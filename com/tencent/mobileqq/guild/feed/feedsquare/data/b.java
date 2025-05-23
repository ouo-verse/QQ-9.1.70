package com.tencent.mobileqq.guild.feed.feedsquare.data;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR$\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\t\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/b;", "", "", "a", "Z", "c", "()Z", QAdRewardDefine$VideoParams.ISCACHE, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetGuildFeedsRsp;", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetGuildFeedsRsp;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetGuildFeedsRsp;", "gProGetGuildFeedsRsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", "setNotificationItem", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;)V", "notificationItem", "<init>", "(ZLcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetGuildFeedsRsp;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProGetGuildFeedsRsp gProGetGuildFeedsRsp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildInteractiveNotificationItem notificationItem;

    public b(boolean z16, @NotNull GProGetGuildFeedsRsp gProGetGuildFeedsRsp, @Nullable GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
        Intrinsics.checkNotNullParameter(gProGetGuildFeedsRsp, "gProGetGuildFeedsRsp");
        this.isCache = z16;
        this.gProGetGuildFeedsRsp = gProGetGuildFeedsRsp;
        this.notificationItem = guildInteractiveNotificationItem;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GProGetGuildFeedsRsp getGProGetGuildFeedsRsp() {
        return this.gProGetGuildFeedsRsp;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final GuildInteractiveNotificationItem getNotificationItem() {
        return this.notificationItem;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsCache() {
        return this.isCache;
    }
}
