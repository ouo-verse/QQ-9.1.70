package com.tencent.luggage.wxa.j6;

import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import com.tencent.luggage.wxa.i8.e;
import com.tencent.luggage.wxa.q8.a;
import com.tencent.luggage.wxa.tn.w;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements com.tencent.luggage.wxa.i8.a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f130871g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public e f130872a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f130873b;

    /* renamed from: c, reason: collision with root package name */
    public Surface f130874c;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference f130875d;

    /* renamed from: e, reason: collision with root package name */
    public Size f130876e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Surface f130877f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Surface f130879b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Surface surface) {
            super(1);
            this.f130879b = surface;
        }

        public final void a(SurfaceTexture surfaceTexture) {
            w.d("MicroMsg.VideoCanvasExtTextureProducerMBImpl", "replaceCallback, newTexture: " + surfaceTexture);
            if (surfaceTexture != null) {
                Surface surface = d.this.f130877f;
                if (surface != null) {
                    surface.release();
                }
                d.this.f130877f = new Surface(surfaceTexture);
                d.this.b().b(d.this.f130877f);
                return;
            }
            d.this.b().b(this.f130879b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SurfaceTexture) obj);
            return Unit.INSTANCE;
        }
    }

    public final e b() {
        e eVar = this.f130872a;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoPluginHandler");
        return null;
    }

    public final void c() {
        com.tencent.luggage.wxa.m4.b bVar;
        com.tencent.luggage.wxa.w1.c cVar;
        if (this.f130873b) {
            return;
        }
        Surface surface = this.f130874c;
        WeakReference weakReference = this.f130875d;
        com.tencent.magicbrush.b bVar2 = null;
        if (weakReference != null) {
            bVar = (com.tencent.luggage.wxa.m4.b) weakReference.get();
        } else {
            bVar = null;
        }
        Size size = this.f130876e;
        if (surface != null && bVar != null && size != null) {
            com.tencent.luggage.wxa.r4.d y06 = bVar.y0();
            if (y06 != null && (cVar = (com.tencent.luggage.wxa.w1.c) y06.h(com.tencent.luggage.wxa.w1.c.class)) != null) {
                bVar2 = cVar.n();
            }
            if (bVar2 == null) {
                w.b("MicroMsg.VideoCanvasExtTextureProducerMBImpl", "tryRegisterProducerIfNeed, magicBrush is null");
                return;
            }
            w.a("MicroMsg.VideoCanvasExtTextureProducerMBImpl", "tryRegisterProducerIfNeed, registerSurface");
            a.C6638a.a(bVar2.u().a("video"), b().getId(), size.getWidth(), size.getHeight(), surface, new b(surface), null, 32, null);
            this.f130873b = true;
        }
    }

    public final void a(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.f130872a = eVar;
    }

    @Override // com.tencent.luggage.wxa.i8.a
    public void a(Surface sameLayerSurface) {
        Intrinsics.checkNotNullParameter(sameLayerSurface, "sameLayerSurface");
        w.a("MicroMsg.VideoCanvasExtTextureProducerMBImpl", "onSameLayerSurfaceReady, sameLayerSurface: " + sameLayerSurface);
        this.f130874c = sameLayerSurface;
        c();
    }

    @Override // com.tencent.luggage.wxa.i8.a
    public void a(com.tencent.luggage.wxa.xd.d insertComponent) {
        Intrinsics.checkNotNullParameter(insertComponent, "insertComponent");
        w.a("MicroMsg.VideoCanvasExtTextureProducerMBImpl", "onInsertJsApiCalled, insertComponent: " + insertComponent);
        if (insertComponent instanceof com.tencent.luggage.wxa.m4.b) {
            this.f130875d = new WeakReference(insertComponent);
            c();
        }
    }

    @Override // com.tencent.luggage.wxa.i8.a
    public void a(Size videoSize) {
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
        w.a("MicroMsg.VideoCanvasExtTextureProducerMBImpl", "onVideoSizeResolved, videoSize: " + videoSize);
        this.f130876e = videoSize;
        c();
    }

    @Override // com.tencent.luggage.wxa.i8.a
    public void a() {
        com.tencent.luggage.wxa.w1.c cVar;
        if (this.f130873b) {
            WeakReference weakReference = this.f130875d;
            com.tencent.magicbrush.b bVar = null;
            com.tencent.luggage.wxa.m4.b bVar2 = weakReference != null ? (com.tencent.luggage.wxa.m4.b) weakReference.get() : null;
            if (bVar2 == null) {
                w.b("MicroMsg.VideoCanvasExtTextureProducerMBImpl", "onSameLayerSurfacePreRelease, insertComponent is null");
                return;
            }
            com.tencent.luggage.wxa.r4.d y06 = bVar2.y0();
            if (y06 != null && (cVar = (com.tencent.luggage.wxa.w1.c) y06.h(com.tencent.luggage.wxa.w1.c.class)) != null) {
                bVar = cVar.n();
            }
            if (bVar == null) {
                w.b("MicroMsg.VideoCanvasExtTextureProducerMBImpl", "onSameLayerSurfacePreRelease, magicBrush is null");
                return;
            }
            w.a("MicroMsg.VideoCanvasExtTextureProducerMBImpl", "onSameLayerSurfacePreRelease, unregisterSurface");
            bVar.u().a("video").b(b().getId());
            Surface surface = this.f130877f;
            if (surface != null) {
                surface.release();
            }
            this.f130873b = false;
        }
    }
}
