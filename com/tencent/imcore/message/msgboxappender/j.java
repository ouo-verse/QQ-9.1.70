package com.tencent.imcore.message.msgboxappender;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.Map;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes7.dex */
public class j implements b {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.msgboxappender.b
    public Object[] a(IMessageManager iMessageManager, MessageRecord messageRecord, EntityManager entityManager, Map<String, RecentUser> map, RecentUserProxy recentUserProxy, IConversationFacade iConversationFacade, String str, int i3, long j3) {
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Object[]) iPatchRedirector.redirect((short) 2, this, iMessageManager, messageRecord, entityManager, map, recentUserProxy, iConversationFacade, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        if (String.valueOf(AppConstants.SYSTEM_MSG_UIN).equals(messageRecord.frienduin)) {
            if (messageRecord instanceof MessageForSystemMsg) {
                structmsg$StructMsg systemMsg = ((MessageForSystemMsg) messageRecord).getSystemMsg();
                if (systemMsg != null) {
                    messageRecord.time = systemMsg.msg_time.get();
                }
                j16 = messageRecord.time;
            } else {
                j16 = j3;
            }
            return new Object[]{Boolean.TRUE, str, Integer.valueOf(i3), Long.valueOf(j16)};
        }
        return new Object[]{Boolean.FALSE, str, Integer.valueOf(i3), Long.valueOf(j3)};
    }
}
