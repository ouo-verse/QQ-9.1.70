package com.tencent.mobileqq.vas.config.business;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Keep
/* loaded from: classes20.dex */
public class QVipHippyConfig {
    public static final boolean ENABLE_CONFIG = VasLongToggle.VAS_SETTING_VIP_HIPPY_BUNDLE_SWITCH.isEnable(false);
    private static final String TAG = "QVipHippyConfig";
    private static final ArrayList<String> superModuleNames;
    public String configUrl;
    public LinkedTreeMap<String, HippyInfo> map;

    /* compiled from: P */
    @Keep
    /* loaded from: classes20.dex */
    public static class HippyInfo {
        public String[] enableDomain;
        public OpenHippyInfo openParams;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends TypeToken<OpenHippyInfo> {
        a() {
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        superModuleNames = arrayList;
        arrayList.add(HippyQQConstants.ModuleName.QQ_VIP);
        arrayList.add(HippyQQConstants.ModuleName.QQ_PERSONALITY);
        arrayList.add(HippyQQConstants.ModuleName.QQ_VIP_SSR);
        arrayList.add(HippyQQConstants.ModuleName.QQ_VAS_GUIDE_MODULE);
        arrayList.add(HippyQQConstants.ModuleName.QQ_VIP_PAY);
        arrayList.add(HippyQQConstants.ModuleName.QQ_SPORT);
        arrayList.add(HippyQQConstants.ModuleName.QQ_WEATHER);
        arrayList.add(HippyQQConstants.ModuleName.QQ_VIP_READER);
    }

    public QVipHippyConfig(@NonNull LinkedTreeMap<String, HippyInfo> linkedTreeMap) {
        HippyInfo hippyInfo;
        OpenHippyInfo openHippyInfo;
        this.configUrl = "";
        this.map = linkedTreeMap;
        String vipBundleName = getVipBundleName();
        if (vipBundleName != HippyQQConstants.ModuleName.QQ_VIP && (hippyInfo = linkedTreeMap.get(vipBundleName)) != null && (openHippyInfo = hippyInfo.openParams) != null) {
            this.configUrl = openHippyInfo.url;
        }
    }

    private static JSONObject getJSONObjectFromToggle(String str) {
        AppRuntime app;
        JSONObject jSONObject;
        if (VasNormalToggle.BUG_REMOVE_HIPPY_CONFIG.isEnable(true) || TextUtils.isEmpty(str) || (app = VasUtil.getApp()) == null || (jSONObject = ((IFeatureRuntimeService) app.getRuntimeService(IFeatureRuntimeService.class, "all")).getJSONObject("vas_hippy_entrance_config", null)) == null) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "getJSONObjectFromToggle parse error:" + e16);
            return null;
        }
    }

    public static String getVipBundleName() {
        if (!ENABLE_CONFIG) {
            return HippyQQConstants.ModuleName.QQ_VIP;
        }
        try {
            return VasLongToggle.VAS_SETTING_VIP_HIPPY_BUNDLE_SWITCH.getJson().getString("bundleName");
        } catch (JSONException unused) {
            QLog.e(TAG, 1, "parse error bundleName");
            return HippyQQConstants.ModuleName.QQ_VIP;
        }
    }

    public static boolean isContainsModule(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (superModuleNames.contains(str)) {
            return true;
        }
        LinkedTreeMap<String, HippyInfo> linkedTreeMap = QVipHippyProcessor.a().map;
        if ((linkedTreeMap == null || !linkedTreeMap.containsKey(str)) && getJSONObjectFromToggle(str) == null) {
            return false;
        }
        return true;
    }

    public static OpenHippyInfo mergeCommonParams(String str) {
        JSONObject jSONObject;
        if (VasNormalToggle.BUG_REMOVE_HIPPY_CONFIG.isEnable(true)) {
            return null;
        }
        JSONObject jSONObjectFromToggle = getJSONObjectFromToggle("Common");
        JSONObject jSONObjectFromToggle2 = getJSONObjectFromToggle(str);
        if (jSONObjectFromToggle2 == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObjectFromToggle2.optJSONObject("openParams");
        if (jSONObjectFromToggle != null && jSONObjectFromToggle.optJSONObject("openParams") != null) {
            jSONObject = jSONObjectFromToggle.optJSONObject("openParams");
        } else {
            jSONObject = optJSONObject;
        }
        if (jSONObject == null) {
            return null;
        }
        if (optJSONObject != null && !optJSONObject.equals(jSONObject)) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                try {
                    jSONObject.put(str2, optJSONObject.get(str2));
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return (OpenHippyInfo) new Gson().fromJson(jSONObject.toString(), new a().getType());
    }

    @Nullable
    public HippyInfo getHippyInfoFromKey(String str) {
        if (this.map.containsKey(str)) {
            return this.map.get(str);
        }
        return null;
    }

    public boolean isEnableGetAuth(String str, String str2) {
        if (superModuleNames.contains(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        HippyInfo hippyInfoFromKey = getHippyInfoFromKey(str);
        if (hippyInfoFromKey != null && hippyInfoFromKey.enableDomain != null && !TextUtils.isEmpty(str2)) {
            for (String str3 : hippyInfoFromKey.enableDomain) {
                if (str3 != null && str3.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
