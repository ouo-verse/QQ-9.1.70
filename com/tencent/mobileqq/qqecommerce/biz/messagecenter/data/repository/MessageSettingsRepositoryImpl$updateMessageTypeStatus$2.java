package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import yf2.a;
import yf2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageSettingsRepositoryImpl$updateMessageTypeStatus$2", f = "MessageSettingsRepositoryImpl.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class MessageSettingsRepositoryImpl$updateMessageTypeStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ MessageType $messageType;
    final /* synthetic */ e $messageTypeStatus;
    int label;
    final /* synthetic */ MessageSettingsRepositoryImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSettingsRepositoryImpl$updateMessageTypeStatus$2(MessageSettingsRepositoryImpl messageSettingsRepositoryImpl, MessageType messageType, e eVar, Continuation<? super MessageSettingsRepositoryImpl$updateMessageTypeStatus$2> continuation) {
        super(2, continuation);
        this.this$0 = messageSettingsRepositoryImpl;
        this.$messageType = messageType;
        this.$messageTypeStatus = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageSettingsRepositoryImpl$updateMessageTypeStatus$2(this.this$0, this.$messageType, this.$messageTypeStatus, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        b bVar;
        a aVar;
        MutableLiveData mutableLiveData;
        a aVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            bVar = this.this$0.remoteDataSource;
            MessageType messageType = this.$messageType;
            e eVar = this.$messageTypeStatus;
            this.label = 1;
            obj = bVar.g(messageType, eVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (booleanValue) {
            aVar = this.this$0.localDataSource;
            aVar.c(this.$messageType, this.$messageTypeStatus);
            mutableLiveData = this.this$0._settings;
            aVar2 = this.this$0.localDataSource;
            mutableLiveData.postValue(aVar2.a());
        }
        return Boxing.boxBoolean(booleanValue);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((MessageSettingsRepositoryImpl$updateMessageTypeStatus$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
