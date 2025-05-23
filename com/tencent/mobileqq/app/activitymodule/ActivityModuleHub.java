package com.tencent.mobileqq.app.activitymodule;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ActivityModuleHub implements IActivityModuleHub, BaseActivityLifecycleCallbacks {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "ActivityModuleHub";
    private List<IActivityModule> modules;

    public ActivityModuleHub(IActivityModuleProvider iActivityModuleProvider, IActivityPropertyProvider iActivityPropertyProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iActivityModuleProvider, (Object) iActivityPropertyProvider);
            return;
        }
        this.modules = new ArrayList();
        if (iActivityModuleProvider == null) {
            return;
        }
        createAndInitModules(iActivityModuleProvider, iActivityPropertyProvider);
    }

    private void createAndInitModules(IActivityModuleProvider iActivityModuleProvider, IActivityPropertyProvider iActivityPropertyProvider) {
        List<IActivityModule> generateModules = iActivityModuleProvider.generateModules();
        if (generateModules.isEmpty()) {
            return;
        }
        for (IActivityModule iActivityModule : generateModules) {
            if (iActivityModule != null) {
                iActivityModule.init(iActivityPropertyProvider);
                this.modules.add(iActivityModule);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityCreate(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnActivityCreate(activity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityDestroyed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) activity);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnActivityDestroyed(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityOnStart(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnActivityOnStart(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPause(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnActivityPause(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPostCreated(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnActivityPostCreated(activity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPostPaused(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnActivityPostPaused(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPostResumed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnActivityPostResumed(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPreCreated(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnActivityPreCreated(activity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPrePaused(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnActivityPrePaused(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPreResumed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnActivityPreResumed(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnActivityResume(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityStopped(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnActivityStopped(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnConfigurationChanged(Activity activity, Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) activity, (Object) configuration);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnConfigurationChanged(activity, configuration);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public boolean doOnDispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnNewIntent(Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity, (Object) intent);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnNewIntent(activity, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnWindowFocusChanged(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, activity, Boolean.valueOf(z16));
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().doOnWindowFocusChanged(activity, z16);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.IActivityModuleHub
    public <T extends IActivityModule> T getModule(Class<? extends IActivityModule> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            T t16 = (T) it.next();
            if (cls.isAssignableFrom(t16.getClass())) {
                return t16;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onAccountChanged(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) activity);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onAccountChanged(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onMultiWindowModeChanged(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, activity, Boolean.valueOf(z16));
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onMultiWindowModeChanged(activity, z16);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPostThemeChanged(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) activity);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onPostThemeChanged(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPreHandleStartActivityForResult(Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, activity, intent, Integer.valueOf(i3));
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onPreHandleStartActivityForResult(activity, intent, i3);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPreSetContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) view);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onPreSetContentView(view);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onRestoreInstanceState(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onRestoreInstanceState(activity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onSaveInstanceState(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onSaveInstanceState(activity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPreSetContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        Iterator<IActivityModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onPreSetContentView(i3);
        }
    }
}
