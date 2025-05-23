package com.tencent.luggage.wxa.k;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.k.l;
import com.tencent.mm.plugin.mmsight.model.MMSightCameraFrameDataCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m extends l {

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.oq.a f131344d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends com.tencent.luggage.wxa.fb.b {

        /* renamed from: u, reason: collision with root package name */
        public final /* synthetic */ boolean f131345u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i3, int i16, boolean z16) {
            super(i3, i16);
            this.f131345u = z16;
        }

        @Override // com.tencent.luggage.wxa.fb.a
        public com.tencent.luggage.wxa.hb.a c() {
            if (this.f131345u) {
                return new com.tencent.luggage.wxa.hb.c(n(), m(), f(), e(), h(), i());
            }
            return new com.tencent.luggage.wxa.hb.b(n(), m(), f(), e(), h(), i());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l.a f131348a;

        public c(l.a aVar) {
            this.f131348a = aVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(SurfaceTexture surfaceTexture) {
            l.a aVar = this.f131348a;
            if (aVar != null) {
                aVar.a(surfaceTexture);
                return null;
            }
            return null;
        }
    }

    public m(Context context, ViewGroup viewGroup, Surface surface, int i3, int i16) {
        b(i3, i16);
        com.tencent.luggage.wxa.oq.a aVar = new com.tencent.luggage.wxa.oq.a(context, surface, i3, i16);
        this.f131344d = aVar;
        boolean a16 = com.tencent.luggage.wxa.pq.a.a(context);
        aVar.a(new a(1, 2, a16), a16);
        SurfaceHolder holder = aVar.getHolder();
        holder.setType(3);
        holder.addCallback(new b());
    }

    @Override // com.tencent.luggage.wxa.k.o
    public void a(int i3) {
    }

    @Override // com.tencent.luggage.wxa.k.o
    public Class c() {
        return SurfaceHolder.class;
    }

    @Override // com.tencent.luggage.wxa.k.o
    public Surface d() {
        return e().getSurface();
    }

    @Override // com.tencent.luggage.wxa.k.o
    public SurfaceHolder e() {
        return this.f131344d.getHolder();
    }

    @Override // com.tencent.luggage.wxa.k.o
    public View g() {
        return this.f131344d;
    }

    @Override // com.tencent.luggage.wxa.k.o
    public boolean i() {
        if (h() != 0 && b() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.k.l
    public EGLContext j() {
        com.tencent.luggage.wxa.oq.a aVar = this.f131344d;
        if (aVar != null) {
            return aVar.getEGLContext();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.k.l
    public MMSightCameraFrameDataCallback k() {
        com.tencent.luggage.wxa.oq.a aVar = this.f131344d;
        if (aVar != null) {
            return aVar.getFrameDataCallback();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.k.l
    public void l() {
        com.tencent.luggage.wxa.oq.a aVar = this.f131344d;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.luggage.wxa.k.l
    public void m() {
        com.tencent.luggage.wxa.oq.a aVar = this.f131344d;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.tencent.luggage.wxa.k.l
    public void a(l.a aVar) {
        com.tencent.luggage.wxa.oq.a aVar2 = this.f131344d;
        if (aVar2 != null) {
            aVar2.a(new c(aVar));
        }
    }

    @Override // com.tencent.luggage.wxa.k.l
    public void a(com.tencent.luggage.wxa.kb.a aVar) {
        com.tencent.luggage.wxa.oq.a aVar2 = this.f131344d;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements SurfaceHolder.Callback {
        public b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
            m.this.b(i16, i17);
            if (!ViewCompat.isInLayout(m.this.f131344d)) {
                m.this.a();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            m.this.b(0, 0);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }
    }
}
