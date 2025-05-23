package h6;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.FeedAutoVideo;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.NormalAbsFeedView;
import com.qzone.proxy.feedcomponent.ViewSectionType;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.gdt.reporter.GdtCarouselCardReporterForQzone;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.widget.carouselcard.TGCarouselCardLayoutManagerParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.carousel.GdtCarouselCardData;
import com.tencent.gdtad.views.carousel.GdtCarouselCardView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.qzoneplayer.video.AutoVideoProgressRecorder;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoElement;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfoHolder;
import com.tencent.mobileqq.qzoneplayer.video.g;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends h6.a implements GdtCarouselCardView.IAdapterForViews {
    private FeedAutoVideo.OnVideoPlayStatusListener C;
    private FeedAutoVideo D;
    private boolean E;
    private final LinkedList<FeedAutoVideo> F;
    private int G;
    private int H;
    private boolean I;

    /* renamed from: f, reason: collision with root package name */
    private GdtCarouselCardView f404419f;

    /* renamed from: h, reason: collision with root package name */
    private GdtCarouselCardView.IOnActionListener f404420h;

    /* renamed from: i, reason: collision with root package name */
    private g f404421i;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f404422m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BusinessFeedData businessFeedData = ((FeedViewSection) b.this).mFeedData;
            if (businessFeedData != null && view != null) {
                Object tag = view.getTag(2131296418);
                if (tag instanceof Integer) {
                    businessFeedData.getAdData().setCarouselCardClickedOrManuallyScrolledItemPosition(b.this.D(businessFeedData, ((Integer) tag).intValue()));
                    b.this.e();
                    com.qzone.proxy.feedcomponent.ui.g gVar = ((FeedViewSection) b.this).onFeedElementClickListener;
                    if (gVar != null) {
                        gVar.onClick(b.this.f404419f, FeedElement.GDT_CAROUSEL_CARD, ((FeedViewSection) b.this).feedPosition, null);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: h6.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10415b implements g {
        C10415b() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.g
        public void onClick(View view, FeedVideoElement feedVideoElement, int i3, Object obj) {
            BusinessFeedData businessFeedData = ((FeedViewSection) b.this).mFeedData;
            if (businessFeedData == null || view == null) {
                return;
            }
            businessFeedData.getAdData().setCarouselCardClickedOrManuallyScrolledItemPosition(b.this.D(businessFeedData, businessFeedData.getAdData().getCarouselCardFirstVisibleItemPosition()));
            b.this.e();
            com.qzone.proxy.feedcomponent.ui.g gVar = ((FeedViewSection) b.this).onFeedElementClickListener;
            if (gVar == null) {
                return;
            }
            if (feedVideoElement == FeedVideoElement.AUTO_VIDEO || feedVideoElement == FeedVideoElement.VIDEO_COVER) {
                gVar.onClick(b.this.f404419f, FeedElement.GDT_CAROUSEL_CARD, ((FeedViewSection) b.this).feedPosition, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class c implements GdtCarouselCardView.IOnActionListener {
        c() {
        }

        @Override // com.tencent.gdtad.views.carousel.GdtCarouselCardView.IOnActionListener
        public void onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.F(false);
                FrameHelperActivity.gj(false, "GdtCarouselCardSection");
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                b.this.F(true);
                FrameHelperActivity.gj(true, "GdtCarouselCardSection");
            }
        }

        @Override // com.tencent.gdtad.views.carousel.GdtCarouselCardView.IOnActionListener
        public void onItemScrolled(int i3, int i16) {
            BusinessFeedData businessFeedData;
            String str;
            GdtLog.i("GdtCarouselCardSection", String.format("[onItemScrolled] from = %d, to = %d", Integer.valueOf(i3), Integer.valueOf(i16)));
            b.this.G = i16;
            FeedAutoVideo feedAutoVideo = b.this.D;
            if (feedAutoVideo != null && !BaseVideoManager.getFeedVideoManager().u(feedAutoVideo)) {
                b.this.F.clear();
                b.this.F.add(feedAutoVideo);
                BaseVideoManager.getFeedVideoManager().onListIdleSingleVideo(b.this.F);
            }
            if (i3 == i16 || (businessFeedData = ((FeedViewSection) b.this).mFeedData) == null) {
                return;
            }
            int D = b.this.D(businessFeedData, i3);
            int D2 = b.this.D(businessFeedData, i16);
            businessFeedData.getAdData().setCarouselCardFirstVisibleItemPosition(D2);
            GdtCarouselCardReporterForQzone.reportForActionType(businessFeedData, D2, "1");
            if (b.this.I) {
                b.this.I = false;
                str = "4";
            } else {
                businessFeedData.getAdData().setCarouselCardClickedOrManuallyScrolledItemPosition(D);
                b.this.e();
                str = "3";
            }
            GdtCarouselCardReporterForQzone.reportForActionType(businessFeedData, i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class d implements FeedAutoVideo.OnVideoPlayStatusListener {
        d() {
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
        public void onVideoPlayComplete(BaseVideo baseVideo) {
            GdtLog.i("GdtCarouselCardSection", "[onVideoPlayComplete]");
            if (b.this.H <= 0 || b.this.f404419f == null) {
                return;
            }
            b.this.I = true;
            b.this.f404419f.smoothScrollToPosition((b.this.G + 1) % b.this.H);
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
        public void onVideoPlayProgressUpdate(BaseVideo baseVideo) {
            GdtLog.i("GdtCarouselCardSection", "[onVideoPlayProgressUpdate]");
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
        public void onVideoPlayStart(BaseVideo baseVideo) {
            GdtLog.i("GdtCarouselCardSection", "[onVideoPlayStart]");
            GdtCarouselCardReporterForQzone.reportForActionType(((FeedViewSection) b.this).mFeedData, b.this.G, "5");
        }

        @Override // com.qzone.module.feedcomponent.ui.FeedAutoVideo.OnVideoPlayStatusListener
        public void onVideoPlayStop(BaseVideo baseVideo) {
            GdtLog.i("GdtCarouselCardSection", "[onVideoPlayStop]");
            if (baseVideo instanceof FeedAutoVideo) {
                if (baseVideo.isVideoCoverNotNull()) {
                    baseVideo.mVideoCover.setShowPlayIcon(true);
                    baseVideo.postInvalidate();
                }
                b.this.E(baseVideo.getVideoPlayInfo());
            }
        }
    }

    public b(Context context, NormalAbsFeedView normalAbsFeedView) {
        super(context, normalAbsFeedView);
        this.E = false;
        this.F = new LinkedList<>();
        this.G = 0;
        this.H = Integer.MIN_VALUE;
        this.I = false;
    }

    private g A() {
        return new C10415b();
    }

    private FeedAutoVideo.OnVideoPlayStatusListener B() {
        return new d();
    }

    private List<GdtCarouselCardData> C() {
        List<GdtAdFeedUtil.CarouselCardInfo> carouselCardInfoList;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || !businessFeedData.isGDTAdvFeed() || (carouselCardInfoList = businessFeedData.getAdData().getCarouselCardInfoList()) == null || carouselCardInfoList.isEmpty()) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        do {
            for (GdtAdFeedUtil.CarouselCardInfo carouselCardInfo : carouselCardInfoList) {
                if (carouselCardInfo != null) {
                    linkedList.add(new GdtCarouselCardData(carouselCardInfo.imageUrl, carouselCardInfo.videoUrl, carouselCardInfo.videoDurationMs, carouselCardInfo.desc));
                }
            }
            if (linkedList.isEmpty()) {
                break;
            }
        } while (linkedList.size() < 4);
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(boolean z16) {
        View view = this.f404419f;
        while (view != null) {
            if (view instanceof TopGestureLayout) {
                ((TopGestureLayout) view).setInterceptScrollLRFlag(z16);
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return;
            } else {
                view = (View) parent;
            }
        }
    }

    private GdtCarouselCardView.IOnActionListener y() {
        return new c();
    }

    private View.OnClickListener z() {
        return new a();
    }

    @Override // h6.a
    public FeedAutoVideo c() {
        return this.D;
    }

    @Override // h6.a
    protected ViewSectionType d() {
        return ViewSectionType.GDT_CAROUSEL_CARD;
    }

    @Override // com.tencent.gdtad.views.carousel.GdtCarouselCardView.IAdapterForViews
    public ImageView getImageView() {
        URLImageView uRLImageView = new URLImageView(getContext());
        uRLImageView.setOnClickListener(this.f404422m);
        if (i.H().p1()) {
            uRLImageView.setColorFilter(-2113929216);
        }
        return uRLImageView;
    }

    @Override // com.tencent.gdtad.views.carousel.GdtCarouselCardView.IAdapterForViews
    public View getVideoView(int i3, int i16, int i17) {
        GdtAdFeedUtil.CarouselCardInfo carouselCardInfoForPosition;
        BusinessFeedData businessFeedData = this.mFeedData;
        FeedAutoVideo feedAutoVideo = null;
        if (businessFeedData != null && businessFeedData.isGDTAdvFeed() && (carouselCardInfoForPosition = GdtAdFeedUtil.getCarouselCardInfoForPosition(businessFeedData, i3)) != null && !TextUtils.isEmpty(carouselCardInfoForPosition.videoUrl)) {
            GdtLog.i("GdtCarouselCardSection", "[getVideoView] cardWidthPx =  " + i16 + " cardHeightPx = " + i17);
            feedAutoVideo = new FeedAutoVideo(getContext());
            feedAutoVideo.setForceToWH(true, i16, i17);
            E(carouselCardInfoForPosition.videoPlayInfo);
            QZoneAdFeedDataExtKt.setVideoPlayInfoForReportAdPlay(businessFeedData, carouselCardInfoForPosition.videoPlayInfo);
            feedAutoVideo.setVideoPlayInfo(carouselCardInfoForPosition.videoPlayInfo);
            feedAutoVideo.setFeedData(businessFeedData);
            int i18 = this.feedPosition;
            NormalAbsFeedView normalAbsFeedView = this.mRootView;
            feedAutoVideo.setFeedPos(i18, normalAbsFeedView != null ? normalAbsFeedView.mIndex : -1);
            feedAutoVideo.setOnVideoPlayStatusListener(this.C);
            feedAutoVideo.setOnFeedVideoElementClickListener(this.f404421i);
            if (feedAutoVideo.isVideoCoverNotNull()) {
                if (!this.E) {
                    feedAutoVideo.mVideoCover.setShowPlayIcon(true);
                    this.E = true;
                } else {
                    feedAutoVideo.mVideoCover.setShowPlayIcon(false);
                }
            }
            this.D = feedAutoVideo;
        }
        return feedAutoVideo;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public boolean haveMultipleViews() {
        return false;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public View obtainView() {
        GdtLog.i("GdtCarouselCardSection", "[obtainViews] start " + this.feedPosition);
        Context context = getContext();
        BusinessFeedData businessFeedData = this.mFeedData;
        if (context != null && businessFeedData != null && businessFeedData.isGDTAdvFeed()) {
            this.f404420h = y();
            this.C = B();
            this.f404421i = A();
            this.f404422m = z();
            this.E = false;
            int screenWidth = AdUIUtils.getScreenWidth(context);
            int i3 = AreaConst.MARGIN_RIGHT;
            int i16 = AreaConst.MARGIN_LEFT;
            int i17 = (screenWidth - i3) - i16;
            int dp2px = AdUIUtils.dp2px(12.0f, context.getResources());
            int dp2px2 = AdUIUtils.dp2px(7.0f, context.getResources());
            int i18 = i17 - (dp2px * 2);
            int i19 = (int) (i18 * 0.75f);
            GdtCarouselCardView.Params params = new GdtCarouselCardView.Params();
            params.weakContext = new WeakReference<>(context);
            params.cardWidthPx = i18;
            params.cardHeightPx = i19;
            params.weakOnActionListener = new WeakReference<>(this.f404420h);
            params.weakAdapterForPlayer = new WeakReference<>(this);
            List<GdtCarouselCardData> C = C();
            params.dataList = C;
            if (C == null || C.isEmpty()) {
                return null;
            }
            this.H = params.dataList.size();
            TGCarouselCardLayoutManagerParams tGCarouselCardLayoutManagerParams = new TGCarouselCardLayoutManagerParams();
            tGCarouselCardLayoutManagerParams.maxVisibleItemCount = 4;
            tGCarouselCardLayoutManagerParams.scrollThreshold = 0.6f;
            tGCarouselCardLayoutManagerParams.horizontalOffsetPx = dp2px;
            tGCarouselCardLayoutManagerParams.verticalOffsetPx = dp2px2;
            tGCarouselCardLayoutManagerParams.canScrollOverStartPosition = false;
            int max = Math.max(0, businessFeedData.getAdData().getCarouselCardFirstVisibleItemPosition());
            if (max < params.dataList.size()) {
                tGCarouselCardLayoutManagerParams.startPosition = max;
                businessFeedData.getAdData().setCarouselCardFirstVisibleItemPosition(max);
                businessFeedData.getAdData().setCarouselCardClickedOrManuallyScrolledItemPosition(max);
                this.G = max;
            }
            params.layoutManagerParams = tGCarouselCardLayoutManagerParams;
            GdtCarouselCardView build = GdtCarouselCardView.build(params);
            if (build == null) {
                return null;
            }
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(i17, i19);
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = AdUIUtils.dp2px(10.0f, context.getResources());
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i16;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i3;
            build.setLayoutParams(layoutParams);
            build.setClipToOutline(true);
            this.f404419f = build;
            GdtLog.i("GdtCarouselCardSection", "[obtainViews] end " + this.feedPosition);
            return build;
        }
        GdtLog.i("GdtCarouselCardSection", "[obtainViews] error " + this.feedPosition);
        return null;
    }

    @Override // h6.a
    public void onPause() {
        if (this.D != null && BaseVideoManager.getFeedVideoManager().u(this.D)) {
            this.F.clear();
            BaseVideoManager.getFeedVideoManager().onListIdleSingleVideo(this.F);
        }
        super.onPause();
    }

    @Override // com.tencent.gdtad.views.carousel.GdtCarouselCardView.IAdapterForViews
    public void recycleVideoView() {
        FeedAutoVideo feedAutoVideo = this.D;
        if (feedAutoVideo == null) {
            return;
        }
        feedAutoVideo.onRecycled();
        this.D = null;
    }

    @Override // com.tencent.gdtad.views.carousel.GdtCarouselCardView.IAdapterForViews
    public void updateImageDrawable(ImageView imageView, int i3, int i16, int i17) {
        GdtAdFeedUtil.CarouselCardInfo carouselCardInfoForPosition;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (imageView == null || businessFeedData == null || !businessFeedData.isGDTAdvFeed() || (carouselCardInfoForPosition = GdtAdFeedUtil.getCarouselCardInfoForPosition(businessFeedData, i3)) == null || TextUtils.isEmpty(carouselCardInfoForPosition.imageUrl)) {
            return;
        }
        imageView.setImageDrawable(URLDrawable.getDrawable(carouselCardInfoForPosition.imageUrl, (URLDrawable.URLDrawableOptions) null));
    }

    @Override // h6.a, com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.f404420h = null;
        this.f404421i = null;
        this.C = null;
        this.f404422m = null;
        this.f404419f = null;
        this.F.clear();
        FeedAutoVideo feedAutoVideo = this.D;
        if (feedAutoVideo != null) {
            feedAutoVideo.onRecycled();
            this.D = null;
        }
        super.onRecycled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(VideoPlayInfo videoPlayInfo) {
        if (videoPlayInfo == null) {
            return;
        }
        GdtLog.i("GdtCarouselCardSection", "[resetVideoPlayInfo]");
        videoPlayInfo.isFeedFirstComplete = false;
        videoPlayInfo.isNotRecordProgress = true;
        VideoPlayInfoHolder videoProgressRecord = AutoVideoProgressRecorder.getInstance().getVideoProgressRecord(videoPlayInfo.videoId);
        videoPlayInfo.videoPlayInfoHolder = videoProgressRecord;
        if (videoProgressRecord == null) {
            videoPlayInfo.videoPlayInfoHolder = new VideoPlayInfoHolder();
        }
        VideoPlayInfoHolder videoPlayInfoHolder = videoPlayInfo.videoPlayInfoHolder;
        videoPlayInfoHolder.currentPositionMills = 0L;
        videoPlayInfoHolder.currentPositionSec = 0L;
        videoPlayInfoHolder.isNeverPlayed = true;
        AutoVideoProgressRecorder.getInstance().putVideoProgerssRecord(videoPlayInfo.videoId, videoPlayInfo.videoPlayInfoHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D(BusinessFeedData businessFeedData, int i3) {
        List<GdtAdFeedUtil.CarouselCardInfo> carouselCardInfoList;
        if (businessFeedData == null || (carouselCardInfoList = businessFeedData.getAdData().getCarouselCardInfoList()) == null || carouselCardInfoList.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return i3 % carouselCardInfoList.size();
    }
}
