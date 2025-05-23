package ng;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.gdt.reporter.GdtCarouselCardReporterForQzone;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.widget.ad.QZoneAdFeedxCarouselCardVideoWidgetView;
import com.qzone.reborn.feedx.widget.ad.QZoneAdVideoItemWidgetView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.widget.carouselcard.TGCarouselCardLayoutManagerParams;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.carousel.GdtCarouselCardData;
import com.tencent.gdtad.views.carousel.GdtCarouselCardView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qzone.QZoneTopGestureLayout;
import gf.r;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends vg.a implements r {
    private GdtAd F;
    private FrameLayout G;
    private GdtCarouselCardView H;
    private QZoneAdFeedxCarouselCardVideoWidgetView I;
    private int J = 0;
    private int K = Integer.MIN_VALUE;
    private boolean L = false;
    private View.OnClickListener M = new ViewOnClickListenerC10844a();
    private GdtCarouselCardView.IOnActionListener N = new b();
    private QZoneAdVideoItemWidgetView.c P = new c();
    private GdtCarouselCardView.IAdapterForViews Q = new d();
    private AdExposureChecker.ExposureCallback R = new e();

    /* compiled from: P */
    /* renamed from: ng.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class ViewOnClickListenerC10844a implements View.OnClickListener {
        ViewOnClickListenerC10844a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BusinessFeedData businessFeedData = ((vg.a) a.this).f441565h;
            GdtAd gdtAd = a.this.F;
            if (businessFeedData != null && gdtAd != null && gdtAd.isValid() && view != null) {
                Object tag = view.getTag(2131296418);
                if (tag instanceof Integer) {
                    int p06 = a.p0(businessFeedData, ((Integer) tag).intValue());
                    QLog.i("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[onClick] aid:" + gdtAd.getAId() + " itemPosition:" + p06);
                    businessFeedData.getAdData().setCarouselCardClickedOrManuallyScrolledItemPosition(p06);
                    a.s0(((vg.a) a.this).C, businessFeedData, gdtAd, new WeakReference(a.this.R));
                    QZoneAdFeedUtils.f55717a.H(((vg.a) a.this).C, view, businessFeedData, FeedElement.GDT_CAROUSEL_CARD, 64, ((vg.a) a.this).f441567m, null);
                } else {
                    QLog.e("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[onClick] error");
                }
            } else {
                QLog.e("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[onClick] error, feedData or view is null");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class c implements QZoneAdVideoItemWidgetView.c {
        c() {
        }

        @Override // lh.a
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            QLog.i("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[onCompletion] currentSelectedItemPosition:" + a.this.J);
            if (a.this.K > 0 && a.this.H != null) {
                a.this.L = true;
                a.this.H.smoothScrollToPosition((a.this.J + 1) % a.this.K);
            } else {
                QLog.e("PSLink-QZoneAdFeedCarouselCardPresenter", 1, "[onCompletion] error");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class d implements GdtCarouselCardView.IAdapterForViews {
        d() {
        }

        @Override // com.tencent.gdtad.views.carousel.GdtCarouselCardView.IAdapterForViews
        public View getVideoView(int i3, int i16, int i17) {
            VideoInfo videoInfo;
            BusinessFeedData businessFeedData = ((vg.a) a.this).f441565h;
            GdtAd gdtAd = a.this.F;
            int gdtInnerAdShowType = businessFeedData != null ? QZoneAdFeedDataExtKt.getGdtInnerAdShowType(businessFeedData) : Integer.MIN_VALUE;
            if (businessFeedData != null && gdtAd != null && gdtAd.isValid() && gdtInnerAdShowType == 46) {
                GdtAdFeedUtil.CarouselCardInfo carouselCardInfoForPosition = GdtAdFeedUtil.getCarouselCardInfoForPosition(businessFeedData, i3);
                if (carouselCardInfoForPosition != null && !TextUtils.isEmpty(carouselCardInfoForPosition.videoUrl) && (videoInfo = carouselCardInfoForPosition.videoInfo) != null && videoInfo.width > 0 && videoInfo.height > 0) {
                    if (((vg.a) a.this).C == null) {
                        QLog.e("PSLink-QZoneAdFeedCarouselCardPresenter", 1, "[getVideoView] error, mActivity is null, position:" + i3);
                        return null;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[getVideoView] position:");
                    sb5.append(i3);
                    sb5.append(" ");
                    sb5.append("widthPx:");
                    sb5.append(i16);
                    sb5.append(" ");
                    sb5.append("heightPx:");
                    sb5.append(i17);
                    sb5.append("videoUrl:");
                    sb5.append(carouselCardInfoForPosition);
                    QLog.i("PSLink-QZoneAdFeedCarouselCardPresenter", 2, sb5.toString() != null ? carouselCardInfoForPosition.videoUrl : null);
                    QZoneAdFeedxCarouselCardVideoWidgetView qZoneAdFeedxCarouselCardVideoWidgetView = new QZoneAdFeedxCarouselCardVideoWidgetView(((vg.a) a.this).C, i16, i17);
                    qZoneAdFeedxCarouselCardVideoWidgetView.setOnClickListener(a.this.M);
                    qZoneAdFeedxCarouselCardVideoWidgetView.setVideoCompletionListener(new WeakReference<>(a.this.P));
                    qZoneAdFeedxCarouselCardVideoWidgetView.C1(businessFeedData, ((vg.a) a.this).f441567m, carouselCardInfoForPosition.videoInfo);
                    a.this.I = qZoneAdFeedxCarouselCardVideoWidgetView;
                    return a.this.I;
                }
                QLog.i("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[getVideoView], not video, position:" + i3);
                return null;
            }
            QLog.i("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[getVideoView], not video, position:" + i3 + " innerAdShowType:" + gdtInnerAdShowType);
            return null;
        }

        @Override // com.tencent.gdtad.views.carousel.GdtCarouselCardView.IAdapterForViews
        public void updateImageDrawable(ImageView imageView, int i3, int i16, int i17) {
            BusinessFeedData businessFeedData = ((vg.a) a.this).f441565h;
            GdtAd gdtAd = a.this.F;
            GdtAdFeedUtil.CarouselCardInfo carouselCardInfoForPosition = GdtAdFeedUtil.getCarouselCardInfoForPosition(((vg.a) a.this).f441565h, i3);
            if (businessFeedData != null && gdtAd != null && gdtAd.isValid() && imageView != null && carouselCardInfoForPosition != null && !TextUtils.isEmpty(carouselCardInfoForPosition.imageUrl)) {
                ih.c.a(carouselCardInfoForPosition.imageUrl, i16, i17, imageView);
                return;
            }
            QLog.i("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[updateImageDrawable] error, position:" + i3);
        }

        @Override // com.tencent.gdtad.views.carousel.GdtCarouselCardView.IAdapterForViews
        public ImageView getImageView() {
            QLog.i("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[getImageView]");
            ImageView imageView = new ImageView(((vg.a) a.this).C);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setOnClickListener(a.this.M);
            return imageView;
        }

        @Override // com.tencent.gdtad.views.carousel.GdtCarouselCardView.IAdapterForViews
        public void recycleVideoView() {
            QLog.i("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[recycleVideoView]");
            if (a.this.I != null) {
                a.this.I.a();
                a.this.I = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class e implements AdExposureChecker.ExposureCallback {
        e() {
        }

        @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
        public void onExposure(WeakReference<View> weakReference) {
            if (((vg.a) a.this).f441565h != null && a.this.F != null && a.this.F.isValid()) {
                GdtAdFeedUtil.doEffectiveExposureReport(((vg.a) a.this).f441565h, ((vg.a) a.this).f441567m, 0);
            } else {
                QLog.e("PSLink-QZoneAdFeedCarouselCardPresenter", 1, "[onExposure] error");
            }
        }
    }

    private GdtCarouselCardView n0(int i3, int i16, int i17, int i18) {
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null) {
            QLog.e("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[createCarouselCardView] error, feedData is null");
            return null;
        }
        GdtCarouselCardView.Params params = new GdtCarouselCardView.Params();
        params.weakContext = new WeakReference<>(this.C);
        params.cardWidthPx = i17;
        params.cardHeightPx = i18;
        params.weakOnActionListener = new WeakReference<>(this.N);
        params.weakAdapterForPlayer = new WeakReference<>(this.Q);
        List<GdtCarouselCardData> o06 = o0(businessFeedData);
        params.dataList = o06;
        if (o06 != null && !o06.isEmpty()) {
            this.K = params.dataList.size();
            TGCarouselCardLayoutManagerParams tGCarouselCardLayoutManagerParams = new TGCarouselCardLayoutManagerParams();
            tGCarouselCardLayoutManagerParams.maxVisibleItemCount = 4;
            tGCarouselCardLayoutManagerParams.scrollThreshold = 0.6f;
            tGCarouselCardLayoutManagerParams.horizontalOffsetPx = i3;
            tGCarouselCardLayoutManagerParams.verticalOffsetPx = i16;
            tGCarouselCardLayoutManagerParams.canScrollOverStartPosition = false;
            int max = Math.max(0, businessFeedData.getAdData().getCarouselCardFirstVisibleItemPosition());
            if (max < params.dataList.size()) {
                tGCarouselCardLayoutManagerParams.startPosition = max;
                businessFeedData.getAdData().setCarouselCardFirstVisibleItemPosition(max);
                businessFeedData.getAdData().setCarouselCardClickedOrManuallyScrolledItemPosition(max);
                this.J = max;
            }
            params.layoutManagerParams = tGCarouselCardLayoutManagerParams;
            return GdtCarouselCardView.build(params);
        }
        QLog.e("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[createCarouselCardView] error");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(boolean z16) {
        GdtAd gdtAd;
        QZoneAdFeedxCarouselCardVideoWidgetView qZoneAdFeedxCarouselCardVideoWidgetView = this.I;
        boolean z17 = qZoneAdFeedxCarouselCardVideoWidgetView != null && qZoneAdFeedxCarouselCardVideoWidgetView.isPlaying();
        GdtAd gdtAd2 = this.F;
        QLog.i("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[play] aid:" + (gdtAd2 != null ? gdtAd2.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) + " currentSelectedItemPosition: " + this.J + " forced:" + z16 + " isPlaying:" + z17);
        QZoneAdFeedxCarouselCardVideoWidgetView qZoneAdFeedxCarouselCardVideoWidgetView2 = this.I;
        if (qZoneAdFeedxCarouselCardVideoWidgetView2 != null) {
            qZoneAdFeedxCarouselCardVideoWidgetView2.H1(z16);
        }
        if (this.f441565h == null || (gdtAd = this.F) == null || !gdtAd.isValid() || QZoneAdFeedDataExtKt.getGdtInnerAdShowType(this.f441565h) != 46 || z17) {
            return;
        }
        GdtCarouselCardReporterForQzone.reportForActionType(this.f441565h, this.J, "5");
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (this.f441565h != null && this.G != null) {
            GdtAd gdtAd = this.F;
            long j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            long aId = gdtAd != null ? gdtAd.getAId() : -2147483648L;
            GdtAd gdtAd2 = this.F;
            String traceId = gdtAd2 != null ? gdtAd2.getTraceId() : null;
            String aid = QZoneAdFeedDataExtKt.getAid(this.f441565h);
            String traceId2 = QZoneAdFeedDataExtKt.getTraceId(this.f441565h);
            QLog.i("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[onBindData] aid:" + aid + " traceId:" + traceId2 + " oldAid:" + aId + " oldTraceId:" + traceId);
            if (!TextUtils.isEmpty(traceId2) && TextUtils.equals(traceId2, traceId)) {
                QLog.e("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[onBindData] ignore, is the same ad");
                return;
            }
            r0();
            this.F = GdtFeedUtilForQZone.E(this.f441565h);
            ng.b a16 = ng.b.a();
            GdtCarouselCardView n06 = n0(a16.f420121c, a16.f420122d, a16.f420123e, a16.f420124f);
            this.H = n06;
            if (n06 == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[onBindData] error, aid:");
                GdtAd gdtAd3 = this.F;
                if (gdtAd3 != null) {
                    j3 = gdtAd3.getAId();
                }
                sb5.append(j3);
                QLog.i("PSLink-QZoneAdFeedCarouselCardPresenter", 2, sb5.toString());
                r0();
                return;
            }
            n06.setId(R.id.f162844my0);
            this.G.addView(this.H, new FrameLayout.LayoutParams(a16.f420119a, a16.f420120b));
            int q16 = QZoneAdFeedUtils.f55717a.q(this.f441565h);
            FrameLayout frameLayout = this.G;
            frameLayout.setPadding(frameLayout.getPaddingLeft(), this.G.getPaddingTop(), this.G.getPaddingRight(), q16);
            ih.b.b(this.f441565h, this.F, 0, 0);
            return;
        }
        QLog.e("PSLink-QZoneAdFeedCarouselCardPresenter", 1, "[onBindData] error, mFeedData or mContainerView is null");
        r0();
    }

    @Override // vg.a
    protected void C(View view) {
        if (view instanceof FrameLayout) {
            this.G = (FrameLayout) view;
        }
    }

    @Override // gf.r
    public void a() {
        QZoneAdFeedxCarouselCardVideoWidgetView qZoneAdFeedxCarouselCardVideoWidgetView = this.I;
        if (qZoneAdFeedxCarouselCardVideoWidgetView != null) {
            qZoneAdFeedxCarouselCardVideoWidgetView.a();
        }
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        QLog.d("PSLink-QZoneAdFeedCarouselCardPresenter", 1, "getVideoItemView   | feedPos = " + this.f441567m + " | view = " + this.I);
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "PSLink-QZoneAdFeedCarouselCardPresenter";
    }

    @Override // gf.r
    public void pause() {
        QZoneAdFeedxCarouselCardVideoWidgetView qZoneAdFeedxCarouselCardVideoWidgetView = this.I;
        if (qZoneAdFeedxCarouselCardVideoWidgetView != null) {
            qZoneAdFeedxCarouselCardVideoWidgetView.pause();
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.nms;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private void r0() {
        GdtCarouselCardView gdtCarouselCardView;
        this.F = null;
        FrameLayout frameLayout = this.G;
        if (frameLayout != null && (gdtCarouselCardView = this.H) != null) {
            frameLayout.removeView(gdtCarouselCardView);
            this.H = null;
        }
        QZoneAdFeedxCarouselCardVideoWidgetView qZoneAdFeedxCarouselCardVideoWidgetView = this.I;
        if (qZoneAdFeedxCarouselCardVideoWidgetView != null) {
            qZoneAdFeedxCarouselCardVideoWidgetView.a();
            this.I = null;
        }
        this.J = 0;
        this.K = 0;
        this.L = false;
    }

    @Override // gf.r
    public void play() {
        q0(false);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements GdtCarouselCardView.IOnActionListener {
        b() {
        }

        @Override // com.tencent.gdtad.views.carousel.GdtCarouselCardView.IOnActionListener
        public void onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                QZoneTopGestureLayout.setBackEnabled(false);
                FrameHelperActivity.gj(false, "PSLink-QZoneAdFeedCarouselCardPresenter");
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                QZoneTopGestureLayout.setBackEnabled(true);
                FrameHelperActivity.gj(true, "PSLink-QZoneAdFeedCarouselCardPresenter");
            }
        }

        @Override // com.tencent.gdtad.views.carousel.GdtCarouselCardView.IOnActionListener
        public void onItemScrolled(int i3, int i16) {
            String str;
            if (i3 == i16) {
                return;
            }
            QLog.i("PSLink-QZoneAdFeedCarouselCardPresenter", 2, "[onItemScrolled] fromPosition:" + i3 + " toPosition:" + i16);
            a.this.J = i16;
            a.this.q0(true);
            BusinessFeedData businessFeedData = ((vg.a) a.this).f441565h;
            GdtAd gdtAd = a.this.F;
            if (businessFeedData == null || gdtAd == null || !gdtAd.isValid()) {
                return;
            }
            int p06 = a.p0(businessFeedData, i3);
            int p07 = a.p0(businessFeedData, i16);
            businessFeedData.getAdData().setCarouselCardFirstVisibleItemPosition(p07);
            GdtCarouselCardReporterForQzone.reportForActionType(businessFeedData, p07, "1");
            if (a.this.L) {
                a.this.L = false;
                str = "4";
            } else {
                businessFeedData.getAdData().setCarouselCardClickedOrManuallyScrolledItemPosition(p06);
                a.s0(((vg.a) a.this).C, businessFeedData, gdtAd, new WeakReference(a.this.R));
                str = "3";
            }
            GdtCarouselCardReporterForQzone.reportForActionType(businessFeedData, p06, str);
            ih.b.b(businessFeedData, gdtAd, p07, p07);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s0(Context context, BusinessFeedData businessFeedData, GdtAd gdtAd, WeakReference<AdExposureChecker.ExposureCallback> weakReference) {
        if (businessFeedData == null || businessFeedData.getAdData().getIsCGIExposureReport()) {
            return;
        }
        AdExposureChecker.onClick(context, gdtAd, weakReference);
    }

    private static List<GdtCarouselCardData> o0(BusinessFeedData businessFeedData) {
        LinkedList linkedList = null;
        if (businessFeedData == null) {
            return null;
        }
        List<GdtAdFeedUtil.CarouselCardInfo> carouselCardInfoList = businessFeedData.getAdData().getCarouselCardInfoList();
        if (carouselCardInfoList != null && !carouselCardInfoList.isEmpty()) {
            linkedList = new LinkedList();
            while (linkedList.size() < 4) {
                for (GdtAdFeedUtil.CarouselCardInfo carouselCardInfo : carouselCardInfoList) {
                    if (carouselCardInfo != null) {
                        linkedList.add(new GdtCarouselCardData(carouselCardInfo.imageUrl, carouselCardInfo.videoUrl, carouselCardInfo.videoDurationMs, carouselCardInfo.desc));
                    }
                }
                if (linkedList.isEmpty()) {
                    break;
                }
            }
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p0(BusinessFeedData businessFeedData, int i3) {
        List<GdtAdFeedUtil.CarouselCardInfo> carouselCardInfoList;
        if (businessFeedData == null || (carouselCardInfoList = businessFeedData.getAdData().getCarouselCardInfoList()) == null || carouselCardInfoList.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return i3 % carouselCardInfoList.size();
    }
}
