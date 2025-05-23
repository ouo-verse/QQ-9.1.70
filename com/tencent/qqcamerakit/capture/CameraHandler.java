package com.tencent.qqcamerakit.capture;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.qqcamerakit.capture.camera.CameraControl;
import com.tencent.qqcamerakit.capture.camera2.b;
import com.tencent.qqcamerakit.capture.cameraextend.a;
import com.tencent.qqcamerakit.capture.camerastrategy.f;
import com.tencent.qqcamerakit.common.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CameraHandler extends Handler implements b.j {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private CameraObservable f344766d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, a> f344767e;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, b> f344768f;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class WaitDoneBundle {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f344769a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f344770b;

        WaitDoneBundle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f344770b = new Object();
                this.f344769a = new Runnable() { // from class: com.tencent.qqcamerakit.capture.CameraHandler.WaitDoneBundle.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WaitDoneBundle.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        synchronized (WaitDoneBundle.this.f344770b) {
                            WaitDoneBundle.this.f344770b.notifyAll();
                        }
                    }
                };
            }
        }

        static void a(Message message) {
            if (message == null) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof WaitDoneBundle) {
                ((WaitDoneBundle) obj).f344769a.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public AtomicBoolean f344771a;

        /* renamed from: b, reason: collision with root package name */
        public int f344772b;

        /* renamed from: c, reason: collision with root package name */
        public int f344773c;

        /* renamed from: d, reason: collision with root package name */
        public int f344774d;

        /* renamed from: e, reason: collision with root package name */
        public d f344775e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f344776f;

        /* renamed from: g, reason: collision with root package name */
        public d f344777g;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f344771a = new AtomicBoolean(false);
                this.f344776f = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public AtomicBoolean f344778a;

        /* renamed from: b, reason: collision with root package name */
        public d f344779b;

        /* renamed from: c, reason: collision with root package name */
        public d f344780c;

        /* renamed from: d, reason: collision with root package name */
        public d f344781d;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f344778a = new AtomicBoolean(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f344782a;

        /* renamed from: b, reason: collision with root package name */
        public d f344783b;

        /* renamed from: c, reason: collision with root package name */
        public c.b f344784c;

        /* renamed from: d, reason: collision with root package name */
        public int f344785d;

        /* renamed from: e, reason: collision with root package name */
        public int f344786e;

        /* renamed from: f, reason: collision with root package name */
        public byte[] f344787f;

        /* renamed from: g, reason: collision with root package name */
        public int f344788g;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public CameraHandler(Looper looper, CameraObservable cameraObservable) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) cameraObservable);
            return;
        }
        this.f344767e = new HashMap();
        this.f344768f = new HashMap();
        this.f344766d = cameraObservable;
    }

    @Override // com.tencent.qqcamerakit.capture.camera2.b.j
    public void a(int i3, int i16, String str, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str, objArr);
        } else {
            this.f344766d.b(i3, i16, str, objArr);
        }
    }

    public void b(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), str);
            return;
        }
        String str2 = "Timeout waiting " + j3 + "ms for " + str;
        long uptimeMillis = SystemClock.uptimeMillis() + j3;
        try {
            WaitDoneBundle waitDoneBundle = new WaitDoneBundle();
            post(waitDoneBundle.f344769a);
            synchronized (waitDoneBundle.f344770b) {
                waitDoneBundle.f344770b.wait(j3);
            }
            if (SystemClock.uptimeMillis() > uptimeMillis) {
                throw new IllegalStateException(str2);
            }
        } catch (InterruptedException unused) {
            if (SystemClock.uptimeMillis() <= uptimeMillis) {
            } else {
                throw new IllegalStateException(str2);
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        d dVar;
        d dVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        super.handleMessage(message);
        int i3 = message.what;
        try {
            try {
                if (i3 == 1) {
                    int s16 = CameraControl.l().s(message.arg1);
                    if (s16 == 6) {
                        this.f344766d.b(1, 0, "", new Object[0]);
                        WaitDoneBundle.a(message);
                        return;
                    } else if (s16 != 0) {
                        this.f344766d.b(1, s16, CameraControl.f(s16), new Object[0]);
                        WaitDoneBundle.a(message);
                        return;
                    } else {
                        if (!CameraControl.l().A()) {
                            this.f344766d.b(1, 7, "setDisplayOrientation error", new Object[0]);
                            WaitDoneBundle.a(message);
                            return;
                        }
                        this.f344766d.b(1, 0, "", new Object[0]);
                    }
                } else if (i3 == 2) {
                    if (e.f()) {
                        e.e("CameraHandler", 2, "[handleMessage]RELEASE");
                    }
                    CameraControl.l().t();
                    try {
                        LockMethodProxy.sleep(50L);
                    } catch (InterruptedException unused) {
                    }
                    this.f344766d.b(9, 0, "camera destory", new Object[0]);
                } else if (i3 == 3) {
                    Object[] objArr = (Object[]) message.obj;
                    d dVar3 = (d) objArr[0];
                    d dVar4 = (d) objArr[1];
                    d dVar5 = (d) objArr[2];
                    int intValue = ((Integer) objArr[3]).intValue();
                    String str = (String) objArr[4];
                    CameraControl l3 = CameraControl.l();
                    String str2 = l3.f344811h + "#" + dVar3 + "#" + dVar4 + "#" + dVar5;
                    a aVar = this.f344767e.get(str2);
                    if (aVar == null) {
                        aVar = new a();
                        this.f344767e.put(str2, aVar);
                    }
                    if (!aVar.f344771a.get()) {
                        if (!l3.E()) {
                            this.f344766d.b(2, 20, "set preview format failed", new Object[0]);
                            WaitDoneBundle.a(message);
                            return;
                        }
                        d[] b16 = f.b(dVar3, dVar4, dVar5);
                        if (!l3.F(b16[0])) {
                            this.f344766d.b(2, 21, "set preview size failed", new Object[0]);
                            WaitDoneBundle.a(message);
                            return;
                        }
                        if (!l3.J(b16[1])) {
                            this.f344766d.b(2, 22, "set pic size failed", new Object[0]);
                            WaitDoneBundle.a(message);
                            return;
                        }
                        if (!l3.H(intValue)) {
                            this.f344766d.b(2, 23, "set preview fps failed", new Object[0]);
                            WaitDoneBundle.a(message);
                            return;
                        }
                        aVar.f344772b = l3.p();
                        aVar.f344775e = l3.n();
                        d m3 = l3.m();
                        if (m3 != null) {
                            aVar.f344777g = m3;
                            aVar.f344776f = true;
                        }
                        int[] q16 = l3.q();
                        aVar.f344773c = q16[0];
                        aVar.f344774d = q16[1];
                        aVar.f344771a.getAndSet(true);
                    } else if (!l3.w(aVar)) {
                        this.f344766d.b(2, -1, "set Camera Params failed", new Object[0]);
                        WaitDoneBundle.a(message);
                        return;
                    } else if (e.f()) {
                        e.e("CameraHandler", 2, "Set camera param by cache params");
                    }
                    if (l3.f344812i == 2 && !CameraControl.l().z(str)) {
                        this.f344766d.b(2, 24, "set autoFocus fail", new Object[0]);
                    }
                    if (!l3.A()) {
                        this.f344766d.b(2, 25, "set display orientation failed", new Object[0]);
                        WaitDoneBundle.a(message);
                        return;
                    }
                    this.f344766d.b(2, 0, "", l3.n(), Integer.valueOf(l3.p()), l3.q());
                } else if (i3 == 201) {
                    if (e.f()) {
                        e.e("CameraHandler", 2, "PREVIEW_SET_SURFACE");
                    }
                    if (!CameraControl.l().I((SurfaceTexture) message.obj)) {
                        this.f344766d.b(2, -1, "set preview texture failed", new Object[0]);
                    }
                } else if (i3 == 301) {
                    if (e.f()) {
                        e.e("CameraHandler", 2, "handleMessage, PICTURE_TAKE");
                    }
                    c cVar = (c) message.obj;
                    CameraControl l16 = CameraControl.l();
                    if (!l16.f344809e) {
                        if (e.f()) {
                            e.e("CameraHandler", 2, "[takePicture]Camera is not previewing...");
                        }
                        WaitDoneBundle.a(message);
                        return;
                    } else {
                        if (cVar.f344782a == null) {
                            this.f344766d.b(2, -1, "take picture error", new Object[0]);
                            WaitDoneBundle.a(message);
                            return;
                        }
                        l16.P(cVar);
                    }
                } else if (i3 == 401) {
                    if (e.f()) {
                        e.e("CameraHandler", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
                    }
                    int i16 = message.arg1;
                    if (i16 == 1) {
                        if (!CameraControl.l().Q(true)) {
                            this.f344766d.b(5, -1, "turn on flash light failed", new Object[0]);
                        }
                    } else if (i16 == 2 && !CameraControl.l().Q(false)) {
                        this.f344766d.b(5, -1, "turn off flash light failed", new Object[0]);
                    }
                } else if (i3 != 701) {
                    if (i3 == 1005) {
                        Object[] objArr2 = (Object[]) message.obj;
                        d dVar6 = (d) objArr2[0];
                        d dVar7 = (d) objArr2[1];
                        d dVar8 = (d) objArr2[2];
                        int intValue2 = ((Integer) objArr2[3]).intValue();
                        int intValue3 = ((Integer) objArr2[4]).intValue();
                        com.tencent.qqcamerakit.capture.camera2.b Q = com.tencent.qqcamerakit.capture.camera2.b.Q();
                        String str3 = com.tencent.qqcamerakit.capture.camera2.b.U + "#" + dVar6 + "#" + dVar7 + "#" + dVar8;
                        if (e.f()) {
                            e.e("CameraHandler", 2, "CAMERA2_SET_PARAMS, viewSize:" + dVar6 + " wantedPreviewSize:" + dVar7 + " wantedPictureSize:" + dVar8 + "focusmode" + intValue3);
                        }
                        b bVar = this.f344768f.get(str3);
                        if (bVar == null) {
                            bVar = new b();
                            this.f344768f.put(str3, bVar);
                        }
                        Q.p0(intValue3);
                        if (!bVar.f344778a.get()) {
                            d[] b17 = f.b(dVar6, dVar7, dVar8);
                            if (b17 == null || b17.length < 2) {
                                dVar = null;
                                dVar2 = null;
                            } else {
                                d dVar9 = b17[0];
                                dVar2 = b17[1];
                                dVar = dVar9;
                            }
                            d k06 = Q.k0(new d(Math.max(dVar6.f344911a, dVar6.f344912b), Math.min(dVar6.f344911a, dVar6.f344912b)));
                            if (!com.tencent.qqcamerakit.capture.camera2.b.Q().t0(dVar)) {
                                this.f344766d.b(2, 21, "[Camera2]setCamera2 previewSize error!", new Object[0]);
                                WaitDoneBundle.a(message);
                                return;
                            }
                            if (!com.tencent.qqcamerakit.capture.camera2.b.Q().v0(dVar2)) {
                                this.f344766d.b(2, 22, "[Camera2]setCamera2 pictureSize error!", new Object[0]);
                                WaitDoneBundle.a(message);
                                return;
                            } else if (!com.tencent.qqcamerakit.capture.camera2.b.Q().s0(intValue2)) {
                                this.f344766d.b(2, 23, "[Camera2]setCamera2 fps error!", new Object[0]);
                                WaitDoneBundle.a(message);
                                return;
                            } else {
                                bVar.f344779b = dVar;
                                bVar.f344780c = dVar2;
                                bVar.f344781d = k06;
                                bVar.f344778a.getAndSet(true);
                            }
                        } else if (!com.tencent.qqcamerakit.capture.camera2.b.Q().i0(bVar)) {
                            this.f344766d.b(2, -1, "[Camera2]setCamera2ParamOnce error!", new Object[0]);
                            WaitDoneBundle.a(message);
                            return;
                        }
                        this.f344766d.b(2, 0, "", com.tencent.qqcamerakit.capture.camera2.b.Q().T(), com.tencent.qqcamerakit.capture.camera2.b.Q().O());
                    } else if (i3 == 1010) {
                        if (e.f()) {
                            e.e("CameraHandler", 2, "[handleMessage]CAMERA2_PICTURE_TAKE");
                        }
                        c cVar2 = (c) message.obj;
                        if (cVar2.f344782a == null) {
                            this.f344766d.b(2, -1, "take picture error", new Object[0]);
                            WaitDoneBundle.a(message);
                            return;
                        }
                        com.tencent.qqcamerakit.capture.camera2.b.Q().E0(cVar2);
                    } else if (i3 == 1021) {
                        if (e.f()) {
                            e.e("CameraHandler", 2, "[handleMessage]CAMERA2_STOP_VIDEO");
                        }
                        com.tencent.qqcamerakit.capture.camera2.b.Q().D0();
                    } else if (i3 == 1050) {
                        com.tencent.qqcamerakit.capture.camera2.b.Q().n0(message.arg1 == 1);
                    } else if (i3 == 601) {
                        CameraControl.l().C(message.arg1);
                    } else if (i3 == 602) {
                        CameraControl.l().L(message.arg1);
                    } else if (i3 == 1040) {
                        com.tencent.qqcamerakit.capture.camera2.b.Q().r0(message.arg1);
                    } else if (i3 == 1041) {
                        com.tencent.qqcamerakit.capture.camera2.b.Q().x0(message.arg1);
                    } else if (i3 == 1080) {
                        com.tencent.qqcamerakit.capture.camera2.b.Q().l0(message.arg1, ((Long) message.obj).longValue());
                    } else if (i3 != 1081) {
                        switch (i3) {
                            case 101:
                                if (e.f()) {
                                    e.e("CameraHandler", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
                                }
                                if (CameraControl.l().y()) {
                                    this.f344766d.b(7, -1, "set autoFocus fail", new Object[0]);
                                    break;
                                }
                                break;
                            case 102:
                                a.C9360a c9360a = (a.C9360a) message.obj;
                                CameraControl.l().v(c9360a.f344877h, c9360a.f344878i, c9360a.f344876g);
                                break;
                            case 103:
                                if (e.f()) {
                                    e.e("CameraHandler", 2, "[handleMessage]SET_FOCUS_MODE_RECORDING");
                                }
                                if (CameraControl.l().K()) {
                                    this.f344766d.b(7, -1, "set autoFocus fail", new Object[0]);
                                    break;
                                }
                                break;
                            default:
                                switch (i3) {
                                    case 203:
                                        if (e.f()) {
                                            e.e("CameraHandler", 2, "PREVIEW_SET_CALLBACK");
                                        }
                                        if (!CameraControl.l().G((com.tencent.qqcamerakit.capture.b) message.obj, message.arg1 > 0)) {
                                            this.f344766d.b(2, -1, "set preview callback failed", new Object[0]);
                                            break;
                                        }
                                        break;
                                    case 204:
                                        if (e.f()) {
                                            e.e("CameraHandler", 2, "PREVIEW_START");
                                        }
                                        if (!CameraControl.l().N()) {
                                            this.f344766d.b(3, -1, "start preview failed", new Object[0]);
                                        }
                                        this.f344766d.b(3, 0, "", new Object[0]);
                                        break;
                                    case 205:
                                        if (e.f()) {
                                            e.e("CameraHandler", 2, "PREVIEW_STOP");
                                        }
                                        if (!CameraControl.l().O()) {
                                            this.f344766d.b(4, -1, "stop preview failed", new Object[0]);
                                            break;
                                        }
                                        break;
                                    default:
                                        switch (i3) {
                                            case 1001:
                                                int f06 = com.tencent.qqcamerakit.capture.camera2.b.Q().f0(message.arg1, message.arg2 != 0, this);
                                                if (f06 != 6) {
                                                    if (f06 != 0) {
                                                        this.f344766d.b(1, f06, CameraControl.f(f06), new Object[0]);
                                                        break;
                                                    }
                                                } else {
                                                    e.d("CameraHandler", 1, "Camera2 is opening!");
                                                    this.f344766d.b(1, 0, "", new Object[0]);
                                                    WaitDoneBundle.a(message);
                                                    return;
                                                }
                                                break;
                                            case 1002:
                                                Object[] objArr3 = (Object[]) message.obj;
                                                SurfaceTexture surfaceTexture = (SurfaceTexture) objArr3[0];
                                                Object obj = objArr3[1];
                                                com.tencent.qqcamerakit.capture.camera2.b.Q().B0(surfaceTexture, obj != null ? (com.tencent.qqcamerakit.capture.b) obj : null);
                                                break;
                                            case 1003:
                                                com.tencent.qqcamerakit.capture.camera2.b.Q().E();
                                                break;
                                            default:
                                                switch (i3) {
                                                    case 1030:
                                                        com.tencent.qqcamerakit.capture.camera2.b.Q().z((a.C9360a) message.obj);
                                                        break;
                                                    case 1031:
                                                        com.tencent.qqcamerakit.capture.camera2.b.Q().o0();
                                                        break;
                                                    case 1032:
                                                        if (e.f()) {
                                                            e.e("CameraHandler", 2, "[handleMessage]CAMERA2_START_VIDEO");
                                                        }
                                                        com.tencent.qqcamerakit.capture.camera2.b.Q().q0();
                                                        break;
                                                }
                                        }
                                }
                        }
                    } else {
                        com.tencent.qqcamerakit.capture.camera2.b.Q().m0();
                    }
                } else {
                    CameraControl.l().B(message.arg1);
                }
            } catch (Exception e16) {
                e.b("CameraHandler", 1, "CameraHandler", e16);
            }
            WaitDoneBundle.a(message);
        } catch (Throwable th5) {
            WaitDoneBundle.a(message);
            throw th5;
        }
    }
}
