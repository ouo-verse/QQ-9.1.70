package org.light.lightAssetKit;

import android.util.Log;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.light.Controller;
import org.light.LightAsset;
import org.light.callback.ComponentUpdateCallback;
import org.light.callback.WillReadSampleCallback;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.components.Camera;
import org.light.lightAssetKit.components.Component;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightAssetDataContext extends BaseContext implements ComponentUpdateCallback, WillReadSampleCallback {
    private static final String TAG = "LightAssetDataContext";
    protected Controller controller;
    protected Entity rootEntity;
    protected LightAssetDataType type;
    protected long nativeHandle = 0;
    protected final Map<Integer, ComponentBase> componentUpdateListenerMap = new HashMap();
    protected JsonObject inputSources = new JsonObject();
    protected JsonObject addInputSources = new JsonObject();
    protected JsonObject properties = new JsonObject();
    protected LazyChangeContextWrapper lazyChangeContextWrapper = new LazyChangeContextWrapper(this);

    private void doAddInputSource() {
        synchronized (this) {
            JsonObject jsonObject = this.addInputSources;
            if (this.controller != null && !jsonObject.entrySet().isEmpty()) {
                this.addInputSources = new JsonObject();
                this.controller.updateResource(jsonObject.toString());
            }
        }
    }

    public static LightAssetDataContext make(LightAsset lightAsset) {
        return make(lightAsset, LightAssetDataType.Json);
    }

    private native Boolean nativeAddLightAsset(LightAsset lightAsset, int i3);

    private native void nativeCompareAndUpdate(String str);

    public static native boolean nativeComponentSupportDynamicallyUpdate(String str);

    private native String nativeExportEntityTreeJsonString();

    private native String nativeExportInputSourcesJsonString();

    private native LightAsset nativeExportLightAsset();

    private native String nativeExportPropertiesJsonString();

    private native void nativeFinalize();

    private static native LightAssetDataContext nativeMake(LightAsset lightAsset, int i3);

    private native void nativeReplaceEntityTreeJsonString(String str);

    private native void nativeReplaceInputSourcesJsonString(String str);

    private native void nativeReplacePropertiesJsonString(String str);

    private synchronized void setInputSources(JsonObject jsonObject) {
        this.inputSources = jsonObject;
    }

    private synchronized void setProperties(JsonObject jsonObject) {
        this.properties = jsonObject;
    }

    private void setRootEntity(Entity entity) {
        LazyChangeContextWrapper lazyChangeContextWrapper = this.lazyChangeContextWrapper;
        if (lazyChangeContextWrapper == null) {
            entity.bindContext(this);
        } else {
            entity.bindContext(lazyChangeContextWrapper);
        }
        this.rootEntity = entity;
    }

    public synchronized Boolean addLightAsset(LightAsset lightAsset) {
        return addLightAsset(lightAsset, LightAssetDataMergeType.Back);
    }

    @Override // org.light.callback.WillReadSampleCallback
    public void beforeReadSample() {
        LazyChangeContextWrapper lazyChangeContextWrapper = this.lazyChangeContextWrapper;
        if (lazyChangeContextWrapper != null) {
            lazyChangeContextWrapper.emit();
        }
    }

    public void bindController(Controller controller) {
        Set<Integer> keySet;
        this.controller = controller;
        if (controller == null) {
            return;
        }
        controller.setWillReadSampleCallback(this);
        controller.setComponentUpdateCallback(this);
        synchronized (this) {
            keySet = this.componentUpdateListenerMap.keySet();
        }
        Iterator<Integer> it = keySet.iterator();
        while (it.hasNext()) {
            controller.addComponentUpdateMonitor(it.next().intValue());
        }
        doAddInputSource();
    }

    public synchronized void callNativeReplaceEntityTreeJsonString(String str) {
        nativeReplaceEntityTreeJsonString(str);
    }

    public synchronized void callNativeReplaceInputSourcesJsonString(String str) {
        nativeReplaceInputSourcesJsonString(str);
    }

    public synchronized void callNativeReplacePropertiesJsonString(String str) {
        nativeReplacePropertiesJsonString(str);
    }

    public synchronized void compareAndUpdate(String str) {
        Entity makeFromJson;
        nativeCompareAndUpdate(str);
        String exportEntityTreeJsonString = exportEntityTreeJsonString();
        if (exportEntityTreeJsonString != null && !exportEntityTreeJsonString.isEmpty() && (makeFromJson = Entity.makeFromJson(exportEntityTreeJsonString)) != null) {
            setRootEntity(makeFromJson);
        }
        String exportInputSourcesJsonString = exportInputSourcesJsonString();
        if (exportInputSourcesJsonString != null && !exportInputSourcesJsonString.isEmpty()) {
            setInputSources((JsonObject) new JsonParser().parse(exportInputSourcesJsonString));
        }
        Log.e(TAG, "merge after " + exportInputSourcesJsonString);
    }

    public boolean componentSupportDynamicallyUpdate(Class<Component> cls) {
        return nativeComponentSupportDynamicallyUpdate(cls.getSimpleName());
    }

    public synchronized LightAsset doExportLightAsset() {
        return nativeExportLightAsset();
    }

    public synchronized String exportEntityTreeJsonString() {
        return nativeExportEntityTreeJsonString();
    }

    public synchronized String exportInputSourcesJsonString() {
        return nativeExportInputSourcesJsonString();
    }

    public synchronized LightAsset exportLightAsset() {
        if (this.type == LightAssetDataType.EntityTree) {
            LazyChangeContextWrapper lazyChangeContextWrapper = this.lazyChangeContextWrapper;
            if (lazyChangeContextWrapper != null) {
                lazyChangeContextWrapper.clear();
            }
            Entity entity = this.rootEntity;
            if (entity != null) {
                callNativeReplaceEntityTreeJsonString(entity.toJson());
            }
            this.addInputSources = new JsonObject();
            JsonObject jsonObject = this.inputSources;
            if (jsonObject != null) {
                callNativeReplaceInputSourcesJsonString(jsonObject.toString());
            }
            JsonObject jsonObject2 = this.properties;
            if (jsonObject2 != null) {
                callNativeReplacePropertiesJsonString(jsonObject2.toString());
            }
        }
        return doExportLightAsset();
    }

    public synchronized String exportPropertiesJsonString() {
        return nativeExportPropertiesJsonString();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.nativeHandle != 0) {
            nativeFinalize();
        }
    }

    public Entity getFirstCameraEntity() {
        List<Entity> entitiesWithComponent;
        Entity entity = this.rootEntity;
        if (entity == null || (entitiesWithComponent = entity.getEntitiesWithComponent(Camera.class)) == null || entitiesWithComponent.isEmpty()) {
            return null;
        }
        return entitiesWithComponent.get(0);
    }

    public synchronized JsonObject getInputSources() {
        return this.inputSources;
    }

    public synchronized JsonObject getProperties() {
        return this.properties;
    }

    public Entity getRootEntity() {
        return this.rootEntity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onAddComponent(int i3, JsonObject jsonObject) {
        Controller controller = this.controller;
        if (controller == null) {
            return;
        }
        controller.addComponent(i3, jsonObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onAddEntity(int i3, int i16, Entity entity) {
        Controller controller = this.controller;
        if (controller == null) {
            return;
        }
        controller.addEntity(i3, i16, entity.toJson());
    }

    @Override // org.light.callback.ComponentUpdateCallback
    public void onComponentUpdated(String str) {
        for (ComponentBase componentBase : (List) Entity.gson().fromJson(str, new TypeToken<List<ComponentBase>>() { // from class: org.light.lightAssetKit.LightAssetDataContext.1
        }.getType())) {
            if (componentBase instanceof Component) {
                Component component = (Component) componentBase;
                synchronized (this) {
                    if (this.componentUpdateListenerMap.containsKey(Integer.valueOf(component.getComponentID()))) {
                        ComponentBase.ComponentUpdateListener componentUpdateListener = this.componentUpdateListenerMap.get(Integer.valueOf(component.getComponentID())).__componentUpdateListener;
                        if (componentUpdateListener != null) {
                            componentUpdateListener.onComponentUpdate(component);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onRegisterComponentUpdateMonitor(Component component) {
        if (component == null) {
            return;
        }
        synchronized (this) {
            this.componentUpdateListenerMap.put(Integer.valueOf(component.getComponentID()), component);
        }
        Controller controller = this.controller;
        if (controller != null) {
            controller.addComponentUpdateMonitor(component.getComponentID());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onRemoveComponent(int i3, String str) {
        Controller controller = this.controller;
        if (controller == null) {
            return;
        }
        controller.removeComponent(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onRemoveEntity(int i3) {
        Controller controller = this.controller;
        if (controller == null) {
            return;
        }
        controller.removeEntity(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onUnregisterComponentUpdateMonitor(Component component) {
        synchronized (this) {
            if (component != null) {
                if (this.componentUpdateListenerMap.containsKey(Integer.valueOf(component.getComponentID()))) {
                    this.componentUpdateListenerMap.remove(Integer.valueOf(component.getComponentID()));
                    Controller controller = this.controller;
                    if (controller != null) {
                        controller.removeComponentUpdateMonitor(component.getComponentID());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.light.lightAssetKit.BaseContext
    public void onUpdateComponent(int i3, String str, JsonObject jsonObject) {
        Controller controller = this.controller;
        if (controller == null) {
            return;
        }
        controller.updateComponent(i3, jsonObject.toString());
    }

    public synchronized void release() {
        this.controller = null;
        this.lazyChangeContextWrapper = null;
        this.componentUpdateListenerMap.clear();
        this.inputSources = null;
        this.addInputSources = null;
        this.properties = null;
        this.rootEntity.bindContext(null);
        this.rootEntity = null;
        nativeFinalize();
    }

    public void updateInputSource(String str, JsonElement jsonElement) {
        synchronized (this) {
            if (str != null) {
                if (!str.isEmpty()) {
                    if (jsonElement == null) {
                        this.addInputSources.remove(str);
                        this.inputSources.remove(str);
                    } else {
                        if (this.inputSources.has(str)) {
                            this.inputSources.add(str, jsonElement);
                            return;
                        }
                        this.addInputSources.add(str, jsonElement);
                        this.inputSources.add(str, jsonElement);
                        doAddInputSource();
                    }
                }
            }
        }
    }

    public synchronized void updateProperty(String str, JsonElement jsonElement) {
        JsonObject jsonObject;
        if (str != null) {
            if (!str.isEmpty() && (jsonObject = this.properties) != null) {
                if (jsonElement == null) {
                    jsonObject.remove(str);
                } else {
                    jsonObject.add(str, jsonElement);
                }
            }
        }
    }

    public static LightAssetDataContext make(LightAsset lightAsset, LightAssetDataType lightAssetDataType) {
        LightAssetDataContext nativeMake = nativeMake(lightAsset, lightAssetDataType.ordinal());
        if (nativeMake != null) {
            if (lightAssetDataType == LightAssetDataType.EntityTree) {
                String exportEntityTreeJsonString = nativeMake.exportEntityTreeJsonString();
                if (exportEntityTreeJsonString != null && !exportEntityTreeJsonString.isEmpty()) {
                    Entity makeFromJson = Entity.makeFromJson(exportEntityTreeJsonString);
                    if (makeFromJson == null) {
                        return null;
                    }
                    nativeMake.setRootEntity(makeFromJson);
                }
                String exportInputSourcesJsonString = nativeMake.exportInputSourcesJsonString();
                if (exportInputSourcesJsonString != null && !exportInputSourcesJsonString.isEmpty()) {
                    nativeMake.setInputSources((JsonObject) new JsonParser().parse(exportInputSourcesJsonString));
                }
                String exportPropertiesJsonString = nativeMake.exportPropertiesJsonString();
                if (exportPropertiesJsonString != null && !exportPropertiesJsonString.isEmpty()) {
                    nativeMake.setProperties((JsonObject) new JsonParser().parse(exportPropertiesJsonString));
                }
            }
            nativeMake.type = lightAssetDataType;
        }
        return nativeMake;
    }

    public synchronized Boolean addLightAsset(LightAsset lightAsset, LightAssetDataMergeType lightAssetDataMergeType) {
        return nativeAddLightAsset(lightAsset, lightAssetDataMergeType.ordinal());
    }
}
