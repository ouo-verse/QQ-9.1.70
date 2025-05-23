package ki0;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.orders.sellerorders.container.ECSellerOrderTab;
import com.tencent.ecommerce.repo.sampleorder.ECApplySampleQueryType;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0005H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002J\u0014\u0010\u0012\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\n\u00a8\u0006\u0018"}, d2 = {"Lki0/b;", "", "Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderTab;", "", "g", "Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleQueryType;", h.F, "", "busId", "tab", "", "f", "d", "inputQuery", "requestType", "e", "", "historyList", "a", "queryType", "c", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f412528a = new b();

    b() {
    }

    private final int g(ECSellerOrderTab eCSellerOrderTab) {
        int i3 = a.f412526a[eCSellerOrderTab.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return i16;
    }

    private final int h(ECApplySampleQueryType eCApplySampleQueryType) {
        switch (a.f412527b[eCApplySampleQueryType.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void a(List<String> historyList) {
        Map mapOf;
        Map map;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("query_list", historyList.toString()), TuplesKt.to(EmotionReportDtImpl.CURRENT_TAB, Integer.valueOf(g(ECSellerOrderTab.SAMPLE))));
        cg0.a.b("ECSellerOrderReporter", "[reportApplySampleOrderSearchHistoryExp] eventCode = order_detail_search_history_query_exp, params = " + mapOf);
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        map = MapsKt__MapsKt.toMap(mapOf);
        IECDataReport.a.a(bVar, "order_detail_search_history_query_exp", map, false, 4, null);
    }

    public final void b() {
        cg0.a.b("ECSellerOrderReporter", "[reportSampleCustomerServiceClick] eventCode = order_list_b_customer_service_clk");
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "order_list_b_customer_service_clk", null, false, 4, null);
    }

    public final void c(ECApplySampleQueryType queryType) {
        Map mapOf;
        Map map;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("order_sort_tab", Integer.valueOf(h(queryType))));
        cg0.a.b("ECSellerOrderReporter", "[reportSampleOrderListTabClick] eventCode = sample_order_list_sort, params = " + mapOf);
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        map = MapsKt__MapsKt.toMap(mapOf);
        IECDataReport.a.a(bVar, "sample_order_list_sort", map, false, 4, null);
    }

    public final void d(ECSellerOrderTab tab) {
        Map mapOf;
        Map map;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(EmotionReportDtImpl.CURRENT_TAB, Integer.valueOf(g(tab))));
        cg0.a.b("ECSellerOrderReporter", "[reportSearchBarClick] eventCode = order_detail_search_bar_clk, params = " + mapOf);
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        map = MapsKt__MapsKt.toMap(mapOf);
        IECDataReport.a.a(bVar, "order_detail_search_bar_clk", map, false, 4, null);
    }

    public final void e(String inputQuery, int requestType, ECSellerOrderTab tab) {
        Map mapOf;
        Map map;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("input_query", inputQuery), TuplesKt.to("request_way", Integer.valueOf(requestType)), TuplesKt.to(EmotionReportDtImpl.CURRENT_TAB, Integer.valueOf(g(tab))));
        cg0.a.b("ECSellerOrderReporter", "[reportTriggerSearchRequest] eventCode = order_detail_search_request, params = " + mapOf);
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        map = MapsKt__MapsKt.toMap(mapOf);
        IECDataReport.a.a(bVar, "order_detail_search_request", map, false, 4, null);
    }

    public final void f(String busId, ECSellerOrderTab tab) {
        Map mapOf;
        Map map;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("bus_id", busId), TuplesKt.to(EmotionReportDtImpl.CURRENT_TAB, Integer.valueOf(g(tab))));
        cg0.a.b("ECSellerOrderReporter", "[reportSubFragmentExp] eventCode = order_detail_exp, params = " + mapOf);
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        map = MapsKt__MapsKt.toMap(mapOf);
        IECDataReport.a.a(bVar, "order_detail_exp", map, false, 4, null);
    }
}
