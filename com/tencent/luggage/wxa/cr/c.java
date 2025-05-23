package com.tencent.luggage.wxa.cr;

import com.tenpay.ndk.FitScUtil;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f123846b = "1234567812345678".getBytes();

    /* renamed from: c, reason: collision with root package name */
    public static volatile c f123847c = null;

    /* renamed from: a, reason: collision with root package name */
    public FitScUtil f123848a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        SM2CipherMode_C1C3C2_ASN1,
        SM2CipherMode_C1C3C2,
        SM2CipherMode_C1C2C3_ASN1,
        SM2CipherMode_C1C2C3,
        SM2CipherMode_04C1C3C2,
        SM2CipherMode_04C1C2C3
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        SM2SignMode_RS_ASN1,
        SM2SignMode_RS
    }

    public c() {
        this.f123848a = null;
        FitScUtil fitScUtil = new FitScUtil();
        this.f123848a = fitScUtil;
        fitScUtil.initTsm();
        com.tencent.luggage.wxa.cr.a.a();
    }

    public static c a() {
        if (f123847c == null) {
            synchronized (c.class) {
                if (f123847c == null) {
                    f123847c = new c();
                }
            }
        }
        return f123847c;
    }

    public int b() {
        return this.f123848a.getLastError();
    }

    public byte[][] c() {
        byte[][] bArr;
        synchronized (FitScUtil.f386595a) {
            bArr = (byte[][]) this.f123848a.sm2GenKeyPair();
        }
        return bArr;
    }

    public byte[] b(byte[] bArr, byte[] bArr2, a aVar) {
        byte[] sm2EncryptWithMode;
        synchronized (FitScUtil.f386595a) {
            sm2EncryptWithMode = this.f123848a.sm2EncryptWithMode(bArr, bArr2, aVar.ordinal());
        }
        return sm2EncryptWithMode;
    }

    public boolean b(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, b bVar) {
        boolean sm2VerifyWithMode;
        synchronized (FitScUtil.f386595a) {
            sm2VerifyWithMode = this.f123848a.sm2VerifyWithMode(bArr, bArr2, bArr3, bArr4, bVar.ordinal());
        }
        return sm2VerifyWithMode;
    }

    public byte[] a(int i3) {
        return this.f123848a.randomBytes(i3);
    }

    public byte[] a(byte[] bArr) {
        byte[] sm2GenPublicKey;
        synchronized (FitScUtil.f386595a) {
            sm2GenPublicKey = this.f123848a.sm2GenPublicKey(bArr);
        }
        return sm2GenPublicKey;
    }

    public byte[] b(byte[] bArr) {
        return this.f123848a.sm3(bArr);
    }

    public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z16) {
        return this.f123848a.sm4CbcEncrypt(bArr, bArr2, bArr3, z16);
    }

    public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f123848a.sm4CtrEncrypt(bArr, bArr2, bArr3);
    }

    public byte[] a(byte[] bArr, byte[] bArr2, a aVar) {
        byte[] sm2DecryptWithMode;
        synchronized (FitScUtil.f386595a) {
            sm2DecryptWithMode = this.f123848a.sm2DecryptWithMode(bArr, bArr2, aVar.ordinal());
        }
        return sm2DecryptWithMode;
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, b bVar) {
        byte[] sm2SignWithMode;
        synchronized (FitScUtil.f386595a) {
            sm2SignWithMode = this.f123848a.sm2SignWithMode(bArr, bArr2, bArr3, bArr4, bVar.ordinal());
        }
        return sm2SignWithMode;
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        return this.f123848a.sm3Hmac(bArr, bArr2);
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z16) {
        return this.f123848a.sm4CbcDecrypt(bArr, bArr2, bArr3, z16);
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f123848a.sm4CtrDecrypt(bArr, bArr2, bArr3);
    }

    public byte[][] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        return (byte[][]) this.f123848a.sm4GcmEncrypt(bArr, bArr2, bArr3, bArr4);
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        return this.f123848a.sm4GcmDecrypt(bArr, bArr2, bArr3, bArr4, bArr5);
    }

    public String a(String str, String str2, String str3) {
        String encryptGenericDataWithCert;
        synchronized (FitScUtil.f386595a) {
            encryptGenericDataWithCert = this.f123848a.encryptGenericDataWithCert(str, str2, str3, false);
        }
        return encryptGenericDataWithCert;
    }
}
