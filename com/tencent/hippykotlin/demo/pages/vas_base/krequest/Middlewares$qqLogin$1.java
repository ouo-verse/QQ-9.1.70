package com.tencent.hippykotlin.demo.pages.vas_base.krequest;

import com.tencent.hippykotlin.demo.pages.vas_base.misc.HttpRequstHelper;
import com.tencent.kuikly.core.manager.c;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.krequest.Middlewares$qqLogin$1", f = "Middlewares.kt", i = {1, 1}, l = {27, 32, 43}, m = "invokeSuspend", n = {DownloadInfo.spKey_Config, "next"}, s = {"L$0", "L$1"})
/* loaded from: classes33.dex */
public final class Middlewares$qqLogin$1 extends SuspendLambda implements Function3<RequestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, Continuation<? super Response>, Object> {
    public /* synthetic */ RequestConfig L$0;
    public /* synthetic */ Function2 L$1;
    public int label;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(RequestConfig requestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object> function2, Continuation<? super Response> continuation) {
        Middlewares$qqLogin$1 middlewares$qqLogin$1 = new Middlewares$qqLogin$1(continuation);
        middlewares$qqLogin$1.L$0 = requestConfig;
        middlewares$qqLogin$1.L$1 = function2;
        return middlewares$qqLogin$1.invokeSuspend(Unit.INSTANCE);
    }

    public Middlewares$qqLogin$1(Continuation<? super Middlewares$qqLogin$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean endsWith$default;
        List split$default;
        List takeLast;
        String joinToString$default;
        Object psk;
        RequestConfig requestConfig;
        Function2 function2;
        List<String> split$default2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        char c16 = 0;
        char c17 = 1;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function2 = this.L$1;
            RequestConfig requestConfig2 = this.L$0;
            ResultKt.throwOnFailure(obj);
            requestConfig = requestConfig2;
            psk = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            RequestConfig requestConfig3 = this.L$0;
            Function2 function22 = this.L$1;
            String str = requestConfig3.baseURL;
            String str2 = requestConfig3.url;
            if (!(str.length() > 0) || new Regex("^([a-z][a-z\\d+\\-.]*:)?//", RegexOption.IGNORE_CASE).containsMatchIn(str2)) {
                str = str2;
            } else if (str2.length() > 0) {
                str = new Regex("/?/$").replace(str, "") + '/' + new Regex("^/+").replace(str2, "");
            }
            String host = new URL(str).getHost();
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(host, QQWinkConstants.VALID_HOST, false, 2, null);
            if (endsWith$default) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) host, new String[]{"."}, false, 0, 6, (Object) null);
                takeLast = CollectionsKt___CollectionsKt.takeLast(split$default, 3);
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(takeLast, ".", null, null, 0, null, null, 62, null);
                HttpRequstHelper httpRequstHelper = HttpRequstHelper.INSTANCE;
                this.L$0 = requestConfig3;
                this.L$1 = function22;
                this.label = 2;
                psk = httpRequstHelper.getPSK(joinToString$default, this);
                if (psk == coroutine_suspended) {
                    return coroutine_suspended;
                }
                requestConfig = requestConfig3;
                function2 = function22;
            } else {
                this.L$0 = null;
                this.label = 1;
                Object invoke = function22.invoke(requestConfig3, this);
                return invoke == coroutine_suspended ? coroutine_suspended : invoke;
            }
        }
        String str3 = (String) psk;
        HttpRequstHelper httpRequstHelper2 = HttpRequstHelper.INSTANCE;
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) str3, new String[]{""}, false, 0, 6, (Object) null);
        long j3 = 5381;
        for (String str4 : split$default2) {
            if ((str4.length() > 0 ? c17 : c16) != 0) {
                Intrinsics.checkNotNullExpressionValue(str4.toCharArray(), "this as java.lang.String).toCharArray()");
                j3 += (j3 << 5) + r13[c16];
                c16 = 0;
                c17 = 1;
            }
        }
        long j16 = TTL.MAX_VALUE & j3;
        Map<String, String> map = requestConfig.cookies;
        c cVar = c.f117352a;
        map.put("uin", cVar.g().getPageData().n().q("uin", ""));
        requestConfig.cookies.put(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN, cVar.g().getPageData().n().q("uin", ""));
        requestConfig.cookies.put("p_skey", str3);
        requestConfig.params.put("g_tk", String.valueOf(j16));
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        Object invoke2 = function2.invoke(requestConfig, this);
        return invoke2 == coroutine_suspended ? coroutine_suspended : invoke2;
    }
}
