package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.layer.BaseLayer;

/* compiled from: P */
/* loaded from: classes.dex */
public interface ContentModel {
    @Nullable
    Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer);
}
