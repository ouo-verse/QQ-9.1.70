package com.tencent.map.tools.json;

import android.text.TextUtils;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.annotation.JsonType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class JsonUtils {
    public static <T> String collectionToJson(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (T t16 : collection) {
            if (t16 instanceof JsonEncoder) {
                jSONArray.mo162put(((JsonEncoder) t16).toJson());
            } else {
                jSONArray.mo162put((Object) null);
            }
        }
        return jSONArray.toString();
    }

    public static <T> JSONObject modelToJson(T t16) {
        if (t16 instanceof JsonEncoder) {
            return ((JsonEncoder) t16).toJson();
        }
        return null;
    }

    public static <T> String modelToJsonString(T t16) {
        JSONObject modelToJson = modelToJson(t16);
        if (modelToJson != null) {
            return modelToJson.toString();
        }
        return null;
    }

    public static <C extends Collection> C parseTo(Class<C> cls, JSONArray jSONArray, Class cls2, Object... objArr) {
        C c16 = (C) Util.newInstance(cls, new Object[0]);
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object opt = jSONArray.opt(i3);
                if (opt instanceof JSONArray) {
                    c16.add(parseTo(cls, (JSONArray) opt, cls2, objArr));
                } else if (opt instanceof JSONObject) {
                    c16.add(parseToModel((JSONObject) opt, cls2, objArr));
                } else if (opt.getClass() == cls2) {
                    c16.add(opt);
                } else if (opt instanceof Integer) {
                    if (cls2 == Double.class) {
                        c16.add(Double.valueOf(((Integer) opt).doubleValue()));
                    } else if (cls2 == Long.class) {
                        c16.add(Long.valueOf(((Integer) opt).longValue()));
                    } else if (cls2 == Float.class) {
                        c16.add(Float.valueOf(((Integer) opt).floatValue()));
                    } else if (cls2 == String.class) {
                        c16.add(opt.toString());
                    }
                } else if (opt instanceof Double) {
                    if (cls2 == Integer.class) {
                        c16.add(Integer.valueOf(((Double) opt).intValue()));
                    } else if (cls2 == Long.class) {
                        c16.add(Long.valueOf(((Double) opt).longValue()));
                    } else if (cls2 == Float.class) {
                        c16.add(Float.valueOf(((Double) opt).floatValue()));
                    } else if (cls2 == String.class) {
                        c16.add(opt.toString());
                    }
                } else if (opt instanceof Long) {
                    if (cls2 == Integer.class) {
                        c16.add(Integer.valueOf(((Long) opt).intValue()));
                    } else if (cls2 == Double.class) {
                        c16.add(Double.valueOf(((Long) opt).doubleValue()));
                    } else if (cls2 == Float.class) {
                        c16.add(Float.valueOf(((Long) opt).floatValue()));
                    } else if (cls2 == String.class) {
                        c16.add(opt.toString());
                    }
                }
            }
        }
        return c16;
    }

    public static Object parseToArray(JSONArray jSONArray, Class cls) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        Object newInstance = Array.newInstance((Class<?>) cls, length);
        for (int i3 = 0; i3 < length; i3++) {
            try {
                Array.set(newInstance, i3, jSONArray.get(i3));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return newInstance;
    }

    public static <T> List<T> parseToList(JSONArray jSONArray, Class<T> cls, Object... objArr) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(parseToModel(jSONArray.optJSONObject(i3), cls, objArr));
            }
        }
        return arrayList;
    }

    public static <T> T parseToModel(JSONObject jSONObject, Class<T> cls, Object... objArr) {
        Class<? extends JsonParser.Deserializer> deserializer;
        JsonType jsonType = (JsonType) cls.getAnnotation(JsonType.class);
        JsonParser jsonParser = null;
        if (jsonType != null && (deserializer = jsonType.deserializer()) != JsonParser.Deserializer.class) {
            try {
                Object deserialize = ((JsonParser.Deserializer) Util.newInstance(deserializer, new Object[0])).deserialize(null, "", jSONObject);
                if (deserialize != null) {
                    if (cls.isAssignableFrom(deserialize.getClass())) {
                        jsonParser = (T) deserialize;
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        if (jsonParser == null) {
            jsonParser = (T) Util.newInstance(cls, objArr);
        }
        if (jsonParser instanceof JsonParser) {
            jsonParser.parse(jSONObject);
        }
        return (T) jsonParser;
    }

    public static <T> T parseToModel(String str, Class<T> cls, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (T) parseToModel(new JSONObject(str), cls, objArr);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
