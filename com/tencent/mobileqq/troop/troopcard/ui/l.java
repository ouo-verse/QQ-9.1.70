package com.tencent.mobileqq.troop.troopcard.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.raft.codegenmeta.utils.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a();
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObject2 = (JSONObject) jSONObject.get(Constants.Configs.BASICS);
        if (jSONObject2 != null && (jSONArray = (JSONArray) jSONObject2.get("datas")) != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i3);
                String str = (String) jSONObject3.get("name");
                int intValue = ((Integer) jSONObject3.get("state")).intValue();
                String str2 = (String) jSONObject3.get(DTConstants.TAG.API);
                String str3 = (String) jSONObject3.get("msg");
                if (QLog.isColorLevel()) {
                    QLog.i("VisitorTroopCardPresent", 2, "checkApiState onResult, basics name = " + str + " state = " + intValue + " api = " + str2 + " msg = " + str3 + "\n");
                }
            }
        }
    }

    private static void b(JSONObject jSONObject, a aVar) throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObject2 = (JSONObject) jSONObject.get("friendlink");
        if (jSONObject2 != null && (jSONArray = (JSONArray) jSONObject2.get("datas")) != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i3);
                String str = (String) jSONObject3.get("name");
                int intValue = ((Integer) jSONObject3.get("state")).intValue();
                String str2 = (String) jSONObject3.get(DTConstants.TAG.API);
                String str3 = (String) jSONObject3.get("msg");
                if ("add_group".equals(str2) && intValue != 1) {
                    aVar.a();
                }
                if (QLog.isColorLevel()) {
                    QLog.i("VisitorTroopCardPresent", 2, "checkApiState onResult, friendlink name = " + str + " state = " + intValue + " api = " + str2 + " msg= " + str3 + "\n");
                }
            }
        }
    }

    private static void c(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObject2 = (JSONObject) jSONObject.get(PreDownloadConstants.DEPARTMENT_QQPAY);
        if (jSONObject2 != null && (jSONArray = (JSONArray) jSONObject2.get("datas")) != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i3);
                String str = (String) jSONObject3.get("name");
                int intValue = ((Integer) jSONObject3.get("state")).intValue();
                String str2 = (String) jSONObject3.get(DTConstants.TAG.API);
                String str3 = (String) jSONObject3.get("msg");
                if (QLog.isColorLevel()) {
                    QLog.i("VisitorTroopCardPresent", 2, "checkApiState onResult, qqpay name = " + str + " state = " + intValue + " api = " + str2 + " msg= " + str3 + "\n");
                }
            }
        }
    }

    public static void d(JSONObject jSONObject, a aVar) {
        if (jSONObject == null) {
            return;
        }
        try {
            int intValue = ((Integer) jSONObject.get("retcode")).intValue();
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("result");
            if (intValue == 0 && jSONObject2 != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("VisitorTroopCardPresent", 2, "checkApiState onResult. retCode = " + intValue + "\n");
                }
                a(jSONObject2);
                b(jSONObject2, aVar);
                int intValue2 = ((Integer) jSONObject2.get("appid")).intValue();
                if (QLog.isColorLevel()) {
                    QLog.i("VisitorTroopCardPresent", 2, "checkApiState onResult, appid =" + intValue2 + "\n");
                }
                c(jSONObject2);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("VisitorTroopCardPresent", 2, "checkApiState onResult " + e16);
            }
        }
    }
}
