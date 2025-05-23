package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppRealTimeLogReporter {
    public static final int MAX_PAGE_COUNT = 10;
    private static final String TAG = "[mini] MiniAppRealTimeLogReporter";
    public static MiniAppRealTimeLogReporter instance;
    private static byte[] lock = new byte[0];
    private List<RealTimeLog> allLogs = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class RealTimeLog {
        public int curLogContentSize;
        public JSONArray filterMsg;
        public ArrayList<RealTimeLogItem> logitems = new ArrayList<>();
        public int page;

        public RealTimeLog(int i3) {
            this.page = i3;
        }
    }

    private RealTimeLog findLogByPage(int i3) {
        List<RealTimeLog> list = this.allLogs;
        if (list != null) {
            for (RealTimeLog realTimeLog : list) {
                if (realTimeLog.page == i3) {
                    return realTimeLog;
                }
            }
        }
        List<RealTimeLog> list2 = this.allLogs;
        if (list2 == null || list2.size() > 10) {
            return null;
        }
        RealTimeLog realTimeLog2 = new RealTimeLog(i3);
        this.allLogs.add(realTimeLog2);
        return realTimeLog2;
    }

    public static MiniAppRealTimeLogReporter getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new MiniAppRealTimeLogReporter();
                }
            }
        }
        return instance;
    }

    private RealTimeLog getLogById(int i3) {
        for (RealTimeLog realTimeLog : this.allLogs) {
            if (realTimeLog.page == i3) {
                return realTimeLog;
            }
        }
        return null;
    }

    public boolean flush(String str, int i3, String str2, String str3) {
        String[] strArr;
        RealTimeLog logById = getLogById(i3);
        if (logById == null) {
            return true;
        }
        JSONArray jSONArray = logById.filterMsg;
        if (jSONArray != null) {
            strArr = new String[jSONArray.length()];
            for (int i16 = 0; i16 < logById.filterMsg.length(); i16++) {
                strArr[i16] = logById.filterMsg.optString(i16, "");
            }
        } else {
            strArr = null;
        }
        String[] strArr2 = strArr;
        if (logById.logitems.size() > 0) {
            MiniAppCmdUtil.getInstance().realTimeLogReport(str, str2, str3, strArr2, logById.logitems, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.report.MiniAppRealTimeLogReporter.1
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                    QLog.e(MiniAppRealTimeLogReporter.TAG, 1, "realTimeLogReport  ReportLog isSuc: " + z16 + "  ret:" + jSONObject);
                }
            });
        }
        this.allLogs.remove(logById);
        return true;
    }

    public boolean report(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return report(jSONObject.getInt("page"), jSONObject.getJSONArray("filterMsg"), jSONObject.getInt("level"), jSONObject.getLong("time"), jSONObject.getString("content"));
        } catch (Exception unused) {
            QLog.e(TAG, 1, "MiniAppRealTimeLogReporter.report failed:" + str);
            return false;
        }
    }

    private boolean report(int i3, JSONArray jSONArray, int i16, long j3, String str) {
        RealTimeLog findLogByPage = findLogByPage(i3);
        if (findLogByPage == null) {
            QLog.e(TAG, 1, "current log has reached its max size");
            return false;
        }
        int config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_REAL_TIME_LOG_MAX_CONTENT_SIZE, com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE);
        int config2 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_REAL_TIME_LOG_MAX_CALL_NUM, 200);
        if (findLogByPage.curLogContentSize >= config) {
            QLog.e(TAG, 1, "current log content has reached its current max size");
            return false;
        }
        if (findLogByPage.logitems.size() >= config2) {
            QLog.e(TAG, 1, "current log item size has reached its current max size");
            return false;
        }
        findLogByPage.filterMsg = jSONArray;
        if (findLogByPage.curLogContentSize + str.length() > config) {
            int length = (findLogByPage.curLogContentSize + str.length()) - config;
            findLogByPage.logitems.add(new RealTimeLogItem(j3, i16, "UserLog:fail Log Size " + length + " Exceed"));
        }
        findLogByPage.logitems.add(new RealTimeLogItem(j3, i16, str));
        findLogByPage.curLogContentSize += str.length();
        return true;
    }
}
