package com.tencent.luggage.wxa.v;

import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name */
    public final e f142843a = new e();

    /* renamed from: b, reason: collision with root package name */
    public final long f142844b;

    /* renamed from: c, reason: collision with root package name */
    public final long f142845c;

    /* renamed from: d, reason: collision with root package name */
    public final h f142846d;

    /* renamed from: e, reason: collision with root package name */
    public int f142847e;

    /* renamed from: f, reason: collision with root package name */
    public long f142848f;

    /* renamed from: g, reason: collision with root package name */
    public long f142849g;

    /* renamed from: h, reason: collision with root package name */
    public long f142850h;

    /* renamed from: i, reason: collision with root package name */
    public long f142851i;

    /* renamed from: j, reason: collision with root package name */
    public long f142852j;

    /* renamed from: k, reason: collision with root package name */
    public long f142853k;

    /* renamed from: l, reason: collision with root package name */
    public long f142854l;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.q.k {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.q.k
        public boolean a() {
            return true;
        }

        @Override // com.tencent.luggage.wxa.q.k
        public long c() {
            return a.this.f142846d.a(a.this.f142848f);
        }

        @Override // com.tencent.luggage.wxa.q.k
        public long a(long j3) {
            if (j3 == 0) {
                return a.this.f142844b;
            }
            long b16 = a.this.f142846d.b(j3);
            a aVar = a.this;
            return aVar.a(aVar.f142844b, b16, 30000L);
        }
    }

    public a(long j3, long j16, h hVar, int i3, long j17) {
        boolean z16;
        if (j3 >= 0 && j16 > j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.a.a(z16);
        this.f142846d = hVar;
        this.f142844b = j3;
        this.f142845c = j16;
        if (i3 == j16 - j3) {
            this.f142848f = j17;
            this.f142847e = 3;
        } else {
            this.f142847e = 0;
        }
    }

    @Override // com.tencent.luggage.wxa.v.f
    public long c(long j3) {
        int i3 = this.f142847e;
        com.tencent.luggage.wxa.n0.a.a(i3 == 3 || i3 == 2);
        this.f142850h = j3 != 0 ? this.f142846d.b(j3) : 0L;
        this.f142847e = 2;
        c();
        return this.f142850h;
    }

    @Override // com.tencent.luggage.wxa.v.f
    public long a(com.tencent.luggage.wxa.q.e eVar) {
        int i3 = this.f142847e;
        if (i3 == 0) {
            long position = eVar.getPosition();
            this.f142849g = position;
            this.f142847e = 1;
            long j3 = this.f142845c - 65307;
            if (j3 > position) {
                return j3;
            }
        } else if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            long j16 = this.f142850h;
            long j17 = 0;
            if (j16 != 0) {
                long a16 = a(j16, eVar);
                if (a16 >= 0) {
                    return a16;
                }
                j17 = a(eVar, this.f142850h, -(a16 + 2));
            }
            this.f142847e = 3;
            return -(j17 + 2);
        }
        this.f142848f = b(eVar);
        this.f142847e = 3;
        return this.f142849g;
    }

    public long b(com.tencent.luggage.wxa.q.e eVar) {
        c(eVar);
        this.f142843a.a();
        while ((this.f142843a.f142874b & 4) != 4 && eVar.getPosition() < this.f142845c) {
            this.f142843a.a(eVar, false);
            e eVar2 = this.f142843a;
            eVar.c(eVar2.f142880h + eVar2.f142881i);
        }
        return this.f142843a.f142875c;
    }

    public void c() {
        this.f142851i = this.f142844b;
        this.f142852j = this.f142845c;
        this.f142853k = 0L;
        this.f142854l = this.f142848f;
    }

    public void c(com.tencent.luggage.wxa.q.e eVar) {
        if (!a(eVar, this.f142845c)) {
            throw new EOFException();
        }
    }

    @Override // com.tencent.luggage.wxa.v.f
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b b() {
        if (this.f142848f != 0) {
            return new b();
        }
        return null;
    }

    public long a(long j3, com.tencent.luggage.wxa.q.e eVar) {
        if (this.f142851i == this.f142852j) {
            return -(this.f142853k + 2);
        }
        long position = eVar.getPosition();
        if (!a(eVar, this.f142852j)) {
            long j16 = this.f142851i;
            if (j16 != position) {
                return j16;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f142843a.a(eVar, false);
        eVar.a();
        e eVar2 = this.f142843a;
        long j17 = eVar2.f142875c;
        long j18 = j3 - j17;
        int i3 = eVar2.f142880h + eVar2.f142881i;
        if (j18 >= 0 && j18 <= 72000) {
            eVar.c(i3);
            return -(this.f142843a.f142875c + 2);
        }
        if (j18 < 0) {
            this.f142852j = position;
            this.f142854l = j17;
        } else {
            long j19 = i3;
            long position2 = eVar.getPosition() + j19;
            this.f142851i = position2;
            this.f142853k = this.f142843a.f142875c;
            if ((this.f142852j - position2) + j19 < JsonGrayBusiId.UI_RESERVE_100000_110000) {
                eVar.c(i3);
                return -(this.f142853k + 2);
            }
        }
        long j26 = this.f142852j;
        long j27 = this.f142851i;
        if (j26 - j27 < JsonGrayBusiId.UI_RESERVE_100000_110000) {
            this.f142852j = j27;
            return j27;
        }
        long position3 = eVar.getPosition() - (i3 * (j18 <= 0 ? 2 : 1));
        long j28 = this.f142852j;
        long j29 = this.f142851i;
        return Math.min(Math.max(position3 + ((j18 * (j28 - j29)) / (this.f142854l - this.f142853k)), j29), this.f142852j - 1);
    }

    public final long a(long j3, long j16, long j17) {
        long j18 = this.f142845c;
        long j19 = this.f142844b;
        long j26 = j3 + (((j16 * (j18 - j19)) / this.f142848f) - j17);
        if (j26 >= j19) {
            j19 = j26;
        }
        return j19 >= j18 ? j18 - 1 : j19;
    }

    public boolean a(com.tencent.luggage.wxa.q.e eVar, long j3) {
        int i3;
        long min = Math.min(j3 + 3, this.f142845c);
        int i16 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i17 = 0;
            if (eVar.getPosition() + i16 > min && (i16 = (int) (min - eVar.getPosition())) < 4) {
                return false;
            }
            eVar.a(bArr, 0, i16, false);
            while (true) {
                i3 = i16 - 3;
                if (i17 < i3) {
                    if (bArr[i17] == 79 && bArr[i17 + 1] == 103 && bArr[i17 + 2] == 103 && bArr[i17 + 3] == 83) {
                        eVar.c(i17);
                        return true;
                    }
                    i17++;
                }
            }
            eVar.c(i3);
        }
    }

    public long a(com.tencent.luggage.wxa.q.e eVar, long j3, long j16) {
        this.f142843a.a(eVar, false);
        while (true) {
            e eVar2 = this.f142843a;
            if (eVar2.f142875c < j3) {
                eVar.c(eVar2.f142880h + eVar2.f142881i);
                e eVar3 = this.f142843a;
                long j17 = eVar3.f142875c;
                eVar3.a(eVar, false);
                j16 = j17;
            } else {
                eVar.a();
                return j16;
            }
        }
    }
}
