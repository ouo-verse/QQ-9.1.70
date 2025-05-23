package com.tencent.tmassistantbase.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected byte[] f380448a;

    /* renamed from: b, reason: collision with root package name */
    protected byte[] f380449b;

    /* renamed from: c, reason: collision with root package name */
    protected byte[] f380450c;

    /* renamed from: d, reason: collision with root package name */
    protected int f380451d;

    /* renamed from: e, reason: collision with root package name */
    protected int f380452e;

    /* renamed from: f, reason: collision with root package name */
    protected int f380453f;

    /* renamed from: g, reason: collision with root package name */
    protected int f380454g;

    /* renamed from: h, reason: collision with root package name */
    protected byte[] f380455h;

    /* renamed from: j, reason: collision with root package name */
    protected int f380457j;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f380456i = true;

    /* renamed from: k, reason: collision with root package name */
    protected Random f380458k = new Random();

    public byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 0, bArr.length, bArr2);
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        return b(bArr, 0, bArr.length, bArr2);
    }

    public byte[] a(byte[] bArr, int i3, int i16, byte[] bArr2) {
        int i17 = 0;
        this.f380452e = 0;
        this.f380451d = 0;
        this.f380455h = bArr2;
        int i18 = i3 + 8;
        byte[] bArr3 = new byte[i18];
        if (i16 % 8 != 0 || i16 < 16) {
            return null;
        }
        byte[] a16 = a(bArr, i3);
        this.f380449b = a16;
        int i19 = a16[0] & 7;
        this.f380453f = i19;
        int i26 = (i16 - i19) - 10;
        if (i26 < 0) {
            return null;
        }
        for (int i27 = i3; i27 < i18; i27++) {
            bArr3[i27] = 0;
        }
        this.f380450c = new byte[i26];
        this.f380452e = 0;
        this.f380451d = 8;
        this.f380457j = 8;
        this.f380453f++;
        this.f380454g = 1;
        while (true) {
            int i28 = this.f380454g;
            if (i28 <= 2) {
                int i29 = this.f380453f;
                if (i29 < 8) {
                    this.f380453f = i29 + 1;
                    this.f380454g = i28 + 1;
                }
                if (this.f380453f == 8) {
                    if (!a(bArr, i3, i16)) {
                        return null;
                    }
                    bArr3 = bArr;
                }
            } else {
                while (i26 != 0) {
                    int i36 = this.f380453f;
                    if (i36 < 8) {
                        this.f380450c[i17] = (byte) (bArr3[(this.f380452e + i3) + i36] ^ this.f380449b[i36]);
                        i17++;
                        i26--;
                        this.f380453f = i36 + 1;
                    }
                    if (this.f380453f == 8) {
                        this.f380452e = this.f380451d - 8;
                        if (!a(bArr, i3, i16)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                }
                this.f380454g = 1;
                while (this.f380454g < 8) {
                    int i37 = this.f380453f;
                    if (i37 < 8) {
                        if ((bArr3[(this.f380452e + i3) + i37] ^ this.f380449b[i37]) != 0) {
                            return null;
                        }
                        this.f380453f = i37 + 1;
                    }
                    if (this.f380453f == 8) {
                        this.f380452e = this.f380451d;
                        if (!a(bArr, i3, i16)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                    this.f380454g++;
                }
                return this.f380450c;
            }
        }
    }

    public byte[] b(byte[] bArr, int i3, int i16, byte[] bArr2) {
        int i17;
        byte[] bArr3 = new byte[8];
        this.f380448a = bArr3;
        this.f380449b = new byte[8];
        this.f380453f = 1;
        this.f380454g = 0;
        this.f380452e = 0;
        this.f380451d = 0;
        this.f380455h = bArr2;
        this.f380456i = true;
        int i18 = (i16 + 10) % 8;
        this.f380453f = i18;
        if (i18 != 0) {
            this.f380453f = 8 - i18;
        }
        this.f380450c = new byte[this.f380453f + i16 + 10];
        bArr3[0] = (byte) ((b() & 248) | this.f380453f);
        int i19 = 1;
        while (true) {
            i17 = this.f380453f;
            if (i19 > i17) {
                break;
            }
            this.f380448a[i19] = (byte) (b() & 255);
            i19++;
        }
        this.f380453f = i17 + 1;
        for (int i26 = 0; i26 < 8; i26++) {
            this.f380449b[i26] = 0;
        }
        this.f380454g = 1;
        while (this.f380454g <= 2) {
            int i27 = this.f380453f;
            if (i27 < 8) {
                byte[] bArr4 = this.f380448a;
                this.f380453f = i27 + 1;
                bArr4[i27] = (byte) (b() & 255);
                this.f380454g++;
            }
            if (this.f380453f == 8) {
                a();
            }
        }
        while (i16 > 0) {
            int i28 = this.f380453f;
            if (i28 < 8) {
                byte[] bArr5 = this.f380448a;
                this.f380453f = i28 + 1;
                bArr5[i28] = bArr[i3];
                i16--;
                i3++;
            }
            if (this.f380453f == 8) {
                a();
            }
        }
        this.f380454g = 1;
        while (true) {
            int i29 = this.f380454g;
            if (i29 <= 7) {
                int i36 = this.f380453f;
                if (i36 < 8) {
                    byte[] bArr6 = this.f380448a;
                    this.f380453f = i36 + 1;
                    bArr6[i36] = 0;
                    this.f380454g = i29 + 1;
                }
                if (this.f380453f == 8) {
                    a();
                }
            } else {
                return this.f380450c;
            }
        }
    }

    private byte[] a(byte[] bArr, int i3) {
        try {
            long b16 = b(bArr, i3, 4);
            long b17 = b(bArr, i3 + 4, 4);
            long b18 = b(this.f380455h, 0, 4);
            long b19 = b(this.f380455h, 4, 4);
            long b26 = b(this.f380455h, 8, 4);
            long b27 = b(this.f380455h, 12, 4);
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

    private byte[] b(byte[] bArr) {
        try {
            long b16 = b(bArr, 0, 4);
            long b17 = b(bArr, 4, 4);
            long b18 = b(this.f380455h, 0, 4);
            long b19 = b(this.f380455h, 4, 4);
            long b26 = b(this.f380455h, 8, 4);
            long b27 = b(this.f380455h, 12, 4);
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

    private byte[] a(byte[] bArr) {
        return a(bArr, 0);
    }

    private int b() {
        return this.f380458k.nextInt();
    }

    private void a() {
        this.f380453f = 0;
        while (true) {
            int i3 = this.f380453f;
            if (i3 >= 8) {
                break;
            }
            if (this.f380456i) {
                byte[] bArr = this.f380448a;
                bArr[i3] = (byte) (bArr[i3] ^ this.f380449b[i3]);
            } else {
                byte[] bArr2 = this.f380448a;
                bArr2[i3] = (byte) (bArr2[i3] ^ this.f380450c[this.f380452e + i3]);
            }
            this.f380453f = i3 + 1;
        }
        System.arraycopy(b(this.f380448a), 0, this.f380450c, this.f380451d, 8);
        this.f380453f = 0;
        while (true) {
            int i16 = this.f380453f;
            if (i16 < 8) {
                byte[] bArr3 = this.f380450c;
                int i17 = this.f380451d + i16;
                bArr3[i17] = (byte) (bArr3[i17] ^ this.f380449b[i16]);
                this.f380453f = i16 + 1;
            } else {
                System.arraycopy(this.f380448a, 0, this.f380449b, 0, 8);
                int i18 = this.f380451d;
                this.f380452e = i18;
                this.f380451d = i18 + 8;
                this.f380453f = 0;
                this.f380456i = false;
                return;
            }
        }
    }

    private static long b(byte[] bArr, int i3, int i16) {
        long j3 = 0;
        int i17 = i16 > 8 ? i3 + 8 : i16 + i3;
        while (i3 < i17) {
            j3 = (j3 << 8) | (bArr[i3] & 255);
            i3++;
        }
        return (4294967295L & j3) | (j3 >>> 32);
    }

    private boolean a(byte[] bArr, int i3, int i16) {
        this.f380453f = 0;
        while (true) {
            int i17 = this.f380453f;
            if (i17 < 8) {
                if (this.f380457j + i17 >= i16) {
                    return true;
                }
                byte[] bArr2 = this.f380449b;
                bArr2[i17] = (byte) (bArr2[i17] ^ bArr[(this.f380451d + i3) + i17]);
                this.f380453f = i17 + 1;
            } else {
                byte[] a16 = a(this.f380449b);
                this.f380449b = a16;
                if (a16 == null) {
                    return false;
                }
                this.f380457j += 8;
                this.f380451d += 8;
                this.f380453f = 0;
                return true;
            }
        }
    }
}
