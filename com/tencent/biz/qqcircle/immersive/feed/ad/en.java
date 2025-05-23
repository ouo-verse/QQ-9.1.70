package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenCloseEvent;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSAdFollowView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class en extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener, Observer<e30.b>, QFSFollowView.c {
    private GdtAd I;
    private FeedCloudMeta$StFeed J;
    private RelativeLayout K;
    private QCircleAsyncTextView L;
    private QFSVipNickNameAndIconView M;
    private QCircleAvatarView N;
    private View P;
    private LinearLayout Q;
    private QFSAdFollowView R;
    private Size S;
    private Drawable T;
    private ImageView U;

    private void A1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.R == null) {
            QLog.d("QFSFullScreenAdTopInfoPresenter", 1, "[updateAuthorFollowView] author attention view not be null.");
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeed.poster.get();
        if (TextUtils.isEmpty(feedCloudMeta$StUser.f398463id.get())) {
            feedCloudMeta$StUser.f398463id.set(String.valueOf(Integer.MIN_VALUE));
        }
        this.R.setUserData(feedCloudMeta$StUser, feedCloudMeta$StFeed);
    }

    private void B1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView = this.M;
        if (qFSVipNickNameAndIconView == null) {
            QLog.e("QFSFullScreenAdTopInfoPresenter", 1, "[updateAuthorNameView] author name view should not be null.");
            return;
        }
        qFSVipNickNameAndIconView.setUser(feedCloudMeta$StFeed.poster);
        this.M.setReportData(new QFSVipNickNameAndIconView.b().g(feedCloudMeta$StFeed).k(r0()));
        this.M.w0(feedCloudMeta$StFeed.poster.nick.get());
        this.M.setNickNameClickListener(new QFSVipNickNameAndIconView.a() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ei
        });
    }

    private void C1() {
        if (this.L == null) {
            QLog.d("QFSFullScreenAdTopInfoPresenter", 1, "[updateFeedPostContentRichText] current feed post content view should be not null.");
            return;
        }
        if (TextUtils.isEmpty(this.J.content.get())) {
            this.L.setVisibility(8);
            return;
        }
        this.L.setNeedSpecialAreaBold(true);
        this.L.setVisibility(0);
        QCircleAsyncTextView qCircleAsyncTextView = this.L;
        qCircleAsyncTextView.setTypeface(Typeface.defaultFromStyle(1));
        qCircleAsyncTextView.setTextSize(2, 16.0f);
        String str = this.J.content.get();
        qCircleAsyncTextView.setMaxLines(2);
        if (af.S(qCircleAsyncTextView, str, (int) (ImmersiveUtils.getScreenWidth() * 0.72f), 2)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(m0().getResources().getColor(R.color.cm6)), 0, str.length(), 34);
            qCircleAsyncTextView.d(spannableStringBuilder, 0, spannableStringBuilder.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ej
                @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
                public final void onClick() {
                    en.this.u1();
                }
            }, R.color.f158017al3, false);
            qCircleAsyncTextView.setText(spannableStringBuilder);
            this.U.setVisibility(0);
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
        QCircleAsyncTextView.e(spannableStringBuilder2, str.length(), this.T);
        qCircleAsyncTextView.showEllipseEndImageSpan(true);
        qCircleAsyncTextView.d(spannableStringBuilder2, 0, spannableStringBuilder2.length() - 1, new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.ek
            @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
            public final void onClick() {
                en.this.v1();
            }
        }, R.color.f158017al3, false);
        qCircleAsyncTextView.d(spannableStringBuilder2, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), new QCircleAsyncTextView.b() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.el
            @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
            public final void onClick() {
                en.this.w1();
            }
        }, R.color.f158017al3, false);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(m0().getResources().getColor(R.color.cm6)), 0, str.length(), 34);
        qCircleAsyncTextView.setText(spannableStringBuilder2);
        this.U.setVisibility(8);
    }

    private void k1(View view, String str) {
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

    private void l1(View view, int i3) {
        if (view == null) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.utils.j.f90213a.K(this.I, view, this.f85018i, r(), i3);
    }

    private void m1() {
        com.tencent.biz.qqcircle.immersive.utils.bi.p(new bi.a() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.em
            @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
            public final void a(Pair pair) {
                en.this.t1(pair);
            }
        });
    }

    private void n1(View view) {
        x.g(view, this.I, this.J, ae.c(r0(), null, this.I, this.f85018i), r(), null, 1);
    }

    private void o1(boolean z16) {
        RelativeLayout relativeLayout = this.K;
        if (relativeLayout == null) {
            QLog.d("QFSFullScreenAdTopInfoPresenter", 1, "[handlerCleanScreen] mHeaderLayout is empty.");
        } else if (z16) {
            relativeLayout.setVisibility(8);
        } else {
            relativeLayout.setVisibility(0);
        }
    }

    private void p1(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f42321jg);
        this.U = imageView;
        imageView.setOnClickListener(this);
    }

    private void q1(LinearLayout linearLayout) {
        if (linearLayout == null) {
            QLog.d("QFSFullScreenAdTopInfoPresenter", 1, "set animation error, authorLayout is null. ");
            return;
        }
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setDuration(400L);
        linearLayout.setLayoutTransition(layoutTransition);
    }

    private void s1(View view) {
        QFSAdFollowView qFSAdFollowView = (QFSAdFollowView) view.findViewById(R.id.f42271jb);
        this.R = qFSAdFollowView;
        qFSAdFollowView.setContentDescription("\u70b9\u51fb\u5173\u6ce8");
        this.R.setFollowStateChangeListener(this);
        this.R.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void t1(Pair pair) {
        String g16 = com.tencent.biz.qqcircle.utils.bj.g((FeedCloudMeta$StFeed) this.f85017h);
        QLog.d("QFSFullScreenAdTopInfoPresenter", 1, "[onClick] currentFeedId: " + g16);
        SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenCloseEvent(g16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1() {
        l1(this.C, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v1() {
        l1(this.C, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w1() {
        n1(this.C);
    }

    private void z1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleAvatarView qCircleAvatarView = this.N;
        if (qCircleAvatarView == null) {
            QLog.e("QFSFullScreenAdTopInfoPresenter", 1, "[updateAuthorAvatar] author icon view should not be null.");
        } else {
            qCircleAvatarView.setUser(feedCloudMeta$StFeed.poster, this.S);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.j) {
            o1(((com.tencent.biz.qqcircle.immersive.feed.event.j) hVar).b());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.K = (RelativeLayout) view.findViewById(R.id.f42341ji);
        this.L = (QCircleAsyncTextView) view.findViewById(R.id.f42331jh);
        this.M = (QFSVipNickNameAndIconView) view.findViewById(R.id.f42291jd);
        this.N = (QCircleAvatarView) view.findViewById(R.id.f42441js);
        this.P = view.findViewById(R.id.f42311jf);
        this.Q = (LinearLayout) view.findViewById(R.id.f42281jc);
        s1(view);
        this.Q.setOnClickListener(this);
        this.P.setOnClickListener(this);
        q1(this.Q);
        this.L.setSpecialClickAreaColor(R.color.f158017al3);
        if (this.T == null) {
            Drawable mutate = QCircleSkinHelper.getInstance().getDrawable(m0(), R.drawable.mhm).mutate();
            this.T = mutate;
            mutate.setBounds(ImmersiveUtils.dpToPx(8.0f), 0, ImmersiveUtils.dpToPx(46.0f), ImmersiveUtils.dpToPx(17.0f));
        }
        this.S = com.tencent.biz.qqcircle.immersive.utils.n.a(view.getContext(), R.dimen.d2_);
        SimpleEventBus.getInstance().registerReceiver(this);
        p1(view);
        k1(this.Q, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_NAME);
        k1(this.U, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_FEEDBACK);
        k1(this.L, QCircleDaTongConstant.ElementId.EM_XSJ_COMMERCIAL_DESCRIPTION);
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.c
    public void O(boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.v(z16, feedCloudMeta$StUser));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            if (view.getId() == R.id.f42311jf) {
                m1();
            } else if (view.getId() != R.id.f42281jc && view.getId() != R.id.f42271jb) {
                if (view.getId() == R.id.f42321jg) {
                    n1(this.U);
                }
            } else {
                GdtAd gdtAd = this.I;
                if (gdtAd != null && gdtAd.isValid()) {
                    i3 = 2;
                } else {
                    i3 = Integer.MIN_VALUE;
                }
                l1(this.Q, i3);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null) {
            return;
        }
        RFWLog.d("QFSFullScreenAdTopInfoPresenter", RFWLog.USR, "fs_lifecycle onSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        o1(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        RFWLog.d("QFSFullScreenAdTopInfoPresenter", RFWLog.USR, "onUnSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
    }

    protected void r1() {
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.J;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (feedCloudMeta$StFeed.f398449id != null) {
            QLog.d("QFSFullScreenAdTopInfoPresenter", 1, "feed id = " + this.J.f398449id.get());
        }
        if (this.L != null && (pBStringField = this.J.content) != null && !TextUtils.isEmpty(pBStringField.get())) {
            this.L.setText((CharSequence) this.J.content.get(), false);
            return;
        }
        QCircleAsyncTextView qCircleAsyncTextView = this.L;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFullScreenAdTopInfoPresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        Context context;
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSFullScreenAdTopInfoPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        QLog.d("QFSFullScreenAdTopInfoPresenter", 1, "[onBindData] feed id: " + com.tencent.biz.qqcircle.utils.bj.g(feedCloudMeta$StFeed) + " | position: " + i3);
        this.J = u.c(this.E);
        r1();
        try {
            FeedCloudMeta$StFeed c16 = u.c(this.E);
            GdtAd gdtAd = new GdtAd(u.e(this.E));
            this.I = gdtAd;
            com.tencent.biz.qqcircle.immersive.utils.j jVar = com.tencent.biz.qqcircle.immersive.utils.j.f90213a;
            RelativeLayout relativeLayout = this.K;
            if (relativeLayout != null) {
                context = relativeLayout.getContext();
            } else {
                context = null;
            }
            jVar.M(gdtAd, context);
            z1(c16);
            B1(c16);
            A1(c16);
            C1();
        } catch (Throwable th5) {
            QLog.e("QFSFullScreenAdTopInfoPresenter", 1, "[onBindData] failed, error is " + th5);
        }
        U0(ae.b(feedCloudMeta$StFeed, i3));
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: y1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d("QFSFullScreenAdTopInfoPresenter", 1, "[onChanged] onChanged...");
        }
        if (bVar == null) {
            return;
        }
        A1(bVar.g());
    }
}
