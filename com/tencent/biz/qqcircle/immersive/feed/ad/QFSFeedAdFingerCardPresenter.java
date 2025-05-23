package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdFingerAnimWrap;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleMaxHeightScrollView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSFeedAdFingerCardPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private View I;
    private RelativeLayout J;
    private RelativeLayout K;
    private TextView L;
    private QCircleAsyncTextView M;
    private TextView N;
    private TextView P;
    private TextView Q;
    private ImageView R;
    private ImageView S;
    private LinearLayout T;
    private QCircleMaxHeightScrollView U;
    private FeedCloudMeta$StFeed V;
    private GdtAd W;
    private QFSFeedAdFingerAnimWrap Z;
    private int X = 0;
    private boolean Y = false;

    /* renamed from: a0, reason: collision with root package name */
    private Drawable f85344a0 = null;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A1(Integer num) {
        View view = this.I;
        if (view != null) {
            view.setVisibility(num.intValue());
        }
    }

    private void B1() {
        Drawable mutate = QCircleSkinHelper.getInstance().getDrawable(m0(), R.drawable.mhk).mutate();
        this.f85344a0 = mutate;
        mutate.setBounds(ImmersiveUtils.dpToPx(8.0f), 0, ImmersiveUtils.dpToPx(46.0f), ImmersiveUtils.dpToPx(17.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        x.e(view, this.W, u.c(this.E), ae.c(r0(), null, this.W, this.f85018i), r());
        EventCollector.getInstance().onViewClicked(view);
    }

    private void E1() {
        GdtAd gdtAd = this.W;
        String buttonText = gdtAd.getButtonText(af.c(gdtAd, this.C));
        String A = af.A(this.W, this.C);
        this.Q.setText(A);
        this.N.setText(this.V.poster.nick.get());
        TextView textView = this.P;
        if (af.o(this.V)) {
            buttonText = A + this.V.poster.nick.get();
        }
        textView.setText(buttonText);
    }

    private void F1() {
        this.M.setNeedSpecialAreaBold(true);
        this.M.setTextSize(2, 14.0f);
        String str = this.V.content.get();
        if (af.S(this.M, str, com.tencent.biz.qqcircle.utils.cx.a(270.0f), 2)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(m0().getResources().getColor(R.color.cl7)), 0, str.length(), 34);
            this.M.d(spannableStringBuilder, 0, spannableStringBuilder.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ab
                @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                public final void onClick() {
                    QFSFeedAdFingerCardPresenter.this.x1();
                }
            }, R.color.f158017al3, false);
            this.M.setText(str);
            this.R.setVisibility(0);
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
            int length = spannableStringBuilder2.length();
            QCircleAsyncTextView.e(spannableStringBuilder2, length, this.f85344a0);
            this.M.showEllipseEndImageSpan(true);
            this.M.d(spannableStringBuilder2, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ac
                @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                public final void onClick() {
                    QFSFeedAdFingerCardPresenter.this.y1();
                }
            }, R.color.f158017al3, false);
            this.M.d(spannableStringBuilder2, 0, spannableStringBuilder2.length() - 1, new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ad
                @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                public final void onClick() {
                    QFSFeedAdFingerCardPresenter.this.z1();
                }
            }, R.color.f158017al3, false);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(m0().getResources().getColor(R.color.cl7)), 0, length, 34);
            this.M.setText(spannableStringBuilder2);
            this.R.setVisibility(8);
        }
        this.L.setText("@" + this.V.poster.nick.get());
    }

    private void G1(final Integer num) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.aa
            @Override // java.lang.Runnable
            public final void run() {
                QFSFeedAdFingerCardPresenter.this.A1(num);
            }
        });
    }

    private void H1() {
        F1();
        E1();
        QFSFeedAdFingerAnimWrap qFSFeedAdFingerAnimWrap = this.Z;
        if (qFSFeedAdFingerAnimWrap == null) {
            return;
        }
        qFSFeedAdFingerAnimWrap.U(this.V.createTime.get());
        this.Z.W(this.V.createTimeNs.get());
        this.Z.V(this.V.syncTime.get());
        this.Z.T(af.f(this.V));
        this.Z.X(false);
    }

    private void s1() {
        Map<String, Object> c16 = ae.c(r0(), QCircleDaTongConstant.ElementParamValue.EM_XSJ_COMMERCIAL_AD_FINGER_STATE_1, null, this.f85018i);
        c16.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMERCIAL_ADCARD_THREE_STAGE, "state2");
        for (Map.Entry<View, String> entry : new HashMap<View, String>() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedAdFingerCardPresenter.1
            {
                put(QFSFeedAdFingerCardPresenter.this.J, "em_xsj_commercial_button");
                put(QFSFeedAdFingerCardPresenter.this.L, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_NAME);
                put(QFSFeedAdFingerCardPresenter.this.M, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_DESCRIPTION);
                put(QFSFeedAdFingerCardPresenter.this.Q, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_GUIDE_TEXT);
                put(QFSFeedAdFingerCardPresenter.this.K, "em_xsj_commercial_button");
                put(QFSFeedAdFingerCardPresenter.this.S, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_GUIDE_ICON);
            }
        }.entrySet()) {
            ae.a(entry.getKey(), this.E, entry.getValue(), c16);
        }
    }

    private void t1() {
        this.Y = true;
        View inflate = ((ViewStub) this.C.findViewById(R.id.v_9)).inflate();
        this.I = inflate;
        this.L = (TextView) inflate.findViewById(R.id.f41631hl);
        this.M = (QCircleAsyncTextView) this.I.findViewById(R.id.f41651hn);
        this.N = (TextView) this.I.findViewById(R.id.f41721hu);
        this.P = (TextView) this.I.findViewById(R.id.f41711ht);
        this.Q = (TextView) this.I.findViewById(R.id.f41751hx);
        this.R = (ImageView) this.I.findViewById(R.id.f380218u);
        this.J = (RelativeLayout) this.I.findViewById(R.id.f41671hp);
        this.K = (RelativeLayout) this.I.findViewById(R.id.f41761hy);
        this.S = (ImageView) this.I.findViewById(R.id.f41661ho);
        this.T = (LinearLayout) this.C.findViewById(R.id.v_h);
        this.U = (QCircleMaxHeightScrollView) this.C.findViewById(R.id.f58152p9);
    }

    private void u1() {
        this.L.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.R.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSFeedAdFingerCardPresenter.this.D1(view);
            }
        });
        this.M.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSFeedAdFingerCardPresenter.this.w1(view);
            }
        });
    }

    private boolean v1() {
        return !eq.f85700a.f(this.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.ak(this.V.f398449id.get(), null));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x1() {
        onClick(this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y1() {
        D1(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z1() {
        onClick(this.M);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.e) {
            if (!TextUtils.equals(((com.tencent.biz.qqcircle.immersive.feed.event.e) hVar).getMTraceId(), this.W.getTraceId())) {
                return;
            } else {
                G1(8);
            }
        }
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.f) {
            G1(0);
            QFSFeedAdFingerAnimWrap qFSFeedAdFingerAnimWrap = this.Z;
            if (qFSFeedAdFingerAnimWrap != null) {
                qFSFeedAdFingerAnimWrap.Y();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSFeedAdFingerCardPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        U0(ae.b(this.E.g(), i3));
        try {
            this.W = new GdtAd(u.e(this.E));
            FeedCloudMeta$StFeed c16 = u.c(this.E);
            this.V = c16;
            this.X = c16.status.get();
        } catch (Throwable th5) {
            QLog.e("QFSFeedAdFingerCardPresenter", 1, "[onBindData] failed, error is " + th5);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        if (v1()) {
            return;
        }
        if (!this.Y) {
            B1();
            t1();
            u1();
            this.Z = new QFSFeedAdFingerAnimWrap(this.I);
        }
        s1();
        QFSFeedAdFingerAnimWrap qFSFeedAdFingerAnimWrap = this.Z;
        if (qFSFeedAdFingerAnimWrap != null) {
            qFSFeedAdFingerAnimWrap.N();
        }
        LinearLayout linearLayout = this.T;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        QCircleMaxHeightScrollView qCircleMaxHeightScrollView = this.U;
        if (qCircleMaxHeightScrollView != null) {
            qCircleMaxHeightScrollView.setVisibility(8);
        }
        H1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        if (v1()) {
            return;
        }
        View view = this.I;
        if (view != null) {
            view.setVisibility(8);
        }
        QFSFeedAdFingerAnimWrap qFSFeedAdFingerAnimWrap = this.Z;
        if (qFSFeedAdFingerAnimWrap != null) {
            qFSFeedAdFingerAnimWrap.O();
        }
        LinearLayout linearLayout = this.T;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        QCircleMaxHeightScrollView qCircleMaxHeightScrollView = this.U;
        if (qCircleMaxHeightScrollView != null) {
            qCircleMaxHeightScrollView.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.immersive.utils.j.f90213a.I(this.W, view, this.f85018i, r(), 10024);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        View view;
        super.onFeedSelected(rFWFeedSelectInfo);
        if (!v1() && (view = this.I) != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QFSFeedAdFingerAnimWrap qFSFeedAdFingerAnimWrap;
        super.onPaused(rFWFeedSelectInfo);
        if (!v1() && (qFSFeedAdFingerAnimWrap = this.Z) != null) {
            qFSFeedAdFingerAnimWrap.P();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QFSFeedAdFingerAnimWrap qFSFeedAdFingerAnimWrap;
        super.onResumed(rFWFeedSelectInfo);
        if (!v1() && (qFSFeedAdFingerAnimWrap = this.Z) != null) {
            qFSFeedAdFingerAnimWrap.Q();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedAdFingerCardPresenter";
    }
}
