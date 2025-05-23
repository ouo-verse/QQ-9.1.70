package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* loaded from: classes15.dex */
public class WatchTogetherClientIPCModule extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static volatile WatchTogetherClientIPCModule f238466e;

    /* renamed from: d, reason: collision with root package name */
    private Handler f238467d;

    public WatchTogetherClientIPCModule(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f238467d = new Handler(Looper.getMainLooper());
        if (QLog.isColorLevel()) {
            QLog.d("WatchTogetherClientIPCModule", 2, "WatchTogetherClientIPCModule register");
        }
    }

    public static WatchTogetherClientIPCModule b() {
        if (f238466e == null) {
            synchronized (WatchTogetherClientIPCModule.class) {
                if (f238466e == null) {
                    f238466e = new WatchTogetherClientIPCModule("WatchTogetherClientIPCModule");
                }
            }
        }
        return f238466e;
    }

    private boolean c() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return true;
        }
        return false;
    }

    public void d(String str, WatchTogetherFloatingData watchTogetherFloatingData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) watchTogetherFloatingData);
            return;
        }
        if (c()) {
            if ("ACTION_SHOW_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(str)) {
                g.k().r(BaseApplication.getContext(), watchTogetherFloatingData);
                return;
            } else if ("ACTION_QUIT_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(str)) {
                g.k().f(watchTogetherFloatingData.getCurUin(), watchTogetherFloatingData.getCurType(), true);
                return;
            } else {
                if ("ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS".equals(str)) {
                    g.k().g();
                    return;
                }
                return;
            }
        }
        this.f238467d.post(new Runnable(str, watchTogetherFloatingData) { // from class: com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherClientIPCModule.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f238468d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ WatchTogetherFloatingData f238469e;

            {
                this.f238468d = str;
                this.f238469e = watchTogetherFloatingData;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, WatchTogetherClientIPCModule.this, str, watchTogetherFloatingData);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                boolean z16 = true;
                if ("ACTION_SHOW_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(this.f238468d)) {
                    if (g.k().r(BaseApplication.getContext(), this.f238469e) != 0) {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("WatchTogetherClientIPCModule", 2, "call TogetherBusinessIPCModule show=" + z16);
                        return;
                    }
                    return;
                }
                if ("ACTION_QUIT_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(this.f238468d)) {
                    g.k().f(this.f238469e.getCurUin(), this.f238469e.getCurType(), true);
                } else if ("ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS".equals(this.f238468d)) {
                    g.k().g();
                }
            }
        });
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("WatchTogetherClientIPCModule", 2, "call TogetherBusinessIPCModule action=" + str);
        }
        EIPCResult eIPCResult = new EIPCResult();
        if ("ACTION_SHOW_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(str)) {
            if (bundle != null) {
                WatchTogetherFloatingData watchTogetherFloatingData = (WatchTogetherFloatingData) bundle.getSerializable("BUNDLE_KEY_UI_DATA");
                if (watchTogetherFloatingData != null) {
                    d(str, watchTogetherFloatingData);
                    eIPCResult.code = 0;
                } else {
                    eIPCResult.code = -102;
                }
            } else {
                eIPCResult.code = -102;
            }
        } else if ("ACTION_QUIT_WATCH_FLOATING_WINDOWS".equalsIgnoreCase(str)) {
            if (bundle != null) {
                WatchTogetherFloatingData watchTogetherFloatingData2 = (WatchTogetherFloatingData) bundle.getSerializable("BUNDLE_KEY_UI_DATA");
                if (watchTogetherFloatingData2 != null) {
                    d(str, watchTogetherFloatingData2);
                    eIPCResult.code = 0;
                } else {
                    eIPCResult.code = -102;
                }
            } else {
                eIPCResult.code = -102;
            }
        } else if ("ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS".equals(str)) {
            d(str, new WatchTogetherFloatingData());
            eIPCResult.code = 0;
        }
        callbackResult(i3, eIPCResult);
        return eIPCResult;
    }
}
