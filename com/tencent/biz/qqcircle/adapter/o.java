package com.tencent.biz.qqcircle.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class o extends e implements SimpleEventReceiver {
    private RecyclerView.LayoutManager G;
    private int H;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }

        private boolean l(e30.b bVar) {
            FeedCloudMeta$StFeed g16;
            View view = this.itemView;
            if (!(view instanceof BaseWidgetView) || !(((BaseWidgetView) view).getData() instanceof e30.b) || (g16 = ((e30.b) ((BaseWidgetView) this.itemView).getData()).g()) == null || bVar.g() == null || TextUtils.isEmpty(g16.f398449id.get()) || !g16.f398449id.get().equals(bVar.g().f398449id.get()) || g16.likeInfo.count.get() != bVar.g().likeInfo.count.get()) {
                return false;
            }
            return true;
        }

        public void m(e30.b bVar, QCircleExtraTypeInfo qCircleExtraTypeInfo, int i3) {
            if (l(bVar)) {
                return;
            }
            View view = this.itemView;
            if (!(view instanceof QCircleWaterfallFeedItemView)) {
                QLog.i("QCircleWaterfallFeedsBlock", 1, "itemView != QCircleWaterfallFeedItemView");
                return;
            }
            ((QCircleWaterfallFeedItemView) view).setExtraTypeInfo(qCircleExtraTypeInfo);
            ((QCircleWaterfallFeedItemView) this.itemView).setData(bVar, i3);
            ((QCircleWaterfallFeedItemView) this.itemView).setDataPosInList(i3);
            ((QCircleWaterfallFeedItemView) this.itemView).setExtraTypeInfo(o.this.f82646m);
            ((QCircleWaterfallFeedItemView) this.itemView).setInteractor(o.this.getInteractor());
        }
    }

    public o(Bundle bundle) {
        super(bundle);
    }

    private void u0() {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() != 0 && ((e30.b) this.mDataList.get(0)).g().dittoFeed.dittoId.get() == 10) {
            this.mDataList.remove(0);
            QLog.i("QCircleWaterfallFeedsBlock", 1, "checkRemoveHeaderTianShuBanner  remove tianshu banner");
        }
    }

    private void v0(@NonNull QFSLayerFeedPosSyncEvent qFSLayerFeedPosSyncEvent) {
        QLog.d("QCircleWaterfallFeedsBlock", 4, "QFSLayerFeedPosSyncEvent position = " + qFSLayerFeedPosSyncEvent.getPos());
        QCircleBaseFragment qCircleBaseFragment = QCirclePluginUtil.getQCircleBaseFragment(getContext());
        if (qCircleBaseFragment != null && qFSLayerFeedPosSyncEvent.getPageCode() == qCircleBaseFragment.hashCode()) {
            com.tencent.biz.qqcircle.immersive.utils.ad.f(getDataList(), this.mRecyclerView, null, qFSLayerFeedPosSyncEvent);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSLayerFeedPosSyncEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() > i3) {
            FeedCloudMeta$StFeed g16 = ((e30.b) this.mDataList.get(i3)).g();
            if (g16.dittoFeed.dittoId.get() != 0) {
                QLog.i("QCircleWaterfallFeedsBlock", 1, "getItemViewType()  return 0 , data.dittoFeed.dittoId = " + g16.dittoFeed.dittoId.get() + " , position = " + i3);
                return 0;
            }
            QLog.i("QCircleWaterfallFeedsBlock", 1, "getItemViewType()  return " + g16.type.get());
            return g16.type.get();
        }
        QLog.e("QCircleWaterfallFeedsBlock", 1, "getItemViewType()  return 0");
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QCircleWaterfallFeedsBlock";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getSpanCount(int i3) {
        return 2;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public String getUniqueKey() {
        return "WATERFALL_ADAPTER_UNIQUE_KEY";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.tencent.biz.qqcircle.adapter.e, com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.G = recyclerView.getLayoutManager();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (ab0.a.a(i3, getDataList())) {
            return;
        }
        ((b) viewHolder).m(getDataList().get(i3), getQCircleExtraTypeInfo(), i3);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 != 2 && i3 != 3) {
            QLog.e("QCircleWaterfallFeedsBlock", 2, "onCreateViewHolder()  return new QCircleDefaultFeedWidget()");
            return new b(new QCircleDefaultFeedItemView(getContext(), i3));
        }
        QLog.i("QCircleWaterfallFeedsBlock", 1, "onCreateViewHolder()  viewType = " + i3);
        QCircleWaterfallFeedItemView qCircleWaterfallFeedItemView = new QCircleWaterfallFeedItemView(viewGroup.getContext());
        qCircleWaterfallFeedItemView.setReportBean(getReportBean());
        qCircleWaterfallFeedItemView.setViewType(this.H);
        return new b(qCircleWaterfallFeedItemView);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        getParentRecyclerView().setClipToPadding(false);
        getParentRecyclerView().setClipChildren(false);
        getParentRecyclerView().setPadding(cx.a(4.0f), 0, cx.a(4.0f), 0);
        getParentRecyclerView().addOnScrollListener(new a());
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.adapter.e, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSLayerFeedPosSyncEvent) {
            v0((QFSLayerFeedPosSyncEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List<e30.b> list) {
        this.mDataList.clear();
        if (list == null) {
            notifyDataSetChanged();
            return;
        }
        this.mDataList.addAll(list);
        u0();
        notifyItemRangeChanged(0, list.size());
        p0();
    }

    public o w0(int i3) {
        this.H = i3;
        return this;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (o.this.G instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) o.this.G;
                int columnCountForAccessibility = staggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
                if (columnCountForAccessibility <= 0) {
                    QLog.e("QCircleWaterfallFeedsBlock", 2, "columnCount invalid");
                    return;
                }
                int[] iArr = new int[columnCountForAccessibility];
                staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
                if (Math.min(o.this.getLocalPosition(iArr[0]), o.this.getLocalPosition(iArr[1])) <= 0) {
                    staggeredGridLayoutManager.invalidateSpanAssignments();
                    QLog.d("QCircleWaterfallFeedsBlock", 2, "invalidateSpanAssignments occur!");
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        }
    }
}
