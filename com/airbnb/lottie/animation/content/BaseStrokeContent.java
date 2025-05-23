package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {

    @Nullable
    private BaseKeyframeAnimation<Float, Float> blurAnimation;
    float blurMaskFilterRadius;

    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final List<BaseKeyframeAnimation<?, Float>> dashPatternAnimations;

    @Nullable
    private final BaseKeyframeAnimation<?, Float> dashPatternOffsetAnimation;
    private final float[] dashPatternValues;

    @Nullable
    private DropShadowKeyframeAnimation dropShadowAnimation;
    protected final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final BaseKeyframeAnimation<?, Integer> opacityAnimation;
    final Paint paint;
    private final BaseKeyframeAnimation<?, Float> widthAnimation;

    /* renamed from: pm, reason: collision with root package name */
    private final PathMeasure f31214pm = new PathMeasure();
    private final Path path = new Path();
    private final Path trimPathPath = new Path();
    private final RectF rect = new RectF();
    private final List<PathGroup> pathGroups = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class PathGroup {
        private final List<PathContent> paths;

        @Nullable
        private final TrimPathContent trimPath;

        PathGroup(@Nullable TrimPathContent trimPathContent) {
            this.paths = new ArrayList();
            this.trimPath = trimPathContent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f16, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.paint = lPaint;
        this.blurMaskFilterRadius = 0.0f;
        this.lottieDrawable = lottieDrawable;
        this.layer = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f16);
        this.opacityAnimation = animatableIntegerValue.createAnimation();
        this.widthAnimation = animatableFloatValue.createAnimation();
        if (animatableFloatValue2 == null) {
            this.dashPatternOffsetAnimation = null;
        } else {
            this.dashPatternOffsetAnimation = animatableFloatValue2.createAnimation();
        }
        this.dashPatternAnimations = new ArrayList(list.size());
        this.dashPatternValues = new float[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.dashPatternAnimations.add(list.get(i3).createAnimation());
        }
        baseLayer.addAnimation(this.opacityAnimation);
        baseLayer.addAnimation(this.widthAnimation);
        for (int i16 = 0; i16 < this.dashPatternAnimations.size(); i16++) {
            baseLayer.addAnimation(this.dashPatternAnimations.get(i16));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation != null) {
            baseLayer.addAnimation(baseKeyframeAnimation);
        }
        this.opacityAnimation.addUpdateListener(this);
        this.widthAnimation.addUpdateListener(this);
        for (int i17 = 0; i17 < list.size(); i17++) {
            this.dashPatternAnimations.get(i17).addUpdateListener(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(this);
        }
        if (baseLayer.getBlurEffect() != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = baseLayer.getBlurEffect().getBlurriness().createAnimation();
            this.blurAnimation = createAnimation;
            createAnimation.addUpdateListener(this);
            baseLayer.addAnimation(this.blurAnimation);
        }
        if (baseLayer.getDropShadowEffect() != null) {
            this.dropShadowAnimation = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.getDropShadowEffect());
        }
    }

    private void applyDashPatternIfNeeded(Matrix matrix) {
        float floatValue;
        L.beginSection("StrokeContent#applyDashPattern");
        if (this.dashPatternAnimations.isEmpty()) {
            L.endSection("StrokeContent#applyDashPattern");
            return;
        }
        float scale = Utils.getScale(matrix);
        for (int i3 = 0; i3 < this.dashPatternAnimations.size(); i3++) {
            this.dashPatternValues[i3] = this.dashPatternAnimations.get(i3).getValue().floatValue();
            if (i3 % 2 == 0) {
                float[] fArr = this.dashPatternValues;
                if (fArr[i3] < 1.0f) {
                    fArr[i3] = 1.0f;
                }
            } else {
                float[] fArr2 = this.dashPatternValues;
                if (fArr2[i3] < 0.1f) {
                    fArr2[i3] = 0.1f;
                }
            }
            float[] fArr3 = this.dashPatternValues;
            fArr3[i3] = fArr3[i3] * scale;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation == null) {
            floatValue = 0.0f;
        } else {
            floatValue = scale * baseKeyframeAnimation.getValue().floatValue();
        }
        this.paint.setPathEffect(new DashPathEffect(this.dashPatternValues, floatValue));
        L.endSection("StrokeContent#applyDashPattern");
    }

    private void applyTrimPath(Canvas canvas, PathGroup pathGroup, Matrix matrix) {
        float f16;
        float f17;
        float f18;
        L.beginSection("StrokeContent#applyTrimPath");
        if (pathGroup.trimPath == null) {
            L.endSection("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
            this.path.addPath(((PathContent) pathGroup.paths.get(size)).getPath(), matrix);
        }
        float floatValue = pathGroup.trimPath.getStart().getValue().floatValue() / 100.0f;
        float floatValue2 = pathGroup.trimPath.getEnd().getValue().floatValue() / 100.0f;
        float floatValue3 = pathGroup.trimPath.getOffset().getValue().floatValue() / 360.0f;
        if (floatValue < 0.01f && floatValue2 > 0.99f) {
            canvas.drawPath(this.path, this.paint);
            L.endSection("StrokeContent#applyTrimPath");
            return;
        }
        this.f31214pm.setPath(this.path, false);
        float length = this.f31214pm.getLength();
        while (this.f31214pm.nextContour()) {
            length += this.f31214pm.getLength();
        }
        float f19 = floatValue3 * length;
        float f26 = (floatValue * length) + f19;
        float min = Math.min((floatValue2 * length) + f19, (f26 + length) - 1.0f);
        float f27 = 0.0f;
        for (int size2 = pathGroup.paths.size() - 1; size2 >= 0; size2--) {
            this.trimPathPath.set(((PathContent) pathGroup.paths.get(size2)).getPath());
            this.trimPathPath.transform(matrix);
            this.f31214pm.setPath(this.trimPathPath, false);
            float length2 = this.f31214pm.getLength();
            if (min > length) {
                float f28 = min - length;
                if (f28 < f27 + length2 && f27 < f28) {
                    if (f26 > length) {
                        f18 = (f26 - length) / length2;
                    } else {
                        f18 = 0.0f;
                    }
                    Utils.applyTrimPathIfNeeded(this.trimPathPath, f18, Math.min(f28 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.trimPathPath, this.paint);
                    f27 += length2;
                }
            }
            float f29 = f27 + length2;
            if (f29 >= f26 && f27 <= min) {
                if (f29 <= min && f26 < f27) {
                    canvas.drawPath(this.trimPathPath, this.paint);
                } else {
                    if (f26 < f27) {
                        f16 = 0.0f;
                    } else {
                        f16 = (f26 - f27) / length2;
                    }
                    if (min > f29) {
                        f17 = 1.0f;
                    } else {
                        f17 = (min - f27) / length2;
                    }
                    Utils.applyTrimPathIfNeeded(this.trimPathPath, f16, f17, 0.0f);
                    canvas.drawPath(this.trimPathPath, this.paint);
                }
            }
            f27 += length2;
        }
        L.endSection("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @CallSuper
    public <T> void addValueCallback(T t16, @Nullable LottieValueCallback<T> lottieValueCallback) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation2;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation3;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation4;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation5;
        if (t16 == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t16 == LottieProperty.STROKE_WIDTH) {
            this.widthAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t16 == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.layer.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.colorFilterAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorFilterAnimation);
            return;
        }
        if (t16 == LottieProperty.BLUR_RADIUS) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.blurAnimation;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.blurAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            this.layer.addAnimation(this.blurAnimation);
            return;
        }
        if (t16 == LottieProperty.DROP_SHADOW_COLOR && (dropShadowKeyframeAnimation5 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation5.setColorCallback(lottieValueCallback);
            return;
        }
        if (t16 == LottieProperty.DROP_SHADOW_OPACITY && (dropShadowKeyframeAnimation4 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation4.setOpacityCallback(lottieValueCallback);
            return;
        }
        if (t16 == LottieProperty.DROP_SHADOW_DIRECTION && (dropShadowKeyframeAnimation3 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation3.setDirectionCallback(lottieValueCallback);
            return;
        }
        if (t16 == LottieProperty.DROP_SHADOW_DISTANCE && (dropShadowKeyframeAnimation2 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation2.setDistanceCallback(lottieValueCallback);
        } else if (t16 == LottieProperty.DROP_SHADOW_RADIUS && (dropShadowKeyframeAnimation = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation.setRadiusCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i3) {
        L.beginSection("StrokeContent#draw");
        if (Utils.hasZeroScaleAxis(matrix)) {
            L.endSection("StrokeContent#draw");
            return;
        }
        this.paint.setAlpha(MiscUtils.clamp((int) ((((i3 / 255.0f) * ((IntegerKeyframeAnimation) this.opacityAnimation).getIntValue()) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(((FloatKeyframeAnimation) this.widthAnimation).getFloatValue() * Utils.getScale(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            L.endSection("StrokeContent#draw");
            return;
        }
        applyDashPatternIfNeeded(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.blurAnimation;
        if (baseKeyframeAnimation2 != null) {
            float floatValue = baseKeyframeAnimation2.getValue().floatValue();
            if (floatValue == 0.0f) {
                this.paint.setMaskFilter(null);
            } else if (floatValue != this.blurMaskFilterRadius) {
                this.paint.setMaskFilter(this.layer.getBlurMaskFilter(floatValue));
            }
            this.blurMaskFilterRadius = floatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.dropShadowAnimation;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.applyTo(this.paint);
        }
        for (int i16 = 0; i16 < this.pathGroups.size(); i16++) {
            PathGroup pathGroup = this.pathGroups.get(i16);
            if (pathGroup.trimPath != null) {
                applyTrimPath(canvas, pathGroup, matrix);
            } else {
                L.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
                    this.path.addPath(((PathContent) pathGroup.paths.get(size)).getPath(), matrix);
                }
                L.endSection("StrokeContent#buildPath");
                L.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                L.endSection("StrokeContent#drawPath");
            }
        }
        L.endSection("StrokeContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z16) {
        L.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i3 = 0; i3 < this.pathGroups.size(); i3++) {
            PathGroup pathGroup = this.pathGroups.get(i3);
            for (int i16 = 0; i16 < pathGroup.paths.size(); i16++) {
                this.path.addPath(((PathContent) pathGroup.paths.get(i16)).getPath(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = ((FloatKeyframeAnimation) this.widthAnimation).getFloatValue();
        RectF rectF2 = this.rect;
        float f16 = floatValue / 2.0f;
        rectF2.set(rectF2.left - f16, rectF2.top - f16, rectF2.right + f16, rectF2.bottom + f16);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.endSection("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i3, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i3, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content;
                if (trimPathContent2.getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.addListener(this);
        }
        PathGroup pathGroup = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content2;
                if (trimPathContent3.getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (pathGroup != null) {
                        this.pathGroups.add(pathGroup);
                    }
                    pathGroup = new PathGroup(trimPathContent3);
                    trimPathContent3.addListener(this);
                }
            }
            if (content2 instanceof PathContent) {
                if (pathGroup == null) {
                    pathGroup = new PathGroup(trimPathContent);
                }
                pathGroup.paths.add((PathContent) content2);
            }
        }
        if (pathGroup != null) {
            this.pathGroups.add(pathGroup);
        }
    }
}
