package com.tencent.ad.tangram.statistics.canvas;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.statistics.xijing.AdDMPReporterHelper;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class AdReporterForDMPWithCanvas {
    public static final String DMP_ACTION_DOWNLOAD_CLICK = "DOWNLOAD_CLICK";
    public static final String DMP_ACTION_VIEW_CONTENT = "VIEW_CONTENT";
    private static final String TAG = "AdDMPReportUtil";

    @Nullable
    private static JSONObject getActionParamsForDownload(@Nullable Ad ad5) {
        if (ad5 != null && ad5.isValid()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", ad5.getAppId());
                return jSONObject;
            } catch (JSONException e16) {
                AdLog.e(TAG, "getActionParamsForDownload", e16);
                return null;
            }
        }
        AdLog.e(TAG, "getActionParamsForDownload error");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean reportAppBtnClick(Ad ad5) {
        byte[] requestData = AdDMPReporterHelper.getRequestData(AdDMPReporterHelper.getRequestJson(ad5, getActionParamsForDownload(ad5), "CUSTOM", DMP_ACTION_DOWNLOAD_CLICK, AdDMPReporterHelper.DEST_URL));
        if (requestData != null && requestData.length > 0) {
            for (int i3 = 0; i3 < 3; i3++) {
                AdHttp.Params requestParams = AdDMPReporterHelper.getRequestParams(requestData);
                AdHttp.send(requestParams);
                if (requestParams != null && requestParams.isSuccess()) {
                    AdLog.i(TAG, "reportAppBtnClick success");
                    return true;
                }
                AdLog.e(TAG, "reportAppBtnClick error");
            }
            return false;
        }
        AdLog.e(TAG, "reportAppBtnClick error");
        return false;
    }

    public static void reportAppBtnClickAsync(final Ad ad5) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.statistics.canvas.AdReporterForDMPWithCanvas.2
            @Override // java.lang.Runnable
            public void run() {
                AdReporterForDMPWithCanvas.reportAppBtnClick(Ad.this);
            }
        }, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean reportLoad(Ad ad5, boolean z16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WadlProxyConsts.VIA_AUTO_DOWNLOAD, z16);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        byte[] requestData = AdDMPReporterHelper.getRequestData(AdDMPReporterHelper.getRequestJson(ad5, jSONObject, DMP_ACTION_VIEW_CONTENT, null, AdDMPReporterHelper.DEST_URL));
        if (requestData != null && requestData.length > 0) {
            for (int i3 = 0; i3 < 3; i3++) {
                AdHttp.Params requestParams = AdDMPReporterHelper.getRequestParams(requestData);
                AdHttp.send(requestParams);
                if (requestParams != null && requestParams.isSuccess()) {
                    return true;
                }
                AdLog.e(TAG, "reportLoad error");
            }
            return false;
        }
        AdLog.e(TAG, "reportLoad error");
        return false;
    }

    public static void reportLoadAsync(final Ad ad5, final boolean z16) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.statistics.canvas.AdReporterForDMPWithCanvas.1
            @Override // java.lang.Runnable
            public void run() {
                AdReporterForDMPWithCanvas.reportLoad(Ad.this, z16);
            }
        }, 4);
    }
}
