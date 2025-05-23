package com.tencent.avcore.camera.callback;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.avcore.camera.callback.a;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends a implements Camera.PreviewCallback {
    static IPatchRedirector $redirector_;
    public boolean C;

    public d(com.tencent.avcore.camera.b bVar, c cVar) {
        super(bVar, cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) cVar);
        } else {
            this.C = true;
        }
    }

    private boolean g(int i3) {
        if (i3 <= 0) {
            return false;
        }
        try {
            com.tencent.avcore.camera.util.a.d().e(i3);
            return true;
        } catch (OutOfMemoryError unused) {
            this.f77405e.c().a();
            try {
                com.tencent.avcore.camera.util.a.d().e(i3);
                return true;
            } catch (OutOfMemoryError e16) {
                AVCoreLog.printAllUserLog("MyPreviewCallback", "allocateFrame failed , size:" + i3 + ", " + e16.getMessage());
                return false;
            }
        }
    }

    private int h(int i3) {
        int bitsPerPixel = ImageFormat.getBitsPerPixel(i3);
        float f16 = (bitsPerPixel * 1.0f) / 8.0f;
        int i16 = (int) (com.tencent.avcore.camera.b.f77379v * com.tencent.avcore.camera.b.f77378u * f16);
        if (AVCoreLog.isLogColorOrGary()) {
            AVCoreLog.printAllUserLog("MyPreviewCallback", "getPreviewBufferSize, previewFormat[" + i3 + "], bitPixel[" + bitsPerPixel + "], byteNum[" + f16 + "], bufSize[" + i16 + "]");
        }
        return i16;
    }

    @Override // com.tencent.avcore.camera.callback.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.avcore.camera.util.a.d().a();
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.printAllUserLog("MyPreviewCallback", "release");
        }
    }

    @Override // com.tencent.avcore.camera.callback.a
    public void f(long j3, SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        int i16 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), surfaceTexture);
            return;
        }
        this.f77404d.c();
        if (this.C && this.f77405e.i() != null) {
            if (g(h(this.f77405e.i().getPreviewFormat()))) {
                int i17 = 0;
                for (int i18 = 0; i18 < com.tencent.avcore.camera.util.a.d().c(); i18++) {
                    byte[] b16 = com.tencent.avcore.camera.util.a.d().b(0);
                    if (b16 != null) {
                        com.tencent.avcore.camera.util.a.d().g(b16, 1);
                        this.f77405e.e().addCallbackBuffer(b16);
                        i17++;
                        if (i17 >= 2) {
                            break;
                        }
                    }
                }
                this.f77405e.e().setPreviewCallbackWithBuffer(this);
                i3 = 1;
            } else {
                this.f77405e.e().setPreviewCallback(this);
            }
            i16 = i3;
        } else {
            this.f77405e.e().setPreviewCallback(this);
        }
        AVCoreLog.printAllUserLog("MyPreviewCallback", "setPreviewCallback, type[" + i16 + "], seq[" + j3 + "]");
    }

    @Override // android.hardware.Camera.PreviewCallback
    @TargetApi(8)
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        String str;
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, (Object) camera2);
            return;
        }
        if (bArr == null) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("MyPreviewCallback", "onPreviewFrame, data is null, Camera[" + camera2 + "], camera[" + this.f77405e.e() + "]");
            }
            this.f77404d.b();
            return;
        }
        a(this.f77407h);
        int length = bArr.length;
        int i16 = com.tencent.avcore.camera.b.f77378u;
        int i17 = com.tencent.avcore.camera.b.f77379v;
        if (length != ((i16 * i17) * 3) / 2) {
            if (length == 460800) {
                i16 = 640;
                i17 = 480;
            } else if (length == 1382400) {
                i16 = 1280;
                i17 = 720;
            } else if (length == 115200) {
                i16 = 320;
                i17 = 240;
            }
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("MyPreviewCallback", "OnPreviewData false, expectSize[" + com.tencent.avcore.camera.b.f77378u + ", " + com.tencent.avcore.camera.b.f77379v + "], dataLen[" + length + "], fixSize[" + i16 + ", " + i17 + "]");
            }
        }
        int i18 = i17;
        int i19 = i16;
        f fVar = this.f77404d;
        int i26 = this.f77407h.f77410a;
        int k3 = this.f77405e.k();
        int i27 = com.tencent.avcore.camera.b.f77382y;
        boolean B = this.f77405e.B();
        a.C0780a c0780a = this.f77407h;
        fVar.a(i26, k3, i27, B, c0780a.f77412c, c0780a.f77413d, c0780a.f77411b, length, i19, i18);
        if (this.f77406f == null) {
            str = "MyPreviewCallback";
            i3 = 0;
        } else {
            com.tencent.avcore.camera.data.c k16 = com.tencent.avcore.camera.data.c.k();
            long j3 = this.f77404d.f77424k;
            int i28 = com.tencent.avcore.camera.b.f77380w;
            a.C0780a c0780a2 = this.f77407h;
            int i29 = c0780a2.f77410a;
            int i36 = c0780a2.f77411b;
            if (this.f77405e.k() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            str = "MyPreviewCallback";
            i3 = 0;
            k16.h(j3, bArr, i19, i18, i28, i29, i36, z16, com.tencent.avcore.camera.b.f77382y, System.currentTimeMillis());
            this.f77406f.onPreviewData(k16);
        }
        if (this.C && this.f77405e.e() != null) {
            byte[] b16 = com.tencent.avcore.camera.util.a.d().b(i3);
            if (b16 == null) {
                if (AVCoreLog.isDevelopLevel()) {
                    AVCoreLog.printAllUserLog(str, "OnPreviewData, \u6ca1\u6709\u7a7a\u95f2\u7684\u7f13\u5b58");
                }
                b16 = bArr;
            }
            com.tencent.avcore.camera.util.a.d().g(b16, 1);
            this.f77405e.e().addCallbackBuffer(b16);
        }
    }
}
