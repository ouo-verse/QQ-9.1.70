package com.tencent.mobileqq.app.message;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.GrayTipsSpan;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.util.aw;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AddMessageHelper", 2, "-----addDatingSafetyGrayTipsMessage  frienduin:" + str + " istroop\uff1a" + i3 + " msg:" + aw.a(str2));
        }
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        MessageForGrayTips messageForGrayTips = (MessageForGrayTips) q.d(MessageRecord.MSG_TYPE_NEARBY_DATING_SAFETY_TIP);
        messageForGrayTips.init(qQAppInterface.getCurrentAccountUin(), str, qQAppInterface.getCurrentAccountUin(), str2, K0, MessageRecord.MSG_TYPE_NEARBY_DATING_SAFETY_TIP, i3, K0);
        messageForGrayTips.isread = true;
        if (!MessageHandlerUtils.msgFilterForDatingSafetyTip(qQAppInterface, messageForGrayTips)) {
            qQAppInterface.getMessageFacade().c(messageForGrayTips, qQAppInterface.getCurrentAccountUin());
        }
    }

    public static void b(AppInterface appInterface, String str, String str2, int i3, ArrayList<GrayTipsSpan> arrayList, boolean z16, boolean z17, boolean z18) {
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("AddMessageHelper", 2, "-----addGrayTipsMessage  frienduin:" + str + " istroop\uff1a" + i3 + " msg:" + aw.a(str2));
        }
        if (z16 && ad.K(i3) && QLog.isColorLevel()) {
            QLog.d("AddMessageHelper", 2, "-----addGrayTipsMessage faild : no troop uin");
        }
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        if (z16) {
            i16 = -5001;
        } else {
            i16 = -5000;
        }
        int i17 = i16;
        Message lastMessage = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getLastMessage(str, i3);
        MessageForNewGrayTips messageForNewGrayTips = (MessageForNewGrayTips) q.d(i17);
        messageForNewGrayTips.init(appInterface.getCurrentAccountUin(), str, appInterface.getCurrentAccountUin(), str2, K0, i17, i3, K0);
        if (lastMessage != null) {
            messageForNewGrayTips.shmsgseq = lastMessage.shmsgseq;
        }
        messageForNewGrayTips.isread = z18;
        messageForNewGrayTips.spans = arrayList;
        messageForNewGrayTips.updateMsgData();
        if (!z17 || !MessageHandlerUtils.msgFilter(appInterface, messageForNewGrayTips, false)) {
            ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).addMessage(messageForNewGrayTips, appInterface.getCurrentAccountUin());
        }
    }

    public static void c(AppInterface appInterface, String str, String str2, int i3, boolean z16, boolean z17) {
        b(appInterface, str, str2, i3, null, z16, z17, true);
    }
}
