package com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting;

import androidx.compose.runtime.MutableState;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import h25.ag;
import h25.ah;
import h25.ar;
import h25.h;
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

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposeViewModel$querySetting$1", f = "AdelieSettingComposeViewModel.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieSettingComposeViewModel$querySetting$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function1<Boolean, Unit> $callback;
    public int label;
    public final /* synthetic */ AdelieSettingComposeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieSettingComposeViewModel$querySetting$1(AdelieSettingComposeViewModel adelieSettingComposeViewModel, Function1<? super Boolean, Unit> function1, Continuation<? super AdelieSettingComposeViewModel$querySetting$1> continuation) {
        super(2, continuation);
        this.this$0 = adelieSettingComposeViewModel;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieSettingComposeViewModel$querySetting$1(this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieSettingComposeViewModel$querySetting$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        h hVar;
        h hVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = RequestKt.sendOIDBRequest(1, 37343, new Function0<ag>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposeRequest$querySetting$2
                @Override // kotlin.jvm.functions.Function0
                public final ag invoke() {
                    return new ag();
                }
            }, new Function1<byte[], ah>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposeRequest$querySetting$3
                @Override // kotlin.jvm.functions.Function1
                public final ah invoke(byte[] bArr) {
                    return (ah) i.b(new ah(null, null, 3, null), bArr);
                }
            }, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OIDBResponse oIDBResponse = (OIDBResponse) obj;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("querySetting ");
        m3.append(oIDBResponse.success);
        m3.append(", ");
        m3.append(oIDBResponse.code);
        m3.append(", ");
        m3.append(oIDBResponse.f114186msg);
        m3.append(", ");
        ah ahVar = (ah) oIDBResponse.rsp;
        m3.append((ahVar == null || (hVar2 = ahVar.f404147d) == null) ? null : Boxing.boxBoolean(hVar2.f404207e));
        kLog.i("AdelieSettingViewModel", m3.toString());
        MutableState<Boolean> mutableState = this.this$0.accessible;
        ah ahVar2 = (ah) oIDBResponse.rsp;
        mutableState.setValue(Boxing.boxBoolean((ahVar2 == null || (hVar = ahVar2.f404147d) == null || !hVar.f404207e) ? false : true));
        MutableState<ar> mutableState2 = this.this$0.assistantInfo;
        ah ahVar3 = (ah) oIDBResponse.rsp;
        mutableState2.setValue(ahVar3 != null ? ahVar3.f404148e : null);
        Function1<Boolean, Unit> function1 = this.$callback;
        if (function1 != null) {
            function1.invoke(this.this$0.accessible.getValue());
        }
        return Unit.INSTANCE;
    }
}
