package com.tencent.ecommerce.repo.buyerorder.orderlist;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.base.list.BaseListDataSource;
import com.tencent.ecommerce.base.list.IListRepository;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.util.j;
import com.tencent.ecommerce.biz.util.k;
import com.tencent.ecommerce.biz.util.l;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 \u001e2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\b\u001a\u00020\u0007*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\n*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005H\u0002J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r*\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u001e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0002J'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0015\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/orderlist/ECOrderListDataSource;", "Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/c;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/b;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/a;", "", "cookie", "Lorg/json/JSONObject;", "u", "fromScene", "Lcom/tencent/ecommerce/base/list/IListRepository$a;", ReportConstant.COSTREPORT_PREFIX, "Lorg/json/JSONArray;", "", "t", "jsonObject", "", "r", "l", "printArray", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, Const.BUNDLE_KEY_REQUEST, DomainData.DOMAIN_NAME, "(Lcom/tencent/ecommerce/repo/buyerorder/orderlist/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extra", "o", "(Lcom/tencent/ecommerce/repo/buyerorder/orderlist/c;Lcom/tencent/ecommerce/repo/buyerorder/orderlist/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "p", "<init>", "()V", "b", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderListDataSource extends BaseListDataSource<ECOrderListRequestInfo, ECOrderListItem, ECOrderListExtraInfo> {
    private final void l(JSONObject jsonObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        String optString;
        JSONArray optJSONArray = jsonObject.optJSONArray("product_carts");
        if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null || (optJSONObject2 = optJSONObject.optJSONObject("order_sku")) == null || (optJSONObject3 = optJSONObject2.optJSONObject("spu")) == null || (optString = optJSONObject3.optString("title")) == null) {
            return;
        }
        JSONArray optJSONArray2 = jsonObject.optJSONArray("labels");
        if (optJSONArray2 == null) {
            optJSONArray2 = new JSONArray();
        }
        l h16 = new k(null, 1, null).h(optJSONArray2);
        h16.e(optString, 14, "qecommerce_skin_color_text_primary", Integer.valueOf(jsonObject.optInt("goods_type") != 101 ? 2 : 1));
        jsonObject.put("nodes", h16.g());
    }

    private final void r(JSONObject jsonObject) {
        l(jsonObject);
        m(jsonObject, j.f104870a.b(jsonObject.optLong("order_price", 0L)));
        JSONArray optJSONArray = jsonObject.optJSONArray("product_carts");
        int i3 = 0;
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            for (int i16 = 0; i16 < length; i16++) {
                JSONObject optJSONObject = optJSONArray.getJSONObject(0).optJSONObject("order_sku");
                JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("sku") : null;
                if (optJSONObject2 != null) {
                    m(optJSONObject2, j.f104870a.b(optJSONObject2.optLong("price", 0L)));
                }
            }
        }
        jsonObject.put("request_channel", ug0.b.f438933d.e());
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length2 = optJSONArray.length();
            int i17 = 0;
            while (i3 < length2) {
                i17 += optJSONArray.getJSONObject(i3).optInt("sku_num");
                i3++;
            }
            while (optJSONArray.length() > 3) {
                optJSONArray.remove(3);
            }
            i3 = i17;
        }
        jsonObject.put("total_sku_num", i3);
    }

    private final IListRepository.Result<ECOrderListItem, ECOrderListExtraInfo> s(JSONObject jSONObject, String str) {
        return new IListRepository.Result<>(true, t(jSONObject.optJSONArray("order_infos"), str), jSONObject.optString("cookie").length() > 0, new ECOrderListExtraInfo(jSONObject.optString("cookie"), jSONObject.optString("token")));
    }

    private final JSONObject u(ECOrderListRequestInfo eCOrderListRequestInfo, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("keyword", eCOrderListRequestInfo.keyword);
        jSONObject2.put("state_option", eCOrderListRequestInfo.getQueryType().type);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("query_option", jSONObject2);
        if (!(str == null || str.length() == 0)) {
            jSONObject.put("cookie", str);
        }
        return jSONObject;
    }

    @Override // com.tencent.ecommerce.base.list.BaseListDataSource
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Object h(ECOrderListRequestInfo eCOrderListRequestInfo, ECOrderListExtraInfo eCOrderListExtraInfo, Continuation<? super IListRepository.Result<ECOrderListItem, ECOrderListExtraInfo>> continuation) {
        return p(eCOrderListRequestInfo, eCOrderListExtraInfo, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object p(ECOrderListRequestInfo eCOrderListRequestInfo, ECOrderListExtraInfo eCOrderListExtraInfo, Continuation<? super IListRepository.Result<ECOrderListItem, ECOrderListExtraInfo>> continuation) {
        ECOrderListDataSource$loadPageFromServer$1 eCOrderListDataSource$loadPageFromServer$1;
        Object coroutine_suspended;
        int i3;
        ECOrderListDataSource eCOrderListDataSource;
        int code;
        JSONObject jSONObject;
        List emptyList;
        if (continuation instanceof ECOrderListDataSource$loadPageFromServer$1) {
            eCOrderListDataSource$loadPageFromServer$1 = (ECOrderListDataSource$loadPageFromServer$1) continuation;
            int i16 = eCOrderListDataSource$loadPageFromServer$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCOrderListDataSource$loadPageFromServer$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCOrderListDataSource$loadPageFromServer$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCOrderListDataSource$loadPageFromServer$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject u16 = u(eCOrderListRequestInfo, eCOrderListExtraInfo != null ? eCOrderListExtraInfo.cookie : null);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("loadFirstPageFromServer, req=");
                    sb5.append(u16);
                    sb5.append(", cookie=");
                    sb5.append(eCOrderListExtraInfo != null ? eCOrderListExtraInfo.getToken() : null);
                    cg0.a.b("OrderListDataSource", sb5.toString());
                    com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                    eCOrderListDataSource$loadPageFromServer$1.L$0 = this;
                    eCOrderListDataSource$loadPageFromServer$1.L$1 = eCOrderListRequestInfo;
                    eCOrderListDataSource$loadPageFromServer$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.qshop_order_query_svr.QshopOrderQuerySvr", "/trpc.ecom.qshop_order_query_svr.QshopOrderQuerySvr/QueryBuyerOrderList", bVar, u16, eCOrderListDataSource$loadPageFromServer$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCOrderListDataSource = this;
                } else if (i3 == 1) {
                    eCOrderListRequestInfo = (ECOrderListRequestInfo) eCOrderListDataSource$loadPageFromServer$1.L$1;
                    eCOrderListDataSource = (ECOrderListDataSource) eCOrderListDataSource$loadPageFromServer$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                code = eCNetworkResponse.getCode();
                jSONObject = (JSONObject) eCNetworkResponse.b();
                if (!cg0.a.c()) {
                    cg0.a.b("OrderListDataSource", "loadFirstPageFromServer rsp, code=" + code + ", data=" + jSONObject);
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("loadFirstPageFromServer rsp, code=");
                    sb6.append(code);
                    sb6.append(", dataIsNull=");
                    sb6.append(jSONObject == null);
                    cg0.a.b("OrderListDataSource", sb6.toString());
                }
                if (code != 0 && jSONObject != null) {
                    return eCOrderListDataSource.s(jSONObject, eCOrderListRequestInfo.getFromScene());
                }
                cg0.a.a("OrderListDataSource", "loadFirstPageFromServer", "loadFirstPageFromServer, code = " + code + ", data=" + jSONObject);
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return new IListRepository.Result(false, emptyList, false, null);
            }
        }
        eCOrderListDataSource$loadPageFromServer$1 = new ECOrderListDataSource$loadPageFromServer$1(this, continuation);
        Object obj2 = eCOrderListDataSource$loadPageFromServer$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCOrderListDataSource$loadPageFromServer$1.label;
        if (i3 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        code = eCNetworkResponse2.getCode();
        jSONObject = (JSONObject) eCNetworkResponse2.b();
        if (!cg0.a.c()) {
        }
        if (code != 0) {
        }
        cg0.a.a("OrderListDataSource", "loadFirstPageFromServer", "loadFirstPageFromServer, code = " + code + ", data=" + jSONObject);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new IListRepository.Result(false, emptyList, false, null);
    }

    private final void m(JSONObject jsonObject, List<String> printArray) {
        jsonObject.put("price_int", printArray.get(0));
        jsonObject.put("price_decimal", printArray.get(1));
    }

    private final List<ECOrderListItem> t(JSONArray jSONArray, String str) {
        List<ECOrderListItem> emptyList;
        if (jSONArray == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject put = jSONArray.getJSONObject(i3).put("scene", str);
            r(put);
            arrayList.add(new ECOrderListItem(put));
        }
        return arrayList;
    }

    static /* synthetic */ Object q(ECOrderListDataSource eCOrderListDataSource, ECOrderListRequestInfo eCOrderListRequestInfo, ECOrderListExtraInfo eCOrderListExtraInfo, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            eCOrderListExtraInfo = null;
        }
        return eCOrderListDataSource.p(eCOrderListRequestInfo, eCOrderListExtraInfo, continuation);
    }

    @Override // com.tencent.ecommerce.base.list.BaseListDataSource
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object c(ECOrderListRequestInfo eCOrderListRequestInfo, Continuation<? super IListRepository.Result<ECOrderListItem, ECOrderListExtraInfo>> continuation) {
        return q(this, eCOrderListRequestInfo, null, continuation, 2, null);
    }
}
