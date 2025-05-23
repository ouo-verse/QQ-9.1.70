package com.airbnb.lottie;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public class Lottie {
    Lottie() {
    }

    public static void initialize(@NonNull LottieConfig lottieConfig) {
        L.setFetcher(lottieConfig.networkFetcher);
        L.setCacheProvider(lottieConfig.cacheProvider);
        L.setTraceEnabled(lottieConfig.enableSystraceMarkers);
    }
}
