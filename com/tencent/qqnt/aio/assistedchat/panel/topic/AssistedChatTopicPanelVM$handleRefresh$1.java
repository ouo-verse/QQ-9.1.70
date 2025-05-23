package com.tencent.qqnt.aio.assistedchat.panel.topic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.d;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/d;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.assistedchat.panel.topic.AssistedChatTopicPanelVM$handleRefresh$1", f = "AssistedChatTopicPanelVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class AssistedChatTopicPanelVM$handleRefresh$1 extends SuspendLambda implements Function2<d, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AssistedChatTopicPanelVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssistedChatTopicPanelVM$handleRefresh$1(AssistedChatTopicPanelVM assistedChatTopicPanelVM, Continuation<? super AssistedChatTopicPanelVM$handleRefresh$1> continuation) {
        super(2, continuation);
        this.this$0 = assistedChatTopicPanelVM;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) assistedChatTopicPanelVM, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AssistedChatTopicPanelVM$handleRefresh$1 assistedChatTopicPanelVM$handleRefresh$1 = new AssistedChatTopicPanelVM$handleRefresh$1(this.this$0, continuation);
        assistedChatTopicPanelVM$handleRefresh$1.L$0 = obj;
        return assistedChatTopicPanelVM$handleRefresh$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull d dVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AssistedChatTopicPanelVM$handleRefresh$1) create(dVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.t((d) this.L$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
