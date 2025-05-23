package com.qzone.common.activities.base;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.common.activities.titlebuilder.a;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.detail.ui.component.FeedDetailCommentTips;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.shakead.ShakeCaiDanAdManager;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.TimeCostTrace;
import cooperation.qzone.zipanimate.life.PageLiveCycleProxy;
import cooperation.vip.tianshu.TianShuManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class QZoneBaseFeedFragment<T extends com.qzone.common.activities.titlebuilder.a> extends CustomListViewFragment<T> implements QZonePullToRefreshListView.b, b6.b {

    /* renamed from: i1, reason: collision with root package name */
    public static boolean f45229i1 = false;
    private boolean A0;
    private int D0;
    protected d5.i E0;
    private d5.aa F0;
    protected d5.y G0;
    private d5.t H0;
    private d5.j I0;
    protected d5.ac J0;
    private d5.ad K0;
    protected d5.z L0;
    protected d5.q M0;
    private d5.h N0;
    protected d5.e O0;
    protected d5.o P0;
    private d5.s Q0;
    private d5.a R0;
    private d5.b S0;
    private d5.ag T0;
    protected volatile d5.l U0;
    private List<g> V0;
    private int Z0;

    /* renamed from: a1, reason: collision with root package name */
    private int f45231a1;

    /* renamed from: b1, reason: collision with root package name */
    protected AbsListView.OnScrollListener f45233b1;

    /* renamed from: d1, reason: collision with root package name */
    protected long f45237d1;

    /* renamed from: e1, reason: collision with root package name */
    protected long f45239e1;

    /* renamed from: f1, reason: collision with root package name */
    private Boolean f45241f1;

    /* renamed from: g1, reason: collision with root package name */
    private Runnable f45243g1;

    /* renamed from: h0, reason: collision with root package name */
    protected ro.a f45244h0;

    /* renamed from: i0, reason: collision with root package name */
    protected View f45246i0;

    /* renamed from: j0, reason: collision with root package name */
    protected TextView f45247j0;

    /* renamed from: k0, reason: collision with root package name */
    protected ImageView f45248k0;

    /* renamed from: n0, reason: collision with root package name */
    protected float f45251n0;

    /* renamed from: o0, reason: collision with root package name */
    protected float f45252o0;

    /* renamed from: q0, reason: collision with root package name */
    protected volatile boolean f45254q0;

    /* renamed from: r0, reason: collision with root package name */
    protected QZoneFeedService f45255r0;

    /* renamed from: x0, reason: collision with root package name */
    public int f45261x0;

    /* renamed from: a0, reason: collision with root package name */
    private int f45230a0 = -1;

    /* renamed from: b0, reason: collision with root package name */
    private int f45232b0 = -1;

    /* renamed from: c0, reason: collision with root package name */
    private int f45234c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    protected boolean f45236d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    protected int f45238e0 = -1;

    /* renamed from: f0, reason: collision with root package name */
    protected int f45240f0 = -1;

    /* renamed from: g0, reason: collision with root package name */
    protected int f45242g0 = 0;

    /* renamed from: l0, reason: collision with root package name */
    protected boolean f45249l0 = false;

    /* renamed from: m0, reason: collision with root package name */
    protected boolean f45250m0 = false;

    /* renamed from: p0, reason: collision with root package name */
    protected int f45253p0 = Integer.MIN_VALUE;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f45256s0 = true;

    /* renamed from: t0, reason: collision with root package name */
    protected String f45257t0 = "baseFragment";

    /* renamed from: u0, reason: collision with root package name */
    protected String f45258u0 = "";

    /* renamed from: v0, reason: collision with root package name */
    protected String f45259v0 = "";

    /* renamed from: w0, reason: collision with root package name */
    protected boolean f45260w0 = false;

    /* renamed from: y0, reason: collision with root package name */
    protected boolean f45262y0 = false;

    /* renamed from: z0, reason: collision with root package name */
    protected al f45263z0 = null;
    protected boolean B0 = false;
    protected int C0 = 0;
    private int W0 = -1;
    protected int X0 = 0;
    protected int Y0 = -1;

    /* renamed from: c1, reason: collision with root package name */
    private int f45235c1 = -1;

    /* renamed from: h1, reason: collision with root package name */
    protected boolean f45245h1 = false;

    /* compiled from: P */
    /* renamed from: com.qzone.common.activities.base.QZoneBaseFeedFragment$14, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass14 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f45265d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f45266e;
        final /* synthetic */ QZoneBaseFeedFragment this$0;

        @Override // java.lang.Runnable
        public void run() {
            d5.ab abVar = this.this$0.reporterInf;
            if (abVar != null) {
                abVar.c(this.f45265d, new k(this.f45266e));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string;
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneBaseFeedFragment.this.simpleClassname, view);
            String str = "";
            if (QZoneBaseFeedFragment.this.containerInf == null) {
                string = "";
            } else {
                string = QZoneBaseFeedFragment.this.containerInf.getString(R.string.f170971bd0);
            }
            if (QZoneBaseFeedFragment.this.f45247j0.getText().toString().equals(string)) {
                if (!QZoneBaseFeedFragment.this.checkNetworkConnect()) {
                    if (QZoneBaseFeedFragment.this.getToastInf() != null) {
                        d5.ae toastInf = QZoneBaseFeedFragment.this.getToastInf();
                        if (QZoneBaseFeedFragment.this.containerInf != null) {
                            str = QZoneBaseFeedFragment.this.containerInf.getString(R.string.ghi);
                        }
                        toastInf.a(str);
                    }
                } else {
                    QZoneBaseFeedFragment.this.mj(0L);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements QZonePullToRefreshListView.c {
        b() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void Y() {
            QZoneBaseFeedFragment.this.Vi();
            QZoneBaseFeedFragment.this.oi();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullEnd() {
            QZoneBaseFeedFragment.this.bj();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullStart() {
            QZoneBaseFeedFragment.this.Hh(new long[0]);
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onRefresh() {
            QZoneBaseFeedFragment.this.onRefresh();
            QZoneBaseFeedFragment.this.stopAllAudio();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements QZonePullToRefreshListView.e {
        c() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.e
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
            QZoneBaseFeedFragment.this.Xi(i3, i16, i17, i18);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            RDMEtraMsgCollector.getInstance().addNormalItemClickAction(QZoneBaseFeedFragment.this.simpleClassname, adapterView, view, i3, j3);
            QZoneBaseFeedFragment qZoneBaseFeedFragment = QZoneBaseFeedFragment.this;
            d5.o oVar = qZoneBaseFeedFragment.P0;
            if (oVar != null) {
                oVar.c(qZoneBaseFeedFragment.E, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements QZonePullToRefreshListView.a {
        e() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.a
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            QZoneBaseFeedFragment.bi(QZoneBaseFeedFragment.this);
            QZoneBaseFeedFragment.this.Ci(motionEvent);
            if (motionEvent.getAction() == 0) {
                QZoneBaseFeedFragment.this.fj();
                QZoneBaseFeedFragment.this.f45251n0 = motionEvent.getRawY();
                return false;
            }
            if (motionEvent.getAction() != 2) {
                return false;
            }
            QZoneBaseFeedFragment.this.f45252o0 = motionEvent.getRawY();
            QZoneBaseFeedFragment qZoneBaseFeedFragment = QZoneBaseFeedFragment.this;
            if (qZoneBaseFeedFragment.f45253p0 == Integer.MIN_VALUE) {
                qZoneBaseFeedFragment.f45253p0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_SETTING_VIDEO_IDLE_SCROLL_Y_MIN_DISTANCE, 200);
            }
            QZoneBaseFeedFragment qZoneBaseFeedFragment2 = QZoneBaseFeedFragment.this;
            float abs = Math.abs(qZoneBaseFeedFragment2.f45252o0 - qZoneBaseFeedFragment2.f45251n0);
            QZoneBaseFeedFragment qZoneBaseFeedFragment3 = QZoneBaseFeedFragment.this;
            if (abs <= qZoneBaseFeedFragment3.f45253p0) {
                return false;
            }
            qZoneBaseFeedFragment3.nj(true);
            QZoneBaseFeedFragment qZoneBaseFeedFragment4 = QZoneBaseFeedFragment.this;
            qZoneBaseFeedFragment4.f45251n0 = qZoneBaseFeedFragment4.f45252o0;
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface g {
        void b(QZoneBaseFeedFragment qZoneBaseFeedFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ri(int i3) {
        if (this.D0 == i3 || getPageId() <= 0) {
            return;
        }
        if (i3 == 1) {
            lj(getPageId(), "SCROLL_STATE_TOUCH_SCROLL");
            com.qzone.reborn.tracer.monitor.b.a().startPageScroll(getPageId());
            this.D0 = i3;
        } else if (i3 == 0) {
            lj(getPageId(), "SCROLL_STATE_IDLE");
            com.qzone.reborn.tracer.monitor.b.a().endPageScroll(getPageId());
            this.D0 = i3;
        }
    }

    static /* bridge */ /* synthetic */ d5.w bi(QZoneBaseFeedFragment qZoneBaseFeedFragment) {
        qZoneBaseFeedFragment.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij() {
        if (this.E != null && checkNetworkConnect() && com.qzone.util.x.b() > 2) {
            int headerViewsCount = this.E.j0().getHeaderViewsCount();
            int firstVisiblePosition = this.E.getFirstVisiblePosition() - headerViewsCount;
            int lastVisiblePosition = this.E.getLastVisiblePosition() - headerViewsCount;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
            com.qzone.feed.business.service.a si5 = si();
            if (si5 == null || !(si5 instanceof QZoneFeedService)) {
                return;
            }
            QZoneFeedService qZoneFeedService = (QZoneFeedService) si5;
            this.f45255r0 = qZoneFeedService;
            qZoneFeedService.l0(firstVisiblePosition, lastVisiblePosition);
            this.f45255r0.m0(firstVisiblePosition, lastVisiblePosition);
            this.f45255r0.k0(firstVisiblePosition, lastVisiblePosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jj() {
        if (this.E == null || getVideoWindowPlayInf() == null) {
            return;
        }
        getVideoWindowPlayInf().a(this.E.getAdapter(), this.X0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qi() {
        return MobileQQ.getMobileQQ().isRuntimeReady() && Ni();
    }

    public abstract void Aj(List<BusinessFeedData> list, boolean z16);

    protected boolean Bi() {
        return false;
    }

    protected void Di() {
        View view = this.f45246i0;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        this.f45246i0.setVisibility(8);
    }

    protected final void Ei() {
        d5.q qVar = this.M0;
        if (qVar != null) {
            qVar.a(this.E);
        }
    }

    protected final boolean Fi() {
        d5.q qVar = this.M0;
        return qVar != null && qVar.c(this.E);
    }

    @Override // b6.b
    public void Gc(String str, String str2, DialogInterface.OnClickListener onClickListener) {
        d5.z zVar = this.L0;
        if (zVar != null) {
            zVar.b(str, str2, onClickListener, null);
        }
    }

    public void Gi(BusinessFeedData businessFeedData) {
        d5.h hVar = this.N0;
        if (hVar != null) {
            hVar.d(new k(businessFeedData));
        }
    }

    @Override // b6.b
    public void H4(Bundle bundle, String str, ApkUpdateDetail apkUpdateDetail, int i3) {
        if (Mi() || this.containerInf == null) {
            return;
        }
        sj(true);
        DownloadApi.d(this.containerInf.getActivity(), bundle, "biz_src_jc_qzone", null, i3);
    }

    @Override // b6.b
    public void H8() {
        notifyAdapter(this.D);
    }

    @Override // b6.b
    public void Ib(String str, String str2) {
        if (Mi() || this.J0 == null) {
            return;
        }
        sj(true);
        this.J0.a(str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Ii() {
        d5.q qVar = this.M0;
        if (qVar != null) {
            qVar.b(this.E);
        }
    }

    public void Ji() {
        this.f45233b1 = new f();
    }

    @Override // b6.b
    public void Ka(BusinessFeedData businessFeedData, int i3, long j3) {
        if (Mi() || this.H0 == null) {
            return;
        }
        sj(true);
        this.H0.e(new k(businessFeedData), i3, 0L);
    }

    @Override // b6.b
    public void La(BusinessFeedData businessFeedData, int i3) {
        if (Mi() || this.H0 == null) {
            return;
        }
        sj(true);
        this.H0.a(new k(businessFeedData), i3);
    }

    protected boolean Li() {
        if (this.f45241f1 == null) {
            if (si() != null) {
                this.f45241f1 = Boolean.valueOf(si().H());
            } else {
                this.f45241f1 = Boolean.FALSE;
            }
        }
        return this.f45241f1.booleanValue();
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragment
    protected boolean Mh() {
        return (this.O0 != null && this.configInf.isLoaded()) && super.Mh();
    }

    protected boolean Mi() {
        if (this.f45254q0) {
            QZLog.i(BaseFragment.TAG, "\u6b63\u5728\u542f\u52a8\u9875\u9762:\u51fa\u73b0\u8fd9\u884clog \u53ef\u80fd\u662f\u7528\u6237\u70b9\u51fb\u8fc7\u5feb");
        }
        return this.f45254q0;
    }

    protected boolean Ni() {
        return false;
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragment
    protected boolean Oh() {
        return (this.O0 != null && this.configInf.isLoaded()) && si() != null && super.Oh();
    }

    protected void Oi() {
        int ui5 = ui();
        if (this.f45234c0 < ui5) {
            this.f45234c0 = ui5;
        }
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragment
    protected void Ph() {
        super.Ph();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneBaseFeedFragment.12
            @Override // java.lang.Runnable
            public void run() {
                String yi5 = QZoneBaseFeedFragment.this.yi();
                d5.c cVar = QZoneBaseFeedFragment.this.configInf;
                if (cVar != null) {
                    cVar.e(yi5);
                }
            }
        });
    }

    protected void Ti() {
        if (this.U0 != null) {
            this.U0.e(this.E);
        }
    }

    @Override // com.qzone.widget.QZonePullToRefreshListView.b
    public void V9() {
        ey3.a.f().k();
    }

    protected void Vi() {
        Ah();
        this.f45235c1 = -1;
    }

    @Override // b6.b
    public void Wa(BusinessFeedData businessFeedData, int i3, long j3, int i16) {
        if (Mi() || this.H0 == null) {
            return;
        }
        sj(true);
        this.H0.d(new k(businessFeedData), i3, j3, i16);
    }

    @Override // b6.b
    public void Wb(String str, int i3, String str2) {
        if (Mi() || this.containerInf == null) {
            return;
        }
        sj(true);
        PayBridgeActivity.tenpay(this.containerInf.getActivity(), str, 4, "\u8d2d\u4e70feed");
    }

    @Override // b6.b
    public void X8(String str, Long l3, String str2, int i3, boolean z16) {
        if (Mi() || this.H0 == null) {
            return;
        }
        sj(true);
        this.H0.h(str, l3, str2, i3, z16);
    }

    protected void Yi() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.PreLoadThread).post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneBaseFeedFragment.4
            @Override // java.lang.Runnable
            public void run() {
                QZoneBaseFeedFragment.this.ij();
                QZoneBaseFeedFragment.this.jj();
            }
        });
        gj();
        mi();
    }

    protected void Zi(AbsListView absListView, int i3) {
        this.C0 = i3;
    }

    @Override // b6.b
    public void ab() {
        QZonePullToRefreshListView zi5 = zi();
        if (zi5 == null) {
            return;
        }
        ListView j06 = zi5.j0();
        if (isResumed(8)) {
            com.qzone.proxy.feedcomponent.c cVar = com.qzone.proxy.feedcomponent.c.f50143a;
            com.qzone.proxy.feedcomponent.i uiInterface = cVar.getUiInterface();
            d5.e eVar = this.O0;
            uiInterface.onListViewIdleWithVideoCover(j06, eVar != null ? eVar.getAttachView() : null, this.D, false);
            cVar.getUiInterface().onListViewIdle(j06);
            cVar.getUiInterface().onListViewIdleWithPanorama(j06, this.D);
            Ui(j06);
        }
    }

    protected void aj() {
        QZonePullToRefreshListView zi5 = zi();
        if (zi5 == null) {
            return;
        }
        ListView j06 = zi5.j0();
        if (isResumed(4)) {
            com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().onListViewScrolling(j06);
        }
    }

    @Override // b6.b
    public void b4(boolean z16, Bundle bundle) {
        d5.h hVar = this.N0;
        if (hVar != null) {
            hVar.handleGetShareUrl(z16, bundle);
        }
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragment
    protected void c0() {
        super.c0();
        com.qzone.feed.business.service.a si5 = si();
        if (si5 == null) {
            return;
        }
        oj();
        this.f45236d0 = true;
        this.f45237d1 = System.currentTimeMillis();
        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH).markFirst();
        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH).startStep("100");
        ro.a aVar = this.f45244h0;
        if (aVar != null && !TextUtils.isEmpty(aVar.b())) {
            si5.L(getHandler(), this.f45244h0.c());
        } else {
            si5.L(getHandler(), null);
        }
        uj(R.string.gn_);
        BaseAdapter baseAdapter = this.D;
        if (baseAdapter == null || baseAdapter.getCount() > 0) {
            return;
        }
        getHandler().post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneBaseFeedFragment.11
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneBaseFeedFragment.this.Fi()) {
                    return;
                }
                QZoneBaseFeedFragment.this.wj(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dj(boolean z16) {
        Ch();
        if (z16) {
            Rh(5);
        } else {
            Rh(4);
        }
        sh();
        if (QZLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(BaseFragment.TAG);
            sb5.append(" onRefreshFooter:");
            sb5.append(z16);
            sb5.append(" ,getState():");
            FeedDetailCommentTips feedDetailCommentTips = this.F;
            sb5.append(feedDetailCommentTips == null ? -100 : feedDetailCommentTips.e());
            QZLog.d(QZLog.TO_DEVICE_TAG, 1, sb5.toString());
        }
    }

    public int getCoverForegroundTrans() {
        return 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gj() {
        if (this.U0 != null) {
            this.U0.a(this.E);
        }
    }

    @Override // b6.b
    public void h5(long j3, String str) {
        if (Mi() || this.H0 == null) {
            return;
        }
        sj(true);
        this.H0.g(j3, str);
    }

    public void hj(long j3) {
        getHandler().postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.QZoneBaseFeedFragment.13
            @Override // java.lang.Runnable
            public void run() {
                QZoneBaseFeedFragment.this.ab();
            }
        }, j3);
    }

    public void ji() {
        s5.a.m(this.f45247j0);
        s5.a.h(this.f45246i0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ki() {
        d5.i iVar = this.E0;
        if (iVar != null) {
            iVar.a();
        } else {
            QZLog.w(BaseFragment.TAG, "addInterestedThing: event imp have not init yet", new Throwable());
        }
        d5.o oVar = this.P0;
        if (oVar != null) {
            oVar.a();
        }
    }

    protected void kj() {
        QZonePullToRefreshListView qZonePullToRefreshListView;
        BaseAdapter baseAdapter = this.D;
        if (baseAdapter == null || baseAdapter.getCount() == 0 || (qZonePullToRefreshListView = this.E) == null) {
            return;
        }
        ListView j06 = qZonePullToRefreshListView.j0();
        if (j06.getLastVisiblePosition() >= (j06.getCount() - 1) - j06.getFooterViewsCount()) {
            Ih();
        }
    }

    @Override // b6.b
    public void la(String str, String str2, Map map) {
        if (Mi() || this.containerInf == null) {
            return;
        }
        sj(true);
        yo.d.e(str, this.containerInf.getActivity(), str2, map);
    }

    public void li(g gVar) {
        List<g> list = this.V0;
        if (list != null) {
            list.add(gVar);
        }
    }

    @Override // b6.b
    public void mh(long j3, int i3, Object obj) {
        d5.t tVar;
        if (Mi()) {
            return;
        }
        sj(true);
        if (i3 == 0) {
            d5.t tVar2 = this.H0;
            if (tVar2 != null) {
                tVar2.c(j3, getCurSkinId(), obj == null ? null : obj.toString());
                return;
            }
            return;
        }
        if (i3 != 2 || (tVar = this.H0) == null) {
            return;
        }
        tVar.i(j3, 125);
    }

    public void mi() {
        BaseAdapter baseAdapter = this.D;
        if (baseAdapter instanceof QZoneBaseFeedAdapter) {
            ((QZoneBaseFeedAdapter) baseAdapter).c();
        }
    }

    public void mj(long j3) {
        Handler handler = getHandler();
        if (handler == null) {
            QZLog.i(BaseFragment.TAG, 1, "refreshFeed: failed to get handler");
            return;
        }
        QZLog.d(BaseFragment.TAG, 1, "refreshFeed successfully hashcode = " + hashCode());
        handler.removeMessages(1);
        handler.sendEmptyMessageDelayed(1, j3);
    }

    protected void ni() {
        d5.i iVar = this.E0;
        if (iVar != null) {
            iVar.c();
        }
    }

    protected void nj(boolean z16) {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.E;
        if (qZonePullToRefreshListView == null) {
            return;
        }
        ListView j06 = qZonePullToRefreshListView.j0();
        if (isResumed(2048)) {
            com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
            d5.e eVar = this.O0;
            uiInterface.onListViewIdleWithVideoCover(j06, eVar != null ? eVar.getAttachView() : null, this.D, z16);
        }
    }

    @Override // b6.b
    public void og(View view, BusinessFeedData businessFeedData, int i3, Object obj) {
        d5.h hVar = this.N0;
        if (hVar != null) {
            hVar.a(view, new k(businessFeedData), i3, obj);
        }
    }

    protected void oi() {
        if (this.B0) {
            this.B0 = false;
            Ih();
        }
    }

    protected void oj() {
        this.f45234c0 = ui();
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        PerfTracer.traceStart(PerfTracer.BASEFEED_SUPER_ONCREATE);
        this.A0 = false;
        this.V0 = new CopyOnWriteArrayList();
        this.Z0 = 0;
        super.onActivityCreated(bundle);
        d5.c cVar = this.configInf;
        this.f45261x0 = cVar != null ? cVar.b() : 0;
        getWindow().setBackgroundDrawable(null);
        getWindow().setFormat(-3);
        this.f45244h0 = ro.a.a(getIntent());
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneBaseFeedFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneBaseFeedFragment.this.U0 != null) {
                    QZoneBaseFeedFragment.this.U0.h();
                }
            }
        });
        if (this.U0 != null) {
            this.U0.d();
        }
        d5.o oVar = this.P0;
        if (oVar != null) {
            oVar.init();
        }
        d5.ag agVar = this.T0;
        if (agVar != null) {
            agVar.a(this.D, this.E);
        }
        PageLiveCycleProxy.sBindLifeCycle(getLifecycle());
        PerfTracer.traceEnd(PerfTracer.BASEFEED_SUPER_ONCREATE);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        List<g> list = this.V0;
        if (list != null) {
            list.clear();
            this.V0 = null;
        }
        ni();
        try {
            if (this.U0 != null) {
                this.U0.f();
            }
        } catch (Exception e16) {
            QZLog.e(BaseFragment.TAG, "onDestroy: " + e16);
        }
        QZonePullToRefreshListView qZonePullToRefreshListView = this.E;
        if (qZonePullToRefreshListView != null) {
            qZonePullToRefreshListView.setOnFirstDrawListner(null);
            this.E.n0();
        }
        d5.o oVar = this.P0;
        if (oVar != null) {
            oVar.destroy();
        }
        d5.e eVar = this.O0;
        if (eVar != null) {
            eVar.onDestroy();
        }
        d5.ag agVar = this.T0;
        if (agVar != null) {
            agVar.unregister();
        }
        PageLiveCycleProxy.sUnBindLifeCycle(getLifecycle());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.CustomListViewFragment, com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        String format;
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        switch (message.what) {
            case 1:
                scrollToTop();
                this.E.setRefreshing(false);
                rj(Boolean.valueOf(si() != null ? si().H() : false));
                dj(Li());
                return;
            case 69906:
                kj();
                Yi();
                ab();
                return;
            case 999902:
            case 999914:
                if (this.C != 1) {
                    return;
                }
                this.f45239e1 = System.currentTimeMillis();
                Ph();
                if (unpack != null) {
                    String str = "";
                    if (unpack.getSucceed()) {
                        long newCnt = unpack.getNewCnt();
                        QZLog.i("Feeds", 1, "feed refresh end success, cost:" + (this.f45239e1 - this.f45237d1) + ",newCnt:" + newCnt);
                        if (newCnt == 0 && (this.E.getAdapter() == null || this.E.getAdapter().getCount() == 0)) {
                            ej();
                            vj();
                        }
                        if (this.containerInf != null) {
                            if (newCnt == 0) {
                                format = this.containerInf.getString(R.string.boz);
                            } else {
                                format = String.format(this.containerInf.getString(R.string.f171018bp0), Long.valueOf(newCnt));
                            }
                            str = format;
                        }
                        yj(str);
                        rj(Boolean.valueOf(unpack.getHasMore()));
                        dj(Li());
                        if (unpack.isAutoLoad()) {
                            QZLog.i("Feeds", 1, BaseFragment.TAG + " \u81ea\u52a8\u52a0\u8f7d\u4e00\u6b21");
                            Ih();
                        }
                        if (newCnt == 0) {
                            qj();
                        }
                    } else {
                        String xi5 = xi(unpack);
                        if (this.containerInf != null) {
                            str = this.containerInf.getString(R.string.gm5);
                        }
                        xj(str, xi5);
                        Rh(this.J);
                        uj(R.string.f170971bd0);
                        QZLog.i("Feeds", 1, "feed refresh end fail:" + xi5 + ", cost:" + (this.f45239e1 - this.f45237d1));
                    }
                    if (this.f45236d0) {
                        this.f45236d0 = false;
                        Oi();
                    }
                } else {
                    uj(R.string.f170971bd0);
                    QZLog.i("Feeds", 1, "feed refresh end, result is null");
                }
                cj(unpack);
                sh();
                return;
            case 999903:
            case 999916:
                if (this.C != 2) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("Feeds", 1, "feed getMoreFeed end: reqType != TYPE_GET_MORE");
                        return;
                    }
                    return;
                }
                if (unpack != null) {
                    if (unpack.getSucceed()) {
                        QZLog.d("Feeds", 1, "feed getMoreFeed end success");
                        rj(Boolean.valueOf(unpack.getHasMore()));
                        dj(Li());
                        if (unpack.isAutoLoad()) {
                            QZLog.i("Feeds", 1, BaseFragment.TAG + " \u81ea\u52a8\u52a0\u8f7d\u4e00\u6b21");
                            Ih();
                        }
                    } else {
                        Rh(this.J);
                        if (QZLog.isColorLevel()) {
                            QZLog.d("Feeds", 1, "feed getMoreFeed end fail");
                        }
                    }
                    Si();
                } else if (QZLog.isColorLevel()) {
                    QZLog.d("Feeds", 1, "feed getMoreFeed end, result is null");
                }
                sh();
                return;
            case 999910:
                Qi(unpack);
                return;
            default:
                d5.o oVar = this.P0;
                if (oVar != null) {
                    oVar.b(message);
                    return;
                }
                return;
        }
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragment, com.qzone.common.activities.base.BaseFragment
    protected void onNetStateChanged(final boolean z16) {
        super.onNetStateChanged(z16);
        ThreadManagerV2.post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneBaseFeedFragment.10
            @Override // java.lang.Runnable
            public void run() {
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().notifyNetworkChange(z16);
            }
        }, 5, null, false);
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragment, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        if (this.A0) {
            this.A0 = false;
            List<g> list = this.V0;
            if (list != null && list.size() > 0) {
                Iterator<g> it = this.V0.iterator();
                while (it.hasNext()) {
                    it.next().b(this);
                }
            }
        }
        super.onResume();
        if (this.mReplace) {
            notifyAdapter(this.D);
        }
        sj(false);
        gj();
        mi();
        TianShuManager.setLastClickAdTraceInfo("", "");
        d5.ad adVar = this.K0;
        if (adVar != null) {
            adVar.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.f45245h1 = true;
        }
    }

    protected void pi(int i3, int i16, int i17, int i18) {
        d5.ab abVar = this.reporterInf;
        if (abVar != null) {
            abVar.d(this.D, i3, i16, i17, i18);
        }
    }

    @Override // b6.b
    public void rb(BusinessFeedData businessFeedData, int i3) {
        d5.z zVar = this.L0;
        if (zVar != null) {
            zVar.a(new k(businessFeedData), i3);
        }
    }

    public BaseAdapter ri() {
        return this.D;
    }

    protected void rj(Boolean bool) {
        QZLog.i("Feeds", 1, "hasMore:" + bool);
        this.f45241f1 = bool;
    }

    @Inject
    @Named("BaseFeedFragmentAlbumImp")
    public void setAlbumInf(d5.a aVar) {
        this.R0 = aVar;
    }

    @Inject
    @Named("BaseFeedFragmentAudioImp")
    public void setAudioInf(d5.b bVar) {
        this.S0 = bVar;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    @Inject(type = "com.qzone.common.activities.base.BaseFeedFragmentContainerImp")
    public void setContainerInf(d5.u uVar) {
        super.setContainerInf(uVar);
    }

    @Inject
    @Named("BaseFeedFragmentCoverImp")
    public void setCoverInf(d5.e eVar) {
        this.O0 = eVar;
    }

    @Inject(type = "com.qzone.common.activities.base.BaseFeedFragmentEventImp")
    public void setEventInf(d5.i iVar) {
        this.E0 = iVar;
    }

    @Inject
    @Named("BaseFeedFragmentFavorImp")
    public void setFavorInf(d5.j jVar) {
        this.I0 = jVar;
    }

    @Inject(type = "com.qzone.common.activities.base.BaseFeedFragmentFeedImp")
    public void setFeedInf(d5.l lVar) {
        this.U0 = lVar;
    }

    @Inject(type = "com.qzone.common.activities.base.BaseFeedFragmentFeedPresenterImp")
    public void setFeedPresenterInf(d5.o oVar) {
        this.P0 = oVar;
    }

    @Inject
    @Named("BaseFeedFragmentForbiddenViewImp")
    public void setForbiddenViewInf(d5.q qVar) {
        this.M0 = qVar;
    }

    @Inject
    @Named("BaseFeedFragmentImageImp")
    public void setImageInf(d5.s sVar) {
        this.Q0 = sVar;
    }

    @Inject
    @Named("BaseFeedFragmentJumpImp")
    public void setJumpInf(d5.t tVar) {
        this.H0 = tVar;
    }

    @Inject
    @Named("BaseFeedFragmentDropDownImp")
    public void setPopupWindowInf(d5.h hVar) {
        this.N0 = hVar;
    }

    @Inject
    @Named("BaseFeedFragmentPushImp")
    public void setPushInf(d5.y yVar) {
        this.G0 = yVar;
    }

    @Inject
    @Named("BaseFeedFragmentQDialogImp")
    public void setQDialogInf(d5.z zVar) {
        this.L0 = zVar;
    }

    @Inject
    @Named("BaseFeedFragmentRecommendFriendImp")
    public void setRecommendFriendInf(d5.aa aaVar) {
        this.F0 = aaVar;
    }

    @Inject
    @Named("BaseFeedFragmentSchemeImp")
    public void setSchemeInf(d5.ac acVar) {
        this.J0 = acVar;
    }

    @Inject
    @Named("BaseFeedFragmentShareImp")
    public void setShareInf(d5.ad adVar) {
        this.K0 = adVar;
    }

    @Inject
    @Named("BaseFeedFragmentWeiShiImp")
    public void setWeiShiInf(d5.ag agVar) {
        this.T0 = agVar;
    }

    public abstract com.qzone.feed.business.service.a si();

    /* JADX INFO: Access modifiers changed from: protected */
    public void sj(boolean z16) {
        this.f45254q0 = z16;
        if (z16) {
            if (this.f45243g1 == null) {
                this.f45243g1 = new Runnable() { // from class: com.qzone.common.activities.base.QZoneBaseFeedFragment.16
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneBaseFeedFragment.this.f45254q0 = false;
                    }
                };
            }
            getHandler().removeCallbacks(this.f45243g1);
            getHandler().postDelayed(this.f45243g1, 500L);
        }
    }

    public void stopAllAudio() {
        d5.b bVar = this.S0;
        if (bVar != null) {
            bVar.stopAll();
        }
    }

    @Override // b6.b
    public void t7(String str, BusinessFeedData businessFeedData, int i3) {
        if (Mi() || this.H0 == null) {
            return;
        }
        sj(true);
    }

    public d5.o ti() {
        return this.P0;
    }

    public void tj(al alVar) {
        this.f45263z0 = alVar;
    }

    protected int ui() {
        return this.f45234c0;
    }

    protected void uj(int i3) {
        View view;
        if (this.f45249l0 || (view = this.f45246i0) == null) {
            return;
        }
        if (view.getVisibility() != 0) {
            this.f45246i0.setVisibility(0);
        }
        if (this.f45247j0 == null || this.containerInf == null) {
            return;
        }
        this.f45247j0.setText(this.containerInf.getResources().getString(i3));
        ji();
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragment
    protected void vh() {
        super.vh();
        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH_MORE).markFirst();
        TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH_MORE).startStep("101");
        if (si() != null) {
            si().J(getHandler());
        }
    }

    public int vi() {
        return this.C0;
    }

    protected final void vj() {
        d5.q qVar = this.M0;
        if (qVar != null) {
            qVar.e(this.E, getCoverForegroundTrans());
        }
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragment
    protected void wh() {
        super.wh();
        com.qzone.feed.business.service.a si5 = si();
        if (si5 != null) {
            si5.I(getHandler());
        }
    }

    public final d5.h wi() {
        return this.N0;
    }

    protected final void wj(boolean z16) {
        d5.q qVar = this.M0;
        if (qVar != null) {
            qVar.d(this.E, getCoverForegroundTrans(), z16);
        }
    }

    @Override // b6.b
    public void xb(final String str) {
        if (Mi()) {
            return;
        }
        sj(true);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneBaseFeedFragment.15
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneBaseFeedFragment.this.H0 != null) {
                    QZoneBaseFeedFragment.this.H0.l(str);
                }
            }
        });
    }

    protected String xi(QZoneResult qZoneResult) {
        return qZoneResult.getMessage();
    }

    protected void xj(String str, String str2) {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.E;
        if (qZonePullToRefreshListView != null) {
            qZonePullToRefreshListView.r0(str, str2);
        }
    }

    @Override // com.qzone.common.activities.base.CustomListViewFragment
    protected long yh() {
        super.yh();
        String yi5 = yi();
        d5.c cVar = this.configInf;
        if (cVar != null) {
            return cVar.g(yi5);
        }
        return 0L;
    }

    protected abstract String yi();

    protected void yj(String str) {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.E;
        if (qZonePullToRefreshListView != null) {
            qZonePullToRefreshListView.s0(str);
        }
    }

    public QZonePullToRefreshListView zi() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zj(String str, String str2) {
        d5.t tVar;
        if (Mi()) {
            return;
        }
        sj(true);
        if (!this.f45256s0 || (tVar = this.H0) == null) {
            return;
        }
        this.f45256s0 = false;
        tVar.b(str, str2);
    }

    private void Ui(ListView listView) {
        View childAt = listView.getChildAt(0);
        d5.e eVar = this.O0;
        if (eVar != null) {
            eVar.b(childAt);
        }
    }

    @Override // b6.b
    public void Vc(String str) {
        Ib(str, null);
    }

    @Override // b6.b
    public void j(int i3, String str, String str2, String str3, boolean z16, String str4, String str5, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3) {
        d5.z zVar = this.L0;
        if (zVar != null) {
            zVar.j(i3, str, str2, str3, z16, str4, str5, onClickListener, onClickListener2, onClickListener3);
        }
    }

    @Override // b6.b
    public void j3(String str, Long l3, String str2, int i3, long j3, long j16) {
        if (Mi() || this.H0 == null) {
            return;
        }
        sj(true);
        this.H0.f(str, l3, str2, i3, j3, j16);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.A0 = true;
        stopAllAudio();
        if (this.U0 != null) {
            this.U0.c(this.E);
        }
        d5.o oVar = this.P0;
        if (oVar != null) {
            oVar.onPause();
        }
        ShakeCaiDanAdManager.c().g();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Pi(List<BusinessFeedData> list) {
        if (list != null && list.size() > 0) {
            this.f45249l0 = true;
            Di();
            Ei();
        } else {
            ej();
            vj();
            this.f45249l0 = false;
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        if (z16) {
            getHandler().postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.QZoneBaseFeedFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    QZoneBaseFeedFragment.this.ab();
                }
            }, 500L);
        }
        ShakeCaiDanAdManager.c().e(z16);
        super.onWindowFocusChanged(z16);
    }

    @Override // b6.b
    public void r5(CharSequence charSequence) {
        d5.z zVar;
        if (!isResumed(16) || (zVar = this.L0) == null) {
            return;
        }
        zVar.c(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements AbsListView.OnScrollListener {
        f() {
        }

        private void a() {
            QZoneBaseFeedFragment qZoneBaseFeedFragment = QZoneBaseFeedFragment.this;
            if (qZoneBaseFeedFragment.D == null || qZoneBaseFeedFragment.f45235c1 < 0 || QZoneBaseFeedFragment.this.f45235c1 > QZoneBaseFeedFragment.this.D.getCount()) {
                return;
            }
            QZoneBaseFeedFragment qZoneBaseFeedFragment2 = QZoneBaseFeedFragment.this;
            if (qZoneBaseFeedFragment2.reporterInf != null) {
                return;
            }
            Object item = qZoneBaseFeedFragment2.D.getItem(qZoneBaseFeedFragment2.f45235c1);
            d5.ab abVar = QZoneBaseFeedFragment.this.reporterInf;
            if (abVar != null) {
                abVar.a(item);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            QZoneBaseFeedFragment.this.Z0 = i3;
            al alVar = QZoneBaseFeedFragment.this.f45263z0;
            if (alVar != null) {
                alVar.onScrollStateChanged(absListView, i3);
            }
            ImageManager.hasScrolled = true;
            if (QZoneBaseFeedFragment.this.U0 != null) {
                QZoneBaseFeedFragment.this.U0.b(true);
            }
            if (i3 == 0) {
                d5.x xVar = QZoneBaseFeedFragment.this.X;
                if (xVar != null) {
                    xVar.c();
                }
                QZoneBaseFeedFragment.this.getHandler().sendEmptyMessageDelayed(69906, 200L);
                if (QZoneBaseFeedFragment.this.Q0 != null) {
                    QZoneBaseFeedFragment.this.Q0.b();
                }
                ImageLoader.onListViewIdle();
                if (absListView != null && absListView.getChildAt(0) != null) {
                    QZoneBaseFeedFragment.this.Ti();
                    oy3.a.a().c(QZoneBaseFeedFragment.this.f45257t0, false);
                }
            } else if (i3 != 2) {
                oy3.a.a().b(QZoneBaseFeedFragment.this.f45257t0);
                d5.x xVar2 = QZoneBaseFeedFragment.this.X;
                if (xVar2 != null) {
                    xVar2.b();
                }
                QZoneBaseFeedFragment.this.getHandler().removeMessages(69906);
                if (QZoneBaseFeedFragment.this.Q0 != null) {
                    QZoneBaseFeedFragment.this.Q0.a();
                }
                QZoneBaseFeedFragment.this.aj();
            } else {
                d5.x xVar3 = QZoneBaseFeedFragment.this.X;
                if (xVar3 != null) {
                    xVar3.b();
                }
                QZoneBaseFeedFragment.this.getHandler().removeMessages(69906);
                if (QZoneBaseFeedFragment.this.Q0 != null) {
                    QZoneBaseFeedFragment qZoneBaseFeedFragment = QZoneBaseFeedFragment.this;
                    if (qZoneBaseFeedFragment.configInf != null) {
                        qZoneBaseFeedFragment.Q0.c(com.qzone.util.p.a(absListView, QZoneBaseFeedFragment.this.configInf.d()));
                    }
                }
            }
            QZoneBaseFeedFragment.this.Zi(absListView, i3);
            if (MobileQQ.getMobileQQ().isRuntimeReady() && QZoneBaseFeedFragment.this.Bi() && absListView != null && QZoneBaseFeedFragment.this.configInf != null) {
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().onFeedScrollStateChangedAction(absListView, absListView.getAdapter(), i3, true, QZoneBaseFeedFragment.this.configInf.getScreenHeight());
            }
            QZoneBaseFeedFragment.this.Ri(i3);
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            d5.ab abVar;
            int i18 = (i3 + i16) - 1;
            if (QZoneBaseFeedFragment.this.f45235c1 != -1) {
                if (i3 < QZoneBaseFeedFragment.this.f45235c1) {
                    QZoneBaseFeedFragment qZoneBaseFeedFragment = QZoneBaseFeedFragment.this;
                    qZoneBaseFeedFragment.pi(i3, qZoneBaseFeedFragment.f45235c1, 25, 19);
                }
                if (i18 > QZoneBaseFeedFragment.this.f45231a1) {
                    QZoneBaseFeedFragment qZoneBaseFeedFragment2 = QZoneBaseFeedFragment.this;
                    qZoneBaseFeedFragment2.pi(qZoneBaseFeedFragment2.f45231a1 + 1, i18 + 1, 25, 19);
                }
            } else {
                QZoneBaseFeedFragment.this.pi(i3, i18 + 1, 25, 19);
            }
            if (QZoneBaseFeedFragment.this.f45235c1 != i3) {
                QZoneBaseFeedFragment.this.f45235c1 = i3;
                a();
            }
            if (i18 > QZoneBaseFeedFragment.this.f45231a1 && (abVar = QZoneBaseFeedFragment.this.reporterInf) != null && !abVar.b()) {
                QZoneBaseFeedFragment qZoneBaseFeedFragment3 = QZoneBaseFeedFragment.this;
                qZoneBaseFeedFragment3.pi(qZoneBaseFeedFragment3.f45231a1 + 1, i18 + 1, 15, 8);
            }
            QZoneBaseFeedFragment.this.f45231a1 = i18;
            al alVar = QZoneBaseFeedFragment.this.f45263z0;
            if (alVar != null) {
                alVar.onScroll(absListView, i3, i16, i17);
            }
            QZoneBaseFeedFragment.this.Wi(absListView, i3, i16, i17);
            if (absListView != null && QZoneBaseFeedFragment.this.qi()) {
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().onFeedScrollAction(absListView, absListView.getAdapter(), i3, i16, i17, QZoneBaseFeedFragment.this.configInf.getScreenHeight());
            }
            QZoneBaseFeedFragment.this.X0 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ki() {
        QZonePullToRefreshListView qZonePullToRefreshListView = (QZonePullToRefreshListView) findViewById(R.id.f163826j);
        this.E = qZonePullToRefreshListView;
        qZonePullToRefreshListView.setListViewBGFeedNormal();
        this.E.setReleaseHold(this.Y);
        if (this.containerInf != null) {
            this.E.setMaximumVelocity((int) (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MAX_SPEED, 6000) * this.containerInf.getResources().getDisplayMetrics().density));
        }
        Ji();
        this.E.setOnScrollListener(this.f45233b1);
        this.E.setOnFirstDrawListner(this);
        this.E.setOnRefreshListener(new b());
        this.E.setOnScrollChangedListener(new c());
        this.E.j0().setOnItemClickListener(new d());
        this.E.setSupportPullUp(true);
        this.E.setDispatchTouchEventListener(new e());
    }

    @Override // b6.b
    public void Q7(String str, BusinessFeedData businessFeedData) {
        if (businessFeedData == null || Mi() || this.H0 == null) {
            return;
        }
        sj(true);
        this.H0.j(str, !businessFeedData.getFeedCommInfo().isHotFeedsFetched);
    }

    public void ej() {
        uj(R.string.cjc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pj(TimeCostTrace timeCostTrace, boolean z16) {
        if (z16) {
            AccManager.reportTimeWithRefresh(TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH).dumpStepCost(), true);
        } else {
            AccManager.reportTimeWithRefreshMore(TimeCostTrace.getTrace(TimeCostTrace.TAG_QZONE_REFRESH_MORE).dumpStepCost(), true);
        }
    }

    @Override // b6.b
    public void e4(BusinessFeedData businessFeedData, int i3, long j3) {
        Wa(businessFeedData, i3, j3, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ai(List<BusinessFeedData> list, boolean z16) {
        if (z16 || list == null || list.size() != 0) {
            return;
        }
        Bj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Hi(View view) {
        if (view == null) {
            return;
        }
        this.f45246i0 = view.findViewById(R.id.bwc);
        this.f45248k0 = (ImageView) view.findViewById(R.id.bwf);
        this.f45247j0 = (TextView) view.findViewById(R.id.bwj);
        if (this.configInf.getScreenWidth() < 480 || (this.configInf.getScreenWidth() == 640 && this.configInf.getScreenHeight() == 960)) {
            this.f45248k0.setVisibility(8);
        }
        this.f45246i0.setOnClickListener(new a());
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 == 0) {
            if (i3 != 37676 && i3 != 37678) {
                d5.ab abVar = this.reporterInf;
                if (abVar != null) {
                    abVar.e();
                    return;
                }
                return;
            }
            d5.aa aaVar = this.F0;
            if (aaVar != null) {
                aaVar.a(zi(), i3, i16);
                return;
            }
            return;
        }
        if (i16 == 4646) {
            finish();
            return;
        }
        d5.o oVar = this.P0;
        if (oVar == null || !oVar.onActivityResult(i3, i16, intent)) {
            switch (i3) {
                case 605:
                    d5.t tVar = this.H0;
                    if (tVar != null) {
                        tVar.m(intent);
                        return;
                    }
                    return;
                case 606:
                    Message obtain = Message.obtain();
                    obtain.what = 601;
                    getHandler().sendMessage(obtain);
                    return;
                case 1204:
                    H8();
                    return;
                case QZoneContant.QZ_REQUEST_OPEN_VIP /* 9236 */:
                    this.f45256s0 = true;
                    return;
                case QZoneContant.QZ_SEARCH_LOCAL_REQUEST_CODE /* 20221 */:
                    return;
                case QZoneContant.QZ_START_QZAPP_REQ /* 37070 */:
                    if (i16 != 37171 && i16 == 37272) {
                        Bundle bundle = new Bundle();
                        d5.c cVar = this.configInf;
                        bundle.putLong("qqid", cVar != null ? cVar.c() : 0L);
                        Message obtain2 = Message.obtain();
                        obtain2.what = QZoneContant.SHIFT_HOMEPAGE;
                        obtain2.setData(bundle);
                        getHandler().sendMessage(obtain2);
                        return;
                    }
                    return;
                case QZoneContant.QZ_START_QZPHOTOCOMMENT_REQ /* 37373 */:
                    if (intent != null) {
                        long j3 = intent.getExtras().getLong("uin");
                        if (j3 != 0) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putLong("qqid", j3);
                            bundle2.putBoolean("isbackmenu", true);
                            Message obtain3 = Message.obtain();
                            obtain3.what = QZoneContant.SHIFT_HOMEPAGE;
                            obtain3.setData(bundle2);
                            getHandler().sendMessage(obtain3);
                            return;
                        }
                        return;
                    }
                    return;
                case QZoneContant.QZ_REQUEST_FEED_ADD_FRIEND /* 37676 */:
                case QZoneContant.QZ_REQUEST_FEED_CARD_ADD_FRIEND /* 37678 */:
                    d5.aa aaVar2 = this.F0;
                    if (aaVar2 != null) {
                        aaVar2.a(zi(), i3, i16);
                        return;
                    }
                    return;
                case QZoneContant.QZ_SELECT_ALBUM /* 37679 */:
                    d5.a aVar = this.R0;
                    if (aVar != null) {
                        aVar.a(intent);
                        return;
                    }
                    return;
                default:
                    d5.ad adVar = this.K0;
                    if (adVar != null) {
                        adVar.a(i3, i16, intent);
                        return;
                    }
                    return;
            }
        }
    }

    protected void Bj() {
    }

    protected void Ci(MotionEvent motionEvent) {
    }

    protected void Qi(QZoneResult qZoneResult) {
    }

    protected void Si() {
    }

    public void bj() {
    }

    protected void cj(QZoneResult qZoneResult) {
    }

    protected void fj() {
    }

    protected void qj() {
    }

    private void lj(int i3, String str) {
    }

    protected void Wi(AbsListView absListView, int i3, int i16, int i17) {
    }

    protected void Xi(int i3, int i16, int i17, int i18) {
    }
}
