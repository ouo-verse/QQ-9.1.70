package com.qq.e.tg.splash;

import com.qq.e.comm.util.AdError;

/* loaded from: classes3.dex */
public interface SplashADPreloadListener {
    void onBackupAdSelected(PreCacheSplashAd preCacheSplashAd);

    void onError(AdError adError);

    void onLoadSuccess();
}
