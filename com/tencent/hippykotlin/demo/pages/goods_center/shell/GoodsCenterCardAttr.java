package com.tencent.hippykotlin.demo.pages.goods_center.shell;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public class GoodsCenterCardAttr extends k {
    public IGoodsCenterCardViewModel viewModel;

    public final IGoodsCenterCardViewModel getViewModel() {
        IGoodsCenterCardViewModel iGoodsCenterCardViewModel = this.viewModel;
        if (iGoodsCenterCardViewModel != null) {
            return iGoodsCenterCardViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
