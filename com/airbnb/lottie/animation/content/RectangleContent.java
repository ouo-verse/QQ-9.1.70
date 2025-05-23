package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {
    private final BaseKeyframeAnimation<?, Float> cornerRadiusAnimation;
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private final Path path = new Path();
    private final RectF rect = new RectF();
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    @Nullable
    private BaseKeyframeAnimation<Float, Float> roundedCornersAnimation = null;

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.name = rectangleShape.getName();
        this.hidden = rectangleShape.isHidden();
        this.lottieDrawable = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = rectangleShape.getPosition().createAnimation();
        this.positionAnimation = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = rectangleShape.getSize().createAnimation();
        this.sizeAnimation = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = rectangleShape.getCornerRadius().createAnimation();
        this.cornerRadiusAnimation = createAnimation3;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t16, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t16 == LottieProperty.RECTANGLE_SIZE) {
            this.sizeAnimation.setValueCallback(lottieValueCallback);
        } else if (t16 == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        } else if (t16 == LottieProperty.CORNER_RADIUS) {
            this.cornerRadiusAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        float floatValue;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        PointF value = this.sizeAnimation.getValue();
        float f16 = value.x / 2.0f;
        float f17 = value.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.cornerRadiusAnimation;
        if (baseKeyframeAnimation2 == null) {
            floatValue = 0.0f;
        } else {
            floatValue = ((FloatKeyframeAnimation) baseKeyframeAnimation2).getFloatValue();
        }
        if (floatValue == 0.0f && (baseKeyframeAnimation = this.roundedCornersAnimation) != null) {
            floatValue = Math.min(baseKeyframeAnimation.getValue().floatValue(), Math.min(f16, f17));
        }
        float min = Math.min(f16, f17);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF value2 = this.positionAnimation.getValue();
        this.path.moveTo(value2.x + f16, (value2.y - f17) + floatValue);
        this.path.lineTo(value2.x + f16, (value2.y + f17) - floatValue);
        if (floatValue > 0.0f) {
            RectF rectF = this.rect;
            float f18 = value2.x;
            float f19 = floatValue * 2.0f;
            float f26 = value2.y;
            rectF.set((f18 + f16) - f19, (f26 + f17) - f19, f18 + f16, f26 + f17);
            this.path.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x - f16) + floatValue, value2.y + f17);
        if (floatValue > 0.0f) {
            RectF rectF2 = this.rect;
            float f27 = value2.x;
            float f28 = value2.y;
            float f29 = floatValue * 2.0f;
            rectF2.set(f27 - f16, (f28 + f17) - f29, (f27 - f16) + f29, f28 + f17);
            this.path.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.path.lineTo(value2.x - f16, (value2.y - f17) + floatValue);
        if (floatValue > 0.0f) {
            RectF rectF3 = this.rect;
            float f36 = value2.x;
            float f37 = value2.y;
            float f38 = floatValue * 2.0f;
            rectF3.set(f36 - f16, f37 - f17, (f36 - f16) + f38, (f37 - f17) + f38);
            this.path.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x + f16) - floatValue, value2.y - f17);
        if (floatValue > 0.0f) {
            RectF rectF4 = this.rect;
            float f39 = value2.x;
            float f46 = floatValue * 2.0f;
            float f47 = value2.y;
            rectF4.set((f39 + f16) - f46, f47 - f17, f39 + f16, (f47 - f17) + f46);
            this.path.arcTo(this.rect, 270.0f, 90.0f, false);
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
            if (content instanceof RoundedCornersContent) {
                this.roundedCornersAnimation = ((RoundedCornersContent) content).getRoundedCorners();
            }
        }
    }
}
