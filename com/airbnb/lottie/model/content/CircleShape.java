package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* compiled from: P */
/* loaded from: classes.dex */
public class CircleShape implements ContentModel {
    private final boolean hidden;
    private final boolean isReversed;
    private final String name;
    private final AnimatableValue<PointF, PointF> position;
    private final AnimatablePointValue size;

    public CircleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, boolean z16, boolean z17) {
        this.name = str;
        this.position = animatableValue;
        this.size = animatablePointValue;
        this.isReversed = z16;
        this.hidden = z17;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    public AnimatablePointValue getSize() {
        return this.size;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isReversed() {
        return this.isReversed;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new EllipseContent(lottieDrawable, baseLayer, this);
    }
}
