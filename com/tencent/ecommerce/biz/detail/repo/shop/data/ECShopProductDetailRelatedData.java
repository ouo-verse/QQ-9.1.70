package com.tencent.ecommerce.biz.detail.repo.shop.data;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.ECProductDetailDataParserType;
import com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001b\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductDetailRelatedData;", "", "Lorg/json/JSONObject;", "product", "Lorg/json/JSONArray;", "a", "requestParams", "c", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "", "Lcom/tencent/ecommerce/base/ui/b;", "b", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "repository", "", "Ljava/lang/String;", "recommendCookie", "", "Z", "isRecommendDataEnd", "d", "isNeedFooterCell", "<init>", "()V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductDetailRelatedData {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isRecommendDataEnd;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IECShopProductDetailRepository repository = com.tencent.ecommerce.biz.detail.repo.shop.a.f102322a.getShopProductDetailRepository();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String recommendCookie = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedFooterCell = true;

    private final JSONArray a(JSONObject product) {
        String optString = product.optString("title", "");
        String str = optString != null ? optString : "";
        JSONArray optJSONArray = product.optJSONArray("labels");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        com.tencent.ecommerce.biz.util.l h16 = new com.tencent.ecommerce.biz.util.k(null, 1, null).h(optJSONArray);
        h16.e(str, 14, "qecommerce_skin_color_text_primary", 2);
        return h16.g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00cd, code lost:
    
        r13 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ECBasePtsViewData> b(JSONObject data, JSONObject requestParams) {
        List<ECBasePtsViewData> arrayList;
        if (data.optBoolean("is_hidden", false)) {
            cg0.a.a("ECDetailCustomRelatedRepo", "getRelatedPtsComposers", "recommend is_hidden = true");
            return new ArrayList();
        }
        JSONArray optJSONArray = data.optJSONArray("recom_card");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                optJSONObject.put("nodes", a(optJSONObject));
            }
        } else if (requestParams.optBoolean("is_first_screen_recommend", true)) {
            cg0.a.a("ECDetailCustomRelatedRepo", "getRelatedPtsComposers", "recommend cards is null");
            data.put("show_recomment_none", 1);
        }
        data.put("show_recommen_title", 1);
        String optString = requestParams.optString("scene", "0");
        int i16 = ECShopRecommendScene.UNKNOWN_TYPE.value;
        try {
            i16 = Integer.parseInt(optString);
        } catch (Exception e16) {
            cg0.a.a("ECShopProductDetailRelatedData", "getRelatedPtsComposers", "[getRelatedPtsComposers] parse scene value error, sceneString = " + optString + ", error = " + e16);
        }
        IECPTSProcessor a16 = com.tencent.ecommerce.biz.detail.dataprocessor.processor.b.f102022b.a(ECProductDetailDataParserType.ECProductDetailDataBizTypeShopRecommend);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("EC_IS_CUSTOM", true);
        jSONObject.put("show_recomment_none", data.optInt("show_recomment_none"));
        jSONObject.put("is_first_screen_recommend", requestParams.optBoolean("is_first_screen_recommend", true));
        jSONObject.put("recommend_data_request_scene", i16);
        List<ECPageParserParams> processRemoteParserParamsArray = a16.processRemoteParserParamsArray(data, jSONObject);
        if (processRemoteParserParamsArray == null) {
            processRemoteParserParamsArray = a16.localPageParserParamsArray(jSONObject);
        }
        List<ECBasePtsViewData> process = a16.process(processRemoteParserParamsArray, data, requestParams);
        if (process == null || arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (data.optBoolean("is_end") && this.isNeedFooterCell && (arrayList.size() == 0 || (!Intrinsics.areEqual(arrayList.get(arrayList.size() - 1).getPageName(), "qshop_detail_recommen_none")))) {
            arrayList.add(new ECBasePtsViewData("", "qshop_detail_footer_cell", "", null));
            this.isNeedFooterCell = false;
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(JSONObject jSONObject, Continuation<? super JSONObject> continuation) {
        ECShopProductDetailRelatedData$requestCustomRelatedData$1 eCShopProductDetailRelatedData$requestCustomRelatedData$1;
        Object coroutine_suspended;
        int i3;
        ECShopProductDetailRelatedData eCShopProductDetailRelatedData;
        ECShopProductDetailRelatedInfo eCShopProductDetailRelatedInfo;
        if (continuation instanceof ECShopProductDetailRelatedData$requestCustomRelatedData$1) {
            eCShopProductDetailRelatedData$requestCustomRelatedData$1 = (ECShopProductDetailRelatedData$requestCustomRelatedData$1) continuation;
            int i16 = eCShopProductDetailRelatedData$requestCustomRelatedData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailRelatedData$requestCustomRelatedData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailRelatedData$requestCustomRelatedData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailRelatedData$requestCustomRelatedData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.isRecommendDataEnd) {
                        cg0.a.b("ECShopProductDetailRelatedData", "requestCustomRelatedData isRecommendDataEnd is true");
                        return new JSONObject();
                    }
                    jSONObject.put("cookie", this.recommendCookie);
                    IECShopProductDetailRepository iECShopProductDetailRepository = this.repository;
                    eCShopProductDetailRelatedData$requestCustomRelatedData$1.L$0 = this;
                    eCShopProductDetailRelatedData$requestCustomRelatedData$1.label = 1;
                    obj = iECShopProductDetailRepository.getShopProductDetailRelatedData(jSONObject, eCShopProductDetailRelatedData$requestCustomRelatedData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCShopProductDetailRelatedData = this;
                } else if (i3 == 1) {
                    eCShopProductDetailRelatedData = (ECShopProductDetailRelatedData) eCShopProductDetailRelatedData$requestCustomRelatedData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCShopProductDetailRelatedInfo = (ECShopProductDetailRelatedInfo) obj;
                if (eCShopProductDetailRelatedInfo == null) {
                    JSONObject jSONObject2 = eCShopProductDetailRelatedInfo.infoData;
                    cg0.a.b("ECShopProductDetailRelatedData", "[requestCustomRelatedData] data = " + jSONObject2);
                    eCShopProductDetailRelatedData.recommendCookie = jSONObject2.optString("cookie");
                    eCShopProductDetailRelatedData.isRecommendDataEnd = jSONObject2.optBoolean("is_end");
                    return jSONObject2;
                }
                cg0.a.a("ECShopProductDetailRelatedData", "requestPtsDataWithModel$\\requestWithCmd$\\onError", "pre pts failure, because req error.");
                return new JSONObject();
            }
        }
        eCShopProductDetailRelatedData$requestCustomRelatedData$1 = new ECShopProductDetailRelatedData$requestCustomRelatedData$1(this, continuation);
        Object obj2 = eCShopProductDetailRelatedData$requestCustomRelatedData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailRelatedData$requestCustomRelatedData$1.label;
        if (i3 != 0) {
        }
        eCShopProductDetailRelatedInfo = (ECShopProductDetailRelatedInfo) obj2;
        if (eCShopProductDetailRelatedInfo == null) {
        }
    }
}
