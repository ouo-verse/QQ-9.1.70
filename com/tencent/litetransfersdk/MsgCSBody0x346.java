package com.tencent.litetransfersdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MsgCSBody0x346 {
    static IPatchRedirector $redirector_;
    public ApplyCopyToReq applyCopyToReq;
    public FileQueryReq fileQueryReq;
    public ApplyDownloadReq pMsgBody0x346_1200;
    public ApplyUploadHitReq pMsgBody0x346_1800;
    public UploadSuccReq pMsgBody0x346_800;
    public DeleteFileReq pMsgBody0x346_900;
    public ApplyUploadReq pMsgBody0x346_uploadReq;
    public int uMsgSubType;
    public int uint32_business_id;

    public MsgCSBody0x346() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
