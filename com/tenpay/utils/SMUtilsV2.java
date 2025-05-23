package com.tenpay.utils;

import com.tencent.luggage.wxa.cr.b;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class SMUtilsV2 {
    static {
        b.a("tsmsc");
    }

    public static native int TSMCryptoDescSM2Decrypt(String str, byte[] bArr, int i3, byte[][] bArr2);

    public static native int TSMCryptoDescSM2Encrypt(String str, byte[] bArr, int i3, byte[][] bArr2);

    public static native int TSMCryptoDescSM2Sign(String str, byte[] bArr, String str2, int i3, byte[][] bArr2);

    public static native int TSMCryptoDescSM2Verify(String str, byte[] bArr, String str2, byte[] bArr2, int i3);

    public static native int TSMCryptoDescSM4CBCDecrypt(String str, byte[] bArr, byte[] bArr2, byte[][] bArr3);

    public static native int TSMCryptoDescSM4CBCEncrypt(String str, byte[] bArr, byte[] bArr2, byte[][] bArr3);

    public static native int TSMCryptoDescSM4CTRDecrypt(String str, byte[] bArr, byte[] bArr2, byte[][] bArr3);

    public static native int TSMCryptoDescSM4CTREncrypt(String str, byte[] bArr, byte[] bArr2, byte[][] bArr3);

    public static native int TSMCryptoDescSM4ECBDecrypt(String str, byte[] bArr, byte[][] bArr2);

    public static native int TSMCryptoDescSM4ECBEncrypt(String str, byte[] bArr, byte[][] bArr2);

    public static native int TSMCryptoDescSM4GCMDecrypt(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[][] bArr5);

    public static native int TSMCryptoDescSM4GCMEncrypt(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[][] bArr4, byte[][] bArr5);

    public static native int TSMStorageCheckSM2PriKey(String str);

    public static native int TSMStorageCheckSM2PubKey(String str);

    public static native int TSMStorageCheckSM4Key(String str);

    public static native int TSMStorageDeleteSM2PriKey(String str);

    public static native int TSMStorageDeleteSM2PubKey(String str);

    public static native int TSMStorageDeleteSM4Key(String str);

    public static native int TSMStorageExportSM2PriKey(String str, int i3, String[] strArr, String[] strArr2);

    public static native int TSMStorageExportSM2PubKey(String str, int i3, String[] strArr);

    public static native int TSMStorageExportSM4Key(String str, byte[][] bArr);

    public static native int TSMStorageGenerateSM2KeyPair(String str);

    public static native int TSMStorageGenerateSM4Key(String str);

    public static native int TSMStorageImportSM2PriKey(String str, String str2, int i3);

    public static native int TSMStorageImportSM2PubKey(String str, String str2, int i3);

    public static native int TSMStorageImportSM4Key(String str, byte[] bArr);

    public static native int TSMStorageInit(String str, String str2, String str3);

    public static native int TSMStorageUpdateSM2PriKey(String str, String str2, int i3);

    public static native int TSMStorageUpdateSM2PubKey(String str, String str2, int i3);

    public static native int TSMStorageUpdateSM4Key(String str, byte[] bArr);
}
