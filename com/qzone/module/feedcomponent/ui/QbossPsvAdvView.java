package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.SubAreaShell;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellQbossPsvAdv;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.QUA;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes39.dex */
public class QbossPsvAdvView extends ViewGroup implements r, AutoGifDrawable.AutoGifCallback {
    private static final int ANIM_REFRESH = 1209;
    private static final String ARK_BANNER_APP_NAME = "com.tencent.qzone.banner";
    private static final String ARK_BANNER_APP_NAME_FOR_NOTIFY = "com.tencent.vas.psvFeeds";
    private static final String ARK_FROM_PAGE = "psvFeeds";
    private static final double BREATH_BTN_MAX_SCALE_PERIOD = 0.15d;
    private static final long BREATH_BTN_SCALE_PERIOD = 1000;
    public static final String BUTTON_SITE_CENTER = "0";
    public static final String BUTTON_SITE_RIGHT_BOTTOM = "1";
    private static final int PIC_DOWNLOADED = 1208;
    private static final int PSV_ADV_TYPE_NO_CONTENT = 0;
    private static final long SLIDE_DUATION = 340;
    private static final long SLIDE_WAIT_TIME = 100;
    private static final String TAG = "QbossPsvAdvView";
    private int adsType;
    FeedPictureInfo backgdPictureInfo;
    private double breathBtnScale;
    boolean empty;
    FeedBitmap feedBitmap;
    int feedPosition;
    int floatDrawWidth;
    int floatHeight;
    FeedPictureInfo floatPictureInfo;
    int floatWidth;
    Paint gapPaint;
    private boolean hasSlide;
    private boolean isArkAdsType;
    private boolean isArkLoaded;
    private boolean isBreathBtn;
    private boolean isCountDownBegin;
    boolean isRecycled;
    private long lastDrawTime;
    int leftPicHeight;
    int leftPicWidth;
    FeedPictureInfo leftThumbPictureInfo;
    protected SubAreaShell mBackgroud;
    protected final DrawUrlPicArea mBackgroundArea;
    protected final DrawPicArea mCloseButtonArea;
    private Runnable mCountDownRunnable;
    protected FeedTextArea mCountDownSummary;
    long mCountDownTime;
    BusinessFeedData mFeedData;
    protected AutoGifDrawable mFloatGifDrawable;
    private String mFloatGifUrl;
    int mHeight;
    protected AutoGifDrawable mLeftGifDrawable;
    private String mLeftGifUrl;
    protected Drawable mLeftNormalDrawable;
    protected SubAreaShell mLeftThumbSummary;
    protected SubAreaShell mLeftThumbTitle;
    CellQbossPsvAdv mQbossPsvAdv;
    protected SubAreaShell mRightButton;
    protected SubAreaShell mRightCloseButton;
    private final int mTopGap;
    int mTrans;
    private Handler mainHandler;
    private boolean needLeftImgSlide;
    protected SubAreaShell.OnAreaClickListener onAreaClickListener;
    com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    protected View.OnClickListener onViewClickListener;
    int photoMode;
    private PicListener picListener;
    private String rightButtonSite;
    private long slideSetTime;
    protected SubAreaShell touchingArea;
    static int DEFAULT_WIDTH = FeedGlobalEnv.g().getScreenWidth();
    static final int DEFAULT_ADS_TYPE_PIC_WIDTH = com.qzone.adapter.feedcomponent.b.f41876w;
    static final int DEFAULT_FLOAT_WIDTH = com.qzone.proxy.feedcomponent.util.g.a(250.0f);
    static final int DEFAULT_FLOAT_HEIGHT = com.qzone.proxy.feedcomponent.util.g.a(100.0f);
    private static final Set<Integer> ANIM_DATA_CACHE_MAP = Collections.newSetFromMap(new ConcurrentHashMap());
    static final Rect rectDsc = new Rect();
    static final Rect rectSrc = new Rect();

