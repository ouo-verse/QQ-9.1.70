package com.tencent.avcore.camera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.avcore.camera.observe.CameraObserver;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVCameraMgr implements ex.a, com.tencent.avcore.camera.callback.c {
    static IPatchRedirector $redirector_;
    private Handler C;
    private com.tencent.avcore.camera.callback.b D;
    private boolean E;
    private Handler F;
    private com.tencent.avcore.camera.observe.a G;
    private final Map<String, Integer> H;
    private b I;
    private int J;

    /* renamed from: d, reason: collision with root package name */
    private final SurfaceTexture f77365d;

    /* renamed from: e, reason: collision with root package name */
    private final NoPreviewRunnable f77366e;

    /* renamed from: f, reason: collision with root package name */
    boolean f77367f;

    /* renamed from: h, reason: collision with root package name */
    private int f77368h;

    /* renamed from: i, reason: collision with root package name */
    private Context f77369i;

    /* renamed from: m, reason: collision with root package name */
    private c f77370m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AVCameraMgr.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            long a16 = com.tencent.avcore.camera.util.c.a();
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("CameraUtils", "CameraHandlerThread, seq[" + a16 + "], event[" + message.what + "]");
            }
            switch (message.what) {
                case 1:
                    AVCameraMgr.this.E(a16, (com.tencent.avcore.camera.data.a) message.obj);
                    return;
                case 2:
                    boolean z16 = true;
                    if (message.arg1 != 1) {
                        z16 = false;
                    }
                    AVCameraMgr.this.s(a16, z16);
                    return;
                case 3:
                    com.tencent.avcore.camera.data.a aVar = (com.tencent.avcore.camera.data.a) message.obj;
                    int i16 = com.tencent.avcore.camera.b.f77379v;
                    int i17 = aVar.f77426b;
                    if (i16 != i17 || com.tencent.avcore.camera.b.f77378u != aVar.f77425a) {
                        AVCameraMgr.this.q(a16, aVar.f77425a, i17);
                    }
                    if (AVCameraMgr.this.f77370m.x() && (i3 = aVar.f77427c) != com.tencent.avcore.camera.b.f77383z && i3 > 0) {
                        AVCameraMgr.this.p(a16, i3);
                        return;
                    }
                    return;
                case 4:
                    AVCameraMgr.this.Q(a16);
                    return;
                case 5:
                    AVCameraMgr.this.p(a16, message.arg1);
                    return;
                case 6:
                    AVCameraMgr.this.q(a16, -1, -1);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AVCameraMgr.this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("camera_id");
            boolean z16 = true;
            int intExtra = intent.getIntExtra("availability", 1);
            long longExtra = intent.getLongExtra("log_seq", 0L);
            AVCameraMgr.this.H.put(stringExtra, Integer.valueOf(intExtra));
            if (intExtra == 1 && AVCameraMgr.this.f77370m != null && AVCameraMgr.this.f77370m.x()) {
                Iterator it = AVCameraMgr.this.H.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((Integer) ((Map.Entry) it.next()).getValue()).intValue() == 0) {
                        z16 = false;
                        break;
                    }
                }
                if (AVCoreLog.isLogColorOrGary()) {
                    AVCoreLog.printAllUserLog("CameraUtils", "CameraAvailabilityReceiver, sendReopenCameraMsg, result[" + z16 + "], seq[" + longExtra + "]");
                }
                if (z16) {
                    AVCameraMgr.this.F.removeMessages(6);
                    AVCameraMgr.this.F.sendEmptyMessageDelayed(6, 1000L);
                    return;
                }
                return;
            }
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("CameraUtils", "CameraAvailabilityReceiver, removeReopenCameraMsg, seq[" + intExtra + "]");
            }
            AVCameraMgr.this.F.removeMessages(6);
        }

        /* synthetic */ b(AVCameraMgr aVCameraMgr, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVCameraMgr, (Object) aVar);
        }
    }

    public AVCameraMgr(Context context, fx.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
            return;
        }
        this.f77365d = new SurfaceTexture(0);
        this.f77366e = new NoPreviewRunnable(this, null);
        this.f77367f = false;
        this.f77368h = 0;
        this.f77369i = null;
        this.f77370m = null;
        this.C = null;
        this.D = null;
        this.E = false;
        this.F = null;
        this.G = null;
        HashMap hashMap = new HashMap(2);
        this.H = hashMap;
        this.I = null;
        if (DeviceInfoMonitor.getModel().equals("HUAWEI GRA-TL00")) {
            this.E = true;
        }
        this.f77369i = context.getApplicationContext();
        c cVar = new c(this.f77369i);
        this.f77370m = cVar;
        cVar.K(aVar);
        r();
        if (this.f77368h > 0) {
            SharedPreferences sharedPreferences = this.f77369i.getSharedPreferences("cameracfg", 0);
            int i3 = sharedPreferences.getInt("frontCameraRotation", 0);
            int i16 = sharedPreferences.getInt("backCameraRotation", 0);
            this.f77370m.L(true, i3);
            this.f77370m.L(false, i16);
        }
        hashMap.put("0", 1);
        hashMap.put("1", 1);
        this.C = new Handler(Looper.getMainLooper());
        this.F = new a(com.tencent.avcore.camera.thread.b.a().getLooper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v8 */
    private SurfaceTexture A(int i3) {
        ?? r06;
        if (this.f77370m.c().isSupportSurfaceMode() && C()) {
            r06 = 1;
        } else {
            r06 = 0;
        }
        if (r06 == 1 && i3 == 1) {
            if (!com.tencent.avcore.camera.data.c.b(this.f77365d)) {
                AVCoreLog.printAllUserLog("CameraUtils", "getSurfaceTexture, frame is not deal right.");
            }
            com.tencent.avcore.camera.data.c.c(this.f77365d);
        }
        this.f77370m.N(r06, this);
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("SurfaceTag", "getSurfaceTexture, isUseSurface[" + ((boolean) r06) + "], cameraMode[" + ((int) r06) + "]");
        }
        return this.f77365d;
    }

    private SurfaceTexture B() {
        return A(1);
    }

    private boolean C() {
        if (this.J == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(long j3, com.tencent.avcore.camera.data.a aVar) {
        int i3;
        boolean z16;
        int i16;
        int i17;
        int i18;
        if (this.f77370m.x() && AVCoreLog.isColorLevel()) {
            AVCoreLog.printAllUserLog("CameraUtils", "warning repeat openCamera, mCamera[" + this.f77370m + "], seq[" + j3 + "]");
        }
        long currentTimeMillis = System.currentTimeMillis();
        AVCoreLog.printAllUserLog("CameraUtils", "openCamera begin, mCamera[" + this.f77370m + "], seq[" + j3 + "]");
        w().a(new Object[]{1, Boolean.valueOf(this.f77370m.x()), Long.valueOf(j3)});
        com.tencent.avcore.camera.callback.b bVar = this.D;
        if (bVar != null) {
            bVar.a();
        }
        int i19 = aVar.f77427c;
        if (i19 > 0 && (i17 = aVar.f77425a) > 0 && (i18 = aVar.f77426b) > 0) {
            com.tencent.avcore.camera.b.f77378u = i17;
            com.tencent.avcore.camera.b.f77379v = i18;
        } else {
            i19 = -1;
        }
        boolean D = this.f77370m.D(j3, B());
        if (D) {
            L(j3, "OpenCameraRunnable.run");
        }
        if (D && i19 != com.tencent.avcore.camera.b.f77383z && i19 > 0) {
            p(j3, i19);
        }
        if (this.D != null) {
            if (this.f77370m.b0() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (D) {
                i16 = 0;
            } else {
                i16 = -3;
            }
            i3 = this.D.c(i16, z16);
        } else {
            i3 = 0;
        }
        w().a(new Object[]{2, Boolean.valueOf(D), Integer.valueOf(i3), Long.valueOf(j3)});
        if (D) {
            F();
        }
        AVCoreLog.printAllUserLog("CameraUtils", "openCamera end. result[" + D + "], cost[" + (System.currentTimeMillis() - currentTimeMillis) + "], seq[" + j3 + "]");
    }

    private void F() {
        if (this.I == null) {
            this.I = new b(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
            this.f77369i.registerReceiver(this.I, intentFilter);
        }
    }

    private void G() {
        this.F.removeMessages(1);
        this.F.removeMessages(2);
        this.F.removeMessages(4);
        this.F.removeMessages(3);
        this.F.removeMessages(5);
        this.F.removeMessages(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i3, int i16, int i17) {
        G();
        Message obtainMessage = this.F.obtainMessage(1);
        obtainMessage.obj = new com.tencent.avcore.camera.data.a(i3, i16, i17);
        obtainMessage.sendToTarget();
    }

    private void L(long j3, String str) {
        if (AVCoreLog.isLogColorOrGary()) {
            AVCoreLog.printAllUserLog("CameraUtils", "startNoPreviewRunnable[" + str + "], seq[" + j3 + "], noPreview[" + this.f77366e.f77374d + "]");
        }
        NoPreviewRunnable noPreviewRunnable = this.f77366e;
        noPreviewRunnable.f77374d = j3;
        this.C.removeCallbacks(noPreviewRunnable);
        this.C.postDelayed(this.f77366e, 10000L);
        this.f77367f = false;
    }

    private void N(boolean z16) {
        G();
        Message obtainMessage = this.F.obtainMessage(2);
        obtainMessage.arg1 = z16 ? 1 : 0;
        obtainMessage.sendToTarget();
    }

    private void O(String str) {
        if (!this.f77367f) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("CameraUtils", "stopNoPreviewRunnable[" + str + "], noPreview[" + this.f77366e.f77374d + "]");
            }
            this.f77367f = true;
            this.C.removeCallbacks(this.f77366e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(long j3) {
        boolean z16;
        if (AVCoreLog.isLogColorOrGary()) {
            AVCoreLog.printAllUserLog("CameraUtils", "switchCamera begin, mCamera[" + this.f77370m + "], seq[" + j3 + "]");
        }
        w().a(new Object[]{5});
        c cVar = this.f77370m;
        if (cVar != null) {
            z16 = cVar.Y(j3, B());
        } else {
            z16 = false;
        }
        w().a(new Object[]{6, Boolean.valueOf(z16)});
        if (AVCoreLog.isLogColorOrGary()) {
            AVCoreLog.printAllUserLog("CameraUtils", "switchCamera end, result[" + z16 + "], mCamera[" + this.f77370m + "], seq[" + j3 + "]");
        }
    }

    private void R() {
        b bVar = this.I;
        if (bVar != null) {
            try {
                this.f77369i.unregisterReceiver(bVar);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.I = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j3, int i3) {
        if (AVCoreLog.isLogColorOrGary() || this.f77370m == null) {
            AVCoreLog.printAllUserLog("CameraUtils", "changePreviewFpsInSubThread begin, mCamera[" + this.f77370m + "], seq[" + j3 + "]");
        }
        c cVar = this.f77370m;
        if (cVar == null) {
            return;
        }
        cVar.O(j3, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j3, int i3, int i16) {
        boolean z16;
        AVCoreLog.printAllUserLog("CameraUtils", "changePreviewSizeInSubThread begin, mCamera[" + this.f77370m + "], seq[" + j3 + "]");
        c cVar = this.f77370m;
        if (cVar != null) {
            z16 = cVar.G(j3, B(), i3, i16);
        } else {
            z16 = false;
        }
        if (z16) {
            L(j3, "changePreviewSizeInSubThread");
        } else {
            O("changePreviewSizeInSubThread");
        }
        w().a(new Object[]{8, Boolean.valueOf(z16)});
    }

    private void r() {
        this.f77368h = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j3, boolean z16) {
        AVCoreLog.printAllUserLog("CameraUtils", "closeCamera begin, mCamera[" + this.f77370m + "], seq[" + j3 + "]");
        w().a(new Object[]{3, Long.valueOf(j3)});
        c cVar = this.f77370m;
        if (cVar != null) {
            cVar.a(j3);
        }
        O("CloseCameraRunnable.run");
        com.tencent.avcore.camera.callback.b bVar = this.D;
        if (bVar != null) {
            bVar.b(z16);
        }
        w().a(new Object[]{4, Boolean.TRUE, Long.valueOf(j3)});
        R();
        AVCoreLog.printAllUserLog("CameraUtils", "closeCamera end, mCamera[" + this.f77370m + "], seq[" + j3 + "]");
    }

    private com.tencent.avcore.camera.observe.a w() {
        if (this.G == null) {
            this.G = new com.tencent.avcore.camera.observe.a();
        }
        return this.G;
    }

    public void D(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.J = i3;
        }
    }

    public void H(CameraObserver cameraObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cameraObserver);
        } else if (cameraObserver != null) {
            w().deleteObserver(cameraObserver);
        }
    }

    public void I(com.tencent.avcore.camera.callback.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bVar);
        } else {
            this.D = bVar;
        }
    }

    public void J(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (DeviceInfoMonitor.getModel().equalsIgnoreCase("HWI-AL00")) {
            SharedPreferences sharedPreferences = this.f77369i.getSharedPreferences(DeviceInfoMonitor.getModel() + "_SP_QAV_CAMERA_OPENED", 4);
            boolean z16 = sharedPreferences.getBoolean("KEY_OPENED", false);
            AVCoreLog.printAllUserLog("CameraUtils", "AVTest. openCamera. hasOpened = " + z16);
            if (!z16) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("KEY_OPENED", true);
                edit.commit();
                this.C.postDelayed(new Runnable(i3, i16, i17) { // from class: com.tencent.avcore.camera.AVCameraMgr.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f77371d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f77372e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f77373f;

                    {
                        this.f77371d = i3;
                        this.f77372e = i16;
                        this.f77373f = i17;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AVCameraMgr.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            AVCameraMgr.this.K(this.f77371d, this.f77372e, this.f77373f);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                }, 1000L);
                return;
            }
            K(i3, i16, i17);
            return;
        }
        K(i3, i16, i17);
    }

    public void M(boolean z16) {
        String str;
        Throwable th5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (this.f77370m != null) {
            str = this.f77370m.x() + "";
        } else {
            str = "null";
        }
        if (AVCoreLog.isColorLevel()) {
            th5 = new Throwable();
        } else {
            th5 = null;
        }
        AVCoreLog.e("CameraUtils", "closeCamera, extraInfo[" + z16 + "], isCameraOpened[" + str + "]", th5);
        c cVar = this.f77370m;
        if (cVar != null && cVar.x()) {
            N(z16);
        }
    }

    public void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            if (!this.f77370m.x()) {
                return;
            }
            G();
            this.F.obtainMessage(4).sendToTarget();
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        try {
            O("finalize");
            this.D = null;
        } finally {
            super.finalize();
        }
    }

    public void n(CameraObserver cameraObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cameraObserver);
        } else if (cameraObserver != null) {
            w().addObserver(cameraObserver);
        }
    }

    public void o(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        G();
        Message obtainMessage = this.F.obtainMessage(3);
        obtainMessage.obj = new com.tencent.avcore.camera.data.a(i3, i16, i17);
        obtainMessage.sendToTarget();
    }

    @Override // com.tencent.avcore.camera.callback.c
    public void onPreviewData(com.tencent.avcore.camera.data.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) cVar);
            return;
        }
        com.tencent.avcore.camera.callback.b bVar = this.D;
        if (bVar != null) {
            O("onPreviewData_" + cVar.f77450j);
            if (this.E) {
                L(-1019L, "onPreviewData_" + cVar.f77450j);
            }
            bVar.onPreviewData(cVar);
            return;
        }
        cVar.l();
    }

    public void rotateCamera() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        c cVar = this.f77370m;
        if (cVar != null && (i3 = this.f77368h) > 0) {
            if (i3 != 1 && cVar.z()) {
                this.f77370m.L(true, this.f77370m.w(true) + 90);
            } else {
                this.f77370m.L(false, this.f77370m.w(false) + 90);
            }
        }
    }

    public void saveCameraAngle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        SharedPreferences.Editor edit = this.f77369i.getSharedPreferences("cameracfg", 0).edit();
        int w3 = this.f77370m.w(true);
        int w16 = this.f77370m.w(false);
        edit.putInt("frontCameraRotation", w3);
        edit.putInt("backCameraRotation", w16);
        edit.commit();
    }

    public void setRotation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        c cVar = this.f77370m;
        if (cVar != null) {
            cVar.R(i3);
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Handler handler = this.F;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.F = null;
        }
        c cVar = this.f77370m;
        if (cVar != null) {
            cVar.H();
            this.f77370m = null;
        }
        O("dispose");
        this.D = null;
    }

    public void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        c cVar = this.f77370m;
        if (cVar != null) {
            cVar.X(z16);
        }
    }

    public void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        c cVar = this.f77370m;
        if (cVar != null) {
            cVar.W(z16);
        }
    }

    public Camera.Parameters x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Camera.Parameters) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        c cVar = this.f77370m;
        if (cVar == null) {
            return null;
        }
        return cVar.i();
    }

    public com.tencent.avcore.camera.data.b y() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.avcore.camera.data.b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        com.tencent.avcore.camera.data.b bVar = new com.tencent.avcore.camera.data.b();
        bVar.f77433f = com.tencent.avcore.camera.b.f77379v;
        bVar.f77432e = com.tencent.avcore.camera.b.f77378u;
        c cVar = this.f77370m;
        boolean z18 = true;
        if (cVar != null && cVar.z()) {
            z16 = true;
        } else {
            z16 = false;
        }
        bVar.f77428a = z16;
        bVar.f77431d = this.f77368h;
        c cVar2 = this.f77370m;
        if (cVar2 != null && cVar2.x()) {
            z17 = true;
        } else {
            z17 = false;
        }
        bVar.f77429b = z17;
        c cVar3 = this.f77370m;
        if (cVar3 == null || !cVar3.y()) {
            z18 = false;
        }
        bVar.f77430c = z18;
        return bVar;
    }

    public SurfaceTexture z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (SurfaceTexture) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        SurfaceTexture A = A(2);
        int h16 = this.f77370m.h();
        if (h16 != 1) {
            A = null;
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("SurfaceTag", "getSurfaceTextureForRender, cameraMode[" + h16 + "], surfaceTexture[" + A + "]");
        }
        return A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class NoPreviewRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public long f77374d;

        NoPreviewRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f77374d = 0L;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AVCameraMgr.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (AVCameraMgr.this.f77370m != null) {
                z16 = AVCameraMgr.this.f77370m.x();
            } else {
                z16 = false;
            }
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("CameraUtils", "NoPreviewRunnable.run, seq[" + this.f77374d + "], isCameraOpened[" + z16 + "], seq[" + this.f77374d + "]");
            }
            if (AVCameraMgr.this.D != null) {
                AVCameraMgr.this.D.c(-1, false);
            }
        }

        /* synthetic */ NoPreviewRunnable(AVCameraMgr aVCameraMgr, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVCameraMgr, (Object) aVar);
        }
    }
}
