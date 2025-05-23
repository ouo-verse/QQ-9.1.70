package com.xiaomi.push;

import android.content.Context;
import android.os.Build;

/* compiled from: P */
/* loaded from: classes28.dex */
public class cl {
    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean b(Context context, String str, long j3) {
        if (!com.xiaomi.push.service.ah.d(context).m(gk.DCJobMutualSwitch.a(), false)) {
            return false;
        }
        if ((Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29) || f.a(context, str, j3)) {
            return false;
        }
        return true;
    }

    public static byte[] c(String str, byte[] bArr) {
        byte[] b16 = aa.b(str);
        try {
            a(b16);
            return fu.b(b16, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] d(String str, byte[] bArr) {
        byte[] b16 = aa.b(str);
        try {
            a(b16);
            return fu.c(b16, bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
