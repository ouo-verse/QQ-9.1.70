package com.tencent.hippykotlin.demo.pages.goods_center.shell;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public class GoodsCenterPendantAttr extends k {
    public IGoodsCenterPendantViewModel viewModel;

    public final IGoodsCenterPendantViewModel getViewModel() {
        IGoodsCenterPendantViewModel iGoodsCenterPendantViewModel = this.viewModel;
        if (iGoodsCenterPendantViewModel != null) {
            return iGoodsCenterPendantViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
