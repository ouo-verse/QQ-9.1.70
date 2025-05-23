package com.tencent.mobileqq.app.generalflag;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
/* loaded from: classes11.dex */
public class p implements IGeneralFlagProvider {
    static IPatchRedirector $redirector_;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(MessageRecord messageRecord, boolean z16, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        if (messageRecord instanceof MessageForLongTextMsg) {
            MessageForLongTextMsg messageForLongTextMsg = (MessageForLongTextMsg) messageRecord;
            if (messageForLongTextMsg.structingMsg != null) {
                im_msg_body_generalflags.long_text_flag.set(1);
                im_msg_body_generalflags.long_text_resid.set(ByteStringMicro.copyFromUtf8(messageForLongTextMsg.structingMsg.mResid));
            } else {
                return z16;
            }
        } else if (messageRecord instanceof MessageForArkApp) {
            MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord;
            if (!TextUtils.isEmpty(messageForArkApp.resIDForLongMsg)) {
                im_msg_body_generalflags.long_text_flag.set(1);
                im_msg_body_generalflags.long_text_resid.set(ByteStringMicro.copyFromUtf8(messageForArkApp.resIDForLongMsg));
            } else {
                return z16;
            }
        } else if (messageRecord instanceof MessageForArkBabyqReply) {
            MessageForArkBabyqReply messageForArkBabyqReply = (MessageForArkBabyqReply) messageRecord;
            if (!TextUtils.isEmpty(messageForArkBabyqReply.resIDForLongMsg)) {
                im_msg_body_generalflags.long_text_flag.set(1);
                im_msg_body_generalflags.long_text_resid.set(ByteStringMicro.copyFromUtf8(messageForArkBabyqReply.resIDForLongMsg));
            } else {
                return z16;
            }
        } else {
            return z16;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider
    public boolean[] getGeneralFlagElemFromMsg(AppInterface appInterface, boolean z16, boolean z17, MessageRecord messageRecord, generalflags$ResvAttr generalflags_resvattr, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (boolean[]) iPatchRedirector.redirect((short) 2, this, appInterface, Boolean.valueOf(z16), Boolean.valueOf(z17), messageRecord, generalflags_resvattr, msg_svc_pbsendmsgreq, im_msg_body_generalflags);
        }
        return new boolean[]{a(messageRecord, z16, im_msg_body_generalflags), z17};
    }
}
