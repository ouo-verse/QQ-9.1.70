package com.tencent.mobileqq.activity.richmedia.state;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import ar2.a;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import er2.a;
import java.io.File;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import yq2.d;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RMVideoStateMgr implements a.b, AVCodec.AVCodecCallback, d.a, a.InterfaceC0065a, AudioCapture.a {

    /* renamed from: r0, reason: collision with root package name */
    private static RMVideoStateMgr f185887r0 = null;

    /* renamed from: s0, reason: collision with root package name */
    public static boolean f185888s0 = true;

    /* renamed from: t0, reason: collision with root package name */
    private static final int[] f185889t0 = {850, MiniReportManager.EventId.SDK_EMBEDDED_SUPPORT_RESULT, 650, 480};
    public CameraProxy G;
    public double H;
    public PreviewContext I;
    public AudioCapture J;
    public String M;
    public AudioCapture.a N;
    public Context P;
    public g Q;
    public String Y;

    /* renamed from: b0, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.recorder.e f185891b0;

    /* renamed from: c0, reason: collision with root package name */
    private volatile boolean f185892c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f185894d0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f185893d = false;

    /* renamed from: e, reason: collision with root package name */
    public long f185895e = 0;

    /* renamed from: f, reason: collision with root package name */
    public AtomicInteger f185897f = new AtomicInteger(0);

    /* renamed from: h, reason: collision with root package name */
    public final f f185900h = new f();

    /* renamed from: i, reason: collision with root package name */
    public final RMVideoSwitchCameraPicMgr f185902i = new RMVideoSwitchCameraPicMgr();

    /* renamed from: m, reason: collision with root package name */
    final RMVideoInitState f185907m = new RMVideoInitState();
    final c C = new c();
    final RMVideoRecordState D = new RMVideoRecordState();
    final d E = new d();
    private boolean F = false;
    public boolean K = false;
    public boolean L = false;
    private boolean R = false;
    public int S = 0;
    public boolean T = true;
    public boolean U = false;
    public boolean V = false;
    public boolean W = true;
    public com.tencent.mobileqq.shortvideo.util.a X = null;
    private int Z = 1;

    /* renamed from: a0, reason: collision with root package name */
    public int f185890a0 = 480;

    /* renamed from: e0, reason: collision with root package name */
    private int f185896e0 = 0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f185898f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f185899g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    public int f185901h0 = 0;

    /* renamed from: i0, reason: collision with root package name */
    public a f185903i0 = new a();

    /* renamed from: j0, reason: collision with root package name */
    public AtomicInteger f185904j0 = new AtomicInteger(1);

    /* renamed from: k0, reason: collision with root package name */
    public AtomicBoolean f185905k0 = new AtomicBoolean(false);

    /* renamed from: l0, reason: collision with root package name */
    public Handler f185906l0 = new Handler(Looper.getMainLooper());

    /* renamed from: m0, reason: collision with root package name */
    public b f185908m0 = new b();

    /* renamed from: n0, reason: collision with root package name */
    private int[] f185909n0 = new int[8];

    /* renamed from: o0, reason: collision with root package name */
    private volatile boolean f185910o0 = false;

    /* renamed from: p0, reason: collision with root package name */
    private Object f185911p0 = new Object();

    /* renamed from: q0, reason: collision with root package name */
    private boolean f185912q0 = true;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f185913a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f185914b;
    }

    RMVideoStateMgr() {
    }

    public static boolean E(boolean z16) {
        if (!com.tencent.mobileqq.shortvideo.hwcodec.b.a() && !z16) {
            return false;
        }
        return true;
    }

    private void Y(int i3, int i16, boolean z16) {
        int i17;
        int length = yq2.a.f450993j.length / 2;
        int i18 = 0;
        while (true) {
            if (i18 < length) {
                int[] iArr = yq2.a.f450993j;
                int i19 = i18 * 2;
                int t16 = t(iArr[i19 + 1], z16);
                if (iArr[i19] == i3 && t16 == i16) {
                    break;
                } else {
                    i18++;
                }
            } else {
                i18 = -1;
                break;
            }
        }
        if (i18 >= 0 && (i17 = f185889t0[i18]) != this.f185890a0) {
            this.f185890a0 = i17;
        }
    }

    private void e(int i3) {
        this.f185904j0.getAndSet(i3);
    }

    public static void i(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("RMVideoStateMgr", 2, "clearVideoDataFile:" + str);
        }
        String b16 = yq2.a.b();
        if (b16 != null && !"".equals(b16) && b16.contains("/qqvideo")) {
            l(b16, str, false);
        }
    }

    private static void l(String str, String str2, boolean z16) {
        if (str != null && str.trim().length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (int i3 = 0; i3 < listFiles.length; i3++) {
                    if (str2 == null || "".equals(str2) || !listFiles[i3].getAbsolutePath().equals(str2)) {
                        if (listFiles[i3].isDirectory()) {
                            l(listFiles[i3].getAbsolutePath(), str2, true);
                        } else {
                            listFiles[i3].delete();
                        }
                    }
                }
            }
            if (z16) {
                file.delete();
            }
        }
    }

    private static void m(String str, String str2) {
        if (str != null && str.trim().length() != 0) {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists() && file2.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.i("RMVideoStateMgr", 2, "deleteDirectoryByTime rootDir:" + file + ", currentDirectory:" + file2);
                }
                String name = file2.getName();
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0 && !TextUtils.isEmpty(name)) {
                    for (int i3 = 0; i3 < listFiles.length; i3++) {
                        String name2 = listFiles[i3].getName();
                        if (!TextUtils.isEmpty(name2) && name2.compareTo(name) < 0) {
                            FileUtils.deleteDirectory(listFiles[i3].getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    public static void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String absolutePath = new File(str).getParentFile().getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            m(absolutePath, str);
        }
    }

    private native void setBeautyLevelNative(int i3);

    private native void setResolutionAlignedByteNative(int i3);

    private native void setVideoClipSpec(int[] iArr);

    public static synchronized RMVideoStateMgr u() {
        RMVideoStateMgr rMVideoStateMgr;
        synchronized (RMVideoStateMgr.class) {
            if (f185887r0 == null) {
                f185887r0 = new RMVideoStateMgr();
            }
            rMVideoStateMgr = f185887r0;
        }
        return rMVideoStateMgr;
    }

    private void w() {
        this.f185910o0 = false;
    }

    public boolean A() {
        if (this.f185904j0.get() == 4) {
            return true;
        }
        return false;
    }

    public boolean B() {
        if (this.f185904j0.get() == 3) {
            return true;
        }
        return false;
    }

    public boolean C() {
        return this.f185899g0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(boolean z16) {
        this.R = z16;
    }

    public boolean F() {
        return this.f185912q0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean G(Context context, String str, g gVar) {
        g gVar2;
        e(1);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        yq2.a.f450987d = displayMetrics.widthPixels;
        yq2.a.f450988e = displayMetrics.heightPixels;
        this.F = false;
        this.P = context;
        this.H = 0.0d;
        this.V = false;
        this.I = null;
        this.K = false;
        this.L = false;
        this.J = null;
        this.Q = gVar;
        this.f185905k0.set(false);
        this.f185912q0 = true;
        int[] iArr = yq2.a.f450993j;
        if (!x(context, str, iArr[4], iArr[5])) {
            if (QLog.isColorLevel()) {
                QLog.e("RMVideoStateMgr", 2, "initDirs failed");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("RMVideoStateMgr", 2, "rmStateMgr onCreate viewST:" + this.Q + "\n videoStateMgr:" + f185887r0);
        }
        try {
            this.X = new com.tencent.mobileqq.shortvideo.util.a(yq2.a.b());
            P(1);
            try {
                this.f185902i.f185915a = (RMVideoSwitchCameraPicMgr.b) context;
            } catch (ClassCastException e16) {
                e16.printStackTrace();
            }
            com.tencent.mobileqq.shortvideo.mediadevice.c.b().c().addCodecCallback(this);
            com.tencent.mobileqq.shortvideo.mediadevice.c.b().d().e(this);
            er2.a.c();
            if (this.f185897f.getAndIncrement() > 0 && (gVar2 = this.Q) != null) {
                gVar2.j();
                com.tencent.mobileqq.shortvideo.mediadevice.c.b().e().a();
                com.tencent.mobileqq.shortvideo.mediadevice.c.b().a();
            }
            com.tencent.mobileqq.shortvideo.mediadevice.c.b().e().e(this);
            com.tencent.mobileqq.shortvideo.mediadevice.c.b().e().g();
            if (this.f185899g0 && this.f185891b0 == null) {
                this.f185891b0 = new com.tencent.mobileqq.videocodec.mediacodec.recorder.e();
            }
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public void H() {
        if (this.f185897f.decrementAndGet() == 0) {
            PreviewContext previewContext = this.I;
            if (previewContext != null) {
                previewContext.mActivtiyDestory = true;
                this.I = null;
            }
            this.P = null;
            if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "rmStateMgr onDestroy viewST:" + this.Q + "\n videoStateMgr:" + f185887r0);
            }
            this.Q.j();
            this.Q = null;
            this.f185907m.e();
            this.f185907m.f();
            this.C.e();
            this.C.f();
            this.J = null;
            stopWatching();
            this.f185902i.f185915a = null;
            this.N = null;
            L();
            this.f185896e0 = 0;
            this.f185898f0 = false;
            this.f185899g0 = false;
        }
        CameraProxy cameraProxy = this.G;
        if (cameraProxy != null) {
            cameraProxy.M = null;
        }
        this.G = null;
    }

    public void I() {
        yq2.a.f();
        s().e();
        er2.a.c().f(null);
        this.f185903i0.f185913a = true;
    }

    public void J() {
        CameraProxy cameraProxy;
        if (this.W) {
            yq2.a.a();
        }
        er2.a.c().f(this);
        s().b();
        PreviewContext previewContext = this.I;
        if (previewContext != null && (cameraProxy = this.G) != null && !cameraProxy.f288138e) {
            previewContext.notifyFirstFrame = true;
        }
        a aVar = this.f185903i0;
        aVar.f185914b = false;
        aVar.f185913a = false;
    }

    public void K() {
        AudioCapture audioCapture = this.J;
        if (audioCapture != null) {
            audioCapture.m();
        }
        AudioCapture audioCapture2 = this.J;
        if (audioCapture2 != null) {
            audioCapture2.r();
            this.J.f288072x.getAndSet(this.X);
        }
        if (QLog.isColorLevel()) {
            QLog.d("RMVideoStateMgr", 2, "[@][openAudioRecord]");
        }
    }

    public void L() {
        if (this.F) {
            return;
        }
        com.tencent.mobileqq.shortvideo.mediadevice.c.b().e().a();
        com.tencent.mobileqq.shortvideo.mediadevice.c.b().e().e(null);
        com.tencent.mobileqq.shortvideo.mediadevice.c.b().c().removeCodecCallback(this);
        com.tencent.mobileqq.shortvideo.mediadevice.c.b().c().recycle();
        com.tencent.mobileqq.shortvideo.mediadevice.c.b().d().d();
        com.tencent.mobileqq.shortvideo.mediadevice.c.b().a();
        try {
            yq2.a.g();
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        er2.a.c().e();
        this.F = true;
    }

    public void M() {
        this.H = 0.0d;
        com.tencent.mobileqq.shortvideo.mediadevice.c.b().e().d();
        if (com.tencent.mobileqq.shortvideo.mediadevice.c.b().e().f451012i.getState() == Thread.State.TERMINATED) {
            com.tencent.mobileqq.shortvideo.mediadevice.c.b().a();
            com.tencent.mobileqq.shortvideo.mediadevice.c.b().e().e(this);
            com.tencent.mobileqq.shortvideo.mediadevice.c.b().e().g();
        }
    }

    public void N(boolean z16) {
        this.K = z16;
    }

    public void O() {
        synchronized (this.f185911p0) {
            this.f185910o0 = true;
            this.f185911p0.notifyAll();
        }
    }

    public void P(int i3) {
        try {
            setBeautyLevelNative(i3);
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public void Q(CameraProxy cameraProxy) {
        this.G = cameraProxy;
        if (cameraProxy != null) {
            cameraProxy.x(this);
        }
    }

    public void R(boolean z16) {
        this.f185912q0 = z16;
    }

    public void S(PreviewContext previewContext) {
        CameraProxy cameraProxy = this.G;
        if (cameraProxy != null) {
            cameraProxy.f288137d = this.Z;
        }
        this.I = previewContext;
        previewContext.notifyFirstFrame = true;
    }

    public boolean T(int i3) {
        try {
            setResolutionAlignedByteNative(i3);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        }
    }

    public void U(boolean z16) {
        this.f185907m.f185882f = z16;
    }

    public void V(b bVar, boolean z16) {
        try {
            boolean isFoundProduct = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68991e);
            boolean isFoundProductFeatureRom = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(com.tencent.aelight.camera.constants.a.f68992f);
            boolean isFoundProductFeatureRom2 = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(com.tencent.aelight.camera.constants.a.f69011y);
            int i3 = 1;
            if ((isFoundProduct || isFoundProductFeatureRom || isFoundProductFeatureRom2) && com.tencent.mobileqq.activity.richmedia.c.f185845b == 1) {
                bVar.f185923b = -bVar.f185923b;
            }
            int[] iArr = this.f185909n0;
            iArr[0] = bVar.f185922a;
            iArr[1] = bVar.f185923b;
            iArr[2] = bVar.f185924c;
            iArr[3] = bVar.f185925d;
            iArr[4] = bVar.f185926e;
            iArr[5] = bVar.f185927f;
            if (com.tencent.mobileqq.activity.richmedia.c.f185845b != 1) {
                i3 = 0;
            }
            iArr[6] = i3;
            if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "setVideoClipSpecdst_width=" + bVar.f185926e + "spec.dst_height=" + bVar.f185927f + "xoffset=" + bVar.f185922a + "y_offset=" + bVar.f185923b + "clip_width=" + bVar.f185924c + "clip_height" + bVar.f185925d);
            }
            setVideoClipSpec(this.f185909n0);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        b bVar2 = this.f185908m0;
        Y(bVar2.f185926e, bVar2.f185927f, z16);
    }

    public void W() {
        this.f185892c0 = true;
        if (QLog.isColorLevel()) {
            QLog.e("RMVideoStateMgr", 2, "startHwRecorder");
        }
    }

    public void X() {
        if (QLog.isColorLevel()) {
            QLog.e("RMVideoStateMgr", 2, "stopHwRecorder");
        }
        this.f185892c0 = false;
        com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar = this.f185891b0;
        if (eVar != null) {
            eVar.s();
        }
        this.f185894d0 = 0;
    }

    @Override // ar2.a.InterfaceC0065a
    public void a(int i3, String str, boolean z16) {
        g gVar = this.Q;
        if (gVar != null) {
            gVar.p(i3, str, z16);
        }
    }

    @Override // ar2.a.InterfaceC0065a
    public void b(int i3, String str, boolean z16) {
        QQToast.makeText(VideoEnvironment.getContext(), "" + str, 0).show();
    }

    @Override // er2.a.b
    public void c(int i3, String str) {
        try {
            yq2.a.g();
        } catch (UnsatisfiedLinkError unused) {
        }
        s().e();
        if (i3 == 0) {
            a(0, HardCodeUtil.qqStr(R.string.t2o), false);
        }
    }

    @Override // yq2.d.a
    public int d(d.a aVar, boolean z16, int i3, int i16) {
        if (aVar == this) {
            s().h(aVar, z16, i3, i16);
            return 0;
        }
        return -1;
    }

    public void f(int i3) {
        e(i3);
        s().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        long b16 = er2.a.b(er2.a.c().f397063c);
        if (b16 <= er2.a.f397058h) {
            if (QLog.isColorLevel()) {
                QLog.d("RMVideoStateMgr", 2, "[@] checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=" + b16 + "StorageManager.FREESPACE_LIMIT_EXIT=" + er2.a.f397058h + " \u624b\u673a\u5269\u4f59\u5b58\u50a8\u7a7a\u95f4\u4e0d\u8db3");
            }
            a(0, HardCodeUtil.qqStr(R.string.t2n), false);
            return false;
        }
        return true;
    }

    public boolean h(int i3) {
        PreviewContext previewContext;
        int i16 = this.f185901h0;
        if (i16 <= 0 && (previewContext = this.I) != null) {
            i16 = previewContext.getFrameIndex();
        }
        if (QLog.isColorLevel()) {
            QLog.d("RMVideoStateMgr", 2, " checkVideoFrameCount frameCount = " + i16);
        }
        if (i16 >= i3) {
            return true;
        }
        return false;
    }

    public void j() {
        if (QLog.isColorLevel()) {
            QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]mIsAudioReady=" + this.K + " mAI=" + this.J);
        }
        if (z()) {
            this.J.o(this.N);
            this.J.j();
            if (QLog.isColorLevel()) {
                QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]");
            }
        }
        this.K = false;
        this.J = null;
        this.L = false;
    }

    public void k(String str) {
        stopWatching();
        if (QLog.isColorLevel()) {
            QLog.d("" + str, 2, "[@][deleteCacheFile] [RMFileEventNotify]stopWatching");
        }
        String str2 = this.M;
        if (str2 != null) {
            FileUtils.delete(str2, false);
        }
    }

    @Override // yq2.c
    public void notify(Object obj, int i3, Object... objArr) {
        PreviewContext previewContext;
        if (i3 != 11) {
            s().c(obj, i3, objArr);
        } else if (CameraProxy.CameraPreviewObservable.class.isInstance(obj) && (previewContext = this.I) != null) {
            previewContext.notifyFirstFrame = true;
        }
    }

    public void o() {
        w();
        this.R = false;
        if (QLog.isColorLevel()) {
            QLog.e("RMVideoStateMgr", 2, "[enterRecordMode]currentState = " + this.f185904j0.get() + " mCurrentSegInvalid=" + this.R);
        }
        s().a();
    }

    @Override // com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback
    public void onAVCodecEvent(AVCodec.AVCodecCallback aVCodecCallback, MessageStruct messageStruct) {
        s().d(aVCodecCallback, messageStruct);
        if (messageStruct.mId == 33554451) {
            if (QLog.isColorLevel()) {
                QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK");
            }
            synchronized (this.f185905k0) {
                this.f185905k0.set(true);
                this.f185905k0.notifyAll();
                if (QLog.isColorLevel()) {
                    QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK ,notifyAll");
                }
            }
        }
    }

    public boolean p() {
        int i3 = this.f185904j0.get();
        if (i3 == 3) {
            s().a();
        } else if (i3 == 2) {
            if (QLog.isColorLevel()) {
                QLog.e("RMVideoStateMgr", 2, "current = G_STATUS_IDLE ,so do not change state...");
            }
            this.f185903i0.f185914b = true;
        }
        if (QLog.isColorLevel()) {
            QLog.e("RMVideoStateMgr", 2, "[exitRecordMode]currentState = " + i3 + " mCurrentSegInvalid=" + this.R);
        }
        return this.R;
    }

    public void q(boolean z16) {
        e(1);
        s().g(z16);
        s().b();
        a aVar = this.f185903i0;
        if (aVar.f185914b && aVar.f185913a) {
            s().e();
        }
    }

    public boolean r() {
        if (!this.f185910o0) {
            synchronized (this.f185911p0) {
                if (!this.f185910o0) {
                    try {
                        this.f185911p0.wait(1000L);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            return true;
        }
        return true;
    }

    public e s() {
        int i3 = this.f185904j0.get();
        RMVideoInitState rMVideoInitState = this.f185907m;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    return this.E;
                }
                return rMVideoInitState;
            }
            return this.D;
        }
        return this.C;
    }

    int t(int i3, boolean z16) {
        int i16;
        if (E(z16) && (i16 = i3 % 16) > 0) {
            return i3 + (16 - i16);
        }
        return i3;
    }

    public void v() {
        if (QLog.isColorLevel()) {
            QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]mIsAudioReady=" + this.K + " mAI=" + this.J);
        }
        if (!z()) {
            AudioCapture audioCapture = new AudioCapture(this.P);
            this.J = audioCapture;
            audioCapture.h(this);
            this.J.k();
        }
        if (QLog.isColorLevel()) {
            QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]");
        }
    }

    public boolean x(Context context, String str, int i3, int i16) {
        long j3;
        if (QLog.isColorLevel()) {
            QLog.e("RMVideoStateMgr", 2, "initAVCodec");
        }
        try {
            j3 = Long.valueOf(str).longValue();
        } catch (NumberFormatException unused) {
            j3 = -1;
        }
        boolean z16 = false;
        if (j3 == -1) {
            if (QLog.isColorLevel()) {
                QLog.e("RMVideoStateMgr", 2, "initAVCodec mLongUin is invalid. mLongUin=" + j3);
            }
            return false;
        }
        try {
            VideoEnvironment.loadAVCodecSo();
            z16 = yq2.a.c(j3, context, i3, i16);
            if (QLog.isColorLevel()) {
                QLog.e("RMVideoStateMgr", 2, "GlobalValue.init:success=" + z16);
            }
        } catch (UnsatisfiedLinkError e16) {
            QLog.e("RMVideoStateMgr", 1, "GlobalValue.init fail", e16);
        }
        return z16;
    }

    public void y(int i3, int i16) {
        ((IPtvFilterUtil) QRoute.api(IPtvFilterUtil.class)).setSupportBeautySafety(true);
        if (i3 == 4) {
            ((IPtvFilterUtil) QRoute.api(IPtvFilterUtil.class)).setBeautyKindSafety(0);
            if (QLog.isColorLevel()) {
                QLog.d("RMVideoStateMgr", 2, "initVideoParams(): ptvMaxTime=" + i16);
            }
            CodecParam.mIsSmooth = 0;
            CodecParam.mEnableTotalTimeAdjust = 0;
            CodecParam.initFixTimestampSwitch();
            CodecParam.RECORD_MAX_TIME = i16 * 1000;
            CodecParam.mMaxrate = RichMediaStrategy.NO_MSF_SUGGEST_RETRY;
            CodecParam.mMinrate = 100000;
            CodecParam.mQmax = 38;
            CodecParam.mQmin = 3;
            CodecParam.mMaxQdiff = 5;
            CodecParam.VIDEO_FPS = 18;
            boolean isFoundProductFeature = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeature(com.tencent.aelight.camera.constants.a.f68998l);
            if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + isFoundProductFeature);
            }
            if (isFoundProductFeature) {
                yq2.a.f450989f = 640;
                yq2.a.f450990g = 480;
                if (QLog.isColorLevel()) {
                    QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
                }
            } else {
                boolean isFoundProductFeature2 = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeature(com.tencent.aelight.camera.constants.a.f69005s);
                if (QLog.isColorLevel()) {
                    QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + isFoundProductFeature2);
                }
                if (isFoundProductFeature2) {
                    yq2.a.f450989f = 1024;
                    yq2.a.f450990g = 768;
                    if (QLog.isColorLevel()) {
                        QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
                    }
                } else {
                    yq2.a.f450989f = 640;
                    yq2.a.f450990g = 480;
                }
            }
            this.Z = 4;
            AudioCapture.A = 4000;
        }
    }

    public boolean z() {
        if (this.J != null && this.K) {
            return true;
        }
        return false;
    }

    public void startWatching() {
    }

    public void stopWatching() {
    }
}
