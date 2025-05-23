package com.tencent.biz.qqcircle.immersive.views.search.feed;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QFSVideoOnPlayEvent;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.feed.ad.ae;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.utils.ac;
import com.tencent.biz.qqcircle.immersive.views.search.feed.QFSSearchFeedResultItemView;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.b;
import e80.c;
import e80.d;
import e80.g;
import e80.h;
import e80.j;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import q80.f;
import q80.k;
import q80.n;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;
import r80.a;
import s80.e;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchFeedResultItemView extends QFSSearchBaseWidgetView<b> implements g, SimpleEventReceiver, c, d, h, View.OnClickListener {
    private FeedCloudMeta$StFeed C;
    private boolean D;
    private f80.d E;
    private View F;
    private GdtAd G;
    private int H;
    private b I;
    private QFSSearchInfo J;
    private Runnable K;

    /* renamed from: e, reason: collision with root package name */
    private final j<FeedCloudMeta$StFeed> f91114e;

    /* renamed from: f, reason: collision with root package name */
    private s80.h f91115f;

    /* renamed from: h, reason: collision with root package name */
    private e f91116h;

    /* renamed from: i, reason: collision with root package name */
    private s80.b f91117i;

    /* renamed from: m, reason: collision with root package name */
    private n f91118m;

    public QFSSearchFeedResultItemView(@NonNull Context context) {
        super(context);
        j<FeedCloudMeta$StFeed> jVar = new j<>();
        this.f91114e = jVar;
        this.D = true;
        n nVar = new n();
        this.f91118m = nVar;
        jVar.c(nVar);
        jVar.c(new q80.d());
        jVar.c(new r80.d());
        jVar.c(new a());
        jVar.c(new r80.e());
        jVar.c(new q80.j());
        jVar.c(new f());
        jVar.c(new k());
        jVar.c(new q80.c());
        jVar.c(new q80.b());
        jVar.h(this);
    }

    private void A0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(i3));
        hashMap.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_NAME, feedCloudMeta$StFeed.poster.nick.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_MUTE, Integer.valueOf(n0()));
        hashMap.put("xsj_eid", l0());
        hashMap.put("eid", l0());
        if (feedCloudMeta$StFeed.type.get() == 2 && feedCloudMeta$StFeed.images.has()) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_TYPE, 2);
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_PIC_NUM, Integer.valueOf(feedCloudMeta$StFeed.images.size()));
        }
        QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
        try {
            qQCircleFeedBase$StReportInfoForClient.mergeFrom(feedCloudMeta$StFeed.reportInfoForClient.get().toByteArray());
            if (!TextUtils.isEmpty(qQCircleFeedBase$StReportInfoForClient.datongJsonData.get())) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            QLog.w("QFSSearchFeedResultItemView", 1, "[resultItemDtReport] InvalidProtocolBufferMicroException");
        }
        ae.d(this.G, hashMap);
        i.k(this, l0(), hashMap, feedCloudMeta$StFeed.hashCode());
    }

    private void B0() {
        Serializable extraTypeInfo = getExtraTypeInfo();
        if (extraTypeInfo instanceof QCircleExtraTypeInfo) {
            this.f91114e.i(extraTypeInfo);
        }
    }

    private void C0(b bVar) {
        this.C = u.c(bVar);
        this.G = new GdtAd(u.e(bVar));
        setExtraTypeInfo(ae.b(bVar.g(), this.H));
        this.E = new f80.d(this.G, this.H, this.F, this.J);
        this.F.setOnClickListener(this);
    }

    private String l0() {
        if (p.w(this.C)) {
            return QCircleDaTongConstant.ElementId.EM_XSJ_AD_FEED;
        }
        return QCircleDaTongConstant.ElementId.EM_XSJ_FEED;
    }

    private e m0() {
        if (this.f91116h == null) {
            e eVar = new e();
            this.f91116h = eVar;
            eVar.N0(this);
        }
        return this.f91116h;
    }

    private int n0() {
        s80.b bVar = this.f91117i;
        if (bVar != null && bVar.k1()) {
            return 0;
        }
        return 1;
    }

    private s80.h p0() {
        if (this.f91115f == null) {
            s80.h hVar = new s80.h();
            this.f91115f = hVar;
            hVar.N0(this);
        }
        return this.f91115f;
    }

    private void q0(int i3) {
        s80.b bVar = this.f91117i;
        if (bVar != null) {
            this.f91114e.d(bVar);
            this.f91117i.i1();
        }
        if (i3 != 2) {
            if (i3 != 3) {
                this.f91117i = null;
                QLog.w("QFSSearchFeedResultItemView", 1, "#initPresenter: unknown type: " + i3 + ", id=" + this.C.f398449id.get() + ", content=" + ac.f90062a.a(this.C.content.get()));
            } else {
                this.f91117i = p0();
            }
        } else {
            this.f91117i = m0();
        }
        s80.b bVar2 = this.f91117i;
        if (bVar2 != null) {
            this.f91114e.c(bVar2);
        }
        B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0() {
        f80.d dVar = this.E;
        if (dVar != null) {
            dVar.j();
        }
    }

    private void v0(QFSVideoOnPlayEvent qFSVideoOnPlayEvent) {
        s80.b bVar;
        if (this.C != null && (bVar = this.f91117i) != null) {
            bVar.z1(false);
            if (this.C.f398449id.get().equals(qFSVideoOnPlayEvent.getFeedId()) && qFSVideoOnPlayEvent.getPlayHashCode() == hashCode()) {
                return;
            }
            stop();
            this.f91117i.j1();
        }
    }

    private void w0(View view, int i3) {
        p.E(this.I, view, this.H, i3);
    }

    private void x0() {
        z0();
        if (this.K == null) {
            this.K = new Runnable() { // from class: o80.a
                @Override // java.lang.Runnable
                public final void run() {
                    QFSSearchFeedResultItemView.this.r0();
                }
            };
        }
        postDelayed(this.K, 500L);
    }

    private void z0() {
        Runnable runnable = this.K;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // e80.h
    public void H() {
        this.f91114e.H();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        this.f91114e.a();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSVideoOnPlayEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gqv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchFeedResultItemView";
    }

    @Override // e80.g
    public boolean isPlaying() {
        return this.f91114e.isPlaying();
    }

    @Override // e80.c
    public boolean l() {
        s80.b bVar = this.f91117i;
        if (bVar != null && bVar.l()) {
            return true;
        }
        return false;
    }

    @Override // e80.d
    public String o() {
        return "feed";
    }

    public FeedCloudMeta$StFeed o0() {
        return this.C;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f91114e.g();
        this.f91114e.e();
        f80.d dVar = this.E;
        if (dVar != null && this.D) {
            dVar.j();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f41601hi) {
            w0(view, 1000);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.f91114e.g();
        f80.d dVar = this.E;
        if (dVar != null) {
            dVar.g();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSVideoOnPlayEvent) {
            v0((QFSVideoOnPlayEvent) simpleBaseEvent);
        }
    }

    @Override // e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    @Deprecated
    public void pause() {
        this.f91114e.pause();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        if (this.D) {
            this.f91114e.play();
        }
    }

    public void s0(Activity activity) {
        z0();
        this.D = false;
        f80.d dVar = this.E;
        if (dVar != null) {
            dVar.h();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void setExtraTypeInfo(Serializable serializable) {
        super.setExtraTypeInfo(serializable);
        B0();
    }

    public void setSearchInfo(QFSSearchInfo qFSSearchInfo) {
        this.J = qFSSearchInfo;
    }

    @Override // e80.g
    public void stop() {
        this.f91114e.stop();
    }

    public void u0(Activity activity) {
        this.D = true;
        if (this.E != null) {
            if (isAttachedToWindow()) {
                x0();
            }
            this.E.i();
        }
    }

    public void y0(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CLCK_POSITION, 4);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_IS_PLAY, Integer.valueOf(i3));
        VideoReport.setElementParams(this, hashMap);
        EventCollector.getInstance().onViewClicked(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(b bVar, int i3) {
        if (bVar == null || this.C == bVar.g()) {
            return;
        }
        this.I = bVar;
        this.H = i3;
        this.C = bVar.g();
        this.F = findViewById(R.id.f41601hi);
        if (isPlaying()) {
            this.f91114e.e0();
        }
        if (p.w(this.C)) {
            C0(bVar);
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.C;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        q0(feedCloudMeta$StFeed.type.get());
        this.f91114e.j(bVar);
        this.f91114e.f(this.C, i3);
        A0(this.C, i3);
        this.f91118m.p1(this.J);
    }
}
