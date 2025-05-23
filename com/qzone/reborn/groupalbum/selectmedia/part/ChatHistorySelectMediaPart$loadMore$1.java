package com.qzone.reborn.groupalbum.selectmedia.part;

import aj.b;
import com.qzone.reborn.groupalbum.selectmedia.adapter.ChatHistorySelectMediaAdapter;
import com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaItemModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$loadMore$1", f = "ChatHistorySelectMediaPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class ChatHistorySelectMediaPart$loadMore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatHistorySelectMediaPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistorySelectMediaPart$loadMore$1(ChatHistorySelectMediaPart chatHistorySelectMediaPart, Continuation<? super ChatHistorySelectMediaPart$loadMore$1> continuation) {
        super(2, continuation);
        this.this$0 = chatHistorySelectMediaPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatHistorySelectMediaPart$loadMore$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            chatHistorySelectMediaAdapter = this.this$0.adapter;
            SearchMediaItemModel X0 = chatHistorySelectMediaAdapter.X0();
            if (X0 != null) {
                this.this$0.M9().U1(new b.GetMoreMediaList(X0.j(), X0.getMsgTime(), X0.l(), com.qzone.reborn.groupalbum.selectmedia.util.b.e()));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChatHistorySelectMediaPart$loadMore$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
