package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class b extends c {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(QQAppInterface qQAppInterface, e eVar) {
        super(qQAppInterface, eVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) eVar);
        }
    }

    private void i(Message message) {
        this.f196405b.k(MessageNotificationSettingManager.l(this.f196404a).o(this.f196405b.e(), message));
    }

    private void j(Message message) {
        boolean z16;
        if (this.f196404a.getMessageFacade().f116353m.getNewConversationSizeWithoutPublicAccount() > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean k3 = com.tencent.util.notification.d.k(message);
        if (z16 && k3) {
            Bitmap e16 = this.f196405b.e();
            int i3 = message.istroop;
            if (i3 == 0) {
                e16 = this.f196404a.getFaceBitmap(message.frienduin, true);
            } else if (i3 == 1) {
                e16 = this.f196404a.getTroopFaceBitmap(message.frienduin, (byte) 3, false, false);
            } else if (i3 == 10014) {
                e16 = com.tencent.avgame.util.a.a(((IQQGuildService) this.f196404a.getRuntimeService(IQQGuildService.class)).getAvatarDrawable(String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(message))));
            }
            this.f196405b.k(e16);
        }
    }

    private void k(Message message) {
        BaseApplication app = this.f196404a.getApp();
        int i3 = message.istroop;
        if ((i3 == 0 || i3 == 1 || i3 == 3000) && message.msgtype == -2016 && i3 != 1) {
            String T = this.f196404a.getMessageFacade().T(app, message, true);
            this.f196405b.g(T);
            this.f196405b.l(T);
            this.f196405b.j(T);
        }
    }

    private void m(Message message) {
        this.f196405b.h(this.f196404a.messageNotifiableChecker().d(message, this.f196405b.b()));
    }

    private void n(Message message) {
        this.f196405b.i(MessageNotificationSettingManager.l(this.f196404a).n(this.f196405b.c(), message));
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
    public final int h(Message message) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final e l(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        }
        f();
        g(message, this.f196405b);
        n(message);
        k(message);
        j(message);
        i(message);
        m(message);
        return this.f196405b;
    }
}
