package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.PreCacheManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class PreCacheJsPlugin extends BaseJsPlugin {
    private static final String EVENT_GET_FETCH_DATA = "getBackgroundFetchData";
    private static final String EVENT_GET_FETCH_TOKEN = "getBackgroundFetchToken";
    private static final String EVENT_SET_FETCH_TOKEN = "setBackgroundFetchToken";
    private static final String TAG = "PreCacheJsPlugin";

    @JsEvent({"getBackgroundFetchData"})
    public void getBackgroundFetchData(RequestEvent requestEvent) {
        byte[] bArr;
        QMLog.d(TAG, "call getBackgroundFetchData callbackId:" + requestEvent.callbackId + " PackageToolVersion:" + this.mApkgInfo.mAppConfigInfo.packageToolVersion);
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("fetchType");
            if (!TextUtils.isEmpty(optString)) {
                PreCacheManager.PreCacheDescData preFetchAppCacheData = PreCacheManager.g().getPreFetchAppCacheData(this.mApkgInfo.mMiniAppInfo, optString);
                if (preFetchAppCacheData != null && (bArr = preFetchAppCacheData.data) != null && bArr.length > 0) {
                    String str = new String(bArr);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("fetchedData", str);
                    jSONObject.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, preFetchAppCacheData.timeStamp);
                    jSONObject.put("path", preFetchAppCacheData.path);
                    jSONObject.put("scene", AppBrandUtil.getWikiScene(preFetchAppCacheData.scene));
                    jSONObject.put("query", preFetchAppCacheData.getQuery());
                    requestEvent.ok(jSONObject);
                } else {
                    requestEvent.fail("\u7f13\u5b58\u6570\u636e\u4e0d\u5b58\u5728");
                }
            } else {
                requestEvent.fail("");
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
            requestEvent.fail("");
        }
    }

    @JsEvent({"getBackgroundFetchDataForContainer"})
    public void getBackgroundFetchDataForContainer(RequestEvent requestEvent) {
        byte[] bArr;
        if (!this.mIsContainer) {
            QMLog.e(TAG, "call getBackgroundFetchDataForContainer error, only for container!");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("fetchType");
            String optString2 = jSONObject.optString("subPkgName");
            String optString3 = jSONObject.optString("pagePath");
            if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                PreCacheManager.PreCacheDescData containerPreFetchAppCacheData = PreCacheManager.g().getContainerPreFetchAppCacheData(this.mApkgInfo.mMiniAppInfo, optString2, optString3, optString);
                if (containerPreFetchAppCacheData != null && (bArr = containerPreFetchAppCacheData.data) != null && bArr.length > 0) {
                    String str = new String(bArr);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("fetchedData", str);
                    jSONObject2.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, containerPreFetchAppCacheData.timeStamp);
                    jSONObject2.put("path", containerPreFetchAppCacheData.path);
                    jSONObject2.put("scene", AppBrandUtil.getWikiScene(containerPreFetchAppCacheData.scene));
                    jSONObject2.put("query", containerPreFetchAppCacheData.getQuery());
                    requestEvent.ok(jSONObject2);
                } else {
                    requestEvent.fail("\u7f13\u5b58\u6570\u636e\u4e0d\u5b58\u5728");
                }
            } else {
                requestEvent.fail("subPkgName or pagePath is null!");
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
            requestEvent.fail("");
        }
    }

    @JsEvent({EVENT_GET_FETCH_TOKEN})
    public void getBackgroundFetchToken(RequestEvent requestEvent) {
        QMLog.d(TAG, "call getBackgroundFetchToken callbackId:" + requestEvent.callbackId);
        try {
            String backgroundFetchToken = PreCacheManager.g().getBackgroundFetchToken(this.mApkgInfo.mMiniAppInfo);
            if (!TextUtils.isEmpty(backgroundFetchToken)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", backgroundFetchToken);
                requestEvent.ok(jSONObject);
            } else {
                requestEvent.fail();
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
            requestEvent.fail();
        }
    }

    @JsEvent({EVENT_SET_FETCH_TOKEN})
    public void setBackgroundFetchToken(RequestEvent requestEvent) {
        QMLog.d(TAG, "call setBackgroundFetchToken callbackId:" + requestEvent.callbackId);
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("token");
            if (!TextUtils.isEmpty(optString)) {
                PreCacheManager.g().setBackgroundFetchToken(this.mApkgInfo.mMiniAppInfo, optString);
                requestEvent.ok();
            } else {
                requestEvent.fail("token is empty!");
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
            requestEvent.fail();
        }
    }
}
