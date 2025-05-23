package com.tencent.avcore.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.avcore.camera.callback.e;
import com.tencent.avcore.camera.data.d;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;
    protected static boolean A;
    protected static d B;

    /* renamed from: t, reason: collision with root package name */
    private static volatile boolean f77377t;

    /* renamed from: u, reason: collision with root package name */
    public static int f77378u;

    /* renamed from: v, reason: collision with root package name */
    public static int f77379v;

    /* renamed from: w, reason: collision with root package name */
    public static int f77380w;

    /* renamed from: x, reason: collision with root package name */
    protected static boolean f77381x;

    /* renamed from: y, reason: collision with root package name */
    public static int f77382y;

    /* renamed from: z, reason: collision with root package name */
    public static int f77383z;

    /* renamed from: a, reason: collision with root package name */
    Context f77384a;

    /* renamed from: b, reason: collision with root package name */
    Camera f77385b;

    /* renamed from: c, reason: collision with root package name */
    int f77386c;

    /* renamed from: d, reason: collision with root package name */
    int f77387d;

    /* renamed from: e, reason: collision with root package name */
    int f77388e;

    /* renamed from: f, reason: collision with root package name */
    String f77389f;

    /* renamed from: g, reason: collision with root package name */
    String f77390g;

    /* renamed from: h, reason: collision with root package name */
    Display f77391h;

    /* renamed from: i, reason: collision with root package name */
    int f77392i;

    /* renamed from: j, reason: collision with root package name */
    int f77393j;

    /* renamed from: k, reason: collision with root package name */
    int f77394k;

    /* renamed from: l, reason: collision with root package name */
    int f77395l;

    /* renamed from: m, reason: collision with root package name */
    int f77396m;

    /* renamed from: n, reason: collision with root package name */
    boolean f77397n;

    /* renamed from: o, reason: collision with root package name */
    boolean f77398o;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.avcore.camera.callback.a f77399p;

    /* renamed from: q, reason: collision with root package name */
    private int f77400q;

    /* renamed from: r, reason: collision with root package name */
    protected fx.a f77401r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f77402s;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13018);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 46)) {
            redirector.redirect((short) 46);
            return;
        }
        f77377t = true;
        f77378u = 1280;
        f77379v = 720;
        f77380w = 17;
        f77381x = false;
        f77383z = 15000;
        A = false;
        B = new d();
    }

    public b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f77385b = null;
        this.f77386c = 0;
        this.f77387d = 0;
        this.f77393j = 0;
        this.f77394k = 0;
        this.f77395l = 0;
        this.f77396m = 0;
        this.f77397n = false;
        this.f77398o = false;
        this.f77399p = null;
        this.f77400q = 0;
        this.f77402s = false;
        this.f77384a = context;
        this.f77391h = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.f77388e = Build.VERSION.SDK_INT;
        this.f77389f = DeviceInfoMonitor.getModel();
        this.f77390g = Build.MANUFACTURER;
        d dVar = B;
        dVar.f77461b = -1;
        dVar.f77462c = -1;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.printAllUserLog("AndroidCamera", "AndroidCamera, Device_Tag[" + this.f77390g + MsgSummary.STR_COLON + this.f77389f + "], Rom_Tag[" + Build.VERSION.INCREMENTAL + "]");
        }
    }

    public static synchronized void I(String str, long j3, int i3, int i16) {
        synchronized (b.class) {
            if (f77378u != i3 || f77379v != i16 || AVCoreLog.isDevelopLevel()) {
                AVCoreLog.printAllUserLog("AndroidCamera", "resetPreViewSize, from[" + str + "], src[" + f77378u + HippyTKDListViewAdapter.X + f77379v + "], final[" + i3 + HippyTKDListViewAdapter.X + i16 + "], seq[" + j3 + "]");
            }
            f77378u = i3;
            f77379v = i16;
        }
    }

    private void J() {
        if (this.f77390g.equalsIgnoreCase("meizu") && this.f77389f.equalsIgnoreCase("meizu_m9")) {
            f77380w = 18;
        } else if (this.f77390g.equalsIgnoreCase("ZTE") && this.f77389f.equalsIgnoreCase("ZTE-T U880")) {
            f77380w = 100;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00fc, code lost:
    
        if (r4.contains(104) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int S(long j3, Camera.Parameters parameters) {
        int i3 = 0;
        try {
            List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats != null) {
                if (AVCoreLog.isLogColorOrGary()) {
                    StringBuilder sb5 = new StringBuilder("setPreviewFormat[");
                    for (int i16 = 0; i16 < supportedPreviewFormats.size(); i16++) {
                        sb5.append(supportedPreviewFormats.get(i16));
                        sb5.append(";");
                    }
                    sb5.append("]");
                    AVCoreLog.printAllUserLog("AndroidCamera", sb5.toString());
                }
                if (!supportedPreviewFormats.contains(17)) {
                    int i17 = 16;
                    if (!supportedPreviewFormats.contains(16)) {
                        int i18 = 20;
                        if (!supportedPreviewFormats.contains(20)) {
                            i18 = IjkMediaPlayer.SDL_FCC_YV12;
                            if (!supportedPreviewFormats.contains(Integer.valueOf(IjkMediaPlayer.SDL_FCC_YV12))) {
                                i18 = 4;
                                if (!supportedPreviewFormats.contains(4)) {
                                    if (!supportedPreviewFormats.contains(17)) {
                                        if (!supportedPreviewFormats.contains(16)) {
                                            i17 = 3;
                                            if (!supportedPreviewFormats.contains(3)) {
                                                i17 = 2;
                                                if (!supportedPreviewFormats.contains(2)) {
                                                    if (!supportedPreviewFormats.contains(4)) {
                                                        i17 = 100;
                                                        if (!supportedPreviewFormats.contains(100)) {
                                                            i17 = 101;
                                                            if (!supportedPreviewFormats.contains(101)) {
                                                                i17 = 102;
                                                                if (!supportedPreviewFormats.contains(102)) {
                                                                    i17 = 103;
                                                                    if (!supportedPreviewFormats.contains(103)) {
                                                                        i17 = 104;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i3 = i18;
                    }
                    i3 = i17;
                }
                i3 = 17;
            }
        } catch (Exception unused) {
        }
        if (i3 != 0) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("AndroidCamera", "setPreviewFormat, supportFormat[" + i3 + "], seq[" + j3 + "]");
            }
            parameters.setPreviewFormat(i3);
            return i3;
        }
        if (AVCoreLog.isLogColorOrGary()) {
            AVCoreLog.printAllUserLog("AndroidCamera", "setPreviewFormat, default supportFormat[17], seq[" + j3 + "]");
        }
        parameters.setPreviewFormat(17);
        return 17;
    }

    private void T(long j3, Camera.Parameters parameters, int i3, int i16) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        f77383z = i16;
        if (supportedPreviewFpsRange != null && supportedPreviewFpsRange.size() > 0) {
            int[] iArr = supportedPreviewFpsRange.get(0);
            int i17 = Integer.MAX_VALUE;
            for (int[] iArr2 : supportedPreviewFpsRange) {
                if (AVCoreLog.isLogColorOrGary()) {
                    AVCoreLog.printAllUserLog("AndroidCamera", "setPreviewRate2, Range[" + iArr2[0] + "->" + iArr2[1] + "], seq[" + j3 + "]");
                }
                int abs = Math.abs(iArr2[0] - f77383z) + Math.abs(iArr2[1] - f77383z);
                if (i17 > abs) {
                    iArr = iArr2;
                    i17 = abs;
                }
            }
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("AndroidCamera", "setPreviewRate2, Range[" + iArr[0] + "->" + iArr[1] + "], supportFormat[" + i3 + "], newFps[" + i16 + "], seq[" + j3 + "]");
            }
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    @TargetApi(9)
    private void U(Camera.Parameters parameters, int i3) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange != null && supportedPreviewFpsRange.size() > 0) {
            int[] iArr = supportedPreviewFpsRange.get(0);
            int i16 = Integer.MAX_VALUE;
            for (int[] iArr2 : supportedPreviewFpsRange) {
                if (AVCoreLog.isLogColorOrGary()) {
                    AVCoreLog.printAllUserLog("AndroidCamera", "setPreviewRate1, Range[" + iArr2[0] + "->" + iArr2[1] + "]");
                }
                int abs = Math.abs(iArr2[0] - f77383z) + Math.abs(iArr2[1] - f77383z);
                if (i16 > abs) {
                    iArr = iArr2;
                    i16 = abs;
                }
            }
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("AndroidCamera", "setPreviewRate1, Range[" + iArr[0] + "->" + iArr[1] + "], supportFormat[" + i3 + "]");
            }
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    private void V(long j3, int i3, int i16, Camera.Parameters parameters) {
        Camera.Size q16;
        int i17 = f77378u;
        int i18 = f77379v;
        try {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null && (q16 = q(supportedPreviewSizes, i3, i16)) != null) {
                I("setPreviewSize_support", j3, q16.width, q16.height);
            }
        } catch (Exception unused) {
        }
        if ((this.f77390g.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && this.f77389f.equalsIgnoreCase("GT-I9003")) || ((this.f77390g.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && this.f77389f.equalsIgnoreCase("GT-I9220")) || (this.f77390g.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && this.f77389f.equalsIgnoreCase("GT-I7000")))) {
            I("setPreviewSize_hardcode", j3, 320, 240);
        }
        if (Z()) {
            I("setPreviewSize_hardcode", j3, 1280, 720);
        }
        if (AVCoreLog.isLogColorOrGary()) {
            AVCoreLog.printAllUserLog("AndroidCamera", "setPreviewSize, in[" + i3 + HippyTKDListViewAdapter.X + i16 + "], before[" + i17 + HippyTKDListViewAdapter.X + i18 + "], final[" + f77378u + HippyTKDListViewAdapter.X + f77379v + "], seq[" + j3 + "]");
        }
        parameters.setPreviewSize(f77378u, f77379v);
    }

    private boolean Z() {
        return this.f77401r.g();
    }

    private void b() {
        this.f77392i = 0;
        try {
            if (this.f77387d == 0) {
                this.f77387d = p();
            }
            if (this.f77387d > 0) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                for (int i3 = 0; i3 < this.f77387d; i3++) {
                    Camera.getCameraInfo(i3, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        try {
                            this.f77392i = i3;
                        } catch (RuntimeException e16) {
                            this.f77392i = 0;
                            if (AVCoreLog.isLogColorOrGary()) {
                                AVCoreLog.e("AndroidCamera", "findBackCameraId, RuntimeException", e16);
                            }
                        }
                    }
                }
            }
        } catch (Exception e17) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e("AndroidCamera", "findBackCameraId, Exception", e17);
            }
        }
    }

    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f77398o;
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return this.f77402s;
    }

    protected boolean C(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, j3)).booleanValue();
        }
        boolean z16 = f77381x;
        try {
            A = true;
            this.f77385b = CameraMonitor.open();
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("AndroidCamera", "openBackCamera, camera[" + this.f77385b + "], seq[" + j3 + "]");
            }
        } catch (Exception e16) {
            f77381x = false;
            Camera camera2 = this.f77385b;
            if (camera2 != null) {
                camera2.release();
                this.f77385b = null;
                AVCoreLog.printAllUserLog("AndroidCamera", "openBackCamera Exception, set camera null, seq[" + j3 + "]");
            }
            AVCoreLog.e("AndroidCamera", "openBackCamera Exception, srcIsCameraOpened[" + z16 + "], seq[" + j3 + "]", e16);
        }
        if (this.f77385b != null) {
            this.f77386c = 2;
            f77381x = true;
            A = false;
            b();
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("AndroidCamera", "openBackCamera, success, seq[" + j3 + "]");
            }
            return true;
        }
        A = false;
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0114 A[Catch: all -> 0x0200, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:7:0x0010, B:11:0x0029, B:14:0x01b1, B:16:0x01e9, B:19:0x01f4, B:20:0x0070, B:22:0x0074, B:24:0x0095, B:26:0x0099, B:28:0x009f, B:30:0x00a5, B:31:0x00c4, B:33:0x00c8, B:34:0x00e7, B:37:0x0114, B:40:0x0119, B:42:0x011d, B:44:0x0122, B:45:0x0127, B:48:0x012f, B:51:0x0143, B:54:0x016b, B:55:0x018e, B:58:0x0170, B:64:0x00f4, B:66:0x00fa, B:67:0x0102, B:69:0x0108), top: B:2:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean D(long j3, SurfaceTexture surfaceTexture) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, this, Long.valueOf(j3), surfaceTexture)).booleanValue();
        }
        AVCoreLog.printAllUserLog("AndroidCamera", "openCamera begin, Camera[" + toString() + "], PreViewSize[" + f77378u + HippyTKDListViewAdapter.X + f77379v + "], seq[" + j3 + "]");
        if (!f77381x) {
            if (this.f77384a == null) {
                AVCoreLog.printAllUserLog("AndroidCamera", "openCamera, context\u4e3a\u7a7a, seq[" + j3 + "]");
            } else {
                int i3 = this.f77386c;
                if (i3 == 0) {
                    if (!E(j3) && !C(j3)) {
                        AVCoreLog.printAllUserLog("AndroidCamera", "openCamera failed, seq[" + j3 + "]");
                    } else if (this.f77385b == null) {
                        AVCoreLog.printAllUserLog("AndroidCamera", "openCamera camera\u4e3a\u7a7a,setPreviewSize seq[" + j3 + "]");
                    } else {
                        P(j3, f77378u, f77379v);
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2 && C(j3)) {
                            P(j3, f77378u, f77379v);
                        }
                        z16 = false;
                    } else {
                        if (E(j3)) {
                            P(j3, f77378u, f77379v);
                        }
                        z16 = false;
                    }
                    if (z16) {
                        this.f77386c = 0;
                        z17 = z16;
                    } else {
                        try {
                            com.tencent.avcore.camera.callback.a aVar = this.f77399p;
                            if (aVar != null) {
                                aVar.f(j3, surfaceTexture);
                            }
                            if (surfaceTexture != null) {
                                this.f77385b.setPreviewTexture(surfaceTexture);
                            }
                            this.f77385b.startPreview();
                        } catch (Exception e16) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("setPreviewDisplay Exception, camera[");
                            if (this.f77385b == null) {
                                z17 = false;
                            }
                            sb5.append(z17);
                            sb5.append("], isCameraOpened[");
                            sb5.append(f77381x);
                            sb5.append("], seq[");
                            sb5.append(j3);
                            sb5.append("]");
                            AVCoreLog.e("AndroidCamera", sb5.toString(), e16);
                            Camera camera2 = this.f77385b;
                            if (camera2 != null) {
                                try {
                                    camera2.release();
                                } catch (Exception e17) {
                                    AVCoreLog.e("AndroidCamera", "setPreviewDisplay camera.release Exception seq[" + j3 + "]", e17);
                                }
                                this.f77385b = null;
                                AVCoreLog.printAllUserLog("AndroidCamera", "setPreviewDisplay fail, set camera null, seq[" + j3 + "]");
                            }
                        }
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
            z17 = false;
        }
        f77381x = z17;
        AVCoreLog.printAllUserLog("AndroidCamera", "openCamera end, result[" + z17 + "], Camera[" + toString() + "], seq[" + j3 + "]");
        if (z17) {
            this.f77401r.l(this.f77384a, "openCamera");
        } else {
            this.f77401r.d(this.f77384a, "openCamera");
        }
        return z17;
    }

    protected boolean E(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, j3)).booleanValue();
        }
        A = true;
        Camera m3 = m(j3);
        this.f77385b = m3;
        if (m3 == null) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("AndroidCamera", "openFrontCamera, fail, seq[" + j3 + "]");
            }
            f77381x = false;
            A = false;
            return false;
        }
        if (this.f77387d == 0) {
            this.f77387d = 2;
        }
        this.f77386c = 1;
        f77381x = true;
        A = false;
        if (AVCoreLog.isLogColorOrGary()) {
            AVCoreLog.printAllUserLog("AndroidCamera", "openFrontCamera, success, seq[" + j3 + "]");
        }
        return true;
    }

    protected Camera F(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Camera) iPatchRedirector.redirect((short) 16, (Object) this, j3);
        }
        this.f77392i = 0;
        Camera camera2 = null;
        try {
            if (this.f77387d == 0) {
                this.f77387d = p();
            }
            if (this.f77387d > 0) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                for (int i3 = 0; i3 < this.f77387d; i3++) {
                    Camera.getCameraInfo(i3, cameraInfo);
                    int i16 = cameraInfo.facing;
                    if (AVCoreLog.isLogColorOrGary()) {
                        AVCoreLog.printAllUserLog("AndroidCamera", "openFrontFacingCamera, camIdx[" + i3 + "], facing[" + i16 + "], seq[" + j3 + "]");
                    }
                    if (i16 == 1) {
                        try {
                            Camera open = CameraMonitor.open(i3);
                            try {
                                this.f77392i = i3;
                                if (AVCoreLog.isLogColorOrGary()) {
                                    AVCoreLog.printAllUserLog("AndroidCamera", "openFrontFacingCamera, c[" + open + "], mCameraId[" + this.f77392i + "], mCameraNum[" + this.f77387d + "], seq[" + j3 + "]");
                                }
                                return open;
                            } catch (Exception e16) {
                                e = e16;
                                camera2 = open;
                                AVCoreLog.e("AndroidCamera", "openFrontFacingCamera, Exception, seq[" + j3 + "]", e);
                                return camera2;
                            }
                        } catch (RuntimeException e17) {
                            this.f77392i = 0;
                            AVCoreLog.e("AndroidCamera", "openFrontFacingCamera, RuntimeException, seq[" + j3 + "]", e17);
                        }
                    }
                }
                return null;
            }
            if (!AVCoreLog.isLogColorOrGary()) {
                return null;
            }
            AVCoreLog.printAllUserLog("AndroidCamera", "openFrontFacingCamera, fail, mCameraNum[" + this.f77387d + "], seq[" + j3 + "]");
            return null;
        } catch (Exception e18) {
            e = e18;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x010c, code lost:
    
        r6.f77401r.l(r6.f77384a, "reopenCamera");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean G(long j3, SurfaceTexture surfaceTexture, int i3, int i16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, this, Long.valueOf(j3), surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (this.f77387d >= 1 && this.f77385b != null) {
            AVCoreLog.printAllUserLog("AndroidCamera", "reopenCamera, size[" + f77378u + ", " + f77379v + "], mCurCamera[" + this.f77386c + "], isCameraOpened[" + f77381x + "], sizeFromParameter[" + i3 + ", " + i16 + "], seq[" + j3 + "]");
            if (i3 == -1 || i16 == -1) {
                i3 = f77378u;
                i16 = f77379v;
            }
            a(j3);
            int i17 = this.f77386c;
            if (i17 != 1) {
                if (i17 == 2 && C(j3)) {
                    P(j3, i3, i16);
                    z16 = true;
                }
                z16 = false;
            } else {
                if (E(j3)) {
                    P(j3, i3, i16);
                    z16 = true;
                }
                z16 = false;
            }
            if (!z16) {
                z17 = z16;
            } else {
                I("reopenCamera", j3, i3, i16);
                try {
                    com.tencent.avcore.camera.callback.a aVar = this.f77399p;
                    if (aVar != null) {
                        aVar.f(j3, surfaceTexture);
                    }
                    if (surfaceTexture != null) {
                        this.f77385b.setPreviewTexture(surfaceTexture);
                    }
                    this.f77385b.startPreview();
                    z17 = true;
                } catch (Exception e16) {
                    if (AVCoreLog.isLogColorOrGary()) {
                        AVCoreLog.e("AndroidCamera", "reopenCamera, Exception, seq[" + j3 + "]", e16);
                    }
                }
            }
        }
        this.f77401r.d(this.f77384a, "reopenCamera");
        return z17;
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
            return;
        }
        AVCoreLog.printAllUserLog("AndroidCamera", "resetCamera, mCurCamera[" + this.f77386c + "->0]");
        this.f77386c = 0;
    }

    public void K(fx.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        this.f77401r = aVar;
        this.f77397n = aVar.c(this.f77384a);
        this.f77398o = this.f77401r.j();
    }

    public void L(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (z16) {
            this.f77395l = i3 % 360;
        } else {
            this.f77396m = i3 % 360;
        }
        AVCoreLog.printColorLog("AndroidCamera", "mFrontCameraAngle: " + this.f77395l + ", mBackCameraAngle: " + this.f77396m);
    }

    protected boolean M(long j3, int i3, Camera camera2) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, Long.valueOf(j3), Integer.valueOf(i3), camera2)).booleanValue();
        }
        d f16 = f(i3, camera2);
        this.f77394k = v();
        this.f77393j = u();
        int g16 = g();
        int o16 = o();
        if (f16.f77460a == 1) {
            i16 = (360 - ((f16.f77461b + f16.f77462c) % 360)) % 360;
        } else {
            i16 = ((f16.f77461b - f16.f77462c) + 360) % 360;
        }
        int t16 = t(this.f77402s);
        int s16 = s(this.f77402s);
        if (f16.f77460a == 1) {
            i17 = (i16 + t16) % 360;
        } else {
            i17 = (i16 + s16) % 360;
        }
        AVCoreLog.printAllUserLog("AndroidCamera", "setCameraDisplayOrientation, cameraId[" + i3 + "], orientation[" + B.f77461b + "->" + f16.f77461b + "], rotation[" + B.f77462c + "->" + f16.f77462c + "], mCompenSateSendAngle[" + this.f77394k + "], mCompenSateRecvAngle[" + this.f77393j + "], mSupportLandscape[" + this.f77402s + "], previewAngleForFrontCamera[" + t16 + "], previewAngleForBackCamera[" + s16 + "], cameraImageOrientation[" + g16 + "], mobileRotation[" + o16 + "], result[" + i17 + "], cameraMode[" + this.f77400q + "], seq[" + j3 + "]");
        Q(camera2, i17);
        d dVar = B;
        dVar.f77460a = f16.f77460a;
        dVar.f77461b = f16.f77461b;
        return true;
    }

    public void N(int i3, com.tencent.avcore.camera.callback.c cVar) {
        boolean z16;
        com.tencent.avcore.camera.callback.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) cVar);
            return;
        }
        if (this.f77400q != i3) {
            this.f77400q = i3;
            z16 = true;
        } else {
            z16 = false;
        }
        int i16 = this.f77400q;
        if (i16 == 0) {
            if (this.f77399p == null || z16) {
                this.f77399p = new com.tencent.avcore.camera.callback.d(this, cVar);
            }
        } else if (i16 == 1 && ((aVar = this.f77399p) == null || z16)) {
            if (aVar != null) {
                aVar.e();
            }
            this.f77399p = new e(this, cVar);
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.printAllUserLog("SurfaceTag", "setCameraMode, mode[" + i3 + "]");
        }
    }

    public void O(long j3, int i3) throws RuntimeException {
        Camera.Parameters parameters;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (this.f77385b == null) {
            return;
        }
        synchronized (B) {
            M(j3, this.f77392i, this.f77385b);
        }
        try {
            parameters = this.f77385b.getParameters();
        } catch (Exception e16) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e("AndroidCamera", "setCameraParaFPS, Exception", e16);
            }
            parameters = null;
        }
        if (parameters == null) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("AndroidCamera", "setCameraParaFPS, parameters\u4e3a\u7a7a");
                return;
            }
            return;
        }
        int S = S(j3, parameters);
        T(j3, parameters, S, i3);
        parameters.set("Rotation", 180);
        try {
            this.f77385b.setParameters(parameters);
        } catch (Exception unused) {
        }
        Camera.Size previewSize = parameters.getPreviewSize();
        int previewFormat = parameters.getPreviewFormat();
        if (previewSize != null) {
            I("setCameraParaFPS", j3, previewSize.width, previewSize.height);
        } else {
            AVCoreLog.printAllUserLog("AndroidCamera", "setCameraParaFPS, getPreviewSize fail, size[" + parameters.get("preview-size") + "]");
        }
        f77380w = previewFormat;
        int[] iArr = new int[2];
        parameters.getPreviewFpsRange(iArr);
        f77382y = ((iArr[0] + iArr[1]) / 2) / 1000;
        J();
        if (AVCoreLog.isLogColorOrGary() || previewSize == null) {
            AVCoreLog.printAllUserLog("AndroidCamera", "setCameraParaFPS, width[" + f77378u + "], height[" + f77379v + "], nInFPS[" + f77382y + "], fpsRange[" + iArr[0] + "|" + iArr[1] + "], videoFormat[" + f77380w + "], supportFormat[" + S + "], seq[" + j3 + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(9)
    public void P(long j3, int i3, int i16) throws RuntimeException {
        Camera.Parameters parameters;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.f77385b == null) {
            return;
        }
        synchronized (B) {
            M(j3, this.f77392i, this.f77385b);
        }
        try {
            parameters = this.f77385b.getParameters();
        } catch (Exception e16) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e("AndroidCamera", "setCameraPara, Exception", e16);
            }
            parameters = null;
        }
        if (parameters == null) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("AndroidCamera", "setCameraPara, parameters\u4e3a\u7a7a");
                return;
            }
            return;
        }
        U(parameters, S(j3, parameters));
        V(j3, i3, i16, parameters);
        try {
            parameters.setRotation(180);
        } catch (Exception unused) {
            parameters.set("Rotation", 180);
        }
        try {
            this.f77385b.setParameters(parameters);
        } catch (Exception unused2) {
        }
        Camera.Size previewSize = parameters.getPreviewSize();
        int previewFormat = parameters.getPreviewFormat();
        I("setCameraPara", j3, previewSize.width, previewSize.height);
        f77380w = previewFormat;
        int[] iArr = new int[2];
        parameters.getPreviewFpsRange(iArr);
        f77382y = ((iArr[0] + iArr[1]) / 2) / 1000;
        J();
        AVCoreLog.printAllUserLog("AndroidCamera", "setCameraPara, size[" + f77378u + HippyTKDListViewAdapter.X + f77379v + "], src[" + i3 + HippyTKDListViewAdapter.X + i16 + "], nInFPS[" + f77382y + "], fpsRange[" + iArr[0] + "~" + iArr[1] + "], videoFormat[" + f77380w + "], seq[" + j3 + "]");
    }

    protected void Q(Camera camera2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) camera2, i3);
            return;
        }
        try {
            camera2.setDisplayOrientation(i3);
        } catch (Exception e16) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e("AndroidCamera", "setDisplayOrientation, Exception", e16);
            }
        }
    }

    public void R(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
            return;
        }
        d dVar = B;
        int i16 = dVar.f77462c;
        int i17 = (i3 + this.f77394k) % 360;
        dVar.f77462c = i17;
        if (i16 != i17) {
            AVCoreLog.printAllUserLog("AndroidCamera", "setMobileRotation, rotation[" + i16 + "->" + B.f77462c + "], mCompenSateSendAngle[" + this.f77394k + "]");
        }
    }

    public void W(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            f77377t = z16;
        }
    }

    public void X(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, z16);
        } else {
            this.f77402s = z16;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c1, code lost:
    
        r6.f77401r.l(r6.f77384a, "switchCamera");
     */
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean Y(long j3, SurfaceTexture surfaceTexture) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, this, Long.valueOf(j3), surfaceTexture)).booleanValue();
        }
        if (this.f77387d >= 1 && this.f77385b != null) {
            AVCoreLog.printAllUserLog("AndroidCamera", "switchCamera, mCurCamera[" + this.f77386c + "], seq[" + j3 + "]");
            a(j3);
            int i3 = this.f77386c;
            if (i3 != 1) {
                if (i3 == 2 && E(j3)) {
                    P(j3, f77378u, f77379v);
                    z16 = true;
                }
                z16 = false;
            } else {
                if (C(j3)) {
                    P(j3, f77378u, f77379v);
                    z16 = true;
                }
                z16 = false;
            }
            if (!z16) {
                z17 = z16;
            } else {
                try {
                    com.tencent.avcore.camera.callback.a aVar = this.f77399p;
                    if (aVar != null) {
                        aVar.f(j3, surfaceTexture);
                    }
                    this.f77385b.setPreviewTexture(surfaceTexture);
                    this.f77385b.startPreview();
                    z17 = true;
                } catch (Exception unused) {
                    if (AVCoreLog.isLogColorOrGary()) {
                        AVCoreLog.printAllUserLog("AndroidCamera", "switchCamera, Exception, seq[" + j3 + "]");
                    }
                }
            }
        }
        this.f77401r.d(this.f77384a, "switchCamera");
        return z17;
    }

    public synchronized boolean a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, j3)).booleanValue();
        }
        AVCoreLog.printAllUserLog("AndroidCamera", "closeCamera begin, camera[" + toString() + "], seq[" + j3 + "]");
        try {
            Camera camera2 = this.f77385b;
            if (camera2 != null) {
                if (f77381x) {
                    camera2.setPreviewCallbackWithBuffer(null);
                    this.f77385b.stopPreview();
                    this.f77385b.release();
                }
                com.tencent.avcore.camera.callback.a aVar = this.f77399p;
                if (aVar != null) {
                    aVar.e();
                }
                this.f77385b = null;
                AVCoreLog.printAllUserLog("AndroidCamera", "closeCamera, set camera null, seq[" + j3 + "]");
            }
        } catch (Exception e16) {
            AVCoreLog.e("AndroidCamera", "closeCamera, Exception, seq[" + j3 + "]", e16);
        }
        f77381x = false;
        AVCoreLog.printAllUserLog("AndroidCamera", "closeCamera end, camera[" + toString() + "], seq[" + j3 + "]");
        this.f77401r.d(this.f77384a, "closeCamera");
        return true;
    }

    public fx.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (fx.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f77401r;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f77396m;
    }

    public Camera e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Camera) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.f77385b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d f(int i3, Camera camera2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (d) iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) camera2);
        }
        d dVar = new d();
        try {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i3, cameraInfo);
            dVar.f77460a = cameraInfo.facing;
            dVar.f77461b = cameraInfo.orientation;
            if (this.f77391h == null) {
                dVar.f77462c = -1;
                return dVar;
            }
            int l3 = l();
            if (l3 != 0) {
                if (l3 != 1) {
                    if (l3 != 2) {
                        if (l3 == 3) {
                            dVar.f77462c = 270;
                        }
                    } else {
                        dVar.f77462c = 180;
                    }
                } else {
                    dVar.f77462c = 90;
                }
            } else {
                dVar.f77462c = 0;
            }
            return dVar;
        } catch (Exception unused) {
            dVar.f77462c = 0;
            return dVar;
        }
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        int i3 = B.f77461b;
        if (i3 == -1) {
            int i16 = this.f77386c;
            if (i16 == 1) {
                return 270;
            }
            if (i16 == 2) {
                return 90;
            }
            return i3;
        }
        return i3;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f77400q;
    }

    public Camera.Parameters i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Camera.Parameters) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        try {
            return this.f77385b.getParameters();
        } catch (Exception e16) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.e("AndroidCamera", "getCameraParams, Exception", e16);
                return null;
            }
            return null;
        }
    }

    public Context j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Context) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f77384a;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f77386c;
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        if (f77377t) {
            return 0;
        }
        try {
            return this.f77391h.getRotation();
        } catch (Exception e16) {
            AVCoreLog.e("AndroidCamera", "getDisplayRotation Exception", e16);
            return 0;
        }
    }

    protected Camera m(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Camera) iPatchRedirector.redirect((short) 13, (Object) this, j3);
        }
        return F(j3);
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f77395l;
    }

    public int o() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        if (!this.f77401r.k(this.f77384a) && (i3 = B.f77462c) != -1) {
            return i3;
        }
        return 0;
    }

    protected int p() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        if (!this.f77401r.m()) {
            if (AVCoreLog.isLogColorOrGary()) {
                AVCoreLog.printAllUserLog("AndroidCamera", "getNumberOfCamera, hardcode[" + this.f77401r.b() + "]");
            }
            return this.f77401r.b();
        }
        try {
            i3 = Camera.getNumberOfCameras();
            try {
                if (AVCoreLog.isLogColorOrGary()) {
                    AVCoreLog.printAllUserLog("AndroidCamera", "getNumberOfCamera, count[" + i3 + "]");
                }
            } catch (Exception e16) {
                e = e16;
                if (AVCoreLog.isLogColorOrGary()) {
                    AVCoreLog.e("AndroidCamera", "getNumberOfCamera, Exception", e);
                }
                return i3;
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 1;
        }
        return i3;
    }

    protected Camera.Size q(List<Camera.Size> list, int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Camera.Size) iPatchRedirector.redirect((short) 23, this, list, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        for (Camera.Size size : list) {
            if (size.width == i3 && size.height == i16) {
                if (AVCoreLog.isLogColorOrGary()) {
                    AVCoreLog.printAllUserLog("AndroidCamera", "getOptimalEqualPreviewSize1, width[" + size.width + "], height[" + size.height + "]");
                }
                return size;
            }
        }
        if (i3 == 320 && i16 == 240) {
            for (Camera.Size size2 : list) {
                if (size2.width == 640 && size2.height == 480) {
                    if (AVCoreLog.isLogColorOrGary()) {
                        AVCoreLog.printAllUserLog("AndroidCamera", "getOptimalEqualPreviewSize2, width[" + size2.width + "], height[" + size2.height + "]");
                    }
                    return size2;
                }
            }
            i3 = 640;
            i16 = 480;
        }
        int i18 = f77378u;
        int i19 = f77379v;
        Camera.Size r16 = r(list, i18, i19);
        if (AVCoreLog.isLogColorOrGary()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getOptimalEqualPreviewSize3, width[");
            int i26 = -1;
            if (r16 != null) {
                i17 = r16.width;
            } else {
                i17 = -1;
            }
            sb5.append(i17);
            sb5.append("], height[");
            if (r16 != null) {
                i26 = r16.height;
            }
            sb5.append(i26);
            sb5.append("], srcW[");
            sb5.append(i3);
            sb5.append("], srcH[");
            sb5.append(i16);
            sb5.append("], fw[");
            sb5.append(i18);
            sb5.append("], fh[");
            sb5.append(i19);
            sb5.append("]");
            AVCoreLog.printAllUserLog("AndroidCamera", sb5.toString());
        }
        return r16;
    }

    protected Camera.Size r(List<Camera.Size> list, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Camera.Size) iPatchRedirector.redirect((short) 22, this, list, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        double d16 = i3 / i16;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double d17 = Double.MAX_VALUE;
        double d18 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((size2.width / size2.height) - d16) <= 0.05d && Math.abs(size2.height - i16) < d18) {
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
        return size;
    }

    int s(boolean z16) {
        int e16;
        if (z16) {
            e16 = this.f77401r.o(this.f77384a, false, true, (byte) 0, false);
        } else {
            e16 = this.f77401r.e(this.f77384a, false, true, (byte) 0, false);
        }
        return e16 * 90;
    }

    int t(boolean z16) {
        int e16;
        if (z16) {
            e16 = this.f77401r.o(this.f77384a, true, true, (byte) 0, false);
        } else {
            e16 = this.f77401r.e(this.f77384a, true, true, (byte) 0, false);
        }
        return 360 - (e16 * 90);
    }

    public String toString() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isCameraOpened[");
        sb5.append(f77381x);
        sb5.append("], mCameraId[");
        sb5.append(this.f77392i);
        sb5.append("], NUM[");
        sb5.append(this.f77387d);
        sb5.append("], CUR[");
        sb5.append(this.f77386c);
        sb5.append("], camera[");
        if (this.f77385b != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("]");
        return sb5.toString();
    }

    protected int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return 0;
    }

    protected int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return 0;
    }

    public int w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this, z16)).intValue();
        }
        if (z16) {
            return this.f77395l;
        }
        return this.f77396m;
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this)).booleanValue();
        }
        return f77381x;
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        return A;
    }

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        int i3 = this.f77386c;
        if (i3 == 0 || i3 == 1) {
            return true;
        }
        return false;
    }
}
