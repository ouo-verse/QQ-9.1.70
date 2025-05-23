package com.tencent.ecommerce.biz.detail.repo.saas;

import android.text.TextUtils;
import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.ECProductDetailDataParserType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailCustomRelatedRepo;", "", "", "service", "method", "Lorg/json/JSONObject;", "requestParams", "c", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mediaId", "b", "data", "", "Lcom/tencent/ecommerce/base/ui/b;", "a", "Ljava/lang/String;", "recommendReqCookie", "", "Z", "isRecommendDataEnd", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDetailCustomRelatedRepo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String recommendReqCookie = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isRecommendDataEnd;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005d, code lost:
    
        r11 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ECBasePtsViewData> a(JSONObject data, JSONObject requestParams) {
        List<ECBasePtsViewData> arrayList;
        IECPTSProcessor a16 = com.tencent.ecommerce.biz.detail.dataprocessor.processor.b.f102022b.a(ECProductDetailDataParserType.ECProductDetailDataCustomRelated);
        JSONArray optJSONArray = data.optJSONArray("products");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            data.put("show_recomment_none", 1);
        }
        boolean optBoolean = data.optBoolean("is_end", false);
        int optInt = requestParams.optInt("source", 0);
        boolean optBoolean2 = requestParams.optBoolean("is_first_screen_recommend", true);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("EC_IS_CUSTOM", true);
        jSONObject.put("show_recomment_none", data.optInt("show_recomment_none"));
        jSONObject.put("recommend_data_scene", optInt);
        List<ECPageParserParams> processRemoteParserParamsArray = a16.processRemoteParserParamsArray(data, jSONObject);
        if (processRemoteParserParamsArray == null) {
            processRemoteParserParamsArray = a16.localPageParserParamsArray(jSONObject);
        }
        List<ECBasePtsViewData> process = a16.process(processRemoteParserParamsArray, data, requestParams);
        if (process == null || arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (requestParams.optInt("source", 0) == 3) {
            if (!optBoolean2 && optBoolean && (arrayList.size() == 0 || (!Intrinsics.areEqual(arrayList.get(arrayList.size() - 1).getPageName(), "qshop_detail_recommen_none")))) {
                arrayList.add(new ECBasePtsViewData("", "qshop_detail_footer_cell", "", null));
            }
        } else if (optBoolean && (arrayList.size() == 0 || (!Intrinsics.areEqual(arrayList.get(arrayList.size() - 1).getPageName(), "qshop_detail_recommen_none")))) {
            arrayList.add(new ECBasePtsViewData("", "qshop_detail_footer_cell", "", null));
        }
        return arrayList;
    }

    public final String b(String mediaId) {
        if (TextUtils.isEmpty(mediaId)) {
            return "";
        }
        return "ECDetailCustomRelatedRepo" + mediaId;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(String str, String str2, JSONObject jSONObject, Continuation<? super JSONObject> continuation) {
        ECDetailCustomRelatedRepo$requestCustomRelatedData$1 eCDetailCustomRelatedRepo$requestCustomRelatedData$1;
        Object coroutine_suspended;
        int i3;
        ECDetailCustomRelatedRepo eCDetailCustomRelatedRepo;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECDetailCustomRelatedRepo$requestCustomRelatedData$1) {
            eCDetailCustomRelatedRepo$requestCustomRelatedData$1 = (ECDetailCustomRelatedRepo$requestCustomRelatedData$1) continuation;
            int i16 = eCDetailCustomRelatedRepo$requestCustomRelatedData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCDetailCustomRelatedRepo$requestCustomRelatedData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCDetailCustomRelatedRepo$requestCustomRelatedData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCDetailCustomRelatedRepo$requestCustomRelatedData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.isRecommendDataEnd) {
                        cg0.a.b("ECDetailCustomRelatedRepo", "[requestCustomRelatedData] data is end, cookie = " + this.recommendReqCookie);
                        return new JSONObject();
                    }
                    jSONObject.put("cookie", this.recommendReqCookie);
                    com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                    eCDetailCustomRelatedRepo$requestCustomRelatedData$1.L$0 = this;
                    eCDetailCustomRelatedRepo$requestCustomRelatedData$1.L$1 = str;
                    eCDetailCustomRelatedRepo$requestCustomRelatedData$1.L$2 = str2;
                    eCDetailCustomRelatedRepo$requestCustomRelatedData$1.L$3 = jSONObject;
                    eCDetailCustomRelatedRepo$requestCustomRelatedData$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e(str, str2, bVar, jSONObject, eCDetailCustomRelatedRepo$requestCustomRelatedData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCDetailCustomRelatedRepo = this;
                } else if (i3 == 1) {
                    jSONObject = (JSONObject) eCDetailCustomRelatedRepo$requestCustomRelatedData$1.L$3;
                    str2 = (String) eCDetailCustomRelatedRepo$requestCustomRelatedData$1.L$2;
                    str = (String) eCDetailCustomRelatedRepo$requestCustomRelatedData$1.L$1;
                    eCDetailCustomRelatedRepo = (ECDetailCustomRelatedRepo) eCDetailCustomRelatedRepo$requestCustomRelatedData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    JSONObject jSONObject2 = (JSONObject) eCNetworkResponse.b();
                    if (jSONObject2 == null) {
                        return null;
                    }
                    cg0.a.b("ECDetailCustomRelatedRepo", "[requestCustomRelatedData] data = " + jSONObject2);
                    if (Intrinsics.areEqual(eCDetailCustomRelatedRepo.recommendReqCookie, "")) {
                        String jSONObject3 = jSONObject2.toString();
                        String optString = jSONObject.optString("media_id");
                        if (!TextUtils.isEmpty(jSONObject3) && !TextUtils.isEmpty(optString)) {
                            ECLocalConfig.f100650f.setString(eCDetailCustomRelatedRepo.b(optString), jSONObject3, Boxing.boxBoolean(true));
                        }
                    }
                    eCDetailCustomRelatedRepo.isRecommendDataEnd = jSONObject2.optBoolean("is_end", false);
                    eCDetailCustomRelatedRepo.recommendReqCookie = jSONObject2.optString("cookie", "");
                    return jSONObject2;
                }
                cg0.a.a("ECDetailCustomRelatedRepo", "requestPtsDataWithModel$\\requestWithCmd$\\onError", "pre pts failure, because req error. service: " + str + TokenParser.SP + "method: " + str2 + "\uff0ccode: " + eCNetworkResponse.getCode());
                return null;
            }
        }
        eCDetailCustomRelatedRepo$requestCustomRelatedData$1 = new ECDetailCustomRelatedRepo$requestCustomRelatedData$1(this, continuation);
        Object obj2 = eCDetailCustomRelatedRepo$requestCustomRelatedData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCDetailCustomRelatedRepo$requestCustomRelatedData$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }
}
