package com.tencent.mobileqq.qqlive.api.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.business.QQLiveConfigConst;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.data.config.CustomData;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveSDKConfigHelper {
    static IPatchRedirector $redirector_ = null;
    public static final int LIVE_APP_BUSINESS_ID_GAME = 10001;
    public static final int LIVE_APP_BUSINESS_ID_GAME_NEW = 10011;
    public static final int LIVE_APP_BUSINESS_ID_OD = 10013;
    public static final int LIVE_APP_BUSINESS_ID_QQLIVE = 10008;
    public static final int MULTI_AV_CHAT_SCENE_ID = 10014;

    public QQLiveSDKConfigHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getClientType() {
        return QQLiveConfigConst.CLIENT_TYPE;
    }

    public static QQLiveSDKConfig getDefIQQLiveSDK() {
        ConfigData build = ConfigData.createBuilder().setLiveAppId(getQQLiveAppId()).setLiveClientType(getClientType()).setPullMsgClientType(getPullMsgClientType()).setTrtcAppId(getTrtcSdkAPPId()).setOpenSdkAppId(QQLiveConfigConst.OPEN_SDK_APP_ID).setSmartEyeAppId("").setLiveAppKey(QQLiveConfigConst.APP_KEY).build();
        CustomData customData = new CustomData();
        customData.liveVerifyUrl = QQLiveConfigConst.KAIYANG_VERIFY_URL;
        return QQLiveSDKConfig.createBuilder().appConfig(build).customData(customData).build();
    }

    public static String getLoginAuthAppId() {
        return QQLiveConfigConst.LOGIN_AUTH_APPID;
    }

    public static String getLoginExtData() {
        return QQLiveConfigConst.LOGIN_EXT_DATA;
    }

    public static int getMultiAvChatSceneId() {
        return 10014;
    }

    public static int getPullMsgClientType() {
        return QQLiveConfigConst.PULL_MSG_CLIENT_TYPE;
    }

    public static String getQQLiveAppId() {
        return QQLiveConfigConst.APP_ID;
    }

    public static int getSceneId() {
        return 10008;
    }

    public static int getSceneIdByRoomType(int i3) {
        if (i3 == 1) {
            return 10011;
        }
        if (i3 == 2) {
            return 10013;
        }
        return 10008;
    }

    public static String getSupportProductType() {
        return "1";
    }

    public static String getTrtcSdkAPPId() {
        return QQLiveConfigConst.TRTC_SDK_APP_ID;
    }
}
