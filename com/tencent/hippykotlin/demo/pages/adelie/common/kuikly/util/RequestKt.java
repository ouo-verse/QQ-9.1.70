package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util;

import c45.e;
import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class RequestKt {
    public static final <Req extends e, Rsp extends e> Object sendOIDBRequest(final int i3, final int i16, final Function0<? extends Req> function0, final Function1<? super byte[], ? extends Rsp> function1, Continuation<? super OIDBResponse<Rsp>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object obj = new BaseOIDBRequest<Req, Rsp>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt$sendOIDBRequest$req$1
            /* JADX WARN: Incorrect return type in method signature: ([B)TRsp; */
            @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
            public final e decodeResponse(byte[] bArr) {
                return (e) function1.invoke(bArr);
            }

            @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
            public final int getOidbCmd() {
                return i16;
            }

            @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
            public final int getOidbServiceType() {
                return i3;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TReq; */
            @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
            public final e getRequest() {
                return (e) function0.invoke();
            }
        };
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(obj, false, new Function1<OIDBResponse<e>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt$sendOIDBRequest$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<e> oIDBResponse) {
                safeContinuation.resumeWith(Result.m476constructorimpl(oIDBResponse));
                return Unit.INSTANCE;
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
