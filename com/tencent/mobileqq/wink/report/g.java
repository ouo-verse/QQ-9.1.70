package com.tencent.mobileqq.wink.report;

import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;

/* compiled from: P */
/* loaded from: classes21.dex */
public class g {
    public static void a() {
        y53.e.d().f("key_auto_template_to_edit_page");
    }

    public static void b(String str, String str2) {
        WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("P_JUMP_PAGE_TIME_COST");
        if (str2 == null) {
            str2 = "";
        }
        y53.e.d().e(str, "key_auto_template_to_edit_page", eventId.traceId(str2).ext2("key_auto_template_to_edit_page").getReportData());
    }

    public static void c() {
        y53.e.d().f("key_next_step_to_edit_page");
    }

    public static void d(String str, String str2) {
        WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("P_JUMP_PAGE_TIME_COST");
        if (str2 == null) {
            str2 = "";
        }
        y53.e.d().e(str, "key_next_step_to_edit_page", eventId.traceId(str2).ext2("key_next_step_to_edit_page").getReportData());
    }
}
