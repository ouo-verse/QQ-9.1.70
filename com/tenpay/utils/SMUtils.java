package com.tenpay.utils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SMUtils {
    private static boolean isLoadSuccess = false;
    private static SMUtils mInstance;

    SMUtils() {
    }

    public static SMUtils getInstance() {
        if (mInstance == null) {
            synchronized (SMUtils.class) {
                if (mInstance == null) {
                    mInstance = new SMUtils();
                }
            }
        }
        return mInstance;
    }

    public static boolean isLoadOK() {
        return isLoadSuccess;
    }

    public native byte[] SM2Decrypt(long j3, byte[] bArr, String str);

    public native byte[] SM2Encrypt(long j3, byte[] bArr, String str);

    public native void SM2FreeCtx(long j3);

    public native Object[] SM2GenKeyPair(long j3);

    public native long SM2InitCtx();

    public native long SM2InitCtxWithPubKey(String str);

    public native int SM2ReSeed(long j3, byte[] bArr);

    public native byte[] SM2Sign(long j3, byte[] bArr, byte[] bArr2, String str, String str2);

    public native int SM2Verify(long j3, byte[] bArr, byte[] bArr2, String str, byte[] bArr3);

    public native byte[] SM3(byte[] bArr);

    public native byte[] SM3Final(long j3);

    public native void SM3Free(long j3);

    public native long SM3Init();

    public native void SM3Update(long j3, byte[] bArr);

    public native byte[] SM4CBCDecrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public native byte[] SM4CBCDecryptNoPadding(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public native byte[] SM4CBCEncrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public native byte[] SM4CBCEncryptNoPadding(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public native byte[] SM4ECBDecrypt(byte[] bArr, byte[] bArr2);

    public native byte[] SM4ECBDecryptNoPadding(byte[] bArr, byte[] bArr2);

    public native byte[] SM4ECBEncrypt(byte[] bArr, byte[] bArr2);

    public native byte[] SM4ECBEncryptNoPadding(byte[] bArr, byte[] bArr2);

    public native byte[] SM4GenKey();

    public native byte[] sm4GCMDecryptNoPadding(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    public native byte[] sm4GCMEncryptNoPadding(byte[] bArr, int i3, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public native String version();
}
