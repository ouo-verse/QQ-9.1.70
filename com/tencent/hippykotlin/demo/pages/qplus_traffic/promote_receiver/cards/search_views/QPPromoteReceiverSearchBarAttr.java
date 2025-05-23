package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitPageModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverSearchBarAttr extends k {
    public final String groupDefaultAvatar = "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/sNUq1Yzn.png";
    public final String userDefaultAvatar = "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/nLY3LmQK.png";
    public QPPromoteReceiverPortraitPageModel viewModel;

    public final QPPromoteReceiverPortraitPageModel getViewModel() {
        QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel = this.viewModel;
        if (qPPromoteReceiverPortraitPageModel != null) {
            return qPPromoteReceiverPortraitPageModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
