package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final boolean hidden;

    @Nullable
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;

    @Nullable
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final boolean isReversed;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private final PolystarShape.Type type;
    private final Path path = new Path();
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable;
        this.name = polystarShape.getName();
        PolystarShape.Type type = polystarShape.getType();
        this.type = type;
        this.hidden = polystarShape.isHidden();
        this.isReversed = polystarShape.isReversed();
        BaseKeyframeAnimation<Float, Float> createAnimation = polystarShape.getPoints().createAnimation();
        this.pointsAnimation = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = polystarShape.getPosition().createAnimation();
        this.positionAnimation = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = polystarShape.getRotation().createAnimation();
        this.rotationAnimation = createAnimation3;
        BaseKeyframeAnimation<Float, Float> createAnimation4 = polystarShape.getOuterRadius().createAnimation();
        this.outerRadiusAnimation = createAnimation4;
        BaseKeyframeAnimation<Float, Float> createAnimation5 = polystarShape.getOuterRoundedness().createAnimation();
        this.outerRoundednessAnimation = createAnimation5;
        PolystarShape.Type type2 = PolystarShape.Type.STAR;
        if (type == type2) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        baseLayer.addAnimation(createAnimation4);
        baseLayer.addAnimation(createAnimation5);
        if (type == type2) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
        createAnimation4.addUpdateListener(this);
        createAnimation5.addUpdateListener(this);
        if (type == type2) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    private void createPolygonPath() {
        double floatValue;
        int i3;
        double d16;
        double d17;
        double d18;
        int floor = (int) Math.floor(this.pointsAnimation.getValue().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        if (baseKeyframeAnimation == null) {
            floatValue = 0.0d;
        } else {
            floatValue = baseKeyframeAnimation.getValue().floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d19 = floor;
        float floatValue2 = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float floatValue3 = this.outerRadiusAnimation.getValue().floatValue();
        double d26 = floatValue3;
        float cos = (float) (Math.cos(radians) * d26);
        float sin = (float) (Math.sin(radians) * d26);
        this.path.moveTo(cos, sin);
        double d27 = (float) (6.283185307179586d / d19);
        double d28 = radians + d27;
        double ceil = Math.ceil(d19);
        int i16 = 0;
        while (i16 < ceil) {
            float cos2 = (float) (Math.cos(d28) * d26);
            double d29 = ceil;
            float sin2 = (float) (d26 * Math.sin(d28));
            if (floatValue2 != 0.0f) {
                d17 = d26;
                i3 = i16;
                d16 = d28;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                d18 = d27;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f16 = floatValue3 * floatValue2 * 0.25f;
                this.path.cubicTo(cos - (cos3 * f16), sin - (sin3 * f16), cos2 + (((float) Math.cos(atan22)) * f16), sin2 + (f16 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                i3 = i16;
                d16 = d28;
                d17 = d26;
                d18 = d27;
                this.path.lineTo(cos2, sin2);
            }
            d28 = d16 + d18;
            i16 = i3 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d29;
            d26 = d17;
            d27 = d18;
        }
        PointF value = this.positionAnimation.getValue();
        this.path.offset(value.x, value.y);
        this.path.close();
    }

    private void createStarPath() {
        double floatValue;
        float f16;
        float f17;
        int i3;
        float f18;
        float f19;
        double d16;
        float f26;
        float f27;
        float f28;
        float f29;
        float f36;
        double d17;
        float f37;
        float f38;
        float f39;
        double d18;
        float f46;
        float f47;
        float f48;
        float f49;
        float floatValue2 = this.pointsAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        if (baseKeyframeAnimation == null) {
            floatValue = 0.0d;
        } else {
            floatValue = baseKeyframeAnimation.getValue().floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d19 = floatValue2;
        float f56 = (float) (6.283185307179586d / d19);
        if (this.isReversed) {
            f56 *= -1.0f;
        }
        float f57 = f56 / 2.0f;
        float f58 = floatValue2 - ((int) floatValue2);
        int i16 = (f58 > 0.0f ? 1 : (f58 == 0.0f ? 0 : -1));
        if (i16 != 0) {
            radians += (1.0f - f58) * f57;
        }
        float floatValue3 = this.outerRadiusAnimation.getValue().floatValue();
        float floatValue4 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.innerRoundednessAnimation;
        if (baseKeyframeAnimation2 != null) {
            f16 = baseKeyframeAnimation2.getValue().floatValue() / 100.0f;
        } else {
            f16 = 0.0f;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.outerRoundednessAnimation;
        if (baseKeyframeAnimation3 != null) {
            f17 = baseKeyframeAnimation3.getValue().floatValue() / 100.0f;
        } else {
            f17 = 0.0f;
        }
        if (i16 != 0) {
            f27 = ((floatValue3 - floatValue4) * f58) + floatValue4;
            i3 = i16;
            double d26 = f27;
            float cos = (float) (d26 * Math.cos(radians));
            f26 = (float) (d26 * Math.sin(radians));
            this.path.moveTo(cos, f26);
            d16 = radians + ((f56 * f58) / 2.0f);
            f18 = cos;
            f19 = f57;
        } else {
            i3 = i16;
            double d27 = floatValue3;
            float cos2 = (float) (Math.cos(radians) * d27);
            float sin = (float) (d27 * Math.sin(radians));
            this.path.moveTo(cos2, sin);
            f18 = cos2;
            f19 = f57;
            d16 = radians + f19;
            f26 = sin;
            f27 = 0.0f;
        }
        double ceil = Math.ceil(d19) * 2.0d;
        int i17 = 0;
        float f59 = f19;
        float f65 = f18;
        boolean z16 = false;
        while (true) {
            double d28 = i17;
            if (d28 < ceil) {
                if (z16) {
                    f28 = floatValue3;
                } else {
                    f28 = floatValue4;
                }
                if (f27 != 0.0f && d28 == ceil - 2.0d) {
                    f29 = f56;
                    f36 = (f56 * f58) / 2.0f;
                } else {
                    f29 = f56;
                    f36 = f59;
                }
                if (f27 != 0.0f && d28 == ceil - 1.0d) {
                    d17 = d28;
                    f37 = f27;
                } else {
                    d17 = d28;
                    f37 = f27;
                    f27 = f28;
                }
                double d29 = f27;
                double d36 = ceil;
                float cos3 = (float) (d29 * Math.cos(d16));
                float sin2 = (float) (d29 * Math.sin(d16));
                if (f16 == 0.0f && f17 == 0.0f) {
                    this.path.lineTo(cos3, sin2);
                    d18 = d16;
                    f38 = f16;
                    f39 = f17;
                } else {
                    f38 = f16;
                    double atan2 = (float) (Math.atan2(f26, f65) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    f39 = f17;
                    d18 = d16;
                    double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    if (z16) {
                        f46 = f38;
                    } else {
                        f46 = f39;
                    }
                    if (z16) {
                        f47 = f39;
                    } else {
                        f47 = f38;
                    }
                    if (z16) {
                        f48 = floatValue4;
                    } else {
                        f48 = floatValue3;
                    }
                    if (z16) {
                        f49 = floatValue3;
                    } else {
                        f49 = floatValue4;
                    }
                    float f66 = f48 * f46 * POLYSTAR_MAGIC_NUMBER;
                    float f67 = cos4 * f66;
                    float f68 = f66 * sin3;
                    float f69 = f49 * f47 * POLYSTAR_MAGIC_NUMBER;
                    float f75 = cos5 * f69;
                    float f76 = f69 * sin4;
                    if (i3 != 0) {
                        if (i17 == 0) {
                            f67 *= f58;
                            f68 *= f58;
                        } else if (d17 == d36 - 1.0d) {
                            f75 *= f58;
                            f76 *= f58;
                        }
                    }
                    this.path.cubicTo(f65 - f67, f26 - f68, cos3 + f75, sin2 + f76, cos3, sin2);
                }
                d16 = d18 + f36;
                z16 = !z16;
                i17++;
                f65 = cos3;
                f26 = sin2;
                f17 = f39;
                f16 = f38;
                f27 = f37;
                f56 = f29;
                ceil = d36;
            } else {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t16, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t16 == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t16 == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t16 == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t16 == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.innerRadiusAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return;
        }
        if (t16 == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t16 == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.innerRoundednessAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t16 == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        int i3 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                createPolygonPath();
            }
        } else {
            createStarPath();
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i3, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i3, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            Content content = list.get(i3);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.addTrimPath(trimPathContent);
                    trimPathContent.addListener(this);
                }
            }
        }
    }
}
