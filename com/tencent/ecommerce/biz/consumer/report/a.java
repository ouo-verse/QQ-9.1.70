package com.tencent.ecommerce.biz.consumer.report;

import com.tencent.ecommerce.base.report.service.g;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J\"\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/report/a;", "", "Lcom/tencent/ecommerce/biz/consumer/report/b;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "", "ext", "", "d", "c", "b", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f101632a = new a();

    a() {
    }

    public final void a(b reportParams, Map<String, String> ext) {
        Map<Object, ? extends Object> f16 = reportParams.z().c(ext).f();
        cg0.a.b("GoodsCardReportHelper", "[reportCloseClick] params = " + f16);
        com.tencent.ecommerce.base.report.service.b.f100913b.dataReport("ds_goods_card_close", f16, true);
        g.d("ds_goods_card_close", f16);
    }

    public final void b(b reportParams, Map<String, String> ext) {
        Map<Object, ? extends Object> f16 = reportParams.z().c(ext).f();
        cg0.a.b("GoodsCardReportHelper", "[reportItemClick] params = " + f16);
        com.tencent.ecommerce.base.report.service.b.f100913b.dataReport("ds_goods_card_clk", f16, true);
        g.d("ds_goods_card_clk", f16);
    }

    public final void c(b reportParams, Map<String, String> ext) {
        Map<Object, ? extends Object> f16 = reportParams.z().c(ext).f();
        cg0.a.b("GoodsCardReportHelper", "[reportViewDisappear] params = " + f16);
        com.tencent.ecommerce.base.report.service.b.f100913b.dataReport("ds_goods_card_exp_duration", f16, true);
        g.d("ds_goods_card_exp_duration", f16);
    }

    public final void d(b reportParams, Map<String, String> ext) {
        Map<Object, ? extends Object> f16 = reportParams.z().c(ext).f();
        cg0.a.b("GoodsCardReportHelper", "[reportViewExp] params = " + f16);
        com.tencent.ecommerce.base.report.service.b.f100913b.dataReport("ds_goods_card_exp", f16, true);
        g.d("ds_goods_card_exp", f16);
    }
}
