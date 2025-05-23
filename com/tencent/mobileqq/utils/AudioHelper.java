package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AudioHelper {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f306877a = false;

    /* renamed from: b, reason: collision with root package name */
    private static int f306878b;

    protected static void a(Context context) {
        int i3;
        if (!f306877a && (i3 = f306878b) < 3) {
            f306878b = i3 + 1;
            f306877a = SoLoadUtilNew.loadSoByName(context, "audiohelper");
        }
    }

    public static synchronized long b(Context context, byte[] bArr, int i3, float f16) {
        synchronized (AudioHelper.class) {
            a(context);
            if (f306877a) {
                return enlargeVolum(bArr, i3, f16);
            }
            return 2000L;
        }
    }

    @Deprecated
    public static native long enlargeVolum(byte[] bArr, int i3, float f16);
}
