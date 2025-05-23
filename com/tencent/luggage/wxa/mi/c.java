package com.tencent.luggage.wxa.mi;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.wxa.hd.a;
import com.tencent.luggage.wxa.vc.d;
import com.tencent.luggage.wxa.vc.e;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements e {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e.a f134602a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f134603b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f134604c;

        public a(e.a aVar, d dVar, String str) {
            this.f134602a = aVar;
            this.f134603b = dVar;
            this.f134604c = str;
        }

        @Override // com.tencent.luggage.wxa.hd.a.b
        public void a(Bitmap bitmap) {
            if (this.f134602a != null && bitmap != null && !bitmap.isRecycled()) {
                this.f134602a.a(this.f134603b, this.f134604c, bitmap);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.vc.e
    public Bitmap a(d dVar, String str) {
        return a(dVar, str, null);
    }

    @Override // com.tencent.luggage.wxa.vc.e
    public Bitmap a(d dVar, String str, e.a aVar) {
        return a(dVar, str, null, aVar);
    }

    @Override // com.tencent.luggage.wxa.vc.e
    public Bitmap a(d dVar, String str, Rect rect, e.a aVar) {
        com.tencent.luggage.wxa.xd.d b16 = dVar.b();
        return ((com.tencent.luggage.wxa.hd.a) b16.b(com.tencent.luggage.wxa.hd.a.class)).b(((com.tencent.luggage.wxa.hd.b) b16.b(com.tencent.luggage.wxa.hd.b.class)).c(b16, str), rect, new a(aVar, dVar, str));
    }
}
