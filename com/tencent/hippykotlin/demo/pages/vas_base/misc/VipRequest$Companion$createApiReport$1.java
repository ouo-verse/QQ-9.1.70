package com.tencent.hippykotlin.demo.pages.vas_base.misc;

import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.hippykotlin.demo.pages.vas_base.report.keport.ApiParam;
import com.tencent.hippykotlin.demo.pages.vas_base.report.keport.Keport;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.random.Random;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import zz0.a;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.misc.VipRequest$Companion$createApiReport$1", f = "VipRequest.kt", i = {0, 0}, l = {85}, m = "invokeSuspend", n = {"fullUrl", "beforeRequestTime"}, s = {"L$0", "J$0"})
/* loaded from: classes33.dex */
public final class VipRequest$Companion$createApiReport$1 extends SuspendLambda implements Function3<RequestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, Continuation<? super Response>, Object> {
    public final /* synthetic */ String $business;
    public final /* synthetic */ Keport $kReport;
    public long J$0;
    public /* synthetic */ Object L$0;
    public /* synthetic */ Function2 L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipRequest$Companion$createApiReport$1(Keport keport, String str, Continuation<? super VipRequest$Companion$createApiReport$1> continuation) {
        super(3, continuation);
        this.$kReport = keport;
        this.$business = str;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(RequestConfig requestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object> function2, Continuation<? super Response> continuation) {
        VipRequest$Companion$createApiReport$1 vipRequest$Companion$createApiReport$1 = new VipRequest$Companion$createApiReport$1(this.$kReport, this.$business, continuation);
        vipRequest$Companion$createApiReport$1.L$0 = requestConfig;
        vipRequest$Companion$createApiReport$1.L$1 = function2;
        return vipRequest$Companion$createApiReport$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        long j3;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            RequestConfig requestConfig = (RequestConfig) this.L$0;
            Function2 function2 = this.L$1;
            long a16 = a.f453719a.a();
            String str2 = requestConfig.baseURL;
            String str3 = requestConfig.url;
            if (!(str2.length() > 0) || new Regex("^([a-z][a-z\\d+\\-.]*:)?//", RegexOption.IGNORE_CASE).containsMatchIn(str3)) {
                str2 = str3;
            } else {
                if (str3.length() > 0) {
                    str2 = new Regex("/?/$").replace(str2, "") + '/' + new Regex("^/+").replace(str3, "");
                }
            }
            this.L$0 = str2;
            this.J$0 = a16;
            this.label = 1;
            obj = function2.invoke(requestConfig, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = a16;
            str = str2;
        } else if (i3 == 1) {
            j3 = this.J$0;
            String str4 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            str = str4;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Response response = (Response) obj;
        if (!VipRequest.urlSamplingList.contains(str) || Random.INSTANCE.nextInt(10000) <= 1) {
            this.$kReport.apiAggregator.add(new ApiParam(str, (int) (a.f453719a.a() - j3), String.valueOf(response.status), response.data.q("code", "0"), this.$business));
        }
        return response;
    }
}
