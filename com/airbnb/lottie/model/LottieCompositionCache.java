package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class LottieCompositionCache {
    private static final LottieCompositionCache INSTANCE = new LottieCompositionCache();
    private final LruCache<String, LottieComposition> cache = new LruCache<>(20);

    @VisibleForTesting
    LottieCompositionCache() {
    }

    public static LottieCompositionCache getInstance() {
        return INSTANCE;
    }

    public void clear() {
        this.cache.evictAll();
    }

    @Nullable
    public LottieComposition get(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.cache.get(str);
    }

    public void put(@Nullable String str, LottieComposition lottieComposition) {
        if (str == null) {
            return;
        }
        this.cache.put(str, lottieComposition);
    }

    public void resize(int i3) {
        this.cache.resize(i3);
    }
}
