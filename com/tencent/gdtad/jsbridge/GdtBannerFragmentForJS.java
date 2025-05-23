package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.richframework.compat.f;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.gdtad.api.banner.GdtBannerParams;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.api.banner.GdtBannerViewBuilder;
import com.tencent.gdtad.api.banner.IGdtBannerAd;
import com.tencent.gdtad.api.banner.IGdtBannerAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtBannerFragmentForJS extends GdtBaseBannerFragment {
    private static final String TAG = "GdtBannerFragmentForJS";

    @NonNull
    private GdtAdListener adListener = new a();
    private IGdtBannerAd bannerAd;
    private GdtBannerView bannerAdView;
    private GdtBannerParams bannerParams;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements GdtAdListener {
        a() {
        }

        private long a(@Nullable GdtAd gdtAd) {
            if (gdtAd != null && gdtAd.getAd() != null) {
                return gdtAd.getAd().getAId();
            }
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdClicked(GdtAd gdtAd) {
            GdtLog.i(GdtBannerFragmentForJS.TAG, String.format("onAdClicked %d", Long.valueOf(a(gdtAd))));
            AdToast.getInstance().show(GdtBannerFragmentForJS.this.getActivity().getApplicationContext(), 0, String.format("onAdClicked %d", Long.valueOf(a(gdtAd))), 0);
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdClosed(GdtAd gdtAd) {
            GdtLog.i(GdtBannerFragmentForJS.TAG, String.format("onAdClosed %d", Long.valueOf(a(gdtAd))));
            AdToast.getInstance().show(GdtBannerFragmentForJS.this.getActivity().getApplicationContext(), 0, String.format("onAdClosed %d", Long.valueOf(a(gdtAd))), 0);
            GdtBannerFragmentForJS gdtBannerFragmentForJS = GdtBannerFragmentForJS.this;
            gdtBannerFragmentForJS.containerView.removeView(gdtBannerFragmentForJS.bannerAdView.getView());
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdFailedToLoad(GdtAd gdtAd, @NonNull GdtAdError gdtAdError) {
            GdtLog.e(GdtBannerFragmentForJS.TAG, "onAdFailedToLoad " + gdtAdError.getErrorMessage());
            AdToast.getInstance().show(GdtBannerFragmentForJS.this.getActivity().getApplicationContext(), 1, "onAdFailedToLoad " + gdtAdError.getErrorMessage(), 0);
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdImpression(GdtAd gdtAd) {
            GdtLog.i(GdtBannerFragmentForJS.TAG, String.format("onAdImpression %d", Long.valueOf(a(gdtAd))));
            AdToast.getInstance().show(GdtBannerFragmentForJS.this.getActivity().getApplicationContext(), 0, String.format("onAdImpression %d", Long.valueOf(a(gdtAd))), 0);
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdLoaded(GdtAd gdtAd) {
            GdtLog.i(GdtBannerFragmentForJS.TAG, String.format("onAdLoaded %d", Long.valueOf(a(gdtAd))));
            AdToast.getInstance().show(GdtBannerFragmentForJS.this.getActivity().getApplicationContext(), 0, String.format("onAdLoaded %d", Long.valueOf(a(gdtAd))), 0);
        }
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment
    @Nullable
    protected GdtAd getAd() {
        Object obj = this.bannerAd;
        if (obj instanceof GdtAd) {
            return (GdtAd) obj;
        }
        return null;
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity == null) {
            return;
        }
        activity.getWindow().addFlags(1024);
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return super.isWrapContent();
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return super.needImmersive();
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return super.needStatusTrans();
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        GdtBannerView gdtBannerView = this.bannerAdView;
        if (gdtBannerView != null) {
            gdtBannerView.destroy(getActivity());
        }
        super.onDestroy();
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment
    protected void onInit(String str, qq_ad_get.QQAdGet qQAdGet, GdtHandler.Params params) {
        GdtBannerParams gdtBannerParams = new GdtBannerParams();
        this.bannerParams = gdtBannerParams;
        gdtBannerParams.requestParams = qQAdGet;
        gdtBannerParams.clickParams = params;
        gdtBannerParams.orientation = 1;
        gdtBannerParams.width = GdtUIUtils.getValueDependsOnScreenWidthIfPortrait(getActivity(), 1080, 1026);
        GdtBannerParams gdtBannerParams2 = this.bannerParams;
        gdtBannerParams2.height = GdtBannerViewBuilder.getHeight(gdtBannerParams2.width);
        IGdtBannerAd buildBannerAd = ((IGdtBannerAdAPI) QRoute.api(IGdtBannerAdAPI.class)).buildBannerAd(this.bannerParams);
        this.bannerAd = buildBannerAd;
        buildBannerAd.setListener(new WeakReference<>(this.adListener));
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        GdtBannerView gdtBannerView = this.bannerAdView;
        if (gdtBannerView != null) {
            gdtBannerView.pause(getActivity());
        }
        super.onPause();
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GdtBannerView gdtBannerView = this.bannerAdView;
        if (gdtBannerView != null) {
            gdtBannerView.resume(getActivity());
        }
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment
    protected void onShow() {
        int valueDependsOnScreenWidthIfPortrait = GdtUIUtils.getValueDependsOnScreenWidthIfPortrait(getActivity(), 1080, 1026);
        int height = GdtBannerViewBuilder.getHeight(valueDependsOnScreenWidthIfPortrait);
        GdtBannerView render = this.bannerAd.render(getActivity(), valueDependsOnScreenWidthIfPortrait, height);
        this.bannerAdView = render;
        if (render == null) {
            AdToast.getInstance().show(getActivity().getApplicationContext(), 0, "ad is rendered", 0);
            return;
        }
        if (render.getView() == null) {
            AdToast.getInstance().show(getActivity().getApplicationContext(), 1, "error", 0);
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(valueDependsOnScreenWidthIfPortrait, height);
        layoutParams.gravity = 1;
        layoutParams.topMargin = 100;
        layoutParams.bottomMargin = 100;
        this.containerView.addView(this.bannerAdView.getView(), layoutParams);
        this.bannerAd.onDisplay();
        AdThreadManager.getInstance().postDelayed(new Runnable() { // from class: com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int dp2px = GdtUIUtils.dp2px(300.0f, GdtBannerFragmentForJS.this.getResources());
                    int height2 = GdtBannerViewBuilder.getHeight(dp2px);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dp2px, height2);
                    layoutParams2.gravity = 1;
                    layoutParams2.topMargin = 100;
                    layoutParams2.bottomMargin = 100;
                    GdtBannerFragmentForJS.this.bannerAdView.getView().setLayoutParams(layoutParams2);
                    GdtBannerFragmentForJS.this.bannerAdView.setSize(dp2px, height2);
                    GdtBannerFragmentForJS.this.containerView.invalidate();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }, 0, 5000L);
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
