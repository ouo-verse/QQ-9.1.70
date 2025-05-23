package com.tencent.qqmini.sdk.plugins;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04363;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04682;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04884;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.MiniLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import org.json.JSONArray;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class ReportPlugin extends BaseJsPlugin {
    public static final String APP_TYPE_MINI_APP = "0";
    public static final String APP_TYPE_MINI_GAME = "1";
    public static final String EVENT_REPORT_KEY_VALUE = "reportKeyValue";
    public static final String KEY_ACTION_TYPE = "actiontype";
    public static final String KEY_RESERVES_ACTION = "reserves_action";
    public static final String KEY_SUB_ACTION_TYPE = "sub_actiontype";
    public static final String KEY_TABLE_DATA = "args";
    public static final String KEY_TABLE_NAME = "tableName";
    public static final int REPORT_EVENT_DISPLAY = 15496;
    public static final int REPORT_EVENT_JS_EXCEPTION = 13582;
    public static final int REPORT_EVENT_SPEED = 13544;
    public static final int REPORT_EVENT_SPEED_NEW_PAGE_2_PAGE_READY = 9;
    public static final int REPORT_EVENT_SPEED_RE_RENDER_TIME = 6;
    public static final String TABLE_DC04239 = "dc04239";
    public static final String TABLE_DC04682 = "dc04682";
    private static final String TAG = "ReportPlugin";

    /* JADX INFO: Access modifiers changed from: private */
    public void doReportBy898(String str, JSONArray jSONArray) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                sb5.append(jSONArray.getString(i3).replace("|", ""));
                if (i3 != jSONArray.length() - 1) {
                    sb5.append(QbAddrData.DATA_SPLITER);
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "doReportBy898 failed, ", e16);
                return;
            }
        }
        boolean isLogStringContainerHighFrequencyEvent = MiniLog.isLogStringContainerHighFrequencyEvent(sb5.toString());
        if (QMLog.isColorLevel() && (!isLogStringContainerHighFrequencyEvent || !FastClickUtils.isFastDoubleClick(TAG, 500L))) {
            QMLog.d(TAG, "doReportBy898 key:  " + str + "  data: " + ((Object) sb5));
        }
        Bundle bundle = new Bundle();
        bundle.putString("log_key", str);
        bundle.putStringArray("data", new String[]{sb5.toString()});
        AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", bundle, null);
    }

    public static String getAppType(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null || !miniAppInfo.isReportTypeMiniGame()) {
            return "0";
        }
        return "1";
    }

    @JsEvent(isSync = false, value = {"api_report"})
    public void apiReport(RequestEvent requestEvent) {
        String str;
        String str2;
        BaseLibInfo baseLibInfo;
        try {
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            String str3 = "";
            if (miniAppInfo == null) {
                str = "";
                str2 = str;
            } else {
                str = miniAppInfo.version;
                str2 = miniAppInfo.appId;
            }
            if (miniAppInfo != null && (baseLibInfo = miniAppInfo.baseLibInfo) != null) {
                str3 = baseLibInfo.baseLibVersion;
            }
            MiniProgramLpReportDC04884.reportApiReport(str2, requestEvent.jsonParams, str, str3);
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
        }
    }

    @JsEvent({"realtimeLog"})
    public String realtimeLogAction(RequestEvent requestEvent) {
        try {
            ((MiniAppRealTimeLogReporter) this.mMiniAppContext.getManager(MiniAppRealTimeLogReporter.class)).report(requestEvent.jsonParams);
            QMLog.d(TAG, "EVENT_NAME_REAL_TIME_LOG " + requestEvent.jsonParams);
            return "";
        } catch (Exception e16) {
            QMLog.e(TAG, "realtimeLog exception", e16);
            return "";
        }
    }

    @JsEvent(isSync = false, value = {"reportDC"})
    public void reportDC(final RequestEvent requestEvent) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.ReportPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    String string = jSONObject.getString("table");
                    JSONArray jSONArray = jSONObject.getJSONArray("reportArray");
                    if (!TextUtils.isEmpty(string) && jSONArray.length() > 0) {
                        ReportPlugin.this.doReportBy898(string, jSONArray);
                    }
                } catch (Exception e16) {
                    QMLog.e(ReportPlugin.TAG, " handleReportDC error.", e16);
                }
            }
        });
    }

    @JsEvent(isSync = false, value = {"reportDataToDC"})
    public void reportDataToDC(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString(KEY_TABLE_NAME);
            JSONObject optJSONObject = jSONObject.optJSONObject("args");
            if (optJSONObject != null) {
                if (TABLE_DC04239.equals(optString)) {
                    SDKMiniProgramLpReportDC04239.reportForSDK(this.mMiniAppInfo, "1", null, optJSONObject.optString("actiontype"), optJSONObject.optString("sub_actiontype"), optJSONObject.optString("reserves_action"), "");
                } else if (TABLE_DC04682.equals(optString)) {
                    MiniProgramLpReportDC04682.report(this.mMiniAppInfo, optJSONObject);
                }
            } else {
                QMLog.e(TAG, "ReportPlugin report to table[" + optString + "] fail, no args, [eventName=" + requestEvent.event + "][jsonParams=" + requestEvent.jsonParams + "]");
            }
        } catch (Exception unused) {
            QMLog.e(TAG, "ReportPlugin handleNativeRequest exception, [eventName=" + requestEvent.event + "][jsonParams=" + requestEvent.jsonParams + "]");
        }
    }

    @JsEvent({"reportKeyValue"})
    public void reportKeyValue(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 3));
    }

    @JsEvent({"reportProfileEvent"})
    public void reportProfileEvent(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            if ("unity_wasm_load".equals(jSONObject.optString("eventCode"))) {
                int optInt = jSONObject.optInt("costTime");
                QMLog.i(TAG, "unity_wasm_load cost=" + optInt);
                StartupReportUtil.reportUnityShow(this.mMiniAppInfo, optInt);
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "reportProfileEvent: exception=", e16);
        }
    }

    @JsEvent({"reportRealtimeAction"})
    public String reportRealtimeAction(RequestEvent requestEvent) {
        if (this.mIsMiniGame) {
            try {
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                MiniAppInfo miniAppInfo = this.mMiniAppInfo;
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, ""));
                String optString = jSONObject2.optString("eventID", "");
                if (JSONUtil.isJson(optString)) {
                    JSONObject jSONObject3 = new JSONObject(optString);
                    if (jSONObject3.has("finishShow")) {
                        SDKMiniProgramLpReportDC04239.reportForSDK(miniAppInfo, getAppType(miniAppInfo), null, "page_view", "finishShow", "", "");
                        if (jSONObject3.length() == 1) {
                            requestEvent.ok();
                            return "";
                        }
                    }
                } else if (optString.equals("finishShow")) {
                    SDKMiniProgramLpReportDC04239.reportForSDK(miniAppInfo, getAppType(miniAppInfo), null, "page_view", "finishShow", "", "");
                    requestEvent.ok();
                    return "";
                }
                jSONObject2.put("version", this.mMiniAppContext.getBaseLibVersion());
                jSONObject.put(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, jSONObject2);
                if (miniAppInfo != null) {
                    MiniProgramLpReportDC04363.handleReportRealTimeAction(miniAppInfo.appId, jSONObject.toString());
                    requestEvent.ok();
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, "", th5);
            }
        }
        return "";
    }
}
