package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.impl.EcommerceMsgCenterServiceImpl;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.MessageLocalDataSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.UIState;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import uq3.k;
import wf2.NetworkResult;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lwf2/a;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl$triggerFirstFetchMessages$2$localJob$1", f = "MessageRepositoryImpl.kt", i = {1, 2}, l = {60, 61, 66}, m = "invokeSuspend", n = {"localMsg", "localMsg"}, s = {"L$0", "L$0"})
/* loaded from: classes35.dex */
final class MessageRepositoryImpl$triggerFirstFetchMessages$2$localJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NetworkResult<MessageItem>>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MessageRepositoryImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRepositoryImpl$triggerFirstFetchMessages$2$localJob$1(MessageRepositoryImpl messageRepositoryImpl, Continuation<? super MessageRepositoryImpl$triggerFirstFetchMessages$2$localJob$1> continuation) {
        super(2, continuation);
        this.this$0 = messageRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageRepositoryImpl$triggerFirstFetchMessages$2$localJob$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0086  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List mutableList;
        Object h16;
        List list;
        MessageItem messageItem;
        MutableStateFlow mutableStateFlow;
        MessageRepositoryImpl.b bVar;
        List list2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            MessageLocalDataSource localDataSource = this.this$0.getLocalDataSource();
            this.label = 1;
            obj = localDataSource.d(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        list2 = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        QLog.d("ECMsgCenter|MessageRepositoryImpl", 2, "triggerFirstFetchMessages return local msg. size = " + list2.size());
                        return new NetworkResult(list2, true, true);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                messageItem = (MessageItem) obj;
                if (messageItem != null) {
                    list.add(0, messageItem);
                    k.a().p(EcommerceMsgCenterServiceImpl.KEY_LAST_CONSUMED_MESSAGE_ID, messageItem.getId());
                }
                mutableStateFlow = this.this$0._messagesState;
                bVar = new MessageRepositoryImpl.b(list, true, UIState.SUCCEED, new byte[0]);
                this.L$0 = list;
                this.label = 3;
                if (mutableStateFlow.emit(bVar, this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                list2 = list;
                QLog.d("ECMsgCenter|MessageRepositoryImpl", 2, "triggerFirstFetchMessages return local msg. size = " + list2.size());
                return new NetworkResult(list2, true, true);
            }
            ResultKt.throwOnFailure(obj);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) obj);
        MessageRepositoryImpl messageRepositoryImpl = this.this$0;
        this.L$0 = mutableList;
        this.label = 2;
        h16 = messageRepositoryImpl.h(this);
        if (h16 == coroutine_suspended) {
            return coroutine_suspended;
        }
        list = mutableList;
        obj = h16;
        messageItem = (MessageItem) obj;
        if (messageItem != null) {
        }
        mutableStateFlow = this.this$0._messagesState;
        bVar = new MessageRepositoryImpl.b(list, true, UIState.SUCCEED, new byte[0]);
        this.L$0 = list;
        this.label = 3;
        if (mutableStateFlow.emit(bVar, this) != coroutine_suspended) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super NetworkResult<MessageItem>> continuation) {
        return ((MessageRepositoryImpl$triggerFirstFetchMessages$2$localJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
