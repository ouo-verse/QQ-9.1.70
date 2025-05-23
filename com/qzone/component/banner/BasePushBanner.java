package com.qzone.component.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* loaded from: classes39.dex */
public abstract class BasePushBanner extends Banner {
    protected ImageView C;
    protected View D;
    protected Animation E;
    protected Animation F;

    /* renamed from: h, reason: collision with root package name */
    protected LinearLayout f46313h;

    /* renamed from: i, reason: collision with root package name */
    protected LinearLayout f46314i;

    /* renamed from: m, reason: collision with root package name */
    protected TextView f46315m;

    public BasePushBanner(Context context) {
        super(context);
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        Animation animation = this.F;
        if (animation == null || this.E == null) {
            return;
        }
        startAnimation(animation);
    }

    protected void v() {
        setDefaultLayoutParams();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bj8, (ViewGroup) this, true);
        this.D = inflate.findViewById(R.id.a5n);
        this.f46314i = (LinearLayout) inflate.findViewById(R.id.h8s);
        this.f46315m = (TextView) inflate.findViewById(R.id.h8r);
        this.f46313h = (LinearLayout) inflate.findViewById(R.id.h8q);
        this.C = (ImageView) inflate.findViewById(R.id.h8p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(final long j3) {
        a aVar = new a();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154790co);
        this.E = loadAnimation;
        loadAnimation.setAnimationListener(aVar);
        Animation.AnimationListener animationListener = new Animation.AnimationListener() { // from class: com.qzone.component.banner.BasePushBanner.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                BasePushBanner.this.getHandler().postDelayed(new Runnable() { // from class: com.qzone.component.banner.BasePushBanner.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BasePushBanner.this.l()) {
                            BasePushBanner basePushBanner = BasePushBanner.this;
                            basePushBanner.startAnimation(basePushBanner.E);
                        }
                    }
                }, j3);
                BasePushBanner.this.y();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.f154787cm);
        this.F = loadAnimation2;
        loadAnimation2.setAnimationListener(animationListener);
    }

    public BasePushBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        v();
    }

    /* loaded from: classes39.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BasePushBanner.this.x();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    protected void x() {
    }

    protected void y() {
    }
}
