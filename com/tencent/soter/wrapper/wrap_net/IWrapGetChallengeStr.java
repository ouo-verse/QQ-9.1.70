package com.tencent.soter.wrapper.wrap_net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IWrapGetChallengeStr extends ISoterNetBaseWrapper<GetChallengeRequest, GetChallengeResult> {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class GetChallengeRequest {
        static IPatchRedirector $redirector_;

        public GetChallengeRequest() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class GetChallengeResult {
        static IPatchRedirector $redirector_;
        public String challenge;

        public GetChallengeResult(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.challenge = str;
            }
        }
    }
}
