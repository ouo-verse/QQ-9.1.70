package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.push.fu;
import com.xiaomi.push.fv;
import com.xiaomi.push.hb;
import com.xiaomi.push.hg;
import com.xiaomi.push.hu;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ar {
    public static hg a(hb hbVar) {
        byte[] m381a = hbVar.m381a();
        hg hgVar = new hg();
        try {
            fv.d(hgVar, m381a);
            return hgVar;
        } catch (hu unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
        String stringExtra2 = intent.getStringExtra("mipush_app_package");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            try {
                byte[] d16 = d(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
                if (d16 != null) {
                    x.r(context, u.d(d16), d16);
                } else {
                    jz4.c.m("notify fcm notification error \uff1adencrypt failed");
                }
            } catch (Throwable th5) {
                jz4.c.o("notify fcm notification error ", th5);
            }
        }
    }

    public static void c(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
        }
    }

    public static byte[] d(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            jz4.c.m("secret is empty, return null");
            return null;
        }
        try {
            return fu.b(com.xiaomi.push.aa.b(str), bArr);
        } catch (Exception e16) {
            jz4.c.o("dencryption error. ", e16);
            return null;
        }
    }
}
