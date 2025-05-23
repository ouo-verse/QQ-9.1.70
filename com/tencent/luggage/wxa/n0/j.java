package com.tencent.luggage.wxa.n0;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f135067a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f135068b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c, reason: collision with root package name */
    public static final Object f135069c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static int[] f135070d = new int[10];

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f135071a;

        /* renamed from: b, reason: collision with root package name */
        public final int f135072b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f135073c;

        public a(int i3, int i16, boolean z16) {
            this.f135071a = i3;
            this.f135072b = i16;
            this.f135073c = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f135074a;

        /* renamed from: b, reason: collision with root package name */
        public final int f135075b;

        /* renamed from: c, reason: collision with root package name */
        public final int f135076c;

        /* renamed from: d, reason: collision with root package name */
        public final float f135077d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f135078e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f135079f;

        /* renamed from: g, reason: collision with root package name */
        public final int f135080g;

        /* renamed from: h, reason: collision with root package name */
        public final int f135081h;

        /* renamed from: i, reason: collision with root package name */
        public final int f135082i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f135083j;

        public b(int i3, int i16, int i17, float f16, boolean z16, boolean z17, int i18, int i19, int i26, boolean z18) {
            this.f135074a = i3;
            this.f135075b = i16;
            this.f135076c = i17;
            this.f135077d = f16;
            this.f135078e = z16;
            this.f135079f = z17;
            this.f135080g = i18;
            this.f135081h = i19;
            this.f135082i = i26;
            this.f135083j = z18;
        }
    }

    public static void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            int i17 = i3 + 1;
            if (i17 < position) {
                int i18 = byteBuffer.get(i3) & 255;
                if (i16 == 3) {
                    if (i18 == 1 && (byteBuffer.get(i17) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i3 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i18 == 0) {
                    i16++;
                }
                if (i18 != 0) {
                    i16 = 0;
                }
                i3 = i17;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static int b(byte[] bArr, int i3) {
        return bArr[i3 + 3] & 31;
    }

    public static int c(byte[] bArr, int i3) {
        int i16;
        synchronized (f135069c) {
            int i17 = 0;
            int i18 = 0;
            while (i17 < i3) {
                try {
                    i17 = a(bArr, i17, i3);
                    if (i17 < i3) {
                        int[] iArr = f135070d;
                        if (iArr.length <= i18) {
                            f135070d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f135070d[i18] = i17;
                        i17 += 3;
                        i18++;
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            i16 = i3 - i18;
            int i19 = 0;
            int i26 = 0;
            for (int i27 = 0; i27 < i18; i27++) {
                int i28 = f135070d[i27] - i19;
                System.arraycopy(bArr, i19, bArr, i26, i28);
                int i29 = i26 + i28;
                int i36 = i29 + 1;
                bArr[i29] = 0;
                i26 = i36 + 1;
                bArr[i36] = 0;
                i19 += i28 + 3;
            }
            System.arraycopy(bArr, i19, bArr, i26, i16 - i26);
        }
        return i16;
    }

    public static a b(byte[] bArr, int i3, int i16) {
        m mVar = new m(bArr, i3, i16);
        mVar.d(8);
        int f16 = mVar.f();
        int f17 = mVar.f();
        mVar.g();
        return new a(f16, f17, mVar.c());
    }

    public static boolean a(String str, byte b16) {
        if ("video/avc".equals(str) && (b16 & 31) == 6) {
            return true;
        }
        return "video/hevc".equals(str) && ((b16 & 126) >> 1) == 39;
    }

    public static int a(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 126) >> 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0093, code lost:
    
        r9 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(byte[] bArr, int i3, int i16, boolean[] zArr) {
        int i17 = i16 - i3;
        com.tencent.luggage.wxa.n0.a.b(i17 >= 0);
        if (i17 == 0) {
            return i16;
        }
        if (zArr != null) {
            if (zArr[0]) {
                a(zArr);
                return i3 - 3;
            }
            if (i17 > 1 && zArr[1] && bArr[i3] == 1) {
                a(zArr);
                return i3 - 2;
            }
            if (i17 > 2 && zArr[2] && bArr[i3] == 0 && bArr[i3 + 1] == 1) {
                a(zArr);
                return i3 - 1;
            }
        }
        int i18 = i16 - 1;
        int i19 = i3 + 2;
        while (i19 < i18) {
            byte b16 = bArr[i19];
            if ((b16 & 254) == 0) {
                int i26 = i19 - 2;
                if (bArr[i26] == 0 && bArr[i19 - 1] == 0 && b16 == 1) {
                    if (zArr != null) {
                        a(zArr);
                    }
                    return i26;
                }
                i19 -= 2;
            }
            i19 += 3;
        }
        if (zArr != null) {
            boolean z16 = i17 > 2 ? false : false;
            zArr[0] = z16;
            zArr[1] = i17 <= 1 ? zArr[2] && bArr[i18] == 0 : bArr[i16 + (-2)] == 0 && bArr[i18] == 0;
            zArr[2] = bArr[i18] == 0;
        }
        return i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b c(byte[] bArr, int i3, int i16) {
        int f16;
        boolean z16;
        boolean z17;
        int i17;
        boolean z18;
        boolean c16;
        float f17;
        float f18;
        int b16;
        m mVar = new m(bArr, i3, i16);
        mVar.d(8);
        int b17 = mVar.b(8);
        mVar.d(16);
        int f19 = mVar.f();
        if (b17 == 100 || b17 == 110 || b17 == 122 || b17 == 244 || b17 == 44 || b17 == 83 || b17 == 86 || b17 == 118 || b17 == 128 || b17 == 138) {
            f16 = mVar.f();
            boolean c17 = f16 == 3 ? mVar.c() : false;
            mVar.f();
            mVar.f();
            mVar.g();
            if (mVar.c()) {
                int i18 = f16 != 3 ? 8 : 12;
                int i19 = 0;
                while (i19 < i18) {
                    if (mVar.c()) {
                        a(mVar, i19 < 6 ? 16 : 64);
                    }
                    i19++;
                }
            }
            z16 = c17;
        } else {
            f16 = 1;
            z16 = false;
        }
        int f26 = mVar.f() + 4;
        int f27 = mVar.f();
        if (f27 == 0) {
            i17 = mVar.f() + 4;
            z17 = z16;
        } else {
            if (f27 == 1) {
                boolean c18 = mVar.c();
                mVar.e();
                mVar.e();
                long f28 = mVar.f();
                z17 = z16;
                for (int i26 = 0; i26 < f28; i26++) {
                    mVar.f();
                }
                z18 = c18;
                i17 = 0;
                mVar.f();
                mVar.g();
                int f29 = mVar.f() + 1;
                int f36 = mVar.f() + 1;
                c16 = mVar.c();
                int i27 = 2 - (c16 ? 1 : 0);
                int i28 = f36 * i27;
                if (!c16) {
                    mVar.g();
                }
                mVar.g();
                int i29 = f29 * 16;
                int i36 = i28 * 16;
                if (mVar.c()) {
                    int f37 = mVar.f();
                    int f38 = mVar.f();
                    int f39 = mVar.f();
                    int f46 = mVar.f();
                    if (f16 != 0) {
                        int i37 = f16 == 3 ? 1 : 2;
                        i27 *= f16 == 1 ? 2 : 1;
                        r7 = i37;
                    }
                    i29 -= (f37 + f38) * r7;
                    i36 -= (f39 + f46) * i27;
                }
                int i38 = i29;
                int i39 = i36;
                if (mVar.c() && mVar.c()) {
                    b16 = mVar.b(8);
                    if (b16 != 255) {
                        int b18 = mVar.b(16);
                        int b19 = mVar.b(16);
                        if (b18 != 0 && b19 != 0) {
                            f18 = b18 / b19;
                            return new b(f19, i38, i39, f18, z17, c16, f26, f27, i17, z18);
                        }
                    } else {
                        float[] fArr = f135068b;
                        if (b16 < fArr.length) {
                            f17 = fArr[b16];
                            f18 = f17;
                            return new b(f19, i38, i39, f18, z17, c16, f26, f27, i17, z18);
                        }
                        Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + b16);
                    }
                }
                f17 = 1.0f;
                f18 = f17;
                return new b(f19, i38, i39, f18, z17, c16, f26, f27, i17, z18);
            }
            z17 = z16;
            i17 = 0;
        }
        z18 = false;
        mVar.f();
        mVar.g();
        int f292 = mVar.f() + 1;
        int f362 = mVar.f() + 1;
        c16 = mVar.c();
        int i272 = 2 - (c16 ? 1 : 0);
        int i282 = f362 * i272;
        if (!c16) {
        }
        mVar.g();
        int i292 = f292 * 16;
        int i362 = i282 * 16;
        if (mVar.c()) {
        }
        int i382 = i292;
        int i392 = i362;
        if (mVar.c()) {
            b16 = mVar.b(8);
            if (b16 != 255) {
            }
        }
        f17 = 1.0f;
        f18 = f17;
        return new b(f19, i382, i392, f18, z17, c16, f26, f27, i17, z18);
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int a(byte[] bArr, int i3, int i16) {
        while (i3 < i16 - 2) {
            if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                return i3;
            }
            i3++;
        }
        return i16;
    }

    public static void a(m mVar, int i3) {
        int i16 = 8;
        int i17 = 8;
        for (int i18 = 0; i18 < i3; i18++) {
            if (i16 != 0) {
                i16 = ((mVar.e() + i17) + 256) % 256;
            }
            if (i16 != 0) {
                i17 = i16;
            }
        }
    }
}
