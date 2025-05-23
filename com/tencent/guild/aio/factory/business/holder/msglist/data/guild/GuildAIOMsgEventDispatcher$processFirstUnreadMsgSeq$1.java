package com.tencent.guild.aio.factory.business.holder.msglist.data.guild;

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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/msg/api/c;", "", "rsp", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildAIOMsgEventDispatcher$processFirstUnreadMsgSeq$1", f = "GuildAIOMsgEventDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildAIOMsgEventDispatcher$processFirstUnreadMsgSeq$1 extends SuspendLambda implements Function2<com.tencent.qqnt.msg.api.c<Long>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildAIOMsgEventDispatcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAIOMsgEventDispatcher$processFirstUnreadMsgSeq$1(GuildAIOMsgEventDispatcher guildAIOMsgEventDispatcher, Continuation<? super GuildAIOMsgEventDispatcher$processFirstUnreadMsgSeq$1> continuation) {
        super(2, continuation);
        this.this$0 = guildAIOMsgEventDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildAIOMsgEventDispatcher$processFirstUnreadMsgSeq$1 guildAIOMsgEventDispatcher$processFirstUnreadMsgSeq$1 = new GuildAIOMsgEventDispatcher$processFirstUnreadMsgSeq$1(this.this$0, continuation);
        guildAIOMsgEventDispatcher$processFirstUnreadMsgSeq$1.L$0 = obj;
        return guildAIOMsgEventDispatcher$processFirstUnreadMsgSeq$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.qqnt.msg.api.c<Long> cVar, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildAIOMsgEventDispatcher$processFirstUnreadMsgSeq$1) create(cVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            com.tencent.qqnt.msg.api.c cVar = (com.tencent.qqnt.msg.api.c) this.L$0;
            QLog.d("GuildMsgListRepo", 1, "getFirstUnreadMsgSeq result=" + cVar.c() + ", errMsg=" + cVar.b() + ", seq=" + cVar.a());
            if (cVar.d()) {
                this.this$0.mLastHasReadMsgSeq = ((Number) cVar.a()).longValue() - 1;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
