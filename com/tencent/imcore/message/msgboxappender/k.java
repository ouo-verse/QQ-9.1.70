package com.tencent.imcore.message.msgboxappender;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class k implements b {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.msgboxappender.b
    public Object[] a(IMessageManager iMessageManager, MessageRecord messageRecord, EntityManager entityManager, Map<String, RecentUser> map, RecentUserProxy recentUserProxy, IConversationFacade iConversationFacade, String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Object[]) iPatchRedirector.redirect((short) 2, this, iMessageManager, messageRecord, entityManager, map, recentUserProxy, iConversationFacade, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        if (AppConstants.VOTE_MSG_UIN.equals(messageRecord.frienduin)) {
            synchronized (((C2CMessageManager) iMessageManager)) {
                List<? extends Entity> query = entityManager.query(MessageRecord.class, messageRecord.getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
                if (query != null) {
                    Iterator<? extends Entity> it = query.iterator();
                    while (it.hasNext()) {
                        entityManager.remove((MessageRecord) it.next());
                    }
                }
            }
            return new Object[]{Boolean.TRUE, str, Integer.valueOf(i3), Long.valueOf(j3)};
        }
        return new Object[]{Boolean.FALSE, str, Integer.valueOf(i3), Long.valueOf(j3)};
    }
}
