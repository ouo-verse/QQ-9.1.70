package com.tencent.qqcamerakit.capture.camera;

import NS_COMM.COMM;
import android.app.admin.DevicePolicyManager;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qqcamerakit.capture.CameraHandler;
import com.tencent.qqcamerakit.capture.b;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.qqcamerakit.capture.camerastrategy.c;
import com.tencent.qqcamerakit.capture.d;
import com.tencent.qqcamerakit.common.e;
import java.util.ArrayList;
import kotlinx.coroutines.DebugKt;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CameraControl implements Camera.AutoFocusCallback, Camera.PreviewCallback {
    static IPatchRedirector $redirector_;
    public static String I;
    private static CameraControl J;
    static final /* synthetic */ boolean K;
    private d C;
    private byte[] D;
    private byte[] E;
    private d F;
    private int[] G;
    private b H;

    /* renamed from: d, reason: collision with root package name */
    private boolean f344808d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f344809e;

    /* renamed from: f, reason: collision with root package name */
    private Camera f344810f;

    /* renamed from: h, reason: collision with root package name */
    public int f344811h;

    /* renamed from: i, reason: collision with root package name */
    public int f344812i;

    /* renamed from: m, reason: collision with root package name */
    private int f344813m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Camera.AutoFocusCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c.a f344819d;

        a(c.a aVar) {
            this.f344819d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CameraControl.this, (Object) aVar);
            }
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z16, Camera camera2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), camera2);
                return;
            }
            if (e.f()) {
                e.e(CameraControl.I, 2, "Request Focus onAutoFocus, ", Boolean.valueOf(z16));
            }
            this.f344819d.onAutoFocusCallback(z16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(COMM.hexlog);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 42)) {
            redirector.redirect((short) 42);
        } else {
            K = true;
            I = "CameraControl";
        }
    }

    public CameraControl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f344811h = -1;
        }
    }

    private void a(byte[] bArr) {
        Camera camera2 = this.f344810f;
        if (camera2 != null && bArr != null) {
            camera2.addCallbackBuffer(bArr);
        }
    }

    private boolean b(int i3) {
        if (i3 <= 0) {
            return false;
        }
        try {
            try {
                byte[] bArr = this.D;
                if (bArr == null || bArr.length != i3) {
                    this.D = new byte[i3];
                }
                byte[] bArr2 = this.E;
                if (bArr2 == null || bArr2.length != i3) {
                    this.E = new byte[i3];
                }
            } catch (OutOfMemoryError e16) {
                e.d(I, 2, "allocateFrame failed , size:" + i3 + ", " + e16.getMessage());
                return false;
            }
        } catch (OutOfMemoryError unused) {
            byte[] bArr3 = this.D;
            if (bArr3 == null || bArr3.length != i3) {
                this.D = new byte[i3];
            }
            byte[] bArr4 = this.E;
            if (bArr4 == null || bArr4.length != i3) {
                this.E = new byte[i3];
            }
        }
        return true;
    }

    private boolean d() {
        return !com.tencent.qqcamerakit.capture.camerastrategy.b.b(c.a.f344895d);
    }

    private boolean e() {
        try {
            return ((DevicePolicyManager) com.tencent.qqcamerakit.capture.c.d().getSystemService("device_policy")).getCameraDisabled(null);
        } catch (Exception e16) {
            if (e.f()) {
                e.b(I, 2, "checkCameraDisabled, ", e16);
                return true;
            }
            return true;
        } catch (NoClassDefFoundError e17) {
            if (e.f()) {
                e.b(I, 2, "checkCameraDisabled, ", e17);
                return true;
            }
            return true;
        }
    }

    public static String f(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return "";
                        }
                        return "CAMERA_OPEN_POLICY_DISABLED";
                    }
                    return "CAMERA_OPEN_GET_PARAM";
                }
                return "CAMERA_OPEN_FAILED";
            }
            return "CAMERA_OPEN_COUNT_ZERO";
        }
        return "CAMERA_OPEN_USED_AV";
    }

    private int g(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return com.tencent.qqcamerakit.capture.camera.a.b();
            }
            if (com.tencent.qqcamerakit.capture.camera.a.g()) {
                return com.tencent.qqcamerakit.capture.camera.a.b();
            }
        } else if (com.tencent.qqcamerakit.capture.camera.a.j()) {
            return com.tencent.qqcamerakit.capture.camera.a.c();
        }
        return -1;
    }

    private int j() {
        boolean z16;
        boolean b16;
        boolean z17;
        String upperCase = com.tencent.qqcamerakit.capture.camerastrategy.b.f344889a.toUpperCase();
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI) && (upperCase.contains("RLI-AN00") || upperCase.contains("RLI-N29") || upperCase.contains("TAH-AN00") || upperCase.contains("TAH-N29"))) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = 90;
        if (z16 || Build.VERSION.SDK_INT >= 29) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.f344811h, cameraInfo);
            int rotation = ((WindowManager) com.tencent.qqcamerakit.capture.c.d().getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation != 2) {
                        if (rotation == 3) {
                            i3 = 270;
                        }
                    } else {
                        i3 = 180;
                    }
                }
            } else {
                i3 = 0;
            }
            if (cameraInfo.facing == 1) {
                i3 = (360 - ((cameraInfo.orientation + i3) % 360)) % 360;
            } else {
                i3 = ((cameraInfo.orientation - i3) + 360) % 360;
            }
        }
        if (this.f344811h == 1) {
            b16 = com.tencent.qqcamerakit.capture.camerastrategy.b.b(c.a.f344892a);
            z17 = com.tencent.qqcamerakit.capture.camerastrategy.b.d(c.a.f344893b);
            if (b16 || z17) {
                i3 += 180;
            }
        } else {
            b16 = com.tencent.qqcamerakit.capture.camerastrategy.b.b(c.a.f344894c);
            if (b16) {
                i3 += 180;
            }
            z17 = false;
        }
        if (e.f()) {
            e.e(I, 2, "setDisplayOrientation degrees=" + i3 + " blackPhone = " + b16 + " rom_black = " + z17);
        }
        return i3;
    }

    public static CameraControl l() {
        if (J == null) {
            synchronized (CameraControl.class) {
                if (J == null) {
                    J = new CameraControl();
                }
            }
        }
        return J;
    }

    private int o() {
        int bitsPerPixel = ImageFormat.getBitsPerPixel(this.f344813m);
        float f16 = (bitsPerPixel * 1.0f) / 8.0f;
        d dVar = this.C;
        int i3 = (int) (dVar.f344912b * dVar.f344911a * f16);
        if (e.f()) {
            e.e(I, 2, "startPreview getPreviewBufferSize:bitpixel=" + bitsPerPixel + " byteNum=" + f16 + " bufSize=" + i3);
        }
        return i3;
    }

    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return B(j());
    }

    public boolean B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        if (!K && this.f344810f == null) {
            throw new AssertionError();
        }
        try {
            this.f344810f.setDisplayOrientation(i3);
            return true;
        } catch (Exception e16) {
            e.b(I, 1, "setDisplayOrientation error, ", e16);
            return false;
        }
    }

    public boolean C(int i3) {
        Camera.Parameters i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this, i3)).booleanValue();
        }
        if (!com.tencent.qqcamerakit.capture.camera.a.d().m() || (i16 = i()) == null) {
            return false;
        }
        return L(i16.getZoom() + i3);
    }

    public boolean D(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str)).booleanValue();
        }
        if (!K && this.f344810f == null) {
            throw new AssertionError();
        }
        if (!d()) {
            return false;
        }
        try {
            this.f344810f.cancelAutoFocus();
        } catch (RuntimeException e16) {
            e.b(I, 1, "", e16);
        }
        Camera.Parameters i3 = i();
        if (i3 == null) {
            return false;
        }
        String focusMode = i3.getFocusMode();
        if (e.f()) {
            e.e(I, 2, "setParamsFocusMode getFocusMode=" + focusMode);
        }
        if (focusMode != null && focusMode.equals(str)) {
            return true;
        }
        boolean k3 = com.tencent.qqcamerakit.capture.camera.a.d().k(str);
        if (k3) {
            i3.setFocusMode(str);
            z16 = x(i3);
        } else {
            z16 = false;
        }
        if (e.f()) {
            e.e(I, 2, "setParamsFocusMode support=" + k3 + " success=" + z16 + " setTo=" + str);
        }
        return z16;
    }

    public boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (!K && this.f344810f == null) {
            throw new AssertionError();
        }
        Camera.Parameters i3 = i();
        if (i3 == null) {
            if (e.f()) {
                e.e(I, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
            }
            return false;
        }
        if (com.tencent.qqcamerakit.capture.camera.a.d().l(17)) {
            i3.setPreviewFormat(17);
            this.f344813m = 17;
            boolean x16 = x(i3);
            if (e.f()) {
                e.e(I, 2, "[@] setParamsPreviewFormat:success=" + x16 + ", isSupportPreviewFormat=NV21 ok");
            }
            return x16;
        }
        if (com.tencent.qqcamerakit.capture.camera.a.d().l(IjkMediaPlayer.SDL_FCC_YV12)) {
            i3.setPreviewFormat(IjkMediaPlayer.SDL_FCC_YV12);
            this.f344813m = IjkMediaPlayer.SDL_FCC_YV12;
            boolean x17 = x(i3);
            if (e.f()) {
                e.e(I, 2, "[@] setParamsPreviewFormat:success=" + x17 + "isSupportPreviewFormat=YV12 OK");
            }
            return x17;
        }
        if (com.tencent.qqcamerakit.capture.camera.a.d().l(20)) {
            i3.setPreviewFormat(20);
            this.f344813m = 20;
            boolean x18 = x(i3);
            if (e.f()) {
                e.e(I, 2, "[@] setParamsPreviewFormat:success=" + x18 + "isSupportPreviewFormat=YUY2 OK");
            }
            return x18;
        }
        if (com.tencent.qqcamerakit.capture.camera.a.d().l(4)) {
            i3.setPreviewFormat(4);
            this.f344813m = 4;
            boolean x19 = x(i3);
            if (e.f()) {
                e.e(I, 2, "[@] setParamsPreviewFormat:success=" + x19 + "isSupportPreviewFormat=RGB_565 OK");
            }
            return x19;
        }
        if (com.tencent.qqcamerakit.capture.camera.a.d().l(256)) {
            i3.setPreviewFormat(256);
            this.f344813m = 256;
            boolean x26 = x(i3);
            if (e.f()) {
                e.e(I, 2, "[@] setParamsPreviewFormat:success=" + x26 + "isSupportPreviewFormat=JPEG OK");
            }
            return x26;
        }
        if (!com.tencent.qqcamerakit.capture.camera.a.d().l(16)) {
            return false;
        }
        i3.setPreviewFormat(16);
        this.f344813m = 16;
        boolean x27 = x(i3);
        if (e.f()) {
            e.e(I, 2, "[@] setParamsPreviewFormat:success=" + x27 + "isSupportPreviewFormat=NV16 OK");
        }
        return x27;
    }

    public boolean F(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) dVar)).booleanValue();
        }
        if (!K && this.f344810f == null) {
            throw new AssertionError();
        }
        Camera.Parameters i3 = i();
        if (i3 == null) {
            if (e.f()) {
                e.e(I, 2, "setParamsPreviewSize failed, getCameraParameters = null");
            }
            return false;
        }
        try {
            i3.setPreviewSize(dVar.f344911a, dVar.f344912b);
            this.C = dVar;
            boolean x16 = x(i3);
            if (e.f()) {
                e.e(I, 2, "setParamsPreviewSize, result = " + x16 + ", size = " + dVar);
            }
            return x16;
        } catch (Exception e16) {
            e.b(I, 1, "setParamsPreviewSize", e16);
            return false;
        }
    }

    public boolean G(b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, bVar, Boolean.valueOf(z16))).booleanValue();
        }
        Camera camera2 = this.f344810f;
        if (camera2 != null && bVar != null) {
            try {
                this.H = bVar;
                if (z16) {
                    if (b(o())) {
                        this.f344810f.addCallbackBuffer(this.D);
                        this.f344810f.addCallbackBuffer(this.E);
                        this.f344810f.setPreviewCallbackWithBuffer(this);
                    } else {
                        this.f344810f.setPreviewCallback(this);
                    }
                } else {
                    camera2.setPreviewCallback(this);
                }
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public boolean H(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, i3)).booleanValue();
        }
        if (!K && this.f344810f == null) {
            throw new AssertionError();
        }
        Camera.Parameters i16 = i();
        if (i16 == null) {
            e.e(I, 1, "setPreviewFps failed, getCameraParameters null");
            return false;
        }
        int[] a16 = com.tencent.qqcamerakit.capture.camerastrategy.d.a(i3);
        if (a16 != null && a16.length >= 2) {
            if (e.f()) {
                e.e(I, 2, "setPreviewFps[low fps=", Integer.valueOf(a16[0]), " high fps=", Integer.valueOf(a16[1]), "]");
            }
            try {
                i16.setPreviewFpsRange(a16[0], a16[1]);
                this.G = a16;
                return x(i16);
            } catch (Exception e16) {
                e.b(I, 1, "setPreviewFps, setPreviewFps error, ", e16);
                return false;
            }
        }
        e.e(I, 1, "setPreviewFps, getFpsRange null");
        return false;
    }

    public boolean I(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) surfaceTexture)).booleanValue();
        }
        Camera camera2 = this.f344810f;
        if (camera2 != null && surfaceTexture != null) {
            if (this.f344809e) {
                if (e.f()) {
                    e.e(I, 2, "[setPreviewTexture] mIsPreviewing true");
                }
                return true;
            }
            try {
                camera2.setPreviewTexture(surfaceTexture);
                return true;
            } catch (Exception e16) {
                e.b(I, 1, "[setPreviewTexture] exp: ", e16);
            }
        }
        return false;
    }

    public boolean J(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) dVar)).booleanValue();
        }
        Camera.Parameters i3 = i();
        if (i3 == null) {
            if (e.f()) {
                e.e(I, 2, "setRawPictureSize failed, getCameraParameters = null");
            }
            return false;
        }
        try {
            i3.setPictureSize(dVar.f344911a, dVar.f344912b);
            this.F = dVar;
            boolean x16 = x(i3);
            if (e.f()) {
                e.e(I, 2, "setRawPictureSize, result = " + x16 + ", size = " + dVar);
            }
            return x16;
        } catch (Exception e16) {
            e.b(I, 1, "setParamsPictureSize", e16);
            return false;
        }
    }

    public boolean K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        if (!D(r()) && !D("auto") && !l().c(null)) {
            return false;
        }
        return true;
    }

    public boolean L(int i3) {
        Camera.Parameters i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, i3)).booleanValue();
        }
        if (!K && this.f344810f == null) {
            throw new AssertionError();
        }
        if (!com.tencent.qqcamerakit.capture.camera.a.d().m() || (i16 = i()) == null) {
            return false;
        }
        int maxZoom = i16.getMaxZoom();
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 <= maxZoom) {
            maxZoom = i3;
        }
        i16.setZoom(maxZoom);
        return x(i16);
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        Camera.Parameters parameters = this.f344810f.getParameters();
        if (e.f()) {
            e.e(I, 2, "startFaceDetection");
        }
        if (parameters.getMaxNumDetectedFaces() > 0) {
            this.f344810f.startFaceDetection();
        }
    }

    public boolean N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        Camera camera2 = this.f344810f;
        if (camera2 == null) {
            return false;
        }
        if (this.f344809e) {
            return true;
        }
        try {
            camera2.startPreview();
            this.f344809e = true;
            if (com.tencent.qqcamerakit.capture.a.E > 0) {
                M();
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public boolean O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        this.H = null;
        if (this.f344810f == null) {
            return false;
        }
        if (!this.f344809e) {
            return true;
        }
        try {
            this.f344809e = false;
            if (d()) {
                try {
                    this.f344810f.cancelAutoFocus();
                } catch (RuntimeException unused) {
                }
            }
            this.f344810f.stopPreview();
            this.f344810f.setPreviewCallback(null);
            this.f344810f.setPreviewDisplay(null);
            return true;
        } catch (Exception unused2) {
            return false;
        }
    }

    public void P(CameraHandler.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) cVar);
            return;
        }
        Camera camera2 = this.f344810f;
        if (camera2 == null) {
            if (e.f()) {
                e.e(I, 2, "[takePicture]mCamera " + ((Object) null));
                return;
            }
            return;
        }
        try {
            camera2.enableShutterSound(false);
        } catch (Exception e16) {
            e.e(I, 1, "[takePicture]enableShutterSound error, ", e16);
        }
        try {
            this.f344809e = false;
            CameraMonitor.takePicture(this.f344810f, null, null, null, new Camera.PictureCallback(cVar) { // from class: com.tencent.qqcamerakit.capture.camera.CameraControl.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                Handler f344814a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ CameraHandler.c f344815b;

                {
                    this.f344815b = cVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CameraControl.this, (Object) cVar);
                    } else {
                        this.f344814a = new Handler(Looper.getMainLooper());
                    }
                }

                @Override // android.hardware.Camera.PictureCallback
                public void onPictureTaken(byte[] bArr, Camera camera3) {
                    Camera.Size size;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bArr, (Object) camera3);
                        return;
                    }
                    if (e.f()) {
                        e.e(CameraControl.I, 2, "onJpegTaken");
                    }
                    try {
                        size = camera3.getParameters().getPictureSize();
                    } catch (Exception e17) {
                        e.b(CameraControl.I, 1, "getPictureSize exception, ", e17);
                        size = null;
                    }
                    if (size == null) {
                        e.d(CameraControl.I, 1, "null picSize");
                        return;
                    }
                    e.e(CameraControl.I, 1, "[onPictureTaken] picSize(", Integer.valueOf(size.width), ", ", Integer.valueOf(size.height), "), orientation = ", Integer.valueOf(this.f344815b.f344785d));
                    if (bArr == null) {
                        return;
                    }
                    this.f344814a.post(new Runnable(bArr) { // from class: com.tencent.qqcamerakit.capture.camera.CameraControl.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ byte[] f344817d;

                        {
                            this.f344817d = bArr;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) bArr);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            CameraHandler.c cVar2 = AnonymousClass1.this.f344815b;
                            cVar2.f344787f = this.f344817d;
                            cVar2.f344788g = 100;
                            new com.tencent.qqcamerakit.capture.cameraextend.c(AnonymousClass1.this.f344815b).execute(new Void[0]);
                        }
                    });
                }
            });
        } catch (RuntimeException e17) {
            e.b(I, 1, "", e17);
        }
    }

    public boolean Q(boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, z16)).booleanValue();
        }
        if (!K && this.f344810f == null) {
            throw new AssertionError();
        }
        if (com.tencent.qqcamerakit.capture.camera.a.d().i()) {
            Camera.Parameters i3 = i();
            if (z16) {
                str = "torch";
            } else {
                str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            }
            i3.setFlashMode(str);
            return x(i3);
        }
        return false;
    }

    public boolean c(Camera.AutoFocusCallback autoFocusCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) autoFocusCallback)).booleanValue();
        }
        if (this.f344810f != null && this.f344809e && d()) {
            try {
                this.f344810f.cancelAutoFocus();
                Camera camera2 = this.f344810f;
                if (autoFocusCallback == null) {
                    autoFocusCallback = this;
                }
                camera2.autoFocus(autoFocusCallback);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f344811h, cameraInfo);
        int i3 = cameraInfo.orientation;
        if (e.f()) {
            e.a(I, 2, "return orientation = " + i3);
        }
        return i3;
    }

    public Camera.Parameters i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Camera.Parameters) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        try {
            return this.f344810f.getParameters();
        } catch (Exception e16) {
            e.c(I, 1, e16, new Object[0]);
            return null;
        }
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return "continuous-picture";
    }

    public d m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (d) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.F;
    }

    public d n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (d) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.C;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z16, Camera camera2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), camera2);
            return;
        }
        if (e.f()) {
            e.e(I, 2, "[onAutoFocus]success " + z16);
        }
        D(k());
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) bArr, (Object) camera2);
            return;
        }
        b bVar = this.H;
        if (bVar != null) {
            bVar.onPreviewFrame(bArr, camera2);
        }
        a(bArr);
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.f344813m;
    }

    public int[] q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (int[]) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.G;
    }

    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        if (e.f()) {
            e.e(I, 2, "[@] getRecordingFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
        }
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
            return "continuous-picture";
        }
        return "continuous-video";
    }

    public int s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
        }
        if (this.f344808d) {
            if (e.f()) {
                e.e(I, 2, "openCamera: Camera is opened, Camera object:" + this.f344810f);
                return 6;
            }
            return 6;
        }
        if (!com.tencent.qqcamerakit.capture.camera.a.h()) {
            if (e.f()) {
                e.e(I, 2, "openCamera failed, hasCameras = false");
            }
            return 2;
        }
        if (e()) {
            if (e.f()) {
                e.e(I, 2, "openCamera failed, camera disable");
                return 5;
            }
            return 5;
        }
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= 10) {
                break;
            }
            if (e.f()) {
                e.a(I, 2, "openCamera: currentCount = " + i16);
            }
            try {
                this.f344812i = i3;
                int g16 = g(i3);
                this.f344811h = g16;
                this.f344810f = CameraMonitor.open(g16);
                i17 = 0;
                break;
            } catch (Exception e16) {
                this.f344810f = null;
                i16++;
                if (e.f()) {
                    e.b(I, 2, "openCamera failed, currentCount =" + i16, e16);
                }
                if (i16 < 10) {
                    try {
                        LockMethodProxy.sleep(300L);
                    } catch (InterruptedException unused) {
                    }
                }
                i17 = 3;
            }
        }
        if (this.f344810f == null) {
            if (e.f()) {
                e.e(I, 2, "openCamera failed, mCamera = null");
            }
            return i17;
        }
        if (!com.tencent.qqcamerakit.capture.camera.a.d().a(this.f344810f)) {
            if (e.f()) {
                e.e(I, 2, "openCamera failed, bindCamera = false");
                return 4;
            }
            return 4;
        }
        this.f344808d = true;
        return 0;
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        this.H = null;
        if (e.f()) {
            e.e(I, 2, "release camera");
        }
        if (!this.f344808d) {
            return;
        }
        com.tencent.qqcamerakit.capture.camera.a.d().n();
        Camera camera2 = this.f344810f;
        if (camera2 == null) {
            return;
        }
        try {
            camera2.release();
            this.f344810f = null;
            this.f344813m = -1;
            this.G = null;
            this.C = null;
            this.f344808d = false;
            u();
        } catch (Exception unused) {
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        this.D = null;
        this.E = null;
        if (e.f()) {
            e.e(I, 2, "releasePreviewFrameBuffer");
        }
    }

    public void v(Rect rect, Rect rect2, c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, rect, rect2, aVar);
            return;
        }
        if (e.f()) {
            e.e(I, 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
        }
        Camera.Parameters i3 = l().i();
        if (rect != null) {
            if (e.f()) {
                e.e(I, 2, "[handleMessage] focus area = " + rect);
            }
            i3.setFocusMode("auto");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(rect, 1000));
            i3.setFocusAreas(arrayList);
            if (i3.getMaxNumMeteringAreas() > 0 && rect2 != null) {
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(new Camera.Area(new Rect(rect2), 1000));
                i3.setMeteringAreas(arrayList2);
            }
            l().f344810f.setParameters(i3);
        }
        l().c(new a(aVar));
    }

    public boolean w(CameraHandler.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) aVar)).booleanValue();
        }
        Camera.Parameters i3 = i();
        if (i3 == null) {
            if (e.f()) {
                e.e(I, 2, "setParamsPreviewFormat failed, getCameraParameters = null");
            }
            return false;
        }
        i3.setPreviewFormat(aVar.f344772b);
        d dVar = aVar.f344775e;
        i3.setPreviewSize(dVar.f344911a, dVar.f344912b);
        i3.setPreviewFpsRange(aVar.f344773c, aVar.f344774d);
        if (aVar.f344776f) {
            d dVar2 = aVar.f344777g;
            i3.setPictureSize(dVar2.f344911a, dVar2.f344912b);
        }
        boolean x16 = x(i3);
        if (x16) {
            this.f344813m = aVar.f344772b;
            this.C = aVar.f344775e;
            this.G = new int[]{aVar.f344773c, aVar.f344774d};
            this.F = aVar.f344777g;
        }
        return x16;
    }

    public boolean x(Camera.Parameters parameters) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) parameters)).booleanValue();
        }
        if (!K && this.f344810f == null) {
            throw new AssertionError();
        }
        if (parameters == null) {
            return false;
        }
        try {
            this.f344810f.setParameters(parameters);
            return true;
        } catch (Exception e16) {
            e.c(I, 1, e16, new Object[0]);
            return false;
        }
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (!D(k()) && !D("auto") && !l().c(null)) {
            return false;
        }
        return true;
    }

    public boolean z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str)).booleanValue();
        }
        if (e.f()) {
            e.e(I, 2, "[setDefaultFocusMode] " + str);
        }
        if (TextUtils.isEmpty(str)) {
            str = k();
        }
        if (!D(str) && !D("auto") && !l().c(null)) {
            return false;
        }
        return true;
    }
}
