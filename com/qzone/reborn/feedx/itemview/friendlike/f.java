package com.qzone.reborn.feedx.itemview.friendlike;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.FrdHotVideoSubFeedInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b \u0010!J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/friendlike/f;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/qzone/reborn/feedx/itemview/friendlike/f$a;", "", "Lcom/qzone/proxy/feedcomponent/model/i;", "newDataList", "", "positionInQZoneFeed", "", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "j0", "holder", "position", "i0", "l0", "k0", "getItemCount", "Lcom/qzone/reborn/feedx/itemview/friendlike/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/itemview/friendlike/h;", "getVideoPlayController", "()Lcom/qzone/reborn/feedx/itemview/friendlike/h;", "videoPlayController", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "curDataList", "D", "I", "<init>", "(Lcom/qzone/reborn/feedx/itemview/friendlike/h;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private final List<FrdHotVideoSubFeedInfo> curDataList;

    /* renamed from: D, reason: from kotlin metadata */
    private int positionInQZoneFeed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final h videoPlayController;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/friendlike/f$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoItemLayout;", "E", "Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoItemLayout;", "l", "()Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoItemLayout;", "videoItemLayout", "<init>", "(Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoItemLayout;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final QZoneFrdHotVideoItemLayout videoItemLayout;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(QZoneFrdHotVideoItemLayout videoItemLayout) {
            super(videoItemLayout);
            Intrinsics.checkNotNullParameter(videoItemLayout, "videoItemLayout");
            this.videoItemLayout = videoItemLayout;
        }

        /* renamed from: l, reason: from getter */
        public final QZoneFrdHotVideoItemLayout getVideoItemLayout() {
            return this.videoItemLayout;
        }
    }

    public f(h videoPlayController) {
        Intrinsics.checkNotNullParameter(videoPlayController, "videoPlayController");
        this.videoPlayController = videoPlayController;
        this.curDataList = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.curDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getVideoItemLayout().m(this.curDataList.get(position), position, this.positionInQZoneFeed);
        this.videoPlayController.f(holder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new a(new QZoneFrdHotVideoItemLayout(context));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        holder.getVideoItemLayout().onAttachToRecyclerView();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        holder.getVideoItemLayout().onDetachFromRecyclerView();
    }

    public final void m0(List<FrdHotVideoSubFeedInfo> newDataList, int positionInQZoneFeed) {
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        this.videoPlayController.onStartRefreshData();
        this.positionInQZoneFeed = positionInQZoneFeed;
        List<FrdHotVideoSubFeedInfo> list = this.curDataList;
        list.clear();
        list.addAll(newDataList);
        notifyDataSetChanged();
    }
}
