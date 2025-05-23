package com.tencent.tuxmetersdk.jwt.algorithms;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.jwt.exceptions.SignatureGenerationException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes27.dex */
public class HMACAlgorithm extends Algorithm {
    static IPatchRedirector $redirector_;
    private final CryptoHelper crypto;
    private final byte[] secret;

    HMACAlgorithm(CryptoHelper cryptoHelper, String str, String str2, byte[] bArr) throws IllegalArgumentException {
        super(str, str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cryptoHelper, str, str2, bArr);
        } else {
            if (bArr != null) {
                this.secret = Arrays.copyOf(bArr, bArr.length);
                this.crypto = cryptoHelper;
                return;
            }
            throw new IllegalArgumentException("The Secret cannot be null");
        }
    }

    static byte[] getSecretBytes(String str) throws IllegalArgumentException {
        if (str != null) {
            return str.getBytes(StandardCharsets.UTF_8);
        }
        throw new IllegalArgumentException("The Secret cannot be null");
    }

    @Override // com.tencent.tuxmetersdk.jwt.algorithms.Algorithm
    public byte[] sign(byte[] bArr, byte[] bArr2) throws SignatureGenerationException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr, (Object) bArr2);
        }
        try {
            return this.crypto.createSignatureFor(getDescription(), this.secret, bArr, bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException e16) {
            throw new SignatureGenerationException(this, e16);
        }
    }

    @Override // com.tencent.tuxmetersdk.jwt.algorithms.Algorithm
    public byte[] sign(byte[] bArr) throws SignatureGenerationException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
        }
        try {
            return this.crypto.createSignatureFor(getDescription(), this.secret, bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException e16) {
            throw new SignatureGenerationException(this, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HMACAlgorithm(String str, String str2, byte[] bArr) throws IllegalArgumentException {
        this(new CryptoHelper(), str, str2, bArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HMACAlgorithm(String str, String str2, String str3) throws IllegalArgumentException {
        this(new CryptoHelper(), str, str2, getSecretBytes(str3));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, str, str2, str3);
    }
}
