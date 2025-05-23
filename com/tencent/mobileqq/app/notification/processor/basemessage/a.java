package com.tencent.mobileqq.app.notification.processor.basemessage;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.b;
import com.tencent.mobileqq.app.notification.struct.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class a extends b {
    static IPatchRedirector $redirector_;

    protected a(QQAppInterface qQAppInterface, e eVar) {
        super(qQAppInterface, eVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) eVar);
        }
    }

    private void o(Message message) {
        if (this.f196404a.getMessageFacade().f116353m.getNewConversationSizeWithoutPublicAccount() == 1) {
            if (!AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(message.frienduin) && !AppConstants.MAYKNOW_RECOMMEND_UIN.equals(message.frienduin) && !AppConstants.FRIEND_ANNIVER_UIN.equals(message.frienduin)) {
                this.f196405b.k(this.f196404a.getFaceBitmap(message.frienduin, true));
            } else {
                this.f196405b.k(this.f196404a.getFaceBitmap(message.senderuin, true));
            }
        }
    }

    @Override // com.tencent.mobileqq.app.notification.struct.d
    public e a(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        }
        o(message);
        this.f196405b.l(d() + MsgSummary.STR_COLON);
        this.f196405b.j(b());
        return l(message);
    }

    @Override // com.tencent.mobileqq.app.notification.struct.c
    public int e(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).intValue();
        }
        return h(message);
    }
}
