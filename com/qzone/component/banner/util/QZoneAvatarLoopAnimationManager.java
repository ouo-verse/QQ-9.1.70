package com.qzone.component.banner.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAvatarLoopAnimationManager {

    /* renamed from: a, reason: collision with root package name */
    private QZoneUserAvatarView f46605a;

    /* renamed from: b, reason: collision with root package name */
    private QZoneUserAvatarView f46606b;

    /* renamed from: c, reason: collision with root package name */
    private QZoneUserAvatarView f46607c;

    /* renamed from: d, reason: collision with root package name */
    private QZoneUserAvatarView f46608d;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<String> f46609e;

    /* renamed from: f, reason: collision with root package name */
    private int f46610f;

    /* renamed from: g, reason: collision with root package name */
    private ObjectAnimator f46611g;

    /* renamed from: h, reason: collision with root package name */
    private ObjectAnimator f46612h;

    /* renamed from: i, reason: collision with root package name */
    private ObjectAnimator f46613i;

    /* renamed from: j, reason: collision with root package name */
    private ObjectAnimator f46614j;

    /* renamed from: k, reason: collision with root package name */
    private ObjectAnimator f46615k;

    /* renamed from: l, reason: collision with root package name */
    private ObjectAnimator f46616l;

    /* renamed from: m, reason: collision with root package name */
    private ObjectAnimator f46617m;

    /* renamed from: n, reason: collision with root package name */
    private ObjectAnimator f46618n;

    /* renamed from: o, reason: collision with root package name */
    private ObjectAnimator f46619o;

    /* renamed from: p, reason: collision with root package name */
    private ObjectAnimator f46620p;

    /* renamed from: q, reason: collision with root package name */
    private ObjectAnimator f46621q;

    /* renamed from: r, reason: collision with root package name */
    private ObjectAnimator f46622r;

    /* renamed from: s, reason: collision with root package name */
    private Handler f46623s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f46624t;

    /* renamed from: u, reason: collision with root package name */
    private int f46625u;

    /* renamed from: v, reason: collision with root package name */
    private Runnable f46626v;

    /* renamed from: w, reason: collision with root package name */
    private Runnable f46627w;

    public QZoneAvatarLoopAnimationManager(ArrayList<QZoneUserAvatarView> arrayList, ArrayList<String> arrayList2) {
        m(arrayList);
        l();
        this.f46609e = arrayList2;
        this.f46610f = 3;
    }

    private void c(final int i3) {
        ObjectAnimator j3 = j(i3);
        if (j3 == null || this.f46623s == null) {
            return;
        }
        j3.removeAllListeners();
        if (this.f46627w != null) {
            RFWLog.i("QZoneAvatarLoopAnimationManager", RFWLog.USR, "remove mResumeAvatarRunnable," + this.f46627w.hashCode() + " type is " + i3);
            this.f46623s.removeCallbacks(this.f46627w);
        }
        this.f46627w = new Runnable() { // from class: com.qzone.component.banner.util.QZoneAvatarLoopAnimationManager.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneAvatarLoopAnimationManager.this.t(i3);
            }
        };
        RFWLog.i("QZoneAvatarLoopAnimationManager", RFWLog.USR, "add mResumeAvatarRunnable," + this.f46627w.hashCode() + " type is " + i3);
        this.f46623s.postDelayed(this.f46627w, 500L);
    }

    private void f() {
        e(this.f46615k);
        e(this.f46616l);
        e(this.f46617m);
        e(this.f46618n);
        e(this.f46619o);
        e(this.f46620p);
        e(this.f46621q);
        e(this.f46622r);
    }

    private void g() {
        e(this.f46611g);
        e(this.f46612h);
        e(this.f46613i);
        e(this.f46614j);
    }

    private void h(final int i3) {
        if (this.f46623s == null) {
            return;
        }
        if (this.f46626v != null) {
            RFWLog.i("QZoneAvatarLoopAnimationManager", RFWLog.USR, "remove mPlayAnimationRunnable, " + this.f46626v.hashCode() + " type is " + i3);
            this.f46623s.removeCallbacks(this.f46626v);
        }
        this.f46626v = new Runnable() { // from class: com.qzone.component.banner.util.QZoneAvatarLoopAnimationManager.3
            @Override // java.lang.Runnable
            public void run() {
                QZoneAvatarLoopAnimationManager.this.n(i3);
            }
        };
        RFWLog.i("QZoneAvatarLoopAnimationManager", RFWLog.USR, "add mPlayAnimationRunnable, " + this.f46626v.hashCode() + " type is " + i3);
        this.f46623s.postDelayed(this.f46626v, 500L);
    }

    private void l() {
        this.f46618n = ObjectAnimator.ofFloat(this.f46608d, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f).setDuration(10L);
        this.f46622r = ObjectAnimator.ofFloat(this.f46608d, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f).setDuration(10L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.f46618n).with(this.f46622r);
        animatorSet.start();
    }

    private void o() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f46605a, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f).setDuration(500L);
        this.f46615k = duration;
        d(duration, this.f46608d);
        this.f46619o = ObjectAnimator.ofFloat(this.f46605a, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f).setDuration(500L);
        this.f46612h = ObjectAnimator.ofFloat(this.f46606b, "translationX", -ImmersiveUtils.dpToPx(this.f46625u)).setDuration(500L);
        this.f46613i = ObjectAnimator.ofFloat(this.f46607c, "translationX", -ImmersiveUtils.dpToPx(this.f46625u)).setDuration(500L);
        this.f46618n = ObjectAnimator.ofFloat(this.f46608d, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f).setDuration(500L);
        this.f46622r = ObjectAnimator.ofFloat(this.f46608d, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f).setDuration(500L);
        this.f46611g = ObjectAnimator.ofFloat(this.f46605a, "translationX", ImmersiveUtils.dpToPx(this.f46625u * 2)).setDuration(10L);
        c(1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.f46615k).with(this.f46619o).with(this.f46612h).with(this.f46613i).with(this.f46618n).with(this.f46622r).before(this.f46611g);
        animatorSet.start();
    }

    private void p() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f46605a, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f).setDuration(500L);
        this.f46615k = duration;
        d(duration, this.f46605a);
        this.f46619o = ObjectAnimator.ofFloat(this.f46605a, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f).setDuration(500L);
        this.f46616l = ObjectAnimator.ofFloat(this.f46606b, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f).setDuration(500L);
        this.f46620p = ObjectAnimator.ofFloat(this.f46606b, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f).setDuration(500L);
        this.f46613i = ObjectAnimator.ofFloat(this.f46607c, "translationX", -ImmersiveUtils.dpToPx(this.f46625u * 2)).setDuration(500L);
        this.f46614j = ObjectAnimator.ofFloat(this.f46608d, "translationX", -ImmersiveUtils.dpToPx(this.f46625u)).setDuration(500L);
        this.f46612h = ObjectAnimator.ofFloat(this.f46606b, "translationX", ImmersiveUtils.dpToPx(this.f46625u)).setDuration(10L);
        c(2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.f46615k).with(this.f46619o).with(this.f46616l).with(this.f46620p).with(this.f46613i).with(this.f46614j).before(this.f46612h);
        animatorSet.start();
    }

    private void q() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f46605a, "translationX", ImmersiveUtils.dpToPx(this.f46625u)).setDuration(500L);
        this.f46611g = duration;
        d(duration, this.f46606b);
        this.f46616l = ObjectAnimator.ofFloat(this.f46606b, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f).setDuration(500L);
        this.f46620p = ObjectAnimator.ofFloat(this.f46606b, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f).setDuration(500L);
        this.f46617m = ObjectAnimator.ofFloat(this.f46607c, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f).setDuration(500L);
        this.f46621q = ObjectAnimator.ofFloat(this.f46607c, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f).setDuration(500L);
        this.f46614j = ObjectAnimator.ofFloat(this.f46608d, "translationX", -ImmersiveUtils.dpToPx(this.f46625u * 2)).setDuration(500L);
        this.f46613i = ObjectAnimator.ofFloat(this.f46607c, "translationX", ImmersiveUtils.dpToPx(0.0f)).setDuration(10L);
        c(3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.f46611g).with(this.f46616l).with(this.f46620p).with(this.f46617m).with(this.f46621q).with(this.f46614j).before(this.f46613i);
        animatorSet.start();
    }

    private void r() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f46605a, "translationX", -ImmersiveUtils.dpToPx(0.0f)).setDuration(500L);
        this.f46611g = duration;
        d(duration, this.f46607c);
        this.f46612h = ObjectAnimator.ofFloat(this.f46606b, "translationX", -ImmersiveUtils.dpToPx(0.0f)).setDuration(500L);
        this.f46617m = ObjectAnimator.ofFloat(this.f46607c, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f).setDuration(500L);
        this.f46621q = ObjectAnimator.ofFloat(this.f46607c, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f).setDuration(500L);
        this.f46618n = ObjectAnimator.ofFloat(this.f46608d, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f).setDuration(500L);
        this.f46622r = ObjectAnimator.ofFloat(this.f46608d, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f).setDuration(500L);
        this.f46614j = ObjectAnimator.ofFloat(this.f46608d, "translationX", ImmersiveUtils.dpToPx(0.0f)).setDuration(10L);
        c(4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.f46611g).with(this.f46612h).with(this.f46617m).with(this.f46621q).with(this.f46618n).with(this.f46622r).before(this.f46614j);
        animatorSet.start();
    }

    private void s() {
        if (this.f46623s == null) {
            RFWLog.e("QZoneAvatarLoopAnimationManager", RFWLog.USR, "handler is null, return");
            return;
        }
        if (this.f46626v != null) {
            RFWLog.i("QZoneAvatarLoopAnimationManager", RFWLog.USR, "remove mPlayAnimationRunnable " + this.f46626v.hashCode());
            this.f46623s.removeCallbacks(this.f46626v);
        }
        if (this.f46627w != null) {
            RFWLog.i("QZoneAvatarLoopAnimationManager", RFWLog.USR, "remove mResumeAvatarRunnable " + this.f46627w.hashCode());
            this.f46623s.removeCallbacks(this.f46627w);
        }
        this.f46623s = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3) {
        x(k(i3));
        if (i3 == 4) {
            QZoneUserAvatarView qZoneUserAvatarView = this.f46608d;
            if (qZoneUserAvatarView != null) {
                qZoneUserAvatarView.setVisibility(8);
            }
            h(1);
            return;
        }
        h(i3 + 1);
    }

    public void i() {
        RFWLog.e("QZoneAvatarLoopAnimationManager", RFWLog.USR, "QZoneAvatarLoopAnimationManager on destroy");
        this.f46605a = null;
        this.f46606b = null;
        this.f46607c = null;
        this.f46608d = null;
        s();
        ArrayList<String> arrayList = this.f46609e;
        if (arrayList != null) {
            arrayList.clear();
        }
        g();
        f();
    }

    public void u(int i3) {
        this.f46625u = i3;
    }

    public void v(Handler handler) {
        this.f46623s = handler;
    }

    public void w() {
        ArrayList<String> arrayList = this.f46609e;
        if (arrayList != null && arrayList.size() >= 4) {
            if (this.f46624t) {
                return;
            }
            this.f46624t = true;
            h(1);
            return;
        }
        QLog.d("QZoneAvatarLoopAnimationManager", 1, "uin list size is less than 4");
    }

    private void e(ObjectAnimator objectAnimator) {
        if (objectAnimator != null) {
            objectAnimator.cancel();
            objectAnimator.removeAllListeners();
        }
    }

    private void m(ArrayList<QZoneUserAvatarView> arrayList) {
        if (arrayList == null || arrayList.size() != 4) {
            return;
        }
        this.f46605a = arrayList.get(0);
        this.f46606b = arrayList.get(1);
        this.f46607c = arrayList.get(2);
        this.f46608d = arrayList.get(3);
    }

    private void x(QZoneUserAvatarView qZoneUserAvatarView) {
        ArrayList<String> arrayList;
        if (qZoneUserAvatarView == null || (arrayList = this.f46609e) == null || arrayList.isEmpty()) {
            return;
        }
        if (this.f46610f >= this.f46609e.size() - 1) {
            this.f46610f = 0;
        } else {
            this.f46610f++;
        }
        try {
            qZoneUserAvatarView.setUser(Long.parseLong(this.f46609e.get(this.f46610f)));
        } catch (Exception e16) {
            RFWLog.e("QZoneAvatarLoopAnimationManager", RFWLog.CLR, "avatar exception is " + e16);
        }
    }

    private void d(ObjectAnimator objectAnimator, QZoneUserAvatarView qZoneUserAvatarView) {
        if (objectAnimator == null) {
            return;
        }
        objectAnimator.removeAllListeners();
        objectAnimator.addListener(new a(qZoneUserAvatarView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i3) {
        if (i3 == 1) {
            o();
            return;
        }
        if (i3 == 2) {
            p();
        } else if (i3 == 3) {
            q();
        } else {
            if (i3 != 4) {
                return;
            }
            r();
        }
    }

    private ObjectAnimator j(int i3) {
        if (i3 == 1) {
            return this.f46611g;
        }
        if (i3 == 2) {
            return this.f46612h;
        }
        if (i3 == 3) {
            return this.f46613i;
        }
        if (i3 != 4) {
            return null;
        }
        return this.f46614j;
    }

    private QZoneUserAvatarView k(int i3) {
        if (i3 == 1) {
            return this.f46605a;
        }
        if (i3 == 2) {
            return this.f46606b;
        }
        if (i3 == 3) {
            return this.f46607c;
        }
        if (i3 != 4) {
            return null;
        }
        return this.f46608d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QZoneUserAvatarView f46630d;

        a(QZoneUserAvatarView qZoneUserAvatarView) {
            this.f46630d = qZoneUserAvatarView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QZoneUserAvatarView qZoneUserAvatarView = this.f46630d;
            if (qZoneUserAvatarView != null) {
                qZoneUserAvatarView.setVisibility(0);
                this.f46630d.bringToFront();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
