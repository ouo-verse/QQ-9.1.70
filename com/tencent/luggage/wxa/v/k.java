package com.tencent.luggage.wxa.v;

import android.util.Log;
import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.l;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f142916a;

        /* renamed from: b, reason: collision with root package name */
        public final int f142917b;

        /* renamed from: c, reason: collision with root package name */
        public final long[] f142918c;

        /* renamed from: d, reason: collision with root package name */
        public final int f142919d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f142920e;

        public a(int i3, int i16, long[] jArr, int i17, boolean z16) {
            this.f142916a = i3;
            this.f142917b = i16;
            this.f142918c = jArr;
            this.f142919d = i17;
            this.f142920e = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f142921a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f142922b;

        /* renamed from: c, reason: collision with root package name */
        public final int f142923c;

        public b(String str, String[] strArr, int i3) {
            this.f142921a = str;
            this.f142922b = strArr;
            this.f142923c = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f142924a;

        /* renamed from: b, reason: collision with root package name */
        public final int f142925b;

        /* renamed from: c, reason: collision with root package name */
        public final int f142926c;

        /* renamed from: d, reason: collision with root package name */
        public final int f142927d;

        public c(boolean z16, int i3, int i16, int i17) {
            this.f142924a = z16;
            this.f142925b = i3;
            this.f142926c = i16;
            this.f142927d = i17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final long f142928a;

        /* renamed from: b, reason: collision with root package name */
        public final int f142929b;

        /* renamed from: c, reason: collision with root package name */
        public final long f142930c;

        /* renamed from: d, reason: collision with root package name */
        public final int f142931d;

        /* renamed from: e, reason: collision with root package name */
        public final int f142932e;

        /* renamed from: f, reason: collision with root package name */
        public final int f142933f;

        /* renamed from: g, reason: collision with root package name */
        public final int f142934g;

        /* renamed from: h, reason: collision with root package name */
        public final int f142935h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f142936i;

        /* renamed from: j, reason: collision with root package name */
        public final byte[] f142937j;

        public d(long j3, int i3, long j16, int i16, int i17, int i18, int i19, int i26, boolean z16, byte[] bArr) {
            this.f142928a = j3;
            this.f142929b = i3;
            this.f142930c = j16;
            this.f142931d = i16;
            this.f142932e = i17;
            this.f142933f = i18;
            this.f142934g = i19;
            this.f142935h = i26;
            this.f142936i = z16;
            this.f142937j = bArr;
        }
    }

    public static int a(int i3) {
        int i16 = 0;
        while (i3 > 0) {
            i16++;
            i3 >>>= 1;
        }
        return i16;
    }

    public static d b(l lVar) {
        a(1, lVar, false);
        long j3 = lVar.j();
        int q16 = lVar.q();
        long j16 = lVar.j();
        int h16 = lVar.h();
        int h17 = lVar.h();
        int h18 = lVar.h();
        int q17 = lVar.q();
        return new d(j3, q16, j16, h16, h17, h18, (int) Math.pow(2.0d, q17 & 15), (int) Math.pow(2.0d, (q17 & 240) >> 4), (lVar.q() & 1) > 0, Arrays.copyOf(lVar.f135088a, lVar.d()));
    }

    public static c[] c(i iVar) {
        int a16 = iVar.a(6) + 1;
        c[] cVarArr = new c[a16];
        for (int i3 = 0; i3 < a16; i3++) {
            cVarArr[i3] = new c(iVar.c(), iVar.a(16), iVar.a(16), iVar.a(8));
        }
        return cVarArr;
    }

    public static void d(i iVar) {
        int i3;
        int a16 = iVar.a(6) + 1;
        for (int i16 = 0; i16 < a16; i16++) {
            if (iVar.a(16) <= 2) {
                iVar.b(24);
                iVar.b(24);
                iVar.b(24);
                int a17 = iVar.a(6) + 1;
                iVar.b(8);
                int[] iArr = new int[a17];
                for (int i17 = 0; i17 < a17; i17++) {
                    int a18 = iVar.a(3);
                    if (iVar.c()) {
                        i3 = iVar.a(5);
                    } else {
                        i3 = 0;
                    }
                    iArr[i17] = (i3 * 8) + a18;
                }
                for (int i18 = 0; i18 < a17; i18++) {
                    for (int i19 = 0; i19 < 8; i19++) {
                        if ((iArr[i18] & (1 << i19)) != 0) {
                            iVar.b(8);
                        }
                    }
                }
            } else {
                throw new o("residueType greater than 2 is not decodable");
            }
        }
    }

    public static b a(l lVar) {
        a(3, lVar, false);
        String b16 = lVar.b((int) lVar.j());
        int length = b16.length() + 11;
        long j3 = lVar.j();
        String[] strArr = new String[(int) j3];
        int i3 = length + 4;
        for (int i16 = 0; i16 < j3; i16++) {
            String b17 = lVar.b((int) lVar.j());
            strArr[i16] = b17;
            i3 = i3 + 4 + b17.length();
        }
        if ((lVar.q() & 1) != 0) {
            return new b(b16, strArr, i3 + 1);
        }
        throw new o("framing bit expected to be set");
    }

    public static boolean a(int i3, l lVar, boolean z16) {
        if (lVar.a() < 7) {
            if (z16) {
                return false;
            }
            throw new o("too short header: " + lVar.a());
        }
        if (lVar.q() != i3) {
            if (z16) {
                return false;
            }
            throw new o("expected header type " + Integer.toHexString(i3));
        }
        if (lVar.q() == 118 && lVar.q() == 111 && lVar.q() == 114 && lVar.q() == 98 && lVar.q() == 105 && lVar.q() == 115) {
            return true;
        }
        if (z16) {
            return false;
        }
        throw new o("expected characters 'vorbis'");
    }

    public static void b(i iVar) {
        int a16 = iVar.a(6) + 1;
        for (int i3 = 0; i3 < a16; i3++) {
            int a17 = iVar.a(16);
            if (a17 == 0) {
                iVar.b(8);
                iVar.b(16);
                iVar.b(16);
                iVar.b(6);
                iVar.b(8);
                int a18 = iVar.a(4) + 1;
                for (int i16 = 0; i16 < a18; i16++) {
                    iVar.b(8);
                }
            } else if (a17 == 1) {
                int a19 = iVar.a(5);
                int[] iArr = new int[a19];
                int i17 = -1;
                for (int i18 = 0; i18 < a19; i18++) {
                    int a26 = iVar.a(4);
                    iArr[i18] = a26;
                    if (a26 > i17) {
                        i17 = a26;
                    }
                }
                int i19 = i17 + 1;
                int[] iArr2 = new int[i19];
                for (int i26 = 0; i26 < i19; i26++) {
                    iArr2[i26] = iVar.a(3) + 1;
                    int a27 = iVar.a(2);
                    if (a27 > 0) {
                        iVar.b(8);
                    }
                    for (int i27 = 0; i27 < (1 << a27); i27++) {
                        iVar.b(8);
                    }
                }
                iVar.b(2);
                int a28 = iVar.a(4);
                int i28 = 0;
                int i29 = 0;
                for (int i36 = 0; i36 < a19; i36++) {
                    i28 += iArr2[iArr[i36]];
                    while (i29 < i28) {
                        iVar.b(a28);
                        i29++;
                    }
                }
            } else {
                throw new o("floor type greater than 1 not decodable: " + a17);
            }
        }
    }

    public static c[] a(l lVar, int i3) {
        a(5, lVar, false);
        int q16 = lVar.q() + 1;
        i iVar = new i(lVar.f135088a);
        iVar.b(lVar.c() * 8);
        for (int i16 = 0; i16 < q16; i16++) {
            a(iVar);
        }
        int a16 = iVar.a(6) + 1;
        for (int i17 = 0; i17 < a16; i17++) {
            if (iVar.a(16) != 0) {
                throw new o("placeholder of time domain transforms not zeroed out");
            }
        }
        b(iVar);
        d(iVar);
        a(i3, iVar);
        c[] c16 = c(iVar);
        if (iVar.c()) {
            return c16;
        }
        throw new o("framing bit after modes not set as expected");
    }

    public static void a(int i3, i iVar) {
        int a16 = iVar.a(6) + 1;
        for (int i16 = 0; i16 < a16; i16++) {
            int a17 = iVar.a(16);
            if (a17 != 0) {
                Log.e("VorbisUtil", "mapping type other than 0 not supported: " + a17);
            } else {
                int a18 = iVar.c() ? iVar.a(4) + 1 : 1;
                if (iVar.c()) {
                    int a19 = iVar.a(8) + 1;
                    for (int i17 = 0; i17 < a19; i17++) {
                        int i18 = i3 - 1;
                        iVar.b(a(i18));
                        iVar.b(a(i18));
                    }
                }
                if (iVar.a(2) != 0) {
                    throw new o("to reserved bits must be zero after mapping coupling steps");
                }
                if (a18 > 1) {
                    for (int i19 = 0; i19 < i3; i19++) {
                        iVar.b(4);
                    }
                }
                for (int i26 = 0; i26 < a18; i26++) {
                    iVar.b(8);
                    iVar.b(8);
                    iVar.b(8);
                }
            }
        }
    }

    public static a a(i iVar) {
        if (iVar.a(24) == 5653314) {
            int a16 = iVar.a(16);
            int a17 = iVar.a(24);
            long[] jArr = new long[a17];
            boolean c16 = iVar.c();
            long j3 = 0;
            if (!c16) {
                boolean c17 = iVar.c();
                for (int i3 = 0; i3 < a17; i3++) {
                    if (c17) {
                        if (iVar.c()) {
                            jArr[i3] = iVar.a(5) + 1;
                        } else {
                            jArr[i3] = 0;
                        }
                    } else {
                        jArr[i3] = iVar.a(5) + 1;
                    }
                }
            } else {
                int a18 = iVar.a(5) + 1;
                int i16 = 0;
                while (i16 < a17) {
                    int a19 = iVar.a(a(a17 - i16));
                    for (int i17 = 0; i17 < a19 && i16 < a17; i17++) {
                        jArr[i16] = a18;
                        i16++;
                    }
                    a18++;
                }
            }
            int a26 = iVar.a(4);
            if (a26 <= 2) {
                if (a26 == 1 || a26 == 2) {
                    iVar.b(32);
                    iVar.b(32);
                    int a27 = iVar.a(4) + 1;
                    iVar.b(1);
                    if (a26 != 1) {
                        j3 = a17 * a16;
                    } else if (a16 != 0) {
                        j3 = a(a17, a16);
                    }
                    iVar.b((int) (j3 * a27));
                }
                return new a(a16, a17, jArr, a26, c16);
            }
            throw new o("lookup type greater than 2 not decodable: " + a26);
        }
        throw new o("expected code book to start with [0x56, 0x43, 0x42] at " + iVar.b());
    }

    public static long a(long j3, long j16) {
        return (long) Math.floor(Math.pow(j3, 1.0d / j16));
    }
}
