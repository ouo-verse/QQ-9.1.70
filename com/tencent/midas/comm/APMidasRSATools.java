package com.tencent.midas.comm;

import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

/* loaded from: classes9.dex */
public class APMidasRSATools {
    private final String DEFAULT_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy+ZF2XdZ6RwK/lAtyC7h\rLA4KaURXrD7gEGcx+t/l8KKLTLfR3j4vOHXHXjixipSXicyJcDH74rfO7ISnFkWQ\r+kVmB5kfhdrq5z6D/h/q7ko7MdU9SUlfZfAxwnS4VJY4xWoFWG9ZAoh5ZHJcloDU\rol0qYTUX/yWNiHkoUtnU+SP+ZJjODpqcYuVdLxlA0YelafeBc3SCeuEcPH9lIiRZ\rw0I91wQvPq7gM7/6qnMEdzm7nJdCIni83INl2bh3gW5UBwFBpNrI/fZkgDA4aVGV\rpplEP9bChkCpq2e1T9gw0ODuEVmgVaSvdwHLMYcGn+nYjWDYy16b6ImdkubF8q5l\rhwIDAQAB\r";
    private RSAPublicKey publicKey;

    private byte charToByte(char c16) {
        return (byte) "0123456789ABCDEF".indexOf(c16);
    }

    private byte[] decrypt(RSAPublicKey rSAPublicKey, byte[] bArr) throws Exception {
        if (rSAPublicKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(2, rSAPublicKey);
                return cipher.doFinal(bArr);
            } catch (InvalidKeyException unused) {
                throw new Exception("\u5bc6\u94a5\u65e0\u6548\uff0c\u8bf7\u68c0\u67e5\u786e\u8ba4");
            } catch (NoSuchAlgorithmException unused2) {
                throw new Exception("\u6ca1\u6709\u8fd9\u6837\u7684\u89e3\u5bc6\u7b97\u6cd5");
            } catch (BadPaddingException unused3) {
                throw new Exception("\u5bc6\u6587\u6570\u636e\u5df2\u635f\u574f");
            } catch (IllegalBlockSizeException unused4) {
                throw new Exception("\u5bc6\u6587\u957f\u5ea6\u65e0\u6548\u6216\u8005\u8fc7\u957f");
            } catch (Exception e16) {
                e16.printStackTrace();
                APLog.i("APMidasRSATools exception", e16.toString());
                throw new Exception("\u5176\u4ed6\u9519\u8bef");
            }
        }
        throw new Exception("\u89e3\u5bc6\u79c1\u94a5\u4e3a\u7a7a, \u8bf7\u8bbe\u7f6e");
    }

    private byte[] getByte(String str) {
        return hexStringToBytes(str);
    }

    private byte[] hexStringToBytes(String str) {
        if (str != null && !str.equals("")) {
            String upperCase = str.toUpperCase();
            int length = upperCase.length() / 2;
            char[] charArray = upperCase.toCharArray();
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = i3 * 2;
                bArr[i3] = (byte) (charToByte(charArray[i16 + 1]) | (charToByte(charArray[i16]) << 4));
            }
            return bArr;
        }
        return null;
    }

    private void loadPublicKey(String str) throws Exception {
        try {
            this.publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public String deCodeKey(String str) {
        try {
            loadPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy+ZF2XdZ6RwK/lAtyC7h\rLA4KaURXrD7gEGcx+t/l8KKLTLfR3j4vOHXHXjixipSXicyJcDH74rfO7ISnFkWQ\r+kVmB5kfhdrq5z6D/h/q7ko7MdU9SUlfZfAxwnS4VJY4xWoFWG9ZAoh5ZHJcloDU\rol0qYTUX/yWNiHkoUtnU+SP+ZJjODpqcYuVdLxlA0YelafeBc3SCeuEcPH9lIiRZ\rw0I91wQvPq7gM7/6qnMEdzm7nJdCIni83INl2bh3gW5UBwFBpNrI/fZkgDA4aVGV\rpplEP9bChkCpq2e1T9gw0ODuEVmgVaSvdwHLMYcGn+nYjWDYy16b6ImdkubF8q5l\rhwIDAQAB\r");
            return new String(decrypt(this.publicKey, getByte(str)));
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
