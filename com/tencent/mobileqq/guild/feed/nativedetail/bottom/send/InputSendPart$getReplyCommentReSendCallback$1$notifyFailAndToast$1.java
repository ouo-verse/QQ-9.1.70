package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.InputSendPart$getReplyCommentReSendCallback$1$notifyFailAndToast$1", f = "InputSendPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class InputSendPart$getReplyCommentReSendCallback$1$notifyFailAndToast$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errMsg;
    final /* synthetic */ a.ReplyRequestOperation $msg;
    final /* synthetic */ Pair<GProStDoReplyReq, GProStReply> $record;
    int label;
    final /* synthetic */ InputSendPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputSendPart$getReplyCommentReSendCallback$1$notifyFailAndToast$1(InputSendPart inputSendPart, String str, a.ReplyRequestOperation replyRequestOperation, Pair<GProStDoReplyReq, GProStReply> pair, Continuation<? super InputSendPart$getReplyCommentReSendCallback$1$notifyFailAndToast$1> continuation) {
        super(2, continuation);
        this.this$0 = inputSendPart;
        this.$errMsg = str;
        this.$msg = replyRequestOperation;
        this.$record = pair;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new InputSendPart$getReplyCommentReSendCallback$1$notifyFailAndToast$1(this.this$0, this.$errMsg, this.$msg, this.$record, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.ea(false, this.$errMsg);
            this.this$0.broadcastMessage("message_reply_request_operation_result", new a.ReplyRequestOperationResult(false, this.$msg, this.$record.getSecond(), this.$record.getFirst(), null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((InputSendPart$getReplyCommentReSendCallback$1$notifyFailAndToast$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
