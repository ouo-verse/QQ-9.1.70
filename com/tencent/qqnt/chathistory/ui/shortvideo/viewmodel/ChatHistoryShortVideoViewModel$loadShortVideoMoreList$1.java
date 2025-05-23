package com.tencent.qqnt.chathistory.ui.shortvideo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.qqnt.chathistory.ui.shortvideo.data.model.ChatHistoryShortVideoItemModel;
import com.tencent.qqnt.chathistory.util.d;
import ew3.a;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "", "", "Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/model/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.shortvideo.viewmodel.ChatHistoryShortVideoViewModel$loadShortVideoMoreList$1", f = "ChatHistoryShortVideoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class ChatHistoryShortVideoViewModel$loadShortVideoMoreList$1 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends List<? extends ChatHistoryShortVideoItemModel>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $requestCount;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatHistoryShortVideoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryShortVideoViewModel$loadShortVideoMoreList$1(ChatHistoryShortVideoViewModel chatHistoryShortVideoViewModel, int i3, Continuation<? super ChatHistoryShortVideoViewModel$loadShortVideoMoreList$1> continuation) {
        super(2, continuation);
        this.this$0 = chatHistoryShortVideoViewModel;
        this.$requestCount = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChatHistoryShortVideoViewModel$loadShortVideoMoreList$1 chatHistoryShortVideoViewModel$loadShortVideoMoreList$1 = new ChatHistoryShortVideoViewModel$loadShortVideoMoreList$1(this.this$0, this.$requestCount, continuation);
        chatHistoryShortVideoViewModel$loadShortVideoMoreList$1.L$0 = obj;
        return chatHistoryShortVideoViewModel$loadShortVideoMoreList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Pair<? extends Integer, ? extends List<? extends ChatHistoryShortVideoItemModel>> pair, Continuation<? super Unit> continuation) {
        return invoke2((Pair<Integer, ? extends List<ChatHistoryShortVideoItemModel>>) pair, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        MutableLiveData mUiState;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Pair pair = (Pair) this.L$0;
            d dVar = d.f354054a;
            str = ChatHistoryShortVideoViewModel.H;
            dVar.a(str, "[loadShortVideoMoreList] msg count:" + pair.getFirst() + " data count:" + ((List) pair.getSecond()).size());
            mUiState = this.this$0.getMUiState();
            mUiState.setValue(new a.GetMoreShortVideoListCompleted((List) pair.getSecond(), this.$requestCount, ((Number) pair.getFirst()).intValue()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull Pair<Integer, ? extends List<ChatHistoryShortVideoItemModel>> pair, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatHistoryShortVideoViewModel$loadShortVideoMoreList$1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
