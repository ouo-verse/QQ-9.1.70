package com.tencent.qqmini.minigame.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin
/* loaded from: classes23.dex */
public class c extends BaseJsPlugin {
    @JsEvent({"notifyGameCanPlay"})
    public void notifyGameCanPlay(RequestEvent requestEvent) {
        QMLog.d("PerformanceJsPlugin", "notifyGameCanPlay");
        BaseRuntimeLoader queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
        if (queryAppRunTimeLoader == null) {
            QMLog.e("PerformanceJsPlugin", "runtimeLoader is null!");
            requestEvent.fail("runtime loader is null");
        } else {
            queryAppRunTimeLoader.notifyRuntimeEvent(6, new Object[0]);
            requestEvent.ok();
            StartupReportUtil.reportCanPlay(this.mMiniAppInfo);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
    }

    @JsEvent({"onCreatedRole"})
    public void onCreatedRole(RequestEvent requestEvent) {
        QMLog.d("PerformanceJsPlugin", "onCreatedRole");
        StartupReportUtil.reportStartUpEvent(StartupReportUtil.EVENT_CREATED_ROLE, this.mMiniAppInfo);
        requestEvent.ok();
    }

    @JsEvent({"onGameFixRegister"})
    public void onGameFixRegister(RequestEvent requestEvent) {
        QMLog.d("PerformanceJsPlugin", "onGameFixRegister");
        gu3.a.e();
        requestEvent.ok();
    }

    @JsEvent({"onPrivacyClickAgree"})
    public void onPrivacyClickAgree(RequestEvent requestEvent) {
        QMLog.d("PerformanceJsPlugin", "onPrivacyClickAgree");
        StartupReportUtil.reportStartUpEvent(StartupReportUtil.EVENT_PRIVACY_AGREE, this.mMiniAppInfo);
        requestEvent.ok();
    }

    @JsEvent({"onPrivacyClickReject"})
    public void onPrivacyClickReject(RequestEvent requestEvent) {
        QMLog.d("PerformanceJsPlugin", "onPrivacyClickReject");
        StartupReportUtil.reportStartUpEvent(StartupReportUtil.EVENT_PRIVACY_REJECT, this.mMiniAppInfo);
        requestEvent.ok();
    }

    @JsEvent({"onPrivacyHasAgreed"})
    public void onPrivacyHasAgreed(RequestEvent requestEvent) {
        QMLog.d("PerformanceJsPlugin", "onPrivacyHasAgreed");
        StartupReportUtil.reportStartUpEvent(StartupReportUtil.EVENT_PRIVACY_HAS_AGREED, this.mMiniAppInfo);
        requestEvent.ok();
    }

    @JsEvent({"onPrivacyShow"})
    public void onPrivacyShow(RequestEvent requestEvent) {
        QMLog.d("PerformanceJsPlugin", "onPrivacyShow");
        StartupReportUtil.reportStartUpEvent(StartupReportUtil.EVENT_PRIVACY_SHOW, this.mMiniAppInfo);
        requestEvent.ok();
    }

    @JsEvent({"reportEvent"})
    public void reportEvent(RequestEvent requestEvent) {
        QMLog.d("PerformanceJsPlugin", "reportEvent");
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("eventId");
            String optString2 = jSONObject.optString("data");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                StartupReportUtil.reportCustomEvent(StartupReportUtil.EVENT_REPORT_CUSTOM_EVENT, this.mMiniAppInfo, optString, optString2);
                requestEvent.ok();
            } else {
                QMLog.w("PerformanceJsPlugin", "reportEvent params empty");
                requestEvent.fail("invalid params");
            }
        } catch (JSONException e16) {
            QMLog.e("PerformanceJsPlugin", "handle reportEvent exception:", e16);
            requestEvent.fail("parse params failed");
        }
    }

    @JsEvent({"startLoadingCheck"})
    public void startLoadingCheck(RequestEvent requestEvent) {
        QMLog.d("PerformanceJsPlugin", "startLoadingCheck");
        BaseRuntimeLoader queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
        if (queryAppRunTimeLoader == null) {
            QMLog.e("PerformanceJsPlugin", "runtimeLoader is null!");
            requestEvent.fail("runtime loader is null");
        } else {
            queryAppRunTimeLoader.notifyRuntimeEvent(5, new Object[0]);
            requestEvent.ok();
        }
    }
}
