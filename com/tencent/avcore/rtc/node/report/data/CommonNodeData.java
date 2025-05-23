package com.tencent.avcore.rtc.node.report.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CommonNodeData {
    static IPatchRedirector $redirector_;
    public int accoutType;
    public int businessType;
    public int callType;
    public String deviceType;
    public int msgLinkType;
    public String osVersion;
    public String peerAccout;
    public String platform;
    public long roomId;
    public int sdkVersion;
    public String selfAccout;
    public String traceId;

    public CommonNodeData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sdkVersion = 10036;
        this.selfAccout = "";
        this.peerAccout = "";
        this.platform = "";
        this.deviceType = "";
        this.osVersion = "";
        this.callType = NodeModel$CallType.K_SINGLE_PERSON.ordinal();
        this.traceId = "";
        this.msgLinkType = NodeModel$MsgLinkType.MSF.ordinal();
    }
}
