package com.tencent.imcore.message.facade.add.inner.end;

import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
class b implements com.tencent.imcore.message.facade.a<QQMessageFacade, QQAppInterface> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.facade.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(QQMessageFacade qQMessageFacade, QQAppInterface qQAppInterface, List<MessageRecord> list, BaseMessageManager.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQMessageFacade, qQAppInterface, list, aVar, Boolean.valueOf(z16));
            return;
        }
        for (String str : aVar.f116302g.keySet()) {
            EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) qQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
            List<MessageRecord> list2 = aVar.f116302g.get(str);
            if (list2 != null && !list2.isEmpty()) {
                Iterator<MessageRecord> it = list2.iterator();
                while (it.hasNext()) {
                    ecShopAssistantManager.c(it.next(), qQAppInterface);
                }
            }
        }
        aVar.f116302g.clear();
    }
}
