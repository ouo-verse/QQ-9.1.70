package com.tencent.mobileqq.qqecommerce.base.somanager;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/somanager/a;", "", "", "params", "", "a", "Lcom/tencent/mobileqq/qqecommerce/base/somanager/b;", "Lcom/tencent/mobileqq/qqecommerce/base/somanager/b;", "showPageCostTimeModel", "Lcom/tencent/mobileqq/qqecommerce/base/somanager/ECShowPageCostTimeScene;", "scene", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/base/somanager/ECShowPageCostTimeScene;)V", "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b showPageCostTimeModel;

    public a(ECShowPageCostTimeScene scene) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(scene, "scene");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("scene", Integer.valueOf(scene.getValue())));
        this.showPageCostTimeModel = new b("ec_quality_show_page_cost_time", mapOf);
    }

    public final void a(Map<Object, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.showPageCostTimeModel.a(params);
    }
}
