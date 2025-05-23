package com.tencent.qqnt.chathistory.ui.link.viewmodel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.link.data.a;
import com.tencent.qqnt.chathistory.ui.link.data.b;
import com.tencent.qqnt.chathistory.ui.link.data.model.a;
import com.tencent.qqnt.chathistory.util.d;
import java.util.List;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/qqnt/chathistory/ui/link/data/model/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.link.viewmodel.ChatHistoryLinkViewModel$getMoreData$1", f = "ChatHistoryLinkViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class ChatHistoryLinkViewModel$getMoreData$1 extends SuspendLambda implements Function2<List<? extends a>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ b.c $data;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatHistoryLinkViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryLinkViewModel$getMoreData$1(ChatHistoryLinkViewModel chatHistoryLinkViewModel, b.c cVar, Continuation<? super ChatHistoryLinkViewModel$getMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = chatHistoryLinkViewModel;
        this.$data = cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, chatHistoryLinkViewModel, cVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        ChatHistoryLinkViewModel$getMoreData$1 chatHistoryLinkViewModel$getMoreData$1 = new ChatHistoryLinkViewModel$getMoreData$1(this.this$0, this.$data, continuation);
        chatHistoryLinkViewModel$getMoreData$1.L$0 = obj;
        return chatHistoryLinkViewModel$getMoreData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends a> list, Continuation<? super Unit> continuation) {
        return invoke2((List<a>) list, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List list = (List) this.L$0;
                this.this$0.getMUiState().setValue(new a.b(list, this.$data.d()));
                d.f354054a.a("ChatHistoryLinkViewModel", "getMoreData " + list.size() + " ");
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull List<com.tencent.qqnt.chathistory.ui.link.data.model.a> list, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((ChatHistoryLinkViewModel$getMoreData$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) continuation);
    }
}
