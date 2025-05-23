package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import bh0.ECPageParserParams;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.share.api.ECActionItemData;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.ECProductDetailDataParserType;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailInfo;
import com.tencent.ecommerce.biz.detail.utils.d;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import com.tencent.ecommerce.biz.shophome.repo.ECShareActionInfo;
import com.tencent.ecommerce.biz.util.k;
import com.tencent.ecommerce.biz.util.l;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u00104\u001a\u00020\f\u0012\u0006\u00105\u001a\u00020\n\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u00103\u001a\u00020\f\u0012\u0006\u00108\u001a\u00020\f\u00a2\u0006\u0004\b9\u0010:J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J3\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u001b\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0016J \u0010\u001c\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u001bJ#\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020!0%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\"\u00101\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00103\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010,\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailCustomViewModel;", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailBaseViewModel;", "Lorg/json/JSONObject;", "data", "requestParams", "", "Lcom/tencent/ecommerce/base/ui/b;", "v2", "Lorg/json/JSONArray;", "r2", "", "w2", "", "spuId", "", "x2", "service", "method", "requestExtraParams", "C2", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", NowProxyConstants.AccountInfoKey.A2, "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "y2", "B2", "", "shareAction", "Lcom/tencent/ecommerce/base/share/api/b;", ICustomDataEditor.STRING_PARAM_2, "shopId", "z2", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/ecommerce/biz/shophome/repo/a;", "V", "Landroidx/lifecycle/MutableLiveData;", "shareActionInfo", "Landroidx/lifecycle/LiveData;", "W", "Landroidx/lifecycle/LiveData;", "u2", "()Landroidx/lifecycle/LiveData;", "shareActionInfoLiveData", "X", "Ljava/lang/String;", "t2", "()Ljava/lang/String;", Constants.BASE_IN_PLUGIN_VERSION, "(Ljava/lang/String;)V", "retainId", "Y", "mediaId", "bizType", "isSelect", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "adClickId", "<init>", "(Ljava/lang/String;ZLandroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductDetailCustomViewModel extends ECShopProductDetailBaseViewModel {

    /* renamed from: V, reason: from kotlin metadata */
    private final MutableLiveData<ECShareActionInfo> shareActionInfo;

    /* renamed from: W, reason: from kotlin metadata */
    private final LiveData<ECShareActionInfo> shareActionInfoLiveData;

    /* renamed from: X, reason: from kotlin metadata */
    private String retainId;

    /* renamed from: Y, reason: from kotlin metadata */
    public final String mediaId;

    public ECShopProductDetailCustomViewModel(String str, boolean z16, FragmentManager fragmentManager, String str2, String str3) {
        super(str, z16, fragmentManager, str3);
        this.mediaId = str2;
        MutableLiveData<ECShareActionInfo> mutableLiveData = new MutableLiveData<>();
        this.shareActionInfo = mutableLiveData;
        this.shareActionInfoLiveData = mutableLiveData;
        this.retainId = "";
    }

    private final JSONArray r2(JSONObject data) {
        JSONArray jSONArray;
        String optString;
        JSONObject optJSONObject = data.optJSONObject("product");
        String str = "";
        if (optJSONObject != null && (optString = optJSONObject.optString("title", "")) != null) {
            str = optString;
        }
        if (optJSONObject == null || (jSONArray = optJSONObject.optJSONArray("labels")) == null) {
            jSONArray = new JSONArray();
        }
        l h16 = new k(null, 1, null).h(jSONArray);
        h16.e(str, 15, "qecommerce_skin_color_text_primary", 2);
        return h16.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ECBasePtsViewData> v2(JSONObject data, JSONObject requestParams) {
        ECProductDetailDataParserType eCProductDetailDataParserType;
        if (this.isSelect) {
            eCProductDetailDataParserType = ECProductDetailDataParserType.ECProductDetailDataBizTypeShopSelect;
        } else {
            eCProductDetailDataParserType = ECProductDetailDataParserType.ECProductDetailDataBizTypeShop;
        }
        IECPTSProcessor a16 = com.tencent.ecommerce.biz.detail.dataprocessor.processor.b.f102022b.a(eCProductDetailDataParserType);
        if (data != null) {
            data.put("nodes", r2(data));
        }
        if (data != null) {
            data.put("price_desc", new JSONObject("{\"nodes\":[{\"name\":\"div\",\"children\":[{\"type\":\"text\",\"text\":\"\u6b64\u8bf4\u660e\u4ec5\u5f53\u51fa\u73b0\u4ef7\u683c\u6bd4\u8f83\u65f6\u6709\u6548\uff0c\u5177\u4f53\u8bf7\u53c2\u89c1\",\"attrs\":{\"style\":\"color:#999999;font-size:24rpx;-webkit-line-clamp:3;\"}},{\"name\":\"a\",\"attrs\":{\"href\":\"https:\\/\\/docs.qq.com\\/doc\\/p\\/0c3ff492a9c5e12022e7bc05bc1f6bba12f57b1e?dver=3.0.0\",\"style\":\"color:#40A0FF;font-size:24rpx;display:-webkit-box;overflow:hidden;-webkit-box-orient:vertical;\"},\"children\":[{\"type\":\"text\",\"text\":\"\u300aQQ\u5c0f\u5e97\u5546\u54c1\u4ef7\u683c\u7ba1\u7406\u89c4\u8303\u300b\"},{\"type\":\"text\",\"text\":\"\u3002\u82e5\u5546\u5bb6\u5355\u72ec\u5bf9\u5212\u7ebf\u4ef7\u683c\u8fdb\u884c\u8bf4\u660e\u7684\uff0c\u4ee5\u5546\u5bb6\u7684\u8868\u8ff0\u4e3a\u51c6\u3002\",\"attrs\":{\"style\":\"color:#999999;font-size:24rpx;\"}}]}]}]}"));
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("media_id", this.mediaId);
        jSONObject.put("is_in_presale", w2(data));
        List<ECPageParserParams> processRemoteParserParamsArray = a16.processRemoteParserParamsArray(data, jSONObject);
        if (processRemoteParserParamsArray == null) {
            processRemoteParserParamsArray = a16.localPageParserParamsArray(jSONObject);
        }
        List<ECBasePtsViewData> process = a16.process(processRemoteParserParamsArray, data, requestParams);
        return process != null ? process : new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object A2(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        ECShopProductDetailCustomViewModel$requestMoreRecommendData$1 eCShopProductDetailCustomViewModel$requestMoreRecommendData$1;
        Object coroutine_suspended;
        int i3;
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel;
        List<ECBasePtsViewData> e16;
        if (continuation instanceof ECShopProductDetailCustomViewModel$requestMoreRecommendData$1) {
            eCShopProductDetailCustomViewModel$requestMoreRecommendData$1 = (ECShopProductDetailCustomViewModel$requestMoreRecommendData$1) continuation;
            int i16 = eCShopProductDetailCustomViewModel$requestMoreRecommendData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailCustomViewModel$requestMoreRecommendData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailCustomViewModel$requestMoreRecommendData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailCustomViewModel$requestMoreRecommendData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    eCShopProductDetailCustomViewModel$requestMoreRecommendData$1.L$0 = this;
                    eCShopProductDetailCustomViewModel$requestMoreRecommendData$1.L$1 = jSONObject;
                    eCShopProductDetailCustomViewModel$requestMoreRecommendData$1.label = 1;
                    obj = B2(jSONObject, eCShopProductDetailCustomViewModel$requestMoreRecommendData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCShopProductDetailCustomViewModel = this;
                } else if (i3 == 1) {
                    jSONObject = (JSONObject) eCShopProductDetailCustomViewModel$requestMoreRecommendData$1.L$1;
                    eCShopProductDetailCustomViewModel = (ECShopProductDetailCustomViewModel) eCShopProductDetailCustomViewModel$requestMoreRecommendData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e16 = eCShopProductDetailCustomViewModel.j2().e((JSONObject) obj, jSONObject);
                if (!e16.isEmpty()) {
                    eCShopProductDetailCustomViewModel.Z1().postValue(e16);
                }
                return Unit.INSTANCE;
            }
        }
        eCShopProductDetailCustomViewModel$requestMoreRecommendData$1 = new ECShopProductDetailCustomViewModel$requestMoreRecommendData$1(this, continuation);
        Object obj2 = eCShopProductDetailCustomViewModel$requestMoreRecommendData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailCustomViewModel$requestMoreRecommendData$1.label;
        if (i3 != 0) {
        }
        e16 = eCShopProductDetailCustomViewModel.j2().e((JSONObject) obj2, jSONObject);
        if (!e16.isEmpty()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object B2(JSONObject jSONObject, Continuation<? super JSONObject> continuation) {
        if (this.isSelect) {
            return new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
        ECShopRecommendScene eCShopRecommendScene = ECShopRecommendScene.QQ_SHOP_PRODUCT_DETAIL;
        jSONObject2.put("recom_scene", eCShopRecommendScene.ordinal());
        jSONObject2.put("scene", eCShopRecommendScene.ordinal());
        return j2().i(jSONObject2, continuation);
    }

    public Object C2(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        c2().postValue(Boxing.boxInt(3));
        Object withContext = BuildersKt.withContext(getDefaultDispatcher(), new ECShopProductDetailCustomViewModel$requestPtsDataWithModel$2(this, str, str2, jSONObject, jSONObject2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }

    public final void D2(String str) {
        this.retainId = str;
    }

    public final void s2(String spuId, int shareAction, ECActionItemData data) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new ECShopProductDetailCustomViewModel$getProductShareInfo$1(this, spuId, shareAction, data, null), 2, null);
    }

    /* renamed from: t2, reason: from getter */
    public final String getRetainId() {
        return this.retainId;
    }

    public final LiveData<ECShareActionInfo> u2() {
        return this.shareActionInfoLiveData;
    }

    public void x2(String spuId, JSONObject requestParams) {
        ECShopProductDetailInfo f16 = j2().f(spuId);
        if (f16 != null) {
            List<ECBasePtsViewData> v26 = v2(f16.infoData, requestParams);
            if (!v26.isEmpty()) {
                Z1().postValue(v26);
                d.f102466a.r(getShowPageCostTime(), false, 1);
                cg0.a.b("ECDetailPageViewModel", "[loadProductDetailFromCache] cache successed");
                return;
            }
            return;
        }
        cg0.a.b("ECDetailPageViewModel", "[loadProductDetailFromCache] cache missed");
    }

    public final void y2(String spuId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopProductDetailCustomViewModel$refreshPageRetainInfo$1(this, spuId, null), 3, null);
    }

    public final Object z2(String str, String str2, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object g16 = j2().g(str, str2, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return g16 == coroutine_suspended ? g16 : Unit.INSTANCE;
    }

    private final boolean w2(JSONObject data) {
        JSONObject optJSONObject;
        if (data == null || (optJSONObject = data.optJSONObject("delivery_info")) == null || optJSONObject.optInt("delivery_mode", 0) != 1) {
            return false;
        }
        if (!optJSONObject.optBoolean("has_end_time", false)) {
            return true;
        }
        long optLong = optJSONObject.optLong("presale_end_time", 0L);
        return optLong != 0 && QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis() / ((long) 1000) < optLong;
    }
}
