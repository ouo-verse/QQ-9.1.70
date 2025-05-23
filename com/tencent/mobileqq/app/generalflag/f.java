package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f implements IGeneralFlagProvider {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    private void b(generalflags$ResvAttr generalflags_resvattr, String str, int i3) {
        boolean z16 = true;
        if ((i3 & 1) != 1) {
            z16 = false;
        }
        if (z16) {
            generalflags_resvattr.uint32_msg_info_flag.set(i3);
            if (QLog.isColorLevel()) {
                QLog.i(MessageHandlerUtils.TAG, 2, "getGeneralFlagElemFromMsg: invoked.  containPasteExtra: " + str);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider
    public boolean[] getGeneralFlagElemFromMsg(AppInterface appInterface, boolean z16, boolean z17, MessageRecord messageRecord, generalflags$ResvAttr generalflags_resvattr, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (boolean[]) iPatchRedirector.redirect((short) 2, this, appInterface, Boolean.valueOf(z16), Boolean.valueOf(z17), messageRecord, generalflags_resvattr, msg_svc_pbsendmsgreq, im_msg_body_generalflags);
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("key_message_extra_info_flag");
        b(generalflags_resvattr, extInfoFromExtStr, a(extInfoFromExtStr));
        return new boolean[]{z16, z17};
    }
}
