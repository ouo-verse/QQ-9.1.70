package com.tencent.upload.report;

import com.google.gson.Gson;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Report {
    static IPatchRedirector $redirector_ = null;
    public static final int REPORT_TYPE_RESLUT = 0;
    public static final int REPORT_TYPE_START = 1;
    public static final String TAG = "Report";
    public long batchCtrlCostAvg;
    public int concurrent;
    public String content_type;
    public long ctrlElapse;
    public long ctrlEnd;
    public long ctrlStart;
    public long dataElapse;
    public long dataEnd;
    public long dataStart;
    public long elapse;
    public long endTime;
    public String entry;
    public String errMsg;
    public String filePath;
    public long fileSize;
    public int flowId;
    public int ipsrctype;
    public boolean isIPV6;
    public long leaveSize;
    public int networkType;
    public int num;
    public String recentApnKey;
    public String refer;
    public int reportType;
    public int retCode;
    public int retry;
    public ArrayList<Long> rttList;
    public String serverIp;
    public int source;
    public long startTime;
    public Map<String, String> transfer;
    public TaskTypeConfig uploadType;
    public String uppAppId;

    public Report() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isIPV6 = false;
        this.elapse = 0L;
        this.ctrlElapse = 0L;
        this.dataElapse = 0L;
        this.leaveSize = 0L;
        this.rttList = new ArrayList<>();
        this.recentApnKey = "";
    }

    public void addRtt(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.rttList.add(Long.valueOf(j3));
        }
    }

    public void clearRttList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.rttList.clear();
        }
    }

    public void subRttList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.rttList.size() <= 20) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.rttList.subList(0, 10));
        ArrayList<Long> arrayList2 = this.rttList;
        ArrayList arrayList3 = new ArrayList(arrayList2.subList(arrayList2.size() - 10, this.rttList.size()));
        this.rttList.clear();
        this.rttList.addAll(arrayList);
        this.rttList.addAll(arrayList3);
    }

    public String toJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        try {
            subRttList();
            String json = new Gson().toJson(this);
            if (json != null && json.length() > 1000) {
                UploadLog.w("Report", "json length > 1000 json:" + json);
                HashMap hashMap = new HashMap();
                hashMap.put("length", Integer.valueOf(json.length()));
                return new Gson().toJson(hashMap);
            }
            return json;
        } catch (Exception e16) {
            UploadLog.e("Report", "exception:", e16);
            return "";
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "UploadReportObj [retCode=" + this.retCode + ",errMsg=" + this.errMsg + ",flowId=" + this.flowId + ",filePath=" + this.filePath + ",uploadType=" + this.uploadType + ",uppAppId=" + this.uppAppId + ",fileSize=" + this.fileSize + ",startTime=" + this.startTime + ",endTime=" + this.endTime + ",serverIp=" + this.serverIp + ",ipsrctype=" + this.ipsrctype + ",networkType=" + this.networkType + ",retry=" + this.retry + ",source=" + this.source + ", recentApnKey=" + this.recentApnKey + ",reportType=" + this.reportType + "]";
    }
}
