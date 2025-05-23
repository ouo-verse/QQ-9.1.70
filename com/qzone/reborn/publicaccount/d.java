package com.qzone.reborn.publicaccount;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.scroller.QZoneFeedPlayScroller;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u0011\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/publicaccount/d;", "Lwe/b;", "Lmm/a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/qzone/reborn/publicaccount/d$b;", "q0", "Landroid/os/Bundle;", "bundle", "", "onInitBlock", "", "Lhh/b;", "l0", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "loadMoreData", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "onBindViewHolder", "getItemCount", "getViewTypeCount", "getItemViewType", "Lcom/qzone/reborn/publicaccount/g;", "D", "Lcom/qzone/reborn/publicaccount/g;", "mMsgListViewModel", "initParams", "<init>", "(Landroid/os/Bundle;)V", "E", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends we.b<mm.a> {

    /* renamed from: D, reason: from kotlin metadata */
    private g mMsgListViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/publicaccount/d$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lmm/a;", "data", "", "position", "", "l", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "itemView", "<init>", "(Lcom/qzone/reborn/widget/QZoneBaseWidgetView;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(QZoneBaseWidgetView<? super mm.a> itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void l(mm.a data, int position) {
            View view = this.itemView;
            QZoneBaseWidgetView qZoneBaseWidgetView = view instanceof QZoneBaseWidgetView ? (QZoneBaseWidgetView) view : null;
            if (qZoneBaseWidgetView != null) {
                qZoneBaseWidgetView.setData(data, position);
            }
        }
    }

    public d(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return h.f58778a.a(getItem(position));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return h.f58778a.c();
    }

    @Override // we.b
    protected List<hh.b> l0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QZoneFeedPlayScroller());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
        Intrinsics.checkNotNullParameter(loadInfo, "loadInfo");
        g gVar = this.mMsgListViewModel;
        if (gVar != null) {
            gVar.loadMore();
        }
    }

    @Override // we.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        if (holder instanceof b) {
            ((b) holder).l(getItem(position), position);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        this.mMsgListViewModel = (g) getViewModel(g.class);
    }

    @Override // com.qzone.reborn.base.j
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public b onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        h hVar = h.f58778a;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new b(hVar.b(context, viewType));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        g gVar;
        if (loadInfo != null) {
            if (loadInfo.isInitState()) {
                g gVar2 = this.mMsgListViewModel;
                if (gVar2 != null) {
                    gVar2.init();
                    return;
                }
                return;
            }
            if (!loadInfo.isRefreshState() || (gVar = this.mMsgListViewModel) == null) {
                return;
            }
            gVar.refresh();
        }
    }
}
