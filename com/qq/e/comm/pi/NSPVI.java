package com.qq.e.comm.pi;

import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public interface NSPVI {
    public static final Map<String, String> ext = new HashMap();

    void fetchAdOnly();

    void fetchAndShowIn(ViewGroup viewGroup);

    String getAdNetWorkName();

    void preload();

    void setAdListener(ADListener aDListener);

    void setAdLogoMargin(int i3, int i16);

    void setFetchDelay(int i3);

    void setFloatView(View view);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setPreloadView(View view);

    void setSkipView(View view);

    void showAd(ViewGroup viewGroup);
}
