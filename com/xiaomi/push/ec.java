package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.eg;

/* compiled from: P */
/* loaded from: classes28.dex */
class ec {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f388656a = Log.isLoggable("BCompressed", 3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(eb ebVar, byte[] bArr) {
        try {
            byte[] a16 = eg.a.a(bArr);
            if (f388656a) {
                jz4.c.n("BCompressed", "decompress " + bArr.length + " to " + a16.length + " for " + ebVar);
                if (ebVar.f388654e == 1) {
                    jz4.c.n("BCompressed", "decompress not support upStream");
                }
            }
            return a16;
        } catch (Exception e16) {
            jz4.c.n("BCompressed", "decompress error " + e16);
            return bArr;
        }
    }
}
