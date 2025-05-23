package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverViewAttr extends k {
    public QPPromoteReceiverViewModel viewModel;

    public final QPPromoteReceiverViewModel getViewModel() {
        QPPromoteReceiverViewModel qPPromoteReceiverViewModel = this.viewModel;
        if (qPPromoteReceiverViewModel != null) {
            return qPPromoteReceiverViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
