package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import com.tencent.mobileqq.config.business.MiniAppApiReportConfigParser;
import com.tencent.mobileqq.minigame.config.MiniGameConfig;
import com.tencent.mobileqq.minigame.config.MiniGameSDKConfig;
import com.tencent.mobileqq.minigame.manager.FileDownloadManager;
import com.tencent.mobileqq.minigame.utils.FeatureSwitchUtils;
import com.tencent.mobileqq.qqfeatureswitch.FeatureSwitch;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import common.config.service.QzoneConfig;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@ProxyService(proxy = WnsConfigProxy.class)
/* loaded from: classes34.dex */
public class ch extends WnsConfigProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public String getConfig(String str, String str2) {
        if ("qqtriton".equals(str) && "MiniGameCodeCacheEnable".equals(str2)) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105526", false);
            QLog.d("WnsConfigProxyImpl", 2, "mini game code cache enable:" + isSwitchOn);
            if (isSwitchOn) {
                return "true";
            }
            return "false";
        }
        return QzoneConfig.getInstance().getConfig(str, str2);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public long getGameInnerTimeoutSetting(boolean z16) {
        int secondGameFixDuration;
        long j3;
        MiniGameSDKConfig miniGameSDKConfig = (MiniGameSDKConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameSDKConfig.CONFIG_ID);
        if (miniGameSDKConfig == null) {
            j3 = z16 ? 60L : 30L;
        } else {
            if (z16) {
                secondGameFixDuration = miniGameSDKConfig.getFirstGameFixDuration();
            } else {
                secondGameFixDuration = miniGameSDKConfig.getSecondGameFixDuration();
            }
            j3 = secondGameFixDuration;
        }
        return j3 * 1000;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public int getMiniFileDownloadType() {
        return FileDownloadManager.getDownloadType();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public String getMiniGameEnginePackageConfig() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public boolean getNotchIgnoreEnable(boolean z16) {
        MiniGameConfig miniGameConfig = (MiniGameConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameConfig.CONFIG_ID);
        return miniGameConfig != null ? miniGameConfig.getIsNotchEnable() : z16;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public boolean getToggleEnableStatus(String str, boolean z16) {
        return FeatureSwitchUtils.INSTANCE.isFeatureSwitchEnable(str, z16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public boolean getWebgl2Enable(String str, boolean z16) {
        String loadAsString;
        JSONArray optJSONArray;
        try {
            loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("101479", "");
            if (QLog.isDebugVersion()) {
                QLog.i("WnsConfigProxyImpl", 2, "getWebgl2Enable: appId=" + str + ", config=" + loadAsString);
            }
        } catch (Exception e16) {
            QLog.e("WnsConfigProxyImpl", 1, "getWebgl2Enable: exception=", e16);
        }
        if (!TextUtils.isEmpty(loadAsString) && (optJSONArray = new JSONObject(loadAsString).optJSONArray("appIdList")) != null && optJSONArray.length() != 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                if (str.equals(optJSONArray.getString(i3))) {
                    return true;
                }
            }
            return z16;
        }
        return z16;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public boolean isWebAudioEnable() {
        FeatureSwitch featureSwitch;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (featureSwitch = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getFeatureSwitch("minigame_webaudio_gray")) == null) {
            return false;
        }
        if (QLog.isDebugVersion()) {
            QLog.i("WnsConfigProxyImpl", 4, "isWebAudioEnable result=" + featureSwitch);
        }
        return featureSwitch.mSwitchEnable;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public List<String> getApiReportConfig() {
        try {
            com.tencent.mobileqq.config.business.y c16 = MiniAppApiReportConfigParser.c();
            if (c16 != null) {
                return c16.a();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
