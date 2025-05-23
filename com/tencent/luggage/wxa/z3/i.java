package com.tencent.luggage.wxa.z3;

import android.hardware.Camera;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public class i extends d {

    /* renamed from: a, reason: collision with root package name */
    public p f146239a;

    /* renamed from: b, reason: collision with root package name */
    public int f146240b;

    public i(p pVar, int i3) {
        this.f146239a = pVar;
        this.f146240b = i3;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        try {
            w.d("CameraTask.CameraReOpenTask", "reopen camera");
            this.f146239a.close();
            this.f146239a.a(this.f146240b);
            this.f146239a.a(new a());
            return null;
        } catch (Exception e16) {
            w.b("CameraTask.CameraReOpenTask", "reopen camera failed! %s", e16.getMessage());
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
