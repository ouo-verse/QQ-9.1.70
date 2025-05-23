package com.tencent.luggage.wxa.z3;

import android.hardware.Camera;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h extends c {

    /* renamed from: a, reason: collision with root package name */
    public p f146236a;

    /* renamed from: b, reason: collision with root package name */
    public int f146237b;

    public h(p pVar, int i3) {
        this.f146236a = pVar;
        this.f146237b = i3;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        try {
            if (!this.f146236a.isOpen()) {
                w.d("CameraTask.DefaultOpenTask", "open camera");
                this.f146236a.a(this.f146237b);
                this.f146236a.a(new a());
                return null;
            }
            return null;
        } catch (Exception e16) {
            w.b("CameraTask.DefaultOpenTask", "open camera failed! %s", e16.getMessage());
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Camera.PreviewCallback {
        public a() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera2) {
        }
    }
}
