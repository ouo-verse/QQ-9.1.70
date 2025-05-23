package com.tencent.mobileqq.icgame.api.impl;

import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.icgame.data.config.ConfigData;
import java.util.HashMap;

/* compiled from: P */
@Deprecated
/* loaded from: classes15.dex */
public class QQLiveConfigModule implements IQQLiveConfigModule {
    private static final ConfigData CONFIG_DEFAULT = ConfigData.createBuilder().setLiveAppId("0").setLiveClientType(0).setLiveAppKey("0").setOpenSdkAppId("0").setTrtcAppId("0").setSmartEyeAppId("0").build();
    private static final HashMap<String, ConfigData> CONFIG_MAPS;
    private static final ConfigData CONFIG_QQ_LIVE;
    private ConfigData configData;

    static {
        ConfigData.Builder createBuilder = ConfigData.createBuilder();
        String str = r22.a.f430572a;
        ConfigData build = createBuilder.setLiveAppId(str).setLiveAppKey(r22.a.f430575d).setLiveClientType(r22.a.f430576e).setOpenSdkAppId(r22.a.f430578g).setTrtcAppId(r22.a.f430579h).setSmartEyeAppId("").setLoginAuthAppid(r22.a.f430574c).build();
        CONFIG_QQ_LIVE = build;
        HashMap<String, ConfigData> hashMap = new HashMap<>();
        CONFIG_MAPS = hashMap;
        hashMap.put(str, build);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        this.configData = null;
    }

    @Override // com.tencent.mobileqq.icgame.api.config.IQQLiveConfigModule
    public ConfigData getConfigData() {
        return this.configData;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        init(iQQLiveSDK, null);
    }

    @Override // com.tencent.mobileqq.icgame.api.config.IQQLiveConfigModule
    public void init(IQQLiveSDK iQQLiveSDK, ConfigData configData) {
        if (configData == null) {
            ConfigData configData2 = CONFIG_MAPS.get(iQQLiveSDK.getAppId());
            this.configData = configData2;
            if (configData2 == null) {
                this.configData = CONFIG_DEFAULT;
                return;
            }
            return;
        }
        this.configData = configData;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
    }
}
