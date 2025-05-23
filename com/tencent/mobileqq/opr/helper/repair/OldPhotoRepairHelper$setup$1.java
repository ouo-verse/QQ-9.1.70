package com.tencent.mobileqq.opr.helper.repair;

import android.content.Context;
import com.tencent.mobileqq.opr.QQOpr;
import com.tencent.mobileqq.opr.model.a;
import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qne.delegate.b;
import com.tencent.qne.delegate.c;
import com.tencent.qne.delegate.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper$setup$1", f = "OldPhotoRepairHelper.kt", i = {0, 1, 1, 2, 2}, l = {80, 83, 92}, m = "invokeSuspend", n = {"qqOpr", "qqOpr", "initStatus", "qqOpr", "modelStatus"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes16.dex */
public final class OldPhotoRepairHelper$setup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Context $context;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OldPhotoRepairHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldPhotoRepairHelper$setup$1(Context context, OldPhotoRepairHelper oldPhotoRepairHelper, Continuation<? super OldPhotoRepairHelper$setup$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.this$0 = oldPhotoRepairHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, oldPhotoRepairHelper, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new OldPhotoRepairHelper$setup$1(this.$context, this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e7 A[Catch: all -> 0x00fd, TryCatch #0 {all -> 0x00fd, blocks: (B:15:0x002c, B:17:0x00e1, B:19:0x00e7, B:21:0x00f3, B:27:0x0042, B:29:0x00a3, B:31:0x00aa, B:33:0x00b6, B:36:0x00d2, B:41:0x004a, B:42:0x007a, B:45:0x0094, B:50:0x0051), top: B:9:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f3 A[Catch: all -> 0x00fd, TRY_LEAVE, TryCatch #0 {all -> 0x00fd, blocks: (B:15:0x002c, B:17:0x00e1, B:19:0x00e7, B:21:0x00f3, B:27:0x0042, B:29:0x00a3, B:31:0x00aa, B:33:0x00b6, B:36:0x00d2, B:41:0x004a, B:42:0x007a, B:45:0x0094, B:50:0x0051), top: B:9:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa A[Catch: all -> 0x00fd, TryCatch #0 {all -> 0x00fd, blocks: (B:15:0x002c, B:17:0x00e1, B:19:0x00e7, B:21:0x00f3, B:27:0x0042, B:29:0x00a3, B:31:0x00aa, B:33:0x00b6, B:36:0x00d2, B:41:0x004a, B:42:0x007a, B:45:0x0094, B:50:0x0051), top: B:9:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6 A[Catch: all -> 0x00fd, TryCatch #0 {all -> 0x00fd, blocks: (B:15:0x002c, B:17:0x00e1, B:19:0x00e7, B:21:0x00f3, B:27:0x0042, B:29:0x00a3, B:31:0x00aa, B:33:0x00b6, B:36:0x00d2, B:41:0x004a, B:42:0x007a, B:45:0x0094, B:50:0x0051), top: B:9:0x001c }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CompletableDeferred completableDeferred;
        d dVar;
        b bVar;
        c cVar;
        QQOpr qQOpr;
        com.tencent.qne.util.d dVar2;
        com.tencent.qne.util.d dVar3;
        QQOpr qQOpr2;
        a preloadModel;
        a aVar;
        CompletableDeferred completableDeferred2;
        CompletableDeferred completableDeferred3;
        CompletableDeferred completableDeferred4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
            } catch (Throwable th5) {
                OprLogger.e("[opr]OldPhotoRepairHelper", "Initialization failed", th5);
                completableDeferred = this.this$0.oprDeferred;
                completableDeferred.complete(null);
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            aVar = (a) this.L$1;
                            qQOpr2 = (QQOpr) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            preloadModel = aVar;
                            if (!preloadModel.a()) {
                                completableDeferred4 = this.this$0.oprDeferred;
                                completableDeferred4.complete(null);
                                return Unit.INSTANCE;
                            }
                            completableDeferred3 = this.this$0.oprDeferred;
                            completableDeferred3.complete(qQOpr2);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    dVar3 = (com.tencent.qne.util.d) this.L$1;
                    qQOpr = (QQOpr) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    dVar2 = dVar3;
                    qQOpr2 = qQOpr;
                    if (!dVar2.b()) {
                        completableDeferred2 = this.this$0.oprDeferred;
                        completableDeferred2.complete(null);
                        return Unit.INSTANCE;
                    }
                    preloadModel = qQOpr2.preloadModel();
                    OprLogger.i("[opr]OldPhotoRepairHelper", Intrinsics.stringPlus("modelStatus:", preloadModel));
                    this.this$0.modelStatus = preloadModel;
                    Function2<a, Continuation<? super Unit>, Object> p16 = this.this$0.p();
                    if (p16 != null) {
                        this.L$0 = qQOpr2;
                        this.L$1 = preloadModel;
                        this.label = 3;
                        if (p16.invoke(preloadModel, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aVar = preloadModel;
                        preloadModel = aVar;
                        if (!preloadModel.a()) {
                        }
                    } else if (!preloadModel.a()) {
                    }
                } else {
                    qQOpr = (QQOpr) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
            } else {
                ResultKt.throwOnFailure(obj);
                QQOpr qQOpr3 = new QQOpr();
                Context context = this.$context;
                dVar = this.this$0.shiply;
                bVar = this.this$0.logger;
                cVar = this.this$0.reporter;
                this.L$0 = qQOpr3;
                this.label = 1;
                Object upVar = qQOpr3.setup(context, dVar, bVar, cVar, this);
                if (upVar == coroutine_suspended) {
                    return coroutine_suspended;
                }
                qQOpr = qQOpr3;
                obj = upVar;
            }
            dVar2 = (com.tencent.qne.util.d) obj;
            OprLogger.i("[opr]OldPhotoRepairHelper", Intrinsics.stringPlus("initStatus:", dVar2));
            this.this$0.initStatus = dVar2;
            Function2<com.tencent.qne.util.d, Continuation<? super Unit>, Object> o16 = this.this$0.o();
            if (o16 != null) {
                this.L$0 = qQOpr;
                this.L$1 = dVar2;
                this.label = 2;
                if (o16.invoke(dVar2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dVar3 = dVar2;
                dVar2 = dVar3;
                qQOpr2 = qQOpr;
                if (!dVar2.b()) {
                }
            } else {
                qQOpr2 = qQOpr;
                if (!dVar2.b()) {
                }
            }
        } else {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((OldPhotoRepairHelper$setup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
