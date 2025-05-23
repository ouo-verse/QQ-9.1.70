package com.tencent.qqnt.chathistory.ui.sticker;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.sticker.adapter.ChatHistoryStickerAdapter;
import com.tencent.qqnt.chathistory.ui.sticker.data.b;
import com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel;
import com.tencent.qqnt.chathistory.ui.sticker.viewmodel.ChatStickerViewModel;
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
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment$loadMore$1", f = "ChatHistoryStickerFragment.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class ChatHistoryStickerFragment$loadMore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ ChatHistoryStickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryStickerFragment$loadMore$1(ChatHistoryStickerFragment chatHistoryStickerFragment, Continuation<? super ChatHistoryStickerFragment$loadMore$1> continuation) {
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
        return new ChatHistoryStickerFragment$loadMore$1(this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ChatHistoryStickerAdapter chatHistoryStickerAdapter;
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
                chatHistoryStickerAdapter = this.this$0.adapter;
                SearchStickerItemModel Z0 = chatHistoryStickerAdapter.Z0();
                if (Z0 != null) {
                    ChatStickerViewModel chatStickerViewModel = (ChatStickerViewModel) this.this$0.rh();
                    b.a aVar = new b.a(Z0.j(), Z0.getMsgTime(), Z0.k(), ExtensionsKt.q());
                    this.label = 1;
                    if (chatStickerViewModel.sendUserIntent(aVar, this) == coroutine_suspended) {
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((ChatHistoryStickerFragment$loadMore$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
