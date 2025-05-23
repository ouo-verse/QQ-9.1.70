package com.qq.e.tg.splash;

import com.qq.e.comm.util.AdError;

/* compiled from: P */
@Deprecated
/* loaded from: classes3.dex */
public interface TGSplashAdListener {
    void onADClicked();

    void onADDismissed();

    void onADExposure();

    void onADFetch();

    void onADPresent();

    void onADSkip();

    void onADTick(long j3);

    void onNoAD(AdError adError);
}
