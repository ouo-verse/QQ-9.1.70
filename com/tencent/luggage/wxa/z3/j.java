package com.tencent.luggage.wxa.z3;

import android.graphics.SurfaceTexture;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j extends e {

    /* renamed from: a, reason: collision with root package name */
    public p f146242a;

    /* renamed from: b, reason: collision with root package name */
    public SurfaceTexture f146243b;

    public j(p pVar, SurfaceTexture surfaceTexture) {
        this.f146242a = pVar;
        this.f146243b = surfaceTexture;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        try {
            if (this.f146242a.isOpen() && !this.f146242a.e()) {
                w.d("CameraTask.DefaultStartPreviewTask", "start preview");
                this.f146242a.a(this.f146243b);
                return null;
            }
            return null;
        } catch (Exception e16) {
            w.b("CameraTask.DefaultStartPreviewTask", "start preview failed! %s", e16.getMessage());
            return null;
        }
    }
}
