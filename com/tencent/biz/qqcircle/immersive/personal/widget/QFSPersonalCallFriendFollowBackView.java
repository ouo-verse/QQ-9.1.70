package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* loaded from: classes4.dex */
public class QFSPersonalCallFriendFollowBackView extends LinearLayout implements View.OnClickListener {
    private static final float D = cx.a(20.0f);
    private static final int E = cx.a(40.0f);
    private static final int F = cx.a(40.0f);
    private Runnable C;

    /* renamed from: d, reason: collision with root package name */
    private QFSPagAnimView f89218d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f89219e;

    /* renamed from: f, reason: collision with root package name */
    private View f89220f;

    /* renamed from: h, reason: collision with root package name */
    private View f89221h;

    /* renamed from: i, reason: collision with root package name */
    private AnimatorSet f89222i;

    /* renamed from: m, reason: collision with root package name */
    private w f89223m;

    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalCallFriendFollowBackView$3, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ QFSPersonalCallFriendFollowBackView this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.e();
        }
    }

    public QFSPersonalCallFriendFollowBackView(Context context) {
        this(context, null);
    }

    private void b() {
        QFSPagAnimView qFSPagAnimView = this.f89218d;
        if (qFSPagAnimView != null) {
            qFSPagAnimView.setVisibility(8);
        }
        this.f89221h.setVisibility(0);
        PathInterpolator pathInterpolator = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        TextView textView = this.f89219e;
        float f16 = D;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "translationY", 0.0f, (-1.0f) * f16);
        ofFloat.setInterpolator(pathInterpolator);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f89219e, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f89221h, "translationY", f16, 0.0f);
        ofFloat3.setInterpolator(pathInterpolator);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f89221h, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f89222i = animatorSet;
        animatorSet.setDuration(280L);
        this.f89222i.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        this.f89222i.addListener(new a());
        this.f89222i.start();
    }

    private void c(Context context) {
        setOrientation(0);
        this.f89218d = new QFSPagAnimView(context);
        this.f89218d.setLayoutParams(new LinearLayout.LayoutParams(E, F));
        addView(this.f89218d);
        this.f89219e = new TextView(context);
        this.f89219e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f89219e.setText(context.getResources().getText(R.string.f188513ww));
        this.f89219e.setTextColor(QFSQUIUtilsKt.d(context, R.color.qui_button_text_secondary_default));
        this.f89219e.setTextSize(1, 14.0f);
        this.f89219e.setTypeface(Typeface.defaultFromStyle(1));
        this.f89219e.setIncludeFontPadding(false);
        addView(this.f89219e);
        setOnClickListener(this);
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        setVisibility(8);
        this.f89219e.setTranslationY(0.0f);
        this.f89219e.setAlpha(1.0f);
        this.f89220f.setBackground(null);
        this.f89221h.setBackground(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qui_button_bg_secondary_default_bg_corner_4_border_1));
    }

    public void e() {
        QFSPagAnimView qFSPagAnimView = this.f89218d;
        if (qFSPagAnimView != null) {
            qFSPagAnimView.V();
        }
        b();
        Runnable runnable = this.C;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f89223m != null) {
            com.tencent.biz.qqcircle.manager.h.b().c("", this.f89223m.L(), 2);
            e();
            View view2 = this.f89221h;
            if (view2 instanceof QFSFollowView) {
                ((QFSFollowView) view2).setCallFriendFollowBackHint("");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setUserData(w wVar) {
        TextView textView;
        if (wVar == null) {
            return;
        }
        this.f89223m = wVar;
        String str = wVar.b().callFollow.text.get();
        if (!TextUtils.isEmpty(str) && (textView = this.f89219e) != null) {
            textView.setText(str);
        }
    }

    public QFSPersonalCallFriendFollowBackView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPersonalCallFriendFollowBackView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSPersonalCallFriendFollowBackView.this.d();
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
