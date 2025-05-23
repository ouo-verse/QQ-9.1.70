package org.light.lightAssetKit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.light.lightAssetKit.components.BasicTransform;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.EntityIdentifier;
import org.light.lightAssetKit.components.ScreenTransform;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Entity {
    private static final int COMPONENT_ID_FACTOR = 1000;
    private static final int INVALID_ID = 0;
    private static Gson __gson;
    private List<Entity> children;
    private transient Map<String, Component> componentMap;
    private List<Component> components;
    private transient BaseContext context;

    /* renamed from: id, reason: collision with root package name */
    private int f423805id;
    private transient Entity parent;
    private transient Type type;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.light.lightAssetKit.Entity$10, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$org$light$lightAssetKit$Entity$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$org$light$lightAssetKit$Entity$Type = iArr;
            try {
                iArr[Type.ENTITY_TYPE_2D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$light$lightAssetKit$Entity$Type[Type.ENTITY_TYPE_3D.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum Type {
        ENTITY_TYPE_2D,
        ENTITY_TYPE_3D
    }

    public Entity() {
        this(Type.ENTITY_TYPE_2D);
    }

    private void assignNewIdForChild(Entity entity) {
        final HashSet hashSet = new HashSet();
        final ArrayList<Entity> arrayList = new ArrayList();
        synchronized (this) {
            getRoot().forEach(new Consumer<Entity>() { // from class: org.light.lightAssetKit.Entity.5
                @Override // org.light.lightAssetKit.Consumer
                public void accept(Entity entity2) {
                    hashSet.add(Integer.valueOf(entity2.getId()));
                }
            });
            entity.forEach(new Consumer<Entity>() { // from class: org.light.lightAssetKit.Entity.6
                @Override // org.light.lightAssetKit.Consumer
                public void accept(Entity entity2) {
                    arrayList.add(entity2);
                }
            });
        }
        int i3 = 0;
        for (Entity entity2 : arrayList) {
            do {
                i3++;
            } while (hashSet.contains(Integer.valueOf(i3)));
            entity2.setId(i3);
        }
    }

    private synchronized int genNewComponentID() {
        if (this.f423805id == 0) {
            return 0;
        }
        HashSet hashSet = new HashSet();
        Iterator<Component> it = this.components.iterator();
        while (it.hasNext()) {
            hashSet.add(Integer.valueOf(it.next().getComponentID()));
        }
        int i3 = this.f423805id * 1000;
        do {
            i3++;
        } while (hashSet.contains(Integer.valueOf(i3)));
        return i3;
    }

    private synchronized BaseContext getContext() {
        return getRoot().context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Gson gson() {
        if (__gson == null) {
            __gson = new GsonBuilder().registerTypeHierarchyAdapter(ComponentBase.class, new JsonSerializer<ComponentBase>() { // from class: org.light.lightAssetKit.Entity.2
                @Override // com.google.gson.JsonSerializer
                public JsonElement serialize(ComponentBase componentBase, java.lang.reflect.Type type, JsonSerializationContext jsonSerializationContext) {
                    return componentBase.toJsonObject();
                }
            }).registerTypeHierarchyAdapter(ComponentBase.class, new JsonDeserializer<ComponentBase>() { // from class: org.light.lightAssetKit.Entity.1
                @Override // com.google.gson.JsonDeserializer
                public ComponentBase deserialize(JsonElement jsonElement, java.lang.reflect.Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    if (jsonElement instanceof JsonObject) {
                        return ComponentBase.makeFromJson((JsonObject) jsonElement);
                    }
                    throw new JsonParseException("Cannot parse json data: " + jsonElement.toString());
                }
            }).create();
        }
        return __gson;
    }

    private void initAfterSerialize() {
        forEach(new Consumer<Entity>() { // from class: org.light.lightAssetKit.Entity.3
            @Override // org.light.lightAssetKit.Consumer
            public void accept(Entity entity) {
                Collection<Component> components;
                synchronized (entity) {
                    Iterator it = entity.children.iterator();
                    while (it.hasNext()) {
                        ((Entity) it.next()).parent = entity;
                    }
                    entity.componentMap.clear();
                    components = entity.getComponents();
                }
                for (Component component : components) {
                    synchronized (entity) {
                        entity.componentMap.put(component.type(), component);
                    }
                    component.setPropertyChangeListener(entity);
                    component.setRegisterComponentListener(entity);
                }
                if (entity.hasComponent(ScreenTransform.class)) {
                    entity.type = Type.ENTITY_TYPE_2D;
                } else if (entity.hasComponent(BasicTransform.class)) {
                    entity.type = Type.ENTITY_TYPE_3D;
                }
            }
        });
    }

    private void initEntity() {
        EntityIdentifier entityIdentifier = new EntityIdentifier();
        entityIdentifier.setId(this.f423805id);
        addComponent(entityIdentifier);
        int i3 = AnonymousClass10.$SwitchMap$org$light$lightAssetKit$Entity$Type[this.type.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                addComponent(new BasicTransform());
                return;
            }
            return;
        }
        addComponent(new ScreenTransform());
    }

    private synchronized boolean isRootEntity() {
        boolean z16;
        if (this.context != null) {
            if (this.parent == null) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    public static Entity makeFromJson(JsonObject jsonObject) {
        Entity entity;
        Exception e16;
        try {
            entity = (Entity) gson().fromJson((JsonElement) jsonObject, Entity.class);
            try {
                entity.initAfterSerialize();
            } catch (Exception e17) {
                e16 = e17;
                LightLogUtil.e("LIGHT_SDK_LOG", "Entity.makeFromJson exception, jsonObject = " + jsonObject.toString(), e16);
                return entity;
            }
        } catch (Exception e18) {
            entity = null;
            e16 = e18;
        }
        return entity;
    }

    private void onAddComponent(Component component) throws LightAssetKitInvalidOperation {
        if (component.__propertyChangeListener == null) {
            component.setEntityId(this.f423805id);
            component.setComponentID(genNewComponentID());
            component.setPropertyChangeListener(this);
            BaseContext context = getContext();
            if (context != null) {
                context.onAddComponent(this.f423805id, component.toJsonObject());
            }
            tryRegisterComponentChange(component);
            component.setRegisterComponentListener(this);
            return;
        }
        throw new LightAssetKitInvalidOperation("Target component has already been another entity's component");
    }

    private void onAddEntity(int i3, Entity entity) {
        if (getId() != 0) {
            assignNewIdForChild(entity);
        }
        BaseContext context = getContext();
        if (context != null) {
            context.onAddEntity(getId(), i3, entity);
        }
        entity.parent = this;
        entity.forEach(new Consumer<Entity>() { // from class: org.light.lightAssetKit.Entity.7
            @Override // org.light.lightAssetKit.Consumer
            public void accept(Entity entity2) {
                Iterator<Component> it = entity2.getComponents().iterator();
                while (it.hasNext()) {
                    Entity.this.tryRegisterComponentChange(it.next());
                }
            }
        });
    }

    private void onRemoveComponent(Component component) {
        component.setPropertyChangeListener(null);
        BaseContext context = getContext();
        if (context != null) {
            context.onRemoveComponent(this.f423805id, component.type());
        }
        unregisterComponentChange(component);
        component.setRegisterComponentListener(null);
    }

    private void onRemoveEntity(Entity entity) {
        BaseContext context = getContext();
        if (context != null) {
            entity.removeAllComponentChangeListenerRecursively();
            context.onRemoveEntity(entity.f423805id);
        }
        entity.parent = null;
        entity.resetAllIds();
    }

    private void registerComponentChange(Component component) {
        BaseContext context = getContext();
        if (context != null) {
            context.onRegisterComponentUpdateMonitor(component);
        }
    }

    private void removeAllComponentChangeListenerRecursively() {
        forEach(new Consumer<Entity>() { // from class: org.light.lightAssetKit.Entity.8
            @Override // org.light.lightAssetKit.Consumer
            public void accept(Entity entity) {
                Iterator<Component> it = entity.getComponents().iterator();
                while (it.hasNext()) {
                    Entity.this.unregisterComponentChange(it.next());
                }
            }
        });
    }

    private void resetAllIds() {
        forEach(new Consumer<Entity>() { // from class: org.light.lightAssetKit.Entity.9
            @Override // org.light.lightAssetKit.Consumer
            public void accept(Entity entity) {
                entity.setId(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryRegisterComponentChange(Component component) {
        if (component.__componentUpdateListener != null) {
            registerComponentChange(component);
        } else {
            unregisterComponentChange(component);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterComponentChange(Component component) {
        BaseContext context = getContext();
        if (context != null) {
            context.onUnregisterComponentUpdateMonitor(component);
        }
    }

    public boolean addChild(Entity entity) throws LightAssetKitInvalidOperation {
        return addChild(-1, entity);
    }

    public boolean addComponent(Component component) {
        if (component == null) {
            return false;
        }
        synchronized (this) {
            if (this.componentMap.containsKey(component.type())) {
                return false;
            }
            this.componentMap.put(component.type(), component);
            this.components.add(component);
            onAddComponent(component);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void bindContext(BaseContext baseContext) {
        this.context = baseContext;
    }

    public synchronized boolean contains(Entity entity) {
        while (entity != null) {
            if (entity == this) {
                return true;
            }
            entity = entity.parent;
        }
        return false;
    }

    public Entity deepCopy() {
        Entity entity = new Entity();
        entity.type = this.type;
        entity.f423805id = this.f423805id;
        ArrayList arrayList = new ArrayList();
        Iterator<Entity> it = getChildren().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().deepCopy());
        }
        entity.children = arrayList;
        ArrayList arrayList2 = new ArrayList();
        Iterator<Component> it5 = getComponents().iterator();
        while (it5.hasNext()) {
            try {
                arrayList2.add((Component) LightAssetUtils.objDeepCopy(it5.next()));
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (InstantiationException e17) {
                e17.printStackTrace();
            }
        }
        entity.components = arrayList2;
        entity.initAfterSerialize();
        return entity;
    }

    public void detach() throws LightAssetKitInvalidOperation {
        if (!isRootEntity()) {
            Entity entity = this.parent;
            if (entity != null) {
                entity.removeChild(this);
                return;
            }
            return;
        }
        throw new LightAssetKitInvalidOperation("Cannot detach root entity.");
    }

    public void forEach(Consumer<Entity> consumer) {
        consumer.accept(this);
        Iterator<Entity> it = getChildren().iterator();
        while (it.hasNext()) {
            it.next().forEach(consumer);
        }
    }

    public synchronized Entity getChildAtIndex(int i3) {
        if (i3 < this.children.size() && i3 >= 0) {
            return this.children.get(i3);
        }
        return null;
    }

    public synchronized List<Entity> getChildren() {
        synchronized (this) {
        }
        return Collections.unmodifiableList(new ArrayList(this.children));
        return Collections.unmodifiableList(new ArrayList(this.children));
    }

    public synchronized Component getComponent(String str) {
        if (!this.componentMap.containsKey(str)) {
            return null;
        }
        return this.componentMap.get(str);
    }

    public Collection<Component> getComponents() {
        return Collections.unmodifiableCollection(new ArrayList(this.components));
    }

    public <T extends Component> List<Entity> getEntitiesWithComponent(final Class<T> cls) {
        final ArrayList arrayList = new ArrayList();
        forEach(new Consumer<Entity>() { // from class: org.light.lightAssetKit.Entity.4
            @Override // org.light.lightAssetKit.Consumer
            public void accept(Entity entity) {
                if (entity.getComponent(cls) != null) {
                    arrayList.add(entity);
                }
            }
        });
        return arrayList;
    }

    public int getId() {
        return this.f423805id;
    }

    public synchronized int getIndexForChild(Entity entity) {
        return this.children.indexOf(entity);
    }

    public synchronized Entity getParent() {
        return this.parent;
    }

    public synchronized int getParentId() {
        int i3;
        Entity entity = this.parent;
        if (entity == null) {
            i3 = -1;
        } else {
            i3 = entity.f423805id;
        }
        return i3;
    }

    public synchronized Entity getRoot() {
        Entity entity;
        entity = this;
        while (true) {
            Entity entity2 = entity.parent;
            if (entity2 != null) {
                entity = entity2;
            }
        }
        return entity;
    }

    public Type getType() {
        return this.type;
    }

    public synchronized boolean hasComponent(String str) {
        return this.componentMap.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPropertyChange(ComponentBase componentBase, String str, JsonElement jsonElement) {
        BaseContext context = getContext();
        if (context != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", componentBase.type());
            jsonObject.add(str, jsonElement);
            context.onUpdateComponent(this.f423805id, componentBase.type(), jsonObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRegisterComponentChange(ComponentBase componentBase) {
        if (componentBase instanceof Component) {
            tryRegisterComponentChange((Component) componentBase);
        }
    }

    public void removeAllChildren() {
        List<Entity> children;
        synchronized (this) {
            children = getChildren();
            this.children.clear();
        }
        Iterator<Entity> it = children.iterator();
        while (it.hasNext()) {
            onRemoveEntity(it.next());
        }
    }

    public void removeAllChildrenRecursively() {
        Iterator<Entity> it = getChildren().iterator();
        while (it.hasNext()) {
            it.next().removeAllChildrenRecursively();
        }
        removeAllChildren();
    }

    public boolean removeChild(Entity entity) {
        int indexOf;
        synchronized (this) {
            indexOf = this.children.indexOf(entity);
        }
        return removeChildAtIndex(indexOf);
    }

    public boolean removeChildAtIndex(int i3) {
        synchronized (this) {
            if (i3 < this.children.size() && i3 >= 0) {
                onRemoveEntity(this.children.remove(i3));
                return true;
            }
            return false;
        }
    }

    public boolean removeComponent(Component component) {
        synchronized (this) {
            if (component != null) {
                if (this.componentMap.containsKey(component.type())) {
                    this.componentMap.remove(component.type());
                    this.components.remove(component);
                    onRemoveComponent(component);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean removeTargetEntityRecursively(Entity entity) {
        if (removeChild(entity)) {
            return true;
        }
        Iterator<Entity> it = getChildren().iterator();
        while (it.hasNext()) {
            if (it.next().removeTargetEntityRecursively(entity)) {
                return true;
            }
        }
        return false;
    }

    public void reset() {
        Collection<Component> components;
        synchronized (this) {
            components = getComponents();
            this.componentMap.clear();
            this.components.clear();
        }
        Iterator<Component> it = components.iterator();
        while (it.hasNext()) {
            onRemoveComponent(it.next());
        }
        initEntity();
    }

    protected void setId(int i3) {
        int i16;
        this.f423805id = i3;
        ((EntityIdentifier) getComponent(EntityIdentifier.class)).setId(i3);
        int i17 = (i3 * 1000) + 1;
        for (Component component : getComponents()) {
            component.setEntityId(i3);
            if (i3 == 0) {
                i16 = i17;
                i17 = 0;
            } else {
                i16 = i17 + 1;
            }
            component.setComponentID(i17);
            i17 = i16;
        }
    }

    public boolean supportDynamicUpdate() {
        Iterator<Entity> it = getChildren().iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            z16 &= it.next().supportDynamicUpdate();
        }
        Iterator<Component> it5 = getComponents().iterator();
        while (it5.hasNext()) {
            z16 &= LightAssetDataContext.nativeComponentSupportDynamicallyUpdate(it5.next().getClass().getSimpleName());
        }
        return z16;
    }

    public synchronized String toJson() {
        return toJsonObject().toString();
    }

    public synchronized JsonObject toJsonObject() {
        return (JsonObject) gson().toJsonTree(this);
    }

    public Entity(Type type) {
        this.f423805id = 0;
        this.children = new ArrayList();
        this.components = new ArrayList();
        this.componentMap = new HashMap();
        this.type = type;
        initEntity();
    }

    public boolean addChild(int i3, Entity entity) throws LightAssetKitInvalidOperation {
        synchronized (this) {
            if (entity != null) {
                if (!this.children.contains(entity)) {
                    if (!entity.isRootEntity()) {
                        if (entity.parent == null) {
                            if (i3 > this.children.size()) {
                                return false;
                            }
                            if (i3 < 0) {
                                i3 = this.children.size();
                            }
                            this.children.add(i3, entity);
                            onAddEntity(i3, entity);
                            return true;
                        }
                        throw new LightAssetKitInvalidOperation("Target entity has already been another entity's child");
                    }
                    throw new LightAssetKitInvalidOperation("Cannot add root entity to another entity");
                }
            }
            return false;
        }
    }

    public synchronized <T extends Component> boolean hasComponent(Class<T> cls) {
        return hasComponent(cls.getSimpleName());
    }

    public static Entity makeFromJson(String str) {
        Entity entity;
        Exception e16;
        try {
            entity = (Entity) gson().fromJson(str, Entity.class);
            try {
                entity.initAfterSerialize();
            } catch (Exception e17) {
                e16 = e17;
                LightLogUtil.e("LIGHT_SDK_LOG", "Entity.makeFromJson exception, json = " + str, e16);
                return entity;
            }
        } catch (Exception e18) {
            entity = null;
            e16 = e18;
        }
        return entity;
    }

    public synchronized <T extends Component> T getComponent(Class<T> cls) {
        T t16 = (T) getComponent(cls.getSimpleName());
        if (t16 != null) {
            if (cls.isInstance(t16)) {
                return t16;
            }
        }
        return null;
    }

    public boolean removeComponent(String str) {
        synchronized (this) {
            if (!this.componentMap.containsKey(str)) {
                return false;
            }
            Component component = this.componentMap.get(str);
            this.componentMap.remove(str);
            this.components.remove(component);
            if (component != null) {
                onRemoveComponent(component);
            }
            return false;
        }
    }

    public <T extends Component> boolean removeComponent(Class<T> cls) {
        return removeComponent(cls.getSimpleName());
    }
}
