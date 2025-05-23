package com.tencent.qqmini.minigame.plugins;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.qqmini.minigame.action.GetGameInfoManager;
import com.tencent.qqmini.minigame.gpkg.GpkgManager;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class GameDataJsPlugin extends BaseJsPlugin {
    private static final String TAG = "GameDataJsPlugin";

    private boolean checkNavigationAppIdListForMiniGame(String str) {
        GameInfoManager obtain;
        MiniGamePkg miniGamePkg;
        if (!StringUtil.isEmpty(str) && (obtain = GetGameInfoManager.obtain(this.mMiniAppContext)) != null && (miniGamePkg = obtain.getMiniGamePkg()) != null) {
            try {
                JSONArray jSONArray = miniGamePkg.mGameConfigJson.f346448d;
                int i3 = 0;
                while (jSONArray != null) {
                    if (i3 >= str.length()) {
                        break;
                    }
                    if (str.equals(jSONArray.getString(i3))) {
                        return true;
                    }
                    i3++;
                }
            } catch (JSONException e16) {
                QMLog.e(TAG, "checkNavigationAppIdListForMiniGame fail, e=", e16);
            }
        }
        return false;
    }

    @JsEvent({"getLaunchOptionsSync"})
    public String getLaunchOptionsSync(RequestEvent requestEvent) {
        String str;
        String str2;
        GameInfoManager obtain = GetGameInfoManager.obtain(this.mMiniAppContext);
        GameInfoManager.LaunchOptions launchOptions = obtain.getLaunchOptions();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            String str3 = null;
            if (TextUtils.isEmpty(launchOptions.fromMiniAppId)) {
                str = null;
            } else {
                str = launchOptions.fromMiniAppId;
            }
            jSONObject2.put("appId", str);
            if (TextUtils.isEmpty(launchOptions.navigateExtData)) {
                str2 = null;
            } else {
                str2 = launchOptions.navigateExtData;
            }
            jSONObject2.put(WadlProxyConsts.EXTRA_DATA, str2);
            jSONObject.put("scene", AppBrandUtil.getWikiScene(launchOptions.scene));
            jSONObject.put("query", launchOptions.query);
            if (!TextUtils.isEmpty(launchOptions.shareTicket)) {
                str3 = launchOptions.shareTicket;
            }
            jSONObject.put("shareTicket", str3);
            jSONObject.put("referrerInfo", jSONObject2);
            jSONObject.put("extendData", obtain.getExtendData());
            jSONObject.put("entryDataHash", launchOptions.entryDataHash);
            return jSONObject.toString();
        } catch (JSONException e16) {
            QMLog.e(TAG, "API_GET_LAUNCH_OPTIONS_SYNC exception: ", e16);
            return requestEvent.fail();
        }
    }

    @JsEvent(isSync = false, value = {PluginConst.DataJsPluginConst.API_GET_USERINFO_OPENDATA})
    public void getOpenDataUserInfo(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            JSONArray optJSONArray = jSONObject.optJSONArray("openIdList");
            String optString = jSONObject.optString("lang", "en");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                String[] strArr = new String[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    strArr[i3] = optJSONArray.getString(i3);
                }
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getUserInfoOpenData(this.mMiniAppInfo.appId, optString, strArr, new AsyncResult() { // from class: com.tencent.qqmini.minigame.plugins.GameDataJsPlugin.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                        if (z16) {
                            requestEvent.ok(jSONObject2);
                        } else {
                            requestEvent.fail(jSONObject2, null);
                        }
                    }
                });
            }
        } catch (JSONException e16) {
            requestEvent.fail();
            QMLog.e(TAG, "handle event:" + requestEvent.event + " error , ", e16);
        }
    }

    @JsEvent({"navigateToMiniProgramConfig"})
    public String navigateToMiniProgramConfig(RequestEvent requestEvent) {
        try {
            boolean checkNavigationAppIdListForMiniGame = checkNavigationAppIdListForMiniGame(new JSONObject(requestEvent.jsonParams).optString("appId"));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("inList", checkNavigationAppIdListForMiniGame);
            } catch (JSONException e16) {
                QMLog.e(TAG, "navigateToMiniProgramConfig: put inList fail, e=", e16);
            }
            QMLog.d(TAG, "navigateToMiniProgramConfig, callJs jsonObject = " + jSONObject);
            return jSONObject.toString();
        } catch (JSONException e17) {
            QMLog.e(TAG, "navigateToMiniProgramConfig: json to str fail, e=", e17);
            return "";
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        if (!this.mIsMiniGame) {
            return true;
        }
        return super.onInterceptJsEvent(requestEvent);
    }

    @JsEvent({"recordOffLineResourceState"})
    public void recordOffLineResourceState(RequestEvent requestEvent) {
        try {
            GpkgManager.setOfflineResourceContent(this.mMiniAppInfo, new JSONObject(requestEvent.jsonParams).optBoolean("isComplete", false));
            requestEvent.ok();
        } catch (Throwable th5) {
            QMLog.e(TAG, th5.getMessage(), th5);
        }
    }
}
