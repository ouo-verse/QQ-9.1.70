package com.tencent.qqnt.chathistory.ui.document;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.document.adapter.ChatHistoryDocumentAdapter;
import java.util.List;
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
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.document.ChatHistoryDocumentFragment$showMultiDeleteActionSheet$1$1$1$1", f = "ChatHistoryDocumentFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class ChatHistoryDocumentFragment$showMultiDeleteActionSheet$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ ChatHistoryDocumentFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryDocumentFragment$showMultiDeleteActionSheet$1$1$1$1(ChatHistoryDocumentFragment chatHistoryDocumentFragment, Continuation<? super ChatHistoryDocumentFragment$showMultiDeleteActionSheet$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = chatHistoryDocumentFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryDocumentFragment, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new ChatHistoryDocumentFragment$showMultiDeleteActionSheet$1$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.qqnt.chathistory.ui.document.data.model.a aVar;
        ChatHistoryDocumentAdapter Xh;
        ChatHistoryDocumentAdapter Xh2;
        ChatHistoryDocumentAdapter Xh3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                aVar = this.this$0.documentCountNode;
                Xh = this.this$0.Xh();
                aVar.f(Xh.Z0().size());
                Xh2 = this.this$0.Xh();
                List<com.tencent.qqnt.chathistory.ui.base.item.b> Y0 = Xh2.Y0();
                ChatHistoryDocumentFragment chatHistoryDocumentFragment = this.this$0;
                for (com.tencent.qqnt.chathistory.ui.base.item.b bVar : Y0) {
                    Xh3 = chatHistoryDocumentFragment.Xh();
                    Xh3.R0(bVar.d(), bVar);
                }
                this.this$0.Wh();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((ChatHistoryDocumentFragment$showMultiDeleteActionSheet$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
