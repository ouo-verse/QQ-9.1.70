package com.tencent.mobileqq.opr.helper.sr;

import android.content.Context;
import com.tencent.mobileqq.opr.PlatformBridge;
import com.tencent.mobileqq.opr.QQSR;
import com.tencent.mobileqq.opr.model.ModelConfig;
import com.tencent.mobileqq.opr.model.TaskQueueConfig;
import com.tencent.mobileqq.opr.model.ThermalPauseTimeConfig;
import com.tencent.mobileqq.opr.model.a;
import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qne.delegate.b;
import com.tencent.qne.delegate.c;
import com.tencent.qne.delegate.d;
import java.util.List;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.tencent.mobileqq.opr.helper.sr.SuperResolutionHelper$setup$1", f = "SuperResolutionHelper.kt", i = {0, 1, 1, 2, 2}, l = {79, 82, 91}, m = "invokeSuspend", n = {"qqsr", "qqsr", "initStatus", "qqsr", "modelStatus"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes16.dex */
public final class SuperResolutionHelper$setup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Context $context;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SuperResolutionHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperResolutionHelper$setup$1(Context context, SuperResolutionHelper superResolutionHelper, Continuation<? super SuperResolutionHelper$setup$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.this$0 = superResolutionHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, superResolutionHelper, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new SuperResolutionHelper$setup$1(this.$context, this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00f2 A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:15:0x002c, B:17:0x00ec, B:19:0x00f2, B:21:0x00fe, B:24:0x0110, B:27:0x010b, B:31:0x0042, B:32:0x00ad, B:34:0x00b3, B:36:0x00bf, B:39:0x00db, B:44:0x004b, B:46:0x0085, B:49:0x00a0, B:53:0x0054), top: B:9:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fe A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:15:0x002c, B:17:0x00ec, B:19:0x00f2, B:21:0x00fe, B:24:0x0110, B:27:0x010b, B:31:0x0042, B:32:0x00ad, B:34:0x00b3, B:36:0x00bf, B:39:0x00db, B:44:0x004b, B:46:0x0085, B:49:0x00a0, B:53:0x0054), top: B:9:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3 A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:15:0x002c, B:17:0x00ec, B:19:0x00f2, B:21:0x00fe, B:24:0x0110, B:27:0x010b, B:31:0x0042, B:32:0x00ad, B:34:0x00b3, B:36:0x00bf, B:39:0x00db, B:44:0x004b, B:46:0x0085, B:49:0x00a0, B:53:0x0054), top: B:9:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bf A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:15:0x002c, B:17:0x00ec, B:19:0x00f2, B:21:0x00fe, B:24:0x0110, B:27:0x010b, B:31:0x0042, B:32:0x00ad, B:34:0x00b3, B:36:0x00bf, B:39:0x00db, B:44:0x004b, B:46:0x0085, B:49:0x00a0, B:53:0x0054), top: B:9:0x001c }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CompletableDeferred completableDeferred;
        ModelConfig modelConfig;
        d dVar;
        b bVar;
        c cVar;
        Object upVar;
        QQSR qqsr;
        com.tencent.qne.util.d dVar2;
        a preloadModel;
        a aVar;
        QQSR qqsr2;
        CompletableDeferred completableDeferred2;
        TaskQueueConfig taskQueueConfig;
        CompletableDeferred completableDeferred3;
        CompletableDeferred completableDeferred4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
            } catch (Throwable th5) {
                OprLogger.e("[qqsr]SuperResolutionHelper", "Initialization failed", th5);
                completableDeferred = this.this$0.qqsrDeferred;
                completableDeferred.complete(null);
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            aVar = (a) this.L$1;
                            qqsr2 = (QQSR) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            preloadModel = aVar;
                            qqsr = qqsr2;
                            if (!preloadModel.a()) {
                                completableDeferred4 = this.this$0.qqsrDeferred;
                                completableDeferred4.complete(null);
                                return Unit.INSTANCE;
                            }
                            taskQueueConfig = this.this$0.taskQueueConfig;
                            List<ThermalPauseTimeConfig> thermalConfig = taskQueueConfig.getThermalConfig();
                            if (thermalConfig != null) {
                                PlatformBridge.INSTANCE.setThermalConfig(thermalConfig);
                            }
                            completableDeferred3 = this.this$0.qqsrDeferred;
                            completableDeferred3.complete(qqsr);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    dVar2 = (com.tencent.qne.util.d) this.L$1;
                    qqsr = (QQSR) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (dVar2.b()) {
                        completableDeferred2 = this.this$0.qqsrDeferred;
                        completableDeferred2.complete(null);
                        return Unit.INSTANCE;
                    }
                    preloadModel = qqsr.preloadModel();
                    OprLogger.i("[qqsr]SuperResolutionHelper", Intrinsics.stringPlus("modelStatus:", preloadModel));
                    this.this$0.modelStatus = preloadModel;
                    Function2<a, Continuation<? super Unit>, Object> r16 = this.this$0.r();
                    if (r16 != null) {
                        this.L$0 = qqsr;
                        this.L$1 = preloadModel;
                        this.label = 3;
                        if (r16.invoke(preloadModel, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aVar = preloadModel;
                        qqsr2 = qqsr;
                        preloadModel = aVar;
                        qqsr = qqsr2;
                        if (!preloadModel.a()) {
                        }
                    } else if (!preloadModel.a()) {
                    }
                } else {
                    QQSR qqsr3 = (QQSR) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    upVar = obj;
                    qqsr = qqsr3;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                QQSR qqsr4 = new QQSR();
                Context context = this.$context;
                modelConfig = this.this$0.modelConfig;
                dVar = this.this$0.shiply;
                bVar = this.this$0.logger;
                cVar = this.this$0.reporter;
                this.L$0 = qqsr4;
                this.label = 1;
                upVar = qqsr4.setup(context, modelConfig, dVar, bVar, cVar, this);
                if (upVar == coroutine_suspended) {
                    return coroutine_suspended;
                }
                qqsr = qqsr4;
            }
            dVar2 = (com.tencent.qne.util.d) upVar;
            OprLogger.i("[qqsr]SuperResolutionHelper", Intrinsics.stringPlus("initStatus:", dVar2));
            this.this$0.initStatus = dVar2;
            Function2<com.tencent.qne.util.d, Continuation<? super Unit>, Object> q16 = this.this$0.q();
            if (q16 != null) {
                this.L$0 = qqsr;
                this.L$1 = dVar2;
                this.label = 2;
                if (q16.invoke(dVar2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (dVar2.b()) {
            }
        } else {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((SuperResolutionHelper$setup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
