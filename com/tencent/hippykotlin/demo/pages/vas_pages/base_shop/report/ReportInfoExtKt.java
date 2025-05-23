package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.report;

import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ReportInfoExtKt {
    public static final BaseReportInfo getReportInfo(VasBasePage vasBasePage) {
        Object obj = vasBasePage.getExtProps().get("shopReportInfo");
        if (obj instanceof BaseReportInfo) {
            return (BaseReportInfo) obj;
        }
        return null;
    }
}
