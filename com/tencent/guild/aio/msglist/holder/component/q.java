package com.tencent.guild.aio.msglist.holder.component;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001\r\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/q;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "E", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lol3/b;", "intent", "handleIntent", "com/tencent/guild/aio/msglist/holder/component/q$b", "d", "Lcom/tencent/guild/aio/msglist/holder/component/q$b;", "mAction", "<init>", "()V", "e", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class q extends t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/msglist/holder/component/q$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            q.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildEmojiSelectEvent) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                GuildEmojiSelectEvent guildEmojiSelectEvent = (GuildEmojiSelectEvent) i3;
                logger.d().d(FrameworkVM.TAG, 2, "select id:" + guildEmojiSelectEvent.getEmojiId() + ", type:" + guildEmojiSelectEvent.getEmojiType() + ", msgseq:" + guildEmojiSelectEvent.getMsg().msgSeq);
            }
            GuildEmojiSelectEvent guildEmojiSelectEvent2 = (GuildEmojiSelectEvent) i3;
            updateUI(new GuildEmojiSelectState(guildEmojiSelectEvent2.getEmojiId(), guildEmojiSelectEvent2.getEmojiType(), guildEmojiSelectEvent2.getMsg()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof u) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgListRefreshEvent(((u) intent).getTag(), null, 2, null));
        } else {
            super.handleIntent(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildEmojiSelectEvent.class).getQualifiedName(), this.mAction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildEmojiSelectEvent.class).getQualifiedName(), this.mAction);
    }
}
