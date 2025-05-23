package op2;

import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class a {
    public static <T> T a(String str, Class<T> cls, T t16) {
        try {
            return (T) new GsonBuilder().disableHtmlEscaping().create().fromJson(str, (Class) cls);
        } catch (Throwable th5) {
            QLog.e("QQSearchWXAdGsonUtil", 1, "[fromJson]", th5);
            return t16;
        }
    }

    public static JsonObject b(JsonObject jsonObject, JsonObject jsonObject2) {
        String str;
        try {
            str = "sourceJsonObject:" + jsonObject + " targetJsonObject:" + jsonObject2 + " ";
        } catch (Throwable th5) {
            QLog.e("QQSearchWXAdGsonUtil", 1, "[merge] build message error, ", th5);
            str = null;
        }
        try {
            return c(jsonObject, jsonObject2);
        } catch (Throwable th6) {
            QLog.e("QQSearchWXAdGsonUtil", 1, "[merge] " + str, th6);
            return jsonObject;
        }
    }

    public static JsonObject c(JsonObject jsonObject, JsonObject jsonObject2) {
        JsonObject jsonObject3;
        if (jsonObject == null) {
            return jsonObject2;
        }
        if (jsonObject2 == null) {
            return jsonObject;
        }
        for (String str : jsonObject.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                JsonElement jsonElement = jsonObject.get(str);
                if (jsonElement != null && jsonElement.isJsonObject()) {
                    if (jsonObject2.has(str) && jsonObject2.get(str).isJsonObject()) {
                        jsonObject3 = jsonObject2.getAsJsonObject(str);
                    } else {
                        jsonObject3 = new JsonObject();
                    }
                    jsonObject2.add(str, c(jsonElement.getAsJsonObject(), jsonObject3));
                } else {
                    jsonObject2.add(str, jsonElement);
                }
            }
        }
        return jsonObject2;
    }

    public static JsonObject d(Object obj, JsonObject jsonObject) {
        try {
            return new GsonBuilder().disableHtmlEscaping().create().toJsonTree(obj).getAsJsonObject();
        } catch (Throwable th5) {
            QLog.e("QQSearchWXAdGsonUtil", 1, "[toJsonObject]", th5);
            return jsonObject;
        }
    }

    public static String e(Object obj, String str) {
        try {
            return new GsonBuilder().disableHtmlEscaping().create().toJson(obj);
        } catch (Throwable th5) {
            QLog.e("QQSearchWXAdGsonUtil", 1, "[toString]", th5);
            return str;
        }
    }
}
