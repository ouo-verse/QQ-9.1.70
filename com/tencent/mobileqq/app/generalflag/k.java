package com.tencent.mobileqq.app.generalflag;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$GeneralFlags;

/* compiled from: P */
/* loaded from: classes11.dex */
public class k implements IGeneralFlagProvider {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(im_msg_body$GeneralFlags im_msg_body_generalflags, generalflags$ResvAttr generalflags_resvattr, boolean z16, MessageForFoldMsg messageForFoldMsg, boolean z17) {
        if (!z17) {
            im_msg_body_generalflags.uint64_uin.set(messageForFoldMsg.mPasswdRedBagSender);
        }
        im_msg_body_generalflags.uint32_prp_fold.set(messageForFoldMsg.foldFlagTemp ? 1 : 0);
        if (!TextUtils.isEmpty(messageForFoldMsg.redBagId) && !z17) {
            im_msg_body_generalflags.bytes_rp_id.set(ByteStringMicro.copyFromUtf8(messageForFoldMsg.redBagId));
        }
        if (!TextUtils.isEmpty(messageForFoldMsg.redBagIndex) && z16) {
            im_msg_body_generalflags.bytes_rp_index.set(ByteStringMicro.copyFromUtf8(messageForFoldMsg.redBagIndex));
            generalflags_resvattr.redbag_msg_sender_uin.set(messageForFoldMsg.mPasswdRedBagSender);
        }
    }

    @Override // com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider
    public boolean[] getGeneralFlagElemFromMsg(AppInterface appInterface, boolean z16, boolean z17, MessageRecord messageRecord, generalflags$ResvAttr generalflags_resvattr, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        boolean z18;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (boolean[]) iPatchRedirector.redirect((short) 2, this, appInterface, Boolean.valueOf(z16), Boolean.valueOf(z17), messageRecord, generalflags_resvattr, msg_svc_pbsendmsgreq, im_msg_body_generalflags);
        }
        if (messageRecord instanceof MessageForFoldMsg) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (com.tencent.mobileqq.managers.g.d(qQAppInterface)) {
                boolean c16 = com.tencent.mobileqq.managers.g.c(qQAppInterface);
                com.tencent.mobileqq.managers.g gVar = (com.tencent.mobileqq.managers.g) appInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
                MessageForFoldMsg messageForFoldMsg = (MessageForFoldMsg) messageRecord;
                if (messageForFoldMsg.redBagId != null && com.tencent.mobileqq.managers.g.c((QQAppInterface) appInterface)) {
                    if (c16 && !gVar.f243718m) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    a(im_msg_body_generalflags, generalflags_resvattr, c16, messageForFoldMsg, z26);
                    z18 = true;
                    z19 = true;
                } else {
                    z18 = z16;
                    z19 = z17;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("msgFold", 2, String.format("Send, pack foldMsg, senderUin: %d, foldFlag: %s, redBagId: %s", Long.valueOf(messageForFoldMsg.mPasswdRedBagSender), Integer.valueOf(messageForFoldMsg.foldFlagTemp ? 1 : 0), messageForFoldMsg.redBagId));
                    QLog.d("msgFold", 2, String.format("Send, send foldMsg, frienduin: %s, msguid: %s, shmsgseq: %s content: %s", messageForFoldMsg.frienduin, Long.valueOf(messageForFoldMsg.msgUid), Long.valueOf(messageForFoldMsg.shmsgseq), messageForFoldMsg.getLogColorContent()));
                }
                return new boolean[]{z18, z19};
            }
        }
        z18 = z16;
        z19 = z17;
        return new boolean[]{z18, z19};
    }
}
