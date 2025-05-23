package p80;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchAdFeedbackEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchOpenCommentPanelEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchShowShareSheetEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSTransitionChangeLocationEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.views.search.event.QFSSearchCheckPlayEvent;
import com.tencent.biz.qqcircle.immersive.views.search.feed.QFSSearchFeedResultItemView;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import e80.h;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import p70.i;
import p80.a;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.bizparts.a<e30.b> implements SimpleEventReceiver {
    private final Collection<WeakReference<c>> C;
    private final b D;
    protected QCircleExtraTypeInfo E;
    private QFSSearchInfo F;

    /* renamed from: m, reason: collision with root package name */
    private i f425696m;

    /* compiled from: P */
    /* renamed from: p80.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C10987a extends v30.a {
        C10987a() {
        }

        @Override // v30.a
        public boolean c(@NonNull e30.b bVar, @NonNull e30.b bVar2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements Observer<String> {

        /* renamed from: d, reason: collision with root package name */
        private int f425698d;

        /* renamed from: e, reason: collision with root package name */
        private final int[] f425699e = new int[2];

        /* renamed from: f, reason: collision with root package name */
        private final int[] f425700f = new int[2];

        /* renamed from: h, reason: collision with root package name */
        private final int[] f425701h = new int[2];

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: p80.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C10988a extends RecyclerView.OnScrollListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f425703d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f425704e;

            C10988a(int i3, int i16) {
                this.f425703d = i3;
                this.f425704e = i16;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
                if (i3 == 0) {
                    recyclerView.removeOnScrollListener(this);
                    b.this.k(recyclerView, this.f425703d, this.f425704e);
                }
            }
        }

        b() {
        }

        private int c(String str) {
            FeedCloudMeta$StFeed c16;
            int itemCount = a.this.getItemCount();
            for (int i3 = 0; i3 < itemCount; i3++) {
                e30.b item = a.this.getItem(i3);
                FeedCloudMeta$StFeed g16 = item.g();
                if (g16 != null && TextUtils.equals(str, g16.f398449id.get())) {
                    return i3;
                }
                if (p.w(g16) && (c16 = u.c(item)) != null && TextUtils.equals(str, c16.f398449id.get())) {
                    return i3;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(RecyclerView.ViewHolder viewHolder) {
            FeedCloudMeta$StFeed o06;
            View view = viewHolder.itemView;
            view.getLocationInWindow(this.f425701h);
            QFSTransitionChangeLocationEvent qFSTransitionChangeLocationEvent = new QFSTransitionChangeLocationEvent();
            qFSTransitionChangeLocationEvent.setLeft(this.f425701h[0]);
            qFSTransitionChangeLocationEvent.setTop(this.f425701h[1]);
            qFSTransitionChangeLocationEvent.setRight(this.f425701h[0] + view.getWidth());
            qFSTransitionChangeLocationEvent.setBottom(this.f425701h[1] + view.getHeight());
            if (a.this.f425696m != null) {
                qFSTransitionChangeLocationEvent.setPageCode(a.this.f425696m.hashCode());
            } else {
                qFSTransitionChangeLocationEvent.setPageCode(view.getContext().hashCode());
            }
            if ((view instanceof QFSSearchFeedResultItemView) && (o06 = ((QFSSearchFeedResultItemView) view).o0()) != null) {
                qFSTransitionChangeLocationEvent.setCoverUrl(o06.cover.picUrl.get());
            }
            SimpleEventBus.getInstance().dispatchEvent(qFSTransitionChangeLocationEvent);
        }

        private void i(RecyclerView recyclerView, int i3, int i16) {
            recyclerView.addOnScrollListener(new C10988a(i3, i16));
            recyclerView.smoothScrollToPosition(i3);
        }

        private void j(BlockContainer blockContainer, int i3, int i16) {
            QLog.d("QFSSearchFeedResultBlock", 1, "[scrollRecyclerViewToPosition] targetPos: " + i3 + "| align: " + i16);
            NestScrollRecyclerView recyclerView = blockContainer.getRecyclerView();
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (findFirstVisibleItemPosition <= i3 && findLastVisibleItemPosition >= i3) {
                    k(recyclerView, i3, i16);
                    return;
                }
            }
            i(recyclerView, i3, i16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(RecyclerView recyclerView, int i3, int i16) {
            final RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition == null) {
                return;
            }
            findViewHolderForAdapterPosition.itemView.getLocationOnScreen(this.f425700f);
            int[] iArr = this.f425700f;
            int i17 = iArr[1];
            iArr[0] = i17;
            iArr[1] = i17 + findViewHolderForAdapterPosition.itemView.getHeight();
            int[] iArr2 = this.f425700f;
            int i18 = iArr2[0];
            if (i18 == 0 && iArr2[1] == 0) {
                return;
            }
            int[] iArr3 = this.f425699e;
            int i19 = iArr3[0];
            int i26 = (iArr3[1] + i19) / 2;
            int i27 = (iArr2[1] + i18) / 2;
            if (i16 == 1) {
                recyclerView.scrollBy(0, i27 - i26);
            } else if (i16 == 0) {
                recyclerView.smoothScrollBy(0, i18 - i19);
            }
            recyclerView.post(new Runnable() { // from class: p80.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.this.d(findViewHolderForAdapterPosition);
                }
            });
        }

        private void l(BlockContainer blockContainer) {
            int[] iArr = this.f425699e;
            if (iArr[0] == 0 && iArr[1] == 0) {
                NestScrollRecyclerView recyclerView = blockContainer.getRecyclerView();
                recyclerView.getLocationOnScreen(this.f425699e);
                int[] iArr2 = this.f425699e;
                int i3 = iArr2[1];
                iArr2[0] = i3;
                iArr2[1] = i3 + recyclerView.getHeight();
            }
        }

        public void f(Integer num, int i3) {
            BlockContainer blockContainer;
            this.f425698d = num.intValue();
            BlockMerger blockMerger = a.this.getBlockMerger();
            if (blockMerger == null || (blockContainer = blockMerger.getBlockContainer()) == null) {
                return;
            }
            l(blockContainer);
            int itemCount = (blockMerger.getItemCount() - a.this.getItemCount()) + num.intValue();
            if (blockMerger.isEnableLoadMore()) {
                itemCount--;
            }
            if (itemCount >= 0 && itemCount < blockMerger.getItemCount()) {
                j(blockContainer, itemCount, i3);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            int c16 = c(str);
            if (c16 == this.f425698d) {
                return;
            }
            f(Integer.valueOf(c16), 1);
        }

        public void h() {
            if (a.this.f425696m == null) {
                return;
            }
            this.f425698d = c(a.this.f425696m.M1().getValue());
            a.this.f425696m.M1().observe(a.this.getParentFragment(), this);
        }

        public void m() {
            if (a.this.f425696m == null) {
                return;
            }
            a.this.f425696m.M1().removeObserver(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends RecyclerView.ViewHolder {
        public c(@NonNull View view) {
            super(view);
        }

        @Deprecated
        private boolean l(e30.b bVar) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            View view = this.itemView;
            if ((view instanceof BaseWidgetView) && (((BaseWidgetView) view).getData() instanceof FeedCloudMeta$StFeed) && (feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) ((BaseWidgetView) this.itemView).getData()) != null && bVar.g() != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.f398449id.get())) {
                return feedCloudMeta$StFeed.f398449id.get().equals(bVar.g().f398449id.get());
            }
            return false;
        }

        public void m(e30.b bVar, QCircleExtraTypeInfo qCircleExtraTypeInfo, int i3) {
            if (i3 == 0) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSSearchCheckPlayEvent());
            }
            if (l(bVar)) {
                KeyEvent.Callback callback = this.itemView;
                if (callback instanceof h) {
                    ((h) callback).H();
                    return;
                }
                return;
            }
            View view = this.itemView;
            if (!(view instanceof QFSSearchFeedResultItemView)) {
                QLog.w("QFSSearchFeedResultBlock", 1, "itemView != QFSSearchFeedResultItemView");
                return;
            }
            ((QFSSearchFeedResultItemView) view).setExtraTypeInfo(qCircleExtraTypeInfo);
            ((QFSSearchFeedResultItemView) this.itemView).setExtraTypeInfo(a.this.E);
            ((QFSSearchFeedResultItemView) this.itemView).setData(bVar, i3);
            ((QFSSearchFeedResultItemView) this.itemView).setDataPosInList(i3);
            ((QFSSearchFeedResultItemView) this.itemView).setInteractor(a.this.getInteractor());
        }
    }

    public a() {
        super(new Bundle());
        this.C = new ArrayList();
        this.D = new b();
    }

    private void j0(QFSSearchAdFeedbackEvent qFSSearchAdFeedbackEvent) {
        if (this.f425696m != null && getDataList() != null && !ab0.a.a(qFSSearchAdFeedbackEvent.getPos(), getDataList())) {
            this.f425696m.A2(getDataList().get(qFSSearchAdFeedbackEvent.getPos()));
        }
    }

    private void k0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        b bVar;
        if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.f398449id.get()) && getDataList() != null && getBlockContainer() != null && getBlockContainer().getRecyclerView() != null && (getBlockContainer().getRecyclerView().getLayoutManager() instanceof LinearLayoutManager)) {
            int itemCount = getBlockMerger().getItemCount() - getItemCount();
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getBlockContainer().getRecyclerView().getLayoutManager();
            int findFirstVisibleItemPosition = (linearLayoutManager.findFirstVisibleItemPosition() - itemCount) + 1;
            int findLastVisibleItemPosition = (linearLayoutManager.findLastVisibleItemPosition() - itemCount) + 2;
            for (int max = Math.max(findFirstVisibleItemPosition, 0); max < Math.min(findLastVisibleItemPosition, getDataList().size()); max++) {
                FeedCloudMeta$StFeed g16 = getItem(max).g();
                if (g16 != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), g16.f398449id.get()) && (bVar = this.D) != null) {
                    bVar.f(Integer.valueOf(max), 0);
                    return;
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    protected DiffUtil.ItemCallback<e30.b> getDiffCallBack() {
        return new C10987a();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSearchOpenCommentPanelEvent.class);
        arrayList.add(QFSSearchShowShareSheetEvent.class);
        arrayList.add(QFSSearchAdFeedbackEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (getDataList() == null || getItemCount() <= i3) {
            return 0;
        }
        FeedCloudMeta$StFeed g16 = getDataList().get(i3).g();
        if (g16.dittoFeed.dittoId.get() != 0 && !p.w(g16)) {
            return 0;
        }
        return g16.type.get();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSSearchFeedResultBlock";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public String getUniqueKey() {
        return "SEARCH_FEED_ADAPTER_UNIQUE_KEY";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    public void l0(QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        this.E = qCircleExtraTypeInfo;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (!ab0.a.a(i3, getDataList())) {
            c cVar = (c) viewHolder;
            View view = viewHolder.itemView;
            if (view instanceof QFSSearchFeedResultItemView) {
                QFSSearchFeedResultItemView qFSSearchFeedResultItemView = (QFSSearchFeedResultItemView) view;
                if (this.isOnResume) {
                    qFSSearchFeedResultItemView.u0(getActivity());
                } else {
                    qFSSearchFeedResultItemView.s0(getActivity());
                }
            }
            cVar.m(getDataList().get(i3), getQCircleExtraTypeInfo(), i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 != 2 && i3 != 3) {
            return new c(new QCircleDefaultFeedItemView(getContext(), i3));
        }
        QFSSearchFeedResultItemView qFSSearchFeedResultItemView = new QFSSearchFeedResultItemView(viewGroup.getContext());
        qFSSearchFeedResultItemView.setParentView(viewGroup);
        qFSSearchFeedResultItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qFSSearchFeedResultItemView.setReportBean(getReportBean());
        qFSSearchFeedResultItemView.setFragment(getParentFragment());
        qFSSearchFeedResultItemView.setSearchInfo(this.F);
        c cVar = new c(qFSSearchFeedResultItemView);
        this.C.add(new WeakReference<>(cVar));
        return cVar;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        this.f425696m = (i) getViewModel(i.class);
        getParentRecyclerView().setClipToPadding(false);
        getParentRecyclerView().setClipChildren(false);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.D.m();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.D.h();
        Iterator<WeakReference<c>> it = this.C.iterator();
        while (it.hasNext()) {
            c cVar = it.next().get();
            if (cVar != null) {
                View view = cVar.itemView;
                if (view instanceof QFSSearchFeedResultItemView) {
                    ((QFSSearchFeedResultItemView) view).s0(activity);
                }
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.D.m();
        Iterator<WeakReference<c>> it = this.C.iterator();
        while (it.hasNext()) {
            c cVar = it.next().get();
            if (cVar != null) {
                View view = cVar.itemView;
                if (view instanceof QFSSearchFeedResultItemView) {
                    ((QFSSearchFeedResultItemView) view).u0(activity);
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSearchOpenCommentPanelEvent) {
            QFSSearchOpenCommentPanelEvent qFSSearchOpenCommentPanelEvent = (QFSSearchOpenCommentPanelEvent) simpleBaseEvent;
            if (qFSSearchOpenCommentPanelEvent.getCommentInfo() != null && p.u(getContext(), qFSSearchOpenCommentPanelEvent.getContextHashCode())) {
                k0(qFSSearchOpenCommentPanelEvent.getCommentInfo().mFeed);
                return;
            }
        }
        if (simpleBaseEvent instanceof QFSSearchShowShareSheetEvent) {
            QFSSearchShowShareSheetEvent qFSSearchShowShareSheetEvent = (QFSSearchShowShareSheetEvent) simpleBaseEvent;
            if (qFSSearchShowShareSheetEvent.getShareInfo() != null && p.u(getContext(), qFSSearchShowShareSheetEvent.getContextHashCode())) {
                k0(qFSSearchShowShareSheetEvent.getShareInfo().feed);
                return;
            }
        }
        if (simpleBaseEvent instanceof QFSSearchAdFeedbackEvent) {
            j0((QFSSearchAdFeedbackEvent) simpleBaseEvent);
        }
    }

    public void setCurrentSearchInfo(QFSSearchInfo qFSSearchInfo) {
        this.F = qFSSearchInfo;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
