package com.tencent.mobileqq.guild.feed.share;

import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.usecases.GuildFeedArkShareInfo;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\n\u0010\f\u001a\u00020\u0002*\u00020\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/share/y;", "", "", "guildId", "b", "Lvk1/b;", "feed", "Lcom/tencent/mobileqq/guild/feed/usecases/GuildFeedArkShareInfo;", "shareInfo", "", "a", "", "c", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final y f223454a = new y();

    y() {
    }

    private final String b(String guildId) {
        IGProGuildInfo guildInfo = ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(guildId);
        if (guildInfo == null) {
            return "";
        }
        String guildName = guildInfo.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "guildInfo.guildName");
        return guildName;
    }

    public final void a(@NotNull vk1.b feed, @NotNull GuildFeedArkShareInfo shareInfo) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        shareInfo.d0(String.valueOf(feed.getGuildId()));
        shareInfo.M(String.valueOf(feed.getChannelId()));
        shareInfo.b0(feed.getFeedId());
        shareInfo.Z(feed.getCreateTime());
        shareInfo.j0(MiscKt.l(feed.r()));
        shareInfo.N(feed.getCommentCount() + feed.e());
        String L = feed.L();
        if (L == null) {
            L = "";
        }
        shareInfo.i0(L);
        y yVar = f223454a;
        shareInfo.h0(yVar.b(shareInfo.p()));
        shareInfo.g0(yVar.c(feed.x()));
        shareInfo.c0(((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).functionListToStr(feed.getFunctionList()));
    }

    @NotNull
    public final String c(boolean z16) {
        if (z16) {
            return "1";
        }
        return "0";
    }
}
