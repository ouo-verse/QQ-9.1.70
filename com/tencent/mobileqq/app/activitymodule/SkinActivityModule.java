package com.tencent.mobileqq.app.activitymodule;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mobileqq.app.ISkinCallback;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.theme.SkinnableActivityProcesser;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SkinActivityModule extends AbsActivityModule implements SkinnableActivityProcesser.Callback {
    static IPatchRedirector $redirector_;
    private static boolean isThemeSwitchOpen;
    private QBaseActivity activity;
    private ISkinCallback callback;
    private SkinnableActivityProcesser processor;
    private ISkinPropertyProvider skinPropertyProvider;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37779);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            isThemeSwitchOpen = false;
        }
    }

    public SkinActivityModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityCreate(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) bundle);
        } else if (this.skinPropertyProvider.themeChangeRightNow()) {
            this.processor = new SkinnableActivityProcesser(this.activity, this);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityDestroyed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        SkinnableActivityProcesser skinnableActivityProcesser = this.processor;
        if (skinnableActivityProcesser != null) {
            skinnableActivityProcesser.destory();
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    @SuppressLint({"SdCardPath"})
    public boolean doOnDispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return false;
    }

    public SkinnableActivityProcesser getSkinProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SkinnableActivityProcesser) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.processor;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.activitymodule.IActivityModule
    public void init(IActivityPropertyProvider iActivityPropertyProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iActivityPropertyProvider);
            return;
        }
        this.activity = (QBaseActivity) iActivityPropertyProvider.getActivity();
        this.skinPropertyProvider = (ISkinPropertyProvider) iActivityPropertyProvider;
        this.callback = (ISkinCallback) iActivityPropertyProvider.getActivity();
    }

    @Override // com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ISkinCallback iSkinCallback = this.callback;
        if (iSkinCallback != null) {
            iSkinCallback.onPostThemeChanged();
        }
    }

    @Override // com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPreThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ISkinCallback iSkinCallback = this.callback;
        if (iSkinCallback != null) {
            iSkinCallback.onPreThemeChanged();
        }
    }
}
