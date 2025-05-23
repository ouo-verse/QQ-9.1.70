package com.tenpay.sdk.util;

import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RSAUtils {
    private static final String TAG = "RSAUtils";
    public static String modulus;
    public static String private_exponent;
    public static String public_exponent;

    public static byte[] ASCII_To_BCD(byte[] bArr, int i3) {
        byte asc_to_bcd;
        byte[] bArr2 = new byte[i3 / 2];
        int i16 = 0;
        for (int i17 = 0; i17 < (i3 + 1) / 2; i17++) {
            int i18 = i16 + 1;
            bArr2[i17] = asc_to_bcd(bArr[i16]);
            if (i18 >= i3) {
                i16 = i18;
                asc_to_bcd = 0;
            } else {
                i16 = i18 + 1;
                asc_to_bcd = asc_to_bcd(bArr[i18]);
            }
            bArr2[i17] = (byte) (asc_to_bcd + (bArr2[i17] << 4));
        }
        return bArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x001d, code lost:
    
        if (r3 <= 102) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte asc_to_bcd(byte b16) {
        int i3;
        if (b16 < 48 || b16 > 57) {
            byte b17 = 65;
            if (b16 < 65 || b16 > 70) {
                b17 = 97;
                if (b16 >= 97) {
                }
            }
            i3 = (b16 - b17) + 10;
            return (byte) i3;
        }
        i3 = b16 - 48;
        return (byte) i3;
    }

    public static String bcd2Str(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b16 = bArr[i3];
            char c16 = (char) (((b16 & 240) >> 4) & 15);
            int i16 = i3 * 2;
            cArr[i16] = (char) (c16 > '\t' ? (c16 + EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET) - 10 : c16 + '0');
            char c17 = (char) (b16 & RegisterType.DOUBLE_HI);
            cArr[i16 + 1] = (char) (c17 > '\t' ? (c17 + EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET) - 10 : c17 + '0');
        }
        return new String(cArr);
    }

    public static String decryptByPrivateKey(String str, RSAPrivateKey rSAPrivateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, rSAPrivateKey);
        int bitLength = rSAPrivateKey.getModulus().bitLength() / 8;
        if (bitLength == 0) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte[] ASCII_To_BCD = ASCII_To_BCD(bytes, bytes.length);
        System.err.println(ASCII_To_BCD.length);
        StringBuffer stringBuffer = new StringBuffer("");
        for (byte[] bArr : splitArray(ASCII_To_BCD, bitLength)) {
            stringBuffer.append(new String(cipher.doFinal(bArr)));
        }
        return stringBuffer.toString();
    }

    public static byte[] decryptWithRSA(byte[] bArr, RSAPublicKey rSAPublicKey) {
        if (rSAPublicKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, rSAPublicKey);
                return cipher.doFinal(bArr);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
            }
        }
        return null;
    }

    public static RSAPrivateKey getPrivateKey(String str, String str2) {
        try {
            return (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new RSAPrivateKeySpec(new BigInteger(str), new BigInteger(str2)));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return null;
        }
    }

    public static RSAPublicKey getPubKeyFromStr(String str) throws Exception {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(ASCII_To_BCD(str.getBytes(), str.length())));
    }

    public static void initRsaKeys() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) generateKeyPair.getPublic();
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) generateKeyPair.getPrivate();
        modulus = rSAPublicKey.getModulus().toString();
        public_exponent = rSAPublicKey.getPublicExponent().toString();
        private_exponent = rSAPrivateKey.getPrivateExponent().toString();
    }

    public static byte[][] splitArray(byte[] bArr, int i3) {
        int i16;
        int length = bArr.length / i3;
        int length2 = bArr.length % i3;
        if (length2 != 0) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        int i17 = length + i16;
        byte[][] bArr2 = new byte[i17];
        for (int i18 = 0; i18 < i17; i18++) {
            byte[] bArr3 = new byte[i3];
            if (i18 == i17 - 1 && length2 != 0) {
                System.arraycopy(bArr, i18 * i3, bArr3, 0, length2);
            } else {
                System.arraycopy(bArr, i18 * i3, bArr3, 0, i3);
            }
            bArr2[i18] = bArr3;
        }
        return bArr2;
    }

    public static String[] splitString(String str, int i3) {
        int i16;
        String substring;
        int length = str.length() / i3;
        int length2 = str.length() % i3;
        if (length2 != 0) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        int i17 = length + i16;
        String[] strArr = new String[i17];
        for (int i18 = 0; i18 < i17; i18++) {
            if (i18 == i17 - 1 && length2 != 0) {
                int i19 = i18 * i3;
                substring = str.substring(i19, i19 + length2);
            } else {
                int i26 = i18 * i3;
                substring = str.substring(i26, i26 + i3);
            }
            strArr[i18] = substring;
        }
        return strArr;
    }
}
