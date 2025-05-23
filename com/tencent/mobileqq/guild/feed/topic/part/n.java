package com.tencent.mobileqq.guild.feed.topic.part;

import android.view.View;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/n;", "Lcom/tencent/mobileqq/guild/feed/topic/part/TopicBasePart;", "Landroid/view/View;", "v", "", "onInitView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n extends TopicBasePart {
    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View v3) {
        Map mutableMap;
        Intrinsics.checkNotNullParameter(v3, "v");
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(getPartRootView(), "pg_sgrp_forum_topic");
        VideoReport.setPageReportPolicy(getPartRootView(), PageReportPolicy.REPORT_ALL);
        View partRootView = getPartRootView();
        mutableMap = MapsKt__MapsKt.toMutableMap(x9().d());
        mutableMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        mutableMap.put("sgrp_topic_id", String.valueOf(z9().getTopicId()));
        mutableMap.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(z9().getGuildId())));
        mutableMap.put("sgrp_channel_id", z9().getGuildId());
        VideoReport.setPageParams(partRootView, new PageParams((Map<String, ?>) mutableMap));
        com.tencent.mobileqq.guild.report.b.i("pg_sgrp_forum_topic", "TopicReportPart");
    }
}
