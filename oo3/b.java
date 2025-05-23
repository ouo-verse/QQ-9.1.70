package oo3;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes22.dex */
class b implements ValueAnimator.AnimatorUpdateListener {
    private long C;
    private long D;
    private long E;
    private c F;

    /* renamed from: d, reason: collision with root package name */
    private float f423260d;

    /* renamed from: e, reason: collision with root package name */
    private float f423261e;

    /* renamed from: f, reason: collision with root package name */
    private float f423262f;

    /* renamed from: h, reason: collision with root package name */
    private long f423263h;

    /* renamed from: i, reason: collision with root package name */
    private long f423264i;

    /* renamed from: m, reason: collision with root package name */
    private long f423265m;

    public b(@NonNull c cVar) {
        this.F = cVar;
    }

    public void a(long j3, long j16) {
        long j17 = this.f423263h;
        this.f423264i = j17;
        long j18 = this.C;
        this.D = j18;
        this.f423265m = j3 - j17;
        this.E = j16 - j18;
    }

    public void b(float f16, float f17) {
        this.f423261e = f16;
        this.f423262f = f17 - f16;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = this.f423261e + (this.f423262f * valueAnimator.getAnimatedFraction());
        this.f423260d = animatedFraction;
        this.F.a(animatedFraction);
        this.f423263h = this.f423264i + ((int) (((float) this.f423265m) * valueAnimator.getAnimatedFraction()));
        long animatedFraction2 = this.D + ((int) (((float) this.E) * valueAnimator.getAnimatedFraction()));
        this.C = animatedFraction2;
        this.F.b(this.f423263h, animatedFraction2);
    }
}
