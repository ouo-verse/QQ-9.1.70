package com.tencent.luggage.wxa.uk;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f142759a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f142760b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f142761c;

    /* renamed from: d, reason: collision with root package name */
    public int f142762d;

    /* renamed from: e, reason: collision with root package name */
    public int f142763e;

    /* renamed from: f, reason: collision with root package name */
    public int f142764f;

    /* renamed from: g, reason: collision with root package name */
    public int f142765g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f142766h;

    /* renamed from: j, reason: collision with root package name */
    public int f142768j;

    /* renamed from: i, reason: collision with root package name */
    public boolean f142767i = true;

    /* renamed from: k, reason: collision with root package name */
    public Random f142769k = new Random();

    public static long b(byte[] bArr, int i3, int i16) {
        long j3 = 0;
        int i17 = i16 > 4 ? i3 + 4 : i16 + i3;
        while (i3 < i17) {
            j3 = (j3 << 8) | (bArr[i3] & 255);
            i3++;
        }
        return 4294967295L & j3;
    }

    public final byte[] a(byte[] bArr, int i3, int i16, byte[] bArr2) {
        int i17 = 0;
        this.f142763e = 0;
        this.f142762d = 0;
        this.f142766h = bArr2;
        int i18 = i3 + 8;
        byte[] bArr3 = new byte[i18];
        if (i16 % 8 != 0 || i16 < 16) {
            return null;
        }
        byte[] a16 = a(bArr, i3);
        this.f142760b = a16;
        if (a16 == null) {
            return null;
        }
        int i19 = a16[0] & 7;
        this.f142764f = i19;
        int i26 = (i16 - i19) - 10;
        if (i26 < 0) {
            return null;
        }
        for (int i27 = i3; i27 < i18; i27++) {
            bArr3[i27] = 0;
        }
        this.f142761c = new byte[i26];
        this.f142763e = 0;
        this.f142762d = 8;
        this.f142768j = 8;
        this.f142764f++;
        this.f142765g = 1;
        while (true) {
            int i28 = this.f142765g;
            if (i28 <= 2) {
                int i29 = this.f142764f;
                if (i29 < 8) {
                    this.f142764f = i29 + 1;
                    this.f142765g = i28 + 1;
                }
                if (this.f142764f == 8) {
                    if (!a(bArr, i3, i16)) {
                        return null;
                    }
                    bArr3 = bArr;
                }
            } else {
                while (i26 != 0) {
                    int i36 = this.f142764f;
                    if (i36 < 8) {
                        this.f142761c[i17] = (byte) (bArr3[(this.f142763e + i3) + i36] ^ this.f142760b[i36]);
                        i17++;
                        i26--;
                        this.f142764f = i36 + 1;
                    }
                    if (this.f142764f == 8) {
                        this.f142763e = this.f142762d - 8;
                        if (!a(bArr, i3, i16)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                }
                this.f142765g = 1;
                while (this.f142765g < 8) {
                    int i37 = this.f142764f;
                    if (i37 < 8) {
                        if ((bArr3[(this.f142763e + i3) + i37] ^ this.f142760b[i37]) != 0) {
                            return null;
                        }
                        this.f142764f = i37 + 1;
                    }
                    if (this.f142764f == 8) {
                        this.f142763e = this.f142762d;
                        if (!a(bArr, i3, i16)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                    this.f142765g++;
                }
                return this.f142761c;
            }
        }
    }

    public final byte[] b(byte[] bArr, int i3, int i16, byte[] bArr2) {
        int i17;
        byte[] bArr3 = new byte[8];
        this.f142759a = bArr3;
        this.f142760b = new byte[8];
        this.f142764f = 1;
        this.f142765g = 0;
        this.f142763e = 0;
        this.f142762d = 0;
        this.f142766h = bArr2;
        this.f142767i = true;
        int i18 = (i16 + 10) % 8;
        this.f142764f = i18;
        if (i18 != 0) {
            this.f142764f = 8 - i18;
        }
        this.f142761c = new byte[this.f142764f + i16 + 10];
        bArr3[0] = (byte) ((b() & 248) | this.f142764f);
        int i19 = 1;
        while (true) {
            i17 = this.f142764f;
            if (i19 > i17) {
                break;
            }
            this.f142759a[i19] = (byte) (b() & 255);
            i19++;
        }
        this.f142764f = i17 + 1;
        for (int i26 = 0; i26 < 8; i26++) {
            this.f142760b[i26] = 0;
        }
        this.f142765g = 1;
        while (this.f142765g <= 2) {
            int i27 = this.f142764f;
            if (i27 < 8) {
                byte[] bArr4 = this.f142759a;
                this.f142764f = i27 + 1;
                bArr4[i27] = (byte) (b() & 255);
                this.f142765g++;
            }
            if (this.f142764f == 8) {
                a();
            }
        }
        while (i16 > 0) {
            int i28 = this.f142764f;
            if (i28 < 8) {
                byte[] bArr5 = this.f142759a;
                this.f142764f = i28 + 1;
                bArr5[i28] = bArr[i3];
                i16--;
                i3++;
            }
            if (this.f142764f == 8) {
                a();
            }
        }
        this.f142765g = 1;
        while (true) {
            int i29 = this.f142765g;
            if (i29 <= 7) {
                int i36 = this.f142764f;
                if (i36 < 8) {
                    byte[] bArr6 = this.f142759a;
                    this.f142764f = i36 + 1;
                    bArr6[i36] = 0;
                    this.f142765g = i29 + 1;
                }
                if (this.f142764f == 8) {
                    a();
                }
            } else {
                return this.f142761c;
            }
        }
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 0, bArr.length, bArr2);
    }

    public final byte[] a(byte[] bArr, int i3) {
        try {
            long b16 = b(bArr, i3, 4);
            long b17 = b(bArr, i3 + 4, 4);
            long b18 = b(this.f142766h, 0, 4);
            long b19 = b(this.f142766h, 4, 4);
            long b26 = b(this.f142766h, 8, 4);
            long b27 = b(this.f142766h, 12, 4);
            int i16 = 16;
            long j3 = 3816266640L;
            while (true) {
                int i17 = i16 - 1;
                if (i16 <= 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) b16);
                    dataOutputStream.writeInt((int) b17);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                b17 = (b17 - ((((b16 << 4) + b26) ^ (b16 + j3)) ^ ((b16 >>> 5) + b27))) & 4294967295L;
                b16 = (b16 - ((((b17 << 4) + b18) ^ (b17 + j3)) ^ ((b17 >>> 5) + b19))) & 4294967295L;
                j3 = (j3 - 2654435769L) & 4294967295L;
                i16 = i17;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        return b(bArr, 0, bArr.length, bArr2);
    }

    public final byte[] b(byte[] bArr) {
        try {
            long b16 = b(bArr, 0, 4);
            long b17 = b(bArr, 4, 4);
            long b18 = b(this.f142766h, 0, 4);
            long b19 = b(this.f142766h, 4, 4);
            long b26 = b(this.f142766h, 8, 4);
            long b27 = b(this.f142766h, 12, 4);
            int i3 = 16;
            long j3 = 0;
            while (true) {
                int i16 = i3 - 1;
                if (i3 <= 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) b16);
                    dataOutputStream.writeInt((int) b17);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                j3 = (j3 + 2654435769L) & 4294967295L;
                b16 = (b16 + ((((b17 << 4) + b18) ^ (b17 + j3)) ^ ((b17 >>> 5) + b19))) & 4294967295L;
                b17 = (b17 + ((((b16 << 4) + b26) ^ (b16 + j3)) ^ ((b16 >>> 5) + b27))) & 4294967295L;
                i3 = i16;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final byte[] a(byte[] bArr) {
        return a(bArr, 0);
    }

    public final void a() {
        this.f142764f = 0;
        while (true) {
            int i3 = this.f142764f;
            if (i3 >= 8) {
                break;
            }
            if (this.f142767i) {
                byte[] bArr = this.f142759a;
                bArr[i3] = (byte) (bArr[i3] ^ this.f142760b[i3]);
            } else {
                byte[] bArr2 = this.f142759a;
                bArr2[i3] = (byte) (bArr2[i3] ^ this.f142761c[this.f142763e + i3]);
            }
            this.f142764f = i3 + 1;
        }
        System.arraycopy(b(this.f142759a), 0, this.f142761c, this.f142762d, 8);
        this.f142764f = 0;
        while (true) {
            int i16 = this.f142764f;
            if (i16 < 8) {
                byte[] bArr3 = this.f142761c;
                int i17 = this.f142762d + i16;
                bArr3[i17] = (byte) (bArr3[i17] ^ this.f142760b[i16]);
                this.f142764f = i16 + 1;
            } else {
                System.arraycopy(this.f142759a, 0, this.f142760b, 0, 8);
                int i18 = this.f142762d;
                this.f142763e = i18;
                this.f142762d = i18 + 8;
                this.f142764f = 0;
                this.f142767i = false;
                return;
            }
        }
    }

    public final int b() {
        return this.f142769k.nextInt();
    }

    public final boolean a(byte[] bArr, int i3, int i16) {
        this.f142764f = 0;
        while (true) {
            int i17 = this.f142764f;
            if (i17 < 8) {
                if (this.f142768j + i17 >= i16) {
                    return true;
                }
                byte[] bArr2 = this.f142760b;
                bArr2[i17] = (byte) (bArr2[i17] ^ bArr[(this.f142762d + i3) + i17]);
                this.f142764f = i17 + 1;
            } else {
                byte[] a16 = a(this.f142760b);
                this.f142760b = a16;
                if (a16 == null) {
                    return false;
                }
                this.f142768j += 8;
                this.f142762d += 8;
                this.f142764f = 0;
                return true;
            }
        }
    }
}
