package com.tencent.mobileqq.minispecial.api.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.ui.controller.MiniHippyController;
import com.tencent.mobileqq.minihippy.api.IMiniHippyApi;
import com.tencent.mobileqq.minispecial.api.IThirdPartyMiniApi;
import com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import f92.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class ThirdPartyMiniApiImpl implements IThirdPartyMiniApi {
    public static final String KEY_EXT_INFO = "ext_info";
    public static final String KEY_GAME_APP_ID = "game_app_id";
    public static final String KEY_KEY = "key";
    public static final String KEY_MAP_INFO = "mapInfo";
    public static final String KEY_MINIGAME_EXT_PARAM = "minigame_extinfo";
    public static final String KEY_RENDER_TYPE = "render_type";
    public static final String KEY_VALUE = "value";
    public static final int RENDER_TYPE_HIPPY = 0;
    public static final int RENDER_TYPE_KUIKLY = 1;
    private static final String TAG = "ThirdPartyMiniApiImpl";

    @Override // com.tencent.mobileqq.minispecial.api.IThirdPartyMiniApi
    public int getThirdPartyEngineType(Object obj) {
        if (!(obj instanceof MiniAppInfo)) {
            return 0;
        }
        if (((IThirdPartyMiniApi) QRoute.api(IThirdPartyMiniApi.class)).isMiniKuikly(obj)) {
            return 2;
        }
        return ((IThirdPartyMiniApi) QRoute.api(IThirdPartyMiniApi.class)).isMiniHippy(obj) ? 1 : 0;
    }

    @Override // com.tencent.mobileqq.minispecial.api.IThirdPartyMiniApi
    public boolean isExtInfoContainsMiniGameThirdPartyParams(Object obj) {
        if (!(obj instanceof MiniAppInfo)) {
            return false;
        }
        String str = ((MiniAppInfo) obj).extInfo;
        if (!TextUtils.isEmpty(str) && str.contains(KEY_MINIGAME_EXT_PARAM)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(KEY_MAP_INFO);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                        if (jSONObject != null && KEY_MINIGAME_EXT_PARAM.equals(jSONObject.optString("key"))) {
                            return new JSONObject(jSONObject.optString("value")).optInt(KEY_RENDER_TYPE, -1) == 1;
                        }
                    }
                }
                return false;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "isExtInfoContainsParams throw t:", th5);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.minispecial.api.IThirdPartyMiniApi
    public boolean isMiniHippy(Object obj) {
        return ((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).isMiniHippy(obj);
    }

    @Override // com.tencent.mobileqq.minispecial.api.IThirdPartyMiniApi
    public boolean isMiniKuikly(Object obj) {
        a.KuiklyConfig kuiklyConfig;
        if (!(obj instanceof MiniAppInfo)) {
            return false;
        }
        if (!isExtInfoContainsMiniGameThirdPartyParams(obj) && !((IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class)).checkAndParseMcKuiklyConfig(obj)) {
            return false;
        }
        String str = ((MiniAppInfo) obj).appId;
        a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101793");
        return ((IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class)).isMiniKuikly(str, (aVar == null || (kuiklyConfig = aVar.a().get(str)) == null) ? null : kuiklyConfig.getConfigId());
    }

    @Override // com.tencent.mobileqq.minispecial.api.IThirdPartyMiniApi
    public boolean isMiniThirdPartyEngine(Object obj) {
        return isMiniKuikly(obj) || isMiniHippy(obj);
    }

    @Override // com.tencent.mobileqq.minispecial.api.IThirdPartyMiniApi
    public String getKuiklyConfigByExtInfo(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(KEY_MAP_INFO);
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                        if (jSONObject.optString("key").equals(KEY_MINIGAME_EXT_PARAM)) {
                            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("value"));
                            if (1 == jSONObject2.optInt(KEY_RENDER_TYPE, -1)) {
                                return jSONObject2.optString("ext_info");
                            }
                        }
                    }
                }
                return null;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "parseKuiklyParam throw t:", th5);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.minispecial.api.IThirdPartyMiniApi
    public g92.a getMiniThirdPartyView(Activity activity, Object obj, int i3) {
        if (i3 == 2) {
            return ((IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class)).getKuiklyUIProxy(activity);
        }
        if (i3 == 1 && (activity instanceof GameActivity1) && (obj instanceof IUIProxy)) {
            return new MiniHippyController((GameActivity1) activity, (IUIProxy) obj);
        }
        return null;
    }
}
