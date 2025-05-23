package com.tencent.av.app;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private CameraManager f73153a = null;

    /* renamed from: b, reason: collision with root package name */
    private c f73154b = null;

    /* renamed from: c, reason: collision with root package name */
    private final Object f73155c = new Object();

    public void a(Context context, String str, Handler handler) {
        if (context == null) {
            return;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        this.f73153a = cameraManager;
        if (cameraManager != null) {
            synchronized (this.f73155c) {
                if (this.f73154b == null) {
                    c cVar = new c(context, str);
                    this.f73154b = cVar;
                    try {
                        this.f73153a.registerAvailabilityCallback(cVar, handler);
                    } catch (IllegalArgumentException unused) {
                        QLog.d("CameraManagerWrapper", 1, "registerAvailabilityCb failed");
                    }
                }
            }
        }
    }

    public void b() {
        if (this.f73153a != null) {
            synchronized (this.f73155c) {
                c cVar = this.f73154b;
                if (cVar != null) {
                    this.f73153a.unregisterAvailabilityCallback(cVar);
                    this.f73154b = null;
                }
            }
        }
    }
}
