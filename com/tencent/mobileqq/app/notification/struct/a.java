package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class a extends c {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(QQAppInterface qQAppInterface, e eVar) {
        super(qQAppInterface, eVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) eVar);
        }
    }

    private void j() {
        Intent b16 = this.f196405b.b();
        String f16 = this.f196405b.f();
        String c16 = this.f196405b.c();
        String d16 = this.f196405b.d();
        Bitmap e16 = this.f196405b.e();
        int totalCounter = this.f196404a.getMessageFacade().f116353m.getTotalCounter(true);
        StringBuffer stringBuffer = new StringBuffer();
        int newConversationSizeWithoutPublicAccount = this.f196404a.getMessageFacade().f116353m.getNewConversationSizeWithoutPublicAccount(true);
        stringBuffer.append(String.format(this.f196404a.getApp().getString(R.string.ckw), Integer.valueOf(newConversationSizeWithoutPublicAccount)));
        if (totalCounter > 1000) {
            stringBuffer.append(this.f196404a.getApp().getString(R.string.ckx));
        } else {
            stringBuffer.append(totalCounter);
            stringBuffer.append(this.f196404a.getApp().getString(R.string.cip));
        }
        if (newConversationSizeWithoutPublicAccount > 1) {
            b16 = SplashActivity.getAliasIntent(this.f196404a.getApp());
            b16.addFlags(335544320);
            b16.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            c16 = this.f196404a.getApp().getString(R.string.notification_title);
            d16 = stringBuffer.toString();
            e16 = null;
        } else {
            QLog.d("[NotificationRebuild] [NotificationProcessor] AbstractBuildLastDefaultNotificationProcessor", 1, "[notification] buildNotificationElement: invoked. \u975e\u72ec\u7acb\u4f1a\u8bdd\u6570<=1\uff0c\u4fdd\u6301\u65e7\u7684\u8df3\u8f6c\u3001\u56fe\u6807\u3001wording \u5df2\u7ecf\u4ece\u4e0a\u9762switch-case\u4e2d\u83b7\u53d6 ", " conversationSizeNotSeparate: ", Integer.valueOf(newConversationSizeWithoutPublicAccount));
        }
        this.f196405b.k(e16);
        this.f196405b.h(b16);
        this.f196405b.i(c16);
        this.f196405b.j(d16);
        this.f196405b.l(f16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.notification.struct.c
    public /* bridge */ /* synthetic */ String b() {
        return super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.notification.struct.c
    public /* bridge */ /* synthetic */ Intent c() {
        return super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.notification.struct.c
    public /* bridge */ /* synthetic */ String d() {
        return super.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.notification.struct.c
    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.notification.struct.c
    public /* bridge */ /* synthetic */ void g(Message message, e eVar) {
        super.g(message, eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(Message message) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        f();
        g(message, this.f196405b);
        if (this.f196404a.getMessageFacade().f116353m.getNewConversationSizeWithoutPublicAccount() > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || this.f196404a.getMessageFacade().f116353m.getTotalCounter(true) == 0) {
            return;
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int i(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).intValue();
        }
        boolean isShowMsgContent = this.f196404a.isShowMsgContent();
        int i3 = message.istroop;
        String str = message.frienduin;
        if (com.tencent.util.notification.d.j(i3, str)) {
            if (isShowMsgContent) {
                return com.tencent.util.notification.d.g().t(str);
            }
            return 265;
        }
        return -113;
    }
}
