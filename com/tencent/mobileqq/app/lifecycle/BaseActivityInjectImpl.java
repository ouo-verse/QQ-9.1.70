package com.tencent.mobileqq.app.lifecycle;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IBaseActivityInjectInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.vas.adv.api.INFBApi;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BaseActivityInjectImpl implements IBaseActivityInjectInterface {
    static IPatchRedirector $redirector_;

    public BaseActivityInjectImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component != null && "com.tencent.mobileqq.activity.SplashActivity".equals(component.getClassName())) {
            intent.setComponent(new ComponentName(component.getPackageName(), SplashActivity.getAliasName()));
        }
    }

    @Override // com.tencent.mobileqq.app.IBaseActivityInjectInterface
    public boolean dispatchTouchEvent(QBaseActivity qBaseActivity, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) qBaseActivity, (Object) motionEvent)).booleanValue();
        }
        ((INFBApi) QRoute.api(INFBApi.class)).dispatchActivityTouchEvent(qBaseActivity, motionEvent);
        return false;
    }

    @Override // com.tencent.mobileqq.app.IBaseActivityInjectInterface
    public void startActivity(QBaseActivity qBaseActivity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qBaseActivity, (Object) intent);
            return;
        }
        a(intent);
        JumpActivity.processIntent(intent);
        JumpActivity.handleIntentForQQBrowser(qBaseActivity, intent);
    }

    @Override // com.tencent.mobileqq.app.IBaseActivityInjectInterface
    public boolean startActivityForResult(QBaseActivity qBaseActivity, Intent intent, int i3, Bundle bundle) {
        WebViewFragment currentWebViewFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, qBaseActivity, intent, Integer.valueOf(i3), bundle)).booleanValue();
        }
        a(intent);
        JumpActivity.processIntent(intent);
        JumpActivity.handleIntentForQQBrowser(qBaseActivity, intent);
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        if (appRuntime instanceof QQAppInterface) {
            URLInterceptManager uRLInterceptManager = (URLInterceptManager) appRuntime.getManager(QQManagerFactory.URL_INTECEPT_MANAGER);
            if (uRLInterceptManager != null && uRLInterceptManager.c(intent, (QQAppInterface) appRuntime, qBaseActivity)) {
                return true;
            }
        } else if ((qBaseActivity instanceof QQBrowserActivity) && (currentWebViewFragment = ((QQBrowserActivity) qBaseActivity).getCurrentWebViewFragment()) != null && currentWebViewFragment.getAppRuntime() != null) {
            AppRuntime appRuntime2 = currentWebViewFragment.getAppRuntime();
            int i16 = QQManagerFactory.URL_INTECEPT_MANAGER;
            if (appRuntime2.getManager(i16) != null && ((URLInterceptManager) currentWebViewFragment.getAppRuntime().getManager(i16)).b(intent, qBaseActivity)) {
                return true;
            }
        }
        try {
            JefsClass.getInstance().checkAndDoSync(qBaseActivity, intent, new TeleScreenRunnable(qBaseActivity, intent, i3, bundle) { // from class: com.tencent.mobileqq.app.lifecycle.BaseActivityInjectImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QBaseActivity f195817d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Intent f195818e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f195819f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Bundle f195820h;

                {
                    this.f195817d = qBaseActivity;
                    this.f195818e = intent;
                    this.f195819f = i3;
                    this.f195820h = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BaseActivityInjectImpl.this, qBaseActivity, intent, Integer.valueOf(i3), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        this.f195817d.startActivityForResultOriginal(this.f195818e, this.f195819f, this.f195820h);
                    } catch (Throwable th5) {
                        QLog.e("qqBaseActivity", 1, th5, new Object[0]);
                    }
                }
            });
        } catch (Throwable th5) {
            QLog.e("qqBaseActivity", 1, th5, new Object[0]);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.IBaseActivityInjectInterface
    public Intent startUnlockActivityIntent(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Intent) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        }
        GesturePWDUnlockActivity.sGesturePWDUnlockShowing = true;
        return new Intent(activity, (Class<?>) GesturePWDUnlockActivity.class);
    }

    @Override // com.tencent.mobileqq.app.IBaseActivityInjectInterface
    public void startActivity(QBaseActivity qBaseActivity, Intent intent, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qBaseActivity, intent, bundle);
            return;
        }
        a(intent);
        JumpActivity.processIntent(intent);
        JumpActivity.handleIntentForQQBrowser(qBaseActivity, intent);
    }

    @Override // com.tencent.mobileqq.app.IBaseActivityInjectInterface
    public void startActivityForResult(QBaseActivity qBaseActivity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, qBaseActivity, intent, Integer.valueOf(i3));
            return;
        }
        a(intent);
        JumpActivity.processIntent(intent);
        JumpActivity.handleIntentForQQBrowser(qBaseActivity, intent);
    }
}
