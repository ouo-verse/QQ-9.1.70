package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.animation.Animator;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFullScreenAdCardPresenter;
import com.tencent.biz.qqcircle.widgets.RoundImageView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import i50.a;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSFullScreenAdCardPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private View I;
    private LinearLayout J;
    private TextView K;
    private TextView L;
    private LinearLayout M;
    private TextView N;
    private TextView P;
    private FrameLayout Q;
    private RoundImageView R;
    private FrameLayout S;
    private Runnable X;
    private GdtAd Y;
    long T = 600;
    long U = 600;
    private a.C10505a V = new a.C10505a(2000);
    private final Handler W = RFWThreadManager.getUIHandler();
    private final Map<Integer, Integer> Z = new HashMap<Integer, Integer>() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFullScreenAdCardPresenter.1
        {
            put(Integer.valueOf(R.id.f33160vp), 2);
            put(Integer.valueOf(R.id.f33170vq), 3);
            put(Integer.valueOf(R.id.f33180vr), 3);
            put(Integer.valueOf(R.id.f42301je), 66);
        }
    };

    private void o1(a.C10505a c10505a, View view, Float f16, Float f17, Long l3) {
        c10505a.a(view, f16.floatValue(), f17.floatValue(), l3.longValue(), 0L, true, true, null, null);
    }

    private int p1(View view) {
        int id5 = view.getId();
        Integer num = Integer.MIN_VALUE;
        if (this.Z.containsKey(Integer.valueOf(id5))) {
            num = this.Z.get(Integer.valueOf(id5));
        }
        if (num == null) {
            return Integer.MIN_VALUE;
        }
        return num.intValue();
    }

    private View.OnClickListener q1(final View view) {
        return new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.eg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSFullScreenAdCardPresenter.this.t1(view, view2);
            }
        };
    }

    private void r1() {
        Map<String, Object> c16 = ae.c(r0(), "state2", null, this.f85018i);
        c16.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADS_CARD_TYPE, "1");
        ae.a(this.R, this.E, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_LOGO, c16);
        ae.a(this.Q, this.E, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_LOGO, c16);
        ae.a(this.S, this.E, "em_xsj_commercial_button", c16);
        ae.a(this.K, this.E, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_NAME, c16);
        ae.a(this.N, this.E, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_NAME, c16);
        ae.a(this.L, this.E, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_DESCRIPTION, c16);
        ae.a(this.P, this.E, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_DESCRIPTION, c16);
        ae.a(this.J, this.E, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_BACKGROUND, c16);
        ae.a(this.M, this.E, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_BACKGROUND, c16);
        ae.e(this.R, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_LOGO);
        ae.e(this.Q, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_LOGO);
        ae.e(this.S, "em_xsj_commercial_button");
        ae.e(this.K, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_NAME);
        ae.e(this.N, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_NAME);
        ae.e(this.L, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_DESCRIPTION);
        ae.e(this.P, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_DESCRIPTION);
        ae.e(this.S, "em_xsj_commercial_button");
        ae.e(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_ADCARD);
        ae.e(this.M, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_ADCARD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean s1(GdtAd gdtAd, String str) {
        if (((FeedCloudMeta$StFeed) this.f85017h).status.get() == 1 && gdtAd != null && TextUtils.equals(gdtAd.getExperimentParam(121009), str)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(View view, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        QLog.i("QFSFullScreenAdCardPresenter", 1, "[handAdClick] viewId = " + view.getId());
        com.tencent.biz.qqcircle.immersive.utils.j.f90213a.I(this.Y, view, this.f85018i, r(), p1(view));
        EventCollector.getInstance().onViewClicked(view2);
    }

    private void v1() {
        this.Q.setAlpha(0.0f);
        this.J.setAlpha(0.0f);
        this.M.setAlpha(0.0f);
        this.S.setAlpha(0.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
        layoutParams.width = ImmersiveUtils.dpToPx(196.0f);
        layoutParams.leftMargin = 0;
        this.J.setLayoutParams(layoutParams);
        this.M.setLayoutParams(layoutParams);
        this.V.c().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1(long j3, Runnable runnable) {
        Runnable runnable2 = this.X;
        if (runnable2 != null) {
            this.W.removeCallbacks(runnable2);
        }
        this.X = runnable;
        this.W.postDelayed(runnable, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1() {
        this.V.c().a();
        a.C10505a c10505a = new a.C10505a(this.T);
        this.V = c10505a;
        FrameLayout frameLayout = this.Q;
        Float valueOf = Float.valueOf(0.0f);
        Float valueOf2 = Float.valueOf(1.0f);
        o1(c10505a, frameLayout, valueOf, valueOf2, Long.valueOf(this.T));
        o1(this.V, this.J, valueOf, valueOf2, Long.valueOf(this.T));
        this.V.e(new a());
        this.V.c().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1() {
        this.V.c().a();
        a.C10505a c10505a = new a.C10505a(this.U);
        this.V = c10505a;
        LinearLayout linearLayout = this.J;
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        o1(c10505a, linearLayout, valueOf, valueOf2, Long.valueOf(this.U));
        o1(this.V, this.M, valueOf2, valueOf, Long.valueOf(this.U));
        o1(this.V, this.S, valueOf2, valueOf, Long.valueOf(this.U));
        this.V.h(this.J, 0.0f, 0.0f, ImmersiveUtils.dpToPx(-89.0f), 0.0f, this.U, true, null, null);
        this.V.h(this.M, 0.0f, 0.0f, ImmersiveUtils.dpToPx(-89.0f), 0.0f, this.U, true, null, null);
        this.V.h(this.Q, 0.0f, 0.0f, ImmersiveUtils.dpToPx(-89.0f), 0.0f, this.U, true, null, null);
        this.V.e(new b());
        this.V.c().b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z1() {
        if (!s1(this.Y, "")) {
            return;
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(this.R).setUrl(((FeedCloudMeta$StFeed) this.f85017h).poster.icon.iconUrl.get()));
        this.K.setText(((FeedCloudMeta$StFeed) this.f85017h).poster.nick.get());
        this.N.setText(((FeedCloudMeta$StFeed) this.f85017h).poster.nick.get());
        this.L.setText(((FeedCloudMeta$StFeed) this.f85017h).content.get());
        this.P.setText(((FeedCloudMeta$StFeed) this.f85017h).content.get());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        r1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        View inflate = ((ViewStub) view.findViewById(R.id.f33230vw)).inflate();
        this.I = inflate;
        inflate.setVisibility(8);
        this.Q = (FrameLayout) this.I.findViewById(R.id.f33160vp);
        RoundImageView roundImageView = (RoundImageView) this.I.findViewById(R.id.f33150vo);
        this.R = roundImageView;
        roundImageView.setmRadius(ImmersiveUtils.dpToPx(24.0f), false);
        this.J = (LinearLayout) this.I.findViewById(R.id.f33170vq);
        this.K = (TextView) this.I.findViewById(R.id.f33190vs);
        this.L = (TextView) this.I.findViewById(R.id.f33210vu);
        this.M = (LinearLayout) this.I.findViewById(R.id.f33180vr);
        this.N = (TextView) this.I.findViewById(R.id.f33200vt);
        this.P = (TextView) this.I.findViewById(R.id.f33220vv);
        this.S = (FrameLayout) this.I.findViewById(R.id.f42301je);
        RoundImageView roundImageView2 = this.R;
        roundImageView2.setOnClickListener(q1(roundImageView2));
        LinearLayout linearLayout = this.J;
        linearLayout.setOnClickListener(q1(linearLayout));
        LinearLayout linearLayout2 = this.M;
        linearLayout2.setOnClickListener(q1(linearLayout2));
        TextView textView = this.K;
        textView.setOnClickListener(q1(textView));
        TextView textView2 = this.N;
        textView2.setOnClickListener(q1(textView2));
        TextView textView3 = this.L;
        textView3.setOnClickListener(q1(textView3));
        TextView textView4 = this.P;
        textView4.setOnClickListener(q1(textView4));
        FrameLayout frameLayout = this.S;
        frameLayout.setOnClickListener(q1(frameLayout));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.d("QFSFullScreenAdCardPresenter", 1, "fs_lifecycle onSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0() + " | mData = " + this.f85017h);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i && this.f85017h != 0) {
            try {
                v1();
                this.I.setVisibility(0);
                w1(((FeedCloudMeta$StFeed) this.f85017h).createTime.get() * 1000, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ef
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSFullScreenAdCardPresenter.this.x1();
                    }
                });
            } catch (Exception e16) {
                QLog.i("QFSFullScreenAdCardPresenter", 1, "[onFeedSelected] exception = " + e16);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.d("QFSFullScreenAdCardPresenter", 1, "onUnSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i) {
            this.W.removeCallbacks(this.X);
            this.V.c().a();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStart(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.i("QFSFullScreenAdCardPresenter", 1, "[onStart] selectInfo = " + rFWFeedSelectInfo);
        super.onStart(rFWFeedSelectInfo);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [feedcloud.FeedCloudMeta$StFeed, T] */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        ?? c16;
        super.L0(feedCloudMeta$StFeed, i3);
        try {
            c16 = u.c(this.E);
            this.f85017h = c16;
        } catch (Exception e16) {
            QLog.e("QFSFullScreenAdCardPresenter", 1, "[onBindData] failed, error is " + e16);
        }
        if (feedCloudMeta$StFeed != null && c16 != 0) {
            this.Y = new GdtAd(u.e(this.E));
            QLog.i("QFSFullScreenAdCardPresenter", 1, "[onBindData] data is not null, position =" + i3 + " data = " + feedCloudMeta$StFeed + ", mData = " + this.f85017h + ", mAd = " + this.Y);
            z1();
            U0(ae.b(feedCloudMeta$StFeed, i3));
            return;
        }
        QLog.e("QFSFullScreenAdCardPresenter", 1, "[onBindData] data = " + feedCloudMeta$StFeed + ", mData = " + this.f85017h);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFullScreenAdCardPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            QFSFullScreenAdCardPresenter.this.y1();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            long j3;
            if (((QFSBaseFeedChildPresenter) QFSFullScreenAdCardPresenter.this).f85017h != null) {
                j3 = ((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) QFSFullScreenAdCardPresenter.this).f85017h).createTimeNs.get() * 1000;
            } else {
                j3 = 2000;
            }
            QFSFullScreenAdCardPresenter.this.w1(j3, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.eh
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFullScreenAdCardPresenter.a.this.b();
                }
            });
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) QFSFullScreenAdCardPresenter.this.J.getLayoutParams();
            layoutParams.width = ImmersiveUtils.dpToPx(285.0f);
            layoutParams.rightMargin = ImmersiveUtils.dpToPx(-89.0f);
            QFSFullScreenAdCardPresenter.this.J.setLayoutParams(layoutParams);
            QFSFullScreenAdCardPresenter.this.M.setLayoutParams(layoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
