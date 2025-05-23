package com.tencent.hippykotlin.demo.pages.qwallet.base.http;

import c45.d;
import c45.i;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.qwallet.base.http.interceptor.IQWalletInterceptor;
import com.tencent.hippykotlin.demo.pages.qwallet.base.http.interceptor.InterceptorData;
import com.tencent.hippykotlin.demo.pages.qwallet.base.http.interceptor.UniqueRequestInterceptor;
import com.tencent.hippykotlin.demo.pages.qwallet.base.log.QWLog;
import com.tencent.hippykotlin.demo.pages.qwallet.base.module.GatewaySSORequest;
import com.tencent.hippykotlin.demo.pages.qwallet.base.module.QWalletGatewaySSOModule;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import d45.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QWalletGatewayServlet {
    public static final QWalletGatewayServlet INSTANCE = new QWalletGatewayServlet();
    public static final List<IQWalletInterceptor> interceptors;

    static {
        List<IQWalletInterceptor> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new UniqueRequestInterceptor());
        interceptors = mutableListOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x01c1 A[LOOP:0: B:22:0x01bb->B:24:0x01c1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <Req extends d, Rsp extends d> Object sendRequest(final String str, final String str2, Req req, final d.a<Rsp> aVar, String str3, boolean z16, boolean z17, List<? extends IQWalletInterceptor> list, Continuation<? super PbResponse<Rsp>> continuation) {
        QWalletGatewayServlet$sendRequest$2 qWalletGatewayServlet$sendRequest$2;
        Object coroutine_suspended;
        int i3;
        List<IQWalletInterceptor> plus;
        PbResponse pbResponse;
        String str4;
        Continuation intercepted;
        String decodeToString;
        Object coroutine_suspended2;
        List<IQWalletInterceptor> list2;
        InterceptorData interceptorData;
        QWalletGatewayServlet qWalletGatewayServlet;
        Iterator<T> it;
        Rsp rsp;
        String decodeToString2;
        if (continuation instanceof QWalletGatewayServlet$sendRequest$2) {
            qWalletGatewayServlet$sendRequest$2 = (QWalletGatewayServlet$sendRequest$2) continuation;
            int i16 = qWalletGatewayServlet$sendRequest$2.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qWalletGatewayServlet$sendRequest$2.label = i16 - Integer.MIN_VALUE;
                Object obj = qWalletGatewayServlet$sendRequest$2.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qWalletGatewayServlet$sendRequest$2.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    InterceptorData interceptorData2 = new InterceptorData(str, str2, z17);
                    if (!(list == null || list.isEmpty())) {
                        plus = CollectionsKt___CollectionsKt.plus((Collection) interceptors, (Iterable) list);
                    } else {
                        plus = interceptors;
                    }
                    Iterator<T> it5 = plus.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            pbResponse = null;
                            break;
                        }
                        Object onBeforeSend = ((IQWalletInterceptor) it5.next()).onBeforeSend(interceptorData2);
                        if (onBeforeSend != null) {
                            pbResponse = (PbResponse) onBeforeSend;
                            break;
                        }
                    }
                    if (pbResponse != null) {
                        return pbResponse;
                    }
                    final QWalletGatewaySSOModule qWalletGatewaySSOModule = (QWalletGatewaySSOModule) c.f117352a.g().acquireModule("QWalletGatewaySSOModule");
                    qWalletGatewayServlet$sendRequest$2.L$0 = this;
                    str4 = str3;
                    qWalletGatewayServlet$sendRequest$2.L$1 = str4;
                    qWalletGatewayServlet$sendRequest$2.L$2 = interceptorData2;
                    qWalletGatewayServlet$sendRequest$2.L$3 = plus;
                    qWalletGatewayServlet$sendRequest$2.label = 1;
                    qWalletGatewaySSOModule.getClass();
                    QWLog qWLog = QWLog.INSTANCE;
                    QWLog.INSTANCE.i("QWalletGatewaySSOModule", "send gateway request [" + str + '.' + str2 + ']', false);
                    final long currentTimeStamp = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(qWalletGatewayServlet$sendRequest$2);
                    final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                    final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    final String c16 = TimerKt.c(10000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.base.module.QWalletGatewaySSOModule$sendGatewayRequest$2$timeoutJob$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                            if (!booleanRef2.element) {
                                booleanRef2.element = true;
                                QWLog qWLog2 = QWLog.INSTANCE;
                                StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('[');
                                m3.append(str);
                                m3.append('.');
                                m3.append(str2);
                                m3.append("] timeout");
                                qWLog2.e(m3.toString());
                                Continuation<PbResponse<d>> continuation2 = safeContinuation;
                                Result.Companion companion = Result.INSTANCE;
                                continuation2.resumeWith(Result.m476constructorimpl(new PbResponse(false, -100001, "\u7cfb\u7edf\u7e41\u5fd9", null)));
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    decodeToString = StringsKt__StringsJVMKt.decodeToString(a.b(i.d(req)));
                    final GatewaySSORequest gatewaySSORequest = new GatewaySSORequest(str, str2, decodeToString, z16);
                    final Function1<PbResponse<d>, Unit> function1 = new Function1<PbResponse<d>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.base.module.QWalletGatewaySSOModule$sendGatewayRequest$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(PbResponse<d> pbResponse2) {
                            PbResponse<d> pbResponse3 = pbResponse2;
                            QWLog qWLog2 = QWLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("gateway finish: ");
                            m3.append(GatewaySSORequest.this);
                            m3.append('[');
                            m3.append(pbResponse3.code);
                            m3.append("][");
                            m3.append(pbResponse3.f114187msg);
                            m3.append("][");
                            m3.append(Utils.INSTANCE.currentBridgeModule().currentTimeStamp() - currentTimeStamp);
                            m3.append("ms]");
                            QWLog.INSTANCE.i("QWalletGatewaySSOModule", m3.toString(), false);
                            Ref.BooleanRef booleanRef2 = booleanRef;
                            if (!booleanRef2.element) {
                                booleanRef2.element = true;
                                TimerKt.a(c16);
                                safeContinuation.resumeWith(Result.m476constructorimpl(pbResponse3));
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("service", str, "method", str2);
                    m3.v(Const.BUNDLE_KEY_REQUEST, decodeToString);
                    m3.w("needEncrypt", z16);
                    qWalletGatewaySSOModule.callNativeMethod("sendGatewayRequest", m3, new Function1<e, Unit>(qWalletGatewaySSOModule, gatewaySSORequest, function1, aVar) { // from class: com.tencent.hippykotlin.demo.pages.qwallet.base.module.QWalletGatewaySSOModule$callNativeGateway$1
                        public final /* synthetic */ GatewaySSORequest $gatewaySSORequest;
                        public final /* synthetic */ Function1<PbResponse<d>, Unit> $pbRspCallback;
                        public final /* synthetic */ d.a<d> $rsp;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                            this.$gatewaySSORequest = gatewaySSORequest;
                            this.$pbRspCallback = function1;
                            this.$rsp = aVar;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar) {
                            e eVar2 = eVar;
                            if (eVar2 == null) {
                                this.$pbRspCallback.invoke(new PbResponse<>(false, -1, "empty response", null));
                            } else {
                                int k3 = eVar2.k("ret_code", -1);
                                String p16 = eVar2.p("ret_msg");
                                String p17 = eVar2.p("response");
                                byte[] a16 = p17 != null ? a.a(p17) : null;
                                if (a16 == null) {
                                    QWLog.INSTANCE.e(this.$gatewaySSORequest + " fail, rspData is null: [" + k3 + "][" + p16 + ']');
                                    this.$pbRspCallback.invoke(new PbResponse<>(false, k3, AgreementConsentViewKt$$ExternalSyntheticOutline0.m("request fail: ", p16), null));
                                } else if (k3 == 0) {
                                    this.$pbRspCallback.invoke(new PbResponse<>(true, k3, p16, i.a(this.$rsp, a16)));
                                } else {
                                    QWLog.INSTANCE.e(this.$gatewaySSORequest + " fail: [" + k3 + "][" + p16 + ']');
                                    this.$pbRspCallback.invoke(new PbResponse<>(false, k3, p16, null));
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    Object orThrow = safeContinuation.getOrThrow();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (orThrow == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(qWalletGatewayServlet$sendRequest$2);
                    }
                    if (orThrow == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list2 = plus;
                    interceptorData = interceptorData2;
                    qWalletGatewayServlet = this;
                    obj = orThrow;
                } else if (i3 == 1) {
                    list2 = qWalletGatewayServlet$sendRequest$2.L$3;
                    interceptorData = qWalletGatewayServlet$sendRequest$2.L$2;
                    String str5 = qWalletGatewayServlet$sendRequest$2.L$1;
                    qWalletGatewayServlet = qWalletGatewayServlet$sendRequest$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    str4 = str5;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                PbResponse pbResponse2 = (PbResponse) obj;
                if (!(str4 != null || str4.length() == 0) && pbResponse2.success && (rsp = pbResponse2.rsp) != 0) {
                    Intrinsics.checkNotNull(rsp, "null cannot be cast to non-null type pbandk.Message");
                    CacheModule cacheModule = (CacheModule) c.f117352a.g().acquireModule("HRCacheModule");
                    decodeToString2 = StringsKt__StringsJVMKt.decodeToString(a.b(i.d((d) rsp)));
                    e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("KEY_RSP_BASE_64", decodeToString2);
                    m16.u("KEY_TIME_STAMP", Utils.INSTANCE.currentBridgeModule().currentTimeStamp());
                    String eVar = m16.toString();
                    QWLog.INSTANCE.i("", "save cache: cacheId:" + str4, false);
                    cacheModule.setItem(str4, eVar);
                }
                qWalletGatewayServlet.getClass();
                it = list2.iterator();
                while (it.hasNext()) {
                    ((IQWalletInterceptor) it.next()).onAfterSend(interceptorData);
                }
                return pbResponse2;
            }
        }
        qWalletGatewayServlet$sendRequest$2 = new QWalletGatewayServlet$sendRequest$2(this, continuation);
        Object obj2 = qWalletGatewayServlet$sendRequest$2.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qWalletGatewayServlet$sendRequest$2.label;
        if (i3 != 0) {
        }
        PbResponse pbResponse22 = (PbResponse) obj2;
        if (!(str4 != null || str4.length() == 0)) {
            Intrinsics.checkNotNull(rsp, "null cannot be cast to non-null type pbandk.Message");
            CacheModule cacheModule2 = (CacheModule) c.f117352a.g().acquireModule("HRCacheModule");
            decodeToString2 = StringsKt__StringsJVMKt.decodeToString(a.b(i.d((d) rsp)));
            e m162 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("KEY_RSP_BASE_64", decodeToString2);
            m162.u("KEY_TIME_STAMP", Utils.INSTANCE.currentBridgeModule().currentTimeStamp());
            String eVar2 = m162.toString();
            QWLog.INSTANCE.i("", "save cache: cacheId:" + str4, false);
            cacheModule2.setItem(str4, eVar2);
        }
        qWalletGatewayServlet.getClass();
        it = list2.iterator();
        while (it.hasNext()) {
        }
        return pbResponse22;
    }
}
