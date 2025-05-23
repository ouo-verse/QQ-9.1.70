package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes22.dex */
public class PageReportPolicyManager {
    private static final List<String> sNotReportList = new CopyOnWriteArrayList();

    public static String getSkipPageInfo() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = sNotReportList.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(",");
        }
        sNotReportList.clear();
        return sb5.toString();
    }

    public static void skipPageReport(PageInfo pageInfo, PageReportPolicy pageReportPolicy) {
        sNotReportList.add(pageInfo.getPageId() + "-" + pageReportPolicy.ordinal());
    }
}
