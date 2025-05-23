package com.tencent.biz.qqcircle.widgets.pymk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.qqcircle.events.QFSPersonalEmptyProductPymkRefreshEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.helpers.k;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.viewmodels.e;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.pymk.QFSPYMKRecommendListView;
import com.tencent.biz.qqcircle.widgets.pymk.b;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StDittoFeed;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUserRecomInfo;
import feedcloud.FeedCloudRead$StGetRecomUserListRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import qc0.r;
import qqcircle.QQCircleDitto$StItemContainer;

/* loaded from: classes5.dex */
public class QFSPYMKRecommendListView extends QCircleBaseWidgetView implements SimpleEventReceiver {
    private boolean C;
    private QCircleBlockContainer D;

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.biz.qqcircle.widgets.pymk.b f93827d;

    /* renamed from: e, reason: collision with root package name */
    private r f93828e;

    /* renamed from: f, reason: collision with root package name */
    protected RecyclerView.LayoutManager f93829f;

    /* renamed from: h, reason: collision with root package name */
    protected QQCircleDitto$StItemContainer f93830h;

    /* renamed from: i, reason: collision with root package name */
    private e f93831i;

    /* renamed from: m, reason: collision with root package name */
    private String f93832m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements b.InterfaceC0940b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.pymk.b.InterfaceC0940b
        public void a() {
            if (QFSPYMKRecommendListView.this.f93831i != null) {
                QFSPYMKRecommendListView.this.f93832m = "";
                QFSPYMKRecommendListView.this.f93831i.M1("", QFSPYMKRecommendListView.this.f93832m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements NestScrollRecyclerView.NestScrollDelegate {
        c() {
        }

        @Override // com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView.NestScrollDelegate
        public float[] getChildOffsetXY() {
            return new float[2];
        }

        @Override // com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView.NestScrollDelegate
        public boolean isNestViewNotReachTop(RecyclerView recyclerView) {
            return cx.i(recyclerView, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d extends v.a {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("update_version_op_urge");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull w wVar) {
            if (QFSPYMKRecommendListView.this.D != null && QFSPYMKRecommendListView.this.D.getBlockMerger() != null && wVar.n()) {
                QFSPYMKRecommendListView.this.f93828e.i0(wVar);
                QFSPYMKRecommendListView.this.f93828e.setBlockVisible(true);
                QFSPYMKRecommendListView.this.f93827d.n0(h.a(R.string.f184093ky), true);
                return;
            }
            QFSPYMKRecommendListView.this.f93828e.setBlockVisible(false);
        }
    }

    public QFSPYMKRecommendListView(@NonNull Context context, Integer num) {
        super(context, num.intValue());
        this.C = false;
        w0(context);
    }

    private void A0(BaseListViewAdapter baseListViewAdapter, QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        if (baseListViewAdapter == null) {
            QLog.d("PYMK-QCirclePYMKRecommendListView", 1, "[setAdapterSource] recommend adapter should not be null.");
        } else if (qQCircleDitto$StItemContainer == null) {
            QLog.d("PYMK-QCirclePYMKRecommendListView", 1, "[setDataSource] container should not be null.");
        } else {
            QLog.d("PYMK-QCirclePYMKRecommendListView", 1, "[setAdapterSource] | itemSize: ", Integer.valueOf(qQCircleDitto$StItemContainer.items.size()));
        }
    }

    private void B0(e30.b bVar, int i3) {
        String str;
        VideoReport.setElementId(getRootView(), QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_BOX);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(ua0.c.d(bVar));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.f93830h;
        if (qQCircleDitto$StItemContainer == null) {
            str = "";
        } else {
            str = qQCircleDitto$StItemContainer.title.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_TITLE, str);
        VideoReport.setElementParams(getRootView(), buildElementParams);
    }

    private void r0(e30.b bVar, FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed) {
        if (bVar == null) {
            QLog.d("PYMK-QCirclePYMKRecommendListView", 1, "[fillContainerSource] blockData should not be null.");
            return;
        }
        if (feedCloudMeta$StDittoFeed == null) {
            QLog.d("PYMK-QCirclePYMKRecommendListView", 1, "[fillContainerSource] dittoFeed should not be null.");
            return;
        }
        try {
            this.f93830h = new QQCircleDitto$StItemContainer();
            Object b16 = bVar.b(String.valueOf(feedCloudMeta$StDittoFeed.dittoId.get()));
            if (b16 instanceof QQCircleDitto$StItemContainer) {
                this.f93830h = (QQCircleDitto$StItemContainer) b16;
                QLog.d("PYMK-QCirclePYMKRecommendListView", 4, "[bindData] get data from blockData");
            } else {
                this.f93830h.mergeFrom(feedCloudMeta$StDittoFeed.dittoData.get().toByteArray());
                QLog.d("PYMK-QCirclePYMKRecommendListView", 4, "[bindData] get data from merger");
            }
            A0(this.f93827d, this.f93830h);
        } catch (Exception e16) {
            QLog.e("PYMK-QCirclePYMKRecommendListView", 1, "[bindData] Exception:", e16);
        }
    }

    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r s0() {
        for (Fragment qCircleBaseFragment = getQCircleBaseFragment(); qCircleBaseFragment != null; qCircleBaseFragment = qCircleBaseFragment.getParentFragment()) {
            if (qCircleBaseFragment instanceof QFSPersonalDetailsFragment) {
                return (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) ((QFSPersonalDetailsFragment) qCircleBaseFragment).getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
            }
        }
        return (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getQCircleBaseFragment().getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
    }

    private void u0(QFSPersonalEmptyProductPymkRefreshEvent qFSPersonalEmptyProductPymkRefreshEvent) {
        if (this.f93831i != null) {
            com.tencent.biz.qqcircle.widgets.pymk.b bVar = this.f93827d;
            if (bVar != null) {
                bVar.clearData();
            }
            e eVar = this.f93831i;
            eVar.M1(eVar.N1(), null);
        }
    }

    private void v0() {
        if (!this.C && this.D != null) {
            this.C = true;
            this.f93827d = new com.tencent.biz.qqcircle.widgets.pymk.b(new b());
            this.D.setEnableLoadMore(true);
            this.D.setEnableRefresh(false);
            this.D.getRecyclerView().setNestedScrollingEnabled(true);
            this.D.getRecyclerView().setNestScrollDelegate(new c());
            this.f93827d.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: qc0.p
                @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
                public final void onLoadData(LoadInfo loadInfo, Object obj) {
                    QFSPYMKRecommendListView.this.y0(loadInfo, obj);
                }
            });
            ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
            r rVar = new r();
            this.f93828e = rVar;
            arrayList.add(rVar);
            arrayList.add(this.f93827d);
            this.D.registerBlock(arrayList);
            this.D.getRecyclerView().setItemAnimator(new EnhanceItemAnimator());
            this.D.setParentFragment(getQCircleBaseFragment());
            if (this.D.getRecyclerView().getItemAnimator() instanceof SimpleItemAnimator) {
                ((SimpleItemAnimator) this.D.getRecyclerView().getItemAnimator()).setSupportsChangeAnimations(false);
            }
            this.D.start();
            x0();
        }
    }

    private void w0(Context context) {
        this.D = (QCircleBlockContainer) findViewById(R.id.f29660m9);
        this.f93829f = new SafeLinearLayoutManager(getContext(), 1, false);
        this.D.setLayoutManagerType(1, 1);
        this.D.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.D.getBlockMerger().setCustomNoMoreDataView(new QFSNormalNoMoreHintView(getContext()));
        this.D.getRecyclerView().addOnScrollListener(new a());
    }

    private void x0() {
        if (getQCircleBaseFragment() == null) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r s06 = s0();
        s06.w2().observe(getQCircleBaseFragment(), new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(LoadInfo loadInfo, Object obj) {
        this.f93827d.getLoadInfo().setCurrentState(3);
        if (!TextUtils.isEmpty(this.f93832m)) {
            this.f93831i.M1("", this.f93832m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(FeedCloudRead$StGetRecomUserListRsp feedCloudRead$StGetRecomUserListRsp) {
        boolean z16;
        v0();
        this.f93832m = feedCloudRead$StGetRecomUserListRsp.attachInfo.get();
        QLog.d("PYMK-QCirclePYMKRecommendListView", 1, "attach info: " + this.f93832m);
        if (this.f93827d.getDataList().size() > 0) {
            this.f93827d.updateData(feedCloudRead$StGetRecomUserListRsp.userRecoms.get());
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new FeedCloudMeta$StUserRecomInfo());
            if (k.f84627a.i(feedCloudRead$StGetRecomUserListRsp.extInfo.mapInfo.get()) && uq3.k.a().c("qfs_need_show_personal_contract_guide", true)) {
                FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo = new FeedCloudMeta$StUserRecomInfo();
                feedCloudMeta$StUserRecomInfo.user.f398463id.set("tag_type_contract");
                arrayList.add(feedCloudMeta$StUserRecomInfo);
            }
            arrayList.addAll(feedCloudRead$StGetRecomUserListRsp.userRecoms.get());
            this.f93827d.setDatas(arrayList);
        }
        QLog.d("PYMK-QCirclePYMKRecommendListView", 1, "response status" + feedCloudRead$StGetRecomUserListRsp.isFinish.get());
        com.tencent.biz.qqcircle.widgets.pymk.b bVar = this.f93827d;
        if (feedCloudRead$StGetRecomUserListRsp.isFinish.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        bVar.notifyLoadingComplete(true, z16);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(Object obj, int i3) {
        FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed;
        if (this.f93827d == null) {
            QLog.d("PYMK-QCirclePYMKRecommendListView", 1, "[bindData] current adapter should not be null.");
            return;
        }
        if (!(obj instanceof e30.b)) {
            QLog.d("PYMK-QCirclePYMKRecommendListView", 1, "[bindData] current obj data not is FeedBlockData type.");
            return;
        }
        e30.b bVar = (e30.b) obj;
        FeedCloudMeta$StFeed g16 = bVar.g();
        if (g16 == null) {
            feedCloudMeta$StDittoFeed = null;
        } else {
            feedCloudMeta$StDittoFeed = g16.dittoFeed.get();
        }
        r0(bVar, feedCloudMeta$StDittoFeed);
        B0(bVar, i3);
        VideoReport.traversePage(this.D.getRecyclerView());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSPersonalEmptyProductPymkRefreshEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gbc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "PYMK-QCirclePYMKRecommendListView";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public QCircleBaseFragment getQCircleBaseFragment() {
        ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(getParentView());
        if (viewModelStoreOwner instanceof QCircleBaseFragment) {
            return (QCircleBaseFragment) viewModelStoreOwner;
        }
        return super.getQCircleBaseFragment();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSPersonalEmptyProductPymkRefreshEvent) {
            u0((QFSPersonalEmptyProductPymkRefreshEvent) simpleBaseEvent);
        }
    }

    public void setPYMKGuestViewModel(e eVar) {
        if (this.f93831i == eVar) {
            return;
        }
        this.f93831i = eVar;
        eVar.C.observe(getQCircleBaseFragment(), new Observer() { // from class: qc0.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPYMKRecommendListView.this.z0((FeedCloudRead$StGetRecomUserListRsp) obj);
            }
        });
    }
}
