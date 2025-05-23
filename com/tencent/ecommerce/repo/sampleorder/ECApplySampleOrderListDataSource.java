package com.tencent.ecommerce.repo.sampleorder;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.base.list.BaseListDataSource;
import com.tencent.ecommerce.base.list.IListRepository;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListExtraInfo;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000  2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0002J'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0015R\u0018\u0010\u001a\u001a\u00020\u0017*\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u00020\t*\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleOrderListDataSource;", "Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "Lcom/tencent/ecommerce/repo/sampleorder/c;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/b;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/a;", "", "", DomainData.DOMAIN_NAME, "Lorg/json/JSONArray;", "", "token", ReportConstant.COSTREPORT_PREFIX, "orderList", "", "t", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/ecommerce/base/list/IListRepository$a;", "o", "(Lcom/tencent/ecommerce/repo/sampleorder/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extra", "p", "(Lcom/tencent/ecommerce/repo/sampleorder/c;Lcom/tencent/ecommerce/repo/buyerorder/orderlist/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "l", "(Lcom/tencent/ecommerce/repo/buyerorder/orderlist/b;)J", "leftTimeMs", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/ecommerce/repo/buyerorder/orderlist/b;)Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "<init>", "()V", "b", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECApplySampleOrderListDataSource extends BaseListDataSource<ECApplySampleOrderListRequest, ECOrderListItem, ECOrderListExtraInfo> {
    private final long l(ECOrderListItem eCOrderListItem) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = eCOrderListItem.getPtsJSONObject().optJSONObject("ui_data");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("show_info")) == null) {
            return 0L;
        }
        return optJSONObject.optLong("expire_left_time") * 1000;
    }

    private final String m(ECOrderListItem eCOrderListItem) {
        String optString;
        JSONObject optJSONObject = eCOrderListItem.getPtsJSONObject().optJSONObject("order");
        return (optJSONObject == null || (optString = optJSONObject.optString("order_id")) == null) ? "" : optString;
    }

    private final List<Integer> n(ECApplySampleOrderListRequest eCApplySampleOrderListRequest) {
        List<Integer> listOf;
        List<Integer> listOf2;
        List<Integer> listOf3;
        List<Integer> listOf4;
        int i3 = b.f105305a[eCApplySampleOrderListRequest.queryType.ordinal()];
        if (i3 == 1) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(ECApplySampleQueryType.AUDITING.type), Integer.valueOf(ECApplySampleQueryType.CANCELLED.type), 3, Integer.valueOf(ECApplySampleQueryType.SIGNING.type), Integer.valueOf(ECApplySampleQueryType.FULFILLING.type), 6, Integer.valueOf(ECApplySampleQueryType.UNFULFILLED.type), Integer.valueOf(ECApplySampleQueryType.FULFILLED.type)});
            return listOf;
        }
        if (i3 == 2) {
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(ECApplySampleQueryType.CANCELLED.type), 3});
            return listOf2;
        }
        if (i3 != 3) {
            listOf4 = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(eCApplySampleOrderListRequest.queryType.type));
            return listOf4;
        }
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(ECApplySampleQueryType.AUDITING.type), 6});
        return listOf3;
    }

    private final List<ECOrderListItem> s(JSONArray jSONArray, String str) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            optJSONObject.put("token", str);
            arrayList.add(new ECOrderListItem(optJSONObject));
        }
        return arrayList;
    }

    private final void t(List<ECOrderListItem> orderList) {
        for (ECOrderListItem eCOrderListItem : orderList) {
            com.tencent.ecommerce.biz.orders.sampleorders.a.f103795b.c(m(eCOrderListItem), l(eCOrderListItem));
        }
    }

    @Override // com.tencent.ecommerce.base.list.BaseListDataSource
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Object h(ECApplySampleOrderListRequest eCApplySampleOrderListRequest, ECOrderListExtraInfo eCOrderListExtraInfo, Continuation<? super IListRepository.Result<ECOrderListItem, ECOrderListExtraInfo>> continuation) {
        return q(eCApplySampleOrderListRequest, eCOrderListExtraInfo, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object q(ECApplySampleOrderListRequest eCApplySampleOrderListRequest, ECOrderListExtraInfo eCOrderListExtraInfo, Continuation<? super IListRepository.Result<ECOrderListItem, ECOrderListExtraInfo>> continuation) {
        ECApplySampleOrderListDataSource$loadPageFromServer$1 eCApplySampleOrderListDataSource$loadPageFromServer$1;
        Object coroutine_suspended;
        int i3;
        String str;
        ECApplySampleOrderListDataSource eCApplySampleOrderListDataSource;
        ECNetworkResponse eCNetworkResponse;
        List emptyList;
        List<ECOrderListItem> emptyList2;
        if (continuation instanceof ECApplySampleOrderListDataSource$loadPageFromServer$1) {
            eCApplySampleOrderListDataSource$loadPageFromServer$1 = (ECApplySampleOrderListDataSource$loadPageFromServer$1) continuation;
            int i16 = eCApplySampleOrderListDataSource$loadPageFromServer$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCApplySampleOrderListDataSource$loadPageFromServer$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCApplySampleOrderListDataSource$loadPageFromServer$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCApplySampleOrderListDataSource$loadPageFromServer$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("query_words", eCApplySampleOrderListRequest.keyword);
                    JSONArray jSONArray = new JSONArray();
                    Iterator<T> it = n(eCApplySampleOrderListRequest).iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((Number) it.next()).intValue());
                    }
                    Unit unit = Unit.INSTANCE;
                    jSONObject.put("order_status_list", jSONArray);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("options", jSONObject);
                    if (eCOrderListExtraInfo == null || (str = eCOrderListExtraInfo.cookie) == null) {
                        str = "";
                    }
                    jSONObject2.put("cookie", str);
                    com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                    eCApplySampleOrderListDataSource$loadPageFromServer$1.L$0 = this;
                    eCApplySampleOrderListDataSource$loadPageFromServer$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.qshop_sample_svr.CreativeSvr", "/trpc.ecom.qshop_sample_svr.CreativeSvr/QueryOrderList", bVar, jSONObject2, eCApplySampleOrderListDataSource$loadPageFromServer$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCApplySampleOrderListDataSource = this;
                } else if (i3 == 1) {
                    eCApplySampleOrderListDataSource = (ECApplySampleOrderListDataSource) eCApplySampleOrderListDataSource$loadPageFromServer$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                JSONObject jSONObject3 = (JSONObject) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() != 0 && jSONObject3 != null) {
                    String optString = jSONObject3.optString("token");
                    JSONArray optJSONArray = jSONObject3.optJSONArray("order_detail_list");
                    if (optJSONArray == null || (emptyList2 = eCApplySampleOrderListDataSource.s(optJSONArray, optString)) == null) {
                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    String optString2 = jSONObject3.optString("cookie");
                    eCApplySampleOrderListDataSource.t(emptyList2);
                    return new IListRepository.Result(true, emptyList2, optString2.length() > 0, new ECOrderListExtraInfo(optString2, optString));
                }
                cg0.a.a("ECApplySampleOrderListDataSource", "loadPageFromServer", "load apply sample order list error, errCode:" + eCNetworkResponse.getCode() + ",errMsg:" + eCNetworkResponse.getMessage());
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return new IListRepository.Result(false, emptyList, false, null);
            }
        }
        eCApplySampleOrderListDataSource$loadPageFromServer$1 = new ECApplySampleOrderListDataSource$loadPageFromServer$1(this, continuation);
        Object obj2 = eCApplySampleOrderListDataSource$loadPageFromServer$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCApplySampleOrderListDataSource$loadPageFromServer$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        JSONObject jSONObject32 = (JSONObject) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() != 0) {
        }
        cg0.a.a("ECApplySampleOrderListDataSource", "loadPageFromServer", "load apply sample order list error, errCode:" + eCNetworkResponse.getCode() + ",errMsg:" + eCNetworkResponse.getMessage());
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new IListRepository.Result(false, emptyList, false, null);
    }

    static /* synthetic */ Object r(ECApplySampleOrderListDataSource eCApplySampleOrderListDataSource, ECApplySampleOrderListRequest eCApplySampleOrderListRequest, ECOrderListExtraInfo eCOrderListExtraInfo, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            eCOrderListExtraInfo = null;
        }
        return eCApplySampleOrderListDataSource.q(eCApplySampleOrderListRequest, eCOrderListExtraInfo, continuation);
    }

    @Override // com.tencent.ecommerce.base.list.BaseListDataSource
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Object c(ECApplySampleOrderListRequest eCApplySampleOrderListRequest, Continuation<? super IListRepository.Result<ECOrderListItem, ECOrderListExtraInfo>> continuation) {
        return r(this, eCApplySampleOrderListRequest, null, continuation, 2, null);
    }
}
