package com.tencent.qqnt.chathistory.ui.link;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.link.adapter.ChatHistoryLinkAdapter;
import com.tencent.qqnt.chathistory.ui.link.data.b;
import com.tencent.qqnt.chathistory.ui.link.viewmodel.ChatHistoryLinkViewModel;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.link.ChatHistoryLinkFragment$loadMore$1", f = "ChatHistoryLinkFragment.kt", i = {}, l = {206}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class ChatHistoryLinkFragment$loadMore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ ChatHistoryLinkFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryLinkFragment$loadMore$1(ChatHistoryLinkFragment chatHistoryLinkFragment, Continuation<? super ChatHistoryLinkFragment$loadMore$1> continuation) {
        super(2, continuation);
        this.this$0 = chatHistoryLinkFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryLinkFragment, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new ChatHistoryLinkFragment$loadMore$1(this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ChatHistoryLinkAdapter Vh;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Vh = this.this$0.Vh();
                com.tencent.qqnt.chathistory.ui.link.data.model.a aVar = (com.tencent.qqnt.chathistory.ui.link.data.model.a) com.tencent.qqnt.chathistory.ui.base.item.c.b(Vh);
                if (aVar != null) {
                    ChatHistoryLinkFragment chatHistoryLinkFragment = this.this$0;
                    com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryLinkFragment", "onLoadMore lastData " + aVar);
                    ChatHistoryLinkViewModel chatHistoryLinkViewModel = (ChatHistoryLinkViewModel) chatHistoryLinkFragment.rh();
                    b.c cVar = new b.c(aVar.j(), aVar.getMsgTime(), aVar.k(), ExtensionsKt.q());
                    this.label = 1;
                    if (chatHistoryLinkViewModel.sendUserIntent(cVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((ChatHistoryLinkFragment$loadMore$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
