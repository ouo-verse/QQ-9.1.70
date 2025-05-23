package com.tencent.qqnt.forwardaio.msglist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.forwardaio.msglist.PreviewAIOMsgListVM$registerMsgNotification$1", f = "PreviewAIOMsgListVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes24.dex */
final class PreviewAIOMsgListVM$registerMsgNotification$1 extends SuspendLambda implements Function2<FileTransNotifyInfo, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PreviewAIOMsgListVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewAIOMsgListVM$registerMsgNotification$1(PreviewAIOMsgListVM previewAIOMsgListVM, Continuation<? super PreviewAIOMsgListVM$registerMsgNotification$1> continuation) {
        super(2, continuation);
        this.this$0 = previewAIOMsgListVM;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) previewAIOMsgListVM, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        PreviewAIOMsgListVM$registerMsgNotification$1 previewAIOMsgListVM$registerMsgNotification$1 = new PreviewAIOMsgListVM$registerMsgNotification$1(this.this$0, continuation);
        previewAIOMsgListVM$registerMsgNotification$1.L$0 = obj;
        return previewAIOMsgListVM$registerMsgNotification$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FileTransNotifyInfo fileTransNotifyInfo, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PreviewAIOMsgListVM$registerMsgNotification$1) create(fileTransNotifyInfo, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) fileTransNotifyInfo, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.W((FileTransNotifyInfo) this.L$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
