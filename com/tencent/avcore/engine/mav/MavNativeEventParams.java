package com.tencent.avcore.engine.mav;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class MavNativeEventParams {
    static IPatchRedirector $redirector_;
    public int bufferLen;
    public byte[] detail;
    public long elapsedRealtime;

    @Deprecated
    public Object extraObj;
    public int flag;
    public long groupId;
    public long info;
    public int multiAVType;
    public int multiSubType;

    @Deprecated
    public int param4;
    public int relationType;

    public MavNativeEventParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
