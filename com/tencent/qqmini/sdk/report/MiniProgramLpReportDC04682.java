package com.tencent.qqmini.sdk.report;

import NS_COMM.COMM;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class MiniProgramLpReportDC04682 {
    private static final String KEY_ACTIV_WBE = "activ_web";
    private static final String KEY_OPT_TYPE = "opt_type";
    private static final String KEY_POS_ID = "pos_id";
    private static final String TAG = "MiniProgramLpReportDC04682";

    private static List<COMM.Entry> newCommonInfoEntries(MiniAppInfo miniAppInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MiniProgramReportHelper.newEntry("platform", "android"));
        arrayList.add(MiniProgramReportHelper.newEntry("uin", String.valueOf(LoginManager.getInstance().getAccount())));
        if (miniAppInfo != null) {
            arrayList.add(MiniProgramReportHelper.newEntry("appid", miniAppInfo.appId));
            arrayList.add(MiniProgramReportHelper.newEntry("appname", miniAppInfo.name));
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

    public static void report(MiniAppInfo miniAppInfo, JSONObject jSONObject) {
        String str;
        if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("report mobile game ad with args: ");
            if (jSONObject != null) {
                str = jSONObject.toString();
            } else {
                str = GlobalUtil.DEF_STRING;
            }
            sb5.append(str);
            QMLog.d(TAG, sb5.toString());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(newCommonInfoEntries(miniAppInfo));
        arrayList.addAll(newMobileGameAdReportEntries(jSONObject));
        if (!QUAUtil.isQQApp()) {
            arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
        }
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(7, arrayList, null));
    }
}
