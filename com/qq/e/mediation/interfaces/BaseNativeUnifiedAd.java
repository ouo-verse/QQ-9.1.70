package com.qq.e.mediation.interfaces;

import android.content.Context;
import com.qq.e.comm.adevent.ADListener;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseNativeUnifiedAd {
    public static final int CALLBACK_CLICK = 3;
    public static final int CALLBACK_IMPRESSION = 4;
    public static final int CALLBACK_LOADED = 1;
    public static final int CALLBACK_NO_AD = 2;
    public static final int DEFAULT_PRIORITY = -1;

    public BaseNativeUnifiedAd(Context context, String str, String str2) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract int getECPM();

    public abstract void loadData(int i3);

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setCategories(List<String> list);

    public abstract void setMaxVideoDuration(int i3);

    public abstract void setMinVideoDuration(int i3);

    public abstract void setVideoADContainerRender(int i3);

    public abstract void setVideoPlayPolicy(int i3);
}
