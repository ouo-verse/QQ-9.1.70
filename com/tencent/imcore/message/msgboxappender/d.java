package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.AppConstants;
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
public class d implements b {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Object[] b(IMessageManager iMessageManager, MessageRecord messageRecord, IConversationFacade iConversationFacade, Map<String, RecentUser> map, RecentUserProxy recentUserProxy, String str, int i3, long j3) {
        boolean z16;
        String str2;
        if (iConversationFacade.isUinInRecentNotSubAccount(messageRecord.senderuin) || map.containsKey(ao.f(messageRecord.senderuin, messageRecord.istroop))) {
            recentUserProxy.delAllRecentUserByUin(messageRecord.senderuin);
        }
        boolean h16 = com.tencent.mobileqq.dating.i.h();
        if (ao.B(messageRecord)) {
            C2CMessageManager c2CMessageManager = (C2CMessageManager) iMessageManager;
            String str3 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
            c2CMessageManager.B0(messageRecord, str3, messageRecord.senderuin);
            if (!h16) {
                c2CMessageManager.B0(messageRecord, AppConstants.LBS_HELLO_UIN, str3);
            }
            c2CMessageManager.B0(messageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, str3);
            if (!messageRecord.isread) {
                iConversationFacade.addNewSayHelloToSet(1001, messageRecord.senderuin);
            }
            z16 = false;
        } else {
            String str4 = messageRecord.frienduin;
            String str5 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
            if (iConversationFacade.isInMsgBox(str4, 1001, str5)) {
                C2CMessageManager c2CMessageManager2 = (C2CMessageManager) iMessageManager;
                c2CMessageManager2.W(str5, 1001, messageRecord.senderuin, c2CMessageManager2.f116281d.getCurrentAccountUin());
            }
            if (com.tencent.mobileqq.dating.i.j(messageRecord)) {
                ((C2CMessageManager) iMessageManager).B0(messageRecord, AppConstants.LBS_HELLO_UIN, messageRecord.senderuin);
                z16 = true;
            } else {
                z16 = false;
            }
            if (!com.tencent.mobileqq.dating.i.g(messageRecord.msgtype, messageRecord.senderuin) && messageRecord.istroop == 1001) {
                ((C2CMessageManager) iMessageManager).B0(messageRecord, AppConstants.NEARBY_LBS_HELLO_UIN, messageRecord.senderuin);
            }
        }
        if (!z16) {
            str2 = AppConstants.NEARBY_LBS_HELLO_UIN;
        } else {
            str2 = AppConstants.LBS_HELLO_UIN;
        }
        messageRecord.frienduin = messageRecord.senderuin;
        return new Object[]{Boolean.TRUE, str2, Integer.valueOf(i3), Long.valueOf(j3)};
    }

    @Override // com.tencent.imcore.message.msgboxappender.b
    public Object[] a(IMessageManager iMessageManager, MessageRecord messageRecord, EntityManager entityManager, Map<String, RecentUser> map, RecentUserProxy recentUserProxy, IConversationFacade iConversationFacade, String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Object[]) iPatchRedirector.redirect((short) 2, this, iMessageManager, messageRecord, entityManager, map, recentUserProxy, iConversationFacade, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(messageRecord.frienduin)) {
            return b(iMessageManager, messageRecord, iConversationFacade, map, recentUserProxy, str, i3, j3);
        }
        return new Object[]{Boolean.FALSE, str, Integer.valueOf(i3), Long.valueOf(j3)};
    }
}
