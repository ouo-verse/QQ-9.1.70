package fj0;

import ck0.Product;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.common.e;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lfj0/b;", "", "", "busId", "", "buttonPos", "", "a", "", "Lck0/c;", "productList", "c", "clickOption", "d", "eventCode", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f399473a = new b();

    b() {
    }

    public final void a(String busId, int buttonPos) {
        Map<Object, Object> f16 = e.e(new e().a(busId), null, 1, null).b("button_position", String.valueOf(buttonPos)).f();
        cg0.a.b("ECShowWindowDataReportUtil", "[reportAddProductBtnClick] eventCoe = window_add_goods_clk, params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "window_add_goods_clk", f16, false, 4, null);
    }

    public final void b(String busId, String eventCode) {
        Map<Object, Object> f16 = e.e(new e().a(busId), null, 1, null).f();
        cg0.a.b("ECShowWindowDataReportUtil", "[reportButtonClick] eventCode = " + eventCode + ", params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }

    public final void c(String busId, List<Product> productList) {
        e e16 = e.e(new e().a(busId), null, 1, null);
        JSONArray jSONArray = new JSONArray();
        for (Product product : productList) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("saas_id", product.getSaasTypeStr());
            jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, product.getSaasProductId());
            jSONArray.mo162put(jSONObject);
        }
        e16.b("delete_product_list", jSONArray.toString());
        Map<Object, Object> f16 = e16.f();
        cg0.a.b("ECShowWindowDataReportUtil", "[reportDeleteBtnClick] eventCode = window_goods_card_delete, params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "window_goods_card_delete", f16, false, 4, null);
    }

    public final void d(String busId, int clickOption) {
        Map<Object, Object> f16 = e.e(new e().a(busId), null, 1, null).b("click_option", String.valueOf(clickOption)).f();
        cg0.a.b("ECShowWindowDataReportUtil", "[reportDeleteConfirmBtnClick] eventCode = window_delete_alert_clk, params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "window_delete_alert_clk", f16, false, 4, null);
    }
}
