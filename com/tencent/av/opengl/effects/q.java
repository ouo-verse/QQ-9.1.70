package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.SystemClock;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.perfstat.MemoryPerfStat;
import com.tencent.av.utils.PerfReporter;
import com.tencent.av.utils.ap;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import org.light.CameraConfig;
import org.light.avatar.AvatarAIInfo;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    final String f74015a;

    /* renamed from: d, reason: collision with root package name */
    int f74018d;

    /* renamed from: m, reason: collision with root package name */
    protected Context f74027m;

    /* renamed from: o, reason: collision with root package name */
    protected com.tencent.av.utils.ab f74029o;

    /* renamed from: s, reason: collision with root package name */
    private c f74033s;

    /* renamed from: t, reason: collision with root package name */
    private n f74034t;

    /* renamed from: v, reason: collision with root package name */
    protected x f74036v;

    /* renamed from: w, reason: collision with root package name */
    protected w f74037w;

    /* renamed from: b, reason: collision with root package name */
    int f74016b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f74017c = 0;

    /* renamed from: e, reason: collision with root package name */
    int f74019e = -1;

    /* renamed from: f, reason: collision with root package name */
    final p f74020f = new p();

    /* renamed from: g, reason: collision with root package name */
    private boolean f74021g = false;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f74022h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f74023i = 0;

    /* renamed from: j, reason: collision with root package name */
    private a f74024j = null;

    /* renamed from: k, reason: collision with root package name */
    private a f74025k = null;

    /* renamed from: l, reason: collision with root package name */
    boolean f74026l = false;

    /* renamed from: n, reason: collision with root package name */
    private final aa f74028n = new aa();

    /* renamed from: p, reason: collision with root package name */
    protected ap f74030p = new ap();

    /* renamed from: q, reason: collision with root package name */
    protected t f74031q = null;

    /* renamed from: r, reason: collision with root package name */
    protected t f74032r = null;

    /* renamed from: u, reason: collision with root package name */
    protected FloatBuffer f74035u = null;

    /* renamed from: x, reason: collision with root package name */
    private com.tencent.av.avatar.a f74038x = null;

    /* renamed from: y, reason: collision with root package name */
    protected boolean f74039y = false;

    /* renamed from: z, reason: collision with root package name */
    private com.tencent.av.utils.o f74040z = new com.tencent.av.utils.o("FilterProcessRender", 2000);

    public q(Context context, c cVar) {
        boolean z16 = false;
        this.f74029o = null;
        String str = "FilterProcessRender_" + com.tencent.av.utils.e.d();
        this.f74015a = str;
        if (QLog.isColorLevel()) {
            this.f74029o = new com.tencent.av.utils.ab(AEFilterSupport.e());
        }
        this.f74033s = cVar;
        com.tencent.sveffects.a.b();
        ((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).init();
        ag.e().c();
        this.f74018d = -1;
        this.f74027m = context;
        SurfaceTexture surfaceTextureForRender = com.tencent.av.camera.b.a(context).getSurfaceTextureForRender();
        if (surfaceTextureForRender != null) {
            this.f74036v = new af(surfaceTextureForRender);
            z16 = true;
        } else {
            this.f74036v = new ah();
        }
        ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).setFilterProcessRenderMode(z16);
        this.f74037w = new ai(str);
        this.f74034t = new n(this);
    }

    private void d(ab abVar, u uVar, boolean z16) {
        if (z16 || abVar.f73916b != null) {
            com.tencent.av.utils.ab abVar2 = this.f74029o;
            if (abVar2 != null) {
                abVar2.e("faceDetect");
            }
            a aVar = this.f74024j;
            if (aVar != null) {
                aVar.d(this.f74020f);
            }
            com.tencent.av.utils.ab abVar3 = this.f74029o;
            if (abVar3 != null) {
                abVar3.d("faceDetect");
            }
        }
    }

    private void f(com.tencent.avcore.camera.data.c cVar, ab abVar, boolean z16, com.tencent.av.utils.p pVar, boolean z17) {
        boolean z18;
        String str;
        boolean z19;
        boolean z26;
        m();
        boolean z27 = this.f74026l;
        boolean z28 = true;
        if (z27 != abVar.f73921g) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            a aVar = this.f74024j;
            if (aVar != null && !z27) {
                aVar.o();
            } else {
                a aVar2 = this.f74025k;
                if (aVar2 != null && z27) {
                    aVar2.o();
                }
            }
            QLog.d(this.f74015a, 1, "mode change zlanMode:=" + this.f74026l);
        }
        boolean z29 = abVar.f73921g;
        this.f74026l = z29;
        if (this.f74024j != null && (z17 || abVar.f73915a != null || abVar.f73917c != null || abVar.f73916b != null || z29 || z16)) {
            int i3 = this.f74016b;
            int i16 = this.f74017c;
            if (z29) {
                a aVar3 = this.f74025k;
                if (aVar3 != null) {
                    aVar3.q(i3, i16);
                    this.f74025k.g(null, abVar.f73916b);
                    t tVar = this.f74031q;
                    this.f74032r = t.a(tVar.f74045a, tVar.f74046b);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    this.f74032r.f74046b = this.f74025k.k(this.f74031q.f74046b, false, this.f74020f, abVar.f73919e);
                    AvatarAIInfo m3 = this.f74025k.m();
                    this.f74040z.c(SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - elapsedRealtime);
                    com.tencent.av.avatar.a aVar4 = this.f74038x;
                    if (aVar4 != null) {
                        aVar4.a(m3, cVar.f77449i);
                    }
                }
            } else {
                com.tencent.av.utils.ab abVar2 = this.f74029o;
                if (abVar2 != null) {
                    abVar2.e("drawFrameInGL");
                }
                n nVar = this.f74034t;
                if (nVar != null) {
                    str = "drawFrameInGL";
                    nVar.b(cVar, abVar, this.f74031q, this.f74016b, this.f74017c);
                    p pVar2 = this.f74020f;
                    if (this.f74034t.f73997c != 0) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    pVar2.f74014k = z26;
                } else {
                    str = "drawFrameInGL";
                }
                this.f74024j.q(i3, i16);
                boolean f16 = this.f74024j.f();
                this.f74024j.j(abVar.f73915a);
                this.f74024j.g(abVar.f73917c, abVar.f73916b);
                this.f74024j.p(z16);
                t tVar2 = this.f74031q;
                this.f74032r = t.a(tVar2.f74045a, tVar2.f74046b);
                this.f74030p.a(4, 0);
                this.f74032r.f74046b = this.f74024j.k(this.f74031q.f74046b, false, this.f74020f, abVar.f73919e);
                this.f74030p.a(4, 1);
                boolean f17 = this.f74024j.f();
                if (this.f74024j.l()) {
                    a(128);
                }
                if (abVar.f73915a != null) {
                    a(16);
                }
                if (abVar.f73917c != null || abVar.f73916b != null) {
                    a(32);
                }
                if (this.f74024j.r()) {
                    a(64);
                }
                if (z17) {
                    a(8);
                }
                com.tencent.av.utils.ab abVar3 = this.f74029o;
                if (abVar3 != null) {
                    abVar3.d(str);
                }
                if (pVar != null) {
                    if (abVar.f73915a != null) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (abVar.f73916b == null) {
                        z28 = false;
                    }
                    pVar.l(z19, z28, z16, z17);
                }
                e(2, this.f74031q, this.f74032r);
                n nVar2 = this.f74034t;
                if (nVar2 != null) {
                    nVar2.c(this.f74032r, f16, f17, this.f74016b, this.f74017c);
                }
            }
        }
        n nVar3 = this.f74034t;
        if (nVar3 != null) {
            nVar3.f(cVar, abVar);
        }
    }

    private void h(long j3, int i3, int i16) {
        if (i3 != 0 && i16 != 0) {
            if (this.f74016b != i3 || this.f74017c != i16) {
                if (QLog.isColorLevel()) {
                    QLog.w(this.f74015a, 1, "innerUpdatePreviewSize, width[" + this.f74016b + "->" + i3 + "], height[" + this.f74017c + "->" + i16 + "], seq[" + j3 + "]");
                }
                this.f74016b = i3;
                this.f74017c = i16;
                this.f74019e = AVGLUtils.initFrameBuffer(i3, i16, this.f74018d);
                x xVar = this.f74036v;
                if (xVar != null) {
                    xVar.g(i3, i16);
                }
                w wVar = this.f74037w;
                if (wVar != null) {
                    wVar.g(i3, i16);
                }
                i();
                com.tencent.sveffects.a.b();
            }
        }
    }

    private void i() {
        if (this.f74035u != null) {
            return;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.f74035u = asFloatBuffer;
        asFloatBuffer.put(new float[]{-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f});
        this.f74035u.position(0);
    }

    private void k(ab abVar, com.tencent.avcore.camera.data.c cVar, ac acVar, long j3) {
        w wVar = this.f74037w;
        if (wVar != null && !abVar.f73921g) {
            wVar.e(this, cVar, this.f74032r, this.f74020f, acVar);
        }
        this.f74021g = false;
        if (acVar.f73922a == null) {
            acVar.f73922a = cVar;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.avcore.camera.data.c cVar2 = acVar.f73922a;
        cVar2.f77453m = (int) (currentTimeMillis - j3);
        cVar2.f77454n = this.f74023i;
        com.tencent.av.utils.ab abVar2 = this.f74029o;
        if (abVar2 != null) {
            abVar2.b(cVar.f77450j);
        }
        MemoryPerfStat.f().i(this.f74023i);
    }

    private void l(com.tencent.avcore.camera.data.c cVar) {
        boolean z16;
        t tVar = this.f74032r;
        if (tVar == null) {
            this.f74032r = t.a(this.f74019e, this.f74018d);
        } else {
            tVar.f74045a = this.f74019e;
            tVar.f74046b = this.f74018d;
        }
        x xVar = this.f74036v;
        if (xVar != null && !xVar.d(cVar)) {
            this.f74036v.f();
            this.f74036v.a();
            this.f74036v = null;
            if (QLog.isDevelopLevel()) {
                QLog.i("SurfaceTag", 4, "preRender, not match frame.");
            }
        }
        if (this.f74036v == null) {
            if (cVar.i()) {
                ah ahVar = new ah();
                this.f74036v = ahVar;
                ahVar.c();
                this.f74036v.g(this.f74016b, this.f74017c);
                z16 = false;
            } else {
                SurfaceTexture surfaceTexture = cVar.f77455o;
                if (surfaceTexture != null) {
                    af afVar = new af(surfaceTexture);
                    this.f74036v = afVar;
                    afVar.c();
                    this.f74036v.g(this.f74016b, this.f74017c);
                }
                z16 = true;
            }
            ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).setFilterProcessRenderMode(z16);
            if (QLog.isDevelopLevel()) {
                QLog.i("SurfaceTag", 4, "preRender, new render for frame.");
            }
        }
        x xVar2 = this.f74036v;
        if (xVar2 != null && xVar2.d(cVar)) {
            m();
            this.f74032r = this.f74036v.b(this, cVar, this.f74031q);
        }
    }

    private void n(com.tencent.avcore.camera.data.c cVar, ac acVar, long j3) {
        cVar.f77442b = this.f74017c;
        cVar.f77443c = this.f74016b;
        this.f74021g = false;
        cVar.f77453m = (int) (System.currentTimeMillis() - j3);
        cVar.f77454n = this.f74023i;
        x xVar = this.f74036v;
        if (xVar != null) {
            xVar.a();
        }
        w wVar = this.f74037w;
        if (wVar != null) {
            wVar.a();
        }
        com.tencent.av.utils.ab abVar = this.f74029o;
        if (abVar != null) {
            abVar.b(cVar.f77450j);
        }
        MemoryPerfStat.f().i(this.f74023i);
        acVar.b(cVar, null, null, null, (short) 0, (short) 0);
    }

    protected void a(int i3) {
        this.f74023i = i3 | this.f74023i;
    }

    public void b(long j3) {
        QLog.w(this.f74015a, 1, "clear, seq[" + j3 + "]");
        x xVar = this.f74036v;
        if (xVar != null) {
            xVar.a();
            this.f74036v.f();
        }
        int i3 = this.f74019e;
        if (i3 != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
            this.f74019e = -1;
        }
        int i16 = this.f74018d;
        if (i16 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i16}, 0);
            this.f74018d = -1;
        }
        w wVar = this.f74037w;
        if (wVar != null) {
            wVar.f();
        }
        a aVar = this.f74024j;
        if (aVar != null) {
            aVar.o();
            this.f74024j = null;
        }
        a aVar2 = this.f74025k;
        if (aVar2 != null) {
            aVar2.o();
            this.f74025k = null;
        }
        n nVar = this.f74034t;
        if (nVar != null) {
            nVar.a();
        }
        ag.e().d(j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j3) {
        a aVar = this.f74024j;
        if (aVar != null) {
            aVar.a(j3);
        } else {
            ag.e().d(j3);
        }
    }

    public void g(long j3, int i3) {
        if (com.tencent.av.utils.e.k()) {
            QLog.w(this.f74015a, 1, "initial, szie[" + this.f74016b + ", " + this.f74017c + "], id[" + this.f74018d + "], seq[" + j3 + "]");
        }
        this.f74022h = true;
        this.f74021g = false;
        if (this.f74018d != -1) {
            return;
        }
        if (j.D()) {
            if (this.f74024j == null) {
                AEFilterAVWrapperImpl aEFilterAVWrapperImpl = new AEFilterAVWrapperImpl(i3);
                this.f74024j = aEFilterAVWrapperImpl;
                aEFilterAVWrapperImpl.h(this.f74016b, this.f74017c);
            }
            if (this.f74025k == null) {
                AEFilterAVWrapperImpl aEFilterAVWrapperImpl2 = new AEFilterAVWrapperImpl(2);
                this.f74025k = aEFilterAVWrapperImpl2;
                aEFilterAVWrapperImpl2.h(640, 480);
            }
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f74018d = iArr[0];
        x xVar = this.f74036v;
        if (xVar != null) {
            xVar.c();
        }
        w wVar = this.f74037w;
        if (wVar != null) {
            wVar.c();
        }
        this.f74023i = 0;
        n nVar = this.f74034t;
        if (nVar != null) {
            nVar.e();
        }
    }

    public void j(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f74015a, 2, "notifyDownloadFinish: path = " + str + " agent = " + str2);
        }
        a aVar = this.f74024j;
        if (aVar != null) {
            aVar.c(str, str2);
        }
    }

    protected void m() {
        t tVar = this.f74031q;
        if (tVar != this.f74032r && tVar != null) {
            tVar.b();
            this.f74031q = null;
        }
        this.f74031q = this.f74032r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        a aVar = this.f74024j;
        if (aVar != null) {
            aVar.o();
        }
    }

    public void p(com.tencent.avcore.camera.data.c cVar, ab abVar, u uVar, ac acVar) {
        ab abVar2;
        boolean z16;
        boolean z17;
        boolean z18;
        com.tencent.av.utils.ab abVar3 = this.f74029o;
        if (abVar3 != null) {
            abVar3.c();
        }
        long currentTimeMillis = System.currentTimeMillis();
        acVar.f73922a = cVar;
        h(0L, cVar.f77443c, cVar.f77442b);
        int i3 = cVar.f77442b;
        int i16 = cVar.f77443c;
        int a16 = ad.a(cVar.f77447g);
        boolean z19 = abVar.f73918d;
        if (this.f74039y != z19) {
            if (QLog.isDevelopLevel()) {
                QLog.i(this.f74015a, 4, "render, needFaceData[" + z19 + "]");
            }
            this.f74039y = z19;
        }
        this.f74028n.a(this.f74015a, cVar.f77450j, i3, i16, cVar.f77445e, abVar.f73918d, abVar.f73915a, abVar.f73916b, abVar.f73917c, cVar, this.f74033s.b("BEAUTY_SKIN"));
        if (this.f74016b != 0 && this.f74017c != 0 && !cVar.j() && this.f74019e != -1 && this.f74022h) {
            this.f74021g = true;
            com.tencent.av.utils.p pVar = (com.tencent.av.utils.p) cVar.f77452l;
            if (pVar != null) {
                pVar.q(a16);
            }
            this.f74020f.a(i3, i16);
            cVar.i();
            a aVar = this.f74024j;
            if (aVar != null) {
                abVar2 = abVar;
                z16 = aVar.b(this.f74033s);
            } else {
                abVar2 = abVar;
                z16 = false;
            }
            if (abVar2.f73915a == null && abVar2.f73916b == null) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17 && !z19 && !z16 && !abVar2.f73921g) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (abVar2.f73920f && z18) {
                if (abVar2.f73921g) {
                    cVar.f77451k = 3;
                }
                PerfReporter.g("prerender_time", 0);
                this.f74030p.a(0, 0);
                l(cVar);
                PerfReporter.g("prerender_time", 1);
                this.f74030p.a(0, 1);
                PerfReporter.g("aefilter_time", 0);
                this.f74030p.a(1, 0);
                f(cVar, abVar, z19, pVar, z16);
                PerfReporter.g("aefilter_time", 1);
                this.f74030p.a(1, 1);
                this.f74030p.a(2, 0);
                d(abVar2, uVar, z19);
                this.f74030p.a(2, 1);
                PerfReporter.g("postrender_time", 0);
                this.f74030p.a(3, 0);
                k(abVar, cVar, acVar, currentTimeMillis);
                PerfReporter.g("postrender_time", 1);
                this.f74030p.a(3, 1);
            } else if (cVar.i()) {
                n(cVar, acVar, currentTimeMillis);
            } else {
                PerfReporter.g("prerender_time", 0);
                this.f74030p.a(0, 0);
                l(cVar);
                PerfReporter.g("prerender_time", 1);
                this.f74030p.a(0, 1);
                PerfReporter.g("postrender_time", 0);
                this.f74030p.a(3, 0);
                k(abVar, cVar, acVar, currentTimeMillis);
                PerfReporter.g("postrender_time", 1);
                this.f74030p.a(3, 1);
            }
            this.f74030p.b();
        }
    }

    public void q(CameraConfig.DeviceCameraOrientation deviceCameraOrientation) {
        a aVar = this.f74025k;
        if (aVar != null) {
            aVar.e(deviceCameraOrientation);
        }
    }

    public void r(CameraConfig.DeviceCameraOrientation deviceCameraOrientation) {
        a aVar = this.f74024j;
        if (aVar != null) {
            aVar.e(deviceCameraOrientation);
        }
    }

    public void s(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(this.f74015a, 2, "setFrontOrBackCamera: isFrontCamera = " + z16);
        }
        a aVar = this.f74024j;
        if (aVar != null) {
            aVar.i(z16);
        }
    }

    public void t(com.tencent.av.avatar.a aVar) {
        this.f74038x = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(this.f74015a, 1, "uninit, mIsInited[" + this.f74022h + "], mIsRendering[" + this.f74021g + "], seq[" + d16 + "]");
        if (!this.f74022h) {
            return;
        }
        this.f74022h = false;
        w wVar = this.f74037w;
        if (wVar != null) {
            wVar.a();
        }
        x xVar = this.f74036v;
        if (xVar != null) {
            xVar.a();
        }
        c(d16);
        a aVar = this.f74024j;
        if (aVar != null) {
            aVar.n();
        }
        a aVar2 = this.f74025k;
        if (aVar2 != null) {
            aVar2.o();
        }
        com.tencent.av.utils.ab abVar = this.f74029o;
        if (abVar != null) {
            abVar.a();
        }
        ag.e().c();
    }

    public void e(int i3, t tVar, t tVar2) {
    }
}
