package com.tencent.qphone.base.util.log.report;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.b0.b;
import com.tencent.mobileqq.msf.core.e0.k;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LogEventReporter {
    public static String EVENT_SET_LOG_LEVEL = "SetLogLevel";
    public static String EVENT_UPLOAD_LOG = "UploadLogFile";
    public static String EVENT_UPLOAD_LOG_DEBUG = "UploadLogFiled_Debug";
    private static String SSO_CONF_IP = "/14.18.180.90:60000";
    public static String TAG = "LogEvent";
    public static final int UPLOADLOG_STAT_CHECKFILE = 20;
    public static final int UPLOADLOG_STAT_RECVPUSH = 10;
    public static final int UPLOADLOG_STAT_RECVPUSH_REPEAT = 11;
    public static final int UPLOADLOG_STAT_UPLOAD = 40;
    public static final int UPLOADLOG_STAT_UPLOAD_ERROR_LARGE = 41;
    public static final int UPLOADLOG_STAT_UPLOAD_SP_ERROR = 50;
    public static final int UPLOADLOG_STAT_ZIP = 30;

    public static void changeEventStat(String str, int i3, ReportLogInfoContext reportLogInfoContext) {
        reportLogInfoContext.stat = i3;
        LogManager.reportLogInfo(reportLogInfoContext);
        SharedPreferences sharedPreferences = MsfService.getCore().getSharedPreferences(str, 0);
        String string = sharedPreferences.getString(reportLogInfoContext.reportId, null);
        if (string == null) {
            QLog.d(TAG, 1, "changeEventStat find eventStr null, stat: ", Integer.valueOf(i3), ", reportId: ", reportLogInfoContext.reportId);
            if (i3 != 40 && i3 != 41) {
                return;
            } else {
                i3 = 50;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            jSONObject.put("stat", i3);
            if (i3 == 40 || i3 == 41) {
                jSONObject.put("fileSize", reportLogInfoContext.zipLogSize);
            }
            if (reportLogInfoContext.isReport) {
                jSONObject.put("endNet", NetConnInfoCenter.getSystemNetState());
                reportLogEvent(str, jSONObject);
                sharedPreferences.edit().remove(reportLogInfoContext.reportId).commit();
            } else {
                sharedPreferences.edit().putString(reportLogInfoContext.reportId, jSONObject.toString()).commit();
            }
            QLog.d(TAG, 1, "changeEventStat " + i3 + " " + reportLogInfoContext.reportId);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    public static void checkUnreportEvent(String str) {
        try {
            SharedPreferences sharedPreferences = MsfService.getCore().getSharedPreferences(str, 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                if (!TextUtils.equals(entry.getKey(), b.f247537d)) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) entry.getValue());
                        if (System.currentTimeMillis() - jSONObject.getLong("time") > 3600000) {
                            reportLogEvent(str, jSONObject);
                            edit.remove(entry.getKey());
                        }
                    } catch (JSONException e16) {
                        QLog.e(TAG, 1, "", e16);
                    }
                }
            }
            edit.commit();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "checkUnreportEvent error", th5);
        }
    }

    public static String getLogStatStr(int i3) {
        if (i3 != 10) {
            if (i3 != 11) {
                if (i3 != 20) {
                    if (i3 != 30) {
                        if (i3 != 40) {
                            if (i3 != 41) {
                                return "";
                            }
                            return "\u65e5\u5fd7\u6587\u4ef6\u8fc7\u5927";
                        }
                        return "\u65e5\u5fd7\u4e0a\u4f20\u5b8c\u6210";
                    }
                    return "\u65e5\u5fd7\u538b\u7f29\u5b8c\u6210";
                }
                return "\u65e5\u5fd7Check\u5b8c\u6210";
            }
            return "\u91cd\u590d\u8bf7\u6c42";
        }
        return "\u5ba2\u6237\u7aef\u6536\u5230Push\u8bf7\u6c42";
    }

    public static void newLogEvent(String str, ReportLogInfoContext reportLogInfoContext) {
        reportLogInfoContext.stat = 10;
        LogManager.reportLogInfo(reportLogInfoContext);
        checkUnreportEvent(str);
        SharedPreferences sharedPreferences = MsfService.getCore().getSharedPreferences(str, 0);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("stat", 10);
            jSONObject.put("uin", MsfService.getCore().getAccountCenter().e());
            jSONObject.put("startNet", NetConnInfoCenter.getSystemNetState());
            jSONObject.put("isSSOConfIP", k.c().d());
            sharedPreferences.edit().putString(reportLogInfoContext.reportId, jSONObject.toString()).commit();
            QLog.d(TAG, 1, "new LogEvent " + reportLogInfoContext.reportId);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    public static void reportLogEvent(String str, JSONObject jSONObject) {
        int i3;
        try {
            if (jSONObject.has("stat")) {
                i3 = jSONObject.getInt("stat");
            } else {
                i3 = 0;
            }
            QLog.d(TAG, 1, "reportLogEvent, " + i3);
            HashMap hashMap = new HashMap();
            if (str.equals(EVENT_UPLOAD_LOG)) {
                hashMap.put("pmStat", String.valueOf(i3));
                if (jSONObject.has("uin")) {
                    hashMap.put("pmUin", String.valueOf(jSONObject.getString("uin")));
                }
                if (jSONObject.has("time")) {
                    hashMap.put("pmTime", String.valueOf(jSONObject.getLong("time")));
                }
                if (jSONObject.has("startNet")) {
                    hashMap.put("pmStartNet", String.valueOf(jSONObject.getInt("startNet")));
                }
                if (jSONObject.has("endNet")) {
                    hashMap.put("pmEndNet", String.valueOf(jSONObject.getInt("endNet")));
                }
                if (jSONObject.has("fileSize")) {
                    hashMap.put("pmFileSize", String.valueOf(jSONObject.getLong("fileSize")));
                }
                if (jSONObject.has("isSSOConfIP")) {
                    hashMap.put("pmSSOConfIP", String.valueOf(jSONObject.getBoolean("isSSOConfIP")));
                }
            }
            if (MsfService.getCore().getStatReporter() != null) {
                MsfService.getCore().getStatReporter().a(str, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                if (QLog.isDebugVersion() && EVENT_UPLOAD_LOG.equals(str)) {
                    MsfService.getCore().getStatReporter().a(EVENT_UPLOAD_LOG_DEBUG, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                }
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }
}
