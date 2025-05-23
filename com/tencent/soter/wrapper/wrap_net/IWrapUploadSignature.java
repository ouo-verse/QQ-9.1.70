package com.tencent.soter.wrapper.wrap_net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IWrapUploadSignature extends ISoterNetBaseWrapper<UploadSignatureRequest, UploadSignatureResult> {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class UploadSignatureRequest {
        static IPatchRedirector $redirector_;
        public String signatureData;
        public String signatureJson;
        public int signatureSaltLength;

        public UploadSignatureRequest(String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3));
                return;
            }
            this.signatureJson = str2;
            this.signatureSaltLength = i3;
            this.signatureData = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class UploadSignatureResult {
        static IPatchRedirector $redirector_;
        public boolean isVerified;

        public UploadSignatureResult(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.isVerified = z16;
            }
        }
    }
}
