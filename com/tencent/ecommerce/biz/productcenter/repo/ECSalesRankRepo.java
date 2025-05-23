package com.tencent.ecommerce.biz.productcenter.repo;

import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.b;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.biz.util.i;
import com.tencent.pts.utils.PTSDeviceUtil;
import gh0.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import xj0.RankGoodsInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J/\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\r2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\"\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u0006\u0010\u0011\u001a\u00020\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo;", "", "Lorg/json/JSONObject;", "data", "Ljava/util/ArrayList;", "Lxj0/a;", "Lkotlin/collections/ArrayList;", "d", "goodsJsonObj", "", "index", "", "a", "Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo$SalesRankType;", "type", "e", "(Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo$SalesRankType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rankListType", "rankList", "b", "c", "<init>", "()V", "SalesRankType", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSalesRankRepo {

    /* renamed from: a, reason: collision with root package name */
    public static final ECSalesRankRepo f103920a = new ECSalesRankRepo();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo$SalesRankType;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "DAILY", "MONTHLY", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public enum SalesRankType {
        UNKNOWN,
        DAILY,
        MONTHLY
    }

    ECSalesRankRepo() {
    }

    private final void a(JSONObject goodsJsonObj, int index) {
        long optLong = goodsJsonObj.optLong("commission");
        JSONObject optJSONObject = goodsJsonObj.optJSONObject("commission_info");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        long optLong2 = optJSONObject.optLong("commission_min");
        long optLong3 = optJSONObject.optLong("commission_max");
        if (optLong2 == 0 && optLong3 == 0) {
            goodsJsonObj.put("index_text", index + 1);
            goodsJsonObj.put("commission_yuan", i.f104869a.b(optLong));
        } else {
            goodsJsonObj.put("index_text", index + 1);
            i iVar = i.f104869a;
            goodsJsonObj.put("commission_min_yuan", iVar.b(optLong2));
            goodsJsonObj.put("commission_max_yuan", iVar.b(optLong3));
        }
    }

    public final void b(SalesRankType rankListType, ArrayList<RankGoodsInfo> rankList) {
        String str = "product_center_rank_list_" + rankListType.name();
        JSONArray jSONArray = new JSONArray();
        int min = Math.min(rankList.size(), 10);
        for (int i3 = 0; i3 < min; i3++) {
            jSONArray.mo162put(rankList.get(i3).getJsonData());
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("goods", jSONArray);
        ECLocalConfig.f100650f.setString(str, jSONObject.toString(), Boolean.TRUE);
    }

    public final ArrayList<RankGoodsInfo> c(SalesRankType rankListType) {
        try {
            return d(new JSONObject((String) ECLocalConfig.f100650f.get("product_center_rank_list_" + rankListType.name(), new JSONObject().toString(), Boolean.TRUE)));
        } catch (Exception e16) {
            cg0.a.a("ECSalesRankRepo", "getCacheRankList", "[getCacheRankList] exception = " + e16);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(SalesRankType salesRankType, Continuation<? super ArrayList<RankGoodsInfo>> continuation) {
        ECSalesRankRepo$reqSalesRankList$1 eCSalesRankRepo$reqSalesRankList$1;
        Object coroutine_suspended;
        int i3;
        ECSalesRankRepo eCSalesRankRepo;
        JSONObject jSONObject;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECSalesRankRepo$reqSalesRankList$1) {
            eCSalesRankRepo$reqSalesRankList$1 = (ECSalesRankRepo$reqSalesRankList$1) continuation;
            int i16 = eCSalesRankRepo$reqSalesRankList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCSalesRankRepo$reqSalesRankList$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCSalesRankRepo$reqSalesRankList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCSalesRankRepo$reqSalesRankList$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("type", salesRankType.ordinal());
                    b bVar = b.f100803a;
                    eCSalesRankRepo$reqSalesRankList$1.L$0 = this;
                    eCSalesRankRepo$reqSalesRankList$1.L$1 = jSONObject2;
                    eCSalesRankRepo$reqSalesRankList$1.label = 1;
                    Object e16 = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.goods_sales_rank_reader.GoodsSalesRankReader", "/trpc.ecom.goods_sales_rank_reader.GoodsSalesRankReader/Get", bVar, jSONObject2, eCSalesRankRepo$reqSalesRankList$1);
                    if (e16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCSalesRankRepo = this;
                    obj = e16;
                    jSONObject = jSONObject2;
                } else if (i3 == 1) {
                    jSONObject = (JSONObject) eCSalesRankRepo$reqSalesRankList$1.L$1;
                    eCSalesRankRepo = (ECSalesRankRepo) eCSalesRankRepo$reqSalesRankList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECSalesRankRepo", "reqSalesRankList service=trpc.ecom.goods_sales_rank_reader.GoodsSalesRankReader, method=/trpc.ecom.goods_sales_rank_reader.GoodsSalesRankReader/Get, params=" + jSONObject + ", response=" + eCNetworkResponse);
                if (eCNetworkResponse.getCode() != 0) {
                    JSONObject jSONObject3 = (JSONObject) eCNetworkResponse.b();
                    cg0.a.b("ECSalesRankRepo", "[reqSalesRankList] request success = " + jSONObject3);
                    return eCSalesRankRepo.d(jSONObject3);
                }
                cg0.a.a("ECSalesRankRepo", "reqSalesRankList", "[reqSalesRankList] request error = " + eCNetworkResponse.getMessage());
                return null;
            }
        }
        eCSalesRankRepo$reqSalesRankList$1 = new ECSalesRankRepo$reqSalesRankList$1(this, continuation);
        Object obj2 = eCSalesRankRepo$reqSalesRankList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCSalesRankRepo$reqSalesRankList$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        cg0.a.b("ECSalesRankRepo", "reqSalesRankList service=trpc.ecom.goods_sales_rank_reader.GoodsSalesRankReader, method=/trpc.ecom.goods_sales_rank_reader.GoodsSalesRankReader/Get, params=" + jSONObject + ", response=" + eCNetworkResponse);
        if (eCNetworkResponse.getCode() != 0) {
        }
    }

    private final ArrayList<RankGoodsInfo> d(JSONObject data) {
        if (data == null) {
            return null;
        }
        float screenWidthDp = PTSDeviceUtil.getScreenWidthDp() - 32;
        if (screenWidthDp < 0) {
            screenWidthDp = PTSDeviceUtil.getScreenWidthDp();
        }
        ArrayList<RankGoodsInfo> arrayList = new ArrayList<>();
        JSONArray optJSONArray = data.optJSONArray("goods");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                a(optJSONObject, i3);
                RankGoodsInfo rankGoodsInfo = new RankGoodsInfo(null, null, 3, null);
                rankGoodsInfo.c(optJSONObject);
                rankGoodsInfo.d(d.f402041a.a("select_rank_cell_card", ECPTSStyleManager.e("select_rank_cell_card", wg0.a.a()), optJSONObject.toString(), screenWidthDp, null));
                arrayList.add(rankGoodsInfo);
            }
        }
        return arrayList;
    }
}
