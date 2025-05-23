package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.oidb.oidb_0xdea$PassThrough;

/* compiled from: P */
/* loaded from: classes11.dex */
public class l implements IGeneralFlagProvider {
    static IPatchRedirector $redirector_;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(MessageRecord messageRecord, boolean z16, generalflags$ResvAttr generalflags_resvattr) {
        if (messageRecord instanceof MessageForReplyText) {
            MessageForReplyText messageForReplyText = (MessageForReplyText) messageRecord;
            if (messageForReplyText.isBarrageMsg) {
                generalflags_resvattr.uint32_comment_flag.set(1);
                generalflags_resvattr.uint64_comment_location.set(messageForReplyText.barrageTimeLocation);
                oidb_0xdea$PassThrough oidb_0xdea_passthrough = new oidb_0xdea$PassThrough();
                oidb_0xdea_passthrough.entrance.set(messageForReplyText.barrageSourceMsgType);
                oidb_0xdea_passthrough.uint32_client_type.set(1);
                generalflags_resvattr.bytes_pass_through.set(ByteStringMicro.copyFrom(oidb_0xdea_passthrough.toByteArray()));
            }
            if (QLog.isColorLevel()) {
                QLog.d(MessageHandlerUtils.TAG, 2, "send replay msg, isBarrageMsg: ", Boolean.valueOf(messageForReplyText.isBarrageMsg), " timeLocation:", Long.valueOf(messageForReplyText.barrageTimeLocation), " type:", Integer.valueOf(messageForReplyText.barrageSourceMsgType));
            }
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
