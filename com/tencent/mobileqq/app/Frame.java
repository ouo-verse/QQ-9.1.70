package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qui.quiblurview.f;
import mqq.app.AppRuntime;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class Frame implements be {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Frame";
    private static IFrameInjectInterface sFrameInjectInterface;
    public AppRuntime app;
    private View contentView;
    protected boolean isResume;
    private QBaseActivity mActivity;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
            return;
        }
        try {
            if (FrameInjectUtil.sFrameInjectInterfaceClzList.size() > 0) {
                sFrameInjectInterface = FrameInjectUtil.sFrameInjectInterfaceClzList.get(0).newInstance();
                QLog.d("Frame", 1, "FrameInjectUtil newInstance");
            }
        } catch (Exception e16) {
            QLog.e("Frame", 1, "FrameInjectUtil static statement: ", e16);
        }
    }

    public Frame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.be
    public void dismissLocalSearchDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        View view = this.contentView;
        if (view != null) {
            Animation animation = view.getAnimation();
            if (animation != null) {
                animation.setAnimationListener(null);
            }
            this.contentView.clearAnimation();
        }
        sFrameInjectInterface.frameDrawerCleanAnim(this);
    }

    public abstract void fillData(boolean z16);

    public View findViewById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (View) iPatchRedirector.redirect((short) 27, (Object) this, i3);
        }
        View view = this.contentView;
        if (view == null) {
            return null;
        }
        return view.findViewById(i3);
    }

    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            this.mActivity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.be
    public final QBaseActivity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mActivity;
    }

    @Override // com.tencent.mobileqq.app.be
    public f.b getBlurDirtyState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (f.b) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.be
    public View getContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.contentView;
    }

    @Override // com.tencent.mobileqq.app.be
    public String getLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    public Resources getResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Resources) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.mActivity.getResources();
    }

    public String getString(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this, i3);
        }
        return this.mActivity.getString(i3);
    }

    @Override // com.tencent.mobileqq.app.be
    public boolean hasInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.be
    public boolean isFrameResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isResume;
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifyActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    @Override // com.tencent.mobileqq.app.ba
    public boolean notifyBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        return sFrameInjectInterface.handleCloseDrawer();
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifyConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) configuration);
        }
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifyContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            this.contentView = view;
        }
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifyCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.app = this.mActivity.getAppRuntime();
        }
    }

    @Override // com.tencent.mobileqq.app.ba
    public View notifyCreateView(LayoutInflater layoutInflater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, (Object) layoutInflater);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifyDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifyMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifyNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent);
        }
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifyPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.isResume = false;
        }
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifyRestoreInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifyResume(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.isResume = true;
        }
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifySaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifyStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.ba
    public void notifyStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else if (this.isResume) {
            notifyPause(false);
        }
    }

    @Override // com.tencent.mobileqq.app.be
    public void onAccountChanged() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        onBeforeAccountChanged();
        AppRuntime appRuntime = this.app;
        AppRuntime appRuntime2 = this.mActivity.getAppRuntime();
        this.app = appRuntime2;
        if (appRuntime != null && appRuntime2 != null) {
            z16 = !TextUtils.equals(appRuntime.getAccount(), appRuntime2.getAccount());
        } else {
            z16 = false;
        }
        fillData(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBeforeAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.be
    public void onDrawComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.be
    public void onFrameTabClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.be
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) logoutReason);
        }
    }

    @Override // com.tencent.mobileqq.app.be
    public View preLoadView(LayoutInflater layoutInflater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, (Object) layoutInflater);
        }
        return null;
    }

    public void runOnUiThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) runnable);
        } else {
            this.mActivity.runOnUiThread(runnable);
        }
    }

    @Override // com.tencent.mobileqq.app.be
    public void setActivity(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qBaseActivity);
        } else {
            this.mActivity = qBaseActivity;
        }
    }
}
