package com.tencent.mobileqq.app.activitymodule;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes11.dex */
public class SystemBarActivityModuleProxy implements ISystemBar, IActivityModule {
    static IPatchRedirector $redirector_;
    protected Activity activity;
    private ISystemBar originSystemBar;
    protected ISystemBarPropertyProvider propertyProvider;

    public SystemBarActivityModuleProxy(ISystemBar iSystemBar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iSystemBar);
        } else {
            this.originSystemBar = iSystemBar;
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityCreate(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
        } else {
            this.originSystemBar.doOnActivityCreate(activity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityDestroyed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity);
        } else {
            this.originSystemBar.doOnActivityDestroyed(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityOnStart(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
        } else {
            this.originSystemBar.doOnActivityOnStart(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPause(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) activity);
        } else {
            this.originSystemBar.doOnActivityPause(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPostCreated(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity, (Object) bundle);
        } else {
            this.originSystemBar.doOnActivityPostCreated(activity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPostPaused(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) activity);
        } else {
            this.originSystemBar.doOnActivityPostPaused(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPostResumed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
        } else {
            this.originSystemBar.doOnActivityPostResumed(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPreCreated(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) bundle);
        } else {
            this.originSystemBar.doOnActivityPreCreated(activity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPrePaused(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
        } else {
            this.originSystemBar.doOnActivityPrePaused(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPreResumed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        } else {
            this.originSystemBar.doOnActivityPreResumed(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
        } else {
            this.originSystemBar.doOnActivityResume(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityStopped(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity);
        } else {
            this.originSystemBar.doOnActivityStopped(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnConfigurationChanged(Activity activity, Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) activity, (Object) configuration);
        } else {
            this.originSystemBar.doOnConfigurationChanged(activity, configuration);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public boolean doOnDispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return this.originSystemBar.doOnDispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnNewIntent(Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) activity, (Object) intent);
        } else {
            this.originSystemBar.doOnNewIntent(activity, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnWindowFocusChanged(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, activity, Boolean.valueOf(z16));
        } else {
            this.originSystemBar.doOnWindowFocusChanged(activity, z16);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.IActivityModule
    public void init(IActivityPropertyProvider iActivityPropertyProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iActivityPropertyProvider);
            return;
        }
        this.originSystemBar.init(iActivityPropertyProvider);
        this.activity = (QBaseActivity) iActivityPropertyProvider.getActivity();
        this.propertyProvider = (ISystemBarPropertyProvider) iActivityPropertyProvider;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBar
    public void initNavigationBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.originSystemBar.initNavigationBarColor();
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onAccountChanged(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) activity);
        } else {
            this.originSystemBar.onAccountChanged(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onMultiWindowModeChanged(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, activity, Boolean.valueOf(z16));
        } else {
            this.originSystemBar.onMultiWindowModeChanged(activity, z16);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPostThemeChanged(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) activity);
        } else {
            this.originSystemBar.onPostThemeChanged(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPreHandleStartActivityForResult(Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, activity, intent, Integer.valueOf(i3));
        } else {
            this.originSystemBar.onPreHandleStartActivityForResult(activity, intent, i3);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPreSetContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            this.originSystemBar.onPreSetContentView(view);
        } else {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onRestoreInstanceState(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) activity, (Object) bundle);
        } else {
            this.originSystemBar.onRestoreInstanceState(activity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onSaveInstanceState(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) activity, (Object) bundle);
        } else {
            this.originSystemBar.onSaveInstanceState(activity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBar
    public void setImmersiveStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.originSystemBar.setImmersiveStatus();
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPreSetContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            this.originSystemBar.onPreSetContentView(i3);
        } else {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBar
    public void setImmersiveStatus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.originSystemBar.setImmersiveStatus(i3);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }
}
