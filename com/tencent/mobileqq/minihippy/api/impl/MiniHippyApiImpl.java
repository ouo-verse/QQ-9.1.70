package com.tencent.mobileqq.minihippy.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.utils.FeatureSwitchUtils;
import com.tencent.mobileqq.minihippy.api.IMiniHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import d92.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniHippyApiImpl implements IMiniHippyApi {
    private static final String KEY_TOGGLE_MINI_HIPPY_SCENE = "gamecenter_mini_hippy_configs";
    private static final String TAG = "MiniHippyApiImpl";
    private static volatile String sharePicUrl;
    private static volatile String shareQuery;
    private static volatile String shareText;

    private String parseUrl(String str) {
        try {
            return new JSONObject(str).optString("url");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseUrl: failed, params=" + str, e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.minihippy.api.IMiniHippyApi
    public void backToHome(Context context) {
        if (context instanceof GameActivity1) {
            GameActivity1 gameActivity1 = (GameActivity1) context;
            if (gameActivity1.isMiniHippyEngine()) {
                gameActivity1.backToHome();
            }
        }
    }

    @Override // com.tencent.mobileqq.minihippy.api.IMiniHippyApi
    public boolean checkIfColdReloadHippy(Object obj, Object obj2) {
        MiniAppInfo miniAppInfo;
        String str;
        boolean z16 = false;
        if (((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).isMiniHippy(obj) && ((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).isMiniHippy(obj2) && (str = (miniAppInfo = (MiniAppInfo) obj).appId) != null) {
            MiniAppInfo miniAppInfo2 = (MiniAppInfo) obj2;
            if (str.equals(miniAppInfo2.appId)) {
                String str2 = miniAppInfo.appId;
                String str3 = miniAppInfo.extInfo;
                String str4 = miniAppInfo.extendData;
                FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
                OpenHippyInfo a16 = d.a(str2, str3, str4, firstPageInfo == null ? null : firstPageInfo.pagePath);
                String str5 = miniAppInfo2.appId;
                String str6 = miniAppInfo2.extInfo;
                String str7 = miniAppInfo2.extendData;
                FirstPageInfo firstPageInfo2 = miniAppInfo2.firstPage;
                OpenHippyInfo a17 = d.a(str5, str6, str7, firstPageInfo2 != null ? firstPageInfo2.pagePath : null);
                if (a16 != null && a17 != null) {
                    String str8 = a17.url;
                    if (str8 != null && str8.contains("isNeedReLoadHippy=1") && !a17.url.equals(a16.url)) {
                        z16 = true;
                    }
                    QLog.i(TAG, 2, "[checkIfReloadHippy] " + z16 + ",curHippyUrl:" + a16.url + ",newHippyUrl:" + a17.url);
                }
            }
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.minihippy.api.IMiniHippyApi
    public Map<String, String> getShareParams() {
        if (TextUtils.isEmpty(shareText) || TextUtils.isEmpty(sharePicUrl)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ThirdPartyMiniPageProxy.KEY_SHARE_TEXT, shareText);
        hashMap.put(ThirdPartyMiniPageProxy.KEY_SHARE_PIC_URL, sharePicUrl);
        if (!TextUtils.isEmpty(shareQuery)) {
            hashMap.put(ThirdPartyMiniPageProxy.KEY_SHARE_QUERY, shareQuery);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.minihippy.api.IMiniHippyApi
    public boolean isInMiniHippyWhiteList(String str) {
        JSONObject toggleJson;
        JSONArray optJSONArray;
        if (!TextUtils.isEmpty(str) && (toggleJson = FeatureSwitchUtils.INSTANCE.getToggleJson(KEY_TOGGLE_MINI_HIPPY_SCENE, "")) != null && (optJSONArray = toggleJson.optJSONArray("appIds")) != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                if (str.equals(optJSONArray.optString(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.minihippy.api.IMiniHippyApi
    public boolean isLaunchByMiniApp(Context context) {
        if (context instanceof GameActivity1) {
            return ((GameActivity1) context).isMiniHippyEngine();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.minihippy.api.IMiniHippyApi
    public boolean isMiniHippy(Object obj) {
        boolean z16;
        if (obj instanceof MiniAppInfo) {
            MiniAppInfo miniAppInfo = (MiniAppInfo) obj;
            String str = miniAppInfo.extInfo;
            if (TextUtils.isEmpty(str)) {
                z16 = isInMiniHippyWhiteList(miniAppInfo.appId);
                QLog.i(TAG, 1, "[isMiniHippy] extInfo is null,isInWhite:" + z16);
            } else if (str.contains("bundle_name") && str.contains(ThirdPartyMiniPageProxy.KEY_HIPPY_DOMAIN)) {
                z16 = true;
            }
            QLog.i(TAG, 1, "[isMiniHippy] " + z16);
            return z16;
        }
        z16 = false;
        QLog.i(TAG, 1, "[isMiniHippy] " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.minihippy.api.IMiniHippyApi
    public void launchMiniHippy(Context context, Intent intent) {
        if (context instanceof GameActivity1) {
            GameActivity1 gameActivity1 = (GameActivity1) context;
            if (gameActivity1.isMiniHippyEngine()) {
                gameActivity1.pushMiniHippy(intent);
            }
        }
    }

    @Override // com.tencent.mobileqq.minihippy.api.IMiniHippyApi
    public void openUrl(Context context, String str) {
        if (context instanceof GameActivity1) {
            GameActivity1 gameActivity1 = (GameActivity1) context;
            if (gameActivity1.isMiniHippyEngine()) {
                String parseUrl = parseUrl(str);
                if (TextUtils.isEmpty(parseUrl)) {
                    QLog.e(TAG, 1, "openUrl: parseUrl null. params=" + str);
                    return;
                }
                gameActivity1.openUrl(parseUrl);
            }
        }
    }

    @Override // com.tencent.mobileqq.minihippy.api.IMiniHippyApi
    public void popMiniHippy(Context context) {
        if (context instanceof GameActivity1) {
            GameActivity1 gameActivity1 = (GameActivity1) context;
            if (gameActivity1.isMiniHippyEngine()) {
                gameActivity1.doOnPopFragment();
            }
        }
    }

    @Override // com.tencent.mobileqq.minihippy.api.IMiniHippyApi
    public void setShareParams(String str, String str2, String str3) {
        shareText = str;
        sharePicUrl = str2;
        shareQuery = str3;
    }
}
