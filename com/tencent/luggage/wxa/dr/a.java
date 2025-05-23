package com.tencent.luggage.wxa.dr;

import com.tenpay.utils.SMUtilsV2;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static byte[] a(String str, byte[] bArr, e eVar) {
        byte[][] bArr2 = new byte[1];
        int TSMCryptoDescSM2Decrypt = SMUtilsV2.TSMCryptoDescSM2Decrypt(str, bArr, eVar.ordinal(), bArr2);
        if (TSMCryptoDescSM2Decrypt == 0) {
            return bArr2[0];
        }
        throw new c(TSMCryptoDescSM2Decrypt);
    }

    public static byte[] b(String str, byte[] bArr, e eVar) {
        byte[][] bArr2 = new byte[1];
        int TSMCryptoDescSM2Encrypt = SMUtilsV2.TSMCryptoDescSM2Encrypt(str, bArr, eVar.ordinal(), bArr2);
        if (TSMCryptoDescSM2Encrypt == 0) {
            return bArr2[0];
        }
        throw new c(TSMCryptoDescSM2Encrypt);
    }

    public static byte[] a(String str, byte[] bArr, String str2, f fVar) {
        byte[][] bArr2 = new byte[1];
        int TSMCryptoDescSM2Sign = SMUtilsV2.TSMCryptoDescSM2Sign(str, bArr, str2, fVar.ordinal(), bArr2);
        if (TSMCryptoDescSM2Sign == 0) {
            return bArr2[0];
        }
        throw new c(TSMCryptoDescSM2Sign);
    }

    public static boolean a(String str, byte[] bArr, String str2, byte[] bArr2, f fVar) {
        int TSMCryptoDescSM2Verify = SMUtilsV2.TSMCryptoDescSM2Verify(str, bArr, str2, bArr2, fVar.ordinal());
        if (-51003 == TSMCryptoDescSM2Verify) {
            return false;
        }
        if (TSMCryptoDescSM2Verify == 0) {
            return true;
        }
        throw new c(TSMCryptoDescSM2Verify);
    }
}
