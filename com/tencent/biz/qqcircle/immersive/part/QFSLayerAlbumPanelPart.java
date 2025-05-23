package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleAlbumPanelBlock;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleFeedAlbumInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.immersive.album.event.QCircleFeedAlbumInfoChangedEvent;
import com.tencent.biz.qqcircle.immersive.album.event.QFSSelectAlbumEvent;
import com.tencent.biz.qqcircle.immersive.album.view.QCircleAlbumItemView;
import com.tencent.biz.qqcircle.immersive.album.view.QFSAlbumTabBar;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel;
import com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.qqcircle.utils.QFSHalfScreenFloatingView;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedAlbum$StVideoAlbumFeedInfo;
import qqcircle.QQCircleFeedBase$AlbumPageData;

/* loaded from: classes4.dex */
public class QFSLayerAlbumPanelPart extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, z30.a, SimpleEventReceiver {
    private TextView C;
    private TextView D;
    private TextView E;
    private ImageView F;
    protected QCircleAlbumBean G;
    protected QCircleFeedAlbumInfo H;
    protected FeedCloudMeta$StFeed I;
    protected RelativeLayout J;
    private QFSHalfScreenFloatingView K;
    protected LinearLayout L;
    protected QCircleBlockContainer M;
    protected QCircleAlbumPanelBlock N;
    protected QFSLayerAlbumViewModel P;
    private a40.k Q;
    private d40.c R;
    private QFSAlbumTabBar S;
    private LinearLayout T;
    private ImageView U;
    private Runnable V;
    private boolean W;
    private boolean X = false;
    private boolean Y = false;
    private boolean Z = false;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f87370a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    private QFSPublishTipsUtils f87371b0 = new QFSPublishTipsUtils();

    /* renamed from: c0, reason: collision with root package name */
    private int f87372c0;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f87373d;

    /* renamed from: d0, reason: collision with root package name */
    private NestScrollRecyclerView f87374d0;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f87375e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f87376f;

    /* renamed from: h, reason: collision with root package name */
    private RefreshHeaderView f87377h;

    /* renamed from: i, reason: collision with root package name */
    private QCirclePanelLoadingView f87378i;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f87379m;

