package com.tencent.luggage.wxa.u;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.a0.a;
import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.u.a;
import com.tencent.luggage.wxa.u.d;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f141842a = v.b("vide");

    /* renamed from: b, reason: collision with root package name */
    public static final int f141843b = v.b("soun");

    /* renamed from: c, reason: collision with root package name */
    public static final int f141844c = v.b("text");

    /* renamed from: d, reason: collision with root package name */
    public static final int f141845d = v.b("sbtl");

    /* renamed from: e, reason: collision with root package name */
    public static final int f141846e = v.b("subt");

    /* renamed from: f, reason: collision with root package name */
    public static final int f141847f = v.b("clcp");

    /* renamed from: g, reason: collision with root package name */
    public static final int f141848g = v.b(C.CENC_TYPE_cenc);

    /* renamed from: h, reason: collision with root package name */
    public static final int f141849h = v.b(PublicAccountMessageUtilImpl.META_NAME);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f141850a;

        /* renamed from: b, reason: collision with root package name */
        public int f141851b;

        /* renamed from: c, reason: collision with root package name */
        public int f141852c;

        /* renamed from: d, reason: collision with root package name */
        public long f141853d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f141854e;

        /* renamed from: f, reason: collision with root package name */
        public final com.tencent.luggage.wxa.n0.l f141855f;

        /* renamed from: g, reason: collision with root package name */
        public final com.tencent.luggage.wxa.n0.l f141856g;

        /* renamed from: h, reason: collision with root package name */
        public int f141857h;

        /* renamed from: i, reason: collision with root package name */
        public int f141858i;

        public a(com.tencent.luggage.wxa.n0.l lVar, com.tencent.luggage.wxa.n0.l lVar2, boolean z16) {
            this.f141856g = lVar;
            this.f141855f = lVar2;
            this.f141854e = z16;
            lVar2.e(12);
            this.f141850a = lVar2.u();
            lVar.e(12);
            this.f141858i = lVar.u();
            com.tencent.luggage.wxa.n0.a.b(lVar.f() == 1, "first_chunk must be 1");
            this.f141851b = -1;
        }

        public boolean a() {
            long s16;
            int i3;
            int i16 = this.f141851b + 1;
            this.f141851b = i16;
            if (i16 == this.f141850a) {
                return false;
            }
            if (this.f141854e) {
                s16 = this.f141855f.v();
            } else {
                s16 = this.f141855f.s();
            }
            this.f141853d = s16;
            if (this.f141851b == this.f141857h) {
                this.f141852c = this.f141856g.u();
                this.f141856g.f(4);
                int i17 = this.f141858i - 1;
                this.f141858i = i17;
                if (i17 > 0) {
                    i3 = this.f141856g.u() - 1;
                } else {
                    i3 = -1;
                }
                this.f141857h = i3;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.u.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6776b {
        boolean a();

        int b();

        int c();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final k[] f141859a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.luggage.wxa.m.j f141860b;

        /* renamed from: c, reason: collision with root package name */
        public int f141861c;

        /* renamed from: d, reason: collision with root package name */
        public int f141862d = 0;

        public c(int i3) {
            this.f141859a = new k[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements InterfaceC6776b {

        /* renamed from: a, reason: collision with root package name */
        public final int f141863a;

        /* renamed from: b, reason: collision with root package name */
        public final int f141864b;

        /* renamed from: c, reason: collision with root package name */
        public final com.tencent.luggage.wxa.n0.l f141865c;

        public d(a.b bVar) {
            com.tencent.luggage.wxa.n0.l lVar = bVar.Q0;
            this.f141865c = lVar;
            lVar.e(12);
            this.f141863a = lVar.u();
            this.f141864b = lVar.u();
        }

        @Override // com.tencent.luggage.wxa.u.b.InterfaceC6776b
        public boolean a() {
            if (this.f141863a != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.luggage.wxa.u.b.InterfaceC6776b
        public int b() {
            int i3 = this.f141863a;
            if (i3 == 0) {
                return this.f141865c.u();
            }
            return i3;
        }

        @Override // com.tencent.luggage.wxa.u.b.InterfaceC6776b
        public int c() {
            return this.f141864b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements InterfaceC6776b {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.n0.l f141866a;

        /* renamed from: b, reason: collision with root package name */
        public final int f141867b;

        /* renamed from: c, reason: collision with root package name */
        public final int f141868c;

        /* renamed from: d, reason: collision with root package name */
        public int f141869d;

        /* renamed from: e, reason: collision with root package name */
        public int f141870e;

        public e(a.b bVar) {
            com.tencent.luggage.wxa.n0.l lVar = bVar.Q0;
            this.f141866a = lVar;
            lVar.e(12);
            this.f141868c = lVar.u() & 255;
            this.f141867b = lVar.u();
        }

        @Override // com.tencent.luggage.wxa.u.b.InterfaceC6776b
        public boolean a() {
            return false;
        }

        @Override // com.tencent.luggage.wxa.u.b.InterfaceC6776b
        public int b() {
            int i3 = this.f141868c;
            if (i3 == 8) {
                return this.f141866a.q();
            }
            if (i3 == 16) {
                return this.f141866a.w();
            }
            int i16 = this.f141869d;
            this.f141869d = i16 + 1;
            if (i16 % 2 == 0) {
                int q16 = this.f141866a.q();
                this.f141870e = q16;
                return (q16 & 240) >> 4;
            }
            return this.f141870e & 15;
        }

        @Override // com.tencent.luggage.wxa.u.b.InterfaceC6776b
        public int c() {
            return this.f141867b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f141871a;

        /* renamed from: b, reason: collision with root package name */
        public final long f141872b;

        /* renamed from: c, reason: collision with root package name */
        public final int f141873c;

        public f(int i3, long j3, int i16) {
            this.f141871a = i3;
            this.f141872b = j3;
            this.f141873c = i16;
        }
    }

    public static j a(a.C6775a c6775a, a.b bVar, long j3, com.tencent.luggage.wxa.p.a aVar, boolean z16, boolean z17) {
        a.b bVar2;
        long j16;
        long[] jArr;
        long[] jArr2;
        a.C6775a d16 = c6775a.d(com.tencent.luggage.wxa.u.a.F);
        int b16 = b(d16.e(com.tencent.luggage.wxa.u.a.T).Q0);
        if (b16 == -1) {
            return null;
        }
        f e16 = e(c6775a.e(com.tencent.luggage.wxa.u.a.P).Q0);
        if (j3 == -9223372036854775807L) {
            bVar2 = bVar;
            j16 = e16.f141872b;
        } else {
            bVar2 = bVar;
            j16 = j3;
        }
        long d17 = d(bVar2.Q0);
        long b17 = j16 != -9223372036854775807L ? v.b(j16, 1000000L, d17) : -9223372036854775807L;
        a.C6775a d18 = d16.d(com.tencent.luggage.wxa.u.a.G).d(com.tencent.luggage.wxa.u.a.H);
        Pair c16 = c(d16.e(com.tencent.luggage.wxa.u.a.S).Q0);
        c a16 = a(d18.e(com.tencent.luggage.wxa.u.a.U).Q0, e16.f141871a, e16.f141873c, (String) c16.second, aVar, z17);
        if (z16) {
            jArr = null;
            jArr2 = null;
        } else {
            Pair a17 = a(c6775a.d(com.tencent.luggage.wxa.u.a.Q));
            long[] jArr3 = (long[]) a17.first;
            jArr2 = (long[]) a17.second;
            jArr = jArr3;
        }
        if (a16.f141860b == null) {
            return null;
        }
        return new j(e16.f141871a, b16, ((Long) c16.first).longValue(), d17, b17, a16.f141860b, a16.f141862d, a16.f141859a, a16.f141861c, jArr, jArr2);
    }

    public static com.tencent.luggage.wxa.a0.a b(com.tencent.luggage.wxa.n0.l lVar, int i3) {
        lVar.f(8);
        ArrayList arrayList = new ArrayList();
        while (lVar.c() < i3) {
            a.b b16 = com.tencent.luggage.wxa.u.f.b(lVar);
            if (b16 != null) {
                arrayList.add(b16);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.tencent.luggage.wxa.a0.a(arrayList);
    }

    public static com.tencent.luggage.wxa.a0.a c(com.tencent.luggage.wxa.n0.l lVar, int i3) {
        lVar.f(12);
        while (lVar.c() < i3) {
            int c16 = lVar.c();
            int f16 = lVar.f();
            if (lVar.f() == com.tencent.luggage.wxa.u.a.D0) {
                lVar.e(c16);
                return b(lVar, c16 + f16);
            }
            lVar.f(f16 - 8);
        }
        return null;
    }

    public static long d(com.tencent.luggage.wxa.n0.l lVar) {
        lVar.e(8);
        lVar.f(com.tencent.luggage.wxa.u.a.c(lVar.f()) != 0 ? 16 : 8);
        return lVar.s();
    }

    public static f e(com.tencent.luggage.wxa.n0.l lVar) {
        int i3;
        boolean z16;
        long v3;
        int i16 = 8;
        lVar.e(8);
        int c16 = com.tencent.luggage.wxa.u.a.c(lVar.f());
        if (c16 == 0) {
            i3 = 8;
        } else {
            i3 = 16;
        }
        lVar.f(i3);
        int f16 = lVar.f();
        lVar.f(4);
        int c17 = lVar.c();
        if (c16 == 0) {
            i16 = 4;
        }
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (i18 < i16) {
                if (lVar.f135088a[c17 + i18] != -1) {
                    z16 = false;
                    break;
                }
                i18++;
            } else {
                z16 = true;
                break;
            }
        }
        long j3 = -9223372036854775807L;
        if (z16) {
            lVar.f(i16);
        } else {
            if (c16 == 0) {
                v3 = lVar.s();
            } else {
                v3 = lVar.v();
            }
            if (v3 != 0) {
                j3 = v3;
            }
        }
        lVar.f(16);
        int f17 = lVar.f();
        int f18 = lVar.f();
        lVar.f(4);
        int f19 = lVar.f();
        int f26 = lVar.f();
        if (f17 == 0 && f18 == 65536 && f19 == -65536 && f26 == 0) {
            i17 = 90;
        } else if (f17 == 0 && f18 == -65536 && f19 == 65536 && f26 == 0) {
            i17 = 270;
        } else if (f17 == -65536 && f18 == 0 && f19 == 0 && f26 == -65536) {
            i17 = 180;
        }
        return new f(f16, j3, i17);
    }

    public static float d(com.tencent.luggage.wxa.n0.l lVar, int i3) {
        lVar.e(i3 + 8);
        return lVar.u() / lVar.u();
    }

    public static int b(com.tencent.luggage.wxa.n0.l lVar) {
        lVar.e(16);
        int f16 = lVar.f();
        if (f16 == f141843b) {
            return 1;
        }
        if (f16 == f141842a) {
            return 2;
        }
        if (f16 == f141844c || f16 == f141845d || f16 == f141846e || f16 == f141847f) {
            return 3;
        }
        return f16 == f141849h ? 4 : -1;
    }

    public static Pair d(com.tencent.luggage.wxa.n0.l lVar, int i3, int i16) {
        Pair b16;
        int c16 = lVar.c();
        while (c16 - i3 < i16) {
            lVar.e(c16);
            int f16 = lVar.f();
            com.tencent.luggage.wxa.n0.a.a(f16 > 0, "childAtomSize should be positive");
            if (lVar.f() == com.tencent.luggage.wxa.u.a.W && (b16 = b(lVar, c16, f16)) != null) {
                return b16;
            }
            c16 += f16;
        }
        return null;
    }

    public static Pair c(com.tencent.luggage.wxa.n0.l lVar) {
        lVar.e(8);
        int c16 = com.tencent.luggage.wxa.u.a.c(lVar.f());
        lVar.f(c16 == 0 ? 8 : 16);
        long s16 = lVar.s();
        lVar.f(c16 == 0 ? 4 : 8);
        int w3 = lVar.w();
        return Pair.create(Long.valueOf(s16), "" + ((char) (((w3 >> 10) & 31) + 96)) + ((char) (((w3 >> 5) & 31) + 96)) + ((char) ((w3 & 31) + 96)));
    }

    public static Pair b(com.tencent.luggage.wxa.n0.l lVar, int i3, int i16) {
        int i17 = i3 + 8;
        int i18 = -1;
        int i19 = 0;
        String str = null;
        Integer num = null;
        while (i17 - i3 < i16) {
            lVar.e(i17);
            int f16 = lVar.f();
            int f17 = lVar.f();
            if (f17 == com.tencent.luggage.wxa.u.a.f141794c0) {
                num = Integer.valueOf(lVar.f());
            } else if (f17 == com.tencent.luggage.wxa.u.a.X) {
                lVar.f(4);
                str = lVar.b(4);
            } else if (f17 == com.tencent.luggage.wxa.u.a.Y) {
                i18 = i17;
                i19 = f16;
            }
            i17 += f16;
        }
        if (!C.CENC_TYPE_cenc.equals(str) && !C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cens.equals(str) && !C.CENC_TYPE_cbcs.equals(str)) {
            return null;
        }
        com.tencent.luggage.wxa.n0.a.a(num != null, "frma atom is mandatory");
        com.tencent.luggage.wxa.n0.a.a(i18 != -1, "schi atom is mandatory");
        k a16 = a(lVar, i18, i19, str);
        com.tencent.luggage.wxa.n0.a.a(a16 != null, "tenc atom is mandatory");
        return Pair.create(num, a16);
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static m a(j jVar, a.C6775a c6775a, com.tencent.luggage.wxa.q.h hVar) {
        InterfaceC6776b eVar;
        boolean z16;
        int i3;
        int i16;
        j jVar2;
        int i17;
        String str;
        int[] iArr;
        long[] jArr;
        long[] jArr2;
        int[] iArr2;
        int i18;
        long j3;
        int[] iArr3;
        boolean z17;
        int[] iArr4;
        int i19;
        int[] iArr5;
        String str2;
        int[] iArr6;
        int i26;
        int i27;
        a.b e16 = c6775a.e(com.tencent.luggage.wxa.u.a.f141824r0);
        if (e16 != null) {
            eVar = new d(e16);
        } else {
            a.b e17 = c6775a.e(com.tencent.luggage.wxa.u.a.f141826s0);
            if (e17 != null) {
                eVar = new e(e17);
            } else {
                throw new o("Track has no sample table size information");
            }
        }
        int c16 = eVar.c();
        if (c16 == 0) {
            return new m(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        a.b e18 = c6775a.e(com.tencent.luggage.wxa.u.a.f141828t0);
        if (e18 == null) {
            e18 = c6775a.e(com.tencent.luggage.wxa.u.a.f141830u0);
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.l lVar = e18.Q0;
        com.tencent.luggage.wxa.n0.l lVar2 = c6775a.e(com.tencent.luggage.wxa.u.a.f141822q0).Q0;
        com.tencent.luggage.wxa.n0.l lVar3 = c6775a.e(com.tencent.luggage.wxa.u.a.f141816n0).Q0;
        a.b e19 = c6775a.e(com.tencent.luggage.wxa.u.a.f141818o0);
        com.tencent.luggage.wxa.n0.l lVar4 = null;
        com.tencent.luggage.wxa.n0.l lVar5 = e19 != null ? e19.Q0 : null;
        a.b e26 = c6775a.e(com.tencent.luggage.wxa.u.a.f141820p0);
        com.tencent.luggage.wxa.n0.l lVar6 = e26 != null ? e26.Q0 : null;
        a aVar = new a(lVar2, lVar, z16);
        lVar3.e(12);
        int u16 = lVar3.u() - 1;
        int u17 = lVar3.u();
        int u18 = lVar3.u();
        if (lVar6 != null) {
            lVar6.e(12);
            i3 = lVar6.u();
        } else {
            i3 = 0;
        }
        if (lVar5 != null) {
            lVar5.e(12);
            i16 = lVar5.u();
            r16 = i16 > 0 ? lVar5.u() - 1 : -1;
            long j16 = 0;
            if (!eVar.a() && "audio/raw".equals(jVar.f141972f.f133896f) && u16 == 0 && i3 == 0 && i16 == 0) {
                long[] jArr3 = new long[c16];
                int[] iArr7 = new int[c16];
                int i28 = i16;
                long[] jArr4 = new long[c16];
                iArr = new int[c16];
                int i29 = u18;
                long j17 = 0;
                j3 = 0;
                int i36 = u16;
                int i37 = 0;
                int i38 = 0;
                int i39 = 0;
                int i46 = 0;
                int i47 = 0;
                int i48 = i28;
                int i49 = r16;
                int i56 = i3;
                int i57 = u17;
                while (i37 < c16) {
                    while (i46 == 0) {
                        com.tencent.luggage.wxa.n0.a.b(aVar.a());
                        j17 = aVar.f141853d;
                        i46 = aVar.f141852c;
                        i36 = i36;
                        i57 = i57;
                    }
                    int i58 = i36;
                    int i59 = i57;
                    if (lVar6 != null) {
                        while (i39 == 0 && i56 > 0) {
                            i39 = lVar6.u();
                            i47 = lVar6.f();
                            i56--;
                        }
                        i39--;
                    }
                    int i65 = i47;
                    jArr3[i37] = j17;
                    int b16 = eVar.b();
                    iArr7[i37] = b16;
                    int i66 = c16;
                    if (b16 > i38) {
                        i38 = b16;
                    }
                    InterfaceC6776b interfaceC6776b = eVar;
                    jArr4[i37] = j3 + i65;
                    iArr[i37] = lVar4 == null ? 1 : 0;
                    if (i37 == i49) {
                        iArr[i37] = 1;
                        i48--;
                        if (i48 > 0) {
                            i49 = lVar4.u() - 1;
                        }
                    }
                    j3 += i29;
                    int i67 = i59 - 1;
                    if (i67 == 0 && i58 > 0) {
                        i58--;
                        i67 = lVar3.u();
                        i29 = lVar3.u();
                    }
                    int i68 = i67;
                    j17 += iArr7[i37];
                    i46--;
                    i37++;
                    eVar = interfaceC6776b;
                    c16 = i66;
                    i29 = i29;
                    i57 = i68;
                    i47 = i65;
                    i36 = i58;
                }
                i17 = c16;
                int i69 = i36;
                int i75 = i57;
                com.tencent.luggage.wxa.n0.a.a(i39 == 0);
                while (i56 > 0) {
                    com.tencent.luggage.wxa.n0.a.a(lVar6.u() == 0);
                    lVar6.f();
                    i56--;
                }
                if (i48 == 0 && i75 == 0) {
                    i27 = i46;
                    if (i27 == 0 && i69 == 0) {
                        jVar2 = jVar;
                        str = "AtomParsers";
                        jArr = jArr3;
                        jArr2 = jArr4;
                        iArr2 = iArr7;
                        i18 = i38;
                    }
                } else {
                    i27 = i46;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Inconsistent stbl box for track ");
                jVar2 = jVar;
                sb5.append(jVar2.f141967a);
                sb5.append(": remainingSynchronizationSamples ");
                sb5.append(i48);
                sb5.append(", remainingSamplesAtTimestampDelta ");
                sb5.append(i75);
                sb5.append(", remainingSamplesInChunk ");
                sb5.append(i27);
                sb5.append(", remainingTimestampDeltaChanges ");
                sb5.append(i69);
                String sb6 = sb5.toString();
                str = "AtomParsers";
                Log.w(str, sb6);
                jArr = jArr3;
                jArr2 = jArr4;
                iArr2 = iArr7;
                i18 = i38;
            } else {
                jVar2 = jVar;
                i17 = c16;
                InterfaceC6776b interfaceC6776b2 = eVar;
                str = "AtomParsers";
                int i76 = aVar.f141850a;
                long[] jArr5 = new long[i76];
                int[] iArr8 = new int[i76];
                while (aVar.a()) {
                    int i77 = aVar.f141851b;
                    jArr5[i77] = aVar.f141853d;
                    iArr8[i77] = aVar.f141852c;
                }
                d.b a16 = com.tencent.luggage.wxa.u.d.a(interfaceC6776b2.b(), jArr5, iArr8, u18);
                long[] jArr6 = a16.f141878a;
                int[] iArr9 = a16.f141879b;
                int i78 = a16.f141880c;
                long[] jArr7 = a16.f141881d;
                iArr = a16.f141882e;
                jArr = jArr6;
                jArr2 = jArr7;
                iArr2 = iArr9;
                i18 = i78;
                j3 = 0;
            }
            if (jVar2.f141974h == null && !hVar.a()) {
                long[] jArr8 = jVar2.f141974h;
                if (jArr8.length == 1 && jVar2.f141968b == 1 && jArr2.length >= 2) {
                    long j18 = jVar2.f141975i[0];
                    long b17 = v.b(jArr8[0], jVar2.f141969c, jVar2.f141970d) + j18;
                    long j19 = jArr2[0];
                    if (j19 <= j18 && j18 < jArr2[1] && jArr2[jArr2.length - 1] < b17 && b17 <= j3) {
                        long j26 = j3 - b17;
                        long b18 = v.b(j18 - j19, jVar2.f141972f.H, jVar2.f141969c);
                        long b19 = v.b(j26, jVar2.f141972f.H, jVar2.f141969c);
                        if ((b18 != 0 || b19 != 0) && b18 <= TTL.MAX_VALUE && b19 <= TTL.MAX_VALUE) {
                            hVar.f137753a = (int) b18;
                            hVar.f137754b = (int) b19;
                            v.a(jArr2, 1000000L, jVar2.f141969c);
                            return new m(jArr, iArr2, i18, jArr2, iArr);
                        }
                    }
                }
                long[] jArr9 = jVar2.f141974h;
                if (jArr9.length == 1) {
                    char c17 = 0;
                    if (jArr9[0] == 0) {
                        int i79 = 0;
                        while (i79 < jArr2.length) {
                            jArr2[i79] = v.b(jArr2[i79] - jVar2.f141975i[c17], 1000000L, jVar2.f141969c);
                            i79++;
                            c17 = 0;
                        }
                        return new m(jArr, iArr2, i18, jArr2, iArr);
                    }
                }
                boolean z18 = jVar2.f141968b == 1;
                int i85 = 0;
                int i86 = 0;
                boolean z19 = false;
                int i87 = 0;
                while (true) {
                    long[] jArr10 = jVar2.f141974h;
                    if (i87 >= jArr10.length) {
                        break;
                    }
                    int[] iArr10 = iArr;
                    long j27 = jVar2.f141975i[i87];
                    if (j27 != -1) {
                        iArr6 = iArr2;
                        i26 = i18;
                        long b26 = v.b(jArr10[i87], jVar2.f141969c, jVar2.f141970d);
                        int a17 = v.a(jArr2, j27, true, true);
                        int a18 = v.a(jArr2, j27 + b26, z18, false);
                        i85 += a18 - a17;
                        z19 = (i86 != a17) | z19;
                        i86 = a18;
                    } else {
                        iArr6 = iArr2;
                        i26 = i18;
                    }
                    i87++;
                    iArr = iArr10;
                    iArr2 = iArr6;
                    i18 = i26;
                }
                int[] iArr11 = iArr;
                int[] iArr12 = iArr2;
                int i88 = i18;
                boolean z26 = (i85 != i17) | z19;
                long[] jArr11 = z26 ? new long[i85] : jArr;
                int[] iArr13 = z26 ? new int[i85] : iArr12;
                int i89 = z26 ? 0 : i88;
                int[] iArr14 = z26 ? new int[i85] : iArr11;
                long[] jArr12 = new long[i85];
                int i95 = i89;
                int i96 = 0;
                int i97 = 0;
                while (true) {
                    long[] jArr13 = jVar2.f141974h;
                    if (i96 >= jArr13.length) {
                        break;
                    }
                    long[] jArr14 = jArr12;
                    String str3 = str;
                    long j28 = jVar2.f141975i[i96];
                    long j29 = jArr13[i96];
                    if (j28 != -1) {
                        str2 = str3;
                        i19 = i96;
                        int[] iArr15 = iArr14;
                        long b27 = v.b(j29, jVar2.f141969c, jVar2.f141970d) + j28;
                        int a19 = v.a(jArr2, j28, true, true);
                        int a26 = v.a(jArr2, b27, z18, false);
                        if (z26) {
                            int i98 = a26 - a19;
                            System.arraycopy(jArr, a19, jArr11, i97, i98);
                            System.arraycopy(iArr12, a19, iArr13, i97, i98);
                            iArr3 = iArr11;
                            z17 = z18;
                            iArr5 = iArr15;
                            System.arraycopy(iArr3, a19, iArr5, i97, i98);
                        } else {
                            iArr3 = iArr11;
                            z17 = z18;
                            iArr5 = iArr15;
                        }
                        int i99 = i95;
                        while (true) {
                            iArr4 = iArr12;
                            if (a19 >= a26) {
                                break;
                            }
                            int i100 = a26;
                            long j36 = j28;
                            jArr14[i97] = v.b(j16, 1000000L, jVar2.f141970d) + v.b(jArr2[a19] - j28, 1000000L, jVar2.f141969c);
                            if (z26 && iArr13[i97] > i99) {
                                i99 = iArr4[a19];
                            }
                            i97++;
                            a19++;
                            a26 = i100;
                            j28 = j36;
                            iArr12 = iArr4;
                        }
                        i95 = i99;
                    } else {
                        iArr3 = iArr11;
                        z17 = z18;
                        iArr4 = iArr12;
                        i19 = i96;
                        iArr5 = iArr14;
                        str2 = str3;
                    }
                    j16 += j29;
                    i96 = i19 + 1;
                    iArr14 = iArr5;
                    iArr11 = iArr3;
                    str = str2;
                    jArr12 = jArr14;
                    z18 = z17;
                    iArr12 = iArr4;
                }
                int[] iArr16 = iArr11;
                long[] jArr15 = jArr12;
                String str4 = str;
                int[] iArr17 = iArr12;
                int[] iArr18 = iArr14;
                boolean z27 = false;
                for (int i101 = 0; i101 < iArr18.length && !z27; i101++) {
                    z27 |= (iArr18[i101] & 1) != 0;
                }
                if (!z27) {
                    Log.w(str4, "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
                    v.a(jArr2, 1000000L, jVar2.f141969c);
                    return new m(jArr, iArr17, i88, jArr2, iArr16);
                }
                return new m(jArr11, iArr13, i95, jArr15, iArr18);
            }
            int[] iArr19 = iArr2;
            int i102 = i18;
            v.a(jArr2, 1000000L, jVar2.f141969c);
            return new m(jArr, iArr19, i102, jArr2, iArr);
        }
        i16 = 0;
        lVar4 = lVar5;
        long j162 = 0;
        if (!eVar.a() && "audio/raw".equals(jVar.f141972f.f133896f) && u16 == 0 && i3 == 0 && i16 == 0) {
        }
        if (jVar2.f141974h == null) {
        }
        int[] iArr192 = iArr2;
        int i1022 = i18;
        v.a(jArr2, 1000000L, jVar2.f141969c);
        return new m(jArr, iArr192, i1022, jArr2, iArr);
    }

    public static byte[] c(com.tencent.luggage.wxa.n0.l lVar, int i3, int i16) {
        int i17 = i3 + 8;
        while (i17 - i3 < i16) {
            lVar.e(i17);
            int f16 = lVar.f();
            if (lVar.f() == com.tencent.luggage.wxa.u.a.K0) {
                return Arrays.copyOfRange(lVar.f135088a, i17, f16 + i17);
            }
            i17 += f16;
        }
        return null;
    }

    public static com.tencent.luggage.wxa.a0.a a(a.b bVar, boolean z16) {
        if (z16) {
            return null;
        }
        com.tencent.luggage.wxa.n0.l lVar = bVar.Q0;
        lVar.e(8);
        while (lVar.a() >= 8) {
            int c16 = lVar.c();
            int f16 = lVar.f();
            if (lVar.f() == com.tencent.luggage.wxa.u.a.C0) {
                lVar.e(c16);
                return c(lVar, c16 + f16);
            }
            lVar.f(f16 - 8);
        }
        return null;
    }

    public static c a(com.tencent.luggage.wxa.n0.l lVar, int i3, int i16, String str, com.tencent.luggage.wxa.p.a aVar, boolean z16) {
        lVar.e(12);
        int f16 = lVar.f();
        c cVar = new c(f16);
        for (int i17 = 0; i17 < f16; i17++) {
            int c16 = lVar.c();
            int f17 = lVar.f();
            com.tencent.luggage.wxa.n0.a.a(f17 > 0, "childAtomSize should be positive");
            int f18 = lVar.f();
            if (f18 != com.tencent.luggage.wxa.u.a.f141793c && f18 != com.tencent.luggage.wxa.u.a.f141795d && f18 != com.tencent.luggage.wxa.u.a.f141790a0 && f18 != com.tencent.luggage.wxa.u.a.f141814m0 && f18 != com.tencent.luggage.wxa.u.a.f141797e && f18 != com.tencent.luggage.wxa.u.a.f141799f && f18 != com.tencent.luggage.wxa.u.a.f141801g && f18 != com.tencent.luggage.wxa.u.a.L0 && f18 != com.tencent.luggage.wxa.u.a.M0) {
                if (f18 != com.tencent.luggage.wxa.u.a.f141807j && f18 != com.tencent.luggage.wxa.u.a.f141792b0 && f18 != com.tencent.luggage.wxa.u.a.f141817o && f18 != com.tencent.luggage.wxa.u.a.f141821q && f18 != com.tencent.luggage.wxa.u.a.f141825s && f18 != com.tencent.luggage.wxa.u.a.f141831v && f18 != com.tencent.luggage.wxa.u.a.f141827t && f18 != com.tencent.luggage.wxa.u.a.f141829u && f18 != com.tencent.luggage.wxa.u.a.f141840z0 && f18 != com.tencent.luggage.wxa.u.a.A0 && f18 != com.tencent.luggage.wxa.u.a.f141813m && f18 != com.tencent.luggage.wxa.u.a.f141815n && f18 != com.tencent.luggage.wxa.u.a.f141809k && f18 != com.tencent.luggage.wxa.u.a.P0) {
                    if (f18 != com.tencent.luggage.wxa.u.a.f141810k0 && f18 != com.tencent.luggage.wxa.u.a.f141832v0 && f18 != com.tencent.luggage.wxa.u.a.f141834w0 && f18 != com.tencent.luggage.wxa.u.a.f141836x0 && f18 != com.tencent.luggage.wxa.u.a.f141838y0) {
                        if (f18 == com.tencent.luggage.wxa.u.a.O0) {
                            cVar.f141860b = com.tencent.luggage.wxa.m.j.a(Integer.toString(i3), "application/x-camera-motion", (String) null, -1, (com.tencent.luggage.wxa.p.a) null);
                        }
                    } else {
                        a(lVar, f18, c16, f17, i3, str, cVar);
                    }
                } else {
                    a(lVar, f18, c16, f17, i3, str, z16, aVar, cVar, i17);
                }
            } else {
                a(lVar, f18, c16, f17, i3, i16, aVar, cVar, i17);
            }
            lVar.e(c16 + f17);
        }
        return cVar;
    }

    public static void a(com.tencent.luggage.wxa.n0.l lVar, int i3, int i16, int i17, int i18, String str, c cVar) {
        lVar.e(i16 + 8 + 8);
        String str2 = "application/ttml+xml";
        List list = null;
        long j3 = Long.MAX_VALUE;
        if (i3 != com.tencent.luggage.wxa.u.a.f141810k0) {
            if (i3 == com.tencent.luggage.wxa.u.a.f141832v0) {
                int i19 = (i17 - 8) - 8;
                byte[] bArr = new byte[i19];
                lVar.a(bArr, 0, i19);
                list = Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i3 == com.tencent.luggage.wxa.u.a.f141834w0) {
                str2 = "application/x-mp4-vtt";
            } else if (i3 == com.tencent.luggage.wxa.u.a.f141836x0) {
                j3 = 0;
            } else if (i3 == com.tencent.luggage.wxa.u.a.f141838y0) {
                cVar.f141862d = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        cVar.f141860b = com.tencent.luggage.wxa.m.j.a(Integer.toString(i18), str2, (String) null, -1, 0, str, -1, (com.tencent.luggage.wxa.p.a) null, j3, list);
    }

    public static void a(com.tencent.luggage.wxa.n0.l lVar, int i3, int i16, int i17, int i18, int i19, com.tencent.luggage.wxa.p.a aVar, c cVar, int i26) {
        com.tencent.luggage.wxa.p.a aVar2 = aVar;
        lVar.e(i16 + 8 + 8);
        lVar.f(16);
        int w3 = lVar.w();
        int w16 = lVar.w();
        lVar.f(50);
        int c16 = lVar.c();
        String str = null;
        int i27 = i3;
        if (i27 == com.tencent.luggage.wxa.u.a.f141790a0) {
            Pair d16 = d(lVar, i16, i17);
            if (d16 != null) {
                i27 = ((Integer) d16.first).intValue();
                aVar2 = aVar2 == null ? null : aVar2.a(((k) d16.second).f141979b);
                cVar.f141859a[i26] = (k) d16.second;
            }
            lVar.e(c16);
        }
        com.tencent.luggage.wxa.p.a aVar3 = aVar2;
        float f16 = 1.0f;
        List list = null;
        byte[] bArr = null;
        int i28 = -1;
        boolean z16 = false;
        while (c16 - i16 < i17) {
            lVar.e(c16);
            int c17 = lVar.c();
            int f17 = lVar.f();
            if (f17 == 0 && lVar.c() - i16 == i17) {
                break;
            }
            int i29 = 1;
            com.tencent.luggage.wxa.n0.a.a(f17 > 0, "childAtomSize should be positive");
            int f18 = lVar.f();
            if (f18 == com.tencent.luggage.wxa.u.a.I) {
                com.tencent.luggage.wxa.n0.a.b(str == null);
                lVar.e(c17 + 8);
                com.tencent.luggage.wxa.o0.a b16 = com.tencent.luggage.wxa.o0.a.b(lVar);
                list = b16.f135959a;
                cVar.f141861c = b16.f135960b;
                if (!z16) {
                    f16 = b16.f135963e;
                }
                str = "video/avc";
            } else if (f18 == com.tencent.luggage.wxa.u.a.J) {
                com.tencent.luggage.wxa.n0.a.b(str == null);
                lVar.e(c17 + 8);
                com.tencent.luggage.wxa.o0.d a16 = com.tencent.luggage.wxa.o0.d.a(lVar);
                list = a16.f135983a;
                cVar.f141861c = a16.f135984b;
                str = "video/hevc";
            } else if (f18 == com.tencent.luggage.wxa.u.a.N0) {
                com.tencent.luggage.wxa.n0.a.b(str == null);
                str = i27 == com.tencent.luggage.wxa.u.a.L0 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
            } else if (f18 == com.tencent.luggage.wxa.u.a.f141803h) {
                com.tencent.luggage.wxa.n0.a.b(str == null);
                str = "video/3gpp";
            } else if (f18 == com.tencent.luggage.wxa.u.a.K) {
                com.tencent.luggage.wxa.n0.a.b(str == null);
                Pair a17 = a(lVar, c17);
                str = (String) a17.first;
                list = Collections.singletonList(a17.second);
            } else if (f18 == com.tencent.luggage.wxa.u.a.f141808j0) {
                f16 = d(lVar, c17);
                z16 = true;
            } else if (f18 == com.tencent.luggage.wxa.u.a.J0) {
                bArr = c(lVar, c17, f17);
            } else if (f18 == com.tencent.luggage.wxa.u.a.I0) {
                int q16 = lVar.q();
                lVar.f(3);
                if (q16 == 0) {
                    int q17 = lVar.q();
                    if (q17 != 0) {
                        if (q17 != 1) {
                            i29 = 2;
                            if (q17 != 2) {
                                if (q17 == 3) {
                                    i28 = 3;
                                }
                            }
                        }
                        i28 = i29;
                    } else {
                        i28 = 0;
                    }
                }
            }
            c16 += f17;
        }
        if (str == null) {
            return;
        }
        cVar.f141860b = com.tencent.luggage.wxa.m.j.a(Integer.toString(i18), str, (String) null, -1, -1, w3, w16, -1.0f, list, i19, f16, bArr, i28, (com.tencent.luggage.wxa.o0.b) null, aVar3);
    }

    public static Pair a(a.C6775a c6775a) {
        a.b e16;
        if (c6775a != null && (e16 = c6775a.e(com.tencent.luggage.wxa.u.a.R)) != null) {
            com.tencent.luggage.wxa.n0.l lVar = e16.Q0;
            lVar.e(8);
            int c16 = com.tencent.luggage.wxa.u.a.c(lVar.f());
            int u16 = lVar.u();
            long[] jArr = new long[u16];
            long[] jArr2 = new long[u16];
            for (int i3 = 0; i3 < u16; i3++) {
                jArr[i3] = c16 == 1 ? lVar.v() : lVar.s();
                jArr2[i3] = c16 == 1 ? lVar.m() : lVar.f();
                if (lVar.o() == 1) {
                    lVar.f(2);
                } else {
                    throw new IllegalArgumentException("Unsupported media rate.");
                }
            }
            return Pair.create(jArr, jArr2);
        }
        return Pair.create(null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(com.tencent.luggage.wxa.n0.l lVar, int i3, int i16, int i17, int i18, String str, boolean z16, com.tencent.luggage.wxa.p.a aVar, c cVar, int i19) {
        int i26;
        int r16;
        int i27;
        String str2;
        String str3;
        String str4;
        com.tencent.luggage.wxa.p.a aVar2;
        boolean z17;
        int i28;
        int i29;
        int i36;
        int i37 = i16;
        com.tencent.luggage.wxa.p.a aVar3 = aVar;
        lVar.e(i37 + 8 + 8);
        int i38 = 0;
        if (z16) {
            i26 = lVar.w();
            lVar.f(6);
        } else {
            lVar.f(8);
            i26 = 0;
        }
        int i39 = 2;
        boolean z18 = true;
        if (i26 == 0 || i26 == 1) {
            int w3 = lVar.w();
            lVar.f(6);
            r16 = lVar.r();
            if (i26 == 1) {
                lVar.f(16);
            }
            i27 = w3;
        } else {
            if (i26 != 2) {
                return;
            }
            lVar.f(16);
            r16 = (int) Math.round(lVar.e());
            i27 = lVar.u();
            lVar.f(20);
        }
        int c16 = lVar.c();
        int i46 = i3;
        if (i46 == com.tencent.luggage.wxa.u.a.f141792b0) {
            Pair d16 = d(lVar, i37, i17);
            if (d16 != null) {
                i46 = ((Integer) d16.first).intValue();
                aVar3 = aVar3 == null ? null : aVar3.a(((k) d16.second).f141979b);
                cVar.f141859a[i19] = (k) d16.second;
            }
            lVar.e(c16);
        }
        com.tencent.luggage.wxa.p.a aVar4 = aVar3;
        String str5 = "audio/raw";
        if (i46 == com.tencent.luggage.wxa.u.a.f141817o) {
            str2 = "audio/ac3";
        } else if (i46 == com.tencent.luggage.wxa.u.a.f141821q) {
            str2 = "audio/eac3";
        } else if (i46 == com.tencent.luggage.wxa.u.a.f141825s) {
            str2 = "audio/vnd.dts";
        } else if (i46 == com.tencent.luggage.wxa.u.a.f141827t || i46 == com.tencent.luggage.wxa.u.a.f141829u) {
            str2 = "audio/vnd.dts.hd";
        } else if (i46 == com.tencent.luggage.wxa.u.a.f141831v) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i46 == com.tencent.luggage.wxa.u.a.f141840z0) {
            str2 = "audio/3gpp";
        } else if (i46 == com.tencent.luggage.wxa.u.a.A0) {
            str2 = "audio/amr-wb";
        } else if (i46 == com.tencent.luggage.wxa.u.a.f141813m || i46 == com.tencent.luggage.wxa.u.a.f141815n) {
            str2 = "audio/raw";
        } else if (i46 == com.tencent.luggage.wxa.u.a.f141809k) {
            str2 = "audio/mpeg";
        } else {
            str2 = i46 == com.tencent.luggage.wxa.u.a.P0 ? "audio/alac" : null;
        }
        String str6 = str2;
        int i47 = r16;
        int i48 = i27;
        int i49 = c16;
        byte[] bArr = null;
        while (i49 - i37 < i17) {
            lVar.e(i49);
            int f16 = lVar.f();
            com.tencent.luggage.wxa.n0.a.a(f16 > 0 ? z18 : i38, "childAtomSize should be positive");
            int f17 = lVar.f();
            int i56 = com.tencent.luggage.wxa.u.a.K;
            if (f17 == i56) {
                str3 = str6;
                str4 = str5;
                aVar2 = aVar4;
                z17 = z18;
                i28 = i39;
                i29 = i38;
            } else if (z16 && f17 == com.tencent.luggage.wxa.u.a.f141811l) {
                str3 = str6;
                str4 = str5;
                aVar2 = aVar4;
                i28 = i39;
                i29 = i38;
                z17 = true;
            } else {
                if (f17 == com.tencent.luggage.wxa.u.a.f141819p) {
                    lVar.e(i49 + 8);
                    cVar.f141860b = com.tencent.luggage.wxa.n.a.a(lVar, Integer.toString(i18), str, aVar4);
                } else if (f17 == com.tencent.luggage.wxa.u.a.f141823r) {
                    lVar.e(i49 + 8);
                    cVar.f141860b = com.tencent.luggage.wxa.n.a.b(lVar, Integer.toString(i18), str, aVar4);
                } else {
                    if (f17 == com.tencent.luggage.wxa.u.a.f141833w) {
                        str3 = str6;
                        str4 = str5;
                        aVar2 = aVar4;
                        i36 = i49;
                        z17 = true;
                        i28 = i39;
                        i29 = i38;
                        cVar.f141860b = com.tencent.luggage.wxa.m.j.a(Integer.toString(i18), str6, null, -1, -1, i48, i47, null, aVar2, 0, str);
                        f16 = f16;
                    } else {
                        i36 = i49;
                        str3 = str6;
                        str4 = str5;
                        aVar2 = aVar4;
                        i28 = i39;
                        i29 = i38;
                        z17 = true;
                        if (f17 == com.tencent.luggage.wxa.u.a.P0) {
                            byte[] bArr2 = new byte[f16];
                            i49 = i36;
                            lVar.e(i49);
                            lVar.a(bArr2, i29, f16);
                            bArr = bArr2;
                            str6 = str3;
                            i49 += f16;
                            i38 = i29;
                            z18 = z17;
                            aVar4 = aVar2;
                            i39 = i28;
                            str5 = str4;
                            i37 = i16;
                        }
                    }
                    i49 = i36;
                    str6 = str3;
                    i49 += f16;
                    i38 = i29;
                    z18 = z17;
                    aVar4 = aVar2;
                    i39 = i28;
                    str5 = str4;
                    i37 = i16;
                }
                str3 = str6;
                str4 = str5;
                aVar2 = aVar4;
                i28 = i39;
                i29 = i38;
                z17 = true;
                str6 = str3;
                i49 += f16;
                i38 = i29;
                z18 = z17;
                aVar4 = aVar2;
                i39 = i28;
                str5 = str4;
                i37 = i16;
            }
            int a16 = f17 == i56 ? i49 : a(lVar, i49, f16);
            if (a16 != -1) {
                Pair a17 = a(lVar, a16);
                str6 = (String) a17.first;
                bArr = (byte[]) a17.second;
                if ("audio/mp4a-latm".equals(str6)) {
                    Pair a18 = com.tencent.luggage.wxa.n0.d.a(bArr);
                    i47 = ((Integer) a18.first).intValue();
                    i48 = ((Integer) a18.second).intValue();
                }
                i49 += f16;
                i38 = i29;
                z18 = z17;
                aVar4 = aVar2;
                i39 = i28;
                str5 = str4;
                i37 = i16;
            }
            str6 = str3;
            i49 += f16;
            i38 = i29;
            z18 = z17;
            aVar4 = aVar2;
            i39 = i28;
            str5 = str4;
            i37 = i16;
        }
        String str7 = str6;
        String str8 = str5;
        com.tencent.luggage.wxa.p.a aVar5 = aVar4;
        int i57 = i39;
        if (cVar.f141860b != null || str7 == null) {
            return;
        }
        cVar.f141860b = com.tencent.luggage.wxa.m.j.a(Integer.toString(i18), str7, (String) null, -1, -1, i48, i47, str8.equals(str7) ? i57 : -1, bArr != null ? Collections.singletonList(bArr) : null, aVar5, 0, str);
    }

    public static int a(com.tencent.luggage.wxa.n0.l lVar, int i3, int i16) {
        int c16 = lVar.c();
        while (c16 - i3 < i16) {
            lVar.e(c16);
            int f16 = lVar.f();
            com.tencent.luggage.wxa.n0.a.a(f16 > 0, "childAtomSize should be positive");
            if (lVar.f() == com.tencent.luggage.wxa.u.a.K) {
                return c16;
            }
            c16 += f16;
        }
        return -1;
    }

    public static Pair a(com.tencent.luggage.wxa.n0.l lVar, int i3) {
        String str;
        lVar.e(i3 + 8 + 4);
        lVar.f(1);
        a(lVar);
        lVar.f(2);
        int q16 = lVar.q();
        if ((q16 & 128) != 0) {
            lVar.f(2);
        }
        if ((q16 & 64) != 0) {
            lVar.f(lVar.w());
        }
        if ((q16 & 32) != 0) {
            lVar.f(2);
        }
        lVar.f(1);
        a(lVar);
        int q17 = lVar.q();
        if (q17 == 32) {
            str = "video/mp4v-es";
        } else if (q17 == 33) {
            str = "video/avc";
        } else if (q17 != 35) {
            if (q17 != 64) {
                str = null;
                if (q17 == 107) {
                    return Pair.create("audio/mpeg", null);
                }
                if (q17 == 96 || q17 == 97) {
                    str = "video/mpeg2";
                } else if (q17 == 165) {
                    str = "audio/ac3";
                } else if (q17 != 166) {
                    switch (q17) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (q17) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        lVar.f(12);
        lVar.f(1);
        int a16 = a(lVar);
        byte[] bArr = new byte[a16];
        lVar.a(bArr, 0, a16);
        return Pair.create(str, bArr);
    }

    public static k a(com.tencent.luggage.wxa.n0.l lVar, int i3, int i16, String str) {
        int i17;
        int i18;
        int i19 = i3 + 8;
        while (true) {
            byte[] bArr = null;
            if (i19 - i3 >= i16) {
                return null;
            }
            lVar.e(i19);
            int f16 = lVar.f();
            if (lVar.f() == com.tencent.luggage.wxa.u.a.Z) {
                int c16 = com.tencent.luggage.wxa.u.a.c(lVar.f());
                lVar.f(1);
                if (c16 == 0) {
                    lVar.f(1);
                    i18 = 0;
                    i17 = 0;
                } else {
                    int q16 = lVar.q();
                    i17 = q16 & 15;
                    i18 = (q16 & 240) >> 4;
                }
                boolean z16 = lVar.q() == 1;
                int q17 = lVar.q();
                byte[] bArr2 = new byte[16];
                lVar.a(bArr2, 0, 16);
                if (z16 && q17 == 0) {
                    int q18 = lVar.q();
                    bArr = new byte[q18];
                    lVar.a(bArr, 0, q18);
                }
                return new k(z16, str, q17, bArr2, i18, i17, bArr);
            }
            i19 += f16;
        }
    }

    public static int a(com.tencent.luggage.wxa.n0.l lVar) {
        int q16 = lVar.q();
        int i3 = q16 & 127;
        while ((q16 & 128) == 128) {
            q16 = lVar.q();
            i3 = (i3 << 7) | (q16 & 127);
        }
        return i3;
    }
}
