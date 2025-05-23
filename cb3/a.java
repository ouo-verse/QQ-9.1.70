package cb3;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* renamed from: cb3.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0181a<T> extends TypeToken<HashMap<String, T>> {
        C0181a() {
        }
    }

    public static <T> T a(String str, Class<T> cls, T t16) {
        try {
            return (T) new GsonBuilder().disableHtmlEscaping().create().fromJson(str, (Class) cls);
        } catch (Throwable th5) {
            QLog.e("WxMiniAdGsonUtil", 1, "[fromJson]", th5);
            return t16;
        }
    }

    public static <T> HashMap<String, T> b(JsonElement jsonElement, HashMap<String, T> hashMap) {
        try {
            return (HashMap) new GsonBuilder().disableHtmlEscaping().create().fromJson(jsonElement, new C0181a().getType());
        } catch (Throwable th5) {
            QLog.e("WxMiniAdGsonUtil", 1, "[fromJson]", th5);
            return hashMap;
        }
    }

    public static String c(Object obj, String str) {
        try {
            return new GsonBuilder().disableHtmlEscaping().create().toJson(obj);
        } catch (Throwable th5) {
            QLog.e("WxMiniAdGsonUtil", 1, "[toString]", th5);
            return str;
        }
    }
}
