package com.tencent.imcore.message.facade.add.inner.end;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
class f implements com.tencent.imcore.message.facade.a<QQMessageFacade, QQAppInterface> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f() {
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
        com.tencent.mobileqq.app.utils.b bVar = (com.tencent.mobileqq.app.utils.b) qQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
        for (MessageRecord messageRecord : list) {
            ((IVideoReporter) QRoute.api(IVideoReporter.class)).reportVideoStructMsgRecv(messageRecord);
            if (bVar != null && bVar.h()) {
                bVar.f(messageRecord.senderuin);
            }
        }
    }
}
