package com.tencent.halley.common.a;

import com.tencent.halley.common.c.a;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static String f113283a;

    public static boolean a(String str, boolean z16, Map<String, String> map, boolean z17) {
        if (map != null) {
            com.tencent.halley.common.utils.d.b("UserActionWrapper", "onUserAction...eventName:" + str + " ,map:");
            for (String str2 : map.keySet()) {
                com.tencent.halley.common.utils.d.b("UserActionWrapper", str2 + ":" + map.get(str2));
            }
        }
        try {
            com.tencent.halley.common.c.e e16 = com.tencent.halley.common.c.e.e();
            String a16 = com.tencent.halley.common.c.e.a(str, z16, map);
            try {
                int andIncrement = e16.f113353c.getAndIncrement();
                com.tencent.halley.common.utils.d.c(e16.f113351a, "upload:" + a16 + " newCount:" + andIncrement);
                if (andIncrement > e16.f113354d) {
                    com.tencent.halley.common.utils.d.b(e16.f113351a, "queue in halleyReportThread is full, abandon report data");
                    e16.f113353c.decrementAndGet();
                } else {
                    new a.b(a16, z17).a(false);
                }
                return true;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return true;
            }
        } catch (Throwable th6) {
            try {
                th6.printStackTrace();
                return true;
            } catch (Throwable th7) {
                th7.printStackTrace();
                return false;
            }
        }
    }
}
