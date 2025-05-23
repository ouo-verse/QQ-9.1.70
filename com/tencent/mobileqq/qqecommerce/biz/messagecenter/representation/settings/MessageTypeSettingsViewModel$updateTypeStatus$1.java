package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings.MessageTypeSettingsViewModel;
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
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings.MessageTypeSettingsViewModel$updateTypeStatus$1", f = "MessageTypeSettingsViewModel.kt", i = {}, l = {39, 40}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class MessageTypeSettingsViewModel$updateTypeStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $newStatus;
    final /* synthetic */ e $oldStatus;
    final /* synthetic */ MessageType $type;
    int label;
    final /* synthetic */ MessageTypeSettingsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageTypeSettingsViewModel$updateTypeStatus$1(MessageTypeSettingsViewModel messageTypeSettingsViewModel, MessageType messageType, e eVar, e eVar2, Continuation<? super MessageTypeSettingsViewModel$updateTypeStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = messageTypeSettingsViewModel;
        this.$type = messageType;
        this.$newStatus = eVar;
        this.$oldStatus = eVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageTypeSettingsViewModel$updateTypeStatus$1(this.this$0, this.$type, this.$newStatus, this.$oldStatus, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ag2.b bVar;
        MutableSharedFlow mutableSharedFlow;
        e eVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            bVar = this.this$0.repo;
            MessageType messageType = this.$type;
            e eVar2 = this.$newStatus;
            this.label = 1;
            obj = bVar.a(messageType, eVar2, this);
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
        mutableSharedFlow = this.this$0._updateResult;
        MessageType messageType2 = this.$type;
        if (booleanValue) {
            eVar = this.$newStatus;
        } else {
            eVar = this.$oldStatus;
        }
        MessageTypeSettingsViewModel.UpdateItemResult updateItemResult = new MessageTypeSettingsViewModel.UpdateItemResult(booleanValue, messageType2, eVar);
        this.label = 2;
        if (mutableSharedFlow.emit(updateItemResult, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MessageTypeSettingsViewModel$updateTypeStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
