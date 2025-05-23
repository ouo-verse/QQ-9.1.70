package com.qzone.canvasui.widget;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.util.AlarmTask;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.util.g;
import com.qzone.util.image.d;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasMultiGifArea extends DittoArea implements r, AutoGifDrawable.AutoGifCallback {
    protected static boolean DEBUG = false;
    public static final int DEFAULT_MARGIN;
    public static final float DEFAULT_NUM_TEXTSIZE;
    private static int DEFAULT_SCREEN_WIDTH = 0;
    private static int DEFAULT_SIZE = 0;
    private static int DEFAULT_SIZE_2_PIC = 0;
    private static int DEFAULT_SIZE_2_PIC_FORWARD = 0;
    private static int DEFAULT_SIZE_FULL_COLUMN = 0;
    private static int DEFAULT_SIZE_FULL_COLUMN_FORWARD = 0;
    public static final int DEFAULT_SPACE;
    protected static final String ImageInterval = "image_interval";
    public static final int MSG_IMAGE_DOWNLOAD_FAILED_FLAG = -10;
    public static final int MSG_SET_CANVAS_MULTIC_PIC_DRAWABLE = 5001;
    public static final int MSG_SET_CANVAS_MULTIC_PIC_GIF = 5007;
    public static final int PLAY_NEXT_GIF_DELAY = 200;
    protected static final String SingalImageSize = "singal_image_size";
    protected static String TAG = "CanvasMutiGifSubArea";
    public static final int TYPE_ACTIVEADC_TITLE = 40;
    static final CommentPicListener commentPicListener;
    static Drawable defaultBackground = null;
    protected static boolean gCanAutoPlayGif = false;
    protected static int gGifLoopCount = 1;
    protected static long gGifLoopDuration = 1000;
    protected static boolean gIsOrderPlay;
    static int globalUniNum;
    private static int mImageInterval;
    private static int mImageSize;
    static final MultiPicListener picinfoDownloadListener;
    private static float sGDTfactor;
    public int MAX_DISPLAY_PIC_NUM;
    public int PLAY_ICON_VALUE;
    float downX;
    float downY;
    protected Rect gGifDisplayRect;
    protected AutoGifDrawable.GifDownloadCallBackListener gifDownloadCallBackListener;
    protected NewGifDrawable.GifPlayListener gifPlayListener;
    private boolean hasSetImageInterval;
    private boolean hasSetImageSize;
    private boolean hasSumm;
    int iKey;
    private boolean isForward;
    private boolean isLongPressed;
    public boolean isQunFeed;
    private boolean isUsePicInfo;
    private boolean ismIsQCircleRecommFeed;
    protected volatile int lazyPlayCount;
    protected volatile int lazyUpdateCount;
    private AlarmTask mAlarmTask;
    private WeakReference<CanvasMultiGifArea> mArea;
    protected ArrayList<AutoGifDrawable> mAutoGifDrawable;
    CanvasQcircleRecomBottomView mBottomView;
    private int mColumnNum;
    protected volatile AutoGifDrawable mCurPlayGif;
    protected volatile int mCurPlayGifIndex;
    final List<Drawable> mDraws;
    BusinessFeedData mFeedData;
    protected volatile long mGifLoopStartTime;
    protected ImageProcessor mGifProcessor;
    protected int mGifTotalCount;
    private int mHeight;
    private Map<String, Long> mImageLoadingTimes;
    boolean mIsBrandOptimization;
    boolean mIsGDTPic;
    private ConcurrentHashMap<Integer, String> mPicDownloadInfoMap;
    ArrayList<FeedPictureInfo> mPicInfos;
    private int mPicItemHeight;
    private int mPicItemWidth;
    private int mPicNum;
    private int mPicSize;
    public ArrayList<PictureItem> mPictureItems;
    private int mRowNum;
    int mSelectedPos;
    public int mUPloadNum;
    private int mWidth;
    public Handler mainHanlder;
    private Paint myPaint;
    boolean needReInvalidate;
    Object objectLock;
    private AlarmTask.OnAlarmListener onAlarmListener;
    protected Runnable playGifRunnable;
    public int playingTextHeight;
    public int playingTextWidth;
    CopyOnWriteArrayList<Drawable> tempDraws;
    protected Runnable updateGifRunnable;
    static ImageLoader loader = ImageLoader.getInstance(FeedGlobalEnv.getContext());
    static final RectF rect = new RectF();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.canvasui.widget.CanvasMultiGifArea$6, reason: invalid class name */
    /* loaded from: classes39.dex */
    public static /* synthetic */ class AnonymousClass6 {
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
                $SwitchMap$com$qzone$proxy$feedcomponent$model$FeedPictureInfo$ImageType[FeedPictureInfo.ImageType.IMAGE_GOLDEN_CUDGEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$model$FeedPictureInfo$ImageType[FeedPictureInfo.ImageType.BALL_PANORAMA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$model$FeedPictureInfo$ImageType[FeedPictureInfo.ImageType.CIRCLE_PANORAMA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class ClickedPos {
        public boolean isMask;
        public int selectedPos;

        public ClickedPos(int i3, boolean z16) {
            this.selectedPos = i3;
            this.isMask = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class DownloadedUpdateGifRunnable implements Runnable {
        Drawable drawable;
        ImageLoader.Options options;
        String url;

        public DownloadedUpdateGifRunnable(String str, Drawable drawable, ImageLoader.Options options) {
            this.url = str;
            this.drawable = drawable;
            this.options = options;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Drawable drawable;
            CanvasMultiGifArea canvasMultiGifArea;
            ImageLoader.Options options = this.options;
            if (options == null || (obj = options.obj) == null || (drawable = this.drawable) == null || !(drawable instanceof NewGifDrawable) || !(obj instanceof CanvasMultiGifArea) || (canvasMultiGifArea = (CanvasMultiGifArea) obj) == null || CanvasMultiGifArea.globalUniNum != options.arg1) {
                return;
            }
            DrawableHolderV2 obtain = DrawableHolderV2.obtain();
            AutoGifDrawable newAutoGifDrawable = AutoGifDrawable.newAutoGifDrawable();
            String str = this.url;
            ImageLoader.Options options2 = this.options;
            FeedGlobalEnv.g();
            newAutoGifDrawable.init(str, options2, FeedGlobalEnv.getContext(), CanvasMultiGifArea.this);
            obtain.autoGifDrawable = newAutoGifDrawable;
            obtain.picArea = canvasMultiGifArea;
            Handler handler = AreaManager.mainHanlder;
            ImageLoader.Options options3 = this.options;
            handler.obtainMessage(16, options3.arg1, options3.arg2, obtain).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class DownloadedUpdateGifRunnableforPicInfo implements Runnable {
        Drawable drawable;
        ImageLoader.Options options;
        String url;

        public DownloadedUpdateGifRunnableforPicInfo(String str, Drawable drawable, ImageLoader.Options options) {
            this.url = str;
            this.drawable = drawable;
            this.options = options;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Drawable drawable;
            CanvasMultiGifArea canvasMultiGifArea;
            ImageLoader.Options options = this.options;
            if (options == null || (obj = options.obj) == null || (drawable = this.drawable) == null || !(drawable instanceof NewGifDrawable) || !(obj instanceof CanvasMultiGifArea) || (canvasMultiGifArea = (CanvasMultiGifArea) obj) == null || CanvasMultiGifArea.globalUniNum != options.arg1) {
                return;
            }
            DrawableHolder obtain = DrawableHolder.obtain();
            AutoGifDrawable newAutoGifDrawable = AutoGifDrawable.newAutoGifDrawable();
            String str = this.url;
            ImageLoader.Options options2 = this.options;
            FeedGlobalEnv.g();
            newAutoGifDrawable.init(str, options2, FeedGlobalEnv.getContext(), CanvasMultiGifArea.this);
            obtain.autoGifDrawable = newAutoGifDrawable;
            obtain.picArea = canvasMultiGifArea;
            ImageLoader.Options options3 = this.options;
            CanvasMultiGifArea.setGifArea(canvasMultiGifArea, options3.arg1, options3.arg2, newAutoGifDrawable);
        }
    }

    static {
        int a16 = g.a(2.0f);
        DEFAULT_SPACE = a16;
        int density = (int) (FeedGlobalEnv.g().getDensity() * 8.0f);
        DEFAULT_MARGIN = density;
        int screenWidth = FeedGlobalEnv.g().getScreenWidth();
        DEFAULT_SCREEN_WIDTH = screenWidth;
        DEFAULT_SIZE = ((screenWidth - (density * 2)) - (a16 * 2)) / 3;
        DEFAULT_SIZE_FULL_COLUMN = (screenWidth - (a16 * 2)) / 3;
        DEFAULT_SIZE_2_PIC = (screenWidth - a16) / 2;
        DEFAULT_SIZE_FULL_COLUMN_FORWARD = ((screenWidth - (density * 2)) - (a16 * 2)) / 3;
        DEFAULT_SIZE_2_PIC_FORWARD = ((screenWidth - (density * 2)) - a16) / 2;
        DEFAULT_NUM_TEXTSIZE = FeedGlobalEnv.g().getSpValue(26.0f);
        picinfoDownloadListener = new MultiPicListener();
        commentPicListener = new CommentPicListener();
        defaultBackground = AreaManager.DEFAULT_BACKGROUND;
        sGDTfactor = 0.75f;
    }

    public CanvasMultiGifArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mGifTotalCount = 0;
        this.mGifLoopStartTime = 0L;
        this.mCurPlayGifIndex = 0;
        this.mCurPlayGif = null;
        this.mAutoGifDrawable = new ArrayList<>();
        this.mPictureItems = new ArrayList<>();
        this.mPicInfos = new ArrayList<>();
        this.mImageLoadingTimes = new HashMap();
        this.mSelectedPos = -1;
        this.downX = -1.0f;
        this.downY = -1.0f;
        this.hasSetImageSize = false;
        this.hasSetImageInterval = false;
        this.iKey = -1;
        this.MAX_DISPLAY_PIC_NUM = 9;
        this.PLAY_ICON_VALUE = AreaConst.dp40;
        this.mDraws = new ArrayList();
        this.objectLock = new Object();
        this.mainHanlder = new Handler(Looper.getMainLooper());
        this.mPicDownloadInfoMap = new ConcurrentHashMap<>();
        this.tempDraws = new CopyOnWriteArrayList<>();
        this.gifDownloadCallBackListener = new AutoGifDrawable.GifDownloadCallBackListener() { // from class: com.qzone.canvasui.widget.CanvasMultiGifArea.1
            @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
            public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                CanvasMultiGifArea.this.onGifDownloaded(str, drawable, options);
            }

            @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
            public void onImageFailed(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            }
        };
        this.gifPlayListener = new NewGifDrawable.GifPlayListener() { // from class: com.qzone.canvasui.widget.CanvasMultiGifArea.2
            @Override // com.tencent.component.media.gif.NewGifDrawable.GifPlayListener
            public void onGifStopPlay(NewGifDrawable newGifDrawable) {
                if (CanvasMultiGifArea.gIsOrderPlay) {
                    long curPlayCount = newGifDrawable != null ? newGifDrawable.getCurPlayCount() : TTL.MAX_VALUE;
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean z16 = currentTimeMillis - CanvasMultiGifArea.this.mGifLoopStartTime >= CanvasMultiGifArea.gGifLoopDuration && curPlayCount >= ((long) CanvasMultiGifArea.gGifLoopCount);
                    if (CanvasMultiGifArea.DEBUG && newGifDrawable != null) {
                        b.e("jinqianli", "FeedMutiPicArea#GifPlayListener, onGifStopPlay, mCurPlayGifIndex=" + CanvasMultiGifArea.this.mCurPlayGifIndex + ",curFrameIndex=" + newGifDrawable.getCurrentFrameIndex() + ",numberOfFrames=" + newGifDrawable.getNumberOfFrames() + ",curPlayCount=" + newGifDrawable.getCurPlayCount() + ",loopCount=" + newGifDrawable.getLoopCount() + ", isPlayNext=" + z16);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("FeedMutiPicArea#GifPlayListener, onGifStopPlay, curTime=");
                        sb5.append(currentTimeMillis);
                        sb5.append(", mGifLoopStartTime=");
                        sb5.append(CanvasMultiGifArea.this.mGifLoopStartTime);
                        sb5.append(", gGifLoopDuration=");
                        sb5.append(CanvasMultiGifArea.gGifLoopDuration);
                        b.e("jinqianli", sb5.toString());
                    }
                    if (z16) {
                        if (newGifDrawable != null) {
                            newGifDrawable.setCurPlayCount(0);
                        }
                        CanvasMultiGifArea.this.playNextGif();
                    }
                }
            }

            @Override // com.tencent.component.media.gif.NewGifDrawable.GifPlayListener
            public void onGifStartPlay(NewGifDrawable newGifDrawable) {
                if (newGifDrawable != null && newGifDrawable.getCurPlayCount() == 0) {
                    CanvasMultiGifArea.this.mGifLoopStartTime = System.currentTimeMillis();
                }
                if (!CanvasMultiGifArea.DEBUG || newGifDrawable == null) {
                    return;
                }
                b.e("jinqianli", "FeedMutiPicArea#GifPlayListener, onGifStartPlay, newGifDrawable.getTag()=" + newGifDrawable.getTag() + ", mCurPlayGifIndex=" + CanvasMultiGifArea.this.mCurPlayGifIndex + ",curFrameIndex=" + newGifDrawable.getCurrentFrameIndex() + ",numberOfFrames=" + newGifDrawable.getNumberOfFrames() + ",curPlayCount=" + newGifDrawable.getCurPlayCount() + ",loopCount=" + newGifDrawable.getLoopCount());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("FeedMutiPicArea#GifPlayListener, onGifStartPlay, mGifLoopStartTime=");
                sb5.append(CanvasMultiGifArea.this.mGifLoopStartTime);
                b.e("jinqianli", sb5.toString());
            }

            @Override // com.tencent.component.media.gif.NewGifDrawable.GifPlayListener
            public void onGifPlaying(NewGifDrawable newGifDrawable) {
            }
        };
        this.playGifRunnable = new Runnable() { // from class: com.qzone.canvasui.widget.CanvasMultiGifArea.3
            @Override // java.lang.Runnable
            public void run() {
                CanvasMultiGifArea canvasMultiGifArea = CanvasMultiGifArea.this;
                canvasMultiGifArea.lazyPlayCount--;
                CanvasMultiGifArea canvasMultiGifArea2 = CanvasMultiGifArea.this;
                canvasMultiGifArea2.lazyPlayCount = canvasMultiGifArea2.lazyPlayCount < 0 ? 0 : CanvasMultiGifArea.this.lazyPlayCount;
                CanvasMultiGifArea.this.playNextGif();
            }
        };
        this.updateGifRunnable = new Runnable() { // from class: com.qzone.canvasui.widget.CanvasMultiGifArea.4
            @Override // java.lang.Runnable
            public void run() {
                CanvasMultiGifArea canvasMultiGifArea = CanvasMultiGifArea.this;
                canvasMultiGifArea.lazyUpdateCount--;
                CanvasMultiGifArea canvasMultiGifArea2 = CanvasMultiGifArea.this;
                canvasMultiGifArea2.lazyUpdateCount = canvasMultiGifArea2.lazyUpdateCount < 0 ? 0 : CanvasMultiGifArea.this.lazyUpdateCount;
                CanvasMultiGifArea.this.invalidate();
            }
        };
        this.onAlarmListener = new AlarmTask.OnAlarmListener() { // from class: com.qzone.canvasui.widget.CanvasMultiGifArea.5
            @Override // com.qzone.module.feedcomponent.util.AlarmTask.OnAlarmListener
            public void onAlarm(AlarmTask alarmTask) {
                if (alarmTask == null || !CanvasMultiGifArea.this.isLongPressed) {
                    return;
                }
                CanvasMultiGifArea.this.isLongPressed = false;
                ClickedPos clickPos = CanvasMultiGifArea.this.getClickPos();
                b.c(CanvasMultiGifArea.TAG, "Long click postion: " + clickPos.selectedPos);
                CanvasMultiGifArea.this.performLongClick(alarmTask.mEvent, (String) CanvasMultiGifArea.this.mPicDownloadInfoMap.get(Integer.valueOf(clickPos.selectedPos)));
            }
        };
        if (layoutAttrSet != null) {
            if (layoutAttrSet.hasAttr(SingalImageSize)) {
                setSingalImageSize(layoutAttrSet.getAttr(SingalImageSize, 15));
                this.hasSetImageSize = true;
            } else {
                this.hasSetImageSize = false;
            }
            if (layoutAttrSet.hasAttr(ImageInterval)) {
                setImageInterval(layoutAttrSet.getAttr(ImageInterval, 2));
                this.hasSetImageInterval = true;
            } else {
                this.hasSetImageInterval = false;
            }
        }
        init();
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

    private float getBaseLine(RectF rectF, Paint paint) {
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return ((((rectF.bottom + rectF.top) - fontMetricsInt.bottom) - fontMetricsInt.top) - 2.0f) / 2.0f;
    }

    public static int getDefaultSize() {
        return DEFAULT_SIZE;
    }

    public static int getDefaultSize2PicForward() {
        return DEFAULT_SIZE_2_PIC_FORWARD;
    }

    private ImageLoader.Options getGifOptionsByPciItem(int i3) {
        ArrayList<PictureItem> arrayList = this.mPictureItems;
        if (arrayList == null || arrayList.size() <= i3) {
            return null;
        }
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.obj = getMUltiArea().get();
        obtain.arg1 = this.iKey;
        obtain.arg2 = i3;
        obtain.clipHeight = this.mPicItemHeight;
        obtain.clipWidth = this.mPicItemWidth;
        if (this.mGifProcessor == null) {
            this.mGifProcessor = new NewGifDrawableSpecifiedRegionProcessor(this.mWidth, this.mHeight, this.gGifDisplayRect);
        }
        obtain.extraProcessor = this.mGifProcessor;
        return obtain;
    }

    private ImageLoader.Options getGifOptionsByPicInfo(int i3) {
        int picSize;
        boolean s16 = i.H().s1();
        if (this.hasSetImageSize) {
            picSize = g.a(mImageSize);
        } else {
            picSize = getPicSize(s16, this.isForward, this.mPicNum);
        }
        this.mPicSize = picSize;
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.obj = getMUltiArea().get();
        obtain.arg1 = this.iKey;
        obtain.arg2 = i3;
        if (this.mGifProcessor == null) {
            this.mGifProcessor = new NewGifDrawableSpecifiedRegionProcessor(this.mWidth, this.mHeight, this.gGifDisplayRect);
        }
        obtain.extraProcessor = this.mGifProcessor;
        int i16 = this.mPicSize;
        obtain.clipWidth = i16;
        obtain.clipHeight = i16;
        return obtain;
    }

    private WeakReference<CanvasMultiGifArea> getMUltiArea() {
        if (this.mArea == null) {
            this.mArea = new WeakReference<>(this);
        }
        return this.mArea;
    }

    private ImageLoader.Options getOptions(int i3) {
        if (this.isUsePicInfo) {
            return getGifOptionsByPicInfo(i3);
        }
        return getGifOptionsByPciItem(i3);
    }

    private ImageLoader.Options getPicOptionsByPicItem(int i3) {
        ArrayList<PictureItem> arrayList = this.mPictureItems;
        if (arrayList == null || arrayList.size() <= i3) {
            return null;
        }
        PictureItem pictureItem = this.mPictureItems.get(i3);
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.obj = getMUltiArea().get();
        obtain.arg1 = this.iKey;
        obtain.arg2 = i3;
        obtain.extraProcessor = new NormalFeedImageProcessor(this.mPicItemWidth, this.mPicItemHeight, pictureItem.pivotXRate, pictureItem.pivotYRate);
        return obtain;
    }

    private ImageLoader.Options getPicOptionsByPicinfo(int i3) {
        int picSize;
        ArrayList<FeedPictureInfo> arrayList = this.mPicInfos;
        if (arrayList == null || arrayList.size() <= i3) {
            return null;
        }
        FeedPictureInfo feedPictureInfo = this.mPicInfos.get(i3);
        boolean s16 = i.H().s1();
        if (this.hasSetImageSize) {
            picSize = g.a(mImageSize);
        } else {
            picSize = getPicSize(s16, this.isForward, this.mPicNum);
        }
        this.mPicSize = picSize;
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.obj = getMUltiArea().get();
        obtain.arg1 = this.iKey;
        obtain.arg2 = i3;
        obtain.extraProcessor = new NormalFeedImageProcessor((int) (this.mPicSize * (isGDTThreePics() ? 1.3333334f : 1.0f)), this.mPicSize, feedPictureInfo.e(), feedPictureInfo.f());
        obtain.processor = feedPictureInfo.g();
        obtain.clipWidth = (int) (this.mPicSize * (isGDTThreePics() ? 1.3333334f : 1.0f));
        obtain.clipHeight = this.mPicSize;
        return obtain;
    }

    public static int getPicSize(boolean z16, boolean z17, int i3) {
        boolean z18 = i.H().F() && FeedGlobalEnv.g().getCurrentPhotoMode() == 0;
        if (!z16) {
            if (i3 != 2 && i3 != 4) {
                return DEFAULT_SIZE;
            }
            return getDefaultSize2PicForward();
        }
        if (i3 == 2 || i3 == 4) {
            if (!z17 && !z18) {
                return DEFAULT_SIZE_2_PIC;
            }
            return getDefaultSize2PicForward();
        }
        if (!z17 && !z18) {
            return DEFAULT_SIZE_FULL_COLUMN;
        }
        return DEFAULT_SIZE_FULL_COLUMN_FORWARD;
    }

    static int getUniNum() {
        int i3 = globalUniNum + 1;
        globalUniNum = i3;
        return i3;
    }

    private void initDrawableByPicItem() {
        AutoGifDrawable loadGif;
        if (this.mPictureItems == null) {
            return;
        }
        this.mCurPlayGif = null;
        int i3 = 0;
        this.mGifTotalCount = 0;
        while (i3 < this.mPictureItems.size()) {
            PictureUrl pictureUrl = this.mPictureItems.get(i3).currentUrl;
            Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(pictureUrl.imageUrl, pictureUrl.url, commentPicListener, getPicOptionsByPicItem(i3));
            if (loadImage != null) {
                b.c(TAG, "get drawable: " + loadImage.toString() + "size ");
            }
            if (loadImage == null) {
                loadImage = AreaManager.DEFAULT_BACKGROUND;
            }
            boolean z16 = gCanAutoPlayGif;
            if (z16 && !gIsOrderPlay) {
                loadGif = loadGif(i3);
            } else {
                loadGif = (z16 && gIsOrderPlay && i3 == 0) ? loadGif(i3) : null;
            }
            this.mDraws.add(loadImage);
            addGif(loadGif);
            i3++;
        }
    }

    private boolean isGDTThreePics() {
        return this.mIsGDTPic && this.mPicNum == 3 && !this.mIsBrandOptimization;
    }

    public static void onConfigurationChanged(Configuration configuration) {
        if (DEFAULT_SCREEN_WIDTH != FeedGlobalEnv.g().getScreenWidth()) {
            int screenWidth = FeedGlobalEnv.g().getScreenWidth();
            DEFAULT_SCREEN_WIDTH = screenWidth;
            int i3 = DEFAULT_MARGIN;
            int i16 = DEFAULT_SPACE;
            DEFAULT_SIZE = ((screenWidth - (i3 * 2)) - (i16 * 2)) / 3;
            DEFAULT_SIZE_FULL_COLUMN = (screenWidth - (i16 * 2)) / 3;
            DEFAULT_SIZE_2_PIC = (screenWidth - i16) / 2;
            DEFAULT_SIZE_FULL_COLUMN_FORWARD = ((screenWidth - (i3 * 2)) - (i16 * 2)) / 3;
            DEFAULT_SIZE_2_PIC_FORWARD = ((screenWidth - (i3 * 2)) - i16) / 2;
        }
    }

    public static synchronized void setGifArea(CanvasMultiGifArea canvasMultiGifArea, int i3, int i16, AutoGifDrawable autoGifDrawable) {
        synchronized (CanvasMultiGifArea.class) {
            if (canvasMultiGifArea != null) {
                if (canvasMultiGifArea.iKey == i3 && canvasMultiGifArea.mDraws.size() > 0 && canvasMultiGifArea.mAutoGifDrawable.size() > i16 && autoGifDrawable != null) {
                    canvasMultiGifArea.mAutoGifDrawable.set(i16, autoGifDrawable);
                    canvasMultiGifArea.invalidate();
                }
            }
        }
    }

    private void setImageInterval(int i3) {
        mImageInterval = i3;
    }

    public static void setPicArea(CanvasMultiGifArea canvasMultiGifArea, int i3, int i16, Drawable drawable, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (canvasMultiGifArea != null) {
            arrayList.addAll(canvasMultiGifArea.mDraws);
        }
        if (canvasMultiGifArea != null && canvasMultiGifArea.iKey == i3 && arrayList.size() > 0 && arrayList.size() > i16 && drawable != null) {
            arrayList.set(i16, drawable);
        }
        if (canvasMultiGifArea != null && canvasMultiGifArea.iKey == i3 && arrayList.size() > 0) {
            if (arrayList.size() > i16 && drawable != null) {
                if (canvasMultiGifArea.mImageLoadingTimes != null && !TextUtils.isEmpty(str)) {
                    Long l3 = canvasMultiGifArea.mImageLoadingTimes.get(str);
                    if (l3 != null) {
                        reportImageShowTime(l3.longValue(), "multiPicture");
                    }
                    canvasMultiGifArea.mImageLoadingTimes.remove(str);
                }
            } else if (!TextUtils.isEmpty(str2)) {
                Log.e(TAG, "setPicArea postion = " + i16 + ", downloadinfo = " + str2 + ", url = " + str);
                canvasMultiGifArea.mPicDownloadInfoMap.put(Integer.valueOf(i16), str2);
            }
        }
        if (canvasMultiGifArea != null) {
            canvasMultiGifArea.mDraws.clear();
            canvasMultiGifArea.mDraws.addAll(arrayList);
            canvasMultiGifArea.invalidate();
        }
    }

    private void setSingalImageSize(int i3) {
        mImageSize = i3;
    }

    public void addGif(AutoGifDrawable autoGifDrawable) {
        this.mAutoGifDrawable.add(autoGifDrawable);
        if (isAutoPlayGif(this.mAutoGifDrawable.size() - 1)) {
            this.mGifTotalCount++;
        }
    }

    int calculateViewHeight(int i3, int i16) {
        if (this.ismIsQCircleRecommFeed) {
            int screenWidth = FeedGlobalEnv.g().getScreenWidth();
            int i17 = DEFAULT_MARGIN;
            return (((screenWidth - i17) - i17) * 3) / 4;
        }
        if (this.isUsePicInfo) {
            return (((int) (i3 * (isGDTThreePics() ? sGDTfactor : 1.0f))) * i16) + ((i16 - 1) * DEFAULT_SPACE);
        }
        return this.mPicItemHeight;
    }

    int calculateViewWidth(int i3) {
        int i16;
        int i17;
        int i18;
        if (this.ismIsQCircleRecommFeed) {
            int screenWidth = FeedGlobalEnv.g().getScreenWidth();
            int i19 = DEFAULT_MARGIN;
            return (screenWidth - i19) - i19;
        }
        if (this.isUsePicInfo) {
            i16 = this.mPicSize * i3;
            i17 = i3 - 1;
            i18 = DEFAULT_SPACE;
        } else {
            i16 = this.mPicItemWidth * i3;
            i17 = i3 - 1;
            i18 = DEFAULT_SPACE;
        }
        return i16 + (i17 * i18);
    }

    public int findPos(int i3, int i16, int i17, int i18) {
        if (this.isUsePicInfo) {
            if (i3 > this.mWidth) {
                return -1;
            }
            int i19 = DEFAULT_SPACE;
            int i26 = (i3 / (i18 + i19)) + ((i16 / (i18 + i19)) * i17);
            if (i26 >= this.mPicInfos.size()) {
                return -1;
            }
            return i26;
        }
        if (i3 > this.mWidth) {
            return -1;
        }
        int i27 = this.mPicItemWidth;
        int i28 = DEFAULT_SPACE;
        int i29 = (i3 / (i27 + i28)) + ((i16 / (this.mPicItemHeight + i28)) * i17);
        if (i29 >= this.mPictureItems.size()) {
            return -1;
        }
        return i29;
    }

    public ClickedPos getClickPos() {
        if (!this.isQunFeed) {
            int i3 = this.mSelectedPos;
            int i16 = this.MAX_DISPLAY_PIC_NUM;
            if (i3 == i16 - 1 && this.mUPloadNum > i16) {
                return new ClickedPos(i3, true);
            }
        }
        return new ClickedPos(this.mSelectedPos, false);
    }

    public int getColumnNum() {
        return this.mColumnNum;
    }

    @Override // com.tencent.ditto.area.DittoArea
    public Object getData() {
        int i3;
        if (this.isUsePicInfo) {
            return getClickPos();
        }
        ArrayList<PictureItem> arrayList = this.mPictureItems;
        if (arrayList == null || (i3 = this.mSelectedPos) <= -1 || i3 >= arrayList.size()) {
            return null;
        }
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        cellPictureInfo.balbum = false;
        cellPictureInfo.albumnum = 1;
        cellPictureInfo.uploadnum = 1;
        cellPictureInfo.pics = this.mPictureItems;
        return i.H().I(cellPictureInfo, this.mSelectedPos);
    }

    public ImageProcessor getGifProcessor() {
        return this.mGifProcessor;
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public int getPaddingLeft() {
        return this.paddingLeft;
    }

    public int getPicNum() {
        return this.mPicNum;
    }

    public int getRowNum() {
        return this.mRowNum;
    }

    public int getSinglePicSize() {
        return this.mPicSize;
    }

    @Override // com.tencent.ditto.area.DittoArea
    public int getType() {
        return 7;
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public int getWidth() {
        return this.mWidth;
    }

    protected void handleAllGifOnIdle() {
        if (isListViewScrollIdle()) {
            playGif();
            return;
        }
        Iterator<AutoGifDrawable> it = this.mAutoGifDrawable.iterator();
        while (it.hasNext()) {
            handleGifOnIdle(it.next());
        }
    }

    public void initDrawable() {
        if (this.isUsePicInfo) {
            initDrawableByPicInfo();
        } else {
            initDrawableByPicItem();
        }
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public void invalidateGifView() {
        try {
            if (DEBUG) {
                b.e("jinqianli", "invalidated");
            }
            invalidate();
        } catch (Exception unused) {
        }
    }

    public boolean isAutoPlayGif(int i3) {
        if (this.isUsePicInfo) {
            return isAutoPlayGifByPicInfo(i3);
        }
        return isAutoPlayGifByPicItem(i3);
    }

    public boolean isAutoPlayGifByPicInfo(int i3) {
        FeedPictureInfo feedPictureInfo;
        ArrayList<FeedPictureInfo> arrayList = this.mPicInfos;
        return arrayList != null && arrayList.size() > i3 && (feedPictureInfo = this.mPicInfos.get(i3)) != null && feedPictureInfo.d() == FeedPictureInfo.ImageType.IMAGE_GIF && feedPictureInfo.i();
    }

    public boolean isAutoPlayGifByPicItem(int i3) {
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        ArrayList<PictureItem> arrayList = this.mPictureItems;
        return (arrayList == null || arrayList.size() <= i3 || (pictureItem = this.mPictureItems.get(i3)) == null || !pictureItem.isGif() || !pictureItem.isAutoPlayGif || (pictureUrl = pictureItem.bigUrl) == null || TextUtils.isEmpty(pictureUrl.url)) ? false : true;
    }

    public boolean isCanAutoPlayGif() {
        return gCanAutoPlayGif;
    }

    public boolean isGifOrderPlay() {
        return gIsOrderPlay;
    }

    public boolean isInRect(float f16, float f17, int i3) {
        float picLeft = getPicLeft(i3, this.mColumnNum, this.mPicNum, this.mPicSize);
        float picTop = getPicTop(i3, this.mColumnNum, this.mPicNum, this.mPicSize);
        if (!this.isUsePicInfo) {
            return f16 < ((float) this.mPicItemWidth) + picLeft && f16 > picLeft && f17 < ((float) this.mPicItemHeight) + picTop && f17 > picTop;
        }
        int i16 = this.mPicSize;
        return f16 < ((float) i16) + picLeft && f16 > picLeft && f17 < ((float) i16) + picTop && f17 > picTop;
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public boolean isListViewScrollIdle() {
        return i.H().g1();
    }

    public void lazyUpdateGif() {
        if (DEBUG) {
            b.e("jinqianli", "MutiGifSubArea#lazyUpdateGif(), lazyUpdateCount=" + this.lazyUpdateCount);
        }
        this.mainHanlder.removeCallbacks(this.updateGifRunnable);
        if (this.lazyPlayCount < 3) {
            this.mainHanlder.postDelayed(this.updateGifRunnable, 100L);
        } else {
            this.mainHanlder.post(this.updateGifRunnable);
        }
    }

    protected AutoGifDrawable loadGif(int i3) {
        if (!gIsOrderPlay || (this.mCurPlayGifIndex < this.mAutoGifDrawable.size() && this.mCurPlayGifIndex == i3)) {
            return loadIndexGif(i3);
        }
        return null;
    }

    protected AutoGifDrawable loadIndexGif(int i3) {
        PictureUrl pictureUrl;
        ImageLoader.Options gifOptionsByPciItem;
        if (!isAutoPlayGif(i3)) {
            return null;
        }
        AutoGifDrawable newAutoGifDrawable = AutoGifDrawable.newAutoGifDrawable();
        if (this.isUsePicInfo) {
            pictureUrl = this.mPicInfos.get(i3).b();
        } else {
            pictureUrl = this.mPictureItems.get(i3).bigUrl;
        }
        String str = pictureUrl.url;
        if (this.isUsePicInfo) {
            gifOptionsByPciItem = getGifOptionsByPicInfo(i3);
        } else {
            gifOptionsByPciItem = getGifOptionsByPciItem(i3);
        }
        FeedGlobalEnv.g();
        newAutoGifDrawable.init(str, gifOptionsByPciItem, FeedGlobalEnv.getContext(), this, this.gifDownloadCallBackListener);
        if (gIsOrderPlay) {
            newAutoGifDrawable.setGifPlayListener(this.gifPlayListener);
        }
        if (newAutoGifDrawable.getRealDrawable() == null || !(newAutoGifDrawable.getRealDrawable() instanceof NewGifDrawable)) {
            return newAutoGifDrawable;
        }
        ((NewGifDrawable) newAutoGifDrawable.getRealDrawable()).setTag(Integer.valueOf(i3));
        return newAutoGifDrawable;
    }

    protected int moveToNextGif(int i3, AutoGifDrawable autoGifDrawable) {
        String str;
        if (this.mGifTotalCount == 1 && autoGifDrawable != null) {
            return i3;
        }
        int i16 = i3 + 1;
        if (i16 >= this.mAutoGifDrawable.size()) {
            i16 = 0;
        }
        if (DEBUG) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("MutiGifSubArea#moveToNextGif(), mGifTotalCount=");
            sb5.append(this.mGifTotalCount);
            sb5.append(", autoGifDrawable ");
            if (autoGifDrawable == null) {
                str = "";
            } else {
                str = "!";
            }
            sb5.append(str);
            sb5.append("=null, curGifIndex=");
            sb5.append(i3);
            sb5.append(", next index is ");
            sb5.append(i16);
            b.e("jinqianli", sb5.toString());
        }
        if (autoGifDrawable != null) {
            if (this.mGifTotalCount <= 1) {
                return i3;
            }
            recycleGif(i3, autoGifDrawable);
        }
        return i16;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:38|(1:40)(1:118)|41|(1:43)|44|(1:46)(1:117)|47|(1:49)(1:116)|50|(3:52|(1:54)(1:114)|55)(1:115)|56|(1:58)(1:113)|59|(5:62|(1:64)(1:89)|(1:66)(1:88)|67|(6:69|(1:73)|74|75|(1:87)(2:77|(2:79|(2:81|82)(1:84))(2:85|86))|83))|(1:91)|92|(1:94)(1:(1:112))|95|(1:97)(1:110)|(3:99|(1:101)|102)(1:109)|103|104|105|106|75|(0)(0)|83|36) */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01a0, code lost:
    
        com.qzone.proxy.feedcomponent.b.c(com.qzone.canvasui.widget.CanvasMultiGifArea.TAG, " ondraw() Canvas: trying to use a recycled bitmap android.graphics.Bitmap");
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01dc A[SYNTHETIC] */
    @Override // com.tencent.ditto.area.DittoArea
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(Canvas canvas) {
        int picSize;
        int i3;
        int i16;
        float f16;
        int i17;
        int i18;
        boolean z16;
        String str;
        int i19;
        int i26;
        Drawable realDrawable;
        BusinessFeedData businessFeedData;
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        canvas.save();
        this.tempDraws.clear();
        this.tempDraws.addAll(this.mDraws);
        if (this.ismIsQCircleRecommFeed && this.tempDraws.size() >= 3) {
            for (int i27 = 0; i27 < 3; i27++) {
                Drawable drawable = this.tempDraws.get(i27);
                if (drawable == null) {
                    drawable = AreaManager.DEFAULT_BACKGROUND;
                }
                if (i27 == 0) {
                    drawable.setBounds(0, getQCircleSharedImgTop(drawable), (this.mWidth * 5) / 8, getQCircleSharedImgBottom(drawable));
                } else if (i27 == 1) {
                    int i28 = this.mWidth;
                    drawable.setBounds((i28 * 5) / 8, 0, i28, this.mHeight / 2);
                } else {
                    int i29 = this.mWidth;
                    int i36 = this.mHeight;
                    drawable.setBounds((i29 * 5) / 8, i36 / 2, i29, i36);
                }
                drawable.draw(canvas);
            }
            if (this.mBottomView == null || (businessFeedData = this.mFeedData) == null || !businessFeedData.isQCircleRecommFeed()) {
                return;
            }
            this.mBottomView.draw(canvas, this.mHeight, this.mWidth);
            return;
        }
        Iterator<Drawable> it = this.tempDraws.iterator();
        int i37 = 0;
        while (it.hasNext()) {
            Drawable next = it.next();
            canvas.save();
            boolean s16 = i.H().s1();
            if (this.hasSetImageSize) {
                picSize = g.a(mImageSize);
            } else {
                picSize = getPicSize(s16, this.isForward, this.mPicNum);
            }
            this.mPicSize = picSize;
            RectF rectF = rect;
            int i38 = this.mColumnNum;
            int i39 = this.mPicNum;
            if (!this.isUsePicInfo) {
                picSize = this.mPicItemWidth;
            }
            rectF.left = getPicLeft(i37, i38, i39, picSize);
            int i46 = this.mColumnNum;
            int i47 = this.mPicNum;
            if (this.isUsePicInfo) {
                i3 = this.mPicSize;
            } else {
                i3 = this.mPicItemHeight;
            }
            float picTop = getPicTop(i37, i46, i47, i3);
            rectF.top = picTop;
            float f17 = rectF.left;
            boolean z17 = this.isUsePicInfo;
            if (z17) {
                i16 = this.mPicSize;
            } else {
                i16 = this.mPicItemWidth;
            }
            rectF.right = f17 + i16;
            if (z17) {
                f16 = this.mPicSize * (isGDTThreePics() ? sGDTfactor : 1.0f);
            } else {
                f16 = this.mPicItemHeight;
            }
            rectF.bottom = picTop + f16;
            canvas.clipRect(rectF);
            canvas.translate(rectF.left, rectF.top);
            AutoGifDrawable autoGifDrawable = i37 < this.mAutoGifDrawable.size() ? this.mAutoGifDrawable.get(i37) : null;
            if (gCanAutoPlayGif && autoGifDrawable != null) {
                boolean z18 = this.isUsePicInfo;
                if (z18) {
                    i19 = this.mPicSize;
                } else {
                    i19 = this.mPicItemWidth;
                }
                if (z18) {
                    i26 = this.mPicSize;
                } else {
                    i26 = this.mPicItemHeight;
                }
                if (autoGifDrawable.draw(canvas, i19, i26)) {
                    if (i.H().p1() && (realDrawable = autoGifDrawable.getRealDrawable()) != null) {
                        Paint paint = new Paint();
                        paint.setColor(j.p());
                        canvas.drawRect(realDrawable.getBounds(), paint);
                    }
                    z16 = true;
                    drawRect(canvas, this.myPaint, i37, !z16);
                    str = this.mPicDownloadInfoMap.get(Integer.valueOf(i37));
                    if (d.f(str)) {
                        if (d.g(str)) {
                            String j3 = d.j(str);
                            if (!TextUtils.isEmpty(j3)) {
                                int i48 = this.mPicSize;
                                d.a(canvas, j3, i48, i48, 0);
                            }
                        } else {
                            d.c(canvas, str, this.mPicSize);
                        }
                    }
                    canvas.restore();
                    i37++;
                }
            }
            if (next == null) {
                next = AreaManager.DEFAULT_BACKGROUND;
            }
            int d16 = d.d(this.mPicDownloadInfoMap.get(Integer.valueOf(i37)));
            if (d16 == 1) {
                next = AreaManager.DEFAULT_BACKGROUND_SERVER;
            } else if (d16 == 2) {
                next = AreaManager.DEFAULT_BACKGROUND_NETWORK;
            }
            boolean z19 = this.isUsePicInfo;
            if (z19) {
                i17 = this.mPicSize;
            } else {
                i17 = this.mPicItemWidth;
            }
            if (z19) {
                i18 = (int) (this.mPicSize * (isGDTThreePics() ? sGDTfactor : 1.0f));
            } else {
                i18 = this.mPicItemHeight;
            }
            next.setBounds(0, 0, i17, i18);
            next.draw(canvas);
            z16 = false;
            drawRect(canvas, this.myPaint, i37, !z16);
            str = this.mPicDownloadInfoMap.get(Integer.valueOf(i37));
            if (d.f(str)) {
            }
            canvas.restore();
            i37++;
        }
        canvas.restore();
    }

    protected void onGifDownloaded(String str, Drawable drawable, ImageLoader.Options options) {
        if (gIsOrderPlay && drawable != null && (drawable instanceof NewGifDrawable)) {
            NewGifDrawable newGifDrawable = (NewGifDrawable) drawable;
            newGifDrawable.setTag(Integer.valueOf(options.arg2));
            newGifDrawable.setGifPlayListener(this.gifPlayListener);
        }
        if (this.isUsePicInfo) {
            this.mainHanlder.post(new DownloadedUpdateGifRunnableforPicInfo(str, drawable, options));
        } else {
            this.mainHanlder.post(new DownloadedUpdateGifRunnable(str, drawable, options));
        }
    }

    public void onGifStateIdle() {
        if (gCanAutoPlayGif && gIsOrderPlay && this.mCurPlayGif != null) {
            handleGifOnIdle(this.mCurPlayGif);
        } else {
            handleAllGifOnIdle();
        }
    }

    public void onGifStateScrolling() {
        Iterator<AutoGifDrawable> it = this.mAutoGifDrawable.iterator();
        while (it.hasNext()) {
            AutoGifDrawable next = it.next();
            if (next != null && next.isRunning()) {
                next.stop();
            }
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.mWidth = calculateViewWidth(this.mColumnNum);
        this.mHeight = calculateViewHeight(this.mPicSize, this.mRowNum);
        int i17 = this.mUPloadNum;
        int i18 = this.MAX_DISPLAY_PIC_NUM;
        if (i17 > i18) {
            String num = Integer.toString((i17 - i18) + 1);
            Paint paintForTextArea = AreaManager.getInstance().getPaintForTextArea(40);
            float textSize = paintForTextArea.getTextSize();
            paintForTextArea.setTextSize(DEFAULT_NUM_TEXTSIZE);
            this.playingTextWidth = (int) paintForTextArea.measureText(num);
            Paint.FontMetrics fontMetrics = paintForTextArea.getFontMetrics();
            this.playingTextHeight = (int) Math.ceil(fontMetrics.descent - fontMetrics.top);
            paintForTextArea.setTextSize(textSize);
        }
        setPadding(this.paddingLeft, 0, 0, 0);
        if (this.hasSumm) {
            setPadding(this.paddingLeft, AreaConst.dp9, 0, 0);
        }
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public void onPause() {
        Iterator<AutoGifDrawable> it = this.mAutoGifDrawable.iterator();
        while (it.hasNext()) {
            AutoGifDrawable next = it.next();
            if (next != null) {
                next.stop();
            }
        }
    }

    public void onStateIdle() {
        Drawable loadImage;
        synchronized (this.objectLock) {
            this.tempDraws.clear();
            this.tempDraws.addAll(this.mDraws);
        }
        if (this.mPicInfos.size() > 0 && this.tempDraws.size() == this.mPicInfos.size()) {
            Iterator<FeedPictureInfo> it = this.mPicInfos.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                FeedPictureInfo next = it.next();
                if (this.tempDraws.get(i3) == defaultBackground && next.f50248k != null && (loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(next.h().imageUrl, next.h().url, picinfoDownloadListener, next.f50248k)) != null) {
                    this.tempDraws.set(i3, loadImage);
                }
                i3++;
            }
        }
        this.mDraws.clear();
        this.mDraws.addAll(this.tempDraws);
        onGifStateIdle();
        if (this.needReInvalidate) {
            if (this.tempDraws.size() > 0 || this.mAutoGifDrawable.size() > 0) {
                invalidate();
            }
        }
    }

    public void onStateScrolling() {
        onGifStateScrolling();
    }

    @Override // com.tencent.ditto.area.DittoArea
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x16 = motionEvent.getX() - this.paddingLeft;
        float y16 = motionEvent.getY();
        if (x16 >= 0.0f && y16 >= 0.0f) {
            if (motionEvent.getAction() == 0) {
                this.downX = x16;
                this.downY = y16;
                this.mSelectedPos = findPos((int) x16, (int) y16, this.mColumnNum, this.mPicSize);
                if (this.clickListener != null) {
                    this.isLongPressed = true;
                    if (this.longClickListener != null) {
                        checkLongClickEvent(motionEvent);
                    }
                }
                return this.mSelectedPos != -1;
            }
            if (motionEvent.getAction() == 2) {
                int i3 = this.mSelectedPos;
                if (i3 != -1) {
                    if (isInRect(x16, y16, i3)) {
                        return true;
                    }
                    clearTouchingEvent();
                    return false;
                }
            } else if (motionEvent.getAction() == 1) {
                int i16 = this.mSelectedPos;
                if (i16 != -1) {
                    if (isInRect(x16, y16, i16) && this.isLongPressed) {
                        cancelLongPressed();
                        DittoArea.ClickListener clickListener = this.clickListener;
                        if (clickListener != null) {
                            clickListener.onClick(this, null, null);
                        }
                        return true;
                    }
                    cancelLongPressed();
                    clearTouchingEvent();
                    return false;
                }
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 4) {
                cancelLongPressed();
                clearTouchingEvent();
            }
            return false;
        }
        cancelLongPressed();
        clearTouchingEvent();
        return false;
    }

    protected void playAllGif(int i3, int i16, int i17, int i18, View view) {
        if (gCanAutoPlayGif) {
            if (this.mAutoGifDrawable.size() > 0) {
                int[] iArr = new int[2];
                if (view != null) {
                    view.getLocationOnScreen(iArr);
                    int i19 = iArr[1] + DittoAreaView.getLocationToViewHost(this)[1];
                    Iterator<AutoGifDrawable> it = this.mAutoGifDrawable.iterator();
                    boolean z16 = true;
                    boolean z17 = true;
                    int i26 = 0;
                    while (it.hasNext()) {
                        AutoGifDrawable next = it.next();
                        if (i26 % i16 == 0) {
                            int i27 = i26 / i16;
                            boolean z18 = 0 - i19 <= i18 * i27;
                            z17 = FeedGlobalEnv.g().getScreenHeight() - i19 > (i27 + 1) * i18;
                            z16 = z18;
                        }
                        if (z16 && z17) {
                            if (next == null) {
                                next = loadGif(i26);
                                this.mAutoGifDrawable.set(i26, next);
                            }
                            if (next != null) {
                                if (isListViewScrollIdle()) {
                                    next.start();
                                    if (DEBUG) {
                                        b.e("jinqianli", " autoGifDrawable.start()" + i26);
                                    }
                                } else {
                                    next.stop();
                                }
                            }
                        } else if (DEBUG) {
                            b.e("jinqianli", " notOverTop && notBelowBottom  is false," + i26);
                        }
                        i26++;
                    }
                    return;
                }
                return;
            }
            if (DEBUG) {
                b.e("jinqianli", "mAutoGifDrawable.size() <= 0, size:" + this.mAutoGifDrawable.size());
            }
            Iterator<AutoGifDrawable> it5 = this.mAutoGifDrawable.iterator();
            while (it5.hasNext()) {
                AutoGifDrawable next2 = it5.next();
                if (next2 != null) {
                    next2.stop();
                }
            }
        }
    }

    public void playGif() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        i.H().J1(2);
        if (this.mColumnNum > this.mAutoGifDrawable.size()) {
            i3 = this.mAutoGifDrawable.size();
        } else {
            i3 = this.mColumnNum;
        }
        int i26 = i3;
        if (i26 == 0) {
            return;
        }
        if (gIsOrderPlay) {
            int i27 = this.mRowNum;
            boolean z16 = this.isUsePicInfo;
            if (z16) {
                i18 = this.mPicSize;
            } else {
                i18 = this.mPicItemWidth;
            }
            int i28 = i18;
            if (z16) {
                i19 = this.mPicSize;
            } else {
                i19 = this.mPicItemHeight;
            }
            playGifByOrder(i27, i26, i28, i19, this.mHost.getContainerView());
            return;
        }
        int i29 = this.mRowNum;
        boolean z17 = this.isUsePicInfo;
        if (z17) {
            i16 = this.mPicSize;
        } else {
            i16 = this.mPicItemWidth;
        }
        int i36 = i16;
        if (z17) {
            i17 = this.mPicSize;
        } else {
            i17 = this.mPicItemHeight;
        }
        playAllGif(i29, i26, i36, i17, this.mHost.getContainerView());
    }

    protected void playGifByOrder(int i3, int i16, int i17, int i18, View view) {
        String str;
        if (!gCanAutoPlayGif || this.mGifTotalCount <= 0 || this.mAutoGifDrawable.size() <= 0 || i3 == 0 || i16 == 0) {
            return;
        }
        this.needReInvalidate = false;
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            int i19 = iArr[1] + DittoAreaView.getLocationToViewHost(this)[1];
            int screenHeight = FeedGlobalEnv.g().getScreenHeight();
            int i26 = this.mCurPlayGifIndex;
            AutoGifDrawable autoGifDrawable = this.mCurPlayGif;
            int i27 = 0;
            while (true) {
                if (i27 >= this.mAutoGifDrawable.size()) {
                    break;
                }
                if (i26 <= 0) {
                    i26 = 0;
                } else if (i26 >= this.mAutoGifDrawable.size()) {
                    i26 = this.mAutoGifDrawable.size() - 1;
                }
                int i28 = i26 / i3;
                boolean z16 = 0 - i19 < i18 * i28;
                boolean z17 = screenHeight - i19 > (i28 + 1) * i18;
                if (z16) {
                    if (!z17) {
                        recycleGif(i26, autoGifDrawable);
                        i26 = 0;
                    } else {
                        autoGifDrawable = loadIndexGif(i26);
                        if (DEBUG) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("FeedMutiPicArea#playGifByOrder, y=");
                            sb5.append(i19);
                            sb5.append(", notOverTop=");
                            sb5.append(z16);
                            sb5.append(", notBelowBottom=");
                            sb5.append(z17);
                            sb5.append(", tempIndex=");
                            sb5.append(i26);
                            sb5.append(", tempGif");
                            if (autoGifDrawable == null) {
                                str = "";
                            } else {
                                str = "!";
                            }
                            sb5.append(str);
                            sb5.append("=null");
                            b.e("jinqianli", sb5.toString());
                        }
                        if (z16 && z17 && autoGifDrawable != null) {
                            this.mCurPlayGifIndex = i26;
                            this.mCurPlayGif = autoGifDrawable;
                            this.mAutoGifDrawable.set(i26, autoGifDrawable);
                            handleGifOnIdle(autoGifDrawable);
                            break;
                        }
                        if (autoGifDrawable != null) {
                            recycleGif(i26, autoGifDrawable);
                        }
                        i26 = moveToNextGif(i26, autoGifDrawable);
                    }
                    i27++;
                }
                do {
                    recycleGif(i26, autoGifDrawable);
                    i26++;
                } while (i26 % i16 != 0);
                i27++;
            }
        }
        if (this.needReInvalidate) {
            invalidateGifView();
        }
    }

    public void playNextGif() {
        this.mCurPlayGifIndex = moveToNextGif(this.mCurPlayGifIndex, this.mCurPlayGif);
        playGif();
    }

    protected void recycleGif(int i3, AutoGifDrawable autoGifDrawable) {
        if (i3 < this.mAutoGifDrawable.size()) {
            if (i3 >= 0 || autoGifDrawable != null) {
                if (autoGifDrawable != null) {
                    if (autoGifDrawable.isRunning()) {
                        autoGifDrawable.stop();
                    }
                    autoGifDrawable.recycled();
                    autoGifDrawable = null;
                }
                this.mAutoGifDrawable.set(i3, autoGifDrawable);
            }
        }
    }

    public void removeGif(int i3) {
        if (isAutoPlayGif(i3)) {
            this.mGifTotalCount--;
        }
        this.mAutoGifDrawable.remove(i3);
    }

    public void reset() {
        this.iKey = getUniNum();
        this.mPicNum = 0;
        this.mUPloadNum = 0;
        this.mColumnNum = 0;
        this.mRowNum = 0;
        this.mSelectedPos = -1;
        this.downX = -1.0f;
        this.downY = -1.0f;
        this.needReInvalidate = false;
    }

    public void setCanAutoPlayGif(boolean z16) {
        gCanAutoPlayGif = z16;
    }

    public void setGifDisplayRect(ImageProcessor imageProcessor) {
        this.mGifProcessor = imageProcessor;
    }

    public void setGifOrderPlay(boolean z16) {
        gIsOrderPlay = z16;
    }

    public void setIsForward(boolean z16) {
        this.isForward = z16;
    }

    public void setIsGdtPic(boolean z16, boolean z17) {
        this.mIsGDTPic = z16;
        this.mIsBrandOptimization = z17;
    }

    public void setPicInfos(FeedPictureInfo[] feedPictureInfoArr, boolean z16, boolean z17, boolean z18) {
        onRecycled();
        this.mPicInfos.clear();
        this.mCurPlayGif = null;
        this.mGifTotalCount = 0;
        this.mCurPlayGifIndex = 0;
        this.hasSumm = z18;
        this.ismIsQCircleRecommFeed = z16;
        if (feedPictureInfoArr != null && feedPictureInfoArr.length > 0) {
            if (feedPictureInfoArr.length > 0) {
                for (FeedPictureInfo feedPictureInfo : feedPictureInfoArr) {
                    if (feedPictureInfo != null && !isUrlEmpty(feedPictureInfo.h())) {
                        this.mPicInfos.add(feedPictureInfo);
                    }
                }
            }
            this.isUsePicInfo = true;
            if (feedPictureInfoArr.length <= 0) {
                this.mPicNum = 0;
                return;
            }
            this.isForward = z17;
            this.mPicNum = this.mPicInfos.size();
            boolean s16 = i.H().s1();
            boolean z19 = i.H().F() && FeedGlobalEnv.g().getCurrentPhotoMode() == 0;
            if (s16 && !z19) {
                this.paddingLeft = z17 ? DEFAULT_MARGIN : 0;
                int i3 = this.mPicNum;
                this.mColumnNum = (i3 == 4 || i3 == 2) ? 2 : 3;
            } else {
                this.paddingLeft = DEFAULT_MARGIN;
                this.mColumnNum = this.mPicNum == 4 ? 2 : 3;
            }
            this.mRowNum = ((this.mPicNum - 1) / this.mColumnNum) + 1;
            initDrawable();
            return;
        }
        this.mPicNum = 0;
    }

    public void setPicItemHeight(int i3) {
        this.mPicItemHeight = i3;
    }

    public void setPicItemWidth(int i3) {
        this.mPicItemWidth = i3;
    }

    public void setPicUploadNum(int i3, int i16) {
        this.mUPloadNum = i3;
        this.MAX_DISPLAY_PIC_NUM = Math.max(i16, 9);
    }

    public void setQunFeed(boolean z16) {
        this.isQunFeed = z16;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CommentPicListener implements ImageLoader.ImageLoadListener {
        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Object obj;
            CanvasMultiGifArea canvasMultiGifArea;
            if (options == null || (obj = options.obj) == null || drawable == null || (canvasMultiGifArea = (CanvasMultiGifArea) obj) == null || canvasMultiGifArea.iKey != options.arg1) {
                return;
            }
            DrawableHolderV2 obtain = DrawableHolderV2.obtain();
            obtain.drawable = drawable;
            obtain.picArea = canvasMultiGifArea;
            AreaManager.mainHanlder.obtainMessage(4, options.arg1, options.arg2, obtain).sendToTarget();
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

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class MultiPicListener implements ImageLoader.ImageLoadListener {
        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            if (options == null || !(options.obj instanceof CanvasMultiGifArea) || TextUtils.isEmpty(options.errCode)) {
                return;
            }
            CanvasMultiGifArea canvasMultiGifArea = (CanvasMultiGifArea) options.obj;
            DrawableHolder obtain = DrawableHolder.obtain();
            obtain.picArea = canvasMultiGifArea;
            obtain.downloadInfo = options.errCode;
            obtain.url = str;
            b.c(CanvasMultiGifArea.TAG, "onImageFailed: position = " + options.arg2 + ", errorCode = " + options.errCode + ", url = " + str);
            AreaManager.mainHanlder.obtainMessage(3, options.arg1, options.arg2, obtain).sendToTarget();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Object obj;
            if (options == null || (obj = options.obj) == null || drawable == null || !(obj instanceof CanvasMultiGifArea)) {
                return;
            }
            b.c(CanvasMultiGifArea.TAG, "onImageLoaded: " + ((NormalFeedImageProcessor) options.extraProcessor).getWidth() + " ," + ((NormalFeedImageProcessor) options.extraProcessor).getHeight());
            CanvasMultiGifArea canvasMultiGifArea = (CanvasMultiGifArea) options.obj;
            if (canvasMultiGifArea == null || canvasMultiGifArea.iKey != options.arg1) {
                return;
            }
            DrawableHolder obtain = DrawableHolder.obtain();
            obtain.drawable = drawable;
            obtain.picArea = canvasMultiGifArea;
            obtain.url = str;
            AreaManager.mainHanlder.obtainMessage(3, options.arg1, options.arg2, obtain).sendToTarget();
            if (canvasMultiGifArea.mPicDownloadInfoMap != null) {
                if (!TextUtils.isEmpty(options.errCode)) {
                    canvasMultiGifArea.mPicDownloadInfoMap.put(Integer.valueOf(options.arg2), options.errCode);
                } else if (canvasMultiGifArea.mPicDownloadInfoMap.get(Integer.valueOf(options.arg2)) != null) {
                    canvasMultiGifArea.mPicDownloadInfoMap.remove(Integer.valueOf(options.arg2));
                }
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    private void cancelLongPressed() {
        this.isLongPressed = false;
        AlarmTask alarmTask = this.mAlarmTask;
        if (alarmTask != null) {
            alarmTask.cancelAlarm();
        }
    }

    private void init() {
        this.hasSetImageInterval = false;
        this.isUsePicInfo = false;
        gCanAutoPlayGif = i.H().k();
        this.gGifDisplayRect = i.H().e0();
        gIsOrderPlay = i.H().Y() == 2;
        gGifLoopCount = i.H().S(QzoneConfig.MAIN_GIF_SETTING, "GifLoopCount", 1);
        gGifLoopDuration = i.H().S(QzoneConfig.MAIN_GIF_SETTING, "GifLoopDuration", 1000);
        Paint paint = new Paint();
        this.myPaint = paint;
        paint.setColor(-1);
    }

    private void initDrawableByPicInfo() {
        AutoGifDrawable loadGif;
        this.mCurPlayGif = null;
        int i3 = 0;
        this.mGifTotalCount = 0;
        this.mCurPlayGifIndex = 0;
        this.mDraws.clear();
        this.mAutoGifDrawable.clear();
        Iterator<FeedPictureInfo> it = this.mPicInfos.iterator();
        while (it.hasNext()) {
            FeedPictureInfo next = it.next();
            String str = next.h().url;
            ImageUrl imageUrl = next.h().imageUrl;
            boolean z16 = gCanAutoPlayGif;
            if (z16 && !gIsOrderPlay) {
                loadGif = loadGif(i3);
            } else {
                loadGif = (z16 && gIsOrderPlay && i3 == 0) ? loadGif(i3) : null;
            }
            Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, picinfoDownloadListener, getPicOptionsByPicinfo(i3));
            addGif(loadGif);
            if (loadImage != null) {
                next.f50248k = null;
            } else {
                loadImage = defaultBackground;
                next.f50248k = getPicOptionsByPicinfo(i3);
                this.needReInvalidate = true;
                this.mImageLoadingTimes.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            this.mDraws.add(loadImage);
            i3++;
        }
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.mCurPlayGif = null;
        this.mCurPlayGifIndex = 0;
        this.mGifTotalCount = 0;
        Iterator<AutoGifDrawable> it = this.mAutoGifDrawable.iterator();
        while (it.hasNext()) {
            AutoGifDrawable next = it.next();
            if (next != null) {
                next.setGifPlayListener(null);
                next.recycled();
            }
        }
        this.mWidth = 0;
        this.mHeight = 0;
        mImageSize = 0;
        this.mPicItemHeight = 0;
        this.mPicItemWidth = 0;
        this.iKey = getUniNum();
        this.mAutoGifDrawable.clear();
        if (this.mPicInfos.size() > 0 && !i.H().g1()) {
            Iterator<FeedPictureInfo> it5 = this.mPicInfos.iterator();
            while (it5.hasNext()) {
                FeedPictureInfo next2 = it5.next();
                if (next2.f50248k != null) {
                    loader.cancel(next2.h().url, picinfoDownloadListener, next2.f50248k);
                }
            }
            this.mPicInfos.clear();
        }
        synchronized (this.objectLock) {
            this.mDraws.clear();
        }
        this.mImageLoadingTimes.clear();
    }

    private int getQCircleSharedImgBottom(Drawable drawable) {
        if (drawable != null && drawable.getIntrinsicWidth() != 0) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i3 = this.mWidth;
            float f16 = (i3 / intrinsicWidth) * intrinsicHeight;
            float f17 = i3 * 1.3f;
            return f16 > f17 ? (int) ((f17 / 2.0f) + (f16 / 2.0f)) : this.mHeight;
        }
        return this.mHeight;
    }

    protected static boolean isUrlEmpty(PictureUrl pictureUrl) {
        return pictureUrl == null || TextUtils.isEmpty(pictureUrl.url);
    }

    public void clearTouchingEvent() {
        this.downX = -1.0f;
        this.downY = -1.0f;
        this.mSelectedPos = -1;
    }

    public float getPicLeft(int i3, int i16, int i17, int i18) {
        int i19;
        if (i16 == 0) {
            b.c(TAG, "columnNum is zero in getPicLeft()");
            return i3;
        }
        int i26 = i3 % i16;
        if (this.isUsePicInfo) {
            i19 = i18 + DEFAULT_SPACE;
        } else {
            i19 = this.mPicItemWidth + DEFAULT_SPACE;
        }
        float f16 = i26 * i19;
        if (f16 == 0.0f) {
            return 0.0f;
        }
        return 0.5f + f16;
    }

    public float getPicTop(int i3, int i16, int i17, int i18) {
        int i19;
        if (i16 == 0) {
            b.c(TAG, "columnNum is zero in getPicTop()");
        } else {
            int i26 = i3 / i16;
            if (this.isUsePicInfo) {
                i19 = i18 + DEFAULT_SPACE;
            } else {
                i19 = this.mPicItemHeight + DEFAULT_SPACE;
            }
            i3 = i26 * i19;
        }
        return i3;
    }

    public void setPictureItems(ArrayList<PictureItem> arrayList, boolean z16) {
        PictureUrl pictureUrl;
        int i3;
        int i16;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.mPictureItems.clear();
        this.isUsePicInfo = false;
        this.mRowNum = 1;
        int size = arrayList.size();
        this.mPicNum = size;
        this.mColumnNum = size;
        int i17 = com.qzone.adapter.feedcomponent.b.f41875v;
        this.mPicItemHeight = i17;
        this.mPicItemWidth = i17;
        this.mDraws.clear();
        this.mPictureItems.addAll(arrayList);
        if (z16 && arrayList.size() > 0 && (pictureUrl = arrayList.get(0).currentUrl) != null && (i3 = pictureUrl.width) > 0 && (i16 = pictureUrl.height) > 0) {
            this.mPicItemWidth = i3;
            this.mPicItemHeight = i16;
        }
        int i18 = com.qzone.adapter.feedcomponent.b.f41875v;
        this.mPicItemWidth = (int) (this.mPicItemWidth * ((i18 * 1.0f) / this.mPicItemHeight));
        this.mPicItemHeight = i18;
        initDrawable();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class DrawableHolder {
        static final int CACHE_SIZE = 20;
        static final LinkedList<DrawableHolder> mHolders = new LinkedList<>();
        public AutoGifDrawable autoGifDrawable;
        public String downloadInfo;
        public Drawable drawable;
        public CanvasMultiGifArea picArea;
        public String url;

        static {
            for (int i3 = 0; i3 <= 20; i3++) {
                mHolders.add(new DrawableHolder());
            }
        }

        static DrawableHolder obtain() {
            DrawableHolder poll;
            LinkedList<DrawableHolder> linkedList = mHolders;
            synchronized (linkedList) {
                poll = linkedList.poll();
            }
            return poll == null ? new DrawableHolder() : poll;
        }

        public static void recyle(DrawableHolder drawableHolder) {
            if (drawableHolder == null) {
                return;
            }
            drawableHolder.autoGifDrawable = null;
            drawableHolder.drawable = null;
            drawableHolder.picArea = null;
            drawableHolder.url = null;
            drawableHolder.downloadInfo = null;
            LinkedList<DrawableHolder> linkedList = mHolders;
            synchronized (linkedList) {
                if (linkedList.size() < 20) {
                    linkedList.add(drawableHolder);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class DrawableHolderV2 {
        static final int CACHE_SIZE = 20;
        static final LinkedList<DrawableHolderV2> mHolders = new LinkedList<>();
        public AutoGifDrawable autoGifDrawable;
        public Drawable drawable;
        public CanvasMultiGifArea picArea;

        static {
            for (int i3 = 0; i3 <= 20; i3++) {
                mHolders.add(new DrawableHolderV2());
            }
        }

        static DrawableHolderV2 obtain() {
            DrawableHolderV2 poll;
            LinkedList<DrawableHolderV2> linkedList = mHolders;
            synchronized (linkedList) {
                poll = linkedList.poll();
            }
            return poll == null ? new DrawableHolderV2() : poll;
        }

        public static void recyle(DrawableHolderV2 drawableHolderV2) {
            if (drawableHolderV2 == null) {
                return;
            }
            drawableHolderV2.autoGifDrawable = null;
            drawableHolderV2.drawable = null;
            drawableHolderV2.picArea = null;
            LinkedList<DrawableHolderV2> linkedList = mHolders;
            synchronized (linkedList) {
                if (linkedList.size() < 20) {
                    linkedList.add(drawableHolderV2);
                }
            }
        }
    }

    private int getQCircleSharedImgTop(Drawable drawable) {
        if (drawable == null || drawable.getIntrinsicWidth() == 0) {
            return 0;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i3 = this.mWidth;
        float f16 = (i3 / intrinsicWidth) * intrinsicHeight;
        float f17 = i3 * 1.3f;
        if (f16 > f17) {
            return (int) ((f17 / 2.0f) - (f16 / 2.0f));
        }
        return 0;
    }

    protected void handleGifOnIdle(AutoGifDrawable autoGifDrawable) {
        if (autoGifDrawable == null) {
            return;
        }
        if (isListViewScrollIdle()) {
            if (autoGifDrawable.isRunning()) {
                return;
            }
            autoGifDrawable.start();
        } else if (autoGifDrawable.isRunning()) {
            autoGifDrawable.stop();
        }
    }

    protected boolean drawRect(Canvas canvas, Paint paint, int i3, boolean z16) {
        ArrayList<FeedPictureInfo> arrayList;
        VideoInfo videoInfo;
        if (canvas == null || paint == null || (arrayList = this.mPicInfos) == null || arrayList.size() <= i3 || !this.isUsePicInfo) {
            return false;
        }
        FeedPictureInfo feedPictureInfo = this.mPicInfos.get(i3);
        if (feedPictureInfo != null) {
            int i16 = AnonymousClass6.$SwitchMap$com$qzone$proxy$feedcomponent$model$FeedPictureInfo$ImageType[feedPictureInfo.d().ordinal()];
            if (i16 == 2) {
                Drawable drawable = AreaManager.GIF_DRAWABLE;
                int i17 = this.mPicSize;
                drawable.setBounds(i17 - AreaConst.dp28, i17 - AreaConst.dp15, i17, i17);
                AreaManager.GIF_DRAWABLE.draw(canvas);
            } else if (i16 == 4 || i16 == 5) {
                canvas.save();
                Drawable drawable2 = AreaManager.PANORAMA_LOG0_DRAWABLE;
                int intrinsicWidth = this.mPicSize - drawable2.getIntrinsicWidth();
                int i18 = AreaConst.dp7;
                canvas.translate(intrinsicWidth - i18, (this.mPicSize - drawable2.getIntrinsicHeight()) - i18);
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                drawable2.draw(canvas);
                canvas.restore();
            }
        }
        if (!this.isQunFeed) {
            int i19 = this.MAX_DISPLAY_PIC_NUM;
            if (i3 == i19 - 1 && this.mUPloadNum > i19) {
                paint.setColor(1711276032);
                RectF rectF = rect;
                canvas.drawRect(0.0f, 0.0f, rectF.width(), rectF.height(), paint);
                int i26 = AreaConst.dp18;
                paint.setColor(-1);
                paint.setTextSize(DEFAULT_NUM_TEXTSIZE);
                int height = ((int) (((rectF.height() - paint.descent()) - paint.ascent()) / 2.0f)) + AreaConst.f48746dp1;
                canvas.drawText(Integer.toString((this.mUPloadNum - this.MAX_DISPLAY_PIC_NUM) + 1), ((((int) (rectF.width() - this.playingTextWidth)) / 2) - AreaConst.dp8) + i26, height, paint);
                int width = (((int) (rectF.width() - this.playingTextWidth)) / 2) - AreaConst.dp10;
                int i27 = (height - AreaConst.f48747dp2) - (this.playingTextHeight / 2);
                AreaManager.MULTIPICTURE_ARROW.setBounds(width, i27, width + i26, i26 + i27);
                AreaManager.MULTIPICTURE_ARROW.draw(canvas);
            }
        }
        int i28 = this.MAX_DISPLAY_PIC_NUM;
        if ((i3 != i28 - 1 || this.mUPloadNum <= i28) && feedPictureInfo != null && feedPictureInfo.f50260w == 1 && (videoInfo = feedPictureInfo.f50261x) != null && !videoInfo.isErrorStatues()) {
            float width2 = rect.width();
            int i29 = this.PLAY_ICON_VALUE;
            int i36 = ((int) (width2 - i29)) / 2;
            AreaManager.ICON_VIDEO_PLAY.setBounds(i36, i36, i36 + i29, i29 + i36);
            AreaManager.ICON_VIDEO_PLAY.draw(canvas);
        }
        return true;
    }

    private static void reportImageShowTime(long j3, String str) {
        if (j3 != 0) {
            long currentTimeMillis = System.currentTimeMillis() - j3;
            if (currentTimeMillis > 0) {
                i.H().c2(currentTimeMillis, str);
            }
        }
    }

    public void setPicInfos(FeedPictureInfo[] feedPictureInfoArr, boolean z16, boolean z17, boolean z18, BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
        setPicInfos(feedPictureInfoArr, z16, z17, z18);
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 != null && businessFeedData2.isQCircleRecommFeed()) {
            CanvasQcircleRecomBottomView canvasQcircleRecomBottomView = this.mBottomView;
            if (canvasQcircleRecomBottomView == null) {
                this.mBottomView = new CanvasQcircleRecomBottomView(getContext(), this.mFeedData, false);
            } else {
                canvasQcircleRecomBottomView.resetFeedData(businessFeedData, false);
                this.mBottomView.postInvalidate();
            }
            this.mBottomView.setVisibility(0);
            return;
        }
        this.mBottomView = null;
    }
}