    /* JADX INFO: Access modifiers changed from: package-private */
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
            QFSLayerAlbumPanelPart.this.Ma(new QCircleFeedAlbumInfo(str, j3, str2, str3, str4, z16, z17).isCollect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            QFSLayerAlbumPanelPart qFSLayerAlbumPanelPart = QFSLayerAlbumPanelPart.this;
            if (qFSLayerAlbumPanelPart.N == null) {
                return false;
            }
            if (!qFSLayerAlbumPanelPart.blockCanScrollDown() && !QFSLayerAlbumPanelPart.this.P.H2()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            QCircleAlbumPanelBlock qCircleAlbumPanelBlock = QFSLayerAlbumPanelPart.this.N;
            if ((qCircleAlbumPanelBlock != null && qCircleAlbumPanelBlock.getItemCount() != 0) || !QFSLayerAlbumPanelPart.this.va()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            return LayoutInflater.from(QFSLayerAlbumPanelPart.this.getContext()).inflate(R.layout.g7x, (ViewGroup) null, false);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            QLog.d("QFSTabAlbumPanelPart", 4, "maxHeight: " + QFSLayerAlbumPanelPart.this.aa());
            return QFSLayerAlbumPanelPart.this.aa();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends com.tencent.mobileqq.widget.qus.a {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            VideoReport.traversePage(QFSLayerAlbumPanelPart.this.K);
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
            com.tencent.biz.qqcircle.immersive.utils.ax.g(QFSLayerAlbumPanelPart.this.getContext(), false);
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(26, com.tencent.biz.qqcircle.utils.bj.g(QFSLayerAlbumPanelPart.this.I), true));
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, QFSLayerAlbumPanelPart.this.getContext()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements QUSBaseHalfScreenFloatingView.l {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
        public void onDismiss() {
            com.tencent.biz.qqcircle.immersive.utils.ax.g(QFSLayerAlbumPanelPart.this.getContext(), true);
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(26, com.tencent.biz.qqcircle.utils.bj.g(QFSLayerAlbumPanelPart.this.I), false));
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(true, QFSLayerAlbumPanelPart.this.getContext()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends RecyclerView.OnScrollListener {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
            QFSLayerAlbumViewModel qFSLayerAlbumViewModel = QFSLayerAlbumPanelPart.this.P;
            if (qFSLayerAlbumViewModel != null && qFSLayerAlbumViewModel.j().getValue() != null) {
                if (!QFSLayerAlbumPanelPart.this.M.canScrollVertically(-1)) {
                    int state = QFSLayerAlbumPanelPart.this.P.j().getValue().getState();
                    if ((state == 1 || state == 4) && QFSLayerAlbumPanelPart.this.P.P1().getCurLoadMoreAction() == 1 && QFSLayerAlbumPanelPart.this.P.H2()) {
                        QFSLayerAlbumPanelPart.this.f87377h.setState(2);
                    } else {
                        QFSLayerAlbumPanelPart.this.f87377h.n();
                    }
                } else {
                    QFSLayerAlbumPanelPart.this.f87377h.n();
                }
                UIStateData<List<e30.b>> value = QFSLayerAlbumPanelPart.this.P.j().getValue();
                if (value != null && value.getData() != null && !value.getData().isEmpty()) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if ((layoutManager instanceof LinearLayoutManager) && i3 == 0) {
                        int size = value.getData().size() - 1;
                        int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                        int min = Math.min(size, 2);
                        int min2 = Math.min(size, findFirstVisibleItemPosition + 2);
                        FeedCloudMeta$StFeed g16 = value.getData().get(min).g();
                        FeedCloudMeta$StFeed g17 = value.getData().get(min2).g();
                        if (g16 != null && g17 != null && g16.f398449id.get().equals(g17.f398449id.get()) && QFSLayerAlbumPanelPart.this.P.H2()) {
                            QFSLayerAlbumPanelPart.this.P.h3(1);
                        }
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            QFSLayerAlbumPanelPart.this.ia(recyclerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f extends RecyclerView.OnScrollListener {
        f() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g implements QUIPageTabBar.i {
        g() {
        }

        @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
        public void I0(int i3, boolean z16) {
            if (!z16) {
                return;
            }
            if (i3 == 0) {
                QFSLayerAlbumPanelPart.this.Ea();
            } else if (QFSLayerAlbumPanelPart.this.Q == null) {
                QFSLayerAlbumPanelPart.this.qa();
                QFSLayerAlbumPanelPart.this.Ja();
                QFSLayerAlbumPanelPart.this.X = true;
                QFSLayerAlbumPanelPart.this.R.T1(QFSLayerAlbumPanelPart.this.G.getFeedAlbumInfo().mAlbumId, true);
            } else if (QFSLayerAlbumPanelPart.this.Q.getItemCount() > 1 || QFSLayerAlbumPanelPart.this.Q.getLoadInfo().isFinish()) {
                QFSLayerAlbumPanelPart.this.Ga();
            } else {
                QFSLayerAlbumPanelPart.this.Ja();
                QFSLayerAlbumPanelPart.this.X = true;
                QFSLayerAlbumPanelPart.this.R.T1(QFSLayerAlbumPanelPart.this.G.getFeedAlbumInfo().mAlbumId, true);
            }
            QFSLayerAlbumPanelPart.this.La(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ba(LoadInfo loadInfo, Object obj) {
        if (!loadInfo.isLoadMoreState()) {
            return;
        }
        if (this.R.getCurrentAlbumId() != this.G.getFeedAlbumInfo().mAlbumId) {
            this.R.T1(this.G.getFeedAlbumInfo().mAlbumId, true);
            QLog.d("QFSTabAlbumPanelPart", 1, "mRelatedAlbumsBlock refresh");
        } else {
            this.R.T1(this.G.getFeedAlbumInfo().mAlbumId, false);
            QLog.d("QFSTabAlbumPanelPart", 1, "mRelatedAlbumsBlock load more");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Da(int i3) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        NestScrollRecyclerView nestScrollRecyclerView = this.f87374d0;
        if (nestScrollRecyclerView != null && i3 >= 1 && (findViewHolderForAdapterPosition = nestScrollRecyclerView.findViewHolderForAdapterPosition(i3 - 1)) != null) {
            int top = findViewHolderForAdapterPosition.itemView.getTop() - this.f87374d0.getPaddingTop();
            this.f87374d0.stopScroll();
            this.f87374d0.scrollBy(0, top);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ea() {
        QCircleAlbumPanelBlock qCircleAlbumPanelBlock = this.N;
        if (qCircleAlbumPanelBlock != null) {
            if ((qCircleAlbumPanelBlock.getDataList() == null && this.N.getDataList().size() == 0) || this.f87374d0 == null) {
                return;
            }
            if (this.W && this.Y) {
                this.Y = false;
                Ga();
                QLog.d("QFSTabAlbumPanelPart", 1, "[locateTargetFeed] relatedAlbum tab click, locate to related album.");
            } else {
                final int Oa = Oa(this.N.getDataList());
                this.f87374d0.stopScroll();
                this.f87374d0.scrollToPosition(Oa);
                this.f87374d0.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.bv
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSLayerAlbumPanelPart.this.Da(Oa);
                    }
                });
            }
        }
    }

    private void Fa(int i3) {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.P;
        if (qFSLayerAlbumViewModel == null) {
            QLog.d("QFSTabAlbumPanelPart", 1, "[requestAlbumList] album view model should not be null.");
        } else {
            qFSLayerAlbumViewModel.h3(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga() {
        QCircleBlockContainer qCircleBlockContainer = this.M;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getBlockMerger() != null && this.M.getRecyclerView() != null) {
            int blockPositionStartOffset = this.M.getBlockMerger().getBlockPositionStartOffset(this.Q);
            RecyclerView.LayoutManager layoutManager = this.M.getRecyclerView().getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(blockPositionStartOffset + 1, 0);
            }
            QLog.d("QFSTabAlbumPanelPart", 1, "scrollToRelateAlbum");
        }
    }

    private void Ha(List<b40.a> list) {
        if (list != null && list.size() != 0 && list.get(0).f() != null) {
            FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = list.get(0).f().album.get();
            String str = feedCloudMeta$FeedAlbum.title.get();
            int i3 = feedCloudMeta$FeedAlbum.feed_count.get();
            this.D.setText(String.format(getContext().getString(R.string.f195774fi), str));
            this.E.setText(getContext().getString(R.string.f1901841e) + i3 + getContext().getString(R.string.f1901941f));
        }
    }

    private void Ia() {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.P;
        if (qFSLayerAlbumViewModel != null && qFSLayerAlbumViewModel.O2().getValue() != null) {
            QQCircleFeedBase$AlbumPageData value = this.P.O2().getValue();
            this.f87371b0.u(this.f87373d, value.album.f398441id.get() + "", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ja() {
        if (this.V == null) {
            this.V = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerAlbumPanelPart.8
                @Override // java.lang.Runnable
                public void run() {
                    if (QFSLayerAlbumPanelPart.this.T != null) {
                        QFSLayerAlbumPanelPart.this.T.setVisibility(0);
                    }
                    if (QFSLayerAlbumPanelPart.this.U != null) {
                        QFSLayerAlbumPanelPart.this.U.setImageDrawable(LoadingUtil.getLoadingDrawable(QFSLayerAlbumPanelPart.this.getContext(), 1));
                    }
                }
            };
        }
        getMainHandler().postDelayed(this.V, 500L);
    }

    private void Ka() {
        if (this.P == null) {
            return;
        }
        ea();
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        qCircleShareInfo.type = 7;
        QQCircleFeedBase$AlbumPageData value = this.P.O2().getValue();
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
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.I;
        if (feedCloudMeta$StFeed2 != null) {
            qCircleReportBean.setFeedId(feedCloudMeta$StFeed2.f398449id.get());
            qCircleShareInfo.mReportBean.setAuthUin(this.I.poster.f398463id.get());
        }
        broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void La(int i3) {
        String a16;
        QFSAlbumTabBar qFSAlbumTabBar = this.S;
        if (qFSAlbumTabBar == null) {
            return;
        }
        VideoReport.setElementId(qFSAlbumTabBar, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_PANEL_TAB);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (i3 == 0) {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f188643x9);
        } else {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f194784cu);
        }
        buildElementParams.put("xsj_tab_name", a16);
        VideoReport.reportEvent("dt_clck", this.S, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ma(boolean z16) {
        ImageView imageView;
        String a16;
        if (this.f87376f != null && (imageView = this.f87375e) != null) {
            imageView.setSelected(z16);
            TextView textView = this.f87376f;
            if (z16) {
                a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f188783xm);
            } else {
                a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f188713xf);
            }
            textView.setText(a16);
        }
    }

    private void Na() {
        QCircleBlockContainer qCircleBlockContainer = this.M;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getBlockMerger() != null) {
            this.M.getBlockMerger().resetTryToLoadMoreCount();
        }
        NestScrollRecyclerView nestScrollRecyclerView = this.f87374d0;
        if (nestScrollRecyclerView == null) {
            return;
        }
        nestScrollRecyclerView.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.bz
            @Override // java.lang.Runnable
            public final void run() {
                QFSLayerAlbumPanelPart.this.Ea();
            }
        });
    }

    private int Oa(List<b40.a> list) {
        if (list == null || list.size() == 0 || this.I == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < list.size(); i16++) {
            b40.a aVar = list.get(i16);
            if (aVar != null && aVar.e() != null) {
                if (aVar.e().f398449id.get().equals(this.I.f398449id.get())) {
                    aVar.p(true);
                    i3 = i16;
                } else {
                    aVar.p(false);
                }
            }
        }
        return i3;
    }

    private void W9(View view, String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, buildElementParams);
    }

    private void X9() {
        this.f87373d.setOnClickListener(this);
        this.L.setOnClickListener(this);
        QCircleBlockContainer qCircleBlockContainer = this.M;
        if (qCircleBlockContainer == null) {
            return;
        }
        NestScrollRecyclerView recyclerView = qCircleBlockContainer.getRecyclerView();
        this.f87374d0 = recyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnScrollListener(new e());
        W9(this.f87373d, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_COLLECT_BUTTON);
        W9(this.L, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_SHARE_BUTTON);
    }

    private void Y9(UIStateData<List<e30.b>> uIStateData) {
        if (!this.W) {
            return;
        }
        if (this.Q != null) {
            QLog.d("QFSTabAlbumPanelPart", 1, "[checkGetRelatedAlbums] mRelatedAlbumsBlock is exist.");
            return;
        }
        if (this.P.P1().getCurLoadMoreAction() == 0) {
            if (this.N.getLoadInfo().isFinish() && ua()) {
                qa();
                return;
            }
            return;
        }
        if (this.P.P1().getCurLoadMoreAction() == 2 && uIStateData.getState() == 3 && this.N.getLoadInfo().isFinish() && uIStateData.getData().size() >= 1 && ua()) {
            qa();
            if (this.N.getItemCount() < 4) {
                this.R.T1(this.G.getFeedAlbumInfo().mAlbumId, true);
            }
        }
    }

    private void Z9() {
        if (!this.W) {
            return;
        }
        QCircleAlbumPanelBlock qCircleAlbumPanelBlock = this.N;
        if (qCircleAlbumPanelBlock != null) {
            qCircleAlbumPanelBlock.clearData();
        }
        a40.k kVar = this.Q;
        if (kVar != null) {
            kVar.clearData();
            this.M.unRegisterBlock(this.Q);
            QLog.d("QFSTabAlbumPanelPart", 1, "clearRelatedAlbumsBlock");
        }
        this.Q = null;
        this.X = false;
        this.Y = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aa() {
        int i3 = this.f87372c0;
        if (i3 != 0) {
            return i3;
        }
        int screenWidth = DisplayUtil.getScreenWidth();
        int screenHeight = DisplayUtil.getScreenHeight();
        if (!com.tencent.biz.qqcircle.utils.bz.r()) {
            screenWidth = Math.min(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth());
            screenHeight = Math.max(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth());
        }
        int i16 = (int) (screenWidth * 0.5625f);
        int i17 = screenHeight - i16;
        if (i17 < i16) {
            i17 = (int) (com.tencent.biz.qqcircle.utils.cx.b(this.J.getContext()) * 0.7d);
        }
        this.f87372c0 = i17;
        QLog.d("QFSTabAlbumPanelPart", 1, "[getCommentPanelHeight] panelHeight: " + i17 + ", topSpaceHeight: " + i16 + ", screenHeight: " + DisplayUtil.getScreenHeight());
        return i17;
    }

    private FeedCloudMeta$FeedAlbumInfo ba() {
        QCircleAlbumPanelBlock qCircleAlbumPanelBlock = this.N;
        if (qCircleAlbumPanelBlock == null) {
            return null;
        }
        b40.a item = this.N.getItem(qCircleAlbumPanelBlock.getItemCount() - 1);
        if (item == null) {
            QLog.d("QFSTabAlbumPanelPart", 1, "[getLastAlbumInfo] lastAlbumInfo is null or out of index.");
            return null;
        }
        return item.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blockCanScrollDown() {
        QCircleBlockContainer qCircleBlockContainer = this.M;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getRecyclerView() != null) {
            return this.M.getRecyclerView().canScrollVertically(-1);
        }
        return false;
    }

    private void ca() {
        if (this.P == null || this.f87375e == null || fb0.a.b("QFSTabAlbumPanelPart", 500L)) {
            return;
        }
        if (com.tencent.biz.qqcircle.helpers.d.a(1, true)) {
            QLog.d("QFSTabAlbumPanelPart", 1, "[handleCollect] forbid collect because of sencebeat");
            return;
        }
        Ma(true ^ this.f87375e.isSelected());
        if (this.f87375e.isSelected()) {
            Ia();
        } else {
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188533wy), 0);
        }
        this.P.f3(this.f87375e.isSelected(), new QFSLayerAlbumViewModel.a() { // from class: com.tencent.biz.qqcircle.immersive.part.bs
            @Override // com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel.a
            public final void a(boolean z16) {
                QFSLayerAlbumPanelPart.xa(z16);
            }
        });
    }

    private void da(Object obj) {
        if (obj instanceof b40.a) {
            wa((b40.a) obj);
        }
    }

    private void ea() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView;
        if (this.J != null && (qFSHalfScreenFloatingView = this.K) != null && qFSHalfScreenFloatingView.getVisibility() == 0) {
            this.K.t();
            this.f87371b0.q(getContext());
        }
    }

    private void ga() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView;
        if (this.H != null && (qFSHalfScreenFloatingView = this.K) != null && qFSHalfScreenFloatingView.getVisibility() != 0) {
            this.K.P(0);
        } else {
            QLog.d("QFSTabAlbumPanelPart", 1, "[handlePanelShow] mFeedAlbumInfo == null || mSlidView == null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ha, reason: merged with bridge method [inline-methods] */
    public void Ca(UIStateData<List<QQCircleFeedAlbum$StVideoAlbumFeedInfo>> uIStateData) {
        a40.k kVar;
        FeedCloudMeta$FeedAlbumInfo ba5;
        QCircleAlbumBean qCircleAlbumBean;
        la();
        if (this.W && uIStateData != null && uIStateData.getData() != null && uIStateData.getData().size() != 0 && (kVar = this.Q) != null && this.N != null) {
            kVar.setDatas(uIStateData.getData());
            this.Q.getLoadInfo().setFinish(uIStateData.getIsFinish());
            this.Q.notifyLoadingComplete(true);
            if (!this.N.getLoadInfo().isFinish() && !uIStateData.getIsLoadMore() && (ba5 = ba()) != null && ba5.feed_serial_number.get() < ba5.album.feed_count.get()) {
                QLog.d("QFSTabAlbumPanelPart", 1, "handleRelatedAlbumsList, refresh albums");
                d40.c cVar = this.R;
                if (cVar != null && cVar.getLastFeed() != null && (qCircleAlbumBean = this.G) != null && !this.R.S1(qCircleAlbumBean.getFeedId())) {
                    this.G.setFeed(this.R.getLastFeed().feed.get());
                    this.P.k3(this.G);
                    this.P.h3(2);
                    this.Y = true;
                }
            }
            if (!uIStateData.getIsLoadMore() && this.X) {
                this.X = false;
                Ga();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleFeedRsp, reason: merged with bridge method [inline-methods] */
    public void Aa(UIStateData<List<e30.b>> uIStateData) {
        if (this.P == null || uIStateData == null || uIStateData.getData() == null || uIStateData.getData().size() == 0 || uIStateData.getState() == 6) {
            return;
        }
        int i3 = 0;
        if (uIStateData.getState() == 4 && this.N.getItemCount() <= 1) {
            this.f87379m.setVisibility(0);
            return;
        }
        this.f87379m.setVisibility(8);
        List<e30.b> data = uIStateData.getData();
        List<b40.a> arrayList = new ArrayList<>();
        try {
            arrayList = c40.a.b(data, this.I);
        } catch (ConcurrentModificationException e16) {
            QLog.e("QFSTabAlbumPanelPart", 1, "[handleFeedRsp] ex: ", e16);
        }
        QLog.d("QFSTabAlbumPanelPart", 1, "[handleFeedRsp] personalAlbumInfoList: ", Integer.valueOf(arrayList.size()));
        Ha(arrayList);
        e30.b bVar = (e30.b) RFSafeListUtils.get(data, 0);
        if (bVar != null && bVar.g() != null) {
            if (QCircleCommonUtil.isOwner(bVar.g().poster.f398463id.get())) {
                this.f87373d.setVisibility(8);
            } else {
                this.f87373d.setVisibility(0);
            }
            if (this.N != null) {
                QLog.d("QFSTabAlbumPanelPart", 1, "getCurLoadMoreAction " + this.P.P1().getCurLoadMoreAction());
                if (this.P.P1().getCurLoadMoreAction() == 1) {
                    this.f87377h.n();
                    this.N.p0(arrayList);
                } else if (this.P.P1().getCurLoadMoreAction() == 0) {
                    this.N.o0(arrayList);
                    this.N.getLoadInfo().setFinish(uIStateData.getIsFinish());
                    this.N.notifyLoadingComplete(true);
                } else {
                    QCirclePanelLoadingView qCirclePanelLoadingView = this.f87378i;
                    if (uIStateData.getState() != 1) {
                        i3 = 8;
                    }
                    qCirclePanelLoadingView.setVisibility(i3);
                    this.N.setData(arrayList);
                    this.N.getLoadInfo().setFinish(uIStateData.getIsFinish());
                    this.N.notifyLoadingComplete(true);
                    if (uIStateData.getState() != 3 || this.K == null) {
                        return;
                    }
                    Na();
                    VideoReport.traversePage(this.K);
                }
                Y9(uIStateData);
                return;
            }
            return;
        }
        QLog.e("QFSTabAlbumPanelPart", 1, "[handleFeedRsp] blockData == null || blockData.getSourceData() == null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(RecyclerView recyclerView) {
        if (this.W && this.S != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                return;
            }
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition());
            if (findViewHolderForAdapterPosition != null && (findViewHolderForAdapterPosition.itemView instanceof QCircleAlbumItemView)) {
                this.S.setCurrentPosition(0);
            } else {
                this.S.setCurrentPosition(1);
            }
        }
    }

    private void initBlockContainer() {
        this.M.setLayoutManagerType(1, 1);
        this.M.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.M.setEnableLoadMore(true);
        this.M.setEnableRefresh(false);
        this.M.setParentFragment(getHostFragment());
        this.M.getRecyclerView().setNestedScrollingEnabled(true);
        ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
        QCircleAlbumPanelBlock qCircleAlbumPanelBlock = new QCircleAlbumPanelBlock(null, null);
        this.N = qCircleAlbumPanelBlock;
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            qCircleAlbumPanelBlock.setReportBean(qCircleReportBean);
        }
        arrayList.add(this.N);
        this.N.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.biz.qqcircle.immersive.part.bt
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                QFSLayerAlbumPanelPart.this.za(loadInfo, obj);
            }
        });
        this.N.addOnScrollListener(new f());
        this.N.x0(this);
        this.M.getRecyclerView().setItemAnimator(new EnhanceItemAnimator());
        if (this.M.getRecyclerView().getItemAnimator() instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) this.M.getRecyclerView().getItemAnimator()).setSupportsChangeAnimations(false);
        }
        this.M.registerBlock(arrayList);
        this.M.start();
    }

    private void initHalfScreenView() {
        this.K.q();
        this.K.v(false);
        this.K.r();
        this.K.setQUSDragFloatController(new b());
        this.K.j(new c());
        this.K.T(new d());
        if (this.K.x() instanceof ViewGroup) {
            ((ViewGroup) this.K.x()).setClipToPadding(false);
            ((ViewGroup) this.K.x()).setClipChildren(false);
        }
        this.K.setClipToPadding(false);
        this.K.setClipChildren(false);
        com.tencent.mobileqq.qui.b.f276860a.a(this.K, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
    }

    private void initViewModel() {
        if (this.G == null) {
            QLog.e("QFSTabAlbumPanelPart", 1, "[initViewModel] album bean shouQFSVipNickNameAndIconViewld not be null.");
            return;
        }
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = (QFSLayerAlbumViewModel) getViewModel(QFSLayerAlbumViewModel.class);
        this.P = qFSLayerAlbumViewModel;
        qFSLayerAlbumViewModel.k3(this.G);
        this.P.S2().setValue(Boolean.valueOf(this.G.getFeedAlbumInfo().isDraft));
        if (this.Z) {
            return;
        }
        this.Z = true;
        oa();
        sa();
    }

    private void ja(@NonNull QFSSelectAlbumEvent qFSSelectAlbumEvent) {
        QCircleAlbumBean albumBean;
        FeedCloudMeta$StFeed feed;
        if (qFSSelectAlbumEvent.getHashCode() != getContext().hashCode() || (albumBean = qFSSelectAlbumEvent.getAlbumBean()) == null || (feed = albumBean.getFeed()) == null) {
            return;
        }
        boolean z16 = true;
        QLog.d("QFSTabAlbumPanelPart", 1, "[handleTabAlbumInfoEvent] feed id:" + com.tencent.biz.qqcircle.utils.bj.g(feed));
        na();
        if (this.I != null && TextUtils.equals(feed.f398449id.get(), this.I.f398449id.get())) {
            this.I = feed;
        } else {
            Z9();
            ma(albumBean);
            initViewModel();
            startInit();
            this.P.j3(this.I.f398449id.get());
            this.P.Y2(this.I, true);
            QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.P;
            if (this.I == null) {
                z16 = false;
            }
            qFSLayerAlbumViewModel.i3(2, z16);
        }
        ga();
    }

    private void la() {
        if (this.V != null) {
            getMainHandler().removeCallbacks(this.V);
        }
        LinearLayout linearLayout = this.T;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ImageView imageView = this.U;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
    }

    private void ma(QCircleAlbumBean qCircleAlbumBean) {
        if (qCircleAlbumBean == null) {
            QLog.e("QFSTabAlbumPanelPart", 1, "[initAlbumBean] init album bean fail, end flow.");
            return;
        }
        this.G = qCircleAlbumBean;
        this.H = qCircleAlbumBean.getFeedAlbumInfo();
        this.I = qCircleAlbumBean.getFeed();
    }

    private void na() {
        if (!this.f87370a0) {
            this.f87370a0 = true;
            com.tencent.biz.qqcircle.utils.k.j("exp_xsj_related_albums_recommend_2");
        }
        this.W = com.tencent.biz.qqcircle.utils.k.h("exp_xsj_related_albums_recommend_2");
    }

    private void oa() {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.P;
        if (qFSLayerAlbumViewModel == null) {
            return;
        }
        qFSLayerAlbumViewModel.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.bx
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSLayerAlbumPanelPart.this.Aa((UIStateData) obj);
            }
        });
        this.P.O2().observe(getHostFragment(), new a());
    }

    private void pa() {
        RelativeLayout relativeLayout = (RelativeLayout) getPartRootView().findViewById(R.id.f33830xi);
        this.J = relativeLayout;
        this.K = (QFSHalfScreenFloatingView) relativeLayout.findViewById(R.id.f33670x3);
        initHalfScreenView();
        this.M = (QCircleBlockContainer) this.J.findViewById(R.id.f30690p1);
        this.L = (LinearLayout) this.J.findViewById(R.id.f46231u1);
        this.f87373d = (LinearLayout) this.J.findViewById(R.id.f45951t_);
        this.f87375e = (ImageView) this.J.findViewById(R.id.f44181oh);
        this.f87376f = (TextView) this.J.findViewById(R.id.f55952ja);
        this.D = (TextView) this.J.findViewById(R.id.sl5);
        this.E = (TextView) this.J.findViewById(R.id.f164272sl4);
        this.f87377h = (RefreshHeaderView) this.J.findViewById(R.id.f166126ys0);
        this.f87378i = (QCirclePanelLoadingView) this.J.findViewById(R.id.f30670oz);
        ViewGroup viewGroup = (ViewGroup) this.J.findViewById(R.id.f33790xe);
        this.f87379m = viewGroup;
        TextView textView = (TextView) viewGroup.findViewById(R.id.f166327f13);
        this.C = textView;
        textView.setText(uq3.c.w3());
        ImageView imageView = (ImageView) this.J.findViewById(R.id.f30680p0);
        this.F = imageView;
        imageView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
        if (!this.W) {
            return;
        }
        if (this.Q == null) {
            a40.k kVar = new a40.k(new Bundle());
            this.Q = kVar;
            kVar.getLoadInfo().setFinish(false);
            QCircleReportBean qCircleReportBean = this.mReportBean;
            if (qCircleReportBean != null) {
                this.Q.setReportBean(qCircleReportBean);
            }
            this.Q.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.biz.qqcircle.immersive.part.bu
                @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
                public final void onLoadData(LoadInfo loadInfo, Object obj) {
                    QFSLayerAlbumPanelPart.this.Ba(loadInfo, obj);
                }
            });
            this.M.registerBlock(this.Q);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QQCircleFeedAlbum$StVideoAlbumFeedInfo());
        this.Q.setDatas(arrayList);
        this.Q.getLoadInfo().setFinish(false);
        QLog.d("QFSTabAlbumPanelPart", 1, "initRelatedAlbumsBlock");
    }

    private void ra() {
        this.T = (LinearLayout) this.J.findViewById(R.id.f33570wt);
        this.U = (ImageView) this.J.findViewById(R.id.f33560ws);
        LinearLayout linearLayout = this.T;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private void sa() {
        if (!this.W) {
            return;
        }
        d40.c cVar = (d40.c) getViewModel(d40.c.class);
        this.R = cVar;
        cVar.P1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.bw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSLayerAlbumPanelPart.this.Ca((UIStateData) obj);
            }
        });
    }

    private void ta() {
        int i3;
        LinearLayout linearLayout = (LinearLayout) this.J.findViewById(R.id.f33580wu);
        if (linearLayout == null) {
            return;
        }
        if (linearLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            if (this.W) {
                i3 = 122;
            } else {
                i3 = 95;
            }
            ((FrameLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = com.tencent.biz.qqcircle.utils.cx.a(i3);
        }
        QFSAlbumTabBar qFSAlbumTabBar = (QFSAlbumTabBar) this.J.findViewById(R.id.f33820xh);
        this.S = qFSAlbumTabBar;
        if (qFSAlbumTabBar == null) {
            return;
        }
        if (!this.W) {
            qFSAlbumTabBar.setVisibility(8);
            return;
        }
        qFSAlbumTabBar.setVisibility(0);
        this.S.setTabData(new String[]{com.tencent.biz.qqcircle.utils.h.a(R.string.f188643x9), com.tencent.biz.qqcircle.utils.h.a(R.string.f194784cu)});
        this.S.setTabChangeListener(new g());
    }

    private boolean ua() {
        FeedCloudMeta$FeedAlbumInfo ba5;
        boolean z16;
        boolean z17;
        if (this.N == null || this.H == null || (ba5 = ba()) == null) {
            return false;
        }
        if (this.H.mAlbumId == ba5.album.f398441id.get()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (ba5.feed_serial_number.get() >= ba5.album.feed_count.get()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean va() {
        a40.k kVar = this.Q;
        if (kVar != null && kVar.getItemCount() != 0) {
            return false;
        }
        return true;
    }

    private void wa(b40.a aVar) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        boolean z16 = true;
        if (aVar != null && aVar.f() != null) {
            FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = aVar.f().album.get();
            RFWPlayerPreRenderHelper rFWPlayerPreRenderHelper = RFWPlayerPreRenderHelper.getInstance();
            RFWPlayerPreRenderBean activity = new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10004).setActivity((Activity) getContext());
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.I;
            if (feedCloudMeta$StFeed != null) {
                feedCloudMeta$StVideo = feedCloudMeta$StFeed.video;
            } else {
                feedCloudMeta$StVideo = null;
            }
            rFWPlayerPreRenderHelper.playerRender(gb0.b.f(activity.setPreloadVideo(gb0.b.k(feedCloudMeta$StVideo)).setPreloadOriginData(gb0.b.m(new e30.b(this.I))).setSourceType(com.tencent.biz.qqcircle.immersive.manager.g.e().i(getReportBean())).setIsJumpTrigger(uq3.o.U0()).setMultiLevel(false)));
            QCircleFeedAlbumInfo qCircleFeedAlbumInfo = new QCircleFeedAlbumInfo(feedCloudMeta$FeedAlbum.f398441id.get());
            qCircleFeedAlbumInfo.title = feedCloudMeta$FeedAlbum.title.get();
            qCircleFeedAlbumInfo.mFeedCount = feedCloudMeta$FeedAlbum.feed_count.get();
            if (feedCloudMeta$FeedAlbum.status.get() != 2) {
                z16 = false;
            }
            qCircleFeedAlbumInfo.isDraft = z16;
            QCircleAlbumBean qCircleAlbumBean = new QCircleAlbumBean(qCircleFeedAlbumInfo);
            qCircleAlbumBean.setNeedShowAlbumPanel(false);
            try {
                qCircleAlbumBean.setFromReportBean(getReportBean().m466clone());
            } catch (Exception e16) {
                RFWLog.i("QFSTabAlbumPanelPart", RFWLog.USR, "[jumpAlbumPage] -> " + e16.getMessage());
            }
            qCircleAlbumBean.setSourceType(52);
            qCircleAlbumBean.setFeed(aVar.e());
            com.tencent.biz.qqcircle.launcher.c.u(getContext(), qCircleAlbumBean);
            return;
        }
        QLog.e("QFSTabAlbumPanelPart", 1, "[jumpAlbumPage] mFeedAlbum is null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void za(LoadInfo loadInfo, Object obj) {
        QLog.d("QFSTabAlbumPanelPart", 1, "[initBlockContainer] loadInfo.isLoadMoreState(): " + loadInfo.isLoadMoreState());
        if (loadInfo.isLoadMoreState()) {
            Fa(0);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QFSSelectAlbumEvent.class);
        arrayList.add(QCircleFeedAlbumInfoChangedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.f33840xj;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTabAlbumPanelPart";
    }

    public boolean isShow() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView;
        if (this.J != null && (qFSHalfScreenFloatingView = this.K) != null && qFSHalfScreenFloatingView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QLog.d("QFSTabAlbumPanelPart", 1, "Album_onBackEvent");
        if (isShow()) {
            ea();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f45951t_) {
            ca();
        } else if (id5 == R.id.f46231u1) {
            Ka();
        } else if (id5 == R.id.f30680p0) {
            ea();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f87372c0 = 0;
        if (this.f87371b0 != null) {
            QLog.d("QFSTabAlbumPanelPart", 1, "[onConfigurationChanged] current config change, hide collect album tips.");
            this.f87371b0.q(getContext());
        }
        if (uq3.o.o1()) {
            ea();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel;
        int i3;
        pa();
        X9();
        initBlockContainer();
        ta();
        ra();
        if (this.L != null && (qFSLayerAlbumViewModel = this.P) != null && qFSLayerAlbumViewModel.S2() != null) {
            LinearLayout linearLayout = this.L;
            if (this.P.S2().getValue().booleanValue()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            linearLayout.setVisibility(i3);
        }
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

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel;
        if (simpleBaseEvent instanceof QFSSelectAlbumEvent) {
            ja((QFSSelectAlbumEvent) simpleBaseEvent);
        }
        if ((simpleBaseEvent instanceof QCircleFeedAlbumInfoChangedEvent) && (qFSLayerAlbumViewModel = this.P) != null) {
            qFSLayerAlbumViewModel.l3(((QCircleFeedAlbumInfoChangedEvent) simpleBaseEvent).mFeedAlbumInfo);
        }
    }

    @Override // z30.a
    public void onClick(View view, int i3, int i16, Object obj) {
        if (i3 == 1) {
            da(obj);
        }
        ea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void xa(boolean z16) {
    }
}
