package com.tencent.luggage.wxa.z3;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public class k extends f {

    /* renamed from: a, reason: collision with root package name */
    public p f146244a;

    public k(p pVar) {
        this.f146244a = pVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        try {
            if (this.f146244a.e()) {
                w.d("CameraTask.DefaultStopPreviewTask", "stop preview");
                this.f146244a.f();
                return null;
            }
            return null;
        } catch (Exception e16) {
            w.d("CameraTask.DefaultStopPreviewTask", "stop preview failed! %s", e16.getMessage());
            return null;
        }
    }
}
