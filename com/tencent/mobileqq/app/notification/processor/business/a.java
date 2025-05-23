package com.tencent.mobileqq.app.notification.processor.business;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.activateFriend.y;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.cn;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends com.tencent.mobileqq.app.notification.struct.a {
    static IPatchRedirector $redirector_;

    protected a(QQAppInterface qQAppInterface, com.tencent.mobileqq.app.notification.struct.e eVar) {
        super(qQAppInterface, eVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) eVar);
        }
    }

    @Override // com.tencent.mobileqq.app.notification.struct.d
    public com.tencent.mobileqq.app.notification.struct.e a(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.app.notification.struct.e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        }
        this.f196405b.k(cn.d(this.f196404a.getApp().getResources().getDrawable(R.drawable.qq_af_icon)));
        this.f196405b.l(d() + MsgSummary.STR_COLON);
        this.f196405b.j(b());
        String extInfoFromExtStr = message.getExtInfoFromExtStr("key_msg_notify_summary");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            this.f196405b.j(extInfoFromExtStr);
        }
        h(message);
        if (message.msgtype == -7090) {
            y.b(this.f196404a, "push_exp", null, null, null, String.valueOf(y.d(message.msgData)));
        }
        return this.f196405b;
    }

    @Override // com.tencent.mobileqq.app.notification.struct.c
    public int e(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).intValue();
        }
        return -113;
    }
}
