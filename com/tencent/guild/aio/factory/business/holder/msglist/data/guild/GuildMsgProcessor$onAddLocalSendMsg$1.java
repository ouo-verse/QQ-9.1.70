package com.tencent.guild.aio.factory.business.holder.msglist.data.guild;

import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgProcessor;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgProcessor$onAddLocalSendMsg$1", f = "GuildMsgProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildMsgProcessor$onAddLocalSendMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.aio.data.msglist.a $msg;
    int label;
    final /* synthetic */ GuildMsgProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMsgProcessor$onAddLocalSendMsg$1(GuildMsgProcessor guildMsgProcessor, com.tencent.aio.data.msglist.a aVar, Continuation<? super GuildMsgProcessor$onAddLocalSendMsg$1> continuation) {
        super(2, continuation);
        this.this$0 = guildMsgProcessor;
        this.$msg = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMsgProcessor$onAddLocalSendMsg$1(this.this$0, this.$msg, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List listOf;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GuildMsgProcessor guildMsgProcessor = this.this$0;
            GuildMsgProcessor.HoldMsgType holdMsgType = GuildMsgProcessor.HoldMsgType.SendMsgType;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(this.$msg);
            guildMsgProcessor.d(new GuildMsgProcessor.HoldMsgInfo(holdMsgType, listOf));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMsgProcessor$onAddLocalSendMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
