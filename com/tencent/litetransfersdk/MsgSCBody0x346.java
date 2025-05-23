package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MsgSCBody0x346 {
    static IPatchRedirector $redirector_;
    public ApplyCopyToRsp applyCopyToRsp;
    public FileQueryRsp fileQueryRsp;
    public ApplyDownloadRsp pMsgBody0x346_1210;
    public ApplyUploadHitRsp pMsgBody0x346_1810;
    public UploadSuccRsp pMsgBody0x346_810;
    public DeleteFileRsp pMsgBody0x346_910;
    public ApplyUploadRsp pMsgBody0x346_uploadRsp;
    public int uMsgSubType;

    public MsgSCBody0x346() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
