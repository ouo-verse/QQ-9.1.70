package com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort;

import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantAttr;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes31.dex */
public final class GoodsCenterSortPendantViewAttr extends GoodsCenterPendantAttr {
    public final Lazy positionTop$delegate;

    public GoodsCenterSortPendantViewAttr() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort.GoodsCenterSortPendantViewAttr$positionTop$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(((GoodsCenterSortPendantViewAttr.this.getPagerData().getNavigationBarHeight() + 52.0f) - 45.0f) + 44.0f);
            }
        });
        this.positionTop$delegate = lazy;
    }
}
