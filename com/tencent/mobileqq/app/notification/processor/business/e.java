package com.tencent.mobileqq.app.notification.processor.business;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ac;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e extends com.tencent.mobileqq.app.notification.struct.a {
    static IPatchRedirector $redirector_;

    protected e(QQAppInterface qQAppInterface, com.tencent.mobileqq.app.notification.struct.e eVar) {
        super(qQAppInterface, eVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) eVar);
        }
    }

    @Override // com.tencent.mobileqq.app.notification.struct.d
    public com.tencent.mobileqq.app.notification.struct.e a(Message message) {
        String j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.app.notification.struct.e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        }
        if (AppConstants.LBS_HELLO_UIN.equals(message.frienduin)) {
            j3 = ac.j(this.f196404a, message.senderuin);
            if (TextUtils.isEmpty(j3)) {
                j3 = message.senderuin;
            }
        } else {
            j3 = ac.j(this.f196404a, message.frienduin);
            if (TextUtils.isEmpty(j3)) {
                j3 = message.frienduin;
            }
        }
        this.f196405b.l(j3 + "(" + d() + "):");
        int i3 = message.msgtype;
        if (i3 == -2053) {
            this.f196405b.j(this.f196404a.getApp().getString(R.string.fnb) + message.nickName + b());
        } else if (i3 == -2068) {
            this.f196405b.j(b());
        } else {
            this.f196405b.j(this.f196404a.getNamePostfix(message) + j3 + MsgSummary.STR_COLON + b());
        }
        if (this.f196404a.getMessageFacade().f116353m.getNewConversationSizeWithoutPublicAccount() == 1) {
            this.f196405b.k(this.f196404a.getStrangerFaceBitmap(message.frienduin, 200));
        }
        h(message);
        return this.f196405b;
    }

    @Override // com.tencent.mobileqq.app.notification.struct.c
    public int e(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).intValue();
        }
        if (message.istroop == 1001) {
            return i(message);
        }
        return -113;
    }
}
