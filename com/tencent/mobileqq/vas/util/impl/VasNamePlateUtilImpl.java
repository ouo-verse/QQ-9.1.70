package com.tencent.mobileqq.vas.util.impl;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.util.IVasNamePlateUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class VasNamePlateUtilImpl implements IVasNamePlateUtil {
    public static final String TAG = "VasNamePlateUtilImpl";
    public static final String WILDCARD = "1000000";
    private List<IVasNamePlateUtil.VipIconClickConfig> mConfigs = null;

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public List<IVasNamePlateUtil.VipIconClickConfig> buildConfigs(boolean z16) {
        String obtainNpJumpUrl;
        ArrayList arrayList = new ArrayList();
        try {
            obtainNpJumpUrl = ((IVasNamePlateUtil) QRoute.api(IVasNamePlateUtil.class)).obtainNpJumpUrl(VasUtil.getApp(), IVasNamePlateUtil.VIP_NP_KEY);
            if (TextUtils.isEmpty(obtainNpJumpUrl)) {
                QLog.e(TAG, 1, "vas_namepaltem,toggele_get_error");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e(TAG, 1, "vas_namepaltem,jump_parse_error:" + e16.getMessage());
        }
        if (TextUtils.isEmpty(obtainNpJumpUrl)) {
            return null;
        }
        JSONArray jSONArray = new JSONObject(obtainNpJumpUrl).getJSONArray("namePlateUrlConfig");
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            IVasNamePlateUtil.VipIconClickConfig vipIconClickConfig = new IVasNamePlateUtil.VipIconClickConfig();
            vipIconClickConfig.vipType = jSONObject.optString("vipType");
            vipIconClickConfig.itemId = jSONObject.optString("itemId");
            vipIconClickConfig.drawerUrl = jSONObject.optString("drawerUrl");
            vipIconClickConfig.vaProfileUrl = jSONObject.optString("VaProfileUrl");
            vipIconClickConfig.ctocUrl = jSONObject.optString("ctocUrl");
            vipIconClickConfig.nameplateType = jSONObject.optString("nameplateType");
            vipIconClickConfig.vaProfileGuestUrl = jSONObject.optString("VaProfileGuestUrl");
            vipIconClickConfig.ctocGuestUrl = jSONObject.optString("ctocGuestUrl");
            vipIconClickConfig.ctocSettingUrl = jSONObject.optString("ctocSettingUrl");
            vipIconClickConfig.ctocSettingGuestUrl = jSONObject.optString("ctocSettingGuestUrl");
            arrayList.add(vipIconClickConfig);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.vas.util.IVasNamePlateUtil
    public IVasNamePlateUtil.VipIconClickConfig findConfig(int i3, int i16, int i17) {
        if (this.mConfigs == null) {
            synchronized (this) {
                if (this.mConfigs == null) {
                    this.mConfigs = buildConfigs(false);
                }
            }
        }
        List<IVasNamePlateUtil.VipIconClickConfig> list = this.mConfigs;
        IVasNamePlateUtil.VipIconClickConfig vipIconClickConfig = null;
        if (list == null) {
            return null;
        }
        for (IVasNamePlateUtil.VipIconClickConfig vipIconClickConfig2 : list) {
            if (vipIconClickConfig2.vipType.equals(String.valueOf(i3)) && vipIconClickConfig2.nameplateType.equals(String.valueOf(i17))) {
                if (vipIconClickConfig2.itemId.equals(String.valueOf(i16))) {
                    return vipIconClickConfig2;
                }
                if (vipIconClickConfig2.itemId.equals(WILDCARD)) {
                    vipIconClickConfig = vipIconClickConfig2;
                }
            }
        }
        return vipIconClickConfig;
    }

    @Override // com.tencent.mobileqq.vas.util.IVasNamePlateUtil
    public String obtainNpJumpUrl(AppRuntime appRuntime, String str) {
        if (appRuntime == null || TextUtils.isEmpty(str)) {
            return "";
        }
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        boolean isFeatureSwitchEnable = iFeatureRuntimeService.isFeatureSwitchEnable(IVasNamePlateUtil.FEATURE_NAME);
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService.isEnabledWithDataSet(IVasNamePlateUtil.FEATURE_NAME, "");
        if (!isFeatureSwitchEnable || isEnabledWithDataSet == null || isEnabledWithDataSet.isEmpty()) {
            return "";
        }
        return isEnabledWithDataSet.get(str);
    }

    @Override // com.tencent.mobileqq.vas.util.IVasNamePlateUtil
    public void preBuildConfig(final boolean z16) {
        if (this.mConfigs != null) {
            return;
        }
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.vas.util.impl.VasNamePlateUtilImpl.1
            @Override // java.lang.Runnable
            public void run() {
                List buildConfigs = VasNamePlateUtilImpl.this.buildConfigs(z16);
                if (buildConfigs == null) {
                    return;
                }
                synchronized (VasNamePlateUtilImpl.this) {
                    VasNamePlateUtilImpl.this.mConfigs = buildConfigs;
                }
            }
        });
    }
}
