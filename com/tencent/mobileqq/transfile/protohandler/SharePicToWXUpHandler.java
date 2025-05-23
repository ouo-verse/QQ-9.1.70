package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import tencent.im.cs.cmd0x352.cmd0x352$TryUpImgReq;

/* loaded from: classes19.dex */
public class SharePicToWXUpHandler extends C2CPicUpHandler {
    static IPatchRedirector $redirector_;

    public SharePicToWXUpHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.C2CPicUpHandler
    protected void setBuType(cmd0x352$TryUpImgReq cmd0x352_tryupimgreq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cmd0x352_tryupimgreq);
        } else {
            cmd0x352_tryupimgreq.uint32_bu_type.set(96);
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.C2CPicUpHandler
    protected void setSsoCmd(ProtoReqManagerImpl.ProtoReq protoReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) protoReq);
        } else {
            protoReq.ssoCmd = RichMediaConstants.CMD_LONGCONN_SHARE_PIC_TO_WX;
        }
    }
}
