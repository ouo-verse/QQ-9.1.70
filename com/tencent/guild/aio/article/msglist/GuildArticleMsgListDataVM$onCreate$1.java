package com.tencent.guild.aio.article.msglist;

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

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lnq0/d;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.article.msglist.GuildArticleMsgListDataVM$onCreate$1", f = "GuildArticleMsgListDataVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GuildArticleMsgListDataVM$onCreate$1 extends SuspendLambda implements Function2<nq0.d, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildArticleMsgListDataVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildArticleMsgListDataVM$onCreate$1(GuildArticleMsgListDataVM guildArticleMsgListDataVM, Continuation<? super GuildArticleMsgListDataVM$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = guildArticleMsgListDataVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildArticleMsgListDataVM$onCreate$1 guildArticleMsgListDataVM$onCreate$1 = new GuildArticleMsgListDataVM$onCreate$1(this.this$0, continuation);
        guildArticleMsgListDataVM$onCreate$1.L$0 = obj;
        return guildArticleMsgListDataVM$onCreate$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            nq0.d dVar = (nq0.d) this.L$0;
            QLog.i("GuildArticleMsgListDataVM", 4, "onReceiver event=" + dVar);
            this.this$0.m().A(dVar.getMsgSeqId());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull nq0.d dVar, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildArticleMsgListDataVM$onCreate$1) create(dVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
