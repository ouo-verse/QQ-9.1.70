package com.tencent.biz.richframework.video.rfw.player;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWFastCostExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPlayerBusinessStrategyExp9095;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWVideoFluencyExp9095;
import java.util.Arrays;
import java.util.Map;
import uq3.c;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWPlayerP2PParams {
    private int mEmergencyTime;
    private int mEmergencyTimeForPrePlay;
    private boolean mEnableP2P;
    private boolean mEnablePCDN;
    private final boolean mEnablePreloadP2P;
    private final boolean mEnablePreloadPCDN;
    private int mFastPlayEmergencyTime;
    private String mFastPlayExpName;
    private int mFastPlaySafeTime;
    private int mInitiativeResetTime;
    private int mPassivityResetTime;
    private int mPcdnProtectBuffTime;
    private int mSafePlayTime;
    private int mSafePlayTimeForPrePlay;

    public RFWPlayerP2PParams() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (c.Y0("qqcircle", "qqcircle_video_enable_preload_p2p", 0, false).intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mEnablePreloadP2P = z16;
        if (c.Y0("qqcircle", "qqcircle_video_enable_preload_pcdn", 1, false).intValue() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.mEnablePreloadPCDN = z17;
        if (c.Y0("qqcircle", "qqcircle_video_enable_p2p", 0, false).intValue() == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.mEnableP2P = z18;
        this.mEnablePCDN = c.Y0("qqcircle", "qqcircle_video_enable_pcdn", 0, false).intValue() == 1;
        this.mEmergencyTime = c.Y0("qqcircle", "qqcircle_video_play_emergence_time", 5, false).intValue();
        this.mSafePlayTime = c.Y0("qqcircle", "qqcircle_video_play_safe_time", 20, false).intValue();
        this.mEmergencyTimeForPrePlay = c.Y0("qqcircle", "qqcircle_video_play_emergence_preload_time", 5, false).intValue();
        this.mSafePlayTimeForPrePlay = c.Y0("qqcircle", "qqcircle_video_play_safe_preload_time", 10, false).intValue();
        updatePlayerBusinessStrategyParam();
        updatePlayCostExpParam();
    }

    private boolean isHitPCDNBlackList(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String l06 = o.l0("photovideo-circle.photo.qq.com|");
            if (TextUtils.isEmpty(l06)) {
                return false;
            }
            return Arrays.asList(l06.split("\\|")).contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    private void updatePlayerBusinessStrategyParam() {
        String expName = RFWPlayerBusinessStrategyExp9095.getExpName();
        Map<String, String> expParam = RFWPlayerBusinessStrategyExp9095.getExpParam();
        if (!TextUtils.isEmpty(expName) && expParam != null && !expParam.isEmpty()) {
            try {
                String str = expParam.get("emergencyTime");
                String str2 = expParam.get("safePlayTime");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    this.mEmergencyTime = Integer.parseInt(str);
                    this.mSafePlayTime = Integer.parseInt(str2);
                    RFWLog.d("RFWPlayerP2PParams", RFWLog.DEV, "[updatePlayerBusinessStrategyParam] mEmergencyTime: " + this.mEmergencyTime + " | mSafePlayTime: " + this.mSafePlayTime);
                }
            } catch (Throwable th5) {
                RFWLog.d("RFWPlayerP2PParams", RFWLog.USR, "[updatePlayerBusinessStrategyParam] ex: ", th5);
            }
        }
    }

    public int getEmergencyTime() {
        return this.mEmergencyTime;
    }

    public int getEmergencyTimeForPrePlay() {
        return this.mEmergencyTimeForPrePlay;
    }

    public int getFastPlayEmergencyTime() {
        return this.mFastPlayEmergencyTime;
    }

    public String getFastPlayExpName() {
        return this.mFastPlayExpName;
    }

    public int getFastPlaySafeTime() {
        return this.mFastPlaySafeTime;
    }

    public int getInitiativeResetTime() {
        return this.mInitiativeResetTime;
    }

    public int getPassivityResetTime() {
        return this.mPassivityResetTime;
    }

    public int getPcdnProtectBuffTime() {
        return this.mPcdnProtectBuffTime;
    }

    public int getSafePlayTime() {
        return this.mSafePlayTime;
    }

    public int getSafePlayTimeForPrePlay() {
        return this.mSafePlayTimeForPrePlay;
    }

    public boolean isEnableP2P() {
        return this.mEnableP2P;
    }

    public boolean isEnablePCDN() {
        return this.mEnablePCDN && RFWVideoFluencyExp9095.enablePCDN();
    }

    public boolean isEnablePreloadP2P() {
        return this.mEnablePreloadP2P;
    }

    public boolean isEnablePreloadPCDN() {
        return this.mEnablePreloadPCDN && RFWVideoFluencyExp9095.enablePCDN();
    }

    public RFWPlayerP2PParams setEmergencyTime(int i3) {
        if (i3 == -1) {
            i3 = c.X0("qqcircle", "qqcircle_video_play_emergence_time", 5).intValue();
        }
        this.mEmergencyTime = i3;
        return this;
    }

    public RFWPlayerP2PParams setEmergencyTimeForPrePlay(int i3) {
        if (i3 == -1) {
            i3 = c.X0("qqcircle", "qqcircle_video_play_emergence_preload_time", 5).intValue();
        }
        this.mEmergencyTimeForPrePlay = i3;
        return this;
    }

    public RFWPlayerP2PParams setEnableP2P(boolean z16) {
        this.mEnableP2P = z16;
        return this;
    }

    public RFWPlayerP2PParams setEnablePCDN(boolean z16) {
        this.mEnablePCDN = z16;
        return this;
    }

    public RFWPlayerP2PParams setSafePlayTime(int i3) {
        if (i3 == -1) {
            i3 = c.X0("qqcircle", "qqcircle_video_play_safe_time", 20).intValue();
        }
        this.mSafePlayTime = i3;
        return this;
    }

    public RFWPlayerP2PParams setSafeTimeForPrePlay(int i3) {
        if (i3 == -1) {
            i3 = c.X0("qqcircle", "qqcircle_video_play_safe_preload_time", 10).intValue();
        }
        this.mSafePlayTimeForPrePlay = i3;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("QFSPlayerP2PParams{");
        stringBuffer.append("mEnablePreloadP2P=");
        stringBuffer.append(this.mEnablePreloadP2P);
        stringBuffer.append(",mEnablePreloadPCDN=");
        stringBuffer.append(this.mEnablePreloadPCDN);
        stringBuffer.append(", mEnableP2P=");
        stringBuffer.append(this.mEnableP2P);
        stringBuffer.append(", mEnablePCDN=");
        stringBuffer.append(this.mEnablePCDN);
        stringBuffer.append(", mEmergencyTime=");
        stringBuffer.append(this.mEmergencyTime);
        stringBuffer.append(", mSafePlayTime=");
        stringBuffer.append(this.mSafePlayTime);
        stringBuffer.append(", mEmergencyTimeForPrePlay=");
        stringBuffer.append(this.mEmergencyTimeForPrePlay);
        stringBuffer.append(", mSafePlayTimeForPrePlay=");
        stringBuffer.append(this.mSafePlayTimeForPrePlay);
        stringBuffer.append(", mFastPlayEmergencyTime=");
        stringBuffer.append(this.mFastPlayEmergencyTime);
        stringBuffer.append(", mFastPlaySafeTime=");
        stringBuffer.append(this.mFastPlaySafeTime);
        stringBuffer.append(", mFastPlayExpName=");
        stringBuffer.append(this.mFastPlayExpName);
        stringBuffer.append(", mInitiativeResetTime=");
        stringBuffer.append(this.mInitiativeResetTime);
        stringBuffer.append(", mPassivityResetTime=");
        stringBuffer.append(this.mPassivityResetTime);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public void updatePlayCostExpParam() {
        int i3;
        int i16;
        String expName = RFWFastCostExp9095.getExpName();
        Map<String, String> expParam = RFWFastCostExp9095.getExpParam();
        if (!TextUtils.isEmpty(expName) && expParam != null && !expParam.isEmpty()) {
            try {
                String str = expParam.get("emergencyTime95");
                String str2 = expParam.get("safePlayTime95");
                String str3 = expParam.get("initiativeResetTime95");
                String str4 = expParam.get("passivityResetTime95");
                String str5 = expParam.get("pcdnProtectBuffTime95");
                if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
                    this.mFastPlayEmergencyTime = Integer.parseInt(str);
                    this.mFastPlaySafeTime = Integer.parseInt(str2);
                    int i17 = 3000;
                    if (str3 != null && !str3.isEmpty()) {
                        i3 = Integer.parseInt(str3);
                        this.mInitiativeResetTime = i3;
                        if (str4 != null && !str4.isEmpty()) {
                            i17 = Integer.parseInt(str4);
                        }
                        this.mPassivityResetTime = i17;
                        if (str5 != null && !str5.isEmpty()) {
                            i16 = Integer.parseInt(str5);
                            this.mPcdnProtectBuffTime = i16;
                            RFWLog.d("RFWPlayerP2PParams", RFWLog.DEV, "[updatePlayCostExpParam] mFastPlayEmergencyTime: " + this.mFastPlayEmergencyTime + " | mFastPlaySafeTime: " + this.mFastPlaySafeTime + " | mInitiativeResetTime:" + this.mInitiativeResetTime + " | mPassivityResetTime: " + this.mPassivityResetTime + " | mPcdnProtectBuffTime: " + this.mPcdnProtectBuffTime);
                            this.mFastPlayExpName = expName;
                        }
                        i16 = 4;
                        this.mPcdnProtectBuffTime = i16;
                        RFWLog.d("RFWPlayerP2PParams", RFWLog.DEV, "[updatePlayCostExpParam] mFastPlayEmergencyTime: " + this.mFastPlayEmergencyTime + " | mFastPlaySafeTime: " + this.mFastPlaySafeTime + " | mInitiativeResetTime:" + this.mInitiativeResetTime + " | mPassivityResetTime: " + this.mPassivityResetTime + " | mPcdnProtectBuffTime: " + this.mPcdnProtectBuffTime);
                        this.mFastPlayExpName = expName;
                    }
                    i3 = 3000;
                    this.mInitiativeResetTime = i3;
                    if (str4 != null) {
                        i17 = Integer.parseInt(str4);
                    }
                    this.mPassivityResetTime = i17;
                    if (str5 != null) {
                        i16 = Integer.parseInt(str5);
                        this.mPcdnProtectBuffTime = i16;
                        RFWLog.d("RFWPlayerP2PParams", RFWLog.DEV, "[updatePlayCostExpParam] mFastPlayEmergencyTime: " + this.mFastPlayEmergencyTime + " | mFastPlaySafeTime: " + this.mFastPlaySafeTime + " | mInitiativeResetTime:" + this.mInitiativeResetTime + " | mPassivityResetTime: " + this.mPassivityResetTime + " | mPcdnProtectBuffTime: " + this.mPcdnProtectBuffTime);
                        this.mFastPlayExpName = expName;
                    }
                    i16 = 4;
                    this.mPcdnProtectBuffTime = i16;
                    RFWLog.d("RFWPlayerP2PParams", RFWLog.DEV, "[updatePlayCostExpParam] mFastPlayEmergencyTime: " + this.mFastPlayEmergencyTime + " | mFastPlaySafeTime: " + this.mFastPlaySafeTime + " | mInitiativeResetTime:" + this.mInitiativeResetTime + " | mPassivityResetTime: " + this.mPassivityResetTime + " | mPcdnProtectBuffTime: " + this.mPcdnProtectBuffTime);
                    this.mFastPlayExpName = expName;
                }
            } catch (Throwable th5) {
                RFWLog.d("RFWPlayerP2PParams", RFWLog.USR, "[updatePlayCostExpParam] ex: ", th5);
            }
        }
    }

    public boolean isEnablePCDN(String str) {
        return !isHitPCDNBlackList(str) && isEnablePCDN();
    }

    public boolean isEnablePreloadPCDN(String str) {
        return !isHitPCDNBlackList(str) && isEnablePreloadPCDN();
    }
}
