package com.tencent.mobileqq.tvideo.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.tvideo.event.QFSTVideoAuthPayPanelEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeExpandFullScreenEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoScrollToNextEvent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.core.ReportConst;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import fy2.b;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ak extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private View I;
    private View J;
    private View K;
    private LottieAnimationView L;
    private boolean M;
    private volatile boolean N;
    private Observer<b.CurrentVideoInfo> P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends QCirclePicStateListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState.isFinishSuccess() && !ak.this.M) {
                ak.this.L.setVisibility(0);
            }
        }
    }

    private void A1() {
        if (this.N && this.P != null) {
            fy2.b.f400938a.a().removeObserver(this.P);
            this.N = false;
            this.P = null;
        }
    }

    private void B1(QFSTVideoAuthPayPanelEvent qFSTVideoAuthPayPanelEvent) {
        if (qFSTVideoAuthPayPanelEvent.isShow()) {
            D1("https://ugd.gtimg.com//vg/1678170415265_icon_tvideo_scroll_next.png");
        } else {
            D1("https://ugd.gtimg.com/vg/1686305398588_lottie_white.json");
        }
    }

    private void C1() {
        if ((m0() instanceof Activity) && ((Activity) m0()).getResources() != null && ((Activity) m0()).getResources().getConfiguration() != null) {
            if (((Activity) m0()).getResources().getConfiguration().orientation == 2) {
                this.J.setVisibility(0);
                this.K.setVisibility(8);
            } else {
                this.K.setVisibility(0);
                this.J.setVisibility(8);
            }
        }
    }

    private void D1(String str) {
        this.L.setTag(str);
        ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
        if (TextUtils.equals(str, "https://ugd.gtimg.com//vg/1678170415265_icon_tvideo_scroll_next.png")) {
            layoutParams.height = cx.a(30.0f);
            layoutParams.width = cx.a(109.0f);
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).leftMargin = cx.a(15.0f);
            }
        } else {
            layoutParams.height = cx.a(42.0f);
            layoutParams.width = cx.a(115.0f);
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).leftMargin = 0;
            }
        }
        this.L.setLayoutParams(layoutParams);
        if (this.M) {
            this.L.setVisibility(8);
        }
        if (TextUtils.equals(str, "https://ugd.gtimg.com//vg/1678170415265_icon_tvideo_scroll_next.png")) {
            Option targetView = Option.obtain().setUrl(str).setTargetView(this.L);
            targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            QCircleFeedPicLoader.g().loadImage(targetView, new a());
        } else {
            this.L.setAnimationFromUrl(str);
            this.L.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() { // from class: com.tencent.mobileqq.tvideo.presenter.ai
                @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
                public final void onCompositionLoaded(LottieComposition lottieComposition) {
                    ak.this.v1(lottieComposition);
                }
            });
            if (o1()) {
                this.L.setRepeatCount(1);
            }
        }
    }

    private boolean E1(int i3) {
        if (i3 >= 30 && o1()) {
            return true;
        }
        return false;
    }

    private void m1() {
        LottieAnimationView lottieAnimationView = this.L;
        if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
            this.L.cancelAnimation();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n1() {
        boolean z16;
        if (!jy2.g.A(jy2.g.q((FeedCloudMeta$StFeed) this.f85017h)) && !AppSetting.t(m0())) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.M = z16;
    }

    private boolean o1() {
        return qx2.a.c().i();
    }

    private boolean p1(boolean z16) {
        if (!z16 && !this.N && o1()) {
            return true;
        }
        return false;
    }

    private void q1() {
        Object tag = this.L.getTag();
        if ((tag instanceof String) && TextUtils.equals((CharSequence) tag, "https://ugd.gtimg.com//vg/1678170415265_icon_tvideo_scroll_next.png")) {
            QFSTVideoScrollToNextEvent qFSTVideoScrollToNextEvent = new QFSTVideoScrollToNextEvent();
            qFSTVideoScrollToNextEvent.setNextPos(this.f85018i + 1);
            SimpleEventBus.getInstance().dispatchEvent(qFSTVideoScrollToNextEvent);
        } else {
            jy2.g.Q((Activity) m0(), 0);
            VideoReport.reportEvent("clck", this.I, null);
            qx2.a.c().m();
        }
    }

    private void r1(View view) {
        View findViewById = view.findViewById(R.id.f45621sd);
        this.I = findViewById;
        if (findViewById == null) {
            return;
        }
        this.J = view.findViewById(R.id.f45551s7);
        this.K = view.findViewById(R.id.f45571s9);
        this.L = (LottieAnimationView) view.findViewById(R.id.xdx);
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ak.this.s1(view2);
            }
        });
        VideoReport.setElementParams(this.I, gy2.c.g());
        VideoReport.setElementExposePolicy(this.I, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.I, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.I, ReportConst.ACTION.FULLSCREEN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        q1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1() {
        LottieAnimationView lottieAnimationView = this.L;
        if (lottieAnimationView != null) {
            lottieAnimationView.playAnimation();
            w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(b.CurrentVideoInfo currentVideoInfo) {
        if (E1(currentVideoInfo.getDuration())) {
            A1();
            y1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v1(LottieComposition lottieComposition) {
        if (this.L.getVisibility() != 0 && !this.M) {
            this.L.setVisibility(0);
        }
    }

    private void w1() {
        qx2.a.c().q(false);
        qx2.a.c().f();
    }

    private void y1() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.aj
            @Override // java.lang.Runnable
            public final void run() {
                ak.this.t1();
            }
        });
    }

    private void z1() {
        this.N = true;
        if (this.P == null) {
            this.P = new Observer() { // from class: com.tencent.mobileqq.tvideo.presenter.ah
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ak.this.u1((b.CurrentVideoInfo) obj);
                }
            };
        }
        fy2.b.f400938a.a().observeForever(this.P);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if ((hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ap) && p1(((com.tencent.biz.qqcircle.immersive.feed.event.ap) hVar).b())) {
            z1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        m1();
        A1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.C = view;
        r1(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleConfigChangeEvent.class);
        eventClass.add(QFSTVideoEpisodeExpandFullScreenEvent.class);
        eventClass.add(QFSTVideoAuthPayPanelEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        n1();
        C1();
        D1("https://ugd.gtimg.com/vg/1686305398588_lottie_white.json");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            C1();
        } else if (simpleBaseEvent instanceof QFSTVideoAuthPayPanelEvent) {
            B1((QFSTVideoAuthPayPanelEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoFullScreenEntrancePresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
    }
}
