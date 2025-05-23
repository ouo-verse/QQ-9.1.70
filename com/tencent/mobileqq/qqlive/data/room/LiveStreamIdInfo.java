package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveStreamIdInfo {
    static IPatchRedirector $redirector_;
    public String auxStreamId;
    public boolean isSelfInfo;
    public String mainStreamId;
    public long originRoomId;
    public long originUid;
    public long roomId;
    public long uid;

    public LiveStreamIdInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
