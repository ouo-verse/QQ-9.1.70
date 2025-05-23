package com.tencent.mobileqq.qqlive.room.feedback;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("RsaUtil", 1, "decrypt key is null");
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static String b(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return Base64.encodeToString(bArr, 0).replaceAll("[\\s*\t\n\r]", "");
        }
        QLog.e("RsaUtil", 1, "encrypt key is null");
        return null;
    }

    public static byte[] c(byte[] bArr, String str) throws Exception {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a(str)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException e16) {
            QLog.i("RsaUtil", 1, e16.getMessage());
            throw e16;
        } catch (NoSuchAlgorithmException e17) {
            QLog.i("RsaUtil", 1, e17.getMessage());
            throw e17;
        } catch (InvalidKeySpecException e18) {
            QLog.i("RsaUtil", 1, e18.getMessage());
            throw e18;
        } catch (BadPaddingException e19) {
            QLog.i("RsaUtil", 1, e19.getMessage());
            throw e19;
        } catch (IllegalBlockSizeException e26) {
            QLog.i("RsaUtil", 1, e26.getMessage());
            throw e26;
        } catch (NoSuchPaddingException e27) {
            QLog.i("RsaUtil", 1, e27.getMessage());
            throw e27;
        } catch (Exception e28) {
            QLog.i("RsaUtil", 1, e28.getMessage());
            throw e28;
        }
    }
}
