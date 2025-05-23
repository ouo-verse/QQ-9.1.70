package com.tencent.avcore.jni.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SocketInfo {
    static IPatchRedirector $redirector_;
    public int chnType;
    public String destIP;
    public int destPort;
    public int familyType;

    /* renamed from: fd, reason: collision with root package name */
    public int f77483fd;

    /* renamed from: protocol, reason: collision with root package name */
    public int f77484protocol;
    public String srcIP;
    public int srcPort;

    public SocketInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.familyType = 0;
        this.srcIP = "";
        this.srcPort = 0;
        this.destIP = "";
        this.destPort = 0;
        this.f77484protocol = 0;
        this.f77483fd = -1;
        this.chnType = 0;
    }

    public static boolean isSame(SocketInfo socketInfo, SocketInfo socketInfo2) {
        if (socketInfo == socketInfo2) {
            return true;
        }
        if (socketInfo == null || socketInfo2 == null) {
            return false;
        }
        if (socketInfo.familyType == socketInfo2.familyType && socketInfo.srcIP.equalsIgnoreCase(socketInfo2.srcIP) && socketInfo.destIP.equalsIgnoreCase(socketInfo2.destIP) && socketInfo.srcPort == socketInfo2.srcPort && socketInfo.destPort == socketInfo2.destPort && socketInfo.f77484protocol == socketInfo2.f77484protocol && socketInfo.f77483fd == socketInfo2.f77483fd && socketInfo.chnType == socketInfo2.chnType) {
            return true;
        }
        return false;
    }
}
