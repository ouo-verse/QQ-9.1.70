package com.tencent.biz.qqcircle.immersive.album.view;

import a40.j;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleFeedAlbumInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.album.event.QCircleAlbumHideShareEvent;
import com.tencent.biz.qqcircle.immersive.album.event.QCircleFeedAlbumInfoChangedEvent;
import com.tencent.biz.qqcircle.immersive.album.event.QFSAlbumBanedEvent;
import com.tencent.biz.qqcircle.immersive.album.event.QFSAlbumProductListCleanEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel;
import com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$AlbumPageData;

/* loaded from: classes4.dex */
public class QFSPersonalAlbumDetailWidget extends QCircleBaseWidgetView<ArrayList<e30.b>> implements LifecycleOwner, SimpleEventReceiver {
    private static final String P = "com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalAlbumDetailWidget";
    private TextView C;
    private TextView D;
    private FrameLayout E;
    private FrameLayout F;
    private AlbumProductionListView G;
    private ViewGroup H;
    private View I;
    private View J;
    private LinearLayout K;
    private ImageView L;
    private TextView M;
    private QFSPublishTipsUtils N;

    /* renamed from: d, reason: collision with root package name */
    private final QCircleBaseFragment f84834d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.biz.qqcircle.bizparts.c f84835e;

    /* renamed from: f, reason: collision with root package name */
    private final LifecycleRegistry f84836f;

    /* renamed from: h, reason: collision with root package name */
    private QFSLayerAlbumViewModel f84837h;

    /* renamed from: i, reason: collision with root package name */
    private RoundCornerImageView f84838i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f84839m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSPersonalAlbumDetailWidget.this.H0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSPersonalAlbumDetailWidget(@NonNull Context context, QCircleBaseFragment qCircleBaseFragment, com.tencent.biz.qqcircle.bizparts.c cVar) {
        super(context);
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f84836f = lifecycleRegistry;
        this.N = new QFSPublishTipsUtils();
        A0(this);
        this.f84834d = qCircleBaseFragment;
        this.f84835e = cVar;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        B0();
        K0(this.f84837h.R2().getFeedAlbumInfo());
        if (this.f84837h.R2().getFeedAlbumInfo() != null) {
            N0(!com.tencent.biz.qqcircle.immersive.utils.r.v0(this.f84837h.R2().getFeedAlbumInfo().ownerUin));
            M0(this.f84837h.R2().getFeedAlbumInfo().isCollect);
        }
        if (this.f84837h.R2().getFeedAlbumInfo() != null) {
            this.G.setReportSourceAndAlbumId(c40.b.b(this.f84837h.R2()), String.valueOf(this.f84837h.R2().getFeedAlbumInfo().mAlbumId));
        }
        r0(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_ADD_PRODUCT);
        r0(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_MANAGE_PRODUCT);
    }

