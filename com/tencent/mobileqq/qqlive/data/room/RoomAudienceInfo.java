package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RoomAudienceInfo {
    static IPatchRedirector $redirector_;
    public int fakeTotalPeople;
    public int userCount;

    public RoomAudienceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
