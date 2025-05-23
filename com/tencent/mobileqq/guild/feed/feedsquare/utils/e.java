package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/e;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/c;", "Lij1/h;", "a", "Lij1/h;", "feed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStChannelSign;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStChannelSign;", "sign", "", "b", "()I", "cardType", "", "getScheduleId", "()Ljava/lang/Long;", "scheduleId", "<init>", "(Lij1/h;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ij1.h feed;

    public e(@NotNull ij1.h feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.feed = feed;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.utils.c
    @NotNull
    public GProStChannelSign a() {
        GProStChannelSign gProStChannelSign = this.feed.I;
        Intrinsics.checkNotNullExpressionValue(gProStChannelSign, "feed.stChannelSign");
        return gProStChannelSign;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.utils.c
    public int b() {
        return this.feed.Q;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.utils.c
    @NotNull
    public Long getScheduleId() {
        return Long.valueOf(this.feed.R);
    }
}
