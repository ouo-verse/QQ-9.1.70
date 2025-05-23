package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.tg.cfg.VideoOption;
import com.qq.e.tg.interstitial2.UnifiedInterstitialMediaListener;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface UIADI {
    public static final Map<String, String> ext = new HashMap();

    void close();

    void destory();

    String getAdNetWorkName();

    int getAdPatternType();

    int getECPM();

    String getECPMLevel();

    void loadAd();

    void loadFullScreenAD();

    void setLodADParams(LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i3);

    void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener);

    void setMinVideoDuration(int i3);

    void setVideoOption(VideoOption videoOption);

    void setVideoPlayPolicy(int i3);

    void show();

    void show(Activity activity);

    void showAsPopupWindow();

    void showAsPopupWindow(Activity activity);

    void showFullScreenAD(Activity activity);
}
