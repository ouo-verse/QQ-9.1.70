package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import com.qq.e.comm.plugin.stat.StatTracer;
import java.io.IOException;
import javax.net.ssl.SSLHandshakeException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class q {
    public static void a(Exception exc, String str) {
        if (an.b()) {
            if (exc instanceof SSLHandshakeException) {
                if (aj.g()) {
                    exc.printStackTrace();
                }
                com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
                cVar.a("name", exc.getClass().getSimpleName());
                cVar.a("url", str);
                StatTracer.trackEvent(90022, 0, (com.qq.e.comm.plugin.stat.b) null, cVar);
                return;
            }
            if (exc instanceof IOException) {
                String message = exc.getMessage();
                if (!TextUtils.isEmpty(message) && message.contains("Hostname") && message.contains("not") && message.contains("verified")) {
                    if (aj.g()) {
                        exc.printStackTrace();
                    }
                    com.qq.e.comm.plugin.stat.c cVar2 = new com.qq.e.comm.plugin.stat.c();
                    cVar2.a("name", exc.getClass().getSimpleName());
                    cVar2.a("url", str);
                    StatTracer.trackEvent(90022, 1, (com.qq.e.comm.plugin.stat.b) null, cVar2);
                }
            }
        }
    }
}
