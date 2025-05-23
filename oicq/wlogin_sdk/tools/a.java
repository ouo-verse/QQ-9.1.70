package oicq.wlogin_sdk.tools;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f422978a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f422979b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f422980c;

    /* renamed from: d, reason: collision with root package name */
    public int f422981d;

    /* renamed from: e, reason: collision with root package name */
    public int f422982e;

    /* renamed from: f, reason: collision with root package name */
    public int f422983f;

    /* renamed from: g, reason: collision with root package name */
    public int f422984g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f422985h;

    /* renamed from: j, reason: collision with root package name */
    public int f422987j;

    /* renamed from: i, reason: collision with root package name */
    public boolean f422986i = true;

    /* renamed from: k, reason: collision with root package name */
    public Random f422988k = new Random();

    public static long b(byte[] bArr, int i3, int i16) {
        int i17;
        long j3 = 0;
        if (i16 > 4) {
            i17 = i3 + 4;
        } else {
            i17 = i16 + i3;
        }
        while (i3 < i17) {
            j3 = (j3 << 8) | (bArr[i3] & 255);
            i3++;
        }
        return 4294967295L & j3;
    }

    public final byte[] a(byte[] bArr, int i3) {
        try {
            long b16 = b(bArr, i3, 4);
            long b17 = b(bArr, i3 + 4, 4);
            long b18 = b(this.f422985h, 0, 4);
            long b19 = b(this.f422985h, 4, 4);
            long b26 = b(this.f422985h, 8, 4);
            long b27 = b(this.f422985h, 12, 4);
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

    public final boolean a(byte[] bArr, int i3, int i16) {
        this.f422983f = 0;
        while (true) {
            int i17 = this.f422983f;
            if (i17 >= 8) {
                byte[] a16 = a(this.f422979b, 0);
                this.f422979b = a16;
                if (a16 == null) {
                    return false;
                }
                this.f422987j += 8;
                this.f422981d += 8;
                this.f422983f = 0;
                return true;
            }
            if (this.f422987j + i17 >= i16) {
                return true;
            }
            byte[] bArr2 = this.f422979b;
            bArr2[i17] = (byte) (bArr2[i17] ^ bArr[(this.f422981d + i3) + i17]);
            this.f422983f = i17 + 1;
        }
    }

    public final void a() {
        byte[] bArr;
        this.f422983f = 0;
        while (true) {
            int i3 = this.f422983f;
            if (i3 >= 8) {
                break;
            }
            if (this.f422986i) {
                byte[] bArr2 = this.f422978a;
                bArr2[i3] = (byte) (bArr2[i3] ^ this.f422979b[i3]);
            } else {
                byte[] bArr3 = this.f422978a;
                bArr3[i3] = (byte) (bArr3[i3] ^ this.f422980c[this.f422982e + i3]);
            }
            this.f422983f = i3 + 1;
        }
        byte[] bArr4 = this.f422978a;
        try {
            long b16 = b(bArr4, 0, 4);
            long b17 = b(bArr4, 4, 4);
            long b18 = b(this.f422985h, 0, 4);
            long b19 = b(this.f422985h, 4, 4);
            long b26 = b(this.f422985h, 8, 4);
            long b27 = b(this.f422985h, 12, 4);
            int i16 = 16;
            long j3 = 0;
            while (true) {
                int i17 = i16 - 1;
                if (i16 <= 0) {
                    break;
                }
                j3 = (j3 + 2654435769L) & 4294967295L;
                b16 = (b16 + ((((b17 << 4) + b18) ^ (b17 + j3)) ^ ((b17 >>> 5) + b19))) & 4294967295L;
                b17 = (b17 + ((((b16 << 4) + b26) ^ (b16 + j3)) ^ ((b16 >>> 5) + b27))) & 4294967295L;
                i16 = i17;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt((int) b16);
            dataOutputStream.writeInt((int) b17);
            dataOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            bArr = null;
        }
        System.arraycopy(bArr, 0, this.f422980c, this.f422981d, 8);
        this.f422983f = 0;
        while (true) {
            int i18 = this.f422983f;
            if (i18 >= 8) {
                System.arraycopy(this.f422978a, 0, this.f422979b, 0, 8);
                int i19 = this.f422981d;
                this.f422982e = i19;
                this.f422981d = i19 + 8;
                this.f422983f = 0;
                this.f422986i = false;
                return;
            }
            byte[] bArr5 = this.f422980c;
            int i26 = this.f422981d + i18;
            bArr5[i26] = (byte) (bArr5[i26] ^ this.f422979b[i18]);
            this.f422983f = i18 + 1;
        }
    }
}
