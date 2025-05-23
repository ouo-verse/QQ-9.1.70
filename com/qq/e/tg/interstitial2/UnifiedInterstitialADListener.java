package com.qq.e.tg.interstitial2;

import com.qq.e.comm.util.AdError;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface UnifiedInterstitialADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpened();

    void onADReceive();

    void onNoAD(AdError adError);

    void onVideoCached();
}
