package com.qzone.reborn.groupalbum.selectmedia.viewmodel;

import aj.a;
import com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaItemModel;
import com.qzone.reborn.groupalbum.selectmedia.util.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "", "", "Lcom/qzone/reborn/groupalbum/selectmedia/data/model/SearchMediaItemModel;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.reborn.groupalbum.selectmedia.viewmodel.ChatHistoryMediaViewModel$loadFirstPageMedia$1", f = "ChatHistoryMediaViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class ChatHistoryMediaViewModel$loadFirstPageMedia$1 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends List<? extends SearchMediaItemModel>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pageCount;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatHistoryMediaViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryMediaViewModel$loadFirstPageMedia$1(ChatHistoryMediaViewModel chatHistoryMediaViewModel, int i3, Continuation<? super ChatHistoryMediaViewModel$loadFirstPageMedia$1> continuation) {
        super(2, continuation);
        this.this$0 = chatHistoryMediaViewModel;
        this.$pageCount = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChatHistoryMediaViewModel$loadFirstPageMedia$1 chatHistoryMediaViewModel$loadFirstPageMedia$1 = new ChatHistoryMediaViewModel$loadFirstPageMedia$1(this.this$0, this.$pageCount, continuation);
        chatHistoryMediaViewModel$loadFirstPageMedia$1.L$0 = obj;
        return chatHistoryMediaViewModel$loadFirstPageMedia$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Pair<? extends Integer, ? extends List<? extends SearchMediaItemModel>> pair, Continuation<? super Unit> continuation) {
        return invoke2((Pair<Integer, ? extends List<SearchMediaItemModel>>) pair, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Pair pair = (Pair) this.L$0;
            c.f56957a.a("ChatHistoryMediaViewModel", "loadFirstPageMedia msgCount " + pair.getFirst() + " dataCount " + ((List) pair.getSecond()).size());
            this.this$0._mUiState.setValue(new a.GetMediaListCompleted((List) pair.getSecond(), this.$pageCount, ((Number) pair.getFirst()).intValue()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Pair<Integer, ? extends List<SearchMediaItemModel>> pair, Continuation<? super Unit> continuation) {
        return ((ChatHistoryMediaViewModel$loadFirstPageMedia$1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
