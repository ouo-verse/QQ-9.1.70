package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements IGeneralFlagProvider {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(MessageRecord messageRecord, boolean z16, generalflags$ResvAttr generalflags_resvattr) {
        int f16;
        if (((messageRecord instanceof MessageForFile) || (messageRecord instanceof MessageForTroopFile)) && (f16 = com.tencent.mobileqq.filemanager.util.k.f(messageRecord)) != 0) {
            generalflags_resvattr.unit32_file_from_scene.set(f16);
            z16 = true;
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(messageRecord.frienduin)) {
            int d16 = com.tencent.mobileqq.filemanager.fileassistant.util.h.d();
            generalflags_resvattr.uint32_device_type.set(d16);
            com.tencent.mobileqq.filemanager.fileassistant.util.h.x(messageRecord, d16);
            return true;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider
    public boolean[] getGeneralFlagElemFromMsg(AppInterface appInterface, boolean z16, boolean z17, MessageRecord messageRecord, generalflags$ResvAttr generalflags_resvattr, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (boolean[]) iPatchRedirector.redirect((short) 2, this, appInterface, Boolean.valueOf(z16), Boolean.valueOf(z17), messageRecord, generalflags_resvattr, msg_svc_pbsendmsgreq, im_msg_body_generalflags);
        }
        return new boolean[]{z16, a(messageRecord, z17, generalflags_resvattr)};
    }
}
