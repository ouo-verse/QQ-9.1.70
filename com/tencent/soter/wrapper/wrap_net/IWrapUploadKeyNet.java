package com.tencent.soter.wrapper.wrap_net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IWrapUploadKeyNet extends ISoterNetBaseWrapper<UploadRequest, UploadResult> {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class UploadRequest {
        static IPatchRedirector $redirector_;
        public String mKeyJson;
        public String mKeyJsonSignature;

        public UploadRequest(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.mKeyJsonSignature = str;
                this.mKeyJson = str2;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class UploadResult {
        static IPatchRedirector $redirector_;
        public boolean mIsUploadAndVerifiedSuccess;

        public UploadResult(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.mIsUploadAndVerifiedSuccess = z16;
            }
        }
    }
}
