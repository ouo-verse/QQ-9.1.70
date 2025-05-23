package com.tencent.liteav.videoproducer.capture.a;

import android.hardware.Camera;
import com.tencent.liteav.base.util.LiteavLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class b implements Camera.AutoFocusCallback {

    /* renamed from: a, reason: collision with root package name */
    private static final b f119601a = new b();

    b() {
    }

    public static Camera.AutoFocusCallback a() {
        return f119601a;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public final void onAutoFocus(boolean z16, Camera camera2) {
        LiteavLog.d("CameraController", "onAutoFocus success: %b", Boolean.valueOf(z16));
    }
}
