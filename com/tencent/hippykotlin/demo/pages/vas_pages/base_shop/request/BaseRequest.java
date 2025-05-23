package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQBrowser;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.KRequest;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Method;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Middlewares;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Middlewares$createApiReport$2;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.HttpRequstHelper;
import com.tencent.hippykotlin.demo.pages.vas_base.report.keport.Keport;
import com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.raft.codegenmeta.utils.Constants;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.LinkedHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class BaseRequest {
    public static final Companion Companion = new Companion();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
        /* JADX WARN: Removed duplicated region for block: B:12:0x0187 A[PHI: r0
  0x0187: PHI (r0v15 java.lang.Object) = (r0v14 java.lang.Object), (r0v1 java.lang.Object) binds: [B:18:0x0184, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE], RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0186 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00a8 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object buildBaseRequest(VasBasePage vasBasePage, String str, e eVar, String str2, Continuation<? super Response> continuation) {
            BaseRequest$Companion$buildBaseRequest$1 baseRequest$Companion$buildBaseRequest$1;
            Object coroutine_suspended;
            int i3;
            e eVar2;
            String str3;
            String str4;
            String str5;
            Object userAgent;
            String str6;
            Object obj;
            String str7;
            String str8;
            String str9;
            if (continuation instanceof BaseRequest$Companion$buildBaseRequest$1) {
                baseRequest$Companion$buildBaseRequest$1 = (BaseRequest$Companion$buildBaseRequest$1) continuation;
                int i16 = baseRequest$Companion$buildBaseRequest$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    baseRequest$Companion$buildBaseRequest$1.label = i16 - Integer.MIN_VALUE;
                    Object obj2 = baseRequest$Companion$buildBaseRequest$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = baseRequest$Companion$buildBaseRequest$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        String uin = vasBasePage.platformApi.getQqModule().getUin();
                        HttpRequstHelper httpRequstHelper = HttpRequstHelper.INSTANCE;
                        baseRequest$Companion$buildBaseRequest$1.L$0 = str;
                        eVar2 = eVar;
                        baseRequest$Companion$buildBaseRequest$1.L$1 = eVar2;
                        baseRequest$Companion$buildBaseRequest$1.L$2 = str2;
                        baseRequest$Companion$buildBaseRequest$1.L$3 = uin;
                        baseRequest$Companion$buildBaseRequest$1.label = 1;
                        Object psk = httpRequstHelper.getPSK("vip.qq.com", baseRequest$Companion$buildBaseRequest$1);
                        if (psk == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str3 = uin;
                        obj2 = psk;
                        str4 = str;
                        str5 = str2;
                    } else {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    ResultKt.throwOnFailure(obj2);
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            str8 = baseRequest$Companion$buildBaseRequest$1.L$4;
                            str9 = baseRequest$Companion$buildBaseRequest$1.L$3;
                            String str10 = baseRequest$Companion$buildBaseRequest$1.L$2;
                            Object obj3 = baseRequest$Companion$buildBaseRequest$1.L$1;
                            String str11 = baseRequest$Companion$buildBaseRequest$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            str6 = str10;
                            obj = obj3;
                            str7 = str11;
                            KRequest use = new KRequest(null, 1, null).use(Middlewares.qqLogin).use(new Middlewares$createApiReport$2(new Ref.IntRef(), new Function1<Response, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.krequest.Middlewares$createApiReport$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(Response response) {
                                    Response response2 = response;
                                    return Boolean.valueOf(response2.status >= 400 || !Intrinsics.areEqual(response2.data.q("code", "0"), "0"));
                                }
                            }, new VLog("Api Request"), new Keport("https://h5.qzone.qq.com/v2/vip/keport"), str6, 1.0f, null));
                            e eVar3 = new e();
                            eVar3.v("req", obj);
                            e eVar4 = new e();
                            e eVar5 = new e();
                            eVar5.z("businessType", HippyQQConstants.ModuleName.QQ_PERSONALITY);
                            Unit unit = Unit.INSTANCE;
                            eVar4.z("context", eVar5);
                            e eVar6 = new e();
                            eVar6.z(Constants.Service.CONFIG_NAME_SPACE, "Production");
                            eVar6.z(MosaicConstants$JsProperty.PROP_ENV, "formal");
                            eVar4.z("naming", eVar6);
                            eVar3.v("options", eVar4);
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.put("uin", str9);
                            linkedHashMap.put("p_skey", str8);
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            linkedHashMap2.put("User-Agent", (String) obj2);
                            linkedHashMap2.put("Content-Type", "application/json");
                            RequestConfig requestConfig = new RequestConfig(null, str7, linkedHashMap2, null, eVar3, 0, linkedHashMap, QCircleReportHelper.SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_QZONE_PAGE);
                            baseRequest$Companion$buildBaseRequest$1.L$0 = null;
                            baseRequest$Companion$buildBaseRequest$1.L$1 = null;
                            baseRequest$Companion$buildBaseRequest$1.L$2 = null;
                            baseRequest$Companion$buildBaseRequest$1.L$3 = null;
                            baseRequest$Companion$buildBaseRequest$1.L$4 = null;
                            baseRequest$Companion$buildBaseRequest$1.label = 3;
                            requestConfig.method = Method.POST;
                            obj2 = use.request(requestConfig, baseRequest$Companion$buildBaseRequest$1);
                            return obj2 != coroutine_suspended ? coroutine_suspended : obj2;
                        }
                        str3 = baseRequest$Companion$buildBaseRequest$1.L$3;
                        str5 = baseRequest$Companion$buildBaseRequest$1.L$2;
                        eVar2 = baseRequest$Companion$buildBaseRequest$1.L$1;
                        str4 = baseRequest$Companion$buildBaseRequest$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    String str12 = (String) obj2;
                    QQBrowser qQBrowser = QQBrowser.INSTANCE;
                    baseRequest$Companion$buildBaseRequest$1.L$0 = str4;
                    baseRequest$Companion$buildBaseRequest$1.L$1 = eVar2;
                    baseRequest$Companion$buildBaseRequest$1.L$2 = str5;
                    baseRequest$Companion$buildBaseRequest$1.L$3 = str3;
                    baseRequest$Companion$buildBaseRequest$1.L$4 = str12;
                    baseRequest$Companion$buildBaseRequest$1.label = 2;
                    userAgent = qQBrowser.getUserAgent(baseRequest$Companion$buildBaseRequest$1);
                    if (userAgent != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str6 = str5;
                    obj = eVar2;
                    str7 = str4;
                    String str13 = str3;
                    str8 = str12;
                    obj2 = userAgent;
                    str9 = str13;
                    KRequest use2 = new KRequest(null, 1, null).use(Middlewares.qqLogin).use(new Middlewares$createApiReport$2(new Ref.IntRef(), new Function1<Response, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.krequest.Middlewares$createApiReport$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(Response response) {
                            Response response2 = response;
                            return Boolean.valueOf(response2.status >= 400 || !Intrinsics.areEqual(response2.data.q("code", "0"), "0"));
                        }
                    }, new VLog("Api Request"), new Keport("https://h5.qzone.qq.com/v2/vip/keport"), str6, 1.0f, null));
                    e eVar32 = new e();
                    eVar32.v("req", obj);
                    e eVar42 = new e();
                    e eVar52 = new e();
                    eVar52.z("businessType", HippyQQConstants.ModuleName.QQ_PERSONALITY);
                    Unit unit2 = Unit.INSTANCE;
                    eVar42.z("context", eVar52);
                    e eVar62 = new e();
                    eVar62.z(Constants.Service.CONFIG_NAME_SPACE, "Production");
                    eVar62.z(MosaicConstants$JsProperty.PROP_ENV, "formal");
                    eVar42.z("naming", eVar62);
                    eVar32.v("options", eVar42);
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    linkedHashMap3.put("uin", str9);
                    linkedHashMap3.put("p_skey", str8);
                    LinkedHashMap linkedHashMap22 = new LinkedHashMap();
                    linkedHashMap22.put("User-Agent", (String) obj2);
                    linkedHashMap22.put("Content-Type", "application/json");
                    RequestConfig requestConfig2 = new RequestConfig(null, str7, linkedHashMap22, null, eVar32, 0, linkedHashMap3, QCircleReportHelper.SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_QZONE_PAGE);
                    baseRequest$Companion$buildBaseRequest$1.L$0 = null;
                    baseRequest$Companion$buildBaseRequest$1.L$1 = null;
                    baseRequest$Companion$buildBaseRequest$1.L$2 = null;
                    baseRequest$Companion$buildBaseRequest$1.L$3 = null;
                    baseRequest$Companion$buildBaseRequest$1.L$4 = null;
                    baseRequest$Companion$buildBaseRequest$1.label = 3;
                    requestConfig2.method = Method.POST;
                    obj2 = use2.request(requestConfig2, baseRequest$Companion$buildBaseRequest$1);
                    if (obj2 != coroutine_suspended) {
                    }
                }
            }
            baseRequest$Companion$buildBaseRequest$1 = new BaseRequest$Companion$buildBaseRequest$1(this, continuation);
            Object obj22 = baseRequest$Companion$buildBaseRequest$1.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = baseRequest$Companion$buildBaseRequest$1.label;
            if (i3 != 0) {
            }
            String str122 = (String) obj22;
            QQBrowser qQBrowser2 = QQBrowser.INSTANCE;
            baseRequest$Companion$buildBaseRequest$1.L$0 = str4;
            baseRequest$Companion$buildBaseRequest$1.L$1 = eVar2;
            baseRequest$Companion$buildBaseRequest$1.L$2 = str5;
            baseRequest$Companion$buildBaseRequest$1.L$3 = str3;
            baseRequest$Companion$buildBaseRequest$1.L$4 = str122;
            baseRequest$Companion$buildBaseRequest$1.label = 2;
            userAgent = qQBrowser2.getUserAgent(baseRequest$Companion$buildBaseRequest$1);
            if (userAgent != coroutine_suspended) {
            }
        }
    }
}
