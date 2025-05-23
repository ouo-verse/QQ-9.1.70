package com.tencent.biz.qqcircle.comment.aicomment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import n20.d;

/* loaded from: classes4.dex */
public class QFSAiCommentPanel extends FrameLayout {
    private n20.b C;
    private QFSPagAnimView D;
    private TextView E;
    private TextView F;
    private AnimatorSet G;

    /* renamed from: d, reason: collision with root package name */
    private d f83338d;

    /* renamed from: e, reason: collision with root package name */
    private c f83339e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f83340f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f83341h;

    /* renamed from: i, reason: collision with root package name */
    private QFSPagAnimView f83342i;

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView f83343m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSAiCommentPanel.this.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f83345d;

        b(List list) {
            this.f83345d = list;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QFSAiCommentPanel.this.D != null && QFSAiCommentPanel.this.f83340f != null && QFSAiCommentPanel.this.C != null && QFSAiCommentPanel.this.f83343m != null) {
                QFSAiCommentPanel.this.D.V();
                QFSAiCommentPanel.this.f83340f.setVisibility(8);
                QFSAiCommentPanel.this.f83343m.setVisibility(0);
                QFSAiCommentPanel.this.C.setDatas(this.f83345d);
                QFSAiCommentPanel.this.f83343m.scheduleLayoutAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements Observer<UIStateData<List<FeedCloudMeta$StComment>>> {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QFSAiCommentPanel> f83347d;

        public c(QFSAiCommentPanel qFSAiCommentPanel) {
            this.f83347d = new WeakReference<>(qFSAiCommentPanel);
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<FeedCloudMeta$StComment>> uIStateData) {
            QFSAiCommentPanel qFSAiCommentPanel;
            if (uIStateData == null || (qFSAiCommentPanel = this.f83347d.get()) == null) {
                return;
            }
            int state = uIStateData.getState();
            if (state != 0) {
                if (state == 1) {
                    qFSAiCommentPanel.A();
                    qFSAiCommentPanel.x();
                    return;
                } else if (state == 2 || state == 3) {
                    qFSAiCommentPanel.y(uIStateData.getData());
                    return;
                } else if (state != 4) {
                    return;
                }
            }
            qFSAiCommentPanel.z(uIStateData.getMsg(), !uIStateData.getIsFinish());
            qFSAiCommentPanel.B();
        }
    }

    public QFSAiCommentPanel(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        LinearLayout linearLayout;
        if (this.D != null && (linearLayout = this.f83340f) != null && this.F != null && this.f83343m != null) {
            linearLayout.setAlpha(1.0f);
            this.f83340f.setTranslationX(0.0f);
            this.f83342i.setAlpha(1.0f);
            this.f83340f.setVisibility(0);
            this.E.setText(h.a(R.string.f188063vo));
            r("qvideo_skin_icon_comment_lucy_loading");
            this.F.setVisibility(4);
            this.f83343m.setVisibility(8);
            this.f83343m.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        QFSPagAnimView qFSPagAnimView = this.f83342i;
        if (qFSPagAnimView == null) {
            return;
        }
        qFSPagAnimView.V();
    }

    private void C() {
        QFSPagAnimView qFSPagAnimView = this.D;
        if (qFSPagAnimView != null) {
            qFSPagAnimView.V();
        }
        QFSPagAnimView qFSPagAnimView2 = this.f83342i;
        if (qFSPagAnimView2 != null) {
            qFSPagAnimView2.V();
        }
    }

    private void k(List<FeedCloudMeta$StComment> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f83342i, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f83340f, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f83340f, "translationX", 0.0f, -cx.a(18.0f));
        ofFloat.addListener(new a());
        ofFloat2.addListener(new b(list));
        RecyclerView recyclerView = this.f83343m;
        recyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(recyclerView.getContext(), R.anim.f154896t1));
        AnimatorSet animatorSet = new AnimatorSet();
        this.G = animatorSet;
        animatorSet.playTogether(ofFloat2, ofFloat3, ofFloat);
        this.G.setDuration(240L);
        this.G.start();
    }

    private void l(QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        QFSFeedCommentInfo qFSFeedCommentInfo;
        String str;
        String str2;
        String str3;
        if (qFSCommentInputWindowConfig != null && (qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo) != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSFeedCommentInfo.mFeed;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            String str4 = "";
            if (feedCloudMeta$StFeed == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            buildElementParams.put("xsj_feed_id", str);
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_AI_REC_CMTPANEL);
            if (qFSCommentInputWindowConfig.commentInfo.mComment == null) {
                str2 = "cmt";
            } else {
                str2 = "reply";
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str2);
            FeedCloudMeta$StComment feedCloudMeta$StComment = qFSCommentInputWindowConfig.commentInfo.mComment;
            if (feedCloudMeta$StComment == null) {
                str3 = "";
            } else {
                str3 = feedCloudMeta$StComment.f398447id.get();
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, str3);
            QCircleReportBean qCircleReportBean = qFSCommentInputWindowConfig.reportBean;
            if (qCircleReportBean != null) {
                str4 = qCircleReportBean.getDtPageId();
            }
            buildElementParams.put("xsj_custom_pgid", str4);
            VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
        }
    }

