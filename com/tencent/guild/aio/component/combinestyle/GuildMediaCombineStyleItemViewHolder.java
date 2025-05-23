package com.tencent.guild.aio.component.combinestyle;

import android.view.View;
import com.tencent.guild.aio.msglist.holder.config.BubbleMsgItemVBArgs;
import com.tencent.guild.aio.msglist.holder.config.GuildItemViewHolderDelegate;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/GuildMediaCombineStyleItemViewHolder;", "", "Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaCombineStyleItemViewHolder {
    @NotNull
    public final GuildItemViewHolderDelegate a() {
        GuildItemViewHolderDelegate guildItemViewHolderDelegate = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleItemViewHolder$getDelegate$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                GuildMediaCombineStyleMsgItemComponentProvider guildMediaCombineStyleMsgItemComponentProvider = new GuildMediaCombineStyleMsgItemComponentProvider(root);
                guildMediaCombineStyleMsgItemComponentProvider.i(new Function1<View, q>() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleItemViewHolder$getDelegate$1$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final q invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new q(root);
                    }
                });
                return guildMediaCombineStyleMsgItemComponentProvider;
            }
        });
        guildItemViewHolderDelegate.g(new Function0<eq0.g>() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleItemViewHolder$getDelegate$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final eq0.g invoke() {
                return new u();
            }
        });
        guildItemViewHolderDelegate.e(new Function2<com.tencent.guild.aio.msglist.holder.config.c, com.tencent.guild.aio.msglist.holder.config.d, Unit>() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleItemViewHolder$getDelegate$1$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.guild.aio.msglist.holder.config.c cVar, com.tencent.guild.aio.msglist.holder.config.d dVar) {
                invoke2(cVar, dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.guild.aio.msglist.holder.config.c cell, @NotNull com.tencent.guild.aio.msglist.holder.config.d component) {
                Intrinsics.checkNotNullParameter(cell, "cell");
                Intrinsics.checkNotNullParameter(component, "component");
                if ((component instanceof GuildMediaCombineStyleMsgItemComponentProvider) && (cell instanceof ab)) {
                    com.tencent.guild.aio.msglist.holder.component.a aVar = component.get().get(3);
                    Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleComponent");
                    ((q) aVar).a2((ab) cell);
                }
            }
        });
        guildItemViewHolderDelegate.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleItemViewHolder$getDelegate$1$4
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new t(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        guildItemViewHolderDelegate.d(new Function0<com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleItemViewHolder$getDelegate$1$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke() {
                return new r();
            }
        });
        return guildItemViewHolderDelegate;
    }
}
