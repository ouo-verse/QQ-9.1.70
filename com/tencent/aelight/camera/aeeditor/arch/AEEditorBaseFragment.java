package com.tencent.aelight.camera.aeeditor.arch;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import ar.b;
import com.tencent.aelight.camera.aeeditor.AEEditorActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class AEEditorBaseFragment extends QPublicBaseFragment {
    private b C;
    public String D;
    protected Dialog F;
    private ViewModelStore H;
    protected Handler E = new Handler(Looper.getMainLooper());
    private final LifecycleRegistry G = new LifecycleRegistry(this);

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ AEEditorBaseFragment this$0;

        @Override // java.lang.Runnable
        public void run() {
            Dialog dialog = this.this$0.F;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    private void sh(Lifecycle.Event event) {
        try {
            this.G.handleLifecycleEvent(event);
        } catch (Throwable unused) {
            QLog.e("AEEditorBaseFragment", 1, "mLifecycleRegistry \u521d\u59cb\u5316\u5931\u8d25");
        }
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.G;
    }

    public abstract String getModuleId();

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (BaseApplicationImpl.getApplication() != null) {
            if (this.H == null) {
                this.H = new ViewModelStore();
            }
            return this.H;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        sh(Lifecycle.Event.ON_CREATE);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        sh(Lifecycle.Event.ON_DESTROY);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sh(Lifecycle.Event.ON_PAUSE);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        sh(Lifecycle.Event.ON_RESUME);
        if (this.C == null && getActivity() != null && (getActivity() instanceof AEEditorActivity)) {
            this.C = ((AEEditorActivity) getActivity()).I2();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        sh(Lifecycle.Event.ON_START);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        sh(Lifecycle.Event.ON_STOP);
    }

    public b ph() {
        b bVar = this.C;
        if (bVar != null) {
            return bVar;
        }
        throw new RuntimeException("moduleManager not set");
    }

    public boolean qh() {
        return false;
    }

    public void rh(b bVar) {
        this.C = bVar;
    }

    public void doOnBackPressed() {
    }

    public void doOnActivityResult(int i3, int i16, Intent intent) {
    }
}
