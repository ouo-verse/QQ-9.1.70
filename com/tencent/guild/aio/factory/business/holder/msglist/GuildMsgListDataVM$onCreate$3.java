package com.tencent.guild.aio.factory.business.holder.msglist;

import com.tencent.guild.aio.msglist.highlight.BeforeNavigateToMsgEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lnq0/d;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM$onCreate$3", f = "GuildMsgListDataVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildMsgListDataVM$onCreate$3 extends SuspendLambda implements Function2<nq0.d, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildMsgListDataVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMsgListDataVM$onCreate$3(GuildMsgListDataVM guildMsgListDataVM, Continuation<? super GuildMsgListDataVM$onCreate$3> continuation) {
        super(2, continuation);
        this.this$0 = guildMsgListDataVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildMsgListDataVM$onCreate$3 guildMsgListDataVM$onCreate$3 = new GuildMsgListDataVM$onCreate$3(this.this$0, continuation);
        guildMsgListDataVM$onCreate$3.L$0 = obj;
        return guildMsgListDataVM$onCreate$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            nq0.d dVar = (nq0.d) this.L$0;
            QLog.i("GuildMsgListDataVM", 4, "onReceiver event=" + dVar);
            this.this$0.i0(new BeforeNavigateToMsgEvent("GuildMsgListDataVM", dVar.getMsgSeqId()));
            this.this$0.m().A(dVar.getMsgSeqId());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull nq0.d dVar, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMsgListDataVM$onCreate$3) create(dVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
