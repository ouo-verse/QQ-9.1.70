package ns1;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.guild.base.GuildBlankActivity;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lns1/b;", "Lls1/a;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "params", "", "b", "", "a", "jump", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "c", "Z", "fromClick", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b implements ls1.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProChannelInfo channelInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FacadeArgsData facadeArgsData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean fromClick;

    public b(@NotNull IGProChannelInfo channelInfo, @NotNull FacadeArgsData facadeArgsData, boolean z16) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.channelInfo = channelInfo;
        this.facadeArgsData = facadeArgsData;
        this.fromClick = z16;
    }

    private final boolean a() {
        IGProGuildInfo L = ch.L(this.channelInfo.getGuildId());
        if (L == null || !L.isMovePostSection()) {
            return false;
        }
        return true;
    }

    private final void b(Context context, JumpGuildParam params) {
        Bundle bundle = new Bundle();
        bundle.putString("guild_id", this.channelInfo.getGuildId());
        bundle.putString("channelId", this.channelInfo.getChannelUin());
        bundle.putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, params.getJoinInfoParam());
        Bundle bundle2 = this.facadeArgsData.C;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildFeedSquareFragment(context, bundle);
    }

    @Override // ls1.a
    public boolean jump(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JumpGuildParam b16 = ls1.b.f415492a.b(this.channelInfo, this.facadeArgsData, this.fromClick);
        b16.getFeedReportSourceInfo().addReportItem("extra_feeds_pre_page_id", "pg_sgrp_sole_channel");
        if (a() && ((this.channelInfo.getType() == 7 && this.channelInfo.getCategoryType() == 1) || this.channelInfo.isHiddenPostChannel())) {
            b(context, b16);
            return true;
        }
        GuildBlankActivity.b.a(context, b16);
        o02.a.f(11);
        ((IGPSService) ch.R0(IGPSService.class)).refreshChannelInfo(this.channelInfo.getGuildId(), this.channelInfo.getChannelUin(), true, 103);
        return true;
    }
}
