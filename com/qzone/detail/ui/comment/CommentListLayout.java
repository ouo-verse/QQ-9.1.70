package com.qzone.detail.ui.comment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CommentListLayout extends LinearLayout {
    private QZonePullToRefreshListView C;
    LinearLayout D;
    private TextView E;
    private FrameLayout F;
    private View G;
    private View H;
    private TranslateAnimation I;
    private TranslateAnimation J;
    private volatile boolean K;
    private boolean L;
    private ValueAnimator.AnimatorUpdateListener M;
    private AnimatorListenerAdapter N;
    private ValueAnimator P;
    private ValueAnimator Q;
    private int R;
    private String S;
    private String T;
    private c U;

    /* renamed from: d, reason: collision with root package name */
    private View f46949d;

    /* renamed from: e, reason: collision with root package name */
    private Context f46950e;

    /* renamed from: f, reason: collision with root package name */
    private int f46951f;

    /* renamed from: h, reason: collision with root package name */
    private int f46952h;

    /* renamed from: i, reason: collision with root package name */
    private final int f46953i;

    /* renamed from: m, reason: collision with root package name */
    private QZonePullToRefreshListView f46954m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CommentListLayout.this.K = false;
            CommentListLayout commentListLayout = CommentListLayout.this;
            commentListLayout.u(animator == commentListLayout.P, false);
            CommentListLayout.this.x(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CommentListLayout.this.K = true;
            CommentListLayout commentListLayout = CommentListLayout.this;
            commentListLayout.R = commentListLayout.getMeasuredWidth();
            CommentListLayout commentListLayout2 = CommentListLayout.this;
            commentListLayout2.u(animator == commentListLayout2.P, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CommentListLayout.this.t(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface c {
        void a();

        void b();
    }

    public CommentListLayout(Context context) {
        this(context, null, -1, ViewUtils.getScreenHeight() / 2);
    }

    private Animator.AnimatorListener j() {
        if (this.N == null) {
            this.N = new a();
        }
        return this.N;
    }

    private ValueAnimator.AnimatorUpdateListener k() {
        if (this.M == null) {
            this.M = new b();
        }
        return this.M;
    }

    private void q() {
        LayoutInflater from = LayoutInflater.from(this.f46950e);
        if (from != null) {
            View inflate = from.inflate(R.layout.bue, (ViewGroup) null);
            this.f46949d = inflate;
            this.f46954m = (QZonePullToRefreshListView) inflate.findViewById(R.id.elh);
            this.C = (QZonePullToRefreshListView) this.f46949d.findViewById(R.id.f166741hr2);
            addView(this.f46949d, new ViewGroup.LayoutParams(this.f46951f, this.f46952h));
            this.D = (LinearLayout) this.f46949d.findViewById(R.id.hg7);
            this.E = (TextView) this.f46949d.findViewById(R.id.jfv);
            FrameLayout frameLayout = (FrameLayout) this.f46949d.findViewById(R.id.aes);
            this.F = frameLayout;
            AccessibilityUtil.c(frameLayout, "\u6536\u8d77", Button.class.getName());
            this.G = this.f46949d.findViewById(R.id.g1h);
            this.H = this.f46949d.findViewById(R.id.id_);
            this.G.setVisibility(4);
            setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(float f16) {
        float f17 = f16 * this.R;
        QZonePullToRefreshListView qZonePullToRefreshListView = this.f46954m;
        if (qZonePullToRefreshListView != null) {
            qZonePullToRefreshListView.setTranslationX(f17);
        }
        LinearLayout linearLayout = this.D;
        if (linearLayout != null) {
            linearLayout.setTranslationX(f17);
        }
        View view = this.G;
        if (view != null) {
            view.setTranslationX(this.R + f17);
        }
        QZonePullToRefreshListView qZonePullToRefreshListView2 = this.C;
        if (qZonePullToRefreshListView2 != null) {
            qZonePullToRefreshListView2.setTranslationX(f17 + this.R);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.f46954m;
        if (qZonePullToRefreshListView != null) {
            qZonePullToRefreshListView.setTranslationX(0.0f);
        }
        LinearLayout linearLayout = this.D;
        if (linearLayout != null) {
            linearLayout.setTranslationX(0.0f);
            this.D.setVisibility(0);
        }
        QZonePullToRefreshListView qZonePullToRefreshListView2 = this.C;
        if (qZonePullToRefreshListView2 != null) {
            qZonePullToRefreshListView2.setTranslationX(0.0f);
            this.C.setVisibility(8);
        }
        View view = this.H;
        if (view != null) {
            view.setVisibility(8);
        }
        setCommentNum(0);
    }

    public void h() {
        if (this.K) {
            return;
        }
        A();
    }

    public void i() {
        if (getVisibility() != 0 || this.K) {
            return;
        }
        this.L = true;
        startAnimation(m());
    }

    public View l() {
        return this.H;
    }

    public Animation m() {
        if (this.J == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.f46952h);
            this.J = translateAnimation;
            translateAnimation.setDuration(300L);
            this.J.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.detail.ui.comment.CommentListLayout.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    CommentListLayout.this.post(new Runnable() { // from class: com.qzone.detail.ui.comment.CommentListLayout.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CommentListLayout.this.setVisible(false);
                            if (CommentListLayout.this.U != null) {
                                CommentListLayout.this.U.a();
                            }
                        }
                    });
                    CommentListLayout.this.v();
                    CommentListLayout.this.K = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    CommentListLayout.this.K = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        return this.J;
    }

    public QZonePullToRefreshListView n() {
        return this.f46954m;
    }

    public QZonePullToRefreshListView o() {
        return this.C;
    }

    public Animation p() {
        if (this.I == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, this.f46952h, 0.0f);
            this.I = translateAnimation;
            translateAnimation.setDuration(300L);
            this.I.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.detail.ui.comment.CommentListLayout.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    CommentListLayout.this.post(new Runnable() { // from class: com.qzone.detail.ui.comment.CommentListLayout.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CommentListLayout.this.setVisible(true);
                            if (CommentListLayout.this.U != null) {
                                CommentListLayout.this.U.b();
                            }
                        }
                    });
                    CommentListLayout.this.K = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    CommentListLayout.this.K = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        return this.I;
    }

    public boolean r() {
        return this.K;
    }

    public boolean s() {
        return this.L;
    }

    public void setCommentDetailTitle() {
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(this.T);
        }
    }

    public void setCommentListViewHeight(int i3) {
        View view = this.f46949d;
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f46949d.getLayoutParams();
        layoutParams.height = i3;
        this.f46949d.setLayoutParams(layoutParams);
        this.f46949d.invalidate();
    }

    public void setCommentNum(int i3) {
        if (this.E != null) {
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewCommentReply", "\u8bc4\u8bba\u56de\u590d");
            if (!TextUtils.isEmpty(this.S)) {
                config = this.S;
            }
            if (i3 > 0) {
                config = String.format(config + "(%d)", Integer.valueOf(i3));
            }
            this.E.setText(config);
        }
    }

    public void setOnClickListenerForBackArea(View.OnClickListener onClickListener) {
        View view = this.H;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnClickListenerForCloseBtn(View.OnClickListener onClickListener) {
        FrameLayout frameLayout = this.F;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(onClickListener);
        }
    }

    public void setOnClickListenerForCommentContainer(View.OnClickListener onClickListener) {
        LinearLayout linearLayout = this.D;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(onClickListener);
        }
    }

    public void setOnCommentViewAnimListener(c cVar) {
        this.U = cVar;
    }

    public void setTitleText(String str) {
        this.S = str;
    }

    public void w() {
        if (getVisibility() == 0 || this.K) {
            return;
        }
        this.L = false;
        startAnimation(p());
    }

    public void x(boolean z16) {
        View view = this.G;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 4);
        }
    }

    public void y() {
        if (this.K) {
            return;
        }
        z();
    }

    public CommentListLayout(Context context, int i3, int i16) {
        this(context, null, i3, i16);
    }

    public void A() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(-1.0f, 0.0f);
        this.Q = ofFloat;
        ofFloat.addUpdateListener(k());
        this.Q.addListener(j());
        this.Q.setDuration(300L);
        this.Q.start();
    }

    public void z() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, -1.0f);
        this.P = ofFloat;
        ofFloat.addUpdateListener(k());
        this.P.addListener(j());
        this.P.setDuration(300L);
        this.P.start();
    }

    public CommentListLayout(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet);
        this.f46951f = -1;
        this.f46952h = ViewUtils.getScreenHeight() / 2;
        this.f46953i = 300;
        this.K = false;
        this.L = true;
        this.S = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewCommentReply", "\u8bc4\u8bba\u56de\u590d");
        this.T = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewCommentDetail", "\u8bc4\u8bba\u8be6\u60c5");
        this.f46950e = context;
        this.f46951f = i3;
        this.f46952h = i16;
        q();
    }

    public void setVisible(boolean z16) {
        setVisibility(z16 ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z16, boolean z17) {
        if (!z16) {
            if (z17) {
                QZonePullToRefreshListView qZonePullToRefreshListView = this.f46954m;
                if (qZonePullToRefreshListView != null) {
                    qZonePullToRefreshListView.setVisibility(0);
                }
                LinearLayout linearLayout = this.D;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                    return;
                }
                return;
            }
            QZonePullToRefreshListView qZonePullToRefreshListView2 = this.C;
            if (qZonePullToRefreshListView2 != null) {
                qZonePullToRefreshListView2.setVisibility(8);
            }
            View view = this.G;
            if (view != null) {
                view.setTranslationX(0.0f);
                return;
            }
            return;
        }
        View view2 = this.H;
        if (view2 != null) {
            view2.setEnabled(!z17);
        }
        View view3 = this.G;
        if (view3 != null) {
            view3.setTranslationX(z17 ? this.R : 0.0f);
            this.G.setVisibility(z17 ? 0 : 4);
        }
        QZonePullToRefreshListView qZonePullToRefreshListView3 = this.C;
        if (qZonePullToRefreshListView3 != null) {
            qZonePullToRefreshListView3.setTranslationX(z17 ? this.R : 0.0f);
            this.C.setVisibility(z17 ? 8 : 0);
        }
        if (z17) {
            return;
        }
        QZonePullToRefreshListView qZonePullToRefreshListView4 = this.f46954m;
        if (qZonePullToRefreshListView4 != null) {
            qZonePullToRefreshListView4.setVisibility(4);
        }
        LinearLayout linearLayout2 = this.D;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(4);
        }
    }
}
