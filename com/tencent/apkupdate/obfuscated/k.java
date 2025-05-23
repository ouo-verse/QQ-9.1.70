package com.tencent.apkupdate.obfuscated;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f72534a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f72535b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f72536c;

    /* renamed from: d, reason: collision with root package name */
    public int f72537d;

    /* renamed from: e, reason: collision with root package name */
    public int f72538e;

    /* renamed from: f, reason: collision with root package name */
    public int f72539f;

    /* renamed from: g, reason: collision with root package name */
    public int f72540g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f72541h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f72542i;

    /* renamed from: j, reason: collision with root package name */
    public int f72543j;

    /* renamed from: k, reason: collision with root package name */
    public Random f72544k;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f72542i = true;
            this.f72544k = new Random();
        }
    }

    public static long d(byte[] bArr, int i3, int i16) {
        int i17;
        long j3 = 0;
        if (i16 > 8) {
            i17 = i3 + 8;
        } else {
            i17 = i16 + i3;
        }
        while (i3 < i17) {
            j3 = (j3 << 8) | (bArr[i3] & 255);
            i3++;
        }
        return (4294967295L & j3) | (j3 >>> 32);
    }

    public final void a() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f72539f = 0;
        while (true) {
            int i3 = this.f72539f;
            if (i3 >= 8) {
                break;
            }
            if (this.f72542i) {
                byte[] bArr2 = this.f72534a;
                bArr2[i3] = (byte) (bArr2[i3] ^ this.f72535b[i3]);
            } else {
                byte[] bArr3 = this.f72534a;
                bArr3[i3] = (byte) (bArr3[i3] ^ this.f72536c[this.f72538e + i3]);
            }
            this.f72539f = i3 + 1;
        }
        byte[] bArr4 = this.f72534a;
        try {
            long d16 = d(bArr4, 0, 4);
            long d17 = d(bArr4, 4, 4);
            long d18 = d(this.f72541h, 0, 4);
            long d19 = d(this.f72541h, 4, 4);
            long d26 = d(this.f72541h, 8, 4);
            long d27 = d(this.f72541h, 12, 4);
            int i16 = 16;
            long j3 = 0;
            while (true) {
                int i17 = i16 - 1;
                if (i16 <= 0) {
                    break;
                }
                j3 = (j3 + 2654435769L) & 4294967295L;
                d16 = (d16 + ((((d17 << 4) + d18) ^ (d17 + j3)) ^ ((d17 >>> 5) + d19))) & 4294967295L;
                d17 = (d17 + ((((d16 << 4) + d26) ^ (d16 + j3)) ^ ((d16 >>> 5) + d27))) & 4294967295L;
                i16 = i17;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt((int) d16);
            dataOutputStream.writeInt((int) d17);
            dataOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            bArr = null;
        }
        System.arraycopy(bArr, 0, this.f72536c, this.f72537d, 8);
        this.f72539f = 0;
        while (true) {
            int i18 = this.f72539f;
            if (i18 < 8) {
                byte[] bArr5 = this.f72536c;
                int i19 = this.f72537d + i18;
                bArr5[i19] = (byte) (bArr5[i19] ^ this.f72535b[i18]);
                this.f72539f = i18 + 1;
            } else {
                System.arraycopy(this.f72534a, 0, this.f72535b, 0, 8);
                int i26 = this.f72537d;
                this.f72538e = i26;
                this.f72537d = i26 + 8;
                this.f72539f = 0;
                this.f72542i = false;
                return;
            }
        }
    }

    public final boolean b(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        this.f72539f = 0;
        while (true) {
            int i17 = this.f72539f;
            if (i17 < 8) {
                if (this.f72543j + i17 >= i16) {
                    return true;
                }
                byte[] bArr2 = this.f72535b;
                bArr2[i17] = (byte) (bArr2[i17] ^ bArr[(this.f72537d + i3) + i17]);
                this.f72539f = i17 + 1;
            } else {
                byte[] c16 = c(this.f72535b, 0);
                this.f72535b = c16;
                if (c16 == null) {
                    return false;
                }
                this.f72543j += 8;
                this.f72537d += 8;
                this.f72539f = 0;
                return true;
            }
        }
    }

    public final byte[] c(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, i3);
        }
        try {
            long d16 = d(bArr, i3, 4);
            long d17 = d(bArr, i3 + 4, 4);
            long d18 = d(this.f72541h, 0, 4);
            long d19 = d(this.f72541h, 4, 4);
            long d26 = d(this.f72541h, 8, 4);
            long d27 = d(this.f72541h, 12, 4);
            int i16 = 16;
            long j3 = 3816266640L;
            while (true) {
                int i17 = i16 - 1;
                if (i16 > 0) {
                    d17 = (d17 - ((((d16 << 4) + d26) ^ (d16 + j3)) ^ ((d16 >>> 5) + d27))) & 4294967295L;
                    d16 = (d16 - ((((d17 << 4) + d18) ^ (d17 + j3)) ^ ((d17 >>> 5) + d19))) & 4294967295L;
                    j3 = (j3 - 2654435769L) & 4294967295L;
                    i16 = i17;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) d16);
                    dataOutputStream.writeInt((int) d17);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
