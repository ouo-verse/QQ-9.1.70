package com.tencent.qphone.base.util.log.report;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes22.dex */
public class LogPushManager {
    private static final String UPLOAD_LOG_PUSH_SEQ = "uploadlogpushseq";
    private static final long UPLOAD_LOG_PUSH_SEQ_STORE_TIME = 259200000;

    public static boolean checkPushSeqExists(ReportLogInfoContext reportLogInfoContext, long j3) {
        String string = BaseApplication.getContext().getSharedPreferences(UPLOAD_LOG_PUSH_SEQ, 0).getString(UPLOAD_LOG_PUSH_SEQ + reportLogInfoContext.uin, null);
        if (string == null) {
            return false;
        }
        try {
            return new JSONObject(string).has(String.valueOf(j3));
        } catch (JSONException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static void storePushSeqInfo(ReportLogInfoContext reportLogInfoContext, long j3) {
        JSONObject jSONObject;
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(UPLOAD_LOG_PUSH_SEQ, 0);
        String str = reportLogInfoContext.uin;
        String string = sharedPreferences.getString(UPLOAD_LOG_PUSH_SEQ + str, null);
        try {
            if (string == null) {
                jSONObject = new JSONObject();
            } else {
                JSONObject jSONObject2 = new JSONObject(string);
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    if (System.currentTimeMillis() - ((Long) jSONObject2.get((String) keys.next())).longValue() > 259200000) {
                        keys.remove();
                    }
                }
                jSONObject = jSONObject2;
            }
            jSONObject.put(String.valueOf(j3), System.currentTimeMillis());
            sharedPreferences.edit().putString(UPLOAD_LOG_PUSH_SEQ + str, jSONObject.toString()).commit();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }
}
