package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.qzone.a;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$openRobotQzone$1", f = "AdelieManagerCenterViewModel.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieManagerCenterViewModel$openRobotQzone$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ String $botUid;
    public final /* synthetic */ Function2<Integer, String, Unit> $callback;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieManagerCenterViewModel$openRobotQzone$1(String str, Function2<? super Integer, ? super String, Unit> function2, Continuation<? super AdelieManagerCenterViewModel$openRobotQzone$1> continuation) {
        super(2, continuation);
        this.$botUid = str;
        this.$callback = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieManagerCenterViewModel$openRobotQzone$1(this.$botUid, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieManagerCenterViewModel$openRobotQzone$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
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
            obj = RequestKt.sendOIDBRequest(1, 37652, new Function0<a>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.AdelieManagerRequest$OpenRobotQzone$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final a invoke() {
                    String str2 = str;
                    MapsKt__MapsKt.emptyMap();
                    return new a(str2);
                }
            }, new Function1<byte[], kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.qzone.b>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.AdelieManagerRequest$OpenRobotQzone$3
                @Override // kotlin.jvm.functions.Function1
                public final kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.qzone.b invoke(byte[] bArr) {
                    return (kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.qzone.b) i.a(kuikly.com.tencent.trpcprotocol.group_pro_robot.mybot_create.qzone.b.f413165d, bArr);
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
