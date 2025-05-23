package com.tencent.qqmini.miniapp.util;

import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AdReportInfoUtil {
    public static final String TAG = "AdReportInfoUtil";

    public static JSONObject getAdReportInfo(ApkgInfo apkgInfo) {
        MiniAppInfo miniAppInfo;
        Map<Integer, Long> map;
        JSONObject jSONObject = new JSONObject();
        if (apkgInfo != null && (miniAppInfo = apkgInfo.mMiniAppInfo) != null) {
            try {
                jSONObject.put("fromAppid", miniAppInfo.launchParam.fromMiniAppId);
                EntryModel entryModel = apkgInfo.mMiniAppInfo.launchParam.entryModel;
                if (entryModel != null) {
                    if (entryModel.type == 0) {
                        jSONObject.put("fromQQ", entryModel.uin);
                    }
                    EntryModel entryModel2 = apkgInfo.mMiniAppInfo.launchParam.entryModel;
                    if (entryModel2.type == 1) {
                        jSONObject.put("fromGroupId", entryModel2.uin);
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                MiniReportManager.MiniAppLaunchState launchState = MiniReportManager.getLaunchState(apkgInfo.appId);
                if (launchState != null && (map = launchState.eventTime) != null && map.size() > 0 && launchState.eventTime.containsKey(1)) {
                    currentTimeMillis = launchState.eventTime.get(1).longValue();
                }
                jSONObject.put("appStartTime", currentTimeMillis);
            } catch (Throwable th5) {
                QMLog.e(TAG, "adReportInfo error,", th5);
            }
        }
        QMLog.d(TAG, "getAdReportInfo : " + jSONObject.toString());
        return jSONObject;
    }
}
