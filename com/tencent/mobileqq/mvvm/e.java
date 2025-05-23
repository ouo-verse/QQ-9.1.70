package com.tencent.mobileqq.mvvm;

import android.support.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e implements LifecycleOwner, ViewModelStoreOwner {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private LifecycleRegistry f252469d;

    /* renamed from: e, reason: collision with root package name */
    private ViewModelStore f252470e;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f252469d = null;
            this.f252470e = null;
        }
    }

    private void a(Lifecycle.Event event) {
        try {
            d().handleLifecycleEvent(event);
        } catch (Throwable unused) {
            QLog.e("LifeCycleDispatcher", 1, "handleLifecycleEvent fail : event -> " + event);
        }
    }

    private LifecycleRegistry d() {
        if (this.f252469d == null) {
            this.f252469d = new LifecycleRegistry(this);
        }
        return this.f252469d;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            a(Lifecycle.Event.ON_CREATE);
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Lifecycle) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return d();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ViewModelStore) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.f252470e == null) {
            this.f252470e = new ViewModelStore();
        }
        return this.f252470e;
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            a(Lifecycle.Event.ON_DESTROY);
            getViewModelStore().clear();
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            a(Lifecycle.Event.ON_PAUSE);
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            a(Lifecycle.Event.ON_RESUME);
        }
    }

    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            a(Lifecycle.Event.ON_START);
        }
    }

    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            a(Lifecycle.Event.ON_STOP);
        }
    }
}
