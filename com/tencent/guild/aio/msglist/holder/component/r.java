package com.tencent.guild.aio.msglist.holder.component;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.msglist.holder.state.MsgListGiftHeadState;
import com.tencent.guild.aio.msglist.holder.state.MsgListGiftState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/r;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "", "l", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/a;", "d", "Lcom/tencent/mvi/base/route/a;", "getAction", "()Lcom/tencent/mvi/base/route/a;", "action", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class r extends t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a action = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/msglist/holder/component/r$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof GuildMsgListIntent.GuildGiftPlayEvent) {
                r.this.updateUI(new MsgListGiftState(((GuildMsgListIntent.GuildGiftPlayEvent) i3).getStop()));
            } else if (i3 instanceof GuildMsgListIntent.GuildGiftHeadUpdateEvent) {
                GuildMsgListIntent.GuildGiftHeadUpdateEvent guildGiftHeadUpdateEvent = (GuildMsgListIntent.GuildGiftHeadUpdateEvent) i3;
                r.this.updateUI(new MsgListGiftHeadState(guildGiftHeadUpdateEvent.getGuildId(), guildGiftHeadUpdateEvent.getTinyId()));
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildGiftPlayEvent.class).getQualifiedName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildGiftHeadUpdateEvent.class).getQualifiedName(), this.action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildGiftPlayEvent.class).getQualifiedName(), this.action);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildGiftHeadUpdateEvent.class).getQualifiedName(), this.action);
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        l();
    }
}
