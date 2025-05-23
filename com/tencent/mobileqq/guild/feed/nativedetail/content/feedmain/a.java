package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\f\u001a\u00060\nj\u0002`\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "", "getItemType", "", "getItemId", "Lhl1/g;", "newItem", "", "b", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "feedDetail", "<init>", "(Lqj1/h;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends FeedDetailMainData {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull qj1.h feedDetail) {
        super(feedDetail);
        Intrinsics.checkNotNullParameter(feedDetail, "feedDetail");
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData, hl1.g
    public boolean b(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return newItem instanceof a;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData, hl1.g
    public long getItemId() {
        return a.class.hashCode();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData, hl1.g
    public int getItemType() {
        return 3;
    }
}
