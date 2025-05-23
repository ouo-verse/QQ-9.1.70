package com.tencent.luggage.wxa.mb;

import android.graphics.SurfaceTexture;
import com.tencent.luggage.wxa.eb.d;
import com.tencent.luggage.wxa.tn.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.mb.a {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fb.a f134246a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f134247b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.tencent.luggage.wxa.fb.a aVar, c cVar) {
            super(1);
            this.f134246a = aVar;
            this.f134247b = cVar;
        }

        public final void a(SurfaceTexture it) {
            int i3;
            Intrinsics.checkNotNullParameter(it, "it");
            com.tencent.luggage.wxa.fb.a aVar = this.f134246a;
            d k3 = aVar.k();
            if (k3 != null) {
                i3 = k3.e();
            } else {
                i3 = -1;
            }
            aVar.a(i3);
            this.f134247b.g().requestRender();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SurfaceTexture) obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.tencent.luggage.wxa.lb.d view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.tencent.luggage.wxa.mb.a
    public void a(com.tencent.luggage.wxa.fb.a renderer) {
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        super.a(renderer);
        renderer.a(new a(renderer, this));
        w.d(e(), "setPreviewRenderer: " + renderer.hashCode());
    }
}
