package com.tencent.rfw.barrage.core;

import android.os.HandlerThread;
import tz3.i;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f365048a;

    /* renamed from: b, reason: collision with root package name */
    private i f365049b;

    public e(i iVar) {
        this.f365049b = iVar;
    }

    public static void c(i iVar, com.tencent.rfw.barrage.data.a aVar) {
        uz3.f e16;
        wz3.a e17;
        if (aVar == null || aVar.U() || (e16 = iVar.e(aVar)) == null || (e17 = e16.e(aVar)) == null) {
            return;
        }
        aVar.z0(e17.b() + (i.l().e() * 2));
        aVar.y0(e17.a() + (i.l().f() * 2));
        aVar.b();
    }

    public void b(com.tencent.rfw.barrage.data.a aVar) {
        c(this.f365049b, aVar);
    }

    public void d() {
        HandlerThread handlerThread = this.f365048a;
        if (handlerThread != null && handlerThread.isAlive()) {
            if (wz3.d.c()) {
                this.f365048a.quitSafely();
            } else {
                this.f365048a.quit();
            }
        }
    }
}
