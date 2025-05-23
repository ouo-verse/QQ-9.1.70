package com.tencent.gamecenter.wadl.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.standard.report.BaseEvent;
import com.tencent.raft.standard.report.IRReport;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlReportImpl implements IRReport {
    private static final String TAG = "Wadl_WadlReportImpl";

    public static String convertHashMapToJSONString(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                if (str != null && map.get(str) != null) {
                    jSONObject.put(str, map.get(str));
                }
            }
            return jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "convertHashMapToJSONString: JSONException when convert HashMap data - " + e16.getMessage());
            return "";
        }
    }

    private void reportToDc(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put(WadlReportBuilder.TableElem.SQ_VERSION, AppSetting.f99551k);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put("domain", "1");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONObject);
            jSONObject2.put(WadlReportBuilder.KEY_DC_ID, WadlProxyConsts.TAG_DC_00087);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(WadlReportBuilder.KEY_REPORT_LIST, jSONArray);
            ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).report(jSONObject3, 0);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.raft.standard.report.IRReport
    public boolean report(BaseEvent baseEvent) {
        if (baseEvent != null) {
            reportToDc(convertHashMapToJSONString(baseEvent.getReportParam()));
            return true;
        }
        return true;
    }

    @Override // com.tencent.raft.standard.report.IRReport
    public boolean reportToBeacon(String str, BaseEvent baseEvent) {
        return true;
    }
}
