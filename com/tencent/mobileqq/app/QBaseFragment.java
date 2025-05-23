package com.tencent.mobileqq.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.activity.ep;
import com.tencent.mobileqq.app.lifecycle.IFragmentLifecycleCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QBaseFragment extends BasePartFragment {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "QBaseFragment";
    private static IFragmentLifecycleCallback sGlobalFragmentLifecycleCallback;
    IFragmentHiddenCallback mIFragmentLifecycleCallback;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface IFragmentAttachCallback {
        void onFragmentAttached(QBaseFragment qBaseFragment);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface IFragmentHiddenCallback {
        void onFragmentHiddenChanged(QBaseFragment qBaseFragment, boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42271);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        if (QBaseActivityInjectUtil.sGlobalFragmentLifeCycleList.size() > 0) {
            QLog.i(TAG, 1, "initInjectVariable \u4e4b\u540e\uff0csGlobalFragmentLifeCycleList: " + QBaseActivityInjectUtil.sGlobalFragmentLifeCycleList.get(0).toString());
            sGlobalFragmentLifecycleCallback = QBaseActivityInjectUtil.sGlobalFragmentLifeCycleList.get(0);
        }
    }

    public QBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    public String getCIOPageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return getClass().getName();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 0;
    }

    public final QBaseActivity getQBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (QBaseActivity) ep.a(getActivity());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        IFragmentLifecycleCallback iFragmentLifecycleCallback = sGlobalFragmentLifecycleCallback;
        if (iFragmentLifecycleCallback != null) {
            iFragmentLifecycleCallback.onCreate(this, bundle);
        }
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onDestroy();
        IFragmentLifecycleCallback iFragmentLifecycleCallback = sGlobalFragmentLifecycleCallback;
        if (iFragmentLifecycleCallback != null) {
            iFragmentLifecycleCallback.onDestroy(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        super.onHiddenChanged(z16);
        IFragmentLifecycleCallback iFragmentLifecycleCallback = sGlobalFragmentLifecycleCallback;
        if (iFragmentLifecycleCallback != null) {
            iFragmentLifecycleCallback.onHiddenChanged(this, z16);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onPause();
        IFragmentLifecycleCallback iFragmentLifecycleCallback = sGlobalFragmentLifecycleCallback;
        if (iFragmentLifecycleCallback != null) {
            iFragmentLifecycleCallback.onPause(this);
        }
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public /* bridge */ /* synthetic */ void onPostThemeChanged() {
        com.tencent.biz.richframework.compat.f.k(this);
    }

    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onResume();
        IFragmentLifecycleCallback iFragmentLifecycleCallback = sGlobalFragmentLifecycleCallback;
        if (iFragmentLifecycleCallback != null) {
            iFragmentLifecycleCallback.onResume(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onStart();
        IFragmentLifecycleCallback iFragmentLifecycleCallback = sGlobalFragmentLifecycleCallback;
        if (iFragmentLifecycleCallback != null) {
            iFragmentLifecycleCallback.onStart(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onStop();
        IFragmentLifecycleCallback iFragmentLifecycleCallback = sGlobalFragmentLifecycleCallback;
        if (iFragmentLifecycleCallback != null) {
            iFragmentLifecycleCallback.onStop(this);
        }
    }

    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    public void setFragmentLifecycleCallback(IFragmentHiddenCallback iFragmentHiddenCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iFragmentHiddenCallback);
        } else {
            this.mIFragmentLifecycleCallback = iFragmentHiddenCallback;
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
