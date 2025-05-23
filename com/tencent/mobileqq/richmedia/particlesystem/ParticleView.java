package com.tencent.mobileqq.richmedia.particlesystem;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.richmedia.particlesystem.ParticleView;
import com.tencent.mobileqq.richmedia.particlesystem.c;
import com.tencent.mobileqq.richmedia.particlesystem.render.ParticleSoftRenderer;
import java.util.concurrent.atomic.AtomicBoolean;
import lm2.g;

/* loaded from: classes18.dex */
public class ParticleView extends FrameLayout {
    static AtomicBoolean D = new AtomicBoolean(false);
    final c.InterfaceC8518c C;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.richmedia.particlesystem.c f281671d;

    /* renamed from: e, reason: collision with root package name */
    private final ParticleSoftRenderer f281672e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f281673f;

    /* renamed from: h, reason: collision with root package name */
    private c f281674h;

    /* renamed from: i, reason: collision with root package name */
    private b f281675i;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f281676m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a implements c.InterfaceC8518c {

        /* renamed from: a, reason: collision with root package name */
        private long f281677a = 0;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            b bVar = ParticleView.this.f281675i;
            if (bVar != null) {
                bVar.b(ParticleView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            b bVar = ParticleView.this.f281675i;
            if (bVar != null) {
                bVar.a(ParticleView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            b bVar = ParticleView.this.f281675i;
            if (bVar != null) {
                bVar.c(ParticleView.this);
            }
        }

        @Override // com.tencent.mobileqq.richmedia.particlesystem.c.InterfaceC8518c
        public void onAnimationEnd() {
            lm2.c.b("ParticleView", "Particle.onAnimationEnd, emitter=" + ParticleView.this.f281671d.l());
            ParticleView.this.f281676m.post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.particlesystem.d
                @Override // java.lang.Runnable
                public final void run() {
                    ParticleView.a.this.d();
                }
            });
        }

        @Override // com.tencent.mobileqq.richmedia.particlesystem.c.InterfaceC8518c
        public void onStart() {
            lm2.c.b("ParticleView", "Particle.onStart, emitter=" + ParticleView.this.f281671d.l());
            ParticleView.this.f281676m.post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.particlesystem.f
                @Override // java.lang.Runnable
                public final void run() {
                    ParticleView.a.this.e();
                }
            });
        }

        @Override // com.tencent.mobileqq.richmedia.particlesystem.c.InterfaceC8518c
        public void onStop() {
            lm2.c.b("ParticleView", "Particle.onStop, emitter=" + ParticleView.this.f281671d.l());
            ParticleView.this.f281676m.post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.particlesystem.e
                @Override // java.lang.Runnable
                public final void run() {
                    ParticleView.a.this.f();
                }
            });
        }

        @Override // com.tencent.mobileqq.richmedia.particlesystem.c.InterfaceC8518c
        public void onUpdate() {
            if (System.currentTimeMillis() - this.f281677a > 1000) {
                this.f281677a = System.currentTimeMillis();
                lm2.c.a("ParticleView", "Particle.onUpdate, emitter=" + ParticleView.this.f281671d.l() + ", particles=" + ParticleView.this.f281671d.o());
            }
        }
    }

    /* loaded from: classes18.dex */
    public interface b {
        void a(ParticleView particleView);

        void b(ParticleView particleView);

        void c(ParticleView particleView);
    }

    /* loaded from: classes18.dex */
    public interface c {
        void a(ParticleView particleView, Object obj);
    }

    public ParticleView(@NonNull Context context) {
        super(context);
        this.f281673f = false;
        this.f281676m = new Handler(Looper.getMainLooper());
        a aVar = new a();
        this.C = aVar;
        if (D.get()) {
            ParticleSoftRenderer particleSoftRenderer = new ParticleSoftRenderer(context);
            this.f281672e = particleSoftRenderer;
            addView(particleSoftRenderer, new FrameLayout.LayoutParams(-1, -1));
            com.tencent.mobileqq.richmedia.particlesystem.c cVar = new com.tencent.mobileqq.richmedia.particlesystem.c(context, particleSoftRenderer);
            this.f281671d = cVar;
            cVar.x(aVar);
            return;
        }
        throw new RuntimeException("initParticleSystem should be called first");
    }

    public static void f(Context context, com.tencent.mobileqq.richmedia.particlesystem.b bVar) {
        g gVar;
        g gVar2;
        lm2.b bVar2;
        if (!D.compareAndSet(false, true)) {
            return;
        }
        com.tencent.rlottie.a.d(context);
        if (bVar != null && (bVar2 = bVar.f281705a) != null) {
            lm2.c.d(bVar2);
        }
        if (bVar != null && (gVar2 = bVar.f281706b) != null) {
            lm2.f.a(gVar2);
        } else {
            lm2.f.a(new lm2.a());
        }
        if (bVar != null && (gVar = bVar.f281707c) != null) {
            lm2.d.b(gVar);
        } else {
            lm2.d.b(new lm2.a());
        }
    }

    private boolean g(float f16, float f17) {
        if (this.f281674h != null && this.f281671d.q(f16, f17) != null) {
            return true;
        }
        return false;
    }

    public void d(mm2.a aVar) {
        int width = this.f281672e.getWidth();
        int height = this.f281672e.getHeight();
        if (width != 0 && height != 0) {
            lm2.c.b("ParticleView", "ParticleView.addAnimation, config:" + aVar + " width=" + width + " height=" + height);
            nm2.c cVar = new nm2.c();
            com.tencent.mobileqq.richmedia.particlesystem.c cVar2 = this.f281671d;
            cVar2.f(cVar.c(cVar2, aVar, width, height));
            return;
        }
        lm2.c.b("ParticleView", "ParticleView.addAnimation, ignore because view size is 0, config:" + aVar);
    }

    public void e() {
        lm2.c.b("ParticleView", "ParticleView.destroy");
        this.f281671d.z();
        this.f281671d.x(null);
        this.f281675i = null;
    }

    boolean h(float f16, float f17) {
        Object q16 = this.f281671d.q(f16, f17);
        if (q16 != null) {
            c cVar = this.f281674h;
            if (cVar != null) {
                cVar.a(this, q16);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f281673f) {
            return false;
        }
        if (motionEvent.getAction() == 0 && g(motionEvent.getX(), motionEvent.getY())) {
            return true;
        }
        if ((motionEvent.getAction() != 1 && motionEvent.getAction() != 3) || !h(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        return true;
    }

    public void setAnimationEventListener(b bVar) {
        this.f281675i = bVar;
    }

    public void setInterceptTouchEvent(boolean z16) {
        this.f281673f = z16;
    }

    public void setOnClickParticleListener(c cVar) {
        this.f281674h = cVar;
    }
}
