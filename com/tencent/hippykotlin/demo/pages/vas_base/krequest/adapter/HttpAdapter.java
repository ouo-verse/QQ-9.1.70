package com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter;

import com.tencent.hippykotlin.demo.pages.foundation.lib.QQBrowser;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUtil;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Method;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.URL;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.VasUserAgent;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.NetworkModule;
import com.tencent.kuikly.core.module.NetworkResponse;
import com.tencent.kuikly.core.module.e;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.pager.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HttpAdapter implements Adapter {
    public static final HttpAdapter instance = new HttpAdapter();

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
        URL url = new URL(str);
        return Intrinsics.areEqual(url.f114309protocol, "https") || Intrinsics.areEqual(url.f114309protocol, "http");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x020f A[PHI: r1
  0x020f: PHI (r1v24 java.lang.Object) = (r1v20 java.lang.Object), (r1v1 java.lang.Object) binds: [B:29:0x020c, B:10:0x0031] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x020e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.String] */
    @Override // com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object request(RequestConfig requestConfig, Continuation<? super Response> continuation) {
        HttpAdapter$request$1 httpAdapter$request$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        String joinToString$default;
        Map map;
        String str;
        ?? r112;
        String str2;
        Object obj2;
        String str3;
        Continuation intercepted;
        Object coroutine_suspended2;
        final RequestConfig requestConfig2 = requestConfig;
        if (continuation instanceof HttpAdapter$request$1) {
            httpAdapter$request$1 = (HttpAdapter$request$1) continuation;
            int i16 = httpAdapter$request$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                httpAdapter$request$1.label = i16 - Integer.MIN_VALUE;
                obj = httpAdapter$request$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = httpAdapter$request$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    String str4 = httpAdapter$request$1.L$4;
                    map = httpAdapter$request$1.L$3;
                    String str5 = httpAdapter$request$1.L$2;
                    joinToString$default = httpAdapter$request$1.L$1;
                    RequestConfig requestConfig3 = httpAdapter$request$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str2 = str5;
                    str = str4;
                    requestConfig2 = requestConfig3;
                    obj2 = obj;
                } else {
                    ResultKt.throwOnFailure(obj);
                    String str6 = requestConfig2.baseURL;
                    String str7 = requestConfig2.url;
                    if (!(str6.length() > 0) || new Regex("^([a-z][a-z\\d+\\-.]*:)?//", RegexOption.IGNORE_CASE).containsMatchIn(str7)) {
                        str6 = str7;
                    } else if (str7.length() > 0) {
                        str6 = new Regex("/?/$").replace(str6, "") + '/' + new Regex("^/+").replace(str7, "");
                    }
                    Map<String, String> map2 = requestConfig2.cookies;
                    ArrayList arrayList = new ArrayList(map2.size());
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        arrayList.add(entry.getKey() + '=' + entry.getValue());
                    }
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "; ", null, null, 0, null, null, 62, null);
                    URL url = new URL(str6);
                    url.searchParams.putAll(requestConfig2.params);
                    String href = url.getHref();
                    map = requestConfig2.headers;
                    httpAdapter$request$1.L$0 = requestConfig2;
                    httpAdapter$request$1.L$1 = joinToString$default;
                    httpAdapter$request$1.L$2 = href;
                    httpAdapter$request$1.L$3 = map;
                    str = "User-Agent";
                    httpAdapter$request$1.L$4 = "User-Agent";
                    httpAdapter$request$1.label = 1;
                    VasUserAgent vasUserAgent = VasUserAgent.INSTANCE;
                    if (VasUserAgent.userAgent.length() > 0) {
                        r112 = VasUserAgent.userAgent;
                    } else {
                        vasUserAgent.updateUserAgent();
                        MqqUtil util = Mqq.INSTANCE.getUtil();
                        String cache_key = vasUserAgent.getCACHE_KEY();
                        util.getClass();
                        if (QQUtils.INSTANCE.compare("9.1.50") >= 0) {
                            r112 = ((e) h.a().acquireModule("KRDiskCacheModule")).c(cache_key);
                        } else {
                            r112 = ((CacheModule) c.f117352a.g().acquireModule("HRCacheModule")).getItem(cache_key);
                        }
                        if (!(r112.length() > 0)) {
                            r112 = QQBrowser.INSTANCE.getUserAgent(httpAdapter$request$1);
                        }
                    }
                    if (r112 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str2 = href;
                    obj2 = r112;
                }
                map.put(str, obj2);
                str3 = requestConfig2.headers.get("Content-Type");
                if (str3 != null || str3.length() == 0) {
                    requestConfig2.headers.put("Content-Type", "application/json");
                }
                httpAdapter$request$1.L$0 = requestConfig2;
                httpAdapter$request$1.L$1 = joinToString$default;
                httpAdapter$request$1.L$2 = str2;
                httpAdapter$request$1.L$3 = null;
                httpAdapter$request$1.L$4 = null;
                httpAdapter$request$1.label = 2;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(httpAdapter$request$1);
                final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                ((NetworkModule) c.f117352a.g().acquireModule("KRNetworkModule")).d(str2, requestConfig2.method != Method.POST, requestConfig2.data, b01.c.b(requestConfig2.headers), joinToString$default, requestConfig2.timeout, new Function4<com.tencent.kuikly.core.nvi.serialization.json.e, Boolean, String, NetworkResponse, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter.HttpAdapter$request$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar, Boolean bool, String str8, NetworkResponse networkResponse) {
                        int i17;
                        String valueOf;
                        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = eVar;
                        boolean booleanValue = bool.booleanValue();
                        String str9 = str8;
                        NetworkResponse networkResponse2 = networkResponse;
                        if (booleanValue) {
                            Integer statusCode = networkResponse2.getStatusCode();
                            i17 = statusCode != null ? statusCode.intValue() : 200;
                        } else {
                            Integer statusCode2 = networkResponse2.getStatusCode();
                            if (statusCode2 == null || (i17 = statusCode2.intValue()) < 400) {
                                i17 = 502;
                            }
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        Iterator<String> c16 = networkResponse2.getHeaderFields().c();
                        while (c16.hasNext()) {
                            String next = c16.next();
                            Object e16 = networkResponse2.getHeaderFields().e(next);
                            if (e16 instanceof b) {
                                valueOf = CollectionsKt___CollectionsKt.joinToString$default(((b) e16).w(), ";", null, null, 0, null, null, 62, null);
                            } else {
                                valueOf = String.valueOf(e16);
                            }
                            linkedHashMap.put(next, valueOf);
                        }
                        Continuation<Response> continuation2 = safeContinuation;
                        Result.Companion companion = Result.INSTANCE;
                        continuation2.resumeWith(Result.m476constructorimpl(new Response(eVar2, i17, booleanValue ? "OK" : str9, linkedHashMap, requestConfig2)));
                        return Unit.INSTANCE;
                    }
                });
                obj = safeContinuation.getOrThrow();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(httpAdapter$request$1);
                }
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        httpAdapter$request$1 = new HttpAdapter$request$1(this, continuation);
        obj = httpAdapter$request$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = httpAdapter$request$1.label;
        if (i3 == 0) {
        }
        map.put(str, obj2);
        str3 = requestConfig2.headers.get("Content-Type");
        if (str3 != null || str3.length() == 0) {
        }
        httpAdapter$request$1.L$0 = requestConfig2;
        httpAdapter$request$1.L$1 = joinToString$default;
        httpAdapter$request$1.L$2 = str2;
        httpAdapter$request$1.L$3 = null;
        httpAdapter$request$1.L$4 = null;
        httpAdapter$request$1.label = 2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(httpAdapter$request$1);
        final Continuation<? super Response> safeContinuation2 = new SafeContinuation(intercepted);
        ((NetworkModule) c.f117352a.g().acquireModule("KRNetworkModule")).d(str2, requestConfig2.method != Method.POST, requestConfig2.data, b01.c.b(requestConfig2.headers), joinToString$default, requestConfig2.timeout, new Function4<com.tencent.kuikly.core.nvi.serialization.json.e, Boolean, String, NetworkResponse, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter.HttpAdapter$request$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar, Boolean bool, String str8, NetworkResponse networkResponse) {
                int i17;
                String valueOf;
                com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = eVar;
                boolean booleanValue = bool.booleanValue();
                String str9 = str8;
                NetworkResponse networkResponse2 = networkResponse;
                if (booleanValue) {
                    Integer statusCode = networkResponse2.getStatusCode();
                    i17 = statusCode != null ? statusCode.intValue() : 200;
                } else {
                    Integer statusCode2 = networkResponse2.getStatusCode();
                    if (statusCode2 == null || (i17 = statusCode2.intValue()) < 400) {
                        i17 = 502;
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator<String> c16 = networkResponse2.getHeaderFields().c();
                while (c16.hasNext()) {
                    String next = c16.next();
                    Object e16 = networkResponse2.getHeaderFields().e(next);
                    if (e16 instanceof b) {
                        valueOf = CollectionsKt___CollectionsKt.joinToString$default(((b) e16).w(), ";", null, null, 0, null, null, 62, null);
                    } else {
                        valueOf = String.valueOf(e16);
                    }
                    linkedHashMap.put(next, valueOf);
                }
                Continuation<Response> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(new Response(eVar2, i17, booleanValue ? "OK" : str9, linkedHashMap, requestConfig2)));
                return Unit.INSTANCE;
            }
        });
        obj = safeContinuation2.getOrThrow();
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (obj == coroutine_suspended2) {
        }
        if (obj != coroutine_suspended) {
        }
    }
}
