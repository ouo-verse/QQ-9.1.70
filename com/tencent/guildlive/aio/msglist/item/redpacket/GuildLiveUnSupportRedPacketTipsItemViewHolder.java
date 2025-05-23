package com.tencent.guildlive.aio.msglist.item.redpacket;

import android.view.View;
import com.tencent.guild.aio.msglist.holder.config.BubbleMsgItemVBArgs;
import com.tencent.guild.aio.msglist.holder.config.GuildItemViewHolderDelegate;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guildlive.aio.msglist.holder.GuildLiveMsgItemComponentProvider;
import eq0.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/item/redpacket/GuildLiveUnSupportRedPacketTipsItemViewHolder;", "", "Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;", "a", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveUnSupportRedPacketTipsItemViewHolder {
    @NotNull
    public GuildItemViewHolderDelegate a() {
        GuildItemViewHolderDelegate guildItemViewHolderDelegate = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.guildlive.aio.msglist.item.redpacket.GuildLiveUnSupportRedPacketTipsItemViewHolder$getDelegate$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                GuildLiveMsgItemComponentProvider guildLiveMsgItemComponentProvider = new GuildLiveMsgItemComponentProvider(root);
                guildLiveMsgItemComponentProvider.k(new Function1<View, GuildLiveUnSupportRedPacketContentComponent>() { // from class: com.tencent.guildlive.aio.msglist.item.redpacket.GuildLiveUnSupportRedPacketTipsItemViewHolder$getDelegate$1$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final GuildLiveUnSupportRedPacketContentComponent invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildLiveUnSupportRedPacketContentComponent(root);
                    }
                });
                return guildLiveMsgItemComponentProvider;
            }
        });
        guildItemViewHolderDelegate.g(new Function0<g>() { // from class: com.tencent.guildlive.aio.msglist.item.redpacket.GuildLiveUnSupportRedPacketTipsItemViewHolder$getDelegate$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                return new ms0.b();
            }
        });
        guildItemViewHolderDelegate.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guildlive.aio.msglist.item.redpacket.GuildLiveUnSupportRedPacketTipsItemViewHolder$getDelegate$1$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guildlive.aio.msglist.holder.c(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        guildItemViewHolderDelegate.d(new Function0<com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guildlive.aio.msglist.item.redpacket.GuildLiveUnSupportRedPacketTipsItemViewHolder$getDelegate$1$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke() {
                return new com.tencent.guildlive.aio.msglist.holder.a();
            }
        });
        return guildItemViewHolderDelegate;
    }
}
