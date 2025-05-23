package com.tencent.mobileqq.ar.model;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes11.dex */
public class CameraProxy implements Camera.PreviewCallback, ARCamera.b {
    public static HandlerThread M;
    private int D;
    private long E;
    private WeakReference<c> I;
    private volatile byte[] K;
    private int L;

    /* renamed from: f, reason: collision with root package name */
    private Handler f198438f;

    /* renamed from: h, reason: collision with root package name */
    private ARCamera f198439h;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f198436d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f198437e = 1;

    /* renamed from: i, reason: collision with root package name */
    private int f198440i = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f198441m = 0;
    private int C = 17;
    private boolean F = false;
    private ArrayList<WeakReference<ARCamera.b>> G = new ArrayList<>();
    private ArrayList<WeakReference<a>> H = new ArrayList<>();
    private ArrayList<WeakReference<c>> J = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void R5(int i3, int i16);

        void S3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final CameraProxy f198444a = new CameraProxy();
    }

    /* loaded from: classes11.dex */
    public interface c {
        boolean Yd(byte[] bArr);
    }

    CameraProxy() {
        this.f198438f = null;
        this.f198439h = null;
        this.D = 10;
        this.E = 0L;
        if (M == null) {
            HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("Camera2 Handler Thread", 0);
            M = newFreeHandlerThread;
            newFreeHandlerThread.start();
            this.f198438f = new Handler(M.getLooper());
        }
        this.f198439h = new ARCamera();
        if (DeviceInfoMonitor.getModel().equalsIgnoreCase("Redmi Note 3")) {
            this.E = 500L;
        } else {
            this.E = 300L;
        }
        this.D = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z16, int i3, int i16) {
        synchronized (this.H) {
            for (int size = this.H.size() - 1; size >= 0; size--) {
                WeakReference<a> weakReference = this.H.get(size);
                if (weakReference != null && weakReference.get() != null) {
                    if (z16) {
                        weakReference.get().S3();
                    } else {
                        weakReference.get().R5(i3, i16);
                    }
                }
            }
        }
    }

    public static CameraProxy v() {
        return b.f198444a;
    }

    public boolean A() {
        if (this.f198436d == 2) {
            return true;
        }
        return false;
    }

    public boolean B() {
        if (this.f198436d == 2 && this.F) {
            return true;
        }
        return false;
    }

    public void C(int i3, int i16, int i17, int i18) {
        ARCamera aRCamera = this.f198439h;
        if (aRCamera != null) {
            aRCamera.y(i3, i16, i17, i18);
        }
    }

    public void E(final int i3) {
        if (this.f198436d == 2) {
            QLog.i("CameraProxy", 2, "openCamera mCurCameraState = " + this.f198436d);
            return;
        }
        this.f198436d = 1;
        this.D = 0;
        F(new Runnable() { // from class: com.tencent.mobileqq.ar.model.CameraProxy.1
            @Override // java.lang.Runnable
            public void run() {
                if (CameraProxy.this.f198436d == 1 && CameraProxy.this.f198439h != null) {
                    try {
                        QLog.i("CameraProxy", 2, "openCameraAync.");
                        int i16 = -3;
                        while (CameraProxy.this.D < 10) {
                            CameraProxy.this.D++;
                            System.currentTimeMillis();
                            if (CameraProxy.this.D == 1) {
                                i16 = CameraProxy.this.f198439h.B(i3);
                            } else {
                                i16 = CameraProxy.this.f198439h.z();
                            }
                            QLog.i("CameraProxy", 2, "try to open camera. mCurOpenCameraTryTimes = " + CameraProxy.this.D + ", MAX_OPEN_CAMERA_TRY_TIMES = 10");
                            if (CameraProxy.this.f198439h == null) {
                                i16 = -3;
                            }
                            if (CameraProxy.this.f198436d != 1) {
                                QLog.i("CameraProxy", 2, "cancel to open camera. next mCurCameraState = " + CameraProxy.this.f198436d);
                                return;
                            }
                            if (i16 == 0) {
                                break;
                            }
                            Thread.currentThread();
                            LockMethodProxy.sleep(CameraProxy.this.E);
                            if (CameraProxy.this.f198436d != 1) {
                                QLog.i("CameraProxy", 2, "cancel to open camera. next mCurCameraState = " + CameraProxy.this.f198436d);
                                return;
                            }
                        }
                        if (i16 == 0) {
                            CameraProxy.this.f198436d = 2;
                            QLog.i("CameraProxy", 2, "openCameraAync successfully. mCurCameraState = " + CameraProxy.this.f198436d);
                            return;
                        }
                        CameraProxy.this.f198436d = 0;
                        QLog.i("CameraProxy", 2, "openCameraAync failed. retCode = " + i16 + ", mCurCameraState = " + CameraProxy.this.f198436d);
                        if (i16 == -1) {
                            CameraProxy.this.D(false, 0, 1);
                            return;
                        } else {
                            if (i16 == -2 || i16 == -3) {
                                CameraProxy.this.D(false, 0, 2);
                                return;
                            }
                            return;
                        }
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                        QLog.i("CameraProxy", 1, "InterruptedException = " + e16.getMessage());
                        CameraProxy.this.f198436d = 0;
                        QLog.i("CameraProxy", 2, "openCameraAync failed. mCurCameraState = " + CameraProxy.this.f198436d);
                        return;
                    }
                }
                QLog.i("CameraProxy", 2, "cancel to open camera. next mCurCameraState = " + CameraProxy.this.f198436d);
            }
        });
    }

    public void F(Runnable runnable) {
        synchronized (M) {
            Handler handler = this.f198438f;
            if (handler != null) {
                handler.post(runnable);
            }
        }
    }

    public void G(ARCamera.b bVar) {
        int size = this.G.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                if (this.G.get(i3).get() == bVar) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            this.G.remove(i3);
        }
    }

    public void H(a aVar) {
        synchronized (this.H) {
            int size = this.H.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    if (this.H.get(i3).get() == aVar) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                this.H.remove(i3);
            }
        }
    }

    public void I(c cVar) {
        synchronized (this.J) {
            int size = this.J.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    if (this.J.get(i3).get() == cVar) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                this.J.remove(i3);
            }
        }
    }

    public void J() {
        ARCamera aRCamera = this.f198439h;
        if (aRCamera != null) {
            aRCamera.C();
        }
    }

    public void K(ARCamera.b bVar) {
        Iterator<WeakReference<ARCamera.b>> it = this.G.iterator();
        while (it.hasNext()) {
            if (it.next().get() == bVar) {
                return;
            }
        }
        this.G.add(new WeakReference<>(bVar));
    }

    public void L(c cVar) {
        if (cVar == null) {
            this.I = null;
        } else {
            this.I = new WeakReference<>(cVar);
        }
    }

    public void M(a aVar) {
        synchronized (this.H) {
            Iterator<WeakReference<a>> it = this.H.iterator();
            while (it.hasNext()) {
                if (it.next().get() == aVar) {
                    return;
                }
            }
            this.H.add(new WeakReference<>(aVar));
        }
    }

    public void N(c cVar) {
        synchronized (this.J) {
            Iterator<WeakReference<c>> it = this.J.iterator();
            while (it.hasNext()) {
                if (it.next().get() == cVar) {
                    return;
                }
            }
            this.J.add(new WeakReference<>(cVar));
        }
    }

    public void O(final SurfaceTexture surfaceTexture) {
        if (this.f198436d == 2 && this.F) {
            QLog.i("CameraProxy", 2, "startCameraPreview return now");
        } else {
            F(new Runnable() { // from class: com.tencent.mobileqq.ar.model.CameraProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("CameraProxy", 2, "startCameraPreview.");
                    if (CameraProxy.this.f198436d == 2 && CameraProxy.this.f198439h != null && !CameraProxy.this.F) {
                        CameraProxy cameraProxy = CameraProxy.this;
                        cameraProxy.f198440i = cameraProxy.f198439h.w();
                        CameraProxy cameraProxy2 = CameraProxy.this;
                        cameraProxy2.f198441m = cameraProxy2.f198439h.v();
                        CameraProxy cameraProxy3 = CameraProxy.this;
                        cameraProxy3.C = cameraProxy3.f198439h.u();
                        CameraProxy cameraProxy4 = CameraProxy.this;
                        ARCamera aRCamera = cameraProxy4.f198439h;
                        CameraProxy cameraProxy5 = CameraProxy.this;
                        cameraProxy4.F = aRCamera.E(cameraProxy5, surfaceTexture, cameraProxy5);
                        if (CameraProxy.this.F) {
                            QLog.i("CameraProxy", 2, "start preview successfully. mCurCameraState = " + CameraProxy.this.f198436d);
                            CameraProxy.this.D(true, 0, 1);
                            QLog.i("CameraProxy", 2, "openCamera end. mIsCameraPreviewing = " + CameraProxy.this.F);
                            return;
                        }
                        QLog.i("CameraProxy", 2, "start preview failed. mCurCameraState = " + CameraProxy.this.f198436d);
                        CameraProxy.this.f198439h.q();
                        CameraProxy.this.f198436d = 0;
                        CameraProxy.this.D(false, 0, 2);
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("ar_model", DeviceInfoMonitor.getModel());
                        hashMap.put("ar_type", "2");
                        hashMap.put("ar_reason", String.valueOf(-4));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidARException", true, 0L, 0L, hashMap, "", true);
                        return;
                    }
                    QLog.i("CameraProxy", 2, String.format("cancel to start preview. mCurCameraState=%s mARCamera=%s mIsCameraPreviewing=%s", Integer.valueOf(CameraProxy.this.f198436d), CameraProxy.this.f198439h, Boolean.valueOf(CameraProxy.this.F)));
                }
            });
        }
    }

    public boolean P(boolean z16) {
        return this.f198439h.G(z16);
    }

    public void n(int i3, int i16) {
        ARCamera aRCamera = this.f198439h;
        if (aRCamera != null) {
            aRCamera.j(i3, i16);
        }
    }

    public void o() {
        ARCamera aRCamera = this.f198439h;
        if (aRCamera != null) {
            aRCamera.k();
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        WeakReference<c> weakReference;
        synchronized (this.J) {
            boolean z16 = false;
            for (int size = this.J.size() - 1; size >= 0; size--) {
                WeakReference<c> weakReference2 = this.J.get(size);
                if (weakReference2.get() != null && (z16 = weakReference2.get().Yd(bArr))) {
                    break;
                }
            }
            if (!z16 && (weakReference = this.I) != null && weakReference.get() != null) {
                this.I.get().Yd(bArr);
            }
        }
        if (this.f198436d == 2) {
            this.K = bArr;
        } else {
            this.K = null;
        }
        ARCamera aRCamera = this.f198439h;
        if (aRCamera != null) {
            this.L = aRCamera.x();
        }
        camera2.addCallbackBuffer(bArr);
    }

    public void p() {
        ARCamera aRCamera = this.f198439h;
        if (aRCamera != null) {
            aRCamera.n();
        }
    }

    public void q() {
        if (this.f198436d == 0) {
            QLog.i("CameraProxy", 2, "closeCamera mCurCameraState = " + this.f198436d);
            return;
        }
        this.f198436d = 3;
        F(new Runnable() { // from class: com.tencent.mobileqq.ar.model.CameraProxy.3
            @Override // java.lang.Runnable
            public void run() {
                if (CameraProxy.this.f198436d == 3 && CameraProxy.this.f198439h != null) {
                    if (CameraProxy.this.F) {
                        CameraProxy.this.f198439h.F();
                    }
                    CameraProxy.this.F = false;
                    CameraProxy.this.f198439h.q();
                    if (CameraProxy.this.f198436d == 3) {
                        CameraProxy.this.f198436d = 0;
                        CameraProxy.this.K = null;
                        CameraProxy.this.D = 0;
                        QLog.i("CameraProxy", 2, "closeCamera successfully. mCurCameraState = " + CameraProxy.this.f198436d);
                        return;
                    }
                    QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + CameraProxy.this.f198436d);
                    return;
                }
                QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + CameraProxy.this.f198436d);
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARCamera.b
    public void r(boolean z16) {
        Iterator<WeakReference<ARCamera.b>> it = this.G.iterator();
        while (it.hasNext()) {
            WeakReference<ARCamera.b> next = it.next();
            if (next.get() != null) {
                next.get().r(z16);
            }
        }
    }

    public boolean s(float f16, boolean z16) {
        ARCamera aRCamera = this.f198439h;
        if (aRCamera != null) {
            return aRCamera.r(f16, z16);
        }
        return false;
    }

    public void t() {
        synchronized (this.J) {
            this.J.clear();
        }
        synchronized (this.H) {
            this.H.clear();
        }
        this.G.clear();
    }

    public void u() {
        ARCamera aRCamera = this.f198439h;
        if (aRCamera != null) {
            aRCamera.t();
        }
    }

    public String w() {
        String str;
        int i3 = this.L;
        if (DeviceInfoMonitor.getModel().equalsIgnoreCase("M1 E")) {
            i3 = 90;
        }
        if (this.K != null) {
            str = ((IOCR) QRoute.api(IOCR.class)).savePreviewImage(this.K, this.f198440i, this.f198441m, this.C, i3);
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CameraProxy", 2, String.format("getLastPreviewFrame, path: %s, rotation: %s", str, Integer.valueOf(i3)));
        }
        return str;
    }

    public int x() {
        return this.C;
    }

    public int y() {
        return this.f198441m;
    }

    public int z() {
        return this.f198440i;
    }
}
