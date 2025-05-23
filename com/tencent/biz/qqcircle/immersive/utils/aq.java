package com.tencent.biz.qqcircle.immersive.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private ObjectAnimator f90139a;

    /* renamed from: b, reason: collision with root package name */
    private ObjectAnimator f90140b;

    /* renamed from: c, reason: collision with root package name */
    private ObjectAnimator f90141c;

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f90142d;

    /* renamed from: e, reason: collision with root package name */
    private ObjectAnimator f90143e;

    /* renamed from: f, reason: collision with root package name */
    private ObjectAnimator f90144f;

    /* renamed from: g, reason: collision with root package name */
    private ObjectAnimator f90145g;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f90146h;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f90147i;

    /* renamed from: j, reason: collision with root package name */
    private ObjectAnimator f90148j;

    /* renamed from: k, reason: collision with root package name */
    private ObjectAnimator f90149k;

    /* renamed from: l, reason: collision with root package name */
    private ObjectAnimator f90150l;

    /* renamed from: m, reason: collision with root package name */
    private ObjectAnimator f90151m;

    /* renamed from: n, reason: collision with root package name */
    private ObjectAnimator f90152n;

    /* renamed from: o, reason: collision with root package name */
    private int f90153o;

    /* renamed from: p, reason: collision with root package name */
    private d f90154p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f90155d;

        a(TextView textView) {
            this.f90155d = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextView textView = this.f90155d;
            if (textView != null) {
                textView.setText(valueAnimator.getAnimatedValue().toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f90157d;

        b(TextView textView) {
            this.f90157d = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextView textView = this.f90157d;
            if (textView != null) {
                textView.setText(valueAnimator.getAnimatedValue().toString());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface d {
        void a(int i3);
    }

    private void c(int i3, QCircleAvatarView qCircleAvatarView, ImageView imageView) {
        ObjectAnimator objectAnimator = this.f90143e;
        if (objectAnimator == null) {
            return;
        }
        objectAnimator.addListener(new c(i3, qCircleAvatarView, imageView));
    }

    private void d(TextView textView) {
        ValueAnimator valueAnimator = this.f90146h;
        if (valueAnimator != null && this.f90147i != null) {
            valueAnimator.addUpdateListener(new a(textView));
            this.f90147i.addUpdateListener(new b(textView));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i3, QCircleAvatarView qCircleAvatarView, ImageView imageView) {
        long j3;
        long j16;
        long j17;
        long j18;
        long j19;
        long j26;
        long j27;
        long j28;
        long j29;
        ObjectAnimator duration = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.85f).setDuration(120L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.85f).setDuration(120L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_X, 0.85f, 1.0f);
        long j36 = 200;
        if (i3 == 3) {
            j3 = 200;
        } else {
            j3 = 80;
        }
        ObjectAnimator duration3 = ofFloat.setDuration(j3);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_Y, 0.85f, 1.0f);
        if (i3 == 3) {
            j16 = 200;
        } else {
            j16 = 80;
        }
        ObjectAnimator duration4 = ofFloat2.setDuration(j16);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.3f);
        if (i3 == 3) {
            j17 = 200;
        } else {
            j17 = 480;
        }
        this.f90143e = ofFloat3.setDuration(j17);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.3f);
        if (i3 == 3) {
            j18 = 200;
        } else {
            j18 = 480;
        }
        this.f90144f = ofFloat4.setDuration(j18);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        if (i3 != 3) {
            j36 = 480;
        }
        this.f90145g = ofFloat5.setDuration(j36);
        ObjectAnimator objectAnimator = this.f90143e;
        long j37 = 640;
        if (i3 == 3) {
            j19 = 640;
        } else {
            j19 = 0;
        }
        objectAnimator.setStartDelay(j19);
        ObjectAnimator objectAnimator2 = this.f90144f;
        if (i3 == 3) {
            j26 = 640;
        } else {
            j26 = 0;
        }
        objectAnimator2.setStartDelay(j26);
        ObjectAnimator objectAnimator3 = this.f90145g;
        if (i3 == 3) {
            j27 = 640;
        } else {
            j27 = 0;
        }
        objectAnimator3.setStartDelay(j27);
        if (i3 == 3) {
            j28 = 640;
        } else {
            j28 = 0;
        }
        duration.setStartDelay(j28);
        if (i3 != 3) {
            j37 = 0;
        }
        duration2.setStartDelay(j37);
        long j38 = 760;
        if (i3 == 3) {
            j29 = 760;
        } else {
            j29 = 120;
        }
        duration3.setStartDelay(j29);
        if (i3 != 3) {
            j38 = 120;
        }
        duration4.setStartDelay(j38);
        this.f90143e.start();
        this.f90144f.start();
        this.f90145g.start();
        duration.start();
        duration2.start();
        duration3.start();
        duration4.start();
    }

    private int j() {
        int i3 = this.f90153o;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return 0;
                }
                return 1600;
            }
            return 1100;
        }
        return 500;
    }

    private void s(int i3) {
        this.f90139a.setRepeatCount(i3);
        this.f90140b.setRepeatCount(i3);
        this.f90141c.setRepeatCount(i3);
        this.f90142d.setRepeatCount(i3);
        this.f90143e.setRepeatCount(2);
        this.f90144f.setRepeatCount(2);
        this.f90145g.setRepeatCount(2);
    }

    private void v() {
        this.f90141c.setStartDelay(120L);
        this.f90142d.setStartDelay(120L);
        this.f90139a.start();
        this.f90140b.start();
        this.f90141c.start();
        this.f90142d.start();
        this.f90143e.start();
        this.f90144f.start();
        this.f90145g.start();
    }

    private void w(int i3) {
        long j3;
        long j16;
        long j17;
        QLog.d("QFSPushRocketAnimationManager", 1, "tail animation start");
        ObjectAnimator objectAnimator = this.f90148j;
        long j18 = 0;
        long j19 = 120;
        if (i3 == 3) {
            j3 = 120;
        } else {
            j3 = 0;
        }
        objectAnimator.setStartDelay(j3);
        ObjectAnimator objectAnimator2 = this.f90149k;
        if (i3 == 3) {
            j18 = 120;
        }
        objectAnimator2.setStartDelay(j18);
        ObjectAnimator objectAnimator3 = this.f90150l;
        if (i3 == 3) {
            j16 = 240;
        } else {
            j16 = 120;
        }
        objectAnimator3.setStartDelay(j16);
        ObjectAnimator objectAnimator4 = this.f90151m;
        if (i3 == 3) {
            j19 = 240;
        }
        objectAnimator4.setStartDelay(j19);
        ObjectAnimator objectAnimator5 = this.f90152n;
        if (this.f90153o == 3) {
            j17 = 440;
        } else {
            j17 = 280;
        }
        objectAnimator5.setStartDelay(j17);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.f90147i).with(this.f90148j).with(this.f90149k).with(this.f90150l).with(this.f90151m).with(this.f90152n).after(this.f90146h);
        animatorSet.start();
        d dVar = this.f90154p;
        if (dVar != null) {
            dVar.a(j());
            this.f90154p = null;
        }
    }

    public void f(int i3, TextView textView, int i16) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    i(textView, i16);
                    return;
                }
                return;
            }
            h(textView, i16);
            return;
        }
        g(textView, i16);
    }

    public void g(TextView textView, int i3) {
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        int i16 = i3 - 1;
        this.f90146h = ValueAnimator.ofInt(1, i16).setDuration(120L);
        this.f90147i = ValueAnimator.ofInt(i16, i3).setDuration(120L);
        this.f90148j = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.7f).setDuration(120L);
        this.f90149k = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.7f).setDuration(120L);
        this.f90150l = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_X, 1.7f, 1.0f).setDuration(240L);
        this.f90151m = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_Y, 1.7f, 1.0f).setDuration(240L);
        this.f90152n = ObjectAnimator.ofFloat(textView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(80L);
        d(textView);
        w(1);
        this.f90146h.start();
    }

    public void h(TextView textView, int i3) {
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        int i16 = i3 - 1;
        this.f90146h = ValueAnimator.ofInt(1, i16).setDuration(600L);
        this.f90147i = ValueAnimator.ofInt(i16, i3).setDuration(120L);
        this.f90148j = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.7f).setDuration(120L);
        this.f90149k = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.7f).setDuration(120L);
        this.f90150l = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_X, 1.7f, 1.0f).setDuration(240L);
        this.f90151m = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_Y, 1.7f, 1.0f).setDuration(240L);
        this.f90152n = ObjectAnimator.ofFloat(textView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(80L);
        d(textView);
        w(2);
        this.f90146h.start();
    }

    public void i(TextView textView, int i3) {
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        int i16 = i3 - 1;
        this.f90146h = ValueAnimator.ofInt(1, i16).setDuration(1240L);
        this.f90147i = ValueAnimator.ofInt(i16, i3).setDuration(120L);
        this.f90148j = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.7f).setDuration(120L);
        this.f90149k = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.7f).setDuration(120L);
        this.f90150l = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_X, 1.7f, 1.0f).setDuration(320L);
        this.f90151m = ObjectAnimator.ofFloat(textView, BasicAnimation.KeyPath.SCALE_Y, 1.7f, 1.0f).setDuration(320L);
        this.f90152n = ObjectAnimator.ofFloat(textView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(80L);
        d(textView);
        w(3);
        this.f90146h.start();
    }

    public void k(int i3, QCircleAvatarView qCircleAvatarView, ImageView imageView, ImageView imageView2) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 == 6) {
                            n(i3, qCircleAvatarView, imageView, imageView2);
                            return;
                        }
                        return;
                    }
                    o(i3, qCircleAvatarView, imageView);
                    return;
                }
                r(i3, qCircleAvatarView, imageView);
                return;
            }
            q(i3, qCircleAvatarView, imageView);
            return;
        }
        p(qCircleAvatarView, imageView);
    }

    public void l() {
        ObjectAnimator objectAnimator = this.f90139a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f90140b;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.f90141c;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        ObjectAnimator objectAnimator4 = this.f90142d;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
        }
        ObjectAnimator objectAnimator5 = this.f90143e;
        if (objectAnimator5 != null) {
            objectAnimator5.cancel();
            this.f90143e.removeAllListeners();
        }
        ObjectAnimator objectAnimator6 = this.f90144f;
        if (objectAnimator6 != null) {
            objectAnimator6.cancel();
        }
        ObjectAnimator objectAnimator7 = this.f90145g;
        if (objectAnimator7 != null) {
            objectAnimator7.cancel();
        }
    }

    public void m() {
        ValueAnimator valueAnimator = this.f90146h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f90146h.removeAllListeners();
            this.f90146h.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.f90147i;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f90147i.removeAllUpdateListeners();
        }
        ObjectAnimator objectAnimator = this.f90148j;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f90149k;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.f90150l;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        ObjectAnimator objectAnimator4 = this.f90151m;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
        }
        ObjectAnimator objectAnimator5 = this.f90152n;
        if (objectAnimator5 != null) {
            objectAnimator5.cancel();
        }
    }

    public void n(int i3, QCircleAvatarView qCircleAvatarView, ImageView imageView, ImageView imageView2) {
        if (qCircleAvatarView == null || imageView == null || imageView2 == null) {
            return;
        }
        imageView.setVisibility(0);
        imageView2.setVisibility(0);
        ObjectAnimator duration = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.2f, 0.85f, 1.05f, 0.95f).setDuration(480L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.2f, 0.85f, 1.05f, 0.95f).setDuration(480L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_X, 0.95f, 1.0f).setDuration(80L);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_Y, 0.95f, 1.0f).setDuration(80L);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.2f).setDuration(320L);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.2f).setDuration(320L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(320L);
        ObjectAnimator duration8 = ObjectAnimator.ofFloat(imageView2, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.2f).setDuration(320L);
        ObjectAnimator duration9 = ObjectAnimator.ofFloat(imageView2, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.2f).setDuration(320L);
        ObjectAnimator duration10 = ObjectAnimator.ofFloat(imageView2, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(320L);
        duration3.setStartDelay(480L);
        duration4.setStartDelay(480L);
        duration5.setStartDelay(120L);
        duration6.setStartDelay(120L);
        duration7.setStartDelay(120L);
        duration8.setStartDelay(320L);
        duration9.setStartDelay(320L);
        duration10.setStartDelay(320L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(920L);
        animatorSet.playTogether(duration, duration2, duration3, duration4, duration5, duration6, duration7, duration8, duration9, duration10);
        animatorSet.start();
    }

    public void o(int i3, QCircleAvatarView qCircleAvatarView, ImageView imageView) {
        if (qCircleAvatarView != null && imageView != null) {
            imageView.setVisibility(0);
            ObjectAnimator duration = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.85f).setDuration(120L);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.85f).setDuration(120L);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_X, 0.85f, 1.0f).setDuration(120L);
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_Y, 0.85f, 1.0f).setDuration(120L);
            ObjectAnimator duration5 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.2f).setDuration(240L);
            ObjectAnimator duration6 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.2f).setDuration(240L);
            ObjectAnimator duration7 = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(240L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(duration, duration2, duration3, duration4, duration5, duration6, duration7);
            animatorSet.setStartDelay(680L);
            animatorSet.start();
        }
    }

    public void p(QCircleAvatarView qCircleAvatarView, ImageView imageView) {
        if (qCircleAvatarView != null && imageView != null) {
            imageView.setVisibility(0);
            this.f90139a = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.85f).setDuration(120L);
            this.f90140b = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.85f).setDuration(120L);
            this.f90141c = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_X, 0.85f, 1.0f).setDuration(160L);
            this.f90142d = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_Y, 0.85f, 1.0f).setDuration(160L);
            this.f90143e = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.3f).setDuration(200L);
            this.f90144f = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.3f).setDuration(200L);
            this.f90145g = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(200L);
            v();
        }
    }

    public void q(int i3, QCircleAvatarView qCircleAvatarView, ImageView imageView) {
        if (qCircleAvatarView != null && imageView != null) {
            imageView.setVisibility(0);
            this.f90139a = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.85f).setDuration(120L);
            this.f90140b = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.85f).setDuration(120L);
            this.f90141c = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_X, 0.85f, 1.0f).setDuration(80L);
            this.f90142d = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_Y, 0.85f, 1.0f).setDuration(80L);
            this.f90143e = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.3f, 1.3f).setDuration(200L);
            this.f90144f = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.3f, 1.3f).setDuration(200L);
            this.f90145g = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f, 0.0f).setDuration(200L);
            c(i3, qCircleAvatarView, imageView);
            s(i3);
            v();
        }
    }

    public void r(int i3, QCircleAvatarView qCircleAvatarView, ImageView imageView) {
        if (qCircleAvatarView != null && imageView != null) {
            imageView.setVisibility(0);
            this.f90139a = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.85f).setDuration(120L);
            this.f90140b = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.85f).setDuration(120L);
            this.f90141c = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_X, 0.85f, 1.0f).setDuration(160L);
            this.f90142d = ObjectAnimator.ofFloat(qCircleAvatarView, BasicAnimation.KeyPath.SCALE_Y, 0.85f, 1.0f).setDuration(160L);
            this.f90143e = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.3f, 1.3f).setDuration(280L);
            this.f90144f = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.3f, 1.3f).setDuration(280L);
            this.f90145g = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f, 0.0f).setDuration(280L);
            c(i3, qCircleAvatarView, imageView);
            s(i3);
            v();
        }
    }

    public void t(d dVar) {
        this.f90154p = dVar;
    }

    public void u(int i3) {
        this.f90153o = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f90159d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QCircleAvatarView f90160e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f90161f;

        c(int i3, QCircleAvatarView qCircleAvatarView, ImageView imageView) {
            this.f90159d = i3;
            this.f90160e = qCircleAvatarView;
            this.f90161f = imageView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            aq.this.e(this.f90159d, this.f90160e, this.f90161f);
            QLog.d("QFSPushRocketAnimationManager", 1, "push anim is end");
            if (aq.this.f90143e != null) {
                aq.this.f90143e.removeAllListeners();
            }
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
