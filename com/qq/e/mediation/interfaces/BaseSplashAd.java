package com.qq.e.mediation.interfaces;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseSplashAd {
    public static final int DEFAULT_PRIORITY = -1;
    public static final int EVENT_TYPE_AD_CLICKED = 4;
    public static final int EVENT_TYPE_AD_DISMISSED = 1;
    public static final int EVENT_TYPE_AD_EXPOSURE = 6;
    public static final int EVENT_TYPE_AD_LOADED = 7;
    public static final int EVENT_TYPE_AD_PRESENT = 3;
    public static final int EVENT_TYPE_AD_TICK = 5;
    public static final int EVENT_TYPE_NO_AD = 2;

    public BaseSplashAd(Context context, String str, String str2) {
    }

    public abstract void fetchAdOnly();

    public abstract void fetchAndShowIn(ViewGroup viewGroup);

    public int getAdapterPriority() {
        return -1;
    }

    public abstract int getECPM();

    public abstract String getECPMLevel();

    public abstract void preload();

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setFetchDelay(int i3);

    public abstract void setLoadAdParams(LoadAdParams loadAdParams);

    public abstract void setSkipView(View view);

    public abstract void showAd(ViewGroup viewGroup);
}
