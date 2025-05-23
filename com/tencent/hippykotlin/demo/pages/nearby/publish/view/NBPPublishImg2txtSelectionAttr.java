package com.tencent.hippykotlin.demo.pages.nearby.publish.view;

import com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPPublishImg2txtSelectionAttr extends k {
    public NBPPublishViewModel viewModel;

    public final NBPPublishViewModel getViewModel() {
        NBPPublishViewModel nBPPublishViewModel = this.viewModel;
        if (nBPPublishViewModel != null) {
            return nBPPublishViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
