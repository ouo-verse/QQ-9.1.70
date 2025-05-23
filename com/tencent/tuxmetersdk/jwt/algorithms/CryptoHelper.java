package com.tencent.tuxmetersdk.jwt.algorithms;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes27.dex */
class CryptoHelper {
    static IPatchRedirector $redirector_ = null;
    private static final byte JWT_PART_SEPARATOR = 46;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CryptoHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] createSignatureFor(String str, byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(str);
        mac.init(new SecretKeySpec(bArr, str));
        mac.update(bArr2);
        mac.update(JWT_PART_SEPARATOR);
        return mac.doFinal(bArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] createSignatureFor(String str, byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(str);
        mac.init(new SecretKeySpec(bArr, str));
        return mac.doFinal(bArr2);
    }
}
