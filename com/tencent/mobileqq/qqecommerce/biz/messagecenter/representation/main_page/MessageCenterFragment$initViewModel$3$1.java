package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.UIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.XRecyclerView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageRepositoryImpl$b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterFragment$initViewModel$3$1", f = "MessageCenterFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class MessageCenterFragment$initViewModel$3$1 extends SuspendLambda implements Function2<MessageRepositoryImpl.b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageCenterFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageCenterFragment$initViewModel$3$1(MessageCenterFragment messageCenterFragment, Continuation<? super MessageCenterFragment$initViewModel$3$1> continuation) {
        super(2, continuation);
        this.this$0 = messageCenterFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MessageCenterFragment$initViewModel$3$1 messageCenterFragment$initViewModel$3$1 = new MessageCenterFragment$initViewModel$3$1(this.this$0, continuation);
        messageCenterFragment$initViewModel$3$1.L$0 = obj;
        return messageCenterFragment$initViewModel$3$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MessageRepositoryImpl.b bVar, Continuation<? super Unit> continuation) {
        return ((MessageCenterFragment$initViewModel$3$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b bVar;
        b bVar2;
        XRecyclerView xRecyclerView;
        XRecyclerView xRecyclerView2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MessageRepositoryImpl.b bVar3 = (MessageRepositoryImpl.b) this.L$0;
            QLog.d("ECMsgCenter|MessageCenterFragment", 2, "messageUIState updated. size = " + bVar3.c().size());
            bVar = this.this$0.messageCenterAdapter;
            XRecyclerView xRecyclerView3 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageCenterAdapter");
                bVar = null;
            }
            bVar.z(bVar3.c());
            bVar2 = this.this$0.messageCenterAdapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageCenterAdapter");
                bVar2 = null;
            }
            bVar2.notifyDataSetChanged();
            xRecyclerView = this.this$0.xRecyclerView;
            if (xRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
                xRecyclerView = null;
            }
            UIState listUIState = bVar3.getListUIState();
            UIState uIState = UIState.FAILED;
            xRecyclerView.pullRefreshCompleted(listUIState != uIState);
            xRecyclerView2 = this.this$0.xRecyclerView;
            if (xRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("xRecyclerView");
            } else {
                xRecyclerView3 = xRecyclerView2;
            }
            xRecyclerView3.loadMoreComplete(bVar3.getListUIState() != uIState, !bVar3.getIsEnd());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
