package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ReportItem {
    static IPatchRedirector $redirector_;
    public boolean bFileExist;
    public boolean bNetWorkChange;
    public boolean bSend;
    public boolean bUserRetry;
    public int dwClientIP;
    public int dwServerIP;
    public int emResult;
    public int nFailCode;
    public int nUserCode;
    public String sSuffix;
    public String strPcSessionId;
    public byte uChannelType;
    public int uDevType;
    public int uDstInstId;
    public long uDuration;
    public long uFileSize;
    public int uFileType;
    public long uNotifyTime;
    public int uRetryCount;
    public long uSessionID;
    public int uSrcInstId;
    public long uStartPos;
    public long uTaskEnd;
    public long uTaskStart;
    public short wServerPort;

    public ReportItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
