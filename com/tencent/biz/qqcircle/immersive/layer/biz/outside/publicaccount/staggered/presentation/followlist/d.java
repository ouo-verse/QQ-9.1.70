package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountFollowUsersItemView;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewholder.QFSPublicAccountFollowUsersItemViewFactory;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u0011\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b%\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0014R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/d;", "Lcom/tencent/biz/qqcircle/bizparts/a;", "Lfeedcloud/FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;", "rsp", "", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", "Landroid/os/Bundle;", "p0", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadData", "getViewTypeCount", "getItemViewType", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "getLogTag", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "rspList", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountFollowUsersItemView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountFollowUsersItemView;", "headerItemView", "arguments", "<init>", "(Landroid/os/Bundle;)V", "D", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d extends com.tencent.biz.qqcircle.bizparts.a<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QFSPublicAccountFollowUsersItemView headerItemView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp> rspList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/d$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Lfeedcloud/FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;", "E", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "l", "()Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "staggeredItemView", "<init>", "(Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QCircleBaseWidgetView<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp> staggeredItemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull QCircleBaseWidgetView<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp> staggeredItemView) {
            super(staggeredItemView);
            Intrinsics.checkNotNullParameter(staggeredItemView, "staggeredItemView");
            this.staggeredItemView = staggeredItemView;
        }

        @NotNull
        public final QCircleBaseWidgetView<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp> l() {
            return this.staggeredItemView;
        }
    }

    public d(@Nullable Bundle bundle) {
        super(bundle);
        this.rspList = new ArrayList();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.rspList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return QFSPublicAccountFollowUsersItemViewFactory.ItemType.FOLLOW_USERS_ITEM_TYPE.getType();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    protected String getLogTag() {
        return "QFSPublicAccountFollowUsersAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return QFSPublicAccountFollowUsersItemViewFactory.f87121a.c();
    }

    public final void i0(@NotNull FeedCloudOfficialaccount$OfficialTopFollowUsersRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        QLog.d(getLogTag(), 1, "setData");
        this.rspList.clear();
        this.rspList.add(rsp);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QCircleBaseWidgetView<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp> l3 = ((b) holder).l();
        Intrinsics.checkNotNull(l3, "null cannot be cast to non-null type com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountFollowUsersItemView");
        QFSPublicAccountFollowUsersItemView qFSPublicAccountFollowUsersItemView = (QFSPublicAccountFollowUsersItemView) l3;
        if (qFSPublicAccountFollowUsersItemView.getData() == null) {
            qFSPublicAccountFollowUsersItemView.setData(this.rspList.get(position), position);
            qFSPublicAccountFollowUsersItemView.m0(this.rspList.get(position));
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        QFSPublicAccountFollowUsersItemView qFSPublicAccountFollowUsersItemView = this.headerItemView;
        if (qFSPublicAccountFollowUsersItemView == null) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            qFSPublicAccountFollowUsersItemView = new QFSPublicAccountFollowUsersItemView(context);
            this.headerItemView = qFSPublicAccountFollowUsersItemView;
        }
        return new b(qFSPublicAccountFollowUsersItemView);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        QFSPublicAccountFollowUsersItemView qFSPublicAccountFollowUsersItemView = this.headerItemView;
        if (qFSPublicAccountFollowUsersItemView != null) {
            qFSPublicAccountFollowUsersItemView.destroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(@Nullable LoadInfo p06) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle p06) {
    }
}
