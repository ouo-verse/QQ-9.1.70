package com.tencent.gdtad.api;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface GdtAdListener {
    void onAdClicked(GdtAd gdtAd);

    void onAdClosed(GdtAd gdtAd);

    void onAdFailedToLoad(GdtAd gdtAd, GdtAdError gdtAdError);

    void onAdImpression(GdtAd gdtAd);

    void onAdLoaded(GdtAd gdtAd);
}
