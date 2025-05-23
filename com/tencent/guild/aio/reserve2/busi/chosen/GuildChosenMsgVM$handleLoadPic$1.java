package com.tencent.guild.aio.reserve2.busi.chosen;

import com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgState;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.tencent.guild.aio.reserve2.busi.chosen.GuildChosenMsgVM$handleLoadPic$1", f = "GuildChosenMsgVM.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildChosenMsgVM$handleLoadPic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $downloadType;
    final /* synthetic */ MsgRecord $msgRecord;
    int label;
    final /* synthetic */ GuildChosenMsgVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChosenMsgVM$handleLoadPic$1(GuildChosenMsgVM guildChosenMsgVM, MsgRecord msgRecord, int i3, Continuation<? super GuildChosenMsgVM$handleLoadPic$1> continuation) {
        super(2, continuation);
        this.this$0 = guildChosenMsgVM;
        this.$msgRecord = msgRecord;
        this.$downloadType = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildChosenMsgVM$handleLoadPic$1(this.this$0, this.$msgRecord, this.$downloadType, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            GuildChosenMsgVM guildChosenMsgVM = this.this$0;
            MsgRecord msgRecord = this.$msgRecord;
            int i16 = this.$downloadType;
            this.label = 1;
            obj = guildChosenMsgVM.A(msgRecord, i16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.this$0.updateUI(new GuildChosenMsgState.GuildUpdatePicIvUIState(this.$msgRecord.msgSeq, ((FileTransNotifyInfo) obj).filePath));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildChosenMsgVM$handleLoadPic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
