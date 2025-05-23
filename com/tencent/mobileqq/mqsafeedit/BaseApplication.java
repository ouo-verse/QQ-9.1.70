package com.tencent.mobileqq.mqsafeedit;

import android.app.Application;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class BaseApplication extends Application {
    static IPatchRedirector $redirector_;
    public static int appnewmsgicon;
    static Context context;
    public static int defaultNotifSoundResourceId;
    public static int qqlaunchicon;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9453);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        appnewmsgicon = 0;
        qqlaunchicon = 0;
        defaultNotifSoundResourceId = 0;
    }

    public BaseApplication() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public static Context getContext() {
        return context;
    }

    public static int getDefaultNotifSoundResourceId() {
        return defaultNotifSoundResourceId;
    }

    public static int getQQLaunchIcon() {
        return qqlaunchicon;
    }

    public static int getQQNewMsgIcon() {
        return appnewmsgicon;
    }

    public void callSystemSuperCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onCreate();
            context = this;
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (context == null) {
            callSystemSuperCreate();
        }
    }
}
