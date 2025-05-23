package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchReqBody;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zz0.a;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NetworkUtils extends BaseObject {
    public static final NetworkUtils INSTANCE = new NetworkUtils();

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static abstract class SuspendResult<RSP> {

        /* compiled from: P */
        /* loaded from: classes31.dex */
        public static final class Failed<RSP> extends SuspendResult<RSP> {
            public final int errorCode;
            public final String errorMsg;

            public final int hashCode() {
                return this.errorCode + (this.errorMsg.hashCode() * 31);
            }

            public final String toString() {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Failed(errorMsg=");
                m3.append(this.errorMsg);
                m3.append(", errorCode=");
                return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.errorCode, ')');
            }

            public Failed(String str, int i3) {
                super(null);
                this.errorMsg = str;
                this.errorCode = i3;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Failed)) {
                    return false;
                }
                Failed failed = (Failed) obj;
                return Intrinsics.areEqual(this.errorMsg, failed.errorMsg) && this.errorCode == failed.errorCode;
            }
        }

        /* compiled from: P */
        /* loaded from: classes31.dex */
        public static final class Succeed<RSP> extends SuspendResult<RSP> {
            public final RSP data;

            public Succeed(RSP rsp) {
                super(null);
                this.data = rsp;
            }
        }

        public /* synthetic */ SuspendResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public SuspendResult() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <REQ extends ISSOModel, RSP> Object requestWithCmd(final String str, REQ req, ISSOModelFactory<RSP> iSSOModelFactory, Continuation<? super NetworkResponse<RSP>> continuation) {
        NetworkUtils$requestWithCmd$5 networkUtils$requestWithCmd$5;
        Object coroutine_suspended;
        int i3;
        Continuation intercepted;
        Object coroutine_suspended2;
        e eVar;
        if (continuation instanceof NetworkUtils$requestWithCmd$5) {
            networkUtils$requestWithCmd$5 = (NetworkUtils$requestWithCmd$5) continuation;
            int i16 = networkUtils$requestWithCmd$5.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                networkUtils$requestWithCmd$5.label = i16 - Integer.MIN_VALUE;
                Object obj = networkUtils$requestWithCmd$5.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = networkUtils$requestWithCmd$5.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    final BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                    final e encode = req.encode();
                    networkUtils$requestWithCmd$5.L$0 = iSSOModelFactory;
                    networkUtils$requestWithCmd$5.label = 1;
                    int i17 = BridgeModule.$r8$clinit;
                    currentBridgeModule.getClass();
                    final long a16 = a.f453719a.a();
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(networkUtils$requestWithCmd$5);
                    final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                    currentBridgeModule.ssoRequest(str, encode, false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$ssoRequest$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar2) {
                            e eVar3 = eVar2;
                            TimerKt.d(1, new Function0<Unit>(encode, str, a.f453719a.a() - a16, eVar3) { // from class: com.tencent.hippykotlin.demo.pages.base.BridgeModule$ssoRequest$2$1.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    try {
                                        BridgeModule bridgeModule = BridgeModule.this;
                                        int i18 = BridgeModule.$r8$clinit;
                                        bridgeModule.getClass();
                                    } catch (Throwable unused) {
                                        KLog.INSTANCE.e("BridgeModule", "\u76d1\u542c\u8bf7\u6c42\u8017\u65f6\u5931\u8d25");
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                            safeContinuation.resumeWith(Result.m476constructorimpl(eVar3));
                            return Unit.INSTANCE;
                        }
                    });
                    obj = safeContinuation.getOrThrow();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (obj == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(networkUtils$requestWithCmd$5);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    iSSOModelFactory = networkUtils$requestWithCmd$5.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                eVar = (e) obj;
                if (eVar == null) {
                    SpanReqData spanReqData = new SpanReqData(eVar.q("spanContext", ""), eVar.q("traceId", ""));
                    if (eVar.a("errorCode")) {
                        return new NetworkResponse(eVar.k("errorCode", -1), eVar.q("errorMsg", "response error message is empty."), null, spanReqData, 4);
                    }
                    return new NetworkResponse(0, null, iSSOModelFactory.decode(new e(eVar.q("data", "{}"))), spanReqData, 3);
                }
                return new NetworkResponse(-1, "response is empty.", null, null, 12);
            }
        }
        networkUtils$requestWithCmd$5 = new NetworkUtils$requestWithCmd$5(this, continuation);
        Object obj2 = networkUtils$requestWithCmd$5.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = networkUtils$requestWithCmd$5.label;
        if (i3 != 0) {
        }
        eVar = (e) obj2;
        if (eVar == null) {
        }
    }

    public final <REQ extends ISSOReqModel, RSP extends ISSORspModel<RSP>> void requestWithCmd(String str, REQ req, RSP rsp, Function1<? super RSP, Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e encode = ((UnifySearchReqBody) req).encode();
        NetworkUtils$requestWithCmd$7 networkUtils$requestWithCmd$7 = new NetworkUtils$requestWithCmd$7(function2, rsp, function1);
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest(str, encode, false, networkUtils$requestWithCmd$7);
    }
}
