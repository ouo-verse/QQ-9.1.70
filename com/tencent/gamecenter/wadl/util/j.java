package com.tencent.gamecenter.wadl.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f107668a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f107669b;

    /* renamed from: c, reason: collision with root package name */
    private int f107670c;

    /* renamed from: d, reason: collision with root package name */
    private int f107671d;

    /* renamed from: e, reason: collision with root package name */
    private int f107672e;

    /* renamed from: f, reason: collision with root package name */
    private int f107673f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f107674g;

    /* renamed from: i, reason: collision with root package name */
    private int f107676i;

    /* renamed from: h, reason: collision with root package name */
    private boolean f107675h = true;

    /* renamed from: j, reason: collision with root package name */
    private Random f107677j = new Random();

    private byte[] a(byte[] bArr) {
        return b(bArr, 0);
    }

    private byte[] b(byte[] bArr, int i3) {
        try {
            long f16 = f(bArr, i3, 4);
            long f17 = f(bArr, i3 + 4, 4);
            long f18 = f(this.f107674g, 0, 4);
            long f19 = f(this.f107674g, 4, 4);
            long f26 = f(this.f107674g, 8, 4);
            long f27 = f(this.f107674g, 12, 4);
            int i16 = 16;
            long j3 = 3816266640L;
            while (true) {
                int i17 = i16 - 1;
                if (i16 > 0) {
                    f17 = (f17 - ((((f16 << 4) + f26) ^ (f16 + j3)) ^ ((f16 >>> 5) + f27))) & 4294967295L;
                    f16 = (f16 - ((((f17 << 4) + f18) ^ (f17 + j3)) ^ ((f17 >>> 5) + f19))) & 4294967295L;
                    j3 = (j3 - 2654435769L) & 4294967295L;
                    i16 = i17;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) f16);
                    dataOutputStream.writeInt((int) f17);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private byte[] c(byte[] bArr, int i3, int i16, byte[] bArr2) {
        int i17 = 0;
        this.f107671d = 0;
        this.f107670c = 0;
        this.f107674g = bArr2;
        byte[] bArr3 = new byte[i3 + 8];
        if (!h(bArr, i3, i16)) {
            return null;
        }
        int i18 = this.f107668a[0] & 7;
        this.f107672e = i18;
        int i19 = (i16 - i18) - 10;
        if (i19 < 0) {
            return null;
        }
        i(bArr3, i3, i19);
        byte[] g16 = g(bArr3, bArr, i3, i16);
        if (g16 == null) {
            return null;
        }
        while (i19 != 0) {
            int i26 = this.f107672e;
            if (i26 < 8) {
                this.f107669b[i17] = (byte) (g16[(this.f107671d + i3) + i26] ^ this.f107668a[i26]);
                i17++;
                i19--;
                this.f107672e = i26 + 1;
            }
            if (this.f107672e == 8) {
                this.f107671d = this.f107670c - 8;
                if (!e(bArr, i3, i16)) {
                    return null;
                }
                g16 = bArr;
            }
        }
        this.f107673f = 1;
        while (this.f107673f < 8) {
            int i27 = this.f107672e;
            if (i27 < 8) {
                if ((g16[(this.f107671d + i3) + i27] ^ this.f107668a[i27]) != 0) {
                    return null;
                }
                this.f107672e = i27 + 1;
            }
            if (this.f107672e == 8) {
                this.f107671d = this.f107670c;
                if (!e(bArr, i3, i16)) {
                    return null;
                }
                g16 = bArr;
            }
            this.f107673f++;
        }
        return this.f107669b;
    }

    private boolean e(byte[] bArr, int i3, int i16) {
        this.f107672e = 0;
        while (true) {
            int i17 = this.f107672e;
            if (i17 < 8) {
                if (this.f107676i + i17 >= i16) {
                    return true;
                }
                byte[] bArr2 = this.f107668a;
                bArr2[i17] = (byte) (bArr2[i17] ^ bArr[(this.f107670c + i3) + i17]);
                this.f107672e = i17 + 1;
            } else {
                byte[] a16 = a(this.f107668a);
                this.f107668a = a16;
                if (a16 == null) {
                    return false;
                }
                this.f107676i += 8;
                this.f107670c += 8;
                this.f107672e = 0;
                return true;
            }
        }
    }

    public static long f(byte[] bArr, int i3, int i16) {
        int i17;
        if (i16 > 4) {
            i17 = i3 + 4;
        } else {
            i17 = i16 + i3;
        }
        long j3 = 0;
        while (i3 < i17) {
            j3 = (j3 << 8) | (bArr[i3] & 255);
            i3++;
        }
        return 4294967295L & j3;
    }

    private byte[] g(byte[] bArr, byte[] bArr2, int i3, int i16) {
        do {
            int i17 = this.f107673f;
            if (i17 <= 2) {
                int i18 = this.f107672e;
                if (i18 < 8) {
                    this.f107672e = i18 + 1;
                    this.f107673f = i17 + 1;
                }
            } else {
                return bArr;
            }
        } while (this.f107672e != 8);
        if (!e(bArr2, i3, i16)) {
            return null;
        }
        return bArr2;
    }

    private boolean h(byte[] bArr, int i3, int i16) {
        if (i16 % 8 != 0 || i16 < 16) {
            return false;
        }
        byte[] b16 = b(bArr, i3);
        this.f107668a = b16;
        if (b16 == null) {
            return false;
        }
        return true;
    }

    private void i(byte[] bArr, int i3, int i16) {
        while (i3 < bArr.length) {
            bArr[i3] = 0;
            i3++;
        }
        this.f107669b = new byte[i16];
        this.f107671d = 0;
        this.f107670c = 8;
        this.f107676i = 8;
        this.f107672e++;
        this.f107673f = 1;
    }

    public byte[] d(byte[] bArr, byte[] bArr2) {
        return c(bArr, 0, bArr.length, bArr2);
    }
}
