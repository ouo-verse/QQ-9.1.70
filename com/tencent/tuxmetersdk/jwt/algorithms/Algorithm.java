package com.tencent.tuxmetersdk.jwt.algorithms;

import com.tencent.mobileqq.app.identity.jwt.JsonWebSignature;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tuxmetersdk.jwt.exceptions.SignatureGenerationException;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class Algorithm {
    static IPatchRedirector $redirector_;
    private final String description;
    private final String name;

    /* JADX INFO: Access modifiers changed from: protected */
    public Algorithm(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.name = str;
            this.description = str2;
        }
    }

    public static Algorithm hmac512(String str) throws IllegalArgumentException {
        return new HMACAlgorithm(JsonWebSignature.HMAC_SHA512, KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA512, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDescription() {
        return this.description;
    }

    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.name;
    }

    public String getSigningKeyId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    public abstract byte[] sign(byte[] bArr) throws SignatureGenerationException;

    public byte[] sign(byte[] bArr, byte[] bArr2) throws SignatureGenerationException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr, (Object) bArr2);
        }
        byte[] bArr3 = new byte[bArr.length + 1 + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        bArr3[bArr.length] = 46;
        System.arraycopy(bArr2, 0, bArr3, bArr.length + 1, bArr2.length);
        return sign(bArr3);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.description;
    }

    public static Algorithm hmac512(byte[] bArr) throws IllegalArgumentException {
        return new HMACAlgorithm(JsonWebSignature.HMAC_SHA512, KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA512, bArr);
    }
}
