package com.qq.e.comm.pi;

import com.qq.e.comm.constants.LoadAdParams;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface UBVI {
    public static final Map<String, String> ext = new HashMap();

    void destroy();

    void fetchAd();

    void fetchAd(LoadAdParams loadAdParams);

    void onWindowFocusChanged(boolean z16);

    void pause();

    void resume();

    void setRefresh(int i3);
}
