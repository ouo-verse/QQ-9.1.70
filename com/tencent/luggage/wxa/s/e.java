package com.tencent.luggage.wxa.s;

import com.tencent.luggage.wxa.n0.l;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final l f139982a = new l(8);

    /* renamed from: b, reason: collision with root package name */
    public int f139983b;

    public final long a(com.tencent.luggage.wxa.q.e eVar) {
        int i3 = 0;
        eVar.b(this.f139982a.f135088a, 0, 1);
        int i16 = this.f139982a.f135088a[0] & 255;
        if (i16 == 0) {
            return Long.MIN_VALUE;
        }
        int i17 = 128;
        int i18 = 0;
        while ((i16 & i17) == 0) {
            i17 >>= 1;
            i18++;
        }
        int i19 = i16 & (~i17);
        eVar.b(this.f139982a.f135088a, 1, i18);
        while (i3 < i18) {
            i3++;
            i19 = (this.f139982a.f135088a[i3] & 255) + (i19 << 8);
        }
        this.f139983b += i18 + 1;
        return i19;
    }

    public boolean b(com.tencent.luggage.wxa.q.e eVar) {
        long length = eVar.getLength();
        long j3 = 1024;
        if (length != -1 && length <= 1024) {
            j3 = length;
        }
        int i3 = (int) j3;
        eVar.b(this.f139982a.f135088a, 0, 4);
        long s16 = this.f139982a.s();
        this.f139983b = 4;
        while (s16 != 440786851) {
            int i16 = this.f139983b + 1;
            this.f139983b = i16;
            if (i16 == i3) {
                return false;
            }
            eVar.b(this.f139982a.f135088a, 0, 1);
            s16 = ((s16 << 8) & (-256)) | (this.f139982a.f135088a[0] & 255);
        }
        long a16 = a(eVar);
        long j16 = this.f139983b;
        if (a16 == Long.MIN_VALUE) {
            return false;
        }
        if (length == -1 || j16 + a16 < length) {
            while (true) {
                long j17 = this.f139983b;
                long j18 = j16 + a16;
                if (j17 < j18) {
                    if (a(eVar) == Long.MIN_VALUE) {
                        return false;
                    }
                    long a17 = a(eVar);
                    if (a17 < 0 || a17 > TTL.MAX_VALUE) {
                        break;
                    }
                    if (a17 != 0) {
                        eVar.a((int) a17);
                        this.f139983b = (int) (this.f139983b + a17);
                    }
                } else {
                    if (j17 != j18) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
