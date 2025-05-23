package com.tencent.mobileqq.qqlive.sail.ui.debug;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.room.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.ui.debug.QQLiveAudienceDebugPart$launchRefreshJob$1", f = "QQLiveAudienceDebugPart.kt", i = {0}, l = {136}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes17.dex */
public final class QQLiveAudienceDebugPart$launchRefreshJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQLiveAudienceDebugPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveAudienceDebugPart$launchRefreshJob$1(QQLiveAudienceDebugPart qQLiveAudienceDebugPart, Continuation<? super QQLiveAudienceDebugPart$launchRefreshJob$1> continuation) {
        super(2, continuation);
        this.this$0 = qQLiveAudienceDebugPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveAudienceDebugPart, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        QQLiveAudienceDebugPart$launchRefreshJob$1 qQLiveAudienceDebugPart$launchRefreshJob$1 = new QQLiveAudienceDebugPart$launchRefreshJob$1(this.this$0, continuation);
        qQLiveAudienceDebugPart$launchRefreshJob$1.L$0 = obj;
        return qQLiveAudienceDebugPart$launchRefreshJob$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0046 -> B:12:0x0049). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        QQLiveAudienceDebugPart$launchRefreshJob$1 qQLiveAudienceDebugPart$launchRefreshJob$1;
        com.tencent.mobileqq.qqlive.sail.room.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    qQLiveAudienceDebugPart$launchRefreshJob$1 = this;
                    f F9 = qQLiveAudienceDebugPart$launchRefreshJob$1.this$0.F9();
                    com.tencent.mobileqq.qqlive.sail.model.player.a aVar = null;
                    if (!(F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e)) {
                        eVar = (com.tencent.mobileqq.qqlive.sail.room.e) F9;
                    } else {
                        eVar = null;
                    }
                    if (eVar != null) {
                        aVar = eVar.getPlayerQuality();
                    }
                    qQLiveAudienceDebugPart$launchRefreshJob$1.this$0.va(aVar);
                    qQLiveAudienceDebugPart$launchRefreshJob$1.this$0.ua(aVar);
                    qQLiveAudienceDebugPart$launchRefreshJob$1.this$0.wa(aVar);
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        qQLiveAudienceDebugPart$launchRefreshJob$1.L$0 = coroutineScope;
                        qQLiveAudienceDebugPart$launchRefreshJob$1.label = 1;
                        if (DelayKt.delay(1000L, qQLiveAudienceDebugPart$launchRefreshJob$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        f F92 = qQLiveAudienceDebugPart$launchRefreshJob$1.this$0.F9();
                        com.tencent.mobileqq.qqlive.sail.model.player.a aVar2 = null;
                        if (!(F92 instanceof com.tencent.mobileqq.qqlive.sail.room.e)) {
                        }
                        if (eVar != null) {
                        }
                        qQLiveAudienceDebugPart$launchRefreshJob$1.this$0.va(aVar2);
                        qQLiveAudienceDebugPart$launchRefreshJob$1.this$0.ua(aVar2);
                        qQLiveAudienceDebugPart$launchRefreshJob$1.this$0.wa(aVar2);
                        if (CoroutineScopeKt.isActive(coroutineScope)) {
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                qQLiveAudienceDebugPart$launchRefreshJob$1 = this;
                if (CoroutineScopeKt.isActive(coroutineScope)) {
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((QQLiveAudienceDebugPart$launchRefreshJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
