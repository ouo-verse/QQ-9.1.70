package com.tencent.luggage.wxa.q8;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.luggage.wxa.p8.f;
import com.tencent.luggage.wxa.q8.b;
import com.tencent.magicbrush.MBRuntime;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements com.tencent.luggage.wxa.q8.a {

    /* renamed from: a, reason: collision with root package name */
    public final MBRuntime f138237a;

    /* renamed from: b, reason: collision with root package name */
    public final String f138238b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f138239c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f138240a;

        /* renamed from: b, reason: collision with root package name */
        public final int f138241b;

        /* renamed from: c, reason: collision with root package name */
        public final Surface f138242c;

        /* renamed from: d, reason: collision with root package name */
        public final Function1 f138243d;

        /* renamed from: e, reason: collision with root package name */
        public final Function1 f138244e;

        public a(int i3, int i16, Surface surface, Function1 callback, Function1 function1) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f138240a = i3;
            this.f138241b = i16;
            this.f138242c = surface;
            this.f138243d = callback;
            this.f138244e = function1;
        }

        public final Function1 a() {
            return this.f138243d;
        }

        public final Function1 b() {
            return this.f138244e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f138240a == aVar.f138240a && this.f138241b == aVar.f138241b && Intrinsics.areEqual(this.f138242c, aVar.f138242c) && Intrinsics.areEqual(this.f138243d, aVar.f138243d) && Intrinsics.areEqual(this.f138244e, aVar.f138244e)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i3 = ((this.f138240a * 31) + this.f138241b) * 31;
            Surface surface = this.f138242c;
            int i16 = 0;
            if (surface == null) {
                hashCode = 0;
            } else {
                hashCode = surface.hashCode();
            }
            int hashCode2 = (((i3 + hashCode) * 31) + this.f138243d.hashCode()) * 31;
            Function1 function1 = this.f138244e;
            if (function1 != null) {
                i16 = function1.hashCode();
            }
            return hashCode2 + i16;
        }

        public String toString() {
            return "SurfaceRegisterParams(width=" + this.f138240a + ", height=" + this.f138241b + ", surface=" + this.f138242c + ", callback=" + this.f138243d + ", frameCallback=" + this.f138244e + ')';
        }
    }

    public b(MBRuntime runtime, String type) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(type, "type");
        this.f138237a = runtime;
        this.f138238b = type;
        this.f138239c = new HashMap();
    }

    @Override // com.tencent.luggage.wxa.q8.a
    public void a(int i3, int i16, int i17, Surface surface, Function1 replaceCallback, Function1 function1) {
        Intrinsics.checkNotNullParameter(replaceCallback, "replaceCallback");
        if (i16 <= 0 || i17 <= 0 || this.f138239c.containsKey(Integer.valueOf(i3))) {
            return;
        }
        this.f138239c.put(Integer.valueOf(i3), new a(i16, i17, surface, replaceCallback, function1));
        this.f138237a.b(i3, this.f138238b, i16, i17, surface);
    }

    @Override // com.tencent.luggage.wxa.q8.a
    public void b(int i3) {
        if (!this.f138239c.containsKey(Integer.valueOf(i3))) {
            return;
        }
        this.f138239c.remove(Integer.valueOf(i3));
        this.f138237a.d(i3, this.f138238b);
    }

    @Override // com.tencent.luggage.wxa.q8.a
    public void a(final int i3, SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        final a aVar = (a) this.f138239c.get(Integer.valueOf(i3));
        if (aVar == null) {
            return;
        }
        f.c("MagicBrush", "surface texture loaded id = " + i3, new Object[0]);
        aVar.a().invoke(surfaceTexture);
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: x31.a
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                b.a(b.this, i3, aVar, surfaceTexture2);
            }
        });
    }

    public static final void a(b this$0, int i3, a entry, SurfaceTexture it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(entry, "$entry");
        this$0.f138237a.c(i3, this$0.f138238b);
        Function1 b16 = entry.b();
        if (b16 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            b16.invoke(it);
        }
    }

    @Override // com.tencent.luggage.wxa.q8.a
    public void a(int i3) {
        f.c("MagicBrush", "surface texture unload id = " + i3, new Object[0]);
        a aVar = (a) this.f138239c.remove(Integer.valueOf(i3));
        if (aVar == null) {
            return;
        }
        aVar.a().invoke(null);
    }
}
