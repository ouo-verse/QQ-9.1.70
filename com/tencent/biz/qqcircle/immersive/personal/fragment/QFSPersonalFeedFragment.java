package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectScrollProcessor;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.bizparts.QCirclePersonalHomeMaterialGuidePopupWindowPart;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedPermissionChangeEvent;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSShowPersonalBottomBlockHintEvent;
import com.tencent.biz.qqcircle.immersive.personal.model.QFSPersonalTabIndexManager;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTemplateCarouselPart;
import com.tencent.biz.qqcircle.immersive.personal.publishguide.QFSPersonalPublishGuideViewModel;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.qqcircle.immersive.utils.ad;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.qqvideo.event.QCircleFeedJSPermissionChangeEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.engineer.test.api.RFWTestDataSource;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class QFSPersonalFeedFragment extends QFSPersonalBaseNestScrollFragment {
    protected BlockPart E;
    protected com.tencent.biz.qqcircle.immersive.personal.part.y F;
    protected QFSPersonalTemplateCarouselPart G;
    protected QCirclePersonalHomeMaterialGuidePopupWindowPart H;
    protected NestScrollRecyclerView I;
    protected QFSPersonalFeedAdapter J;
    protected QFSPersonalDetailsFragment K;
    protected com.tencent.biz.qqcircle.immersive.personal.viewmodel.r L;
    protected QFSPersonalPublishGuideViewModel M;
    protected int N;
    protected t30.f S;
    protected int P = 0;
    protected boolean Q = false;
    private Observer<Boolean> R = null;
    public boolean T = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements MultiViewBlock.OnLoadDataDelegate<QFSPersonalFeedAdapter> {
        a() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadData(LoadInfo loadInfo, QFSPersonalFeedAdapter qFSPersonalFeedAdapter) {
            if (loadInfo.isLoadMoreState()) {
                QFSPersonalFeedFragment qFSPersonalFeedFragment = QFSPersonalFeedFragment.this;
                qFSPersonalFeedFragment.L.n(qFSPersonalFeedFragment.N);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements QFSPersonalFeedAdapter.f {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter.f
        public void a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
            if (!FastClickUtils.isFastDoubleClick("fast_click_personal_detail_publish") && !QFSPersonalFeedFragment.this.J.A0(kVar)) {
                if (QFSPersonalFeedFragment.this.J.y0(kVar)) {
                    if (kVar instanceof com.tencent.biz.qqcircle.immersive.personal.bean.i) {
                        String w3 = ((com.tencent.biz.qqcircle.immersive.personal.bean.i) kVar).w();
                        QLog.i("QFSPersonalFeedFragment", 1, "[onItemClick] is QFSPersonalDittoFeedGuildInfo. scheme = " + w3);
                        com.tencent.biz.qqcircle.launcher.c.M(QFSPersonalFeedFragment.this.getContext(), w3);
                        return;
                    }
                    return;
                }
                QFSPersonalFeedFragment.this.wh(i3, kVar, qCircleBaseWidgetView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = QFSPersonalFeedFragment.this.L;
            if (rVar != null) {
                rVar.e3();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Observer<QFSPersonalInfo> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QFSPersonalInfo qFSPersonalInfo) {
            if (qFSPersonalInfo != null) {
                QFSPersonalFeedFragment qFSPersonalFeedFragment = QFSPersonalFeedFragment.this;
                if (qFSPersonalFeedFragment.F != null) {
                    qFSPersonalFeedFragment.T = QFSPersonalInfo.O;
                    if (!qFSPersonalInfo.f88425l && qFSPersonalInfo.f88426m) {
                        String c26 = uq3.c.c2();
                        if (qFSPersonalInfo.f88427n) {
                            QFSPersonalFeedFragment.this.F.M9(c26, uq3.c.b2());
                        } else {
                            QFSPersonalFeedFragment.this.F.M9(c26, uq3.c.a2());
                        }
                        QFSPersonalFeedFragment.this.L.o2().setValue(UIStateData.obtainEmpty());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f88645d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f88646e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f88647f;

        e(boolean z16, String str, String str2) {
            this.f88645d = z16;
            this.f88646e = str;
            this.f88647f = str2;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            QFSPersonalFeedFragment qFSPersonalFeedFragment = QFSPersonalFeedFragment.this;
            if (qFSPersonalFeedFragment.F != null && qFSPersonalFeedFragment.N == 20101) {
                if (bool.booleanValue()) {
                    QFSPersonalFeedFragment.this.F.E9();
                    return;
                }
                if (this.f88645d) {
                    QFSPersonalFeedFragment qFSPersonalFeedFragment2 = QFSPersonalFeedFragment.this;
                    if (qFSPersonalFeedFragment2.T) {
                        qFSPersonalFeedFragment2.F.R9();
                        return;
                    }
                }
                QFSPersonalFeedFragment.this.F.M9(this.f88646e, this.f88647f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f extends RecyclerView.OnScrollListener {
        f() {
        }

        public void handleScrollStateChanged(int i3) {
            QCircleAspectScrollProcessor.getInstance().onScrollState(QFSPersonalFeedFragment.this, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
            handleScrollStateChanged(i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            if (recyclerView.getLayoutManager() instanceof SafeGridLayoutManager) {
                SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) recyclerView.getLayoutManager();
                QFSPersonalFeedFragment.this.P = ((safeGridLayoutManager.findFirstVisibleItemPosition() + safeGridLayoutManager.findLastVisibleItemPosition()) / 2) / 3;
            }
        }
    }

    private void Ah(String str, long j3) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
        if (rVar != null && !rVar.K2()) {
            QLog.i("QFSPersonalFeedFragment", 1, str);
            this.F.P9(str, j3);
        }
    }

    private void Bh(@NonNull QFSLayerFeedPosSyncEvent qFSLayerFeedPosSyncEvent) {
        QLog.d("QFSPersonalFeedFragment", 4, "QFSLayerFeedPosSyncEvent position = " + qFSLayerFeedPosSyncEvent.getPos());
        if (this.J != null && this.K != null && this.L != null && qFSLayerFeedPosSyncEvent.getPageCode() == hashCode()) {
            ad.f(this.J.t0(), this.I, this.K.Jh(), qFSLayerFeedPosSyncEvent);
        }
    }

    private void Ch(UIStateData<List<e30.b>> uIStateData) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
        if (rVar != null && !rVar.K2() && this.J != null && uIStateData != null && uIStateData.getData() != null) {
            QLog.i(getTAG(), 1, "[handleModify] -> uiStateData = " + uIStateData);
            ArrayList arrayList = new ArrayList();
            Iterator<e30.b> it = uIStateData.getData().iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.bean.k(this.L.i2(), it.next(), this.N));
            }
            this.J.setDatas(arrayList);
        }
    }

    private void Dh() {
        com.tencent.biz.qqcircle.immersive.personal.part.y yVar;
        if (!HostNetworkUtils.isNetworkAvailable() && (yVar = this.F) != null) {
            yVar.N9(uq3.c.N3());
        }
    }

    private void Gh() {
        this.E.getBlockContainer().getRecyclerView().setNestedScrollingEnabled(true);
        this.E.getBlockContainer().setEnableRefresh(false);
        this.E.getBlockContainer().setEnableLoadMore(true);
        this.E.getBlockContainer().setParentFragment(this);
        this.E.getBlockContainer().getBlockMerger().setTryToLoadMoreWhenNotFullScreen(3);
        this.E.getBlockContainer().getBlockMerger().setCustomNoMoreDataView(new QFSNormalNoMoreHintView(getContext()));
    }

    public static QFSPersonalFeedFragment Hh(int i3) {
        QFSPersonalFeedFragment qFSPersonalProductFeedFragment;
        Bundle bundle = new Bundle();
        bundle.putInt("fs_key_personal_feed_type", i3);
        if (i3 != 20101) {
            if (i3 != 20112) {
                qFSPersonalProductFeedFragment = null;
            } else {
                qFSPersonalProductFeedFragment = new QFSPersonalPrivateProdsFeedFragment();
            }
        } else {
            qFSPersonalProductFeedFragment = new QFSPersonalProductFeedFragment();
        }
        if (qFSPersonalProductFeedFragment != null) {
            qFSPersonalProductFeedFragment.setArguments(bundle);
        }
        return qFSPersonalProductFeedFragment;
    }

    private void Lh(SimpleBaseEvent simpleBaseEvent) {
        if (QFSPersonalTabIndexManager.f88726a.h() && this.J != null) {
            if ((simpleBaseEvent instanceof QCircleFeedJSPermissionChangeEvent) && !Kh()) {
                QCircleFeedJSPermissionChangeEvent qCircleFeedJSPermissionChangeEvent = (QCircleFeedJSPermissionChangeEvent) simpleBaseEvent;
                String feedId = qCircleFeedJSPermissionChangeEvent.getFeedId();
                int rightFlag = qCircleFeedJSPermissionChangeEvent.getRightFlag();
                int downLoadOper = qCircleFeedJSPermissionChangeEvent.getDownLoadOper();
                for (e30.b bVar : this.J.t0()) {
                    if (bVar != null && bVar.g() != null && bVar.g().f398449id.get().equals(feedId)) {
                        cq.f92752a.v(bVar.g(), rightFlag, downLoadOper);
                    }
                }
            }
            if ((simpleBaseEvent instanceof QFSFeedPermissionChangeEvent) && !Kh()) {
                QFSFeedPermissionChangeEvent qFSFeedPermissionChangeEvent = (QFSFeedPermissionChangeEvent) simpleBaseEvent;
                String feedId2 = qFSFeedPermissionChangeEvent.getFeedId();
                int rightFlag2 = qFSFeedPermissionChangeEvent.getRightFlag();
                for (e30.b bVar2 : this.J.t0()) {
                    if (bVar2 != null && bVar2.g() != null && bVar2.g().right != null && bVar2.g().right.ugcRight != null && bVar2.g().f398449id.get().equals(feedId2)) {
                        bVar2.g().right.ugcRight.rightFlag.set(rightFlag2);
                    }
                }
            }
        }
    }

    private void showLoadingView() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
        if (rVar != null && rVar.J2()) {
            this.F.Q9();
        }
    }

    private String yh(int i3) {
        if (i3 == 20112) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f19307498);
        }
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f19308499);
    }

    protected void Eh(UIStateData<List<e30.b>> uIStateData) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
        if (rVar != null && !rVar.K2() && this.J != null && uIStateData != null && uIStateData.getData() != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<e30.b> it = uIStateData.getData().iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.bean.k(this.L.i2(), it.next(), this.N));
            }
            this.J.setDatas(arrayList);
            this.F.E9();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fh() {
        QFSPersonalFeedAdapter qFSPersonalFeedAdapter = this.J;
        if (qFSPersonalFeedAdapter != null && this.L != null) {
            NestScrollRecyclerView parentRecyclerView = qFSPersonalFeedAdapter.getParentRecyclerView();
            this.I = parentRecyclerView;
            parentRecyclerView.addOnScrollListener(new f());
        }
    }

    abstract void Ih();

    /* JADX INFO: Access modifiers changed from: protected */
    public List<MultiViewBlock> Jh() {
        ArrayList arrayList = new ArrayList();
        QFSPersonalFeedAdapter qFSPersonalFeedAdapter = new QFSPersonalFeedAdapter(getArguments());
        this.J = qFSPersonalFeedAdapter;
        qFSPersonalFeedAdapter.O0(yh(this.N));
        this.J.setOnLoadDataDelegate(new a());
        this.J.M0(new b());
        arrayList.add(this.J);
        return arrayList;
    }

    abstract boolean Kh();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Mh(UIStateData<List<e30.b>> uIStateData) {
        boolean z16;
        QFSPersonalFeedAdapter qFSPersonalFeedAdapter;
        if (uIStateData == null) {
            return;
        }
        boolean isFinish = uIStateData.getIsFinish();
        int state = uIStateData.getState();
        if (state != 0) {
            z16 = false;
            if (state != 1) {
                if (state != 2) {
                    if (state != 3) {
                        if (state != 4) {
                            if (state == 7) {
                                Ch(uIStateData);
                            }
                        } else {
                            Ah(uIStateData.getMsg(), uIStateData.getRetCode());
                        }
                    } else {
                        z16 = true;
                    }
                }
                Eh(uIStateData);
                this.E.getBlockContainer().getBlockMerger().resetTryToLoadMoreCount();
            } else {
                showLoadingView();
            }
            qFSPersonalFeedAdapter = this.J;
            if (qFSPersonalFeedAdapter == null) {
                qFSPersonalFeedAdapter.getLoadInfo().setFinish(isFinish);
                if (z16) {
                    this.J.notifyLoadingComplete(true, isFinish);
                    return;
                }
                return;
            }
            return;
        }
        zh();
        z16 = true;
        qFSPersonalFeedAdapter = this.J;
        if (qFSPersonalFeedAdapter == null) {
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        BlockPart blockPart = new BlockPart(R.id.vg9, Jh(), 2, 3);
        this.E = blockPart;
        arrayList.add(blockPart);
        com.tencent.biz.qqcircle.immersive.personal.part.y yVar = new com.tencent.biz.qqcircle.immersive.personal.part.y();
        this.F = yVar;
        arrayList.add(yVar);
        this.H = new QCirclePersonalHomeMaterialGuidePopupWindowPart((QFSPersonalDetailsFragment) getParentFragment());
        this.G = new QFSPersonalTemplateCarouselPart((QFSPersonalDetailsFragment) getParentFragment());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.glh;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSLayerFeedPosSyncEvent.class);
        eventClass.add(QFSFeedPermissionChangeEvent.class);
        eventClass.add(QFSShowPersonalBottomBlockHintEvent.class);
        eventClass.add(QCircleFeedJSPermissionChangeEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalFeedFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViewModel() {
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment = this.K;
        if (qFSPersonalDetailsFragment == null) {
            QLog.i("QFSPersonalFeedFragment", 1, "fsPersonalHomeFragment is null");
            return;
        }
        this.L = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(qFSPersonalDetailsFragment, null, com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        QFSPersonalPublishGuideViewModel qFSPersonalPublishGuideViewModel = (QFSPersonalPublishGuideViewModel) getViewModel(this.K, null, QFSPersonalPublishGuideViewModel.class);
        this.M = qFSPersonalPublishGuideViewModel;
        qFSPersonalPublishGuideViewModel.R1(this.L.g2());
        this.F.H9(new c());
        this.L.g2().observe(this, new d());
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() == null) {
            return;
        }
        this.N = getArguments().getInt("fs_key_personal_feed_type");
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QFSPersonalFeedAdapter qFSPersonalFeedAdapter = this.J;
        if (qFSPersonalFeedAdapter != null) {
            qFSPersonalFeedAdapter.setDatas(new ArrayList());
        }
        NestScrollRecyclerView nestScrollRecyclerView = this.I;
        if (nestScrollRecyclerView != null) {
            nestScrollRecyclerView.clearOnScrollListeners();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        t30.f fVar = this.S;
        if (fVar != null) {
            fVar.onPause();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSLayerFeedPosSyncEvent) {
            Bh((QFSLayerFeedPosSyncEvent) simpleBaseEvent);
            return;
        }
        if ((simpleBaseEvent instanceof QFSFeedPermissionChangeEvent) || (simpleBaseEvent instanceof QCircleFeedJSPermissionChangeEvent)) {
            Lh(simpleBaseEvent);
            QFSPersonalFeedAdapter qFSPersonalFeedAdapter = this.J;
            if (qFSPersonalFeedAdapter != null) {
                qFSPersonalFeedAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @RFWTestDataSource(key = "key_personal_feed_recycler_view", objName = "mRecyclerView")
    public void onResume() {
        super.onResume();
        t30.f fVar = this.S;
        if (fVar != null) {
            fVar.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseNestScrollFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        this.K = (QFSPersonalDetailsFragment) getParentFragment();
        Gh();
        initViewModel();
        Ih();
        Fh();
        Dh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseNestScrollFragment
    protected NestScrollRecyclerView sh() {
        QFSPersonalFeedAdapter qFSPersonalFeedAdapter = this.J;
        if (qFSPersonalFeedAdapter == null) {
            return null;
        }
        return qFSPersonalFeedAdapter.getParentRecyclerView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseNestScrollFragment
    public boolean vh(RecyclerView recyclerView) {
        if (recyclerView == null || recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() < recyclerView.computeVerticalScrollRange()) {
            return false;
        }
        return true;
    }

    protected void wh(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        if (kVar != null && qCircleBaseWidgetView != null && this.L != null) {
            QCircleLayerBean xh5 = xh(i3, kVar);
            int[] iArr = new int[2];
            qCircleBaseWidgetView.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i16 = iArr[0];
            xh5.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], qCircleBaseWidgetView.getWidth() + i16, iArr[1] + qCircleBaseWidgetView.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(kVar.a()).setTransitionDelayTimeMs(0).setTransitionDurationMs(200).setEnterAnimFadeCoverTimeMs(300));
            xh5.setPrePersonalPageUin(this.L.i2());
            if (qCircleBaseWidgetView.getChildCount() > 0 && (qCircleBaseWidgetView.getChildAt(0) instanceof FrameLayout) && ((FrameLayout) qCircleBaseWidgetView.getChildAt(0)).getChildCount() > 0 && (((FrameLayout) qCircleBaseWidgetView.getChildAt(0)).getChildAt(0) instanceof ImageView)) {
                xh5.getTransitionAnimBean().setCoverDrawable(((ImageView) ((FrameLayout) qCircleBaseWidgetView.getChildAt(0)).getChildAt(0)).getDrawable());
            }
            if (kVar.b() != null) {
                feedCloudMeta$StVideo = kVar.b().video;
            } else {
                feedCloudMeta$StVideo = null;
            }
            RFWPlayerPreRenderHelper.getInstance().playerRender(gb0.b.f(new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10003).setActivity(getActivity()).setSourceType(com.tencent.biz.qqcircle.immersive.manager.g.e().i(getReportBean())).setPreloadVideo(gb0.b.k(feedCloudMeta$StVideo)).setIsJumpTrigger(uq3.o.U0()).setPreloadOriginData(gb0.b.m(new e30.b(kVar.b()))).setMultiLevel(true)));
            com.tencent.biz.qqcircle.launcher.c.u(getContext(), xh5);
        }
    }

    public QCircleLayerBean xh(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setSourceType(this.N);
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setSourceType(this.N);
        if (getReportBean() != null) {
            qCircleLayerBean.setFromReportBean(getReportBean().m466clone());
        }
        if (kVar != null) {
            qCircleLayerBean.setFeed(kVar.b());
        }
        qCircleLayerBean.setUser(this.L.v2().c());
        if (this.L.g2() != null && this.L.g2().getValue() != null) {
            qCircleLayerBean.putBusinessData("isOpenShareAd", Boolean.valueOf(this.L.g2().getValue().M));
        }
        qCircleLayerBean.setDataPosInList(i3);
        qCircleLayerBean.setTransInitBean(qCircleInitBean);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        qCircleLayerBean.setGlobalViewModelKey(this.L.y2());
        if (kVar != null && ((kVar.p() == 20101 || kVar.p() == 20105 || kVar.p() == 20106 || kVar.p() == 20112) && QCirclePluginUtil.isOwner(kVar.b().poster))) {
            qCircleLayerBean.setFromPage(1);
        }
        qCircleLayerBean.setPageCode(hashCode());
        qCircleLayerBean.setLaunchFrom("qfs_personal_tab_all");
        QCircleInitBean.QCircleActionBean qCircleActionBean = new QCircleInitBean.QCircleActionBean();
        qCircleActionBean.mShowSharePanelTopAction = true;
        qCircleLayerBean.setActionBean(qCircleActionBean);
        String Hh = this.K.Hh();
        if (!TextUtils.isEmpty(Hh)) {
            qCircleLayerBean.getExtraTypeInfo().mReportExtraMap.put(QFS5507ReportHelper.JsonKey.TRANS_FEEDID, Hh);
        }
        String Ih = this.K.Ih();
        if (!TextUtils.isEmpty(Ih)) {
            qCircleLayerBean.getExtraTypeInfo().mReportExtraMap.put(QFS5507ReportHelper.JsonKey.TRANS_REQID, Ih);
        }
        return qCircleLayerBean;
    }

    protected void zh() {
        String E1;
        String D1;
        if (this.J == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<com.tencent.biz.qqcircle.immersive.personal.bean.k> dataList = this.J.getDataList();
        if (this.Q && dataList.size() > 0) {
            Iterator<com.tencent.biz.qqcircle.immersive.personal.bean.k> it = dataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.biz.qqcircle.immersive.personal.bean.k next = it.next();
                if (this.J.A0(next)) {
                    arrayList.add(next);
                    break;
                }
            }
        }
        this.J.setDatas(arrayList);
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
        if (rVar != null && !rVar.K2() && !this.Q) {
            boolean L2 = this.L.L2();
            switch (this.N) {
                case ErrorCode.ERROR_CMD_INVALID /* 20101 */:
                    if (!L2) {
                        QLog.d("QFSPersonalFeedFragment", 1, "not main state");
                        return;
                    } else {
                        E1 = uq3.c.E1();
                        D1 = uq3.c.D1();
                        break;
                    }
                case ErrorCode.ERROR_APPID_NOT_FOUND /* 20102 */:
                    if (L2) {
                        E1 = uq3.c.C1();
                    } else {
                        E1 = uq3.c.B1();
                    }
                    if (L2) {
                        D1 = uq3.c.A1();
                        break;
                    } else {
                        D1 = uq3.c.z1();
                        break;
                    }
                case ErrorCode.ERROR_VERIFY_FAILED /* 20103 */:
                    if (L2) {
                        E1 = uq3.c.J1();
                    } else {
                        E1 = uq3.c.I1();
                    }
                    if (L2) {
                        D1 = uq3.c.H1();
                        break;
                    } else {
                        D1 = uq3.c.G1();
                        break;
                    }
                default:
                    E1 = "";
                    D1 = E1;
                    break;
            }
            this.F.M9(E1, "");
            this.L.r2().observe(this, new e(L2, E1, D1));
        }
    }
}
