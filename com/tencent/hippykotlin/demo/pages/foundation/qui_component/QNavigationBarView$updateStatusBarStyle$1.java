package com.tencent.hippykotlin.demo.pages.foundation.qui_component;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
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

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView$updateStatusBarStyle$1", f = "QNavigationBar.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class QNavigationBarView$updateStatusBarStyle$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ h $color;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QNavigationBarView$updateStatusBarStyle$1(h hVar, Continuation<? super QNavigationBarView$updateStatusBarStyle$1> continuation) {
        super(2, continuation);
        this.$color = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QNavigationBarView$updateStatusBarStyle$1(this.$color, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((QNavigationBarView$updateStatusBarStyle$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
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
            QNavigationBarView.Companion companion = QNavigationBarView.Companion;
            if (!QNavigationBarView.Companion.access$isWhiteColor(this.$color)) {
                this.label = 1;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).toNative(false, "isWhiteStatusBar", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView$Companion$isWhiteStatusBar$2$1
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
            }
            ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).setWhiteStatusBarStyle();
            return Unit.INSTANCE;
        }
        if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!((Boolean) obj).booleanValue()) {
            ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).setBlackStatusBarStyle();
            return Unit.INSTANCE;
        }
        ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).setWhiteStatusBarStyle();
        return Unit.INSTANCE;
    }
}
