package com.tencent.mobileqq.opr.helper.repair;

import com.tencent.mobileqq.opr.QQOpr;
import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper$destroy$1", f = "OldPhotoRepairHelper.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class OldPhotoRepairHelper$destroy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ OldPhotoRepairHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldPhotoRepairHelper$destroy$1(OldPhotoRepairHelper oldPhotoRepairHelper, Continuation<? super OldPhotoRepairHelper$destroy$1> continuation) {
        super(2, continuation);
        this.this$0 = oldPhotoRepairHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) oldPhotoRepairHelper, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new OldPhotoRepairHelper$destroy$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CompletableJob completableJob;
        CompletableJob completableJob2;
        CompletableDeferred completableDeferred;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    completableDeferred = this.this$0.oprDeferred;
                    this.label = 1;
                    obj = completableDeferred.await(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                QQOpr qQOpr = (QQOpr) obj;
                if (qQOpr != null) {
                    qQOpr.release();
                }
            } catch (Throwable th5) {
                try {
                    OprLogger.e("[opr]OldPhotoRepairHelper", "Failed to release resources", th5);
                } catch (Throwable th6) {
                    completableJob = this.this$0.supervisorJob;
                    Job.DefaultImpls.cancel$default((Job) completableJob, (CancellationException) null, 1, (Object) null);
                    throw th6;
                }
            }
            completableJob2 = this.this$0.supervisorJob;
            Job.DefaultImpls.cancel$default((Job) completableJob2, (CancellationException) null, 1, (Object) null);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((OldPhotoRepairHelper$destroy$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
