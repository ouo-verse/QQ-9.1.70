package com.tencent.mobileqq.managers;

import android.content.Intent;
import com.tencent.mobileqq.activity.recent.data.RecentItemPullActivePush;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.message.q;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static String f243719i;

    /* renamed from: m, reason: collision with root package name */
    public static String f243720m;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f243721d;

    /* renamed from: e, reason: collision with root package name */
    private MessageForText f243722e;

    /* renamed from: f, reason: collision with root package name */
    public RecentItemPullActivePush f243723f;

    /* renamed from: h, reason: collision with root package name */
    public Intent f243724h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72966);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f243719i = "QQ";
            f243720m = "extra_notify_msg";
        }
    }

    public h(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f243721d = qQAppInterface;
        }
    }

    public MessageForText a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MessageForText) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f243723f == null) {
            return null;
        }
        if (this.f243722e == null) {
            MessageForText messageForText = (MessageForText) q.d(-1000);
            this.f243722e = messageForText;
            messageForText.msgtype = -1000;
            messageForText.istroop = AppConstants.VALUE.UIN_TYPE_PULL_ACTIVE_PUSH;
            messageForText.isread = false;
            messageForText.selfuin = this.f243721d.getCurrentAccountUin();
            MessageForText messageForText2 = this.f243722e;
            String str = AppConstants.PULL_ACTIVE_PUSH_UIN;
            messageForText2.senderuin = str;
            messageForText2.frienduin = str;
            Intent intent = this.f243724h;
            if (intent != null) {
                messageForText2.f203106msg = intent.getStringExtra(f243720m);
            }
            this.f243722e.time = this.f243723f.time;
        }
        String str2 = this.f243722e.f203106msg;
        if (str2 == null || !str2.equals(this.f243723f.mTitleName)) {
            this.f243722e.f203106msg = this.f243723f.mTitleName;
        }
        MessageForText messageForText3 = this.f243722e;
        long j3 = messageForText3.time;
        long j16 = this.f243723f.time;
        if (j3 != j16) {
            messageForText3.time = j16;
        }
        return messageForText3;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.f243723f == null) {
            return 0;
        }
        return 1;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f243723f = null;
        }
    }

    public void d(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        if (this.f243723f == null) {
            RecentUser recentUser = new RecentUser(AppConstants.PULL_ACTIVE_PUSH_UIN, AppConstants.VALUE.UIN_TYPE_PULL_ACTIVE_PUSH);
            recentUser.msgType = -1000;
            this.f243723f = new RecentItemPullActivePush(recentUser);
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        this.f243723f.p(intent.getStringExtra(f243720m), serverTimeMillis);
        this.f243724h = intent;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }
}
