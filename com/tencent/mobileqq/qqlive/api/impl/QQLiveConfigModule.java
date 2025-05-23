package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.business.QQLiveConfigConst;
import com.tencent.mobileqq.qqlive.business.a;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import java.util.HashMap;

/* compiled from: P */
@Deprecated
/* loaded from: classes17.dex */
public class QQLiveConfigModule implements IQQLiveConfigModule {
    static IPatchRedirector $redirector_;
    private static final ConfigData CONFIG_DEFAULT;
    private static final ConfigData CONFIG_GUILD;
    private static final HashMap<String, ConfigData> CONFIG_MAPS;
    private static final ConfigData CONFIG_QQ_LIVE;
    private ConfigData configData;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60779);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        CONFIG_DEFAULT = ConfigData.createBuilder().setLiveAppId("0").setLiveClientType(0).setLiveAppKey("0").setOpenSdkAppId("0").setTrtcAppId("0").setSmartEyeAppId("0").build();
        ConfigData.Builder createBuilder = ConfigData.createBuilder();
        String str = QQLiveConfigConst.APP_ID;
        ConfigData build = createBuilder.setLiveAppId(str).setLiveAppKey(QQLiveConfigConst.APP_KEY).setLiveClientType(QQLiveConfigConst.CLIENT_TYPE).setOpenSdkAppId(QQLiveConfigConst.OPEN_SDK_APP_ID).setTrtcAppId(QQLiveConfigConst.TRTC_SDK_APP_ID).setSmartEyeAppId("").build();
        CONFIG_QQ_LIVE = build;
        ConfigData.Builder createBuilder2 = ConfigData.createBuilder();
        String str2 = a.f271158a;
        ConfigData build2 = createBuilder2.setLiveAppId(str2).setLiveAppKey(a.f271159b).setLiveClientType(a.f271160c).setOpenSdkAppId(a.f271161d).setTrtcAppId(a.f271162e).setSmartEyeAppId("IDA2bMIY").build();
        CONFIG_GUILD = build2;
        HashMap<String, ConfigData> hashMap = new HashMap<>();
        CONFIG_MAPS = hashMap;
        hashMap.put(str, build);
        hashMap.put(str2, build2);
    }

    public QQLiveConfigModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.configData = null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule
    public ConfigData getConfigData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ConfigData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.configData;
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init(iQQLiveSDK, null);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iQQLiveSDK);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule
    public void init(IQQLiveSDK iQQLiveSDK, ConfigData configData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iQQLiveSDK, (Object) configData);
            return;
        }
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
}
