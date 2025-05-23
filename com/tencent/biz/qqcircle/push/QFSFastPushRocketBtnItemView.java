package com.tencent.biz.qqcircle.push;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.l;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

/* loaded from: classes5.dex */
public class QFSFastPushRocketBtnItemView extends FrameLayout {
    private AnimatorSet C;
    private AnimatorSet D;
    private int E;
    private int F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private float M;
    private float N;
    private int P;
    private boolean Q;
    private c R;
    private String S;
    private String T;
    private String U;
    private int V;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f91786d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f91787e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f91788f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f91789h;

    /* renamed from: i, reason: collision with root package name */
    private AnimatorSet f91790i;

    /* renamed from: m, reason: collision with root package name */
    private AnimatorSet f91791m;

    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSFastPushRocketBtnItemView.this.o(1);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(com.tencent.biz.qqcircle.push.a aVar);
    }

    public QFSFastPushRocketBtnItemView(@NonNull Context context) {
        this(context, null);
    }

    private void A(int i3) {
        this.f91788f = new ImageView(getContext(), null, 0);
        this.f91788f.setLayoutParams(new FrameLayout.LayoutParams(cx.a(24.0f), cx.a(24.0f), 17));
        this.f91788f.setImageResource(i3);
        addView(this.f91788f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        AnimatorSet animatorSet = this.f91791m;
        if (animatorSet == null) {
            return;
        }
        animatorSet.addListener(new b());
    }

    private void p() {
        if (this.V == 0) {
            this.V = com.tencent.biz.qqcircle.f.v().t();
        }
        if (this.V >= this.E - this.K) {
            this.H = true;
            this.I = false;
        } else {
            if (!this.J) {
                w(QCircleSkinHelper.getInstance().getUrl(this.U), 54, 54, this.f91787e);
            }
            this.H = false;
            this.I = true;
        }
    }

    private void q() {
        if (this.L) {
            return;
        }
        if (this.f91790i == null) {
            PathInterpolator pathInterpolator = new PathInterpolator(0.21f, 0.0f, 0.58f, 1.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.3f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.3f);
            ofFloat.setInterpolator(pathInterpolator);
            ofFloat2.setInterpolator(pathInterpolator);
            ofFloat.setDuration(50L);
            ofFloat2.setDuration(50L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f91790i = animatorSet;
            animatorSet.play(ofFloat).with(ofFloat2);
        }
        this.f91790i.start();
        QLog.d("QFSFastPushRocketBtnItemView", 1, "Pos: " + this.P + " enlarge.");
    }

    private void s() {
        this.f91787e = new ImageView(getContext(), null, 0);
        this.f91787e.setLayoutParams(new FrameLayout.LayoutParams(cx.a(54.0f), cx.a(54.0f), 17));
        addView(this.f91787e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(com.tencent.biz.qqcircle.push.a aVar) {
        c cVar = this.R;
        if (cVar == null) {
            return;
        }
        cVar.a(aVar);
    }

    private void u(int i3) {
        if (i3 == 2) {
            x();
            m();
        } else {
            w(QCircleSkinHelper.getInstance().getUrl(this.T), 54, 54, this.f91787e);
            q();
            this.L = true;
            postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.push.QFSFastPushRocketBtnItemView.2
                @Override // java.lang.Runnable
                public void run() {
                    QFSFastPushRocketBtnItemView.this.x();
                    QFSFastPushRocketBtnItemView.this.m();
                    QFSFastPushRocketBtnItemView.this.L = false;
                }
            }, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, int i3, int i16, ImageView imageView) {
        Option loadingDrawableColor = Option.obtain().setUrl(str).setRequestWidth(ImmersiveUtils.dpToPx(i3)).setRequestHeight(ImmersiveUtils.dpToPx(i16)).setTargetView(imageView).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0);
        loadingDrawableColor.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(loadingDrawableColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (!this.L) {
            return;
        }
        if (this.f91791m == null) {
            PathInterpolator pathInterpolator = new PathInterpolator(0.42f, 0.0f, 0.77f, 0.99f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_X, 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_Y, 1.3f, 1.0f);
            ofFloat.setInterpolator(pathInterpolator);
            ofFloat2.setInterpolator(pathInterpolator);
            ofFloat.setDuration(50L);
            ofFloat2.setDuration(50L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f91791m = animatorSet;
            animatorSet.play(ofFloat).with(ofFloat2);
        }
        this.f91791m.start();
        QLog.d("QFSFastPushRocketBtnItemView", 1, "Pos: " + this.P + " shrink.");
    }

    public void n() {
        if (this.D == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.D = animatorSet;
            animatorSet.setDuration(160L);
        }
        AnimatorSet animatorSet2 = this.C;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            this.C.pause();
        }
        float translationX = getTranslationX();
        float translationY = getTranslationY();
        this.D.playTogether(ObjectAnimator.ofFloat(this.f91786d, "translationX", translationX, this.M), ObjectAnimator.ofFloat(this.f91786d, "translationY", translationY, this.N), ObjectAnimator.ofFloat(this.f91786d, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f91786d, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f91786d, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
        this.D.start();
        postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.push.QFSFastPushRocketBtnItemView.4
            @Override // java.lang.Runnable
            public void run() {
                QFSFastPushRocketBtnItemView.this.w(QCircleSkinHelper.getInstance().getUrl(QFSFastPushRocketBtnItemView.this.S), 54, 54, QFSFastPushRocketBtnItemView.this.f91787e);
            }
        }, 160L);
    }

    public void o(int i3) {
        if (FastClickUtils.isFastDoubleClick("QFSFastPushRocketBtnItemView", 500L)) {
            return;
        }
        com.tencent.biz.qqcircle.push.a aVar = new com.tencent.biz.qqcircle.push.a();
        aVar.g(this.P);
        if (!this.H) {
            aVar.e(false);
            aVar.h(this.E);
            aVar.d(0);
            aVar.f(this.I);
            t(aVar);
            return;
        }
        u(i3);
    }

    public void r(int i3, boolean z16, int i16, c cVar) {
        String valueOf;
        int i17;
        w(QCircleSkinHelper.getInstance().getUrl(this.S), 54, 54, this.f91787e);
        this.f91786d = this;
        this.E = i16;
        this.Q = z16;
        this.R = cVar;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2 || i3 == 3) {
                    this.G = false;
                    SpannableString spannableString = null;
                    this.f91789h = new TextView(getContext(), null, 0);
                    this.f91789h.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                    this.f91789h.setPadding(0, cx.a(2.0f), 0, cx.a(2.0f));
                    this.f91789h.setTextColor(getResources().getColor(R.color.cla));
                    if (this.E <= 0) {
                        valueOf = com.tencent.biz.qqcircle.utils.h.a(R.string.f183793k5);
                        i17 = 12;
                    } else {
                        if (l.b() && this.E == l.c()) {
                            valueOf = String.valueOf(this.E) + "\n" + com.tencent.biz.qqcircle.utils.h.a(R.string.f183833k9);
                            spannableString = new SpannableString(valueOf);
                            spannableString.setSpan(new AbsoluteSizeSpan(cx.a(18)), 0, valueOf.length() - 2, 33);
                            spannableString.setSpan(new AbsoluteSizeSpan(cx.a(10.0f)), valueOf.length() - 2, valueOf.length(), 33);
                        } else {
                            valueOf = String.valueOf(this.E);
                        }
                        i17 = 18;
                    }
                    this.f91789h.setIncludeFontPadding(false);
                    if (spannableString != null) {
                        this.f91789h.setText(spannableString);
                        this.f91789h.setGravity(17);
                    } else {
                        this.f91789h.setTextSize(1, i17);
                        this.f91789h.setText(valueOf);
                    }
                    RFWTypefaceUtil.setNumberTypeface(this.f91789h, false);
                    addView(this.f91789h);
                }
            } else {
                this.G = false;
                A(R.drawable.ntz);
            }
        } else {
            this.G = true;
            A(R.drawable.f162085nu0);
        }
        setVisibility(0);
        setOnClickListener(new a());
        p();
    }

    public void setBtnDisable() {
        this.H = false;
        if (l.b()) {
            return;
        }
        w(QCircleSkinHelper.getInstance().getUrl(this.U), 54, 54, this.f91787e);
    }

    public void setBtnType(int i3) {
        this.F = i3;
    }

    public void setChooseStatus(boolean z16) {
        String str;
        if (z16 == this.L) {
            return;
        }
        if (z16) {
            q();
        } else {
            x();
        }
        if (l.b() || this.H) {
            QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
            if (z16) {
                str = this.T;
            } else {
                str = this.S;
            }
            w(qCircleSkinHelper.getUrl(str), 54, 54, this.f91787e);
        }
        this.L = z16;
    }

    public void setEnableClickWhenLackRocket(boolean z16) {
        this.J = z16;
    }

    public void setHasPushedCnt(int i3) {
        this.K = i3;
    }

    public void setPosition(int i3) {
        this.P = i3;
    }

    public void setUserCurrentRocketCount(int i3) {
        this.V = i3;
    }

    public void v(int i3, int i16) {
        int i17;
        int i18;
        long j3;
        long j16;
        if (this.C == null) {
            this.M = getTranslationX();
            this.N = getTranslationY();
            int i19 = -1;
            if (i3 >= 0) {
                i17 = 1;
            } else {
                i17 = -1;
            }
            if (i16 >= 0) {
                i19 = 1;
            }
            int abs = Math.abs(i3);
            int abs2 = Math.abs(i16);
            int i26 = 12;
            if (abs == 0) {
                i18 = 0;
            } else {
                i18 = 12;
            }
            if (abs2 == 0) {
                i26 = 0;
            }
            PathInterpolator pathInterpolator = new PathInterpolator(0.21f, 0.0f, 0.58f, 1.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", 0.0f, cx.a(abs) * i17, i17 * cx.a(abs - i18));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "translationY", 0.0f, cx.a(abs2) * i19, i19 * cx.a(abs2 - i26));
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            if (!this.Q) {
                ofFloat.setInterpolator(pathInterpolator);
                ofFloat2.setInterpolator(pathInterpolator);
            }
            ofFloat3.setInterpolator(pathInterpolator);
            ofFloat4.setInterpolator(pathInterpolator);
            if (this.Q) {
                j3 = 240;
            } else {
                j3 = 360;
            }
            ofFloat.setDuration(j3);
            if (this.Q) {
                j16 = 240;
            } else {
                j16 = 360;
            }
            ofFloat2.setDuration(j16);
            ofFloat3.setDuration(200L);
            ofFloat4.setDuration(200L);
            ofFloat5.setDuration(120L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.C = animatorSet;
            animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        }
        this.C.start();
    }

    public void y() {
        if (!l.b()) {
            this.S = "qvideo_rocket_feed_quickpush_bt_normal_v2";
            this.T = "qvideo_rocket_feed_quickpush_bt_selected_v2";
        } else {
            this.S = "qvideo_rocket_feed_quickpush_bt_cancel_v4";
            this.T = "qvideo_rocket_feed_quickpush_bt_cancel_v4";
        }
    }

    public void z() {
        if (l.b()) {
            this.S = "qvideo_rocket_feed_quickpush_bt_normal_v4";
            this.T = "qvideo_rocket_feed_quickpush_bt_selected_v4";
            this.U = "qvideo_rocket_feed_quickpush_bt_number_disable_v2";
        } else {
            this.S = "qvideo_rocket_feed_quickpush_bt_normal_v2";
            this.T = "qvideo_rocket_feed_quickpush_bt_selected_v2";
            this.U = "qvideo_rocket_feed_quickpush_bt_number_disable_v2";
        }
    }

    public QFSFastPushRocketBtnItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSFastPushRocketBtnItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = true;
        this.I = false;
        this.J = false;
        this.K = 0;
        this.L = false;
        this.P = 0;
        this.Q = false;
        this.S = "qvideo_rocket_feed_quickpush_bt_normal";
        this.T = "qvideo_rocket_feed_quickpush_bt_selected";
        this.U = "qvideo_rocket_feed_quickpush_bt_number_disable";
        this.V = 0;
        s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QFSFastPushRocketBtnItemView.this.f91791m != null) {
                QFSFastPushRocketBtnItemView.this.f91791m.removeAllListeners();
            }
            com.tencent.biz.qqcircle.push.a aVar = new com.tencent.biz.qqcircle.push.a();
            aVar.e(QFSFastPushRocketBtnItemView.this.G);
            aVar.h(QFSFastPushRocketBtnItemView.this.E);
            aVar.d(QFSFastPushRocketBtnItemView.this.F);
            aVar.g(QFSFastPushRocketBtnItemView.this.P);
            QFSFastPushRocketBtnItemView.this.t(aVar);
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
}
