package com.tencent.aelight.camera.aebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.ae.q;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e implements q, LifecycleOwner, ViewModelStoreOwner {

    /* renamed from: d, reason: collision with root package name */
    private LifecycleRegistry f66027d = new LifecycleRegistry(this);

    /* renamed from: e, reason: collision with root package name */
    private ViewModelStore f66028e;

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f66027d;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (MobileQQ.sMobileQQ != null) {
            if (this.f66028e == null) {
                this.f66028e = new ViewModelStore();
            }
            return this.f66028e;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // com.tencent.aelight.camera.ae.q
    public boolean m(int i3, KeyEvent keyEvent, boolean z16) {
        return false;
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void onActivityPause() {
        try {
            this.f66027d.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        } catch (Throwable unused) {
            QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void onActivityResume() {
        try {
            this.f66027d.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        } catch (Throwable unused) {
            QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void onActivityStart() {
        try {
            this.f66027d.handleLifecycleEvent(Lifecycle.Event.ON_START);
        } catch (Throwable unused) {
            QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void onActivityStop() {
        try {
            this.f66027d.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        } catch (Throwable unused) {
            QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void onCreate(Bundle bundle) {
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f66027d = lifecycleRegistry;
        try {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        } catch (Throwable unused) {
            QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void onDestroy() {
        try {
            this.f66027d.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        } catch (Throwable unused) {
            QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
        ViewModelStore viewModelStore = this.f66028e;
        if (viewModelStore != null) {
            viewModelStore.clear();
        }
    }

    @Override // com.tencent.aelight.camera.ae.q
    public boolean onTouchEvent(MotionEvent motionEvent, boolean z16) {
        return false;
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void onNewIntent(Intent intent) {
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void onWindowFocusChanged(boolean z16) {
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void finish() {
    }

    @Override // com.tencent.aelight.camera.ae.q
    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
