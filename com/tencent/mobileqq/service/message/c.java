package com.tencent.mobileqq.service.message;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(AppInterface appInterface, String str) {
        String currentAccountUin = appInterface.getCurrentAccountUin();
        String qqStr = HardCodeUtil.qqStr(R.string.f213365q0);
        long K0 = e.K0();
        MessageRecord d16 = q.d(MessageRecord.MSG_TYPE_SHIELD_MSG);
        d16.init(currentAccountUin, str, currentAccountUin, qqStr, K0, 0, 0, K0);
        d16.msgtype = MessageRecord.MSG_TYPE_SHIELD_MSG;
        d16.isread = true;
        ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).addMessage(d16, currentAccountUin);
    }

    public static void b(AppInterface appInterface, String str) {
        String currentAccountUin = appInterface.getCurrentAccountUin();
        String qqStr = HardCodeUtil.qqStr(R.string.o3l);
        long K0 = e.K0();
        MessageRecord d16 = q.d(MessageRecord.MSG_TYPE_SHIELD_MSG);
        d16.init(currentAccountUin, str, currentAccountUin, qqStr, K0, 0, 0, K0);
        d16.msgtype = MessageRecord.MSG_TYPE_SHIELD_MSG;
        boolean z16 = true;
        d16.isread = true;
        List<MessageRecord> msgList = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(str, 0);
        if (msgList != null && msgList.size() > 0 && ad.b(msgList.get(msgList.size() - 1), d16, false)) {
            if (QLog.isColorLevel()) {
                QLog.w("MessageUtils", 2, "inserShieldTipsForFriends filtered!");
            }
        } else {
            z16 = false;
        }
        if (!z16) {
            ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).addMessage(d16, currentAccountUin);
        }
    }
}
