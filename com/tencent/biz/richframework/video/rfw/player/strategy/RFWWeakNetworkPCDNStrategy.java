package com.tencent.biz.richframework.video.rfw.player.strategy;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerP2PParams;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWFastCostExp9095;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWWeakNetworkPCDNStrategy {

    /* loaded from: classes5.dex */
    public static class WeakNetworkPCDNStrategyResult {
        private int mEmergencyTime;
        private boolean mHasHitWeakNetStrategy;
        private int mSafePlayTime;

        public int getEmergencyTime() {
            return this.mEmergencyTime;
        }

        public int getSafePlayTime() {
            return this.mSafePlayTime;
        }

        public boolean hasHitWeakNetStrategy() {
            return this.mHasHitWeakNetStrategy;
        }

        public void setEmergencyTime(int i3) {
            this.mEmergencyTime = i3;
        }

        public void setHasHitWeakNetStrategy(boolean z16) {
            this.mHasHitWeakNetStrategy = z16;
        }

        public void setSafePlayTime(int i3) {
            this.mSafePlayTime = i3;
        }

        public String toString() {
            return "PlayerTimeStrategy{mEmergencyTime=" + this.mEmergencyTime + ", mSafePlayTime=" + this.mSafePlayTime + ", mHasHitWeakNetStrategy=" + this.mHasHitWeakNetStrategy + '}';
        }
    }

    private long getWeakNetworkEmergencyTime() {
        return uq3.c.H4();
    }

    private long getWeakNetworkSafePlayTime() {
        return uq3.c.I4();
    }

    private boolean isEnabledWeakNetworkPlayParam() {
        return uq3.c.Z5();
    }

    private boolean isWeakNetworkToPCDN(RFWPlayerOptions rFWPlayerOptions) {
        int i3;
        if (rFWPlayerOptions == null) {
            QLog.d("QFSWeakNetworkPCDNStrategy", 1, "[updateWeakNetworkParamToResult] player options should not be null.");
            return false;
        }
        RFWVideoUrlBean realPlayBean = rFWPlayerOptions.getRealPlayBean();
        if (realPlayBean == null) {
            i3 = 0;
        } else {
            i3 = realPlayBean.mRate;
        }
        if (i3 <= 0) {
            QLog.d("QFSWeakNetworkPCDNStrategy", 1, "[processWeakNetworkPCDNParam] current video bit rate is zero, end flow.");
            return false;
        }
        long predictSpeedWithOutDownGrade = RFWVideoUtils.getPredictSpeedWithOutDownGrade(rFWPlayerOptions.getSceneId());
        if (predictSpeedWithOutDownGrade <= i3 / 8 && predictSpeedWithOutDownGrade > 0) {
            return true;
        }
        return false;
    }

    private boolean shouldAdjust(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions == null) {
            return false;
        }
        if (rFWPlayerOptions.isPreloadPlayer() && rFWPlayerOptions.getFromType() != 10001) {
            return false;
        }
        return true;
    }

    private void updateExpDownOptionParam(SuperPlayerDownOption superPlayerDownOption, int i3) {
        if (superPlayerDownOption == null) {
            QLog.d("QFSWeakNetworkPCDNStrategy", 1, "[updateNotExpDownOptionParam] downOption == null.");
            return;
        }
        QLog.d("QFSWeakNetworkPCDNStrategy", 1, "[updateExpDownOptionParam] pcdnProtectBuffTime: " + i3);
        superPlayerDownOption.pcdnProtectBuffTime = i3;
    }

    private void updateNotExpDownOptionParam(SuperPlayerDownOption superPlayerDownOption) {
        if (superPlayerDownOption == null) {
            QLog.d("QFSWeakNetworkPCDNStrategy", 1, "[updateNotExpDownOptionParam] downOption == null.");
        } else {
            QLog.d("QFSWeakNetworkPCDNStrategy", 1, "[updateNotExpDownOptionParam] hit not exp.");
            superPlayerDownOption.pcdnProtectBuffTime = o.m0(4);
        }
    }

    private void updateWeakNetworkParamToResult(WeakNetworkPCDNStrategyResult weakNetworkPCDNStrategyResult, RFWPlayerOptions rFWPlayerOptions) {
        try {
            int weakNetworkEmergencyTime = (int) getWeakNetworkEmergencyTime();
            int weakNetworkSafePlayTime = (int) getWeakNetworkSafePlayTime();
            weakNetworkPCDNStrategyResult.setEmergencyTime(weakNetworkEmergencyTime);
            weakNetworkPCDNStrategyResult.setSafePlayTime(weakNetworkSafePlayTime);
            QLog.d("QFSWeakNetworkPCDNStrategy", 1, "[updateWeakNetworkParamToResult] emergencyTime: " + weakNetworkEmergencyTime + " | safePlayTime: " + weakNetworkSafePlayTime);
        } catch (Throwable th5) {
            QLog.e("QFSWeakNetworkPCDNStrategy", 1, "[updateWeakNetworkParamToResult] error: ", th5);
        }
    }

    public WeakNetworkPCDNStrategyResult processWeakNetworkPCDNParam(@NonNull RFWPlayerP2PParams rFWPlayerP2PParams, RFWPlayerOptions rFWPlayerOptions, SuperPlayerDownOption superPlayerDownOption, boolean z16) {
        WeakNetworkPCDNStrategyResult weakNetworkPCDNStrategyResult = new WeakNetworkPCDNStrategyResult();
        if (z16 && com.tencent.mobileqq.qcircle.api.utils.c.h()) {
            if (RFWFastCostExp9095.hitExpC()) {
                if (shouldAdjust(rFWPlayerOptions)) {
                    weakNetworkPCDNStrategyResult.setEmergencyTime(rFWPlayerP2PParams.getFastPlayEmergencyTime());
                    weakNetworkPCDNStrategyResult.setSafePlayTime(rFWPlayerP2PParams.getFastPlaySafeTime());
                    updateExpDownOptionParam(superPlayerDownOption, rFWPlayerP2PParams.getPcdnProtectBuffTime());
                }
            } else {
                weakNetworkPCDNStrategyResult.setEmergencyTime(rFWPlayerP2PParams.getFastPlayEmergencyTime());
                weakNetworkPCDNStrategyResult.setSafePlayTime(rFWPlayerP2PParams.getFastPlaySafeTime());
                updateExpDownOptionParam(superPlayerDownOption, rFWPlayerP2PParams.getPcdnProtectBuffTime());
            }
        } else {
            weakNetworkPCDNStrategyResult.setEmergencyTime(rFWPlayerP2PParams.getEmergencyTime());
            weakNetworkPCDNStrategyResult.setSafePlayTime(rFWPlayerP2PParams.getSafePlayTime());
            updateNotExpDownOptionParam(superPlayerDownOption);
        }
        if (!isEnabledWeakNetworkPlayParam()) {
            return weakNetworkPCDNStrategyResult;
        }
        if (!isWeakNetworkToPCDN(rFWPlayerOptions)) {
            return weakNetworkPCDNStrategyResult;
        }
        weakNetworkPCDNStrategyResult.setHasHitWeakNetStrategy(true);
        updateWeakNetworkParamToResult(weakNetworkPCDNStrategyResult, rFWPlayerOptions);
        return weakNetworkPCDNStrategyResult;
    }
}
