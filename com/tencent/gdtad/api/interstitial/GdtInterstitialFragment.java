package com.tencent.gdtad.api.interstitial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityReverseLandscapeForTool;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtInterstitialFragment extends QPublicBaseFragment {

    @NonNull
    private static Set<String> G = new HashSet();

    @Nullable
    private GdtInterstitialParams C;

    @NonNull
    private GdtInterstitialStatus D = new GdtInterstitialStatus();

    @Nullable
    private GdtInterstitialView E;

    @Nullable
    private QQProgressDialog F;

    public static int Ah(@Nullable Activity activity, @Nullable GdtInterstitialParams gdtInterstitialParams) {
        int i3;
        Class cls;
        if (Looper.myLooper() == Looper.getMainLooper() && activity != null && gdtInterstitialParams != null && gdtInterstitialParams.canShow()) {
            int screenOrientation = getScreenOrientation(activity);
            gdtInterstitialParams.orientation = screenOrientation;
            if (screenOrientation == 1) {
                cls = QPublicTransFragmentActivityForTool.class;
            } else if (screenOrientation == 0) {
                cls = QPublicTransFragmentActivityLandscapeForTool.class;
            } else if (screenOrientation == 8) {
                cls = QPublicTransFragmentActivityReverseLandscapeForTool.class;
            } else {
                cls = null;
            }
            if (cls != null) {
                if (G.contains(gdtInterstitialParams.getTraceId())) {
                    i3 = 2;
                } else {
                    G.add(gdtInterstitialParams.getTraceId());
                    Bundle bundle = new Bundle();
                    Bundle bundle2 = gdtInterstitialParams.clickOptions.extra;
                    if (bundle2 != null && !bundle2.isEmpty()) {
                        bundle.putAll(gdtInterstitialParams.clickOptions.extra);
                    }
                    bundle.putParcelable("interstitialParams", gdtInterstitialParams);
                    bundle.putLong("interstitialStartToShowTimeMillis", System.currentTimeMillis());
                    Intent intent = new Intent();
                    intent.putExtra("public_fragment_window_feature", 1);
                    intent.putExtras(bundle);
                    QPublicFragmentActivity.b.e(activity, intent, cls, GdtInterstitialFragment.class, 10001);
                    i3 = 0;
                }
                GdtLog.i("GdtInterstitialFragment", String.format("start errorCode:%d", Integer.valueOf(i3)));
                return i3;
            }
        }
        i3 = 4;
        GdtLog.i("GdtInterstitialFragment", String.format("start errorCode:%d", Integer.valueOf(i3)));
        return i3;
    }

    private static int getScreenOrientation(Activity activity) {
        int i3;
        if (activity.getWindowManager().getDefaultDisplay().getRotation() == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return i3 ^ 1;
    }

    private String getTraceId() {
        GdtInterstitialParams gdtInterstitialParams = this.C;
        if (gdtInterstitialParams != null && gdtInterstitialParams.canShow()) {
            return this.C.getTraceId();
        }
        return null;
    }

    private void rh() {
        GdtInterstitialParams gdtInterstitialParams = this.C;
        if (gdtInterstitialParams != null && gdtInterstitialParams.canShow()) {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(getContext(), this.C.clickOptions.f108486ad);
        }
    }

    private void zh(boolean z16) {
        int i3;
        GdtLog.i("GdtInterstitialFragment", String.format("setLoading visible:%b", Boolean.valueOf(z16)));
        if (z16) {
            QQProgressDialog qQProgressDialog = this.F;
            if (qQProgressDialog == null || !qQProgressDialog.isShowing()) {
                FragmentActivity activity = getActivity();
                if (getQBaseActivity() != null) {
                    i3 = getQBaseActivity().getTitleBarHeight();
                } else {
                    i3 = 0;
                }
                QQProgressDialog qQProgressDialog2 = new QQProgressDialog(activity, i3);
                this.F = qQProgressDialog2;
                qQProgressDialog2.setCancelable(false);
                this.F.setMessage("\u6b63\u5728\u52a0\u8f7d");
                this.F.show();
                return;
            }
            return;
        }
        QQProgressDialog qQProgressDialog3 = this.F;
        if (qQProgressDialog3 != null) {
            if (qQProgressDialog3.isShowing()) {
                try {
                    this.F.dismiss();
                } catch (Throwable th5) {
                    GdtLog.e("GdtInterstitialFragment", "setLoading", th5);
                }
            }
            this.F = null;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        GdtLog.i("GdtInterstitialFragment", "beforeFinish");
        GdtInterstitialView gdtInterstitialView = this.E;
        if (gdtInterstitialView != null) {
            gdtInterstitialView.destroy(getActivity());
        }
        e.d().g(getTraceId());
        Bundle bundle = new Bundle();
        bundle.putParcelable("interstitialStatus", this.D);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        try {
            getActivity().setResult(-1, intent);
        } catch (Throwable th5) {
            GdtLog.e("GdtInterstitialFragment", "beforeFinish", th5);
        }
        super.beforeFinish();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
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
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z16;
        FrameLayout frameLayout;
        GdtInterstitialStatus gdtInterstitialStatus = this.D;
        int i3 = 1;
        if (f.c().d() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        gdtInterstitialStatus.arkAppDownloaded = z16;
        final int i16 = 4;
        FrameLayout frameLayout2 = null;
        try {
            frameLayout = new FrameLayout(getActivity());
            try {
                zh(true);
                AdThreadManager.getInstance().postDelayed(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GdtInterstitialFragment.this.C == null || !GdtInterstitialFragment.this.C.canShow() || !GdtInterstitialFragment.this.D.arkScriptLoaded) {
                            GdtInterstitialFragment.this.sh(4, 13, Integer.MIN_VALUE, Integer.MIN_VALUE);
                        }
                    }
                }, 0, 10000L);
                b.b();
                ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification(e.d().a().f108629a, e.d().b());
                if (getArguments() != null && getArguments().containsKey("interstitialParams")) {
                    GdtInterstitialParams gdtInterstitialParams = (GdtInterstitialParams) getArguments().getParcelable("interstitialParams");
                    this.C = gdtInterstitialParams;
                    if (gdtInterstitialParams != null && gdtInterstitialParams.canShow() && !TextUtils.isEmpty(getTraceId()) && getArguments().containsKey("interstitialStartToShowTimeMillis")) {
                        this.D.startToShowTimeMillis = getArguments().getLong("interstitialStartToShowTimeMillis");
                        try {
                            if (e.d().f(getTraceId(), new WeakReference<>(this)) && getActivity() != null) {
                                getActivity().setRequestedOrientation(this.C.orientation);
                                this.C.width = GdtUIUtils.getScreenWidth(getActivity());
                                this.C.height = GdtUIUtils.getScreenHeight(getActivity());
                                GdtInterstitialParams gdtInterstitialParams2 = this.C;
                                if (gdtInterstitialParams2.width > 0 && gdtInterstitialParams2.height > 0) {
                                    GdtInterstitialView gdtInterstitialView = new GdtInterstitialView(getActivity(), this.C, this.D);
                                    this.E = gdtInterstitialView;
                                    if (gdtInterstitialView.getView() != null) {
                                        GdtInterstitialParams gdtInterstitialParams3 = this.C;
                                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(gdtInterstitialParams3.width, gdtInterstitialParams3.height);
                                        layoutParams.gravity = 17;
                                        frameLayout.addView(this.E.getView(), layoutParams);
                                        if (!this.C.windowTranslucentStatus) {
                                            getActivity().getWindow().addFlags(1024);
                                        }
                                        i16 = 0;
                                    }
                                }
                            }
                            i16 = 1;
                        } catch (Throwable th5) {
                            th = th5;
                            frameLayout2 = frameLayout;
                            GdtLog.e("GdtInterstitialFragment", "onCreateView", th);
                            frameLayout = frameLayout2;
                            i16 = i3;
                            rh();
                            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialFragment.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    GdtInterstitialFragment.this.D.jsCoreDownloaded = ((IArkEnvironment) QRoute.api(IArkEnvironment.class)).isJSCLibExist();
                                    GdtAnalysisHelperForInterstitial.reportFortShowInterstitialCreated(GdtInterstitialFragment.this.getActivity(), GdtInterstitialFragment.this.C, GdtInterstitialFragment.this.D, i16);
                                }
                            }, 5);
                            AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
                            return frameLayout;
                        }
                    }
                }
                GdtLog.i("GdtInterstitialFragment", String.format("onCreateView traceId:%s", getTraceId()));
            } catch (Throwable th6) {
                th = th6;
                i3 = i16;
            }
        } catch (Throwable th7) {
            th = th7;
            i3 = 4;
        }
        rh();
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialFragment.2
            @Override // java.lang.Runnable
            public void run() {
                GdtInterstitialFragment.this.D.jsCoreDownloaded = ((IArkEnvironment) QRoute.api(IArkEnvironment.class)).isJSCLibExist();
                GdtAnalysisHelperForInterstitial.reportFortShowInterstitialCreated(GdtInterstitialFragment.this.getActivity(), GdtInterstitialFragment.this.C, GdtInterstitialFragment.this.D, i16);
            }
        }, 5);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        GdtLog.i("GdtInterstitialFragment", "onFinish");
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        GdtLog.i("GdtInterstitialFragment", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.D.activityStatus = 3;
        GdtInterstitialView gdtInterstitialView = this.E;
        if (gdtInterstitialView != null) {
            gdtInterstitialView.pause(getActivity());
        }
        if (this.D.arkScriptLoaded) {
            GdtInterstitialNotifyReg.r(getActivity(), this.C, this.D);
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GdtLog.i("GdtInterstitialFragment", "onResume");
        this.D.activityStatus = 2;
        GdtInterstitialView gdtInterstitialView = this.E;
        if (gdtInterstitialView != null) {
            gdtInterstitialView.resume(getActivity());
        }
        if (this.D.arkScriptLoaded) {
            zh(false);
            GdtInterstitialNotifyReg.t(getActivity(), this.C, this.D);
        }
    }

    public boolean sh(int i3, int i16, int i17, int i18) {
        boolean z16;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zh(false);
            GdtInterstitialStatus gdtInterstitialStatus = this.D;
            gdtInterstitialStatus.closeReason = i3;
            gdtInterstitialStatus.closeError = i16;
            gdtInterstitialStatus.closeErrorForArk = i17;
            gdtInterstitialStatus.closeErrorForArkScript = i18;
            if (getActivity() != null) {
                getActivity().finish();
                GdtAnalysisHelperForInterstitial.reportFortCloseInterstitialStart(getActivity(), this.C, this.D);
                z16 = true;
                GdtLog.i("GdtInterstitialFragment", String.format("finish %b error:%d arkError:%d arkScriptError:%d", Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)));
                return z16;
            }
        }
        z16 = false;
        GdtLog.i("GdtInterstitialFragment", String.format("finish %b error:%d arkError:%d arkScriptError:%d", Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)));
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public GdtInterstitialParams th() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public GdtInterstitialStatus uh() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean vh() {
        boolean z16;
        GdtInterstitialParams gdtInterstitialParams;
        if (Looper.myLooper() == Looper.getMainLooper() && (gdtInterstitialParams = this.C) != null && gdtInterstitialParams.canShow()) {
            GdtHandler.Params params = new GdtHandler.Params();
            params.activity = new WeakReference<>(getActivity());
            GdtHandler.Options options = this.C.clickOptions;
            params.f108486ad = options.f108486ad;
            params.reportForClick = options.reportForClick;
            params.sceneID = options.sceneID;
            params.componentID = options.componentID;
            params.appAutoDownload = options.appAutoDownload;
            params.videoCeilingSupportedIfNotInstalled = options.videoCeilingSupportedIfNotInstalled;
            params.videoCeilingSupportedIfInstalled = options.videoCeilingSupportedIfInstalled;
            params.videoStartPositionMillis = options.videoStartPositionMillis;
            params.directPlay = options.directPlay;
            params.antiSpamParams = options.antiSpamParams;
            params.antiSpamParamsForClick = options.antiSpamParamsForClick;
            params.extra = options.extra;
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
            z16 = true;
        } else {
            z16 = false;
        }
        GdtLog.i("GdtInterstitialFragment", String.format("onClick %b", Boolean.valueOf(z16)));
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wh() {
        GdtInterstitialStatus gdtInterstitialStatus = this.D;
        if (!gdtInterstitialStatus.exposed) {
            gdtInterstitialStatus.exposed = true;
            GdtLog.i("GdtInterstitialFragment", String.format("onImpression timeMillis:%d", Long.valueOf(gdtInterstitialStatus.getDurationBetweenStartAndNow())));
            GdtAnalysisHelperForInterstitial.reportFortShowInterstitialImpression(getActivity(), this.C, this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xh() {
        GdtInterstitialStatus gdtInterstitialStatus = this.D;
        if (gdtInterstitialStatus.arkScriptLoaded) {
            GdtLog.e("GdtInterstitialFragment", "onLoaded error");
            return;
        }
        gdtInterstitialStatus.arkScriptLoaded = true;
        if (gdtInterstitialStatus.activityStatus == 2) {
            GdtInterstitialNotifyReg.t(getActivity(), this.C, this.D);
        }
        zh(false);
        GdtLog.i("GdtInterstitialFragment", String.format("onLoaded timeMillis:%d", Long.valueOf(this.D.getDurationBetweenStartAndNow())));
        GdtAnalysisHelperForInterstitial.reportFortShowInterstitialLoadArkScript(getActivity(), this.C, this.D);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yh(int i3) {
        this.D.videoStatus = i3;
    }
}
