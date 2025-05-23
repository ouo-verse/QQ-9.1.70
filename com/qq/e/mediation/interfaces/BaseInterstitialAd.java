package com.qq.e.mediation.interfaces;

import android.app.Activity;
import com.qq.e.tg.cfg.VideoOption;
import com.qq.e.tg.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.tg.interstitial2.UnifiedInterstitialMediaListener;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseInterstitialAd {
    public static final int DEFAULT_PRIORITY = -1;

    public BaseInterstitialAd(Activity activity, String str, String str2) {
    }

    public abstract void close();

    public abstract void destory();

    public abstract int getAdPatternType();

    public int getAdapterPriority() {
        return -1;
    }

    public abstract int getECPM();

    public abstract String getECPMLevel();

    public abstract void loadAd();

    public abstract void setAdListener(UnifiedInterstitialADListener unifiedInterstitialADListener);

    public abstract void setMaxVideoDuration(int i3);

    public abstract void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener);

    public abstract void setMinVideoDuration(int i3);

    public abstract void setVideoOption(VideoOption videoOption);

    public abstract void setVideoPlayPolicy(int i3);

    public abstract void show();

    public abstract void show(Activity activity);

    public abstract void showAsPopupWindow();

    public abstract void showAsPopupWindow(Activity activity);
}
