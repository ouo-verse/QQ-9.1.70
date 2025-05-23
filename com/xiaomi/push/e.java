package com.xiaomi.push;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes28.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    static final char[] f388646a = "0123456789ABCDEF".toCharArray();

    public static String a(byte[] bArr, int i3, int i16) {
        StringBuilder sb5 = new StringBuilder(i16 * 2);
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = bArr[i3 + i17] & 255;
            char[] cArr = f388646a;
            sb5.append(cArr[i18 >> 4]);
            sb5.append(cArr[i18 & 15]);
        }
        return sb5.toString();
    }

    public static boolean b(Context context) {
        return b.f388236a;
    }
}
