package com.tencent.hippykotlin.demo.pages.vas_base;

import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$updateStatusBarStyle$1", f = "VasBasePage.kt", i = {}, l = {TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class VasBasePage$updateStatusBarStyle$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ VasBasePage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasBasePage$updateStatusBarStyle$1(VasBasePage vasBasePage, Continuation<? super VasBasePage$updateStatusBarStyle$1> continuation) {
        super(2, continuation);
        this.this$0 = vasBasePage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VasBasePage$updateStatusBarStyle$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((VasBasePage$updateStatusBarStyle$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            VasModule vasModule = this.this$0.platformApi.getVasModule();
            this.label = 1;
            vasModule.getClass();
            KLog.INSTANCE.e("VasModule", "isWhiteStatusBar");
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            vasModule.toNative(false, "isWhiteStatusBar", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasModule$isWhiteStatusBar$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    safeContinuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(eVar2 != null ? eVar2.f("isWhiteStatusBar") : false)));
                    return Unit.INSTANCE;
                }
            }, false);
            obj = safeContinuation.getOrThrow();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            this.this$0.platformApi.getCoreModule().setWhiteStatusBarStyle();
        } else {
            this.this$0.platformApi.getCoreModule().setBlackStatusBarStyle();
        }
        return Unit.INSTANCE;
    }
}
