package com.tenpay.ndk;

import com.tencent.luggage.wxa.cr.b;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FitScUtil {

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f386595a = new byte[0];

    static {
        b.a("tsmsc");
    }

    public native synchronized String encryptGenericDataWithCert(String str, String str2, String str3, boolean z16);

    public native synchronized String encryptPassWithCert(String str, byte[] bArr, byte[] bArr2, long j3, String str2, int i3, boolean z16);

    public native synchronized int getLastError();

    public native synchronized String getVersion();

    public native synchronized boolean init(String str, String str2, String str3, String str4);

    public native synchronized boolean initTsm();

    public native synchronized byte[] md5(byte[] bArr);

    public native synchronized byte[] randomBytes(int i3);

    public native synchronized void release();

    public native synchronized byte[] sha1(byte[] bArr);

    public native synchronized byte[] sha256(byte[] bArr);

    public native synchronized byte[] sm2DecryptWithMode(byte[] bArr, byte[] bArr2, int i3);

    public native synchronized byte[] sm2EncryptWithMode(byte[] bArr, byte[] bArr2, int i3);

    public native synchronized Object[] sm2GenKeyPair();

    public native synchronized byte[] sm2GenPublicKey(byte[] bArr);

    public native synchronized byte[] sm2SignWithMode(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i3);

    public native synchronized boolean sm2VerifyWithMode(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i3);

    public native synchronized byte[] sm3(byte[] bArr);

    public native synchronized byte[] sm3Hmac(byte[] bArr, byte[] bArr2);

    public native synchronized byte[] sm4CbcDecrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z16);

    public native synchronized byte[] sm4CbcEncrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z16);

    public native synchronized byte[] sm4CtrDecrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public native synchronized byte[] sm4CtrEncrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public native synchronized byte[] sm4GcmDecrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    public native synchronized Object[] sm4GcmEncrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);
}
