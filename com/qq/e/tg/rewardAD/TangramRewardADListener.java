package com.qq.e.tg.rewardAD;

import com.qq.e.comm.util.AdError;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface TangramRewardADListener {
    void onADCached();

    void onADClick();

    void onADClose();

    void onADComplete();

    void onADExpose();

    void onADLoad();

    void onADPlay(TangramRewardADData tangramRewardADData);

    void onADShow();

    void onError(AdError adError);

    @Deprecated
    void onReward();

    void onReward(RewardResult rewardResult);
}
