package com.qq.e.tg.interstitial2;

import com.qq.e.comm.util.AdError;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface UnifiedInterstitialMediaListener {
    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoading();

    void onVideoPageClose();

    void onVideoPageOpen();

    void onVideoPause();

    void onVideoReady(long j3);

    void onVideoStart();
}
