package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class BaseRoomStatus {
    static IPatchRedirector $redirector_ = null;
    public static final int SUPERVISE_KICK_OFF = 10;
    public static final int VIDEO_CLOSE = 0;
    public static final int VIDEO_OPEN = 1;
    public static final int VIDEO_PAUSE = 2;
    public static final int VIDEO_RESUME = 3;

    public BaseRoomStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
