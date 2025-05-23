package com.tencent.hippykotlin.demo.pages.vas_base.krequest;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.vas_base.report.keport.ApiParam;
import com.tencent.hippykotlin.demo.pages.vas_base.report.keport.Keport;
import com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_base.krequest.Middlewares$createApiReport$2", f = "Middlewares.kt", i = {0, 0}, l = {77}, m = "invokeSuspend", n = {DownloadInfo.spKey_Config, "beforeRequestTime"}, s = {"L$0", "J$0"})
/* loaded from: classes33.dex */
public final class Middlewares$createApiReport$2 extends SuspendLambda implements Function3<RequestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, Continuation<? super Response>, Object> {
    public final /* synthetic */ String $business;
    public final /* synthetic */ Function1<Response, Boolean> $isFailed;
    public final /* synthetic */ Keport $keport;
    public final /* synthetic */ VLog $log;
    public final /* synthetic */ Ref.IntRef $requestId;
    public final /* synthetic */ float $sample;
    public long J$0;
    public /* synthetic */ RequestConfig L$0;
    public /* synthetic */ Function2 L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Middlewares$createApiReport$2(Ref.IntRef intRef, Function1<? super Response, Boolean> function1, VLog vLog, Keport keport, String str, float f16, Continuation<? super Middlewares$createApiReport$2> continuation) {
        super(3, continuation);
        this.$requestId = intRef;
        this.$isFailed = function1;
        this.$log = vLog;
        this.$keport = keport;
        this.$business = str;
        this.$sample = f16;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(RequestConfig requestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object> function2, Continuation<? super Response> continuation) {
        Middlewares$createApiReport$2 middlewares$createApiReport$2 = new Middlewares$createApiReport$2(this.$requestId, this.$isFailed, this.$log, this.$keport, this.$business, this.$sample, continuation);
        middlewares$createApiReport$2.L$0 = requestConfig;
        middlewares$createApiReport$2.L$1 = function2;
        return middlewares$createApiReport$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        RequestConfig requestConfig;
        long currentTimeStamp;
        Object invoke;
        String str;
        String str2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            requestConfig = this.L$0;
            Function2 function2 = this.L$1;
            currentTimeStamp = ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp();
            this.L$0 = requestConfig;
            this.J$0 = currentTimeStamp;
            this.label = 1;
            invoke = function2.invoke(requestConfig, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            long j3 = this.J$0;
            requestConfig = this.L$0;
            ResultKt.throwOnFailure(obj);
            currentTimeStamp = j3;
            invoke = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Response response = (Response) invoke;
        int currentTimeStamp2 = (int) (((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp() - currentTimeStamp);
        int i16 = response.status;
        String q16 = response.data.q("code", "0");
        this.$requestId.element++;
        if (this.$isFailed.invoke(response).booleanValue()) {
            String remove = requestConfig.cookies.remove("p_skey");
            VLog vLog = this.$log;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("request failed\n[");
            m3.append(this.$requestId.element);
            m3.append("] request:\n");
            m3.append(requestConfig);
            vLog.log$enumunboxing$(m3.toString(), 3, true);
            VLog vLog2 = this.$log;
            StringBuilder m16 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('[');
            m16.append(this.$requestId.element);
            m16.append("]\ncostTime: ");
            m16.append(currentTimeStamp2);
            m16.append("\nresponse:\n");
            m16.append(response);
            vLog2.log$enumunboxing$(m16.toString(), 3, true);
            if (remove != null) {
                requestConfig.cookies.put("p_skey", remove);
            }
            Keport keport = this.$keport;
            String str3 = requestConfig.baseURL;
            String str4 = requestConfig.url;
            if ((str3.length() > 0) && !new Regex("^([a-z][a-z\\d+\\-.]*:)?//", RegexOption.IGNORE_CASE).containsMatchIn(str4)) {
                if (str4.length() > 0) {
                    str4 = new Regex("/?/$").replace(str3, "") + '/' + new Regex("^/+").replace(str4, "");
                } else {
                    str2 = str3;
                    keport.apiAggregator.add(new ApiParam(str2, currentTimeStamp2, String.valueOf(i16), q16, this.$business));
                }
            }
            str2 = str4;
            keport.apiAggregator.add(new ApiParam(str2, currentTimeStamp2, String.valueOf(i16), q16, this.$business));
        } else if (Random.INSTANCE.nextFloat() < this.$sample) {
            Keport keport2 = this.$keport;
            String str5 = requestConfig.baseURL;
            String str6 = requestConfig.url;
            if ((str5.length() > 0) && !new Regex("^([a-z][a-z\\d+\\-.]*:)?//", RegexOption.IGNORE_CASE).containsMatchIn(str6)) {
                if (str6.length() > 0) {
                    str6 = new Regex("/?/$").replace(str5, "") + '/' + new Regex("^/+").replace(str6, "");
                } else {
                    str = str5;
                    keport2.apiAggregator.add(new ApiParam(str, currentTimeStamp2, String.valueOf(i16), q16, this.$business));
                }
            }
            str = str6;
            keport2.apiAggregator.add(new ApiParam(str, currentTimeStamp2, String.valueOf(i16), q16, this.$business));
        }
        return response;
    }
}
