package com.tencent.qqnt.chathistory.ui.sticker;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.ui.base.q;
import com.tencent.qqnt.chathistory.ui.sticker.adapter.ChatHistoryStickerAdapter;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment$showMultiDeleteActionSheet$1$1$1$1", f = "ChatHistoryStickerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class ChatHistoryStickerFragment$showMultiDeleteActionSheet$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ ChatHistoryStickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment$showMultiDeleteActionSheet$1$1$1$1$2, reason: invalid class name */
    /* loaded from: classes23.dex */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.tencent.qqnt.expandRecyclerView.adapter.node.b, Boolean> {
        static IPatchRedirector $redirector_;
        public static final AnonymousClass2 INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50137);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new AnonymousClass2();
            }
        }

        AnonymousClass2() {
            super(1, ExtensionsKt.class, "predicateSticker", "predicateSticker(Lcom/tencent/qqnt/expandRecyclerView/adapter/node/BaseNode;)Z", 1);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final Boolean invoke(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            return Boolean.valueOf(ExtensionsKt.y(p06));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryStickerFragment$showMultiDeleteActionSheet$1$1$1$1(ChatHistoryStickerFragment chatHistoryStickerFragment, Continuation<? super ChatHistoryStickerFragment$showMultiDeleteActionSheet$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = chatHistoryStickerFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryStickerFragment, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new ChatHistoryStickerFragment$showMultiDeleteActionSheet$1$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ChatHistoryStickerAdapter chatHistoryStickerAdapter;
        ChatHistoryStickerAdapter chatHistoryStickerAdapter2;
        ChatHistoryStickerAdapter chatHistoryStickerAdapter3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                chatHistoryStickerAdapter = this.this$0.adapter;
                List<com.tencent.qqnt.chathistory.ui.base.item.b> c16 = chatHistoryStickerAdapter.c1();
                ChatHistoryStickerFragment chatHistoryStickerFragment = this.this$0;
                for (com.tencent.qqnt.chathistory.ui.base.item.b bVar : c16) {
                    chatHistoryStickerAdapter3 = chatHistoryStickerFragment.adapter;
                    chatHistoryStickerAdapter3.R0(bVar.d(), bVar);
                }
                this.this$0.Wh();
                chatHistoryStickerAdapter2 = this.this$0.adapter;
                q.a(chatHistoryStickerAdapter2, AnonymousClass2.INSTANCE);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((ChatHistoryStickerFragment$showMultiDeleteActionSheet$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
