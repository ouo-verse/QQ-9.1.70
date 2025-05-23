package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import androidx.fragment.app.FragmentManager;
import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.ECProductDetailDataParserType;
import com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailInfo;
import com.tencent.ecommerce.biz.detail.utils.d;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import com.tencent.ecommerce.biz.util.k;
import com.tencent.ecommerce.biz.util.l;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\n\u00a2\u0006\u0004\b \u0010!J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J3\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailDistributorViewModel;", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailBaseViewModel;", "Lorg/json/JSONObject;", "data", "requestParams", "", "Lcom/tencent/ecommerce/base/ui/b;", "r2", "Lorg/json/JSONArray;", "q2", "", "spuId", "", ICustomDataEditor.STRING_PARAM_2, "service", "method", "requestExtraParams", "v2", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t2", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "u2", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "V", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "distributorRepo", "bizType", "", "isSelect", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "adClickId", "<init>", "(Ljava/lang/String;ZLandroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductDetailDistributorViewModel extends ECShopProductDetailBaseViewModel {

    /* renamed from: V, reason: from kotlin metadata */
    private final IECShopProductDetailRepository distributorRepo;

    public ECShopProductDetailDistributorViewModel(String str, boolean z16, FragmentManager fragmentManager, String str2) {
        super(str, z16, fragmentManager, str2);
        this.distributorRepo = com.tencent.ecommerce.biz.detail.repo.shop.a.f102322a.getShopProductDetailRepository();
    }

    private final JSONArray q2(JSONObject data) {
        String optString;
        JSONObject optJSONObject = data.optJSONObject("product");
        String str = "";
        if (optJSONObject != null && (optString = optJSONObject.optString("title", "")) != null) {
            str = optString;
        }
        JSONArray optJSONArray = data.optJSONArray("labels");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        l h16 = new k(null, 1, null).h(optJSONArray);
        h16.e(str, 15, "qecommerce_skin_color_text_primary", 2);
        return h16.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ECBasePtsViewData> r2(JSONObject data, JSONObject requestParams) {
        IECPTSProcessor a16 = com.tencent.ecommerce.biz.detail.dataprocessor.processor.b.f102022b.a(ECProductDetailDataParserType.ECProductDetailDataBizTypeShopDistributor);
        if (data != null) {
            data.put("nodes", q2(data));
        }
        if (data != null) {
            data.put("price_desc", new JSONObject("{\"nodes\":[{\"name\":\"div\",\"children\":[{\"type\":\"text\",\"text\":\"\u6b64\u8bf4\u660e\u4ec5\u5f53\u51fa\u73b0\u4ef7\u683c\u6bd4\u8f83\u65f6\u6709\u6548\uff0c\u5177\u4f53\u8bf7\u53c2\u89c1\",\"attrs\":{\"style\":\"color:#999999;font-size:24rpx;-webkit-line-clamp:3;\"}},{\"name\":\"a\",\"attrs\":{\"href\":\"https:\\/\\/docs.qq.com\\/doc\\/p\\/0c3ff492a9c5e12022e7bc05bc1f6bba12f57b1e?dver=3.0.0\",\"style\":\"color:#40A0FF;font-size:24rpx;display:-webkit-box;overflow:hidden;-webkit-box-orient:vertical;\"},\"children\":[{\"type\":\"text\",\"text\":\"\u300aQQ\u5c0f\u5e97\u5546\u54c1\u4ef7\u683c\u7ba1\u7406\u89c4\u8303\u300b\"},{\"type\":\"text\",\"text\":\"\u3002\u82e5\u5546\u5bb6\u5355\u72ec\u5bf9\u5212\u7ebf\u4ef7\u683c\u8fdb\u884c\u8bf4\u660e\u7684\uff0c\u4ee5\u5546\u5bb6\u7684\u8868\u8ff0\u4e3a\u51c6\u3002\",\"attrs\":{\"style\":\"color:#999999;font-size:24rpx;\"}}]}]}]}"));
        }
        List<ECPageParserParams> processRemoteParserParamsArray = a16.processRemoteParserParamsArray(data, new JSONObject());
        if (processRemoteParserParamsArray == null) {
            processRemoteParserParamsArray = a16.localPageParserParamsArray(new JSONObject());
        }
        List<ECBasePtsViewData> process = a16.process(processRemoteParserParamsArray, data, requestParams);
        return process != null ? process : new ArrayList();
    }

    public void s2(String spuId, JSONObject requestParams) {
        ECShopProductDetailInfo f16 = j2().f(spuId);
        if (f16 != null) {
            List<ECBasePtsViewData> r26 = r2(f16.infoData, requestParams);
            if (!r26.isEmpty()) {
                Z1().postValue(r26);
                d.f102466a.r(getShowPageCostTime(), true, 1);
                cg0.a.b("ECDetailPageViewModel", "[loadProductDetailFromCache] cache successed");
                return;
            }
            return;
        }
        cg0.a.b("ECDetailPageViewModel", "[loadProductDetailFromCache] cache missed");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object t2(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        ECShopProductDetailDistributorViewModel$requestMoreRecommendData$1 eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1;
        Object coroutine_suspended;
        int i3;
        ECShopProductDetailDistributorViewModel eCShopProductDetailDistributorViewModel;
        List<ECBasePtsViewData> e16;
        if (continuation instanceof ECShopProductDetailDistributorViewModel$requestMoreRecommendData$1) {
            eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1 = (ECShopProductDetailDistributorViewModel$requestMoreRecommendData$1) continuation;
            int i16 = eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1.L$0 = this;
                    eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1.L$1 = jSONObject;
                    eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1.label = 1;
                    obj = u2(jSONObject, eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCShopProductDetailDistributorViewModel = this;
                } else if (i3 == 1) {
                    jSONObject = (JSONObject) eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1.L$1;
                    eCShopProductDetailDistributorViewModel = (ECShopProductDetailDistributorViewModel) eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e16 = eCShopProductDetailDistributorViewModel.j2().e((JSONObject) obj, jSONObject);
                if (!e16.isEmpty()) {
                    eCShopProductDetailDistributorViewModel.Z1().postValue(e16);
                }
                return Unit.INSTANCE;
            }
        }
        eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1 = new ECShopProductDetailDistributorViewModel$requestMoreRecommendData$1(this, continuation);
        Object obj2 = eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailDistributorViewModel$requestMoreRecommendData$1.label;
        if (i3 != 0) {
        }
        e16 = eCShopProductDetailDistributorViewModel.j2().e((JSONObject) obj2, jSONObject);
        if (!e16.isEmpty()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object u2(JSONObject jSONObject, Continuation<? super JSONObject> continuation) {
        if (this.isSelect) {
            return new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
        jSONObject2.put("recom_scene", ECShopRecommendScene.QQ_SHOP_PRODUCT_DETAIL.ordinal());
        jSONObject2.put("scene", ECShopRecommendScene.QQ_SHOP_WEB_PRODUCT_DETAIL.ordinal());
        return j2().i(jSONObject2, continuation);
    }

    public Object v2(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        c2().postValue(Boxing.boxInt(3));
        Object withContext = BuildersKt.withContext(getDefaultDispatcher(), new ECShopProductDetailDistributorViewModel$requestPtsDataWithModel$2(this, str, str2, jSONObject, jSONObject2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }
}
