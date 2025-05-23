package com.tencent.mobileqq.webprocess;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.tencent.mobileqq.app.AppStatusCallbackSingleton;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebCoreService extends Service {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final int f313720d;

    /* renamed from: e, reason: collision with root package name */
    private static WebCoreService f313721e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f313722f;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class KernelService extends Service {
        static IPatchRedirector $redirector_;

        public KernelService() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (IBinder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            }
            return null;
        }

        @Override // android.app.Service
        public void onCreate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onCreate();
            if (QLog.isColorLevel()) {
                QLog.d("WebCoreService", 2, "KernelService.onCreate");
            }
        }

        @Override // android.app.Service
        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("WebCoreService", 2, "KernelService.onDestroy");
            }
            try {
                super.stopForeground(true);
            } catch (Exception unused) {
            }
            super.onDestroy();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
            }
            if (intent != null && WebCoreService.f313721e != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("WebCoreService", 2, "KernelService.onStartCommand");
                }
                try {
                    WebCoreService.f313721e.startForeground(WebCoreService.f313720d, AppStatusCallbackSingleton.getInstance().getCallback().makeFakeNotificationForProcessKeepAlive(true));
                    super.startForeground(WebCoreService.f313720d, AppStatusCallbackSingleton.getInstance().getCallback().makeFakeNotificationForProcessKeepAlive(false));
                    WebCoreService.f313721e.stopForeground(true);
                } catch (Exception e16) {
                    QLog.d("WebCoreService", 1, "", e16);
                }
            }
            return 2;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48421);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f313720d = ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).getAppId();
        f313721e = null;
        f313722f = false;
    }

    public WebCoreService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void c() {
        if (Build.VERSION.SDK_INT >= 25) {
            return;
        }
        try {
            BaseApplication.getContext().startService(new Intent(BaseApplication.getContext(), (Class<?>) KernelService.class));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("WebCoreService", 2, "", th5);
            }
        }
    }

    public static synchronized void d() {
        synchronized (WebCoreService.class) {
            BaseApplication context = BaseApplication.getContext();
            try {
                context.startService(new Intent(context, (Class<?>) WebCoreService.class));
                f313722f = true;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("WebCoreService", 2, "", th5);
                }
            }
        }
    }

    public static void e() {
        if (Build.VERSION.SDK_INT >= 25) {
            return;
        }
        try {
            BaseApplication.getContext().stopService(new Intent(BaseApplication.getContext(), (Class<?>) KernelService.class));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("WebCoreService", 2, "", th5);
            }
        }
    }

    public static synchronized void f() {
        synchronized (WebCoreService.class) {
            try {
                BaseApplication.getContext().stopService(new Intent(BaseApplication.getContext(), (Class<?>) WebCoreService.class));
                f313722f = false;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("WebCoreService", 2, "", th5);
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f313721e = this;
        if (QLog.isColorLevel()) {
            QLog.d("WebCoreService", 2, "WebCoreService.onCreate " + Build.VERSION.SDK_INT);
        }
        super.onCreate();
        e();
        if (Build.VERSION.SDK_INT < 25) {
            c();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebCoreService", 2, "WebCoreService.onDestroy");
        }
        e();
        super.onDestroy();
        f313721e = null;
    }
}
