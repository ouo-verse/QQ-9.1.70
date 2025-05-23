package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e implements b {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Object[] b(IMessageManager iMessageManager, MessageRecord messageRecord, IConversationFacade iConversationFacade, Map<String, RecentUser> map, RecentUserProxy recentUserProxy, String str, int i3, long j3, String str2, int i16) {
        if ((iConversationFacade.isUinInRecentNotSubAccount(messageRecord.senderuin) || map.containsKey(ao.f(messageRecord.senderuin, messageRecord.istroop))) && !RecentUtil.b((QQAppInterface) ((C2CMessageManager) iMessageManager).f116281d, messageRecord.senderuin)) {
            recentUserProxy.delAllRecentUserByUin(messageRecord.senderuin);
        }
        ((C2CMessageManager) iMessageManager).B0(messageRecord, str2, messageRecord.frienduin);
        return new Object[]{Boolean.TRUE, str2, Integer.valueOf(i16), Long.valueOf(messageRecord.time)};
    }

    @Override // com.tencent.imcore.message.msgboxappender.b
    public Object[] a(IMessageManager iMessageManager, MessageRecord messageRecord, EntityManager entityManager, Map<String, RecentUser> map, RecentUserProxy recentUserProxy, IConversationFacade iConversationFacade, String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Object[]) iPatchRedirector.redirect((short) 2, this, iMessageManager, messageRecord, entityManager, map, recentUserProxy, iConversationFacade, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        if (ao.c(messageRecord.istroop) == 1044) {
            return b(iMessageManager, messageRecord, iConversationFacade, map, recentUserProxy, str, i3, j3, AppConstants.MATCH_CHAT_UIN, 1044);
        }
        if (ao.c(messageRecord.istroop) == 10008) {
            return b(iMessageManager, messageRecord, iConversationFacade, map, recentUserProxy, str, i3, j3, AppConstants.QCIRCLE_CHAT_UIN, 10008);
        }
        return new Object[]{Boolean.FALSE, str, Integer.valueOf(i3), Long.valueOf(j3)};
    }
}
