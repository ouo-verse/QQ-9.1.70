package org.light.lightAssetKit;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.light.lightAssetKit.components.Component;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class LazyChangeContextWrapper extends BaseContext {
    private final BaseContext context;
    private Map<Integer, ComponentChangeCommand> componentCommand = new HashMap();
    private final Object lock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ComponentChangeCommand {
        Map<String, JsonObject> addComponentCommand = new HashMap();
        Map<String, JsonObject> updateComponentCommand = new HashMap();
        Set<String> removeComponentCommand = new HashSet();

        ComponentChangeCommand() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LazyChangeContextWrapper(BaseContext baseContext) {
        this.context = baseContext;
    }

    private ComponentChangeCommand getComponentCommand(int i3) {
        if (this.componentCommand.containsKey(Integer.valueOf(i3))) {
            return this.componentCommand.get(Integer.valueOf(i3));
        }
        ComponentChangeCommand componentChangeCommand = new ComponentChangeCommand();
        this.componentCommand.put(Integer.valueOf(i3), componentChangeCommand);
        return componentChangeCommand;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        synchronized (this.lock) {
            this.componentCommand.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emit() {
        Map<Integer, ComponentChangeCommand> map;
        synchronized (this.lock) {
            map = this.componentCommand;
            this.componentCommand = new HashMap();
        }
        for (Map.Entry<Integer, ComponentChangeCommand> entry : map.entrySet()) {
            Iterator<JsonObject> it = entry.getValue().addComponentCommand.values().iterator();
            while (it.hasNext()) {
                this.context.onAddComponent(entry.getKey().intValue(), it.next());
            }
            for (JsonObject jsonObject : entry.getValue().updateComponentCommand.values()) {
                this.context.onUpdateComponent(entry.getKey().intValue(), jsonObject.get("type").getAsString(), jsonObject);
            }
            Iterator<String> it5 = entry.getValue().removeComponentCommand.iterator();
            while (it5.hasNext()) {
                this.context.onRemoveComponent(entry.getKey().intValue(), it5.next());
            }
        }
        map.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onAddComponent(int i3, JsonObject jsonObject) {
        synchronized (this.lock) {
            ComponentChangeCommand componentCommand = getComponentCommand(i3);
            String asString = jsonObject.get("type").getAsString();
            if (componentCommand.addComponentCommand.containsKey(asString)) {
                componentCommand.addComponentCommand.put(asString, jsonObject);
            } else {
                if (componentCommand.updateComponentCommand.containsKey(asString)) {
                    return;
                }
                if (componentCommand.removeComponentCommand.contains(asString)) {
                    componentCommand.removeComponentCommand.remove(asString);
                    componentCommand.updateComponentCommand.put(asString, jsonObject);
                } else {
                    componentCommand.addComponentCommand.put(asString, jsonObject);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onAddEntity(int i3, int i16, Entity entity) {
        this.context.onAddEntity(i3, i16, entity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onRegisterComponentUpdateMonitor(Component component) {
        this.context.onRegisterComponentUpdateMonitor(component);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onRemoveComponent(int i3, String str) {
        synchronized (this.lock) {
            ComponentChangeCommand componentCommand = getComponentCommand(i3);
            if (componentCommand.addComponentCommand.containsKey(str)) {
                componentCommand.addComponentCommand.remove(str);
            } else if (componentCommand.updateComponentCommand.containsKey(str)) {
                componentCommand.updateComponentCommand.remove(str);
            } else if (componentCommand.removeComponentCommand.contains(str)) {
            } else {
                componentCommand.removeComponentCommand.add(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onRemoveEntity(int i3) {
        synchronized (this.lock) {
            this.componentCommand.remove(Integer.valueOf(i3));
        }
        this.context.onRemoveEntity(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onUnregisterComponentUpdateMonitor(Component component) {
        this.context.onUnregisterComponentUpdateMonitor(component);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onUpdateComponent(int i3, String str, JsonObject jsonObject) {
        synchronized (this.lock) {
            ComponentChangeCommand componentCommand = getComponentCommand(i3);
            if (componentCommand.addComponentCommand.containsKey(str)) {
                JsonObject jsonObject2 = componentCommand.addComponentCommand.get(str);
                for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                    jsonObject2.add(entry.getKey(), entry.getValue());
                }
            } else if (componentCommand.updateComponentCommand.containsKey(str)) {
                JsonObject jsonObject3 = componentCommand.updateComponentCommand.get(str);
                for (Map.Entry<String, JsonElement> entry2 : jsonObject.entrySet()) {
                    jsonObject3.add(entry2.getKey(), entry2.getValue());
                }
            } else if (!componentCommand.removeComponentCommand.contains(str)) {
                componentCommand.updateComponentCommand.put(str, jsonObject);
            }
        }
    }
}
