package com.qq.e.mediation.interfaces;

import android.app.Activity;
import android.content.Context;
import com.qq.e.comm.adevent.ADListener;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseRewardAd {
    public static final int DEFAULT_PRIORITY = -1;
    public static final int EVENT_TYPE_ON_AD_CLICK = 6;
    public static final int EVENT_TYPE_ON_AD_CLOSE = 8;
    public static final int EVENT_TYPE_ON_AD_EXPOSE = 4;
    public static final int EVENT_TYPE_ON_AD_LOADED = 1;
    public static final int EVENT_TYPE_ON_AD_SHOW = 3;
    public static final int EVENT_TYPE_ON_ERROR = 9;
    public static final int EVENT_TYPE_ON_REWARD = 5;
    public static final int EVENT_TYPE_ON_VIDEO_CACHED = 2;
    public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 7;

    public BaseRewardAd(Context context, String str, String str2) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract int getECPM();

    public abstract String getECPMLevel();

    public abstract long getExpireTimestamp();

    public abstract boolean hasShown();

    public abstract void loadAD();

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setVolumOn(boolean z16);

    public abstract void showAD();

    public void showAD(Activity activity) {
        showAD();
    }
}
