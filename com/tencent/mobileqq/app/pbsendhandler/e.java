package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e implements IPbSendReqHandler {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        if (((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).f194692h) {
            if (QLog.isColorLevel()) {
                QLog.d(KplRoleInfo.KPL_TAG, 2, "get kpl global flag");
            }
            messageRecord.saveExtInfoToExtStr(KplRoleInfo.MSG_EXT_KEY, "Y");
            String str = messageRecord.frienduin;
            int i3 = messageRecord.istroop;
            long j3 = messageRecord.uniseq;
            qQAppInterface.getMessageFacade().a1(str, i3, j3, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
            qQAppInterface.getMessageFacade().a1(str, i3, j3, AppConstants.Key.COLUMN_EXT_LONG, Integer.valueOf(messageRecord.extLong));
        }
    }

    @Override // com.tencent.mobileqq.app.pbsendhandler.IPbSendReqHandler
    public msg_svc$PbSendMsgReq handlePbSendMsg(AppInterface appInterface, MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext, int i3, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (msg_svc$PbSendMsgReq) iPatchRedirector.redirect((short) 2, this, appInterface, messageRecord, im_msg_body_richtext, Integer.valueOf(i3), msg_svc_pbsendmsgreq);
        }
        a((QQAppInterface) appInterface, messageRecord);
        return msg_svc_pbsendmsgreq;
    }
}
