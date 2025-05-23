package com.tencent.richframework.widget.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.richframework.widget.scale.imageview.R$styleable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SubsamplingScaleImageView extends View {
    private static final String TAG = "SubsamplingScaleImageView";
    private static Bitmap.Config preferredBitmapConfig;
    private Anim anim;
    public boolean atXEdge;
    public boolean atYEdge;
    private Bitmap bitmap;
    protected ImageDecoder bitmapDecoder;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugLinePaint;
    private Paint debugTextPaint;
    private ImageRegionDecoder decoder;
    private final ReadWriteLock decoderLock;
    private final float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private Executor executor;
    private int fullImageSampleSize;
    private final Handler handler;
    private boolean imageLoadedSent;
    private boolean isAutoMagnified;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private final int mTouchSlop;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private OnImageEventListener onImageEventListener;
    private View.OnLongClickListener onLongClickListener;
    private int orientationConfig;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private boolean quickScaleMoved;
    private PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    private PointF quickScaleVLastPoint;
    private PointF quickScaleVStart;
    private boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private GestureDetector singleDetector;
    private final float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private final PointF vTranslateBefore;
    private PointF vTranslateStart;
    private boolean zoomEnabled;
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(0, 90, 180, 270, -1);
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_EASING_STYLES = Arrays.asList(2, 1);
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(2, 1, 3, 4);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class Anim {
        private long duration;
        private int easing;
        private boolean interruptible;
        private int origin;
        private PointF sCenterEnd;
        private PointF sCenterEndRequested;
        private PointF sCenterStart;
        private float scaleEnd;
        private float scaleStart;
        private long time;
        private PointF vFocusEnd;
        private PointF vFocusStart;

        Anim() {
            this.duration = 500L;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }

        static /* synthetic */ OnAnimationEventListener access$2800(Anim anim) {
            anim.getClass();
            return null;
        }

        static /* synthetic */ OnAnimationEventListener access$2802(Anim anim, OnAnimationEventListener onAnimationEventListener) {
            anim.getClass();
            return onAnimationEventListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class BitmapLoadTask implements Runnable {
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z16) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageDecoder make;
            final String uri = this.source.toString();
            final Context context = this.contextRef.get();
            DecoderFactory<? extends ImageDecoder> decoderFactory = this.decoderFactoryRef.get();
            final SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            try {
                ImageDecoder imageDecoder = subsamplingScaleImageView.bitmapDecoder;
                if (imageDecoder != null) {
                    make = imageDecoder;
                } else {
                    make = decoderFactory.make();
                }
                make.decode(context, this.source, subsamplingScaleImageView.getWidth(), subsamplingScaleImageView.getHeight(), new Consumer<Bitmap>() { // from class: com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.BitmapLoadTask.1
                    @Override // androidx.core.util.Consumer
                    public void accept(final Bitmap bitmap) {
                        final Integer valueOf = Integer.valueOf(SubsamplingScaleImageView.getExifOrientation(context, uri));
                        subsamplingScaleImageView.post(new Runnable() { // from class: com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.BitmapLoadTask.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (bitmap != null) {
                                    if (BitmapLoadTask.this.preview) {
                                        subsamplingScaleImageView.onPreviewLoaded(bitmap);
                                        return;
                                    } else {
                                        subsamplingScaleImageView.onImageLoaded(bitmap, valueOf.intValue(), false);
                                        return;
                                    }
                                }
                                if (BitmapLoadTask.this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                                    if (BitmapLoadTask.this.preview) {
                                        subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(BitmapLoadTask.this.exception);
                                    } else {
                                        subsamplingScaleImageView.onImageEventListener.onImageLoadError(BitmapLoadTask.this.exception);
                                    }
                                }
                            }
                        });
                    }
                });
            } catch (Exception e16) {
                RFWLog.e(SubsamplingScaleImageView.TAG, RFWLog.USR, e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnAnimationEventListener {
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception exc);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnStateChangedListener {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class ScaleAndTranslate {
        private float scale;
        private final PointF vTranslate;

        ScaleAndTranslate(float f16, PointF pointF) {
            this.scale = f16;
            this.vTranslate = pointF;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class Tile {
        private Bitmap bitmap;
        private Rect fileSRect;
        private boolean loading;
        private Rect sRect;
        private int sampleSize;
        private Rect vRect;
        private boolean visible;

        Tile() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            tile.loading = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                ImageRegionDecoder imageRegionDecoder = this.decoderRef.get();
                Tile tile = this.tileRef.get();
                if (imageRegionDecoder == null || tile == null || subsamplingScaleImageView == null || !imageRegionDecoder.isReady() || !tile.visible) {
                    if (tile == null) {
                        return null;
                    }
                    tile.loading = false;
                    return null;
                }
                subsamplingScaleImageView.debug("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, Integer.valueOf(tile.sampleSize));
                subsamplingScaleImageView.decoderLock.readLock().lock();
                try {
                    if (imageRegionDecoder.isReady()) {
                        subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                        if (subsamplingScaleImageView.sRegion != null) {
                            tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                        }
                        return imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                    }
                    tile.loading = false;
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                    return null;
                } finally {
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                }
            } catch (Exception e16) {
                RFWLog.e(SubsamplingScaleImageView.TAG, RFWLog.USR, "Failed to decode tile", e16);
                this.exception = e16;
                return null;
            } catch (OutOfMemoryError e17) {
                RFWLog.e(SubsamplingScaleImageView.TAG, RFWLog.USR, "Failed to decode tile - OutOfMemoryError", e17);
                this.exception = new RuntimeException(e17);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            Tile tile = this.tileRef.get();
            if (subsamplingScaleImageView == null || tile == null) {
                return;
            }
            if (bitmap != null) {
                tile.bitmap = bitmap;
                tile.loading = false;
                subsamplingScaleImageView.onTileLoaded();
            } else {
                if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                    return;
                }
                subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory<? extends ImageRegionDecoder> decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("TilesInitTask.doInBackground", new Object[0]);
                ImageRegionDecoder make = decoderFactory.make();
                this.decoder = make;
                Point init = make.init(context, this.source);
                int i3 = init.x;
                int i16 = init.y;
                int exifOrientation = SubsamplingScaleImageView.getExifOrientation(context, uri);
                if (subsamplingScaleImageView.sRegion != null) {
                    subsamplingScaleImageView.sRegion.left = Math.max(0, subsamplingScaleImageView.sRegion.left);
                    subsamplingScaleImageView.sRegion.top = Math.max(0, subsamplingScaleImageView.sRegion.top);
                    subsamplingScaleImageView.sRegion.right = Math.min(i3, subsamplingScaleImageView.sRegion.right);
                    subsamplingScaleImageView.sRegion.bottom = Math.min(i16, subsamplingScaleImageView.sRegion.bottom);
                    i3 = subsamplingScaleImageView.sRegion.width();
                    i16 = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{i3, i16, exifOrientation};
            } catch (Exception e16) {
                RFWLog.e(SubsamplingScaleImageView.TAG, RFWLog.USR, "Failed to initialise bitmap decoder", e16);
                this.exception = e16;
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else {
                    if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                        return;
                    }
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.debug = false;
        this.orientationConfig = -1;
        this.maxScale = 2.0f;
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = Integer.MAX_VALUE;
        this.maxTileHeight = Integer.MAX_VALUE;
        this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 150;
        this.vTranslateBefore = new PointF(0.0f, 0.0f);
        this.minScale = minScale();
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1 && SubsamplingScaleImageView.this.onLongClickListener != null) {
                    SubsamplingScaleImageView.this.maxTouchCount = 0;
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.super.setOnLongClickListener(null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SubsamplingScaleImageView);
            int i3 = R$styleable.SubsamplingScaleImageView_assetName;
            if (obtainStyledAttributes.hasValue(i3) && (string = obtainStyledAttributes.getString(i3)) != null && string.length() > 0) {
                setImage(ImageSource.asset(string).tilingEnabled());
            }
            int i16 = R$styleable.SubsamplingScaleImageView_src;
            if (obtainStyledAttributes.hasValue(i16) && (resourceId = obtainStyledAttributes.getResourceId(i16, 0)) > 0) {
                setImage(ImageSource.resource(resourceId).tilingEnabled());
            }
            int i17 = R$styleable.SubsamplingScaleImageView_panEnabled;
            if (obtainStyledAttributes.hasValue(i17)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(i17, true));
            }
            int i18 = R$styleable.SubsamplingScaleImageView_zoomEnabled;
            if (obtainStyledAttributes.hasValue(i18)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(i18, true));
            }
            int i19 = R$styleable.SubsamplingScaleImageView_quickScaleEnabled;
            if (obtainStyledAttributes.hasValue(i19)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(i19, true));
            }
            int i26 = R$styleable.SubsamplingScaleImageView_tileBackgroundColor;
            if (obtainStyledAttributes.hasValue(i26)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(i26, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int calculateInSampleSize(float f16) {
        int round;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f16 *= this.minimumTileDpi / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth = (int) (sWidth() * f16);
        int sHeight = (int) (sHeight() * f16);
        if (sWidth != 0 && sHeight != 0) {
            int i3 = 1;
            if (sHeight() <= sHeight && sWidth() <= sWidth) {
                round = 1;
            } else {
                round = Math.round(sHeight() / sHeight);
                int round2 = Math.round(sWidth() / sWidth);
                if (round >= round2) {
                    round = round2;
                }
            }
            while (true) {
                int i16 = i3 * 2;
                if (i16 < round) {
                    i3 = i16;
                } else {
                    return i3;
                }
            }
        } else {
            return 32;
        }
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onImageLoaded();
            }
        }
        return isBaseLayerReady;
    }

    private boolean checkReady() {
        boolean z16;
        if (getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.readySent && z16) {
            preDraw();
            this.readySent = true;
            onReady();
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onReady();
            }
        }
        return z16;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            Paint paint = new Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if ((this.debugTextPaint == null || this.debugLinePaint == null) && this.debug) {
            Paint paint2 = new Paint();
            this.debugTextPaint = paint2;
            paint2.setTextSize(px(12));
            this.debugTextPaint.setColor(-65281);
            this.debugTextPaint.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.debugLinePaint = paint3;
            paint3.setColor(-65281);
            this.debugLinePaint.setStyle(Paint.Style.STROKE);
            this.debugLinePaint.setStrokeWidth(px(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void debug(String str, Object... objArr) {
        if (this.debug) {
            RFWLog.d(TAG, RFWLog.DEV, String.format(str, objArr));
        }
    }

    private float distance(float f16, float f17, float f18, float f19) {
        float f26 = f16 - f17;
        float f27 = f18 - f19;
        return (float) Math.sqrt((f26 * f26) + (f27 * f27));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        boolean z16;
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = sWidth() / 2;
                pointF.y = sHeight() / 2;
            }
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        float f16 = this.scale;
        if (f16 > min * 0.9d && f16 != this.minScale) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            min = minScale();
        }
        float f17 = min;
        int i3 = this.doubleTapZoomStyle;
        if (i3 == 3) {
            setScaleAndCenter(f17, pointF);
        } else if (i3 != 2 && z16 && this.panEnabled) {
            if (i3 == 1) {
                new AnimationBuilder(f17, pointF, pointF2).withInterruptible(false).withDuration(this.doubleTapZoomDuration).withOrigin(4).start();
            }
        } else {
            new AnimationBuilder(f17, pointF).withInterruptible(false).withDuration(this.doubleTapZoomDuration).withOrigin(4).start();
        }
        invalidate();
    }

    private void drawDebugMsg(Canvas canvas) {
        if (this.debug) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Scale: ");
            Locale locale = Locale.ENGLISH;
            sb5.append(String.format(locale, "%.2f", Float.valueOf(this.scale)));
            sb5.append(" (");
            sb5.append(String.format(locale, "%.2f", Float.valueOf(minScale())));
            sb5.append(" - ");
            sb5.append(String.format(locale, "%.2f", Float.valueOf(this.maxScale)));
            sb5.append(")");
            canvas.drawText(sb5.toString(), px(5), px(15), this.debugTextPaint);
            canvas.drawText("Translate: " + String.format(locale, "%.2f", Float.valueOf(this.vTranslate.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(this.vTranslate.y)), px(5), px(30), this.debugTextPaint);
            PointF center = getCenter();
            canvas.drawText("Source center: " + String.format(locale, "%.2f", Float.valueOf(center.x)) + ":" + String.format(locale, "%.2f", Float.valueOf(center.y)), px(5), px(45), this.debugTextPaint);
            Anim anim = this.anim;
            if (anim != null) {
                PointF sourceToViewCoord = sourceToViewCoord(anim.sCenterStart);
                PointF sourceToViewCoord2 = sourceToViewCoord(this.anim.sCenterEndRequested);
                PointF sourceToViewCoord3 = sourceToViewCoord(this.anim.sCenterEnd);
                canvas.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, px(10), this.debugLinePaint);
                this.debugLinePaint.setColor(SupportMenu.CATEGORY_MASK);
                canvas.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, px(20), this.debugLinePaint);
                this.debugLinePaint.setColor(-16776961);
                canvas.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, px(25), this.debugLinePaint);
                this.debugLinePaint.setColor(-16711681);
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.debugLinePaint);
            }
            if (this.vCenterStart != null) {
                this.debugLinePaint.setColor(SupportMenu.CATEGORY_MASK);
                PointF pointF = this.vCenterStart;
                canvas.drawCircle(pointF.x, pointF.y, px(20), this.debugLinePaint);
            }
            if (this.quickScaleSCenter != null) {
                this.debugLinePaint.setColor(-16776961);
                canvas.drawCircle(sourceToViewX(this.quickScaleSCenter.x), sourceToViewY(this.quickScaleSCenter.y), px(35), this.debugLinePaint);
            }
            if (this.quickScaleVStart != null && this.isQuickScaling) {
                this.debugLinePaint.setColor(-16711681);
                PointF pointF2 = this.quickScaleVStart;
                canvas.drawCircle(pointF2.x, pointF2.y, px(30), this.debugLinePaint);
            }
            this.debugLinePaint.setColor(-65281);
        }
    }

    private void drawMatrixBitmap(Canvas canvas) {
        float f16;
        int i3;
        int i16;
        float f17 = this.scale;
        if (this.bitmapIsPreview) {
            f17 *= this.sWidth / this.bitmap.getWidth();
            f16 = this.scale * (this.sHeight / this.bitmap.getHeight());
        } else {
            f16 = f17;
        }
        if (this.matrix == null) {
            this.matrix = new Matrix();
        }
        this.matrix.reset();
        this.matrix.postScale(f17, f16);
        this.matrix.postRotate(getRequiredRotation());
        Matrix matrix = this.matrix;
        PointF pointF = this.vTranslate;
        matrix.postTranslate(pointF.x, pointF.y);
        if (getRequiredRotation() == 180) {
            Matrix matrix2 = this.matrix;
            float f18 = this.scale;
            matrix2.postTranslate(this.sWidth * f18, f18 * this.sHeight);
        } else if (getRequiredRotation() == 90) {
            this.matrix.postTranslate(this.scale * this.sHeight, 0.0f);
        } else if (getRequiredRotation() == 270) {
            this.matrix.postTranslate(0.0f, this.scale * this.sWidth);
        }
        if (this.tileBgPaint != null) {
            if (this.sRect == null) {
                this.sRect = new RectF();
            }
            RectF rectF = this.sRect;
            if (this.bitmapIsPreview) {
                i3 = this.bitmap.getWidth();
            } else {
                i3 = this.sWidth;
            }
            float f19 = i3;
            if (this.bitmapIsPreview) {
                i16 = this.bitmap.getHeight();
            } else {
                i16 = this.sHeight;
            }
            rectF.set(0.0f, 0.0f, f19, i16);
            this.matrix.mapRect(this.sRect);
            canvas.drawRect(this.sRect, this.tileBgPaint);
        }
        canvas.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
    }

    private void drawTileBitmap(Canvas canvas, Tile tile) {
        if (this.tileBgPaint != null) {
            canvas.drawRect(tile.vRect, this.tileBgPaint);
        }
        if (this.matrix == null) {
            this.matrix = new Matrix();
        }
        this.matrix.reset();
        setMatrixArray(this.srcArray, 0.0f, 0.0f, tile.bitmap.getWidth(), 0.0f, tile.bitmap.getWidth(), tile.bitmap.getHeight(), 0.0f, tile.bitmap.getHeight());
        if (getRequiredRotation() == 0) {
            setMatrixArray(this.dstArray, tile.vRect.left, tile.vRect.top, tile.vRect.right, tile.vRect.top, tile.vRect.right, tile.vRect.bottom, tile.vRect.left, tile.vRect.bottom);
        } else if (getRequiredRotation() == 90) {
            setMatrixArray(this.dstArray, tile.vRect.right, tile.vRect.top, tile.vRect.right, tile.vRect.bottom, tile.vRect.left, tile.vRect.bottom, tile.vRect.left, tile.vRect.top);
        } else if (getRequiredRotation() == 180) {
            setMatrixArray(this.dstArray, tile.vRect.right, tile.vRect.bottom, tile.vRect.left, tile.vRect.bottom, tile.vRect.left, tile.vRect.top, tile.vRect.right, tile.vRect.top);
        } else if (getRequiredRotation() == 270) {
            setMatrixArray(this.dstArray, tile.vRect.left, tile.vRect.bottom, tile.vRect.left, tile.vRect.top, tile.vRect.right, tile.vRect.top, tile.vRect.right, tile.vRect.bottom);
        }
        this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
        canvas.drawBitmap(tile.bitmap, this.matrix, this.bitmapPaint);
        if (this.debug) {
            canvas.drawRect(tile.vRect, this.debugLinePaint);
        }
    }

    private void drawTileLayer(Canvas canvas) {
        if (this.tileMap != null && isBaseLayerReady()) {
            renderTilesLayer(canvas);
        } else if (this.bitmap != null) {
            drawMatrixBitmap(canvas);
        }
    }

    private float ease(int i3, long j3, float f16, float f17, long j16) {
        if (i3 != 1) {
            if (i3 == 2) {
                return easeInOutQuad(j3, f16, f17, j16);
            }
            throw new IllegalStateException("Unexpected easing type: " + i3);
        }
        return easeOutQuad(j3, f16, f17, j16);
    }

    private float easeInOutQuad(long j3, float f16, float f17, long j16) {
        float f18;
        float f19 = ((float) j3) / (((float) j16) / 2.0f);
        if (f19 < 1.0f) {
            f18 = (f17 / 2.0f) * f19;
        } else {
            float f26 = f19 - 1.0f;
            f18 = (-f17) / 2.0f;
            f19 = (f26 * (f26 - 2.0f)) - 1.0f;
        }
        return (f18 * f19) + f16;
    }

    private float easeOutQuad(long j3, float f16, float f17, long j16) {
        float f18 = ((float) j3) / ((float) j16);
        return ((-f17) * f18 * (f18 - 2.0f)) + f16;
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
            return;
        }
        if (getRequiredRotation() == 90) {
            int i3 = rect.top;
            int i16 = this.sHeight;
            rect2.set(i3, i16 - rect.right, rect.bottom, i16 - rect.left);
        } else {
            if (getRequiredRotation() == 180) {
                int i17 = this.sWidth;
                int i18 = i17 - rect.right;
                int i19 = this.sHeight;
                rect2.set(i18, i19 - rect.bottom, i17 - rect.left, i19 - rect.top);
                return;
            }
            int i26 = this.sWidth;
            rect2.set(i26 - rect.bottom, rect.left, i26 - rect.top, rect.right);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitToBounds(boolean z16, ScaleAndTranslate scaleAndTranslate) {
        float max;
        int max2;
        float max3;
        if (this.panLimit == 2 && isReady()) {
            z16 = false;
        }
        PointF pointF = scaleAndTranslate.vTranslate;
        float limitedScale = limitedScale(scaleAndTranslate.scale);
        float sWidth = sWidth() * limitedScale;
        float sHeight = sHeight() * limitedScale;
        if (this.panLimit == 3 && isReady()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2) - sWidth);
            pointF.y = Math.max(pointF.y, (getHeight() / 2) - sHeight);
        } else if (z16) {
            pointF.x = Math.max(pointF.x, getWidth() - sWidth);
            pointF.y = Math.max(pointF.y, getHeight() - sHeight);
        } else {
            pointF.x = Math.max(pointF.x, -sWidth);
            pointF.y = Math.max(pointF.y, -sHeight);
        }
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        float paddingTop = (getPaddingTop() > 0 || getPaddingBottom() > 0) ? getPaddingTop() / (getPaddingTop() + getPaddingBottom()) : 0.5f;
        if (this.panLimit == 3 && isReady()) {
            max = Math.max(0, getWidth() / 2);
            max2 = Math.max(0, getHeight() / 2);
        } else {
            if (z16) {
                max = Math.max(0.0f, (getWidth() - sWidth) * paddingLeft);
                max3 = Math.max(0.0f, (getHeight() - sHeight) * paddingTop);
                pointF.x = Math.min(pointF.x, max);
                pointF.y = Math.min(pointF.y, max3);
                scaleAndTranslate.scale = limitedScale;
            }
            max = Math.max(0, getWidth());
            max2 = Math.max(0, getHeight());
        }
        max3 = max2;
        pointF.x = Math.min(pointF.x, max);
        pointF.y = Math.min(pointF.y, max3);
        scaleAndTranslate.scale = limitedScale;
    }

    @AnyThread
    static int getExifOrientation(Context context, String str) {
        int i3;
        int i16 = 0;
        if (str.startsWith("content")) {
            Cursor cursor = null;
            try {
                try {
                    cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse(str), new String[]{"orientation"}, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        int i17 = cursor.getInt(0);
                        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i17)) && i17 != -1) {
                            i16 = i17;
                        } else {
                            RFWLog.e(TAG, RFWLog.USR, "Unsupported orientation: " + i17);
                        }
                    }
                    if (cursor == null) {
                        return i16;
                    }
                } catch (Exception unused) {
                    RFWLog.e(TAG, RFWLog.USR, "Could not get orientation of image from media store");
                    if (cursor == null) {
                        return 0;
                    }
                }
                cursor.close();
                return i16;
            } catch (Throwable th5) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th5;
            }
        }
        if (!str.startsWith("file:///") || str.startsWith("file:///android_asset/")) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(str.substring(7)).getAttributeInt("Orientation", 1);
            if (attributeInt != 1 && attributeInt != 0) {
                if (attributeInt == 6) {
                    i3 = 90;
                } else if (attributeInt == 3) {
                    i3 = 180;
                } else if (attributeInt == 8) {
                    i3 = 270;
                } else {
                    RFWLog.e(TAG, RFWLog.USR, "Unsupported EXIF orientation: " + attributeInt);
                    return 0;
                }
                return i3;
            }
            return 0;
        } catch (Exception unused2) {
            RFWLog.e(TAG, RFWLog.USR, "Could not get EXIF orientation of image");
            return 0;
        }
    }

    @NonNull
    private Point getMaxBitmapDimensions(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.maxTileWidth), Math.min(canvas.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    @AnyThread
    private int getRequiredRotation() {
        int i3 = this.orientationConfig;
        if (i3 == -1) {
            return this.sOrientation;
        }
        return i3;
    }

    private boolean handMultiTouchMove(@NonNull MotionEvent motionEvent) {
        float distance = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
        float x16 = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
        float y16 = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        if (!this.zoomEnabled) {
            return false;
        }
        PointF pointF = this.vCenterStart;
        if (distance(pointF.x, x16, pointF.y, y16) <= 5.0f && Math.abs(distance - this.vDistStart) <= 5.0f && !this.isPanning) {
            return false;
        }
        this.isZooming = true;
        this.isPanning = true;
        double d16 = this.scale;
        float min = Math.min(this.maxScale, (distance / this.vDistStart) * this.scaleStart);
        this.scale = min;
        if (min <= minScale()) {
            this.vDistStart = distance;
            this.scaleStart = minScale();
            this.vCenterStart.set(x16, y16);
            this.vTranslateStart.set(this.vTranslate);
        } else if (this.panEnabled) {
            PointF pointF2 = this.vCenterStart;
            float f16 = pointF2.x;
            PointF pointF3 = this.vTranslateStart;
            float f17 = f16 - pointF3.x;
            float f18 = pointF2.y - pointF3.y;
            float f19 = this.scale;
            float f26 = this.scaleStart;
            float f27 = f17 * (f19 / f26);
            float f28 = f18 * (f19 / f26);
            PointF pointF4 = this.vTranslate;
            pointF4.x = x16 - f27;
            pointF4.y = y16 - f28;
            if ((sHeight() * d16 < getHeight() && this.scale * sHeight() >= getHeight()) || (d16 * sWidth() < getWidth() && this.scale * sWidth() >= getWidth())) {
                fitToBounds(true);
                this.vCenterStart.set(x16, y16);
                this.vTranslateStart.set(this.vTranslate);
                this.scaleStart = this.scale;
                this.vDistStart = distance;
            }
        } else if (this.sRequestedCenter != null) {
            this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sRequestedCenter.x);
            this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sRequestedCenter.y);
        } else {
            this.vTranslate.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
            this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
        }
        fitToBounds(true);
        refreshRequiredTiles(this.eagerLoadingEnabled);
        return true;
    }

    private void handleActionDownEvent(@NonNull MotionEvent motionEvent, int i3) {
        this.anim = null;
        requestDisallowInterceptTouchEvent(true);
        this.maxTouchCount = Math.max(this.maxTouchCount, i3);
        if (i3 >= 2) {
            if (this.zoomEnabled) {
                float distance = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                this.scaleStart = this.scale;
                this.vDistStart = distance;
                PointF pointF = this.vTranslateStart;
                PointF pointF2 = this.vTranslate;
                pointF.set(pointF2.x, pointF2.y);
                this.vCenterStart.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
            } else {
                this.maxTouchCount = 0;
            }
            this.handler.removeMessages(1);
            return;
        }
        if (!this.isQuickScaling) {
            PointF pointF3 = this.vTranslateStart;
            PointF pointF4 = this.vTranslate;
            pointF3.set(pointF4.x, pointF4.y);
            this.vCenterStart.set(motionEvent.getX(), motionEvent.getY());
            this.handler.sendEmptyMessageDelayed(1, 600L);
        }
    }

    private boolean handleActionMoveEvent(@NonNull MotionEvent motionEvent, int i3) {
        if (this.maxTouchCount > 0) {
            if (i3 >= 2) {
                return handMultiTouchMove(motionEvent);
            }
            if (this.isQuickScaling) {
                return handleQuickScaling(motionEvent);
            }
            if (!this.isZooming) {
                return handleNoZooming(motionEvent);
            }
        }
        return false;
    }

    private boolean handleNoZooming(@NonNull MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        float abs = Math.abs(motionEvent.getX() - this.vCenterStart.x);
        float abs2 = Math.abs(motionEvent.getY() - this.vCenterStart.y);
        float f16 = this.density * 5.0f;
        if (abs <= f16 && abs2 <= f16 && !this.isPanning) {
            return false;
        }
        this.vTranslate.x = this.vTranslateStart.x + (motionEvent.getX() - this.vCenterStart.x);
        this.vTranslate.y = this.vTranslateStart.y + (motionEvent.getY() - this.vCenterStart.y);
        PointF pointF = this.vTranslate;
        float f17 = pointF.x;
        float f18 = pointF.y;
        fitToBounds(true);
        PointF pointF2 = this.vTranslate;
        if (f17 != pointF2.x) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.atXEdge = z16;
        float f19 = pointF2.y;
        if (f18 != f19) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.atYEdge = z17;
        if (z16 && abs > abs2 && !this.isPanning) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 && abs2 > abs && !this.isPanning) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (f18 == f19 && abs2 > 3.0f * f16) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (!z18 && !z19 && (!z16 || !z17 || z26 || this.isPanning)) {
            this.isPanning = true;
        } else if (abs > f16 || abs2 > f16) {
            this.maxTouchCount = 0;
            this.handler.removeMessages(1);
            requestDisallowInterceptTouchEvent(false);
        }
        if (!this.panEnabled) {
            PointF pointF3 = this.vTranslate;
            PointF pointF4 = this.vTranslateStart;
            pointF3.x = pointF4.x;
            pointF3.y = pointF4.y;
            requestDisallowInterceptTouchEvent(false);
        }
        refreshRequiredTiles(this.eagerLoadingEnabled);
        return true;
    }

    private boolean handleQuickScaling(@NonNull MotionEvent motionEvent) {
        boolean z16;
        float abs = (Math.abs(this.quickScaleVStart.y - motionEvent.getY()) * 2.0f) + this.quickScaleThreshold;
        if (this.quickScaleLastDistance == -1.0f) {
            this.quickScaleLastDistance = abs;
        }
        float y16 = motionEvent.getY();
        PointF pointF = this.quickScaleVLastPoint;
        if (y16 > pointF.y) {
            z16 = true;
        } else {
            z16 = false;
        }
        pointF.set(0.0f, motionEvent.getY());
        float f16 = 1.0f;
        float abs2 = Math.abs(1.0f - (abs / this.quickScaleLastDistance)) * 0.5f;
        if (abs2 > 0.03f || this.quickScaleMoved) {
            this.quickScaleMoved = true;
            if (this.quickScaleLastDistance > 0.0f) {
                if (z16) {
                    f16 = abs2 + 1.0f;
                } else {
                    f16 = 1.0f - abs2;
                }
            }
            double d16 = this.scale;
            float max = Math.max(minScale(), Math.min(this.maxScale, this.scale * f16));
            this.scale = max;
            if (this.panEnabled) {
                PointF pointF2 = this.vCenterStart;
                float f17 = pointF2.x;
                PointF pointF3 = this.vTranslateStart;
                float f18 = f17 - pointF3.x;
                float f19 = pointF2.y;
                float f26 = f19 - pointF3.y;
                float f27 = this.scaleStart;
                float f28 = f18 * (max / f27);
                float f29 = f26 * (max / f27);
                PointF pointF4 = this.vTranslate;
                pointF4.x = f17 - f28;
                pointF4.y = f19 - f29;
                if ((sHeight() * d16 < getHeight() && this.scale * sHeight() >= getHeight()) || (d16 * sWidth() < getWidth() && this.scale * sWidth() >= getWidth())) {
                    fitToBounds(true);
                    this.vCenterStart.set(sourceToViewCoord(this.quickScaleSCenter));
                    this.vTranslateStart.set(this.vTranslate);
                    this.scaleStart = this.scale;
                    abs = 0.0f;
                }
            } else if (this.sRequestedCenter != null) {
                this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sRequestedCenter.x);
                this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sRequestedCenter.y);
            } else {
                this.vTranslate.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
                this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
            }
        }
        this.quickScaleLastDistance = abs;
        fitToBounds(true);
        refreshRequiredTiles(this.eagerLoadingEnabled);
        return true;
    }

    private synchronized void initialiseBaseLayer(@NonNull Point point) {
        debug("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        this.satTemp = scaleAndTranslate;
        fitToBounds(true, scaleAndTranslate);
        int calculateInSampleSize = calculateInSampleSize(this.satTemp.scale);
        this.fullImageSampleSize = calculateInSampleSize;
        if (calculateInSampleSize > 1) {
            this.fullImageSampleSize = calculateInSampleSize / 2;
        }
        if (this.fullImageSampleSize == 1 && this.sRegion == null && sWidth() < point.x && sHeight() < point.y) {
            this.decoder.recycle();
            this.decoder = null;
            new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false).run();
        } else {
            initialiseTileMap(point);
            Iterator<Tile> it = this.tileMap.get(Integer.valueOf(this.fullImageSampleSize)).iterator();
            while (it.hasNext()) {
                execute(new TileLoadTask(this, this.decoder, it.next()));
            }
            refreshRequiredTiles(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initialiseTileMap(Point point) {
        boolean z16;
        int i3;
        int i16;
        int i17 = 0;
        int i18 = 1;
        debug("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.tileMap = new LinkedHashMap();
        int i19 = this.fullImageSampleSize;
        int i26 = 1;
        int i27 = 1;
        while (true) {
            int sWidth = sWidth() / i26;
            int sHeight = sHeight() / i27;
            int i28 = sWidth / i19;
            int i29 = sHeight / i19;
            while (true) {
                if (i28 + i26 + i18 > point.x || (i28 > getWidth() * 1.25d && i19 < this.fullImageSampleSize)) {
                    i26++;
                    sWidth = sWidth() / i26;
                    i28 = sWidth / i19;
                    i18 = i18;
                    i17 = i17;
                }
            }
            while (true) {
                if (i29 + i27 + i18 > point.y || (i29 > getHeight() * 1.25d && i19 < this.fullImageSampleSize)) {
                    i27++;
                    sHeight = sHeight() / i27;
                    i29 = sHeight / i19;
                    i18 = i18;
                    i17 = i17;
                }
            }
            ArrayList arrayList = new ArrayList(i26 * i27);
            int i36 = i17;
            while (i36 < i26) {
                int i37 = i17;
                while (i37 < i27) {
                    Tile tile = new Tile();
                    tile.sampleSize = i19;
                    if (i19 == this.fullImageSampleSize) {
                        z16 = i18;
                    } else {
                        z16 = i17;
                    }
                    tile.visible = z16;
                    int i38 = i36 * sWidth;
                    int i39 = i37 * sHeight;
                    if (i36 == i26 - 1) {
                        i3 = sWidth();
                    } else {
                        i3 = (i36 + 1) * sWidth;
                    }
                    if (i37 == i27 - 1) {
                        i16 = sHeight();
                    } else {
                        i16 = (i37 + 1) * sHeight;
                    }
                    tile.sRect = new Rect(i38, i39, i3, i16);
                    tile.vRect = new Rect(0, 0, 0, 0);
                    tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                    i37++;
                    i17 = 0;
                    i18 = 1;
                }
                i36++;
                i18 = 1;
            }
            int i46 = i17;
            this.tileMap.put(Integer.valueOf(i19), arrayList);
            if (i19 == 1) {
                return;
            }
            i19 /= 2;
            i18 = 1;
            i17 = i46;
        }
    }

    private boolean isBaseLayerReady() {
        boolean z16 = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map == null) {
            return false;
        }
        for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
            if (entry.getKey().intValue() == this.fullImageSampleSize) {
                for (Tile tile : entry.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z16 = false;
                    }
                }
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public PointF limitedSCenter(float f16, float f17, float f18, @NonNull PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f16, f17, f18);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - vTranslateForSCenter.x) / f18, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - vTranslateForSCenter.y) / f18);
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float limitedScale(float f16) {
        return Math.min(this.maxScale, Math.max(minScale(), f16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean magnifyLongPicIfNeeded(boolean z16) {
        float width = getWidth();
        float height = getHeight();
        if (width > 0.0f && height > 0.0f) {
            int i3 = this.sWidth;
            int i16 = this.sHeight;
            if (i3 > 0 && i16 > 0) {
                String str = TAG;
                RFWLog.i(str, RFWLog.USR, "display width is " + width + " actualWidth is " + i3 + " display height is " + height + " actualHeight is " + i16);
                float f16 = ((float) i16) / height;
                float f17 = (float) i3;
                float f18 = f16 / (f17 / width);
                if (f18 <= 3.0f) {
                    RFWLog.i(str, RFWLog.USR, "not long pic, no need to scale");
                    return true;
                }
                RFWLog.i(str, RFWLog.USR, "target zoom is " + f18 + " max scale is " + this.maxScale + " current scale is " + getScale());
                float f19 = width / f17;
                this.doubleTapZoomScale = f19;
                if (this.isAutoMagnified) {
                    return false;
                }
                if (z16) {
                    new AnimationBuilder(f19, new PointF((getLeft() + getRight()) / 2.0f, 0.0f)).start();
                } else {
                    setScaleAndCenter(f19, new PointF((getLeft() + getRight()) / 2.0f, 0.0f));
                }
                this.isAutoMagnified = true;
                return true;
            }
            RFWLog.e(TAG, RFWLog.USR, "actual size less than 0");
            return false;
        }
        RFWLog.e(TAG, RFWLog.USR, "displayHeight is less than 0f");
        return false;
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i3 = this.minimumScaleType;
        if (i3 != 2 && i3 != 4) {
            if (i3 == 3) {
                float f16 = this.minScale;
                if (f16 > 0.0f) {
                    return f16;
                }
            }
            return Math.min((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
        }
        return Math.max((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onPreviewLoaded(Bitmap bitmap) {
        debug("onPreviewLoaded", new Object[0]);
        if (this.bitmap == null && !this.imageLoadedSent) {
            Rect rect = this.pRegion;
            if (rect != null) {
                this.bitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), this.pRegion.height());
            } else {
                this.bitmap = bitmap;
            }
            this.bitmapIsPreview = true;
            if (checkReady()) {
                invalidate();
                requestLayout();
            }
            return;
        }
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        Bitmap bitmap;
        debug("onTileLoaded", new Object[0]);
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && (bitmap = this.bitmap) != null) {
            if (!this.bitmapIsCached) {
                bitmap.recycle();
            }
            this.bitmap = null;
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null && this.bitmapIsCached) {
                onImageEventListener.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i3, int i16, int i17) {
        int i18;
        int i19;
        int i26;
        debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(this.orientationConfig));
        int i27 = this.sWidth;
        if (i27 > 0 && (i26 = this.sHeight) > 0 && (i27 != i3 || i26 != i16)) {
            reset(false);
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                if (!this.bitmapIsCached) {
                    bitmap.recycle();
                }
                this.bitmap = null;
                OnImageEventListener onImageEventListener = this.onImageEventListener;
                if (onImageEventListener != null && this.bitmapIsCached) {
                    onImageEventListener.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
        }
        this.decoder = imageRegionDecoder;
        this.sWidth = i3;
        this.sHeight = i16;
        this.sOrientation = i17;
        checkReady();
        if (!checkImageLoaded() && (i18 = this.maxTileWidth) > 0 && i18 != Integer.MAX_VALUE && (i19 = this.maxTileHeight) > 0 && i19 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
            initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));
        }
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        if (r1 != 262) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean onTouchEventInternal(@NonNull MotionEvent motionEvent) {
        boolean z16;
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 5) {
                        if (action != 6) {
                            if (action != 261) {
                            }
                        }
                    }
                } else if (handleActionMoveEvent(motionEvent, pointerCount)) {
                    this.handler.removeMessages(1);
                    invalidate();
                    return true;
                }
                return false;
            }
            this.handler.removeMessages(1);
            if (this.isQuickScaling) {
                this.isQuickScaling = false;
                if (!this.quickScaleMoved) {
                    doubleTapZoom(this.quickScaleSCenter, this.vCenterStart);
                }
            }
            if (this.maxTouchCount > 0 && ((z16 = this.isZooming) || this.isPanning)) {
                if (z16 && pointerCount == 2) {
                    this.isPanning = true;
                    PointF pointF = this.vTranslateStart;
                    PointF pointF2 = this.vTranslate;
                    pointF.set(pointF2.x, pointF2.y);
                    if (motionEvent.getActionIndex() == 1) {
                        this.vCenterStart.set(motionEvent.getX(0), motionEvent.getY(0));
                    } else {
                        this.vCenterStart.set(motionEvent.getX(1), motionEvent.getY(1));
                    }
                }
                if (pointerCount < 3) {
                    this.isZooming = false;
                }
                if (pointerCount < 2) {
                    this.isPanning = false;
                    this.maxTouchCount = 0;
                }
                refreshRequiredTiles(true);
                return true;
            }
            if (pointerCount == 1) {
                this.isZooming = false;
                this.isPanning = false;
                this.maxTouchCount = 0;
            }
            return true;
        }
        handleActionDownEvent(motionEvent, pointerCount);
        return true;
    }

    private void preDraw() {
        Float f16;
        if (getWidth() != 0 && getHeight() != 0 && this.sWidth > 0 && this.sHeight > 0) {
            if (this.sPendingCenter != null && (f16 = this.pendingScale) != null) {
                this.scale = f16.floatValue();
                if (this.vTranslate == null) {
                    this.vTranslate = new PointF();
                }
                this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sPendingCenter.x);
                this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sPendingCenter.y);
                this.sPendingCenter = null;
                this.pendingScale = null;
                fitToBounds(true);
                refreshRequiredTiles(true);
            }
            fitToBounds(false);
        }
    }

    private int px(int i3) {
        return (int) (this.density * i3);
    }

    private void refreshRequiredTiles(boolean z16) {
        if (this.decoder != null && this.tileMap != null) {
            int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
            Iterator<Map.Entry<Integer, List<Tile>>> it = this.tileMap.entrySet().iterator();
            while (it.hasNext()) {
                for (Tile tile : it.next().getValue()) {
                    if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                        tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            tile.bitmap = null;
                        }
                    }
                    if (tile.sampleSize == min) {
                        if (tileVisible(tile)) {
                            tile.visible = true;
                            if (!tile.loading && tile.bitmap == null && z16) {
                                execute(new TileLoadTask(this, this.decoder, tile));
                            }
                        } else if (tile.sampleSize != this.fullImageSampleSize) {
                            tile.visible = false;
                            if (tile.bitmap != null) {
                                tile.bitmap.recycle();
                                tile.bitmap = null;
                            }
                        }
                    } else if (tile.sampleSize == this.fullImageSampleSize) {
                        tile.visible = true;
                    }
                }
            }
        }
    }

    private void renderTilesLayer(Canvas canvas) {
        int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
        boolean z16 = false;
        for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
            if (entry.getKey().intValue() == min) {
                for (Tile tile : entry.getValue()) {
                    if (tile.visible && (tile.loading || tile.bitmap == null)) {
                        z16 = true;
                    }
                }
            }
        }
        for (Map.Entry<Integer, List<Tile>> entry2 : this.tileMap.entrySet()) {
            if (entry2.getKey().intValue() == min || z16) {
                for (Tile tile2 : entry2.getValue()) {
                    sourceToViewRect(tile2.sRect, tile2.vRect);
                    if (!tile2.loading && tile2.bitmap != null) {
                        drawTileBitmap(canvas, tile2);
                    } else if (tile2.loading && this.debug) {
                        canvas.drawText("LOADING", tile2.vRect.left + px(5), tile2.vRect.top + px(35), this.debugTextPaint);
                    }
                    if (tile2.visible && this.debug) {
                        canvas.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + "," + tile2.sRect.left + "," + tile2.sRect.bottom + "," + tile2.sRect.right, tile2.vRect.left + px(5), tile2.vRect.top + px(15), this.debugTextPaint);
                    }
                }
            }
        }
    }

    private void requestDisallowInterceptTouchEvent(boolean z16) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    private void reset(boolean z16) {
        OnImageEventListener onImageEventListener;
        debug("reset newImage=" + z16, new Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore.set(0.0f, 0.0f);
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z16) {
            this.uri = null;
            this.decoderLock.writeLock().lock();
            try {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null) {
                    imageRegionDecoder.recycle();
                    this.decoder = null;
                }
                this.decoderLock.writeLock().unlock();
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && !this.bitmapIsCached) {
                    bitmap.recycle();
                }
                if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
                    onImageEventListener.onPreviewReleased();
                }
                this.sWidth = 0;
                this.sHeight = 0;
                this.sOrientation = 0;
                this.sRegion = null;
                this.pRegion = null;
                this.readySent = false;
                this.imageLoadedSent = false;
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            } catch (Throwable th5) {
                this.decoderLock.writeLock().unlock();
                throw th5;
            }
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map != null) {
            Iterator<Map.Entry<Integer, List<Tile>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                for (Tile tile : it.next().getValue()) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState != null && VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.orientationConfig = imageViewState.getOrientation();
            this.pendingScale = Float.valueOf(imageViewState.getScale());
            this.sPendingCenter = imageViewState.getCenter();
            invalidate();
        }
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.sHeight;
        }
        return this.sWidth;
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation != 90 && requiredRotation != 270) {
            return this.sWidth;
        }
        return this.sHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (SubsamplingScaleImageView.this.zoomEnabled && SubsamplingScaleImageView.this.readySent && SubsamplingScaleImageView.this.vTranslate != null) {
                    SubsamplingScaleImageView.this.setGestureDetector(context);
                    if (SubsamplingScaleImageView.this.quickScaleEnabled) {
                        SubsamplingScaleImageView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                        SubsamplingScaleImageView.this.vTranslateStart = new PointF(SubsamplingScaleImageView.this.vTranslate.x, SubsamplingScaleImageView.this.vTranslate.y);
                        SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                        subsamplingScaleImageView.scaleStart = subsamplingScaleImageView.scale;
                        SubsamplingScaleImageView.this.isQuickScaling = true;
                        SubsamplingScaleImageView.this.isZooming = true;
                        SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                        SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                        subsamplingScaleImageView2.quickScaleSCenter = subsamplingScaleImageView2.viewToSourceCoord(subsamplingScaleImageView2.vCenterStart);
                        SubsamplingScaleImageView.this.quickScaleVStart = new PointF(motionEvent.getX(), motionEvent.getY());
                        SubsamplingScaleImageView.this.quickScaleVLastPoint = new PointF(SubsamplingScaleImageView.this.quickScaleSCenter.x, SubsamplingScaleImageView.this.quickScaleSCenter.y);
                        SubsamplingScaleImageView.this.quickScaleMoved = false;
                        return false;
                    }
                    SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                    subsamplingScaleImageView3.doubleTapZoom(subsamplingScaleImageView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                    return true;
                }
                return super.onDoubleTapEvent(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                if (SubsamplingScaleImageView.this.panEnabled && SubsamplingScaleImageView.this.readySent && SubsamplingScaleImageView.this.vTranslate != null && motionEvent != null && motionEvent2 != null && ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f || Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f) && ((Math.abs(f16) > 500.0f || Math.abs(f17) > 500.0f) && !SubsamplingScaleImageView.this.isZooming))) {
                    PointF pointF = new PointF(SubsamplingScaleImageView.this.vTranslate.x + (f16 * 0.25f), SubsamplingScaleImageView.this.vTranslate.y + (f17 * 0.25f));
                    new AnimationBuilder(new PointF(((SubsamplingScaleImageView.this.getWidth() / 2) - pointF.x) / SubsamplingScaleImageView.this.scale, ((SubsamplingScaleImageView.this.getHeight() / 2) - pointF.y) / SubsamplingScaleImageView.this.scale)).withEasing(1).withPanLimited(false).withOrigin(3).start();
                    return true;
                }
                return super.onFling(motionEvent, motionEvent2, f16, f17);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        }, new Handler(Looper.getMainLooper()));
        this.singleDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        }, new Handler(Looper.getMainLooper()));
    }

    private void setMatrixArray(float[] fArr, float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29) {
        fArr[0] = f16;
        fArr[1] = f17;
        fArr[2] = f18;
        fArr[3] = f19;
        fArr[4] = f26;
        fArr[5] = f27;
        fArr[6] = f28;
        fArr[7] = f29;
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        preferredBitmapConfig = config;
    }

    private void sourceToViewRect(@NonNull Rect rect, @NonNull Rect rect2) {
        rect2.set((int) sourceToViewX(rect.left), (int) sourceToViewY(rect.top), (int) sourceToViewX(rect.right), (int) sourceToViewY(rect.bottom));
    }

    private float sourceToViewX(float f16) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f16 * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f16) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f16 * this.scale) + pointF.y;
    }

    private boolean tileVisible(Tile tile) {
        float viewToSourceX = viewToSourceX(0.0f);
        float viewToSourceX2 = viewToSourceX(getWidth());
        float viewToSourceY = viewToSourceY(0.0f);
        float viewToSourceY2 = viewToSourceY(getHeight());
        if (viewToSourceX <= tile.sRect.right && tile.sRect.left <= viewToSourceX2 && viewToSourceY <= tile.sRect.bottom && tile.sRect.top <= viewToSourceY2) {
            return true;
        }
        return false;
    }

    @NonNull
    private PointF vTranslateForSCenter(float f16, float f17, float f18) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = f18;
        this.satTemp.vTranslate.set(paddingLeft - (f16 * f18), paddingTop - (f17 * f18));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    private float viewToSourceX(float f16) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f16 - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f16) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f16 - pointF.y) / this.scale;
    }

    @Nullable
    public final PointF getCenter() {
        return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
    }

    public final float getScale() {
        return this.scale;
    }

    public boolean isLoadSameImage(ImageSource imageSource) {
        if (this.uri == null || imageSource.getUri() == null) {
            return false;
        }
        RFWLog.i(TAG, RFWLog.CLR, "previous uri is " + this.uri + ", new uri is " + imageSource.getUri());
        return this.uri.equals(imageSource.getUri());
    }

    public final boolean isReady() {
        return this.readySent;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z16;
        super.onDraw(canvas);
        createPaints();
        if (this.sWidth != 0 && this.sHeight != 0 && getWidth() != 0 && getHeight() != 0) {
            if (this.tileMap == null && this.decoder != null) {
                initialiseBaseLayer(getMaxBitmapDimensions(canvas));
            }
            if (!checkReady()) {
                return;
            }
            preDraw();
            Anim anim = this.anim;
            if (anim != null && anim.vFocusStart != null) {
                float f16 = this.scale;
                this.vTranslateBefore.set(this.vTranslate);
                long currentTimeMillis = System.currentTimeMillis() - this.anim.time;
                boolean z17 = true;
                if (currentTimeMillis > this.anim.duration) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                long min = Math.min(currentTimeMillis, this.anim.duration);
                this.scale = ease(this.anim.easing, min, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
                float ease = ease(this.anim.easing, min, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
                float ease2 = ease(this.anim.easing, min, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
                this.vTranslate.x -= sourceToViewX(this.anim.sCenterEnd.x) - ease;
                this.vTranslate.y -= sourceToViewY(this.anim.sCenterEnd.y) - ease2;
                if (!z16 && this.anim.scaleStart != this.anim.scaleEnd) {
                    z17 = false;
                }
                fitToBounds(z17);
                sendStateChanged(f16, this.vTranslateBefore, this.anim.origin);
                refreshRequiredTiles(z16);
                if (z16) {
                    Anim.access$2800(this.anim);
                    this.anim = null;
                }
                invalidate();
            }
            drawTileLayer(canvas);
            drawDebugMsg(canvas);
        }
    }

    protected void onImageLoaded() {
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        boolean z16;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        boolean z17 = true;
        if (mode != 1073741824) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (mode2 == 1073741824) {
            z17 = false;
        }
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z16 && z17) {
                size = sWidth();
                size2 = sHeight();
            } else if (z17) {
                size2 = (int) ((sHeight() / sWidth()) * size);
            } else if (z16) {
                size = (int) ((sWidth() / sHeight()) * size2);
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        debug("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i3), Integer.valueOf(i16));
        PointF center = getCenter();
        if (this.readySent && center != null) {
            this.anim = null;
            this.pendingScale = Float.valueOf(this.scale);
            this.sPendingCenter = center;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim = this.anim;
        if (anim != null && !anim.interruptible) {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
        Anim anim2 = this.anim;
        if (anim2 != null) {
            Anim.access$2800(anim2);
        }
        this.anim = null;
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            GestureDetector gestureDetector2 = this.singleDetector;
            if (gestureDetector2 != null) {
                gestureDetector2.onTouchEvent(motionEvent);
            }
            return true;
        }
        if (!this.isQuickScaling && ((gestureDetector = this.detector) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return true;
        }
        if (this.vTranslateStart == null) {
            this.vTranslateStart = new PointF(0.0f, 0.0f);
        }
        if (this.vCenterStart == null) {
            this.vCenterStart = new PointF(0.0f, 0.0f);
        }
        float f16 = this.scale;
        this.vTranslateBefore.set(pointF);
        boolean onTouchEventInternal = onTouchEventInternal(motionEvent);
        sendStateChanged(f16, this.vTranslateBefore, 2);
        if (onTouchEventInternal || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF(sWidth() / 2, sHeight() / 2);
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void setBitmapDecoder(@NonNull ImageDecoder imageDecoder) {
        if (imageDecoder != null) {
            this.bitmapDecoder = imageDecoder;
            return;
        }
        throw new IllegalArgumentException("Decoder cannot be set to null");
    }

    public final void setBitmapDecoderClass(@NonNull Class<? extends ImageDecoder> cls) {
        if (cls != null) {
            this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(@NonNull DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.bitmapDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean z16) {
        this.debug = z16;
    }

    public final void setDoubleTapZoomDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setDoubleTapZoomDuration(int i3) {
        this.doubleTapZoomDuration = Math.max(0, i3);
    }

    public final void setDoubleTapZoomScale(float f16) {
        this.doubleTapZoomScale = f16;
    }

    public final void setDoubleTapZoomStyle(int i3) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i3))) {
            this.doubleTapZoomStyle = i3;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i3);
    }

    public void setEagerLoadingEnabled(boolean z16) {
        this.eagerLoadingEnabled = z16;
    }

    public void setExecutor(@NonNull Executor executor) {
        if (executor != null) {
            this.executor = executor;
            return;
        }
        throw new NullPointerException("Executor must not be null");
    }

    public final void setImage(@NonNull ImageSource imageSource) {
        setImage(imageSource, null, null);
    }

    public void setIsAutoMagnified(boolean z16) {
        this.isAutoMagnified = z16;
    }

    public final void setMaxScale(float f16) {
        this.maxScale = f16;
    }

    public void setMaxTileSize(int i3) {
        this.maxTileWidth = i3;
        this.maxTileHeight = i3;
    }

    public final void setMaximumDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setMinScale(float f16) {
        this.minScale = f16;
    }

    public final void setMinimumDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i3);
    }

    public final void setMinimumScaleType(int i3) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(i3))) {
            this.minimumScaleType = i3;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i3);
    }

    public void setMinimumTileDpi(int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i3);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener) {
        this.onImageEventListener = onImageEventListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public final void setOrientationConfig(int i3) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i3))) {
            this.orientationConfig = i3;
            reset(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i3);
    }

    public final void setPanEnabled(boolean z16) {
        PointF pointF;
        this.panEnabled = z16;
        if (!z16 && (pointF = this.vTranslate) != null) {
            pointF.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
            this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
            if (isReady()) {
                refreshRequiredTiles(true);
                invalidate();
            }
        }
    }

    public final void setPanLimit(int i3) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(i3))) {
            this.panLimit = i3;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i3);
    }

    public final void setQuickScaleEnabled(boolean z16) {
        this.quickScaleEnabled = z16;
    }

    public final void setRegionDecoderClass(@NonNull Class<? extends ImageRegionDecoder> cls) {
        if (cls != null) {
            this.regionDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(@NonNull DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.regionDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setScaleAndCenter(float f16, @Nullable PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f16);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i3) {
        if (Color.alpha(i3) == 0) {
            this.tileBgPaint = null;
        } else {
            Paint paint = new Paint();
            this.tileBgPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i3);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z16) {
        this.zoomEnabled = z16;
    }

    @Nullable
    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public boolean tryMagnifyLongPic(final boolean z16) {
        float height = getHeight();
        float width = getWidth();
        if (height > 0.0f && width > 0.0f) {
            return magnifyLongPicIfNeeded(z16);
        }
        RFWLog.e(TAG, RFWLog.USR, "displayHeight is less than 0f");
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SubsamplingScaleImageView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                SubsamplingScaleImageView.this.magnifyLongPicIfNeeded(z16);
            }
        });
        return false;
    }

    @Nullable
    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap, int i3, boolean z16) {
        OnImageEventListener onImageEventListener;
        debug("onImageLoaded", new Object[0]);
        int i16 = this.sWidth;
        if (i16 > 0 && this.sHeight > 0 && (i16 != bitmap.getWidth() || this.sHeight != bitmap.getHeight())) {
            reset(false);
        }
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null && !this.bitmapIsCached) {
            bitmap2.recycle();
        }
        if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
            onImageEventListener.onPreviewReleased();
        }
        this.bitmapIsPreview = false;
        this.bitmapIsCached = z16;
        this.bitmap = bitmap;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.sOrientation = i3;
        boolean checkReady = checkReady();
        boolean checkImageLoaded = checkImageLoaded();
        if (checkReady || checkImageLoaded) {
            invalidate();
            requestLayout();
        }
    }

    public final void setImage(@NonNull ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, null, imageViewState);
    }

    @Nullable
    public final PointF sourceToViewCoord(float f16, float f17, @NonNull PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f16), sourceToViewY(f17));
        return pointF;
    }

    @Nullable
    public final PointF viewToSourceCoord(float f16, float f17) {
        return viewToSourceCoord(f16, f17, new PointF());
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public AnimationBuilder withOrigin(int i3) {
            this.origin = i3;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public AnimationBuilder withPanLimited(boolean z16) {
            this.panLimited = z16;
            return this;
        }

        public void start() {
            PointF pointF;
            if (SubsamplingScaleImageView.this.anim != null) {
                Anim.access$2800(SubsamplingScaleImageView.this.anim);
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float limitedScale = SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            if (this.panLimited) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF2 = this.targetSCenter;
                pointF = subsamplingScaleImageView.limitedSCenter(pointF2.x, pointF2.y, limitedScale, new PointF());
            } else {
                pointF = this.targetSCenter;
            }
            SubsamplingScaleImageView.this.anim = new Anim();
            SubsamplingScaleImageView.this.anim.scaleStart = SubsamplingScaleImageView.this.scale;
            SubsamplingScaleImageView.this.anim.scaleEnd = limitedScale;
            SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.anim.sCenterEndRequested = pointF;
            SubsamplingScaleImageView.this.anim.sCenterStart = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.anim.sCenterEnd = pointF;
            SubsamplingScaleImageView.this.anim.vFocusStart = SubsamplingScaleImageView.this.sourceToViewCoord(pointF);
            SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(paddingLeft, paddingTop);
            SubsamplingScaleImageView.this.anim.duration = this.duration;
            SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            SubsamplingScaleImageView.this.anim.easing = this.easing;
            SubsamplingScaleImageView.this.anim.origin = this.origin;
            SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            Anim.access$2802(SubsamplingScaleImageView.this.anim, null);
            PointF pointF3 = this.vFocus;
            if (pointF3 != null) {
                float f16 = pointF3.x - (SubsamplingScaleImageView.this.anim.sCenterStart.x * limitedScale);
                float f17 = this.vFocus.y - (SubsamplingScaleImageView.this.anim.sCenterStart.y * limitedScale);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(limitedScale, new PointF(f16, f17));
                SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f16), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f17));
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        @NonNull
        public AnimationBuilder withDuration(long j3) {
            this.duration = j3;
            return this;
        }

        @NonNull
        public AnimationBuilder withEasing(int i3) {
            if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i3))) {
                this.easing = i3;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i3);
        }

        @NonNull
        public AnimationBuilder withInterruptible(boolean z16) {
            this.interruptible = z16;
            return this;
        }

        AnimationBuilder(PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        AnimationBuilder(float f16, PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f16;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        AnimationBuilder(float f16, PointF pointF, PointF pointF2) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f16;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }
    }

    public final void setImage(@NonNull ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, null);
    }

    public void setMaxTileSize(int i3, int i16) {
        this.maxTileWidth = i3;
        this.maxTileHeight = i16;
    }

    @Nullable
    public final PointF viewToSourceCoord(float f16, float f17, @NonNull PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f16), viewToSourceY(f17));
        return pointF;
    }

    public final void setImage(@NonNull ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        if (imageSource != null) {
            reset(true);
            if (imageViewState != null) {
                restoreState(imageViewState);
            }
            if (imageSource2 != null) {
                if (imageSource.getBitmap() == null) {
                    if (imageSource.getSWidth() > 0 && imageSource.getSHeight() > 0) {
                        this.sWidth = imageSource.getSWidth();
                        this.sHeight = imageSource.getSHeight();
                        this.pRegion = imageSource2.getSRegion();
                        if (imageSource2.getBitmap() != null) {
                            this.bitmapIsCached = imageSource2.isCached();
                            onPreviewLoaded(imageSource2.getBitmap());
                        } else {
                            Uri uri = imageSource2.getUri();
                            if (uri == null && imageSource2.getResource() != null) {
                                uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                            }
                            new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri, true).run();
                        }
                    } else {
                        throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                    }
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                }
            }
            if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
                onImageLoaded(Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0, false);
                return;
            }
            if (imageSource.getBitmap() != null) {
                onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
                return;
            }
            this.sRegion = imageSource.getSRegion();
            Uri uri2 = imageSource.getUri();
            this.uri = uri2;
            if (uri2 == null && imageSource.getResource() != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
            }
            if (!imageSource.getTile() && this.sRegion == null) {
                new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false).run();
                return;
            } else {
                execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
                return;
            }
        }
        throw new NullPointerException("imageSource must not be null");
    }

    protected void onReady() {
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
    }

    private void fitToBounds(boolean z16) {
        boolean z17;
        float f16 = 0.0f;
        if (this.vTranslate == null) {
            this.vTranslate = new PointF(0.0f, 0.0f);
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(f16, new PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z16, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (!z17 || this.minimumScaleType == 4) {
            return;
        }
        this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }

    private void sendStateChanged(float f16, PointF pointF, int i3) {
    }
}
