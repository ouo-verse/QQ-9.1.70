package com.tencent.gdtad.basics.motivevideo;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e extends ReportDialog {
    private Activity C;
    private Intent D;
    private GdtMvVideoViewController E;
    private GdtMotiveVideoModel F;
    private Intent G;
    private Application.ActivityLifecycleCallbacks H;
    private boolean I;
    private ResultReceiver J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements n {
        a() {
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void finish() {
            e.this.dismiss();
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public Activity getActivity() {
            return e.this.C;
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void setResult(int i3, Intent intent) {
            if (e.this.J == null) {
                QLog.i("GdtMotiveVideoDialog", 1, "mResultReceiver == null");
            } else {
                e.this.J.send(i3, intent.getExtras());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f108929d;

        b(ViewGroup viewGroup) {
            this.f108929d = viewGroup;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i3) {
            if ((i3 & 4) == 0) {
                this.f108929d.setSystemUiVisibility(7942);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f108931d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f108932e;

        c(ViewGroup viewGroup, View view) {
            this.f108931d = viewGroup;
            this.f108932e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f108931d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            GdtLog.d("GdtMotiveVideoDialog", "onGlobalLayout: l=" + this.f108931d.getLeft() + ",t=" + this.f108931d.getTop() + ",r=" + this.f108931d.getRight() + ",b=" + this.f108931d.getBottom());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onGlobalLayout: ");
            sb5.append(this.f108932e);
            GdtLog.d("GdtMotiveVideoDialog", sb5.toString());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.basics.motivevideo.e$e, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class DialogInterfaceOnDismissListenerC1153e implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<e> f108935d;

        public DialogInterfaceOnDismissListenerC1153e(e eVar) {
            this.f108935d = new WeakReference<>(eVar);
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            e eVar = this.f108935d.get();
            if (eVar == null) {
                QLog.i("GdtMotiveVideoDialog", 1, "gdtMotiveVideoDialog == null");
                return;
            }
            eVar.C.setIntent(eVar.G);
            eVar.C.getApplication().unregisterActivityLifecycleCallbacks(eVar.H);
            eVar.E.D();
            eVar.H = null;
            eVar.J = null;
        }
    }

    public e(@NonNull Context context) {
        super(context, R.style.Theme.Black.NoTitleBar.Fullscreen);
        this.C = (Activity) context;
    }

    private static GdtMotiveVideoPageData X(@Nullable Serializable serializable) {
        if (!(serializable instanceof GdtMotiveVideoPageData)) {
            return null;
        }
        return (GdtMotiveVideoPageData) serializable;
    }

    private void Y() {
        boolean z16;
        boolean z17;
        this.G = this.C.getIntent();
        this.C.setIntent(this.D);
        Bundle extras = this.D.getExtras();
        if (extras == null) {
            return;
        }
        GdtMotiveVideoPageData X = X(extras.getSerializable("data"));
        if (X == null) {
            QLog.e("GdtMotiveVideoDialog", 4, "[initData] firstVideoData is null");
            return;
        }
        this.F = new GdtMotiveVideoModel(X);
        if (this.C.getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!X.isLandscapeForcePortrait && (!z16 || !X.isForcePortrait)) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.I = z17;
        QLog.d("GdtMotiveVideoDialog", 1, "initData: isOriLandscape:", Boolean.valueOf(z16), ",mIsLandscapeForcePortrait:", Boolean.valueOf(this.I));
    }

    private void Z() {
        this.E = new GdtMvVideoViewController(new a(), this.F, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(int i3) {
        if (this.I && this.C != null) {
            QLog.d("GdtMotiveVideoDialog", 1, "updateForceOrientation:", Integer.valueOf(i3));
            this.C.setRequestedOrientation(i3);
        }
    }

    private void initView() {
        Z();
        this.E.A0(1);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        window.setFlags(1024, 1024);
        window.setVolumeControlStream(3);
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        viewGroup.setSystemUiVisibility(7942);
        viewGroup.setOnSystemUiVisibilityChangeListener(new b(viewGroup));
        View P = this.E.P(LayoutInflater.from(this.C), viewGroup);
        setContentView(P);
        setOnDismissListener(new DialogInterfaceOnDismissListenerC1153e(this));
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new c(viewGroup, P));
        this.H = new d();
        this.C.getApplication().registerActivityLifecycleCallbacks(this.H);
        this.E.d0();
    }

    public void a0(ResultReceiver resultReceiver) {
        this.J = resultReceiver;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.E.c0()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Y();
        initView();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b0(0);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.E.i0();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.E.f0();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        GdtLog.d("GdtMotiveVideoDialog", "onWindowFocusChanged() called with: hasFocus = [" + z16 + "]");
        if (z16) {
            getWindow().getDecorView().setSystemUiVisibility(7942);
        }
    }

    public void setIntent(Intent intent) {
        this.D = intent;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        b0(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d implements Application.ActivityLifecycleCallbacks {
        d() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity == e.this.C) {
                e.this.b0(0);
                e.this.E.e0();
                e.this.C.getApplication().unregisterActivityLifecycleCallbacks(e.this.H);
                e.this.H = null;
                e.this.J = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (activity == e.this.C) {
                e.this.E.g0(false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (activity == e.this.C) {
                e.this.E.i0();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity == e.this.C) {
                e.this.E.F0();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
