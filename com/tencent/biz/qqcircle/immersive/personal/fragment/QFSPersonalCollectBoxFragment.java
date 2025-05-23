package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalCollectBoxAdapter;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalRecommendCollectBoxAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalCollectBoxDetailBean;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalCollectBoxEvent;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalNewCollectBoxBottomSheet;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPersonalCollectBoxFragment extends QFSPersonalBaseNestScrollFragment {
    protected BlockPart E;
    protected com.tencent.biz.qqcircle.immersive.personal.part.y F;
    protected QFSPersonalCollectBoxAdapter G;
    protected QFSPersonalRecommendCollectBoxAdapter H;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements MultiViewBlock.OnLoadDataDelegate {
        a() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (QFSPersonalCollectBoxFragment.this.I != null && loadInfo.isLoadMoreState()) {
                QFSPersonalCollectBoxFragment.this.I.Y2(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements MultiViewBlock.OnLoadDataDelegate {
        b() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (QFSPersonalCollectBoxFragment.this.I != null && loadInfo.isLoadMoreState()) {
                QFSPersonalCollectBoxFragment.this.I.Y2(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements Observer<UIStateData<List<FeedCloudFavoritessvr$FavoritesInfo>>> {
        c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onChanged(UIStateData<List<FeedCloudFavoritessvr$FavoritesInfo>> uIStateData) {
            boolean z16;
            if (uIStateData == null) {
                return;
            }
            boolean isFinish = uIStateData.getIsFinish();
            int state = uIStateData.getState();
            if (state == 0) {
                QFSPersonalCollectBoxFragment.this.Eh();
            } else {
                z16 = false;
                if (state != 1) {
                    if (state != 2) {
                        if (state != 3) {
                            if (state == 4) {
                                QFSPersonalCollectBoxFragment.this.Fh(uIStateData.getMsg());
                            }
                        } else {
                            z16 = true;
                        }
                    }
                    QFSPersonalCollectBoxFragment.this.Mh();
                    QFSPersonalCollectBoxFragment.this.Hh(uIStateData);
                }
                if (!z16) {
                    QFSPersonalCollectBoxFragment.this.G.getLoadInfo().setFinish(isFinish);
                    QFSPersonalCollectBoxFragment.this.G.notifyLoadingComplete(true, isFinish);
                    QFSPersonalCollectBoxFragment.this.H.getLoadInfo().setFinish(isFinish);
                    QFSPersonalCollectBoxFragment.this.H.notifyLoadingComplete(true, isFinish);
                    return;
                }
                return;
            }
            z16 = true;
            if (!z16) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Observer<List<FeedCloudFavoritessvr$FavoritesInfo>> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<FeedCloudFavoritessvr$FavoritesInfo> list) {
            QFSPersonalCollectBoxFragment.this.H.setDatas(list);
            if (RFSafeListUtils.isEmpty(list)) {
                MutableLiveData<UIStateData<List<FeedCloudFavoritessvr$FavoritesInfo>>> e26 = QFSPersonalCollectBoxFragment.this.I.e2();
                UIStateData<List<FeedCloudFavoritessvr$FavoritesInfo>> value = e26.getValue();
                if (value != null && value.getData().isEmpty()) {
                    value.setState(0);
                    e26.postValue(value);
                }
                QFSPersonalCollectBoxFragment.this.E.getBlockContainer().getBlockMerger().getDataList().remove(QFSPersonalCollectBoxFragment.this.H);
            }
        }
    }

    private void Dh() {
        VideoReport.setElementId(((QCircleBaseFragment) this).mContentView, QCircleDaTongConstant.ElementId.EM_XSJ_COLLECT_FOLDER_TAB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        String str;
        String str2;
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.I;
        if (rVar != null && this.F != null) {
            boolean z16 = rVar.v2().z();
            if (z16) {
                str = "\u6682\u65e0\u6536\u85cf\u5939";
            } else {
                str = "\u8be5\u7528\u6237\u6682\u65e0\u6536\u85cf\u5939";
            }
            if (z16) {
                str2 = "\u53bb\u521b\u5efa\u559c\u6b22\u7684\u6536\u85cf\u5939\u5427~";
            } else {
                str2 = "";
            }
            this.F.M9(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(String str) {
        com.tencent.biz.qqcircle.immersive.personal.part.y yVar;
        if (this.I != null && (yVar = this.F) != null) {
            yVar.M9(str, null);
        }
    }

    private void Gh(QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.I;
        if (rVar != null && rVar.e2().getValue() != null) {
            if (qFSPersonalCollectBoxEvent.getEventStatus() == 1) {
                FeedCloudFavoritessvr$FavoritesInfo favoritesInfo = qFSPersonalCollectBoxEvent.getFavoritesInfo();
                MutableLiveData<UIStateData<List<FeedCloudFavoritessvr$FavoritesInfo>>> e26 = this.I.e2();
                e26.getValue().setState(3);
                e26.getValue().getData().add(0, favoritesInfo);
                e26.postValue(e26.getValue());
                return;
            }
            if (qFSPersonalCollectBoxEvent.getEventStatus() != 2 && qFSPersonalCollectBoxEvent.getEventStatus() != 6 && qFSPersonalCollectBoxEvent.getEventStatus() != 5) {
                if (qFSPersonalCollectBoxEvent.getEventStatus() == 3) {
                    MutableLiveData<List<FeedCloudFavoritessvr$FavoritesInfo>> q26 = this.I.q2();
                    q26.getValue().remove(qFSPersonalCollectBoxEvent.getFavoritesInfo());
                    q26.postValue(q26.getValue());
                    return;
                } else {
                    if (qFSPersonalCollectBoxEvent.getEventStatus() == 4) {
                        MutableLiveData<UIStateData<List<FeedCloudFavoritessvr$FavoritesInfo>>> e27 = this.I.e2();
                        Iterator<FeedCloudFavoritessvr$FavoritesInfo> it = e27.getValue().getData().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (it.next().f398434id.get() == qFSPersonalCollectBoxEvent.getFavoritesInfo().f398434id.get()) {
                                it.remove();
                                break;
                            }
                        }
                        if (e27.getValue().getData().isEmpty() && this.I.q2().getValue().isEmpty()) {
                            e27.getValue().setState(0);
                        }
                        e27.postValue(e27.getValue());
                        return;
                    }
                    return;
                }
            }
            MutableLiveData<UIStateData<List<FeedCloudFavoritessvr$FavoritesInfo>>> e28 = this.I.e2();
            Iterator<FeedCloudFavoritessvr$FavoritesInfo> it5 = e28.getValue().getData().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                FeedCloudFavoritessvr$FavoritesInfo next = it5.next();
                if (next.f398434id.get() == qFSPersonalCollectBoxEvent.getFavoritesInfo().f398434id.get()) {
                    if (qFSPersonalCollectBoxEvent.getFavoritesInfo().title.has()) {
                        next.title.set(qFSPersonalCollectBoxEvent.getFavoritesInfo().title.get());
                    }
                    if (qFSPersonalCollectBoxEvent.getFavoritesInfo().cover_url.has()) {
                        next.cover_url.set(qFSPersonalCollectBoxEvent.getFavoritesInfo().cover_url.get());
                    }
                    if (qFSPersonalCollectBoxEvent.getFavoritesInfo().feed_num.has()) {
                        next.feed_num.set(qFSPersonalCollectBoxEvent.getFavoritesInfo().feed_num.get());
                    }
                    if (qFSPersonalCollectBoxEvent.getFeedList() != null) {
                        long j3 = next.feed_num.get();
                        int size = qFSPersonalCollectBoxEvent.getFeedList().size();
                        if (qFSPersonalCollectBoxEvent.getEventStatus() == 6) {
                            next.feed_num.set(j3 + size);
                        } else if (qFSPersonalCollectBoxEvent.getEventStatus() == 5) {
                            next.feed_num.set(j3 - size);
                        }
                    }
                }
            }
            e28.postValue(e28.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(UIStateData<List<FeedCloudFavoritessvr$FavoritesInfo>> uIStateData) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.I;
        if (rVar != null && !rVar.K2() && this.G != null && uIStateData != null && uIStateData.getData() != null) {
            this.G.setDatas(uIStateData.getData());
            this.F.E9();
        }
    }

    private void Ih() {
        this.E.getBlockContainer().getRecyclerView().setNestedScrollingEnabled(true);
        this.E.getBlockContainer().setEnableRefresh(false);
        this.E.getBlockContainer().setEnableLoadMore(true);
        this.E.getBlockContainer().setParentFragment(this);
        this.E.getBlockContainer().getBlockMerger().setNoMoreHint(com.tencent.biz.qqcircle.utils.h.a(R.string.f1921346o));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(int i3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, QCircleBaseWidgetView qCircleBaseWidgetView) {
        QFSPersonalCollectBoxDetailBean qFSPersonalCollectBoxDetailBean = new QFSPersonalCollectBoxDetailBean();
        qFSPersonalCollectBoxDetailBean.setFavoritesInfo(feedCloudFavoritessvr$FavoritesInfo);
        com.tencent.biz.qqcircle.launcher.c.b0(getContext(), qFSPersonalCollectBoxDetailBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(int i3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, QCircleBaseWidgetView qCircleBaseWidgetView) {
        com.tencent.biz.qqcircle.immersive.personal.bean.n nVar = new com.tencent.biz.qqcircle.immersive.personal.bean.n(5);
        nVar.d(feedCloudFavoritessvr$FavoritesInfo);
        new QFSPersonalNewCollectBoxBottomSheet(getContext(), getView(), nVar, getReportBean()).show();
    }

    private List<MultiViewBlock> Lh() {
        ArrayList arrayList = new ArrayList();
        QFSPersonalCollectBoxAdapter qFSPersonalCollectBoxAdapter = new QFSPersonalCollectBoxAdapter(getArguments());
        this.G = qFSPersonalCollectBoxAdapter;
        qFSPersonalCollectBoxAdapter.setOnLoadDataDelegate(new a());
        this.G.l0(new QFSPersonalCollectBoxAdapter.c() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.g
            @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalCollectBoxAdapter.c
            public final void a(int i3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, QCircleBaseWidgetView qCircleBaseWidgetView) {
                QFSPersonalCollectBoxFragment.this.Jh(i3, feedCloudFavoritessvr$FavoritesInfo, qCircleBaseWidgetView);
            }
        });
        QFSPersonalRecommendCollectBoxAdapter qFSPersonalRecommendCollectBoxAdapter = new QFSPersonalRecommendCollectBoxAdapter(getArguments());
        this.H = qFSPersonalRecommendCollectBoxAdapter;
        qFSPersonalRecommendCollectBoxAdapter.l0(new QFSPersonalRecommendCollectBoxAdapter.b() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.h
            @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalRecommendCollectBoxAdapter.b
            public final void a(int i3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, QCircleBaseWidgetView qCircleBaseWidgetView) {
                QFSPersonalCollectBoxFragment.this.Kh(i3, feedCloudFavoritessvr$FavoritesInfo, qCircleBaseWidgetView);
            }
        });
        this.H.setOnLoadDataDelegate(new b());
        arrayList.add(this.G);
        arrayList.add(this.H);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh() {
        BlockPart blockPart = this.E;
        if (blockPart != null) {
            blockPart.getBlockContainer().getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
            this.E.getBlockContainer().getBlockMerger().resetTryToLoadMoreCount();
        }
    }

    private void initViewModel() {
        QLog.i(getTAG(), 1, "[initViewModel] getParentFragment() = " + getParentFragment());
        IPartHost iPartHost = (IPartHost) getParentFragment();
        this.I = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(iPartHost, null, com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        ViewTreeViewModelStoreOwner.set(sh(), iPartHost);
        this.I.e2().observe(this, new c());
        this.I.q2().observe(this, new d());
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        BlockPart blockPart = new BlockPart(R.id.f34250yn, Lh(), 3, 1);
        this.E = blockPart;
        arrayList.add(blockPart);
        com.tencent.biz.qqcircle.immersive.personal.part.y yVar = new com.tencent.biz.qqcircle.immersive.personal.part.y();
        this.F = yVar;
        arrayList.add(yVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gkh;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSPersonalCollectBoxEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCollectBoxFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSPersonalCollectBoxEvent) {
            Gh((QFSPersonalCollectBoxEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseNestScrollFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        Ih();
        Dh();
        initViewModel();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseNestScrollFragment
    protected NestScrollRecyclerView sh() {
        QFSPersonalCollectBoxAdapter qFSPersonalCollectBoxAdapter = this.G;
        if (qFSPersonalCollectBoxAdapter == null) {
            return null;
        }
        return qFSPersonalCollectBoxAdapter.getParentRecyclerView();
    }
}
