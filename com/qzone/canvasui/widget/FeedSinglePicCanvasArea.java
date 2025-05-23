package com.qzone.canvasui.widget;

import NS_MOBILE_FEEDS.stPhotoTag;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.qzone.adapter.feedcomponent.b;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.adapter.feedcomponent.p;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.ui.FeedContent;
import com.qzone.module.feedcomponent.ui.FeedTextArea;
import com.qzone.module.feedcomponent.ui.SubArea;
import com.qzone.module.feedcomponent.ui.TemplateFeedTextArea;
import com.qzone.module.feedcomponent.util.AlarmTask;
import com.qzone.module.feedcomponent.util.CanvasFeedContentUtil;
import com.qzone.module.feedcomponent.util.QcircleShareFeedSizeUtil;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLive;
import com.qzone.proxy.feedcomponent.model.CellOperationRegion;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.RegionData;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.util.g;
import com.qzone.proxy.feedcomponent.widget.e;
import com.qzone.util.image.d;
import com.qzone.widget.y;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class FeedSinglePicCanvasArea extends DittoArea implements AutoGifDrawable.AutoGifCallback, SubArea.ViewHost, r {
    public static int BOTTOM_MASK = 0;
    static int COMMENT_MAX_HEIGHT = 0;
    static final int COMMENT_PADDING;
    static final int DEFAULT_MARGIN;
    public static int LEFT_MASK = 0;
    private static final float LONG_PIC_SCALE;
    static final int NORMAL_MARGIN;
    public static final boolean OPEN_GIF = true;
    private static final int PIC_RADIUS = 16;
    public static int RIGHT_MASK = 0;
    private static Drawable SINGALE_PIC_ADS_DRAWBLE = null;
    private static Drawable SINGALE_PIC_BACKGROUND_DRAWBLE = null;
    private static Drawable SKIN_SINGALE_PIC_BACKGROUND_DRAWBLE = null;
    private static final String TAG = "FeedSinglePicCanvasArea";
    static final float TAG_VIEW_SACLE = 0.8f;
    public static int TOP_MASK;
    public static final int dp5;
    static Paint gifTextPaint;
    static int globalUniNum;
    static Paint liveTextPaint;
    static TextPaint templateShuoshuoPaint;
    y autoGifDrawable;
    Drawable backgoundDrawable;
    boolean canAutoPlayGif;
    CellLive cellLive;
    public String clientkey;
    public BusinessFeedData curFeedData;
    public FeedPictureInfo curPictureInfo;
    boolean differentPhotoAutoMode;
    float downX;
    float downY;
    private final boolean enableShowKingcardTips;
    private String errCode;
    BusinessFeedData feedData;
    public String feedskey;
    int flag;
    Paint.FontMetricsInt fontMetricsInt;
    private long gif_load_start;
    private boolean gif_play_started;
    boolean hasEventTag;
    boolean hasPrintSinglePicLog;
    boolean hasSummary;
    public HotAreaCallBack hotAreaCallBack;
    boolean isBigPicMode;
    boolean isBizRecomFeeds;
    boolean isForward;
    private boolean isLongImg;
    private boolean isLongPressed;
    boolean isNewAdvStyle;
    boolean isPassive;
    boolean isSubMultiAdvContainer;
    boolean isSubSingleAdvContainer;
    private boolean kingcardExposureReport;
    Paint linePaint;
    private int longImgModeHeight;
    private int longImgModeWidth;
    Drawable mAdvWarterMarkDrawable;
    private AlarmTask mAlarmTask;
    private CanvasQcircleRecomBottomView mBottomView;
    float mClickPosX;
    p mFeedSinglePicTagHelper;
    DittoHost mHost;
    e mImageTagArea;
    Bitmap mImageTagCache;
    FeedPictureInfo.ImageType mImageType;
    private Rect mKingcardClickRect;
    private final String mKingcardDefaultText;
    RelativeLayout mMaskLayout;
    int mPaddingLeft;
    int mPaddingTop;
    private View mParent;
    PreRenderImageTagTask mPreRenderImageTagTask;
    boolean mShowWarterMark;
    int mUni;
    Drawable maskDrawable;
    boolean needLayout;
    private AlarmTask.OnAlarmListener onAlarmListener;
    ArrayList<stPhotoTag> photoTag;
    int picHeight;
    int picWidth;
    ImageUrl preImageUrl;
    ImageLoader.Options preOpt;
    String preUrl;
    int realMarginInPx;
    FeedTextArea redPocketTextArea;
    boolean rejectBigMode;
    String signUrl;
    Drawable singleDrawable;
    TemplateFeedTextArea templateShuoshuoTextArea;
    Rect textRect;
    private RegionData touchedRegionData;
    public String ugckey;

    /* renamed from: com.qzone.canvasui.widget.FeedSinglePicCanvasArea$4, reason: invalid class name */
    /* loaded from: classes39.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$qzone$proxy$feedcomponent$model$FeedPictureInfo$ImageType;

        static {
            int[] iArr = new int[FeedPictureInfo.ImageType.values().length];
            $SwitchMap$com$qzone$proxy$feedcomponent$model$FeedPictureInfo$ImageType = iArr;
            try {
                iArr[FeedPictureInfo.ImageType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$model$FeedPictureInfo$ImageType[FeedPictureInfo.ImageType.IMAGE_GIF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$model$FeedPictureInfo$ImageType[FeedPictureInfo.ImageType.MUSIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$model$FeedPictureInfo$ImageType[FeedPictureInfo.ImageType.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes39.dex */
    public interface HotAreaCallBack {
        void handleHotAreaClickEvent(RegionData regionData);
    }

    /* loaded from: classes39.dex */
    public class PicListener implements ImageLoader.ImageLoadListener {
        private long startTime;
        private boolean hasReportCurrentImage = false;
        private long reportStartTime = 0;
        private boolean hasReport = false;

        public PicListener() {
            this.startTime = 0L;
            this.startTime = System.currentTimeMillis();
        }

        private void reportImageShowTime() {
            if (this.hasReportCurrentImage) {
                return;
            }
            this.hasReportCurrentImage = true;
            if (this.reportStartTime != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.reportStartTime;
                if (currentTimeMillis > 0) {
                    i.H().c2(currentTimeMillis, "singlePicture");
                }
            }
        }

        private void reportLoadTime(String str, boolean z16) {
            if (this.hasReport) {
                return;
            }
            this.hasReport = true;
            i.H().x1(str, z16, this.startTime != 0 ? System.currentTimeMillis() - this.startTime : 0L);
        }

        public void setReportStartTime() {
            this.reportStartTime = System.currentTimeMillis();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            reportLoadTime(str, false);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            reportLoadTime(str, false);
            if (options != null) {
                FeedSinglePicCanvasArea.this.errCode = options.errCode;
                AreaManager.mainHanlder.obtainMessage(1, FeedSinglePicCanvasArea.this).sendToTarget();
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Object obj;
            boolean z16;
            int i3;
            if (options != null && (obj = options.obj) != null && (obj instanceof Integer) && drawable != null && FeedSinglePicCanvasArea.this.mUni == ((Integer) obj).intValue()) {
                FeedSinglePicCanvasArea feedSinglePicCanvasArea = FeedSinglePicCanvasArea.this;
                feedSinglePicCanvasArea.singleDrawable = drawable;
                if (feedSinglePicCanvasArea.picHeight != drawable.getIntrinsicHeight()) {
                    FeedSinglePicCanvasArea.this.picHeight = drawable.getIntrinsicHeight();
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (FeedSinglePicCanvasArea.this.picWidth != drawable.getIntrinsicWidth()) {
                    FeedSinglePicCanvasArea.this.picWidth = drawable.getIntrinsicWidth();
                    z16 = true;
                }
                FeedSinglePicCanvasArea feedSinglePicCanvasArea2 = FeedSinglePicCanvasArea.this;
                feedSinglePicCanvasArea2.initSize(feedSinglePicCanvasArea2.curPictureInfo, z16);
                FeedSinglePicCanvasArea.this.getClass();
                if (z16) {
                    i3 = 2;
                } else {
                    FeedSinglePicCanvasArea.this.needLayout = true;
                    i3 = 1;
                }
                AreaManager.mainHanlder.obtainMessage(i3, FeedSinglePicCanvasArea.this).sendToTarget();
                reportImageShowTime();
            }
            if (options == null || TextUtils.isEmpty(options.errCode)) {
                FeedSinglePicCanvasArea.this.errCode = null;
            } else {
                FeedSinglePicCanvasArea.this.errCode = options.errCode;
            }
            reportLoadTime(str, true);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* loaded from: classes39.dex */
    public class PreRenderImageTagTask implements Runnable {

        /* renamed from: com.qzone.canvasui.widget.FeedSinglePicCanvasArea$PreRenderImageTagTask$1, reason: invalid class name */
        /* loaded from: classes39.dex */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FeedSinglePicCanvasArea.this.invalidate();
            }
        }

        public PreRenderImageTagTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FeedSinglePicCanvasArea.this.getClass();
        }
    }

    static {
        int i3 = AreaManager.FEED_INTERVAL;
        DEFAULT_MARGIN = i3;
        NORMAL_MARGIN = i3;
        float f16 = 2.3f;
        try {
            f16 = i.H().R("QZoneSetting", "feedPicAreaLongScale", 2.3f);
        } catch (Throwable unused) {
        }
        if (f16 < 2.0f) {
            f16 = 2.0f;
        }
        LONG_PIC_SCALE = f16;
        dp5 = AreaConst.dp5;
        globalUniNum = 1;
        COMMENT_PADDING = g.a(8.0f);
        LEFT_MASK = 1;
        TOP_MASK = 2;
        RIGHT_MASK = 4;
        BOTTOM_MASK = 8;
        SINGALE_PIC_ADS_DRAWBLE = j.g(728);
        SINGALE_PIC_BACKGROUND_DRAWBLE = j.g(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
        SKIN_SINGALE_PIC_BACKGROUND_DRAWBLE = j.g(961);
    }

    public FeedSinglePicCanvasArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.realMarginInPx = NORMAL_MARGIN;
        this.singleDrawable = AreaManager.DEFAULT_BACKGROUND;
        this.maskDrawable = null;
        this.textRect = null;
        this.mUni = -1;
        this.mImageType = FeedPictureInfo.ImageType.NORMAL;
        this.mClickPosX = -1.0f;
        this.gif_load_start = 0L;
        this.gif_play_started = false;
        this.mPreRenderImageTagTask = new PreRenderImageTagTask();
        this.enableShowKingcardTips = i.H().S("QZoneSetting", "enableKingCardShowText", 1) != 0;
        this.mKingcardDefaultText = i.H().T("QZoneSetting", "kingCardFreeWatchTips", "\u514d\u6d41\u91cf\u64ad\u653e");
        this.kingcardExposureReport = false;
        this.onAlarmListener = new AlarmTask.OnAlarmListener() { // from class: com.qzone.canvasui.widget.FeedSinglePicCanvasArea.3
            @Override // com.qzone.module.feedcomponent.util.AlarmTask.OnAlarmListener
            public void onAlarm(AlarmTask alarmTask) {
                if (alarmTask == null || !FeedSinglePicCanvasArea.this.isLongPressed) {
                    return;
                }
                FeedSinglePicCanvasArea.this.isLongPressed = false;
                FeedSinglePicCanvasArea feedSinglePicCanvasArea = FeedSinglePicCanvasArea.this;
                feedSinglePicCanvasArea.performLongClick(alarmTask.mEvent, feedSinglePicCanvasArea.errCode);
            }
        };
        this.mHost = dittoHost;
    }

    private void checkLongClickEvent(MotionEvent motionEvent) {
        if (this.mAlarmTask == null) {
            this.mAlarmTask = new AlarmTask();
        }
        AlarmTask alarmTask = this.mAlarmTask;
        alarmTask.mEvent = motionEvent;
        alarmTask.cancelAlarm();
        this.mAlarmTask.setAlarmListener(this.onAlarmListener);
        this.mAlarmTask.setTriggerTime(1000L);
    }

    private void drawKingcardFreeWatchTips(Canvas canvas) {
        if (AreaManager.FEED_KINGCARD_PLAY_ICON == null) {
            AreaManager.FEED_KINGCARD_PLAY_ICON = j.g(925);
        }
        if (AreaManager.FEED_KINGCARD_PLAY_BG == null) {
            AreaManager.FEED_KINGCARD_PLAY_BG = j.g(926);
        }
        int dpToPx = FeedVideoEnv.dpToPx(132.0f);
        int dpToPx2 = FeedVideoEnv.dpToPx(44.0f);
        int i3 = (this.picWidth - dpToPx) / 2;
        int i16 = (this.picHeight - dpToPx2) / 2;
        int dpToPx3 = FeedVideoEnv.dpToPx(17.0f);
        int dpToPx4 = FeedVideoEnv.dpToPx(16.0f);
        if (this.mKingcardClickRect == null) {
            this.mKingcardClickRect = new Rect(i3, i16, (this.picWidth + dpToPx) / 2, (this.picHeight + dpToPx2) / 2);
        }
        AreaManager.FEED_KINGCARD_PLAY_BG.setBounds(this.mKingcardClickRect);
        AreaManager.FEED_KINGCARD_PLAY_BG.draw(canvas);
        AreaManager.FEED_KINGCARD_PLAY_ICON.setBounds(FeedVideoEnv.dpToPx(18.0f) + i3, FeedVideoEnv.dpToPx(14.0f) + i16, FeedVideoEnv.dpToPx(14.0f) + i3 + dpToPx3, FeedVideoEnv.dpToPx(14.0f) + i16 + dpToPx4);
        AreaManager.FEED_KINGCARD_PLAY_ICON.draw(canvas);
        canvas.drawText(this.mKingcardDefaultText, i3 + FeedVideoEnv.dpToPx(35.0f), i16 + FeedVideoEnv.dpToPx(28.0f), FeedVideoEnv.videoFreeTrafficPaint);
        if (this.kingcardExposureReport) {
            return;
        }
        this.kingcardExposureReport = true;
        i.H().j2(8, 219, 7);
    }

    private ImageLoader.Options getNormalOptions(FeedPictureInfo feedPictureInfo) {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        int uniNum = getUniNum();
        this.mUni = uniNum;
        obtain.obj = Integer.valueOf(uniNum);
        obtain.extraProcessor = feedPictureInfo.c();
        obtain.processor = feedPictureInfo.g();
        obtain.preferQuality = false;
        if (feedPictureInfo.f50252o) {
            obtain.imageConfig = Bitmap.Config.ARGB_8888;
        }
        if (feedPictureInfo.h().width > 0 && feedPictureInfo.h().height > 0 && FeedContent.isGoldenCudgel(feedPictureInfo.h().width, feedPictureInfo.h().height)) {
            obtain.preferQuality = true;
        }
        return obtain;
    }

    private int getQCircleSharedImgBottom() {
        int i3;
        FeedPictureInfo feedPictureInfo = this.curPictureInfo;
        if (feedPictureInfo != null && (i3 = feedPictureInfo.f50256s) != 0) {
            int i16 = this.picWidth;
            float f16 = (i16 / i3) * feedPictureInfo.f50257t;
            float f17 = i16 * 1.13f;
            return f16 > f17 ? (int) ((f17 / 2.0f) + (f16 / 2.0f)) : this.picHeight;
        }
        return this.picHeight;
    }

    private int getQCircleSharedImgTop() {
        int i3;
        FeedPictureInfo feedPictureInfo = this.curPictureInfo;
        if (feedPictureInfo == null || (i3 = feedPictureInfo.f50256s) == 0) {
            return 0;
        }
        int i16 = this.picWidth;
        float f16 = (i16 / i3) * feedPictureInfo.f50257t;
        float f17 = i16 * 1.13f;
        if (f16 > f17) {
            return (int) ((f17 / 2.0f) - (f16 / 2.0f));
        }
        return 0;
    }

    static int getUniNum() {
        int i3 = globalUniNum + 1;
        globalUniNum = i3;
        return i3;
    }

    private void initGifDrawable(FeedPictureInfo feedPictureInfo) {
        if (this.canAutoPlayGif && this.autoGifDrawable == null && this.mImageType == FeedPictureInfo.ImageType.IMAGE_GIF && feedPictureInfo.i() && isListViewScrollIdle()) {
            this.autoGifDrawable = new y();
            this.gif_load_start = System.currentTimeMillis();
            this.autoGifDrawable.d(feedPictureInfo.b().url, getGifOptions(), FeedGlobalEnv.getContext(), this, null);
        }
    }

    private void initImageType(FeedPictureInfo feedPictureInfo) {
        FeedPictureInfo.ImageType d16 = feedPictureInfo.d();
        this.mImageType = d16;
        if (d16 == null) {
            this.mImageType = FeedPictureInfo.ImageType.NORMAL;
        }
    }

    private void initSingalDrawable(FeedPictureInfo feedPictureInfo, ImageLoader.Options options) {
        int screenWidth;
        this.signUrl = feedPictureInfo.h().url;
        PicListener picListener = new PicListener();
        if ((this.mImageType == FeedPictureInfo.ImageType.NORMAL && feedPictureInfo.h().width == 0 && feedPictureInfo.h().height == 0) || this.mImageType == FeedPictureInfo.ImageType.IMAGE_GOLDEN_CUDGEL) {
            Log.i(TAG, "initSingalDrawable: crop " + feedPictureInfo.h().url);
            options.cropHead = true;
            options.cropHwRation = this.mImageType == FeedPictureInfo.ImageType.IMAGE_GOLDEN_CUDGEL ? 2.0f : LONG_PIC_SCALE;
        }
        Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(feedPictureInfo.h().imageUrl, this.signUrl, picListener, options);
        this.singleDrawable = loadImage;
        if (loadImage == null) {
            picListener.setReportStartTime();
            this.singleDrawable = AreaManager.DEFAULT_BACKGROUND;
            this.picHeight = this.height;
            this.picWidth = this.width;
            return;
        }
        this.picHeight = loadImage.getIntrinsicHeight();
        this.picWidth = this.singleDrawable.getIntrinsicWidth();
        if (!isHotRegionPic()) {
            if (!i.H().m1()) {
                return;
            }
            if (feedPictureInfo.h().width != 0 && feedPictureInfo.h().height != 0) {
                return;
            }
        }
        if (this.isForward) {
            screenWidth = AreaConst.getDefaultWidth();
        } else {
            screenWidth = FeedGlobalEnv.g().getScreenWidth();
        }
        int[] applyNewSinglePicRule = CanvasFeedContentUtil.applyNewSinglePicRule(this.picHeight, this.picWidth, screenWidth);
        this.picWidth = applyNewSinglePicRule[0];
        this.picHeight = applyNewSinglePicRule[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSize(FeedPictureInfo feedPictureInfo, boolean z16) {
        int a16;
        if (this.feedData == null || feedPictureInfo == null) {
            return;
        }
        boolean z17 = true;
        this.rejectBigMode = ((double) feedPictureInfo.h().width) * 1.7d < ((double) feedPictureInfo.h().height);
        this.differentPhotoAutoMode = i.H().F() && FeedGlobalEnv.g().getCurrentPhotoMode() == 0;
        this.isBigPicMode = (!i.H().s1() || this.rejectBigMode || this.differentPhotoAutoMode) ? false : true;
        boolean isTemplateShuoshuo = isTemplateShuoshuo(this.curPictureInfo, this.feedData);
        if (!this.isForward && !this.differentPhotoAutoMode) {
            a16 = FeedGlobalEnv.g().getScreenWidth();
        } else {
            a16 = b.a();
        }
        int min = Math.min(this.picWidth, useMaxWidth() ? a16 : a16 - (this.realMarginInPx * 2));
        if (isTemplateShuoshuo) {
            if (feedPictureInfo.f50256s == feedPictureInfo.f50257t) {
                min = FeedGlobalEnv.g().getScreenWidth() - (this.realMarginInPx * 2);
            }
        } else if (min <= 0) {
            min = this.isBigPicMode ? a16 : a16 - (this.realMarginInPx * 2);
        }
        int i3 = this.picWidth;
        if (i3 > 0) {
            this.picHeight = (this.picHeight * min) / i3;
        } else {
            this.picHeight = min;
        }
        this.picWidth = min;
        if (i.H().m1() && z16) {
            int[] applyNewSinglePicRule = CanvasFeedContentUtil.applyNewSinglePicRule(this.picHeight, this.picWidth, a16);
            this.picWidth = applyNewSinglePicRule[0];
            this.picHeight = applyNewSinglePicRule[1];
        }
        if (this.picHeight < ((int) (this.picWidth * LONG_PIC_SCALE)) && this.mImageType != FeedPictureInfo.ImageType.IMAGE_GOLDEN_CUDGEL) {
            z17 = false;
        }
        this.isLongImg = z17;
        if (this.feedData.isQCircleRecommFeed()) {
            this.picWidth = a16;
            this.picHeight = (int) (a16 * Math.min(this.picHeight / this.picWidth, 1.13f));
            this.isLongImg = false;
        }
        if (this.feedData.isAttach()) {
            return;
        }
        if (!this.isSubMultiAdvContainer && !this.feedData.getFeedCommInfo().isBizRecomFeeds()) {
            if (this.feedData.isSubOfSingleAdvContainerFeed()) {
                this.mPaddingLeft = 0;
            } else if (this.picWidth >= FeedGlobalEnv.g().getScreenWidth() - this.realMarginInPx && this.isBigPicMode) {
                if (this.feedData.getSinglePicAdvStyle() != 4 && !this.feedData.isSingleCardStyle()) {
                    this.mPaddingLeft = 0;
                } else {
                    this.mPaddingLeft = this.realMarginInPx;
                }
            } else if (this.isForward && this.picWidth >= b.a() - this.realMarginInPx && this.isBigPicMode) {
                this.mPaddingLeft = 0;
            } else if (this.feedData.getFeedCommInfo().isYunYingFeeds()) {
                this.mPaddingLeft = (FeedGlobalEnv.g().getScreenWidth() - this.picWidth) / 2;
            } else if (isTemplateShuoshuo(this.curPictureInfo, this.feedData)) {
                this.mPaddingLeft = this.isForward ? 0 : this.realMarginInPx;
            } else {
                this.mPaddingLeft = this.realMarginInPx;
            }
        } else {
            this.mPaddingLeft = 0;
        }
        if (this.feedData.isGDTAdvFeed()) {
            if (this.feedData.isSubOfSingleAdvContainerFeed()) {
                this.mPaddingTop = 0;
            } else {
                this.mPaddingTop = (int) (DittoUIEngine.g().getDensity() * 6.0f);
            }
            if (this.feedData.getSinglePicAdvStyle() == 4 || this.feedData.isSingleCardStyle()) {
                this.mAdvWarterMarkDrawable = SINGALE_PIC_ADS_DRAWBLE;
                setShadowDrawable(SINGALE_PIC_BACKGROUND_DRAWBLE);
                int i16 = AreaConst.dp2_5;
                int i17 = AreaConst.f48747dp2;
                setShadowSize(i17, i16, i17, 0);
                this.backgoundDrawable = SINGALE_PIC_BACKGROUND_DRAWBLE;
                if (i.H().p1()) {
                    setShadowDrawable(SKIN_SINGALE_PIC_BACKGROUND_DRAWBLE);
                }
            }
        } else {
            if (TextUtils.isEmpty(this.feedData.getCellSummary().displayStr)) {
                this.mPaddingTop = 0;
            } else {
                this.mPaddingTop = (int) (DittoUIEngine.g().getDensity() * 6.0f);
            }
            this.mShadowDrawable = null;
        }
        BusinessFeedData businessFeedData = this.feedData;
        if (businessFeedData == null || !businessFeedData.isQCircleShareCardFeed()) {
            return;
        }
        fitQcircleShareFeed();
    }

    private boolean isHotRegionPic() {
        CellOperationRegion cellOperationRegion = this.feedData.cellOperationRegion;
        return (cellOperationRegion == null || cellOperationRegion.regions.size() == 0 || this.feedData.cellOperationRegion.interactiveType != 0) ? false : true;
    }

    private boolean isValidLongPicDrawable() {
        int i3 = this.picHeight;
        return i3 == 0 || i3 / this.picWidth < 3;
    }

    private boolean useMaxWidth() {
        return this.isBigPicMode || (this.picWidth >= FeedGlobalEnv.g().getScreenWidth() - DEFAULT_MARGIN && this.isBigPicMode) || this.isBizRecomFeeds || ((this.isForward && (this.feedData.isLiveVideoFeed() || !isTemplateShuoshuo(this.curPictureInfo, this.feedData))) || this.differentPhotoAutoMode || this.isSubMultiAdvContainer || this.isSubSingleAdvContainer || this.feedData.getFeedCommInfo().isYunYingFeeds());
    }

    void DrawTemplateShuoshuoText(Canvas canvas, int i3, int i16, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.endsWith("\n")) {
            str = str + "\n";
        }
        canvas.save();
        if (this.maskDrawable == null) {
            this.maskDrawable = new ColorDrawable(-16777216);
        }
        this.maskDrawable.setAlpha(90);
        this.maskDrawable.setBounds(0, 0, i3, i16);
        this.maskDrawable.draw(canvas);
        int a16 = i3 - g.a(30.0f);
        if (this.templateShuoshuoTextArea == null) {
            TemplateFeedTextArea templateFeedTextArea = new TemplateFeedTextArea(80);
            this.templateShuoshuoTextArea = templateFeedTextArea;
            templateFeedTextArea.setTextColor(-1);
            this.templateShuoshuoTextArea.setMaxLine(9);
            this.templateShuoshuoTextArea.setTextGravity(1);
            this.templateShuoshuoTextArea.setMaxWidth(a16);
            this.templateShuoshuoTextArea.setEllipsisStr(null);
            this.templateShuoshuoTextArea.setAnimationProgress(this.feedData.fadedTimeScale);
            this.templateShuoshuoTextArea.setAnimationListener(new TextCellLayout.l() { // from class: com.qzone.canvasui.widget.FeedSinglePicCanvasArea.2
                @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.l
                public void onProgressChanged(long j3) {
                    FeedSinglePicCanvasArea.this.feedData.fadedTimeScale = (int) j3;
                }
            });
            this.templateShuoshuoTextArea.setViewHost(this);
        }
        this.templateShuoshuoTextArea.setData(str, 0);
        this.templateShuoshuoTextArea.updateNetEmoji();
        this.templateShuoshuoTextArea.setTextSize(24.0f);
        this.templateShuoshuoTextArea.setLineSpace(AreaConst.dp11);
        this.templateShuoshuoTextArea.setTextBold(true);
        this.templateShuoshuoTextArea.measure(a16, 0);
        if (this.templateShuoshuoTextArea.getLineCount() >= 5) {
            this.templateShuoshuoTextArea.setTextSize(16.0f);
            this.templateShuoshuoTextArea.setLineSpace(AreaConst.dp9);
            this.templateShuoshuoTextArea.measure(a16, 0);
        }
        if ((this.templateShuoshuoTextArea.getPaint() != null ? this.templateShuoshuoTextArea.getPaint().getFontMetricsInt() : null) != null) {
            canvas.translate((i3 - a16) / 2, ((i16 - this.templateShuoshuoTextArea.getHeight()) + ((r10.bottom - r10.top) / 2)) / 2);
        }
        if (this.feedData.feedType != 4097) {
            this.templateShuoshuoTextArea.disableFadeAnimation();
        }
        this.templateShuoshuoTextArea.draw(canvas, null);
        canvas.restore();
    }

    boolean checkClickOutside(float f16, float f17) {
        float f18 = this.downX;
        if (f18 >= 0.0f) {
            float f19 = this.downY;
            if (f19 >= 0.0f) {
                float f26 = ((f18 - f16) * (f18 - f16)) + ((f19 - f17) * (f19 - f17));
                int i3 = dp5;
                r3 = f26 > ((float) (i3 * i3));
                if (r3) {
                    this.downY = -1.0f;
                    this.downX = -1.0f;
                }
            }
        }
        return r3;
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        RegionData regionData;
        if (isHotRegionPic()) {
            if (motionEvent.getAction() == 0) {
                for (RegionData regionData2 : this.feedData.cellOperationRegion.regions) {
                    if (regionData2.checkHit(this.height, this.width, motionEvent.getX(), motionEvent.getY())) {
                        this.touchedRegionData = regionData2;
                        return true;
                    }
                }
            } else if (motionEvent.getAction() == 3) {
                this.touchedRegionData = null;
            } else if (motionEvent.getAction() == 1 && (regionData = this.touchedRegionData) != null && regionData.checkHit(this.height, this.width, motionEvent.getX(), motionEvent.getY())) {
                com.qzone.proxy.feedcomponent.b.c("GAMESHARE", String.format("touched feed picture view, size: %d %d", Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight())));
                HotAreaCallBack hotAreaCallBack = this.hotAreaCallBack;
                if (hotAreaCallBack != null) {
                    RegionData regionData3 = this.touchedRegionData;
                    if (regionData3.actionType == 2) {
                        hotAreaCallBack.handleHotAreaClickEvent(regionData3);
                        return true;
                    }
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    boolean drawGifFactor(Canvas canvas) {
        if (this.autoGifDrawable != null) {
            if (gifTextPaint == null) {
                Paint paint = new Paint(1);
                gifTextPaint = paint;
                paint.setTextSize(getSpValue(12.0f));
            }
            String c16 = this.autoGifDrawable.c();
            Rect rect = new Rect();
            if (!TextUtils.isEmpty(c16)) {
                gifTextPaint.getTextBounds(c16, 0, c16.length() - 1, rect);
                int measureText = (int) (this.picWidth - gifTextPaint.measureText(c16));
                int height = this.picHeight - rect.height();
                int i3 = AreaConst.dp1_5;
                gifTextPaint.setColor(Color.argb(127, 0, 0, 0));
                int i16 = i3 * 2;
                canvas.drawRect(measureText - i16, height - i16, this.picWidth, this.picHeight, gifTextPaint);
                gifTextPaint.setColor(-1);
                canvas.drawText(c16, measureText - i3, this.picHeight - i3, gifTextPaint);
                return true;
            }
        }
        return false;
    }

    boolean drawGifMark(Canvas canvas) {
        int i3 = this.picWidth;
        int i16 = AreaConst.dp25;
        if (i3 <= i16) {
            return false;
        }
        int i17 = this.picHeight;
        int i18 = i17 - AreaConst.dp14;
        AreaManager.GIF_DRAWABLE.setBounds(i3 - i16, i18, i3, i17);
        AreaManager.GIF_DRAWABLE.draw(canvas);
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public View getAttachedView() {
        Object obj = this.mHost;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    public float getClickPosX() {
        return this.mClickPosX;
    }

    ImageLoader.Options getGifOptions() {
        int i3;
        int i16;
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.obj = Integer.valueOf(this.mUni);
        obtain.preferQuality = false;
        FeedPictureInfo feedPictureInfo = this.curPictureInfo;
        if (feedPictureInfo != null) {
            FeedPictureInfo.ImageType d16 = feedPictureInfo.d();
            this.mImageType = d16;
            if (d16 == null) {
                this.mImageType = FeedPictureInfo.ImageType.NORMAL;
            }
            obtain.extraProcessor = this.curPictureInfo.c();
            obtain.processor = this.curPictureInfo.g();
            if (this.curPictureInfo.f50257t > FeedGlobalEnv.g().getScreenHeight()) {
                i3 = FeedGlobalEnv.g().getScreenHeight();
            } else {
                i3 = this.curPictureInfo.f50257t;
            }
            if (this.curPictureInfo.f50256s > FeedGlobalEnv.g().getScreenWidth()) {
                i16 = FeedGlobalEnv.g().getScreenWidth();
            } else {
                i16 = this.curPictureInfo.f50256s;
            }
            obtain.clipHeight = i3;
            obtain.clipWidth = i16;
            FeedPictureInfo feedPictureInfo2 = this.curPictureInfo;
            if (feedPictureInfo2.f50252o) {
                obtain.imageConfig = Bitmap.Config.ARGB_8888;
            }
            if (feedPictureInfo2.h().width > 0 && this.curPictureInfo.h().height > 0 && FeedContent.isGoldenCudgel(this.curPictureInfo.h().width, this.curPictureInfo.h().height)) {
                obtain.preferQuality = true;
            }
        }
        return obtain;
    }

    public Drawable getSingleDrawable() {
        return this.singleDrawable;
    }

    public float getSpValue(float f16) {
        return TypedValue.applyDimension(2, f16, FeedGlobalEnv.getContext().getResources().getDisplayMetrics());
    }

    @Override // com.tencent.ditto.area.DittoArea
    public int getType() {
        return 6;
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public void invalidateGifView() {
        if (!this.gif_play_started) {
            this.gif_play_started = true;
            if (this.gif_load_start > 0) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("load_time", "" + (System.currentTimeMillis() - this.gif_load_start));
                i.H().v("qzone_gif_load_time", System.currentTimeMillis() - this.gif_load_start, hashMap);
                com.qzone.proxy.feedcomponent.b.e("Feed", "report gif load time:" + (System.currentTimeMillis() - this.gif_load_start));
            }
        }
        invalidate();
    }

    public boolean isInPicArea(float f16, float f17) {
        return this.isLongImg ? f16 > ((float) getPaddingLeft()) && f16 < ((float) (this.longImgModeWidth + getPaddingLeft())) && f17 > ((float) getPaddingTop()) && f17 < ((float) (this.longImgModeHeight + getPaddingTop())) : f16 > ((float) getPaddingLeft()) && f16 < ((float) (this.picWidth + getPaddingLeft())) && f17 > ((float) getPaddingTop()) && f17 < ((float) (this.picHeight + getPaddingTop()));
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public boolean isListViewScrollIdle() {
        return i.H().g1();
    }

    boolean needDrawPhotoTag() {
        ArrayList<stPhotoTag> arrayList = this.photoTag;
        return (arrayList == null || arrayList.get(0) == null || this.picWidth < 200) ? false : true;
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        boolean z16;
        FeedPictureInfo feedPictureInfo;
        BusinessFeedData businessFeedData;
        int i3;
        int i16;
        int i17;
        int i18;
        FeedPictureInfo feedPictureInfo2;
        super.onDraw(canvas);
        if (this.singleDrawable == null) {
            return;
        }
        canvas.save();
        y yVar = this.autoGifDrawable;
        if (yVar != null && this.canAutoPlayGif && yVar.b(canvas, this.picWidth, this.picHeight)) {
            z16 = true;
        } else {
            int d16 = d.d(this.errCode);
            if (d16 == 1) {
                this.singleDrawable = AreaManager.DEFAULT_BACKGROUND_SERVER;
            } else if (d16 == 2) {
                this.singleDrawable = AreaManager.DEFAULT_BACKGROUND_NETWORK;
            }
            try {
                if (this.isLongImg && isValidLongPicDrawable()) {
                    Drawable drawable = this.singleDrawable;
                    int i19 = this.longImgModeWidth;
                    drawable.setBounds(0, 0, i19, (this.picHeight * i19) / this.picWidth);
                } else if (this.feedData.isQCircleRecommFeed()) {
                    this.singleDrawable.setBounds(0, getQCircleSharedImgTop(), this.picWidth, getQCircleSharedImgBottom());
                } else {
                    this.singleDrawable.setBounds(0, 0, this.picWidth, this.picHeight);
                }
                this.singleDrawable.draw(canvas);
            } catch (Exception e16) {
                com.qzone.proxy.feedcomponent.b.d("AvatarArea", "Feed Avatar draw exception.", e16);
            }
            z16 = false;
        }
        int i26 = AnonymousClass4.$SwitchMap$com$qzone$proxy$feedcomponent$model$FeedPictureInfo$ImageType[this.mImageType.ordinal()];
        if (i26 != 1) {
            if (i26 != 2) {
                if (i26 == 3) {
                    int intrinsicHeight = AreaManager.QQ_MUSIC_STOP.getIntrinsicHeight();
                    if (intrinsicHeight == -1) {
                        Drawable drawable2 = AreaManager.QQ_MUSIC_PLAY;
                        drawable2.setBounds(0, 0, this.picWidth, this.picHeight);
                        drawable2.draw(canvas);
                    } else {
                        int i27 = (this.picWidth - intrinsicHeight) / 2;
                        int i28 = (this.picHeight - intrinsicHeight) / 2;
                        Drawable drawable3 = AreaManager.QQ_MUSIC_PLAY;
                        drawable3.setBounds(i27, i28, intrinsicHeight + i27, intrinsicHeight + i28);
                        drawable3.draw(canvas);
                    }
                } else if (i26 == 4) {
                    Drawable drawable4 = AreaManager.IMAGE_VIDEO;
                    int intrinsicHeight2 = drawable4.getIntrinsicHeight();
                    int i29 = (this.picWidth - intrinsicHeight2) / 2;
                    int i36 = (this.picHeight - intrinsicHeight2) / 2;
                    drawable4.setBounds(i29, i36, intrinsicHeight2 + i29, intrinsicHeight2 + i36);
                    drawable4.draw(canvas);
                }
            } else if (!z16) {
                drawGifMark(canvas);
            } else {
                drawGifFactor(canvas);
            }
        } else if (isTemplateShuoshuo(this.curPictureInfo, this.curFeedData) && (feedPictureInfo = this.curPictureInfo) != null) {
            DrawTemplateShuoshuoText(canvas, this.picWidth, this.picHeight, feedPictureInfo.f50263z);
        }
        if (this.isLongImg && (feedPictureInfo2 = this.curPictureInfo) != null && !feedPictureInfo2.j()) {
            int i37 = this.longImgModeWidth;
            int i38 = i37 - AreaConst.dp30;
            int i39 = this.longImgModeHeight;
            AreaManager.GOLDEN_CUDGEL_DRAWABLE.setBounds(i38, i39 - AreaConst.dp18, i37, i39);
            AreaManager.GOLDEN_CUDGEL_DRAWABLE.draw(canvas);
        }
        FeedPictureInfo feedPictureInfo3 = this.curPictureInfo;
        if (feedPictureInfo3 != null && feedPictureInfo3.j()) {
            if (this.isLongImg) {
                i3 = this.longImgModeWidth;
                i16 = i3 - AreaConst.dp54;
                i17 = this.longImgModeHeight;
                i18 = AreaConst.dp20;
            } else {
                i3 = this.picWidth;
                i16 = i3 - AreaConst.dp54;
                i17 = this.picHeight;
                i18 = AreaConst.dp20;
            }
            int i46 = i17 - i18;
            if (AreaManager.LONG_PICS_BROWSING_DRAWABLE == null) {
                AreaManager.LONG_PICS_BROWSING_DRAWABLE = j.g(944);
            }
            AreaManager.LONG_PICS_BROWSING_DRAWABLE.setBounds(i16, i46, i3, i17);
            AreaManager.LONG_PICS_BROWSING_DRAWABLE.draw(canvas);
        }
        if (this.linePaint == null) {
            Paint paint = new Paint();
            this.linePaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.linePaint.setColor(j.c(10));
        }
        if ((this.flag & LEFT_MASK) != 0) {
            canvas.drawRect(0.0f, 0.0f, com.qzone.proxy.feedcomponent.d.f50146c, this.picHeight, this.linePaint);
        }
        if ((this.flag & TOP_MASK) != 0) {
            canvas.drawRect(0.0f, 0.0f, this.picWidth, com.qzone.proxy.feedcomponent.d.f50146c, this.linePaint);
        }
        if ((this.flag & RIGHT_MASK) != 0) {
            canvas.drawRect(r0 - com.qzone.proxy.feedcomponent.d.f50146c, 0.0f, this.picWidth, this.picHeight, this.linePaint);
        }
        if ((this.flag & BOTTOM_MASK) != 0) {
            canvas.drawRect(0.0f, r0 - com.qzone.proxy.feedcomponent.d.f50146c, this.picWidth, this.picHeight, this.linePaint);
        }
        if (this.mBottomView != null && (businessFeedData = this.feedData) != null && businessFeedData.isQCircleRecommFeed()) {
            this.mBottomView.draw(canvas, this.picHeight, this.picWidth);
        }
        canvas.restore();
        if (d.f(this.errCode)) {
            if (d.g(this.errCode)) {
                String j3 = d.j(this.errCode);
                if (TextUtils.isEmpty(j3)) {
                    return;
                }
                d.a(canvas, j3, this.picWidth, this.picHeight, this.mPaddingLeft);
                return;
            }
            d.b(canvas, this.picWidth, this.picHeight, this.errCode, this.mPaddingLeft);
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        FeedPictureInfo.ImageType imageType;
        if (this.isLongImg && (((imageType = this.mImageType) == FeedPictureInfo.ImageType.NORMAL || imageType == FeedPictureInfo.ImageType.IMAGE_GOLDEN_CUDGEL) && isValidLongPicDrawable())) {
            View attachedView = getAttachedView();
            if (attachedView != null && attachedView.getWidth() > 0) {
                this.longImgModeWidth = attachedView.getWidth() / 2;
                this.longImgModeHeight = attachedView.getWidth();
            } else {
                this.longImgModeWidth = FeedGlobalEnv.g().getScreenWidth() / 2;
                this.longImgModeHeight = FeedGlobalEnv.g().getScreenWidth();
            }
            setMeasuredDimension(this.longImgModeWidth, this.longImgModeHeight);
            return;
        }
        setMeasuredDimension(this.picWidth, this.picHeight);
    }

    public void onPause() {
        y yVar = this.autoGifDrawable;
        if (yVar != null) {
            yVar.m();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        if (!i.H().g1() && this.preOpt != null) {
            ImageLoader.getInstance(FeedGlobalEnv.getContext()).cancel(this.preUrl, new PicListener(), this.preOpt);
            FeedGlobalEnv.g().getAsyncRenderHandler().removeCallbacks(this.mPreRenderImageTagTask);
        }
        y yVar = this.autoGifDrawable;
        if (yVar != null) {
            yVar.j();
        }
        this.preOpt = null;
        this.preUrl = null;
        this.preImageUrl = null;
        this.singleDrawable = null;
        this.autoGifDrawable = null;
        this.needLayout = false;
        this.photoTag = null;
        this.curPictureInfo = null;
        this.mMaskLayout = null;
        this.hasPrintSinglePicLog = false;
        globalUniNum = getUniNum();
        this.picWidth = 0;
        this.picHeight = 0;
        this.errCode = null;
        this.hasSummary = false;
    }

    public void onStateIdle() {
        DittoHost dittoHost;
        if (this.singleDrawable == AreaManager.DEFAULT_BACKGROUND && this.preOpt != null) {
            Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(this.preImageUrl, this.preUrl, new PicListener(), this.preOpt);
            this.singleDrawable = loadImage;
            if (loadImage != null) {
                this.picHeight = loadImage.getIntrinsicHeight();
                int intrinsicWidth = this.singleDrawable.getIntrinsicWidth();
                this.picWidth = intrinsicWidth;
                int min = Math.min(intrinsicWidth, AreaConst.getDefaultWidth());
                int i3 = this.picWidth;
                if (i3 > 0) {
                    this.picHeight = (this.picHeight * min) / i3;
                }
                this.picWidth = min;
            } else {
                this.singleDrawable = AreaManager.DEFAULT_BACKGROUND;
            }
        }
        if (this.needLayout) {
            requestLayout();
            this.needLayout = false;
        }
        Drawable drawable = this.singleDrawable;
        if (drawable != null && drawable != AreaManager.DEFAULT_BACKGROUND) {
            invalidate();
        }
        if (this.templateShuoshuoTextArea != null && (dittoHost = this.mHost) != null) {
            View containerView = dittoHost.getContainerView();
            int[] iArr = new int[2];
            if (containerView != null) {
                containerView.getLocationOnScreen(iArr);
                int height = getHeight();
                int top = iArr[1] + containerView.getTop();
                int i16 = (height * 1) / 2;
                boolean z16 = g.a(75.0f) - top < i16;
                boolean z17 = FeedGlobalEnv.g().getScreenHeight() - top > i16;
                if (z16 && z17) {
                    this.templateShuoshuoTextArea.setAnimationEnabled(true);
                    this.templateShuoshuoTextArea.invalidate();
                    return;
                }
                this.templateShuoshuoTextArea.setAnimationEnabled(false);
            }
        }
        playGif();
    }

    public void onStateScrolling() {
        TemplateFeedTextArea templateFeedTextArea = this.templateShuoshuoTextArea;
        if (templateFeedTextArea != null) {
            templateFeedTextArea.setAnimationEnabled(false);
        }
        y yVar = this.autoGifDrawable;
        if (yVar != null) {
            yVar.m();
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isInPicArea(motionEvent.getX(), motionEvent.getY())) {
            cancelLongPressed();
            return false;
        }
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        this.mClickPosX = motionEvent.getX();
        if (motionEvent.getAction() == 0) {
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
            if (this.clickListener != null) {
                this.isLongPressed = true;
                if (this.longClickListener != null) {
                    checkLongClickEvent(motionEvent);
                }
            }
        } else if (motionEvent.getAction() != 2) {
            if (motionEvent.getAction() == 1) {
                if (this.clickListener != null && this.isLongPressed) {
                    cancelLongPressed();
                    if (!checkClickOutside(x16, y16)) {
                        this.clickListener.onClick(this, null, null);
                        if (this.feedData.isQCircleShareCardFeed()) {
                            i.H().f(805, 3, 2);
                        }
                    }
                }
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 4) {
                cancelLongPressed();
            }
        }
        this.mClickPosX = -1.0f;
        return true;
    }

    protected void playGif() {
        FeedPictureInfo feedPictureInfo;
        if (this.canAutoPlayGif) {
            DittoHost dittoHost = this.mHost;
            if (dittoHost != null) {
                View containerView = dittoHost.getContainerView();
                int[] iArr = new int[2];
                if (containerView != null) {
                    containerView.getLocationOnScreen(iArr);
                    int height = getHeight();
                    int top = iArr[1] + containerView.getTop();
                    boolean z16 = g.a(75.0f) - top < (height * 1) / 3;
                    boolean z17 = FeedGlobalEnv.g().getScreenHeight() - top > (height * 2) / 3;
                    BusinessFeedData businessFeedData = this.feedData;
                    boolean z18 = businessFeedData != null && businessFeedData.feedType == 2;
                    if ((z16 && z17) || z18) {
                        if (this.autoGifDrawable == null && (feedPictureInfo = this.curPictureInfo) != null && feedPictureInfo.d() == FeedPictureInfo.ImageType.IMAGE_GIF && this.curPictureInfo.i()) {
                            ImageLoader.Options gifOptions = getGifOptions();
                            y yVar = new y();
                            this.autoGifDrawable = yVar;
                            String str = this.curPictureInfo.b().url;
                            FeedGlobalEnv.g();
                            yVar.d(str, gifOptions, FeedGlobalEnv.getContext(), this, null);
                        }
                        y yVar2 = this.autoGifDrawable;
                        if (yVar2 != null) {
                            yVar2.l();
                            return;
                        }
                        return;
                    }
                    this.autoGifDrawable = null;
                }
            }
            y yVar3 = this.autoGifDrawable;
            if (yVar3 != null) {
                yVar3.m();
            }
        }
    }

    public void setCanAutoPlayGif(boolean z16) {
        this.canAutoPlayGif = z16;
    }

    public void setFlag(int i3) {
        this.flag = i3;
    }

    public void setIsForward(boolean z16) {
        this.isForward = z16;
    }

    public void setIsPassive(boolean z16) {
        this.isPassive = z16;
    }

    public void setPaddingLeft(int i3) {
        this.mPaddingLeft = i3;
    }

    public void setPaddingTop(int i3) {
        this.mPaddingTop = i3;
    }

    public void setPicInfo(BusinessFeedData businessFeedData, FeedPictureInfo feedPictureInfo, int i3, int i16, Context context, boolean z16) {
        TemplateFeedTextArea templateFeedTextArea;
        this.curFeedData = businessFeedData;
        this.hasSummary = (businessFeedData == null || businessFeedData.getCellSummaryV2() == null || TextUtils.isEmpty(businessFeedData.getCellSummaryV2().displayStr)) ? false : true;
        this.curPictureInfo = feedPictureInfo;
        this.isBizRecomFeeds = z16;
        this.feedData = businessFeedData;
        if (businessFeedData != null) {
            this.isSubSingleAdvContainer = businessFeedData.isSubOfSingleAdvContainerFeed();
            this.isSubMultiAdvContainer = businessFeedData.isSubOfMultiAdvContainerFeed();
            this.isSubSingleAdvContainer = businessFeedData.isSubOfSingleAdvContainerFeed();
            this.isNewAdvStyle = businessFeedData.isNewAdvStyle();
        }
        initImageType(feedPictureInfo);
        ImageLoader.Options normalOptions = getNormalOptions(feedPictureInfo);
        String str = feedPictureInfo.h().url;
        normalOptions.obj = Integer.valueOf(this.mUni);
        normalOptions.extraProcessor = feedPictureInfo.c();
        normalOptions.processor = feedPictureInfo.g();
        normalOptions.clipHeight = i16;
        normalOptions.clipWidth = i3;
        normalOptions.preferQuality = false;
        this.height = i16;
        this.width = i3;
        if (feedPictureInfo.f50252o) {
            normalOptions.imageConfig = Bitmap.Config.ARGB_8888;
        }
        if (feedPictureInfo.h().width > 0 && feedPictureInfo.h().height > 0 && FeedContent.isGoldenCudgel(feedPictureInfo.h().width, feedPictureInfo.h().height)) {
            normalOptions.preferQuality = true;
        }
        ArrayList<stPhotoTag> arrayList = feedPictureInfo.f50258u;
        if (arrayList != null) {
            arrayList.size();
        }
        initGifDrawable(feedPictureInfo);
        initSingalDrawable(feedPictureInfo, normalOptions);
        initSize(feedPictureInfo, false);
        this.preUrl = str;
        this.preImageUrl = feedPictureInfo.h().imageUrl;
        this.preOpt = normalOptions;
        if (i.f41888b && businessFeedData != null && businessFeedData.getFeedCommInfoV2() != null) {
            this.feedskey = businessFeedData.getFeedCommInfoV2().feedskey;
            this.clientkey = businessFeedData.getFeedCommInfoV2().clientkey;
            this.ugckey = businessFeedData.getFeedCommInfoV2().ugckey;
        }
        if (isTemplateShuoshuo(this.curPictureInfo, businessFeedData) && (templateFeedTextArea = this.templateShuoshuoTextArea) != null) {
            if (businessFeedData != null) {
                templateFeedTextArea.setAnimationProgress(businessFeedData.fadedTimeScale);
            }
            this.templateShuoshuoTextArea.setAnimationListener(new TextCellLayout.l() { // from class: com.qzone.canvasui.widget.FeedSinglePicCanvasArea.1
                @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.l
                public void onProgressChanged(long j3) {
                    com.qzone.proxy.feedcomponent.b.c("FADELOG", "progress: " + j3);
                    FeedSinglePicCanvasArea.this.feedData.fadedTimeScale = (int) j3;
                }
            });
        }
        if (this.hasSummary) {
            setPadding(this.mPaddingLeft, AreaConst.dp9, getPaddingRight(), getPaddingBottom());
        } else if (z16) {
            setPadding(this.mPaddingLeft, -AreaConst.f48749dp4, getPaddingRight(), getPaddingBottom());
        } else {
            setPadding(this.mPaddingLeft, 0, getPaddingRight(), getPaddingBottom());
        }
        if (businessFeedData != null && businessFeedData.isQCircleRecommFeed()) {
            CanvasQcircleRecomBottomView canvasQcircleRecomBottomView = this.mBottomView;
            if (canvasQcircleRecomBottomView == null) {
                this.mBottomView = new CanvasQcircleRecomBottomView(getContext(), businessFeedData, false);
            } else {
                canvasQcircleRecomBottomView.resetFeedData(businessFeedData, false);
                this.mBottomView.postInvalidate();
            }
            this.mBottomView.setVisibility(0);
            return;
        }
        this.mBottomView = null;
    }

    private void cancelLongPressed() {
        this.isLongPressed = false;
        AlarmTask alarmTask = this.mAlarmTask;
        if (alarmTask != null) {
            alarmTask.cancelAlarm();
        }
    }

    public void fitQcircleShareFeed() {
        int[] fitQcircleShareFeed = QcircleShareFeedSizeUtil.fitQcircleShareFeed(new int[]{this.picWidth, this.picHeight});
        this.picWidth = fitQcircleShareFeed[0];
        this.picHeight = fitQcircleShareFeed[1];
    }

    public boolean isTemplateShuoshuo(FeedPictureInfo feedPictureInfo, BusinessFeedData businessFeedData) {
        return ((feedPictureInfo == null || TextUtils.isEmpty(feedPictureInfo.f50263z)) && (businessFeedData == null || businessFeedData.getAudioInfo() == null || businessFeedData.getAudioInfo().size() <= 0)) ? false : true;
    }
}
