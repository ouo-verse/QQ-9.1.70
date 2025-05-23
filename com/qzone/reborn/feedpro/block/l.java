package com.qzone.reborn.feedpro.block;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.banner.hotbanner.QzoneFeedProHotBannerPageContainerView;
import com.qzone.reborn.feedpro.banner.hotbanner.item.FeedProBaseHotBanner;
import com.tencent.biz.richframework.part.BaseListAdapterIOCKt;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001$B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J$\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0014J\u0016\u0010\u0018\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/feedpro/block/l;", "Lcom/qzone/reborn/base/m;", "Lnd/b;", "Landroid/os/Bundle;", "initParams", "", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "i", "onBindViewHolder", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "", "Lcom/qzone/reborn/feedpro/banner/hotbanner/item/FeedProBaseHotBanner;", "banners", "J", "c0", "Lcom/qzone/reborn/feedpro/banner/hotbanner/QzoneFeedProHotBannerPageContainerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedpro/banner/hotbanner/QzoneFeedProHotBannerPageContainerView;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "bannerDataList", "<init>", "(Landroid/os/Bundle;)V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l extends com.qzone.reborn.base.m implements nd.b {

    /* renamed from: C, reason: from kotlin metadata */
    private List<FeedProBaseHotBanner> bannerDataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QzoneFeedProHotBannerPageContainerView containerView;

    public l(Bundle bundle) {
        super(bundle);
    }

    @Override // nd.b
    public void J(List<FeedProBaseHotBanner> banners) {
        Intrinsics.checkNotNullParameter(banners, "banners");
        this.bannerDataList = banners;
        setDatas(banners);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> adapter) {
        QzoneFeedProHotBannerPageContainerView qzoneFeedProHotBannerPageContainerView = new QzoneFeedProHotBannerPageContainerView(getActivity());
        this.containerView = qzoneFeedProHotBannerPageContainerView;
        Intrinsics.checkNotNull(qzoneFeedProHotBannerPageContainerView);
        qzoneFeedProHotBannerPageContainerView.setHostActivity(getActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        QzoneFeedProHotBannerPageContainerView qzoneFeedProHotBannerPageContainerView2 = this.containerView;
        Intrinsics.checkNotNull(qzoneFeedProHotBannerPageContainerView2);
        qzoneFeedProHotBannerPageContainerView2.setLayoutParams(layoutParams);
        QzoneFeedProHotBannerPageContainerView qzoneFeedProHotBannerPageContainerView3 = this.containerView;
        Intrinsics.checkNotNull(qzoneFeedProHotBannerPageContainerView3);
        return qzoneFeedProHotBannerPageContainerView3;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.onBindViewHolder(viewHolder, i3);
        List<FeedProBaseHotBanner> list = this.bannerDataList;
        if (list == null || list.isEmpty()) {
            QzoneFeedProHotBannerPageContainerView qzoneFeedProHotBannerPageContainerView = this.containerView;
            if (qzoneFeedProHotBannerPageContainerView == null) {
                return;
            }
            qzoneFeedProHotBannerPageContainerView.setData(null);
            return;
        }
        QzoneFeedProHotBannerPageContainerView qzoneFeedProHotBannerPageContainerView2 = this.containerView;
        if (qzoneFeedProHotBannerPageContainerView2 == null) {
            return;
        }
        List<FeedProBaseHotBanner> list2 = this.bannerDataList;
        Intrinsics.checkNotNull(list2);
        qzoneFeedProHotBannerPageContainerView2.setData(list2.get(0));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
        BaseListAdapterIOCKt.registerIoc(this, this, nd.b.class);
    }

    @Override // nd.b
    public void c0() {
        this.bannerDataList = null;
        setDatas(null);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
