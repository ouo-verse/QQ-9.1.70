package com.tencent.mapsdk.internal;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.opengl.GLUtils;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.lb;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ua extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    public static final String f151157a = "tms-gl";

    /* renamed from: b, reason: collision with root package name */
    public static final int f151158b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f151159c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f151160d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f151161e = 2;

    /* renamed from: f, reason: collision with root package name */
    public static final int f151162f = 60;

    /* renamed from: j, reason: collision with root package name */
    private static final String f151163j = "GLSurfaceView";

    /* renamed from: k, reason: collision with root package name */
    private static final boolean f151164k = false;

    /* renamed from: l, reason: collision with root package name */
    private static final boolean f151165l = false;

    /* renamed from: m, reason: collision with root package name */
    private static final boolean f151166m = false;

    /* renamed from: n, reason: collision with root package name */
    private static final boolean f151167n = false;

    /* renamed from: o, reason: collision with root package name */
    private static final boolean f151168o = false;

    /* renamed from: p, reason: collision with root package name */
    private static final boolean f151169p = true;

    /* renamed from: q, reason: collision with root package name */
    private static final boolean f151170q = false;

    /* renamed from: r, reason: collision with root package name */
    private static final j f151171r = new j(0);
    private int A;
    private boolean B;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f151172g;

    /* renamed from: h, reason: collision with root package name */
    protected int f151173h;

    /* renamed from: i, reason: collision with root package name */
    i f151174i;

    /* renamed from: s, reason: collision with root package name */
    private final WeakReference<ua> f151175s;

    /* renamed from: t, reason: collision with root package name */
    private m f151176t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f151177u;

    /* renamed from: v, reason: collision with root package name */
    private e f151178v;

    /* renamed from: w, reason: collision with root package name */
    private f f151179w;

    /* renamed from: x, reason: collision with root package name */
    private g f151180x;

    /* renamed from: y, reason: collision with root package name */
    private k f151181y;

    /* renamed from: z, reason: collision with root package name */
    private int f151182z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d implements g {
        d() {
        }

        @Override // com.tencent.mapsdk.internal.ua.g
        public final EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e16) {
                Log.e(ua.f151163j, "eglCreateWindowSurface", e16);
                return null;
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }

        /* synthetic */ d(byte b16) {
            this();
        }

        @Override // com.tencent.mapsdk.internal.ua.g
        public final void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class i extends BaseThread {

        /* renamed from: a, reason: collision with root package name */
        boolean f151201a;

        /* renamed from: b, reason: collision with root package name */
        boolean f151202b;

        /* renamed from: c, reason: collision with root package name */
        boolean f151203c;

        /* renamed from: d, reason: collision with root package name */
        boolean f151204d;

        /* renamed from: e, reason: collision with root package name */
        boolean f151205e;

        /* renamed from: f, reason: collision with root package name */
        boolean f151206f;

        /* renamed from: g, reason: collision with root package name */
        boolean f151207g;

        /* renamed from: h, reason: collision with root package name */
        boolean f151208h;

        /* renamed from: m, reason: collision with root package name */
        boolean f151213m;

        /* renamed from: p, reason: collision with root package name */
        private long f151216p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f151217q;

        /* renamed from: r, reason: collision with root package name */
        private boolean f151218r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f151219s;

        /* renamed from: u, reason: collision with root package name */
        private h f151221u;

        /* renamed from: v, reason: collision with root package name */
        private WeakReference<ua> f151222v;

        /* renamed from: n, reason: collision with root package name */
        ArrayList<Runnable> f151214n = new ArrayList<>();

        /* renamed from: o, reason: collision with root package name */
        boolean f151215o = true;

        /* renamed from: t, reason: collision with root package name */
        private float f151220t = 60.0f;

        /* renamed from: i, reason: collision with root package name */
        int f151209i = 0;

        /* renamed from: j, reason: collision with root package name */
        int f151210j = 0;

        /* renamed from: l, reason: collision with root package name */
        boolean f151212l = true;

        /* renamed from: k, reason: collision with root package name */
        int f151211k = 1;

        i(WeakReference<ua> weakReference) {
            this.f151222v = weakReference;
            setName(ua.a("SV"));
            LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " create");
        }

        static /* synthetic */ boolean a(i iVar) {
            iVar.f151201a = true;
            return true;
        }

        private void h() {
            if (this.f151206f) {
                this.f151206f = false;
                this.f151221u.a();
                LogUtil.a(g()).c(lb.a.f149160g, "stopEglSurfaceLocked");
            }
        }

        private void i() {
            if (this.f151205e) {
                this.f151221u.b();
                this.f151205e = false;
                ua.f151171r.c(this);
                LogUtil.a(g()).c(lb.a.f149160g, "stopEglContextLocked");
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:153:0x03dc  */
        /* JADX WARN: Removed duplicated region for block: B:156:0x03e9 A[Catch: all -> 0x0410, Exception -> 0x0412, TRY_LEAVE, TryCatch #7 {Exception -> 0x0412, blocks: (B:3:0x001c, B:4:0x0020, B:213:0x0212, B:76:0x021b, B:78:0x0221, B:80:0x0225, B:82:0x0229, B:84:0x0236, B:85:0x025b, B:87:0x025f, B:90:0x0264, B:92:0x0270, B:95:0x0297, B:96:0x029b, B:103:0x02eb, B:105:0x02fd, B:107:0x0303, B:108:0x030b, B:110:0x0313, B:113:0x031e, B:115:0x0326, B:116:0x032d, B:119:0x0331, B:121:0x033e, B:123:0x0348, B:126:0x0356, B:128:0x0360, B:130:0x0368, B:132:0x0370, B:133:0x0373, B:135:0x0387, B:136:0x0391, B:138:0x0399, B:140:0x03a9, B:144:0x03b7, B:145:0x03c4, B:154:0x03df, B:156:0x03e9, B:166:0x03f4, B:177:0x03d3, B:185:0x02ab, B:186:0x02ac, B:187:0x02b0, B:196:0x02c6, B:198:0x0281, B:200:0x028b, B:201:0x0252, B:203:0x02c7, B:204:0x02cf, B:206:0x02d0, B:207:0x02d8, B:209:0x02d9, B:210:0x02e1, B:282:0x040f), top: B:2:0x001c, outer: #9 }] */
        /* JADX WARN: Removed duplicated region for block: B:173:0x03dd  */
        /* JADX WARN: Removed duplicated region for block: B:186:0x02ac A[Catch: all -> 0x0410, Exception -> 0x0412, TryCatch #7 {Exception -> 0x0412, blocks: (B:3:0x001c, B:4:0x0020, B:213:0x0212, B:76:0x021b, B:78:0x0221, B:80:0x0225, B:82:0x0229, B:84:0x0236, B:85:0x025b, B:87:0x025f, B:90:0x0264, B:92:0x0270, B:95:0x0297, B:96:0x029b, B:103:0x02eb, B:105:0x02fd, B:107:0x0303, B:108:0x030b, B:110:0x0313, B:113:0x031e, B:115:0x0326, B:116:0x032d, B:119:0x0331, B:121:0x033e, B:123:0x0348, B:126:0x0356, B:128:0x0360, B:130:0x0368, B:132:0x0370, B:133:0x0373, B:135:0x0387, B:136:0x0391, B:138:0x0399, B:140:0x03a9, B:144:0x03b7, B:145:0x03c4, B:154:0x03df, B:156:0x03e9, B:166:0x03f4, B:177:0x03d3, B:185:0x02ab, B:186:0x02ac, B:187:0x02b0, B:196:0x02c6, B:198:0x0281, B:200:0x028b, B:201:0x0252, B:203:0x02c7, B:204:0x02cf, B:206:0x02d0, B:207:0x02d8, B:209:0x02d9, B:210:0x02e1, B:282:0x040f), top: B:2:0x001c, outer: #9 }] */
        /* JADX WARN: Removed duplicated region for block: B:216:0x03ff A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x01e0 A[Catch: all -> 0x040d, TryCatch #6 {, blocks: (B:6:0x0021, B:266:0x0025, B:268:0x002f, B:269:0x0036, B:8:0x0047, B:264:0x004f, B:72:0x020f, B:10:0x005c, B:12:0x0062, B:13:0x006d, B:15:0x0071, B:17:0x007d, B:19:0x0088, B:21:0x008c, B:23:0x0091, B:25:0x0095, B:27:0x009f, B:31:0x00aa, B:33:0x00b4, B:36:0x00b9, B:38:0x00c3, B:39:0x00c8, B:41:0x00cc, B:43:0x00d0, B:45:0x00d4, B:46:0x00d7, B:47:0x00e4, B:49:0x00e8, B:51:0x00ec, B:53:0x00f8, B:54:0x0104, B:56:0x010a, B:60:0x01dc, B:62:0x01e0, B:64:0x01e4, B:65:0x01ea, B:68:0x01ee, B:70:0x01f2, B:71:0x0201, B:217:0x03ff, B:218:0x0117, B:221:0x0121, B:225:0x013a, B:227:0x0144, B:229:0x014e, B:230:0x0176, B:237:0x017a, B:234:0x0190, B:235:0x01cc, B:232:0x0181, B:242:0x0156, B:244:0x015e, B:241:0x01b4, B:246:0x0193, B:247:0x019d, B:253:0x01a0, B:254:0x01ac), top: B:5:0x0021 }] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01ee A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0297 A[Catch: all -> 0x0410, Exception -> 0x0412, TryCatch #7 {Exception -> 0x0412, blocks: (B:3:0x001c, B:4:0x0020, B:213:0x0212, B:76:0x021b, B:78:0x0221, B:80:0x0225, B:82:0x0229, B:84:0x0236, B:85:0x025b, B:87:0x025f, B:90:0x0264, B:92:0x0270, B:95:0x0297, B:96:0x029b, B:103:0x02eb, B:105:0x02fd, B:107:0x0303, B:108:0x030b, B:110:0x0313, B:113:0x031e, B:115:0x0326, B:116:0x032d, B:119:0x0331, B:121:0x033e, B:123:0x0348, B:126:0x0356, B:128:0x0360, B:130:0x0368, B:132:0x0370, B:133:0x0373, B:135:0x0387, B:136:0x0391, B:138:0x0399, B:140:0x03a9, B:144:0x03b7, B:145:0x03c4, B:154:0x03df, B:156:0x03e9, B:166:0x03f4, B:177:0x03d3, B:185:0x02ab, B:186:0x02ac, B:187:0x02b0, B:196:0x02c6, B:198:0x0281, B:200:0x028b, B:201:0x0252, B:203:0x02c7, B:204:0x02cf, B:206:0x02d0, B:207:0x02d8, B:209:0x02d9, B:210:0x02e1, B:282:0x040f), top: B:2:0x001c, outer: #9 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void j() throws InterruptedException {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            l lVar;
            boolean z26;
            boolean z27;
            int i3;
            int i16;
            int i17;
            l lVar2;
            boolean z28;
            boolean z29;
            boolean z36;
            boolean z37;
            boolean z38;
            h hVar;
            EGLDisplay eglGetDisplay;
            boolean z39;
            this.f151221u = new h(this.f151222v);
            this.f151205e = false;
            this.f151206f = false;
            boolean z46 = false;
            boolean z47 = false;
            boolean z48 = false;
            boolean z49 = false;
            boolean z55 = false;
            boolean z56 = false;
            boolean z57 = false;
            int i18 = 0;
            int i19 = 0;
            boolean z58 = false;
            Runnable runnable = null;
            GL10 gl10 = null;
            while (true) {
                try {
                    try {
                        synchronized (ua.f151171r) {
                            while (!this.f151217q) {
                                if (!this.f151214n.isEmpty()) {
                                    runnable = this.f151214n.remove(0);
                                    z16 = false;
                                } else {
                                    boolean z59 = this.f151202b;
                                    boolean z65 = this.f151218r;
                                    if (z59 != z65) {
                                        this.f151202b = z65;
                                        ua.f151171r.notifyAll();
                                    } else {
                                        z65 = false;
                                    }
                                    if (this.f151208h) {
                                        h();
                                        i();
                                        this.f151208h = false;
                                        z48 = true;
                                    }
                                    if (z46) {
                                        h();
                                        i();
                                        z29 = false;
                                    } else {
                                        z29 = z46;
                                    }
                                    if (z65 && this.f151206f) {
                                        h();
                                    }
                                    if (z65 && this.f151205e) {
                                        ua uaVar = this.f151222v.get();
                                        if (uaVar != null && uaVar.B) {
                                            z39 = true;
                                        } else {
                                            z39 = false;
                                        }
                                        if (!z39 || ua.f151171r.a()) {
                                            i();
                                        }
                                    }
                                    if (z65 && ua.f151171r.b()) {
                                        this.f151221u.b();
                                    }
                                    if (!this.f151203c && !this.f151204d) {
                                        if (this.f151206f) {
                                            h();
                                        }
                                        this.f151204d = true;
                                        this.f151219s = false;
                                        ua.f151171r.notifyAll();
                                    }
                                    if (this.f151203c && this.f151204d) {
                                        this.f151204d = false;
                                        ua.f151171r.notifyAll();
                                    }
                                    if (z47) {
                                        this.f151213m = true;
                                        ua.f151171r.notifyAll();
                                        z47 = false;
                                        z58 = false;
                                    }
                                    if (a()) {
                                        if (!this.f151205e) {
                                            if (z48) {
                                                z36 = z29;
                                                z37 = z47;
                                                z48 = false;
                                            } else if (ua.f151171r.b(this)) {
                                                try {
                                                    hVar = this.f151221u;
                                                    EGL10 egl10 = (EGL10) EGLContext.getEGL();
                                                    hVar.f151196b = egl10;
                                                    eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                                                    hVar.f151197c = eglGetDisplay;
                                                } catch (RuntimeException e16) {
                                                    e = e16;
                                                    z36 = z29;
                                                }
                                                if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                                                    z36 = z29;
                                                    try {
                                                    } catch (RuntimeException e17) {
                                                        e = e17;
                                                        z37 = z47;
                                                        ua.f151171r.c(this);
                                                        LogUtil.a(g()).e(lb.a.f149160g, "egl helper start exception", e);
                                                        this.f151205e = true;
                                                        ua.f151171r.notifyAll();
                                                        z55 = true;
                                                        if (this.f151205e) {
                                                        }
                                                        if (!this.f151206f) {
                                                        }
                                                    }
                                                    if (hVar.f151196b.eglInitialize(eglGetDisplay, new int[2])) {
                                                        ua uaVar2 = hVar.f151195a.get();
                                                        if (uaVar2 != null) {
                                                            z37 = z47;
                                                            hVar.f151199e = uaVar2.f151178v.a(hVar.f151196b, hVar.f151197c);
                                                            hVar.f151200f = uaVar2.f151179w.a(hVar.f151196b, hVar.f151197c, hVar.f151199e);
                                                        } else {
                                                            hVar.f151199e = null;
                                                            hVar.f151200f = null;
                                                            z37 = z47;
                                                        }
                                                        EGLContext eGLContext = hVar.f151200f;
                                                        if (eGLContext != null) {
                                                            try {
                                                                if (eGLContext == EGL10.EGL_NO_CONTEXT) {
                                                                }
                                                                hVar.f151198d = null;
                                                            } catch (RuntimeException e18) {
                                                                e = e18;
                                                                ua.f151171r.c(this);
                                                                LogUtil.a(g()).e(lb.a.f149160g, "egl helper start exception", e);
                                                                this.f151205e = true;
                                                                ua.f151171r.notifyAll();
                                                                z55 = true;
                                                                if (this.f151205e) {
                                                                }
                                                                if (!this.f151206f) {
                                                                }
                                                            }
                                                            this.f151205e = true;
                                                            ua.f151171r.notifyAll();
                                                            z55 = true;
                                                        }
                                                        hVar.f151200f = null;
                                                        hVar.f151196b.eglGetError();
                                                        h.a("createContext");
                                                        hVar.f151198d = null;
                                                        this.f151205e = true;
                                                        ua.f151171r.notifyAll();
                                                        z55 = true;
                                                    } else {
                                                        throw new RuntimeException("eglInitialize failed");
                                                    }
                                                } else {
                                                    throw new RuntimeException("eglGetDisplay failed");
                                                }
                                            }
                                            if (this.f151205e && !this.f151206f) {
                                                this.f151206f = true;
                                                z49 = true;
                                                z56 = true;
                                                z57 = true;
                                            }
                                            if (!this.f151206f) {
                                                if (this.f151215o) {
                                                    int i26 = this.f151209i;
                                                    int i27 = this.f151210j;
                                                    z16 = false;
                                                    this.f151215o = false;
                                                    i18 = i26;
                                                    i19 = i27;
                                                    z38 = true;
                                                    z49 = true;
                                                    z58 = true;
                                                } else {
                                                    z16 = false;
                                                    z38 = false;
                                                }
                                                this.f151212l = z16;
                                                ua.f151171r.notifyAll();
                                                z57 = z38;
                                                z46 = z36;
                                                z47 = z37;
                                            }
                                        }
                                        z36 = z29;
                                        z37 = z47;
                                        if (this.f151205e) {
                                            this.f151206f = true;
                                            z49 = true;
                                            z56 = true;
                                            z57 = true;
                                        }
                                        if (!this.f151206f) {
                                        }
                                    } else {
                                        z36 = z29;
                                        z37 = z47;
                                    }
                                    LockMethodProxy.wait(ua.f151171r);
                                    z46 = z36;
                                    z47 = z37;
                                }
                                if (runnable != null) {
                                    runnable.run();
                                    runnable = null;
                                } else {
                                    if (z49) {
                                        h hVar2 = this.f151221u;
                                        if (hVar2.f151196b != null) {
                                            if (hVar2.f151197c != null) {
                                                if (hVar2.f151199e != null) {
                                                    hVar2.a();
                                                    ua uaVar3 = hVar2.f151195a.get();
                                                    if (uaVar3 != null) {
                                                        z17 = z46;
                                                        z18 = z47;
                                                        z19 = z48;
                                                        hVar2.f151198d = uaVar3.f151180x.a(hVar2.f151196b, hVar2.f151197c, hVar2.f151199e, uaVar3.getHolder());
                                                        lVar = null;
                                                    } else {
                                                        z17 = z46;
                                                        z18 = z47;
                                                        z19 = z48;
                                                        lVar = null;
                                                        hVar2.f151198d = null;
                                                    }
                                                    EGLSurface eGLSurface = hVar2.f151198d;
                                                    if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                                                        if (!hVar2.f151196b.eglMakeCurrent(hVar2.f151197c, eGLSurface, eGLSurface, hVar2.f151200f)) {
                                                            hVar2.f151196b.eglGetError();
                                                            h.a("EGLHelper", "eglMakeCurrent");
                                                            z28 = false;
                                                            if (z28) {
                                                                synchronized (ua.f151171r) {
                                                                    this.f151207g = true;
                                                                    ua.f151171r.notifyAll();
                                                                }
                                                                z49 = false;
                                                            } else {
                                                                synchronized (ua.f151171r) {
                                                                    this.f151207g = true;
                                                                    this.f151219s = true;
                                                                    ua.f151171r.notifyAll();
                                                                }
                                                                z46 = z17;
                                                                z47 = z18;
                                                                z48 = z19;
                                                            }
                                                        } else {
                                                            z28 = true;
                                                            if (z28) {
                                                            }
                                                        }
                                                    }
                                                    if (hVar2.f151196b.eglGetError() == 12299) {
                                                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                                                    }
                                                    z28 = false;
                                                    if (z28) {
                                                    }
                                                } else {
                                                    throw new RuntimeException("mEglConfig not initialized");
                                                }
                                            } else {
                                                throw new RuntimeException("eglDisplay not initialized");
                                            }
                                        } else {
                                            throw new RuntimeException("egl not initialized");
                                        }
                                    } else {
                                        z17 = z46;
                                        z18 = z47;
                                        z19 = z48;
                                        lVar = null;
                                    }
                                    if (z56) {
                                        h hVar3 = this.f151221u;
                                        GL gl5 = hVar3.f151200f.getGL();
                                        ua uaVar4 = hVar3.f151195a.get();
                                        if (uaVar4 != null) {
                                            if (uaVar4.f151181y != null) {
                                                gl5 = uaVar4.f151181y.a();
                                            }
                                            if ((uaVar4.f151182z & 3) != 0) {
                                                if ((uaVar4.f151182z & 1) != 0) {
                                                    i17 = 1;
                                                } else {
                                                    i17 = 0;
                                                }
                                                if ((uaVar4.f151182z & 2) != 0) {
                                                    lVar2 = new l();
                                                } else {
                                                    lVar2 = lVar;
                                                }
                                                gl5 = GLDebugHelper.wrap(gl5, i17, lVar2);
                                            }
                                        }
                                        GL10 gl102 = (GL10) gl5;
                                        ua.f151171r.a(gl102);
                                        gl10 = gl102;
                                        z56 = false;
                                    }
                                    if (z55) {
                                        ua uaVar5 = this.f151222v.get();
                                        if (uaVar5 != null) {
                                            uaVar5.f151176t.a(gl10, this.f151221u.f151199e);
                                        }
                                        z55 = false;
                                    }
                                    if (z57) {
                                        ua uaVar6 = this.f151222v.get();
                                        if (uaVar6 != null) {
                                            uaVar6.f151176t.a(gl10, i18, i19);
                                        }
                                        z57 = false;
                                    }
                                    if (this.f151216p != 0) {
                                        SystemClock.elapsedRealtime();
                                    }
                                    this.f151216p = SystemClock.elapsedRealtime();
                                    long elapsedRealtime = SystemClock.elapsedRealtime();
                                    ua uaVar7 = this.f151222v.get();
                                    if (uaVar7 != null) {
                                        z26 = uaVar7.f151176t.a(gl10);
                                    } else {
                                        z26 = false;
                                    }
                                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                                    if (z26) {
                                        h hVar4 = this.f151221u;
                                        if (!hVar4.f151196b.eglSwapBuffers(hVar4.f151197c, hVar4.f151198d)) {
                                            i16 = hVar4.f151196b.eglGetError();
                                        } else {
                                            i16 = 12288;
                                        }
                                        if (i16 != 12288) {
                                            if (i16 != 12302) {
                                                h.a(ua.f151157a, "eglSwapBuffers");
                                                synchronized (ua.f151171r) {
                                                    z27 = true;
                                                    this.f151219s = true;
                                                    ua.f151171r.notifyAll();
                                                }
                                                z46 = z17;
                                                if (!z58) {
                                                    z27 = z18;
                                                }
                                                i3 = (int) ((1000.0f / this.f151220t) - ((float) elapsedRealtime2));
                                                if (i3 > 0) {
                                                    synchronized (this) {
                                                        try {
                                                            wait(i3);
                                                        } catch (InterruptedException unused) {
                                                        }
                                                    }
                                                }
                                                z47 = z27;
                                                z48 = z19;
                                            } else {
                                                z27 = true;
                                                z46 = true;
                                                if (!z58) {
                                                }
                                                i3 = (int) ((1000.0f / this.f151220t) - ((float) elapsedRealtime2));
                                                if (i3 > 0) {
                                                }
                                                z47 = z27;
                                                z48 = z19;
                                            }
                                        }
                                    }
                                    z27 = true;
                                    z46 = z17;
                                    if (!z58) {
                                    }
                                    i3 = (int) ((1000.0f / this.f151220t) - ((float) elapsedRealtime2));
                                    if (i3 > 0) {
                                    }
                                    z47 = z27;
                                    z48 = z19;
                                }
                            }
                            ua uaVar8 = this.f151222v.get();
                            if (uaVar8 != null) {
                                uaVar8.f151176t.ad();
                            }
                            synchronized (ua.f151171r) {
                                h();
                                i();
                            }
                            return;
                        }
                    } catch (Exception e19) {
                        e19.printStackTrace();
                        LogUtil.a(g()).e(lb.a.f149160g, "guardedRun exception", e19);
                        synchronized (ua.f151171r) {
                            h();
                            i();
                            return;
                        }
                    }
                } catch (Throwable th5) {
                    synchronized (ua.f151171r) {
                        h();
                        i();
                        throw th5;
                    }
                }
            }
        }

        private boolean k() {
            if (this.f151205e && this.f151206f && a()) {
                return true;
            }
            return false;
        }

        private void l() {
            synchronized (ua.f151171r) {
                this.f151203c = true;
                this.f151207g = false;
                ua.f151171r.notifyAll();
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " surfaceCreated begin, wait: " + this.f151204d + ", finish: " + this.f151207g + ", exit: " + this.f151201a);
                while (this.f151204d && !this.f151207g && !this.f151201a) {
                    try {
                        LockMethodProxy.wait(ua.f151171r);
                    } catch (InterruptedException e16) {
                        Thread.currentThread().interrupt();
                        LogUtil.a(g()).e(lb.a.f149160g, ua.a("SV") + " surfaceCreated exception", e16);
                    }
                }
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " surfaceCreated end");
            }
        }

        private void m() {
            synchronized (ua.f151171r) {
                this.f151203c = false;
                ua.f151171r.notifyAll();
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " surfaceDestroyed begin, wait: " + this.f151204d + ", exit: " + this.f151201a);
                while (!this.f151204d && !this.f151201a) {
                    try {
                        LockMethodProxy.wait(ua.f151171r);
                    } catch (InterruptedException e16) {
                        Thread.currentThread().interrupt();
                        LogUtil.a(g()).e(lb.a.f149160g, ua.a("SV") + " surfaceDestroyed exception", e16);
                    }
                }
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " surfaceDestroyed end");
            }
        }

        private void n() {
            synchronized (ua.f151171r) {
                this.f151208h = true;
                ua.f151171r.notifyAll();
            }
        }

        public final int b() {
            int i3;
            synchronized (ua.f151171r) {
                i3 = this.f151211k;
            }
            return i3;
        }

        public final void c() {
            synchronized (ua.f151171r) {
                this.f151212l = true;
                ua.f151171r.notifyAll();
            }
        }

        public final void d() {
            synchronized (ua.f151171r) {
                this.f151218r = true;
                ua.f151171r.notifyAll();
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " pause begin, exit: " + this.f151201a + ", pause: " + this.f151202b);
                while (!this.f151201a && !this.f151202b) {
                    try {
                        LockMethodProxy.wait(ua.f151171r);
                    } catch (InterruptedException e16) {
                        Thread.currentThread().interrupt();
                        LogUtil.a(g()).e(lb.a.f149160g, ua.a("SV") + " pause exception", e16);
                    }
                }
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " pause end");
            }
        }

        public final void e() {
            synchronized (ua.f151171r) {
                this.f151218r = false;
                this.f151212l = true;
                this.f151213m = false;
                ua.f151171r.notifyAll();
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " resume begin, exit: " + this.f151201a + ", pause: " + this.f151202b + ", render: " + this.f151213m);
                while (!this.f151201a && this.f151202b && !this.f151213m) {
                    try {
                        LockMethodProxy.wait(ua.f151171r);
                    } catch (InterruptedException e16) {
                        Thread.currentThread().interrupt();
                        LogUtil.a(g()).e(lb.a.f149160g, ua.a("SV") + " resume exception", e16);
                    }
                }
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " resume end");
            }
        }

        public final void f() {
            synchronized (ua.f151171r) {
                this.f151217q = true;
                ua.f151171r.notifyAll();
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " requestExitAndWait begin, exit: " + this.f151201a);
                while (!this.f151201a) {
                    try {
                        LockMethodProxy.wait(ua.f151171r);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " requestExitAndWait end");
            }
        }

        final int g() {
            WeakReference<ua> weakReference = this.f151222v;
            if (weakReference != null && weakReference.get() != null) {
                return this.f151222v.get().getMapId();
            }
            return -1;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " start");
            try {
                try {
                    j();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            } finally {
                ua.f151171r.a(this);
            }
        }

        final boolean a() {
            if (this.f151202b || !this.f151203c || this.f151219s || this.f151209i <= 0 || this.f151210j <= 0) {
                return false;
            }
            return this.f151212l || this.f151211k == 1;
        }

        private void a(int i3) {
            if (i3 >= 0 && i3 <= 1) {
                synchronized (ua.f151171r) {
                    this.f151211k = i3;
                    ua.f151171r.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        private void a(int i3, int i16) {
            synchronized (ua.f151171r) {
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " onWindowResize try begin, width: " + this.f151209i + ", height: " + this.f151210j);
                if (this.f151209i == i3 && this.f151210j == i16) {
                    this.f151215o = false;
                    ua.f151171r.notifyAll();
                    return;
                }
                this.f151209i = i3;
                this.f151210j = i16;
                this.f151215o = true;
                this.f151212l = true;
                this.f151213m = false;
                ua.f151171r.notifyAll();
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " onWindowResize begin, exit: " + this.f151201a + ", pause: " + this.f151202b + ", render: " + this.f151213m);
                while (!this.f151201a && !this.f151202b && !this.f151213m) {
                    if (!(this.f151205e && this.f151206f && a())) {
                        break;
                    }
                    try {
                        LockMethodProxy.wait(ua.f151171r);
                    } catch (InterruptedException e16) {
                        Thread.currentThread().interrupt();
                        LogUtil.a(g()).e(lb.a.f149160g, ua.a("SV") + " onWindowResize exception", e16);
                    }
                }
                LogUtil.a(g()).c(lb.a.f149160g, ua.a("SV") + " onWindowResize end");
            }
        }

        private void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (ua.f151171r) {
                    this.f151214n.add(runnable);
                    ua.f151171r.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public final void a(float f16) {
            if (f16 <= 1.0f) {
                LogUtil.e(ky.f149107m, "\u5e27\u7387\u8bbe\u7f6e\u4e0d\u5728\u6709\u6548\u503c\u8303\u56f4\u5185");
            } else {
                this.f151220t = f16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        private static String f151223a = "GLThreadManager";

        /* renamed from: g, reason: collision with root package name */
        private static final int f151224g = 131072;

        /* renamed from: h, reason: collision with root package name */
        private static final String f151225h = "Q3Dimension MSM7500 ";

        /* renamed from: b, reason: collision with root package name */
        private boolean f151226b;

        /* renamed from: c, reason: collision with root package name */
        private int f151227c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f151228d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f151229e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f151230f;

        /* renamed from: i, reason: collision with root package name */
        private i f151231i;

        j() {
        }

        public final synchronized void a(i iVar) {
            i.a(iVar);
            if (this.f151231i == iVar) {
                this.f151231i = null;
            }
            notifyAll();
        }

        public final synchronized boolean b(i iVar) {
            i iVar2 = this.f151231i;
            if (iVar2 != iVar && iVar2 != null) {
                c();
                if (this.f151229e) {
                    return true;
                }
                i iVar3 = this.f151231i;
                if (iVar3 != null) {
                    synchronized (ua.f151171r) {
                        iVar3.f151208h = true;
                        ua.f151171r.notifyAll();
                    }
                }
                return false;
            }
            this.f151231i = iVar;
            notifyAll();
            return true;
        }

        public final synchronized void c(i iVar) {
            if (this.f151231i == iVar) {
                this.f151231i = null;
            }
            notifyAll();
        }

        /* synthetic */ j(byte b16) {
            this();
        }

        private void c() {
            if (this.f151226b) {
                return;
            }
            this.f151227c = 131072;
            this.f151229e = true;
            this.f151226b = true;
        }

        public final synchronized boolean a() {
            return this.f151230f;
        }

        public final synchronized void a(GL10 gl10) {
            if (!this.f151228d) {
                c();
                String glGetString = gl10.glGetString(7937);
                if (this.f151227c < 131072) {
                    this.f151229e = !glGetString.startsWith(f151225h);
                    notifyAll();
                }
                this.f151230f = this.f151229e ? false : true;
                this.f151228d = true;
            }
        }

        public final synchronized boolean b() {
            c();
            return !this.f151229e;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface k {
        GL a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class l extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private StringBuilder f151232a = new StringBuilder();

        l() {
        }

        private void a() {
            if (this.f151232a.length() > 0) {
                Log.v(ua.f151163j, this.f151232a.toString());
                StringBuilder sb5 = this.f151232a;
                sb5.delete(0, sb5.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            a();
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i3, int i16) {
            for (int i17 = 0; i17 < i16; i17++) {
                char c16 = cArr[i3 + i17];
                if (c16 == '\n') {
                    a();
                } else {
                    this.f151232a.append(c16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface m {
        void a(GL10 gl10, int i3, int i16);

        void a(GL10 gl10, EGLConfig eGLConfig);

        boolean a(GL10 gl10);

        void ad();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n extends b {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public n(boolean z16) {
            super(0, r3, 0);
            int i3;
            if (z16) {
                i3 = 16;
            } else {
                i3 = 0;
            }
        }
    }

    public ua(Context context) {
        super(context);
        this.f151173h = -1;
        this.f151175s = new WeakReference<>(this);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMapId() {
        return this.f151173h;
    }

    public void b() {
        this.f151174i.d();
    }

    protected void finalize() throws Throwable {
        try {
            i iVar = this.f151174i;
            if (iVar != null) {
                iVar.f();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.f151182z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.B;
    }

    public int getRenderMode() {
        return this.f151174i.b();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f151177u) {
            this.f151174i.e();
        }
        this.f151177u = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        i iVar = this.f151174i;
        if (iVar != null) {
            iVar.d();
        }
        this.f151177u = true;
        super.onDetachedFromWindow();
    }

    public void setDebugFlags(int i3) {
        this.f151182z = i3;
    }

    public void setEGLConfigChooser(e eVar) {
        i();
        this.f151178v = eVar;
    }

    public void setEGLContextClientVersion(int i3) {
        i();
        this.A = i3;
    }

    public void setEGLContextFactory(f fVar) {
        i();
        this.f151179w = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        i();
        this.f151180x = gVar;
    }

    public void setGLWrapper(k kVar) {
        this.f151181y = kVar;
    }

    public void setPreserveEGLContextOnPause(boolean z16) {
        this.B = z16;
    }

    public void setRenderMode(int i3) {
        i iVar = this.f151174i;
        if (i3 >= 0 && i3 <= 1) {
            j jVar = f151171r;
            synchronized (jVar) {
                iVar.f151211k = i3;
                jVar.notifyAll();
            }
            return;
        }
        throw new IllegalArgumentException("renderMode");
    }

    public void setRenderer(m mVar) {
        a(mVar, 60.0f);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        boolean z16;
        i iVar = this.f151174i;
        j jVar = f151171r;
        synchronized (jVar) {
            LogUtil.a(iVar.g()).c(lb.a.f149160g, a("SV") + " onWindowResize try begin, width: " + iVar.f151209i + ", height: " + iVar.f151210j);
            if (iVar.f151209i == i16 && iVar.f151210j == i17) {
                iVar.f151215o = false;
                jVar.notifyAll();
                return;
            }
            iVar.f151209i = i16;
            iVar.f151210j = i17;
            iVar.f151215o = true;
            iVar.f151212l = true;
            iVar.f151213m = false;
            jVar.notifyAll();
            LogUtil.a(iVar.g()).c(lb.a.f149160g, a("SV") + " onWindowResize begin, exit: " + iVar.f151201a + ", pause: " + iVar.f151202b + ", render: " + iVar.f151213m);
            while (!iVar.f151201a && !iVar.f151202b && !iVar.f151213m) {
                if (iVar.f151205e && iVar.f151206f && iVar.a()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    break;
                }
                try {
                    LockMethodProxy.wait(f151171r);
                } catch (InterruptedException e16) {
                    Thread.currentThread().interrupt();
                    LogUtil.a(iVar.g()).e(lb.a.f149160g, a("SV") + " onWindowResize exception", e16);
                }
            }
            LogUtil.a(iVar.g()).c(lb.a.f149160g, a("SV") + " onWindowResize end");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        i iVar = this.f151174i;
        j jVar = f151171r;
        synchronized (jVar) {
            iVar.f151203c = true;
            iVar.f151207g = false;
            jVar.notifyAll();
            LogUtil.a(iVar.g()).c(lb.a.f149160g, a("SV") + " surfaceCreated begin, wait: " + iVar.f151204d + ", finish: " + iVar.f151207g + ", exit: " + iVar.f151201a);
            while (iVar.f151204d && !iVar.f151207g && !iVar.f151201a) {
                try {
                    LockMethodProxy.wait(f151171r);
                } catch (InterruptedException e16) {
                    Thread.currentThread().interrupt();
                    LogUtil.a(iVar.g()).e(lb.a.f149160g, a("SV") + " surfaceCreated exception", e16);
                }
            }
            LogUtil.a(iVar.g()).c(lb.a.f149160g, a("SV") + " surfaceCreated end");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        i iVar = this.f151174i;
        j jVar = f151171r;
        synchronized (jVar) {
            iVar.f151203c = false;
            jVar.notifyAll();
            LogUtil.a(iVar.g()).c(lb.a.f149160g, a("SV") + " surfaceDestroyed begin, wait: " + iVar.f151204d + ", exit: " + iVar.f151201a);
            while (!iVar.f151204d && !iVar.f151201a) {
                try {
                    LockMethodProxy.wait(f151171r);
                } catch (InterruptedException e16) {
                    Thread.currentThread().interrupt();
                    LogUtil.a(iVar.g()).e(lb.a.f149160g, a("SV") + " surfaceDestroyed exception", e16);
                }
            }
            LogUtil.a(iVar.g()).c(lb.a.f149160g, a("SV") + " surfaceDestroyed end");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements f {

        /* renamed from: b, reason: collision with root package name */
        private int f151194b;

        c() {
            this.f151194b = EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION;
        }

        @Override // com.tencent.mapsdk.internal.ua.f
        public final EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f151194b, ua.this.A, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (ua.this.A == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        /* synthetic */ c(ua uaVar, byte b16) {
            this();
        }

        @Override // com.tencent.mapsdk.internal.ua.f
        public final void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            egl10.eglGetError();
            h.a("eglDestroyContex");
        }
    }

    public static String a(String str) {
        return "tms-gl." + str + ".9eef7ec0";
    }

    private void d() {
        getHolder().addCallback(this);
    }

    private boolean e() {
        return this.f151172g;
    }

    private void f() {
        setEGLConfigChooser(new b(8, 16, 8));
    }

    private void h() {
        this.f151174i.c();
    }

    private void i() {
        if (this.f151174i != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void c() {
        i iVar = this.f151174i;
        if (iVar != null) {
            iVar.f();
        }
    }

    public final void a(float f16) {
        i iVar = this.f151174i;
        if (iVar != null) {
            iVar.a(f16);
            this.f151174i.c();
        }
    }

    public void setEGLConfigChooser(boolean z16) {
        setEGLConfigChooser(new n(z16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<ua> f151195a;

        /* renamed from: b, reason: collision with root package name */
        EGL10 f151196b;

        /* renamed from: c, reason: collision with root package name */
        EGLDisplay f151197c;

        /* renamed from: d, reason: collision with root package name */
        EGLSurface f151198d;

        /* renamed from: e, reason: collision with root package name */
        EGLConfig f151199e;

        /* renamed from: f, reason: collision with root package name */
        EGLContext f151200f;

        public h(WeakReference<ua> weakReference) {
            this.f151195a = weakReference;
        }

        private void c() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f151196b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f151197c = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f151196b.eglInitialize(eglGetDisplay, new int[2])) {
                    ua uaVar = this.f151195a.get();
                    if (uaVar != null) {
                        this.f151199e = uaVar.f151178v.a(this.f151196b, this.f151197c);
                        this.f151200f = uaVar.f151179w.a(this.f151196b, this.f151197c, this.f151199e);
                    } else {
                        this.f151199e = null;
                        this.f151200f = null;
                    }
                    EGLContext eGLContext = this.f151200f;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.f151200f = null;
                        this.f151196b.eglGetError();
                        a("createContext");
                    }
                    this.f151198d = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        private boolean d() {
            if (this.f151196b != null) {
                if (this.f151197c != null) {
                    if (this.f151199e != null) {
                        a();
                        ua uaVar = this.f151195a.get();
                        if (uaVar != null) {
                            this.f151198d = uaVar.f151180x.a(this.f151196b, this.f151197c, this.f151199e, uaVar.getHolder());
                        } else {
                            this.f151198d = null;
                        }
                        EGLSurface eGLSurface = this.f151198d;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (!this.f151196b.eglMakeCurrent(this.f151197c, eGLSurface, eGLSurface, this.f151200f)) {
                                this.f151196b.eglGetError();
                                a("EGLHelper", "eglMakeCurrent");
                                return false;
                            }
                            return true;
                        }
                        if (this.f151196b.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        private GL e() {
            l lVar;
            GL gl5 = this.f151200f.getGL();
            ua uaVar = this.f151195a.get();
            if (uaVar != null) {
                if (uaVar.f151181y != null) {
                    gl5 = uaVar.f151181y.a();
                }
                if ((uaVar.f151182z & 3) != 0) {
                    int i3 = 1;
                    if ((uaVar.f151182z & 1) == 0) {
                        i3 = 0;
                    }
                    if ((uaVar.f151182z & 2) != 0) {
                        lVar = new l();
                    } else {
                        lVar = null;
                    }
                    return GLDebugHelper.wrap(gl5, i3, lVar);
                }
                return gl5;
            }
            return gl5;
        }

        private int f() {
            if (!this.f151196b.eglSwapBuffers(this.f151197c, this.f151198d)) {
                return this.f151196b.eglGetError();
            }
            return 12288;
        }

        private void g() {
            a();
        }

        final void a() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f151198d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f151196b.eglMakeCurrent(this.f151197c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            ua uaVar = this.f151195a.get();
            if (uaVar != null) {
                uaVar.f151180x.a(this.f151196b, this.f151197c, this.f151198d);
            }
            this.f151198d = null;
        }

        public final void b() {
            if (this.f151200f != null) {
                ua uaVar = this.f151195a.get();
                if (uaVar != null) {
                    try {
                        EGL10 egl10 = this.f151196b;
                        EGLDisplay eGLDisplay = this.f151197c;
                        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f151200f)) {
                            Log.e("EglHelper", "finish() eglMakeCurrent failed,errorDetail:" + GLUtils.getEGLErrorString(this.f151196b.eglGetError()));
                        }
                    } catch (Exception e16) {
                        Log.e("EglHelper", "finish eglMakeCurrent exceptionDetail:" + Log.getStackTraceString(e16));
                    }
                    uaVar.f151179w.a(this.f151196b, this.f151197c, this.f151200f);
                }
                this.f151200f = null;
            }
            EGLDisplay eGLDisplay2 = this.f151197c;
            if (eGLDisplay2 != null) {
                this.f151196b.eglTerminate(eGLDisplay2);
                this.f151197c = null;
            }
        }

        public static void a(String str) {
            throw new RuntimeException(c(str));
        }

        public static void a(String str, String str2) {
            Log.w(str, c(str2));
        }

        private void b(String str) {
            this.f151196b.eglGetError();
            a(str);
        }

        private static String c(String str) {
            return str + " failed: ";
        }
    }

    ua(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f151173h = -1;
        this.f151175s = new WeakReference<>(this);
        d();
    }

    public final void a(m mVar, float f16) {
        i();
        if (this.f151178v == null) {
            this.f151178v = new n(true);
        }
        byte b16 = 0;
        if (this.f151179w == null) {
            this.f151179w = new c(this, b16);
        }
        if (this.f151180x == null) {
            this.f151180x = new d(b16);
        }
        this.f151176t = mVar;
        i iVar = new i(this.f151175s);
        this.f151174i = iVar;
        iVar.a(f16);
        this.f151174i.start();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    abstract class a implements e {

        /* renamed from: a, reason: collision with root package name */
        protected int[] f151183a;

        public a(int[] iArr, boolean z16) {
            if (z16) {
                int[] iArr2 = new int[17];
                System.arraycopy(iArr, 0, iArr2, 0, 12);
                iArr2[12] = 12338;
                iArr2[13] = 1;
                iArr2[14] = 12337;
                iArr2[15] = 4;
                iArr2[16] = 12344;
                iArr = iArr2;
            }
            if (ua.this.A == 2) {
                int length = iArr.length;
                int[] iArr3 = new int[length + 2];
                int i3 = length - 1;
                System.arraycopy(iArr, 0, iArr3, 0, i3);
                iArr3[i3] = 12352;
                iArr3[length] = 4;
                iArr3[length + 1] = 12344;
                iArr = iArr3;
            }
            this.f151183a = iArr;
        }

        private static int[] a(int[] iArr) {
            int length = iArr.length;
            int[] iArr2 = new int[length + 4];
            int i3 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr2[i3] = 12338;
            iArr2[length] = 1;
            iArr2[length + 1] = 12337;
            iArr2[length + 2] = 4;
            iArr2[length + 3] = 12344;
            return iArr2;
        }

        private int[] b(int[] iArr) {
            if (ua.this.A != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i3 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr2[i3] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.tencent.mapsdk.internal.ua.e
        public final EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f151183a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i3 = iArr[0];
            if (i3 > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i3];
                if (egl10.eglChooseConfig(eGLDisplay, this.f151183a, eGLConfigArr, i3, iArr)) {
                    EGLConfig a16 = a(egl10, eGLDisplay, eGLConfigArr);
                    if (a16 != null) {
                        return a16;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends a {

        /* renamed from: c, reason: collision with root package name */
        protected int f151185c;

        /* renamed from: d, reason: collision with root package name */
        protected int f151186d;

        /* renamed from: e, reason: collision with root package name */
        protected int f151187e;

        /* renamed from: f, reason: collision with root package name */
        protected int f151188f;

        /* renamed from: g, reason: collision with root package name */
        protected int f151189g;

        /* renamed from: h, reason: collision with root package name */
        protected int f151190h;

        /* renamed from: j, reason: collision with root package name */
        private int[] f151192j;

        public b(int i3, int i16, int i17) {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, i3, 12325, i16, 12326, i17, 12344}, ua.this.f151172g);
            this.f151192j = new int[1];
            this.f151185c = 8;
            this.f151186d = 8;
            this.f151187e = 8;
            this.f151188f = i3;
            this.f151189g = i16;
            this.f151190h = i17;
        }

        @Override // com.tencent.mapsdk.internal.ua.a
        public final EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a16 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a17 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a16 >= this.f151189g && a17 >= this.f151190h) {
                    int a18 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a19 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a26 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a27 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a18 == this.f151185c && a19 == this.f151186d && a26 == this.f151187e && a27 == this.f151188f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i3) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i3, this.f151192j)) {
                return this.f151192j[0];
            }
            return 0;
        }
    }

    public void a() {
        this.f151174i.e();
    }

    private void a(Runnable runnable) {
        i iVar = this.f151174i;
        if (runnable != null) {
            j jVar = f151171r;
            synchronized (jVar) {
                iVar.f151214n.add(runnable);
                jVar.notifyAll();
            }
            return;
        }
        throw new IllegalArgumentException("r must not be null");
    }
}
