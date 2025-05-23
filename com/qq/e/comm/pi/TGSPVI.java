package com.qq.e.comm.pi;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.tg.splash.SplashOrder;
import com.qq.e.tg.splash.TGSplashAD;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TGSPVI {
    public static final Map<String, String> ext = new HashMap();

    void doRecycleBeforeSplashDismiss();

    void fetchAdOnly();

    void fetchAndShowIn(ViewGroup viewGroup);

    String getAdNetWorkName();

    SplashOrder getSelectResultImmediately(String str);

    void needUseCustomDynamicFloatView(boolean z16);

    void needUseCustomFloatViewPosition(boolean z16);

    void needUseSplashButtonGuideView(boolean z16);

    void preload();

    void reportCost(int i3, int i16, Map map);

    void reportEmptyOrderIfNecessaryAndPreFetchAd(TGSplashAD.FetchAdParams fetchAdParams);

    void reportLinkEvent(TGSplashAD.ReportParams reportParams);

    void reportNoUseSplashReason(int i3);

    void selectOrderByLocalRealtimeParallelism();

    void setAdListener(ADListener aDListener);

    void setAdLogoView(View view);

    void setBrokenWindowCloseView(View view);

    void setCustomDecoderPlayer(ITangramDecoderPlayer iTangramDecoderPlayer);

    void setEasterEggVolumeIcon(View view, View view2);

    void setFetchDelay(int i3);

    void setFloatView(View view);

    void setLimitAdView(View view);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setOneShotFocusViewRect(Rect rect);

    void setPreloadView(View view);

    void setPureSkipView(View view);

    void setSkipView(View view);

    void setSplashButtonGuideViewHeight(int i3);

    void setVideoView(ITangramPlayer iTangramPlayer, boolean z16);

    void setVolumeIcon(View view, View view2);

    void setVolumeIconEasterEggMargin(int i3, int i16);

    void setVolumeIconMargin(int i3, int i16);

    void showAd(TGSplashAD.SplashDisplayParams splashDisplayParams);
}
