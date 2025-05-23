package com.tencent.mars.comm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AndroidCertVerifyResult {
    static IPatchRedirector $redirector_;
    private final List<X509Certificate> mCertificateChain;
    private final boolean mIsIssuedByHostMatched;
    private final boolean mIsIssuedByKnownRoot;
    private final int mStatus;

    public AndroidCertVerifyResult(int i3, boolean z16, List<X509Certificate> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), list);
            return;
        }
        this.mStatus = i3;
        this.mIsIssuedByKnownRoot = z16;
        this.mCertificateChain = new ArrayList(list);
        this.mIsIssuedByHostMatched = false;
    }

    public byte[][] getCertificateChainEncoded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[][]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        byte[][] bArr = new byte[this.mCertificateChain.size()];
        for (int i3 = 0; i3 < this.mCertificateChain.size(); i3++) {
            try {
                bArr[i3] = this.mCertificateChain.get(i3).getEncoded();
            } catch (CertificateEncodingException unused) {
                return new byte[0];
            }
        }
        return bArr;
    }

    public int getStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mStatus;
    }

    public boolean isIssuedByHostMatched() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mIsIssuedByHostMatched;
    }

    public boolean isIssuedByKnownRoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.mIsIssuedByKnownRoot;
    }

    public AndroidCertVerifyResult(int i3, boolean z16, List<X509Certificate> list, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), list, Boolean.valueOf(z17));
            return;
        }
        this.mStatus = i3;
        this.mIsIssuedByKnownRoot = z16;
        this.mCertificateChain = new ArrayList(list);
        this.mIsIssuedByHostMatched = z17;
    }

    public AndroidCertVerifyResult(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        this.mStatus = i3;
        this.mIsIssuedByKnownRoot = false;
        this.mCertificateChain = Collections.emptyList();
        this.mIsIssuedByHostMatched = false;
    }
}
