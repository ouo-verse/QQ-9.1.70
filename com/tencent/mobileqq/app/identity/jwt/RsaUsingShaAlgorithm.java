package com.tencent.mobileqq.app.identity.jwt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RsaUsingShaAlgorithm {
    static IPatchRedirector $redirector_ = null;
    private static final String RS256ALG = "SHA256withRSA";
    private static final String TAG = "RsaUsingShaAlgorithm";

    public RsaUsingShaAlgorithm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Signature getSignature() {
        try {
            return Signature.getInstance("SHA256withRSA");
        } catch (NoSuchAlgorithmException e16) {
            QLog.e(TAG, 1, "getSignature error : ", e16.getMessage());
            return null;
        }
    }

    private boolean initForVerify(Signature signature, Key key) {
        try {
            signature.initVerify((PublicKey) key);
            return true;
        } catch (InvalidKeyException e16) {
            QLog.e(TAG, 1, "initForVerify error : ", e16.getMessage());
            return false;
        }
    }

    public boolean verifySignature(byte[] bArr, Key key, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, bArr, key, bArr2)).booleanValue();
        }
        Signature signature = getSignature();
        if (signature == null) {
            QLog.e(TAG, 1, "verifySignature fail");
            return false;
        }
        if (!initForVerify(signature, key)) {
            QLog.e(TAG, 1, "initForVerify fail");
            return false;
        }
        try {
            signature.update(bArr2);
            return signature.verify(bArr);
        } catch (SignatureException unused) {
            return false;
        }
    }
}
