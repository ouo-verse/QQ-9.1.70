package com.tencent.ecommerce.biz.detail.repo.saas;

import bh0.ECPageParserParams;
import ck0.Category;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.ECProductDetailDataParserType;
import com.tencent.ecommerce.biz.detail.utils.e;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J;\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailHostRelatedRepo;", "", "Lorg/json/JSONObject;", "data", "requestParams", WadlProxyConsts.EXT_JSON, "", "Lcom/tencent/ecommerce/base/ui/b;", "a", "", "service", "method", "categoryId", "", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDetailHostRelatedRepo {
    private final List<ECBasePtsViewData> a(JSONObject data, JSONObject requestParams, JSONObject extJson) {
        List<ECBasePtsViewData> mutableList;
        IECPTSProcessor a16 = com.tencent.ecommerce.biz.detail.dataprocessor.processor.b.f102022b.a(ECProductDetailDataParserType.ECProductDetailDataHostRelated);
        JSONArray optJSONArray = data.optJSONArray("product_list");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            data.put("show_recomment_none", 1);
        }
        extJson.put("show_recomment_none", data.optInt("show_recomment_none"));
        List<ECPageParserParams> processRemoteParserParamsArray = a16.processRemoteParserParamsArray(data, extJson);
        if (processRemoteParserParamsArray == null) {
            processRemoteParserParamsArray = a16.localPageParserParamsArray(extJson);
        }
        List<ECBasePtsViewData> process = a16.process(processRemoteParserParamsArray, data, requestParams);
        if (process == null) {
            return null;
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) process);
        return mutableList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object b(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Continuation<? super List<ECBasePtsViewData>> continuation) {
        ECDetailHostRelatedRepo$requestDataWithModel$1 eCDetailHostRelatedRepo$requestDataWithModel$1;
        Object coroutine_suspended;
        int i3;
        ECDetailHostRelatedRepo eCDetailHostRelatedRepo;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECDetailHostRelatedRepo$requestDataWithModel$1) {
            eCDetailHostRelatedRepo$requestDataWithModel$1 = (ECDetailHostRelatedRepo$requestDataWithModel$1) continuation;
            int i16 = eCDetailHostRelatedRepo$requestDataWithModel$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCDetailHostRelatedRepo$requestDataWithModel$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCDetailHostRelatedRepo$requestDataWithModel$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCDetailHostRelatedRepo$requestDataWithModel$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                    eCDetailHostRelatedRepo$requestDataWithModel$1.L$0 = this;
                    eCDetailHostRelatedRepo$requestDataWithModel$1.L$1 = str;
                    eCDetailHostRelatedRepo$requestDataWithModel$1.L$2 = str2;
                    eCDetailHostRelatedRepo$requestDataWithModel$1.L$3 = jSONObject;
                    eCDetailHostRelatedRepo$requestDataWithModel$1.L$4 = jSONObject2;
                    eCDetailHostRelatedRepo$requestDataWithModel$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e(str, str2, bVar, jSONObject, eCDetailHostRelatedRepo$requestDataWithModel$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCDetailHostRelatedRepo = this;
                } else if (i3 == 1) {
                    jSONObject2 = (JSONObject) eCDetailHostRelatedRepo$requestDataWithModel$1.L$4;
                    jSONObject = (JSONObject) eCDetailHostRelatedRepo$requestDataWithModel$1.L$3;
                    str2 = (String) eCDetailHostRelatedRepo$requestDataWithModel$1.L$2;
                    str = (String) eCDetailHostRelatedRepo$requestDataWithModel$1.L$1;
                    eCDetailHostRelatedRepo = (ECDetailHostRelatedRepo) eCDetailHostRelatedRepo$requestDataWithModel$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    JSONObject jSONObject3 = (JSONObject) eCNetworkResponse.b();
                    if (jSONObject3 == null) {
                        return null;
                    }
                    cg0.a.b("ECDetailHostRelatedRepo", "[requestDataWithModel] data = " + jSONObject3);
                    List<ECBasePtsViewData> a16 = eCDetailHostRelatedRepo.a(jSONObject3, jSONObject, jSONObject2);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[requestDataWithModel] pre pts success, service: ");
                    sb5.append(str);
                    sb5.append(TokenParser.SP);
                    sb5.append("method: ");
                    sb5.append(str2);
                    sb5.append(", count: ");
                    sb5.append(a16 != null ? Boxing.boxInt(a16.size()) : null);
                    cg0.a.b("ECDetailHostRelatedRepo", sb5.toString());
                    return a16;
                }
                cg0.a.a("ECDetailHostRelatedRepo", "requestPtsDataWithModel$\\requestWithCmd$\\onError", "pre pts failure, because req error. service: " + str + TokenParser.SP + "method: " + str2);
                return null;
            }
        }
        eCDetailHostRelatedRepo$requestDataWithModel$1 = new ECDetailHostRelatedRepo$requestDataWithModel$1(this, continuation);
        Object obj2 = eCDetailHostRelatedRepo$requestDataWithModel$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCDetailHostRelatedRepo$requestDataWithModel$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    public final Object c(String str, String str2, String str3, JSONObject jSONObject, Continuation<? super List<ECBasePtsViewData>> continuation) {
        Integer intOrNull;
        Long longOrNull;
        String optString = jSONObject.optString("EC_GOODS_TYPE", "");
        if (!e.f102467a.e(optString)) {
            long j3 = 0;
            try {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str3);
                if (longOrNull != null) {
                    j3 = longOrNull.longValue();
                }
            } catch (NumberFormatException e16) {
                cg0.a.a("ECDetailHostRelatedRepo", "[requestHostRelatedData]", e16.toString());
            }
            long j16 = j3;
            String optString2 = jSONObject.optString("EC_OTHER_CATEGORY");
            String str4 = optString2 != null ? optString2 : "";
            int i3 = 0;
            try {
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(optString);
                if (intOrNull != null) {
                    i3 = intOrNull.intValue();
                }
            } catch (NumberFormatException e17) {
                cg0.a.a("ECDetailHostRelatedRepo", "[requestHostRelatedData]", e17.toString());
            }
            return b(str, str2, new pi0.a(null, new Category(j16, str4, i3, false, 8, null), null, null, null, null, 61, null).a(), jSONObject, continuation);
        }
        return new ArrayList();
    }
}
