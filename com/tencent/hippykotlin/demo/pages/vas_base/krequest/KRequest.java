package com.tencent.hippykotlin.demo.pages.vas_base.krequest;

import com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter.Adapter;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter.HttpAdapter;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter.UniSsoAdapter;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Custom;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Middleware;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.WrapMiddleware;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
/* loaded from: classes33.dex */
public class KRequest {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final RequestConfig defaultConfig;
    public final List<Middleware> middlewares;

    static {
        new KRequest(null, 1, 0 == true ? 1 : 0);
    }

    public KRequest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Middleware>, java.util.ArrayList] */
    public final Object dispatch(int i3, RequestConfig requestConfig, Continuation<? super Response> continuation) {
        Custom custom;
        int lastIndex;
        Object obj;
        Middleware middleware = (Middleware) this.middlewares.get(i3);
        if (middleware instanceof WrapMiddleware) {
            custom = null;
        } else {
            Iterator<T> it = requestConfig.custom.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(((Custom) obj).getClass()), middleware.getCustom())) {
                    break;
                }
            }
            custom = (Custom) obj;
        }
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.middlewares);
        if (i3 == lastIndex) {
            return middleware.execute(requestConfig, custom, new KRequest$dispatch$2(this, null), continuation);
        }
        return middleware.execute(requestConfig, custom, new KRequest$dispatch$3(this, i3, null), continuation);
    }

    public final Object doRequest(RequestConfig requestConfig, Continuation<? super Response> continuation) {
        List listOf;
        Object obj;
        Adapter adapter = requestConfig.adapter;
        if (adapter == null) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Adapter[]{UniSsoAdapter.instance, HttpAdapter.instance});
            Iterator it = listOf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Adapter) obj).adapt(requestConfig)) {
                    break;
                }
            }
            Adapter adapter2 = (Adapter) obj;
            if (adapter2 != null) {
                return adapter2.request(requestConfig, continuation);
            }
            throw new IllegalArgumentException("\u8be5\u8bf7\u6c42\u65e0\u9002\u914d\u5668");
        }
        return adapter.request(requestConfig, continuation);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Middleware>, java.util.ArrayList] */
    public final KRequest use(Function3<? super RequestConfig, ? super Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, ? super Continuation<? super Response>, ? extends Object> function3) {
        this.middlewares.add(new WrapMiddleware(function3));
        return this;
    }

    public KRequest(RequestConfig requestConfig) {
        this.defaultConfig = requestConfig;
        this.middlewares = new ArrayList();
    }

    public /* synthetic */ KRequest(RequestConfig requestConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new RequestConfig(null, null, null, null, null, 0, null, 1023));
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Middleware>, java.util.ArrayList] */
    public final Object request(RequestConfig requestConfig, Continuation<? super Response> continuation) {
        Map plus;
        Map mutableMap;
        Map plus2;
        Map mutableMap2;
        Map plus3;
        Map mutableMap3;
        List plus4;
        List mutableList;
        RequestConfig requestConfig2 = this.defaultConfig;
        String str = requestConfig.baseURL;
        if (str.length() == 0) {
            str = requestConfig2.baseURL;
        }
        String str2 = str;
        Method method = requestConfig.method;
        String str3 = requestConfig.url;
        if (str3.length() == 0) {
            str3 = requestConfig2.url;
        }
        String str4 = str3;
        int i3 = requestConfig.timeout;
        if (i3 == 0) {
            i3 = requestConfig2.timeout;
        }
        int i16 = i3;
        Adapter adapter = requestConfig.adapter;
        if (adapter == null) {
            adapter = requestConfig2.adapter;
        }
        Adapter adapter2 = adapter;
        plus = MapsKt__MapsKt.plus(requestConfig2.headers, requestConfig.headers);
        mutableMap = MapsKt__MapsKt.toMutableMap(plus);
        plus2 = MapsKt__MapsKt.plus(requestConfig2.params, requestConfig.params);
        mutableMap2 = MapsKt__MapsKt.toMutableMap(plus2);
        e eVar = requestConfig2.data;
        e eVar2 = requestConfig.data;
        e eVar3 = new e();
        for (Iterator<String> c16 = eVar.c(); c16.hasNext(); c16 = c16) {
            String next = c16.next();
            eVar3.v(next, eVar.e(next));
        }
        Iterator<String> c17 = eVar2.c();
        while (c17.hasNext()) {
            String next2 = c17.next();
            eVar3.v(next2, eVar2.e(next2));
        }
        plus3 = MapsKt__MapsKt.plus(requestConfig2.cookies, requestConfig.cookies);
        mutableMap3 = MapsKt__MapsKt.toMutableMap(plus3);
        plus4 = CollectionsKt___CollectionsKt.plus((Collection) requestConfig2.custom, (Iterable) requestConfig.custom);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) plus4);
        RequestConfig requestConfig3 = new RequestConfig(str4, method, str2, mutableMap, mutableMap2, eVar3, i16, mutableMap3, mutableList, adapter2);
        if (this.middlewares.isEmpty()) {
            return doRequest(requestConfig3, continuation);
        }
        return dispatch(0, requestConfig3, continuation);
    }
}
