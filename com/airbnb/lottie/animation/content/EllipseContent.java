package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class EllipseContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float ELLIPSE_CONTROL_POINT_PERCENTAGE = 0.55228f;
    private final CircleShape circleShape;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private final Path path = new Path();
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, CircleShape circleShape) {
        this.name = circleShape.getName();
        this.lottieDrawable = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = circleShape.getSize().createAnimation();
        this.sizeAnimation = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = circleShape.getPosition().createAnimation();
        this.positionAnimation = createAnimation2;
        this.circleShape = circleShape;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t16, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t16 == LottieProperty.ELLIPSE_SIZE) {
            this.sizeAnimation.setValueCallback(lottieValueCallback);
        } else if (t16 == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
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
        if (this.circleShape.isHidden()) {
            this.isPathValid = true;
            return this.path;
        }
        PointF value = this.sizeAnimation.getValue();
        float f16 = value.x / 2.0f;
        float f17 = value.y / 2.0f;
        float f18 = f16 * ELLIPSE_CONTROL_POINT_PERCENTAGE;
        float f19 = ELLIPSE_CONTROL_POINT_PERCENTAGE * f17;
        this.path.reset();
        if (this.circleShape.isReversed()) {
            float f26 = -f17;
            this.path.moveTo(0.0f, f26);
            float f27 = 0.0f - f18;
            float f28 = -f16;
            float f29 = 0.0f - f19;
            this.path.cubicTo(f27, f26, f28, f29, f28, 0.0f);
            float f36 = f19 + 0.0f;
            this.path.cubicTo(f28, f36, f27, f17, 0.0f, f17);
            float f37 = f18 + 0.0f;
            this.path.cubicTo(f37, f17, f16, f36, f16, 0.0f);
            this.path.cubicTo(f16, f29, f37, f26, 0.0f, f26);
        } else {
            float f38 = -f17;
            this.path.moveTo(0.0f, f38);
            float f39 = f18 + 0.0f;
            float f46 = 0.0f - f19;
            this.path.cubicTo(f39, f38, f16, f46, f16, 0.0f);
            float f47 = f19 + 0.0f;
            this.path.cubicTo(f16, f47, f39, f17, 0.0f, f17);
            float f48 = 0.0f - f18;
            float f49 = -f16;
            this.path.cubicTo(f48, f17, f49, f47, f49, 0.0f);
            this.path.cubicTo(f49, f46, f48, f38, 0.0f, f38);
        }
        PointF value2 = this.positionAnimation.getValue();
        this.path.offset(value2.x, value2.y);
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
