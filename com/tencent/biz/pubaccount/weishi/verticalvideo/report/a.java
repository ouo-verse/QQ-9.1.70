package com.tencent.biz.pubaccount.weishi.verticalvideo.report;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.bb;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {
    private static void a(WSStatisticsReporter.Builder builder, String str) {
        builder.build(str).report();
    }

    public static void b(String str, int i3, stSimpleMetaFeed stsimplemetafeed) {
        WSStatisticsReporter.Builder operationId = new WSStatisticsReporter.Builder().setSopName("chat_page").setTestId(bb.x(10007)).setPushId("").setFlush(true).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("content", i3, stsimplemetafeed)).setOperationId("");
        HashMap hashMap = new HashMap();
        hashMap.put("qq_group_num", str);
        hashMap.put("card_type", "1");
        operationId.addExtParams(hashMap);
        a(operationId, "gzh_click");
    }
}
