package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.widgets.RoundImageView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashSet;
import tencent.gdt.creatorReader;
import tencent.gdt.qq_ad_get;

/* loaded from: classes4.dex */
public class QFSFeedChildAdShadePresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private static long Q = 0;
    private static long R = 2000;
    private static long S = 2000;
    private TextView I;
    private RoundImageView J;
    private View K;
    private GdtAd L;
    private g M = new g();
    private final Runnable N = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdShadePresenter.1
        @Override // java.lang.Runnable
        public void run() {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
            translateAnimation.setDuration(QFSFeedChildAdShadePresenter.R);
            translateAnimation.setInterpolator(new LinearInterpolator());
            translateAnimation.setFillBefore(true);
            translateAnimation.setAnimationListener(new a());
            translateAnimation.setRepeatMode(1);
            if (QFSFeedChildAdShadePresenter.this.J == null) {
                return;
            }
            QFSFeedChildAdShadePresenter.this.J.setVisibility(0);
            QFSFeedChildAdShadePresenter.this.J.startAnimation(translateAnimation);
        }

        /* renamed from: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdShadePresenter$1$a */
        /* loaded from: classes4.dex */
        class a implements Animation.AnimationListener {
            a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (QFSFeedChildAdShadePresenter.this.J == null) {
                    return;
                }
                QFSFeedChildAdShadePresenter.this.J.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }
    };
    private HashSet<Integer> P = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.tencent.biz.qqcircle.utils.cx.a(4.0f));
        }
    }

    @RequiresApi(api = 21)
    private void r1() {
        this.K.setOutlineProvider(new a());
        this.K.setClipToOutline(true);
    }

    private void s1() {
        View view = this.K;
        if (view != null) {
            view.setVisibility(8);
        }
        RoundImageView roundImageView = this.J;
        if (roundImageView != null) {
            roundImageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(View view) {
        if (view == null) {
            QLog.d("QFSFeedChildAdShadePresenter", 1, "[initAdGrayBar] current root view should be not null.");
            return;
        }
        View view2 = this.K;
        if (view2 != null) {
            view2.setVisibility(0);
            this.J.setVisibility(8);
            return;
        }
        this.K = ((ViewStub) view.findViewById(R.id.v_d)).inflate();
        r1();
        this.I = (TextView) this.K.findViewById(R.id.f38941ab);
        RoundImageView roundImageView = (RoundImageView) this.K.findViewById(R.id.f38981af);
        this.J = roundImageView;
        roundImageView.setmRadius(com.tencent.biz.qqcircle.utils.cx.a(6.0f), false);
        this.J.setVisibility(8);
        this.K.setOnClickListener(this);
        this.P.add(Integer.valueOf(R.id.v_c));
    }

    private void v1() {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdShadePresenter.3
            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildAdShadePresenter qFSFeedChildAdShadePresenter = QFSFeedChildAdShadePresenter.this;
                qFSFeedChildAdShadePresenter.t1(((QFSBaseFeedChildPresenter) qFSFeedChildAdShadePresenter).C);
                QFSFeedChildAdShadePresenter.this.x1();
                QFSFeedChildAdShadePresenter.this.M.i(QFSFeedChildAdShadePresenter.this.L, ((QFSBaseFeedChildPresenter) QFSFeedChildAdShadePresenter.this).C, ((QFSBaseFeedChildPresenter) QFSFeedChildAdShadePresenter.this).f85018i, ((QFSBaseFeedChildPresenter) QFSFeedChildAdShadePresenter.this).D);
                QFSFeedChildAdShadePresenter.this.M.h();
            }
        }, Q);
        RFWThreadManager.getUIHandler().postDelayed(this.N, S);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        com.tencent.biz.qqcircle.immersive.utils.j jVar = com.tencent.biz.qqcircle.immersive.utils.j.f90213a;
        creatorReader.CreatorAD creatorAD = (creatorReader.CreatorAD) jVar.P(feedCloudMeta$StFeed);
        this.L = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo) null);
        if (creatorAD != null && creatorAD.qq_ad_get_rsp.pos_ads_info.has()) {
            qq_ad_get.QQAdGetRsp.PosAdInfo posAdInfo = creatorAD.qq_ad_get_rsp.pos_ads_info.get(0);
            if (!posAdInfo.has() || !posAdInfo.ads_info.has()) {
                return;
            }
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = posAdInfo.ads_info.get(0);
            if (!adInfo.has()) {
                return;
            }
            GdtAd gdtAd = new GdtAd(adInfo);
            this.L = gdtAd;
            jVar.M(gdtAd, this.C.getContext());
            if (creatorAD.card_show_second.get() != 0) {
                Q = creatorAD.card_show_second.get() * 1000;
            }
            if (creatorAD.highlight_second.get() != 0) {
                S = creatorAD.highlight_second.get() * 1000;
            }
            if (creatorAD.highlight_slide_second.get() != 0) {
                R = creatorAD.highlight_slide_second.get() * 1000;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1() {
        GdtAd gdtAd;
        TextView textView = this.I;
        if (textView != null && (gdtAd = this.L) != null) {
            textView.setText(gdtAd.getText());
        } else {
            QLog.d("QFSFeedChildAdShadePresenter", 1, "[updateAdGrayBar] current ad Des should be not null.");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        SimpleEventBus.getInstance().registerReceiver(this);
        GdtAd gdtAd = this.L;
        if (gdtAd != null && gdtAd.isValid()) {
            v1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        s1();
        if (this.L != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.N);
            this.M.f(m0());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.P.contains(Integer.valueOf(view.getId()))) {
            com.tencent.biz.qqcircle.immersive.utils.j.f90213a.C(this.L, view, this.f85018i, r(), Integer.MIN_VALUE);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        if (this.L != null) {
            this.M.g();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        if (this.L != null && this.K != null) {
            this.M.h();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public void L0(final FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.f85017h = feedCloudMeta$StFeed;
        s1();
        if (((FeedCloudMeta$StFeed) this.f85017h).advInfo.jobID.get() == 0) {
            this.L = null;
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdShadePresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    QFSFeedChildAdShadePresenter.this.w1(feedCloudMeta$StFeed);
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdShadePresenter";
    }
}
