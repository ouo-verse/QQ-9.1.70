package com.qq.e.comm.plugin.k;

import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ad {
    public static int a(String str, int i3) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable th5) {
            GDTLogger.e("NumberUtil", th5);
            return i3;
        }
    }
}
