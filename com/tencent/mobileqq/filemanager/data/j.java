package com.tencent.mobileqq.filemanager.data;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f207792a = "actFilePreview";

    /* renamed from: b, reason: collision with root package name */
    public long f207793b;

    /* renamed from: c, reason: collision with root package name */
    public String f207794c;

    /* renamed from: d, reason: collision with root package name */
    public String f207795d;

    /* renamed from: e, reason: collision with root package name */
    public String f207796e;

    /* renamed from: f, reason: collision with root package name */
    public long f207797f;

    /* renamed from: g, reason: collision with root package name */
    public String f207798g;

    /* renamed from: h, reason: collision with root package name */
    public String f207799h;

    /* renamed from: i, reason: collision with root package name */
    public int f207800i;

    /* renamed from: j, reason: collision with root package name */
    public String f207801j;

    /* renamed from: k, reason: collision with root package name */
    public String f207802k;

    /* renamed from: l, reason: collision with root package name */
    public String f207803l;

    /* renamed from: m, reason: collision with root package name */
    public String f207804m;

    /* renamed from: n, reason: collision with root package name */
    public String f207805n;

    /* renamed from: o, reason: collision with root package name */
    public long f207806o;

    /* renamed from: p, reason: collision with root package name */
    public long f207807p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f207808q;

    /* renamed from: r, reason: collision with root package name */
    String f207809r;

    /* renamed from: s, reason: collision with root package name */
    public long f207810s;

    /* renamed from: t, reason: collision with root package name */
    public long f207811t;

    public j(String str) {
        this.f207809r = str;
    }

    private HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            this.f207796e = String.valueOf(9004);
            this.f207802k += "_NotNetWork";
        }
        hashMap.put("param_serverip", String.valueOf(this.f207794c));
        hashMap.put(ReportConstant.KEY_UUID, String.valueOf(this.f207795d));
        hashMap.put("param_FailCode", String.valueOf(this.f207796e));
        hashMap.put("param_fsizeo", String.valueOf(this.f207797f));
        hashMap.put("param_url", String.valueOf(this.f207798g));
        hashMap.put("param_key", String.valueOf(this.f207799h));
        hashMap.put("param_retry", String.valueOf(this.f207800i));
        hashMap.put("param_errMsg", String.valueOf(this.f207802k));
        hashMap.put("param_fileName", String.valueOf(this.f207801j));
        hashMap.put("param_fileExt", String.valueOf(this.f207803l));
        hashMap.put("param_source", String.valueOf(this.f207804m));
        hashMap.put("param_stage", String.valueOf(this.f207805n));
        hashMap.put("param_stagetimelen", String.valueOf(this.f207806o));
        hashMap.put("param_staytimelen", String.valueOf(this.f207807p));
        this.f207802k = "";
        return hashMap;
    }

    public void b() {
        HashMap<String, String> a16 = a();
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doReport:bSuccess[" + this.f207808q + "],");
            sb5.append("strReportUin[" + this.f207809r + "],");
            sb5.append("startTime[" + this.f207810s + "],");
            sb5.append("endTime[" + this.f207811t + "],");
            for (String str : a16.keySet()) {
                sb5.append(str + "[" + a16.get(str) + "]");
            }
            QLog.i("FilePreviewDataReporter<FileAssistant>", 4, "doReport:" + sb5.toString());
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f207809r, "actFilePreview", this.f207808q, 0L, 0L, a16, "");
    }
}
