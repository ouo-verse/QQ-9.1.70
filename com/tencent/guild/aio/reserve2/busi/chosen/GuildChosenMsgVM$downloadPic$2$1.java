package com.tencent.guild.aio.reserve2.busi.chosen;

import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgVM$downloadPic$2$1", f = "GuildChosenMsgVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GuildChosenMsgVM$downloadPic$2$1 extends SuspendLambda implements Function2<FileTransNotifyInfo, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<FileTransNotifyInfo> $continuation;
    final /* synthetic */ MsgRecord $msgRecord;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildChosenMsgVM$downloadPic$2$1(CancellableContinuation<? super FileTransNotifyInfo> cancellableContinuation, MsgRecord msgRecord, Continuation<? super GuildChosenMsgVM$downloadPic$2$1> continuation) {
        super(2, continuation);
        this.$continuation = cancellableContinuation;
        this.$msgRecord = msgRecord;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildChosenMsgVM$downloadPic$2$1 guildChosenMsgVM$downloadPic$2$1 = new GuildChosenMsgVM$downloadPic$2$1(this.$continuation, this.$msgRecord, continuation);
        guildChosenMsgVM$downloadPic$2$1.L$0 = obj;
        return guildChosenMsgVM$downloadPic$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FileTransNotifyInfo fileTransNotifyInfo, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildChosenMsgVM$downloadPic$2$1) create(fileTransNotifyInfo, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FileTransNotifyInfo fileTransNotifyInfo = (FileTransNotifyInfo) this.L$0;
            if (this.$continuation.isActive() && fileTransNotifyInfo.msgId == this.$msgRecord.msgId) {
                this.$continuation.resume(fileTransNotifyInfo, new Function1<Throwable, Unit>() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgVM$downloadPic$2$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Throwable it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }
                });
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
