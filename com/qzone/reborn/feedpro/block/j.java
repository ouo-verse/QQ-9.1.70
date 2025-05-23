package com.qzone.reborn.feedpro.block;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.reborn.feedpro.widget.userhome.QzoneFeedProFeedCountContainerView;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0014R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/feedpro/block/j;", "Lcom/qzone/reborn/base/m;", "Landroid/os/Bundle;", "initParams", "", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Lcom/tencent/biz/richframework/part/PartManager;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/richframework/part/PartManager;", "partManager", "<init>", "(Landroid/os/Bundle;Lcom/tencent/biz/richframework/part/PartManager;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j extends com.qzone.reborn.base.m {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final PartManager partManager;

    public j(Bundle bundle, PartManager partManager) {
        super(bundle);
        this.partManager = partManager;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> adapter) {
        QzoneFeedProFeedCountContainerView qzoneFeedProFeedCountContainerView = new QzoneFeedProFeedCountContainerView(getActivity(), this, i0(), this.partManager);
        qzoneFeedProFeedCountContainerView.setHostActivity(getActivity());
        qzoneFeedProFeedCountContainerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return qzoneFeedProFeedCountContainerView;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
    }
}
