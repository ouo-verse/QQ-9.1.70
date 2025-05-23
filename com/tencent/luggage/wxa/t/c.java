package com.tencent.luggage.wxa.t;

import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.luggage.wxa.n0.l;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.q.i;
import com.tencent.luggage.wxa.t.b;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements b.InterfaceC6729b {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f140808a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f140809b;

    /* renamed from: c, reason: collision with root package name */
    public final long f140810c;

    public c(long[] jArr, long[] jArr2, long j3) {
        this.f140808a = jArr;
        this.f140809b = jArr2;
        this.f140810c = j3;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public boolean a() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.t.b.InterfaceC6729b
    public long b(long j3) {
        return this.f140808a[v.b(this.f140809b, j3, true, true)];
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long c() {
        return this.f140810c;
    }

    public static c a(i iVar, l lVar, long j3, long j16) {
        int q16;
        lVar.f(10);
        int f16 = lVar.f();
        if (f16 <= 0) {
            return null;
        }
        int i3 = iVar.f137765d;
        long b16 = v.b(f16, (i3 >= 32000 ? gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION : PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT) * 1000000, i3);
        int w3 = lVar.w();
        int w16 = lVar.w();
        int w17 = lVar.w();
        int i16 = 2;
        lVar.f(2);
        long j17 = j3 + iVar.f137764c;
        int i17 = w3 + 1;
        long[] jArr = new long[i17];
        long[] jArr2 = new long[i17];
        jArr[0] = 0;
        jArr2[0] = j17;
        int i18 = 1;
        while (i18 < i17) {
            if (w17 == 1) {
                q16 = lVar.q();
            } else if (w17 == i16) {
                q16 = lVar.w();
            } else if (w17 == 3) {
                q16 = lVar.t();
            } else {
                if (w17 != 4) {
                    return null;
                }
                q16 = lVar.u();
            }
            int i19 = i17;
            j17 += q16 * w16;
            int i26 = w16;
            int i27 = w17;
            jArr[i18] = (i18 * b16) / w3;
            jArr2[i18] = j16 == -1 ? j17 : Math.min(j16, j17);
            i18++;
            i17 = i19;
            w16 = i26;
            w17 = i27;
            i16 = 2;
        }
        return new c(jArr, jArr2, b16);
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long a(long j3) {
        return this.f140809b[v.b(this.f140808a, j3, true, true)];
    }
}
