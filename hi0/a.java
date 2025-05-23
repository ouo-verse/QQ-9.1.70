package hi0;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.service.b;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u00a8\u0006\u000e"}, d2 = {"Lhi0/a;", "", "", "b", "", "inputQuery", "", "requestType", "c", "", "historyList", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f404941a = new a();

    a() {
    }

    public final void a(List<String> historyList) {
        Map mapOf;
        b bVar = b.f100913b;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("query_list", historyList.toString()));
        IECDataReport.a.a(bVar, "order_list_search_history_query_exp", mapOf, false, 4, null);
    }

    public final void b() {
        IECDataReport.a.a(b.f100913b, "order_list_search_bar_clk", null, false, 4, null);
    }

    public final void c(String inputQuery, int requestType) {
        Map mapOf;
        b bVar = b.f100913b;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("input_query", inputQuery), TuplesKt.to("request_way", Integer.valueOf(requestType)));
        IECDataReport.a.a(bVar, "order_list_search_request", mapOf, false, 4, null);
    }
}
