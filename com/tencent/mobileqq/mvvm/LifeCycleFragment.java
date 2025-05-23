package com.tencent.mobileqq.mvvm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LifeCycleFragment extends BaseFragment implements d {
    static IPatchRedirector $redirector_;
    private e C;

    public LifeCycleFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.C = new e();
        }
    }

    public static d ph(QBaseActivity qBaseActivity) {
        Fragment findFragmentByTag = qBaseActivity.getSupportFragmentManager().findFragmentByTag("fragment_tag_life_cycle_Fragment");
        if (findFragmentByTag instanceof LifeCycleFragment) {
            return (LifeCycleFragment) findFragmentByTag;
        }
        FragmentTransaction beginTransaction = qBaseActivity.getSupportFragmentManager().beginTransaction();
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        LifeCycleFragment lifeCycleFragment = new LifeCycleFragment();
        beginTransaction.add(lifeCycleFragment, "fragment_tag_life_cycle_Fragment");
        beginTransaction.commitAllowingStateLoss();
        return lifeCycleFragment;
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Lifecycle) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.C.getLifecycle();
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ViewModelStore) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.C.getViewModelStore();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            this.C.e();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
            this.C.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onPause();
            this.C.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            this.C.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onStart();
            this.C.onStart();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onStop();
            this.C.onStop();
        }
    }
}
