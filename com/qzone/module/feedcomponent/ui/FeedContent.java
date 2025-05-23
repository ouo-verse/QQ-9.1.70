package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qzone.adapter.feedcomponent.FakeShuoShuoDataCacheHelper;
import com.qzone.canvasui.widget.shake.GdtShakeLayoutForQzone;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.feed.gift.util.FeedGiftUtil;
import com.qzone.feed.gift.widget.FeedGiftLayout;
import com.qzone.feed.panorama.PanoramaLayout;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasLeftThumbView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasMakeDynamicView;
import com.qzone.personalize.model.CustomHighFiveData;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.ViewSectionType;
import com.qzone.proxy.feedcomponent.model.AudioInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAlbumEntrance;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellQbossPsvAdv;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.widget.AudioMediaPlayer;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.widget.particle.ParticleTextSurfaceView;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.RawImageProcessor;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.gdtad.views.shake.GdtShakeSensor;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import cooperation.qzone.panorama.callback.OnPanoramaClickListener;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedContent extends FeedViewSection implements View.OnClickListener {
    protected static final int LEFT_THUMB_TITLE_DEFAULT_MAX_LINE = 1;
    protected static final int LEFT_THUMB_TITLE_MAX_LINE = 3;
    protected static final int MULTI_PIC_MAX_DISPLAY_NUM = 9;
    public static final float SINGLE_SMALL_PHOTO_MAX_SCALE = 2.0f;
    public static final float SINGLE_SMALL_PHOTO_MAX_WIDTH_PERCENT = 0.5f;
    public static final float SINGLE_SMALL_PHOTO_MIN_DPI = 163.80933f;
    protected static final int SUMMMARY_DEFAULT_MAX_LINE = 5;
    static final String TAG = "FeedContent";
    static float density;
    static int screenWidth;
    protected int SINGLE_SMALL_PHOTO_MAX_HEIGHT;
    protected int SINGLE_SMALL_PHOTO_MAX_WIDTH;
    ArrayList<AudioInfo> audioInfos;
    protected String cellId;
    String clientKey;
    private boolean hasMultiPicVideo;
    protected ImageProcessorSupplier imageProcessorSupplier;
    protected int imageRightMargin;
    protected boolean isBizRecomFeeds;
    protected boolean isForward;
    protected boolean isMoodList;
    protected boolean isPassive;
    protected boolean isShowFowardIcon;
    protected FeedPictureInfo leftThumbPictureInfo;
    protected AudioFeedBubble mAudioBubble;
    protected FeedVideoView mAutoVideo;
    protected CanvasFeedContentView mCanvasFeedContentView;
    protected CanvasMakeDynamicView mCanvasMakeDynamicView;
    protected ParticleTextSurfaceView mContentParticleTextView;
    protected FeedVideoView mContentViewVideo;
    protected RelativeLayout mFeedContentContainer;
    protected FeedGiftLayout mFeedGiftLayout;
    protected FeedPicTextCardNewView mFeedPicTextCardNewView;
    private GdtShakeLayoutForQzone mGdtShakeLayout;
    protected CellTextView mHighFiveSummaryView;
    protected CellLeftThumb mLeftThumb;
    protected CanvasLeftThumbView mLeftThumbView;
    private Handler mMainHandler;
    protected PanoramaLayout mPanoramaView;
    protected QbossPsvAdvView mQbossPsvAdvView;
    int marginTop;
    protected int maxLines;
    protected int paddingBottom;
    protected int photoMode;
    FeedPictureInfo[] pictureInfos;
    protected int smallImageLeftMargin;
    protected int smallImageRightMargin;
    protected String state;
    VideoInfo videoInfo;
    public static FeedViewSection.SectionController FeedContentController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedContent.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            if (businessFeedData == null) {
                return true;
            }
            if (businessFeedData.isGDTAdvFeed()) {
                return !GdtAdFeedUtil.isSectionVisible(businessFeedData, ViewSectionType.CONTENT_FEED);
            }
            return false;
        }
    };
    protected static final int MARGIN_RIGHT = com.qzone.adapter.feedcomponent.j.f(275);
    protected static final int MAX_LINE = com.qzone.adapter.feedcomponent.j.i(820);
    protected static final int MARGIN_TOP = (int) com.qzone.adapter.feedcomponent.j.e(277);
    static final int TITLE_BAR_HEIGHT = com.qzone.adapter.feedcomponent.j.f(288);

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class FeedImageTagData {
        public FeedPictureInfo pictureInfo;
        public int position;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface ImageProcessorSupplier {
        ImageProcessor supplyMulti(com.qzone.adapter.feedcomponent.a aVar, FeedPictureInfo feedPictureInfo, int i3, int i16);

        RawImageProcessor supplyMultiRaw(com.qzone.adapter.feedcomponent.a aVar, FeedPictureInfo feedPictureInfo, int i3, int i16);

        ImageProcessor supplySingle(com.qzone.adapter.feedcomponent.a aVar, FeedPictureInfo feedPictureInfo, int i3, int i16);

        RawImageProcessor supplySingleRaw(com.qzone.adapter.feedcomponent.a aVar, FeedPictureInfo feedPictureInfo, int i3, int i16);
    }

    public FeedContent(Context context, FeedView feedView) {
        super(context, feedView);
        this.SINGLE_SMALL_PHOTO_MAX_WIDTH = 200;
        this.SINGLE_SMALL_PHOTO_MAX_HEIGHT = 200;
        this.cellId = "";
        this.hasMultiPicVideo = false;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        init();
    }

    public static boolean isGoldenCudgel(int i3, int i16) {
        return com.qzone.proxy.feedcomponent.util.g.c(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShakeInvalid() {
        return !ih.j.k(this.mFeedData) || this.onFeedElementClickListener == null || this.mGdtShakeLayout == null || MobileQQ.sMobileQQ.getResumeActivity() == null;
    }

    private boolean needTailShowInForwardArea() {
        BusinessFeedData businessFeedData = this.mFeedData;
        return (businessFeedData == null || businessFeedData.getOriginalInfo() == null || this.mFeedData.getOriginalInfo().getCellSummaryV2() == null || TextUtils.isEmpty(this.mFeedData.getOriginalInfo().getCellSummaryV2().summary)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnUiThread(Runnable runnable) {
        FeedGlobalEnv.g().postRunnableToUIThread(runnable);
    }

    public static void setAudioBubbleState(AudioFeedBubble audioFeedBubble) {
        if (AudioMediaPlayer.a().c() != null && audioFeedBubble.getSaveDir().equals(AudioMediaPlayer.a().b())) {
            if (AudioMediaPlayer.f50916k == 1) {
                audioFeedBubble.setCurrentState(1);
                return;
            } else {
                audioFeedBubble.setCurrentState(0);
                return;
            }
        }
        audioFeedBubble.setCurrentState(0);
    }

    private void setHighFiveData(BusinessFeedData businessFeedData) {
        if (this.mHighFiveSummaryView == null) {
            return;
        }
        if (businessFeedData != null && businessFeedData.feedType == 4098 && businessFeedData.hasHighFive && businessFeedData.getUser() != null) {
            this.mHighFiveSummaryView.setVisibility(0);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(com.qzone.adapter.feedcomponent.i.H().k0());
            sb5.append(MsgSummary.STR_COLON);
            String str = businessFeedData.getUser().nickName;
            String c16 = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "highFiveSummary", "\u5411{nickname}\u51fb\u638c\u4e86");
            if (!TextUtils.isEmpty(c16) && c16.contains("{nickname}") && str != null) {
                c16 = c16.replace("{nickname}", str);
            }
            CustomHighFiveData e16 = com.qzone.personalize.business.b.n().e(com.qzone.adapter.feedcomponent.i.H().j0());
            if (e16 != null && !TextUtils.isEmpty(e16.strHighFiveText)) {
                c16 = e16.strHighFiveText + c16;
            }
            sb5.append(c16);
            this.mHighFiveSummaryView.setRichText(sb5.toString(), false);
            this.mHighFiveSummaryView.setTextSize(1, 14.0f);
            return;
        }
        this.mHighFiveSummaryView.setVisibility(8);
    }

    private void setMakeDynamicData() {
        CellAlbumEntrance cellAlbumEntrance;
        CellAlbumEntrance cellAlbumEntrance2;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null) {
            com.qzone.proxy.feedcomponent.b.i(TAG, "setMakeDynamicData, mFeedData is null ");
            return;
        }
        CellAlbumEntrance cellAlbumEntrance3 = businessFeedData.cellAlbumEntrance;
        if (cellAlbumEntrance3 != null && cellAlbumEntrance3.iAttr == 2) {
            handleQCircleEntrance();
            return;
        }
        if (com.qzone.feed.utils.c.d() == 0 && ((cellAlbumEntrance2 = this.mFeedData.cellAlbumEntrance) == null || cellAlbumEntrance2.iAttr == 0)) {
            FeedViewSection.setVisibility(8, this.mCanvasMakeDynamicView);
            return;
        }
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2.feedType != 4099 && (cellAlbumEntrance = businessFeedData2.cellAlbumEntrance) != null && !TextUtils.isEmpty(cellAlbumEntrance.guideTitle)) {
            FeedViewSection.setVisibility(0, this.mCanvasMakeDynamicView);
            CanvasMakeDynamicView canvasMakeDynamicView = this.mCanvasMakeDynamicView;
            if (canvasMakeDynamicView != null) {
                canvasMakeDynamicView.setFeedData(this.mFeedData);
                return;
            }
            return;
        }
        FeedViewSection.setVisibility(8, this.mCanvasMakeDynamicView);
    }

    private void showGdtShakeView() {
        if (this.mGdtShakeLayout == null) {
            return;
        }
        if (!ih.j.k(this.mFeedData)) {
            FeedViewSection.setViewGone(this.mGdtShakeLayout);
            return;
        }
        boolean isVerticalVideo = GdtAdFeedUtil.isVerticalVideo(this.mFeedData);
        int i3 = AreaConst.dp50;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(isVerticalVideo ? com.qzone.proxy.feedcomponent.util.g.a(181.0f) : -1, i3);
        layoutParams.gravity = 80;
        layoutParams.leftMargin = AreaConst.MARGIN_LEFT;
        layoutParams.rightMargin = AreaConst.MARGIN_RIGHT;
        layoutParams.topMargin = -i3;
        this.mGdtShakeLayout.setLayoutParams(layoutParams);
        GdtShakeSensor.OnShakeListener onShakeListener = new GdtShakeSensor.OnShakeListener() { // from class: com.qzone.module.feedcomponent.ui.FeedContent.3
            @Override // com.tencent.gdtad.views.shake.GdtShakeSensor.OnShakeListener
            public void onShakeComplete() {
                if (FeedContent.this.isShakeInvalid()) {
                    if (FeedContent.this.mGdtShakeLayout != null) {
                        FeedContent.this.mGdtShakeLayout.resetShakeSensor();
                        return;
                    }
                    return;
                }
                int[] iArr = new int[2];
                FeedContent.this.mGdtShakeLayout.getLocationOnScreen(iArr);
                if (iArr[1] >= GdtFeedUtilForQZone.m() && QZoneAdFeedUtils.A(MobileQQ.sMobileQQ.getResumeActivity()) >= iArr[1] + FeedContent.this.mGdtShakeLayout.getHeight() && FeedContent.this.mGdtShakeLayout.hasWindowFocus()) {
                    FeedContent feedContent = FeedContent.this;
                    feedContent.onFeedElementClickListener.onClick(feedContent.mGdtShakeLayout, FeedElement.GDT_ACTION_SHAKE, FeedContent.this.feedPosition, null);
                } else {
                    FeedContent.this.mGdtShakeLayout.resetShakeSensor();
                }
            }
        };
        this.mGdtShakeLayout.setTag(onShakeListener);
        this.mGdtShakeLayout.init(ih.j.c(this.mFeedData));
        this.mGdtShakeLayout.setShakeListener(new WeakReference<>(onShakeListener));
        this.mGdtShakeLayout.start();
        FeedViewSection.setViewVisbile(this.mGdtShakeLayout);
    }

    private void showPanoramaView(FeedPictureInfo feedPictureInfo) {
        int i3 = AreaConst.dp10;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.isGDTAdvFeed()) {
            i3 = AreaConst.dp8;
        }
        ViewGroup.LayoutParams layoutParams = this.mPanoramaView.getLayoutParams();
        int i16 = screenWidth;
        if (i16 == 0) {
            i16 = FeedGlobalEnv.g().getScreenWidth();
        }
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 != null && businessFeedData2.feedType == 12290) {
            i3 = AreaManager.EXTEND_FEED_HORIZONTAL_INTERVAL;
        }
        int i17 = 2;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (com.qzone.adapter.feedcomponent.i.H().W() == 1) {
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.rightMargin = 0;
                marginLayoutParams.width = i16;
                marginLayoutParams.height = (int) ((i16 * 9) / 16.0f);
            } else {
                marginLayoutParams.leftMargin = i3;
                marginLayoutParams.rightMargin = i3;
                marginLayoutParams.width = i16 - (i3 * 2);
                marginLayoutParams.height = (int) ((r2 * 9) / 16.0f);
            }
            this.mPanoramaView.setLayoutParams(marginLayoutParams);
        } else if (layoutParams != null) {
            layoutParams.width = i16 - (i3 * 2);
            layoutParams.height = (int) ((r2 * 9) / 16.0f);
            this.mPanoramaView.setLayoutParams(layoutParams);
        }
        String str = feedPictureInfo.a() != null ? feedPictureInfo.a().url : null;
        String str2 = feedPictureInfo.h() != null ? feedPictureInfo.h().url : null;
        if (this.mPanoramaView.E()) {
            this.mPanoramaView.K();
            this.mPanoramaView.x(str);
            return;
        }
        int i18 = feedPictureInfo.d() == FeedPictureInfo.ImageType.CIRCLE_PANORAMA ? 2 : 0;
        BusinessFeedData businessFeedData3 = this.mFeedData;
        if (businessFeedData3 != null && businessFeedData3.feedType == 2) {
            i17 = 3;
        }
        PanoramaConfig.Builder panoramaType = new PanoramaConfig.Builder(i18).setShowType(1).setRenderMode(0).setOpenGyroscopeSensor(true).setOpenTouchMove(true).setShowLoadingProgress(true).setShowGuideAnimate(true).setShowPanoramaBall(true).setThumbUrl(str).setSmallUrl(str2).setPanoramaType(i17);
        this.mPanoramaView.setOnPanoramaListener(new OnPanoramaClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedContent.2
            @Override // cooperation.qzone.panorama.callback.OnPanoramaClickListener
            public void onPanoramaClick() {
                com.qzone.proxy.feedcomponent.ui.g gVar;
                FeedContent feedContent = FeedContent.this;
                PanoramaLayout panoramaLayout = feedContent.mPanoramaView;
                if (panoramaLayout == null || (gVar = feedContent.onFeedElementClickListener) == null) {
                    return;
                }
                FeedElement feedElement = FeedElement.PHOTO;
                int i19 = feedContent.feedPosition;
                gVar.onClick(panoramaLayout, feedElement, i19, new com.qzone.proxy.feedcomponent.model.f(i19, 0, feedContent.isShowFowardIcon));
            }
        });
        this.mPanoramaView.O(panoramaType);
    }

    private void updateFeedGiftLayout(FeedPictureInfo[] feedPictureInfoArr) {
        CellDecorateInfo cellDecorateInfo;
        CellDecorateInfo.CellGiftData cellGiftData;
        int i3;
        FeedGiftLayout feedGiftLayout = this.mFeedGiftLayout;
        if (feedGiftLayout == null || feedPictureInfoArr == null || feedPictureInfoArr.length == 0 || feedPictureInfoArr[0] == null) {
            return;
        }
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && (cellDecorateInfo = businessFeedData.cellDecorateInfo) != null && (cellGiftData = cellDecorateInfo.cellGiftData) != null && ((i3 = cellGiftData.iType) == 1 || i3 == 2)) {
            if (feedPictureInfoArr.length == 1 && FeedGiftUtil.c()) {
                FeedViewSection.setVisibility(0, this.mFeedGiftLayout);
                this.mFeedGiftLayout.s(this.mFeedData);
                return;
            } else {
                FeedViewSection.setVisibility(8, this.mFeedGiftLayout);
                return;
            }
        }
        FeedViewSection.setVisibility(8, feedGiftLayout);
    }

    public BusinessFeedData getBusinessFeedData() {
        return this.mFeedData;
    }

    protected String getContentContainerJson() {
        return "qzone_canvas_ui_feed_content_container.json";
    }

    public CanvasFeedContentView getContentView() {
        return this.mCanvasFeedContentView;
    }

    public int getFeedContentBottom() {
        CanvasFeedContentView canvasFeedContentView = this.mCanvasFeedContentView;
        if (canvasFeedContentView != null) {
            return canvasFeedContentView.getBottom();
        }
        return 0;
    }

    public RelativeLayout getFeedContentContainer() {
        return this.mFeedContentContainer;
    }

    public FeedVideoView getFeedContentVideo() {
        return this.mContentViewVideo;
    }

    public FeedGiftLayout getFeedGiftView() {
        return this.mFeedGiftLayout;
    }

    public ImageProcessorSupplier getImageProcessorSupplier() {
        return this.imageProcessorSupplier;
    }

    protected int getLeftMargin() {
        return this.smallImageLeftMargin;
    }

    public PanoramaLayout getPanoramaView() {
        return this.mPanoramaView;
    }

    protected int getRightMargin() {
        return this.smallImageRightMargin;
    }

    public FeedVideoView getVideoView() {
        return this.mAutoVideo;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public boolean haveMultipleViews() {
        return true;
    }

    protected void init() {
        density = FeedGlobalEnv.g().getDensity();
        screenWidth = FeedGlobalEnv.g().getScreenWidth();
        this.smallImageLeftMargin = com.qzone.adapter.feedcomponent.j.f(274);
        this.smallImageRightMargin = com.qzone.adapter.feedcomponent.j.f(275);
        this.imageRightMargin = (int) (density * 2.0f);
        this.marginTop = MARGIN_TOP;
    }

    public boolean isMoodList() {
        return this.isMoodList;
    }

    public boolean isMultiPicVideoFeed() {
        return this.hasMultiPicVideo;
    }

    public boolean isPlayOnWifi() {
        FeedVideoView feedVideoView = this.mAutoVideo;
        if (feedVideoView == null || feedVideoView.getAutoVideoView() == null || this.mAutoVideo.getAutoVideoView().mVideoCover == null) {
            return false;
        }
        return this.mAutoVideo.getAutoVideoView().mVideoCover.isShowStoreIcon();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public List<View> obtainViews() {
        String str;
        ArrayList arrayList = new ArrayList();
        setPhotoMode(com.qzone.adapter.feedcomponent.i.H().W());
        if (this.mFeedContentContainer == null) {
            RelativeLayout relativeLayout = (RelativeLayout) DittoUIEngine.g().inflateView(getContext(), getContentContainerJson(), (ViewGroup) null);
            this.mFeedContentContainer = relativeLayout;
            CanvasFeedContentView canvasFeedContentView = (CanvasFeedContentView) relativeLayout.findViewById(com.qzone.adapter.feedcomponent.j.O(2794));
            this.mCanvasFeedContentView = canvasFeedContentView;
            canvasFeedContentView.setIsForward(this.isForward);
            FeedViewSection.FeedViewOptions feedViewOptions = this.mOptions;
            boolean z16 = feedViewOptions != null ? feedViewOptions.isDetail : false;
            this.mCanvasFeedContentView.setIsDetail(z16);
            if (!z16) {
                this.mContentViewVideo = (FeedVideoView) this.mFeedContentContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(JsonGrayBusiId.QWALLET_GRAY_TIP_ID));
            }
            ParticleTextSurfaceView particleTextSurfaceView = (ParticleTextSurfaceView) this.mFeedContentContainer.findViewById(com.qzone.adapter.feedcomponent.j.O(2814));
            this.mContentParticleTextView = particleTextSurfaceView;
            this.mCanvasFeedContentView.setParticletextView(particleTextSurfaceView);
            this.mContentParticleTextView.bringToFront();
            this.mContentParticleTextView.setVisibility(8);
            this.mAudioBubble = (AudioFeedBubble) generateView(AudioFeedBubble.class, Integer.MIN_VALUE);
            FeedVideoView feedVideoView = (FeedVideoView) generateView(FeedVideoView.class, Integer.MIN_VALUE);
            this.mAutoVideo = feedVideoView;
            DittoUIEngine g16 = DittoUIEngine.g();
            if (!this.isForward) {
                str = "@id/feed_auto_video";
            } else {
                str = "@id/feed_content_video_stub_forward";
            }
            feedVideoView.setId(g16.getResourceId(str));
            this.mAutoVideo.setIsForward(this.isForward);
            CanvasLeftThumbView canvasLeftThumbView = (CanvasLeftThumbView) generateView(CanvasLeftThumbView.class, Integer.MIN_VALUE);
            this.mLeftThumbView = canvasLeftThumbView;
            canvasLeftThumbView.setLayoutParams(generateLayoutParams());
            PanoramaLayout panoramaLayout = new PanoramaLayout(getContext());
            this.mPanoramaView = panoramaLayout;
            panoramaLayout.setLayoutParams(generateLayoutParams());
            FeedGiftLayout feedGiftLayout = new FeedGiftLayout(getContext());
            this.mFeedGiftLayout = feedGiftLayout;
            feedGiftLayout.setLayoutParams(generateLayoutParams());
            if (!this.isForward) {
                this.mQbossPsvAdvView = new QbossPsvAdvView(getContext(), null);
                this.mCanvasMakeDynamicView = new CanvasMakeDynamicView(getContext(), null);
                CellTextView cellTextView = new CellTextView(getContext());
                this.mHighFiveSummaryView = cellTextView;
                cellTextView.setLayoutParams(generateLayoutParams());
            }
            FeedPicTextCardNewView feedPicTextCardNewView = new FeedPicTextCardNewView(getContext());
            this.mFeedPicTextCardNewView = feedPicTextCardNewView;
            feedPicTextCardNewView.setIsForward(this.isForward);
        }
        arrayList.add(this.mFeedContentContainer);
        arrayList.add(this.mAudioBubble);
        arrayList.add(this.mAutoVideo);
        arrayList.add(this.mLeftThumbView);
        arrayList.add(this.mFeedPicTextCardNewView);
        QbossPsvAdvView qbossPsvAdvView = this.mQbossPsvAdvView;
        if (qbossPsvAdvView != null) {
            arrayList.add(qbossPsvAdvView);
        }
        CanvasMakeDynamicView canvasMakeDynamicView = this.mCanvasMakeDynamicView;
        if (canvasMakeDynamicView != null) {
            arrayList.add(canvasMakeDynamicView);
        }
        FeedPicTextCardNewView feedPicTextCardNewView2 = this.mFeedPicTextCardNewView;
        if (feedPicTextCardNewView2 != null) {
            arrayList.add(feedPicTextCardNewView2);
        }
        arrayList.add(this.mPanoramaView);
        arrayList.add(this.mFeedGiftLayout);
        CellTextView cellTextView2 = this.mHighFiveSummaryView;
        if (cellTextView2 != null) {
            arrayList.add(cellTextView2);
        }
        if (!this.isForward && ih.j.k(this.mFeedData)) {
            if (this.mGdtShakeLayout == null) {
                this.mGdtShakeLayout = new GdtShakeLayoutForQzone(getContext());
            }
            arrayList.add(this.mGdtShakeLayout);
        }
        return arrayList;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onApplyFeedData() {
        String valueOf;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData.feedType == 4098) {
            int W = com.qzone.adapter.feedcomponent.i.H().W();
            int i3 = businessFeedData.getFeedCommInfo().actiontype;
            if (i3 == 0) {
                valueOf = String.valueOf(businessFeedData.getIdInfo().cellId);
            } else if (i3 != 1) {
                valueOf = "";
            } else {
                valueOf = businessFeedData.getOriginalInfo() == null ? null : businessFeedData.getOriginalInfo().getIdInfo().cellId;
            }
            if (this.isForward) {
                MyFeedViewBuilder.setSourceContentArea(businessFeedData, this, W);
                return;
            } else {
                MyFeedViewBuilder.setContentArea(businessFeedData, this, W, valueOf);
                return;
            }
        }
        if (this.isForward && ((!businessFeedData.isQCircleRecommFeed() && !businessFeedData.isQCircleShareCardFeed()) || (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getCellSummaryV2() == null))) {
            businessFeedData = businessFeedData.getOriginalInfo();
        }
        FeedPictureInfo[] u16 = com.qzone.adapter.feedcomponent.d.u(businessFeedData, this.photoMode);
        if (!businessFeedData.getFeedCommInfo().isPicUpLayout()) {
            setPictureInfos(u16);
        }
        CellLeftThumb leftThumb = businessFeedData.getLeftThumb();
        if (leftThumb != null && !businessFeedData.isQzoneCardFeed() && !businessFeedData.isCampusHomeShareFeed()) {
            setLeftThumbData(leftThumb);
            setLeftThumbPictureInfo(leftThumb.getPictureInfo());
        }
        setAudioInfo(businessFeedData.getAudioInfo());
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (businessFeedData.getFeedCommInfo().appid == 2 && videoInfo != null && videoInfo.videoTime < 1000) {
            videoInfo.videoTime = 1000L;
        }
        setVideoInfo(businessFeedData.getFeedCommInfo().clientkey, videoInfo);
        setCellId(businessFeedData.getIdInfo().cellId);
        onUpdate();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FeedImageTagData feedImageTagData;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.onFeedElementClickListener != null && (feedImageTagData = (FeedImageTagData) view.getTag()) != null) {
            com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
            FeedElement feedElement = FeedElement.PHOTO;
            int i3 = this.feedPosition;
            gVar.onClick(view, feedElement, i3, new com.qzone.proxy.feedcomponent.model.f(i3, feedImageTagData.position, this.isShowFowardIcon));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onInsertedIntoView() {
        super.onInsertedIntoView();
        FeedGiftLayout feedGiftLayout = this.mFeedGiftLayout;
        if (feedGiftLayout != null) {
            feedGiftLayout.n();
        }
    }

    public void onPause() {
        CanvasFeedContentView canvasFeedContentView = this.mCanvasFeedContentView;
        if (canvasFeedContentView != null) {
            canvasFeedContentView.onPause();
        }
        FeedVideoView feedVideoView = this.mAutoVideo;
        if (feedVideoView != null) {
            feedVideoView.onPause();
        }
        FeedVideoView feedVideoView2 = this.mContentViewVideo;
        if (feedVideoView2 != null) {
            feedVideoView2.onPause();
        }
        PanoramaLayout panoramaLayout = this.mPanoramaView;
        if (panoramaLayout != null) {
            panoramaLayout.I();
        }
        FeedGiftLayout feedGiftLayout = this.mFeedGiftLayout;
        if (feedGiftLayout != null) {
            feedGiftLayout.o();
        }
        GdtShakeLayoutForQzone gdtShakeLayoutForQzone = this.mGdtShakeLayout;
        if (gdtShakeLayoutForQzone != null) {
            gdtShakeLayoutForQzone.stop();
        }
    }

    public void onRecycled(boolean z16) {
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2;
        this.mLeftThumb = null;
        CanvasFeedContentView canvasFeedContentView = this.mCanvasFeedContentView;
        if (canvasFeedContentView != null) {
            canvasFeedContentView.onRecycled();
        }
        CanvasLeftThumbView canvasLeftThumbView = this.mLeftThumbView;
        if (canvasLeftThumbView != null) {
            canvasLeftThumbView.onRecycled();
        }
        QbossPsvAdvView qbossPsvAdvView = this.mQbossPsvAdvView;
        if (qbossPsvAdvView != null) {
            qbossPsvAdvView.onRecycled();
        }
        FeedVideoView feedVideoView = this.mAutoVideo;
        if (feedVideoView != null) {
            feedVideoView.onRecycled(z16);
        }
        FeedVideoView feedVideoView2 = this.mContentViewVideo;
        if (feedVideoView2 != null) {
            feedVideoView2.onRecycled(z16);
        }
        AudioFeedBubble audioFeedBubble = this.mAudioBubble;
        if (audioFeedBubble != null) {
            audioFeedBubble.onRecycled();
        }
        PanoramaLayout panoramaLayout = this.mPanoramaView;
        if (panoramaLayout != null && ((businessFeedData2 = this.mFeedData) == null || businessFeedData2.feedType != 2)) {
            panoramaLayout.J();
        }
        FeedGiftLayout feedGiftLayout = this.mFeedGiftLayout;
        if (feedGiftLayout != null && ((businessFeedData = this.mFeedData) == null || businessFeedData.feedType != 2)) {
            feedGiftLayout.p();
            this.mFeedGiftLayout.setVisibility(8);
        }
        GdtShakeLayoutForQzone gdtShakeLayoutForQzone = this.mGdtShakeLayout;
        if (gdtShakeLayoutForQzone != null) {
            gdtShakeLayoutForQzone.recycle();
            this.mGdtShakeLayout.setTag(null);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateIdle() {
        CanvasFeedContentView canvasFeedContentView = this.mCanvasFeedContentView;
        if (canvasFeedContentView != null) {
            canvasFeedContentView.onStateIdle();
        }
        QbossPsvAdvView qbossPsvAdvView = this.mQbossPsvAdvView;
        if (qbossPsvAdvView != null) {
            qbossPsvAdvView.onStateIdle();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateScrolling() {
        CanvasFeedContentView canvasFeedContentView = this.mCanvasFeedContentView;
        if (canvasFeedContentView != null) {
            canvasFeedContentView.onStateScrolling();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onUpdate() {
        CanvasFeedContentView canvasFeedContentView;
        QbossPsvAdvView qbossPsvAdvView;
        CanvasFeedContentView canvasFeedContentView2;
        CellLeftThumb cellLeftThumb;
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2;
        CellAlbumEntrance cellAlbumEntrance;
        BusinessFeedData businessFeedData3 = this.mFeedData;
        boolean z16 = (businessFeedData3 == null || (businessFeedData3.getFeedCommInfo().feedsAttr & 3072) == 0) ? false : true;
        BusinessFeedData businessFeedData4 = this.mFeedData;
        boolean z17 = businessFeedData4 != null && businessFeedData4.isHandBlog();
        if (!z16 && !z17) {
            FeedViewSection.setViewVisbile(this.mCanvasFeedContentView);
            FeedViewSection.setViewVisbile(this.mFeedContentContainer);
        } else {
            FeedViewSection.setViewGone(this.mCanvasFeedContentView);
            FeedViewSection.setViewGone(this.mFeedContentContainer);
            FeedViewSection.setViewGone(this.mContentViewVideo);
        }
        FeedViewSection.setViewGone(this.mContentParticleTextView);
        CanvasFeedContentView canvasFeedContentView3 = this.mCanvasFeedContentView;
        if (canvasFeedContentView3 != null) {
            canvasFeedContentView3.clearParticleFlag();
        }
        if (this.mFeedContentContainer != null) {
            BusinessFeedData businessFeedData5 = this.mFeedData;
            if (businessFeedData5 != null && businessFeedData5.isFriendPlayingFeed()) {
                this.mFeedContentContainer.setPadding(0, 0, 0, 0);
            } else {
                BusinessFeedData businessFeedData6 = this.mFeedData;
                if (businessFeedData6 != null && !businessFeedData6.isAdFeeds()) {
                    BusinessFeedData businessFeedData7 = this.mFeedData;
                    if (!businessFeedData7.isSubFeed && (businessFeedData7.getUser() == null || this.mFeedData.getUser().uin <= 0)) {
                        this.mFeedContentContainer.setPadding(0, AreaConst.dp10, 0, 0);
                    }
                }
                BusinessFeedData businessFeedData8 = this.mFeedData;
                if (businessFeedData8 != null && businessFeedData8.isForwardFeed() && !this.mFeedData.needShowForwardTitle() && !this.mFeedData.isPublicAccountShare() && !this.mFeedData.isQCircleShareCardFeed() && !this.mFeedData.isQCircleRecommFeed()) {
                    this.mFeedContentContainer.setPadding(0, 0, 0, AreaConst.dp6);
                } else {
                    this.mFeedContentContainer.setPadding(0, 0, 0, 0);
                }
                BusinessFeedData businessFeedData9 = this.mFeedData;
                if (businessFeedData9 != null && (cellAlbumEntrance = businessFeedData9.cellAlbumEntrance) != null && cellAlbumEntrance.iAttr == 1) {
                    this.mFeedContentContainer.setPadding(0, 0, 0, 0);
                }
            }
        }
        if (!z16 && !z17) {
            int contentViewVideoIndex = getContentViewVideoIndex(this.mFeedData, this.pictureInfos);
            CanvasFeedContentView canvasFeedContentView4 = this.mCanvasFeedContentView;
            if (canvasFeedContentView4 != null) {
                canvasFeedContentView4.setMultiPicAreaVideo(contentViewVideoIndex, this.mContentViewVideo);
                this.mCanvasFeedContentView.setContentInfo(this.mFeedData, this.pictureInfos, this.photoMode, this.isPassive, this.videoInfo != null);
                setContentViewVideo(this.pictureInfos, contentViewVideoIndex);
                CanvasFeedContentView canvasFeedContentView5 = this.mCanvasFeedContentView;
                if (canvasFeedContentView5.isForward) {
                    if (canvasFeedContentView5.isAreaEmpty()) {
                        if (this.mCanvasFeedContentView.getVisibility() != 8) {
                            this.mCanvasFeedContentView.setVisibility(8);
                            this.mCanvasFeedContentView.clearParticleFlag();
                            FeedViewSection.setViewGone(this.mFeedContentContainer);
                            FeedViewSection.setViewGone(this.mContentViewVideo);
                        }
                    } else if (this.mCanvasFeedContentView.getVisibility() != 0) {
                        this.mCanvasFeedContentView.setVisibility(0);
                        FeedViewSection.setViewVisbile(this.mFeedContentContainer);
                    }
                }
            }
        }
        CanvasFeedContentView canvasFeedContentView6 = this.mCanvasFeedContentView;
        if (canvasFeedContentView6 != null && canvasFeedContentView6.isAreaEmpty()) {
            FeedViewSection.setViewGone(this.mFeedContentContainer);
        }
        BusinessFeedData businessFeedData10 = this.mFeedData;
        boolean z18 = businessFeedData10 != null && businessFeedData10.getFeedCommInfo().isBizRecomFamousFeeds() && this.mFeedData.isSubFeed;
        BusinessFeedData businessFeedData11 = this.mFeedData;
        boolean z19 = businessFeedData11 != null && businessFeedData11.isSubFeed && (businessFeedData2 = businessFeedData11.parentFeedData) != null && businessFeedData2.isFriendLikeContainer();
        BusinessFeedData businessFeedData12 = this.mFeedData;
        boolean z26 = businessFeedData12 != null && businessFeedData12.isPublicAccountContainer();
        BusinessFeedData businessFeedData13 = this.mFeedData;
        boolean z27 = businessFeedData13 != null && businessFeedData13.isRecommendQQCircleFeed();
        if (z19 || z18 || z26 || z27) {
            CanvasFeedContentView canvasFeedContentView7 = this.mCanvasFeedContentView;
            if (canvasFeedContentView7 != null) {
                canvasFeedContentView7.clearParticleFlag();
                this.mCanvasFeedContentView.setVisibility(8);
            }
            FeedViewSection.setViewGone(this.mFeedContentContainer);
            FeedViewSection.setViewGone(this.mContentViewVideo);
        }
        if (com.qzone.adapter.feedcomponent.i.H().S0() && this.mCanvasFeedContentView != null) {
            BusinessFeedData businessFeedData14 = this.mFeedData;
            if (businessFeedData14 != null && !TextUtils.isEmpty(businessFeedData14.feedContentReadstr)) {
                if (this.mFeedData.isForwardFeed()) {
                    BusinessFeedData originalInfoSafe = this.mFeedData.getOriginalInfoSafe();
                    CanvasFeedContentView canvasFeedContentView8 = this.mCanvasFeedContentView;
                    if (canvasFeedContentView8.isForward && originalInfoSafe != null) {
                        if (!originalInfoSafe.hasCalculate) {
                            com.qzone.adapter.feedcomponent.d.w(originalInfoSafe);
                        }
                        this.mCanvasFeedContentView.setFocusableInTouchMode(true);
                        this.mCanvasFeedContentView.setFocusable(true);
                        this.mCanvasFeedContentView.setContentDescription(originalInfoSafe.getUser().nickName + originalInfoSafe.feedContentReadstr);
                    } else {
                        canvasFeedContentView8.setFocusableInTouchMode(false);
                        this.mCanvasFeedContentView.setFocusable(false);
                        this.mCanvasFeedContentView.setContentDescription("");
                        this.mCanvasFeedContentView.setDesc(this.mFeedData.feedContentReadstr);
                    }
                } else {
                    this.mCanvasFeedContentView.setFocusableInTouchMode(false);
                    this.mCanvasFeedContentView.setFocusable(false);
                    this.mCanvasFeedContentView.setContentDescription(this.mFeedData.feedContentReadstr);
                    this.mCanvasFeedContentView.setDesc(this.mFeedData.feedContentReadstr);
                }
            }
            this.mCanvasFeedContentView.updateAccessibility();
        }
        BusinessFeedData businessFeedData15 = this.mFeedData;
        if (businessFeedData15 != null) {
            businessFeedData15.getFeedCommInfo().isBizRecomFeeds();
        }
        FeedPictureInfo[] feedPictureInfoArr = this.pictureInfos;
        updateAudioInfo(feedPictureInfoArr != null && feedPictureInfoArr.length > 0);
        updateVideoInfo(this.clientKey, this.videoInfo);
        updateTailInfo();
        updatePanoramaInfo(this.pictureInfos);
        updateFeedGiftLayout(this.pictureInfos);
        CanvasLeftThumbView canvasLeftThumbView = this.mLeftThumbView;
        if (canvasLeftThumbView != null && (cellLeftThumb = this.mLeftThumb) != null && (businessFeedData = this.mFeedData) != null) {
            canvasLeftThumbView.setFeedData(businessFeedData, cellLeftThumb, this.leftThumbPictureInfo);
            this.mLeftThumbView.setOnFeedElementClickListener(this.onFeedElementClickListener);
            FeedViewSection.setViewVisbile(this.mLeftThumbView);
        } else {
            FeedViewSection.setViewGone(canvasLeftThumbView);
        }
        if (!z16 && (canvasFeedContentView2 = this.mCanvasFeedContentView) != null) {
            canvasFeedContentView2.requestLayout();
        }
        BusinessFeedData businessFeedData16 = this.mFeedData;
        if (businessFeedData16 != null && businessFeedData16.isCellQbossPsvAdv() && (qbossPsvAdvView = this.mQbossPsvAdvView) != null) {
            qbossPsvAdvView.update();
            this.mQbossPsvAdvView.forceLayout();
            FeedViewSection.setViewVisbile(this.mQbossPsvAdvView);
        } else {
            FeedViewSection.setViewGone(this.mQbossPsvAdvView);
        }
        setHighFiveData(this.mFeedData);
        if (QZoneAdFeedDataExtKt.isGdt585AdVideo(this.mFeedData) && QZoneAdFeedDataExtKt.isGdt585ABTest(this.mFeedData) && (canvasFeedContentView = this.mCanvasFeedContentView) != null) {
            canvasFeedContentView.setVisibility(8);
        }
        setMakeDynamicData();
        showGdtShakeView();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setAlpha(int i3) {
        CanvasLeftThumbView canvasLeftThumbView = this.mLeftThumbView;
        if (canvasLeftThumbView != null) {
            canvasLeftThumbView.setAlpha(i3);
        }
        FeedVideoView feedVideoView = this.mAutoVideo;
        if (feedVideoView != null) {
            feedVideoView.setTrans(i3);
        }
        CanvasMakeDynamicView canvasMakeDynamicView = this.mCanvasMakeDynamicView;
        if (canvasMakeDynamicView != null) {
            canvasMakeDynamicView.setAlpha(i3);
        }
    }

    public void setAudioInfo(ArrayList<AudioInfo> arrayList) {
        this.audioInfos = arrayList;
    }

    public void setBusinessFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
        if (businessFeedData != null) {
            this.isBizRecomFeeds = businessFeedData.getFeedCommInfo().isBizRecomFeeds();
        }
    }

    public void setCellId(String str) {
        this.cellId = str;
    }

    protected void setContentViewVideo(FeedPictureInfo[] feedPictureInfoArr, int i3) {
        FeedPictureInfo feedPictureInfo;
        VideoInfo videoInfo;
        if (!isMultiPicVideoFeed() || feedPictureInfoArr == null || feedPictureInfoArr.length <= i3 || i3 < 0 || this.mCanvasFeedContentView == null || this.mContentViewVideo == null || (feedPictureInfo = feedPictureInfoArr[i3]) == null || feedPictureInfo.f50260w != 1 || (videoInfo = feedPictureInfo.f50261x) == null || !videoInfo.isAutoPlay()) {
            return;
        }
        this.mCanvasFeedContentView.setContentViewVideoMode();
        this.mContentViewVideo.setFeedData(this.mFeedData, feedPictureInfoArr[i3].f50261x);
        this.mCanvasFeedContentView.setMultiPicAreaVideoPos();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setFeedData(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
        super.setFeedData(businessFeedData, feedViewOptions);
        this.isBizRecomFeeds = businessFeedData.getFeedCommInfo().isBizRecomFeeds();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setFeedPosition(int i3) {
        super.setFeedPosition(i3);
        CanvasFeedContentView canvasFeedContentView = this.mCanvasFeedContentView;
        if (canvasFeedContentView != null) {
            canvasFeedContentView.setFeedPos(i3);
        }
        CanvasLeftThumbView canvasLeftThumbView = this.mLeftThumbView;
        if (canvasLeftThumbView != null) {
            canvasLeftThumbView.setFeedPosition(i3);
        }
        QbossPsvAdvView qbossPsvAdvView = this.mQbossPsvAdvView;
        if (qbossPsvAdvView != null) {
            qbossPsvAdvView.setFeedPos(i3);
        }
        FeedVideoView feedVideoView = this.mAutoVideo;
        if (feedVideoView != null) {
            feedVideoView.setFeedPos(i3, this.mRootView.mIndex);
        }
        FeedVideoView feedVideoView2 = this.mContentViewVideo;
        if (feedVideoView2 != null) {
            feedVideoView2.setFeedPos(i3, this.mRootView.mIndex);
        }
        PanoramaLayout panoramaLayout = this.mPanoramaView;
        if (panoramaLayout != null) {
            panoramaLayout.setFeedPosition(i3);
        }
        CanvasMakeDynamicView canvasMakeDynamicView = this.mCanvasMakeDynamicView;
        if (canvasMakeDynamicView != null) {
            canvasMakeDynamicView.setFeedPosition(i3);
        }
        FeedGiftLayout feedGiftLayout = this.mFeedGiftLayout;
        if (feedGiftLayout != null) {
            feedGiftLayout.setFeedPosition(i3);
        }
        FeedPicTextCardNewView feedPicTextCardNewView = this.mFeedPicTextCardNewView;
        if (feedPicTextCardNewView != null) {
            feedPicTextCardNewView.setFeedPosition(i3);
        }
    }

    public void setForward(boolean z16) {
        this.isForward = z16;
    }

    public void setHideSummary(boolean z16) {
        CanvasFeedContentView canvasFeedContentView = this.mCanvasFeedContentView;
        if (canvasFeedContentView != null) {
            canvasFeedContentView.setHideSummary(z16);
        }
    }

    public void setImageProcessorSupplier(ImageProcessorSupplier imageProcessorSupplier) {
        this.imageProcessorSupplier = imageProcessorSupplier;
    }

    public void setIsPassive(boolean z16) {
        this.isPassive = z16;
    }

    public void setLeftThumbData(CellLeftThumb cellLeftThumb) {
        this.mLeftThumb = cellLeftThumb;
        if (cellLeftThumb == null || !com.qzone.adapter.feedcomponent.i.H().S0() || cellLeftThumb == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        if (cellLeftThumb.getUser() != null && !TextUtils.isEmpty(cellLeftThumb.getUser().nickName)) {
            sb5.append(cellLeftThumb.getUser().nickName + MsgSummary.STR_COLON);
        }
        if (!TextUtils.isEmpty(cellLeftThumb.getTitle())) {
            sb5.append(cellLeftThumb.getTitle() + ", ");
        }
        if (!TextUtils.isEmpty(cellLeftThumb.getSummary())) {
            sb5.append(cellLeftThumb.getSummary());
        }
        String b16 = com.qzone.adapter.feedcomponent.i.H().b(sb5.toString().replaceAll("uin:[1-9][0-9]{5,10}|nick:|<|>", ""));
        if (TextUtils.isEmpty(b16)) {
            return;
        }
        this.mLeftThumbView.setContentDescription(b16);
    }

    public void setLeftThumbPictureInfo(FeedPictureInfo feedPictureInfo) {
        this.leftThumbPictureInfo = feedPictureInfo;
    }

    public void setMoodList(boolean z16) {
        this.isMoodList = z16;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        super.setOnFeedElementClickListener(gVar);
        CanvasFeedContentView canvasFeedContentView = this.mCanvasFeedContentView;
        if (canvasFeedContentView != null) {
            canvasFeedContentView.setOnFeedElementClickListener(gVar);
        }
        CanvasLeftThumbView canvasLeftThumbView = this.mLeftThumbView;
        if (canvasLeftThumbView != null) {
            canvasLeftThumbView.setOnFeedElementClickListener(gVar);
        }
        QbossPsvAdvView qbossPsvAdvView = this.mQbossPsvAdvView;
        if (qbossPsvAdvView != null) {
            qbossPsvAdvView.setOnElementClickListener(gVar);
        }
        FeedVideoView feedVideoView = this.mAutoVideo;
        if (feedVideoView != null) {
            feedVideoView.setOnFeedElementClickListener(gVar);
        }
        FeedVideoView feedVideoView2 = this.mContentViewVideo;
        if (feedVideoView2 != null) {
            feedVideoView2.setOnFeedElementClickListener(gVar);
        }
        FeedGiftLayout feedGiftLayout = this.mFeedGiftLayout;
        if (feedGiftLayout != null) {
            feedGiftLayout.setOnFeedElementClickListener(gVar);
        }
        CanvasMakeDynamicView canvasMakeDynamicView = this.mCanvasMakeDynamicView;
        if (canvasMakeDynamicView != null) {
            canvasMakeDynamicView.setOnFeedElementClickListener(gVar);
        }
        FeedPicTextCardNewView feedPicTextCardNewView = this.mFeedPicTextCardNewView;
        if (feedPicTextCardNewView != null) {
            feedPicTextCardNewView.setOnFeedElementClickListener(gVar);
        }
    }

    public void setPhotoMode(int i3) {
        this.photoMode = i3;
    }

    public void setPictureInfos(FeedPictureInfo[] feedPictureInfoArr) {
        this.pictureInfos = feedPictureInfoArr;
    }

    public void setQbossPsvAdvBackgdPictureInfo(FeedPictureInfo feedPictureInfo) {
        QbossPsvAdvView qbossPsvAdvView = this.mQbossPsvAdvView;
        if (qbossPsvAdvView != null) {
            qbossPsvAdvView.setQbossPsvAdvBackgdPictureInfo(feedPictureInfo);
        }
    }

    public void setQbossPsvAdvData(CellQbossPsvAdv cellQbossPsvAdv) {
        QbossPsvAdvView qbossPsvAdvView = this.mQbossPsvAdvView;
        if (qbossPsvAdvView != null) {
            qbossPsvAdvView.setmQbossPsvAdvData(cellQbossPsvAdv);
        }
    }

    public void setQbossPsvAdvFloatPictureInfo(FeedPictureInfo feedPictureInfo) {
        QbossPsvAdvView qbossPsvAdvView = this.mQbossPsvAdvView;
        if (qbossPsvAdvView != null) {
            qbossPsvAdvView.setFloatPictureInfo(feedPictureInfo);
        }
    }

    public void setQbossPsvAdvPictureInfo(FeedPictureInfo feedPictureInfo) {
        QbossPsvAdvView qbossPsvAdvView = this.mQbossPsvAdvView;
        if (qbossPsvAdvView != null) {
            qbossPsvAdvView.setBusinessFeedData(this.mFeedData);
            this.mQbossPsvAdvView.setLeftThumbPictureInfo(feedPictureInfo);
        }
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setVideoInfo(String str, VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
        this.clientKey = str;
    }

    public void startVideoIfNeed(boolean z16) {
        FeedVideoView feedVideoView = this.mAutoVideo;
        if (feedVideoView != null) {
            feedVideoView.doPlayVideoOnlyDetail(z16);
        }
    }

    void updateAudioInfo(boolean z16) {
        String str;
        ArrayList<AudioInfo> arrayList = this.audioInfos;
        if (arrayList != null && arrayList.size() != 0) {
            AudioInfo audioInfo = this.audioInfos.get(0);
            this.mAudioBubble.setIsWithPic(z16);
            this.mAudioBubble.setAudioInfo(audioInfo);
            AudioFeedBubble audioFeedBubble = this.mAudioBubble;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.cellId);
            sb5.append("_");
            sb5.append(0);
            if (this.isForward) {
                str = "_isF";
            } else {
                str = "_notF";
            }
            sb5.append(str);
            sb5.append("_");
            sb5.append(audioInfo.audioTime);
            audioFeedBubble.setUniKey(sb5.toString());
            this.mAudioBubble.setBusinessFeedData(this.mFeedData);
            this.mAudioBubble.setFeedPosition(this.feedPosition);
            setAudioBubbleState(this.mAudioBubble);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mAudioBubble.getLayoutParams();
            if (marginLayoutParams == null) {
                marginLayoutParams = new LinearLayout.LayoutParams(-1, -2);
            }
            int i3 = z16 ? 30 : 20;
            float f16 = density;
            marginLayoutParams.leftMargin = (int) ((i3 * f16) + 0.5f);
            marginLayoutParams.topMargin = (int) (((z16 ? -24 : 7) * f16) + 0.5f);
            this.mAudioBubble.setLayoutParams(marginLayoutParams);
            FeedViewSection.setViewVisbile(this.mAudioBubble);
            return;
        }
        FeedViewSection.setViewGone(this.mAudioBubble);
    }

    protected void updateTailInfo() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.getCellBottomRecomm() != null && this.mFeedData.isNewTailStyle()) {
            if ((this.isForward && needTailShowInForwardArea()) || (!this.isForward && !needTailShowInForwardArea())) {
                FeedViewSection.setVisibility(0, this.mFeedPicTextCardNewView);
                FeedPicTextCardNewView feedPicTextCardNewView = this.mFeedPicTextCardNewView;
                if (feedPicTextCardNewView != null) {
                    feedPicTextCardNewView.setFeedData(this.mFeedData);
                    return;
                }
                return;
            }
            FeedViewSection.setViewGone(this.mFeedPicTextCardNewView);
            return;
        }
        FeedViewSection.setViewGone(this.mFeedPicTextCardNewView);
    }

    protected void updateVideoInfo(String str, VideoInfo videoInfo) {
        int i3 = 0;
        boolean z16 = true;
        boolean z17 = this.isForward || !(this.mFeedData.isQCircleRecommFeed() || this.mFeedData.isQCircleShareCardFeed()) || this.mFeedData.getOriginalInfo() == null || this.mFeedData.getOriginalInfo().getCellSummaryV2() == null || TextUtils.isEmpty(this.mFeedData.getOriginalInfo().getCellSummaryV2().summary);
        if (videoInfo != null && z17) {
            FeedVideoView feedVideoView = this.mAutoVideo;
            if (feedVideoView != null) {
                FeedViewSection.setVisibility(0, feedVideoView);
                this.mAutoVideo.setFeedData(this.mFeedData, videoInfo);
                try {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mAutoVideo.getLayoutParams();
                    if (layoutParams != null) {
                        BusinessFeedData businessFeedData = this.mFeedData;
                        if (businessFeedData == null || businessFeedData.getCellSummaryV2() == null || TextUtils.isEmpty(this.mFeedData.getCellSummaryV2().displayStr)) {
                            z16 = false;
                        }
                        if (z16) {
                            if (!this.isForward) {
                                i3 = AreaConst.dp9;
                            }
                        } else {
                            i3 = AreaConst.f48746dp1;
                        }
                        if (layoutParams.topMargin != i3) {
                            layoutParams.topMargin = i3;
                            this.mAutoVideo.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        FeedViewSection.setVisibility(8, this.mAutoVideo);
    }

    public FeedAutoVideo getVideoView(Rect rect) {
        FeedVideoView feedVideoView = this.mAutoVideo;
        if (feedVideoView == null || feedVideoView.getAutoVideoView() == null || rect == null) {
            return null;
        }
        int[] iArr = new int[2];
        this.mAutoVideo.getAutoVideoView().getLocationOnScreen(iArr);
        int i3 = iArr[1];
        int i16 = iArr[0];
        int right = this.mAutoVideo.getAutoVideoView().getRight() - this.mAutoVideo.getAutoVideoView().getLeft();
        int bottom = this.mAutoVideo.getAutoVideoView().getBottom() - this.mAutoVideo.getAutoVideoView().getTop();
        if (i3 > com.qzone.proxy.feedcomponent.util.g.a(80.0f) && i3 < FeedGlobalEnv.g().getScreenHeight() - com.qzone.proxy.feedcomponent.util.g.a(100.0f)) {
            rect.left = i16;
            rect.top = i3;
            rect.right = i16 + right;
            rect.bottom = i3 + bottom;
        }
        return this.mAutoVideo.getAutoVideoView();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void reset() {
        this.videoInfo = null;
        this.isPassive = false;
        this.mFeedData = null;
        this.pictureInfos = null;
        this.photoMode = 0;
        QbossPsvAdvView qbossPsvAdvView = this.mQbossPsvAdvView;
        if (qbossPsvAdvView != null) {
            qbossPsvAdvView.reset();
        }
        CanvasFeedContentView canvasFeedContentView = this.mCanvasFeedContentView;
        if (canvasFeedContentView != null) {
            canvasFeedContentView.reset();
        }
    }

    private void handleQCircleEntrance() {
        FeedViewSection.setVisibility(8, this.mCanvasMakeDynamicView);
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData.feedType == 2) {
            com.qzone.proxy.feedcomponent.b.i(TAG, "handleQCircleEntrance, feedType is detail ");
            return;
        }
        CellAlbumEntrance cellAlbumEntrance = businessFeedData.cellAlbumEntrance;
        if (cellAlbumEntrance == null) {
            com.qzone.proxy.feedcomponent.b.i(TAG, "handleQCircleEntrance, albumEntrance is null ");
            return;
        }
        if (TextUtils.isEmpty(cellAlbumEntrance.guideTitle)) {
            com.qzone.proxy.feedcomponent.b.i(TAG, "handleQCircleEntrance, guideTitle is empty ");
            return;
        }
        CellFeedCommInfo feedCommInfoV2 = this.mFeedData.getFeedCommInfoV2();
        if (feedCommInfoV2 == null) {
            com.qzone.proxy.feedcomponent.b.i(TAG, "handleQCircleEntrance, feedCommInfoV2 is null ");
            return;
        }
        int i3 = feedCommInfoV2.appid;
        String str = feedCommInfoV2.clientkey;
        QZLog.i(TAG, 1, "handleQCircleEntrance, appId: " + i3 + ", clientKey: " + str + ", feedsKey: " + feedCommInfoV2.feedskey);
        if (i3 != 311) {
            return;
        }
        final FakeShuoShuoDataCacheHelper.a b16 = FakeShuoShuoDataCacheHelper.b(str);
        if (b16 == null) {
            com.qzone.proxy.feedcomponent.b.i(TAG, "handleQCircleEntrance, fakeData is null ");
        } else {
            FeedGlobalEnv.g().postRunnableToNormalThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedContent.4
                @Override // java.lang.Runnable
                public void run() {
                    boolean c16 = b16.c();
                    QZLog.i(FeedContent.TAG, 1, "handleQCircleEntrance, fileExists: " + c16);
                    if (c16) {
                        FeedContent.this.runOnUiThread(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.FeedContent.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QZLog.i(FeedContent.TAG, 1, "handleQCircleEntrance, set visible ");
                                FeedViewSection.setVisibility(0, FeedContent.this.mCanvasMakeDynamicView);
                                FeedContent feedContent = FeedContent.this;
                                CanvasMakeDynamicView canvasMakeDynamicView = feedContent.mCanvasMakeDynamicView;
                                if (canvasMakeDynamicView != null) {
                                    canvasMakeDynamicView.setFeedData(feedContent.mFeedData);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    protected int getContentViewVideoIndex(BusinessFeedData businessFeedData, FeedPictureInfo[] feedPictureInfoArr) {
        VideoInfo videoInfo;
        if (businessFeedData != null && businessFeedData.isForwardFeed() && (this instanceof FeedForward)) {
            businessFeedData = businessFeedData.getOriginalInfo();
        }
        int i3 = 0;
        this.hasMultiPicVideo = false;
        int i16 = -1;
        if (feedPictureInfoArr != null && feedPictureInfoArr.length > 1) {
            int length = feedPictureInfoArr.length;
            if (businessFeedData != null && businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().uploadnum > length) {
                length = businessFeedData.getPictureInfo().uploadnum;
            }
            int i17 = 0;
            while (true) {
                if (i17 >= feedPictureInfoArr.length || i17 >= 9) {
                    break;
                }
                FeedPictureInfo feedPictureInfo = feedPictureInfoArr[i17];
                if (feedPictureInfo != null && feedPictureInfo.f50260w == 1 && feedPictureInfo.f50261x != null) {
                    feedPictureInfo.r(FeedPictureInfo.ImageType.VIDEO);
                }
                i17++;
            }
            int i18 = length > 9 ? 8 : 9;
            while (true) {
                if (i3 >= feedPictureInfoArr.length || i3 >= i18) {
                    break;
                }
                FeedPictureInfo feedPictureInfo2 = feedPictureInfoArr[i3];
                if (feedPictureInfo2 == null || feedPictureInfo2.f50260w != 1 || (videoInfo = feedPictureInfo2.f50261x) == null || !videoInfo.isAutoPlay()) {
                    i3++;
                } else {
                    this.hasMultiPicVideo = true;
                    feedPictureInfoArr[i3].r(FeedPictureInfo.ImageType.VIDEO);
                    BusinessFeedData businessFeedData2 = this.mFeedData;
                    if (businessFeedData2 != null) {
                        businessFeedData2.setMixVideoIndex(i3);
                    }
                    i16 = i3;
                }
            }
            if (!this.hasMultiPicVideo) {
                FeedViewSection.setVisibility(8, this.mContentViewVideo);
            }
        } else {
            FeedViewSection.setVisibility(8, this.mContentViewVideo);
        }
        return i16;
    }

    private void updatePanoramaInfo(FeedPictureInfo[] feedPictureInfoArr) {
        FeedPictureInfo feedPictureInfo;
        PanoramaLayout panoramaLayout;
        if (feedPictureInfoArr != null && feedPictureInfoArr.length == 1 && (feedPictureInfo = feedPictureInfoArr[0]) != null) {
            FeedPictureInfo.ImageType d16 = feedPictureInfo.d();
            if ((d16 == FeedPictureInfo.ImageType.BALL_PANORAMA || d16 == FeedPictureInfo.ImageType.CIRCLE_PANORAMA) && (panoramaLayout = this.mPanoramaView) != null) {
                FeedViewSection.setVisibility(0, panoramaLayout);
                showPanoramaView(feedPictureInfoArr[0]);
                return;
            } else {
                FeedViewSection.setVisibility(8, this.mPanoramaView);
                return;
            }
        }
        FeedViewSection.setVisibility(8, this.mPanoramaView);
    }

    protected boolean isVideoEqual(VideoInfo videoInfo, VideoInfo videoInfo2) {
        if (videoInfo == null && videoInfo2 == null) {
            return true;
        }
        if (videoInfo != null && videoInfo2 != null) {
            if (videoInfo.equals(videoInfo2)) {
                return true;
            }
            String str = videoInfo.videoId;
            if (str != null) {
                return str.equals(videoInfo2.videoId);
            }
        }
        return false;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void attachView(NormalAbsFeedView normalAbsFeedView) {
    }

    public void onListScroll() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        onRecycled(true);
    }
}
