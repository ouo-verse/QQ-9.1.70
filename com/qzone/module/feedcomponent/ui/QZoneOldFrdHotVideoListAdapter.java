package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.FrdHotVideoSubFeedInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoListAdapter$FrdHotVideoViewHolder;", "", "Lcom/qzone/proxy/feedcomponent/model/i;", "newDataList", "", "setDataList", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoAutoPlayController;", "autoPlayController", "Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoAutoPlayController;", "getAutoPlayController", "()Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoAutoPlayController;", "", "curDataList", "Ljava/util/List;", "<init>", "(Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoAutoPlayController;)V", "FrdHotVideoViewHolder", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class QZoneOldFrdHotVideoListAdapter extends RecyclerView.Adapter<FrdHotVideoViewHolder> {
    private final QZoneOldFrdHotVideoAutoPlayController autoPlayController;
    private final List<FrdHotVideoSubFeedInfo> curDataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoListAdapter$FrdHotVideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "videoItemView", "Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoItemView;", "(Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoItemView;)V", "getVideoItemView", "()Lcom/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoItemView;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class FrdHotVideoViewHolder extends RecyclerView.ViewHolder {
        private final QZoneOldFrdHotVideoItemView videoItemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrdHotVideoViewHolder(QZoneOldFrdHotVideoItemView videoItemView) {
            super(videoItemView);
            Intrinsics.checkNotNullParameter(videoItemView, "videoItemView");
            this.videoItemView = videoItemView;
        }

        public final QZoneOldFrdHotVideoItemView getVideoItemView() {
            return this.videoItemView;
        }
    }

    public QZoneOldFrdHotVideoListAdapter(QZoneOldFrdHotVideoAutoPlayController autoPlayController) {
        Intrinsics.checkNotNullParameter(autoPlayController, "autoPlayController");
        this.autoPlayController = autoPlayController;
        this.curDataList = new ArrayList();
    }

    public final QZoneOldFrdHotVideoAutoPlayController getAutoPlayController() {
        return this.autoPlayController;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.curDataList.size();
    }

    public final void setDataList(List<FrdHotVideoSubFeedInfo> newDataList) {
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        this.autoPlayController.onStartRefreshData();
        List<FrdHotVideoSubFeedInfo> list = this.curDataList;
        list.clear();
        list.addAll(newDataList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(FrdHotVideoViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getVideoItemView().updateData(this.curDataList.get(position), position);
        this.autoPlayController.onBindViewHolder(holder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public FrdHotVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new FrdHotVideoViewHolder(new QZoneOldFrdHotVideoItemView(context));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(FrdHotVideoViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow((QZoneOldFrdHotVideoListAdapter) holder);
        holder.getVideoItemView().onAttachToRecyclerView();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(FrdHotVideoViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow((QZoneOldFrdHotVideoListAdapter) holder);
        holder.getVideoItemView().onDetachFromRecyclerView();
    }
}
