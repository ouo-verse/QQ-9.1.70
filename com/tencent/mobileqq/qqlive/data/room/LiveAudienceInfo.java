package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveAudienceInfo extends LiveUserInfo {
    static IPatchRedirector $redirector_;
    public long contribution;
    public long enterTs;
    public long explicitId;

    public LiveAudienceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.data.user.LiveUserInfo
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "LiveAudienceInfo{uid=" + this.uid + ", contribution='" + this.contribution + '}';
    }
}
