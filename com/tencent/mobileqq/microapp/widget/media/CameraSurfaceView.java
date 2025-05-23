package com.tencent.mobileqq.microapp.widget.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static Camera f246169a;

    /* renamed from: h, reason: collision with root package name */
    public static int f246170h;

    /* renamed from: i, reason: collision with root package name */
    public static int f246171i;

    /* renamed from: l, reason: collision with root package name */
    static final /* synthetic */ boolean f246172l;

    /* renamed from: b, reason: collision with root package name */
    boolean f246173b;

    /* renamed from: c, reason: collision with root package name */
    boolean f246174c;

    /* renamed from: d, reason: collision with root package name */
    public ApkgConfigManager.a f246175d;

    /* renamed from: e, reason: collision with root package name */
    protected WeakReference f246176e;

    /* renamed from: f, reason: collision with root package name */
    Camera.AutoFocusCallback f246177f;

    /* renamed from: g, reason: collision with root package name */
    Camera.PreviewCallback f246178g;

    /* renamed from: j, reason: collision with root package name */
    b f246179j;

    /* renamed from: k, reason: collision with root package name */
    a f246180k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CameraSurfaceView.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                CameraSurfaceView.this.a(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CameraSurfaceView.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                CameraSurfaceView.this.e();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16962);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f246172l = true;
        f246169a = null;
        f246170h = 320;
        f246171i = 240;
    }

    public CameraSurfaceView(Context context, WebviewContainer webviewContainer) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) webviewContainer);
            return;
        }
        this.f246173b = false;
        this.f246174c = false;
        this.f246177f = new com.tencent.mobileqq.microapp.widget.media.a(this);
        this.f246178g = null;
        this.f246179j = new b();
        this.f246180k = new a();
        b();
        this.f246176e = new WeakReference(webviewContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
            return "continuous-picture";
        }
        return "continuous-video";
    }

    void b() {
        this.f246174c = false;
        getHolder().addCallback(this);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CameraSurfaceView", 2, "openCamera");
        }
        ThreadManagerV2.excute(this.f246179j, 16, null, true);
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CameraSurfaceView", 2, "closeCamera");
        }
        ThreadManagerV2.excute(this.f246180k, 16, null, true);
    }

    @TargetApi(9)
    public void e() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f246174c && !this.f246173b) {
            if (f246169a == null) {
                try {
                    f246169a = CameraMonitor.open(0);
                    if (CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL)) {
                        i3 = 270;
                    } else {
                        i3 = 90;
                    }
                    f246169a.setDisplayOrientation(i3);
                    Camera.Parameters parameters = f246169a.getParameters();
                    Camera.Size a16 = a(parameters.getSupportedPreviewSizes(), f246170h, f246171i);
                    if (a16 != null) {
                        parameters.setPreviewSize(a16.width, a16.height);
                        parameters.setPictureSize(a16.width, a16.height);
                        if (QLog.isColorLevel()) {
                            QLog.i("CameraSurfaceView", 2, "previewSize w h " + a16.width + "   " + a16.height);
                        }
                    }
                    if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                        parameters.setFocusMode("continuous-video");
                    }
                    parameters.setFlashMode("auto");
                    f246169a.setParameters(parameters);
                    parameters.getPreviewFormat();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            Camera camera2 = f246169a;
            if (camera2 != null) {
                try {
                    camera2.setPreviewDisplay(getHolder());
                    Camera.PreviewCallback previewCallback = this.f246178g;
                    if (previewCallback != null) {
                        f246169a.setPreviewCallback(previewCallback);
                    }
                    f246169a.startPreview();
                    f246169a.autoFocus(this.f246177f);
                    this.f246173b = true;
                } catch (Exception e17) {
                    e17.printStackTrace();
                    this.f246173b = false;
                }
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        WebviewContainer webviewContainer;
        com.tencent.mobileqq.microapp.appbrand.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        WeakReference weakReference = this.f246176e;
        if (weakReference == null || (webviewContainer = (WebviewContainer) weakReference.get()) == null || (aVar = webviewContainer.appBrandRuntime) == null || aVar.f245905j) {
            return;
        }
        e();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) surfaceHolder);
        } else {
            this.f246174c = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) surfaceHolder);
        } else {
            this.f246174c = false;
            d();
        }
    }

    boolean a() {
        return !CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_NOT_FOCUS_MODEL);
    }

    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!f246172l && this.f246175d == null) {
            throw new AssertionError();
        }
        if (!a()) {
            return false;
        }
        try {
            f246169a.cancelAutoFocus();
        } catch (RuntimeException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("CameraSurfaceView", 2, "", e16);
            }
        }
        Camera.Parameters parameters = f246169a.getParameters();
        if (parameters == null) {
            return false;
        }
        String focusMode = parameters.getFocusMode();
        if (focusMode != null && focusMode.equals(str)) {
            return true;
        }
        if (!com.tencent.mobileqq.shortvideo.mediadevice.a.d().m(str)) {
            return false;
        }
        parameters.setFocusMode(str);
        boolean a16 = a(parameters);
        if (QLog.isColorLevel()) {
            QLog.d("CameraSurfaceView", 2, "[@] setParamsFocusMode isSupportFocus=true  success=" + a16);
        }
        return a16;
    }

    public boolean a(Camera.Parameters parameters) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parameters)).booleanValue();
        }
        if (parameters == null) {
            return false;
        }
        try {
            f246169a.setParameters(parameters);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        Camera camera2 = f246169a;
        if (camera2 == null) {
            return;
        }
        try {
            camera2.setPreviewCallback(null);
            f246169a.stopPreview();
            this.f246173b = false;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (z16 || !this.f246174c) {
            try {
                f246169a.setPreviewDisplay(null);
                f246169a.release();
                f246169a = null;
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    public void a(ApkgConfigManager.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.f246175d = aVar;
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
        }
    }

    private Camera.Size a(List list, int i3, int i16) {
        double d16;
        int i17;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            if (size2.width == i3 && size2.height == i16) {
                return size2;
            }
        }
        double d17 = i3 / i16;
        Iterator it5 = list.iterator();
        double d18 = Double.MAX_VALUE;
        double d19 = Double.MAX_VALUE;
        while (it5.hasNext()) {
            Camera.Size size3 = (Camera.Size) it5.next();
            if ((i3 > i16 && size3.width > size3.height) || (i3 < i16 && size3.width < size3.height)) {
                d16 = size3.width;
                i17 = size3.height;
            } else {
                d16 = size3.height;
                i17 = size3.width;
            }
            if (Math.abs((d16 / i17) - d17) <= 0.05d && Math.abs(size3.height - i16) < d19) {
                d19 = Math.abs(size3.height - i16);
                size = size3;
            }
        }
        if (size == null) {
            Iterator it6 = list.iterator();
            while (it6.hasNext()) {
                Camera.Size size4 = (Camera.Size) it6.next();
                if (Math.abs(size4.height - i16) < d18) {
                    size = size4;
                    d18 = Math.abs(size4.height - i16);
                }
            }
        }
        return size;
    }
}
