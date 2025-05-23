package com.tencent.luggage.wxa.w;

import android.util.Pair;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.luggage.wxa.w.v;
import java.util.Arrays;
import java.util.Collections;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i implements h {

    /* renamed from: n, reason: collision with root package name */
    public static final double[] f143793n = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a, reason: collision with root package name */
    public String f143794a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.l f143795b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f143796c;

    /* renamed from: d, reason: collision with root package name */
    public long f143797d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean[] f143798e = new boolean[4];

    /* renamed from: f, reason: collision with root package name */
    public final a f143799f = new a(128);

    /* renamed from: g, reason: collision with root package name */
    public long f143800g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f143801h;

    /* renamed from: i, reason: collision with root package name */
    public long f143802i;

    /* renamed from: j, reason: collision with root package name */
    public long f143803j;

    /* renamed from: k, reason: collision with root package name */
    public long f143804k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f143805l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f143806m;

    @Override // com.tencent.luggage.wxa.w.h
    public void a() {
        com.tencent.luggage.wxa.n0.j.a(this.f143798e);
        this.f143799f.a();
        this.f143800g = 0L;
        this.f143801h = false;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        public static final byte[] f143807e = {0, 0, 1};

        /* renamed from: a, reason: collision with root package name */
        public boolean f143808a;

        /* renamed from: b, reason: collision with root package name */
        public int f143809b;

        /* renamed from: c, reason: collision with root package name */
        public int f143810c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f143811d;

        public a(int i3) {
            this.f143811d = new byte[i3];
        }

        public void a() {
            this.f143808a = false;
            this.f143809b = 0;
            this.f143810c = 0;
        }

        public boolean a(int i3, int i16) {
            if (this.f143808a) {
                int i17 = this.f143809b - i16;
                this.f143809b = i17;
                if (this.f143810c == 0 && i3 == 181) {
                    this.f143810c = i17;
                } else {
                    this.f143808a = false;
                    return true;
                }
            } else if (i3 == 179) {
                this.f143808a = true;
            }
            byte[] bArr = f143807e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void a(byte[] bArr, int i3, int i16) {
            if (this.f143808a) {
                int i17 = i16 - i3;
                byte[] bArr2 = this.f143811d;
                int length = bArr2.length;
                int i18 = this.f143809b + i17;
                if (length < i18) {
                    this.f143811d = Arrays.copyOf(bArr2, i18 * 2);
                }
                System.arraycopy(bArr, i3, this.f143811d, this.f143809b, i17);
                this.f143809b += i17;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        dVar.a();
        this.f143794a = dVar.b();
        this.f143795b = fVar.a(dVar.c(), 2);
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(long j3, boolean z16) {
        this.f143802i = j3;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.n0.l lVar) {
        boolean z16;
        boolean z17;
        int c16 = lVar.c();
        int d16 = lVar.d();
        byte[] bArr = lVar.f135088a;
        this.f143800g += lVar.a();
        this.f143795b.a(lVar, lVar.a());
        while (true) {
            int a16 = com.tencent.luggage.wxa.n0.j.a(bArr, c16, d16, this.f143798e);
            if (a16 == d16) {
                break;
            }
            int i3 = a16 + 3;
            int i16 = lVar.f135088a[i3] & 255;
            if (!this.f143796c) {
                int i17 = a16 - c16;
                if (i17 > 0) {
                    this.f143799f.a(bArr, c16, a16);
                }
                if (this.f143799f.a(i16, i17 < 0 ? -i17 : 0)) {
                    Pair a17 = a(this.f143799f, this.f143794a);
                    this.f143795b.a((com.tencent.luggage.wxa.m.j) a17.first);
                    this.f143797d = ((Long) a17.second).longValue();
                    this.f143796c = true;
                }
            }
            if (i16 == 0 || i16 == 179) {
                int i18 = d16 - a16;
                if (this.f143801h && this.f143806m && this.f143796c) {
                    this.f143795b.a(this.f143804k, this.f143805l ? 1 : 0, ((int) (this.f143800g - this.f143803j)) - i18, i18, null);
                }
                boolean z18 = this.f143801h;
                if (!z18 || this.f143806m) {
                    this.f143803j = this.f143800g - i18;
                    long j3 = this.f143802i;
                    if (j3 == -9223372036854775807L) {
                        j3 = z18 ? this.f143804k + this.f143797d : 0L;
                    }
                    this.f143804k = j3;
                    z16 = false;
                    this.f143805l = false;
                    this.f143802i = -9223372036854775807L;
                    z17 = true;
                    this.f143801h = true;
                } else {
                    z16 = false;
                    z17 = true;
                }
                this.f143806m = i16 == 0 ? z17 : z16;
            } else if (i16 == 184) {
                this.f143805l = true;
            }
            c16 = i3;
        }
        if (this.f143796c) {
            return;
        }
        this.f143799f.a(bArr, c16, d16);
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair a(a aVar, String str) {
        float f16;
        int i3;
        float f17;
        int i16;
        long j3;
        byte[] copyOf = Arrays.copyOf(aVar.f143811d, aVar.f143809b);
        int i17 = copyOf[4] & 255;
        int i18 = copyOf[5] & 255;
        int i19 = (i17 << 4) | (i18 >> 4);
        int i26 = ((i18 & 15) << 8) | (copyOf[6] & 255);
        int i27 = (copyOf[7] & 240) >> 4;
        if (i27 == 2) {
            f16 = i26 * 4;
            i3 = i19 * 3;
        } else if (i27 == 3) {
            f16 = i26 * 16;
            i3 = i19 * 9;
        } else {
            if (i27 != 4) {
                f17 = 1.0f;
                com.tencent.luggage.wxa.m.j a16 = com.tencent.luggage.wxa.m.j.a(str, "video/mpeg2", (String) null, -1, -1, i19, i26, -1.0f, Collections.singletonList(copyOf), -1, f17, (com.tencent.luggage.wxa.p.a) null);
                i16 = (copyOf[7] & RegisterType.DOUBLE_HI) - 1;
                if (i16 >= 0) {
                    double[] dArr = f143793n;
                    if (i16 < dArr.length) {
                        double d16 = dArr[i16];
                        byte b16 = copyOf[aVar.f143810c + 9];
                        int i28 = (b16 & Constants.VIRTUAL_GAMEPAD_SDK_DATA) >> 5;
                        if (i28 != (b16 & 31)) {
                            d16 *= (i28 + 1.0d) / (r0 + 1);
                        }
                        j3 = (long) (1000000.0d / d16);
                        return Pair.create(a16, Long.valueOf(j3));
                    }
                }
                j3 = 0;
                return Pair.create(a16, Long.valueOf(j3));
            }
            f16 = i26 * 121;
            i3 = i19 * 100;
        }
        f17 = f16 / i3;
        com.tencent.luggage.wxa.m.j a162 = com.tencent.luggage.wxa.m.j.a(str, "video/mpeg2", (String) null, -1, -1, i19, i26, -1.0f, Collections.singletonList(copyOf), -1, f17, (com.tencent.luggage.wxa.p.a) null);
        i16 = (copyOf[7] & RegisterType.DOUBLE_HI) - 1;
        if (i16 >= 0) {
        }
        j3 = 0;
        return Pair.create(a162, Long.valueOf(j3));
    }
}
