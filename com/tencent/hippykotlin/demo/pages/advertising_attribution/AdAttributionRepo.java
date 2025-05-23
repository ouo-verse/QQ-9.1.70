package com.tencent.hippykotlin.demo.pages.advertising_attribution;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.advertising_attribution.model.AdAttributionAddResult;
import com.tencent.hippykotlin.demo.pages.advertising_attribution.model.AdAttributionReq;
import com.tencent.hippykotlin.demo.pages.advertising_attribution.model.AdAttributionRspFactory;
import com.tencent.hippykotlin.demo.pages.base.NetworkResponse;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdAttributionRepo {
    public static final AdAttributionRepo INSTANCE = new AdAttributionRepo();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object addAdAttributionData(e eVar, Continuation<? super AdAttributionAddResult> continuation) {
        AdAttributionRepo$addAdAttributionData$1 adAttributionRepo$addAdAttributionData$1;
        Object coroutine_suspended;
        int i3;
        NetworkResponse networkResponse;
        if (continuation instanceof AdAttributionRepo$addAdAttributionData$1) {
            adAttributionRepo$addAdAttributionData$1 = (AdAttributionRepo$addAdAttributionData$1) continuation;
            int i16 = adAttributionRepo$addAdAttributionData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                adAttributionRepo$addAdAttributionData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = adAttributionRepo$addAdAttributionData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = adAttributionRepo$addAdAttributionData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    NetworkUtils networkUtils = NetworkUtils.INSTANCE;
                    AdAttributionReq adAttributionReq = new AdAttributionReq(eVar);
                    AdAttributionRspFactory adAttributionRspFactory = new AdAttributionRspFactory();
                    adAttributionRepo$addAdAttributionData$1.label = 1;
                    obj = networkUtils.requestWithCmd("trpc.ecom.user_action_report_svr.Reporter/Add", adAttributionReq, adAttributionRspFactory, adAttributionRepo$addAdAttributionData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                networkResponse = (NetworkResponse) obj;
                if (networkResponse.code != 0) {
                    AdAttributionAddResult adAttributionAddResult = (AdAttributionAddResult) networkResponse.data;
                    return adAttributionAddResult == null ? new AdAttributionAddResult(0, networkResponse.message, "\u56de\u5305\u6570\u636e\u4e3a\u7a7a") : adAttributionAddResult;
                }
                Utils utils = Utils.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("AdAttributionRepo addAdAttributionData response error, error code = ");
                m3.append(networkResponse.code);
                m3.append(", error message = ");
                m3.append(networkResponse.message);
                utils.logToNative(m3.toString());
                return new AdAttributionAddResult(networkResponse.code, networkResponse.message, "\u540e\u53f0\u7f51\u7edc\u56de\u5305\u5931\u8d25");
            }
        }
        adAttributionRepo$addAdAttributionData$1 = new AdAttributionRepo$addAdAttributionData$1(this, continuation);
        Object obj2 = adAttributionRepo$addAdAttributionData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = adAttributionRepo$addAdAttributionData$1.label;
        if (i3 != 0) {
        }
        networkResponse = (NetworkResponse) obj2;
        if (networkResponse.code != 0) {
        }
    }
}
