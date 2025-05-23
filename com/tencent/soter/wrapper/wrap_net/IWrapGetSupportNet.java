package com.tencent.soter.wrapper.wrap_net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IWrapGetSupportNet extends ISoterNetBaseWrapper<GetSupportRequest, GetSupportResult> {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class GetSupportRequest {
        static IPatchRedirector $redirector_;
        public String requestJson;

        public GetSupportRequest(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.requestJson = str;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class GetSupportResult {
        static IPatchRedirector $redirector_;
        public boolean isSupport;
        public int supportType;

        public GetSupportResult(boolean z16) {
            this(z16, -1);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        }

        public GetSupportResult(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            } else {
                this.isSupport = z16;
                this.supportType = i3;
            }
        }
    }
}
