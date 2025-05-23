package com.tencent.mobileqq.qqlive.room.prepare.covercrop;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qroute.route.MonitorKt$runOnUI$2", f = "Monitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class QQLiveCoverCropFragment$onUploadCover$fileJob$1$1$invokeSuspend$lambda$1$$inlined$runOnUI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ QQLiveCoverCropFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveCoverCropFragment$onUploadCover$fileJob$1$1$invokeSuspend$lambda$1$$inlined$runOnUI$1(Continuation continuation, QQLiveCoverCropFragment qQLiveCoverCropFragment) {
        super(2, continuation);
        this.this$0 = qQLiveCoverCropFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation, (Object) qQLiveCoverCropFragment);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
        }
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        QQLiveCoverCropFragment$onUploadCover$fileJob$1$1$invokeSuspend$lambda$1$$inlined$runOnUI$1 qQLiveCoverCropFragment$onUploadCover$fileJob$1$1$invokeSuspend$lambda$1$$inlined$runOnUI$1 = new QQLiveCoverCropFragment$onUploadCover$fileJob$1$1$invokeSuspend$lambda$1$$inlined$runOnUI$1(completion, this.this$0);
        qQLiveCoverCropFragment$onUploadCover$fileJob$1$1$invokeSuspend$lambda$1$$inlined$runOnUI$1.p$ = (CoroutineScope) obj;
        return qQLiveCoverCropFragment$onUploadCover$fileJob$1$1$invokeSuspend$lambda$1$$inlined$runOnUI$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
        return ((QQLiveCoverCropFragment$onUploadCover$fileJob$1$1$invokeSuspend$lambda$1$$inlined$runOnUI$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.mobileqq.qqlive.room.multichat.utils.c.a(this.this$0.getContext(), "\u4e0a\u4f20\u5931\u8d25");
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
