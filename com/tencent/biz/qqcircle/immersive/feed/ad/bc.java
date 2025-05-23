package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bc extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private static final int Y = DisplayUtil.dip2px(RFWApplication.getApplication(), 4.0f);
    private View I;
    private QFSVipNickNameAndIconView J;
    private QCircleExpandableTextView K;
    private ImageView L;
    private Drawable M;
    private LinearLayout N;
    private TextView P;
    private TextView Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private TextView U;
    private TextView V;
    private GdtAd W;
    private final HashSet<Integer> X = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSVipNickNameAndIconView.a {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A1() {
        C1(this.C);
    }

    private void C1(View view) {
        x.e(view, this.W, u.c(this.E), ae.c(r0(), null, this.W, this.f85018i), r());
    }

    private void D1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView = this.J;
        if (qFSVipNickNameAndIconView == null) {
            QLog.e("QFSFeedChildAdBottomInfoPresenter", 1, "[updateAuthorNameView] author name view should not be null.");
            return;
        }
        qFSVipNickNameAndIconView.x0(12);
        this.J.setUser(feedCloudMeta$StFeed.poster);
        this.J.setReportData(new QFSVipNickNameAndIconView.b().g(feedCloudMeta$StFeed).k(r0()));
        this.J.w0("@" + feedCloudMeta$StFeed.poster.nick.get());
    }

    private void E1() {
        GdtAd gdtAd = this.W;
        if (gdtAd != null && this.N != null) {
            if (!af.k(gdtAd)) {
                this.N.setVisibility(8);
                return;
            }
            this.N.setVisibility(0);
            this.P.setText(this.W.getAppName());
            this.Q.setText(this.W.getAppChannelAuthorName());
            this.R.setText(this.W.getAppChannelICPNumber());
            this.S.setText(this.W.getAppChannelVersionName());
            final String appChannelPermissionUrl = this.W.getAppChannelPermissionUrl();
            final String appChannelPrivacyUrl = this.W.getAppChannelPrivacyUrl();
            final String appChannelFeatureListUrl = this.W.getAppChannelFeatureListUrl();
            this.V.setText(Html.fromHtml("<u>\u529f\u80fd\u4ecb\u7ecd</u>"));
            this.T.setText(Html.fromHtml("<u>\u5e94\u7528\u6743\u9650</u>"));
            this.U.setText(Html.fromHtml("<u>\u9690\u79c1\u534f\u8bae</u>"));
            this.N.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.au
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bc.this.u1(view);
                }
            });
            this.T.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.av
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bc.this.v1(appChannelPermissionUrl, view);
                }
            });
            this.U.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.aw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bc.this.w1(appChannelPrivacyUrl, view);
                }
            });
            this.V.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ax
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bc.this.x1(appChannelFeatureListUrl, view);
                }
            });
            return;
        }
        QLog.e("QFSFeedChildAdBottomInfoPresenter", 1, "[updateBottomAppInfo] container is null.");
    }

    private void F1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.K == null) {
            QLog.d("QFSFeedChildAdBottomInfoPresenter", 1, "[updateFeedPostContentRichText] current feed post content view should be not null.");
            return;
        }
        if (TextUtils.isEmpty(feedCloudMeta$StFeed.content.get())) {
            this.K.setVisibility(8);
            return;
        }
        this.K.setSpecialAreaTextColor(R.color.f158017al3);
        this.K.setNeedSpecialAreaBold(true);
        this.K.setDisableExpand(true);
        this.K.setVisibility(0);
        QCircleAsyncTextView qCircleAsyncTextView = (QCircleAsyncTextView) this.K.e();
        qCircleAsyncTextView.setTextSize(2, 14.0f);
        String str = feedCloudMeta$StFeed.content.get();
        qCircleAsyncTextView.setMaxLines(2);
        if (af.S(qCircleAsyncTextView, str, (int) (com.tencent.biz.qqcircle.utils.bz.j() * 0.72f), 2)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(m0().getResources().getColor(R.color.cl7)), 0, str.length(), 34);
            qCircleAsyncTextView.d(spannableStringBuilder, 0, spannableStringBuilder.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.az
                @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                public final void onClick() {
                    bc.this.y1();
                }
            }, R.color.f158017al3, false);
            qCircleAsyncTextView.setText(spannableStringBuilder);
            this.L.setVisibility(0);
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
        QCircleAsyncTextView.e(spannableStringBuilder2, str.length(), this.M);
        qCircleAsyncTextView.showEllipseEndImageSpan(true);
        qCircleAsyncTextView.d(spannableStringBuilder2, 0, spannableStringBuilder2.length() - 1, new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ba
            @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
            public final void onClick() {
                bc.this.z1();
            }
        }, R.color.f158017al3, false);
        qCircleAsyncTextView.d(spannableStringBuilder2, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bb
            @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
            public final void onClick() {
                bc.this.A1();
            }
        }, R.color.f158017al3, false);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(m0().getResources().getColor(R.color.cl7)), 0, str.length(), 34);
        qCircleAsyncTextView.setText(spannableStringBuilder2);
        this.L.setVisibility(8);
    }

    private void o1(View view, String str) {
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null && view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            VideoReport.setElementReuseIdentifier(view, str + this.E.g().f398449id.get());
            VideoReport.setElementParams(view, hashMap);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        }
    }

    private void p1(View view) {
        com.tencent.biz.qqcircle.immersive.utils.j.f90213a.I(this.W, view, this.f85018i, r(), Integer.MIN_VALUE);
    }

    private void q1(View view) {
        if (view == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f378118_);
        this.N = linearLayout;
        if (linearLayout == null) {
            return;
        }
        this.P = (TextView) linearLayout.findViewById(R.id.f3777186);
        this.Q = (TextView) this.N.findViewById(R.id.f3774183);
        this.R = (TextView) this.N.findViewById(R.id.f3776185);
        this.S = (TextView) this.N.findViewById(R.id.f3780189);
        this.V = (TextView) this.N.findViewById(R.id.f3775184);
        this.T = (TextView) this.N.findViewById(R.id.f3778187);
        this.U = (TextView) this.N.findViewById(R.id.f3779188);
        af.a(this.N);
        this.N.setVisibility(8);
    }

    private void r1(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.v_7);
        this.L = imageView;
        imageView.setOnClickListener(this);
    }

    private void s1() {
        this.K.setOnClickHashTagListener(new RFWAsyncRichTextView.OnClickHashTagTextListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ay
            @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener
            public final void onClick(String str) {
                bc.this.t1(str);
            }
        });
        this.J.setNickNameClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(String str) {
        p1(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.immersive.utils.j.f90213a.I(this.W, view, this.f85018i, r(), 10069);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v1(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.launcher.c.n(m0(), str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w1(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.launcher.c.n(m0(), str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x1(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.launcher.c.n(m0(), str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y1() {
        p1(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z1() {
        p1(this.C);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        Context context;
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSFeedChildAdBottomInfoPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        U0(ae.b(this.E.g(), i3));
        c1(false);
        try {
            FeedCloudMeta$StFeed c16 = u.c(this.E);
            GdtAd gdtAd = new GdtAd(u.e(this.E));
            this.W = gdtAd;
            com.tencent.biz.qqcircle.immersive.utils.j jVar = com.tencent.biz.qqcircle.immersive.utils.j.f90213a;
            View view = this.I;
            if (view != null) {
                context = view.getContext();
            } else {
                context = null;
            }
            jVar.M(gdtAd, context);
            D1(c16);
            F1(c16);
            E1();
        } catch (Throwable th5) {
            QLog.e("QFSFeedChildAdBottomInfoPresenter", 1, "[onBindData] failed, error is " + th5);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean D0(e40.p pVar) {
        if (this.K != null) {
            return !r0.g();
        }
        return super.D0(pVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = view.findViewById(R.id.v_p);
        this.J = (QFSVipNickNameAndIconView) view.findViewById(R.id.v_i);
        this.X.add(Integer.valueOf(R.id.v_i));
        ((ViewStub) view.findViewById(R.id.f33370w_)).inflate();
        this.K = (QCircleExpandableTextView) view.findViewById(R.id.f165233va0);
        if (this.M == null) {
            Drawable mutate = QCircleSkinHelper.getInstance().getDrawable(m0(), R.drawable.mhk).mutate();
            this.M = mutate;
            mutate.setBounds(ImmersiveUtils.dpToPx(8.0f), 0, ImmersiveUtils.dpToPx(46.0f), ImmersiveUtils.dpToPx(17.0f));
        }
        af.a(this.I);
        r1(view);
        q1(view);
        s1();
        o1(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_NAME);
        o1(this.L, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_FEEDBACK);
        o1(this.K.e(), QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_DESCRIPTION);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void c1(boolean z16) {
        int i3;
        super.c1(z16);
        View view = this.I;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleConfigChangeEvent.class);
        return eventClass;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.v_7) {
            C1(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            af.a(this.N);
            af.a(this.I);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdBottomInfoPresenter";
    }
}
