package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.mapsdk.internal.by;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private int alpha;
    private final LottieValueAnimator animator;
    private Rect canvasClipBounds;
    private RectF canvasClipBoundsRectF;
    private boolean clipToCompositionBounds;
    private LottieComposition composition;

    @Nullable
    private CompositionLayer compositionLayer;
    private boolean enableMergePaths;

    @Nullable
    FontAssetDelegate fontAssetDelegate;

    @Nullable
    private FontAssetManager fontAssetManager;
    private boolean ignoreSystemAnimationsDisabled;

    @Nullable
    private ImageAssetDelegate imageAssetDelegate;

    @Nullable
    private ImageAssetManager imageAssetManager;

    @Nullable
    private String imageAssetsFolder;
    private boolean isApplyingOpacityToLayersEnabled;
    private boolean isDirty;
    private final ArrayList<LazyCompositionTask> lazyCompositionTasks;
    private boolean maintainOriginalImageBounds;
    private OnVisibleAction onVisibleAction;
    private boolean outlineMasksAndMattes;
    private boolean performanceTrackingEnabled;
    private final ValueAnimator.AnimatorUpdateListener progressUpdateListener;
    private RenderMode renderMode;
    private final Matrix renderingMatrix;
    private boolean safeMode;
    private Bitmap softwareRenderingBitmap;
    private Canvas softwareRenderingCanvas;
    private Rect softwareRenderingDstBoundsRect;
    private RectF softwareRenderingDstBoundsRectF;
    private Matrix softwareRenderingOriginalCanvasMatrix;
    private Matrix softwareRenderingOriginalCanvasMatrixInverse;
    private Paint softwareRenderingPaint;
    private Rect softwareRenderingSrcBoundsRect;
    private RectF softwareRenderingTransformedBounds;
    private boolean systemAnimationsEnabled;

    @Nullable
    TextDelegate textDelegate;
    private boolean useSoftwareRendering;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface LazyCompositionTask {
        void run(LottieComposition lottieComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RepeatMode {
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.animator = lottieValueAnimator;
        this.systemAnimationsEnabled = true;
        this.ignoreSystemAnimationsDisabled = false;
        this.safeMode = false;
        this.onVisibleAction = OnVisibleAction.NONE;
        this.lazyCompositionTasks = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.LottieDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.compositionLayer != null) {
                    LottieDrawable.this.compositionLayer.setProgress(LottieDrawable.this.animator.getAnimatedValueAbsolute());
                }
            }
        };
        this.progressUpdateListener = animatorUpdateListener;
        this.maintainOriginalImageBounds = false;
        this.clipToCompositionBounds = true;
        this.alpha = 255;
        this.renderMode = RenderMode.AUTOMATIC;
        this.useSoftwareRendering = false;
        this.renderingMatrix = new Matrix();
        this.isDirty = false;
        lottieValueAnimator.addUpdateListener(animatorUpdateListener);
    }

    private boolean animationsEnabled() {
        if (!this.systemAnimationsEnabled && !this.ignoreSystemAnimationsDisabled) {
            return false;
        }
        return true;
    }

    private void buildCompositionLayer() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return;
        }
        CompositionLayer compositionLayer = new CompositionLayer(this, LayerParser.parse(lottieComposition), lottieComposition.getLayers(), lottieComposition);
        this.compositionLayer = compositionLayer;
        if (this.outlineMasksAndMattes) {
            compositionLayer.setOutlineMasksAndMattes(true);
        }
        this.compositionLayer.setClipToCompositionBounds(this.clipToCompositionBounds);
    }

    private void computeRenderMode() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return;
        }
        this.useSoftwareRendering = this.renderMode.useSoftwareRendering(Build.VERSION.SDK_INT, lottieComposition.hasDashPattern(), lottieComposition.getMaskAndMatteCount());
    }

    private void convertRect(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void drawDirectlyToCanvas(Canvas canvas) {
        CompositionLayer compositionLayer = this.compositionLayer;
        LottieComposition lottieComposition = this.composition;
        if (compositionLayer != null && lottieComposition != null) {
            this.renderingMatrix.reset();
            if (!getBounds().isEmpty()) {
                this.renderingMatrix.preScale(r2.width() / lottieComposition.getBounds().width(), r2.height() / lottieComposition.getBounds().height());
            }
            compositionLayer.draw(canvas, this.renderingMatrix, this.alpha);
        }
    }

    private void ensureSoftwareRenderingBitmap(int i3, int i16) {
        try {
            Bitmap bitmap = this.softwareRenderingBitmap;
            if (bitmap != null && bitmap.getWidth() >= i3 && this.softwareRenderingBitmap.getHeight() >= i16) {
                if (this.softwareRenderingBitmap.getWidth() > i3 || this.softwareRenderingBitmap.getHeight() > i16) {
                    Bitmap createBitmap = Bitmap.createBitmap(this.softwareRenderingBitmap, 0, 0, i3, i16);
                    this.softwareRenderingBitmap = createBitmap;
                    this.softwareRenderingCanvas.setBitmap(createBitmap);
                    this.isDirty = true;
                }
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            this.softwareRenderingBitmap = createBitmap2;
            this.softwareRenderingCanvas.setBitmap(createBitmap2);
            this.isDirty = true;
        } catch (OutOfMemoryError e16) {
            Log.e(ComponentFactory.ComponentType.Lottie, "ensureSoftwareRenderingBitmap OutOfMemoryError" + e16.getMessage());
        }
    }

    private void ensureSoftwareRenderingObjectsInitialized() {
        if (this.softwareRenderingCanvas != null) {
            return;
        }
        this.softwareRenderingCanvas = new Canvas();
        this.softwareRenderingTransformedBounds = new RectF();
        this.softwareRenderingOriginalCanvasMatrix = new Matrix();
        this.softwareRenderingOriginalCanvasMatrixInverse = new Matrix();
        this.canvasClipBounds = new Rect();
        this.canvasClipBoundsRectF = new RectF();
        this.softwareRenderingPaint = new LPaint();
        this.softwareRenderingSrcBoundsRect = new Rect();
        this.softwareRenderingDstBoundsRect = new Rect();
        this.softwareRenderingDstBoundsRectF = new RectF();
    }

    @Nullable
    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback == null || !(callback instanceof View)) {
            return null;
        }
        return ((View) callback).getContext();
    }

    private FontAssetManager getFontAssetManager() {
        if (getCallback() == null) {
            return null;
        }
        if (this.fontAssetManager == null) {
            this.fontAssetManager = new FontAssetManager(getCallback(), this.fontAssetDelegate);
        }
        return this.fontAssetManager;
    }

    private ImageAssetManager getImageAssetManager() {
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager imageAssetManager = this.imageAssetManager;
        if (imageAssetManager != null && !imageAssetManager.hasSameContext(getContext())) {
            this.imageAssetManager = null;
        }
        if (this.imageAssetManager == null) {
            this.imageAssetManager = new ImageAssetManager(getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.getImages());
        }
        return this.imageAssetManager;
    }

    private boolean ignoreCanvasClipBounds() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        if (!(((View) callback).getParent() instanceof ViewGroup)) {
            return false;
        }
        return !((ViewGroup) r0).getClipChildren();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addValueCallback$14(KeyPath keyPath, Object obj, LottieValueCallback lottieValueCallback, LottieComposition lottieComposition) {
        addValueCallback(keyPath, (KeyPath) obj, (LottieValueCallback<KeyPath>) lottieValueCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playAnimation$0(LottieComposition lottieComposition) {
        playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resumeAnimation$1(LottieComposition lottieComposition) {
        resumeAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFrame$12(int i3, LottieComposition lottieComposition) {
        setFrame(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMaxFrame$4(int i3, LottieComposition lottieComposition) {
        setMaxFrame(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMaxFrame$7(String str, LottieComposition lottieComposition) {
        setMaxFrame(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMaxProgress$5(float f16, LottieComposition lottieComposition) {
        setMaxProgress(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinAndMaxFrame$10(int i3, int i16, LottieComposition lottieComposition) {
        setMinAndMaxFrame(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinAndMaxFrame$8(String str, LottieComposition lottieComposition) {
        setMinAndMaxFrame(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinAndMaxFrame$9(String str, String str2, boolean z16, LottieComposition lottieComposition) {
        setMinAndMaxFrame(str, str2, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinAndMaxProgress$11(float f16, float f17, LottieComposition lottieComposition) {
        setMinAndMaxProgress(f16, f17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinFrame$2(int i3, LottieComposition lottieComposition) {
        setMinFrame(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinFrame$6(String str, LottieComposition lottieComposition) {
        setMinFrame(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinProgress$3(float f16, LottieComposition lottieComposition) {
        setMinProgress(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setProgress$13(float f16, LottieComposition lottieComposition) {
        setProgress(f16);
    }

    private void renderAndDrawAsBitmap(Canvas canvas, CompositionLayer compositionLayer) {
        if (this.composition != null && compositionLayer != null) {
            ensureSoftwareRenderingObjectsInitialized();
            canvas.getMatrix(this.softwareRenderingOriginalCanvasMatrix);
            canvas.getClipBounds(this.canvasClipBounds);
            convertRect(this.canvasClipBounds, this.canvasClipBoundsRectF);
            this.softwareRenderingOriginalCanvasMatrix.mapRect(this.canvasClipBoundsRectF);
            convertRect(this.canvasClipBoundsRectF, this.canvasClipBounds);
            if (this.clipToCompositionBounds) {
                this.softwareRenderingTransformedBounds.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
            } else {
                compositionLayer.getBounds(this.softwareRenderingTransformedBounds, null, false);
            }
            this.softwareRenderingOriginalCanvasMatrix.mapRect(this.softwareRenderingTransformedBounds);
            Rect bounds = getBounds();
            float width = bounds.width() / getIntrinsicWidth();
            float height = bounds.height() / getIntrinsicHeight();
            scaleRect(this.softwareRenderingTransformedBounds, width, height);
            if (!ignoreCanvasClipBounds()) {
                RectF rectF = this.softwareRenderingTransformedBounds;
                Rect rect = this.canvasClipBounds;
                rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
            }
            int ceil = (int) Math.ceil(this.softwareRenderingTransformedBounds.width());
            int ceil2 = (int) Math.ceil(this.softwareRenderingTransformedBounds.height());
            if (ceil != 0 && ceil2 != 0) {
                ensureSoftwareRenderingBitmap(ceil, ceil2);
                if (this.isDirty) {
                    this.renderingMatrix.set(this.softwareRenderingOriginalCanvasMatrix);
                    this.renderingMatrix.preScale(width, height);
                    Matrix matrix = this.renderingMatrix;
                    RectF rectF2 = this.softwareRenderingTransformedBounds;
                    matrix.postTranslate(-rectF2.left, -rectF2.top);
                    Bitmap bitmap = this.softwareRenderingBitmap;
                    if (bitmap != null) {
                        bitmap.eraseColor(0);
                    }
                    compositionLayer.draw(this.softwareRenderingCanvas, this.renderingMatrix, this.alpha);
                    this.softwareRenderingOriginalCanvasMatrix.invert(this.softwareRenderingOriginalCanvasMatrixInverse);
                    this.softwareRenderingOriginalCanvasMatrixInverse.mapRect(this.softwareRenderingDstBoundsRectF, this.softwareRenderingTransformedBounds);
                    convertRect(this.softwareRenderingDstBoundsRectF, this.softwareRenderingDstBoundsRect);
                }
                this.softwareRenderingSrcBoundsRect.set(0, 0, ceil, ceil2);
                Bitmap bitmap2 = this.softwareRenderingBitmap;
                if (bitmap2 != null) {
                    canvas.drawBitmap(bitmap2, this.softwareRenderingSrcBoundsRect, this.softwareRenderingDstBoundsRect, this.softwareRenderingPaint);
                }
            }
        }
    }

    private void scaleRect(RectF rectF, float f16, float f17) {
        rectF.set(rectF.left * f16, rectF.top * f17, rectF.right * f16, rectF.bottom * f17);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.addListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.animator.addPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.addUpdateListener(animatorUpdateListener);
    }

    public <T> void addValueCallback(final KeyPath keyPath, final T t16, @Nullable final LottieValueCallback<T> lottieValueCallback) {
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.ae
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$addValueCallback$14(keyPath, t16, lottieValueCallback, lottieComposition);
                }
            });
            return;
        }
        boolean z16 = true;
        if (keyPath == KeyPath.COMPOSITION) {
            compositionLayer.addValueCallback(t16, lottieValueCallback);
        } else if (keyPath.getResolvedElement() != null) {
            keyPath.getResolvedElement().addValueCallback(t16, lottieValueCallback);
        } else {
            List<KeyPath> resolveKeyPath = resolveKeyPath(keyPath);
            for (int i3 = 0; i3 < resolveKeyPath.size(); i3++) {
                resolveKeyPath.get(i3).getResolvedElement().addValueCallback(t16, lottieValueCallback);
            }
            z16 = true ^ resolveKeyPath.isEmpty();
        }
        if (z16) {
            invalidateSelf();
            if (t16 == LottieProperty.TIME_REMAP) {
                setProgress(getProgress());
            }
        }
    }

    public void cancelAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.cancel();
        if (!isVisible()) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
    }

    public void clearComposition() {
        if (this.animator.isRunning()) {
            this.animator.cancel();
            if (!isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.animator.clearComposition();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        L.beginSection("Drawable#draw");
        if (this.safeMode) {
            try {
                if (this.useSoftwareRendering) {
                    renderAndDrawAsBitmap(canvas, this.compositionLayer);
                } else {
                    drawDirectlyToCanvas(canvas);
                }
            } catch (Throwable th5) {
                Logger.error("Lottie crashed in draw!", th5);
            }
        } else if (this.useSoftwareRendering) {
            renderAndDrawAsBitmap(canvas, this.compositionLayer);
        } else {
            drawDirectlyToCanvas(canvas);
        }
        this.isDirty = false;
        L.endSection("Drawable#draw");
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    @MainThread
    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
        if (!isVisible()) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Nullable
    public Bitmap getBitmapForId(String str) {
        ImageAssetManager imageAssetManager = getImageAssetManager();
        if (imageAssetManager != null) {
            return imageAssetManager.bitmapForId(str);
        }
        return null;
    }

    public boolean getClipToCompositionBounds() {
        return this.clipToCompositionBounds;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public int getFrame() {
        return (int) this.animator.getFrame();
    }

    @Nullable
    @Deprecated
    public Bitmap getImageAsset(String str) {
        LottieImageAsset lottieImageAsset;
        ImageAssetManager imageAssetManager = getImageAssetManager();
        if (imageAssetManager != null) {
            return imageAssetManager.bitmapForId(str);
        }
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            lottieImageAsset = null;
        } else {
            lottieImageAsset = lottieComposition.getImages().get(str);
        }
        if (lottieImageAsset == null) {
            return null;
        }
        return lottieImageAsset.getBitmap();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.getBounds().width();
    }

    @Nullable
    public LottieImageAsset getLottieImageAssetForId(String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return null;
        }
        return lottieComposition.getImages().get(str);
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.maintainOriginalImageBounds;
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return lottieComposition.getPerformanceTracker();
        }
        return null;
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    public RenderMode getRenderMode() {
        if (this.useSoftwareRendering) {
            return RenderMode.SOFTWARE;
        }
        return RenderMode.HARDWARE;
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    @SuppressLint({"WrongConstant"})
    public int getRepeatMode() {
        return this.animator.getRepeatMode();
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    @Nullable
    public TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    @Nullable
    public Typeface getTypeface(String str, String str2) {
        FontAssetManager fontAssetManager = getFontAssetManager();
        if (fontAssetManager != null) {
            return fontAssetManager.getTypeface(str, str2);
        }
        return null;
    }

    public boolean hasMasks() {
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer != null && compositionLayer.hasMasks()) {
            return true;
        }
        return false;
    }

    public boolean hasMatte() {
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer != null && compositionLayer.hasMatte()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.isDirty) {
            return;
        }
        this.isDirty = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isAnimating() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAnimatingOrWillAnimateOnVisible() {
        if (isVisible()) {
            return this.animator.isRunning();
        }
        OnVisibleAction onVisibleAction = this.onVisibleAction;
        if (onVisibleAction != OnVisibleAction.PLAY && onVisibleAction != OnVisibleAction.RESUME) {
            return false;
        }
        return true;
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.isApplyingOpacityToLayersEnabled;
    }

    public boolean isLooping() {
        if (this.animator.getRepeatCount() == -1) {
            return true;
        }
        return false;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    @Deprecated
    public void loop(boolean z16) {
        int i3;
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (z16) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        lottieValueAnimator.setRepeatCount(i3);
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
        if (!isVisible()) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
    }

    @MainThread
    public void playAnimation() {
        float maxFrame;
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.s
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$playAnimation$0(lottieComposition);
                }
            });
            return;
        }
        computeRenderMode();
        if (animationsEnabled() || getRepeatCount() == 0) {
            if (isVisible()) {
                this.animator.playAnimation();
                this.onVisibleAction = OnVisibleAction.NONE;
            } else {
                this.onVisibleAction = OnVisibleAction.PLAY;
            }
        }
        if (!animationsEnabled()) {
            if (getSpeed() < 0.0f) {
                maxFrame = getMinFrame();
            } else {
                maxFrame = getMaxFrame();
            }
            setFrame((int) maxFrame);
            this.animator.endAnimation();
            if (!isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
    }

    public void removeAllAnimatorListeners() {
        this.animator.removeAllListeners();
    }

    public void removeAllUpdateListeners() {
        this.animator.removeAllUpdateListeners();
        this.animator.addUpdateListener(this.progressUpdateListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.removeListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.animator.removePauseListener(animatorPauseListener);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.removeUpdateListener(animatorUpdateListener);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        if (this.compositionLayer == null) {
            Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.compositionLayer.resolveKeyPath(keyPath, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    @MainThread
    public void resumeAnimation() {
        float maxFrame;
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.aa
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$resumeAnimation$1(lottieComposition);
                }
            });
            return;
        }
        computeRenderMode();
        if (animationsEnabled() || getRepeatCount() == 0) {
            if (isVisible()) {
                this.animator.resumeAnimation();
                this.onVisibleAction = OnVisibleAction.NONE;
            } else {
                this.onVisibleAction = OnVisibleAction.RESUME;
            }
        }
        if (!animationsEnabled()) {
            if (getSpeed() < 0.0f) {
                maxFrame = getMinFrame();
            } else {
                maxFrame = getMaxFrame();
            }
            setFrame((int) maxFrame);
            this.animator.endAnimation();
            if (!isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
    }

    public void reverseAnimationSpeed() {
        this.animator.reverseAnimationSpeed();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j3) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i3) {
        this.alpha = i3;
        invalidateSelf();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z16) {
        this.isApplyingOpacityToLayersEnabled = z16;
    }

    public void setClipToCompositionBounds(boolean z16) {
        if (z16 != this.clipToCompositionBounds) {
            this.clipToCompositionBounds = z16;
            CompositionLayer compositionLayer = this.compositionLayer;
            if (compositionLayer != null) {
                compositionLayer.setClipToCompositionBounds(z16);
            }
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Logger.warning("Use addColorFilter instead.");
    }

    public boolean setComposition(LottieComposition lottieComposition) {
        if (this.composition == lottieComposition) {
            return false;
        }
        this.isDirty = true;
        clearComposition();
        this.composition = lottieComposition;
        buildCompositionLayer();
        this.animator.setComposition(lottieComposition);
        setProgress(this.animator.getAnimatedFraction());
        Iterator it = new ArrayList(this.lazyCompositionTasks).iterator();
        while (it.hasNext()) {
            LazyCompositionTask lazyCompositionTask = (LazyCompositionTask) it.next();
            if (lazyCompositionTask != null) {
                lazyCompositionTask.run(lottieComposition);
            }
            it.remove();
        }
        this.lazyCompositionTasks.clear();
        lottieComposition.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
        computeRenderMode();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.fontAssetDelegate = fontAssetDelegate;
        FontAssetManager fontAssetManager = this.fontAssetManager;
        if (fontAssetManager != null) {
            fontAssetManager.setDelegate(fontAssetDelegate);
        }
    }

    public void setFrame(final int i3) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.t
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$setFrame$12(i3, lottieComposition);
                }
            });
        } else {
            this.animator.setFrame(i3);
        }
    }

    public void setIgnoreDisabledSystemAnimations(boolean z16) {
        this.ignoreSystemAnimationsDisabled = z16;
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.imageAssetDelegate = imageAssetDelegate;
        ImageAssetManager imageAssetManager = this.imageAssetManager;
        if (imageAssetManager != null) {
            imageAssetManager.setDelegate(imageAssetDelegate);
        }
    }

    public void setImagesAssetsFolder(@Nullable String str) {
        this.imageAssetsFolder = str;
    }

    public void setMaintainOriginalImageBounds(boolean z16) {
        this.maintainOriginalImageBounds = z16;
    }

    public void setMaxFrame(final int i3) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.z
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$setMaxFrame$4(i3, lottieComposition);
                }
            });
        } else {
            this.animator.setMaxFrame(i3 + 0.99f);
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f16) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.r
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.lambda$setMaxProgress$5(f16, lottieComposition2);
                }
            });
        } else {
            this.animator.setMaxFrame(MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f16));
        }
    }

    public void setMinAndMaxFrame(final String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.v
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.lambda$setMinAndMaxFrame$8(str, lottieComposition2);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            int i3 = (int) marker.startFrame;
            setMinAndMaxFrame(i3, ((int) marker.durationFrames) + i3);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f16, @FloatRange(from = 0.0d, to = 1.0d) final float f17) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.w
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.lambda$setMinAndMaxProgress$11(f16, f17, lottieComposition2);
                }
            });
        } else {
            setMinAndMaxFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f16), (int) MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), f17));
        }
    }

    public void setMinFrame(final int i3) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.x
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$setMinFrame$2(i3, lottieComposition);
                }
            });
        } else {
            this.animator.setMinFrame(i3);
        }
    }

    public void setMinProgress(final float f16) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.y
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.lambda$setMinProgress$3(f16, lottieComposition2);
                }
            });
        } else {
            setMinFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f16));
        }
    }

    public void setOutlineMasksAndMattes(boolean z16) {
        if (this.outlineMasksAndMattes == z16) {
            return;
        }
        this.outlineMasksAndMattes = z16;
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer != null) {
            compositionLayer.setOutlineMasksAndMattes(z16);
        }
    }

    public void setPerformanceTrackingEnabled(boolean z16) {
        this.performanceTrackingEnabled = z16;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            lottieComposition.setPerformanceTrackingEnabled(z16);
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f16) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.q
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$setProgress$13(f16, lottieComposition);
                }
            });
            return;
        }
        L.beginSection("Drawable#setProgress");
        this.animator.setFrame(this.composition.getFrameForProgress(f16));
        L.endSection("Drawable#setProgress");
    }

    public void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
        computeRenderMode();
    }

    public void setRepeatCount(int i3) {
        this.animator.setRepeatCount(i3);
    }

    public void setRepeatMode(int i3) {
        this.animator.setRepeatMode(i3);
    }

    public void setSafeMode(boolean z16) {
        this.safeMode = z16;
    }

    public void setSpeed(float f16) {
        this.animator.setSpeed(f16);
    }

    public void setSystemAnimationsAreEnabled(Boolean bool) {
        this.systemAnimationsEnabled = bool.booleanValue();
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.textDelegate = textDelegate;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean z18 = !isVisible();
        boolean visible = super.setVisible(z16, z17);
        if (z16) {
            OnVisibleAction onVisibleAction = this.onVisibleAction;
            if (onVisibleAction == OnVisibleAction.PLAY) {
                playAnimation();
            } else if (onVisibleAction == OnVisibleAction.RESUME) {
                resumeAnimation();
            }
        } else if (this.animator.isRunning()) {
            pauseAnimation();
            this.onVisibleAction = OnVisibleAction.RESUME;
        } else if (!z18) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        playAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        endAnimation();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        ImageAssetManager imageAssetManager = getImageAssetManager();
        if (imageAssetManager == null) {
            Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = imageAssetManager.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    public boolean useTextGlyphs() {
        if (this.textDelegate == null && this.composition.getCharacters().size() > 0) {
            return true;
        }
        return false;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z16) {
        if (this.enableMergePaths == z16) {
            return;
        }
        this.enableMergePaths = z16;
        if (this.composition != null) {
            buildCompositionLayer();
        }
    }

    public void setMaxFrame(final String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.ab
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.lambda$setMaxFrame$7(str, lottieComposition2);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMaxFrame((int) (marker.startFrame + marker.durationFrames));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinFrame(final String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.ad
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.lambda$setMinFrame$6(str, lottieComposition2);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMinFrame((int) marker.startFrame);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    private void convertRect(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setMinAndMaxFrame(final String str, final String str2, final boolean z16) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.ac
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.lambda$setMinAndMaxFrame$9(str, str2, z16, lottieComposition2);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            int i3 = (int) marker.startFrame;
            Marker marker2 = this.composition.getMarker(str2);
            if (marker2 != null) {
                setMinAndMaxFrame(i3, (int) (marker2.startFrame + (z16 ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void draw(Canvas canvas, Matrix matrix) {
        CompositionLayer compositionLayer = this.compositionLayer;
        LottieComposition lottieComposition = this.composition;
        if (compositionLayer == null || lottieComposition == null) {
            return;
        }
        if (this.useSoftwareRendering) {
            canvas.save();
            canvas.concat(matrix);
            renderAndDrawAsBitmap(canvas, compositionLayer);
            canvas.restore();
        } else {
            compositionLayer.draw(canvas, matrix, this.alpha);
        }
        this.isDirty = false;
    }

    public <T> void addValueCallback(KeyPath keyPath, T t16, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        addValueCallback(keyPath, (KeyPath) t16, (LottieValueCallback<KeyPath>) new LottieValueCallback<T>() { // from class: com.airbnb.lottie.LottieDrawable.2
            @Override // com.airbnb.lottie.value.LottieValueCallback
            public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                return (T) simpleLottieValueCallback.getValue(lottieFrameInfo);
            }
        });
    }

    public void setMinAndMaxFrame(final int i3, final int i16) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.u
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.lambda$setMinAndMaxFrame$10(i3, i16, lottieComposition);
                }
            });
        } else {
            this.animator.setMinAndMaxFrames(i3, i16 + 0.99f);
        }
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
    }
}
