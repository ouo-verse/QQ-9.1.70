package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleAlbumPanelBlock;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleFeedAlbumInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.immersive.album.event.QCircleFeedAlbumInfoChangedEvent;
import com.tencent.biz.qqcircle.immersive.album.event.QCircleFeedAlbumInfoEvent;
import com.tencent.biz.qqcircle.immersive.album.view.QCircleAlbumItemView;
import com.tencent.biz.qqcircle.immersive.events.QFSPageIndexEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel;
import com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$AlbumPageData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ac extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, z30.a, SimpleEventReceiver {
    protected TextView C;
    private RefreshHeaderView D;
    private QCirclePanelLoadingView E;
    private ViewGroup F;
    private TextView G;
    private TextView H;
    private TextView I;
    private ImageView J;
    protected QCircleAlbumBean K;
    protected QCircleFeedAlbumInfo L;
    protected FeedCloudMeta$StFeed M;
    protected RelativeLayout N;
    protected QCircleAlbumSlidBottomView P;
    protected LinearLayout Q;
    protected QCircleBlockContainer R;
    protected QCircleAlbumPanelBlock S;
    protected QFSLayerAlbumViewModel T;
    private QFSPublishTipsUtils U = new QFSPublishTipsUtils();

    /* renamed from: d, reason: collision with root package name */
    private ViewStub f87661d;

    /* renamed from: e, reason: collision with root package name */
    private View f87662e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f87663f;

    /* renamed from: h, reason: collision with root package name */
    private ViewStub f87664h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f87665i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f87666m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Observer<QQCircleFeedBase$AlbumPageData> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData) {
            boolean z16;
            if (qQCircleFeedBase$AlbumPageData == null) {
                return;
            }
            String str = qQCircleFeedBase$AlbumPageData.album.owner.f398463id.get();
            long j3 = qQCircleFeedBase$AlbumPageData.album.f398441id.get();
            String str2 = qQCircleFeedBase$AlbumPageData.album.title.get();
            String str3 = qQCircleFeedBase$AlbumPageData.album.description.get();
            String str4 = qQCircleFeedBase$AlbumPageData.album.cover_url.get();
            boolean z17 = true;
            if (qQCircleFeedBase$AlbumPageData.album.collection_info.status.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (qQCircleFeedBase$AlbumPageData.album.status.get() != 2) {
                z17 = false;
            }
            ac.this.xa(new QCircleFeedAlbumInfo(str, j3, str2, str3, str4, z16, z17).isCollect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
            QFSLayerAlbumViewModel qFSLayerAlbumViewModel = ac.this.T;
            if (qFSLayerAlbumViewModel != null && qFSLayerAlbumViewModel.j().getValue() != null) {
                if (!ac.this.R.canScrollVertically(-1)) {
                    int state = ac.this.T.j().getValue().getState();
                    if ((state == 1 || state == 4) && ac.this.T.P1().getCurLoadMoreAction() == 1 && ac.this.T.H2()) {
                        ac.this.D.setState(2);
                    } else {
                        ac.this.D.n();
                    }
                } else {
                    ac.this.D.n();
                }
                UIStateData<List<e30.b>> value = ac.this.T.j().getValue();
                if (value != null && value.getData() != null && !value.getData().isEmpty()) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if ((layoutManager instanceof LinearLayoutManager) && i3 == 0) {
                        int size = value.getData().size() - 1;
                        int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                        int min = Math.min(size, 2);
                        int min2 = Math.min(size, findFirstVisibleItemPosition + 2);
                        FeedCloudMeta$StFeed g16 = value.getData().get(min).g();
                        FeedCloudMeta$StFeed g17 = value.getData().get(min2).g();
                        if (g16 != null && g17 != null) {
                            if (g16.f398449id.get().equals(g17.f398449id.get()) && ac.this.T.H2()) {
                                ac.this.T.h3(1);
                            } else if (!ac.this.R.canScrollVertically(-1) && !ac.this.T.H2()) {
                                ac.this.P.setParentConsumeEvent(true);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            if (i3 == 0) {
                QCircleHostDropFrameMonitorHelper.stopMonitorScene(QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_COMMENT_PAGE(), false);
            } else {
                QCircleHostDropFrameMonitorHelper.startMonitorScene(QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_COMMENT_PAGE());
            }
        }
    }

    public ac() {
    }

    private void G9(View view, String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, buildElementParams);
    }

    private void H9() {
        NestScrollRecyclerView recyclerView;
        LinearLayout linearLayout = this.f87665i;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        LinearLayout linearLayout2 = this.Q;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(this);
        }
        View view = this.f87662e;
        if (view != null) {
            view.setOnClickListener(this);
        }
        QCircleBlockContainer qCircleBlockContainer = this.R;
        if (qCircleBlockContainer == null || (recyclerView = qCircleBlockContainer.getRecyclerView()) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new b());
        if (ha()) {
            G9(this.f87665i, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_COLLECT_BUTTON);
        }
        G9(this.Q, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_SHARE_BUTTON);
    }

    private void I9(View view, String str) {
        if (view == null) {
            QLog.d("QFSBottomAlbumPanelPart", 1, "[dtReportBindViewData] album view model not is null.");
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, Q9());
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private void J9(View view, Map<String, Object> map) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(map);
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_ENTRANCE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, buildElementParams);
    }

    private void K9(View view, String str) {
        if (view == null) {
            QLog.e("QFSBottomAlbumPanelPart", 1, "[dtReportImpl] view is null.");
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", view, Q9());
    }

    private long L9() {
        QCircleFeedAlbumInfo qCircleFeedAlbumInfo = this.L;
        if (qCircleFeedAlbumInfo == null) {
            return 0L;
        }
        return qCircleFeedAlbumInfo.mAlbumId;
    }

    private Map<String, Object> Q9() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(L9()));
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.T;
        if (qFSLayerAlbumViewModel != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_SOURCE, c40.b.b(qFSLayerAlbumViewModel.R2()));
        }
        return buildElementParams;
    }

    private String R9(View view) {
        return view.getResources().getString(R.string.f195744ff);
    }

    private void S9(QCircleFeedAlbumInfoEvent qCircleFeedAlbumInfoEvent) {
        QCircleFeedAlbumInfo qCircleFeedAlbumInfo;
        TextView textView = this.f87663f;
        if (textView != null && (qCircleFeedAlbumInfo = qCircleFeedAlbumInfoEvent.mFeedAlbumInfo) != null) {
            ta(textView, qCircleFeedAlbumInfo);
        } else {
            QLog.e("QFSBottomAlbumPanelPart", 1, "mBottomBannerTV or event.mFeedAlbumInfo should not be null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T9(boolean z16) {
        int i3;
        View view = this.f87662e;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    private void Y9(Object obj) {
        if (obj instanceof e30.b) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.M;
            if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.f398449id.get().equals(((e30.b) obj).g().f398449id.get())) {
                return;
            }
            this.M = ((e30.b) obj).g();
            QCircleAlbumPanelBlock qCircleAlbumPanelBlock = this.S;
            if (qCircleAlbumPanelBlock != null) {
                qCircleAlbumPanelBlock.w0(true);
            }
        }
    }

    private void aa() {
        if (!ga()) {
            QLog.d("QFSBottomAlbumPanelPart", 1, "[initBannerView] current not load banner view.");
            return;
        }
        ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.f33550wr);
        this.f87661d = viewStub;
        View findViewById = viewStub.inflate().findViewById(R.id.f33540wq);
        this.f87662e = findViewById;
        findViewById.setVisibility(0);
        TextView textView = (TextView) this.f87662e.findViewById(R.id.f39161ax);
        this.f87663f = textView;
        ta(textView, this.L);
    }

    private void ba() {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.T;
        if (qFSLayerAlbumViewModel == null) {
            return;
        }
        qFSLayerAlbumViewModel.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ac.this.oa((UIStateData) obj);
            }
        });
        this.T.O2().observe(getHostFragment(), new a());
    }

    private void ca() {
        ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.sla);
        this.f87664h = viewStub;
        RelativeLayout relativeLayout = (RelativeLayout) viewStub.inflate().findViewById(R.id.sl_);
        this.N = relativeLayout;
        this.P = (QCircleAlbumSlidBottomView) relativeLayout.findViewById(R.id.f30700p2);
        this.R = (QCircleBlockContainer) this.N.findViewById(R.id.f30690p1);
        this.Q = (LinearLayout) this.N.findViewById(R.id.f46231u1);
        this.f87665i = (LinearLayout) this.N.findViewById(R.id.f45951t_);
        this.f87666m = (ImageView) this.N.findViewById(R.id.f44181oh);
        this.C = (TextView) this.N.findViewById(R.id.f55952ja);
        this.H = (TextView) this.N.findViewById(R.id.sl5);
        this.I = (TextView) this.N.findViewById(R.id.f164272sl4);
        this.D = (RefreshHeaderView) this.N.findViewById(R.id.f166126ys0);
        this.E = (QCirclePanelLoadingView) this.N.findViewById(R.id.f30670oz);
        ViewGroup viewGroup = (ViewGroup) this.N.findViewById(R.id.f33790xe);
        this.F = viewGroup;
        TextView textView = (TextView) viewGroup.findViewById(R.id.f166327f13);
        this.G = textView;
        textView.setText(uq3.c.w3());
        I9(this.P, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_LIST_PANEL);
        ImageView imageView = (ImageView) this.N.findViewById(R.id.f30680p0);
        this.J = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
    }

    private void da() {
        if (this.P == null) {
            QLog.d("QFSBottomAlbumPanelPart", 1, "[initSlidView] mSlidView == null.");
            return;
        }
        this.P.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ac.this.pa(view);
            }
        });
        this.P.c(new c());
    }

    private void init() {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel;
        int i3;
        initViewModel();
        initView();
        H9();
        da();
        initBlockContainer();
        if (this.Q != null && (qFSLayerAlbumViewModel = this.T) != null && qFSLayerAlbumViewModel.S2() != null) {
            LinearLayout linearLayout = this.Q;
            if (this.T.S2().getValue().booleanValue()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            linearLayout.setVisibility(i3);
        }
    }

    private void initBlockContainer() {
        this.R.setLayoutManagerType(1, 1);
        this.R.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.R.setEnableLoadMore(true);
        this.R.setEnableRefresh(false);
        this.R.setParentFragment(getHostFragment());
        this.R.getRecyclerView().setNestedScrollingEnabled(true);
        ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
        QCircleAlbumPanelBlock qCircleAlbumPanelBlock = new QCircleAlbumPanelBlock(null, M9());
        this.S = qCircleAlbumPanelBlock;
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            qCircleAlbumPanelBlock.setReportBean(qCircleReportBean);
        }
        arrayList.add(this.S);
        this.S.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.biz.qqcircle.immersive.part.z
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                ac.this.na(loadInfo, obj);
            }
        });
        this.S.addOnScrollListener(new d());
        this.S.x0(this);
        this.R.getRecyclerView().setItemAnimator(new EnhanceItemAnimator());
        if (this.R.getRecyclerView().getItemAnimator() instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) this.R.getRecyclerView().getItemAnimator()).setSupportsChangeAnimations(false);
        }
        this.R.registerBlock(arrayList);
        this.R.start();
    }

    private void initView() {
        aa();
        ca();
    }

    private boolean ja() {
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView = this.P;
        if (qCircleAlbumSlidBottomView != null && qCircleAlbumSlidBottomView.k()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ma() {
        if (this.P == null) {
            return;
        }
        if (!ea()) {
            za();
            return;
        }
        QCircleAlbumBean qCircleAlbumBean = this.K;
        if ((qCircleAlbumBean == null || qCircleAlbumBean.needShowAlbumPanel()) && this.P.getVisibility() == 8) {
            X9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void na(LoadInfo loadInfo, Object obj) {
        QLog.d("QFSBottomAlbumPanelPart", 1, "[initBlockContainer] loadInfo.isLoadMoreState(): " + loadInfo.isLoadMoreState());
        if (loadInfo.isLoadMoreState()) {
            ra(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pa(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        W9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void ra(int i3) {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.T;
        if (qFSLayerAlbumViewModel == null) {
            QLog.d("QFSBottomAlbumPanelPart", 1, "[requestAlbumList] album view model should not be null.");
        } else {
            qFSLayerAlbumViewModel.h3(i3);
        }
    }

    private void sa(List<b40.a> list) {
        if (list != null && list.size() != 0 && list.get(0).f() != null) {
            FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = list.get(0).f().album.get();
            String str = feedCloudMeta$FeedAlbum.title.get();
            int i3 = feedCloudMeta$FeedAlbum.feed_count.get();
            this.H.setText(String.format(getContext().getString(R.string.f195774fi), str));
            this.I.setText(getContext().getString(R.string.f1901841e) + i3 + getContext().getString(R.string.f1901941f));
        }
    }

    private void ta(TextView textView, QCircleFeedAlbumInfo qCircleFeedAlbumInfo) {
        String str = qCircleFeedAlbumInfo.title;
        int i3 = qCircleFeedAlbumInfo.mFeedCount;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        textView.setText(String.format(R9(textView), str, Integer.valueOf(i3)));
    }

    private void ua(List<b40.a> list, TextView textView) {
        if (textView != null && list != null && list.size() != 0 && list.get(0).f() != null) {
            FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = list.get(0).f().album.get();
            textView.setText(String.format(R9(textView), feedCloudMeta$FeedAlbum.title.get(), Integer.valueOf(feedCloudMeta$FeedAlbum.feed_count.get())));
        }
    }

    private void va() {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.T;
        if (qFSLayerAlbumViewModel != null && qFSLayerAlbumViewModel.O2().getValue() != null) {
            if (ia()) {
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188763xk), 0);
                return;
            }
            QQCircleFeedBase$AlbumPageData value = this.T.O2().getValue();
            this.U.u(this.f87665i, value.album.f398441id.get() + "", true);
        }
    }

    private void wa() {
        if (this.T == null) {
            return;
        }
        W9();
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        qCircleShareInfo.type = 7;
        QQCircleFeedBase$AlbumPageData value = this.T.O2().getValue();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        if (value != null) {
            qCircleShareInfo.isShowDeleteAndEditAlbum = QCirclePluginUtil.isOwner(value.album.owner.f398463id.get());
            qCircleShareInfo.albumId = value.album.f398441id.get();
            qCircleShareInfo.albumStatus = value.album.status.get();
            feedCloudMeta$StFeed.share.set(value.share_info.get());
        }
        qCircleShareInfo.feed = feedCloudMeta$StFeed;
        qCircleShareInfo.source = 12;
        qCircleShareInfo.feedBlockData = new e30.b(feedCloudMeta$StFeed);
        qCircleShareInfo.shareStyleType = 6;
        QCircleReportBean qCircleReportBean = new QCircleReportBean();
        qCircleShareInfo.mReportBean = qCircleReportBean;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.M;
        if (feedCloudMeta$StFeed2 != null) {
            qCircleReportBean.setFeedId(feedCloudMeta$StFeed2.f398449id.get());
            qCircleShareInfo.mReportBean.setAuthUin(this.M.poster.f398463id.get());
        }
        broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa(boolean z16) {
        ImageView imageView;
        String a16;
        if (this.C != null && (imageView = this.f87666m) != null) {
            imageView.setSelected(z16);
            TextView textView = this.C;
            if (z16) {
                a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f188783xm);
            } else {
                a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f188713xf);
            }
            textView.setText(a16);
        }
    }

    private void za() {
        QCircleBlockContainer qCircleBlockContainer = this.R;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getBlockMerger() != null) {
            this.R.getBlockMerger().resetTryToLoadMoreCount();
        }
        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.y
            @Override // java.lang.Runnable
            public final void run() {
                ac.this.qa();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Aa(@NonNull b40.a aVar) {
        this.M = aVar.e();
        int Ba = Ba(this.S.getDataList());
        this.S.w0(true);
        B1(Ba);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B1(int i3) {
        QCircleBlockContainer qCircleBlockContainer = this.R;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getRecyclerView() != null) {
            this.R.getRecyclerView().scrollToPosition(i3);
            if (this.R.getRecyclerView().getAdapter() != null) {
                this.R.getRecyclerView().getAdapter().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Ba(List<b40.a> list) {
        if (list == null || list.size() == 0 || this.M == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < list.size(); i16++) {
            b40.a aVar = list.get(i16);
            if (aVar != null && aVar.e() != null) {
                if (aVar.e().f398449id.get().equals(this.M.f398449id.get())) {
                    aVar.p(true);
                    i3 = i16;
                } else {
                    aVar.p(false);
                }
            }
        }
        return i3;
    }

    protected QCircleAlbumItemView.a M9() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String N9() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.M;
        if (feedCloudMeta$StFeed == null) {
            return "";
        }
        return feedCloudMeta$StFeed.f398449id.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O9() {
        if (this.R.getRecyclerView() == null) {
            return 0;
        }
        RecyclerView.LayoutManager layoutManager = this.R.getRecyclerView().getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return 0;
        }
        return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int P9() {
        if (this.R.getRecyclerView() == null) {
            return 0;
        }
        RecyclerView.LayoutManager layoutManager = this.R.getRecyclerView().getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return 0;
        }
        return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U9() {
        if (this.T == null || this.f87666m == null || fb0.a.b("QFSBottomAlbumPanelPart", 500L)) {
            return;
        }
        if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            QLog.d("QFSBottomAlbumPanelPart", 1, "[handleCollect] forbid collect because of sencebeat");
            return;
        }
        xa(true ^ this.f87666m.isSelected());
        if (this.f87666m.isSelected()) {
            va();
        } else {
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188533wy), 0);
        }
        this.T.f3(this.f87666m.isSelected(), new QFSLayerAlbumViewModel.a() { // from class: com.tencent.biz.qqcircle.immersive.part.w
            @Override // com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel.a
            public final void a(boolean z16) {
                ac.la(z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V9(View view, Object obj) {
        if (obj instanceof b40.a) {
            b40.a aVar = (b40.a) obj;
            Aa(aVar);
            QFSPageIndexEvent qFSPageIndexEvent = new QFSPageIndexEvent(aVar.e());
            if (this.T != null) {
                qFSPageIndexEvent.hasMoreData = !r2.P1().isFinish();
            }
            SimpleEventBus.getInstance().dispatchEvent(qFSPageIndexEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W9() {
        RelativeLayout relativeLayout = this.N;
        if (relativeLayout != null && this.P != null && relativeLayout.getVisibility() == 0) {
            this.P.d();
            this.U.q(getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X9() {
        if (this.L != null && this.P != null) {
            this.N.setVisibility(0);
            this.P.o();
            za();
            return;
        }
        QLog.d("QFSBottomAlbumPanelPart", 1, "[handlePanelShow] mFeedAlbumInfo == null || mSlidView == null.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z9(QCircleAlbumBean qCircleAlbumBean) {
        if (qCircleAlbumBean == null) {
            QLog.e("QFSBottomAlbumPanelPart", 1, "[initAlbumBean] init album bean fail, end flow.");
            return;
        }
        this.K = qCircleAlbumBean;
        this.L = qCircleAlbumBean.getFeedAlbumInfo();
        this.M = qCircleAlbumBean.getFeed();
    }

    protected boolean ea() {
        return true;
    }

    protected boolean ga() {
        return true;
    }

    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QCircleFeedAlbumInfoEvent.class);
        arrayList.add(QCircleFeedAlbumInfoChangedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSBottomAlbumPanelPart";
    }

    protected boolean ha() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("layer_notify_part_update_feed".equals(str)) {
            Y9(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: handleFeedRsp, reason: merged with bridge method [inline-methods] */
    public void oa(UIStateData<List<e30.b>> uIStateData) {
        e30.b bVar;
        if (this.T != null && uIStateData != null && uIStateData.getData() != null && uIStateData.getData().size() != 0) {
            int i3 = 0;
            if (uIStateData.getState() == 4 && this.S.getItemCount() <= 1) {
                this.F.setVisibility(0);
                return;
            }
            this.F.setVisibility(8);
            List<e30.b> data = uIStateData.getData();
            List<b40.a> arrayList = new ArrayList<>();
            try {
                arrayList = c40.a.b(data, this.M);
                bVar = (e30.b) RFSafeListUtils.get(data, 0);
            } catch (Exception e16) {
                QLog.e("QFSBottomAlbumPanelPart", 1, "[handleFeedRsp] ex: ", e16);
                bVar = null;
            }
            QLog.d("QFSBottomAlbumPanelPart", 1, "[handleFeedRsp] personalAlbumInfoList: ", Integer.valueOf(arrayList.size()));
            sa(arrayList);
            ua(arrayList, this.f87663f);
            if (bVar != null && bVar.g() != null) {
                if (QCircleCommonUtil.isOwner(bVar.g().poster.f398463id.get())) {
                    this.f87665i.setVisibility(8);
                } else {
                    this.f87665i.setVisibility(0);
                }
                if (this.S != null) {
                    if (this.T.P1().getCurLoadMoreAction() == 1) {
                        this.D.n();
                        this.S.p0(arrayList);
                        return;
                    }
                    if (this.T.P1().getCurLoadMoreAction() == 0) {
                        this.S.o0(arrayList);
                        this.S.getLoadInfo().setFinish(uIStateData.getIsFinish());
                        this.S.notifyLoadingComplete(true);
                        return;
                    }
                    QCirclePanelLoadingView qCirclePanelLoadingView = this.E;
                    if (uIStateData.getState() != 1) {
                        i3 = 8;
                    }
                    qCirclePanelLoadingView.setVisibility(i3);
                    this.S.setData(arrayList);
                    this.S.getLoadInfo().setFinish(uIStateData.getIsFinish());
                    this.S.notifyLoadingComplete(true);
                    QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView = this.P;
                    if (qCircleAlbumSlidBottomView != null && qCircleAlbumSlidBottomView.getVisibility() == 8) {
                        getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.ab
                            @Override // java.lang.Runnable
                            public final void run() {
                                ac.this.ma();
                            }
                        }, 500L);
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.e("QFSBottomAlbumPanelPart", 1, "[handleFeedRsp] blockData == null || blockData.getSourceData() == null.");
        }
    }

    protected boolean ia() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViewModel() {
        if (this.K == null) {
            QLog.e("QFSBottomAlbumPanelPart", 1, "[initViewModel] album bean shouQFSVipNickNameAndIconViewld not be null.");
            return;
        }
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = (QFSLayerAlbumViewModel) getViewModel(QFSLayerAlbumViewModel.class);
        this.T = qFSLayerAlbumViewModel;
        qFSLayerAlbumViewModel.k3(this.K);
        this.T.S2().setValue(Boolean.valueOf(this.K.getFeedAlbumInfo().isDraft));
        ba();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f33540wq) {
            if (ja()) {
                W9();
            } else {
                X9();
            }
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(L9()));
            J9(this.f87663f, hashMap);
        } else if (id5 == R.id.f45951t_) {
            U9();
        } else if (id5 == R.id.f46231u1) {
            wa();
        } else if (id5 == R.id.f30680p0) {
            W9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.U != null) {
            QLog.d("QFSBottomAlbumPanelPart", 1, "[onConfigurationChanged] current config change, hide collect album tips.");
            this.U.q(getContext());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        init();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        K9(this.f87663f, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_ENTRANCE);
    }

    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel;
        if ((simpleBaseEvent instanceof QCircleFeedAlbumInfoEvent) && getHostFragment() != null && getHostFragment().isResumed()) {
            S9((QCircleFeedAlbumInfoEvent) simpleBaseEvent);
        }
        if ((simpleBaseEvent instanceof QCircleFeedAlbumInfoChangedEvent) && (qFSLayerAlbumViewModel = this.T) != null) {
            qFSLayerAlbumViewModel.l3(((QCircleFeedAlbumInfoChangedEvent) simpleBaseEvent).mFeedAlbumInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qa() {
        int max;
        QCircleAlbumPanelBlock qCircleAlbumPanelBlock = this.S;
        if (qCircleAlbumPanelBlock != null && qCircleAlbumPanelBlock.getDataList() != null && this.S.getDataList().size() > 0) {
            int Ba = Ba(this.S.getDataList());
            int P9 = P9();
            int O9 = O9();
            QLog.d("QFSBottomAlbumPanelPart", 1, "[locateTargetFeed] current select:" + Ba + " | firstVisibleItemPos: " + O9 + " | lastVisibleItemPos: " + P9);
            if (P9 == -1 && O9 == -1) {
                int max2 = Math.max(Ba - 1, 0);
                B1(max2);
                QLog.d("QFSBottomAlbumPanelPart", 1, "[locateTargetFeed]:" + max2);
                return;
            }
            if (O9 <= Ba && Ba <= P9) {
                if (Ba == O9) {
                    max = Math.max(Ba - 1, 0);
                } else {
                    max = Math.min(Ba + 2, this.S.getDataList().size() - 1);
                }
            } else if (Ba > P9) {
                max = Math.min(Ba + 2, this.S.getDataList().size() - 1);
            } else {
                max = Math.max(Ba - 1, 0);
            }
            B1(max);
            QLog.d("QFSBottomAlbumPanelPart", 1, "[locateTargetFeed]:" + max);
        }
    }

    public ac(QCircleAlbumBean qCircleAlbumBean) {
        Z9(qCircleAlbumBean);
    }

    @Override // z30.a
    public void onClick(View view, int i3, int i16, Object obj) {
        if (i3 == 1) {
            V9(view, obj);
        }
        W9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void la(boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements QCircleAlbumSlidBottomView.c {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
        public void onDismiss() {
            String str;
            ac.this.N.setVisibility(8);
            ac.this.T9(true);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = ac.this.M;
            if (feedCloudMeta$StFeed == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(3, str, false));
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
        public void onShow() {
            String str;
            ac.this.P.setParentConsumeEvent(false);
            ac.this.T9(false);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = ac.this.M;
            if (feedCloudMeta$StFeed == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(3, str, true));
            VideoReport.traversePage(ac.this.P);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
        }
    }
}
