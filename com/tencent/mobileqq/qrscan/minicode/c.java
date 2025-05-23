package com.tencent.mobileqq.qrscan.minicode;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.minicode.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.i;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c implements Handler.Callback {
    static IPatchRedirector $redirector_;
    int C;
    int D;
    boolean E;
    boolean F;
    boolean G;
    List<com.tencent.mobileqq.qrscan.a> H;
    d I;
    Context J;
    int K;
    String L;
    String M;
    String N;
    String P;
    private CopyOnWriteArrayList<WeakReference<i>> Q;

    /* renamed from: d, reason: collision with root package name */
    EglHandlerThread f276742d;

    /* renamed from: e, reason: collision with root package name */
    Handler f276743e;

    /* renamed from: f, reason: collision with root package name */
    HandlerThread f276744f;

    /* renamed from: h, reason: collision with root package name */
    Handler f276745h;

    /* renamed from: i, reason: collision with root package name */
    int f276746i;

    /* renamed from: m, reason: collision with root package name */
    Bitmap f276747m;

    public c(Context context, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f276746i = -1;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = new ArrayList();
        this.J = context;
        this.D = i17;
        this.C = i16;
        this.K = i3;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MINICODE_DETECT_THREAD");
        this.f276744f = baseHandlerThread;
        baseHandlerThread.start();
        this.f276745h = new Handler(this.f276744f.getLooper(), this);
        EglHandlerThread eglHandlerThread = new EglHandlerThread("MINICODE_EGLHANDLER_THREAD", null);
        this.f276742d = eglHandlerThread;
        eglHandlerThread.start();
        Looper looper = this.f276742d.getLooper();
        if (looper != null) {
            this.f276743e = new Handler(looper, this);
        } else {
            QLog.i("MiniRecog.detector", 1, "MiniCodeDetector init eglHandler exception: looper=null");
        }
        this.Q = new CopyOnWriteArrayList<>();
    }

    private static void b(int i3, Bitmap bitmap) {
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        a.a("glBindTexture");
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        a.a("glTexParameteri");
        GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        a.a("texImage2D");
    }

    @TargetApi(18)
    private void d() {
        try {
            this.f276743e.removeCallbacksAndMessages(null);
            this.f276742d.quitSafely();
            this.f276742d = null;
            this.f276743e = null;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("MiniRecog.detector", 2, e16.getMessage(), e16);
            }
        }
        try {
            this.f276745h.removeCallbacksAndMessages(null);
            this.f276744f.quitSafely();
            this.f276744f = null;
            this.f276745h = null;
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.i("MiniRecog.detector", 2, e17.getMessage(), e17);
            }
        }
        this.F = false;
        this.f276747m = null;
        this.H.clear();
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.detector", 2, "closeLater()");
        }
    }

    private void e() {
        QLog.i("MiniRecog.detector", 1, "destroyInEGL()");
        this.E = false;
        int i3 = this.f276746i;
        if (i3 >= 0) {
            b.c(i3);
            this.f276746i = -1;
        }
        d dVar = this.I;
        if (dVar != null) {
            try {
                dVar.b();
            } catch (Exception e16) {
                QLog.i("MiniRecog.detector", 1, "destroyInEGL exception:" + e16.getLocalizedMessage(), e16);
            }
        }
        Handler handler = this.f276745h;
        if (handler != null) {
            handler.sendEmptyMessage(100);
        }
    }

    private int h() {
        int i3;
        QLog.i("MiniRecog.detector", 1, "initInEGL");
        this.E = true;
        f fVar = new f();
        fVar.f276764a = this.K;
        fVar.f276765b = 256;
        fVar.f276766c = 256;
        fVar.f276768e = this.L;
        fVar.f276769f = this.N;
        fVar.f276767d = Utils.readModelFile(this.M);
        fVar.f276770g = this.P;
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.detector", 2, "runType" + ContainerUtils.KEY_VALUE_DELIMITER + fVar.f276764a + "\nnetHeight" + ContainerUtils.KEY_VALUE_DELIMITER + fVar.f276765b + "\nnetWidth" + ContainerUtils.KEY_VALUE_DELIMITER + fVar.f276766c + "\nparamPath" + ContainerUtils.KEY_VALUE_DELIMITER + fVar.f276768e + "\nanchorPath" + ContainerUtils.KEY_VALUE_DELIMITER + fVar.f276769f + "\nkernelBinaryIndex" + ContainerUtils.KEY_VALUE_DELIMITER + fVar.f276770g + "\nmodelString" + ContainerUtils.KEY_VALUE_DELIMITER + fVar.f276767d + "\n");
        }
        int i16 = this.C;
        if (i16 > 0 && (i3 = this.D) > 0) {
            this.f276746i = a.c(i16, i3);
        }
        d dVar = new d(fVar);
        this.I = dVar;
        return dVar.d() ? 1 : 0;
    }

    private boolean i(long j3, boolean z16) {
        List<com.tencent.mobileqq.qrscan.a> list;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.detector", 2, "processInEGL start **********");
        }
        this.H.clear();
        if (!this.E) {
            if (QLog.isColorLevel()) {
                QLog.i("MiniRecog.detector", 2, "processInEGL has not been initialized; Skipped.");
            }
            return false;
        }
        Bitmap bitmap = this.f276747m;
        if (bitmap != null && !bitmap.isRecycled()) {
            Bitmap bitmap2 = this.f276747m;
            if (bitmap2.getWidth() == this.C && bitmap2.getHeight() == this.D && (i3 = this.f276746i) >= 0) {
                try {
                    b(i3, bitmap2);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            } else {
                this.C = bitmap2.getWidth();
                this.D = bitmap2.getHeight();
                int i16 = this.f276746i;
                int i17 = -1;
                if (i16 >= 0) {
                    b.c(i16);
                    this.f276746i = -1;
                }
                try {
                    i17 = b.a(GLSLRender.GL_TEXTURE_2D, bitmap2);
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
                this.f276746i = i17;
            }
            d dVar = this.I;
            if (dVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("MiniRecog.detector", 2, "processInEGL MiniCodeRecog is null");
                }
                return false;
            }
            int i18 = this.f276746i;
            if (i18 >= 0) {
                list = dVar.a(i18, this.C, this.D, j3, z16);
                if (QLog.isColorLevel()) {
                    QLog.i("MiniRecog.detector", 2, String.format("minicode_timecost processInEGL end consume=%d **********", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                }
            } else {
                list = null;
            }
            if (list != null) {
                this.H.addAll(list);
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.detector", 2, "processInEGL mInBmp invalid");
        }
        return false;
    }

    public void a(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iVar);
            return;
        }
        Iterator<WeakReference<i>> it = this.Q.iterator();
        while (it.hasNext()) {
            i iVar2 = it.next().get();
            if (iVar2 != null && iVar2 == iVar) {
                return;
            }
        }
        this.Q.add(new WeakReference<>(iVar));
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.G) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.detector", 2, "close()");
        }
        this.G = true;
        if (this.E) {
            Handler handler = this.f276743e;
            if (handler != null) {
                handler.sendEmptyMessage(202);
                return;
            }
            return;
        }
        d();
    }

    public boolean f(Bitmap bitmap, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, bitmap, Long.valueOf(j3))).booleanValue();
        }
        try {
            if (!this.E) {
                if (QLog.isColorLevel()) {
                    QLog.i("MiniRecog.detector", 2, "detector has not been initialized; Skipped.");
                }
                return false;
            }
            if (this.G) {
                if (QLog.isColorLevel()) {
                    QLog.i("MiniRecog.detector", 2, "detector has been closed; Skipped.");
                }
                return false;
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                if (this.F) {
                    if (QLog.isColorLevel()) {
                        QLog.i("MiniRecog.detector", 2, "detect mIsProcessing is true");
                    }
                    return false;
                }
                Handler handler = this.f276743e;
                if (handler == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("MiniRecog.detector", 2, "mEglHandler is null");
                    }
                    return false;
                }
                this.F = true;
                this.f276747m = bitmap;
                handler.obtainMessage(201, Long.valueOf(j3)).sendToTarget();
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MiniRecog.detector", 2, "detect input bitmap invalid");
            }
            return false;
        } catch (Exception e16) {
            QLog.i("MiniRecog.detector", 1, "detect exception: " + e16.getMessage(), e16);
            return false;
        }
    }

    public void g(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.detector", 2, "initEnv");
        }
        this.L = str;
        this.M = str2;
        this.N = str3;
        this.P = str4;
        Handler handler = this.f276743e;
        if (handler != null) {
            handler.sendEmptyMessage(200);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        switch (i3) {
            case 100:
                d();
                return false;
            case 101:
                Object[] objArr = (Object[]) message.obj;
                Iterator<WeakReference<i>> it = this.Q.iterator();
                while (it.hasNext()) {
                    i iVar = it.next().get();
                    if (iVar != null) {
                        iVar.c(this.H, ((Long) objArr[1]).longValue());
                    }
                }
                this.F = false;
                return false;
            case 102:
                int i16 = message.arg1;
                Iterator<WeakReference<i>> it5 = this.Q.iterator();
                while (it5.hasNext()) {
                    i iVar2 = it5.next().get();
                    if (iVar2 != null) {
                        iVar2.b(i16);
                    }
                }
                return false;
            case 103:
                Object[] objArr2 = (Object[]) message.obj;
                Iterator<WeakReference<i>> it6 = this.Q.iterator();
                while (it6.hasNext()) {
                    i iVar3 = it6.next().get();
                    if (iVar3 != null) {
                        iVar3.a(((Long) objArr2[0]).longValue());
                    }
                }
                return false;
            default:
                switch (i3) {
                    case 200:
                        int h16 = h();
                        Handler handler = this.f276745h;
                        if (handler != null) {
                            handler.obtainMessage(102, h16, 0).sendToTarget();
                            break;
                        }
                        break;
                    case 201:
                        long longValue = ((Long) message.obj).longValue();
                        boolean z16 = e.f276759b;
                        boolean i17 = i(longValue, z16);
                        Handler handler2 = this.f276745h;
                        if (handler2 != null) {
                            this.f276745h.sendMessage(handler2.obtainMessage(101, new Object[]{Boolean.valueOf(i17), Long.valueOf(longValue)}));
                        }
                        Handler handler3 = this.f276745h;
                        if (handler3 != null && z16) {
                            this.f276745h.sendMessage(handler3.obtainMessage(103, new Object[]{Long.valueOf(longValue)}));
                            break;
                        }
                        break;
                    case 202:
                        e();
                        break;
                }
                return false;
        }
    }

    public void j(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iVar);
            return;
        }
        Iterator<WeakReference<i>> it = this.Q.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            i iVar2 = next.get();
            if (iVar2 != null && iVar2 == iVar) {
                this.Q.remove(next);
                return;
            }
        }
    }
}
