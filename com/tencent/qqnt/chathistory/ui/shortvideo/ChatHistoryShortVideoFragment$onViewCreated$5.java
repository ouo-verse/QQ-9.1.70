package com.tencent.qqnt.chathistory.ui.shortvideo;

import com.tencent.qqnt.chathistory.ui.shortvideo.viewmodel.ChatHistoryShortVideoViewModel;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import ew3.b;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.shortvideo.ChatHistoryShortVideoFragment$onViewCreated$5", f = "ChatHistoryShortVideoFragment.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
final class ChatHistoryShortVideoFragment$onViewCreated$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatHistoryShortVideoFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryShortVideoFragment$onViewCreated$5(ChatHistoryShortVideoFragment chatHistoryShortVideoFragment, Continuation<? super ChatHistoryShortVideoFragment$onViewCreated$5> continuation) {
        super(2, continuation);
        this.this$0 = chatHistoryShortVideoFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChatHistoryShortVideoFragment$onViewCreated$5(this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            int m3 = ExtensionsKt.m(4);
            ChatHistoryShortVideoViewModel chatHistoryShortVideoViewModel = (ChatHistoryShortVideoViewModel) this.this$0.rh();
            b.GetShortVideoList getShortVideoList = new b.GetShortVideoList(m3);
            this.label = 1;
            if (chatHistoryShortVideoViewModel.sendUserIntent(getShortVideoList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatHistoryShortVideoFragment$onViewCreated$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
