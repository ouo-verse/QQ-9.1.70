package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniProgramLpReportDC04363 {
    private static final String BUSINESS_ANALYTICS = "mmbizwxaanalytics";
    private static final String BUSINESS_JS_API = "mmbizwxajsapi";
    private static final String BUSINESS_MONITOR = "mmbizwxamonitor";
    private static final String BUSINESS_SERVICE_QUALITY = "mmbizwxaservicequality";
    private static final String KEY_DATA = "data";
    private static final String KEY_EVENT_ID = "eventID";
    private static final String KEY_NAME = "name";
    private static final String KEY_VALUE = "value";
    private static final String TAG = "MiniProgramLpReportDC04";

    public static void handleReportRealTimeAction(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !str2.contains(BUSINESS_JS_API) && !str2.contains(BUSINESS_SERVICE_QUALITY)) {
            MiniProgramReporter.getInstance().add(MiniProgramReportHelper.newSingleDcData(4, String.valueOf(3), newThirdPartyEntries(str, str2), (List<COMM.Entry>) null));
        } else {
            QLog.w(TAG, 2, "handleReportRealTimeAction not handle data " + str2);
        }
    }

    private static List<COMM.Entry> newThirdPartyEntries(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str2).optString(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA));
            String optString = jSONObject.optString("business");
            if (BUSINESS_MONITOR.equals(optString)) {
                arrayList.add(MiniProgramReportHelper.newEntry(jSONObject.optString("name"), String.valueOf(jSONObject.optInt("value"))));
            } else if (BUSINESS_ANALYTICS.equals(optString)) {
                arrayList.add(MiniProgramReportHelper.newEntry(jSONObject.optString(KEY_EVENT_ID), jSONObject.optString("data")));
            }
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                if (!BUSINESS_MONITOR.equals(optString) || (!"name".equals(str3) && !"value".equals(str3))) {
                    if (!BUSINESS_ANALYTICS.equals(optString) || (!KEY_EVENT_ID.equals(str3) && !"data".equals(str3))) {
                        arrayList.add(MiniProgramReportHelper.newEntry(str3, jSONObject.optString(str3)));
                    }
                }
            }
            arrayList.add(MiniProgramReportHelper.newEntry("appid", str));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return arrayList;
    }
}
