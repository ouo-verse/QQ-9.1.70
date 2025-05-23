package com.tencent.mobileqq.dpc.api.impl;

import android.content.SharedPreferences;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.imcore.message.an;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCAccountService;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class DPCAccountServiceImpl implements IDPCAccountService {
    static IPatchRedirector $redirector_;
    public static HashSet<String> accountDpcNames;
    private String currentUinMD5;
    public AppRuntime mApp;
    public HashMap<String, DeviceProfileManager.DPCConfigInfo> mFeatureAccountMapLV2;
    public HashMap<String, DeviceProfileManager.DPCConfigInfo> mFeatureDefaultAccountMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34511);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            accountDpcNames = new HashSet<>();
        }
    }

    public DPCAccountServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mFeatureAccountMapLV2 = new HashMap<>();
            this.mFeatureDefaultAccountMap = new HashMap<>();
        }
    }

    public static String buildAccountDpcSPName(AppRuntime appRuntime, String str) {
        if (appRuntime == null) {
            return "";
        }
        return an.a(appRuntime.getAccount()) + "_" + str;
    }

    private void doOnCreate(AppRuntime appRuntime) {
        boolean z16;
        this.mApp = appRuntime;
        try {
            this.currentUinMD5 = an.a(appRuntime.getAccount());
        } catch (NoClassDefFoundError e16) {
            e16.printStackTrace();
        }
        if (MobileQQ.sProcessId != 9) {
            z16 = true;
        } else {
            z16 = false;
        }
        init(z16);
    }

    private void init(boolean z16) {
        DeviceProfileManager.DPCConfigInfo dPCConfigInfo;
        initDefaultValue();
        if (!z16) {
            return;
        }
        SharedPreferences mMKVMigratedSharePreferencesSync = QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(this.mApp.getApplicationContext(), IDPCApiConstant.DPCCONFIG_ACCOUNT_SHAREPRE_NAME, 4);
        for (DPCAccountNames dPCAccountNames : DPCAccountNames.values()) {
            String buildAccountDpcName = buildAccountDpcName(dPCAccountNames.name());
            String string = mMKVMigratedSharePreferencesSync.getString(buildAccountDpcName, "");
            if ("".equals(string)) {
                dPCConfigInfo = (DeviceProfileManager.DPCConfigInfo) this.mFeatureDefaultAccountMap.get(buildAccountDpcName).clone();
            } else {
                dPCConfigInfo = new DeviceProfileManager.DPCConfigInfo();
                DeviceProfileManager.buildDPCConfigValue(dPCConfigInfo, string);
            }
            this.mFeatureAccountMapLV2.put(buildAccountDpcName, dPCConfigInfo);
            if (QLog.isColorLevel()) {
                QLog.i(DeviceProfileManager.TAG, 2, "init loop mFeatureMapLV2_account MAP: " + buildAccountDpcName + ContainerUtils.KEY_VALUE_DELIMITER + dPCConfigInfo.toString());
            }
        }
    }

    private void initDefaultValue() {
        for (DPCAccountNames dPCAccountNames : DPCAccountNames.values()) {
            this.mFeatureDefaultAccountMap.put(buildAccountDpcName(dPCAccountNames.name()), new DeviceProfileManager.DPCConfigInfo());
            accountDpcNames.add(dPCAccountNames.name());
        }
    }

    public String buildAccountDpcName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return this.currentUinMD5 + "_" + str;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            doOnCreate(appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(DeviceProfileManager.TAG, 2, "AccountDpcManager onDestroy()");
        }
        synchronized (DeviceProfileManager.getInstance()) {
            DeviceProfileManager.sAccountDpcService = null;
            this.mApp = null;
            DeviceProfileManager.getInstance().nextServerDataState(1);
        }
    }
}
