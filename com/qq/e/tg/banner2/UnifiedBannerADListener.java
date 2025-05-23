package com.qq.e.tg.banner2;

import com.qq.e.comm.util.AdError;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface UnifiedBannerADListener {
    void onADClicked();

    void onADCloseOverlay();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpenOverlay();

    void onADReceive();

    void onNoAD(AdError adError);
}
