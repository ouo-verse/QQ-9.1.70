package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ad.tangram.views.button.AdAppDownloadButtonController;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSAdBannerChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.af;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap;
import com.tencent.biz.qqcircle.widgets.RoundImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.GdtAntiSpamReportHelper;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSFeedChildAdCardPresenter extends QFSFeedChildBaseCardPresenter {
    protected GdtAd W;
    protected FeedCloudMeta$StFeed X;
    protected int Y = 0;
    private boolean Z = false;

    /* renamed from: a0, reason: collision with root package name */
    protected final GdtAntiSpamReportHelper f85345a0 = new GdtAntiSpamReportHelper();

    /* renamed from: b0, reason: collision with root package name */
    protected View f85346b0;

    /* renamed from: c0, reason: collision with root package name */
    private LinearLayout f85347c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f85348d0;

    /* renamed from: e0, reason: collision with root package name */
    private RoundImageView f85349e0;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f85350f0;

    /* renamed from: g0, reason: collision with root package name */
    private FrameLayout f85351g0;

    /* renamed from: h0, reason: collision with root package name */
    private QFSAdDownloadButton f85352h0;

    /* renamed from: i0, reason: collision with root package name */
    private AdAppDownloadButtonController f85353i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f85354j0;

    /* renamed from: k0, reason: collision with root package name */
    private GdtShakeIconView f85355k0;

    /* renamed from: l0, reason: collision with root package name */
    protected View f85356l0;

    /* renamed from: m0, reason: collision with root package name */
    protected QFSFeedAdCardDynamicBackgroundView f85357m0;

    /* renamed from: n0, reason: collision with root package name */
    protected QFSFeedAdCardAnimWrap f85358n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f85359o0;

    /* loaded from: classes4.dex */
    class a implements af.c {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.ad.af.c
        public void a() {
            if (!af.Z(QFSFeedChildAdCardPresenter.this.W)) {
                return;
            }
            QFSFeedChildAdCardPresenter qFSFeedChildAdCardPresenter = QFSFeedChildAdCardPresenter.this;
            qFSFeedChildAdCardPresenter.T0(new com.tencent.biz.qqcircle.immersive.feed.event.c(qFSFeedChildAdCardPresenter.W.getTraceId(), true));
        }
    }

    private void A1() {
        String str = "state2";
        Map<String, Object> c16 = ae.c(r0(), "state2", null, this.f85018i);
        c16.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_CARD_TYPE, "1");
        if (this.Y == 1) {
            str = QCircleDaTongConstant.ElementParamValue.EM_XSJ_COMMERCIAL_ADCARD_STATE_3;
        }
        c16.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADCARD_THREE_STAGE, str);
        HashMap<View, String> hashMap = new HashMap<View, String>() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter.2
            {
                put(QFSFeedChildAdCardPresenter.this.f85349e0, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_LOGO);
                put(QFSFeedChildAdCardPresenter.this.f85350f0, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_NAME);
                put(QFSFeedChildAdCardPresenter.this.f85351g0, "em_xsj_commercial_button");
                put(QFSFeedChildAdCardPresenter.this.f85346b0, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_BACKGROUND);
            }
        };
        for (Map.Entry<View, String> entry : hashMap.entrySet()) {
            ae.a(entry.getKey(), this.E, entry.getValue(), c16);
        }
        hashMap.put(this.K, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_ADCARD);
        hashMap.put(this.L, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_ADCARD);
        hashMap.put(this.M, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_ADCARD);
        hashMap.put(this.N, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_ADCARD);
        for (Map.Entry<View, String> entry2 : hashMap.entrySet()) {
            ae.e(entry2.getKey(), entry2.getValue());
        }
    }

    private boolean B1() {
        View view = this.f85346b0;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C1(int i3) {
        af.r0(this.f85356l0, i3);
        af.r0(this.I, i3);
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = this.f85358n0;
        if (qFSFeedAdCardAnimWrap != null) {
            if (i3 == 0) {
                qFSFeedAdCardAnimWrap.J();
                this.f85358n0.I();
                this.f85358n0.K();
            } else {
                qFSFeedAdCardAnimWrap.R();
                this.f85358n0.P();
                this.f85358n0.Q();
            }
        }
    }

    private void I1() {
        AdAppDownloadButtonController adAppDownloadButtonController = this.f85353i0;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.unregisterView(new WeakReference<>(this.f85352h0));
            this.f85353i0 = null;
        }
    }

    private void J1() {
        if (af.Z(this.W) && af.y(this.W) == 1) {
            this.f85347c0.setVisibility(0);
            QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = this.f85358n0;
            if (qFSFeedAdCardAnimWrap != null) {
                qFSFeedAdCardAnimWrap.N();
            }
            String x16 = af.x(this.W);
            if (TextUtils.isEmpty(x16)) {
                x16 = "\u6447\u52a8\u6216\u70b9\u51fb\u770b\u66f4\u591a";
            }
            this.f85348d0.setText(x16);
            return;
        }
        this.f85347c0.setVisibility(8);
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap2 = this.f85358n0;
        if (qFSFeedAdCardAnimWrap2 != null) {
            qFSFeedAdCardAnimWrap2.T();
        }
    }

    private void K1() {
        String str = this.X.poster.icon.iconUrl.get();
        if (!TextUtils.isEmpty(str)) {
            Option regionWidth = Option.obtain().setRequestWidth(com.tencent.biz.qqcircle.utils.cx.a(40.0f)).setRequestHeight(com.tencent.biz.qqcircle.utils.cx.a(40.0f)).setTargetView(this.f85349e0).setUrl(str).setRegionHeight(com.tencent.biz.qqcircle.utils.cx.a(40.0f)).setRegionWidth(com.tencent.biz.qqcircle.utils.cx.a(40.0f));
            regionWidth.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(regionWidth);
        }
        this.f85349e0.setmRadius(com.tencent.biz.qqcircle.utils.cx.a(20.0f), false);
        this.f85350f0.setText(this.X.poster.nick.get());
        this.f85352h0.setPrefixText("");
        if (af.Z(this.W) && af.z(this.W) == 1) {
            String x16 = af.x(this.W);
            if (TextUtils.isEmpty(x16)) {
                x16 = "\u6447\u52a8\u6216\u70b9\u51fb\u67e5\u770b\u8be6\u60c5";
            }
            this.f85352h0.setPrefixText("\u6447\u52a8\u6216\u70b9\u51fb");
            this.f85354j0.setText(x16);
            return;
        }
        this.f85354j0.setText(this.X.subtitle.get());
    }

    private void L1(final int i3) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bg
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedChildAdCardPresenter.this.C1(i3);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void M1() {
        if (!k1()) {
            return;
        }
        A1();
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = this.f85358n0;
        if (qFSFeedAdCardAnimWrap != null) {
            qFSFeedAdCardAnimWrap.A();
        }
        L1(0);
        m1((FeedCloudMeta$StFeed) this.f85017h);
        z1();
    }

    private void s1(QFSAdBannerChangeEvent qFSAdBannerChangeEvent) {
        AdAppDownloadButtonController adAppDownloadButtonController;
        if (!qFSAdBannerChangeEvent.mShow && (adAppDownloadButtonController = this.f85353i0) != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    private void u1(QFSFeedAdCardAnimEvent qFSFeedAdCardAnimEvent) {
        AdAppDownloadButtonController adAppDownloadButtonController;
        if (TextUtils.equals(qFSFeedAdCardAnimEvent.getState(), "2") && qFSFeedAdCardAnimEvent.getStatus() == 1 && (adAppDownloadButtonController = this.f85353i0) != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    private void w1() {
        this.f85347c0.setVisibility(8);
        this.f85355k0.setVisibility(8);
        this.f85355k0.stop();
    }

    private void z1() {
        if (this.f85353i0 != null) {
            return;
        }
        boolean k3 = af.k(this.W);
        if (this.f85359o0 != k3) {
            QLog.d("QFSFeedChildAdCardPresenter", 1, "initDownloadBtnView isValid: " + k3);
            this.f85359o0 = k3;
        }
        this.f85353i0 = af.R((Activity) m0(), this.W, this.f85352h0, this.f85351g0, R.drawable.kho);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap;
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.e) {
            if (!TextUtils.equals(((com.tencent.biz.qqcircle.immersive.feed.event.e) hVar).getMTraceId(), this.W.getTraceId())) {
                return;
            } else {
                L1(8);
            }
        }
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.f) {
            t1((com.tencent.biz.qqcircle.immersive.feed.event.f) hVar);
        }
        if ((hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.b) && TextUtils.equals(((com.tencent.biz.qqcircle.immersive.feed.event.b) hVar).getMTraceId(), this.W.getTraceId()) && (qFSFeedAdCardAnimWrap = this.f85358n0) != null) {
            qFSFeedAdCardAnimWrap.H(true, 0L);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.f85358n0 = null;
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSFeedChildAdCardPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        U0(ae.b(this.E.g(), i3));
        try {
            FeedCloudMeta$StFeed c16 = u.c(this.E);
            this.X = c16;
            this.Y = c16.status.get();
            this.W = new GdtAd(u.e(this.E));
        } catch (Throwable th5) {
            QLog.e("QFSFeedChildAdCardPresenter", 1, "[onBindData] failed, error is " + th5);
        }
        if (!k1()) {
            return;
        }
        x1(this.C);
        z1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E1(View view) {
        x.e(view, this.W, this.X, ae.c(r0(), null, this.W, this.f85018i), r());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F1(View view) {
        if (view == null) {
            return;
        }
        this.f85345a0.listenOnTouchEvent(view);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSFeedChildAdCardPresenter.this.r1(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G1() {
        QFSFeedAdCardDynamicBackgroundView qFSFeedAdCardDynamicBackgroundView = this.f85357m0;
        if (qFSFeedAdCardDynamicBackgroundView == null) {
            QLog.e("QFSFeedChildAdCardPresenter", 2, "[setDynamicBackground] don't support mAdBigBannerDynamicBackground");
            return;
        }
        qFSFeedAdCardDynamicBackgroundView.setPagUrl(null);
        this.f85357m0.setVisibility(8);
        if (!af.c0(this.W)) {
            QLog.i("QFSFeedChildAdCardPresenter", 2, "[setDynamicBackground] don't support ");
        } else {
            QLog.i("QFSFeedChildAdCardPresenter", 2, "[setDynamicBackground]");
            this.f85357m0.setPagUrl(this.W.getCardBackgroundUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H1() {
        if (this.f85357m0 == null) {
            QLog.i("QFSFeedChildAdCardPresenter", 2, "[showBigBannerDynamicBackground] don't support mAdBigBannerDynamicBackground");
        } else {
            if (!af.c0(this.W)) {
                QLog.i("QFSFeedChildAdCardPresenter", 2, "[showBigBannerDynamicBackground] don't support ");
                return;
            }
            this.f85357m0.Y();
            this.f85357m0.setVisibility(0);
            QLog.i("QFSFeedChildAdCardPresenter", 2, "[showBigBannerDynamicBackground]");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        QLog.i("QFSFeedChildAdCardPresenter", 2, NodeProps.ON_DETACHED_FROM_WINDOW);
        super.M0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N1() {
        K1();
        J1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter
    protected boolean g1() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSAdBannerChangeEvent.class);
        eventClass.add(QFSFeedAdCardAnimEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter
    protected boolean k1() {
        if (af.a0(this.W, this.Y) || this.f85017h == 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter
    protected void m1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.E == null) {
            QLog.e("QFSFeedChildAdCardPresenter", 1, "[updateCardUIData] data info should not be null.");
        } else {
            if (!k1()) {
                return;
            }
            N1();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.Q.contains(Integer.valueOf(view.getId()))) {
            r1(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        I1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        M1();
        this.f85345a0.setExpoTime();
        AdAppDownloadButtonController adAppDownloadButtonController = this.f85353i0;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        AdAppDownloadButtonController adAppDownloadButtonController = this.f85353i0;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewPause();
        }
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = this.f85358n0;
        if (qFSFeedAdCardAnimWrap != null) {
            qFSFeedAdCardAnimWrap.B();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = this.f85358n0;
        if (qFSFeedAdCardAnimWrap != null) {
            qFSFeedAdCardAnimWrap.C();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSAdBannerChangeEvent) {
            s1((QFSAdBannerChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSFeedAdCardAnimEvent) {
            u1((QFSFeedAdCardAnimEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = this.f85358n0;
        if (qFSFeedAdCardAnimWrap != null) {
            qFSFeedAdCardAnimWrap.D();
        }
        AdAppDownloadButtonController adAppDownloadButtonController = this.f85353i0;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderDetachedFromWindow(viewHolder);
        I1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r1(View view) {
        int intValue;
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer a16 = com.tencent.biz.qqcircle.immersive.feed.ad.a.f85437a.a(view, B1());
        String adAntiSpamForClickParams = this.f85345a0.getAdAntiSpamForClickParams(this.C);
        com.tencent.biz.qqcircle.immersive.utils.j jVar = com.tencent.biz.qqcircle.immersive.utils.j.f90213a;
        GdtAd gdtAd = this.W;
        int i3 = this.f85018i;
        QCircleExtraTypeInfo r16 = r();
        if (a16 == null) {
            intValue = 1000;
        } else {
            intValue = a16.intValue();
        }
        jVar.J(gdtAd, view, i3, r16, intValue, adAntiSpamForClickParams);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t1(com.tencent.biz.qqcircle.immersive.feed.event.f fVar) {
        if (TextUtils.equals(fVar.getMTraceId(), this.W.getTraceId()) && !eq.f85700a.f(this.Y)) {
            L1(0);
            AdAppDownloadButtonController adAppDownloadButtonController = this.f85353i0;
            if (adAppDownloadButtonController != null) {
                adAppDownloadButtonController.onViewResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v1() {
        if (this.f85357m0 == null) {
            QLog.i("QFSFeedChildAdCardPresenter", 2, "[hideBigBannerDynamicBackground] don't support mAdBigBannerDynamicBackground");
        } else {
            if (!af.c0(this.W)) {
                QLog.i("QFSFeedChildAdCardPresenter", 2, "[hideBigBannerDynamicBackground] don't support ");
                return;
            }
            this.f85357m0.setVisibility(8);
            this.f85357m0.V();
            QLog.i("QFSFeedChildAdCardPresenter", 2, "[hideBigBannerDynamicBackground]");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdCardPresenter";
    }

    protected void x1(View view) {
        if (view != null && !this.Z) {
            this.Z = true;
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.v9u);
            if (viewStub != null) {
                l30.c.a(RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c()), view.getContext(), viewStub);
            }
            View findViewById = view.findViewById(R.id.v9q);
            this.f85356l0 = findViewById;
            af.a(findViewById);
            this.f85349e0 = (RoundImageView) this.f85356l0.findViewById(R.id.f38601_e);
            this.f85350f0 = (TextView) this.f85356l0.findViewById(R.id.f38611_f);
            this.f85351g0 = (FrameLayout) this.f85356l0.findViewById(R.id.f38721_q);
            QFSAdDownloadButton qFSAdDownloadButton = (QFSAdDownloadButton) this.f85356l0.findViewById(R.id.f38751_t);
            this.f85352h0 = qFSAdDownloadButton;
            qFSAdDownloadButton.setPrefixTag("QFSFeedChildAdCardPresenter");
            this.f85354j0 = (TextView) this.f85356l0.findViewById(R.id.f38741_s);
            this.f85355k0 = (GdtShakeIconView) this.f85356l0.findViewById(R.id.f38731_r);
            this.f85357m0 = (QFSFeedAdCardDynamicBackgroundView) this.f85356l0.findViewById(R.id.f375817n);
            this.f85347c0 = (LinearLayout) this.f85356l0.findViewById(R.id.f33280w1);
            this.f85348d0 = (TextView) this.f85356l0.findViewById(R.id.f38671_l);
            w1();
            F1(this.f85349e0);
            F1(this.f85350f0);
            F1(this.f85351g0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y1() {
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = this.f85358n0;
        if (qFSFeedAdCardAnimWrap == null) {
            return;
        }
        qFSFeedAdCardAnimWrap.F(new a());
    }
}
