package com.tencent.mobileqq.ar.arengine;

import android.graphics.PointF;
import android.os.Environment;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.mobileqq.ar.arengine.y;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.lang.Thread;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARLocalGestureCircleRecog {

    /* renamed from: w, reason: collision with root package name */
    private static boolean f197867w = false;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f197868x = false;

    /* renamed from: a, reason: collision with root package name */
    private ProcessWorker f197869a = null;

    /* renamed from: b, reason: collision with root package name */
    private Object f197870b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private Object f197871c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private boolean f197872d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f197873e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f197874f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f197875g = false;

    /* renamed from: h, reason: collision with root package name */
    private int f197876h = 480;

    /* renamed from: i, reason: collision with root package name */
    private int f197877i = 640;

    /* renamed from: j, reason: collision with root package name */
    private long f197878j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f197879k = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f197880l = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f197881m = 0;

    /* renamed from: n, reason: collision with root package name */
    private long f197882n = 0;

    /* renamed from: o, reason: collision with root package name */
    private long f197883o = 0;

    /* renamed from: p, reason: collision with root package name */
    private AVGestureWrapper f197884p = null;

    /* renamed from: q, reason: collision with root package name */
    private y f197885q = new y();

    /* renamed from: r, reason: collision with root package name */
    private b f197886r = null;

    /* renamed from: s, reason: collision with root package name */
    String f197887s = Environment.getExternalStorageDirectory().getPath() + File.separator + "ar_cloud_img/";

    /* renamed from: t, reason: collision with root package name */
    int f197888t = 0;

    /* renamed from: u, reason: collision with root package name */
    PointF f197889u = new PointF(-1.0f, -1.0f);

    /* renamed from: v, reason: collision with root package name */
    PointF[] f197890v = new PointF[100];

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class ProcessWorker extends BaseThread {
        private long C;
        byte[] E;
        private boolean D = false;
        private boolean F = true;

        public ProcessWorker() {
            this.E = new byte[((ARLocalGestureCircleRecog.this.f197876h * ARLocalGestureCircleRecog.this.f197877i) * 3) / 2];
            setDaemon(true);
            start();
        }

        public void o() {
            this.F = false;
            if (getState() == Thread.State.WAITING) {
                synchronized (this) {
                    notify();
                }
            }
        }

        void p(long j3, byte[] bArr) {
            if (getState() == Thread.State.WAITING) {
                byte[] bArr2 = this.E;
                System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
                this.C = j3;
                this.D = true;
                synchronized (this) {
                    notify();
                }
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public synchronized void run() {
            ARLocalGestureCircleRecog aRLocalGestureCircleRecog;
            setName("ARLocalGestureCircleRecogProcessWorker");
            while (this.F) {
                while (!this.D && this.F) {
                    try {
                        LockMethodProxy.wait(this);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                if (!this.F) {
                    return;
                }
                this.D = false;
                synchronized (ARLocalGestureCircleRecog.this.f197870b) {
                    ARLocalGestureCircleRecog.this.f197874f = true;
                    try {
                        try {
                            ARLocalGestureCircleRecog aRLocalGestureCircleRecog2 = ARLocalGestureCircleRecog.this;
                            y l3 = aRLocalGestureCircleRecog2.l(this.E, aRLocalGestureCircleRecog2.f197876h, ARLocalGestureCircleRecog.this.f197877i, 17);
                            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecog. recogResult = " + l3 + ",mRecogResult.gestureResult.mode = " + ARLocalGestureCircleRecog.this.f197885q.f198295c.f198321g);
                            if (ARLocalGestureCircleRecog.this.f197873e && !ARLocalGestureCircleRecog.this.f197875g && ARLocalGestureCircleRecog.this.f197886r != null && ARLocalGestureCircleRecog.this.f197885q.f198295c.f198321g == 0) {
                                ARLocalGestureCircleRecog.this.f197886r.b(l3);
                            }
                            aRLocalGestureCircleRecog = ARLocalGestureCircleRecog.this;
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.d("AREngine_ARLocalGestureCircleRecog", 2, "Exception", e17);
                            }
                            aRLocalGestureCircleRecog = ARLocalGestureCircleRecog.this;
                        }
                        aRLocalGestureCircleRecog.f197874f = false;
                        Thread.yield();
                    } finally {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements AVGestureWrapper.AVUploadReport {
        a() {
        }

        @Override // com.tencent.av.avgesture.AVGestureWrapper.AVUploadReport
        public void avGestureUploadReport(String str, String str2) {
            SdkContext.getInstance().getReporter().reportToCompass("dc00898", "", str, str, 0, 0, "", "", str2, "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void b(y yVar);
    }

    public static PointF i(int i3, int i16, int i17, int i18, PointF pointF) {
        float f16 = i17;
        return new PointF(f16 - ((pointF.y / i16) * f16), (pointF.x / i3) * i18);
    }

    private void j() {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "delete backup file.");
        File[] listFiles = new File(this.f197887s).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public static synchronized boolean u() {
        String str;
        File file;
        synchronized (ARLocalGestureCircleRecog.class) {
            try {
                try {
                    str = SdkContext.getInstance().getResources().getGestureResource().getModelPath() + File.separator;
                    file = new File(str);
                } catch (Exception e16) {
                    f197868x = false;
                    QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture model failed. err = " + e16.getMessage());
                }
            } catch (UnsatisfiedLinkError e17) {
                f197868x = false;
                QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture model failed. UnsatisfiedLinkError. err = " + e17.getMessage());
            }
            if (!file.exists()) {
                QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture model failed. model path not exist. modelPath = " + file);
                return false;
            }
            QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture model.... modelPath = " + file);
            AVGestureWrapper.setFilePath(str, str, str);
            AVGestureWrapper.setGlobalConfigFile(str);
            AVGestureWrapper.setAVGestureReport(new a());
            AVGestureWrapper.setShouldUpload(false);
            f197868x = true;
            QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture model ok.");
            return f197868x;
        }
    }

    public static synchronized boolean v() {
        synchronized (ARLocalGestureCircleRecog.class) {
            boolean a16 = com.tencent.mobileqq.shortvideo.ptvfilter.gesture.a.a();
            boolean isGestureEnable = SdkContext.getInstance().getResources().getGestureResource().isGestureEnable();
            if (a16 && isGestureEnable) {
                String str = SdkContext.getInstance().getResources().getGestureResource().getSoPathDir() + "libAVGesture4Android.so";
                if (!new File(str).exists()) {
                    QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so failed. so not exist. soFilename = " + str);
                    return false;
                }
                QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so... md5FromCalc = " + com.tencent.mobileqq.portal.o.e(str));
                try {
                    System.load(str);
                    f197867w = true;
                    QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so ok. soFilename = " + str + ", SDKVersion = " + AVGestureWrapper.getVersionInfo());
                } catch (Throwable th5) {
                    f197867w = false;
                    QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so failed. err = " + th5.getMessage());
                }
                return f197867w;
            }
            QLog.i("AREngine_ARLocalGestureCircleRecog", 2, "load gesture so failed. isGestureResourceReady = " + a16 + ", isGestureEnable = " + isGestureEnable);
            return false;
        }
    }

    public boolean A() {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "start start.");
        if (this.f197873e) {
            return true;
        }
        if (this.f197869a == null) {
            this.f197869a = new ProcessWorker();
        }
        y();
        j();
        this.f197873e = true;
        this.f197875g = false;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "start end. mIsStarted = " + this.f197873e);
        return true;
    }

    public void B() {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "stop start.");
        if (!this.f197873e) {
            return;
        }
        ProcessWorker processWorker = this.f197869a;
        if (processWorker != null) {
            processWorker.o();
            this.f197869a = null;
        }
        this.f197873e = false;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "stop end. mIsStarted = " + this.f197873e);
    }

    public void C() {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "uninit start.");
        if (!this.f197872d) {
            return;
        }
        this.f197886r = null;
        synchronized (this.f197871c) {
            AVGestureWrapper aVGestureWrapper = this.f197884p;
            if (aVGestureWrapper != null) {
                aVGestureWrapper.destroyRecognizor();
                this.f197884p = null;
            }
        }
        this.f197872d = false;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "uninit end. mIsInited = " + this.f197872d);
    }

    y.c k(byte[] bArr, int i3, int i16, int i17, boolean z16) {
        boolean z17;
        long currentTimeMillis = System.currentTimeMillis();
        y.c cVar = new y.c(1);
        PointF[] pointFArr = {new PointF(-1.0f, -1.0f)};
        synchronized (this.f197871c) {
            AVGestureWrapper aVGestureWrapper = this.f197884p;
            if (aVGestureWrapper != null) {
                boolean doCalc = aVGestureWrapper.doCalc(bArr, i3, i16, 2, 270, z16);
                cVar.f198315a = doCalc;
                cVar.f198317c = this.f197884p.getGestureType();
                PointF keyPointByName = this.f197884p.getKeyPointByName("finger");
                pointFArr[0] = keyPointByName;
                if (doCalc && keyPointByName.x > 0.0f && keyPointByName.y > 0.0f && ((z16 && cVar.f198317c.equalsIgnoreCase("finger1")) || !z16)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectGesture. doCalc. isSuccess = " + z17 + ", res = " + doCalc + ", type = " + cVar.f198317c + ", x = " + pointFArr[0].x + ", y = " + pointFArr[0].y);
            } else {
                z17 = false;
            }
        }
        if (z17) {
            PointF[] pointFArr2 = cVar.f198318d;
            int i18 = cVar.f198319e;
            cVar.f198319e = i18 + 1;
            PointF pointF = pointFArr[0];
            pointFArr2[i18] = new PointF(pointF.x, pointF.y);
            cVar.f198321g = 0;
            cVar.f198316b = 0;
        } else {
            cVar.f198317c = "";
            PointF[] pointFArr3 = cVar.f198318d;
            int i19 = cVar.f198319e;
            cVar.f198319e = i19 + 1;
            pointFArr3[i19] = new PointF(-1.0f, -1.0f);
            cVar.f198321g = -1;
            cVar.f198316b = -1;
        }
        cVar.f198320f = (int) (System.currentTimeMillis() - currentTimeMillis);
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectGesture. gestureResult = " + cVar + ", TotalTime = " + cVar.f198320f);
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x045c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    y l(byte[] bArr, int i3, int i16, int i17) {
        boolean z16;
        int i18;
        boolean z17;
        y.b bVar;
        boolean z18;
        int i19;
        float m3;
        int i26;
        y.b bVar2;
        int i27;
        float f16;
        float f17;
        float m16;
        float f18;
        int i28;
        y yVar = this.f197885q;
        y.b bVar3 = yVar.f198296d;
        bVar3.f198302b = bVar3.f198301a;
        int i29 = bVar3.f198305e;
        bVar3.f198306f = i29;
        if (this.f197873e && i29 < 999) {
            y.c cVar = yVar.f198295c;
            if (cVar.f198319e >= 999) {
                cVar.f198319e = 0;
                QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. reset gesture result point cnt.");
            }
            y yVar2 = this.f197885q;
            y.b bVar4 = yVar2.f198296d;
            if (bVar4.f198301a == 0) {
                QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. return. state == ARCircleResult.CIRCLE_STATE_SUCCESS.");
                return this.f197885q;
            }
            if (bVar4.f198305e != 0 && yVar2.f198295c.f198315a) {
                z16 = false;
            } else {
                z16 = true;
            }
            y.c k3 = k(bArr, i3, i16, i17, z16);
            int i36 = k3.f198316b;
            y yVar3 = this.f197885q;
            yVar3.f198295c.f198315a = k3.f198315a;
            y.b bVar5 = yVar3.f198296d;
            if (bVar5.f198305e == 0) {
                if (i36 == 0) {
                    this.f197888t = 0;
                    PointF pointF = this.f197889u;
                    if (pointF.x < 0.0f) {
                        PointF pointF2 = k3.f198318d[0];
                        pointF.x = pointF2.x;
                        pointF.y = pointF2.y;
                        m16 = -1.0f;
                    } else {
                        m16 = m(pointF, k3.f198318d[0]);
                        PointF pointF3 = this.f197889u;
                        PointF pointF4 = k3.f198318d[0];
                        pointF3.x = pointF4.x;
                        pointF3.y = pointF4.y;
                    }
                    y.b bVar6 = this.f197885q.f198296d;
                    int i37 = bVar6.f198312l;
                    if (i37 < 4) {
                        if (m16 > 30) {
                            bVar6.f198312l = i37 + 1;
                        }
                        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. startDrawDetect. return. , px = " + k3.f198318d[0].x + ", py = " + k3.f198318d[0].y + ", d1 = " + m16 + ", d2 = -1.0, gesturePointCnt = " + this.f197885q.f198296d.f198312l + ", stillPointCnt = " + this.f197885q.f198296d.f198313m + ", goodPointCnt = " + this.f197885q.f198296d.f198314n);
                        return this.f197885q;
                    }
                    int i38 = bVar6.f198313m;
                    if (i38 < 4) {
                        if (m16 >= 0.0f) {
                            if (m16 < 30) {
                                int i39 = i38 + 1;
                                bVar6.f198313m = i39;
                                if (i39 >= 4) {
                                    bVar6.f198314n = 0;
                                }
                            } else {
                                i28 = 0;
                            }
                        } else {
                            i28 = 0;
                        }
                        bVar6.f198313m = i28;
                    }
                    int i46 = bVar6.f198314n;
                    if (i46 < 6) {
                        if (i46 != 0) {
                            if (i46 >= 1 && m16 > 30) {
                                f18 = m(this.f197890v[i46 - 1], k3.f198318d[0]);
                                if (f18 <= 120) {
                                    i27 = 4;
                                    f17 = m16;
                                    f16 = f18;
                                }
                            }
                        } else {
                            f18 = -1.0f;
                        }
                        y.b bVar7 = this.f197885q.f198296d;
                        int i47 = bVar7.f198314n + 1;
                        bVar7.f198314n = i47;
                        PointF pointF5 = k3.f198318d[0];
                        float f19 = m16;
                        this.f197890v[i47 - 1] = new PointF(pointF5.x, pointF5.y);
                        f16 = f18;
                        f17 = f19;
                        i27 = 4;
                    }
                    f17 = m16;
                    f16 = -1.0f;
                    i27 = 4;
                } else {
                    int i48 = this.f197888t + 1;
                    this.f197888t = i48;
                    if (i48 > 13) {
                        bVar5.f198312l = 0;
                        bVar5.f198313m = 0;
                        bVar5.f198314n = 0;
                    } else if (i48 > 5) {
                        i27 = 4;
                        if (bVar5.f198312l < 4) {
                            bVar5.f198312l = 0;
                        }
                        if (bVar5.f198313m < 4) {
                            bVar5.f198313m = 0;
                        }
                        if (bVar5.f198314n < 4) {
                            bVar5.f198314n = 0;
                        }
                        f16 = -1.0f;
                        f17 = -1.0f;
                    }
                    i27 = 4;
                    f16 = -1.0f;
                    f17 = -1.0f;
                }
                y.b bVar8 = this.f197885q.f198296d;
                if (bVar8.f198312l >= i27 && ((bVar8.f198313m >= i27 && bVar8.f198314n >= i27) || bVar8.f198314n >= 6)) {
                    y.a n3 = n(this.f197890v, bVar8.f198314n);
                    if (n3 != null) {
                        y.b bVar9 = this.f197885q.f198296d;
                        y.a aVar = bVar9.f198303c;
                        aVar.f198300d = n3.f198300d;
                        p(bVar9.f198307g, 0, bVar9.f198308h, bVar9.f198309i, aVar);
                    } else {
                        return this.f197885q;
                    }
                } else {
                    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. startDrawDetect. return. , px = " + k3.f198318d[0].x + ", py = " + k3.f198318d[0].y + ", d1 = " + f17 + ", d2 = " + f16 + ", gesturePointCnt = " + this.f197885q.f198296d.f198312l + ", stillPointCnt = " + this.f197885q.f198296d.f198313m + ", goodPointCnt = " + this.f197885q.f198296d.f198314n);
                    return this.f197885q;
                }
            }
            if (this.f197885q.f198296d.f198305e == 0) {
                PointF[] pointFArr = k3.f198318d;
                int i49 = k3.f198319e;
                if (pointFArr[i49 - 1].x > 0.0f && pointFArr[i49 - 1].y > 0.0f && !k3.f198317c.equalsIgnoreCase("finger1")) {
                    k3.f198317c = "";
                    PointF[] pointFArr2 = k3.f198318d;
                    int i56 = k3.f198319e;
                    pointFArr2[i56 - 1].x = -1.0f;
                    pointFArr2[i56 - 1].y = -1.0f;
                    k3.f198321g = -1;
                    k3.f198316b = -1;
                }
            }
            y yVar4 = this.f197885q;
            y.c cVar2 = yVar4.f198295c;
            cVar2.f198320f = k3.f198320f;
            cVar2.f198317c = k3.f198317c;
            PointF pointF6 = k3.f198318d[k3.f198319e - 1];
            float f26 = pointF6.x;
            if (f26 > 0.0f) {
                float f27 = pointF6.y;
                if (f27 > 0.0f) {
                    cVar2.f198321g = k3.f198321g;
                    cVar2.f198316b = 0;
                    PointF[] pointFArr3 = cVar2.f198318d;
                    int i57 = cVar2.f198319e;
                    cVar2.f198319e = i57 + 1;
                    pointFArr3[i57] = pointF6;
                    y.b bVar10 = yVar4.f198296d;
                    int i58 = bVar10.f198305e;
                    if (i58 == 0) {
                        if (150.0f < f26 && f26 < this.f197876h - 150 && 50.0f < f27 && f27 < this.f197877i - 50) {
                            PointF[] pointFArr4 = bVar10.f198304d;
                            bVar10.f198305e = i58 + 1;
                            pointFArr4[i58] = new PointF(pointF6.x, pointF6.y);
                            y.b bVar11 = this.f197885q.f198296d;
                            bVar11.f198301a = 1;
                            bVar11.f198314n = 0;
                            this.f197878j = 0L;
                            this.f197879k = 0L;
                            this.f197882n = System.currentTimeMillis();
                            this.f197883o = 0L;
                        } else {
                            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture failed. firstPoint. x = " + pointF6.x + ", y = " + pointF6.y);
                        }
                    } else {
                        boolean t16 = t(bVar10.f198304d, i58, pointF6, 20.0f);
                        if (!t16) {
                            y yVar5 = this.f197885q;
                            y.c cVar3 = yVar5.f198295c;
                            int i59 = cVar3.f198319e;
                            if (i59 >= 2) {
                                PointF[] pointFArr5 = cVar3.f198318d;
                                i19 = 1;
                                m3 = m(pointFArr5[i59 - 2], pointFArr5[i59 - 1]);
                            } else {
                                i19 = 1;
                                y.b bVar12 = yVar5.f198296d;
                                m3 = m(bVar12.f198304d[bVar12.f198305e - 1], pointF6);
                            }
                            if (m3 > 50.0f) {
                                this.f197885q.f198296d.f198314n += i19;
                                if (this.f197882n == 0) {
                                    this.f197882n = System.currentTimeMillis();
                                } else {
                                    this.f197883o = System.currentTimeMillis();
                                }
                                long j3 = this.f197882n;
                                if (j3 != 0) {
                                    long j16 = this.f197883o;
                                    if (j16 != 0) {
                                        i26 = (int) (j16 - j3);
                                        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture dist. dist = " + m3 + ", goodPointCnt = " + this.f197885q.f198296d.f198314n + ", timeLen = " + i26);
                                        bVar2 = this.f197885q.f198296d;
                                        if (bVar2.f198314n >= 1 && i26 > 30) {
                                            PointF[] pointFArr6 = bVar2.f198304d;
                                            int i65 = bVar2.f198305e;
                                            bVar2.f198305e = i65 + 1;
                                            pointFArr6[i65] = new PointF(pointF6.x, pointF6.y);
                                            this.f197885q.f198296d.f198314n = 0;
                                            this.f197882n = System.currentTimeMillis();
                                            this.f197883o = 0L;
                                        }
                                        this.f197878j = 0L;
                                        this.f197879k = 0L;
                                    }
                                }
                            }
                            i26 = 0;
                            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture dist. dist = " + m3 + ", goodPointCnt = " + this.f197885q.f198296d.f198314n + ", timeLen = " + i26);
                            bVar2 = this.f197885q.f198296d;
                            if (bVar2.f198314n >= 1) {
                                PointF[] pointFArr62 = bVar2.f198304d;
                                int i652 = bVar2.f198305e;
                                bVar2.f198305e = i652 + 1;
                                pointFArr62[i652] = new PointF(pointF6.x, pointF6.y);
                                this.f197885q.f198296d.f198314n = 0;
                                this.f197882n = System.currentTimeMillis();
                                this.f197883o = 0L;
                            }
                            this.f197878j = 0L;
                            this.f197879k = 0L;
                        } else {
                            QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "Gesture failed. isRepeat = " + t16 + ", isException = false");
                        }
                    }
                    y yVar6 = this.f197885q;
                    bVar = yVar6.f198296d;
                    if (bVar.f198311k < bVar.f198309i - 1) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        bVar.f198301a = 0;
                    }
                    return yVar6;
                }
            }
            cVar2.f198316b = -1;
            if (yVar4.f198296d.f198305e > 0) {
                if (this.f197878j == 0) {
                    this.f197878j = System.currentTimeMillis();
                } else {
                    this.f197879k = System.currentTimeMillis();
                }
                long j17 = this.f197878j;
                if (j17 != 0) {
                    long j18 = this.f197879k;
                    if (j18 != 0) {
                        i18 = (int) (j18 - j17);
                        if (i18 > 2000) {
                            y yVar7 = this.f197885q;
                            y.b bVar13 = yVar7.f198296d;
                            if (bVar13.f198311k >= bVar13.f198309i * 0.8d) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                bVar13.f198301a = 0;
                            } else {
                                bVar13.f198301a = -1;
                            }
                            this.f197878j = 0L;
                            this.f197879k = 0L;
                            return yVar7;
                        }
                    }
                }
                i18 = 0;
                if (i18 > 2000) {
                }
            }
            y yVar62 = this.f197885q;
            bVar = yVar62.f198296d;
            if (bVar.f198311k < bVar.f198309i - 1) {
            }
            if (z18) {
            }
            return yVar62;
        }
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "detectImg. return. mRecogResult.circleResult.pointCnt >= ARLocalGestureCircleRecogResult.MAX_POINT_CNT - 1.");
        return this.f197885q;
    }

    float m(PointF pointF, PointF pointF2) {
        if (pointF != null && pointF2 != null) {
            float abs = Math.abs(pointF.x - pointF2.x);
            float abs2 = Math.abs(pointF.y - pointF2.y);
            return (float) Math.sqrt((abs * abs) + (abs2 * abs2));
        }
        return 0.0f;
    }

    y.a n(PointF[] pointFArr, int i3) {
        if (i3 < 3) {
            return null;
        }
        int i16 = i3 - 1;
        return o(pointFArr, i16, pointFArr[i16]);
    }

    y.a o(PointF[] pointFArr, int i3, PointF pointF) {
        boolean z16;
        float q16;
        int i16 = i3;
        int i17 = i16 + 1;
        if (i17 < 3) {
            return null;
        }
        y.a aVar = new y.a();
        double d16 = 0.0d;
        double d17 = 0.0d;
        double d18 = 0.0d;
        double d19 = 0.0d;
        double d26 = 0.0d;
        double d27 = 0.0d;
        double d28 = 0.0d;
        double d29 = 0.0d;
        double d36 = 0.0d;
        int i18 = 0;
        while (i18 < i16) {
            PointF pointF2 = pointFArr[i18];
            int i19 = i17;
            double d37 = pointF2.x;
            double d38 = pointF2.y;
            double d39 = d37 * d37;
            double d46 = d38 * d38;
            d16 += d37;
            d17 += d38;
            d18 += d39;
            d19 += d46;
            d26 += d39 * d37;
            d27 += d46 * d38;
            d28 += d37 * d38;
            d29 += d37 * d46;
            d36 += d39 * d38;
            i18++;
            i16 = i3;
            i17 = i19;
            aVar = aVar;
        }
        int i26 = i17;
        y.a aVar2 = aVar;
        double d47 = pointF.x;
        double d48 = pointF.y;
        double d49 = d47 * d47;
        double d56 = d48 * d48;
        double d57 = d16 + d47;
        double d58 = d17 + d48;
        double d59 = d18 + d49;
        double d65 = d19 + d56;
        double d66 = d26 + (d49 * d47);
        double d67 = d27 + (d56 * d48);
        double d68 = d28 + (d47 * d48);
        double d69 = d29 + (d47 * d56);
        double d75 = d36 + (d49 * d48);
        double d76 = i26;
        double d77 = (d76 * d59) - (d57 * d57);
        double d78 = (d68 * d76) - (d57 * d58);
        double d79 = (d66 * d76) + (d69 * d76);
        double d85 = d59 + d65;
        double d86 = d79 - (d85 * d57);
        double d87 = (d76 * d65) - (d58 * d58);
        double d88 = ((d75 * d76) + (d67 * d76)) - (d85 * d58);
        double d89 = (d88 * d78) - (d86 * d87);
        double d95 = d87 * d77;
        double d96 = d78 * d78;
        double d97 = d89 / (d95 - d96);
        double d98 = ((d88 * d77) - (d86 * d78)) / (d96 - d95);
        aVar2.f198298b = ((float) d97) / (-2.0f);
        aVar2.f198299c = ((float) d98) / (-2.0f);
        aVar2.f198297a = ((float) Math.sqrt(((d97 * d97) + (d98 * d98)) - (((-((((d57 * d97) + (d58 * d98)) + d59) + d65)) / d76) * 4.0d))) / 2.0f;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        while (true) {
            int i36 = i3 - 1;
            if (i27 >= i36 + 1) {
                break;
            }
            PointF pointF3 = new PointF(aVar2.f198298b, aVar2.f198299c);
            PointF pointF4 = new PointF(aVar2.f198298b + aVar2.f198297a, aVar2.f198299c);
            float q17 = q(pointF3, pointF4, pointFArr[i27]);
            if (i27 != i36) {
                q16 = q(pointF3, pointF4, pointFArr[i27 + 1]);
            } else {
                q16 = q(pointF3, pointF4, pointF);
            }
            if ((270.0f > q17 || q17 > 360.0f || 0.0f > q16 || q16 > 90.0f) && (270.0f > q16 || q16 > 360.0f || 0.0f > q17 || q17 > 90.0f)) {
                if (q16 > q17) {
                    i29++;
                }
                i28++;
            }
            i27++;
        }
        if (i28 > 0 && i29 <= i28 / 2.0f) {
            z16 = false;
        } else {
            z16 = true;
        }
        aVar2.f198300d = z16;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "fitCircle. centerX = " + aVar2.f198298b + ", centerY = " + aVar2.f198299c + ", r = " + aVar2.f198297a + ", isClockwise = " + aVar2.f198300d + ", clockWiseCnt = " + i29 + ", usedPointCnt = " + i28 + ", pointCnt = " + i3);
        return aVar2;
    }

    int p(PointF[] pointFArr, int i3, int[] iArr, int i16, y.a aVar) {
        int i17;
        int i18;
        PointF pointF;
        if (!aVar.f198300d) {
            i17 = -1;
        } else {
            i17 = 1;
        }
        float f16 = (i17 * 360.0f) / i16;
        float f17 = (float) ((f16 / 180.0f) * 3.141592653589793d);
        Math.abs((180.0f * f17) / 3.141592653589793d);
        if (i17 == -1) {
            i18 = 0;
        } else {
            i18 = 360;
        }
        PointF pointF2 = new PointF(aVar.f198298b - aVar.f198297a, aVar.f198299c);
        new PointF(aVar.f198298b, aVar.f198299c);
        float f18 = i18;
        int i19 = 0;
        int i26 = i3;
        while (i19 < i16) {
            if (i19 == 0) {
                pointF = new PointF(pointF2.x - aVar.f198298b, pointF2.y - aVar.f198299c);
            } else {
                PointF pointF3 = pointFArr[i26 - 1];
                pointF = new PointF(pointF3.x - aVar.f198298b, pointF3.y - aVar.f198299c);
            }
            PointF pointF4 = new PointF(0.0f, 0.0f);
            double d16 = f17;
            pointF4.x = ((float) ((Math.cos(d16) * pointF.x) - (Math.sin(d16) * pointF.y))) + aVar.f198298b;
            pointF4.y = ((float) ((Math.sin(d16) * pointF.x) + (Math.cos(d16) * pointF.y))) + aVar.f198299c;
            pointFArr[i26] = pointF4;
            iArr[i26] = ((((int) f18) - ((int) ((Math.random() * 210.0d) + 30.0d))) + 360) % 360;
            i26++;
            i19++;
            f18 -= f16;
            pointF2 = pointF2;
        }
        PointF pointF5 = pointF2;
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "genCirclePoints4. pointCnt = " + i26 + ", newCnt = " + i19 + ", radianInc = " + f17 + ", startDegree = " + i18 + ", startP.x = " + pointF5.x + ", startP.y = " + pointF5.y + ", circle.x = " + aVar.f198298b + ", circle.y = " + aVar.f198299c);
        return i26;
    }

    float q(PointF pointF, PointF pointF2, PointF pointF3) {
        float f16 = pointF2.x;
        float f17 = pointF3.x;
        float f18 = (f16 - f17) * (f16 - f17);
        float f19 = pointF2.y;
        float f26 = pointF3.y;
        double sqrt = Math.sqrt(f18 + ((f19 - f26) * (f19 - f26)));
        float f27 = pointF.x;
        float f28 = pointF3.x;
        float f29 = (f27 - f28) * (f27 - f28);
        float f36 = pointF.y;
        float f37 = pointF3.y;
        double sqrt2 = Math.sqrt(f29 + ((f36 - f37) * (f36 - f37)));
        float f38 = pointF2.x;
        float f39 = pointF.x;
        float f46 = (f38 - f39) * (f38 - f39);
        float f47 = pointF2.y;
        float f48 = pointF.y;
        double sqrt3 = Math.sqrt(f46 + ((f47 - f48) * (f47 - f48)));
        double acos = (Math.acos((((sqrt2 * sqrt2) + (sqrt3 * sqrt3)) - (sqrt * sqrt)) / ((sqrt2 * 2.0d) * sqrt3)) * 180.0d) / 3.141592653589793d;
        if (pointF3.y > pointF.y) {
            return (float) acos;
        }
        return (float) (360.0d - acos);
    }

    public boolean r(int i3, int i16, b bVar) {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "init. imgW = " + i3 + ", imgH = " + i16);
        if (this.f197872d) {
            return true;
        }
        this.f197872d = false;
        this.f197873e = false;
        this.f197874f = false;
        synchronized (this.f197871c) {
            com.tencent.sveffects.a.b();
            if (v() && u() && this.f197884p == null) {
                this.f197884p = new AVGestureWrapper();
            }
        }
        this.f197876h = i3;
        this.f197877i = i16;
        this.f197886r = bVar;
        y();
        this.f197872d = true;
        return true;
    }

    public boolean s() {
        return this.f197875g;
    }

    boolean t(PointF[] pointFArr, int i3, PointF pointF, float f16) {
        if (pointFArr == null || i3 == 0 || pointF == null) {
            return false;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            if (m(pointFArr[i16], pointF) < f16) {
                return true;
            }
        }
        return false;
    }

    public void w(long j3, byte[] bArr) {
        if (bArr == null || !this.f197873e || this.f197875g || this.f197885q.f198295c.f198321g == 1) {
            return;
        }
        ProcessWorker processWorker = this.f197869a;
        if (processWorker != null) {
            processWorker.p(j3, bArr);
        }
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecog. onPreviewFrame");
    }

    public void x() {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "pause. mIsPause = " + this.f197875g);
        if (this.f197875g) {
            return;
        }
        this.f197875g = true;
    }

    public void y() {
        this.f197885q.a();
        y.a aVar = new y.a();
        aVar.f198297a = (this.f197877i / 4.0f) * 1.05f;
        aVar.f198298b = (this.f197876h / 2) - 100;
        aVar.f198299c = r0 / 2;
        aVar.f198300d = true;
        y.b bVar = this.f197885q.f198296d;
        bVar.f198303c = aVar;
        p(bVar.f198307g, 0, bVar.f198308h, bVar.f198309i, aVar);
        this.f197878j = 0L;
        this.f197879k = 0L;
        this.f197880l = 0L;
        this.f197881m = 0L;
        this.f197882n = 0L;
        this.f197883o = 0L;
    }

    public void z() {
        QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "resume. mIsPause = " + this.f197875g);
        if (!this.f197875g) {
            return;
        }
        this.f197875g = false;
    }
}
