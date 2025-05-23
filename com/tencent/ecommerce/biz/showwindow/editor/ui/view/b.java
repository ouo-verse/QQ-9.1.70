package com.tencent.ecommerce.biz.showwindow.editor.ui.view;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.common.e;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/editor/ui/view/b;", "", "", "eventCode", "Lorg/json/JSONObject;", "params", "", "a", "c", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f104479a = new b();

    b() {
    }

    public final void a(String eventCode, JSONObject params) {
        Map<Object, Object> f16 = new e().b("saas_id", params.optString("saas_id")).b("goods_type", String.valueOf(params.optInt("goods_type"))).b(ReportDataBuilder.KEY_PRODUCT_ID, params.optString(ReportDataBuilder.KEY_PRODUCT_ID)).b("product_name", params.optString("product_name")).f();
        if (cg0.a.c()) {
            cg0.a.b("ECProductCardEditorDataReport", "[reportGoodCardEditPageExp] eventCode = " + eventCode + ", params = " + f16);
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }

    public final void b(String eventCode, JSONObject params) {
        Map<Object, Object> f16 = new e().b("saas_id", params.optString("saas_id")).b("goods_type", String.valueOf(params.optInt("goods_type"))).b(ReportDataBuilder.KEY_PRODUCT_ID, params.optString(ReportDataBuilder.KEY_PRODUCT_ID)).b("product_name", params.optString("product_name")).b("edited_cover", params.optString("edited_cover")).b("edited_title", params.optString("edited_title")).f();
        if (cg0.a.c()) {
            cg0.a.b("ECProductCardEditorDataReport", "[reportGoodsCardEditionSave] eventCode = " + eventCode + ", params = " + f16);
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }

    public final void c(String eventCode, JSONObject params) {
        Map<Object, Object> f16 = new e().f();
        if (cg0.a.c()) {
            cg0.a.b("ECProductCardEditorDataReport", "[reportGoodsCardExampleBtnClick] eventCode = " + eventCode + ", params = " + f16);
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }
}
