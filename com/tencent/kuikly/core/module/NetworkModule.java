package com.tencent.kuikly.core.module;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJB\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016J|\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062d\u0010\u0018\u001a`\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000ej\u0002`\u0017J\u0091\u0001\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2O\u0010\u0018\u001aK\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00160\u001aj\u0002`\u001bJ\u00a6\u0001\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2d\u0010\u0018\u001a`\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000ej\u0002`\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/kuikly/core/module/NetworkModule;", "Lcom/tencent/kuikly/core/module/Module;", "", "url", "", "isPost", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "param", "headers", "cookie", "", "timeout", "b", "moduleName", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "data", "success", "errorMsg", "Lcom/tencent/kuikly/core/module/j;", "response", "", "Lcom/tencent/kuikly/core/module/NMAllResponse;", "responseCallback", "g", "Lkotlin/Function3;", "Lcom/tencent/kuikly/core/module/NMResponse;", "c", "d", "<init>", "()V", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class NetworkModule extends Module {
    public static final /* synthetic */ f a(NetworkModule networkModule) {
        networkModule.getClass();
        return null;
    }

    private final com.tencent.kuikly.core.nvi.serialization.json.e b(String url, boolean isPost, com.tencent.kuikly.core.nvi.serialization.json.e param, com.tencent.kuikly.core.nvi.serialization.json.e headers, String cookie, int timeout) {
        String str;
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("url", url);
        if (isPost) {
            str = "POST";
        } else {
            str = "GET";
        }
        eVar.v("method", str);
        eVar.v("param", param);
        if (headers != null) {
            eVar.v("headers", headers);
        }
        if (cookie != null) {
            eVar.v("cookie", cookie);
        }
        eVar.t("timeout", timeout);
        return eVar;
    }

    public final void d(final String url, final boolean isPost, final com.tencent.kuikly.core.nvi.serialization.json.e param, com.tencent.kuikly.core.nvi.serialization.json.e headers, String cookie, int timeout, final Function4<? super com.tencent.kuikly.core.nvi.serialization.json.e, ? super Boolean, ? super String, ? super NetworkResponse, Unit> responseCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        final long a16 = zz0.a.f453719a.a();
        Module.toNative$default(this, false, "httpRequest", b(url, isPost, param, headers, cookie, timeout).toString(), new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.kuikly.core.module.NetworkModule$httpRequest$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Integer] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                com.tencent.kuikly.core.nvi.serialization.json.e eVar2;
                T t16;
                if (eVar != null) {
                    long j3 = a16;
                    boolean z16 = isPost;
                    Function4<com.tencent.kuikly.core.nvi.serialization.json.e, Boolean, String, NetworkResponse, Unit> function4 = responseCallback;
                    final NetworkModule networkModule = this;
                    final String str = url;
                    final com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = param;
                    String q16 = eVar.q("data", "");
                    try {
                        eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e(q16);
                    } catch (Throwable unused) {
                        eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                        eVar2.v("data", q16);
                    }
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    try {
                        t16 = new com.tencent.kuikly.core.nvi.serialization.json.e(eVar.q("headers", "{}"));
                    } catch (Throwable unused2) {
                        t16 = 0;
                    }
                    objectRef.element = t16;
                    final boolean a17 = com.tencent.kuikly.core.base.d.a(eVar.j("success"));
                    final String p16 = eVar.p("errorMsg");
                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    if (eVar.a(HiAnalyticsConstant.HaKey.BI_KEY_RESULT)) {
                        objectRef2.element = Integer.valueOf(eVar.j(HiAnalyticsConstant.HaKey.BI_KEY_RESULT));
                    }
                    com.tencent.kuikly.core.nvi.serialization.json.e eVar4 = (com.tencent.kuikly.core.nvi.serialization.json.e) objectRef.element;
                    if (eVar4 == null) {
                        eVar4 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                    }
                    NetworkResponse networkResponse = new NetworkResponse(eVar4, (Integer) objectRef2.element);
                    final long a18 = zz0.a.f453719a.a() - j3;
                    String str2 = z16 ? "POST" : "GET";
                    function4.invoke(eVar2, Boolean.valueOf(a17), p16, networkResponse);
                    final String str3 = str2;
                    TimerKt.d(1, new Function0<Unit>() { // from class: com.tencent.kuikly.core.module.NetworkModule$httpRequest$2$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            try {
                                NetworkModule.a(NetworkModule.this);
                            } catch (Throwable unused3) {
                                KLog.INSTANCE.e("NetworkModule", "\u76d1\u542c\u8bf7\u6c42\u8017\u65f6\u5931\u8d25");
                            }
                        }
                    });
                }
            }
        }, false, 16, null);
    }

    public final void g(String url, com.tencent.kuikly.core.nvi.serialization.json.e param, Function4<? super com.tencent.kuikly.core.nvi.serialization.json.e, ? super Boolean, ? super String, ? super NetworkResponse, Unit> responseCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        d(url, false, param, null, null, 30, responseCallback);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public String moduleName() {
        return "KRNetworkModule";
    }

    public final void c(String url, boolean isPost, com.tencent.kuikly.core.nvi.serialization.json.e param, com.tencent.kuikly.core.nvi.serialization.json.e headers, String cookie, int timeout, final Function3<? super com.tencent.kuikly.core.nvi.serialization.json.e, ? super Boolean, ? super String, Unit> responseCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        d(url, isPost, param, headers, cookie, timeout, new Function4<com.tencent.kuikly.core.nvi.serialization.json.e, Boolean, String, NetworkResponse, Unit>() { // from class: com.tencent.kuikly.core.module.NetworkModule$httpRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar, Boolean bool, String str, NetworkResponse networkResponse) {
                invoke(eVar, bool.booleanValue(), str, networkResponse);
                return Unit.INSTANCE;
            }

            public final void invoke(com.tencent.kuikly.core.nvi.serialization.json.e data, boolean z16, String errorMsg, NetworkResponse response) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Intrinsics.checkNotNullParameter(response, "response");
                responseCallback.invoke(data, Boolean.valueOf(z16), errorMsg);
            }
        });
    }

    public static /* synthetic */ void f(NetworkModule networkModule, String str, boolean z16, com.tencent.kuikly.core.nvi.serialization.json.e eVar, com.tencent.kuikly.core.nvi.serialization.json.e eVar2, String str2, int i3, Function4 function4, int i16, Object obj) {
        networkModule.d(str, z16, eVar, (i16 & 8) != 0 ? null : eVar2, (i16 & 16) != 0 ? null : str2, (i16 & 32) != 0 ? 30 : i3, function4);
    }
}
