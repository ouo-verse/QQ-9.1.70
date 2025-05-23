package com.tencent.map.tools.json;

import android.text.TextUtils;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.json.annotation.JsonType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class JsonComposer implements JsonEncoder, JsonParser {
    private static Map<Class, Map<Field, String>> sClassJsonMap = new ConcurrentHashMap();
    private String mFieldNamePrefix;
    private Map<Field, String> mJsonFields;
    private FieldNameStyle mFieldNameStyle = FieldNameStyle.HUMP;
    private boolean mAllowEmpty = true;
    private Map<Field, JsonParser.Deserializer> mFieldDeserializer = new HashMap();
    private Map<Class, JsonParser.Deserializer> mClassDeserializer = new HashMap();

    private synchronized void checkJsonComposerElements() {
        Class<? extends JsonParser.Deserializer> deserializer;
        JsonType jsonType = (JsonType) getClass().getAnnotation(JsonType.class);
        if (jsonType != null) {
            this.mAllowEmpty = jsonType.allowEmpty();
            this.mFieldNameStyle = jsonType.fieldNameStyle();
            this.mFieldNamePrefix = jsonType.fieldNamePrefix();
            Class<? extends JsonParser.Deserializer> deserializer2 = jsonType.deserializer();
            if (deserializer2 != JsonParser.Deserializer.class) {
                this.mClassDeserializer.put(getClass(), (JsonParser.Deserializer) Util.newInstance(deserializer2, new Object[0]));
            }
        }
        this.mJsonFields = sClassJsonMap.get(getClass());
        Collection<Field> arrayList = new ArrayList();
        Map<Field, String> map = this.mJsonFields;
        if (map == null) {
            this.mJsonFields = new ConcurrentHashMap();
            for (Class<?> cls = getClass(); cls != JsonComposer.class; cls = cls.getSuperclass()) {
                arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
            }
            sClassJsonMap.put(getClass(), this.mJsonFields);
        } else {
            arrayList = map.keySet();
        }
        for (Field field : arrayList) {
            if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isTransient(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
                JsonType jsonType2 = (JsonType) field.getType().getAnnotation(JsonType.class);
                if (jsonType2 != null && (deserializer = jsonType2.deserializer()) != JsonParser.Deserializer.class) {
                    this.mFieldDeserializer.put(field, (JsonParser.Deserializer) Util.newInstance(deserializer, new Object[0]));
                }
                Json json = (Json) field.getAnnotation(Json.class);
                if (json != null) {
                    if (!json.ignore()) {
                        if (TextUtils.isEmpty(json.name())) {
                            this.mJsonFields.put(field, translateFieldName(field.getName()));
                        } else {
                            this.mJsonFields.put(field, json.name());
                        }
                    }
                    Class<? extends JsonParser.Deserializer> deserializer3 = json.deserializer();
                    if (deserializer3 != JsonParser.Deserializer.class) {
                        this.mFieldDeserializer.put(field, (JsonParser.Deserializer) Util.newInstance(deserializer3, new Object[0]));
                    }
                } else if (!field.getName().contains("this")) {
                    this.mJsonFields.put(field, translateFieldName(field.getName()));
                }
            }
        }
    }

    private String pickString(String str) {
        while (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("<");
            int lastIndexOf = str.lastIndexOf(">");
            if (indexOf < 0) {
                indexOf = 0;
            }
            if (lastIndexOf < 0) {
                lastIndexOf = str.length();
            }
            if (lastIndexOf > indexOf) {
                str = str.substring(indexOf + 1, lastIndexOf);
                if (str.contains("<") && str.contains(">")) {
                }
            }
            return str;
        }
        return str;
    }

    private String translateFieldName(String str) {
        String str2 = this.mFieldNamePrefix;
        if (str2 != null && str.startsWith(str2)) {
            String substring = str.substring(this.mFieldNamePrefix.length(), this.mFieldNamePrefix.length() + 1);
            str = substring.toLowerCase() + str.substring(this.mFieldNamePrefix.length() + 1);
        }
        if (this.mFieldNameStyle == FieldNameStyle.UNDERLINE) {
            Matcher matcher = Pattern.compile("[A-Z]").matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, "_" + matcher.group(0).toLowerCase());
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getFieldValueByJsonName(String str) throws IllegalAccessException {
        Map<Field, String> map = this.mJsonFields;
        if (map != null) {
            for (Map.Entry<Field, String> entry : map.entrySet()) {
                if (entry.getValue().equals(str)) {
                    return entry.getKey().get(this);
                }
            }
            return null;
        }
        return null;
    }

    protected boolean onEachItemParse(String str, Object obj) {
        return false;
    }

    protected boolean onEachItemToJson(JSONObject jSONObject, String str, Object obj) {
        return false;
    }

    @Override // com.tencent.map.tools.json.JsonParser
    public void parse(JSONObject jSONObject) {
        Class findClass;
        Collection collection;
        checkJsonComposerElements();
        JsonParser.Deserializer deserializer = this.mClassDeserializer.get(getClass());
        if (deserializer != null) {
            try {
                deserializer.deserialize(this, getClass().getName(), jSONObject);
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        for (Map.Entry<Field, String> entry : this.mJsonFields.entrySet()) {
            Field key = entry.getKey();
            key.setAccessible(true);
            Class<?> type = key.getType();
            Object opt = jSONObject.opt(entry.getValue());
            JsonParser.Deserializer deserializer2 = this.mFieldDeserializer.get(key);
            if (deserializer2 != null) {
                try {
                    key.set(this, deserializer2.deserialize(this, entry.getValue(), opt));
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
            if (!onEachItemParse(entry.getValue(), opt)) {
                if (opt instanceof JSONArray) {
                    Type genericType = key.getGenericType();
                    if (genericType instanceof ParameterizedType) {
                        String pickString = pickString(genericType.toString());
                        try {
                            if (!TextUtils.isEmpty(pickString) && (findClass = Util.findClass(pickString, getClass().getClassLoader())) != null) {
                                if (Set.class.isAssignableFrom(key.getType())) {
                                    collection = JsonUtils.parseTo(HashSet.class, (JSONArray) opt, findClass, new Object[0]);
                                } else if (List.class.isAssignableFrom(key.getType())) {
                                    collection = JsonUtils.parseTo(ArrayList.class, (JSONArray) opt, findClass, new Object[0]);
                                } else {
                                    collection = null;
                                }
                                key.set(this, collection);
                            }
                        } catch (IllegalAccessException e18) {
                            e18.printStackTrace();
                        }
                    } else {
                        Class cls = (Class) genericType;
                        if (cls.isArray()) {
                            try {
                                key.set(this, JsonUtils.parseToArray((JSONArray) opt, cls.getComponentType()));
                            } catch (IllegalAccessException e19) {
                                e19.printStackTrace();
                            }
                        }
                    }
                } else if (opt instanceof JSONObject) {
                    try {
                        key.set(this, JsonUtils.parseToModel((JSONObject) opt, key.getType(), new Object[0]));
                    } catch (IllegalAccessException e26) {
                        e26.printStackTrace();
                    }
                } else if (type == String.class) {
                    try {
                        key.set(this, String.valueOf(opt));
                    } catch (IllegalAccessException e27) {
                        e27.printStackTrace();
                    }
                } else {
                    try {
                        if (type == Boolean.TYPE) {
                            if (opt instanceof Boolean) {
                                key.setBoolean(this, ((Boolean) opt).booleanValue());
                            } else if (opt instanceof String) {
                                if (opt.equals("false")) {
                                    key.setBoolean(this, false);
                                } else if (opt.equals("true")) {
                                    key.setBoolean(this, true);
                                }
                            }
                        } else if (type == Byte.TYPE) {
                            if (opt instanceof Byte) {
                                key.setByte(this, ((Byte) opt).byteValue());
                            } else if (opt instanceof Number) {
                                key.setByte(this, ((Number) opt).byteValue());
                            }
                        } else if (type == Character.TYPE) {
                            if (opt instanceof Character) {
                                key.setChar(this, ((Character) opt).charValue());
                            } else if (opt instanceof Integer) {
                                if (Character.isLetter(((Integer) opt).intValue())) {
                                    key.setChar(this, Character.toChars(((Integer) opt).intValue())[0]);
                                } else if (10 > ((Integer) opt).intValue() && ((Integer) opt).intValue() >= 0) {
                                    key.setChar(this, Character.forDigit(((Integer) opt).intValue(), 10));
                                }
                            }
                        } else if (type == Double.TYPE) {
                            if (opt instanceof Number) {
                                key.setDouble(this, ((Number) opt).doubleValue());
                            } else if (opt instanceof String) {
                                key.setDouble(this, Double.parseDouble((String) opt));
                            }
                        } else if (type == Float.TYPE) {
                            if (opt instanceof Number) {
                                key.setFloat(this, ((Number) opt).floatValue());
                            } else if (opt instanceof String) {
                                key.setFloat(this, Float.parseFloat((String) opt));
                            }
                        } else if (type == Integer.TYPE) {
                            if (opt instanceof Number) {
                                key.setInt(this, ((Number) opt).intValue());
                            } else if (opt instanceof String) {
                                key.setInt(this, Integer.parseInt((String) opt));
                            }
                        } else if (type == Long.TYPE) {
                            if (opt instanceof Number) {
                                key.setLong(this, ((Number) opt).longValue());
                            } else if (opt instanceof String) {
                                key.setLong(this, Long.parseLong((String) opt));
                            }
                        } else if (type == Short.TYPE) {
                            if (opt instanceof Number) {
                                key.setShort(this, ((Number) opt).shortValue());
                            } else if (opt instanceof String) {
                                key.setShort(this, Short.parseShort((String) opt));
                            }
                        } else if (opt != null) {
                            key.set(this, opt);
                        }
                    } catch (IllegalAccessException e28) {
                        e28.printStackTrace();
                    } catch (NumberFormatException e29) {
                        e29.printStackTrace();
                    } catch (Exception e36) {
                        e36.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.tencent.map.tools.json.JsonEncoder
    public JSONObject toJson() {
        Object obj;
        checkJsonComposerElements();
        Set<Map.Entry<Field, String>> entrySet = this.mJsonFields.entrySet();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<Field, String> entry : entrySet) {
            Field key = entry.getKey();
            key.setAccessible(true);
            Class<?> type = key.getType();
            JSONArray jSONArray = null;
            try {
                obj = key.get(this);
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                obj = null;
            }
            if (!onEachItemToJson(jSONObject, entry.getValue(), obj)) {
                if (Collection.class.isAssignableFrom(type)) {
                    try {
                        Collection collection = (Collection) key.get(this);
                        JSONArray jSONArray2 = new JSONArray();
                        if (collection != null && !collection.isEmpty()) {
                            for (Object obj2 : collection) {
                                if (obj2 instanceof JsonEncoder) {
                                    jSONArray2.mo162put(JsonUtils.modelToJson(obj2));
                                }
                            }
                        }
                        String value = entry.getValue();
                        if (this.mAllowEmpty || (collection != null && !collection.isEmpty())) {
                            jSONArray = jSONArray2;
                        }
                        jSONObject.put(value, jSONArray);
                    } catch (IllegalAccessException e17) {
                        e17.printStackTrace();
                    } catch (JSONException e18) {
                        e18.printStackTrace();
                    }
                } else {
                    try {
                        Object obj3 = key.get(this);
                        if (obj3 instanceof Double) {
                            jSONObject.put(entry.getValue(), ((Double) obj3).doubleValue());
                        } else if (obj3 instanceof Long) {
                            jSONObject.put(entry.getValue(), ((Long) obj3).longValue());
                        } else if (obj3 instanceof Integer) {
                            jSONObject.put(entry.getValue(), ((Integer) obj3).intValue());
                        } else if (obj3 instanceof Boolean) {
                            jSONObject.put(entry.getValue(), ((Boolean) obj3).booleanValue());
                        } else if (obj3 instanceof JsonEncoder) {
                            jSONObject.put(entry.getValue(), JsonUtils.modelToJson(obj3));
                        } else if (obj3 != null && obj3.getClass().isArray()) {
                            jSONObject.put(entry.getValue(), new JSONArray(obj3));
                        } else {
                            String value2 = entry.getValue();
                            if (obj3 == null && this.mAllowEmpty) {
                                obj3 = new JSONObject();
                            }
                            jSONObject.put(value2, obj3);
                        }
                    } catch (IllegalAccessException e19) {
                        e19.printStackTrace();
                    } catch (JSONException e26) {
                        e26.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }
}
