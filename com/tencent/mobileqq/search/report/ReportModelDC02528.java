package com.tencent.mobileqq.search.report;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ReportModelDC02528 extends ReportModel {

    /* renamed from: ts, reason: collision with root package name */
    protected long f283715ts;
    protected final String platform = "Android";
    public String opername = " ";
    public String module = " ";
    public String action = " ";
    public String obj1 = " ";
    public String obj2 = " ";
    public String obj3 = " ";
    public String ver1 = " ";
    public String ver2 = " ";
    public String ver3 = " ";
    public String ver4 = " ";
    public String ver5 = " ";
    public String ver6 = " ";
    public String ver7 = " ";
    public int app_version = 0;
    public String session_id = " ";

    public ReportModelDC02528() {
        opername("Grp_all_search");
    }

    public ReportModelDC02528 action(String str) {
        this.action = str;
        return this;
    }

    public ReportModelDC02528 app_version(int i3) {
        this.app_version = i3;
        return this;
    }

    public ReportModelDC02528 module(String str) {
        this.module = str;
        return this;
    }

    public ReportModelDC02528 obj1(String str) {
        this.obj1 = str;
        return this;
    }

    public ReportModelDC02528 obj2(String str) {
        this.obj2 = str;
        return this;
    }

    public ReportModelDC02528 obj3(String str) {
        this.obj3 = str;
        return this;
    }

    public ReportModelDC02528 opername(String str) {
        this.opername = str;
        return this;
    }

    public ReportModelDC02528 session_id(String str) {
        this.session_id = str;
        return this;
    }

    @Override // com.tencent.mobileqq.search.report.ReportModel
    public String toReportString() {
        this.f283715ts = System.currentTimeMillis();
        return this.f283715ts + "|" + this.uin + "|" + this.opername + "|" + this.module + "|" + this.action + "|Android|" + this.version + "|" + this.obj1 + "|" + this.obj2 + "|" + this.obj3 + "|" + this.ver1 + "|" + this.ver2 + "|" + this.ver3 + "|" + this.ver4 + "|" + this.ver5 + "|" + this.ver6 + "|" + this.ver7 + "|" + this.app_version + "|" + this.session_id;
    }

    public String toString() {
        return "ReportModelDC02528{report_count=" + this.report_count + ", uin='" + this.uin + "', ts=" + this.f283715ts + ", version='" + this.version + "', platform='Android', opername='" + this.opername + "', module='" + this.module + "', action='" + this.action + "', obj1='" + this.obj1 + "', obj2='" + this.obj2 + "', obj3='" + this.obj3 + "', ver1='" + this.ver1 + "', ver2='" + this.ver2 + "', ver3='" + this.ver3 + "', ver4='" + this.ver4 + "', ver5='" + this.ver5 + "', ver6='" + this.ver6 + "', ver7='" + this.ver7 + "', app_version=" + this.app_version + ", session_id='" + this.session_id + "'}";
    }

    public ReportModelDC02528 ver1(String str) {
        this.ver1 = str;
        return this;
    }

    public ReportModelDC02528 ver2(String str) {
        this.ver2 = str;
        return this;
    }

    public ReportModelDC02528 ver3(String str) {
        this.ver3 = str;
        return this;
    }

    public ReportModelDC02528 ver4(String str) {
        this.ver4 = str;
        return this;
    }

    public ReportModelDC02528 ver5(String str) {
        this.ver5 = str;
        return this;
    }

    public ReportModelDC02528 ver6(String str) {
        this.ver6 = str;
        return this;
    }

    public ReportModelDC02528 ver7(String str) {
        this.ver7 = str;
        return this;
    }
}
