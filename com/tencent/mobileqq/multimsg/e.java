package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends f {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MessageForArkApp f251592d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f251593e;

        a(MessageForArkApp messageForArkApp, QQAppInterface qQAppInterface) {
            this.f251592d = messageForArkApp;
            this.f251593e = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, messageForArkApp, qQAppInterface);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 4, (Object) this, (Object) im_msg_body_richtext);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                return;
            }
            try {
                if (aVar.f258597a == 0) {
                    this.f251592d.resIDForLongMsg = aVar.f258602f;
                    this.f251593e.getMessageFacade().E0(this.f251592d, null, false);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, result.errStr=" + aVar.f258598b + ",result.errStr=" + aVar.f258599c);
                }
                f.c(this.f251593e, this.f251592d);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, catch exception", e16);
                }
                f.c(this.f251593e, this.f251592d);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
        }
    }

    public e(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    @Override // com.tencent.mobileqq.multimsg.f
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 4;
    }

    public void k(QQAppInterface qQAppInterface, MessageForArkApp messageForArkApp, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, messageForArkApp, Boolean.valueOf(z16));
            return;
        }
        if (messageForArkApp.istroop == 1) {
            com.tencent.biz.anonymous.a.h().a(messageForArkApp);
        }
        if (z16) {
            qQAppInterface.getMessageFacade().m(messageForArkApp);
        }
        messageForArkApp.mPendantAnimatable = true;
        byte[] s16 = qQAppInterface.getProxyManager().k().s(messageForArkApp);
        if (s16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("StructLongTextMsg", 2, "step2: sendLongTextMsg pack failed! packData is null.............................");
            }
            messageForArkApp.extraflag = 32768;
            qQAppInterface.getMsgCache().G1(messageForArkApp.frienduin, messageForArkApp.istroop, messageForArkApp.uniseq);
            ((MessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.k3(messageForArkApp.istroop), false, new Object[]{messageForArkApp.frienduin, Integer.valueOf(messageForArkApp.istroop), -1, null, 0L, Long.valueOf(messageForArkApp.uniseq)});
        }
        f fVar = (f) qQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER);
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        String str = messageForArkApp.frienduin;
        boolean j3 = fVar.j(qQAppInterface, s16, currentAccountUin, str, str, messageForArkApp.istroop, messageForArkApp.uniseq, 1035, new a(messageForArkApp, qQAppInterface));
        if (j3) {
            if (QLog.isColorLevel()) {
                QLog.d("StructLongTextMsg", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("StructLongTextMsg", 2, "sendLongTextMsg failed! isSuccess:" + j3);
            }
            f.c(qQAppInterface, messageForArkApp);
        }
    }
}
