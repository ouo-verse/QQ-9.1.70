package com.tencent.mobileqq.search.report;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class ReportModel implements Serializable {
    private static final long serialVersionUID = 1;
    public int report_count = 1;
    public String uin = "";
    public String version = "";

    public abstract String toReportString();
}
