package com.tencent.gdtad.basics.motivevideo.hippy;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class e extends ReportDialog {
    private final WeakReference<Activity> C;
    private Application.ActivityLifecycleCallbacks D;
    private d E;
    private final StartGdtMotiveVideoParams F;
    private final b G;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public final class b implements om0.d {
        b() {
        }

        @Override // om0.d
        public void addView(View view) {
            if (view == null) {
                GdtLog.e("GdtMotiveHippyDialog", "[addView] view is null");
            } else {
                e.this.setContentView(view);
            }
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void finish() {
            e.this.d0();
            if (e.this.isShowing()) {
                e.this.b0();
                return;
            }
            AdThreadManager adThreadManager = AdThreadManager.getInstance();
            final e eVar = e.this;
            adThreadManager.postDelayed(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.f
                @Override // java.lang.Runnable
                public final void run() {
                    e.U(e.this);
                }
            }, 0, 100L);
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public Activity getActivity() {
            if (e.this.C != null) {
                return (Activity) e.this.C.get();
            }
            return null;
        }

        @Override // om0.d
        public void removeView(View view) {
            if (view == null) {
                GdtLog.e("GdtMotiveHippyDialog", "[removeView] view is null");
            } else {
                view.setVisibility(8);
            }
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void setResult(int i3, Intent intent) {
            ResultReceiver resultReceiver;
            if (e.this.F != null) {
                resultReceiver = e.this.F.resultReceiver;
            } else {
                resultReceiver = null;
            }
            if (resultReceiver != null && intent != null) {
                resultReceiver.send(i3, intent.getExtras());
            } else {
                GdtLog.e("GdtMotiveHippyDialog", "[setResult] resultReceiver == null || intent == null");
            }
        }
    }

    e(Activity activity, StartGdtMotiveVideoParams startGdtMotiveVideoParams) {
        super(activity, R.style.Theme.Black.NoTitleBar.Fullscreen);
        this.G = new b();
        this.C = new WeakReference<>(activity);
        this.F = startGdtMotiveVideoParams;
        X();
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: mm0.c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                com.tencent.gdtad.basics.motivevideo.hippy.e.this.Y(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void U(e eVar) {
        eVar.b0();
    }

    private void X() {
        StartGdtMotiveVideoParams startGdtMotiveVideoParams = this.F;
        if (startGdtMotiveVideoParams == null) {
            GdtLog.e("GdtMotiveHippyDialog", "[initController] parameters is invalid");
            return;
        }
        if (this.E == null) {
            this.E = d.x(startGdtMotiveVideoParams, new WeakReference(this.G));
        }
        if (this.E == null) {
            d.X(this.F, 1);
            this.G.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(DialogInterface dialogInterface) {
        d dVar = this.E;
        if (dVar != null) {
            dVar.w();
            this.E.A();
        }
        GdtLog.i("GdtMotiveHippyDialog", "[onActivityStopped]: ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(Activity activity, StartGdtMotiveVideoParams startGdtMotiveVideoParams) {
        try {
            new e(activity, startGdtMotiveVideoParams).show();
        } catch (Throwable th5) {
            d.X(startGdtMotiveVideoParams, 15);
            GdtLog.e("GdtMotiveHippyDialog", "[start] GdtMotiveVideoDialog.show()", th5);
        }
    }

    private void a0() {
        GdtLog.i("GdtMotiveHippyDialog", "[registerActivityLifecycle]");
        try {
            if (this.D == null) {
                this.D = new a();
                Activity activity = this.G.getActivity();
                if (activity == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    activity.registerActivityLifecycleCallbacks(this.D);
                } else {
                    Application application = (Application) activity.getApplicationContext();
                    if (application == null) {
                    } else {
                        application.registerActivityLifecycleCallbacks(this.D);
                    }
                }
            }
        } catch (Throwable th5) {
            GdtLog.e("GdtMotiveHippyDialog", th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        try {
            dismiss();
        } catch (Throwable unused) {
            GdtLog.e("GdtMotiveHippyDialog", "[safeDismiss]");
        }
    }

    public static void c0(final StartGdtMotiveVideoParams startGdtMotiveVideoParams, Intent intent) {
        int i3;
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        final Activity activity;
        GdtMotiveVideoPageData gdtMotiveVideoPageData2;
        if (startGdtMotiveVideoParams != null && (activity = startGdtMotiveVideoParams.activity) != null && (gdtMotiveVideoPageData2 = startGdtMotiveVideoParams.data) != null && gdtMotiveVideoPageData2.containerType == 1) {
            activity.setIntent(intent);
            activity.runOnUiThread(new Runnable() { // from class: mm0.b
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.gdtad.basics.motivevideo.hippy.e.Z(activity, startGdtMotiveVideoParams);
                }
            });
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[start] error params");
        if (startGdtMotiveVideoParams != null && (gdtMotiveVideoPageData = startGdtMotiveVideoParams.data) != null) {
            i3 = gdtMotiveVideoPageData.containerType;
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        GdtLog.e("GdtMotiveHippyDialog", sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        Application application;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        GdtLog.i("GdtMotiveHippyDialog", "[unregisterActivityLifecycle]");
        Activity activity = this.G.getActivity();
        if (activity == null) {
            application = null;
        } else {
            application = activity.getApplication();
        }
        if (application != null && (activityLifecycleCallbacks = this.D) != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.D = null;
        }
    }

    private void initWindow() {
        pm0.d.a(getWindow());
        a0();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        initWindow();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        GdtLog.i("GdtMotiveHippyDialog", "[onWindowFocusChanged] called with: hasFocus = [" + z16 + "]");
        if (z16 && getWindow() != null && getWindow().getDecorView() != null) {
            getWindow().getDecorView().setSystemUiVisibility(7942);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            GdtLog.i("GdtMotiveHippyDialog", "[onActivityCreated], activity: " + activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (e.this.G.getActivity() == activity && e.this.E != null) {
                e.this.d0();
                GdtLog.i("GdtMotiveHippyDialog", "[onActivityDestroyed]: ");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (e.this.G.getActivity() == activity && e.this.E != null) {
                e.this.E.R();
                GdtLog.i("GdtMotiveHippyDialog", "[onActivityPaused]: ");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (e.this.G.getActivity() == activity && e.this.E != null) {
                e.this.E.V();
                GdtLog.i("GdtMotiveHippyDialog", "[onActivityResumed]: ");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (e.this.G.getActivity() == activity && e.this.E != null) {
                e.this.E.W();
                GdtLog.i("GdtMotiveHippyDialog", "[onActivityStarted]: ");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (e.this.G.getActivity() == activity && e.this.E != null) {
                e.this.E.Y();
                GdtLog.i("GdtMotiveHippyDialog", "[onActivityStopped]: ");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
