package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videocodec.mediacodec.util.ThumbnailUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes20.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.e f312625a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.d f312626b;

    /* renamed from: c, reason: collision with root package name */
    protected b f312627c;

    /* renamed from: d, reason: collision with root package name */
    private HandlerThread f312628d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.recorder.c f312629e;

    /* renamed from: f, reason: collision with root package name */
    private String f312630f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f312631g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.c f312632h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f312633i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f312634j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f312635k;

    /* renamed from: l, reason: collision with root package name */
    private f f312636l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ThumbnailUtil.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.util.ThumbnailUtil.a
        public void onResult(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.f312634j = true;
                if (QLog.isColorLevel() && QLog.isColorLevel()) {
                    QLog.d("HWVideoRecorder", 2, "Generate thumbnail result. success = " + z16 + " ; file path = " + str);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        protected WeakReference<e> f312638a;

        public b(Looper looper, e eVar) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, e.this, looper, eVar);
            } else {
                this.f312638a = new WeakReference<>(eVar);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            e eVar = this.f312638a.get();
            if (eVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("HWVideoRecorder", 2, "RecodeHandler.handleMessage: encoder is null");
                    return;
                }
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            e.f(e.this);
                            return;
                        }
                        throw new RuntimeException("Unhandled msg what=" + i3);
                    }
                    Object obj = message.obj;
                    if (obj != null) {
                        Object[] objArr = (Object[]) obj;
                        if (objArr != null && objArr.length == 5) {
                            eVar.j(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), (float[]) objArr[2], (float[]) objArr[3], ((Long) objArr[4]).longValue());
                            return;
                        }
                        throw new IllegalArgumentException("args == null || args.length != 6");
                    }
                    throw new RuntimeException("bundle == null");
                }
                if (e.this.f312634j || e.this.f312632h == null || !e.this.f312632h.f312565j) {
                    eVar.l();
                    return;
                }
                sendEmptyMessageDelayed(1, 100L);
                if (QLog.isColorLevel() && QLog.isColorLevel()) {
                    QLog.d("HWVideoRecorder", 2, "Thumbnail is not ready. Wait 100ms and retry.");
                    return;
                }
                return;
            }
            Object obj2 = message.obj;
            if (obj2 != null) {
                eVar.k((c) obj2);
                return;
            }
            throw new RuntimeException("bundle == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        com.tencent.mobileqq.videocodec.mediacodec.recorder.c f312640a;

        /* renamed from: b, reason: collision with root package name */
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c f312641b;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
        }

        /* synthetic */ c(e eVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar, (Object) aVar);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f312631g = false;
        this.f312635k = false;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("recode_thread");
        this.f312628d = baseHandlerThread;
        baseHandlerThread.start();
        this.f312627c = g(this.f312628d.getLooper());
        this.f312625a = new com.tencent.mobileqq.videocodec.mediacodec.encoder.e();
        this.f312626b = new com.tencent.mobileqq.videocodec.mediacodec.encoder.d();
        this.f312636l = new f();
    }

    static /* synthetic */ d f(e eVar) {
        eVar.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(c cVar) {
        this.f312629e = cVar.f312640a;
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar2 = cVar.f312641b;
        if (QLog.isColorLevel()) {
            QLog.w("HWVideoRecorder", 2, "handleStartRecording EGLContext = " + cVar2.b());
        }
        if (this.f312631g) {
            l();
        }
        this.f312631g = true;
        this.f312632h = cVar2;
        this.f312630f = cVar2.f312558c;
        try {
            this.f312625a.f(cVar2);
            this.f312626b.b(cVar2, this.f312625a.c());
            com.tencent.mobileqq.videocodec.mediacodec.recorder.c cVar3 = this.f312629e;
            if (cVar3 != null) {
                cVar3.onEncodeStart();
            }
            this.f312633i = true;
            this.f312634j = false;
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.w("HWVideoRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + cVar2, th5);
            }
            com.tencent.mobileqq.videocodec.mediacodec.recorder.c cVar4 = this.f312629e;
            if (cVar4 != null) {
                cVar4.onEncodeError(1, th5);
            }
            this.f312631g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar;
        if (QLog.isColorLevel()) {
            QLog.w("HWVideoRecorder", 2, "handleStopRecording");
        }
        if (this.f312631g) {
            this.f312631g = false;
            try {
                this.f312625a.g();
                if (QLog.isColorLevel()) {
                    QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
                }
                com.tencent.mobileqq.videocodec.mediacodec.recorder.c cVar2 = this.f312629e;
                if (cVar2 != null && (cVar = this.f312632h) != null && cVar.f312575t == null) {
                    cVar2.onEncodeFinish(this.f312630f);
                    this.f312629e = null;
                }
                this.f312626b.d();
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("HWVideoRecorder", 2, "handleStopRecording: exception. config = " + this.f312632h);
                }
                com.tencent.mobileqq.videocodec.mediacodec.recorder.c cVar3 = this.f312629e;
                if (cVar3 != null) {
                    cVar3.onEncodeError(2, e16);
                }
                this.f312625a.d();
                this.f312626b.d();
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
        }
    }

    @NonNull
    protected b g(Looper looper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) looper);
        }
        return new b(looper, this);
    }

    public void h(int i3, int i16, float[] fArr, float[] fArr2, long j3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), fArr, fArr2, Long.valueOf(j3));
            return;
        }
        if (this.f312635k) {
            z16 = this.f312636l.e(i16);
        } else {
            this.f312627c.removeMessages(2);
            z16 = false;
        }
        if (!this.f312635k || z16) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = new Object[]{Integer.valueOf(i3), Integer.valueOf(i16), fArr, fArr2, Long.valueOf(j3)};
            this.f312627c.sendMessage(obtain);
        }
    }

    public MediaFormat i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (MediaFormat) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        com.tencent.mobileqq.videocodec.mediacodec.encoder.e eVar = this.f312625a;
        if (eVar != null) {
            return eVar.f312590i;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(int i3, int i16, float[] fArr, float[] fArr2, long j3) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), fArr, fArr2, Long.valueOf(j3));
            return;
        }
        if (this.f312632h == null) {
            QLog.d("HWVideoRecorder", 1, "handleFrameAvailable fail, encodeConfig null");
            return;
        }
        if (!this.f312631g) {
            if (QLog.isColorLevel()) {
                QLog.d("HWVideoRecorder", 2, "handleFrameAvailable mIsRecording = " + this.f312631g);
                return;
            }
            return;
        }
        try {
            this.f312625a.b();
            if (this.f312633i) {
                com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = this.f312632h;
                if (cVar.f312565j) {
                    this.f312633i = false;
                    i17 = i16;
                    ThumbnailUtil.a(i17, cVar.f312559d, cVar.f312560e, cVar, new a());
                    if (this.f312635k) {
                        i17 = this.f312636l.d();
                    }
                    if (i17 == -1) {
                        this.f312626b.a(i3, i17, fArr, fArr2, j3);
                        if (this.f312635k) {
                            this.f312636l.b(false, 1);
                        }
                        com.tencent.mobileqq.videocodec.mediacodec.recorder.c cVar2 = this.f312629e;
                        if (cVar2 != null) {
                            cVar2.onEncodeFrame();
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("HWVideoRecorder", 2, "ignore frame: ", Long.valueOf(j3));
                        return;
                    }
                    return;
                }
            }
            i17 = i16;
            if (this.f312635k) {
            }
            if (i17 == -1) {
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("HWVideoRecorder", 2, "frameAvailable: exception. config = " + this.f312632h, e16);
            }
            com.tencent.mobileqq.videocodec.mediacodec.recorder.c cVar3 = this.f312629e;
            if (cVar3 != null) {
                cVar3.onEncodeError(2, e16);
            }
            this.f312625a.d();
            this.f312626b.d();
            this.f312631g = false;
        }
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return !this.f312631g;
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        HandlerThread handlerThread = this.f312628d;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f312628d = null;
        }
        this.f312629e = null;
        this.f312632h = null;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f312635k = true;
        }
    }

    public void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f312635k = z16;
        }
    }

    public void q(com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar, com.tencent.mobileqq.videocodec.mediacodec.recorder.c cVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar, (Object) cVar2);
        } else {
            r(cVar, cVar2, null);
        }
    }

    public void r(com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar, com.tencent.mobileqq.videocodec.mediacodec.recorder.c cVar2, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, cVar, cVar2, dVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("HWVideoRecorder", 2, "startRecording EGLContext = " + cVar.b());
        }
        if (this.f312635k) {
            this.f312636l.c(cVar.f312559d, cVar.f312560e);
        }
        Message obtain = Message.obtain();
        c cVar3 = new c(this, null);
        cVar3.f312640a = cVar2;
        cVar3.f312641b = cVar;
        obtain.obj = cVar3;
        obtain.what = 0;
        this.f312627c.sendMessage(obtain);
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f312635k) {
            this.f312636l.a();
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.f312627c.sendMessage(obtain);
    }
}
