package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.MessageLocalDataSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.UIState;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import wf2.NetworkResult;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lwf2/a;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl$triggerFirstFetchMessages$2$remoteJob$1", f = "MessageRepositoryImpl.kt", i = {1, 1, 2}, l = {84, 93, 103}, m = "invokeSuspend", n = {"remoteMessageResult", "remoteMsg", "remoteMessageResult"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes35.dex */
final class MessageRepositoryImpl$triggerFirstFetchMessages$2$remoteJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NetworkResult<MessageItem>>, Object> {
    final /* synthetic */ Deferred<NetworkResult<MessageItem>> $localJob;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MessageRepositoryImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRepositoryImpl$triggerFirstFetchMessages$2$remoteJob$1(MessageRepositoryImpl messageRepositoryImpl, Deferred<NetworkResult<MessageItem>> deferred, Continuation<? super MessageRepositoryImpl$triggerFirstFetchMessages$2$remoteJob$1> continuation) {
        super(2, continuation);
        this.this$0 = messageRepositoryImpl;
        this.$localJob = deferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageRepositoryImpl$triggerFirstFetchMessages$2$remoteJob$1(this.this$0, this.$localJob, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        NetworkResult networkResult;
        List<MessageItem> a16;
        MutableStateFlow mutableStateFlow;
        MessageLocalDataSource localDataSource;
        NetworkResult networkResult2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = a.d(this.this$0.getRemoteDataSource(), new byte[0], 0, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        networkResult2 = (NetworkResult) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        return networkResult2;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List<MessageItem> list = (List) this.L$1;
                NetworkResult networkResult3 = (NetworkResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                a16 = list;
                networkResult = networkResult3;
                QLog.d("ECMsgCenter|MessageRepositoryImpl", 2, "triggerFirstFetchMessages return remote msg. size = " + a16.size());
                localDataSource = this.this$0.getLocalDataSource();
                this.L$0 = networkResult;
                this.L$1 = null;
                this.label = 3;
                if (localDataSource.c(a16, this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                networkResult2 = networkResult;
                return networkResult2;
            }
            ResultKt.throwOnFailure(obj);
        }
        Pair pair = (Pair) obj;
        networkResult = (NetworkResult) pair.getFirst();
        if (!networkResult.getIsSucceed()) {
            return networkResult;
        }
        if (this.$localJob.isActive()) {
            QLog.e("ECMsgCenter|MessageRepositoryImpl", 2, "triggerFirstFetchMessages local job cancelled.");
            Job.DefaultImpls.cancel$default((Job) this.$localJob, (CancellationException) null, 1, (Object) null);
        }
        a16 = networkResult.a();
        mutableStateFlow = this.this$0._messagesState;
        MessageRepositoryImpl.b bVar = new MessageRepositoryImpl.b(a16, networkResult.getIsEnd(), UIState.SUCCEED, (byte[]) pair.getSecond());
        this.L$0 = networkResult;
        this.L$1 = a16;
        this.label = 2;
        if (mutableStateFlow.emit(bVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        QLog.d("ECMsgCenter|MessageRepositoryImpl", 2, "triggerFirstFetchMessages return remote msg. size = " + a16.size());
        localDataSource = this.this$0.getLocalDataSource();
        this.L$0 = networkResult;
        this.L$1 = null;
        this.label = 3;
        if (localDataSource.c(a16, this) != coroutine_suspended) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super NetworkResult<MessageItem>> continuation) {
        return ((MessageRepositoryImpl$triggerFirstFetchMessages$2$remoteJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
