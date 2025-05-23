package com.tencent.mobileqq.mvvm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QLifeCycleFragment extends ReportAndroidXFragment implements d {
    static IPatchRedirector $redirector_;
    private e C;

    public QLifeCycleFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.C = new e();
        }
    }

    public static d ph(FragmentActivity fragmentActivity) {
        Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag("fragment_tag_life_cycle_QFragment");
        if (findFragmentByTag instanceof QLifeCycleFragment) {
            return (QLifeCycleFragment) findFragmentByTag;
        }
        FragmentTransaction beginTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        QLifeCycleFragment qLifeCycleFragment = new QLifeCycleFragment();
        beginTransaction.add(qLifeCycleFragment, "fragment_tag_life_cycle_QFragment");
        beginTransaction.commitAllowingStateLoss();
        return qLifeCycleFragment;
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

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            this.C.e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
            this.C.onDestroy();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onPause();
            this.C.onPause();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            this.C.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onStart();
            this.C.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
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
