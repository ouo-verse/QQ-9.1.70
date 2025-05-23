package com.tencent.imcore.message.facade.add.inner.end;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
class e implements com.tencent.imcore.message.facade.a<QQMessageFacade, QQAppInterface> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(BaseMessageManager.a aVar, Message message) {
        com.tencent.mobileqq.troop.data.c a16;
        int f16;
        if (message != null) {
            int i3 = message.istroop;
            if (i3 == 1) {
                com.tencent.mobileqq.troop.data.c a17 = ((com.tencent.mobileqq.model.d) aVar.f116304i).a(message.frienduin);
                if (a17 != null && a17.g() == message.shmsgseq) {
                    f16 = a17.f();
                }
                f16 = 0;
            } else if (i3 == 3000) {
                com.tencent.mobileqq.troop.data.c a18 = ((com.tencent.mobileqq.model.d) aVar.f116304i).a(message.frienduin + ContainerUtils.FIELD_DELIMITER + 3000);
                if (a18 != null && a18.g() == message.shmsgseq) {
                    f16 = a18.d();
                }
                f16 = 0;
            } else {
                if (i3 == 10014 && (a16 = ((com.tencent.mobileqq.model.b) aVar.f116305j).a(message.frienduin)) != null && a16.g() == message.shmsgseq) {
                    f16 = a16.f();
                }
                f16 = 0;
            }
            message.bizType = f16;
        }
    }

    private void d(QQMessageFacade qQMessageFacade, QQAppInterface qQAppInterface, BaseMessageManager.a aVar, Message message, RecentUser recentUser) {
        RecentUtil.K0(recentUser, qQMessageFacade);
        aVar.f116306k.saveRecentUser(recentUser);
        if (recentUser.getType() == 1038) {
            ((AppletsFolderManager) qQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).f(recentUser);
        }
        if (message != null) {
            int i3 = message.istroop;
            if (i3 == 3000) {
                ((com.tencent.mobileqq.model.d) aVar.f116304i).b(recentUser.uin + ContainerUtils.FIELD_DELIMITER + 3000);
                return;
            }
            if (i3 != 10014) {
                ((com.tencent.mobileqq.model.d) aVar.f116304i).b(recentUser.uin);
            }
        }
    }

    @Override // com.tencent.imcore.message.facade.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(QQMessageFacade qQMessageFacade, QQAppInterface qQAppInterface, List<MessageRecord> list, BaseMessageManager.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQMessageFacade, qQAppInterface, list, aVar, Boolean.valueOf(z16));
            return;
        }
        Message v16 = qQMessageFacade.v1();
        b(aVar, v16);
        Iterator<String> it = aVar.f116296a.keySet().iterator();
        while (it.hasNext()) {
            try {
                d(qQMessageFacade, qQAppInterface, aVar, v16, aVar.f116296a.get(it.next()));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("InComingMsgProcessor", 2, "addMultiMessagesInner --> Catch Exception .Info = " + e16);
                }
            }
        }
    }
}
