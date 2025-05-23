package com.qq.e.comm.pi;

import android.content.Context;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.tg.rewardAD.RewardDialogContentViewHolder;
import com.qq.e.tg.rewardAD.TangramRewardAdManager;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IEGRVADI {
    void cancelShowAd();

    void checkAndRemoveOldVideoCache();

    void cleanAdCache();

    void deleteOldVideoCache(Context context, long j3);

    String getCurrentAdData();

    int getECPM();

    String getECPMLevel();

    long getExpireTimestamp();

    Map<String, List<TGRVOI>> getPosOrderListFromCache();

    boolean hasPreloadedAd(String str);

    boolean hasShown();

    boolean isNetworkSelectOrderTimeout();

    boolean isShownSuccess();

    void loadAD();

    void notifyNetworkSelectOrderTimeout();

    void onAdShow(TangramRewardAdManager.PosParams posParams);

    void onS2SReward(boolean z16, String str, int i3);

    void preloadAd(Context context, String str, LoadAdParams loadAdParams, int i3);

    void reportEvent(int i3, int i16, Map<String, Object> map);

    void setCloseDialogTips(String str, String str2, String str3);

    void setCustomAdDataGenerator(ICustomAdDataGenerator iCustomAdDataGenerator);

    void setCustomExtraRewardInfo(String str);

    void setCustomGradientRewardInfo(String str);

    void setExposurePassThroughInfo(Map map);

    void setGainRewardTime(int i3);

    void setLeftTopTips(String str, String str2, String str3);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setOneMoreAdTips(String str);

    void setPageCloseDialogTips(String str, String str2, String str3);

    void setPageTopTips(String str, String str2);

    void setRewardDialogContentViewHolder(RewardDialogContentViewHolder rewardDialogContentViewHolder);

    void setVideoVolumeOn(boolean z16);

    void showAD();

    void showAD(Context context, String str, TangramRewardAdManager.PosParams posParams, TangramRewardAdManager.TangramRewardAdCallback tangramRewardAdCallback);

    void showLoadedAd(String str, TangramRewardAdManager.PosParams posParams, int i3);

    void showLocalOrder(String str, TangramRewardAdManager.PosParams posParams);

    void updateNativeOrderCache(String str, String[] strArr);
}
