package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterViewModel$updateMessageStatus$1", f = "MessageCenterViewModel.kt", i = {}, l = {77, 78}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class MessageCenterViewModel$updateMessageStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MessageType $messageType;
    final /* synthetic */ com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e $newStatus;
    int label;
    final /* synthetic */ MessageCenterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageCenterViewModel$updateMessageStatus$1(MessageCenterViewModel messageCenterViewModel, MessageType messageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e eVar, Continuation<? super MessageCenterViewModel$updateMessageStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = messageCenterViewModel;
        this.$messageType = messageType;
        this.$newStatus = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageCenterViewModel$updateMessageStatus$1(this.this$0, this.$messageType, this.$newStatus, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ag2.b bVar;
        MutableSharedFlow mutableSharedFlow;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            bVar = this.this$0.messageTypeRepo;
            MessageType messageType = this.$messageType;
            com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e eVar = this.$newStatus;
            this.label = 1;
            obj = bVar.a(messageType, eVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        mutableSharedFlow = this.this$0._operationFlow;
        s sVar = new s(booleanValue, this.$messageType, this.$newStatus);
        this.label = 2;
        if (mutableSharedFlow.emit(sVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MessageCenterViewModel$updateMessageStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
