package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta$StHotTagInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"toHotEventInfo", "Lcom/tencent/biz/qqcircle/beans/HotEventInfo;", "Lfeedcloud/FeedCloudMeta$StHotTagInfo;", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class HotEventInfoKt {
    @NotNull
    public static final HotEventInfo toHotEventInfo(@NotNull FeedCloudMeta$StHotTagInfo feedCloudMeta$StHotTagInfo) {
        Intrinsics.checkNotNullParameter(feedCloudMeta$StHotTagInfo, "<this>");
        String str = feedCloudMeta$StHotTagInfo.f398452id.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.id.get()");
        int i3 = feedCloudMeta$StHotTagInfo.rank.get();
        String str2 = feedCloudMeta$StHotTagInfo.title.get();
        Intrinsics.checkNotNullExpressionValue(str2, "this.title.get()");
        String str3 = feedCloudMeta$StHotTagInfo.subTitle.get();
        Intrinsics.checkNotNullExpressionValue(str3, "this.subTitle.get()");
        String str4 = feedCloudMeta$StHotTagInfo.description.get();
        Intrinsics.checkNotNullExpressionValue(str4, "this.description.get()");
        String str5 = feedCloudMeta$StHotTagInfo.cover.picUrl.get();
        Intrinsics.checkNotNullExpressionValue(str5, "this.cover.picUrl.get()");
        return new HotEventInfo(str, i3, str2, str3, str4, str5);
    }
}
