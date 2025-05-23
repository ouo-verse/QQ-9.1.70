package org.light.lightAssetKit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.DataSourceComponent;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class ComponentBase {
    private static Gson __gson;
    private transient Object __extraInfo = null;
    protected transient Entity __propertyChangeListener = null;
    protected transient ComponentUpdateListener __componentUpdateListener = null;
    protected transient Entity __registerComponentListener = null;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface ComponentUpdateListener {
        void onComponentUpdate(ComponentBase componentBase);
    }

    protected static Gson gson() {
        if (__gson == null) {
            __gson = new GsonBuilder().registerTypeHierarchyAdapter(Float.class, new JsonSerializer<Float>() { // from class: org.light.lightAssetKit.ComponentBase.4
                @Override // com.google.gson.JsonSerializer
                public JsonElement serialize(Float f16, Type type, JsonSerializationContext jsonSerializationContext) {
                    if (Float.isNaN(f16.floatValue()) || Float.isInfinite(f16.floatValue())) {
                        return null;
                    }
                    return new JsonPrimitive((Number) f16);
                }
            }).registerTypeHierarchyAdapter(Double.class, new JsonSerializer<Double>() { // from class: org.light.lightAssetKit.ComponentBase.3
                @Override // com.google.gson.JsonSerializer
                public JsonElement serialize(Double d16, Type type, JsonSerializationContext jsonSerializationContext) {
                    if (Double.isNaN(d16.doubleValue()) || Double.isInfinite(d16.doubleValue())) {
                        return null;
                    }
                    return new JsonPrimitive((Number) d16);
                }
            }).registerTypeHierarchyAdapter(Enum.class, new JsonSerializer<Enum<?>>() { // from class: org.light.lightAssetKit.ComponentBase.2
                @Override // com.google.gson.JsonSerializer
                public JsonElement serialize(Enum<?> r36, Type type, JsonSerializationContext jsonSerializationContext) {
                    if (type instanceof Class) {
                        Class cls = (Class) type;
                        try {
                            try {
                                String str = (String) cls.getField("name").get(r36);
                                if (str != null && !str.isEmpty()) {
                                    return new JsonPrimitive(str);
                                }
                                throw new NoSuchFieldException("");
                            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
                                return new JsonPrimitive((Number) Integer.valueOf(cls.getField("value").getInt(r36)));
                            }
                        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused2) {
                        }
                    }
                    return null;
                }
            }).registerTypeHierarchyAdapter(Enum.class, new JsonDeserializer<Enum<?>>() { // from class: org.light.lightAssetKit.ComponentBase.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.gson.JsonDeserializer
                public Enum<?> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    if (type instanceof Class) {
                        Class cls = (Class) type;
                        if (jsonElement.isJsonPrimitive()) {
                            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                            Enum<?>[] enumArr = (Enum[]) cls.getEnumConstants();
                            try {
                                int i3 = 0;
                                if (asJsonPrimitive.isNumber()) {
                                    Field field = cls.getField("value");
                                    int asInt = asJsonPrimitive.getAsInt();
                                    int length = enumArr.length;
                                    while (i3 < length) {
                                        Enum<?> r36 = enumArr[i3];
                                        if (field.getInt(r36) == asInt) {
                                            return r36;
                                        }
                                        i3++;
                                    }
                                } else if (asJsonPrimitive.isString()) {
                                    String asString = asJsonPrimitive.getAsString();
                                    int length2 = enumArr.length;
                                    while (i3 < length2) {
                                        Enum<?> r16 = enumArr[i3];
                                        if (r16.toString().equalsIgnoreCase(asString)) {
                                            return r16;
                                        }
                                        i3++;
                                    }
                                }
                            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e16) {
                                throw new JsonParseException(e16);
                            }
                        }
                        throw new JsonParseException("Cannot parse json data: " + jsonElement.toString());
                    }
                    throw new JsonParseException("Wrong type! Cannot parse json data: " + jsonElement.toString());
                }
            }).create();
        }
        return __gson;
    }

    public static ComponentBase makeFromJson(JsonObject jsonObject) throws JsonSyntaxException {
        try {
            try {
                try {
                    String asString = jsonObject.get("type").getAsString();
                    Class<?> cls = Class.forName("org.light.lightAssetKit.components." + asString);
                    if (!asString.equals("DataSourceComponent")) {
                        return (ComponentBase) gson().fromJson((JsonElement) jsonObject, (Class) cls.asSubclass(ComponentBase.class));
                    }
                    return (ComponentBase) DataSourceComponent.gson().fromJson((JsonElement) jsonObject, DataSourceComponent.class);
                } catch (ClassNotFoundException e16) {
                    e = e16;
                    throw new JsonSyntaxException(e);
                }
            } catch (ClassNotFoundException unused) {
                return (ComponentBase) gson().fromJson((JsonElement) jsonObject, Component.class.asSubclass(ComponentBase.class));
            }
        } catch (JsonParseException e17) {
            e = e17;
        } catch (ClassCastException e18) {
            e = e18;
        } catch (IllegalStateException e19) {
            e = e19;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doUpdate(ComponentBase componentBase) {
        ComponentUpdateListener componentUpdateListener = this.__componentUpdateListener;
        if (componentUpdateListener != null) {
            componentUpdateListener.onComponentUpdate(this);
        }
    }

    public Object extraInfo() {
        return this.__extraInfo;
    }

    public void putExtraInfo(Object obj) {
        this.__extraInfo = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportPropertyChange(String str, Object obj) {
        Entity entity = this.__propertyChangeListener;
        if (entity != null) {
            entity.onPropertyChange(this, str, gson().toJsonTree(obj));
        }
    }

    public void setComponentUpdateListener(ComponentUpdateListener componentUpdateListener) {
        this.__componentUpdateListener = componentUpdateListener;
        Entity entity = this.__registerComponentListener;
        if (entity != null) {
            entity.onRegisterComponentChange(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPropertyChangeListener(Entity entity) {
        this.__propertyChangeListener = entity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRegisterComponentListener(Entity entity) {
        this.__registerComponentListener = entity;
    }

    public String toJson() {
        return toJsonObject().toString();
    }

    public JsonObject toJsonObject() {
        JsonObject jsonObject = (JsonObject) gson().toJsonTree(this);
        jsonObject.addProperty("type", type());
        if (this.__extraInfo != null) {
            for (Map.Entry<String, JsonElement> entry : ((JsonObject) gson().toJsonTree(this.__extraInfo)).entrySet()) {
                jsonObject.add(entry.getKey(), entry.getValue());
            }
        }
        return jsonObject;
    }

    public String toString() {
        return toJson();
    }

    public abstract String type();

    protected void update(String str) {
        update((ComponentBase) gson().fromJson(str, (Class) getClass()));
    }

    protected void update(ComponentBase componentBase) {
        doUpdate(componentBase);
    }

    public static ComponentBase makeFromJson(String str) throws JsonSyntaxException {
        return makeFromJson((JsonObject) new JsonParser().parse(str));
    }
}
