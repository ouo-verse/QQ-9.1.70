package com.tencent.gdtad.basics.motivevideo.hippy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.basics.motivevideo.hippy.GdtMotiveDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtMotiveDialogFragment extends GdtBaseDialogFragment {
    private GdtMotiveVideoPageData D;
    private d E;
    private final a F = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public final class a implements om0.d {
        a() {
        }

        @Override // om0.d
        public void addView(View view) {
            boolean z16;
            if (view == null) {
                QLog.e("GdtMotiveDialogFragment", 1, "[DialogHippyViewController][addView] error, view is null");
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[DialogHippyViewController][addView] getDialog():");
            if (GdtMotiveDialogFragment.this.getDialog() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i("GdtMotiveDialogFragment", 1, sb5.toString());
            if (GdtMotiveDialogFragment.this.getDialog() != null) {
                GdtMotiveDialogFragment.this.getDialog().setContentView(view);
            }
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void finish() {
            com.tencent.gdtad.basics.motivevideo.report.a.p("GdtMotiveDialogFragment", "[DialogHippyViewController][finish]", AdMetricID.Reward.HIPPY_DIALOG_FRAGMENT_VIEW_CONTROLLER_FINISH, GdtMotiveDialogFragment.this.D);
            GdtMotiveDialogFragment.this.setCancelable(true);
            GdtMotiveDialogFragment.this.ph();
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public Activity getActivity() {
            return GdtMotiveDialogFragment.this.getActivity();
        }

        @Override // om0.d
        public void removeView(View view) {
            if (view == null) {
                QLog.e("GdtMotiveDialogFragment", 1, "[DialogHippyViewController][removeView] error, view is null");
            } else {
                QLog.i("GdtMotiveDialogFragment", 1, "[DialogHippyViewController][removeView]");
                view.setVisibility(8);
            }
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void setResult(int i3, Intent intent) {
            ResultReceiver resultReceiver;
            if (GdtMotiveDialogFragment.this.getArguments() != null) {
                resultReceiver = (ResultReceiver) GdtMotiveDialogFragment.this.getArguments().getParcelable("receiver");
            } else {
                resultReceiver = null;
            }
            if (resultReceiver == null) {
                com.tencent.gdtad.basics.motivevideo.report.a.k("GdtMotiveDialogFragment", "[DialogHippyViewController][setResult] error, resultReceiver is null", null, AdMetricID.Reward.HIPPY_DIALOG_FRAGMENT_VIEW_CONTROLLER_SET_RESULT_FAILED, GdtMotiveDialogFragment.this.D, 1);
                return;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.p("GdtMotiveDialogFragment", "[DialogHippyViewController][setResult] resultCode:" + i3, AdMetricID.Reward.HIPPY_DIALOG_FRAGMENT_VIEW_CONTROLLER_SET_RESULT_SUCCESS, GdtMotiveDialogFragment.this.D);
            resultReceiver.send(i3, intent.getExtras());
        }
    }

    private void th() {
        if (getDialog() != null && getDialog().getWindow() != null) {
            try {
                getDialog().getWindow().getDecorView().setSystemUiVisibility(7942);
                return;
            } catch (Throwable th5) {
                QLog.e("GdtMotiveDialogFragment", 1, "[hideNavigateBar]", th5);
                return;
            }
        }
        QLog.e("GdtMotiveDialogFragment", 1, "[hideNavigateBar] error, dialog or window is null");
    }

    private void uh(ResultReceiver resultReceiver) {
        boolean z16;
        boolean z17;
        StartGdtMotiveVideoParams build = StartGdtMotiveVideoParams.build(getActivity(), this.D);
        build.resultReceiver = resultReceiver;
        if (this.E == null) {
            this.E = d.x(build, new WeakReference(this.F));
        }
        if (this.E == null) {
            d.X(build, 1);
            this.F.finish();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[initController] mHippyController:");
        if (this.E != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        String sb6 = sb5.toString();
        if (this.E != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.f("GdtMotiveDialogFragment", sb6, null, z17, AdMetricID.Reward.HIPPY_DIALOG_FRAGMENT_VIEW_CONTROLLER_INITIALIZE_SUCCESS, AdMetricID.Reward.HIPPY_DIALOG_FRAGMENT_VIEW_CONTROLLER_INITIALIZE_FAILED, this.D, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void vh(StartGdtMotiveVideoParams startGdtMotiveVideoParams, Activity activity) {
        try {
            GdtMotiveDialogFragment wh5 = wh(startGdtMotiveVideoParams.resultReceiver, startGdtMotiveVideoParams.data);
            wh5.setCancelable(false);
            wh5.qh((FragmentActivity) activity, "GdtMotiveDialogFragment");
            com.tencent.gdtad.basics.motivevideo.report.a.p("GdtMotiveDialogFragment", "[start]", AdMetricID.Reward.HIPPY_DIALOG_FRAGMENT_START_SUCCESS, startGdtMotiveVideoParams.data);
        } catch (Throwable th5) {
            com.tencent.gdtad.basics.motivevideo.report.a.k("GdtMotiveDialogFragment", "[start] error", th5, AdMetricID.Reward.HIPPY_DIALOG_FRAGMENT_START_FAILED, startGdtMotiveVideoParams.data, 15);
            d.X(startGdtMotiveVideoParams, 15);
        }
    }

    public static GdtMotiveDialogFragment wh(ResultReceiver resultReceiver, GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        Bundle bundle = new Bundle();
        GdtMotiveDialogFragment gdtMotiveDialogFragment = new GdtMotiveDialogFragment();
        bundle.putSerializable("data", gdtMotiveVideoPageData);
        bundle.putParcelable("receiver", resultReceiver);
        gdtMotiveDialogFragment.setArguments(bundle);
        return gdtMotiveDialogFragment;
    }

    public static void xh(final StartGdtMotiveVideoParams startGdtMotiveVideoParams, Intent intent) {
        int i3;
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        GdtMotiveVideoPageData gdtMotiveVideoPageData2;
        GdtMotiveVideoPageData gdtMotiveVideoPageData3;
        if (startGdtMotiveVideoParams != null) {
            final Activity activity = startGdtMotiveVideoParams.activity;
            if ((activity instanceof FragmentActivity) && (gdtMotiveVideoPageData3 = startGdtMotiveVideoParams.data) != null && gdtMotiveVideoPageData3.containerType == 1) {
                activity.setIntent(intent);
                activity.runOnUiThread(new Runnable() { // from class: mm0.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        GdtMotiveDialogFragment.vh(StartGdtMotiveVideoParams.this, activity);
                    }
                });
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[start] error, containerType:");
        if (startGdtMotiveVideoParams != null && (gdtMotiveVideoPageData2 = startGdtMotiveVideoParams.data) != null) {
            i3 = gdtMotiveVideoPageData2.containerType;
        } else {
            i3 = Integer.MIN_VALUE;
        }
        sb5.append(i3);
        String sb6 = sb5.toString();
        if (startGdtMotiveVideoParams != null) {
            gdtMotiveVideoPageData = startGdtMotiveVideoParams.data;
        } else {
            gdtMotiveVideoPageData = null;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.k("GdtMotiveDialogFragment", sb6, null, AdMetricID.Reward.HIPPY_DIALOG_FRAGMENT_START_FAILED, gdtMotiveVideoPageData, 4);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.avj);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.tencent.gdtad.basics.motivevideo.report.a.p("GdtMotiveDialogFragment", "[onDismiss]", AdMetricID.Reward.HIPPY_DIALOG_FRAGMENT_ON_DISMISS, this.D);
        d dVar = this.E;
        if (dVar != null) {
            dVar.w();
            this.E.A();
        }
        if (getArguments() != null) {
            getArguments().remove("receiver");
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.i("GdtMotiveDialogFragment", 1, "[onPause]");
        d dVar = this.E;
        if (dVar != null) {
            dVar.R();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i("GdtMotiveDialogFragment", 1, "[onResume]");
        d dVar = this.E;
        if (dVar != null) {
            dVar.V();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        QLog.i("GdtMotiveDialogFragment", 1, "[onStart]");
        d dVar = this.E;
        if (dVar != null) {
            dVar.W();
        }
        th();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        QLog.i("GdtMotiveDialogFragment", 1, "[onStop]");
        d dVar = this.E;
        if (dVar != null) {
            dVar.Y();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @SuppressLint({"RestrictedApi"})
    public void setupDialog(@NonNull Dialog dialog, int i3) {
        Serializable serializable;
        ResultReceiver resultReceiver;
        super.setupDialog(dialog, i3);
        Bundle arguments = getArguments();
        Window window = null;
        if (arguments != null) {
            serializable = arguments.getSerializable("data");
        } else {
            serializable = null;
        }
        if (serializable instanceof GdtMotiveVideoPageData) {
            this.D = (GdtMotiveVideoPageData) serializable;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.p("GdtMotiveDialogFragment", "[setupDialog]", AdMetricID.Reward.HIPPY_DIALOG_FRAGMENT_SETUP_DIALOG, this.D);
        if (arguments != null) {
            resultReceiver = (ResultReceiver) arguments.getParcelable("receiver");
        } else {
            resultReceiver = null;
        }
        if (dialog != null) {
            window = dialog.getWindow();
        }
        pm0.d.a(window);
        uh(resultReceiver);
    }
}
