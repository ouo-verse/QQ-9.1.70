package com.tencent.mobileqq.guild.media.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMediaNetStatusView extends ImageView {

    /* renamed from: h, reason: collision with root package name */
    static int f229725h = 300;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f229726d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f229727e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f229728f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends com.tencent.mobileqq.widget.f {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            GuildMediaNetStatusView.this.c();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            onAnimationEnd(animator);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            GuildMediaNetStatusView.this.c();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            onAnimationStart(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            GuildMediaNetStatusView.this.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public GuildMediaNetStatusView(Context context) {
        super(context);
        this.f229727e = false;
        this.f229728f = false;
        b();
    }

    private void b() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        this.f229726d = ofInt;
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f229726d.setDuration(f229725h);
        this.f229726d.addListener(new a());
        this.f229726d.addUpdateListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f229727e) {
            setImageResource(R.drawable.guild_audio_net_normal);
            this.f229727e = false;
            if (QLog.isColorLevel()) {
                QLog.d("QGMC.NetStatusView", 2, "cancel alpha bg drawable !");
            }
        }
    }

    private void d() {
        if (!this.f229727e) {
            setImageResource(R.drawable.guild_audio_net_normal);
            this.f229727e = true;
            if (QLog.isColorLevel()) {
                QLog.d("QGMC.NetStatusView", 2, "set alpha bg drawable !");
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (QLog.isColorLevel()) {
            QLog.d("QGMC.NetStatusView", 2, "onAttachedToWindow ");
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (QLog.isColorLevel()) {
            QLog.d("QGMC.NetStatusView", 2, NodeProps.ON_DETACHED_FROM_WINDOW);
        }
    }

    public void setImageDrawable(Drawable drawable, boolean z16) {
        if (z16) {
            this.f229726d.cancel();
            d();
            setImageDrawable(drawable);
            this.f229726d.start();
            return;
        }
        setImageDrawable(drawable);
    }

    public void setQuality(int i3) {
        if (i3 >= 5) {
            setImageResource(R.drawable.guild_audio_net_worst);
        } else if (i3 >= 3) {
            setImageResource(R.drawable.guild_audio_net_bad);
        } else {
            setImageResource(R.drawable.guild_audio_net_normal);
        }
    }

    public GuildMediaNetStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f229727e = false;
        this.f229728f = false;
        b();
    }

    public GuildMediaNetStatusView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f229727e = false;
        this.f229728f = false;
        b();
    }
}