    public QbossPsvAdvView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.picListener = new PicListener();
        this.mCloseButtonArea = new DrawPicArea();
        this.mBackgroundArea = new DrawUrlPicArea();
        this.mTopGap = AreaConst.dp15;
        this.photoMode = 0;
        this.mTrans = 255;
        this.isArkLoaded = false;
        this.onViewClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.QbossPsvAdvView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QbossPsvAdvView qbossPsvAdvView;
                com.qzone.proxy.feedcomponent.ui.g gVar;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!QbossPsvAdvView.this.isArkAdsType && (gVar = (qbossPsvAdvView = QbossPsvAdvView.this).onFeedElementClickListener) != null) {
                    gVar.onClick(view, FeedElement.FEED_QBOSS_PSV_ADV_AREA, qbossPsvAdvView.feedPosition, qbossPsvAdvView.mQbossPsvAdv);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.onAreaClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.QbossPsvAdvView.2
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                QbossPsvAdvView qbossPsvAdvView;
                com.qzone.proxy.feedcomponent.ui.g gVar;
                if (QbossPsvAdvView.this.isArkAdsType || (gVar = (qbossPsvAdvView = QbossPsvAdvView.this).onFeedElementClickListener) == null) {
                    return;
                }
                if (qbossPsvAdvView.mRightCloseButton != subAreaShell) {
                    gVar.onClick(qbossPsvAdvView, FeedElement.FEED_QBOSS_PSV_ADV_AREA, qbossPsvAdvView.feedPosition, qbossPsvAdvView.mQbossPsvAdv);
                } else {
                    gVar.onClick(qbossPsvAdvView, FeedElement.FEED_QBOSS_PSV_ADV_DELETE, qbossPsvAdvView.feedPosition, qbossPsvAdvView.mQbossPsvAdv);
                }
            }
        };
        this.isCountDownBegin = false;
        this.mCountDownRunnable = new Runnable() { // from class: com.qzone.module.feedcomponent.ui.QbossPsvAdvView.3
            @Override // java.lang.Runnable
            public void run() {
                QbossPsvAdvView qbossPsvAdvView = QbossPsvAdvView.this;
                if (qbossPsvAdvView.mQbossPsvAdv != null) {
                    qbossPsvAdvView.mCountDownTime = (System.currentTimeMillis() / 1000) - QbossPsvAdvView.this.mQbossPsvAdv.getCountDownTime();
                    AreaManager areaManager = AreaManager.getInstance();
                    CellQbossPsvAdv cellQbossPsvAdv = QbossPsvAdvView.this.mQbossPsvAdv;
                    SubArea leftThumbAdsSummaryArea = areaManager.getLeftThumbAdsSummaryArea(cellQbossPsvAdv, cellQbossPsvAdv.getSummaryKey());
                    if (leftThumbAdsSummaryArea != null) {
                        QbossPsvAdvView.this.mLeftThumbSummary = SubAreaShell.obtain(leftThumbAdsSummaryArea);
                    }
                    QbossPsvAdvView qbossPsvAdvView2 = QbossPsvAdvView.this;
                    if (qbossPsvAdvView2.mLeftThumbSummary != null) {
                        qbossPsvAdvView2.postInvalidate();
                    }
                    QbossPsvAdvView.this.invalidate();
                    QbossPsvAdvView qbossPsvAdvView3 = QbossPsvAdvView.this;
                    if (!qbossPsvAdvView3.isRecycled || qbossPsvAdvView3.mCountDownTime <= 0) {
                        qbossPsvAdvView3.postDelayed(qbossPsvAdvView3.mCountDownRunnable, 1000L);
                    }
                }
            }
        };
        this.mainHandler = new Handler(Looper.getMainLooper()) { // from class: com.qzone.module.feedcomponent.ui.QbossPsvAdvView.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message == null) {
                    return;
                }
                int i3 = message.what;
                if (i3 == 1208) {
                    QbossPsvAdvView.this.invalidate();
                    return;
                }
                if (i3 != 1209) {
                    return;
                }
                QbossPsvAdvView.this.invalidate();
                if (QbossPsvAdvView.this.needLeftImgSlide || QbossPsvAdvView.this.isBreathBtn) {
                    QbossPsvAdvView.this.mainHandler.sendEmptyMessageDelayed(1209, 20L);
                }
            }
        };
        init();
    }

    private String arkMetaDataBuilderForBannerApp(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap3.put("uin", FeedGlobalEnv.g().getUin() + "");
        hashMap2.put(ITVKPlayerEventListener.KEY_USER_INFO, hashMap3);
        hashMap2.put("ua", QUA.getQUA3());
        hashMap2.put("from", ARK_FROM_PAGE);
        hashMap2.put("data", jSONObject);
        hashMap.put("indexData", hashMap2);
        return new JSONObject(hashMap).toString();
    }

    private void beginCountDown() {
        if (this.isCountDownBegin || getHandler() == null) {
            return;
        }
        getHandler().postDelayed(this.mCountDownRunnable, 1000L);
        this.isCountDownBegin = true;
    }

    private boolean canPlayGif() {
        return com.qzone.adapter.feedcomponent.i.H().k();
    }

    public static void cleanCache() {
        ANIM_DATA_CACHE_MAP.clear();
    }

    private ImageLoader.Options getLeftPicOption() {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        int i3 = this.leftPicWidth;
        this.floatDrawWidth = i3;
        obtain.clipHeight = i3;
        obtain.clipWidth = this.leftPicHeight;
        obtain.preferQuality = false;
        obtain.extraProcessor = new NormalFeedImageProcessor(this.floatDrawWidth, this.mHeight, 0.5f, 0.0f);
        return obtain;
    }

    private ImageLoader.Options getOption() {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        int i3 = DEFAULT_FLOAT_WIDTH;
        this.floatDrawWidth = i3;
        obtain.clipHeight = i3;
        obtain.clipWidth = DEFAULT_FLOAT_HEIGHT;
        obtain.preferQuality = false;
        obtain.extraProcessor = new NormalFeedImageProcessor(this.floatDrawWidth, this.mHeight, 0.5f, 0.0f);
        return obtain;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        onDraw(canvas);
    }

    SubAreaShell findArea(float f16, float f17) {
        if (isInCloseButtonArea(f16, f17 - getPaddingTop())) {
            return this.mRightCloseButton;
        }
        return null;
    }

    void init() {
        setOnClickListener(this.onViewClickListener);
        this.gapPaint = new Paint();
        int i3 = DEFAULT_ADS_TYPE_PIC_WIDTH;
        this.leftPicWidth = i3;
        this.leftPicHeight = i3;
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public void invalidateGifView() {
        invalidate();
    }

    boolean isInCloseButtonArea(float f16, float f17) {
        if (this.mRightCloseButton == null) {
            return false;
        }
        int i3 = DEFAULT_WIDTH - AreaConst.dp22_5;
        int i16 = AreaConst.dp5;
        int i17 = i3 + i16;
        int i18 = AreaConst.dp28 + i16;
        int i19 = AreaConst.dp20;
        return ((float) (i18 + i19)) > f17 && ((float) (i18 - i19)) < f17 && ((float) (i17 + i19)) > f16 && ((float) (i17 - i19)) < f16;
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public boolean isListViewScrollIdle() {
        return com.qzone.adapter.feedcomponent.i.H().g1();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(DEFAULT_WIDTH, this.mHeight);
    }

    public void onStateIdle() {
        FeedPictureInfo feedPictureInfo;
        if (canPlayGif() && (feedPictureInfo = this.leftThumbPictureInfo) != null && feedPictureInfo.i()) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i3 = iArr[1];
            boolean z16 = com.qzone.proxy.feedcomponent.util.g.a(75.0f) - i3 < (this.mHeight * 1) / 3;
            boolean z17 = FeedGlobalEnv.g().getScreenHeight() - i3 > (this.mHeight * 2) / 3;
            if (z16 && z17) {
                AutoGifDrawable autoGifDrawable = this.mLeftGifDrawable;
                if (autoGifDrawable != null) {
                    autoGifDrawable.start();
                } else {
                    AutoGifDrawable newAutoGifDrawable = AutoGifDrawable.newAutoGifDrawable();
                    this.mLeftGifDrawable = newAutoGifDrawable;
                    String str = this.mFloatGifUrl;
                    ImageLoader.Options leftPicOption = getLeftPicOption();
                    FeedGlobalEnv.g();
                    newAutoGifDrawable.init(str, leftPicOption, FeedGlobalEnv.getContext(), this);
                }
                AutoGifDrawable autoGifDrawable2 = this.mFloatGifDrawable;
                if (autoGifDrawable2 != null) {
                    autoGifDrawable2.start();
                    return;
                }
                AutoGifDrawable newAutoGifDrawable2 = AutoGifDrawable.newAutoGifDrawable();
                this.mFloatGifDrawable = newAutoGifDrawable2;
                String str2 = this.mFloatGifUrl;
                ImageLoader.Options option = getOption();
                FeedGlobalEnv.g();
                newAutoGifDrawable2.init(str2, option, FeedGlobalEnv.getContext(), this);
                return;
            }
        }
        AutoGifDrawable autoGifDrawable3 = this.mLeftGifDrawable;
        if (autoGifDrawable3 != null) {
            autoGifDrawable3.stop();
        }
        AutoGifDrawable autoGifDrawable4 = this.mFloatGifDrawable;
        if (autoGifDrawable4 != null) {
            autoGifDrawable4.stop();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        SubAreaShell findArea = findArea(motionEvent.getX(), motionEvent.getY());
        SubAreaShell subAreaShell = this.touchingArea;
        if (findArea != subAreaShell) {
            if (subAreaShell != null) {
                subAreaShell.clearTouchingEvent();
            }
            this.touchingArea = findArea;
        }
        if (findArea != null) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.offsetLocation(findArea.getLeft() * (-1), findArea.getTop() * (-1));
            boolean onTouchEvent = findArea.onTouchEvent(obtain);
            obtain.recycle();
            if (onTouchEvent) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void reset() {
        SubAreaShell.recycle(this.mLeftThumbSummary);
        SubAreaShell.recycle(this.mLeftThumbTitle);
        SubAreaShell.recycle(this.mRightButton);
        SubAreaShell.recycle(this.mRightCloseButton);
        SubAreaShell.recycle(this.mBackgroud);
        this.mHeight = 0;
        this.mLeftThumbSummary = null;
        this.mLeftThumbTitle = null;
        this.mRightButton = null;
        this.mRightCloseButton = null;
        this.mBackgroud = null;
        this.empty = true;
        this.isCountDownBegin = false;
        this.mLeftNormalDrawable = null;
        this.mQbossPsvAdv = null;
        this.needLeftImgSlide = false;
        this.isBreathBtn = false;
        this.mainHandler.removeMessages(1209);
    }

    public void setBusinessFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
    }

    public void setFeedPos(int i3) {
        this.feedPosition = i3;
    }

    public void setFloatPictureInfo(FeedPictureInfo feedPictureInfo) {
        this.floatPictureInfo = feedPictureInfo;
    }

    public void setLeftThumbPictureInfo(FeedPictureInfo feedPictureInfo) {
        this.leftThumbPictureInfo = feedPictureInfo;
    }

    public void setOnElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setPhotoMode(int i3) {
        this.photoMode = i3;
    }

    public void setQbossPsvAdvBackgdPictureInfo(FeedPictureInfo feedPictureInfo) {
        this.backgdPictureInfo = feedPictureInfo;
    }

    public void setTrans(int i3) {
        this.mTrans = i3;
    }

    public void setmQbossPsvAdvData(CellQbossPsvAdv cellQbossPsvAdv) {
        this.mQbossPsvAdv = cellQbossPsvAdv;
        this.lastDrawTime = -1L;
        this.slideSetTime = -1L;
        this.hasSlide = false;
        this.isBreathBtn = false;
        this.needLeftImgSlide = false;
        this.breathBtnScale = 1.0d;
        this.isArkAdsType = false;
        if (cellQbossPsvAdv == null || cellQbossPsvAdv.extendinfo == null) {
            return;
        }
        int hashCode = cellQbossPsvAdv.hashCode();
        Set<Integer> set = ANIM_DATA_CACHE_MAP;
        if (!set.contains(Integer.valueOf(hashCode))) {
            this.needLeftImgSlide = "1030".equals(this.mQbossPsvAdv.extendinfo.get("psv_adv_pattern_id"));
            set.add(Integer.valueOf(hashCode));
        }
        String str = this.mQbossPsvAdv.extendinfo.get("psv_adv_res_data");
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean equals = "1".equals(jSONObject.optString("is_ark_type"));
                this.isArkAdsType = equals;
                if (equals) {
                    jSONObject.optString(QQCustomArkDialogUtil.APP_VIEW);
                    jSONObject.optString("version");
                    arkMetaDataBuilderForBannerApp(jSONObject);
                } else {
                    this.isBreathBtn = "2".equals(jSONObject.optString("button type"));
                    this.rightButtonSite = jSONObject.optString("button_site");
                }
            } catch (JSONException e16) {
                Log.w(TAG, "setmQbossPsvAdvData: failed to parse json" + str, e16);
            }
        }
        if ((this.isArkAdsType || !this.needLeftImgSlide) && !this.isBreathBtn) {
            return;
        }
        this.mainHandler.sendEmptyMessageDelayed(1209, 20L);
    }

    public void update() {
        if (this.mQbossPsvAdv == null || this.isArkAdsType) {
            return;
        }
        this.mHeight = DEFAULT_ADS_TYPE_PIC_WIDTH;
        if (this.adsType == 0) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(getPaddingLeft(), AreaConst.dp6, getPaddingRight(), getPaddingBottom());
        }
        FeedPictureInfo feedPictureInfo = this.leftThumbPictureInfo;
        if (feedPictureInfo != null && feedPictureInfo.h() != null) {
            this.mLeftGifUrl = this.leftThumbPictureInfo.h().url;
            ImageLoader.Options leftPicOption = getLeftPicOption();
            if (canPlayGif() && this.leftThumbPictureInfo.i()) {
                if (this.mLeftGifDrawable == null) {
                    AutoGifDrawable.newAutoGifDrawable();
                    this.mLeftGifDrawable = AutoGifDrawable.newAutoGifDrawable();
                }
                AutoGifDrawable autoGifDrawable = this.mLeftGifDrawable;
                ImageUrl imageUrl = this.leftThumbPictureInfo.h().imageUrl;
                FeedGlobalEnv.g();
                autoGifDrawable.init(imageUrl, leftPicOption, FeedGlobalEnv.getContext(), this);
                this.empty = false;
            } else {
                FeedGlobalEnv.g();
                this.mLeftNormalDrawable = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(this.leftThumbPictureInfo.h().imageUrl, this.mLeftGifUrl, this.picListener, leftPicOption);
            }
        }
        DrawPicArea drawPicArea = this.mCloseButtonArea;
        Drawable closeButtonDrawable = getCloseButtonDrawable();
        int i3 = AreaConst.dp10;
        if (drawPicArea.setData(closeButtonDrawable, i3, i3)) {
            SubAreaShell obtain = SubAreaShell.obtain(this.mCloseButtonArea);
            this.mRightCloseButton = obtain;
            obtain.setParent(this);
            this.mRightCloseButton.setOnClickListener(this.onAreaClickListener);
            this.mRightCloseButton.enableShellClick();
            this.empty = false;
        }
        FeedPictureInfo feedPictureInfo2 = this.backgdPictureInfo;
        if (feedPictureInfo2 != null) {
            this.mBackgroundArea.setData(feedPictureInfo2, DEFAULT_WIDTH, this.mHeight - this.mTopGap, feedPictureInfo2.h().imageUrl);
            SubAreaShell obtain2 = SubAreaShell.obtain(this.mBackgroundArea);
            this.mBackgroud = obtain2;
            obtain2.setParent(this);
            this.mBackgroud.setOnClickListener(this.onAreaClickListener);
            this.empty = false;
        }
        AreaManager areaManager = AreaManager.getInstance();
        CellQbossPsvAdv cellQbossPsvAdv = this.mQbossPsvAdv;
        SubArea leftThumbAdsTitleArea = areaManager.getLeftThumbAdsTitleArea(cellQbossPsvAdv, cellQbossPsvAdv.getTitleKey());
        if (leftThumbAdsTitleArea != null) {
            SubAreaShell obtain3 = SubAreaShell.obtain(leftThumbAdsTitleArea);
            this.mLeftThumbTitle = obtain3;
            obtain3.setParent(this);
            this.mLeftThumbTitle.setOnClickListener(this.onAreaClickListener);
            this.empty = false;
        }
        AreaManager areaManager2 = AreaManager.getInstance();
        CellQbossPsvAdv cellQbossPsvAdv2 = this.mQbossPsvAdv;
        SubArea leftThumbAdsSummaryArea = areaManager2.getLeftThumbAdsSummaryArea(cellQbossPsvAdv2, cellQbossPsvAdv2.getSummaryKey());
        if (leftThumbAdsSummaryArea != null) {
            SubAreaShell obtain4 = SubAreaShell.obtain(leftThumbAdsSummaryArea);
            this.mLeftThumbSummary = obtain4;
            obtain4.setParent(this);
            this.mLeftThumbSummary.setOnClickListener(this.onAreaClickListener);
            this.empty = false;
        }
        AreaManager areaManager3 = AreaManager.getInstance();
        CellQbossPsvAdv cellQbossPsvAdv3 = this.mQbossPsvAdv;
        SubArea rightThumAdsRightBtnArea = areaManager3.getRightThumAdsRightBtnArea(cellQbossPsvAdv3, cellQbossPsvAdv3.getButtonKey());
        if (rightThumAdsRightBtnArea != null) {
            SubAreaShell obtain5 = SubAreaShell.obtain(rightThumAdsRightBtnArea);
            this.mRightButton = obtain5;
            obtain5.setParent(this);
            this.mRightButton.setOnClickListener(this.onAreaClickListener);
            this.empty = false;
        }
        FeedPictureInfo feedPictureInfo3 = this.floatPictureInfo;
        if (feedPictureInfo3 == null || feedPictureInfo3.h() == null) {
            return;
        }
        this.mFloatGifUrl = this.floatPictureInfo.h().url;
        FeedPictureInfo feedPictureInfo4 = this.floatPictureInfo;
        this.floatWidth = feedPictureInfo4.f50256s;
        this.floatHeight = feedPictureInfo4.f50257t;
        ImageLoader.Options option = getOption();
        if (canPlayGif()) {
            if (this.mFloatGifDrawable == null) {
                this.mFloatGifDrawable = AutoGifDrawable.newAutoGifDrawable();
            }
            AutoGifDrawable autoGifDrawable2 = this.mFloatGifDrawable;
            String str = this.mFloatGifUrl;
            FeedGlobalEnv.g();
            autoGifDrawable2.init(str, option, FeedGlobalEnv.getContext(), this);
        }
    }

    /* loaded from: classes39.dex */
    public class PicListener implements ImageLoader.ImageLoadListener {
        public PicListener() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (drawable != null) {
                QbossPsvAdvView qbossPsvAdvView = QbossPsvAdvView.this;
                qbossPsvAdvView.mLeftNormalDrawable = drawable;
                qbossPsvAdvView.mainHandler.sendEmptyMessage(1208);
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.isRecycled = true;
        this.isCountDownBegin = false;
        if (BitmapManager.OPEN_BITMAP) {
            BitmapManager.getInstance().recyle(this.feedBitmap);
            this.feedBitmap = null;
        }
        this.touchingArea = null;
        DrawPicArea drawPicArea = this.mCloseButtonArea;
        if (drawPicArea != null) {
            drawPicArea.onRecycled();
        }
        DrawUrlPicArea drawUrlPicArea = this.mBackgroundArea;
        if (drawUrlPicArea != null) {
            drawUrlPicArea.onRecycled();
        }
        AutoGifDrawable autoGifDrawable = this.mLeftGifDrawable;
        if (autoGifDrawable != null) {
            autoGifDrawable.stop();
            this.mLeftGifDrawable = null;
        }
        this.mLeftNormalDrawable = null;
        AutoGifDrawable autoGifDrawable2 = this.mFloatGifDrawable;
        if (autoGifDrawable2 != null) {
            autoGifDrawable2.stop();
            this.mFloatGifDrawable = null;
        }
        if (this.isArkAdsType) {
            this.isArkLoaded = false;
            ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification(ARK_BANNER_APP_NAME_FOR_NOTIFY, null);
        }
        this.needLeftImgSlide = false;
        this.isBreathBtn = false;
        this.mainHandler.removeMessages(1209);
    }

    public Drawable getCloseButtonDrawable() {
        return com.qzone.adapter.feedcomponent.j.g(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x028d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        float f16;
        float f17;
        Integer num;
        int i3;
        Drawable advTypeDrawble;
        Drawable markTypeDrawable;
        SubAreaShell subAreaShell;
        SubAreaShell subAreaShell2;
        int height;
        int i16;
        int i17;
        int i18;
        CellQbossPsvAdv cellQbossPsvAdv;
        SubAreaShell subAreaShell3;
        FeedBitmap obtainBitmap;
        SubAreaShell subAreaShell4;
        int i19;
        int height2;
        Integer num2;
        if (this.empty || this.mQbossPsvAdv == null || this.isArkAdsType) {
            return;
        }
        long j3 = this.lastDrawTime;
        long currentTimeMillis = System.currentTimeMillis();
        this.lastDrawTime = currentTimeMillis;
        canvas.save();
        canvas.translate(0.0f, getPaddingTop());
        this.gapPaint.setColor(com.qzone.adapter.feedcomponent.j.s());
        this.gapPaint.setAlpha(this.mTrans);
        canvas.drawRect(0.0f, 0.0f, DEFAULT_WIDTH, this.mTopGap, this.gapPaint);
        if (this.mBackgroud != null) {
            canvas.save();
            canvas.translate(0.0f, this.mTopGap);
            this.mBackgroud.draw(canvas, null);
            canvas.restore();
        }
        if (this.needLeftImgSlide && !this.hasSlide) {
            long j16 = this.slideSetTime;
            if (j16 == -1) {
                this.slideSetTime = currentTimeMillis;
            } else if (currentTimeMillis - j16 >= 100) {
                this.hasSlide = true;
            }
            f16 = 0.0f;
            if (this.hasSlide) {
                long j17 = (currentTimeMillis - this.slideSetTime) - 100;
                if (j17 >= SLIDE_DUATION) {
                    this.needLeftImgSlide = false;
                    f17 = 1.0f;
                    f16 = 1.0f;
                    if (f16 < f17) {
                        num = Integer.valueOf(canvas.save());
                        canvas.translate(this.leftPicWidth * (f16 - f17), 0.0f);
                    } else {
                        num = null;
                    }
                    if (this.mLeftGifDrawable != null) {
                        canvas.save();
                        canvas.translate(0.0f, this.mTopGap * 0.5f);
                        canvas.translate(0.0f, AreaConst.f48747dp2);
                        this.mLeftGifDrawable.draw(canvas, this.leftPicWidth, (int) (this.leftPicHeight - (this.mTopGap * 0.5f)));
                        canvas.restore();
                    } else if (this.mLeftNormalDrawable != null) {
                        canvas.save();
                        canvas.translate(0.0f, 0.0f);
                        this.mLeftNormalDrawable.setBounds(0, (int) (this.mTopGap * 0.5d), this.leftPicWidth, this.leftPicHeight);
                        this.mLeftNormalDrawable.draw(canvas);
                        canvas.restore();
                    }
                    if (num != null) {
                        canvas.restoreToCount(num.intValue());
                    }
                    i3 = this.mHeight + ((int) (AreaConst.FEED_INTERVAL * 1.5f));
                    advTypeDrawble = getAdvTypeDrawble(this.mQbossPsvAdv.getPsvAdvType());
                    if (advTypeDrawble != null) {
                        advTypeDrawble.setBounds(0, 0, advTypeDrawble.getIntrinsicWidth(), advTypeDrawble.getIntrinsicHeight());
                        advTypeDrawble.draw(canvas);
                    }
                    markTypeDrawable = getMarkTypeDrawable(this.mQbossPsvAdv.getMarkType());
                    if (markTypeDrawable != null) {
                        canvas.save();
                        canvas.translate(0.0f, this.mHeight - AreaConst.dp17);
                        markTypeDrawable.setBounds(0, 0, markTypeDrawable.getIntrinsicWidth(), markTypeDrawable.getIntrinsicHeight());
                        markTypeDrawable.draw(canvas);
                        canvas.restore();
                    }
                    subAreaShell = this.mRightCloseButton;
                    if (subAreaShell != null) {
                        subAreaShell.draw(canvas, null, DEFAULT_WIDTH - AreaConst.dp22_5, AreaConst.dp28);
                    }
                    if (this.mRightButton != null) {
                        if (this.isBreathBtn) {
                            if (j3 == -1) {
                                this.breathBtnScale = 1.0d;
                            } else {
                                double d16 = (((currentTimeMillis - j3) * 0.3d) / 1000.0d) + this.breathBtnScale;
                                this.breathBtnScale = d16;
                                if (d16 >= 1.0d && d16 != 1.3d) {
                                    while (true) {
                                        double d17 = this.breathBtnScale;
                                        if (d17 <= 1.3d) {
                                            break;
                                        } else {
                                            this.breathBtnScale = d17 - 0.3d;
                                        }
                                    }
                                } else {
                                    this.breathBtnScale = 1.0d;
                                }
                            }
                        }
                        int width = (DEFAULT_WIDTH - this.mRightButton.getWidth()) - AreaConst.dp12;
                        if ("1".equals(this.rightButtonSite)) {
                            i19 = this.mTopGap;
                            height2 = (this.mHeight - AreaConst.dp24) - this.mRightButton.getHeight();
                        } else {
                            i19 = this.mTopGap;
                            height2 = ((this.mHeight - i19) - this.mRightButton.getHeight()) / 2;
                        }
                        int i26 = i19 + height2;
                        if (this.breathBtnScale > 1.0d) {
                            num2 = Integer.valueOf(canvas.save());
                            double d18 = this.breathBtnScale;
                            if (d18 > 1.15d) {
                                d18 = 2.3d - d18;
                            }
                            float f18 = (float) d18;
                            Log.i(TAG, "onDraw: " + f18);
                            canvas.scale(f18, f18, (((float) this.mRightButton.getWidth()) / 2.0f) + ((float) width), (((float) this.mRightButton.getHeight()) / 2.0f) + ((float) i26));
                        } else {
                            num2 = null;
                        }
                        this.mRightButton.draw(canvas, null, width, i26);
                        if (num2 != null) {
                            canvas.restoreToCount(num2.intValue());
                        }
                    }
                    subAreaShell2 = this.mLeftThumbTitle;
                    if (subAreaShell2 != null) {
                        i16 = subAreaShell2.getHeight();
                        SubAreaShell subAreaShell5 = this.mLeftThumbSummary;
                        height = subAreaShell5 == null ? 0 : subAreaShell5.getHeight();
                        i17 = height > 0 ? AreaConst.dp5 * (-1) : 0;
                    } else {
                        SubAreaShell subAreaShell6 = this.mLeftThumbSummary;
                        height = subAreaShell6 == null ? 0 : subAreaShell6.getHeight();
                        i16 = 0;
                        i17 = 0;
                    }
                    int i27 = this.mTopGap;
                    i18 = i27 + (((((this.mHeight - i27) - i16) - height) - i17) / 2);
                    if (BitmapManager.OPEN_BITMAP && !this.isRecycled) {
                        BitmapManager.getInstance().recyle(this.feedBitmap);
                        obtainBitmap = BitmapManager.getInstance().obtainBitmap(this.mHeight, URLDrawableHelper.AIO_IMAGE_DEFAULT_BG_COLOR);
                        this.feedBitmap = obtainBitmap;
                        if (obtainBitmap != null) {
                            if (i16 != 0) {
                                SubAreaShell subAreaShell7 = this.mLeftThumbTitle;
                                if (subAreaShell7 != null) {
                                    subAreaShell7.setLeft(i3);
                                    this.mLeftThumbTitle.setTop(i18);
                                    this.mLeftThumbTitle.draw(this.feedBitmap.getCanvas(), null, this.mLeftThumbTitle.getPaddingLeft(), this.mLeftThumbTitle.getPaddingTop() + i18);
                                }
                                this.feedBitmap.isUsed = true;
                            }
                            if (height != 0 && (subAreaShell4 = this.mLeftThumbSummary) != null) {
                                subAreaShell4.setLeft(i3);
                                int i28 = i18 + i16;
                                this.mLeftThumbSummary.setTop(i17 + i28);
                                this.mLeftThumbSummary.draw(this.feedBitmap.getCanvas(), null, this.mLeftThumbSummary.getPaddingLeft(), i28 + this.mLeftThumbSummary.getPaddingTop());
                                this.feedBitmap.isUsed = true;
                            }
                            if (this.feedBitmap.isUsed) {
                                Rect rect = rectSrc;
                                rect.bottom = this.mHeight;
                                rect.right = getWidth() - i3;
                                Rect rect2 = rectDsc;
                                rect2.left = i3;
                                rect2.right = getWidth();
                                rect2.bottom = this.mHeight;
                                rect2.top = 0;
                                canvas.drawBitmap(this.feedBitmap.getBitmap(), rect, rect2, (Paint) null);
                            }
                            canvas.restore();
                            return;
                        }
                    }
                    canvas.save();
                    canvas.translate(i3, i18);
                    if (i16 != 0 && (subAreaShell3 = this.mLeftThumbTitle) != null) {
                        subAreaShell3.setLeft(i3);
                        this.mLeftThumbTitle.setTop(i18);
                        this.mLeftThumbTitle.draw(canvas, null);
                    }
                    if (height != 0 && this.mLeftThumbSummary != null) {
                        canvas.translate(0.0f, i16 + i17);
                        this.mLeftThumbSummary.setLeft(i3);
                        this.mLeftThumbSummary.setTop(i18 + i16 + i17);
                        this.mLeftThumbSummary.draw(canvas, null);
                    }
                    canvas.restore();
                    if (this.mFloatGifDrawable != null && canPlayGif()) {
                        canvas.translate(0.0f, this.mTopGap);
                        this.mFloatGifDrawable.draw(canvas, DEFAULT_FLOAT_WIDTH, this.mHeight - this.mTopGap);
                    }
                    cellQbossPsvAdv = this.mQbossPsvAdv;
                    if (cellQbossPsvAdv != null && cellQbossPsvAdv.getCountDownTime() != 0) {
                        beginCountDown();
                    }
                    canvas.restore();
                }
                f16 = ((float) j17) / 340.0f;
            }
            f17 = 1.0f;
            if (f16 < f17) {
            }
            if (this.mLeftGifDrawable != null) {
            }
            if (num != null) {
            }
            i3 = this.mHeight + ((int) (AreaConst.FEED_INTERVAL * 1.5f));
            advTypeDrawble = getAdvTypeDrawble(this.mQbossPsvAdv.getPsvAdvType());
            if (advTypeDrawble != null) {
            }
            markTypeDrawable = getMarkTypeDrawable(this.mQbossPsvAdv.getMarkType());
            if (markTypeDrawable != null) {
            }
            subAreaShell = this.mRightCloseButton;
            if (subAreaShell != null) {
            }
            if (this.mRightButton != null) {
            }
            subAreaShell2 = this.mLeftThumbTitle;
            if (subAreaShell2 != null) {
            }
            int i272 = this.mTopGap;
            i18 = i272 + (((((this.mHeight - i272) - i16) - height) - i17) / 2);
            if (BitmapManager.OPEN_BITMAP) {
                BitmapManager.getInstance().recyle(this.feedBitmap);
                obtainBitmap = BitmapManager.getInstance().obtainBitmap(this.mHeight, URLDrawableHelper.AIO_IMAGE_DEFAULT_BG_COLOR);
                this.feedBitmap = obtainBitmap;
                if (obtainBitmap != null) {
                }
            }
            canvas.save();
            canvas.translate(i3, i18);
            if (i16 != 0) {
                subAreaShell3.setLeft(i3);
                this.mLeftThumbTitle.setTop(i18);
                this.mLeftThumbTitle.draw(canvas, null);
            }
            if (height != 0) {
                canvas.translate(0.0f, i16 + i17);
                this.mLeftThumbSummary.setLeft(i3);
                this.mLeftThumbSummary.setTop(i18 + i16 + i17);
                this.mLeftThumbSummary.draw(canvas, null);
            }
            canvas.restore();
            if (this.mFloatGifDrawable != null) {
                canvas.translate(0.0f, this.mTopGap);
                this.mFloatGifDrawable.draw(canvas, DEFAULT_FLOAT_WIDTH, this.mHeight - this.mTopGap);
            }
            cellQbossPsvAdv = this.mQbossPsvAdv;
            if (cellQbossPsvAdv != null) {
                beginCountDown();
            }
            canvas.restore();
        }
        f16 = 1.0f;
        if (this.hasSlide) {
        }
        f17 = 1.0f;
        if (f16 < f17) {
        }
        if (this.mLeftGifDrawable != null) {
        }
        if (num != null) {
        }
        i3 = this.mHeight + ((int) (AreaConst.FEED_INTERVAL * 1.5f));
        advTypeDrawble = getAdvTypeDrawble(this.mQbossPsvAdv.getPsvAdvType());
        if (advTypeDrawble != null) {
        }
        markTypeDrawable = getMarkTypeDrawable(this.mQbossPsvAdv.getMarkType());
        if (markTypeDrawable != null) {
        }
        subAreaShell = this.mRightCloseButton;
        if (subAreaShell != null) {
        }
        if (this.mRightButton != null) {
        }
        subAreaShell2 = this.mLeftThumbTitle;
        if (subAreaShell2 != null) {
        }
        int i2722 = this.mTopGap;
        i18 = i2722 + (((((this.mHeight - i2722) - i16) - height) - i17) / 2);
        if (BitmapManager.OPEN_BITMAP) {
        }
        canvas.save();
        canvas.translate(i3, i18);
        if (i16 != 0) {
        }
        if (height != 0) {
        }
        canvas.restore();
        if (this.mFloatGifDrawable != null) {
        }
        cellQbossPsvAdv = this.mQbossPsvAdv;
        if (cellQbossPsvAdv != null) {
        }
        canvas.restore();
    }

    public Drawable getAdvTypeDrawble(int i3) {
        if (i3 == 1) {
            return com.qzone.adapter.feedcomponent.j.g(796);
        }
        if (i3 != 2) {
            return null;
        }
        return com.qzone.adapter.feedcomponent.j.g(797);
    }

    public Drawable getMarkTypeDrawable(int i3) {
        if (i3 == 1) {
            return com.qzone.adapter.feedcomponent.j.g(com.tencent.luggage.wxa.b7.a.CTRL_INDEX);
        }
        if (i3 != 2) {
            return null;
        }
        return com.qzone.adapter.feedcomponent.j.g(800);
    }

    public QbossPsvAdvView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.picListener = new PicListener();
        this.mCloseButtonArea = new DrawPicArea();
        this.mBackgroundArea = new DrawUrlPicArea();
        this.mTopGap = AreaConst.dp15;
        this.photoMode = 0;
        this.mTrans = 255;
        this.isArkLoaded = false;
        this.onViewClickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.QbossPsvAdvView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QbossPsvAdvView qbossPsvAdvView;
                com.qzone.proxy.feedcomponent.ui.g gVar;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!QbossPsvAdvView.this.isArkAdsType && (gVar = (qbossPsvAdvView = QbossPsvAdvView.this).onFeedElementClickListener) != null) {
                    gVar.onClick(view, FeedElement.FEED_QBOSS_PSV_ADV_AREA, qbossPsvAdvView.feedPosition, qbossPsvAdvView.mQbossPsvAdv);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.onAreaClickListener = new SubAreaShell.OnAreaClickListener() { // from class: com.qzone.module.feedcomponent.ui.QbossPsvAdvView.2
            @Override // com.qzone.module.feedcomponent.ui.SubAreaShell.OnAreaClickListener
            public void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell) {
                QbossPsvAdvView qbossPsvAdvView;
                com.qzone.proxy.feedcomponent.ui.g gVar;
                if (QbossPsvAdvView.this.isArkAdsType || (gVar = (qbossPsvAdvView = QbossPsvAdvView.this).onFeedElementClickListener) == null) {
                    return;
                }
                if (qbossPsvAdvView.mRightCloseButton != subAreaShell) {
                    gVar.onClick(qbossPsvAdvView, FeedElement.FEED_QBOSS_PSV_ADV_AREA, qbossPsvAdvView.feedPosition, qbossPsvAdvView.mQbossPsvAdv);
                } else {
                    gVar.onClick(qbossPsvAdvView, FeedElement.FEED_QBOSS_PSV_ADV_DELETE, qbossPsvAdvView.feedPosition, qbossPsvAdvView.mQbossPsvAdv);
                }
            }
        };
        this.isCountDownBegin = false;
        this.mCountDownRunnable = new Runnable() { // from class: com.qzone.module.feedcomponent.ui.QbossPsvAdvView.3
            @Override // java.lang.Runnable
            public void run() {
                QbossPsvAdvView qbossPsvAdvView = QbossPsvAdvView.this;
                if (qbossPsvAdvView.mQbossPsvAdv != null) {
                    qbossPsvAdvView.mCountDownTime = (System.currentTimeMillis() / 1000) - QbossPsvAdvView.this.mQbossPsvAdv.getCountDownTime();
                    AreaManager areaManager = AreaManager.getInstance();
                    CellQbossPsvAdv cellQbossPsvAdv = QbossPsvAdvView.this.mQbossPsvAdv;
                    SubArea leftThumbAdsSummaryArea = areaManager.getLeftThumbAdsSummaryArea(cellQbossPsvAdv, cellQbossPsvAdv.getSummaryKey());
                    if (leftThumbAdsSummaryArea != null) {
                        QbossPsvAdvView.this.mLeftThumbSummary = SubAreaShell.obtain(leftThumbAdsSummaryArea);
                    }
                    QbossPsvAdvView qbossPsvAdvView2 = QbossPsvAdvView.this;
                    if (qbossPsvAdvView2.mLeftThumbSummary != null) {
                        qbossPsvAdvView2.postInvalidate();
                    }
                    QbossPsvAdvView.this.invalidate();
                    QbossPsvAdvView qbossPsvAdvView3 = QbossPsvAdvView.this;
                    if (!qbossPsvAdvView3.isRecycled || qbossPsvAdvView3.mCountDownTime <= 0) {
                        qbossPsvAdvView3.postDelayed(qbossPsvAdvView3.mCountDownRunnable, 1000L);
                    }
                }
            }
        };
        this.mainHandler = new Handler(Looper.getMainLooper()) { // from class: com.qzone.module.feedcomponent.ui.QbossPsvAdvView.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message == null) {
                    return;
                }
                int i36 = message.what;
                if (i36 == 1208) {
                    QbossPsvAdvView.this.invalidate();
                    return;
                }
                if (i36 != 1209) {
                    return;
                }
                QbossPsvAdvView.this.invalidate();
                if (QbossPsvAdvView.this.needLeftImgSlide || QbossPsvAdvView.this.isBreathBtn) {
                    QbossPsvAdvView.this.mainHandler.sendEmptyMessageDelayed(1209, 20L);
                }
            }
        };
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
    }
}
