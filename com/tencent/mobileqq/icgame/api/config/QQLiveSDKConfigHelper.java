package com.tencent.mobileqq.icgame.api.config;

import com.tencent.mobileqq.icgame.data.config.ConfigData;
import com.tencent.mobileqq.icgame.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qqlive.business.QQLiveConfigConst;
import com.tencent.mobileqq.qqlive.data.config.CustomData;
import r22.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveSDKConfigHelper {
    public static final int LIVE_APP_BUSINESS_ID_IC_GAME = 10015;
    public static final int LIVE_APP_BUSINESS_ID_QQLIVE = 10008;

    public static int getClientType() {
        return a.f430576e;
    }

    public static QQLiveSDKConfig getDefIQQLiveSDK() {
        ConfigData build = ConfigData.createBuilder().setLiveAppId(getQQLiveAppId()).setLiveClientType(getClientType()).setPullMsgClientType(getPullMsgClientType()).setTrtcAppId(getTrtcSdkAPPId()).setOpenSdkAppId(a.f430578g).setSmartEyeAppId("").setLiveAppKey(a.f430575d).setLoginAuthAppid(getLoginAuthAppId()).build();
        CustomData customData = new CustomData();
        customData.liveVerifyUrl = QQLiveConfigConst.KAIYANG_VERIFY_URL;
        return QQLiveSDKConfig.createBuilder().appConfig(build).customData(customData).build();
    }

    public static String getLoginAuthAppId() {
        return a.f430574c;
    }

    public static String getLoginExtData() {
        return a.f430573b;
    }

    public static int getPullMsgClientType() {
        return a.f430577f;
    }

    public static String getQQLiveAppId() {
        return a.f430572a;
    }

    public static int getSceneId() {
        return 10015;
    }

    public static int getSceneIdByRoomType(int i3) {
        return 10015;
    }

    public static String getTrtcSdkAPPId() {
        return a.f430579h;
    }
}
