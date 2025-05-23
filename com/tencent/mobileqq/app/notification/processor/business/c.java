package com.tencent.mobileqq.app.notification.processor.business;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.cn;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c extends com.tencent.mobileqq.app.notification.struct.a {
    static IPatchRedirector $redirector_;

    protected c(QQAppInterface qQAppInterface, com.tencent.mobileqq.app.notification.struct.e eVar) {
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
        this.f196405b.k(cn.d(this.f196404a.getApp().getResources().getDrawable(R.drawable.qq_confess_icon_entry)));
        this.f196405b.i(this.f196404a.getApp().getString(R.string.fbv));
        ConfessInfo confessInfo = new ConfessInfo();
        confessInfo.parseFromJsonStr(message.getExtInfoFromExtStr("ext_key_confess_info"));
        String p16 = ConfessMsgUtil.p(this.f196404a, confessInfo, message.senderuin);
        this.f196405b.l(p16 + "(" + d() + "):" + b());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(p16);
        sb5.append(":");
        sb5.append(b());
        this.f196405b.j(sb5.toString());
        h(message);
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
