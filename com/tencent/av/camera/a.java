package com.tencent.av.camera;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.TextureView;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements c, TextureView.SurfaceTextureListener {

    /* renamed from: i, reason: collision with root package name */
    private static int f73495i = -1;

    /* renamed from: m, reason: collision with root package name */
    private static int f73496m = -1;

    /* renamed from: d, reason: collision with root package name */
    private Camera f73497d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceTexture f73498e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f73499f;

    /* renamed from: h, reason: collision with root package name */
    private int f73500h = 1;

    private void b() {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i3 = 0; i3 < numberOfCameras; i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            int i16 = cameraInfo.facing;
            if (i16 == 1) {
                f73495i = i3;
            } else if (i16 == 0) {
                f73496m = i3;
            }
        }
        QLog.d("Camera1Manager", 1, "fetchCameraInfo backIndex=" + f73496m + " frontIndex=" + f73495i);
    }

    private Camera.Size c(List<Camera.Size> list, int i3, int i16) {
        double d16 = i3 / i16;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double d17 = Double.MAX_VALUE;
        double d18 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((size2.width / size2.height) - d16) <= 0.1d && Math.abs(size2.height - i16) < d18) {
                d18 = Math.abs(size2.height - i16);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - i16) < d17) {
                    size = size3;
                    d17 = Math.abs(size3.height - i16);
                }
            }
        }
        if (size != null) {
            QLog.d("Camera1Manager", 1, "getOptimalPreviewSize [" + size.width + "," + size.height + "]");
        }
        return size;
    }

    public static int d(Activity activity) {
        int i3;
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 0) {
            i3 = 0;
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation == 3) {
                        i3 = 180;
                    }
                } else {
                    i3 = 270;
                }
            }
        } else {
            i3 = 90;
        }
        QLog.w("Camera1Manager", 1, "getPreviewDegree=" + i3);
        return i3;
    }

    private void f(int i3) {
        int i16;
        QLog.d("Camera1Manager", 1, "--------openCamera------ type" + i3);
        this.f73500h = i3;
        if (i3 == 1) {
            try {
                int i17 = f73495i;
                if (i17 != -1) {
                    this.f73497d = CameraMonitor.open(i17);
                }
            } catch (Exception e16) {
                release();
                QLog.e("Camera1Manager", 1, "openCamera failed: " + e16);
                return;
            }
        }
        if (i3 == 2 && (i16 = f73496m) != -1) {
            this.f73497d = CameraMonitor.open(i16);
        } else {
            this.f73497d = null;
        }
    }

    @Override // com.tencent.av.camera.c
    public void a(AutoFitTextureView autoFitTextureView, Activity activity) {
        this.f73499f = activity;
        this.f73498e = autoFitTextureView.getSurfaceTexture();
        autoFitTextureView.setSurfaceTextureListener(this);
        b();
        autoFitTextureView.setAspectRatio(720, 1280);
        QLog.d("Camera1Manager", 1, "initView");
    }

    public void e() {
        f(this.f73500h);
    }

    public void g() {
        int i3;
        Camera.Parameters parameters = this.f73497d.getParameters();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        if (this.f73500h == 1) {
            i3 = f73495i;
        } else {
            i3 = f73496m;
        }
        Camera.getCameraInfo(i3, cameraInfo);
        Camera.Size c16 = c(parameters.getSupportedPreviewSizes(), 1280, 720);
        if (c16 != null) {
            parameters.setPreviewSize(c16.width, c16.height);
        } else {
            parameters.setPreviewSize(1280, 720);
        }
        this.f73497d.setParameters(parameters);
        QLog.d("Camera1Manager", 1, "-----------------setPreviewSize-----------");
    }

    public void h() {
        if (this.f73497d == null) {
            return;
        }
        try {
            QLog.d("Camera1Manager", 1, "--------startPreview------");
            this.f73497d.setPreviewTexture(this.f73498e);
            this.f73497d.setDisplayOrientation(d(this.f73499f));
            this.f73497d.startPreview();
            this.f73497d.autoFocus(null);
        } catch (Exception e16) {
            QLog.e("Camera1Manager", 1, "startPreview failed: " + e16);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        this.f73498e = surfaceTexture;
        resume();
        QLog.d("Camera1Manager", 1, "onSurfaceTextureAvailable");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        QLog.d("Camera1Manager", 1, "onSurfaceTextureDestroyed");
        release();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        QLog.d("Camera1Manager", 1, "onSurfaceTextureSizeChanged");
    }

    @Override // com.tencent.av.camera.c
    public void release() {
        Camera camera2 = this.f73497d;
        if (camera2 != null) {
            try {
                camera2.stopPreview();
                this.f73497d.release();
                this.f73497d = null;
            } catch (Exception e16) {
                QLog.e("Camera1Manager", 1, "release failed: " + e16);
            }
        }
        QLog.d("Camera1Manager", 1, "--------release------");
    }

    @Override // com.tencent.av.camera.c
    public void resume() {
        if (this.f73498e != null) {
            e();
            g();
            h();
        }
    }

    @Override // com.tencent.av.camera.c
    public boolean switchCamera() {
        release();
        int i3 = this.f73500h;
        if (i3 == 1) {
            f(2);
        } else if (i3 == 2) {
            f(1);
        }
        h();
        if (this.f73500h == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
