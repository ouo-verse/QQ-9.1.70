package com.tencent.gdtad.basics.motivevideo.hippy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtMotiveHippyFragment extends QPublicBaseFragment {
    private d C;
    private final a D = new a();
    private StartGdtMotiveVideoParams E;
    private FrameLayout F;

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
                QLog.e("GdtMotiveHippyFragment", 1, "[FragmentHippyViewController][addView] error, view is null");
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[FragmentHippyViewController][addView] mFragmentRootView:");
            if (GdtMotiveHippyFragment.this.F != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i("GdtMotiveHippyFragment", 1, sb5.toString());
            if (GdtMotiveHippyFragment.this.F != null) {
                GdtMotiveHippyFragment.this.F.addView(view);
            }
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void finish() {
            GdtMotiveVideoPageData gdtMotiveVideoPageData;
            if (GdtMotiveHippyFragment.this.E != null) {
                gdtMotiveVideoPageData = GdtMotiveHippyFragment.this.E.data;
            } else {
                gdtMotiveVideoPageData = null;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.p("GdtMotiveHippyFragment", "[FragmentHippyViewController][finish]", AdMetricID.Reward.HIPPY_FRAGMENT_VIEW_CONTROLLER_FINISH, gdtMotiveVideoPageData);
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public Activity getActivity() {
            return GdtMotiveHippyFragment.this.getQBaseActivity();
        }

        @Override // om0.d
        public void removeView(View view) {
            boolean z16;
            if (view == null) {
                QLog.e("GdtMotiveHippyFragment", 1, "[FragmentHippyViewController][removeView] error, view is null");
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[FragmentHippyViewController][removeView] mFragmentRootView:");
            if (GdtMotiveHippyFragment.this.F != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i("GdtMotiveHippyFragment", 1, sb5.toString());
            if (GdtMotiveHippyFragment.this.F != null) {
                GdtMotiveHippyFragment.this.F.removeView(view);
            }
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void setResult(int i3, Intent intent) {
            ResultReceiver resultReceiver;
            boolean z16;
            boolean z17;
            GdtMotiveVideoPageData gdtMotiveVideoPageData = null;
            if (GdtMotiveHippyFragment.this.getArguments() != null) {
                resultReceiver = (ResultReceiver) GdtMotiveHippyFragment.this.getArguments().getParcelable("result_receiver");
            } else {
                resultReceiver = null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[FragmentHippyViewController][setResult] resultReceiver:");
            if (resultReceiver != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            String sb6 = sb5.toString();
            if (resultReceiver != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (GdtMotiveHippyFragment.this.E != null) {
                gdtMotiveVideoPageData = GdtMotiveHippyFragment.this.E.data;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.f("GdtMotiveHippyFragment", sb6, null, z17, AdMetricID.Reward.HIPPY_FRAGMENT_VIEW_CONTROLLER_SET_RESULT_SUCCESS, AdMetricID.Reward.HIPPY_FRAGMENT_VIEW_CONTROLLER_SET_RESULT_FAILED, gdtMotiveVideoPageData, 1);
            if (resultReceiver != null) {
                resultReceiver.send(i3, intent.getExtras());
            }
        }
    }

    private static GdtMotiveVideoPageData rh(Serializable serializable) {
        if (!(serializable instanceof GdtMotiveVideoPageData)) {
            return null;
        }
        return (GdtMotiveVideoPageData) serializable;
    }

    private void sh() {
        boolean z16;
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        d x16 = d.x(this.E, new WeakReference(this.D));
        this.C = x16;
        if (x16 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        StartGdtMotiveVideoParams startGdtMotiveVideoParams = this.E;
        if (startGdtMotiveVideoParams != null) {
            gdtMotiveVideoPageData = startGdtMotiveVideoParams.data;
        } else {
            gdtMotiveVideoPageData = null;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.f("GdtMotiveHippyFragment", "[initController]", null, z16, AdMetricID.Reward.HIPPY_FRAGMENT_INITIALIZE_CONTROLLER_SUCCESS, AdMetricID.Reward.HIPPY_FRAGMENT_INITIALIZE_CONTROLLER_FAILED, gdtMotiveVideoPageData, 1);
        if (this.C == null) {
            d.X(this.E, 1);
            this.D.finish();
        }
    }

    private void th(Activity activity) {
        Bundle bundle;
        if (activity == null) {
            com.tencent.gdtad.basics.motivevideo.report.a.k("GdtMotiveHippyFragment", "[initData] error, activity is null", null, AdMetricID.Reward.HIPPY_FRAGMENT_INITIALIZE_DATA_FAILED, null, 1);
            return;
        }
        ResultReceiver resultReceiver = null;
        if (activity.getIntent() != null) {
            bundle = activity.getIntent().getExtras();
        } else {
            bundle = null;
        }
        if (bundle == null) {
            com.tencent.gdtad.basics.motivevideo.report.a.k("GdtMotiveHippyFragment", "[initData] error, arguments is null", null, AdMetricID.Reward.HIPPY_FRAGMENT_INITIALIZE_DATA_FAILED, null, 1);
            activity.finish();
            return;
        }
        GdtMotiveVideoPageData rh5 = rh(bundle.getSerializable("data"));
        if (rh5 == null) {
            com.tencent.gdtad.basics.motivevideo.report.a.k("GdtMotiveHippyFragment", "[initData] error, firstVideoData is null", null, AdMetricID.Reward.HIPPY_FRAGMENT_INITIALIZE_DATA_FAILED, rh5, 1);
            return;
        }
        Parcelable parcelable = bundle.getParcelable("result_receiver");
        if (parcelable instanceof ResultReceiver) {
            resultReceiver = (ResultReceiver) parcelable;
        }
        StartGdtMotiveVideoParams build = StartGdtMotiveVideoParams.build(activity, rh5, resultReceiver);
        this.E = build;
        if (build == null) {
            com.tencent.gdtad.basics.motivevideo.report.a.k("GdtMotiveHippyFragment", "[initData] error, mStartGdtMotiveParams is null", null, AdMetricID.Reward.HIPPY_FRAGMENT_INITIALIZE_DATA_FAILED, rh5, 1);
            return;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.p("GdtMotiveHippyFragment", "[initData]", AdMetricID.Reward.HIPPY_FRAGMENT_INITIALIZE_DATA_SUCCESS, rh5);
        this.E.secondVideoData = rh(bundle.getSerializable("second_data"));
        this.E.thirdVideoData = rh(bundle.getSerializable("third_data"));
        StartGdtMotiveVideoParams startGdtMotiveVideoParams = this.E;
        startGdtMotiveVideoParams.bundle = bundle;
        try {
            startGdtMotiveVideoParams.processInTool = ((Boolean) bundle.getSerializable("key_process_in_tool")).booleanValue();
            this.E.requestCode = ((Integer) bundle.getSerializable("key_request_code")).intValue();
        } catch (Throwable th5) {
            QLog.e("GdtMotiveHippyFragment", 1, "[initData]", th5);
        }
    }

    private void uh(Activity activity) {
        boolean z16;
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        GdtMotiveVideoPageData gdtMotiveVideoPageData2;
        StartGdtMotiveVideoParams startGdtMotiveVideoParams;
        if (activity != null && (startGdtMotiveVideoParams = this.E) != null && startGdtMotiveVideoParams.data != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        StartGdtMotiveVideoParams startGdtMotiveVideoParams2 = this.E;
        if (startGdtMotiveVideoParams2 != null) {
            gdtMotiveVideoPageData = startGdtMotiveVideoParams2.data;
        } else {
            gdtMotiveVideoPageData = null;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.f("GdtMotiveHippyFragment", "[initWindow]", null, z16, AdMetricID.Reward.HIPPY_FRAGMENT_INITIALIZE_WINDOW_SUCCESS, AdMetricID.Reward.HIPPY_FRAGMENT_INITIALIZE_WINDOW_FAILED, gdtMotiveVideoPageData, 1);
        if (activity == null) {
            return;
        }
        pm0.d.a(activity.getWindow());
        StartGdtMotiveVideoParams startGdtMotiveVideoParams3 = this.E;
        if (startGdtMotiveVideoParams3 != null && (gdtMotiveVideoPageData2 = startGdtMotiveVideoParams3.data) != null) {
            activity.setRequestedOrientation(gdtMotiveVideoPageData2.screenOrientation);
        }
    }

    public static void vh(StartGdtMotiveVideoParams startGdtMotiveVideoParams, Intent intent) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        if (startGdtMotiveVideoParams != null && startGdtMotiveVideoParams.activity != null) {
            GdtMotiveVideoPageData gdtMotiveVideoPageData2 = startGdtMotiveVideoParams.data;
            if (gdtMotiveVideoPageData2.containerType == 0) {
                com.tencent.gdtad.basics.motivevideo.report.a.p("GdtMotiveHippyFragment", "[start]", AdMetricID.Reward.HIPPY_FRAGMENT_START_SUCCESS, gdtMotiveVideoPageData2);
                QPublicFragmentActivity.b.e(startGdtMotiveVideoParams.activity, intent, QPublicTransFragmentActivityForTool.class, GdtMotiveHippyFragment.class, startGdtMotiveVideoParams.requestCode);
                return;
            }
        }
        if (startGdtMotiveVideoParams != null) {
            gdtMotiveVideoPageData = startGdtMotiveVideoParams.data;
        } else {
            gdtMotiveVideoPageData = null;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.k("GdtMotiveHippyFragment", "[start] error", null, AdMetricID.Reward.HIPPY_FRAGMENT_START_FAILED, gdtMotiveVideoPageData, 1);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        StartGdtMotiveVideoParams startGdtMotiveVideoParams = this.E;
        if (startGdtMotiveVideoParams != null) {
            gdtMotiveVideoPageData = startGdtMotiveVideoParams.data;
        } else {
            gdtMotiveVideoPageData = null;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.p("GdtMotiveHippyFragment", "[beforeFinish]", AdMetricID.Reward.HIPPY_FRAGMENT_BEFORE_FINISH, gdtMotiveVideoPageData);
        d dVar = this.C;
        if (dVar != null) {
            dVar.w();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        if (activity == null) {
            QLog.e("GdtMotiveHippyFragment", 1, "[initWindowStyleAndAnimation] error, activity is null");
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        QLog.i("GdtMotiveHippyFragment", 1, "[initWindowStyleAndAnimation]");
        th(activity);
        uh(activity);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QLog.i("GdtMotiveHippyFragment", 1, "[onCreate]");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z16;
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        if (layoutInflater != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        StartGdtMotiveVideoParams startGdtMotiveVideoParams = this.E;
        FrameLayout frameLayout = null;
        if (startGdtMotiveVideoParams != null) {
            gdtMotiveVideoPageData = startGdtMotiveVideoParams.data;
        } else {
            gdtMotiveVideoPageData = null;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.f("GdtMotiveHippyFragment", "[onCreateView]", null, z16, AdMetricID.Reward.HIPPY_FRAGMENT_ON_CREATE_VIEW_SUCCESS, AdMetricID.Reward.HIPPY_FRAGMENT_ON_CREATE_VIEW_FAILED, gdtMotiveVideoPageData, 1);
        if (layoutInflater != null) {
            this.F = new FrameLayout(layoutInflater.getContext());
            sh();
            frameLayout = this.F;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        StartGdtMotiveVideoParams startGdtMotiveVideoParams = this.E;
        if (startGdtMotiveVideoParams != null) {
            gdtMotiveVideoPageData = startGdtMotiveVideoParams.data;
        } else {
            gdtMotiveVideoPageData = null;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.p("GdtMotiveHippyFragment", "[onDestroy]", AdMetricID.Reward.HIPPY_FRAGMENT_ON_DESTROY, gdtMotiveVideoPageData);
        d dVar = this.C;
        if (dVar != null) {
            dVar.A();
        }
        if (getArguments() != null) {
            getArguments().remove("result_receiver");
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.i("GdtMotiveHippyFragment", 1, "[onPause]");
        d dVar = this.C;
        if (dVar != null) {
            dVar.R();
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i("GdtMotiveHippyFragment", 1, "[onResume]");
        d dVar = this.C;
        if (dVar != null) {
            dVar.V();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        QLog.i("GdtMotiveHippyFragment", 1, "[onStop]");
        d dVar = this.C;
        if (dVar != null) {
            dVar.Y();
        }
        super.onStop();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        QLog.i("GdtMotiveHippyFragment", 1, "[onWindowFocusChanged] hasFocus:" + z16);
        if (z16 && getQBaseActivity() != null && getQBaseActivity().getWindow() != null && getQBaseActivity().getWindow().getDecorView() != null) {
            getQBaseActivity().getWindow().getDecorView().setSystemUiVisibility(7942);
        }
    }
}
