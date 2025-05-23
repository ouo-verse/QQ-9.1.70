package com.tencent.mobileqq.dpc.api.impl;

import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RespGetConfig;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class DPCApiImpl implements IDPCApi {
    static IPatchRedirector $redirector_ = null;
    private static final String LOAD_DPC_TOGGLE = "load_dpc_toggle";
    private static final String SDCARD_MIGRATE_TOGGLE = "qq_richstatus_sdcard_migrate";

    public DPCApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public void addObserver(DPCObserver dPCObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) dPCObserver);
        } else {
            DeviceProfileManager.addObserver(dPCObserver);
        }
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public ConfigurationService$ReqGetConfig buidldReqConfig(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ConfigurationService$ReqGetConfig) iPatchRedirector.redirect((short) 16, (Object) this, (Object) appRuntime);
        }
        return DeviceProfileManager.buidldReqConfig(appRuntime);
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public int getAbRamdom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return DeviceProfileManager.getInstance().mAbRamdom;
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public String getFeatureValue(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? DeviceProfileManager.getInstance().getFeatureValue(str) : (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public String getFeatureValueWithoutAccountManager(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? DeviceProfileManager.getInstanceWithoutAccountManager().getFeatureValue(str) : (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public int getMaxAbRamdom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 10000;
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public int getServerDataCurrentState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return DeviceProfileManager.getInstance().getServerDataCurrentState();
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public int getServerDataCurrentStateWithoutAccountManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return DeviceProfileManager.getInstanceWithoutAccountManager().getServerDataCurrentState();
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public boolean isFeatureSupported(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? DeviceProfileManager.getInstance().isFeatureSupported(str) : ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public boolean isInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return DeviceProfileManager.isInited;
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public boolean isLoadDpcSpToggleEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public boolean isRichStatusToggleEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public void nextServerDataState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            DeviceProfileManager.getInstance().nextServerDataState(i3);
        }
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public boolean onDPCResponse(ConfigurationService$RespGetConfig configurationService$RespGetConfig, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) configurationService$RespGetConfig, (Object) str)).booleanValue();
        }
        return DeviceProfileManager.getInstance().onDPCResponse(configurationService$RespGetConfig, str);
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public int parseComplexParamsBySimpleStringParser(String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) strArr)).intValue();
        }
        return DeviceProfileManager.parseComplexParams(str, strArr, new DeviceProfileManager.SimpleStringParser());
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public int parseComplexParamsByStringToIntParser(String str, Integer[] numArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) numArr)).intValue();
        }
        return DeviceProfileManager.parseComplexParams(str, numArr, new DeviceProfileManager.StringToIntParser());
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public void registerBroadCast(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) appRuntime);
        } else {
            DeviceProfileManager.getInstance(appRuntime).registerBroadCast(appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public void removeObserver(DPCObserver dPCObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) dPCObserver);
        } else {
            DeviceProfileManager.removeObserver(dPCObserver);
        }
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public void unRegisterBroadCast(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) appRuntime);
        } else {
            DeviceProfileManager.getInstance(appRuntime).unRegisterBroadCast(appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public String getFeatureValue(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? DeviceProfileManager.getInstance().getFeatureValue(str, str2) : (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public String getFeatureValueWithoutAccountManager(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? DeviceProfileManager.getInstanceWithoutAccountManager().getFeatureValue(str, str2) : (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
    }

    @Override // com.tencent.mobileqq.dpc.api.IDPCApi
    public boolean isFeatureSupported(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? DeviceProfileManager.getInstance().isFeatureSupported(str, j3) : ((Boolean) iPatchRedirector.redirect((short) 8, this, str, Long.valueOf(j3))).booleanValue();
    }
}
