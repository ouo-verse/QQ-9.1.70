package com.tencent.luggage.wxa.u;

import android.util.Log;
import com.google.android.exoplayer2.C;
import com.tencent.luggage.wxa.q.l;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f141978a;

    /* renamed from: b, reason: collision with root package name */
    public final String f141979b;

    /* renamed from: c, reason: collision with root package name */
    public final l.a f141980c;

    /* renamed from: d, reason: collision with root package name */
    public final int f141981d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f141982e;

    public k(boolean z16, String str, int i3, byte[] bArr, int i16, int i17, byte[] bArr2) {
        boolean z17;
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.tencent.luggage.wxa.n0.a.a((bArr2 == null) ^ z17);
        this.f141978a = z16;
        this.f141979b = str;
        this.f141981d = i3;
        this.f141982e = bArr2;
        this.f141980c = new l.a(a(str), bArr, i16, i17);
    }

    public static int a(String str) {
        if (str == null) {
            return 1;
        }
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(C.CENC_TYPE_cbc1)) {
                    c16 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals(C.CENC_TYPE_cbcs)) {
                    c16 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals(C.CENC_TYPE_cenc)) {
                    c16 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals(C.CENC_TYPE_cens)) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 1:
                return 2;
            default:
                Log.w("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
