package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import h25.ak;
import h25.f;
import h25.p;
import h25.q;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieCreateTtsViewModel$createTtsVoiceRequest$1", f = "AdelieCreateTtsViewModel.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieCreateTtsViewModel$createTtsVoiceRequest$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function3<Boolean, Integer, String, Unit> $callback;
    public final /* synthetic */ ak $textInfo;
    public int label;
    public final /* synthetic */ AdelieCreateTtsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieCreateTtsViewModel$createTtsVoiceRequest$1(AdelieCreateTtsViewModel adelieCreateTtsViewModel, Function3<? super Boolean, ? super Integer, ? super String, Unit> function3, ak akVar, Continuation<? super AdelieCreateTtsViewModel$createTtsVoiceRequest$1> continuation) {
        super(2, continuation);
        this.this$0 = adelieCreateTtsViewModel;
        this.$callback = function3;
        this.$textInfo = akVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieCreateTtsViewModel$createTtsVoiceRequest$1(this.this$0, this.$callback, this.$textInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieCreateTtsViewModel$createTtsVoiceRequest$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        f fVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            final ak akVar = this.$textInfo;
            Function0<p> function0 = new Function0<p>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieCreateTtsViewModel$createTtsVoiceRequest$1$rsp$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final p invoke() {
                    return new p(1, ak.this, null, 4);
                }
            };
            AdelieCreateTtsViewModel$createTtsVoiceRequest$1$rsp$2 adelieCreateTtsViewModel$createTtsVoiceRequest$1$rsp$2 = new Function1<byte[], q>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieCreateTtsViewModel$createTtsVoiceRequest$1$rsp$2
                @Override // kotlin.jvm.functions.Function1
                public final q invoke(byte[] bArr) {
                    return (q) i.b(new q(null, 1, null), bArr);
                }
            };
            this.label = 1;
            obj = RequestKt.sendOIDBRequest(1, 37529, function0, adelieCreateTtsViewModel$createTtsVoiceRequest$1$rsp$2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OIDBResponse oIDBResponse = (OIDBResponse) obj;
        KLog.INSTANCE.i("AdelieTtsSettingViewModel", "createTtsVoiceRequest response: " + oIDBResponse);
        AdelieCreateTtsViewModel adelieCreateTtsViewModel = this.this$0;
        Rsp rsp = oIDBResponse.rsp;
        q qVar = (q) rsp;
        adelieCreateTtsViewModel.currentTaskId = (qVar == null || (fVar = qVar.f404225d) == null) ? null : fVar.f404200d;
        if (rsp != 0 && oIDBResponse.success) {
            this.$callback.invoke(Boxing.boxBoolean(true), Boxing.boxInt(oIDBResponse.code), oIDBResponse.f114186msg);
            return Unit.INSTANCE;
        }
        this.$callback.invoke(Boxing.boxBoolean(false), Boxing.boxInt(oIDBResponse.code), oIDBResponse.f114186msg);
        return Unit.INSTANCE;
    }
}
