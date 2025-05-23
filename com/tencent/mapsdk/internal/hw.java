package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.in;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class hw implements Animation {

    /* renamed from: a, reason: collision with root package name */
    public in f148757a = null;

    /* renamed from: b, reason: collision with root package name */
    protected a f148758b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a implements in.a {

        /* renamed from: a, reason: collision with root package name */
        AnimationListener f148759a;

        public a(AnimationListener animationListener) {
            this.f148759a = animationListener;
        }

        @Override // com.tencent.mapsdk.internal.in.a
        public final void b() {
            if (this.f148759a != null) {
                kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.hw.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.f148759a.onAnimationEnd();
                    }
                });
            }
        }

        @Override // com.tencent.mapsdk.internal.in.a
        public final void a() {
            if (this.f148759a != null) {
                kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.hw.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.f148759a.onAnimationStart();
                    }
                });
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public AnimationListener getAnimationListener() {
        a aVar = this.f148758b;
        if (aVar != null) {
            return aVar.f148759a;
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public long getDuration() {
        in inVar = this.f148757a;
        if (inVar != null) {
            return inVar.a();
        }
        return 0L;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public Interpolator getInterpolator() {
        in inVar = this.f148757a;
        if (inVar != null) {
            return inVar.f148804f;
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public void setAnimationListener(AnimationListener animationListener) {
        a aVar = new a(animationListener);
        this.f148758b = aVar;
        in inVar = this.f148757a;
        if (inVar != null) {
            inVar.a(aVar);
        }
    }
}
