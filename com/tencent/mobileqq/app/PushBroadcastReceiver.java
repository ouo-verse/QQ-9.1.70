package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

/* loaded from: classes11.dex */
public class PushBroadcastReceiver extends QQBroadcastReceiver {
    static IPatchRedirector $redirector_;

    public PushBroadcastReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(QQAppInterface qQAppInterface, Intent intent) {
        if ("tencent.notify.background".equals(intent.getAction())) {
            ThreadManagerV2.post(new Runnable(intent, qQAppInterface) { // from class: com.tencent.mobileqq.app.PushBroadcastReceiver.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Intent f194951d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f194952e;

                {
                    this.f194951d = intent;
                    this.f194952e = qQAppInterface;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, PushBroadcastReceiver.this, intent, qQAppInterface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Class<?> cls;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    String stringExtra = this.f194951d.getStringExtra("classname");
                    if (stringExtra != null) {
                        try {
                            cls = Class.forName(stringExtra);
                        } catch (ClassNotFoundException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("processIntent", 2, e16.getMessage());
                            }
                        }
                        this.f194952e.showIdleNotification(BaseApplication.getContext(), cls);
                    }
                    cls = null;
                    this.f194952e.showIdleNotification(BaseApplication.getContext(), cls);
                }
            }, 10, null, false);
        } else if ("tencent.notify.foreground".equals(intent.getAction())) {
            ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.app.PushBroadcastReceiver.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f194953d;

                {
                    this.f194953d = qQAppInterface;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PushBroadcastReceiver.this, (Object) qQAppInterface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("notification", 2, "PushBroadcastReceiver processIntent removeNotification");
                    }
                    this.f194953d.removeNotification();
                }
            }, 10, null, false);
        }
        if ("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION".equals(intent.getAction()) || "com.tencent.mobileqq.IPADONLINE_CLICK_NOTIFICATION".equals(intent.getAction()) || "com.tencent.mobileqq.PHONEDONLINE_CLICK_NOTIFICATION".equals(intent.getAction())) {
            if (QLog.isColorLevel()) {
                QLog.d("notification", 2, "PushBroadcastReceiver processIntent event : " + intent.getAction());
            }
            ((MessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).G4(BaseApplication.getContext(), intent);
            com.tencent.mobileqq.managers.d.b(intent);
        }
    }

    @Override // mqq.app.QQBroadcastReceiver
    public void onReceive(AppRuntime appRuntime, Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, context, intent);
            return;
        }
        if (intent.getExtras() != null) {
            intent.getExtras().getString("selfuin");
        }
        if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
            a((QQAppInterface) appRuntime, intent);
        }
    }
}
