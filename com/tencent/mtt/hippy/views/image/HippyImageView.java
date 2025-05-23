package com.tencent.mtt.hippy.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.UrlUtils;
import com.tencent.mtt.hippy.views.common.CommonBackgroundDrawable;
import com.tencent.mtt.hippy.views.common.CommonBorder;
import com.tencent.mtt.hippy.views.list.HippyRecycler;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import com.tencent.mtt.supportui.utils.CommonTool;
import com.tencent.mtt.supportui.views.asyncimage.AsyncImageView;
import com.tencent.mtt.supportui.views.asyncimage.BackgroundDrawable;
import com.tencent.mtt.supportui.views.asyncimage.ContentDrawable;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyImageView extends AsyncImageView implements HippyViewBase, CommonBorder, HippyRecycler {
    public static final String IMAGE_PROPS = "props";
    public static final String IMAGE_TYPE_APNG = "apng";
    public static final String IMAGE_TYPE_GIF = "gif";
    public static final String IMAGE_VIEW_OBJ = "viewobj";
    private final HippyEngineContext hippyEngineContext;
    private HippyMap initProps;
    private boolean isGifPaused;
    protected NativeGestureDispatcher mGestureDispatcher;
    private long mGifLastPlayTime;
    private boolean mGifMatrixComputed;
    private Movie mGifMovie;
    private Path mGifPath;
    private long mGifProgress;
    private float mGifScaleX;
    private float mGifScaleY;
    private int mGifStartX;
    private int mGifStartY;
    private Rect mNinePatchRect;
    private OnErrorEvent mOnErrorEvent;
    private OnLoadEndEvent mOnLoadEndEvent;
    private OnLoadEvent mOnLoadEvent;
    private OnLoadStartEvent mOnLoadStartEvent;
    private final boolean[] mShouldSendImageEvent;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.views.image.HippyImageView$2, reason: invalid class name */
    /* loaded from: classes20.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType;

        static {
            int[] iArr = new int[AsyncImageView.ScaleType.values().length];
            $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType = iArr;
            try {
                iArr[AsyncImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[AsyncImageView.ScaleType.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[AsyncImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[AsyncImageView.ScaleType.CENTER_CROP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[AsyncImageView.ScaleType.ORIGIN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum ImageEvent {
        ONLOAD,
        ONLOAD_START,
        ONLOAD_END,
        ONERROR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class OnErrorEvent extends HippyViewEvent {
        OnErrorEvent() {
            super("onError");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class OnLoadEndEvent extends HippyViewEvent {
        OnLoadEndEvent() {
            super(HippyQQPagView.EventName.ON_LOAD_END);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class OnLoadEvent extends HippyViewEvent {
        OnLoadEvent() {
            super("onLoad");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class OnLoadStartEvent extends HippyViewEvent {
        OnLoadStartEvent() {
            super(HippyQQPagView.EventName.ON_LOAD_START);
        }
    }

    public HippyImageView(Context context) {
        super(context);
        this.initProps = new HippyMap();
        this.mGifStartX = 0;
        this.mGifStartY = 0;
        this.mGifScaleX = 1.0f;
        this.mGifScaleY = 1.0f;
        this.mGifMatrixComputed = false;
        this.mGifProgress = 0L;
        this.mGifLastPlayTime = -1L;
        this.isGifPaused = false;
        this.mShouldSendImageEvent = new boolean[ImageEvent.values().length];
        HippyEngineContext engineContext = ((HippyInstanceContext) context).getEngineContext();
        this.hippyEngineContext = engineContext;
        if (engineContext != null) {
            setImageAdapter(engineContext.getGlobalConfigs().getImageLoaderAdapter());
        }
    }

    private static float calculateBorderRadius(float f16, float f17, float f18) {
        if (f16 == 0.0f) {
            f16 = f17;
        }
        return Math.max(0.0f, f16 - (f18 * 0.5f));
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0070, code lost:
    
        if (r1 < r2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007b, code lost:
    
        r13.mGifScaleX = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0079, code lost:
    
        if (r1 > r2) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void computeMatrixParams() {
        Path path;
        BackgroundDrawable backgroundDrawable;
        float f16;
        float f17;
        if (!this.mGifMatrixComputed) {
            this.mGifStartX = 0;
            this.mGifStartY = 0;
            float f18 = 1.0f;
            this.mGifScaleX = 1.0f;
            this.mGifScaleY = 1.0f;
            if (this.mGifMovie.width() > 0 && this.mGifMovie.height() > 0 && getWidth() > 0 && getHeight() > 0) {
                this.mGifScaleX = getWidth() / this.mGifMovie.width();
                this.mGifScaleY = getHeight() / this.mGifMovie.height();
            }
            AsyncImageView.ScaleType scaleType = this.mScaleType;
            if (scaleType == null) {
                scaleType = AsyncImageView.ScaleType.FIT_XY;
            }
            int i3 = AnonymousClass2.$SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[scaleType.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            this.mGifScaleY = 1.0f;
                            this.mGifScaleX = 1.0f;
                        }
                    } else {
                        f18 = this.mGifScaleX;
                        f17 = this.mGifScaleY;
                    }
                } else {
                    f18 = this.mGifScaleX;
                    f17 = this.mGifScaleY;
                }
                if (this.mScaleType != AsyncImageView.ScaleType.ORIGIN) {
                    this.mGifStartX = (int) (((getWidth() / this.mGifScaleX) - this.mGifMovie.width()) / 2.0f);
                    this.mGifStartY = (int) (((getHeight() / this.mGifScaleY) - this.mGifMovie.height()) / 2.0f);
                }
                path = this.mGifPath;
                if (path != null) {
                    this.mGifPath = new Path();
                } else {
                    path.rewind();
                }
                backgroundDrawable = this.mBGDrawable;
                if (backgroundDrawable != null) {
                    float[] borderWidthArray = backgroundDrawable.getBorderWidthArray();
                    if (borderWidthArray == null) {
                        f16 = 0.0f;
                    } else {
                        f16 = borderWidthArray[0];
                    }
                    RectF rectF = new RectF(f16, f16, getWidth() - f16, getHeight() - f16);
                    float[] borderRadiusArray = this.mBGDrawable.getBorderRadiusArray();
                    if (CommonTool.hasPositiveItem(borderRadiusArray)) {
                        float f19 = borderRadiusArray[0];
                        float calculateBorderRadius = calculateBorderRadius(borderRadiusArray[1], f19, f16);
                        float calculateBorderRadius2 = calculateBorderRadius(borderRadiusArray[2], f19, f16);
                        float calculateBorderRadius3 = calculateBorderRadius(borderRadiusArray[3], f19, f16);
                        float calculateBorderRadius4 = calculateBorderRadius(borderRadiusArray[4], f19, f16);
                        this.mGifPath.addRoundRect(rectF, new float[]{calculateBorderRadius, calculateBorderRadius, calculateBorderRadius2, calculateBorderRadius2, calculateBorderRadius3, calculateBorderRadius3, calculateBorderRadius4, calculateBorderRadius4}, Path.Direction.CW);
                    } else {
                        this.mGifPath.addRect(rectF, Path.Direction.CW);
                    }
                }
                this.mGifMatrixComputed = true;
            }
            this.mGifScaleX = 1.0f;
            this.mGifScaleY = f18;
            if (this.mScaleType != AsyncImageView.ScaleType.ORIGIN) {
            }
            path = this.mGifPath;
            if (path != null) {
            }
            backgroundDrawable = this.mBGDrawable;
            if (backgroundDrawable != null) {
            }
            this.mGifMatrixComputed = true;
        }
    }

    private OnErrorEvent getOnErrorEvent() {
        if (this.mOnErrorEvent == null) {
            this.mOnErrorEvent = new OnErrorEvent();
        }
        return this.mOnErrorEvent;
    }

    private OnLoadEndEvent getOnLoadEndEvent() {
        if (this.mOnLoadEndEvent == null) {
            this.mOnLoadEndEvent = new OnLoadEndEvent();
        }
        return this.mOnLoadEndEvent;
    }

    private OnLoadEvent getOnLoadEvent() {
        if (this.mOnLoadEvent == null) {
            this.mOnLoadEvent = new OnLoadEvent();
        }
        return this.mOnLoadEvent;
    }

    private OnLoadStartEvent getOnLoadStartEvent() {
        if (this.mOnLoadStartEvent == null) {
            this.mOnLoadStartEvent = new OnLoadStartEvent();
        }
        return this.mOnLoadStartEvent;
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyRecycler
    public void clear() {
        this.mTintColor = 0;
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    protected void doFetchImage(Object obj, final int i3) {
        final String str;
        RenderNode renderNode;
        if (this.mImageAdapter != null) {
            if (obj == null) {
                obj = new HashMap();
            }
            if (obj instanceof Map) {
                HippyEngineContext hippyEngineContext = this.hippyEngineContext;
                if (hippyEngineContext != null && (renderNode = hippyEngineContext.getRenderManager().getRenderNode(getId())) != null) {
                    this.initProps = renderNode.getProps();
                }
                try {
                    ((Map) obj).put("props", this.initProps);
                    ((Map) obj).put(IMAGE_VIEW_OBJ, this);
                } catch (Exception e16) {
                    LogUtils.d("HippyImageView", "doFetchImage: " + e16);
                }
            }
            if (i3 == 1) {
                str = this.mUrl;
            } else {
                str = this.mDefaultSourceUrl;
            }
            this.mImageAdapter.fetchImage(str, new HippyImageLoader.Callback() { // from class: com.tencent.mtt.hippy.views.image.HippyImageView.1
                @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
                public void onRequestFail(Throwable th5, String str2) {
                    if (i3 == 1) {
                        if (TextUtils.equals(str, ((AsyncImageView) HippyImageView.this).mUrl)) {
                            ((AsyncImageView) HippyImageView.this).mUrlFetchState = 0;
                        } else {
                            return;
                        }
                    }
                    if (i3 == 2 && !TextUtils.equals(str, ((AsyncImageView) HippyImageView.this).mDefaultSourceUrl)) {
                        return;
                    }
                    HippyImageView.this.handleImageRequest(null, i3, th5);
                }

                @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
                public void onRequestStart(HippyDrawable hippyDrawable) {
                    ((AsyncImageView) HippyImageView.this).mSourceDrawable = hippyDrawable;
                }

                @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
                public void onRequestSuccess(HippyDrawable hippyDrawable) {
                    if (i3 == 1) {
                        if (!TextUtils.equals(str, ((AsyncImageView) HippyImageView.this).mUrl)) {
                            return;
                        } else {
                            ((AsyncImageView) HippyImageView.this).mUrlFetchState = 2;
                        }
                    }
                    if (i3 != 2 || TextUtils.equals(str, ((AsyncImageView) HippyImageView.this).mDefaultSourceUrl)) {
                        HippyImageView.this.handleImageRequest(hippyDrawable, i3, null);
                    }
                }
            }, obj);
        }
    }

    protected boolean drawGIF(Canvas canvas) {
        Movie movie = this.mGifMovie;
        int i3 = 0;
        if (movie == null) {
            return false;
        }
        int duration = movie.duration();
        if (duration == 0) {
            duration = 1000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.isGifPaused) {
            long j3 = this.mGifLastPlayTime;
            if (j3 != -1) {
                long j16 = this.mGifProgress + (currentTimeMillis - j3);
                this.mGifProgress = j16;
                if (j16 > duration) {
                    this.mGifProgress = 0L;
                }
            }
            this.mGifLastPlayTime = currentTimeMillis;
        }
        computeMatrixParams();
        long j17 = this.mGifProgress;
        if (j17 <= TTL.MAX_VALUE) {
            i3 = (int) j17;
        }
        this.mGifMovie.setTime(i3);
        canvas.save();
        if (!this.mGifPath.isEmpty()) {
            canvas.clipPath(this.mGifPath);
        }
        canvas.scale(this.mGifScaleX, this.mGifScaleY);
        this.mGifMovie.draw(canvas, this.mGifStartX, this.mGifStartY);
        canvas.restore();
        if (!this.isGifPaused) {
            postInvalidateDelayed(40L);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    protected BackgroundDrawable generateBackgroundDrawable() {
        return new CommonBackgroundDrawable();
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    protected ContentDrawable generateContentDrawable() {
        return new HippyContentDrawable();
    }

    public NativeGestureDispatcher getGestureDispatcher() {
        return this.mGestureDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public void handleGetImageFail(Throwable th5) {
        if (this.mShouldSendImageEvent[ImageEvent.ONERROR.ordinal()]) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("error", String.valueOf(th5));
            hippyMap.pushInt("errorCode", -1);
            String str = this.mUrl;
            if (str == null) {
                str = "";
            }
            hippyMap.pushString("errorURL", str);
            getOnErrorEvent().send(this, hippyMap);
        }
        if (this.mShouldSendImageEvent[ImageEvent.ONLOAD_END.ordinal()]) {
            HippyMap hippyMap2 = new HippyMap();
            hippyMap2.pushInt("success", 0);
            getOnLoadEndEvent().send(this, hippyMap2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public void handleGetImageStart() {
        if (this.mShouldSendImageEvent[ImageEvent.ONLOAD_START.ordinal()]) {
            getOnLoadStartEvent().send(this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public void handleGetImageSuccess() {
        Bitmap bitmap;
        if (this.mShouldSendImageEvent[ImageEvent.ONLOAD.ordinal()]) {
            getOnLoadEvent().send(this, null);
        }
        if (this.mShouldSendImageEvent[ImageEvent.ONLOAD_END.ordinal()]) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("success", 1);
            IDrawableTarget iDrawableTarget = this.mSourceDrawable;
            if (iDrawableTarget != null && (bitmap = iDrawableTarget.getBitmap()) != null) {
                HippyMap hippyMap2 = new HippyMap();
                hippyMap2.pushInt("width", bitmap.getWidth());
                hippyMap2.pushInt("height", bitmap.getHeight());
                hippyMap.pushMap("image", hippyMap2);
            }
            getOnLoadEndEvent().send(this, hippyMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public void handleImageRequest(IDrawableTarget iDrawableTarget, int i3, Object obj) {
        Drawable drawable;
        if (iDrawableTarget != null && !TextUtils.isEmpty(iDrawableTarget.getImageType())) {
            this.mImageType = iDrawableTarget.getImageType();
        }
        Throwable th5 = null;
        if (iDrawableTarget instanceof HippyDrawable) {
            HippyDrawable hippyDrawable = (HippyDrawable) iDrawableTarget;
            if (hippyDrawable.isAnimated()) {
                this.mGifMovie = hippyDrawable.getGIF();
                this.mGifMatrixComputed = false;
                setLayerType(1, null);
            }
        }
        if (!TextUtils.isEmpty(this.mImageType) && this.mImageType.equals("apng") && i3 == 1) {
            if (iDrawableTarget != null && (drawable = iDrawableTarget.getDrawable()) != null) {
                this.mSourceDrawable = null;
                this.mContentDrawable = drawable;
                this.mUrlFetchState = 2;
                setContent(i3);
                handleGetImageSuccess();
                return;
            }
            this.mUrlFetchState = 0;
            if (obj instanceof Throwable) {
                th5 = (Throwable) obj;
            }
            handleGetImageFail(th5);
            return;
        }
        super.handleImageRequest(iDrawableTarget, i3, obj);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mGifMovie != null) {
            try {
                drawGIF(canvas);
            } catch (Throwable th5) {
                LogUtils.e("HippyImageView", "onDraw error: ", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.mGifMatrixComputed = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        NativeGestureDispatcher nativeGestureDispatcher = this.mGestureDispatcher;
        if (nativeGestureDispatcher != null) {
            return onTouchEvent | nativeGestureDispatcher.handleTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void pause() {
        this.isGifPaused = true;
        this.mGifLastPlayTime = -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public void resetContent() {
        this.mGifMovie = null;
        this.mGifMatrixComputed = false;
        this.mGifProgress = 0L;
        this.mGifLastPlayTime = -1L;
        super.resetContent();
    }

    public void resetProps() {
        HippyViewController.resetTransform(this);
        setAlpha(1.0f);
        this.mTintColor = 0;
        this.mBGDrawable = null;
        this.mContentDrawable = null;
        this.mScaleType = AsyncImageView.ScaleType.FIT_XY;
        setImagePositionX(0);
        setImagePositionY(0);
        this.mUrl = null;
        this.mImageType = null;
        setBackgroundDrawable(null);
        Arrays.fill(this.mShouldSendImageEvent, false);
        this.mGifMatrixComputed = false;
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView, com.tencent.mtt.supportui.views.IBorder
    public void setBorderColor(int i3, int i16) {
        super.setBorderColor(i3, i16);
        this.mGifMatrixComputed = false;
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView, com.tencent.mtt.supportui.views.IBorder
    public void setBorderRadius(float f16, int i3) {
        super.setBorderRadius(f16, i3);
        this.mGifMatrixComputed = false;
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView, com.tencent.mtt.supportui.views.IBorder
    public void setBorderStyle(int i3) {
        super.setBorderStyle(i3);
        this.mGifMatrixComputed = false;
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView, com.tencent.mtt.supportui.views.IBorder
    public void setBorderWidth(float f16, int i3) {
        super.setBorderWidth(f16, i3);
        this.mGifMatrixComputed = false;
    }

    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        this.mGestureDispatcher = nativeGestureDispatcher;
    }

    public void setHippyViewDefaultSource(String str) {
        setDefaultSource(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setImageEventEnable(int i3, boolean z16) {
        this.mShouldSendImageEvent[i3] = z16;
    }

    public void setInitProps(HippyMap hippyMap) {
        this.initProps = hippyMap;
    }

    public void setNinePatchCoordinate(boolean z16, int i3, int i16, int i17, int i18) {
        if (z16) {
            this.mNinePatchRect = null;
        } else {
            if (this.mNinePatchRect == null) {
                this.mNinePatchRect = new Rect();
            }
            this.mNinePatchRect.set(i3, i16, i17, i18);
        }
        Drawable drawable = this.mContentDrawable;
        if (drawable instanceof HippyContentDrawable) {
            ((HippyContentDrawable) drawable).setNinePatchCoordinate(this.mNinePatchRect);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public boolean shouldFetchImage() {
        boolean z16;
        Drawable drawable;
        int i3 = this.mUrlFetchState;
        if (i3 == 1) {
            return false;
        }
        if (i3 == 0) {
            return true;
        }
        HippyMap hippyMap = this.initProps;
        if (hippyMap != null && hippyMap.getBoolean(NodeProps.CUSTOM_PROP_ISGIF)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (!TextUtils.isEmpty(this.mImageType) && this.mImageType.equals("gif")) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (!TextUtils.isEmpty(this.mImageType) && this.mImageType.equals("apng") && (drawable = this.mContentDrawable) != null && !(drawable instanceof ContentDrawable)) {
            return false;
        }
        if (z16) {
            if (this.mGifMovie != null) {
                return false;
            }
            return true;
        }
        Bitmap bitmap = getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    protected boolean shouldUseFetchImageMode(String str) {
        if (!UrlUtils.isWebUrl(str) && !UrlUtils.isFileUrl(str)) {
            return false;
        }
        return true;
    }

    public void startPlay() {
        this.isGifPaused = false;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public void updateContentDrawableProperty(int i3) {
        super.updateContentDrawableProperty(i3);
        Drawable drawable = this.mContentDrawable;
        if ((drawable instanceof HippyContentDrawable) && i3 == 1) {
            ((HippyContentDrawable) drawable).setNinePatchCoordinate(this.mNinePatchRect);
        }
        this.mGifMatrixComputed = false;
    }
}
