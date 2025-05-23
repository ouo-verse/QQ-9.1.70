package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniProgramLpReportDC04682 {
    private static final String KEY_ACTIV_WBE = "activ_web";
    private static final String KEY_OPT_TYPE = "opt_type";
    private static final String KEY_POS_ID = "pos_id";
    private static final String TAG = "MiniProgramLpReportDC04682";

    private static List<COMM.Entry> newCommonInfoEntries(MiniAppConfig miniAppConfig) {
        MiniAppInfo miniAppInfo;
        ArrayList arrayList = new ArrayList();
        arrayList.add(MiniProgramReportHelper.newEntry("platform", "android"));
        arrayList.add(MiniProgramReportHelper.newEntry("uin", String.valueOf(com.tencent.open.adapter.a.f().l())));
        if (miniAppConfig != null && (miniAppInfo = miniAppConfig.config) != null) {
            arrayList.add(MiniProgramReportHelper.newEntry("appid", miniAppInfo.appId));
            arrayList.add(MiniProgramReportHelper.newEntry("appname", miniAppConfig.config.name));
        }
        return arrayList;
    }

    private static List<COMM.Entry> newMobileGameAdReportEntries(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            arrayList.add(MiniProgramReportHelper.newEntry("pos_id", String.valueOf(jSONObject.optInt("pos_id"))));
            arrayList.add(MiniProgramReportHelper.newEntry(KEY_OPT_TYPE, String.valueOf(jSONObject.optInt(KEY_OPT_TYPE))));
            arrayList.add(MiniProgramReportHelper.newEntry(KEY_ACTIV_WBE, jSONObject.optString(KEY_ACTIV_WBE)));
        }
        return arrayList;
    }

    public static void report(MiniAppConfig miniAppConfig, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(newCommonInfoEntries(miniAppConfig));
        arrayList.addAll(newMobileGameAdReportEntries(jSONObject));
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(7, arrayList, null));
    }
}
