package com.tencent.luggage.wxa.v;

import com.tencent.luggage.wxa.n0.l;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.v.h;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends h {

    /* renamed from: n, reason: collision with root package name */
    public com.tencent.luggage.wxa.n0.f f142856n;

    /* renamed from: o, reason: collision with root package name */
    public a f142857o;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements f, com.tencent.luggage.wxa.q.k {

        /* renamed from: a, reason: collision with root package name */
        public long[] f142858a;

        /* renamed from: b, reason: collision with root package name */
        public long[] f142859b;

        /* renamed from: c, reason: collision with root package name */
        public long f142860c = -1;

        /* renamed from: d, reason: collision with root package name */
        public long f142861d = -1;

        public a() {
        }

        @Override // com.tencent.luggage.wxa.q.k
        public boolean a() {
            return true;
        }

        @Override // com.tencent.luggage.wxa.v.f
        public long c(long j3) {
            long b16 = b.this.b(j3);
            this.f142861d = this.f142858a[v.b(this.f142858a, b16, true, true)];
            return b16;
        }

        public void d(long j3) {
            this.f142860c = j3;
        }

        public void a(l lVar) {
            lVar.f(1);
            int t16 = lVar.t() / 18;
            this.f142858a = new long[t16];
            this.f142859b = new long[t16];
            for (int i3 = 0; i3 < t16; i3++) {
                this.f142858a[i3] = lVar.m();
                this.f142859b[i3] = lVar.m();
                lVar.f(2);
            }
        }

        @Override // com.tencent.luggage.wxa.q.k
        public long c() {
            return b.this.f142856n.b();
        }

        @Override // com.tencent.luggage.wxa.v.f
        public long a(com.tencent.luggage.wxa.q.e eVar) {
            long j3 = this.f142861d;
            if (j3 < 0) {
                return -1L;
            }
            long j16 = -(j3 + 2);
            this.f142861d = -1L;
            return j16;
        }

        @Override // com.tencent.luggage.wxa.q.k
        public long a(long j3) {
            return this.f142860c + this.f142859b[v.b(this.f142858a, b.this.b(j3), true, true)];
        }

        @Override // com.tencent.luggage.wxa.v.f
        public com.tencent.luggage.wxa.q.k b() {
            return this;
        }
    }

    public static boolean c(l lVar) {
        if (lVar.a() >= 5 && lVar.q() == 127 && lVar.s() == 1179402563) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0009. Please report as an issue. */
    public final int b(l lVar) {
        int i3;
        int i16;
        int w3;
        int i17 = (lVar.f135088a[2] & 255) >> 4;
        switch (i17) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                i3 = i17 - 2;
                i16 = PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
                return i16 << i3;
            case 6:
            case 7:
                lVar.f(4);
                lVar.x();
                if (i17 == 6) {
                    w3 = lVar.q();
                } else {
                    w3 = lVar.w();
                }
                lVar.e(0);
                return w3 + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i3 = i17 - 8;
                i16 = 256;
                return i16 << i3;
            default:
                return -1;
        }
    }

    @Override // com.tencent.luggage.wxa.v.h
    public void a(boolean z16) {
        super.a(z16);
        if (z16) {
            this.f142856n = null;
            this.f142857o = null;
        }
    }

    public static boolean a(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.tencent.luggage.wxa.v.h
    public long a(l lVar) {
        if (a(lVar.f135088a)) {
            return b(lVar);
        }
        return -1L;
    }

    @Override // com.tencent.luggage.wxa.v.h
    public boolean a(l lVar, long j3, h.b bVar) {
        byte[] bArr = lVar.f135088a;
        if (this.f142856n == null) {
            this.f142856n = new com.tencent.luggage.wxa.n0.f(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, lVar.d());
            copyOfRange[4] = Byte.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            int a16 = this.f142856n.a();
            com.tencent.luggage.wxa.n0.f fVar = this.f142856n;
            bVar.f142900a = com.tencent.luggage.wxa.m.j.a(null, "audio/flac", null, -1, a16, fVar.f135062f, fVar.f135061e, singletonList, null, 0, null);
            return true;
        }
        if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            a aVar = new a();
            this.f142857o = aVar;
            aVar.a(lVar);
            return true;
        }
        if (!a(bArr)) {
            return true;
        }
        a aVar2 = this.f142857o;
        if (aVar2 != null) {
            aVar2.d(j3);
            bVar.f142901b = this.f142857o;
        }
        return false;
    }
}
