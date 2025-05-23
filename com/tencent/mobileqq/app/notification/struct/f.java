package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Message f196412a;

    /* renamed from: b, reason: collision with root package name */
    private final QQAppInterface f196413b;

    /* renamed from: c, reason: collision with root package name */
    private e f196414c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f196415d;

    public f(QQAppInterface qQAppInterface, Message message, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, message, Boolean.valueOf(z16));
            return;
        }
        this.f196412a = message;
        this.f196413b = qQAppInterface;
        this.f196414c = new e();
        this.f196415d = z16;
    }

    private void b() {
        if (!this.f196415d) {
            this.f196414c.l(null);
        }
    }

    private Intent c() {
        return this.f196414c.b();
    }

    private String d() {
        return this.f196414c.c();
    }

    private String e() {
        return this.f196414c.d();
    }

    private Bitmap f() {
        return this.f196414c.e();
    }

    private String g() {
        return this.f196414c.f();
    }

    private void h() {
        QQAppInterface qQAppInterface = this.f196413b;
        this.f196414c.h(qQAppInterface.getIntentByMessage(qQAppInterface.getApp(), this.f196412a, true));
        c().putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 6);
        c().putExtra(AppConstants.Key.KEY_NOTIFICATION_CLICK_ACTION, true);
    }

    private void i() {
        this.f196414c.g(com.tencent.mobileqq.app.notification.a.b(this.f196413b, this.f196412a));
        String stringExtra = c().getStringExtra("uinname");
        if (stringExtra == null || "".equals(stringExtra)) {
            stringExtra = c().getStringExtra("uin");
        }
        this.f196414c.i(stringExtra);
    }

    @Nullable
    public e a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        h();
        i();
        c b16 = ProcessorFactory.b(this.f196413b, this.f196412a.istroop, this.f196414c);
        if (b16 == null) {
            return null;
        }
        e a16 = b16.a(this.f196412a);
        this.f196414c = a16;
        if (a16 == null) {
            return null;
        }
        int e16 = b16.e(this.f196412a);
        if (c() == null) {
            this.f196414c.h(new Intent());
        }
        c().putExtra("KEY_NOTIFY_ID_FROM_PROCESSOR", e16);
        c().putExtra(QQNotificationManager.PARAM_NOTIFYID, e16);
        b();
        if (QLog.isColorLevel()) {
            QLog.d("[NotificationRebuild] NotificationElementBuilder", 2, "[create] build: invoked. ", " notificationElement: ", this.f196414c);
        }
        return this.f196414c;
    }

    @NotNull
    public String toString() {
        Bundle bundle;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f196414c == null) {
            return "notificationElement: null";
        }
        if (c() != null) {
            bundle = c().getExtras();
        } else {
            bundle = null;
        }
        if (f() != null) {
            str = String.valueOf(f().getHeight());
        } else {
            str = "using default bitmap";
        }
        return "NotificationElementBuilder{contentIntentExtras=" + bundle + ", ticker='" + g() + "', contentTitle='" + d() + "', notificationContentText='" + e() + "', notificationIconBitmapStr=" + str + '}';
    }
}
