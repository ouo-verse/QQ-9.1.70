package com.tencent.mobileqq.qqperf.api.impl;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.cf;
import com.tencent.mobileqq.app.guard.GuardConfig;
import com.tencent.mobileqq.guild.IGuildExtApi;
import com.tencent.mobileqq.perf.memory.leak.g;
import com.tencent.mobileqq.perf.process.config.MainProcConfig;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes17.dex */
public class PerfApiImpl implements IPerfApi {
    static IPatchRedirector $redirector_ = null;
    private static final String ClassName_GuildContactFragment;
    private static final String TAG = "PerfApiImpl";
    private final com.tencent.mobileqq.perf.tracker.callback.a sceneChangedCallback;

    /* loaded from: classes17.dex */
    class a extends com.tencent.mobileqq.perf.tracker.callback.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PerfApiImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
                return;
            }
            try {
                com.tencent.mobileqq.perf.memory.leak.b.b(activity);
            } catch (Exception e16) {
                QLog.e(PerfApiImpl.TAG, 1, "onActivityDestroyed ", e16);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
                return;
            }
            super.onActivityResumed(activity);
            if (!g.isCacheInitializing) {
                g.isCacheInitializing = true;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqperf.api.impl.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.j();
                    }
                }, 16, null, false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74435);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            ClassName_GuildContactFragment = ((IGuildExtApi) QRoute.api(IGuildExtApi.class)).getGuildContactFragment().getClass().getName();
        }
    }

    public PerfApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.sceneChangedCallback = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$init$0() {
        if (MainProcConfig.r().j()) {
            QLog.i(TAG, 1, "unseal result: " + com.tencent.mobileqq.perf.tool.a.f258204a.b());
        }
    }

    @Override // com.tencent.mobileqq.qqperf.api.IPerfApi
    public void addFragmentForFilterFragment(String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) strArr);
        } else {
            SceneTracker.b(strArr);
        }
    }

    @Override // com.tencent.mobileqq.qqperf.api.IPerfApi
    public String getGuardConfigID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return GuardConfig.instance().getConfigId();
    }

    @Override // com.tencent.mobileqq.qqperf.api.IPerfApi
    public String getSimpleClassName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -674892106:
                if (str.equals("SplashActivity")) {
                    c16 = 0;
                    break;
                }
                break;
            case 556545597:
                if (str.equals("GuildContactFragment")) {
                    c16 = 1;
                    break;
                }
                break;
            case 1142609737:
                if (str.equals("MainFragment")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return SplashActivity.class.getSimpleName();
            case 1:
                return ClassName_GuildContactFragment;
            case 2:
                return MainFragment.class.getSimpleName();
            default:
                return null;
        }
    }

    @Override // com.tencent.mobileqq.qqperf.api.IPerfApi
    public String getTopActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return cf.a();
    }

    @Override // com.tencent.mobileqq.qqperf.api.IPerfApi
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this.sceneChangedCallback);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqperf.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    PerfApiImpl.lambda$init$0();
                }
            }, 64, null, false);
        }
    }

    @Override // com.tencent.mobileqq.qqperf.api.IPerfApi
    public void traceEnd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            SceneTracker.f258213d.traceEnd(str);
        }
    }

    @Override // com.tencent.mobileqq.qqperf.api.IPerfApi
    public void traceStart(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            SceneTracker.f258213d.m(str);
        }
    }
}
