package com.tencent.mobileqq.springhb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ReportInfo implements Serializable {
    static IPatchRedirector $redirector_;
    static long curUniqueSeq;
    public int activityType;
    public String bussId;
    public int count;
    public Map<String, String> extParams;
    public String fromSrc;
    boolean isRealTime;
    transient boolean isSending;
    public String moduleId;
    public long opTime;
    public String operationCode;
    public int reportType;
    long reqSeq;
    int retryCount;
    public String subModuleId;
    long uniqueSeq;
    public ArrayList<Long> uniqueSeqMergeList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26009);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            curUniqueSeq = 0L;
        }
    }

    public ReportInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.uniqueSeqMergeList = new ArrayList<>();
            this.isSending = false;
        }
    }

    private boolean a(Map<String, String> map, Map<String, String> map2) {
        if (map == map2) {
            return true;
        }
        if (map != null && map2 != null) {
            return map.equals(map2);
        }
        return false;
    }

    public static ReportInfo create(String str, String str2, String str3, String str4, String str5, Map<String, String> map, boolean z16, int i3, int i16) {
        ReportInfo reportInfo = new ReportInfo();
        long j3 = curUniqueSeq + 1;
        curUniqueSeq = j3;
        reportInfo.uniqueSeq = j3;
        reportInfo.uniqueSeqMergeList.add(Long.valueOf(j3));
        reportInfo.bussId = str;
        reportInfo.fromSrc = str2;
        reportInfo.moduleId = str3;
        reportInfo.subModuleId = str4;
        reportInfo.operationCode = str5;
        reportInfo.opTime = NetConnInfoCenter.getServerTimeMillis();
        reportInfo.count = 1;
        reportInfo.extParams = map;
        reportInfo.isRealTime = z16;
        reportInfo.reportType = i3;
        reportInfo.activityType = i16;
        return reportInfo;
    }

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.bussId) && !TextUtils.isEmpty(this.operationCode)) {
            return true;
        }
        return false;
    }

    public boolean merge(ReportInfo reportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) reportInfo)).booleanValue();
        }
        if (reportInfo == null || !TextUtils.equals(this.bussId, reportInfo.bussId) || !TextUtils.equals(this.fromSrc, reportInfo.fromSrc) || !TextUtils.equals(this.moduleId, reportInfo.moduleId) || !TextUtils.equals(this.subModuleId, reportInfo.subModuleId) || !TextUtils.equals(this.operationCode, reportInfo.operationCode) || !a(this.extParams, reportInfo.extParams)) {
            return false;
        }
        this.opTime = Math.max(this.opTime, reportInfo.opTime);
        this.count += reportInfo.count;
        this.uniqueSeqMergeList.addAll(reportInfo.uniqueSeqMergeList);
        return true;
    }

    public String toSimpleString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "ReportInfo{uni_seq = " + this.uniqueSeq + ", r_c = " + this.retryCount + ", i_s = " + this.isSending + ", c = " + this.count + ", uni_seq_list = " + this.uniqueSeqMergeList + '}';
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ReportInfo{r_t = " + this.reportType + ", uni_seq = " + this.uniqueSeq + ", r_s = " + this.reqSeq + ", b = " + this.bussId + ", f = " + this.fromSrc + ", m = " + this.moduleId + ", s = " + this.subModuleId + ", o = " + this.operationCode + "\uff0ctime = " + this.opTime + ", iRT = " + this.isRealTime + ", c : " + this.count + ", uni_seq_list = " + this.uniqueSeqMergeList + '}';
    }
}
