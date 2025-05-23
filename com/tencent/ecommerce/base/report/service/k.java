package com.tencent.ecommerce.base.report.service;

import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0002J&\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/k;", "", "", "params", "", "b", "", QzoneIPCModule.RESULT_CODE, "a", "Lcom/tencent/ecommerce/base/report/service/l;", "Lcom/tencent/ecommerce/base/report/service/l;", "showPageCostTimeModel", "Lcom/tencent/ecommerce/base/report/service/ECShowPageCostTimeScene;", "scene", "<init>", "(Lcom/tencent/ecommerce/base/report/service/ECShowPageCostTimeScene;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final l showPageCostTimeModel;

    public k(ECShowPageCostTimeScene eCShowPageCostTimeScene) {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("scene", Integer.valueOf(eCShowPageCostTimeScene.value)));
        this.showPageCostTimeModel = new l("ec_quality_show_page_cost_time", mapOf);
    }

    public final void b(Map<Object, ? extends Object> params) {
        this.showPageCostTimeModel.a(params);
    }

    public final void a(int resultCode, Map<Object, ? extends Object> params) {
        Map<Object, ? extends Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_code", Integer.valueOf(resultCode)));
        if (params != null) {
            mutableMapOf.putAll(params);
        }
        this.showPageCostTimeModel.a(mutableMapOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(k kVar, int i3, Map map, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            map = null;
        }
        kVar.a(i3, map);
    }
}
