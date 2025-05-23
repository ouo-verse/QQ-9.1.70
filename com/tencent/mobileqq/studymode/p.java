package com.tencent.mobileqq.studymode;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile p f291008a;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("invoke_study_mode_by_scheme");
        }
        return true;
    }

    public static p b() {
        if (f291008a == null) {
            synchronized (p.class) {
                if (f291008a == null) {
                    f291008a = new p();
                }
            }
        }
        return f291008a;
    }

    public static int c(int i3) {
        if (i3 != 6) {
            if (i3 != 9) {
                if (i3 == 11) {
                    return 6;
                }
                return -1;
            }
            return 5;
        }
        return 4;
    }

    public static int d(int i3) {
        if (i3 == 7) {
            return 5;
        }
        if (i3 == 8) {
            return 7;
        }
        if (i3 == 10) {
            return 8;
        }
        return -1;
    }

    public static int e(int i3, int i16) {
        if (i3 != 5) {
            if (i3 == 7) {
                return 5;
            }
            if (i3 == 8) {
                return 6;
            }
            return i16;
        }
        return 3;
    }

    public static boolean f(int i3) {
        if (i3 != 6 && i3 != 9) {
            return false;
        }
        return true;
    }

    public static boolean g(int i3) {
        if (i3 != 7 && i3 != 8 && i3 != 10) {
            return false;
        }
        return true;
    }

    public boolean h(Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) intent)).booleanValue();
        }
        if (activity == null || intent == null || !"5".equals(intent.getStringExtra("fromtype"))) {
            return false;
        }
        JumpKidModeMgr.b().x(activity, 8);
        return true;
    }

    public boolean i(Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) intent)).booleanValue();
        }
        if (activity == null || intent == null || !"wezone".equals(intent.getStringExtra("sceneidentifier"))) {
            return false;
        }
        return JumpKidModeMgr.b().u(activity, -1, 9);
    }
}
