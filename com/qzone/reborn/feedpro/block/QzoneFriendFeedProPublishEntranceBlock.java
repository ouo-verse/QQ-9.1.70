package com.qzone.reborn.feedpro.block;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.part.BaseListAdapterIOCKt;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0014\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedpro/block/QzoneFriendFeedProPublishEntranceBlock;", "Lcom/qzone/reborn/base/m;", "Landroid/os/Bundle;", "initParams", "", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "p1", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "", "createBlockRootView", "<init>", "(Landroid/os/Bundle;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFriendFeedProPublishEntranceBlock extends com.qzone.reborn.base.m {
    public QzoneFriendFeedProPublishEntranceBlock(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<Object> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> p16) {
        QzoneFriendFeedProPublishEntranceBlock$createBlockRootView$publishBarView$1 qzoneFriendFeedProPublishEntranceBlock$createBlockRootView$publishBarView$1 = new QzoneFriendFeedProPublishEntranceBlock$createBlockRootView$publishBarView$1(getActivity());
        qzoneFriendFeedProPublishEntranceBlock$createBlockRootView$publishBarView$1.setHostActivity(getActivity());
        com.qzone.reborn.util.r rVar = com.qzone.reborn.util.r.f59560a;
        qzoneFriendFeedProPublishEntranceBlock$createBlockRootView$publishBarView$1.setLayoutParams(new FrameLayout.LayoutParams(-1, rVar.e(48)));
        qzoneFriendFeedProPublishEntranceBlock$createBlockRootView$publishBarView$1.setPadding(rVar.e(16), 0, rVar.e(16), 0);
        BaseListAdapterIOCKt.registerIoc(this, qzoneFriendFeedProPublishEntranceBlock$createBlockRootView$publishBarView$1, com.qzone.reborn.feedpro.widget.header.a.class);
        return qzoneFriendFeedProPublishEntranceBlock$createBlockRootView$publishBarView$1;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
    }
}
