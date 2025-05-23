package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class v {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(QQAppInterface qQAppInterface, BaseMessageManager baseMessageManager, IMessageFacade iMessageFacade, String str, int i3, String str2, String str3, int i16, int i17, boolean z16) {
        RecentUser findRecentUserByUin;
        int o16 = ConfessMsgUtil.o(i16, i17);
        qQAppInterface.getMessageProxy(i3).k(str, i3, str2, str3, o16);
        Message lastMessage = iMessageFacade.getLastMessage(str, i3);
        String str4 = lastMessage.senderuin;
        if (str4 != null && str4.equals(str2)) {
            if (o16 == 0 || (o16 != 0 && o16 == lastMessage.getExtraKey())) {
                List<MessageRecord> p16 = qQAppInterface.getMessageProxy(i3).p(str, i3);
                if (p16 != null && !p16.isEmpty()) {
                    MessageRecord.copyMessageRecordBaseField(lastMessage, p16.get(p16.size() - 1));
                    lastMessage.frienduin = str;
                    lastMessage.emoRecentMsg = null;
                    try {
                        baseMessageManager.h(lastMessage);
                        return;
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", th5);
                            return;
                        }
                        return;
                    }
                }
                lastMessage.emoRecentMsg = null;
                lastMessage.f203106msg = null;
                ConfessMsgUtil.q(lastMessage);
                if (z16 && (findRecentUserByUin = qQAppInterface.getProxyManager().m().findRecentUserByUin(str, i3)) != null) {
                    iMessageFacade.removeRecentUser(findRecentUserByUin);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(QQAppInterface qQAppInterface, BaseMessageManager baseMessageManager, IMessageFacade iMessageFacade, String str, int i3, String str2, String str3, boolean z16) {
        String str4;
        Message lastMessage;
        String str5;
        RecentUser findRecentUserByUin;
        MessageRecord messageRecord;
        qQAppInterface.getMessageProxy(i3).k(str, i3, str2, str3, 0);
        if (i3 == 1010) {
            str4 = AppConstants.DATE_UIN;
        } else if (i3 != 1001 && i3 != 10002) {
            str4 = "";
        } else {
            str4 = AppConstants.LBS_HELLO_UIN;
        }
        String str6 = str4;
        if (!TextUtils.isEmpty(str6) && (str5 = (lastMessage = iMessageFacade.getLastMessage(str, i3)).senderuin) != null && str5.equals(str2)) {
            qQAppInterface.getMessageProxy(i3).k(str6, i3, str, str3, 0);
            List<MessageRecord> p16 = qQAppInterface.getMessageProxy(i3).p(str, i3);
            if (p16 != null && !p16.isEmpty()) {
                MessageRecord messageRecord2 = p16.get(p16.size() - 1);
                MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(messageRecord2.msgtype);
                MessageRecord.copyMessageRecordBaseField(d16, messageRecord2);
                d16.frienduin = str6;
                d16.senderuin = str;
                if (!ad.D(messageRecord2.msgtype)) {
                    messageRecord = messageRecord2;
                    baseMessageManager.c0(d16, null, false, true, 1);
                } else {
                    messageRecord = messageRecord2;
                }
                MessageRecord.copyMessageRecordBaseField(lastMessage, messageRecord);
                lastMessage.frienduin = str;
                lastMessage.emoRecentMsg = null;
                try {
                    baseMessageManager.h(lastMessage);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox decode msgInLBSBox ERROR", th5);
                    }
                }
            }
            Message lastMessage2 = iMessageFacade.getLastMessage(str6, i3);
            String str7 = lastMessage2.senderuin;
            if (str7 != null && str7.equals(str)) {
                List<MessageRecord> p17 = qQAppInterface.getMessageProxy(i3).p(str6, i3);
                if (p17 != null && !p17.isEmpty()) {
                    MessageRecord.copyMessageRecordBaseField(lastMessage2, p17.get(p17.size() - 1));
                    lastMessage2.frienduin = str6;
                    lastMessage2.emoRecentMsg = null;
                    try {
                        baseMessageManager.h(lastMessage2);
                        return;
                    } catch (Throwable th6) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", th6);
                            return;
                        }
                        return;
                    }
                }
                lastMessage2.emoRecentMsg = null;
                lastMessage2.f203106msg = null;
                if (z16 && (findRecentUserByUin = qQAppInterface.getProxyManager().m().findRecentUserByUin(str6, i3)) != null) {
                    iMessageFacade.removeRecentUser(findRecentUserByUin);
                }
            }
        }
    }
}
