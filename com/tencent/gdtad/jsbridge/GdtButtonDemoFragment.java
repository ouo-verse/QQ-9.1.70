package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.views.button.AdAppDownloadButtonController;
import com.tencent.ad.tangram.views.button.IAdAppDownloadButtonView;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.gdtad.api.GdtAdParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtButtonDemoFragment extends GdtBaseBannerFragment {
    private GdtButtonDemoAd C;
    private AdAppDownloadButtonController D;
    private IAdAppDownloadButtonView E;
    private Button F;
    private GdtAdListener G = new c();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static final class GdtButtonDemoAd extends GdtAd {
        d mParams;

        public GdtButtonDemoAd(@Nullable d dVar) {
            super(dVar);
            this.mParams = dVar;
        }

        @Override // com.tencent.gdtad.api.GdtAd
        protected GdtAdParams getParams() {
            return this.mParams;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtButtonDemoFragment.this.D.onClick(Integer.MIN_VALUE);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtButtonDemoFragment.this.D.onCancelClick(Integer.MIN_VALUE);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class c implements GdtAdListener {
        c() {
        }

        private long a(@Nullable GdtAd gdtAd) {
            if (gdtAd != null && gdtAd.getAd() != null) {
                return gdtAd.getAd().getAId();
            }
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdClicked(GdtAd gdtAd) {
            GdtLog.i("GdtButtonDemoFragment", String.format("[onAdClicked] %d", Long.valueOf(a(gdtAd))));
            AdToast.getInstance().show(GdtButtonDemoFragment.this.getActivity().getApplicationContext(), 0, String.format("[onAdClicked] %d", Long.valueOf(a(gdtAd))), 0);
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdClosed(GdtAd gdtAd) {
            GdtLog.i("GdtButtonDemoFragment", String.format("[onAdClosed] %d", Long.valueOf(a(gdtAd))));
            AdToast.getInstance().show(GdtButtonDemoFragment.this.getActivity().getApplicationContext(), 0, String.format("[onAdClosed] %d", Long.valueOf(a(gdtAd))), 0);
            GdtButtonDemoFragment gdtButtonDemoFragment = GdtButtonDemoFragment.this;
            gdtButtonDemoFragment.containerView.removeView((View) gdtButtonDemoFragment.E);
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdFailedToLoad(GdtAd gdtAd, @NonNull GdtAdError gdtAdError) {
            GdtLog.e("GdtButtonDemoFragment", "[onAdFailedToLoad] " + gdtAdError.getErrorMessage());
            AdToast.getInstance().show(GdtButtonDemoFragment.this.getActivity().getApplicationContext(), 1, "onAdFailedToLoad " + gdtAdError.getErrorMessage(), 0);
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdImpression(GdtAd gdtAd) {
            GdtLog.i("GdtButtonDemoFragment", String.format("[onAdImpression] %d", Long.valueOf(a(gdtAd))));
            AdToast.getInstance().show(GdtButtonDemoFragment.this.getActivity().getApplicationContext(), 0, String.format("[onAdImpression] %d", Long.valueOf(a(gdtAd))), 0);
        }

        @Override // com.tencent.gdtad.api.GdtAdListener
        public void onAdLoaded(GdtAd gdtAd) {
            GdtLog.i("GdtButtonDemoFragment", String.format("[onAdLoaded] %d", Long.valueOf(a(gdtAd))));
            AdToast.getInstance().show(GdtButtonDemoFragment.this.getActivity().getApplicationContext(), 0, String.format("[onAdLoaded] %d", Long.valueOf(a(gdtAd))), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class d extends GdtAdParams {
        d() {
        }
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment
    protected GdtAd getAd() {
        return this.C;
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
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
        Button button = new Button(getContext());
        this.F = button;
        button.setText("\u53d6\u6d88\u4e0b\u8f7d");
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        AdAppDownloadButtonController adAppDownloadButtonController = this.D;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.unregisterView(new WeakReference<>(this.E));
            this.D = null;
            this.E = null;
        }
        super.onDestroy();
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment
    protected void onInit(String str, qq_ad_get.QQAdGet qQAdGet, GdtHandler.Params params) {
        d dVar = new d();
        dVar.requestParams = qQAdGet;
        dVar.clickParams = params;
        GdtButtonDemoAd gdtButtonDemoAd = new GdtButtonDemoAd(dVar);
        this.C = gdtButtonDemoAd;
        gdtButtonDemoAd.setListener(new WeakReference<>(this.G));
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        AdAppDownloadButtonController adAppDownloadButtonController = this.D;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewPause();
        }
        super.onPause();
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AdAppDownloadButtonController adAppDownloadButtonController = this.D;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    @Override // com.tencent.gdtad.jsbridge.GdtBaseBannerFragment
    protected void onShow() {
        AdAppDownloadButtonController.Params params = new AdAppDownloadButtonController.Params();
        params.clickParams = GdtHandler.toParams(this.C.getParams().clickParams);
        AdAppDownloadButtonController adAppDownloadButtonController = new AdAppDownloadButtonController(params);
        this.D = adAppDownloadButtonController;
        adAppDownloadButtonController.registerView(new WeakReference<>(this.E));
        ((View) this.E).setOnClickListener(new a());
        this.containerView.addView((View) this.E, new LinearLayout.LayoutParams(600, 100));
        this.F.setOnClickListener(new b());
        this.containerView.addView(this.F, new LinearLayout.LayoutParams(600, 100));
    }
}
