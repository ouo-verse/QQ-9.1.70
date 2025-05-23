package com.tencent.biz.qqcircle.immersive.views.search.hotrank;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.events.QFSShowSearchHotPanelEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSTransitionChangeLocationEvent;
import com.tencent.biz.qqcircle.immersive.utils.ac;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.widget.RightTextRecyclerLayout;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.immersive.views.search.util.m;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e80.c;
import e80.d;
import e80.g;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StSearchHotEventInfo;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import nb0.b;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public final class QFSSearchHotRankView extends QFSSearchBaseWidgetView<FeedCloudRead$StSearchHotEventInfo> implements g, c, d, View.OnClickListener {
    public static final int[] M = {R.drawable.nsz, R.drawable.f162077nt1, R.drawable.f162078nt2, R.drawable.f162079nt3, R.drawable.f162080nt4, R.drawable.nt5, R.drawable.nt6, R.drawable.nt7, R.drawable.nt8, R.drawable.f162076nt0};
    private View C;
    private final b90.b D;
    private final z80.b E;
    private n80.a F;
    private com.tencent.biz.qqcircle.immersive.views.search.hotrank.b G;
    private boolean H;
    private FeedCloudRead$StSearchHotEventInfo I;
    private boolean J;
    private m K;
    private final Observer<String> L;

    /* renamed from: e, reason: collision with root package name */
    private View f91142e;

    /* renamed from: f, reason: collision with root package name */
    private RightTextRecyclerLayout f91143f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f91144h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f91145i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f91146m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class JumpRunnable implements Runnable {
        JumpRunnable() {
        }

        private QCircleLayerBean e() {
            FeedCloudMeta$StFeed item = QFSSearchHotRankView.this.E.getItem(0);
            QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
            qCircleLayerBean.setDataPosInList(0);
            qCircleLayerBean.setFeed(item);
            qCircleLayerBean.setUseLoadingPic(true);
            qCircleLayerBean.setSourceType(QFSSearchHotRankView.this.getQCircleExtraTypeInfo().pageType);
            qCircleLayerBean.setLayerBizAssemblerType("biz_search_result_page");
            qCircleLayerBean.setGlobalViewModelKey(QFSSearchHotRankView.this.G.U1());
            qCircleLayerBean.setFeedListBusiReqData(new QQCircleFeedBase$StFeedListBusiReqData());
            qCircleLayerBean.setFromReportBean(QFSSearchHotRankView.this.getReportBean().setFromElement(QCircleDaTongConstant.ElementId.EM_XSJ_INFO_CARD));
            qCircleLayerBean.setTransInitBean(new QCircleInitBean());
            if (QFSSearchHotRankView.this.G.b2() != null) {
                qCircleLayerBean.setTransitionAnimBean(QFSSearchHotRankView.this.x0(item));
                qCircleLayerBean.setPageCode(QFSSearchHotRankView.this.G.b2().hashCode());
            }
            QLog.i("QFSSearchHotRankView", 1, "#getDetailInitBean:, id=" + item.f398449id.get() + ", content=" + ac.f90062a.a(item.content.get()) + ", playUrl=" + p.m(item));
            return qCircleLayerBean;
        }

        private void f() {
            QFSSearchPrerenderManager.E(QFSSearchHotRankView.this.getContext()).R(QFSSearchHotRankView.this.E.getItem(0), null, "hotRank", 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            w20.a.j().registerDisplaySurface(QFSSearchHotRankView.this.G.U1(), QFSSearchHotRankView.this.G.b2());
            com.tencent.biz.qqcircle.launcher.c.u(QFSSearchHotRankView.this.getContext(), e());
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements b.c {

        /* renamed from: d, reason: collision with root package name */
        private final int[] f91148d = new int[2];

        b() {
        }

        private void a(int i3) {
            Object c16 = QFSSearchHotRankView.this.K.c();
            if (!(c16 instanceof View)) {
                return;
            }
            View view = (View) c16;
            view.getLocationInWindow(this.f91148d);
            QFSTransitionChangeLocationEvent qFSTransitionChangeLocationEvent = new QFSTransitionChangeLocationEvent();
            qFSTransitionChangeLocationEvent.setLeft(this.f91148d[0]);
            qFSTransitionChangeLocationEvent.setTop(this.f91148d[1]);
            qFSTransitionChangeLocationEvent.setRight(this.f91148d[0] + view.getWidth());
            qFSTransitionChangeLocationEvent.setBottom(this.f91148d[1] + view.getHeight());
            if (QFSSearchHotRankView.this.G.b2() != null) {
                qFSTransitionChangeLocationEvent.setPageCode(QFSSearchHotRankView.this.G.b2().hashCode());
            } else {
                qFSTransitionChangeLocationEvent.setPageCode(QFSSearchHotRankView.this.hashCode());
            }
            qFSTransitionChangeLocationEvent.setCoverUrl(QFSSearchHotRankView.this.I.feedList.get(i3).cover.picUrl.get());
            SimpleEventBus.getInstance().dispatchEvent(qFSTransitionChangeLocationEvent);
        }

        @Override // nb0.b.c
        public void b(int i3) {
            if (QFSSearchHotRankView.this.H) {
                QFSSearchHotRankView.this.play();
            } else {
                a(i3);
            }
            QFSSearchPrerenderManager.E(QFSSearchHotRankView.this.getContext()).U("hotRank", i3);
        }
    }

    public QFSSearchHotRankView(@NonNull @NotNull Context context) {
        super(context);
        this.D = new b90.b();
        this.E = new z80.b();
        this.H = true;
        this.J = true;
        this.L = new Observer() { // from class: com.tencent.biz.qqcircle.immersive.views.search.hotrank.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSSearchHotRankView.this.D0((String) obj);
            }
        };
        A0(this);
    }

    private void A0(View view) {
        this.f91142e = view.findViewById(R.id.xbg);
        this.f91145i = (ImageView) view.findViewById(R.id.xbf);
        View findViewById = view.findViewById(R.id.f3629146);
        this.C = findViewById;
        findViewById.setOnClickListener(this);
        ((ImageView) view.findViewById(R.id.f43911nr)).setColorFilter(getContext().getColor(R.color.f157867cl0));
        this.f91146m = (TextView) view.findViewById(R.id.title);
        this.f91143f = (RightTextRecyclerLayout) view.findViewById(R.id.f71833p8);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f43781ne);
        this.f91144h = recyclerView;
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext(), 0, false));
        this.f91144h.setAdapter(this.E);
        this.E.l0(hashCode());
        h80.a aVar = new h80.a(new b());
        aVar.g("hotRank");
        this.f91144h.addOnScrollListener(aVar);
        n80.a aVar2 = new n80.a(8388611, aVar);
        this.F = aVar2;
        aVar2.attachToRecyclerView(this.f91144h);
        this.f91144h.addOnScrollListener(new a());
        this.K = new m(this.f91144h, this.E, this.F, hashCode());
        z0();
    }

    private void B0(List<FeedCloudMeta$StFeed> list) {
        if (list != null && list.size() == 1) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = list.get(0);
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("is_single_hot_feed");
            feedCloudMeta$StFeed.clientInfo.setHasFlag(true);
            feedCloudMeta$StFeed.clientInfo.clientMap.set(Collections.singletonList(feedCloudCommon$Entry));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(String str) {
        int v06 = v0(str);
        if (v06 >= 0 && v06 < this.E.getNUM_BACKGOURND_ICON() && v06 != this.F.f() && this.J && !this.H) {
            if (v06 == 0) {
                this.F.l(0);
            } else {
                this.F.n(v06);
            }
        }
    }

    private void E0(FeedCloudRead$StSearchHotEventInfo feedCloudRead$StSearchHotEventInfo) {
        this.G.Z1(feedCloudRead$StSearchHotEventInfo);
        this.G.X1(feedCloudRead$StSearchHotEventInfo.feedList.get());
    }

    private void F0() {
        int i3;
        if (this.I.rank.has()) {
            i3 = this.I.rank.get();
        } else {
            i3 = -1;
        }
        if (i3 > 0) {
            int[] iArr = M;
            if (i3 <= iArr.length) {
                this.f91145i.setVisibility(0);
                this.f91145i.setImageResource(iArr[i3 - 1]);
                return;
            }
        }
        this.f91145i.setVisibility(8);
    }

    private void G0() {
        String str = this.I.title.get();
        if (TextUtils.isEmpty(str)) {
            this.f91146m.setVisibility(8);
        } else {
            this.f91146m.setVisibility(0);
            this.f91146m.setText(str);
        }
    }

    private void s0() {
        i.k(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_VIEW_WHOLE_RANKLIST_BUTTON, null, this.I.hashCode());
    }

    private int v0(String str) {
        int num_backgournd_icon = this.E.getNUM_BACKGOURND_ICON();
        for (int i3 = 0; i3 < num_backgournd_icon; i3++) {
            if (TextUtils.equals(str, this.E.getItem(i3).f398449id.get())) {
                return i3;
            }
        }
        return -1;
    }

    private int w0() {
        return !C0() ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QFSTransitionAnimBean x0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSTransitionAnimBean.SourceRect sourceRect;
        View findViewByPosition;
        RecyclerView.LayoutManager layoutManager = this.E.getRecyclerView().getLayoutManager();
        if (layoutManager != null && (findViewByPosition = layoutManager.findViewByPosition(0)) != null) {
            int[] iArr = new int[2];
            findViewByPosition.getLocationInWindow(iArr);
            int i3 = iArr[0];
            sourceRect = new QFSTransitionAnimBean.SourceRect(i3, iArr[1], findViewByPosition.getWidth() + i3, iArr[1] + findViewByPosition.getHeight());
        } else {
            sourceRect = null;
        }
        if (sourceRect == null) {
            int screenWidth = ViewUtils.getScreenWidth() / 4;
            int screenHeight = ViewUtils.getScreenHeight() / 4;
            sourceRect = new QFSTransitionAnimBean.SourceRect(screenWidth, screenHeight, screenWidth * 3, screenHeight * 3);
        }
        return new QFSTransitionAnimBean().setLayoutRect(sourceRect).setImageUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setScaleType(ImageView.ScaleType.CENTER_CROP).setBackTransition(true);
    }

    private void y0() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_MUTE, Integer.valueOf(w0()));
        i.k(this, QCircleDaTongConstant.ElementId.EM_XSJ_HOT_CARD, hashMap, this.I.hashCode());
    }

    private void z0() {
        if (this.f91142e == null) {
            return;
        }
        if (QCircleSkinHelper.getInstance().isDarkMode()) {
            this.f91142e.setBackgroundResource(R.drawable.kfc);
        } else {
            this.f91142e.setBackgroundResource(R.drawable.kfb);
        }
    }

    public boolean C0() {
        return this.K.e();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        this.K.a();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gr8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchHotRankView";
    }

    @Override // e80.g
    public boolean isPlaying() {
        return this.K.isPlaying();
    }

    @Override // e80.c
    public boolean l() {
        return this.K.l();
    }

    @Override // e80.d
    public String o() {
        return "hotRank";
    }

    public void onActivityPause() {
        this.H = false;
    }

    public void onActivityResume() {
        this.H = true;
        this.J = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.G.M1().observe(getQCircleBaseFragment(), this.L);
        this.K.f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f3629146) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSShowSearchHotPanelEvent(true));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.G.M1().removeObserver(this.L);
        this.K.g();
    }

    @Override // e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        this.K.pause();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        this.K.play();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudRead$StSearchHotEventInfo feedCloudRead$StSearchHotEventInfo, int i3) {
        if (this.I == feedCloudRead$StSearchHotEventInfo) {
            return;
        }
        this.I = feedCloudRead$StSearchHotEventInfo;
        List<FeedCloudMeta$StFeed> list = feedCloudRead$StSearchHotEventInfo.feedList.get();
        B0(list);
        this.E.setDatas(list);
        E0(feedCloudRead$StSearchHotEventInfo);
        if (list != null && !list.isEmpty()) {
            this.f91142e.setVisibility(0);
            ad.t(this.f91143f, list, QCircleApplication.getAPP().getString(R.string.fr5), new JumpRunnable());
            G0();
            F0();
            this.D.b(this, this.I);
            this.F.l(0);
            y0();
            s0();
            return;
        }
        QLog.d("QFSSearchHotRankView", 1, "#bindData check feedList fail");
        this.f91142e.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void setExtraTypeInfo(Serializable serializable) {
        super.setExtraTypeInfo(serializable);
        this.E.j0(getQCircleExtraTypeInfo());
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView
    public void setFragment(Fragment fragment) {
        super.setFragment(fragment);
        com.tencent.biz.qqcircle.immersive.views.search.hotrank.b bVar = (com.tencent.biz.qqcircle.immersive.views.search.hotrank.b) getViewModel(com.tencent.biz.qqcircle.immersive.views.search.hotrank.b.class);
        this.G = bVar;
        bVar.O1(getContext());
        this.G.Q1("hotRank");
        this.E.k0(getQCircleBaseFragment());
    }

    @Override // e80.g
    public void stop() {
        this.K.stop();
    }

    public LiveData<UIStateData<List<e30.b>>> u0() {
        return this.G.j();
    }
}
