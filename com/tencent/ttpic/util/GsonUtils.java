package com.tencent.ttpic.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class GsonUtils {
    private static final String TAG = "com.tencent.ttpic.util.GsonUtils";
    private static Gson gson = new GsonBuilder().create();

    GsonUtils() {
    }

    public static void confirmValueIsArray(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        if (jsonObject == null || str == null || (jsonElement = jsonObject.get(str)) == null || jsonElement.isJsonArray()) {
            return;
        }
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(jsonElement);
        jsonObject.remove(str);
        jsonObject.add(str, jsonArray);
    }

    public static double getDoubleUnsafe(JsonArray jsonArray, int i3) {
        return jsonArray.get(i3).getAsDouble();
    }

    public static float getFloatSafe(JsonArray jsonArray, int i3) {
        if (i3 >= jsonArray.size()) {
            return 0.0f;
        }
        return jsonArray.get(i3).getAsFloat();
    }

    public static float getFloatUnsafe(JsonArray jsonArray, int i3) {
        return jsonArray.get(i3).getAsFloat();
    }

    public static int getIntUnsafe(JsonArray jsonArray, int i3) {
        return jsonArray.get(i3).getAsInt();
    }

    public static JsonObject getJsonObjectUnsafe(JsonArray jsonArray, int i3) {
        return jsonArray.get(i3).getAsJsonObject();
    }

    public static String getStringUnsafe(JsonArray jsonArray, int i3) {
        return jsonArray.get(i3).getAsString();
    }

    public static JsonObject json2JsonObject(String str) {
        if (str == null) {
            return null;
        }
        try {
            JsonElement parse = new JsonParser().parse(str);
            if (parse instanceof JsonObject) {
                return (JsonObject) parse;
            }
        } catch (JsonSyntaxException e16) {
            LogUtils.e(TAG, e16);
        }
        return null;
    }

    public static <T> T json2Obj(Gson gson2, String str, Type type) {
        try {
            return (T) gson2.fromJson(str, type);
        } catch (Exception e16) {
            LogUtils.e(e16);
            return null;
        }
    }

    public static <T> List<T> json2ObjList(Gson gson2, String str, Class<T> cls) {
        ArrayList arrayList = null;
        try {
            JsonArray asJsonArray = new JsonParser().parse(str).getAsJsonArray();
            ArrayList arrayList2 = new ArrayList();
            try {
                int size = asJsonArray.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList2.add(gson2.fromJson(asJsonArray.get(i3), (Class) cls));
                }
                return arrayList2;
            } catch (Exception e16) {
                e = e16;
                arrayList = arrayList2;
                LogUtils.e(e);
                return arrayList;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static <T> String obj2Json(Gson gson2, T t16) {
        try {
            return gson2.toJson(t16);
        } catch (Exception e16) {
            LogUtils.e(e16);
            return null;
        }
    }

    public static <T> String objList2Json(Gson gson2, List<T> list) {
        try {
            return gson2.toJson(list);
        } catch (Exception e16) {
            LogUtils.e(e16);
            return null;
        }
    }

    public static boolean optBoolean(JsonObject jsonObject, String str) {
        return optBoolean(jsonObject, str, false);
    }

    public static double optDouble(JsonObject jsonObject, String str) {
        return optDouble(jsonObject, str, Double.NaN);
    }

    public static float optFloat(JsonObject jsonObject, String str) {
        return optFloat(jsonObject, str, Float.NaN);
    }

    public static int optInt(JsonObject jsonObject, String str) {
        return optInt(jsonObject, str, 0);
    }

    public static JsonArray optJsonArray(JsonObject jsonObject, String str) {
        try {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement instanceof JsonArray) {
                return (JsonArray) jsonElement;
            }
            return null;
        } catch (Exception e16) {
            LogUtils.e(TAG, e16);
            return null;
        }
    }

    public static JsonObject optJsonObject(JsonObject jsonObject, String str) {
        try {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement instanceof JsonObject) {
                return (JsonObject) jsonElement;
            }
            return null;
        } catch (Exception e16) {
            LogUtils.e(TAG, e16);
            return null;
        }
    }

    public static long optLong(JsonObject jsonObject, String str) {
        return optLong(jsonObject, str, 0L);
    }

    public static String optString(JsonObject jsonObject, String str) {
        return optString(jsonObject, str, "");
    }

    public static int getIntUnsafe(JsonObject jsonObject, String str) {
        return jsonObject.get(str).getAsInt();
    }

    public static String getStringUnsafe(JsonObject jsonObject, String str) {
        return jsonObject.get(str).getAsString();
    }

    public static boolean optBoolean(JsonObject jsonObject, String str, boolean z16) {
        try {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement instanceof JsonPrimitive) {
                return jsonElement.getAsBoolean();
            }
        } catch (Exception e16) {
            LogUtils.e(TAG, e16);
        }
        return z16;
    }

    public static double optDouble(JsonObject jsonObject, String str, double d16) {
        try {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement instanceof JsonPrimitive) {
                return jsonElement.getAsDouble();
            }
        } catch (Exception e16) {
            LogUtils.e(TAG, e16);
        }
        return d16;
    }

    public static float optFloat(JsonObject jsonObject, String str, float f16) {
        try {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement instanceof JsonPrimitive) {
                return jsonElement.getAsFloat();
            }
        } catch (Exception e16) {
            LogUtils.e(TAG, e16);
        }
        return f16;
    }

    public static int optInt(JsonObject jsonObject, String str, int i3) {
        try {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement instanceof JsonPrimitive) {
                return jsonElement.getAsInt();
            }
        } catch (Exception e16) {
            LogUtils.e(TAG, e16);
        }
        return i3;
    }

    public static long optLong(JsonObject jsonObject, String str, long j3) {
        try {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement instanceof JsonPrimitive) {
                return jsonElement.getAsLong();
            }
        } catch (Exception e16) {
            LogUtils.e(TAG, e16);
        }
        return j3;
    }

    public static String optString(JsonObject jsonObject, String str, String str2) {
        try {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement instanceof JsonPrimitive) {
                return jsonElement.getAsString();
            }
        } catch (Exception e16) {
            LogUtils.e(TAG, e16);
        }
        return str2;
    }

    public static <T> T json2Obj(String str, Type type) {
        try {
            return (T) gson.fromJson(str, type);
        } catch (Exception e16) {
            LogUtils.e(e16);
            return null;
        }
    }

    public static <T> String obj2Json(T t16) {
        return obj2Json(gson, t16);
    }

    public static <T> String objList2Json(List<T> list) {
        return objList2Json(gson, list);
    }

    public static <T> String obj2Json(Gson gson2, T t16, Type type) {
        try {
            return gson2.toJson(t16, type);
        } catch (Exception e16) {
            LogUtils.e(e16);
            return null;
        }
    }

    public static <T> T json2Obj(Gson gson2, String str, Class<T> cls) {
        try {
            return (T) gson2.fromJson(str, (Class) cls);
        } catch (Throwable th5) {
            LogUtils.e(TAG, th5);
            return null;
        }
    }

    public static JsonArray optJsonArray(JsonArray jsonArray, int i3) {
        if (i3 < 0) {
            return null;
        }
        try {
            if (i3 >= jsonArray.size()) {
                return null;
            }
            JsonElement jsonElement = jsonArray.get(i3);
            if (jsonElement instanceof JsonArray) {
                return (JsonArray) jsonElement;
            }
            return null;
        } catch (Exception e16) {
            LogUtils.e(TAG, e16);
            return null;
        }
    }

    public static JsonObject optJsonObject(JsonArray jsonArray, int i3) {
        if (i3 < 0) {
            return null;
        }
        try {
            if (i3 >= jsonArray.size()) {
                return null;
            }
            JsonElement jsonElement = jsonArray.get(i3);
            if (jsonElement instanceof JsonObject) {
                return (JsonObject) jsonElement;
            }
            return null;
        } catch (Exception e16) {
            LogUtils.e(TAG, e16);
            return null;
        }
    }

    public static <T> String obj2Json(T t16, Type type) {
        return obj2Json(gson, t16, type);
    }

    public static double optDouble(JsonArray jsonArray, int i3) {
        return optDouble(jsonArray, i3, Double.NaN);
    }

    public static int optInt(JsonArray jsonArray, int i3) {
        return optInt(jsonArray, i3, 0);
    }

    public static String optString(JsonArray jsonArray, int i3) {
        if (i3 < 0) {
            return "";
        }
        try {
            if (i3 >= jsonArray.size()) {
                return "";
            }
            JsonElement jsonElement = jsonArray.get(i3);
            return jsonElement instanceof JsonPrimitive ? jsonElement.getAsString() : "";
        } catch (Exception e16) {
            LogUtils.e(TAG, e16);
            return "";
        }
    }

    public static <T> T json2Obj(String str, Class<T> cls) {
        return (T) json2Obj(gson, str, (Class) cls);
    }

    public static <T> List<T> json2ObjList(String str, Class<T> cls) {
        return json2ObjList(gson, str, cls);
    }

    public static double optDouble(JsonArray jsonArray, int i3, double d16) {
        if (i3 >= 0) {
            try {
                if (i3 < jsonArray.size()) {
                    JsonElement jsonElement = jsonArray.get(i3);
                    if (jsonElement instanceof JsonPrimitive) {
                        return jsonElement.getAsDouble();
                    }
                }
            } catch (Exception e16) {
                LogUtils.e(TAG, e16);
            }
        }
        return d16;
    }

    public static int optInt(JsonArray jsonArray, int i3, int i16) {
        if (i3 >= 0) {
            try {
                if (i3 < jsonArray.size()) {
                    JsonElement jsonElement = jsonArray.get(i3);
                    if (jsonElement instanceof JsonPrimitive) {
                        return jsonElement.getAsInt();
                    }
                }
            } catch (Exception e16) {
                LogUtils.e(TAG, e16);
            }
        }
        return i16;
    }
}
