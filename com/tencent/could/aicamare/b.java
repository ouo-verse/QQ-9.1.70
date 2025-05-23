package com.tencent.could.aicamare;

import android.hardware.Camera;
import com.tencent.could.aicamare.callback.CameraEventListener;
import com.tencent.could.aicamare.util.CameraLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements Camera.PreviewCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Camera f99915a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f99916b;

    public b(d dVar, Camera camera2) {
        this.f99916b = dVar;
        this.f99915a = camera2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar, (Object) camera2);
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, (Object) camera2);
            return;
        }
        if (this.f99915a == null) {
            CameraLogger.a("CameraHolderImp", "currentCamera is null!", this.f99916b.f99921c);
            return;
        }
        CameraEventListener cameraEventListener = this.f99916b.f99920b;
        if (cameraEventListener != null) {
            cameraEventListener.onDataFrameCallBack(bArr);
        }
    }
}
