package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public interface KeyPathElement {
    <T> void addValueCallback(T t16, @Nullable LottieValueCallback<T> lottieValueCallback);

    void resolveKeyPath(KeyPath keyPath, int i3, List<KeyPath> list, KeyPath keyPath2);
}
