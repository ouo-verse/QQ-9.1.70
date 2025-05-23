package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MsgCSBody0x211_0x7 {
    static IPatchRedirector $redirector_;
    public MsgHeader msgHeader;
    public FTNNotify[] pMsgBody0x211_0x7_0x1_FTNNotifySrc;
    public NFCNotify[] pMsgBody0x211_0x7_0x2_NFCNotifySrc;
    public FileControl[] pMsgBody0x211_0x7_0x3_FileControl;
    public RFCInfoNotify[] pMsgBody0x211_0x7_0x8_RFCInfoNotiy;
    public FTNNotify[] pMsgBody0x211_0x7_0x9_FTNNotifyThumb;
    public NFCNotify[] pMsgBody0x211_0x7_0xa_NFCNotifyThumb;
    public int uMsgSubCmd;

    public MsgCSBody0x211_0x7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
