package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPGuideNoviceFirstPageViewAttr extends k {
    public NBPGuideNoviceViewModel viewModel;

    public final NBPGuideNoviceViewModel getViewModel() {
        NBPGuideNoviceViewModel nBPGuideNoviceViewModel = this.viewModel;
        if (nBPGuideNoviceViewModel != null) {
            return nBPGuideNoviceViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
