package com.tencent.mobileqq.auto.engine.main.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.main.IASFragment;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements IASFragment {
    static IPatchRedirector $redirector_;
    private FragmentManager C;

    /* renamed from: d, reason: collision with root package name */
    private final ViewGroup f199904d;

    /* renamed from: e, reason: collision with root package name */
    private ASEnterBean f199905e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f199906f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f199907h;

    /* renamed from: i, reason: collision with root package name */
    private View f199908i;

    /* renamed from: m, reason: collision with root package name */
    private Fragment f199909m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(@NonNull ViewGroup viewGroup, @Nullable ASEnterBean aSEnterBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewGroup, (Object) aSEnterBean);
            return;
        }
        this.f199904d = viewGroup;
        this.f199905e = aSEnterBean;
        this.f199906f = (Activity) viewGroup.getContext();
        f();
        e();
        a();
        QLog.d("QFSTabFakeNativeFragment", 1, "mEnterBean has init " + hashCode());
    }

    private void a() {
        c();
        b();
        d();
    }

    private void b() {
        FragmentManager fragmentManager = this.C;
        if (fragmentManager != null && fragmentManager.getFragments().size() > 0) {
            for (Fragment fragment : this.C.getFragments()) {
                if ("QFSTabFakeNativeFragment".equals(fragment.getTag())) {
                    try {
                        this.C.beginTransaction().remove(fragment).commitNowAllowingStateLoss();
                        QLog.d("QFSTabFakeNativeFragment", 1, "remove success");
                        ViewGroup viewGroup = this.f199904d;
                        if (viewGroup != null) {
                            viewGroup.removeView(this.f199908i);
                        }
                    } catch (Exception e16) {
                        QLog.e("QFSTabFakeNativeFragment", 1, e16, new Object[0]);
                    }
                }
            }
        }
    }

    private void c() {
        Activity activity = this.f199906f;
        if (activity == null) {
            QLog.d("QFSTabFakeNativeFragment", 1, "initChildFragment hostActivity is null");
            return;
        }
        Fragment findFragmentByTag = ((FragmentActivity) activity).getSupportFragmentManager().findFragmentByTag("com.tencent.mobileqq.activity.home.MainFragment");
        if (findFragmentByTag == null) {
            QLog.d("QFSTabFakeNativeFragment", 1, "initChildFragment mainFragment is null");
        } else {
            this.C = findFragmentByTag.getChildFragmentManager();
        }
    }

    private void d() {
        if (this.f199908i != null || this.C == null) {
            return;
        }
        this.f199909m = ((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).createFolderFragment();
        this.C.beginTransaction().add(this.f199909m, "QFSTabFakeNativeFragment").setMaxLifecycle(this.f199909m, Lifecycle.State.STARTED).commitNowAllowingStateLoss();
        this.f199908i = this.f199909m.getView();
    }

    private void e() {
        if (this.f199907h) {
            return;
        }
        this.f199907h = true;
        ((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).preloadFolderView(this.f199906f);
    }

    public void f() {
        boolean z16;
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f199905e != null && (activity = this.f199906f) != null) {
            ((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).putArgusToHostActivity(activity.getIntent(), this.f199905e.getSchemeAction(), this.f199905e.getAttrs(), this.f199905e.getByteAttrs());
            QLog.d("QFSTabFakeNativeFragment", 1, "setEnterBean" + hashCode());
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setEnterBeanToActivity error:");
        boolean z17 = false;
        if (this.f199905e == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("|");
        if (this.f199906f == null) {
            z17 = true;
        }
        sb5.append(z17);
        QLog.d("QFSTabFakeNativeFragment", 1, sb5.toString());
    }

    public void g(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) intent);
            return;
        }
        try {
            if (this.f199905e == null) {
                return;
            }
            ((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).putArgusToHostActivity(intent, this.f199905e.getSchemeAction(), this.f199905e.getAttrs(), this.f199905e.getByteAttrs());
            QLog.d("QFSTabFakeNativeFragment", 1, "updateIntent");
        } catch (Exception e16) {
            QLog.d("QFSTabFakeNativeFragment", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public View getTargetDecorView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (View) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f199908i;
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public boolean isAdded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        View view = this.f199908i;
        if (view != null && view.getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public boolean isRealFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        }
        return this.f199908i;
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f199906f != null && this.f199909m != null) {
            b();
        }
        this.f199909m = null;
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onNewIntent(@NonNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle);
        } else if ((bundle.getSerializable(ASEngineConstants.ShadowEngineKey.KEY_AS_ENTER_BEAN) instanceof ASEnterBean) && this.f199906f != null) {
            this.f199905e = (ASEnterBean) bundle.getSerializable(ASEngineConstants.ShadowEngineKey.KEY_AS_ENTER_BEAN);
            ((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).putArgusToHostActivity(this.f199906f.getIntent(), this.f199905e.getSchemeAction(), this.f199905e.getAttrs(), this.f199905e.getByteAttrs());
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            FragmentManager fragmentManager = this.C;
            if (fragmentManager != null && this.f199909m != null) {
                fragmentManager.beginTransaction().setMaxLifecycle(this.f199909m, Lifecycle.State.STARTED).commitNowAllowingStateLoss();
            }
        } catch (Exception e16) {
            QLog.e("QFSTabFakeNativeFragment", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            FragmentManager fragmentManager = this.C;
            if (fragmentManager != null && this.f199909m != null) {
                fragmentManager.beginTransaction().setMaxLifecycle(this.f199909m, Lifecycle.State.RESUMED).commitNowAllowingStateLoss();
            }
        } catch (Exception e16) {
            QLog.e("QFSTabFakeNativeFragment", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setArguments(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setHostActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
        } else {
            this.f199906f = activity;
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setIsSelected(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
    }
}
