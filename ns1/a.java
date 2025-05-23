package ns1;

import android.content.Context;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import k02.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lns1/a;", "Lls1/a;", "Landroid/content/Context;", "context", "", "jump", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "b", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements ls1.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProChannelInfo channelInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FacadeArgsData facadeArgsData;

    public a(@NotNull IGProChannelInfo channelInfo, @NotNull FacadeArgsData facadeArgsData) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.channelInfo = channelInfo;
        this.facadeArgsData = facadeArgsData;
    }

    @Override // ls1.a
    public boolean jump(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JumpGuildParam a16 = this.facadeArgsData.a();
        a16.getJoinInfoParam().setAfterJoinJumpChannelId(this.channelInfo.getChannelUin());
        a16.extras.putInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM, 1);
        GuildJumpDebugUtils.a("GUILD_JUMP", "StandaloneJumpApp jumpGuildParam = ", a16);
        if (a16.isGuest() && !sf1.a.INSTANCE.a(this.channelInfo.getType(), (int) this.channelInfo.getApplicationId())) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).openJoinInvitationDialog(context, a16);
        } else if (!sf1.a.INSTANCE.b(this.channelInfo.getType(), (int) this.channelInfo.getApplicationId())) {
            String str = a16.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
            GuildJumpUtil.z(context, str, a16.getChannelId(), a16.getReportSourceInfo(), null, 16, null);
        } else {
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoChannelDirectly(context, a16);
        }
        o02.a.f(11);
        ((IGPSService) ch.R0(IGPSService.class)).refreshChannelInfo(this.channelInfo.getGuildId(), this.channelInfo.getChannelUin(), true, 103);
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(this.channelInfo.getGuildId());
        if (guildInfo == null) {
            return true;
        }
        d.a(guildInfo, this.channelInfo, !guildInfo.isMember());
        return true;
    }
}
