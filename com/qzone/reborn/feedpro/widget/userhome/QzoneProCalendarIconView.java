package com.qzone.reborn.feedpro.widget.userhome;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import cooperation.qzone.util.QZLog;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes37.dex */
public class QzoneProCalendarIconView extends FrameLayout implements com.qzone.reborn.feedx.part.userhome.a {
    private AnimationDrawable C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f54722d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f54723e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f54724f;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Integer, Integer> f54725h;

    /* renamed from: i, reason: collision with root package name */
    private long f54726i;

    /* renamed from: m, reason: collision with root package name */
    private AnimationDrawable f54727m;

    public QzoneProCalendarIconView(Context context) {
        super(context);
        this.f54725h = new HashMap();
        this.f54726i = -1L;
        k();
    }

    private void e() {
        this.f54722d = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f54722d.setLayoutParams(layoutParams);
        this.f54722d.setImageDrawable(h());
        addView(this.f54722d);
    }

    private void f() {
        this.f54723e = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f54723e.setLayoutParams(layoutParams);
        addView(this.f54723e);
    }

    private void g() {
        this.f54724f = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f54724f.setLayoutParams(layoutParams);
        this.f54724f.setVisibility(8);
        addView(this.f54724f);
    }

    private Drawable h() {
        return getContext().getDrawable(R.drawable.f14727n);
    }

    private Drawable i(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        try {
            return getResources().getDrawable(this.f54725h.get(Integer.valueOf(calendar.get(2) + 1)).intValue());
        } catch (Exception e16) {
            QZLog.e("QZoneCalendarIconView", "getDrawableByMonth catch an exception.", e16);
            return null;
        }
    }

    private void j() {
        this.f54725h.clear();
        this.f54725h.put(1, Integer.valueOf(R.drawable.f16398w));
        this.f54725h.put(2, Integer.valueOf(R.drawable.f164390));
        this.f54725h.put(3, Integer.valueOf(R.drawable.f164491));
        this.f54725h.put(4, Integer.valueOf(R.drawable.f164592));
        this.f54725h.put(5, Integer.valueOf(R.drawable.f164693));
        this.f54725h.put(6, Integer.valueOf(R.drawable.f164794));
        this.f54725h.put(7, Integer.valueOf(R.drawable.f164895));
        this.f54725h.put(8, Integer.valueOf(R.drawable.f164996));
        this.f54725h.put(9, Integer.valueOf(R.drawable.f165097));
        this.f54725h.put(10, Integer.valueOf(R.drawable.f16408x));
        this.f54725h.put(11, Integer.valueOf(R.drawable.f16418y));
        this.f54725h.put(12, Integer.valueOf(R.drawable.f16428z));
    }

    private void k() {
        e();
        f();
        g();
        this.f54727m = (AnimationDrawable) getResources().getDrawable(R.drawable.f14712w, null);
        this.C = (AnimationDrawable) getResources().getDrawable(R.drawable.f14842x, null);
        j();
    }

    private void l(long j3) {
        if (this.f54726i > 0 && new Date(this.f54726i).getYear() == new Date(j3).getYear() && new Date(this.f54726i).getMonth() == new Date(j3).getMonth()) {
            return;
        }
        long j16 = this.f54726i;
        if (j16 == -1) {
            this.f54726i = j3;
            com.tencent.mobileqq.qzone.picload.c.a().g(this.f54723e, i(j3), this.D);
            this.f54723e.setAlpha(1.0f);
            this.f54724f.setVisibility(8);
            return;
        }
        com.tencent.mobileqq.qzone.picload.c.a().g(this.f54724f, i(j16), this.D);
        this.f54723e.setAlpha(1.0f);
        this.f54724f.setVisibility(8);
        Drawable i3 = i(j3);
        com.tencent.mobileqq.qzone.picload.c.a().g(this.f54724f, i3, this.D);
        this.f54727m.stop();
        this.C.stop();
        this.f54723e.clearAnimation();
        this.f54724f.clearAnimation();
        if (this.f54726i < j3) {
            this.f54722d.setImageDrawable(this.f54727m);
            this.f54727m.start();
        } else {
            this.f54722d.setImageDrawable(this.C);
            this.C.start();
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setAnimationListener(new a(i3));
        alphaAnimation.setDuration(400L);
        alphaAnimation2.setDuration(80L);
        this.f54723e.startAnimation(alphaAnimation);
        this.f54724f.setAlpha(0.0f);
        this.f54724f.setVisibility(0);
        this.f54724f.postDelayed(new Runnable() { // from class: com.qzone.reborn.feedpro.widget.userhome.QzoneProCalendarIconView.2
            @Override // java.lang.Runnable
            public void run() {
                QzoneProCalendarIconView.this.f54724f.startAnimation(alphaAnimation2);
            }
        }, 280L);
        this.f54726i = j3;
    }

    @Override // com.qzone.reborn.feedx.part.userhome.a
    public void a(int i3) {
        this.D = i3;
        com.tencent.mobileqq.qzone.picload.c.a().m(this.f54722d, i3);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.f54723e, i3);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.f54724f, i3);
        AnimationDrawable animationDrawable = this.f54727m;
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

    public QzoneProCalendarIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f54725h = new HashMap();
        this.f54726i = -1L;
        k();
    }

    public QzoneProCalendarIconView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f54725h = new HashMap();
        this.f54726i = -1L;
        k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Drawable f54729d;

        a(Drawable drawable) {
            this.f54729d = drawable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.tencent.mobileqq.qzone.picload.c.a().g(QzoneProCalendarIconView.this.f54723e, this.f54729d, QzoneProCalendarIconView.this.D);
            QzoneProCalendarIconView.this.f54723e.setAlpha(1.0f);
            QzoneProCalendarIconView.this.f54724f.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
