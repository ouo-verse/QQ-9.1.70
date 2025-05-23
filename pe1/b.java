package pe1;

import com.tencent.guild.aio.component.combinestyle.GuildMediaAioCombineStyleChain;
import com.tencent.guild.aio.component.combinestyle.aa;
import com.tencent.guild.aio.component.combinestyle.af;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aiocombinestyle.component.local.LocalCombineStyleChainFactory;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lpe1/b;", "Lcom/tencent/guild/aio/component/combinestyle/af;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "combineStyleAioItem", "Lcom/tencent/guild/aio/component/combinestyle/i;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b implements af {
    @Override // com.tencent.guild.aio.component.combinestyle.af
    @NotNull
    public GuildMediaAioCombineStyleChain a(@NotNull GuildMsgItem guildMsgItem, @NotNull aa combineStyleAioItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
        Intrinsics.checkNotNullParameter(combineStyleAioItem, "combineStyleAioItem");
        LocalCombineStyleChainFactory localCombineStyleChainFactory = LocalCombineStyleChainFactory.f213886a;
        Integer valueOf = Integer.valueOf(R.drawable.guild_live_channel_icon_system_head);
        String liveChannelSecurityMsgText = ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).getLiveChannelSecurityMsgText(combineStyleAioItem.getActivity());
        Intrinsics.checkNotNullExpressionValue(liveChannelSecurityMsgText, "api(IGuildLiveChannelApi\u2026yleAioItem.getActivity())");
        return LocalCombineStyleChainFactory.b(localCombineStyleChainFactory, valueOf, liveChannelSecurityMsgText, UIUtil.f112434a.x().getString(R.string.f147560x8) + "\uff1a", null, 0, 24, null);
    }
}
