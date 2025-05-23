package com.tencent.rfw.barrage.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import tz3.i;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final vz3.d f365050a = new vz3.d();

    public void a() {
        vz3.d dVar = this.f365050a;
        if (dVar == null) {
            return;
        }
        dVar.a();
    }

    public Bitmap b(com.tencent.rfw.barrage.data.a aVar, i iVar) {
        if (aVar == null) {
            wz3.b.d("RFWCacheDrawManager", "[fetchBitmapCache] error.", new RuntimeException("barrage should be null."));
            return null;
        }
        if (aVar.P()) {
            Bitmap m3 = aVar.m();
            if (m3 == null) {
                m3 = this.f365050a.b((int) aVar.y(), (int) aVar.x());
            } else if (m3.getWidth() < ((int) aVar.y()) || m3.getHeight() < ((int) aVar.x())) {
                this.f365050a.d(m3);
                m3 = this.f365050a.b((int) aVar.y(), (int) aVar.x());
            }
            aVar.n0(m3);
            if (m3 == null) {
                return null;
            }
            Canvas n3 = aVar.n();
            if (n3 == null) {
                n3 = new Canvas(m3);
                aVar.o0(n3);
            } else {
                n3.setBitmap(m3);
            }
            Canvas canvas = n3;
            m3.eraseColor(0);
            aVar.p0(false);
            uz3.f e16 = iVar.e(aVar);
            if (e16 == null) {
                return m3;
            }
            e16.c(canvas, aVar, iVar, i.l().e(), i.l().f());
            return m3;
        }
        return aVar.m();
    }

    public void c(Bitmap bitmap) {
        vz3.d dVar = this.f365050a;
        if (dVar == null) {
            return;
        }
        dVar.d(bitmap);
    }
}
