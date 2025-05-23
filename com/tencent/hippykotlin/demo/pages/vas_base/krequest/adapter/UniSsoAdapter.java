package com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter;

import com.tencent.hippy.qq.utils.WebSSOUtils;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.QKRNetworkModule;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.URL;
import com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLogKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Map;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt___StringsKt;
import org.apache.httpcore.HttpStatus;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class UniSsoAdapter implements Adapter {
    public static final Companion Companion = new Companion();
    public static final Map<Integer, Integer> codeMap;
    public static final UniSsoAdapter instance;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
    }

    static {
        Map<Integer, Integer> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, 200), TuplesKt.to(101, 413), TuplesKt.to(102, Integer.valueOf(HttpStatus.SC_TOO_MANY_REQUESTS)), TuplesKt.to(103, 400), TuplesKt.to(201, 500), TuplesKt.to(202, 504));
        codeMap = mapOf;
        instance = new UniSsoAdapter();
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter.Adapter
    public final boolean adapt(RequestConfig requestConfig) {
        String str = requestConfig.baseURL;
        String str2 = requestConfig.url;
        if (!(str.length() > 0) || new Regex("^([a-z][a-z\\d+\\-.]*:)?//", RegexOption.IGNORE_CASE).containsMatchIn(str2)) {
            str = str2;
        } else {
            if (str2.length() > 0) {
                str = new Regex("/?/$").replace(str, "") + '/' + new Regex("^/+").replace(str2, "");
            }
        }
        return Intrinsics.areEqual(new URL(str).getOrigin(), "sso://unisso");
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter.Adapter
    public final Object request(final RequestConfig requestConfig, Continuation<? super Response> continuation) {
        Continuation intercepted;
        String drop;
        Object coroutine_suspended;
        String str = requestConfig.baseURL;
        String str2 = requestConfig.url;
        if (!(str.length() > 0) || new Regex("^([a-z][a-z\\d+\\-.]*:)?//", RegexOption.IGNORE_CASE).containsMatchIn(str2)) {
            str = str2;
        } else {
            if (str2.length() > 0) {
                str = new Regex("/?/$").replace(str, "") + '/' + new Regex("^/+").replace(str2, "");
            }
        }
        URL url = new URL(str);
        if (Intrinsics.areEqual(url.getOrigin(), "sso://unisso")) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            QKRNetworkModule qKRNetworkModule = (QKRNetworkModule) c.f117352a.g().acquireModule("QKRNetworkModule");
            drop = StringsKt___StringsKt.drop(url.pathname, 1);
            e eVar = requestConfig.data;
            long j3 = requestConfig.timeout * 1000;
            Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter.UniSsoAdapter$request$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar2) {
                    String p16;
                    e eVar3 = eVar2;
                    if (eVar3 == null) {
                        safeContinuation.resumeWith(Result.m476constructorimpl(new Response(new e(), 400, "Bad Request", requestConfig)));
                    } else {
                        VLogKt.getClog(this).log$enumunboxing$("sso response: " + eVar3, 1, true);
                        e m3 = eVar3.m("data");
                        if (m3 == null) {
                            m3 = new e();
                        }
                        int j16 = eVar3.j(WebSSOUtils.CALLBACK_COLUMN_SSORET);
                        Integer num = UniSsoAdapter.codeMap.get(Integer.valueOf(j16));
                        if (num != null) {
                            j16 = num.intValue();
                        }
                        if (eVar3.a(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET)) {
                            m3.t("code", eVar3.j(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET));
                        }
                        m3.v("msgRaw", eVar3.q("msg", ""));
                        Continuation<Response> continuation2 = safeContinuation;
                        if (j16 == 200) {
                            p16 = "OK";
                        } else {
                            p16 = eVar3.p("msg");
                        }
                        continuation2.resumeWith(Result.m476constructorimpl(new Response(m3, j16, p16, requestConfig)));
                    }
                    return Unit.INSTANCE;
                }
            };
            qKRNetworkModule.getClass();
            e eVar2 = new e();
            eVar2.v("cmd", drop);
            eVar2.v("data", eVar);
            eVar2.u("timeout", j3);
            qKRNetworkModule.toNative(false, "uniAgent", eVar2.toString(), function1, true);
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("SSO\u8bf7\u6c42 origin \u5fc5\u987b\u662f sso://unisso\uff0c\u5f53\u524d\uff1a");
        m3.append(url.getOrigin());
        throw new IllegalArgumentException(m3.toString());
    }
}
