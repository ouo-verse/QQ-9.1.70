package com.tencent.hippykotlin.demo.pages.qplus_traffic.shell;

import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeCardAttr extends k {
    public IQPlusTrafficCardHomeViewModel viewModel;

    public final IQPlusTrafficCardHomeViewModel getViewModel() {
        IQPlusTrafficCardHomeViewModel iQPlusTrafficCardHomeViewModel = this.viewModel;
        if (iQPlusTrafficCardHomeViewModel != null) {
            return iQPlusTrafficCardHomeViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
