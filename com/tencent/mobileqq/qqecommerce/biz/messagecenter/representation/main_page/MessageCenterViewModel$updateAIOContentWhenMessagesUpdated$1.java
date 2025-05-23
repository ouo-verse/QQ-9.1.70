package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenterService;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl;
import com.tencent.qphone.base.util.QLog;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterViewModel$updateAIOContentWhenMessagesUpdated$1", f = "MessageCenterViewModel.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class MessageCenterViewModel$updateAIOContentWhenMessagesUpdated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageCenterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageRepositoryImpl$b;", "state", "", "a", "(Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageRepositoryImpl$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a<T> implements FlowCollector {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseQQAppInterface f263308d;

        a(BaseQQAppInterface baseQQAppInterface) {
            this.f263308d = baseQQAppInterface;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(MessageRepositoryImpl.b bVar, Continuation<? super Unit> continuation) {
            ((IEcommerceMsgCenterService) this.f263308d.getRuntimeService(IEcommerceMsgCenterService.class, "")).tryClearRedDotIfNeeded(this.f263308d);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageCenterViewModel$updateAIOContentWhenMessagesUpdated$1(MessageCenterViewModel messageCenterViewModel, Continuation<? super MessageCenterViewModel$updateAIOContentWhenMessagesUpdated$1> continuation) {
        super(2, continuation);
        this.this$0 = messageCenterViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MessageCenterViewModel$updateAIOContentWhenMessagesUpdated$1 messageCenterViewModel$updateAIOContentWhenMessagesUpdated$1 = new MessageCenterViewModel$updateAIOContentWhenMessagesUpdated$1(this.this$0, continuation);
        messageCenterViewModel$updateAIOContentWhenMessagesUpdated$1.L$0 = obj;
        return messageCenterViewModel$updateAIOContentWhenMessagesUpdated$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            BaseQQAppInterface baseQQAppInterface = peekAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) peekAppRuntime : null;
            if (baseQQAppInterface == null) {
                QLog.e("MessageCenterViewModel", 1, "updateAIOContentWhenMessagesUpdated failed. appInterface is null");
                return Unit.INSTANCE;
            }
            StateFlow<MessageRepositoryImpl.b> Z1 = this.this$0.Z1();
            a aVar = new a(baseQQAppInterface);
            this.label = 1;
            if (Z1.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MessageCenterViewModel$updateAIOContentWhenMessagesUpdated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
