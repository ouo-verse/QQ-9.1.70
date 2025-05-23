package com.tencent.guildlive.aio.msglist.list;

import com.tencent.guildlive.utils.GuildLiveLogUtil;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lnq0/d;", "event", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guildlive.aio.msglist.list.GuildLiveMsgListDataVM$onCreate$1", f = "GuildLiveMsgListDataVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildLiveMsgListDataVM$onCreate$1 extends SuspendLambda implements Function2<nq0.d, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildLiveMsgListDataVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildLiveMsgListDataVM$onCreate$1(GuildLiveMsgListDataVM guildLiveMsgListDataVM, Continuation<? super GuildLiveMsgListDataVM$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = guildLiveMsgListDataVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildLiveMsgListDataVM$onCreate$1 guildLiveMsgListDataVM$onCreate$1 = new GuildLiveMsgListDataVM$onCreate$1(this.this$0, continuation);
        guildLiveMsgListDataVM$onCreate$1.L$0 = obj;
        return guildLiveMsgListDataVM$onCreate$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        HashSet hashSet;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            nq0.d dVar = (nq0.d) this.L$0;
            GuildLiveLogUtil.INSTANCE.e("GuildLiveMsgListDataVM", "onReceiver event=" + dVar);
            hashSet = this.this$0.pendingHighLightMsgSeqSet;
            hashSet.add(Boxing.boxLong(dVar.getMsgSeqId()));
            this.this$0.m().A(dVar.getMsgSeqId());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull nq0.d dVar, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildLiveMsgListDataVM$onCreate$1) create(dVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
