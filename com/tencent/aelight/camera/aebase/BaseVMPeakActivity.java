package com.tencent.aelight.camera.aebase;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class BaseVMPeakActivity extends PeakActivity implements ViewModelStoreOwner {
    private LifecycleRegistry P = new LifecycleRegistry(this);
    private ViewModelStore Q;

    @Override // mqq.app.BaseActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.P;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (BaseApplicationImpl.getApplication() != null) {
            if (this.Q == null) {
                this.Q = new ViewModelStore();
            }
            return this.Q;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.P = lifecycleRegistry;
        try {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        } catch (Throwable unused) {
            QLog.e("BaseActivity2", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            this.P.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        } catch (Throwable unused) {
            QLog.e("BaseActivity2", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
        if (this.Q == null || isChangingConfigurations()) {
            return;
        }
        this.Q.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            this.P.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        } catch (Throwable unused) {
            QLog.e("BaseActivity2", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            this.P.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        } catch (Throwable unused) {
            QLog.e("BaseActivity2", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            this.P.handleLifecycleEvent(Lifecycle.Event.ON_START);
        } catch (Throwable unused) {
            QLog.e("BaseActivity2", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        try {
            this.P.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        } catch (Throwable unused) {
            QLog.e("BaseActivity2", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
    }
}
