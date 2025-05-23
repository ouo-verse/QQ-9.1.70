package com.tencent.biz.subscribe.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import mqq.util.WeakReference;

/* loaded from: classes5.dex */
public class PopViewAnimationDrawableHelper {

    /* renamed from: c, reason: collision with root package name */
    private c f95685c;

    /* renamed from: e, reason: collision with root package name */
    private int f95687e;

    /* renamed from: f, reason: collision with root package name */
    private int f95688f;

    /* renamed from: g, reason: collision with root package name */
    private AnimationDrawable f95689g;

    /* renamed from: h, reason: collision with root package name */
    private int f95690h;

    /* renamed from: a, reason: collision with root package name */
    private Handler f95683a = new b();

    /* renamed from: d, reason: collision with root package name */
    private d f95686d = new a();

    /* renamed from: b, reason: collision with root package name */
    private Runnable f95684b = new LoopingRunnable(this);

    /* loaded from: classes5.dex */
    private static class LoopingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<PopViewAnimationDrawableHelper> f95691d;

        public LoopingRunnable(PopViewAnimationDrawableHelper popViewAnimationDrawableHelper) {
            this.f95691d = new WeakReference<>(popViewAnimationDrawableHelper);
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar;
            PopViewAnimationDrawableHelper popViewAnimationDrawableHelper = this.f95691d.get();
            if (popViewAnimationDrawableHelper != null && (dVar = popViewAnimationDrawableHelper.f95686d) != null) {
                if (popViewAnimationDrawableHelper.f95688f <= 0) {
                    AnimationDrawable animationDrawable = popViewAnimationDrawableHelper.f95689g;
                    if (animationDrawable != null && animationDrawable.getFrame(animationDrawable.getNumberOfFrames() - 1) != animationDrawable.getCurrent()) {
                        dVar.a();
                        return;
                    } else {
                        dVar.b();
                        return;
                    }
                }
                dVar.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    class a implements d {
        a() {
        }

        @Override // com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.d
        public void a() {
            PopViewAnimationDrawableHelper.this.i();
        }

        @Override // com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.d
        public void b() {
            if (PopViewAnimationDrawableHelper.this.f95685c != null) {
                PopViewAnimationDrawableHelper.this.f95685c.onEnd();
            }
            if (PopViewAnimationDrawableHelper.this.f95683a != null && PopViewAnimationDrawableHelper.this.f95684b != null) {
                PopViewAnimationDrawableHelper.this.f95683a.removeCallbacks(PopViewAnimationDrawableHelper.this.f95684b);
            }
        }
    }

    /* loaded from: classes5.dex */
    private static class b extends Handler {
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onEnd();

        void onStart();
    }

    /* loaded from: classes5.dex */
    private interface d {
        void a();

        void b();
    }

    public PopViewAnimationDrawableHelper(AnimationDrawable animationDrawable) {
        this.f95689g = animationDrawable;
        this.f95690h = animationDrawable.getNumberOfFrames();
    }

    private int h() {
        for (int i3 = 0; i3 < this.f95690h; i3++) {
            if (this.f95687e < this.f95689g.getDuration(i3)) {
                this.f95687e = this.f95689g.getDuration(i3);
            }
        }
        int i16 = this.f95687e;
        if (i16 > 1000) {
            return 1000;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Handler handler;
        int i3;
        Runnable runnable = this.f95684b;
        if (runnable != null && (handler = this.f95683a) != null) {
            int i16 = this.f95688f;
            if (i16 > 0) {
                handler.postDelayed(runnable, i16);
                return;
            }
            if (i16 == 0) {
                i3 = h();
            } else {
                i3 = this.f95687e;
            }
            handler.postDelayed(runnable, i3);
        }
    }

    public void j() {
        Handler handler = this.f95683a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f95683a = null;
        }
    }

    public void k(c cVar) {
        this.f95685c = cVar;
    }

    public void l() {
        AnimationDrawable animationDrawable = this.f95689g;
        if (animationDrawable == null) {
            return;
        }
        animationDrawable.start();
        i();
        c cVar = this.f95685c;
        if (cVar != null) {
            cVar.onStart();
        }
    }
}
