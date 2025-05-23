package com.qzone.reborn.feedx.widget.homepage;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import cooperation.qzone.util.QZLog;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneCalendarIconView extends FrameLayout implements com.qzone.reborn.feedx.part.userhome.a {
    private static final int E = ar.e(24.0f);
    private static final int F = ar.e(12.0f);
    private AnimationDrawable C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f56341d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f56342e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f56343f;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Integer, Integer> f56344h;

    /* renamed from: i, reason: collision with root package name */
    private long f56345i;

    /* renamed from: m, reason: collision with root package name */
    private AnimationDrawable f56346m;

    public QZoneCalendarIconView(Context context) {
        super(context);
        this.f56344h = new HashMap();
        this.f56345i = -1L;
        k();
    }

    private void e() {
        this.f56341d = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f56341d.setLayoutParams(layoutParams);
        this.f56341d.setImageDrawable(h());
        addView(this.f56341d);
    }

    private void f() {
        this.f56342e = new ImageView(getContext());
        int i3 = F;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 17;
        this.f56342e.setLayoutParams(layoutParams);
        addView(this.f56342e);
    }

    private void g() {
        this.f56343f = new ImageView(getContext());
        int i3 = F;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 17;
        this.f56343f.setLayoutParams(layoutParams);
        this.f56343f.setVisibility(8);
        addView(this.f56343f);
    }

    private Drawable h() {
        return getContext().getDrawable(R.drawable.f16849b);
    }

    private Drawable i(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        try {
            return getResources().getDrawable(this.f56344h.get(Integer.valueOf(calendar.get(2) + 1)).intValue());
        } catch (Exception e16) {
            QZLog.e("QZoneCalendarIconView", "getDrawableByMonth catch an exception.", e16);
            return null;
        }
    }

    private void j() {
        this.f56344h.clear();
        this.f56344h.put(1, Integer.valueOf(R.drawable.f16859c));
        this.f56344h.put(2, Integer.valueOf(R.drawable.f16899g));
        this.f56344h.put(3, Integer.valueOf(R.drawable.f16909h));
        this.f56344h.put(4, Integer.valueOf(R.drawable.f16919i));
        this.f56344h.put(5, Integer.valueOf(R.drawable.f16929j));
        this.f56344h.put(6, Integer.valueOf(R.drawable.f16939k));
        this.f56344h.put(7, Integer.valueOf(R.drawable.f16949l));
        this.f56344h.put(8, Integer.valueOf(R.drawable.f16959m));
        this.f56344h.put(9, Integer.valueOf(R.drawable.f16969n));
        this.f56344h.put(10, Integer.valueOf(R.drawable.f16869d));
        this.f56344h.put(11, Integer.valueOf(R.drawable.f16879e));
        this.f56344h.put(12, Integer.valueOf(R.drawable.f16889f));
    }

    private void k() {
        e();
        f();
        g();
        this.f56346m = (AnimationDrawable) getResources().getDrawable(R.drawable.f153949, null);
        this.C = (AnimationDrawable) getResources().getDrawable(R.drawable.f15514_, null);
        j();
        int e16 = ar.e(2.0f);
        setPadding(e16, e16, e16, e16);
    }

    private void l(long j3) {
        if (this.f56345i > 0 && new Date(this.f56345i).getYear() == new Date(j3).getYear() && new Date(this.f56345i).getMonth() == new Date(j3).getMonth()) {
            return;
        }
        long j16 = this.f56345i;
        if (j16 == -1) {
            this.f56345i = j3;
            com.tencent.mobileqq.qzone.picload.c.a().g(this.f56342e, i(j3), this.D);
            this.f56342e.setAlpha(1.0f);
            this.f56343f.setVisibility(8);
            return;
        }
        com.tencent.mobileqq.qzone.picload.c.a().g(this.f56343f, i(j16), this.D);
        this.f56342e.setAlpha(1.0f);
        this.f56343f.setVisibility(8);
        Drawable i3 = i(j3);
        com.tencent.mobileqq.qzone.picload.c.a().g(this.f56343f, i3, this.D);
        this.f56346m.stop();
        this.C.stop();
        this.f56342e.clearAnimation();
        this.f56343f.clearAnimation();
        if (this.f56345i < j3) {
            this.f56341d.setImageDrawable(this.f56346m);
            this.f56346m.start();
        } else {
            this.f56341d.setImageDrawable(this.C);
            this.C.start();
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setAnimationListener(new a(i3));
        alphaAnimation.setDuration(400L);
        alphaAnimation2.setDuration(80L);
        this.f56342e.startAnimation(alphaAnimation);
        this.f56343f.setAlpha(0.0f);
        this.f56343f.setVisibility(0);
        this.f56343f.postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.widget.homepage.QZoneCalendarIconView.2
            @Override // java.lang.Runnable
            public void run() {
                QZoneCalendarIconView.this.f56343f.startAnimation(alphaAnimation2);
            }
        }, 280L);
        this.f56345i = j3;
    }

    @Override // com.qzone.reborn.feedx.part.userhome.a
    public void a(int i3) {
        this.D = i3;
        com.tencent.mobileqq.qzone.picload.c.a().m(this.f56341d, i3);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.f56342e, i3);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.f56343f, i3);
        AnimationDrawable animationDrawable = this.f56346m;
        if (animationDrawable != null) {
            animationDrawable.mutate().setColorFilter(i3, PorterDuff.Mode.SRC_IN);
        }
        AnimationDrawable animationDrawable2 = this.C;
        if (animationDrawable2 != null) {
            animationDrawable2.mutate().setColorFilter(i3, PorterDuff.Mode.SRC_IN);
        }
    }

    public void m(long j3) {
        l(j3);
    }

    public QZoneCalendarIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f56344h = new HashMap();
        this.f56345i = -1L;
        k();
    }

    public QZoneCalendarIconView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f56344h = new HashMap();
        this.f56345i = -1L;
        k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Drawable f56348d;

        a(Drawable drawable) {
            this.f56348d = drawable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.tencent.mobileqq.qzone.picload.c.a().g(QZoneCalendarIconView.this.f56342e, this.f56348d, QZoneCalendarIconView.this.D);
            QZoneCalendarIconView.this.f56342e.setAlpha(1.0f);
            QZoneCalendarIconView.this.f56343f.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
