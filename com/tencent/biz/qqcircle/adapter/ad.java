package com.tencent.biz.qqcircle.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectScrollProcessor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSRecyclerViewScrollEvent;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.immersive.scrollers.QFSMixFeedPlayScroller;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedTalentPeopleView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StItemContainer;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ad extends e implements SimpleEventReceiver {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        public void d(int i3, int i16) {
            QCircleAspectScrollProcessor.getInstance().onScrollPageIdState(i3, i16);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traversePage(recyclerView);
            }
            d(i3, ad.this.getPageId());
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }

        private boolean l(e30.b bVar) {
            e30.b bVar2;
            View view = this.itemView;
            if ((view instanceof BaseWidgetView) && (((BaseWidgetView) view).getData() instanceof e30.b) && (bVar2 = (e30.b) ((BaseWidgetView) this.itemView).getData()) != null && bVar2.g() != null && bVar.g() != null) {
                if (!TextUtils.isEmpty(bVar.g().f398449id.get())) {
                    if (!bVar2.g().f398449id.get().equals(bVar.g().f398449id.get()) || bVar2.g().likeInfo.count.get() != bVar.g().likeInfo.count.get()) {
                        return false;
                    }
                    return true;
                }
                int i3 = bVar.g().dittoFeed.dittoId.get();
                if (i3 == bVar2.g().dittoFeed.dittoId.get() && i3 == 22) {
                    return ad.this.x0(bVar, bVar2);
                }
            }
            return false;
        }

        public void m(e30.b bVar, QCircleExtraTypeInfo qCircleExtraTypeInfo, int i3) {
            if (l(bVar)) {
                return;
            }
            View view = this.itemView;
            if (!(view instanceof QCircleBaseWidgetView)) {
                QLog.i("QFSMixFeedsBlock", 1, "itemView != QCircleWaterfallFeedItemView");
                return;
            }
            ((QCircleBaseWidgetView) view).setExtraTypeInfo(qCircleExtraTypeInfo);
            ((QCircleBaseWidgetView) this.itemView).setExtraTypeInfo(ad.this.f82646m);
            ((QCircleBaseWidgetView) this.itemView).setData(bVar, i3);
            ((QCircleBaseWidgetView) this.itemView).setDataPosInList(i3);
            View view2 = this.itemView;
            if (view2 instanceof QFSMixFeedTalentPeopleView) {
                ((QFSMixFeedTalentPeopleView) view2).setPageId(ad.this.f82646m.mSubPageId);
            }
        }
    }

    public ad(Bundle bundle) {
        super(bundle);
    }

    private void v0(@NonNull QFSLayerFeedPosSyncEvent qFSLayerFeedPosSyncEvent) {
        QLog.d("QFSMixFeedsBlock", 4, "QFSLayerFeedPosSyncEvent position = " + qFSLayerFeedPosSyncEvent.getPos() + "feedId =" + qFSLayerFeedPosSyncEvent.getFeedId());
        QCircleBaseFragment qCircleBaseFragment = QCirclePluginUtil.getQCircleBaseFragment(getContext());
        if (this.f82646m != null && qCircleBaseFragment != null && qFSLayerFeedPosSyncEvent.getPageCode() == qCircleBaseFragment.hashCode()) {
            com.tencent.biz.qqcircle.immersive.utils.ad.g(getDataList(), this.mRecyclerView, null, qFSLayerFeedPosSyncEvent, isEnableRefresh() ? 1 : 0);
        }
    }

    private void w0(QFSRecyclerViewScrollEvent qFSRecyclerViewScrollEvent) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && qFSRecyclerViewScrollEvent != null) {
            recyclerView.getLocationOnScreen(new int[2]);
            this.mRecyclerView.smoothScrollBy(0, (int) (qFSRecyclerViewScrollEvent.mDistanceY - r1[1]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x0(e30.b bVar, e30.b bVar2) {
        QQCircleDitto$StItemContainer i3;
        QQCircleDitto$StItemContainer i16 = com.tencent.biz.qqcircle.immersive.views.mixfeed.d.i(bVar, String.valueOf(22));
        if (i16 != null && i16.items.size() >= 1 && (i3 = com.tencent.biz.qqcircle.immersive.views.mixfeed.d.i(bVar2, String.valueOf(22))) != null && i3.items.size() >= 1 && i16.items.get().size() >= 1 && i3.items.get().size() >= 1) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = i16.items.get(0).feeds.get(0);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = i3.items.get(0).feeds.get(0);
            if (feedCloudMeta$StFeed != null && bVar2 != null) {
                return feedCloudMeta$StFeed.f398449id.get().equals(feedCloudMeta$StFeed2.f398449id.get());
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSLayerFeedPosSyncEvent.class);
        arrayList.add(QFSRecyclerViewScrollEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public BaseWidgetView.IInteractor getInteractor() {
        if (this.mInteractor == null) {
            this.mInteractor = (BaseWidgetView.IInteractor) getIocInterface(j20.a.class);
        }
        return this.mInteractor;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        FeedCloudMeta$StFeed g16;
        if (getItem(i3) == null) {
            g16 = null;
        } else {
            g16 = getItem(i3).g();
        }
        return com.tencent.biz.qqcircle.immersive.views.mixfeed.d.c(g16);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSMixFeedsBlock";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getSpanCount(int i3) {
        return com.tencent.biz.qqcircle.immersive.views.mixfeed.d.d(getItemViewType(i3));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public String getUniqueKey() {
        return "WATERFALL_MIX_FEED_ADAPTER_UNIQUE_KEY";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return com.tencent.biz.qqcircle.immersive.views.mixfeed.d.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.adapter.e
    public List<com.tencent.biz.qqcircle.scrollers.a> k0() {
        List<com.tencent.biz.qqcircle.scrollers.a> k06;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_mix_feeds_block_pic_preload", true)) {
            k06 = new ArrayList<>();
        } else {
            k06 = super.k0();
        }
        k06.add(new QFSMixFeedPlayScroller());
        return k06;
    }

    @Override // com.tencent.biz.qqcircle.adapter.e, com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof b) {
            ((b) viewHolder).m(getItem(i3), getQCircleExtraTypeInfo(), i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new b(com.tencent.biz.qqcircle.immersive.views.mixfeed.d.a(viewGroup, i3));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        if (getParentRecyclerView() == null) {
            return;
        }
        getParentRecyclerView().setClipToPadding(false);
        getParentRecyclerView().setClipChildren(false);
        getParentRecyclerView().setPadding(cx.a(4.0f), 0, cx.a(4.0f), 0);
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
        } else if (simpleBaseEvent instanceof QFSRecyclerViewScrollEvent) {
            w0((QFSRecyclerViewScrollEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
