package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.push.hw;
import com.xiaomi.push.ig;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fv {
    private static int a(Context context, String str, String str2) {
        com.xiaomi.push.service.j e16;
        NotificationChannel b16;
        int importance;
        if (Build.VERSION.SDK_INT >= 26 && context != null && !TextUtils.isEmpty(str) && (e16 = com.xiaomi.push.service.j.e(context, str)) != null && (b16 = e16.b(e16.i(str2))) != null) {
            importance = b16.getImportance();
            if (importance != 0) {
                return 32;
            }
            return 64;
        }
        return 0;
    }

    public static short b(Context context, hb hbVar) {
        String str;
        gs m375a = hbVar.m375a();
        if (m375a != null && m375a.m342a() != null) {
            str = m375a.m342a().get("channel_id");
        } else {
            str = null;
        }
        return c(context, hbVar.f389250b, str);
    }

    public static short c(Context context, String str, String str2) {
        int i3;
        int i16;
        int i17 = 0;
        int a16 = g.f(context, str, false).a() + 0;
        if (h.b(context)) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        int i18 = a16 + i3;
        if (h.a(context)) {
            i16 = 8;
        } else {
            i16 = 0;
        }
        int i19 = i18 + i16;
        if (com.xiaomi.push.service.j.t(context)) {
            i17 = 16;
        }
        return (short) (i19 + i17 + a(context, str, str2));
    }

    public static <T extends hq<T, ?>> void d(T t16, byte[] bArr) {
        if (bArr != null) {
            new fy(new ig.a(true, true, bArr.length)).a(t16, bArr);
            return;
        }
        throw new hu("the message byte is empty.");
    }

    public static <T extends hq<T, ?>> byte[] e(T t16) {
        if (t16 == null) {
            return null;
        }
        try {
            return new fz(new hw.a()).a(t16);
        } catch (hu e16) {
            jz4.c.o("convertThriftObjectToBytes catch TException.", e16);
            return null;
        }
    }
}
