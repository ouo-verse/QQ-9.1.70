package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendDataUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "data", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;)V", "getData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class RecommendDataUpdateEvent extends SimpleBaseEvent {

    @NotNull
    private final RecommendAbsFeedData data;

    public RecommendDataUpdateEvent(@NotNull RecommendAbsFeedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    @NotNull
    public final RecommendAbsFeedData getData() {
        return this.data;
    }
}
