package com.tencent.state.publicchat.view;

import com.tencent.state.publicchat.view.MessageListView;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.utils.SquarePagViewUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.state.publicchat.view.MessageListView$playPAGWithTask$1", f = "MessageListView.kt", i = {}, l = {510}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes38.dex */
public final class MessageListView$playPAGWithTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MessageListView.BroadcastTask $task;
    int label;
    final /* synthetic */ MessageListView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.state.publicchat.view.MessageListView$playPAGWithTask$1$1, reason: invalid class name */
    /* loaded from: classes38.dex */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ String $pagFilepath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str) {
            super(0);
            this.$pagFilepath = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ISquarePagView iSquarePagView;
            MessageListView$playPAGWithTask$1.this.this$0.isBroadcastPlaying = true;
            iSquarePagView = MessageListView$playPAGWithTask$1.this.this$0.squarePagView;
            if (iSquarePagView != null) {
                SquarePagViewUtils.INSTANCE.playFile(iSquarePagView, this.$pagFilepath, 1, new Function1<ISquarePagView, Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$playPAGWithTask$1$1$$special$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ISquarePagView iSquarePagView2) {
                        invoke2(iSquarePagView2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ISquarePagView iSquarePagView2) {
                        if (iSquarePagView2 != null) {
                            iSquarePagView2.replaceTextLayer(0, MessageListView$playPAGWithTask$1.this.$task.getContent(), null, Boolean.TRUE);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageListView$playPAGWithTask$1(MessageListView messageListView, MessageListView.BroadcastTask broadcastTask, Continuation continuation) {
        super(2, continuation);
        this.this$0 = messageListView;
        this.$task = broadcastTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new MessageListView$playPAGWithTask$1(this.this$0, this.$task, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MessageListView$playPAGWithTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            SquarePagViewUtils squarePagViewUtils = SquarePagViewUtils.INSTANCE;
            String pagUrl = this.$task.getPagUrl();
            this.label = 1;
            obj = squarePagViewUtils.downloadPag(pagUrl, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) obj;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return Unit.INSTANCE;
        }
        SquareBaseKt.getSquareThread().postOnUi(new AnonymousClass1(str));
        return Unit.INSTANCE;
    }
}
