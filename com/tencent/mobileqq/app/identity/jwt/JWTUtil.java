package com.tencent.mobileqq.app.identity.jwt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: P */
/* loaded from: classes11.dex */
public class JWTUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "JWTUtil";

    public JWTUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getPayload(String str, String str2) {
        PublicKey publicKey = getPublicKey(str2);
        if (publicKey == null) {
            return null;
        }
        return new JwtConsumer(new SimpleKeyResolver(publicKey)).processToPayload(str);
    }

    private static PublicKey getPublicKey(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decodeBase64(str.replaceAll("\\-*BEGIN.*KEY\\-*", "").replaceAll("\\-*END.*KEY\\-*", ""))));
        } catch (NoSuchAlgorithmException e16) {
            QLog.e(TAG, 1, "getPublicKey NoSuchAlgorithmException : ", e16.getMessage());
            return null;
        } catch (InvalidKeySpecException e17) {
            QLog.e(TAG, 1, "getPublicKey InvalidKeySpecException : ", e17.getMessage());
            return null;
        }
    }
}
