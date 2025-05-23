package com.tencent.gdtad.api.banner;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleNewStyle;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtBannerAd extends GdtAd implements IGdtBannerAd {
    private AdFeedbackDialogFragment.Listener feedbackDialogListener;
    private GdtBannerParams params;
    private boolean rendered;
    private float touchUpX;
    private float touchUpY;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GdtBannerView f108500d;

        a(GdtBannerView gdtBannerView) {
            this.f108500d = gdtBannerView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f108500d.getAntiSpamForClick().onTouch(view, motionEvent);
            if (motionEvent.getAction() == 1) {
                GdtBannerAd.this.touchUpX = motionEvent.getX();
                GdtBannerAd.this.touchUpY = motionEvent.getY();
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GdtBannerView f108502d;

        b(GdtBannerView gdtBannerView) {
            this.f108502d = gdtBannerView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtLog.i("GdtBannerAd", "getView().onClick");
            if (!GdtBannerAd.this.g()) {
                GdtLog.e("GdtBannerAd", "getView().onClick !isValidClick()");
            } else {
                GdtBannerAd.this.params.clickParams.antiSpamParams = this.f108502d.getAntiSpamForClick().onClick(view);
                GdtBannerAd.this.params.clickParams.videoCeilingSupportedIfNotInstalled = true;
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(GdtBannerAd.this.params.clickParams);
                GdtBannerAd.this.notifyClicked();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class c implements AdFeedbackDialogFragment.Listener {
        c() {
        }

        @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
        public void onResult(AdFeedbackDialogFragment.Result result) {
            if (result != null && result.action == 3) {
                GdtBannerAd.this.notifyClosed();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtLog.i("GdtBannerAd", "getOptionsView().onClick");
            if (!GdtBannerAd.this.isLoaded()) {
                GdtLog.e("GdtBannerAd", "getOptionsView().onClick !isValidClick()");
            } else {
                int i3 = 1;
                if (GdtBannerAd.this.params.orientation == 1) {
                    i3 = 0;
                } else if (GdtBannerAd.this.params.orientation != 0 && GdtBannerAd.this.params.orientation != 8) {
                    i3 = Integer.MIN_VALUE;
                }
                if (i3 == Integer.MIN_VALUE) {
                    GdtLog.e("GdtBannerAd", "getOptionsView().onClick unknown feedbackStyleId");
                } else {
                    AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
                    adFeedbackParams.activity = GdtBannerAd.this.params.clickParams.activity;
                    adFeedbackParams.listener = new WeakReference<>(GdtBannerAd.this.feedbackDialogListener);
                    adFeedbackParams.f61346ad = GdtBannerAd.this.params.clickParams.f108486ad;
                    adFeedbackParams.styleId = i3;
                    try {
                        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
                    } catch (Throwable th5) {
                        GdtLog.e("GdtBannerAd", "handleJsCallRequest", th5);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GdtBannerAd(GdtBannerParams gdtBannerParams) {
        super(gdtBannerParams);
        this.rendered = false;
        this.params = gdtBannerParams;
        init();
    }

    private GdtBannerView f(GdtBannerParams gdtBannerParams) {
        if (gdtBannerParams != null && gdtBannerParams.isValid() && gdtBannerParams.clickParams.isValid()) {
            GdtBannerViewWithRectangleNewStyle gdtBannerViewWithRectangleNewStyle = new GdtBannerViewWithRectangleNewStyle(gdtBannerParams.clickParams.activity.get(), gdtBannerParams);
            gdtBannerViewWithRectangleNewStyle.setSize(gdtBannerParams.width, gdtBannerParams.height);
            AdAnalysisHelperForUtil.reportForBanner(gdtBannerParams.clickParams.activity.get(), gdtBannerParams.clickParams.f108486ad);
            return gdtBannerViewWithRectangleNewStyle;
        }
        GdtLog.e("GdtBannerAd", "build error");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (isLoaded()) {
            long minIntervalMillisBetweenExposureAndClick = this.params.clickParams.f108486ad.getMinIntervalMillisBetweenExposureAndClick();
            GdtLog.i("GdtBannerAd", "getView().onClick exp time :" + minIntervalMillisBetweenExposureAndClick);
            long min = Math.min(Math.max(minIntervalMillisBetweenExposureAndClick, 0L), 1000L);
            long currentTimeMillis = System.currentTimeMillis();
            GdtBannerParams gdtBannerParams = this.params;
            if (min > currentTimeMillis - gdtBannerParams.showTime) {
                GdtLog.e("GdtBannerAd", "getView().onClick return cause click unless than exp time :" + min);
            } else {
                int bannerInvalidClickXPercent = gdtBannerParams.clickParams.f108486ad.getBannerInvalidClickXPercent();
                GdtLog.i("GdtBannerAd", "getView().onClick exp leftRightPercent :" + bannerInvalidClickXPercent);
                int min2 = Math.min(Math.max(bannerInvalidClickXPercent, 0), 100);
                float f16 = this.touchUpX;
                double d16 = (double) f16;
                GdtBannerParams gdtBannerParams2 = this.params;
                int i3 = gdtBannerParams2.width;
                if (d16 >= ((i3 * min2) * 1.0d) / 100.0d && f16 <= ((i3 * (100 - min2)) * 1.0d) / 100.0d) {
                    int bannerInvalidClickYPercent = gdtBannerParams2.clickParams.f108486ad.getBannerInvalidClickYPercent();
                    GdtLog.i("GdtBannerAd", "getView().onClick exp upDownPercent :" + bannerInvalidClickYPercent);
                    int min3 = Math.min(Math.max(bannerInvalidClickYPercent, 0), 100);
                    float f17 = this.touchUpY;
                    double d17 = (double) f17;
                    int i16 = this.params.height;
                    if (d17 >= ((i16 * min3) * 1.0d) / 100.0d && f17 <= ((i16 * (100 - min3)) * 1.0d) / 100.0d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.gdtad.api.GdtAd
    public int getErrorCode(com.tencent.gdtad.aditem.GdtAd gdtAd, int i3, int i16, int i17) {
        int errorCode = super.getErrorCode(gdtAd, i3, i16, i17);
        if (errorCode != 0) {
            return errorCode;
        }
        if (gdtAd != null && isValid() && getMParams().requestParams != null) {
            if (GdtBannerParams.isCreativeSizeValid(gdtAd)) {
                return 0;
            }
            return 7;
        }
        GdtLog.e("GdtBannerAd", "getErrorCode error");
        return 1;
    }

    @Override // com.tencent.gdtad.api.banner.IGdtBannerAd
    public void onDisplay() {
        GdtBannerParams gdtBannerParams = this.params;
        if (gdtBannerParams != null && gdtBannerParams.showTime == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            gdtBannerParams.showTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.gdtad.api.banner.IGdtBannerAd
    public GdtBannerView render(Context context, int i3, int i16) {
        if (context != null && i3 >= 0 && i16 >= 0 && isLoaded() && !this.rendered) {
            GdtBannerParams gdtBannerParams = this.params;
            gdtBannerParams.width = i3;
            gdtBannerParams.height = i16;
            GdtBannerView f16 = f(gdtBannerParams);
            if (f16 != null && f16.getView() != null && f16.getAntiSpamForClick() != null) {
                f16.getView().setOnTouchListener(new a(f16));
                f16.getView().setOnClickListener(new b(f16));
                if (f16.getOptionsView() != null) {
                    this.feedbackDialogListener = new c();
                    f16.getOptionsView().setOnClickListener(new d());
                }
                this.rendered = true;
                return f16;
            }
            GdtLog.e("GdtBannerAd", "render error");
            return null;
        }
        GdtLog.e("GdtBannerAd", "render error");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.gdtad.api.GdtAd
    /* renamed from: getParams */
    public GdtBannerParams getMParams() {
        return this.params;
    }
}
