package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RoundedCornersContent;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* compiled from: P */
/* loaded from: classes.dex */
public class RoundedCorners implements ContentModel {
    private final AnimatableValue<Float, Float> cornerRadius;
    private final String name;

    public RoundedCorners(String str, AnimatableValue<Float, Float> animatableValue) {
        this.name = str;
        this.cornerRadius = animatableValue;
    }

    public AnimatableValue<Float, Float> getCornerRadius() {
        return this.cornerRadius;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RoundedCornersContent(lottieDrawable, baseLayer, this);
    }
}