    private void A0(View view) {
        this.K = (LinearLayout) view.findViewById(R.id.f45951t_);
        this.L = (ImageView) view.findViewById(R.id.f44181oh);
        this.M = (TextView) view.findViewById(R.id.f55952ja);
        this.G = (AlbumProductionListView) view.findViewById(R.id.f27850hc);
        this.H = (ViewGroup) view.findViewById(R.id.ywv);
        this.I = view.findViewById(R.id.f33510wn);
        this.J = view.findViewById(R.id.f33760xb);
        this.f84838i = (RoundCornerImageView) view.findViewById(R.id.f164257p5);
        this.f84839m = (TextView) view.findViewById(R.id.f164289r3);
        this.D = (TextView) view.findViewById(R.id.skm);
        this.C = (TextView) view.findViewById(R.id.f166931j64);
        this.E = (FrameLayout) view.findViewById(R.id.loading);
        this.F = (FrameLayout) view.findViewById(R.id.skn);
        this.G.setFeedItemOnClickListener(new j.a() { // from class: com.tencent.biz.qqcircle.immersive.album.view.p
            @Override // a40.j.a
            public final void a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
                QFSPersonalAlbumDetailWidget.this.D0(feedCloudMeta$StFeed, i3);
            }
        });
        this.K.setOnClickListener(new a());
    }

    private void B0() {
        this.f84837h = (QFSLayerAlbumViewModel) getViewModel(this.f84834d, QFSLayerAlbumViewModel.class);
    }

    private void C0(Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        boolean z16;
        if (this.f84837h.O2().getValue().album.status.get() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        List<FeedCloudMeta$FeedAlbumInfo> list = feedCloudMeta$StFeed.album_infos.get();
        if (list != null && list.size() > 0) {
            QCircleFeedAlbumInfo qCircleFeedAlbumInfo = new QCircleFeedAlbumInfo(feedCloudMeta$StFeed.album_infos.get().get(0).album.f398441id.get());
            qCircleFeedAlbumInfo.isDraft = z16;
            QCircleAlbumBean qCircleAlbumBean = new QCircleAlbumBean(qCircleFeedAlbumInfo);
            qCircleAlbumBean.setFromReportBean(getReportBean().m466clone());
            qCircleAlbumBean.setSourceType(52);
            qCircleAlbumBean.setDataPosInList(i3);
            qCircleAlbumBean.setFeed(feedCloudMeta$StFeed);
            qCircleAlbumBean.setNeedShowAlbumPanel(false);
            qCircleAlbumBean.setPreRenderType(10011);
            com.tencent.biz.qqcircle.launcher.c.u(context, qCircleAlbumBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        C0(getContext(), feedCloudMeta$StFeed, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(Long l3, Long l16, boolean z16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.launcher.c.o0(getContext(), uq3.c.s3(String.valueOf(l3), String.valueOf(l16), z16), null, -1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(Long l3, boolean z16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.launcher.c.o0(getContext(), uq3.c.r3(String.valueOf(l3), z16), null, -1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        ImageView imageView;
        if (this.f84837h != null && (imageView = this.L) != null) {
            M0(!imageView.isSelected());
            if (this.L.isSelected()) {
                J0();
            } else {
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188533wy), 0);
            }
            this.f84837h.f3(this.L.isSelected(), new QFSLayerAlbumViewModel.a() { // from class: com.tencent.biz.qqcircle.immersive.album.view.q
                @Override // com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel.a
                public final void a(boolean z16) {
                    QFSPersonalAlbumDetailWidget.E0(z16);
                }
            });
        }
    }

    private void I0(int i3) {
        FrameLayout frameLayout = this.F;
        if (frameLayout != null) {
            frameLayout.setVisibility(i3);
            try {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (i3 == 0) {
                    layoutParams.height = -1;
                } else {
                    layoutParams.height = -2;
                }
                setLayoutParams(layoutParams);
            } catch (Exception e16) {
                QLog.e(P, 1, e16, new Object[0]);
            }
        }
    }

    private void J0() {
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = this.f84837h;
        if (qFSLayerAlbumViewModel != null && qFSLayerAlbumViewModel.O2().getValue() != null) {
            QQCircleFeedBase$AlbumPageData value = this.f84837h.O2().getValue();
            this.N.u(this.K, value.album.f398441id.get() + "", true);
        }
    }

    private void K0(QCircleFeedAlbumInfo qCircleFeedAlbumInfo) {
        if (qCircleFeedAlbumInfo == null) {
            return;
        }
        p0(this.f84838i, qCircleFeedAlbumInfo.coverUrl);
        if (qCircleFeedAlbumInfo.title.isEmpty()) {
            this.f84839m.setText("");
        } else {
            this.f84839m.setText(qCircleFeedAlbumInfo.title);
        }
        if (qCircleFeedAlbumInfo.description.isEmpty()) {
            this.D.setVisibility(8);
        } else {
            this.D.setVisibility(0);
            this.D.setText(qCircleFeedAlbumInfo.description);
        }
    }

    private void L0(QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData) {
        boolean z16;
        boolean z17;
        StringBuilder sb5 = new StringBuilder();
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField = qQCircleFeedBase$AlbumPageData.subsidiary_field_desc;
        if (pBRepeatMessageField != null && pBRepeatMessageField.get().size() > 0) {
            sb5.append(qQCircleFeedBase$AlbumPageData.subsidiary_field_desc.get().get(0).value.get());
            sb5.append(qQCircleFeedBase$AlbumPageData.subsidiary_field_desc.get().get(0).key.get());
            if (qQCircleFeedBase$AlbumPageData.subsidiary_field_desc.get().size() >= 2) {
                sb5.append(" / ");
                sb5.append(qQCircleFeedBase$AlbumPageData.subsidiary_field_desc.get().get(1).value.get());
                sb5.append(qQCircleFeedBase$AlbumPageData.subsidiary_field_desc.get().get(1).key.get());
            }
        }
        this.C.setText(sb5);
        FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = qQCircleFeedBase$AlbumPageData.album;
        if (feedCloudMeta$FeedAlbum != null) {
            String str = feedCloudMeta$FeedAlbum.owner.f398463id.get();
            long j3 = qQCircleFeedBase$AlbumPageData.album.f398441id.get();
            String str2 = qQCircleFeedBase$AlbumPageData.album.title.get();
            String str3 = qQCircleFeedBase$AlbumPageData.album.description.get();
            String str4 = qQCircleFeedBase$AlbumPageData.album.cover_url.get();
            if (qQCircleFeedBase$AlbumPageData.album.collection_info.status.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (qQCircleFeedBase$AlbumPageData.album.status.get() == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            QCircleFeedAlbumInfo qCircleFeedAlbumInfo = new QCircleFeedAlbumInfo(str, j3, str2, str3, str4, z16, z17);
            K0(qCircleFeedAlbumInfo);
            N0(!com.tencent.biz.qqcircle.immersive.utils.r.v0(qCircleFeedAlbumInfo.ownerUin));
            M0(qCircleFeedAlbumInfo.isCollect);
            this.f84837h.S2().setValue(Boolean.valueOf(qCircleFeedAlbumInfo.isDraft));
        }
    }

    private void M0(boolean z16) {
        String a16;
        if (this.M != null && this.L != null) {
            QLog.e(P, 1, "updateCollect:" + z16);
            this.L.setSelected(z16);
            TextView textView = this.M;
            if (z16) {
                a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f188783xm);
            } else {
                a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f188713xf);
            }
            textView.setText(a16);
        }
    }

    private void N0(boolean z16) {
        LinearLayout linearLayout = this.K;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(0);
    }

    private void O0(int i3, String str) {
        FrameLayout frameLayout = this.F;
        if (frameLayout == null) {
            return;
        }
        frameLayout.removeAllViews();
        this.F.addView(new QUIEmptyState.Builder(getContext()).setImageType(i3).setTitle(str).setDesc("").setBackgroundColorType(0).setAutoCenter(false).build());
        this.F.requestLayout();
    }

    private void P0() {
        final boolean z16;
        QQCircleFeedBase$AlbumPageData value = this.f84837h.O2().getValue();
        if (value != null && value.album.get() != null) {
            String str = this.f84837h.O2().getValue().album.owner.f398463id.get();
            final Long valueOf = Long.valueOf(this.f84837h.O2().getValue().album.f398441id.get());
            final Long valueOf2 = Long.valueOf(this.f84837h.O2().getValue().album.version_number.get());
            if (this.f84837h.O2().getValue().album.status.get() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (str != null && QCirclePluginUtil.isOwner(str)) {
                this.H.setVisibility(0);
                this.J.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.album.view.n
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QFSPersonalAlbumDetailWidget.this.F0(valueOf, valueOf2, z16, view);
                    }
                });
                this.I.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.album.view.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QFSPersonalAlbumDetailWidget.this.G0(valueOf, z16, view);
                    }
                });
                return;
            }
            this.H.setVisibility(8);
            return;
        }
        this.H.setVisibility(8);
    }

    private void p0(RoundCornerImageView roundCornerImageView, String str) {
        if (str == null) {
            return;
        }
        roundCornerImageView.setCorner(cx.a(4.0f));
        if (str.isEmpty()) {
            roundCornerImageView.setImageDrawable(v0());
        } else {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setTargetView(roundCornerImageView).setFailDrawable(v0()).setLoadingDrawable(v0()).setPredecode(true).setRequestWidth(roundCornerImageView.getLayoutParams().width).setRequestHeight(roundCornerImageView.getLayoutParams().height));
        }
    }

    private void r0(View view, String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(this.f84837h.R2().getFeedAlbumInfo().mAlbumId));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_SOURCE, c40.b.b(this.f84837h.R2()));
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, buildElementParams);
    }

    private void s0(int i3, int i16) {
        int i17;
        if (i16 == 0) {
            i17 = 8;
        } else {
            i17 = 0;
        }
        this.G.setVisibility(i17);
        I0(i17);
        this.E.setVisibility(i17);
        if (i3 == R.id.f27850hc) {
            this.G.setVisibility(i16);
        } else if (i3 == R.id.skn) {
            I0(i16);
        } else if (i3 == R.id.loading) {
            this.E.setVisibility(i16);
        }
    }

    private Drawable v0() {
        return com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.f162036nq1);
    }

    private void y0() {
        this.G.setData(new ArrayList());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QFSAlbumProductListCleanEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gld;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f84836f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return P;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f84836f.setCurrentState(Lifecycle.State.STARTED);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f84837h.j().observe(this.f84834d, new k(this));
        this.f84837h.O2().observe(this.f84834d, new l(this));
        this.f84837h.T2().observe(this.f84834d, new m(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f84836f.setCurrentState(Lifecycle.State.DESTROYED);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.f84837h.j().removeObserver(new k(this));
        this.f84837h.O2().removeObserver(new l(this));
        this.f84837h.T2().removeObserver(new m(this));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSAlbumProductListCleanEvent) {
            y0();
        }
    }

    public void u0(QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData) {
        if (qQCircleFeedBase$AlbumPageData == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_COLLECT_BUTTON_STATE, Integer.valueOf(qQCircleFeedBase$AlbumPageData.album.collection_info.status.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, qQCircleFeedBase$AlbumPageData.album.owner.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(qQCircleFeedBase$AlbumPageData.album.f398441id.get()));
        VideoReport.setElementId(this.K, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_DETAILS_COLLECT_BUTTON);
        VideoReport.setElementParams(this.K, buildElementParams);
    }

    public void w0(QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData) {
        L0(qQCircleFeedBase$AlbumPageData);
        P0();
        u0(qQCircleFeedBase$AlbumPageData);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedAlbumInfoChangedEvent(qQCircleFeedBase$AlbumPageData));
    }

    public void x0(boolean z16) {
        this.G.c().setNestedScrollingEnabled(z16);
    }

    public void z0(UIStateData<List<e30.b>> uIStateData) {
        int state = uIStateData.getState();
        boolean isLoadMore = uIStateData.getIsLoadMore();
        boolean isFinish = uIStateData.getIsFinish();
        if (state != 0) {
            if (state != 1) {
                if (state != 2) {
                    if (state != 3) {
                        if (state == 4) {
                            if (!isLoadMore) {
                                long retCode = uIStateData.getRetCode();
                                if (10022 != retCode && 10014 != retCode) {
                                    s0(R.id.skn, 0);
                                    O0(13, uq3.c.N1());
                                } else {
                                    SimpleEventBus.getInstance().dispatchEvent(new QCircleAlbumHideShareEvent());
                                    SimpleEventBus.getInstance().dispatchEvent(new QFSAlbumBanedEvent());
                                }
                                this.f84835e.getBlockMerger().showHint(false);
                                this.f84835e.getBlockMerger().onLoadMoreCompleted(false, isFinish);
                                return;
                            }
                            this.f84835e.notifyLoadingComplete(false, isFinish);
                            return;
                        }
                        return;
                    }
                    s0(R.id.f27850hc, 0);
                    if (isLoadMore) {
                        this.G.a(uIStateData.getData());
                    } else {
                        this.G.setData(uIStateData.getData());
                    }
                    this.f84835e.notifyLoadingComplete(true, isFinish);
                    return;
                }
                s0(R.id.f27850hc, 0);
                this.G.setData(uIStateData.getData());
                this.f84835e.notifyLoadingComplete(true, isFinish);
                return;
            }
            if (isLoadMore) {
                this.f84835e.getBlockMerger().showHint(true);
                this.f84835e.getLoadInfo().setCurrentState(3);
                return;
            } else {
                s0(R.id.loading, 0);
                return;
            }
        }
        if (!isLoadMore && (this.G.b() == null || this.G.b().size() == 0)) {
            s0(R.id.skn, 0);
            O0(16, uq3.c.S0());
            this.f84835e.getBlockMerger().showHint(false);
            this.f84835e.getBlockMerger().onLoadMoreCompleted(false, isFinish);
            return;
        }
        this.f84835e.notifyLoadingComplete(true, isFinish);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E0(boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void bindData(ArrayList<e30.b> arrayList, int i3) {
    }
}
