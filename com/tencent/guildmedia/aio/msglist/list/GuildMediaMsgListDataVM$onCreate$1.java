package com.tencent.guildmedia.aio.msglist.list;

import com.tencent.guildmedia.utils.GuildMediaLogUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import nq0.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lnq0/d;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guildmedia.aio.msglist.list.GuildMediaMsgListDataVM$onCreate$1", f = "GuildMediaMsgListDataVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildMediaMsgListDataVM$onCreate$1 extends SuspendLambda implements Function2<d, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildMediaMsgListDataVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaMsgListDataVM$onCreate$1(GuildMediaMsgListDataVM guildMediaMsgListDataVM, Continuation<? super GuildMediaMsgListDataVM$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = guildMediaMsgListDataVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildMediaMsgListDataVM$onCreate$1 guildMediaMsgListDataVM$onCreate$1 = new GuildMediaMsgListDataVM$onCreate$1(this.this$0, continuation);
        guildMediaMsgListDataVM$onCreate$1.L$0 = obj;
        return guildMediaMsgListDataVM$onCreate$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            d dVar = (d) this.L$0;
            GuildMediaLogUtil.INSTANCE.c("GuildMediaMsgListDataVM", "onReceiver event=" + dVar);
            this.this$0.m().A(dVar.getMsgSeqId());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull d dVar, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMediaMsgListDataVM$onCreate$1) create(dVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
