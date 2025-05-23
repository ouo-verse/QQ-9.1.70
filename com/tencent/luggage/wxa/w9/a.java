package com.tencent.luggage.wxa.w9;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Consumer;
import com.tencent.luggage.wxa.tn.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.w9.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.w9.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6868a {
        public static void b(int i3, int i16, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            com.tencent.luggage.wxa.xm.b.INSTANCE.a(23773, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3, str4, str5, str6, str7, str8, e.f141561c);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.w9.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6869a {
            public static void a(String str, Throwable th5, Map map, String... strArr) {
                a(str, th5 != null ? Log.getStackTraceString(th5).replace('\n', ';').replace("\t", "") : "", map, strArr);
            }

            public static void a(String str, String str2, Map map, String... strArr) {
                String a16 = a.a();
                String str3 = strArr.length >= 1 ? strArr[0] : "";
                String str4 = strArr.length >= 2 ? strArr[1] : "";
                String str5 = strArr.length >= 3 ? strArr[2] : "";
                String str6 = strArr.length >= 4 ? strArr[3] : "";
                final String str7 = strArr.length >= 5 ? strArr[4] : "";
                String a17 = C6868a.a(new Consumer() { // from class: m41.a
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        a.C6868a.C6869a.a(str7, (Map) obj);
                    }
                }, map);
                w.d("MicroMsg.CompatReporter", "#reportCommon: " + str);
                C6868a.b(1, 0, str, a16, str2, str3, str4, str5, str6, a17);
            }

            public static /* synthetic */ void a(String str, Map map) {
                map.put("key5", str);
                map.put("dev-fingerprint", Build.FINGERPRINT);
            }
        }

        public static String a(Map map) {
            try {
                return new JSONObject(map).toString().replace(",", ";");
            } catch (Exception e16) {
                w.a("MicroMsg.CompatReporter", e16, "json error", new Object[0]);
                return e16.getMessage();
            }
        }

        public static String a(Consumer consumer, Map map) {
            if (map == null) {
                map = new HashMap();
            }
            consumer.accept(map);
            return a(map);
        }
    }

    public static /* synthetic */ String a() {
        return b();
    }

    public static String b() {
        String i3 = z.i();
        if (TextUtils.isEmpty(i3)) {
            return "";
        }
        if (i3.contains(":")) {
            return i3.substring(i3.lastIndexOf(":") + 1);
        }
        return "main";
    }
}
