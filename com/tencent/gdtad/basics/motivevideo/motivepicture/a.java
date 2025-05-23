package com.tencent.gdtad.basics.motivevideo.motivepicture;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.n;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends ReportDialog {
    private Activity C;
    private Intent D;
    private GdtMvPictureViewController E;
    private GdtMotiveVideoModel F;
    private Intent G;
    private Application.ActivityLifecycleCallbacks H;
    private boolean I;
    private ResultReceiver J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.basics.motivevideo.motivepicture.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1157a implements n {
        C1157a() {
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void finish() {
            a.this.dismiss();
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public Activity getActivity() {
            return a.this.C;
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void setResult(int i3, Intent intent) {
            if (a.this.J == null) {
                QLog.i("GdtMotivePictureDialog", 1, "mResultReceiver == null");
            } else {
                a.this.J.send(i3, intent.getExtras());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f109072d;

        b(ViewGroup viewGroup) {
            this.f109072d = viewGroup;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i3) {
            if ((i3 & 4) == 0) {
                this.f109072d.setSystemUiVisibility(7942);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f109074d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f109075e;

        c(ViewGroup viewGroup, View view) {
            this.f109074d = viewGroup;
            this.f109075e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f109074d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            GdtLog.d("GdtMotivePictureDialog", "onGlobalLayout: l=" + this.f109074d.getLeft() + ",t=" + this.f109074d.getTop() + ",r=" + this.f109074d.getRight() + ",b=" + this.f109074d.getBottom());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onGlobalLayout: ");
            sb5.append(this.f109075e);
            GdtLog.d("GdtMotivePictureDialog", sb5.toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class e implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<a> f109078d;

        public e(a aVar) {
            this.f109078d = new WeakReference<>(aVar);
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a aVar = this.f109078d.get();
            if (aVar == null) {
                QLog.i("GdtMotivePictureDialog", 1, "gdtMotivePictureDialog == null");
                return;
            }
            aVar.C.setIntent(aVar.G);
            aVar.C.getApplication().unregisterActivityLifecycleCallbacks(aVar.H);
            aVar.E.u();
            aVar.H = null;
            aVar.J = null;
        }
    }

    public a(@NonNull Context context) {
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
            QLog.e("GdtMotivePictureDialog", 4, "[initData] firstVideoData is null");
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
        QLog.d("GdtMotivePictureDialog", 1, "initData: isOriLandscape:", Boolean.valueOf(z16), ",mIsLandscapeForcePortrait:", Boolean.valueOf(this.I));
    }

    private void Z() {
        this.E = new GdtMvPictureViewController(new C1157a(), this.F, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(int i3) {
        if (this.I && this.C != null) {
            QLog.d("GdtMotivePictureDialog", 1, "updateForceOrientation:", Integer.valueOf(i3));
            this.C.setRequestedOrientation(i3);
        }
    }

    private void initView() {
        b0(1);
        Z();
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
        View C = this.E.C(LayoutInflater.from(this.C), viewGroup);
        setContentView(C);
        setOnDismissListener(new e(this));
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new c(viewGroup, C));
        this.H = new d();
        this.C.getApplication().registerActivityLifecycleCallbacks(this.H);
        this.E.P();
    }

    public void a0(ResultReceiver resultReceiver) {
        this.J = resultReceiver;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.E.O()) {
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
        this.E.U();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.E.R();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        GdtLog.d("GdtMotivePictureDialog", "onWindowFocusChanged() called with: hasFocus = [" + z16 + "]");
        if (z16) {
            getWindow().getDecorView().setSystemUiVisibility(7942);
        }
    }

    public void setIntent(Intent intent) {
        this.D = intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d implements Application.ActivityLifecycleCallbacks {
        d() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity == a.this.C) {
                a.this.b0(0);
                a.this.E.Q();
                a.this.C.getApplication().unregisterActivityLifecycleCallbacks(a.this.H);
                a.this.H = null;
                a.this.J = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (activity == a.this.C) {
                a.this.E.S(false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (activity == a.this.C) {
                a.this.E.U();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity == a.this.C) {
                a.this.E.V();
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
