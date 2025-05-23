package com.tencent.guild.aio.factory.business.holder.msglist.data.guild;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import zs.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "rsp", "", "invoke", "(Lcom/tencent/aio/msgservice/h;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMsgRepoDelegate$getLatestDbMsgs$1$1 extends Lambda implements Function1<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Unit> {
    final /* synthetic */ GuildMsgRepoDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMsgRepoDelegate$getLatestDbMsgs$1$1(GuildMsgRepoDelegate guildMsgRepoDelegate) {
        super(1);
        this.this$0 = guildMsgRepoDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildMsgRepoDelegate this$0, com.tencent.aio.msgservice.h rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        this$0.P(rsp);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar) {
        invoke2(hVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        zs.a a16 = zs.b.a(Dispatchers.INSTANCE);
        final GuildMsgRepoDelegate guildMsgRepoDelegate = this.this$0;
        a.C11711a.b(a16, new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.s
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgRepoDelegate$getLatestDbMsgs$1$1.b(GuildMsgRepoDelegate.this, rsp);
            }
        }, null, 2, null);
    }
}
