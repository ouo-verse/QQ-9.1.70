package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingDialog;
import com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingFragment;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.basics.motivevideo.hippy.GdtMotiveDialogFragment;
import com.tencent.gdtad.basics.motivevideo.hippy.GdtMotiveHippyFragment;
import com.tencent.gdtad.basics.motivevideo.motivepicture.GdtMotivePictureFragment;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.basics.motivevideo.report.GdtAnalysisHelperForMotiveAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.gdtad.util.GdtVipWithoutAdHelper;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtMotiveVideoFragment extends QPublicBaseFragment {
    private GdtMvVideoViewController C;
    private GdtMotiveVideoModel D;
    private FrameLayout E;
    private boolean F = false;
    private boolean G;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f108850d;

        a(View view) {
            this.f108850d = view;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i3) {
            if ((i3 & 4) == 0) {
                this.f108850d.setSystemUiVisibility(7942);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements n {
        b() {
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void finish() {
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public Activity getActivity() {
            return GdtMotiveVideoFragment.this.getQBaseActivity();
        }

        @Override // com.tencent.gdtad.basics.motivevideo.n
        public void setResult(int i3, Intent intent) {
            ResultReceiver resultReceiver;
            boolean z16;
            if (GdtMotiveVideoFragment.this.getArguments() != null) {
                resultReceiver = (ResultReceiver) GdtMotiveVideoFragment.this.getArguments().getParcelable("result_receiver");
            } else {
                resultReceiver = null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[setResult] resultReceiver != null? :");
            if (resultReceiver != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            GdtLog.i("GdtMotiveVideoFragment", sb5.toString());
            if (resultReceiver != null) {
                resultReceiver.send(i3, intent.getExtras());
            }
            Activity activity = getActivity();
            if (activity != null) {
                activity.setResult(i3, intent);
            }
        }
    }

    public GdtMotiveVideoFragment() {
        GdtLog.d("GdtMotiveVideoFragment", "GdtMotiveVideoFragment: ");
    }

    private static GdtMotiveVideoPageData qh(@Nullable Serializable serializable) {
        if (!(serializable instanceof GdtMotiveVideoPageData)) {
            return null;
        }
        return (GdtMotiveVideoPageData) serializable;
    }

    private void sh(Activity activity) {
        Bundle arguments = getArguments();
        if (arguments == null) {
            activity.finish();
            return;
        }
        GdtMotiveVideoPageData qh5 = qh(arguments.getSerializable("data"));
        if (qh5 == null) {
            activity.finish();
        } else {
            this.D = new GdtMotiveVideoModel(qh5);
        }
    }

    private void th() {
        if (this.C == null || this.G) {
            this.G = false;
            this.C = new GdtMvVideoViewController(new b(), this.D, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void uh(Activity activity, Intent intent, ResultReceiver resultReceiver, GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        try {
            com.tencent.gdtad.basics.motivevideo.motivepicture.a aVar = new com.tencent.gdtad.basics.motivevideo.motivepicture.a(activity);
            aVar.setIntent(intent);
            aVar.a0(resultReceiver);
            aVar.show();
        } catch (Exception e16) {
            QLog.i("GdtMotiveVideoFragment", 1, "GdtMotiveImageDialog.show()", e16);
            vh(resultReceiver, gdtMotiveVideoPageData.supportOpenMotiveAd);
        }
    }

    public static void vh(ResultReceiver resultReceiver, boolean z16) {
        if (resultReceiver == null) {
            QLog.i("GdtMotiveVideoFragment", 1, "onGdtMotiveVideoFailed resultReceiver == null");
            return;
        }
        Intent intent = new Intent();
        if (z16) {
            intent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_DURATION_TIME, 0);
            intent.putExtra("elapsed_time", 0);
            intent.putExtra("profitable_flag", false);
            intent.putExtra("is_end", false);
        } else {
            intent.putExtra("isRewarded", false);
        }
        resultReceiver.send(-1, intent.getExtras());
    }

    public static void wh(StartGdtMotiveVideoParams startGdtMotiveVideoParams) {
        final Activity activity;
        final GdtMotiveVideoPageData gdtMotiveVideoPageData;
        Bundle bundle;
        if (startGdtMotiveVideoParams != null && (activity = startGdtMotiveVideoParams.activity) != null && (gdtMotiveVideoPageData = startGdtMotiveVideoParams.data) != null && (bundle = startGdtMotiveVideoParams.bundle) != null) {
            GdtMotiveVideoPageData gdtMotiveVideoPageData2 = startGdtMotiveVideoParams.secondVideoData;
            GdtMotiveVideoPageData gdtMotiveVideoPageData3 = startGdtMotiveVideoParams.thirdVideoData;
            boolean z16 = startGdtMotiveVideoParams.processInTool;
            final ResultReceiver resultReceiver = startGdtMotiveVideoParams.resultReceiver;
            int i3 = startGdtMotiveVideoParams.requestCode;
            GdtAnalysisHelperForMotiveAd.t(activity, gdtMotiveVideoPageData);
            if (GdtVipWithoutAdHelper.getVipWithoutAdMemberState() && gdtMotiveVideoPageData.isMiniGame) {
                GdtVipWithoutAdHelper.vipWithoutAdGetReward(resultReceiver);
                GdtVipWithoutAdHelper.showVipWithoutAdToast();
                QLog.d("GdtMotiveVideoFragment", 1, "gdtmv vipWithoutAdGetReward success");
                return;
            }
            bundle.putSerializable("data", gdtMotiveVideoPageData);
            bundle.putSerializable("second_data", gdtMotiveVideoPageData2);
            bundle.putSerializable("third_data", gdtMotiveVideoPageData3);
            bundle.putSerializable("key_process_in_tool", Boolean.valueOf(z16));
            bundle.putSerializable("key_request_code", Integer.valueOf(i3));
            bundle.putLong("key_motive_show_start_time", System.currentTimeMillis());
            bundle.putString(LaunchParam.KEY_REF_ID, gdtMotiveVideoPageData.refId);
            bundle.putParcelable("result_receiver", startGdtMotiveVideoParams.resultReceiver);
            final Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
            intent.putExtras(bundle);
            if (TextUtils.isEmpty(intent.getStringExtra(LaunchParam.KEY_REF_ID))) {
                GdtLog.e("GdtMotiveVideoFragment", "start gdt empty refId");
            }
            switch (gdtMotiveVideoPageData.getType()) {
                case 1:
                    QLog.i("GdtMotiveVideoFragment", 1, "start motive browsing type = " + gdtMotiveVideoPageData.containerType);
                    if (gdtMotiveVideoPageData.containerType == 1) {
                        GdtMotiveBrowsingDialog.INSTANCE.b(activity, gdtMotiveVideoPageData, intent, resultReceiver);
                    } else {
                        GdtMotiveBrowsingFragment.INSTANCE.a(activity, gdtMotiveVideoPageData, intent, resultReceiver);
                    }
                    GdtADFlyingStreamingReportHelper.getInstance().setShowCardStatus(3);
                    return;
                case 2:
                case 3:
                    if (gdtMotiveVideoPageData.containerType == 1) {
                        activity.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoFragment.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    e eVar = new e(activity);
                                    eVar.setIntent(intent);
                                    eVar.a0(resultReceiver);
                                    eVar.show();
                                } catch (Exception e16) {
                                    QLog.i("GdtMotiveVideoFragment", 1, "GdtMotiveVideoDialog.show()", e16);
                                    GdtMotiveVideoFragment.vh(resultReceiver, gdtMotiveVideoPageData.supportOpenMotiveAd);
                                }
                            }
                        });
                        return;
                    } else {
                        xh(activity, intent, z16, gdtMotiveVideoPageData, i3, GdtMotiveVideoFragment.class);
                        return;
                    }
                case 4:
                case 5:
                    zh(startGdtMotiveVideoParams, intent);
                    return;
                case 6:
                    yh(startGdtMotiveVideoParams, intent);
                    return;
                default:
                    QLog.i("GdtMotiveVideoFragment", 4, "[start] type is unknown");
                    vh(resultReceiver, gdtMotiveVideoPageData.supportOpenMotiveAd);
                    return;
            }
        }
        GdtLog.i("GdtMotiveVideoFragment", "[start] error params");
    }

    private static void xh(Activity activity, Intent intent, boolean z16, GdtMotiveVideoPageData gdtMotiveVideoPageData, int i3, Class<? extends QPublicBaseFragment> cls) {
        Class cls2;
        Class cls3;
        if (z16) {
            if (gdtMotiveVideoPageData.screenOrientation == 0) {
                cls3 = QPublicFragmentActivityLandscapeForTool.class;
            } else {
                cls3 = QPublicFragmentActivityForTool.class;
            }
            QPublicFragmentActivity.b.e(activity, intent, cls3, cls, i3);
            return;
        }
        if (gdtMotiveVideoPageData.screenOrientation == 0) {
            cls2 = QPublicFragmentActivityLandscape.class;
        } else {
            cls2 = QPublicFragmentActivity.class;
        }
        QPublicFragmentActivity.b.e(activity, intent, cls2, cls, i3);
    }

    private static void yh(StartGdtMotiveVideoParams startGdtMotiveVideoParams, Intent intent) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        GdtMotiveVideoPageData gdtMotiveVideoPageData2;
        String str;
        long j3;
        int i3;
        String str2 = null;
        if (startGdtMotiveVideoParams != null && startGdtMotiveVideoParams.activity != null && (gdtMotiveVideoPageData2 = startGdtMotiveVideoParams.data) != null) {
            GdtAd parseGdtAdFromString = GdtUtil.parseGdtAdFromString(gdtMotiveVideoPageData2);
            if (parseGdtAdFromString != null) {
                str = parseGdtAdFromString.getPosId();
            } else {
                str = null;
            }
            if (parseGdtAdFromString != null) {
                j3 = parseGdtAdFromString.getAId();
            } else {
                j3 = -2147483648L;
            }
            if (parseGdtAdFromString != null) {
                str2 = parseGdtAdFromString.getTraceId();
            }
            if (intent != null && !TextUtils.isEmpty(str)) {
                intent.putExtra("gdt_download_pos_id", str);
            }
            if (intent != null && j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                intent.putExtra("gdt_download_aid", String.valueOf(j3));
            }
            if (intent != null && !TextUtils.isEmpty(str2)) {
                intent.putExtra("gdt_download_trace_id", str2);
            }
            QLog.i("GdtMotiveVideoFragment", 1, "[startHippyMotivePage] posId:" + str + " aid:" + j3 + " traceId:" + str2);
            boolean z16 = startGdtMotiveVideoParams.activity instanceof FragmentActivity;
            GdtMotiveVideoPageData gdtMotiveVideoPageData3 = startGdtMotiveVideoParams.data;
            int i16 = gdtMotiveVideoPageData3.containerType;
            if (i16 == 1) {
                if (z16) {
                    GdtMotiveDialogFragment.xh(startGdtMotiveVideoParams, intent);
                } else {
                    com.tencent.gdtad.basics.motivevideo.hippy.e.c0(startGdtMotiveVideoParams, intent);
                }
                if (z16) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                int i17 = i3;
                com.tencent.gdtad.basics.motivevideo.report.a.q("GdtMotiveVideoFragment", "[startHippyMotivePage] containerDetailType:" + i17, AdMetricID.Reward.HIPPY_START_SUCCESS, startGdtMotiveVideoParams.data, i17);
                GdtAnalysisHelperForMotiveAd.w(startGdtMotiveVideoParams.activity, startGdtMotiveVideoParams.data, true, z16);
                return;
            }
            if (i16 == 0) {
                com.tencent.gdtad.basics.motivevideo.report.a.q("GdtMotiveVideoFragment", "[startHippyMotivePage] containerDetailType:1", AdMetricID.Reward.HIPPY_START_SUCCESS, gdtMotiveVideoPageData3, 1);
                GdtMotiveHippyFragment.vh(startGdtMotiveVideoParams, intent);
                return;
            } else {
                com.tencent.gdtad.basics.motivevideo.report.a.k("GdtMotiveVideoFragment", "[startHippyMotivePage] error, containerType:" + startGdtMotiveVideoParams.data.containerType, null, AdMetricID.Reward.HIPPY_START_FAILED, startGdtMotiveVideoParams.data, 4);
                return;
            }
        }
        if (startGdtMotiveVideoParams != null) {
            gdtMotiveVideoPageData = startGdtMotiveVideoParams.data;
        } else {
            gdtMotiveVideoPageData = null;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.k("GdtMotiveVideoFragment", "[startHippyMotivePage] error, invalid params", null, AdMetricID.Reward.HIPPY_START_FAILED, gdtMotiveVideoPageData, 4);
    }

    public static void zh(StartGdtMotiveVideoParams startGdtMotiveVideoParams, final Intent intent) {
        final GdtMotiveVideoPageData gdtMotiveVideoPageData;
        final Activity activity;
        if (startGdtMotiveVideoParams != null && (gdtMotiveVideoPageData = startGdtMotiveVideoParams.data) != null && (activity = startGdtMotiveVideoParams.activity) != null) {
            boolean z16 = startGdtMotiveVideoParams.processInTool;
            final ResultReceiver resultReceiver = startGdtMotiveVideoParams.resultReceiver;
            if (gdtMotiveVideoPageData.containerType == 1) {
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        GdtMotiveVideoFragment.uh(activity, intent, resultReceiver, gdtMotiveVideoPageData);
                    }
                });
                return;
            } else {
                xh(activity, intent, z16, gdtMotiveVideoPageData, startGdtMotiveVideoParams.requestCode, GdtMotivePictureFragment.class);
                return;
            }
        }
        GdtLog.e("GdtMotiveVideoFragment", "[startMotivePicturePage] error params");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        if (this.C != null && !this.F) {
            this.F = true;
            String str = "";
            if (getArguments() != null) {
                str = getArguments().getString("arg_callback", "");
            }
            this.C.E(str);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        sh(activity);
        super.initWindowStyleAndAnimation(activity);
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.setFlags(1024, 1024);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(7942);
        decorView.setOnSystemUiVisibilityChangeListener(new a(decorView));
        activity.setRequestedOrientation(this.D.getGdtMotiveVideoPageData().screenOrientation);
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
        GdtMvVideoViewController gdtMvVideoViewController = this.C;
        if (gdtMvVideoViewController != null) {
            return gdtMvVideoViewController.c0();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GdtMvVideoViewController gdtMvVideoViewController = this.C;
        if (gdtMvVideoViewController != null) {
            gdtMvVideoViewController.x0();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GdtLog.i("GdtMotiveVideoFragment", "onCreate: ");
        if (this.D == null) {
            return;
        }
        th();
        this.C.d0();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(layoutInflater.getContext());
        this.E = frameLayout2;
        View rh5 = rh(layoutInflater, frameLayout2, 1);
        if (rh5 != null) {
            this.E.addView(rh5);
            frameLayout = this.E;
        } else {
            frameLayout = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        GdtMvVideoViewController gdtMvVideoViewController = this.C;
        if (gdtMvVideoViewController != null) {
            gdtMvVideoViewController.e0();
        }
        if (getArguments() != null) {
            getArguments().remove("result_receiver");
        }
        GdtADFlyingStreamingReportHelper.getInstance().onDestroy();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        GdtMvVideoViewController gdtMvVideoViewController = this.C;
        if (gdtMvVideoViewController != null) {
            gdtMvVideoViewController.g0(false);
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GdtLog.i("GdtMotiveVideoFragment", "onResume: ");
        GdtMvVideoViewController gdtMvVideoViewController = this.C;
        if (gdtMvVideoViewController != null) {
            gdtMvVideoViewController.i0();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        GdtMvVideoViewController gdtMvVideoViewController = this.C;
        if (gdtMvVideoViewController != null) {
            gdtMvVideoViewController.F0();
        }
        super.onStop();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16) {
            getQBaseActivity().getWindow().getDecorView().setSystemUiVisibility(7942);
        }
    }

    @Nullable
    public View rh(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, int i3) {
        if (this.D == null) {
            QLog.e("GdtMotiveVideoFragment", 1, "[init] ad data error");
            return null;
        }
        th();
        this.C.A0(i3);
        this.C.d0();
        if (this.D.getGdtMotiveVideoPageData() != null) {
            GdtUIUtils.enableTopLiuHaiIfNeeded(getQBaseActivity(), this.D.getGdtMotiveVideoPageData().screenOrientation);
        }
        return this.C.P(layoutInflater, viewGroup);
    }
}
