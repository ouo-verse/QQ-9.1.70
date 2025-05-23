package com.tencent.luggage.wxa.i8;

import com.tencent.luggage.wxa.ai.k;
import com.tencent.luggage.wxa.i8.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.zp.h;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements e.m0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f129503a;

    /* renamed from: b, reason: collision with root package name */
    public final float f129504b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakReference f129505c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f129506a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f129507b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f129508c;

        public a(boolean z16, float f16, float f17) {
            this.f129506a = z16;
            this.f129507b = f16;
            this.f129508c = f17;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = (c) d.this.f129505c.get();
            if (cVar == null) {
                w.d("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale#ui, textureImageViewLike already release");
            } else if (this.f129506a) {
                cVar.setTextureViewWidthWeight(this.f129507b);
            } else {
                cVar.setTextureViewHeightWeight(this.f129508c);
            }
        }
    }

    public d(k kVar, c cVar) {
        float f16 = kVar.f();
        this.f129503a = f16;
        float a16 = kVar.a();
        this.f129504b = a16;
        w.d("MicroMsg.AppBrand.TextureScaleLogic", "<init>, originWidthScale: %f, originHeightScale: %f", Float.valueOf(f16), Float.valueOf(a16));
        this.f129505c = new WeakReference(cVar);
    }

    @Override // com.tencent.luggage.wxa.i8.e.m0
    public void a(boolean z16, float f16, float f17) {
        float f18;
        boolean z17;
        w.d("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged: %b, widthScale: %f, heightScale: %f", Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
        if (z16) {
            w.d("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged");
            return;
        }
        if (((c) this.f129505c.get()) == null) {
            w.d("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, textureImageViewLike already release");
            return;
        }
        float f19 = f16 / this.f129503a;
        float f26 = f17 / this.f129504b;
        float f27 = 1.0f;
        if (f19 >= f26) {
            z17 = false;
            f27 = (f26 / f19) * 1.0f;
            f18 = 1.0f;
        } else {
            f18 = (f19 / f26) * 1.0f;
            z17 = true;
        }
        w.d("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, fixedWidthScale: %f, fixedHeightScale: %f, finalWidthScale: %f, finalHeightScale: %f, willScaleWidth: %b", Float.valueOf(f19), Float.valueOf(f26), Float.valueOf(f18), Float.valueOf(f27), Boolean.valueOf(z17));
        h.f146825d.a(new a(z17, f18, f27));
    }
}
