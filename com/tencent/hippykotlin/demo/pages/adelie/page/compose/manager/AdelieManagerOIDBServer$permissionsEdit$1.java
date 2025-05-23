package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import h25.aq;
import h25.n;
import h25.o;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerOIDBServer$permissionsEdit$1", f = "AdelieManagerOIDBServer.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieManagerOIDBServer$permissionsEdit$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function3<Integer, String, o, Unit> $callback;
    public final /* synthetic */ int $editType;
    public final /* synthetic */ String $robotUid;
    public final /* synthetic */ aq $set;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieManagerOIDBServer$permissionsEdit$1(Function3<? super Integer, ? super String, ? super o, Unit> function3, int i3, String str, aq aqVar, Continuation<? super AdelieManagerOIDBServer$permissionsEdit$1> continuation) {
        super(2, continuation);
        this.$callback = function3;
        this.$editType = i3;
        this.$robotUid = str;
        this.$set = aqVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieManagerOIDBServer$permissionsEdit$1(this.$callback, this.$editType, this.$robotUid, this.$set, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieManagerOIDBServer$permissionsEdit$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            final n nVar = new n();
            int i16 = this.$editType;
            String str = this.$robotUid;
            aq aqVar = this.$set;
            nVar.f404218d = i16;
            nVar.f404219e = str;
            nVar.f404220f = aqVar;
            Function0<n> function0 = new Function0<n>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerOIDBServer$permissionsEdit$1$rsp$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final n invoke() {
                    return n.this;
                }
            };
            AdelieManagerOIDBServer$permissionsEdit$1$rsp$2 adelieManagerOIDBServer$permissionsEdit$1$rsp$2 = new Function1<byte[], o>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerOIDBServer$permissionsEdit$1$rsp$2
                @Override // kotlin.jvm.functions.Function1
                public final o invoke(byte[] bArr) {
                    return (o) i.b(new o(null, 1, null), bArr);
                }
            };
            this.label = 1;
            obj = RequestKt.sendOIDBRequest(1, 37756, function0, adelieManagerOIDBServer$permissionsEdit$1$rsp$2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OIDBResponse oIDBResponse = (OIDBResponse) obj;
        Function3<Integer, String, o, Unit> function3 = this.$callback;
        if (oIDBResponse.rsp != 0 && oIDBResponse.success) {
            function3.invoke(Integer.valueOf(oIDBResponse.code), oIDBResponse.f114186msg, oIDBResponse.rsp);
        } else {
            function3.invoke(Integer.valueOf(oIDBResponse.code), oIDBResponse.f114186msg, null);
        }
        return Unit.INSTANCE;
    }
}
