package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.UIState;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.MutableStateFlow;
import wf2.NetworkResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl$triggerFirstFetchMessages$2", f = "MessageRepositoryImpl.kt", i = {0, 1}, l = {107, 108, 111}, m = "invokeSuspend", n = {"remoteJob", "localResult"}, s = {"L$0", "L$0"})
/* loaded from: classes35.dex */
public final class MessageRepositoryImpl$triggerFirstFetchMessages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageRepositoryImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRepositoryImpl$triggerFirstFetchMessages$2(MessageRepositoryImpl messageRepositoryImpl, Continuation<? super MessageRepositoryImpl$triggerFirstFetchMessages$2> continuation) {
        super(2, continuation);
        this.this$0 = messageRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MessageRepositoryImpl$triggerFirstFetchMessages$2 messageRepositoryImpl$triggerFirstFetchMessages$2 = new MessageRepositoryImpl$triggerFirstFetchMessages$2(this.this$0, continuation);
        messageRepositoryImpl$triggerFirstFetchMessages$2.L$0 = obj;
        return messageRepositoryImpl$triggerFirstFetchMessages$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        Deferred deferred;
        NetworkResult networkResult;
        MutableStateFlow mutableStateFlow;
        MessageRepositoryImpl.b bVar;
        List emptyList;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new MessageRepositoryImpl$triggerFirstFetchMessages$2$localJob$1(this.this$0, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new MessageRepositoryImpl$triggerFirstFetchMessages$2$remoteJob$1(this.this$0, async$default, null), 3, null);
            this.L$0 = async$default2;
            this.label = 1;
            Object await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            deferred = async$default2;
            obj = await;
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                networkResult = (NetworkResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                NetworkResult networkResult2 = (NetworkResult) obj;
                if (networkResult.a().isEmpty() && !networkResult2.getIsSucceed()) {
                    QLog.e("ECMsgCenter|MessageRepositoryImpl", 1, "triggerFetchMessages both sources failed.");
                    mutableStateFlow = this.this$0._messagesState;
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    bVar = new MessageRepositoryImpl.b(emptyList, true, UIState.FAILED, new byte[0]);
                    this.L$0 = null;
                    this.label = 3;
                    if (mutableStateFlow.emit(bVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            deferred = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        NetworkResult networkResult3 = (NetworkResult) obj;
        this.L$0 = networkResult3;
        this.label = 2;
        Object await2 = deferred.await(this);
        if (await2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        networkResult = networkResult3;
        obj = await2;
        NetworkResult networkResult22 = (NetworkResult) obj;
        if (networkResult.a().isEmpty()) {
            QLog.e("ECMsgCenter|MessageRepositoryImpl", 1, "triggerFetchMessages both sources failed.");
            mutableStateFlow = this.this$0._messagesState;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            bVar = new MessageRepositoryImpl.b(emptyList, true, UIState.FAILED, new byte[0]);
            this.L$0 = null;
            this.label = 3;
            if (mutableStateFlow.emit(bVar, this) == coroutine_suspended) {
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MessageRepositoryImpl$triggerFirstFetchMessages$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
