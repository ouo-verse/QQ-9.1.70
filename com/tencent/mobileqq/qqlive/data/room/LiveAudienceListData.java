package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.PageData;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveAudienceListData extends PageData<LiveAudienceInfo> {
    static IPatchRedirector $redirector_;

    public LiveAudienceListData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
