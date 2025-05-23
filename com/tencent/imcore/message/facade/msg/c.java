package com.tencent.imcore.message.facade.msg;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
class c implements com.tencent.imcore.message.facade.c<QQMessageFacade, QQAppInterface> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.facade.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Message a(QQMessageFacade qQMessageFacade, QQAppInterface qQAppInterface, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Message) iPatchRedirector.redirect((short) 2, this, qQMessageFacade, qQAppInterface, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (str == null) {
            return null;
        }
        String f16 = ao.f(str, i3);
        Message message = qQMessageFacade.f116349e.get(f16);
        if (message == null) {
            String tableName = MessageRecord.getTableName(str, i3);
            String oldTableName = MessageRecord.getOldTableName(str, i3);
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
            if (!createEntityManager.tabbleIsExist(tableName) && !createEntityManager.tabbleIsExist(oldTableName)) {
                if (message == null) {
                    message = new Message();
                    message.frienduin = str;
                    message.istroop = i3;
                    qQMessageFacade.f116349e.put(f16, message);
                } else {
                    message.isCacheValid = true;
                }
            } else {
                message = qQMessageFacade.Q.f(str, i3, createEntityManager);
            }
            createEntityManager.close();
        }
        if (message != null && ao.z(message.frienduin, message.istroop)) {
            message.istroop = ao.c(message.istroop);
        }
        return message;
    }
}
