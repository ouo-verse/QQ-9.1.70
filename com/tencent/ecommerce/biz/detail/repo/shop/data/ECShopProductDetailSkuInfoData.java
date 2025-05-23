package com.tencent.ecommerce.biz.detail.repo.shop.data;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.ECProductDetailDataParserType;
import com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.SkuInfoType;
import com.tencent.ecommerce.biz.util.ECDebugUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u0012B#\u0012\u0006\u0010*\u001a\u00020\u0017\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u00100\u001a\u00020,\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0013\u0010\u000b\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011J)\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\fJ\u0006\u0010\u001f\u001a\u00020\u0002R\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010!R0\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170#j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010%R\u0016\u0010(\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010'R\u0014\u0010*\u001a\u00020\u00178\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010)R\u0016\u0010+\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010)R\u0017\u00100\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010-\u001a\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00063"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductDetailSkuInfoData;", "", "Lorg/json/JSONObject;", "e", "productDetailData", "b", "f", "data", "", "Lcom/tencent/ecommerce/base/ui/b;", "g", "l", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", tl.h.F, "", "d", "c", "", "a", "newBuyCount", "isNeedShowToast", DomainData.DOMAIN_NAME, "(Ljava/lang/Integer;Z)Ljava/util/List;", "", "name", "value", "p", "j", "i", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/IECShopProductDetailRepository;", "repository", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "chooseSkuOptions", "I", "buyCount", "Ljava/lang/String;", "spuId", "activeId", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/SkuInfoType;", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/SkuInfoType;", "getType", "()Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/SkuInfoType;", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/SkuInfoType;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductDetailSkuInfoData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IECShopProductDetailRepository repository = com.tencent.ecommerce.biz.detail.repo.shop.a.f102322a.getShopProductDetailRepository();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LinkedHashMap<String, String> chooseSkuOptions = new LinkedHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int buyCount = 1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String spuId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final String activeId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final SkuInfoType type;

    public ECShopProductDetailSkuInfoData(String str, String str2, SkuInfoType skuInfoType) {
        this.spuId = str;
        this.activeId = str2;
        this.type = skuInfoType;
    }

    private final JSONObject b(JSONObject productDetailData) {
        JSONObject f16 = f(productDetailData);
        JSONObject optJSONObject = f16.optJSONObject("product");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        return new k(optJSONObject, f16.optJSONObject("active_info")).e(this.chooseSkuOptions, this.buyCount);
    }

    private final JSONObject e() {
        ECShopProductDetailInfo shopDetailCacheData = this.repository.getShopDetailCacheData(this.spuId, this.activeId);
        JSONObject jSONObject = shopDetailCacheData != null ? shopDetailCacheData.infoData : null;
        return jSONObject != null ? jSONObject : new JSONObject();
    }

    private final JSONObject f(JSONObject productDetailData) {
        JSONObject optJSONObject = productDetailData.optJSONObject("product");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        k kVar = new k(optJSONObject, productDetailData.optJSONObject("active_info"));
        JSONObject f16 = kVar.f(this.chooseSkuOptions);
        JSONArray g16 = kVar.g(this.chooseSkuOptions);
        if (kVar.u(this.chooseSkuOptions, false).isEmpty()) {
            this.buyCount = 1;
        }
        JSONObject e16 = kVar.e(this.chooseSkuOptions, this.buyCount);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sku_head_pts_info", f16);
        jSONObject.put("sku_pts_info", g16);
        jSONObject.put("sku_buy_count_info", e16);
        if (h.f102374a[this.type.ordinal()] == 2) {
            f16.put("is_sample", "1");
            JSONObject optJSONObject2 = f16.optJSONObject("price");
            if (optJSONObject2 != null) {
                optJSONObject2.put("price_txt", "0");
            }
            e16.put("is_sample", "1");
            e16.put("limit", "1");
            e16.put("count", "1");
            e16.put("max_count", "1");
            e16.put("min_count", "1");
        }
        productDetailData.put("sku_pts_data", jSONObject);
        return productDetailData;
    }

    private final List<ECBasePtsViewData> g(JSONObject data) {
        IECPTSProcessor a16 = com.tencent.ecommerce.biz.detail.dataprocessor.processor.b.f102022b.a(ECProductDetailDataParserType.ECProductDetailDataBizTypeShopChooseSkuInfo);
        List<ECPageParserParams> processRemoteParserParamsArray = a16.processRemoteParserParamsArray(data, new JSONObject());
        if (processRemoteParserParamsArray == null) {
            processRemoteParserParamsArray = a16.localPageParserParamsArray(new JSONObject());
        }
        List<ECBasePtsViewData> process = a16.process(processRemoteParserParamsArray, data, new JSONObject());
        if (process == null) {
            process = new ArrayList<>();
        }
        ECDebugUtils.f104852b.c(wg0.a.a().getApplicationContext(), data.toString());
        return process;
    }

    /* renamed from: a, reason: from getter */
    public final int getBuyCount() {
        return this.buyCount;
    }

    public final boolean c() {
        return b(e()).optBoolean("is_activity_soldout", false);
    }

    public final boolean d() {
        return b(e()).optBoolean("soldout", false);
    }

    public final List<ECBasePtsViewData> h(JSONObject productDetailData) {
        JSONObject f16 = f(productDetailData);
        List<ECBasePtsViewData> g16 = g(f16);
        cg0.a.b("ECDetailShopRepo", "[getDetailSkuInfoFromCache] data = " + f16 + ", pre pts success, count: " + g16.size());
        return g16;
    }

    public final boolean i() {
        JSONObject e16 = e();
        JSONObject optJSONObject = e16.optJSONObject("product");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject optJSONObject2 = e16.optJSONObject("active_info");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        return com.tencent.ecommerce.biz.detail.utils.f.f(optJSONObject2) && !new k(optJSONObject, optJSONObject2).o(this.chooseSkuOptions);
    }

    public final boolean j() {
        JSONObject e16 = e();
        JSONObject optJSONObject = e16.optJSONObject("product");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject optJSONObject2 = e16.optJSONObject("active_info");
        k kVar = new k(optJSONObject, optJSONObject2);
        return ((optJSONObject2 != null ? com.tencent.ecommerce.biz.detail.utils.f.a(optJSONObject2) : false) || kVar.q(this.chooseSkuOptions)) && !kVar.l(this.chooseSkuOptions);
    }

    public final JSONObject k() {
        Object first;
        String e16;
        JSONObject d16;
        if (d()) {
            cg0.a.b("ECDetailShopRepo", "jumpToOrderPage isSoldOut");
            return new JSONObject();
        }
        JSONObject e17 = e();
        JSONObject optJSONObject = e17.optJSONObject("product");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        k kVar = new k(optJSONObject, e17.optJSONObject("active_info"));
        List<JSONObject> u16 = kVar.u(this.chooseSkuOptions, true);
        if (!u16.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) u16);
            JSONObject jSONObject = (JSONObject) first;
            e16 = i.e(jSONObject);
            d16 = i.d(jSONObject);
            if (e16.length() == 0) {
                cg0.a.a("ECDetailShopRepo", "jumpToOrderPage", "skuid does not exist!");
                return new JSONObject();
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sku_id", e16);
            jSONObject2.put("sku_num", this.buyCount);
            jSONObject2.put("sku_price", d16);
            return jSONObject2;
        }
        com.tencent.ecommerce.base.ui.i.f101155b.d(kVar.h(this.chooseSkuOptions), ECToastIcon.ICON_ERROR, 0);
        return new JSONObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object l(Continuation<? super JSONObject> continuation) {
        ECShopProductDetailSkuInfoData$requestProductDetailData$1 eCShopProductDetailSkuInfoData$requestProductDetailData$1;
        Object coroutine_suspended;
        int i3;
        String str;
        if (continuation instanceof ECShopProductDetailSkuInfoData$requestProductDetailData$1) {
            eCShopProductDetailSkuInfoData$requestProductDetailData$1 = (ECShopProductDetailSkuInfoData$requestProductDetailData$1) continuation;
            int i16 = eCShopProductDetailSkuInfoData$requestProductDetailData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailSkuInfoData$requestProductDetailData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailSkuInfoData$requestProductDetailData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailSkuInfoData$requestProductDetailData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("spu_id", this.spuId);
                    String str2 = this.activeId;
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put("active_id", str2);
                    String str3 = this.activeId;
                    if (str3 == null || str3.length() == 0) {
                        str = "/trpc.ecom.qq_shop_detail_svr.ProductCard/GetProductDetailByBuyer";
                    } else {
                        str = "/trpc.ecom.qq_shop_detail_svr.ProductCard/GetActiveProductDetailByBuyer";
                    }
                    IECShopProductDetailRepository iECShopProductDetailRepository = this.repository;
                    eCShopProductDetailSkuInfoData$requestProductDetailData$1.label = 1;
                    obj = iECShopProductDetailRepository.getShopProductDetailData("trpc.ecom.qq_shop_detail_svr.ProductCard", str, jSONObject, eCShopProductDetailSkuInfoData$requestProductDetailData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECShopProductDetailInfo eCShopProductDetailInfo = (ECShopProductDetailInfo) obj;
                JSONObject jSONObject2 = eCShopProductDetailInfo == null ? eCShopProductDetailInfo.infoData : null;
                return jSONObject2 == null ? jSONObject2 : new JSONObject();
            }
        }
        eCShopProductDetailSkuInfoData$requestProductDetailData$1 = new ECShopProductDetailSkuInfoData$requestProductDetailData$1(this, continuation);
        Object obj2 = eCShopProductDetailSkuInfoData$requestProductDetailData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailSkuInfoData$requestProductDetailData$1.label;
        if (i3 != 0) {
        }
        ECShopProductDetailInfo eCShopProductDetailInfo2 = (ECShopProductDetailInfo) obj2;
        if (eCShopProductDetailInfo2 == null) {
        }
        if (jSONObject2 == null) {
        }
    }

    public final Object m(Continuation<? super ECShopProductDetailBuyFloatPageInfo> continuation) {
        return this.repository.updateSkuInfoDataToCache(this.spuId, this.activeId, continuation);
    }

    public final List<ECBasePtsViewData> p(String name, String value) {
        String str = this.chooseSkuOptions.get(name);
        if (str == null) {
            str = "";
        }
        if ((str.length() > 0) && Intrinsics.areEqual(str, value)) {
            this.chooseSkuOptions.remove(name);
        } else {
            this.chooseSkuOptions.put(name, value);
        }
        return o(this, null, false, 1, null);
    }

    public final List<ECBasePtsViewData> n(Integer newBuyCount, boolean isNeedShowToast) {
        Object first;
        int f16;
        if (newBuyCount != null) {
            newBuyCount.intValue();
            this.buyCount = newBuyCount.intValue();
        }
        JSONObject e16 = e();
        JSONObject optJSONObject = e16.optJSONObject("product");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        k kVar = new k(optJSONObject, e16.optJSONObject("active_info"));
        List<JSONObject> u16 = kVar.u(this.chooseSkuOptions, true);
        List<JSONObject> list = u16;
        if (list == null || list.isEmpty()) {
            this.buyCount = 1;
            if (isNeedShowToast) {
                com.tencent.ecommerce.base.ui.i.f101155b.d(kVar.h(this.chooseSkuOptions), ECToastIcon.ICON_ERROR, 0);
            }
            return h(e16);
        }
        int i3 = kVar.i(u16);
        if (i3 == 0) {
            i3 = Integer.MAX_VALUE;
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) u16);
        f16 = i.f((JSONObject) first);
        int min = Math.min(i3, f16);
        if (min == 0) {
            if (this.buyCount != 0 && isNeedShowToast) {
                com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.wtg, ECToastIcon.ICON_ERROR, 0);
            }
            this.buyCount = 0;
            return h(e16);
        }
        int i16 = this.buyCount;
        if (i16 < 1) {
            this.buyCount = 1;
            if (isNeedShowToast) {
                com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.wtj, ECToastIcon.ICON_ERROR, 0);
            }
            return h(e16);
        }
        if (i16 > min) {
            this.buyCount = min;
            if (isNeedShowToast) {
                com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.wti, ECToastIcon.ICON_ERROR, 0);
            }
            return h(e16);
        }
        return h(e16);
    }

    public static /* synthetic */ List o(ECShopProductDetailSkuInfoData eCShopProductDetailSkuInfoData, Integer num, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return eCShopProductDetailSkuInfoData.n(num, z16);
    }
}
