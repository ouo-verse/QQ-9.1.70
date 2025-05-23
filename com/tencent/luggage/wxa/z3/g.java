package com.tencent.luggage.wxa.z3;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends b {

    /* renamed from: a, reason: collision with root package name */
    public p f146235a;

    public g(p pVar) {
        this.f146235a = pVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        try {
            if (this.f146235a.isOpen()) {
                this.f146235a.close();
                w.d("CameraTask.DefaultCloseTask", "close camera");
                return null;
            }
            return null;
        } catch (Exception e16) {
            w.b("CameraTask.DefaultCloseTask", "close camera failed! %s", e16.getMessage());
            return null;
        }
    }
}
