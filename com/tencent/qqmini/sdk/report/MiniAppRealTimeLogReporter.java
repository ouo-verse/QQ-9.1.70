package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppRealTimeLogReporter {
    public static final int MAX_CONTENT_SIZE = 5120;
    public static final int MAX_LOG_ITEM_COUNT = 200;
    public static final int MAX_PAGE_COUNT = 10;
    private static final String TAG = "MiniAppRealTimeLogReporter";
    private List<RealTimeLog> allLogs = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class RealTimeLog {
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
        if (list2 != null && list2.size() <= 10) {
            RealTimeLog realTimeLog2 = new RealTimeLog(i3);
            this.allLogs.add(realTimeLog2);
            return realTimeLog2;
        }
        return null;
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
        if (logById != null) {
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
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).realTimeLogReport(str, str2, str3, strArr2, logById.logitems, new AsyncResult() { // from class: com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                        QMLog.d(MiniAppRealTimeLogReporter.TAG, "realTimeLogReport  ReportLog isSuc: " + z16 + "  ret:" + jSONObject);
                    }
                });
            }
            this.allLogs.remove(logById);
            return true;
        }
        return true;
    }

    public boolean report(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return report(jSONObject.getInt("page"), jSONObject.getJSONArray("filterMsg"), jSONObject.getInt("level"), jSONObject.getLong("time"), jSONObject.getString("content"));
        } catch (Exception unused) {
            QMLog.e(TAG, "MiniAppRealTimeLogReporter.report failed:" + str);
            return false;
        }
    }

    private boolean report(int i3, JSONArray jSONArray, int i16, long j3, String str) {
        RealTimeLog findLogByPage = findLogByPage(i3);
        if (findLogByPage == null) {
            QMLog.e(TAG, "current log has reached its max size");
            return false;
        }
        if (findLogByPage.curLogContentSize >= 5120) {
            QMLog.e(TAG, "current log content has reached its current max size");
            return false;
        }
        if (findLogByPage.logitems.size() >= 200) {
            QMLog.e(TAG, "current log item size has reached its current max size");
            return false;
        }
        findLogByPage.filterMsg = jSONArray;
        if (findLogByPage.curLogContentSize + str.length() > 5120) {
            str = str.substring(0, MAX_CONTENT_SIZE - findLogByPage.curLogContentSize);
        }
        findLogByPage.logitems.add(new RealTimeLogItem(j3, i16, str));
        findLogByPage.curLogContentSize += str.length();
        return true;
    }
}
