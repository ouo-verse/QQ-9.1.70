package com.tencent.util;

import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ThreeDes {
    static IPatchRedirector $redirector_ = null;
    private static final String ALGORITHM_3DES = "DESede";
    private static final String CHAR_SET = "UTF-8";

    public ThreeDes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static byte[] build3DesKey(byte[] bArr) throws UnsupportedEncodingException {
        byte[] bArr2 = new byte[24];
        if (24 > bArr.length) {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, 24);
        }
        return bArr2;
    }

    public static String decode(String str, String str2) {
        try {
            byte[] decrypt = decrypt(PluginBaseInfoHelper.Base64Helper.decode(str, 0), str2.getBytes("UTF-8"));
            if (decrypt == null) {
                return null;
            }
            return new String(decrypt, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(build3DesKey(bArr2), ALGORITHM_3DES);
            Cipher cipher = Cipher.getInstance(ALGORITHM_3DES);
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e17) {
            e17.printStackTrace();
            return null;
        } catch (Exception e18) {
            e18.printStackTrace();
            return null;
        }
    }

    public static String encode(String str, String str2) {
        try {
            byte[] encrypt = encrypt(str.getBytes("UTF-8"), str2.getBytes("UTF-8"));
            if (encrypt == null) {
                return null;
            }
            return PluginBaseInfoHelper.Base64Helper.encodeToString(encrypt, 2);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(build3DesKey(bArr2), ALGORITHM_3DES);
            Cipher cipher = Cipher.getInstance(ALGORITHM_3DES);
            cipher.init(1, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e17) {
            e17.printStackTrace();
            return null;
        } catch (Exception e18) {
            e18.printStackTrace();
            return null;
        }
    }
}
