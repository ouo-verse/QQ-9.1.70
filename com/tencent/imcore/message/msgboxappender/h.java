package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h implements b {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Object[] b(IMessageManager iMessageManager, MessageRecord messageRecord, String str, int i3, long j3) {
        boolean z16;
        C2CMessageManager c2CMessageManager = (C2CMessageManager) iMessageManager;
        Message lastMessage = c2CMessageManager.f116282e.getLastMessage(messageRecord.frienduin, messageRecord.istroop);
        INewFriendService iNewFriendService = (INewFriendService) c2CMessageManager.f116281d.getRuntimeService(INewFriendService.class, "");
        lastMessage.istroop = messageRecord.istroop;
        iNewFriendService.loadNewFriendMsg(false);
        int allUnreadMessageCount = iNewFriendService.getAllUnreadMessageCount();
        if (allUnreadMessageCount > 0) {
            if (!messageRecord.isSendFromLocal() && messageRecord.time < lastMessage.time) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                MessageRecord.copyMessageRecordBaseField(lastMessage, messageRecord);
                lastMessage.msgData = messageRecord.msgData;
                c2CMessageManager.f116282e.setIncomingMsg(lastMessage);
                try {
                    ((C2CMessageManager) iMessageManager).h(lastMessage);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "addMessageRecord ERROR", th5);
                    }
                }
                c2CMessageManager.f116282e.getIncomingMsg().unReadNum = allUnreadMessageCount;
            }
        } else {
            c2CMessageManager.f116282e.setIncomingMsg(null);
        }
        return new Object[]{Boolean.TRUE, str, Integer.valueOf(i3), Long.valueOf(j3)};
    }

    @Override // com.tencent.imcore.message.msgboxappender.b
    public Object[] a(IMessageManager iMessageManager, MessageRecord messageRecord, EntityManager entityManager, Map<String, RecentUser> map, RecentUserProxy recentUserProxy, IConversationFacade iConversationFacade, String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Object[]) iPatchRedirector.redirect((short) 2, this, iMessageManager, messageRecord, entityManager, map, recentUserProxy, iConversationFacade, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        if (!String.valueOf(AppConstants.MAYKNOW_RECOMMEND_UIN).equals(messageRecord.frienduin) && !AppConstants.FRIEND_ANNIVER_UIN.equals(messageRecord.frienduin)) {
            return new Object[]{Boolean.FALSE, str, Integer.valueOf(i3), Long.valueOf(j3)};
        }
        return b(iMessageManager, messageRecord, str, i3, j3);
    }
}