    private Drawable m() {
        int[] iArr;
        if (QCircleSkinHelper.getInstance().isDarkMode()) {
            iArr = new int[]{Color.parseColor("#1A1A1A"), Color.parseColor("#000000")};
        } else {
            iArr = new int[]{Color.parseColor("#EAF6FF"), Color.parseColor("#B5DFFF")};
        }
        return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr);
    }

    private QCircleBaseFragment n() {
        return QCirclePluginUtil.getQCircleBaseFragment(getContext());
    }

    private void o() {
        if (this.f83341h == null) {
            return;
        }
        this.f83341h.setBackground(m());
    }

    private void p() {
        if (this.f83342i == null) {
            return;
        }
        this.f83342i.setResUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_skin_img_comment_lucy_bg_light"));
    }

    private void q() {
        if (this.f83338d == null) {
            return;
        }
        if (this.f83339e == null) {
            this.f83339e = new c(this);
        }
        this.f83338d.N1().observe(n(), this.f83339e);
    }

    private void r(String str) {
        QFSPagAnimView qFSPagAnimView = this.D;
        if (qFSPagAnimView == null) {
            return;
        }
        qFSPagAnimView.N(QCircleSkinHelper.getInstance().getUrl(str), Integer.MAX_VALUE, -1L);
    }

    private void s() {
        View.inflate(getContext(), R.layout.g7q, this);
        this.f83341h = (ImageView) findViewById(R.id.f33420we);
        o();
        this.f83342i = (QFSPagAnimView) findViewById(R.id.f33430wf);
        p();
        this.f83343m = (RecyclerView) findViewById(R.id.f33460wi);
        n20.b bVar = new n20.b();
        this.C = bVar;
        this.f83343m.setAdapter(bVar);
        this.f83343m.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f83340f = (LinearLayout) findViewById(R.id.f33490wl);
        this.D = (QFSPagAnimView) findViewById(R.id.f33480wk);
        this.E = (TextView) findViewById(R.id.f33500wm);
        this.F = (TextView) findViewById(R.id.f33470wj);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    private void t() {
        if (n() == null) {
            QLog.d("QFSAiCommentPanel", 1, "getBaseFragment() is null");
        } else {
            this.f83338d = (d) n().getViewModel(d.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        QFSPagAnimView qFSPagAnimView = this.f83342i;
        if (qFSPagAnimView == null) {
            return;
        }
        qFSPagAnimView.setRepeatTimes(Integer.MAX_VALUE);
        this.f83342i.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(List<FeedCloudMeta$StComment> list) {
        QLog.d("QFSAiCommentPanel", 1, "showComments");
        k(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, boolean z16) {
        int i3;
        if (this.D != null && this.F != null && this.f83343m != null) {
            this.E.setText(str);
            r("qvideo_skin_icon_comment_lucy_loading_failed");
            TextView textView = this.F;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            textView.setVisibility(i3);
            this.f83343m.setVisibility(8);
        }
    }

    public void j() {
        AnimatorSet animatorSet = this.G;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.G.cancel();
        }
        d dVar = this.f83338d;
        if (dVar != null) {
            dVar.N1().removeObserver(this.f83339e);
        }
        setVisibility(8);
        C();
        v();
    }

    public void setCommentItemClickListener(View.OnClickListener onClickListener) {
        n20.b bVar = this.C;
        if (bVar != null && this.F != null && onClickListener != null) {
            bVar.q0(onClickListener);
            this.F.setOnClickListener(onClickListener);
        }
    }

    public void u(QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        d dVar = this.f83338d;
        if (dVar == null) {
            return;
        }
        dVar.P1(qFSCommentInputWindowConfig);
        this.C.p0(qFSCommentInputWindowConfig);
    }

    public void v() {
        d dVar = this.f83338d;
        if (dVar == null) {
            return;
        }
        dVar.R1();
    }

    public void w(QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        setVisibility(0);
        q();
        u(qFSCommentInputWindowConfig);
        l(qFSCommentInputWindowConfig);
    }

    public QFSAiCommentPanel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s();
        t();
    }
}
