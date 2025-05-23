package org.libpag;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes29.dex */
class DisplayLink implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    private ValueAnimator f423670a;
    private long nativeContext = 0;

    /* renamed from: b, reason: collision with root package name */
    private Handler f423671b = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes29.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DisplayLink.this.f423670a.start();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DisplayLink.this.f423670a.cancel();
        }
    }

    DisplayLink() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f423670a = ofFloat;
        ofFloat.setDuration(1000L);
        this.f423670a.addUpdateListener(this);
        this.f423670a.setRepeatCount(-1);
    }

    public static DisplayLink Create(long j3) {
        DisplayLink displayLink = new DisplayLink();
        displayLink.nativeContext = j3;
        return displayLink;
    }

    private native void onUpdate(long j3);

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        onUpdate(this.nativeContext);
    }

    public void start() {
        this.f423671b.post(new a());
    }

    public void stop() {
        this.f423671b.post(new b());
    }
}
