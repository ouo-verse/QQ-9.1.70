package com.tencent.guildmedia.aio.msglist.list.data;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guildmedia.aio.msglist.list.data.GuildMediaMsgRepoDelegate$onMsgReceive$3$1", f = "GuildMediaMsgRepoDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildMediaMsgRepoDelegate$onMsgReceive$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<com.tencent.aio.data.msglist.a> $it;
    int label;
    final /* synthetic */ GuildMediaMsgRepoDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildMediaMsgRepoDelegate$onMsgReceive$3$1(List<? extends com.tencent.aio.data.msglist.a> list, GuildMediaMsgRepoDelegate guildMediaMsgRepoDelegate, Continuation<? super GuildMediaMsgRepoDelegate$onMsgReceive$3$1> continuation) {
        super(2, continuation);
        this.$it = list;
        this.this$0 = guildMediaMsgRepoDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMediaMsgRepoDelegate$onMsgReceive$3$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<com.tencent.aio.data.msglist.a> list = this.$it;
            GuildMediaMsgRepoDelegate guildMediaMsgRepoDelegate = this.this$0;
            for (com.tencent.aio.data.msglist.a aVar : list) {
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                QLog.i("GuildMediaMsgRepoDelegate", 1, "onMsgReceive, msgChannelId:" + ((GuildMsgItem) aVar).getMsgRecord().peerUid + ", seq:" + aVar.getMsgSeq());
                GuildMediaMsgRepoDelegate.E(guildMediaMsgRepoDelegate, (GuildMsgItem) aVar, false, false, 6, null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMediaMsgRepoDelegate$onMsgReceive$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
