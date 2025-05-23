package com.tencent.mobileqq.app.lifecycle;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements IFragmentLifecycleCallback {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.IFragmentLifecycleCallback
    public void onCreate(Fragment fragment, @Nullable @org.jetbrains.annotations.Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fragment, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.IFragmentLifecycleCallback
    public void onDestroy(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) fragment);
        } else {
            SceneTracker.f258213d.onQFragmentDestroy(fragment);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.IFragmentLifecycleCallback
    public void onHiddenChanged(Fragment fragment, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, fragment, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.IFragmentLifecycleCallback
    public void onPause(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fragment);
        } else {
            SceneTracker.f258213d.onQFragmentPaused(fragment);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.IFragmentLifecycleCallback
    public void onResume(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fragment);
        } else {
            SceneTracker.f258213d.onQFragmentResumed(fragment);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.IFragmentLifecycleCallback
    public void onStart(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragment);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.IFragmentLifecycleCallback
    public void onStop(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fragment);
        }
    }
}
