package com.tencent.luggage.wxa.u;

import android.util.Log;
import android.util.Pair;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {
    public static Pair a(byte[] bArr) {
        com.tencent.luggage.wxa.n0.l lVar = new com.tencent.luggage.wxa.n0.l(bArr);
        if (lVar.d() < 32) {
            return null;
        }
        lVar.e(0);
        if (lVar.f() != lVar.a() + 4 || lVar.f() != a.V) {
            return null;
        }
        int c16 = a.c(lVar.f());
        if (c16 > 1) {
            Log.w("PsshAtomUtil", "Unsupported pssh version: " + c16);
            return null;
        }
        UUID uuid = new UUID(lVar.m(), lVar.m());
        if (c16 == 1) {
            lVar.f(lVar.u() * 16);
        }
        int u16 = lVar.u();
        if (u16 != lVar.a()) {
            return null;
        }
        byte[] bArr2 = new byte[u16];
        lVar.a(bArr2, 0, u16);
        return Pair.create(uuid, bArr2);
    }

    public static UUID b(byte[] bArr) {
        Pair a16 = a(bArr);
        if (a16 == null) {
            return null;
        }
        return (UUID) a16.first;
    }
}
