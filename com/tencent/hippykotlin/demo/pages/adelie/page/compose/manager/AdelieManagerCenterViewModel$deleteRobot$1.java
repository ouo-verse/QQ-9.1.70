package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.ttpic.baseutils.math.BitUtils;
import h25.j;
import h25.k;
import h25.x;
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
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$deleteRobot$1", f = "AdelieManagerCenterViewModel.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieManagerCenterViewModel$deleteRobot$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ String $botUid;
    public final /* synthetic */ Function2<Integer, String, Unit> $callback;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieManagerCenterViewModel$deleteRobot$1(String str, Function2<? super Integer, ? super String, Unit> function2, Continuation<? super AdelieManagerCenterViewModel$deleteRobot$1> continuation) {
        super(2, continuation);
        this.$botUid = str;
        this.$callback = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieManagerCenterViewModel$deleteRobot$1(this.$botUid, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieManagerCenterViewModel$deleteRobot$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            final String str = this.$botUid;
            this.label = 1;
            obj = RequestKt.sendOIDBRequest(1, 37238, new Function0<j>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.AdelieManagerRequest$deleteRobot$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final j invoke() {
                    return new j(4, new x(str, null, null, null, null, 0, null, BitUtils.BIT_TURN_ZERO_1));
                }
            }, new Function1<byte[], k>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.AdelieManagerRequest$deleteRobot$3
                @Override // kotlin.jvm.functions.Function1
                public final k invoke(byte[] bArr) {
                    return (k) i.b(new k(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0), bArr);
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
        this.$callback.invoke(Boxing.boxInt(oIDBResponse.code), oIDBResponse.f114186msg);
        return Unit.INSTANCE;
    }
}
