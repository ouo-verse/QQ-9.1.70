package com.qzone.feed.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGalleryEntranceLoopAnimManager {

    /* renamed from: a, reason: collision with root package name */
    private RFWSquareImageView f47440a;

    /* renamed from: b, reason: collision with root package name */
    private RFWSquareImageView f47441b;

    /* renamed from: c, reason: collision with root package name */
    private RFWSquareImageView f47442c;

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f47443d;

    /* renamed from: e, reason: collision with root package name */
    private ObjectAnimator f47444e;

    /* renamed from: f, reason: collision with root package name */
    private ObjectAnimator f47445f;

    /* renamed from: g, reason: collision with root package name */
    private ObjectAnimator f47446g;

    /* renamed from: h, reason: collision with root package name */
    private ObjectAnimator f47447h;

    /* renamed from: i, reason: collision with root package name */
    private ObjectAnimator f47448i;

    /* renamed from: j, reason: collision with root package name */
    private ObjectAnimator f47449j;

    /* renamed from: k, reason: collision with root package name */
    private ObjectAnimator f47450k;

    /* renamed from: l, reason: collision with root package name */
    private ObjectAnimator f47451l;

    /* renamed from: m, reason: collision with root package name */
    private b f47452m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a();
    }

    public QZoneGalleryEntranceLoopAnimManager(ArrayList<RFWSquareImageView> arrayList) {
        f(arrayList);
    }

    private void h() {
        this.f47443d = ObjectAnimator.ofFloat(this.f47440a, "translationX", -ImmersiveUtils.dpToPx(8.0f)).setDuration(500L);
        this.f47444e = ObjectAnimator.ofFloat(this.f47441b, "translationX", ImmersiveUtils.dpToPx(16.0f)).setDuration(500L);
        this.f47445f = ObjectAnimator.ofFloat(this.f47442c, "translationX", -ImmersiveUtils.dpToPx(8.0f)).setDuration(500L);
        this.f47446g = ObjectAnimator.ofFloat(this.f47440a, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.82f).setDuration(500L);
        this.f47449j = ObjectAnimator.ofFloat(this.f47440a, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.82f).setDuration(500L);
        this.f47448i = ObjectAnimator.ofFloat(this.f47442c, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.21f).setDuration(500L);
        this.f47451l = ObjectAnimator.ofFloat(this.f47442c, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.21f).setDuration(500L);
        d(this.f47443d, false);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.f47443d).with(this.f47444e).with(this.f47445f).with(this.f47446g).with(this.f47449j).with(this.f47448i).with(this.f47451l);
        animatorSet.start();
        this.f47442c.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f47443d = ObjectAnimator.ofFloat(this.f47440a, "translationX", ImmersiveUtils.dpToPx(8.0f)).setDuration(500L);
        this.f47444e = ObjectAnimator.ofFloat(this.f47441b, "translationX", ImmersiveUtils.dpToPx(8.0f)).setDuration(500L);
        this.f47445f = ObjectAnimator.ofFloat(this.f47442c, "translationX", -ImmersiveUtils.dpToPx(16.0f)).setDuration(500L);
        this.f47447h = ObjectAnimator.ofFloat(this.f47441b, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.21f).setDuration(500L);
        this.f47450k = ObjectAnimator.ofFloat(this.f47441b, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.21f).setDuration(500L);
        this.f47448i = ObjectAnimator.ofFloat(this.f47442c, BasicAnimation.KeyPath.SCALE_X, 1.21f, 1.0f).setDuration(500L);
        this.f47451l = ObjectAnimator.ofFloat(this.f47442c, BasicAnimation.KeyPath.SCALE_Y, 1.21f, 1.0f).setDuration(500L);
        d(this.f47443d, true);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.f47443d).with(this.f47444e).with(this.f47445f).with(this.f47447h).with(this.f47450k).with(this.f47448i).with(this.f47451l);
        animatorSet.start();
        this.f47441b.bringToFront();
    }

    public void j() {
        e(this.f47443d);
        e(this.f47444e);
        e(this.f47445f);
        e(this.f47446g);
        e(this.f47447h);
        e(this.f47448i);
        e(this.f47449j);
        e(this.f47450k);
        e(this.f47451l);
    }

    public void k(b bVar) {
        this.f47452m = bVar;
    }

    public void l() {
        h();
    }

    private void e(ObjectAnimator objectAnimator) {
        if (objectAnimator != null) {
            objectAnimator.cancel();
            objectAnimator.removeAllListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z16) {
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.qzone.feed.utils.QZoneGalleryEntranceLoopAnimManager.2
                @Override // java.lang.Runnable
                public void run() {
                    if (QZoneGalleryEntranceLoopAnimManager.this.f47452m == null) {
                        return;
                    }
                    QZoneGalleryEntranceLoopAnimManager.this.f47452m.a();
                }
            }, 2000L);
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.qzone.feed.utils.QZoneGalleryEntranceLoopAnimManager.3
                @Override // java.lang.Runnable
                public void run() {
                    QZoneGalleryEntranceLoopAnimManager.this.i();
                }
            }, 1000L);
        }
    }

    private void d(ObjectAnimator objectAnimator, boolean z16) {
        if (objectAnimator == null) {
            return;
        }
        objectAnimator.removeAllListeners();
        objectAnimator.addListener(new a(z16));
    }

    private void f(ArrayList<RFWSquareImageView> arrayList) {
        if (arrayList != null && arrayList.size() == 3) {
            this.f47440a = arrayList.get(0);
            this.f47441b = arrayList.get(1);
            this.f47442c = arrayList.get(2);
            return;
        }
        QLog.d("QZoneGalleryEntranceLoopAnimManager", 1, "image list is less than 3 ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f47453d;

        a(boolean z16) {
            this.f47453d = z16;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QZoneGalleryEntranceLoopAnimManager.this.g(this.f47453d);
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
