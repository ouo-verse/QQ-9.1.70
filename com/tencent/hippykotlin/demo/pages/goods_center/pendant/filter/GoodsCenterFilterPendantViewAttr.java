package com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter;

import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantAttr;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes31.dex */
public final class GoodsCenterFilterPendantViewAttr extends GoodsCenterPendantAttr {
    public final Lazy positionTop$delegate;

    public GoodsCenterFilterPendantViewAttr() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantViewAttr$positionTop$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(((GoodsCenterFilterPendantViewAttr.this.getPagerData().getNavigationBarHeight() + 52.0f) - 45.0f) + 44.0f + 36.0f);
            }
        });
        this.positionTop$delegate = lazy;
    }
}
