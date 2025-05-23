package com.tencent.luggage.wxa.d;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static volatile d f123877b;

    /* renamed from: a, reason: collision with root package name */
    public c f123878a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements c {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.d.d.c
        public Bitmap a(int i3, int i16) {
            com.tencent.luggage.wxa.h.b.c("MiroMsg.MBBitmapPool", "hy: dummy getTask", new Object[0]);
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        }

        @Override // com.tencent.luggage.wxa.d.d.c
        public void init() {
            com.tencent.luggage.wxa.h.b.c("MiroMsg.MBBitmapPool", "hy: dummy init", new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        Bitmap a(int i3, int i16);

        void init();
    }

    public d() {
        b bVar = new b();
        this.f123878a = bVar;
        bVar.init();
    }

    public static d a() {
        d dVar;
        if (f123877b == null) {
            synchronized (d.class) {
                if (f123877b == null) {
                    f123877b = new d();
                }
                dVar = f123877b;
            }
            return dVar;
        }
        return f123877b;
    }

    public Bitmap a(int i3, int i16) {
        return this.f123878a.a(i3, i16);
    }
}
