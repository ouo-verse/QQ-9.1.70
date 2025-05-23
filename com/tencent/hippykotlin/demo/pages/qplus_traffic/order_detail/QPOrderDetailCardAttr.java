package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailCardAttr extends k {
    public IQPOrderDetailCardViewModel viewModel;

    public final IQPOrderDetailCardViewModel getViewModel() {
        IQPOrderDetailCardViewModel iQPOrderDetailCardViewModel = this.viewModel;
        if (iQPOrderDetailCardViewModel != null) {
            return iQPOrderDetailCardViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
