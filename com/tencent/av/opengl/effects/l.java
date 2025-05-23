package com.tencent.av.opengl.effects;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.av.opengl.PtuSoLoader;
import com.tencent.av.utils.at;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.qphone.base.util.QLog;
import org.light.CameraConfig;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class l extends s {
    protected long M;
    protected long N;
    private long E = 50;
    public q F = null;
    protected boolean G = false;
    protected final y H = new y();
    protected final ab I = new ab();
    protected final ac J = new ac();
    protected volatile com.tencent.avcore.camera.data.c K = null;
    protected volatile com.tencent.avcore.camera.data.c L = null;
    private com.tencent.av.utils.o P = new com.tencent.av.utils.o("EffectRenderWrapper", 2000);

    private void p(com.tencent.avcore.camera.data.c cVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.K == cVar) {
            this.K = null;
        }
        this.J.a();
        byte[] bArr = cVar.f77441a;
        if (bArr != null) {
            com.tencent.avcore.camera.util.a.d().g(bArr, 3);
        }
        y(cVar, this.I);
        com.tencent.av.utils.p pVar = (com.tencent.av.utils.p) cVar.f77452l;
        pVar.n();
        q qVar = this.F;
        if (qVar != null) {
            qVar.p(cVar, this.I, null, this.J);
        }
        cVar.a();
        pVar.o();
        if (bArr != null) {
            com.tencent.avcore.camera.util.a.d().g(bArr, 0);
        }
        ac acVar = this.J;
        if (acVar.f73922a == null) {
            acVar.f73922a = cVar;
        }
        com.tencent.avcore.camera.data.c cVar2 = acVar.f73922a;
        cVar2.f77452l = pVar;
        ab abVar = this.I;
        if (!abVar.f73921g) {
            s(abVar, acVar);
        } else {
            cVar2.l();
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        this.M = elapsedRealtime2;
        this.P.c(elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
    }

    protected void A(long j3) {
        q qVar = this.F;
        if (qVar != null) {
            qVar.g(j3, l());
        }
    }

    public void a(long j3) {
        q qVar = this.F;
        if (qVar != null) {
            qVar.c(j3);
        }
    }

    public void d(com.tencent.avcore.camera.data.c cVar) {
        boolean z16 = true;
        if (cVar.f77455o == null) {
            this.H.a(cVar.f77441a, cVar.f77442b, cVar.f77443c, cVar.f77444d, cVar.f77445e, cVar.f77448h, cVar.f77447g, cVar.f77450j);
            if (cVar.f77441a == null || cVar.f77442b == 0 || cVar.f77443c == 0) {
                z16 = false;
            }
        }
        if (!z16) {
            cVar.l();
            return;
        }
        if (this.D.hasMessages(3)) {
            this.D.removeMessages(3);
            if (this.K != null && this.K != cVar) {
                try {
                    this.K.l();
                } catch (Throwable unused) {
                }
                this.K = null;
            }
            if (cVar.f77441a != null) {
                com.tencent.avcore.camera.util.a.d().f(2, 0);
            }
        }
        if (cVar.f77441a != null) {
            com.tencent.avcore.camera.util.a.d().g(cVar.f77441a, 2);
        }
        this.K = cVar;
        this.D.obtainMessage(3, cVar).sendToTarget();
    }

    @Override // com.tencent.av.opengl.effects.s, com.tencent.av.opengl.effects.v
    public void h() {
        Message obtainMessage = this.D.obtainMessage(1);
        obtainMessage.obj = Long.valueOf(com.tencent.av.utils.e.d());
        obtainMessage.sendToTarget();
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("SurfaceTag", "Effect-init");
        }
    }

    @Override // com.tencent.av.opengl.effects.s
    protected void j(Message message) {
        switch (message.what) {
            case 1:
                m(at.c(message.obj));
                return;
            case 2:
                w(at.c(message.obj));
                return;
            case 3:
                if (!n()) {
                    p((com.tencent.avcore.camera.data.c) message.obj);
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Math.abs(elapsedRealtime - this.M);
                long abs = Math.abs(elapsedRealtime - this.N);
                boolean z16 = false;
                if (this.N != 0 && abs < this.E) {
                    z16 = true;
                }
                this.N = elapsedRealtime;
                long j3 = 2000;
                if (z16) {
                    j3 = Math.min(this.E - abs, 2000L);
                }
                if (this.D.hasMessages(8)) {
                    this.D.removeMessages(8);
                    if (this.L != null && this.L != ((com.tencent.avcore.camera.data.c) message.obj)) {
                        this.L.l();
                    }
                }
                this.L = (com.tencent.avcore.camera.data.c) message.obj;
                if (z16) {
                    Handler handler = this.D;
                    handler.sendMessageDelayed(handler.obtainMessage(8, message.obj), j3);
                    return;
                } else {
                    p((com.tencent.avcore.camera.data.c) message.obj);
                    return;
                }
            case 4:
                A(at.c(message.obj));
                return;
            case 5:
                x();
                return;
            case 6:
            default:
                return;
            case 7:
                r();
                return;
            case 8:
                p((com.tencent.avcore.camera.data.c) message.obj);
                return;
            case 9:
                t((CameraConfig.DeviceCameraOrientation) message.obj);
                return;
            case 10:
                int intValue = ((Integer) message.obj).intValue();
                if (intValue == 0) {
                    return;
                }
                this.E = 1000 / intValue;
                return;
        }
    }

    protected int l() {
        return 0;
    }

    protected void m(long j3) {
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("EffectRenderWrapper", "initInGL, isInitial[" + this.G + "], loadPtvSo[" + PtuSoLoader.soloadedPTV + "], seq[" + j3 + "]");
        }
        if (this.G) {
            return;
        }
        this.G = true;
        super.h();
        q qVar = this.F;
        if (qVar != null) {
            qVar.g(j3, l());
        }
    }

    protected abstract boolean n();

    public void o() {
        this.D.obtainMessage(6).sendToTarget();
    }

    public void q() {
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("EffectRenderWrapper", "release AEFilterManager");
        }
        this.D.obtainMessage(7).sendToTarget();
    }

    protected void r() {
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("EffectRenderWrapper", "releaseAEFilterManagerInGL, p[" + this.F + "]");
        }
        q qVar = this.F;
        if (qVar != null) {
            qVar.o();
        }
    }

    protected abstract void s(ab abVar, ac acVar);

    protected void t(CameraConfig.DeviceCameraOrientation deviceCameraOrientation) {
        q qVar = this.F;
        if (qVar != null) {
            qVar.q(deviceCameraOrientation);
        }
    }

    public void u(int i3) {
        QLog.i("EffectRenderWrapper", 1, "setFPS[" + i3 + "]");
        this.D.obtainMessage(10, Integer.valueOf(i3)).sendToTarget();
    }

    public void uninit() {
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("EffectRenderWrapper", "uninit");
        }
        this.D.obtainMessage(5).sendToTarget();
    }

    public void v(com.tencent.av.avatar.a aVar) {
        q qVar = this.F;
        if (qVar != null) {
            qVar.t(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(long j3) {
        if (!this.G) {
            return;
        }
        this.G = false;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("EffectRenderWrapper", "terminateInGL, seq[" + j3 + "]");
        }
        q qVar = this.F;
        if (qVar != null) {
            qVar.b(j3);
        }
        super.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("EffectRenderWrapper", "unInitInGL, p[" + this.F + "]");
        }
        q qVar = this.F;
        if (qVar != null) {
            qVar.u();
        }
    }

    protected abstract void y(com.tencent.avcore.camera.data.c cVar, ab abVar);

    public void z(long j3) {
        Message obtainMessage = this.D.obtainMessage(4);
        obtainMessage.obj = Long.valueOf(j3);
        obtainMessage.sendToTarget();
    }
}
