package com.tencent.qimei.k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r0.f343327a == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String a16;
        if (com.tencent.qimei.f.a.f343257a) {
            d dVar = d.f343326f;
            if (context != null && context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            synchronized (dVar) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    if (dVar.f343327a == null) {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                        try {
                            if (context.bindService(intent, dVar.f343331e, 1)) {
                                synchronized (dVar.f343330d) {
                                    try {
                                        dVar.f343330d.wait(3000L);
                                    } finally {
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    try {
                        a16 = dVar.a(context, "OUID");
                    } catch (Exception th5) {
                        a16 = "";
                        return a16;
                    }
                } else {
                    throw new IllegalStateException("Cannot run on MainThread");
                }
            }
            return a16;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
