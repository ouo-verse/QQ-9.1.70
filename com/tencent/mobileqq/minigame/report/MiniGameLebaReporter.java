package com.tencent.mobileqq.minigame.report;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/MiniGameLebaReporter;", "", "()V", "ACTION_TYPE_LEBA", "", "REFER_LEBA", "", "RESERVES_2_LEBA_RED_POINT", "RESERVES_ACTION_CLICK", "RESERVES_ACTION_EXPO", "SUB_ACTION_LEBA", "TAG", "VIA_LEBA", "createMiniAppConfigForLeba", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "targetAppId", "getReserves", "isClickReport", "", "reportFromLeba", "", "appInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "reportFromLebaAsync", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameLebaReporter {
    private static final String ACTION_TYPE_LEBA = "active_page";
    public static final MiniGameLebaReporter INSTANCE = new MiniGameLebaReporter();
    private static final int REFER_LEBA = 2050;
    private static final String RESERVES_2_LEBA_RED_POINT = "red_point";
    private static final String RESERVES_ACTION_CLICK = "click";
    private static final String RESERVES_ACTION_EXPO = "expo";
    private static final String SUB_ACTION_LEBA = "app_center";
    private static final String TAG = "MiniGameLebaReporter";
    private static final String VIA_LEBA = "2050";

    MiniGameLebaReporter() {
    }

    private final MiniAppConfig createMiniAppConfigForLeba(String targetAppId) {
        MiniAppInfo miniAppInfo = new MiniAppInfo();
        if (targetAppId == null) {
            targetAppId = "null";
        }
        miniAppInfo.appId = targetAppId;
        miniAppInfo.via = VIA_LEBA;
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        LaunchParam launchParam = new LaunchParam();
        launchParam.scene = 2050;
        miniAppConfig.launchParam = launchParam;
        return miniAppConfig;
    }

    private final void reportFromLeba(BusinessInfoCheckUpdate.AppInfo appInfo, boolean isClickReport) {
        if (appInfo == null) {
            MiniProgramLpReportDC04239.reportMiniAppEvent(createMiniAppConfigForLeba(null), "", "", ACTION_TYPE_LEBA, SUB_ACTION_LEBA, getReserves(isClickReport), null);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(appInfo.buffer.get());
            String optString = jSONObject.optString("_show_mission");
            JSONObject optJSONObject = jSONObject.optJSONObject("msg");
            if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(optString);
                if (optJSONObject2 != null) {
                    String optString2 = optJSONObject2.optString("content");
                    if (TextUtils.isEmpty(optString2)) {
                        return;
                    }
                    MiniProgramLpReportDC04239.reportMiniAppEvent(createMiniAppConfigForLeba(new JSONObject(optString2).optString("appid")), "", "", ACTION_TYPE_LEBA, SUB_ACTION_LEBA, getReserves(isClickReport), "red_point", jSONObject.optString("ad_id"));
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "doReportForMiniGame warning, " + optString + ", " + optJSONObject + ", " + isClickReport);
            }
            MiniProgramLpReportDC04239.reportMiniAppEvent(createMiniAppConfigForLeba(null), "", "", ACTION_TYPE_LEBA, SUB_ACTION_LEBA, getReserves(isClickReport), null);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "doReportForMiniGame, ex=" + e16.getMessage() + ",isClickReport=" + isClickReport);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportFromLebaAsync$lambda$0(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        INSTANCE.reportFromLeba(appInfo, z16);
    }

    public final void reportFromLebaAsync(final BusinessInfoCheckUpdate.AppInfo appInfo, final boolean isClickReport) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.report.b
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameLebaReporter.reportFromLebaAsync$lambda$0(BusinessInfoCheckUpdate.AppInfo.this, isClickReport);
            }
        }, 64, null, false);
    }

    private final String getReserves(boolean isClickReport) {
        if (isClickReport) {
            return "click";
        }
        return "expo";
    }
}
