package com.tencent.mobileqq.ar.ARRecord;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ar.ARRecord.d;
import com.tencent.mobileqq.ar.y;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g implements d.a, com.tencent.mobileqq.ar.ARRecord.a, Handler.Callback {

    /* renamed from: b0, reason: collision with root package name */
    private static final Object f197061b0 = new Object();
    private TextureRender C;
    private u81.a D;
    private int E;
    private float[] G;
    private float[] H;
    private long I;
    private AudioRecordController J;
    private File K;
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.c L;
    private boolean N;
    private boolean P;
    private boolean Q;
    private long R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean Y;
    private long Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f197062a0;

    /* renamed from: d, reason: collision with root package name */
    private Context f197063d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f197064e;

    /* renamed from: f, reason: collision with root package name */
    private a f197065f;

    /* renamed from: h, reason: collision with root package name */
    private d f197066h;

    /* renamed from: i, reason: collision with root package name */
    private Surface f197067i;

    /* renamed from: m, reason: collision with root package name */
    private f f197068m;
    private int F = -1;
    private int M = 0;
    private boolean W = false;
    private boolean X = true;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(int i3, String str);

        void b(int i3);

        void onRecordStart();

        void onRecordUpdate(int i3, int i16);
    }

    public g(Context context) {
        QLog.d("VideoRecordController", 2, "VideoRecordController");
        this.f197063d = context;
        this.f197064e = new Handler(this);
    }

    private File i() {
        File file;
        Exception e16;
        File file2;
        try {
            file = new File(e.a());
            file2 = this.K;
        } catch (Exception e17) {
            file = null;
            e16 = e17;
        }
        if (file2 == null || !file2.exists()) {
            return null;
        }
        if (!FileUtils.copyFile(this.K, file)) {
            return null;
        }
        try {
            j();
        } catch (Exception e18) {
            e16 = e18;
            QLog.e("VideoRecordController", 1, "renameTempVideoFile fail.", e16);
            return file;
        }
        return file;
    }

    private void j() {
        File file = this.K;
        if (file != null && file.exists()) {
            this.K.delete();
        }
    }

    private void l(int i3) {
        if (!this.T) {
            boolean z16 = true;
            this.T = true;
            if (i3 == 2) {
                if (System.currentTimeMillis() - this.R >= 1000) {
                    z16 = false;
                }
                if (z16) {
                    i3 = 11;
                }
            }
            if (!this.P) {
                o(i3);
            }
            w();
        }
    }

    private void m() {
        long currentTimeMillis = (System.currentTimeMillis() - this.R) - this.Z;
        long c16 = com.tencent.av.ui.funchat.record.b.c();
        if (currentTimeMillis >= 60000) {
            this.U = true;
            w();
        } else if (c16 <= 5242880) {
            this.V = true;
            w();
        } else {
            r();
        }
    }

    private void n(int i3, int i16) {
        Bitmap bitmap;
        QLog.d("VideoRecordController", 2, String.format("loadWaterMarkTexture screenWidth=%s screenHeight=%s", Integer.valueOf(i3), Integer.valueOf(i16)));
        if (this.F == -1) {
            this.F = R.drawable.ha7;
        }
        try {
            bitmap = BitmapFactory.decodeResource(this.f197063d.getResources(), this.F);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            QLog.e("VideoRecordController", 1, String.format("loadWaterMarkTexture decode bitmap oom, %s", e16.getMessage()));
            bitmap = null;
        }
        if (bitmap != null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i17 = iArr[0];
            if (i17 > 0) {
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i17);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
                this.E = i17;
                int width = bitmap.getWidth();
                float f16 = i3;
                float f17 = width / f16;
                float f18 = i16;
                float height = bitmap.getHeight() / f18;
                float f19 = ((i3 - width) - 40) / f16;
                float f26 = ((i16 - r0) - 28) / f18;
                float[] fArr = new float[16];
                this.G = fArr;
                Matrix.setIdentityM(fArr, 0);
                Matrix.translateM(this.G, 0, 0.0f, 0.5f, 0.0f);
                Matrix.rotateM(this.G, 0, 180.0f, 1.0f, 0.0f, 0.0f);
                Matrix.translateM(this.G, 0, 0.0f, -0.5f, 0.0f);
                float[] fArr2 = new float[16];
                this.H = fArr2;
                Matrix.setIdentityM(fArr2, 0);
                Matrix.translateM(this.H, 0, -f19, -f26, 0.0f);
                Matrix.scaleM(this.H, 0, f17, height, 1.0f);
            }
        }
    }

    private void o(int i3) {
        QLog.d("VideoRecordController", 2, String.format("notifyRecordError errorType=%s", Integer.valueOf(i3)));
        Handler handler = this.f197064e;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(105);
            obtainMessage.arg1 = i3;
            obtainMessage.sendToTarget();
            ARRecordReport.a().d(i3);
        }
    }

    private void p(int i3, long j3, String str) {
        QLog.d("VideoRecordController", 2, String.format("notifyRecordFinish finishType=%s", Integer.valueOf(i3)));
        Handler handler = this.f197064e;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(104);
            obtainMessage.arg1 = i3;
            obtainMessage.obj = str;
            obtainMessage.sendToTarget();
            ARRecordReport.a().e(i3, j3);
        }
    }

    private void q() {
        QLog.d("VideoRecordController", 2, "notifyRecordStart");
        Handler handler = this.f197064e;
        if (handler != null) {
            handler.sendEmptyMessage(102);
        }
    }

    private void r() {
        long j3;
        Handler handler = this.f197064e;
        if (handler != null) {
            handler.removeMessages(103);
            this.f197064e.sendEmptyMessageDelayed(101, 1000L);
            Message obtainMessage = this.f197064e.obtainMessage(103);
            obtainMessage.arg1 = (int) (System.currentTimeMillis() - this.R);
            File file = this.K;
            if (file != null) {
                j3 = file.length();
            } else {
                j3 = 0;
            }
            obtainMessage.arg2 = (int) j3;
            obtainMessage.sendToTarget();
        }
    }

    private boolean v() {
        boolean z16 = false;
        QLog.d("VideoRecordController", 2, String.format("startRecord mState=%s mIsRecording=%s", Integer.valueOf(this.M), Boolean.valueOf(this.N)));
        synchronized (f197061b0) {
            if (!this.N) {
                this.N = true;
                this.Y = false;
                this.Q = false;
                this.M = 1;
                this.S = false;
                this.T = false;
                this.U = false;
                this.V = false;
                this.Z = 0L;
                z16 = true;
            }
        }
        return z16;
    }

    private boolean w() {
        boolean z16 = false;
        QLog.d("VideoRecordController", 2, String.format("stopRecord mState=%s mIsRecording=%s mNotSaveRecordFile=%s mHaveErrorHappened=%s mHaveMaxRecord=%s mHaveSDCardFull=%s", Integer.valueOf(this.M), Boolean.valueOf(this.N), Boolean.valueOf(this.S), Boolean.valueOf(this.T), Boolean.valueOf(this.U), Boolean.valueOf(this.V)));
        synchronized (f197061b0) {
            if (this.N) {
                AudioRecordController audioRecordController = this.J;
                if (audioRecordController != null) {
                    audioRecordController.q();
                    this.J = null;
                    this.f197062a0 = null;
                }
                d dVar = this.f197066h;
                if (dVar != null) {
                    dVar.g();
                    this.M = 4;
                    this.f197066h = null;
                } else if (this.M == 1) {
                    QLog.e("VideoRecordController", 1, "stopRecord VideoEncoder is starting.");
                    if (!this.P) {
                        o(11);
                    }
                    this.N = false;
                    this.M = 0;
                }
                Surface surface = this.f197067i;
                if (surface != null) {
                    surface.release();
                    this.f197067i = null;
                }
                this.Q = false;
                z16 = true;
            }
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.d.a
    public void a() {
        QLog.d("VideoRecordController", 2, "onEncodeRealStart");
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.d.a
    public void b() {
        boolean z16;
        QLog.d("VideoRecordController", 2, "onEncodeFinish");
        if (this.T) {
            QLog.w("VideoRecordController", 1, "onEncodeFinish error happened, delete temp file.");
            j();
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.R;
            if (currentTimeMillis < 1000) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!this.S && !z16) {
                File i3 = i();
                if (i3 != null && i3.exists()) {
                    String absolutePath = i3.getAbsolutePath();
                    if (!this.W) {
                        ARRecordUtils.e(i3);
                    }
                    QLog.d("VideoRecordController", 2, String.format("onEncodeFinish filePath=%s", absolutePath));
                    if (this.U) {
                        p(1, currentTimeMillis, absolutePath);
                    } else if (this.V) {
                        p(2, currentTimeMillis, absolutePath);
                    } else {
                        p(0, currentTimeMillis, absolutePath);
                    }
                } else {
                    QLog.e("VideoRecordController", 1, "onEncodeFinish rename file fail, delete temp file.");
                    j();
                    l(12);
                }
            } else {
                QLog.w("VideoRecordController", 1, "onEncodeFinish not valid record, delete temp file.");
                j();
                if (z16) {
                    l(11);
                }
            }
        }
        synchronized (f197061b0) {
            this.N = false;
            this.P = false;
            this.M = 0;
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.a
    public boolean c(boolean z16, String str) {
        if (!y.a().f198847g) {
            QLog.w("VideoRecordController", 2, "startVideoRecord record is disable.");
            return false;
        }
        QLog.d("VideoRecordController", 2, String.format("startVideoRecord userOperation=%s mState=%s mIsRecording=%s mIsPreRecord=%s, audioPath=%s", Boolean.valueOf(z16), Integer.valueOf(this.M), Boolean.valueOf(this.N), Boolean.valueOf(this.P), str));
        synchronized (f197061b0) {
            if (this.M == 4) {
                QLog.e("VideoRecordController", 1, "startVideoRecord VideoEncoder is stopping.");
                return false;
            }
            this.f197062a0 = str;
            if (!z16) {
                if (this.P || !v()) {
                    return false;
                }
                this.P = true;
                Handler handler = this.f197064e;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(100, 4000L);
                }
                ARRecordReport.a().c();
            } else if (this.P) {
                this.P = false;
                this.R = System.currentTimeMillis();
                q();
                r();
                ARRecordReport.a().b(true);
            } else {
                if (!v()) {
                    return false;
                }
                this.R = System.currentTimeMillis();
                m();
                ARRecordReport.a().b(false);
                Handler handler2 = this.f197064e;
                if (handler2 != null) {
                    handler2.removeMessages(100);
                }
            }
            return true;
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.a
    public boolean d(boolean z16, boolean z17) {
        boolean z18;
        if (!y.a().f198847g) {
            QLog.w("VideoRecordController", 2, "stopVideoRecord record is disable.");
            return false;
        }
        if (this.M == 4) {
            QLog.w("VideoRecordController", 2, "stopVideoRecord state == stopping");
            return false;
        }
        QLog.d("VideoRecordController", 2, String.format("stopVideoRecord userOperation=%s saveRecord=%s mState=%s mIsPreRecord=%s", Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(this.M), Boolean.valueOf(this.P)));
        if (!this.P && (z16 || z17)) {
            z18 = false;
        } else {
            z18 = true;
        }
        this.S = z18;
        if (!w()) {
            return false;
        }
        Handler handler = this.f197064e;
        if (handler != null) {
            handler.removeMessages(100);
            this.f197064e.removeMessages(101);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.a
    public boolean f() {
        return this.N;
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.d.a
    public void g(int i3) {
        QLog.d("VideoRecordController", 2, String.format("onEncodeError errorCode=%s", Integer.valueOf(i3)));
        l(i3);
        synchronized (f197061b0) {
            this.N = false;
            this.P = false;
            this.M = 0;
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.a
    public void h(a aVar) {
        QLog.d("VideoRecordController", 2, String.format("setVideoRecordListener listener=%s", aVar));
        this.f197065f = aVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        return true;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 100:
                if (this.P) {
                    this.S = true;
                    w();
                    break;
                }
                break;
            case 101:
                m();
                break;
            case 102:
                a aVar = this.f197065f;
                if (aVar != null && !this.P) {
                    aVar.onRecordStart();
                    break;
                }
                break;
            case 103:
                a aVar2 = this.f197065f;
                if (aVar2 != null && !this.P) {
                    aVar2.onRecordUpdate(message.arg1, message.arg2);
                    break;
                }
                break;
            case 104:
                a aVar3 = this.f197065f;
                if (aVar3 != null && !this.P) {
                    aVar3.a(message.arg1, (String) message.obj);
                    break;
                }
                break;
            case 105:
                a aVar4 = this.f197065f;
                if (aVar4 != null && !this.P) {
                    aVar4.b(message.arg1);
                    break;
                }
                break;
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.a
    public boolean isRecording() {
        boolean z16;
        synchronized (f197061b0) {
            if (this.N && !this.P) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public void k(com.tencent.mobileqq.videocodec.mediacodec.encoder.a aVar, int i3, int i16) {
        int i17;
        QLog.d("VideoRecordController", 2, String.format("doStartRecord mState=%s mIsRecording=%s", Integer.valueOf(this.M), Boolean.valueOf(this.N)));
        synchronized (f197061b0) {
            if (this.N) {
                try {
                    String b16 = e.b();
                    this.K = new File(b16);
                    int i18 = (((int) (i16 * (540 / i3))) / 16) * 16;
                    if (DeviceInfoMonitor.getModel().equalsIgnoreCase("CAM-TL00")) {
                        i17 = 1024000;
                    } else {
                        i17 = 5120000;
                    }
                    com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(b16, 540, i18, i17, 1, false, 0);
                    this.L = cVar;
                    cVar.d(EGL14.eglGetCurrentContext());
                    d dVar = new d();
                    this.f197066h = dVar;
                    dVar.f(this.L, this);
                    Surface b17 = this.f197066h.b();
                    this.f197067i = b17;
                    this.f197068m = new f(aVar, b17);
                    this.C = new TextureRender();
                    this.D = new u81.a();
                    com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar2 = this.L;
                    n(cVar2.f312559d, cVar2.f312560e);
                    if (q.p(this.f197062a0)) {
                        this.J = new PcmRecordController(this, this.f197062a0);
                    } else {
                        this.J = new MicRecordController(this);
                    }
                    this.J.p();
                    q();
                    this.M = 2;
                } catch (Exception e16) {
                    QLog.e("VideoRecordController", 1, "doStartRecord fail.", e16);
                    l(1);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.d.a
    public void onEncodeStart() {
        QLog.d("VideoRecordController", 2, "onEncodeStart");
    }

    public void s(byte[] bArr, long j3) {
        d dVar;
        synchronized (f197061b0) {
            long j16 = j3 - this.Z;
            if (this.N && (dVar = this.f197066h) != null && !this.Y) {
                dVar.a(bArr, j16);
                this.Q = true;
            }
        }
    }

    public void t(int i3, int i16, float[] fArr, float[] fArr2, long j3) {
        synchronized (f197061b0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.I < 33) {
                return;
            }
            this.I = currentTimeMillis;
            if (this.Q && this.N && this.f197066h != null && !this.Y) {
                long j16 = j3 - this.Z;
                try {
                    this.f197068m.a();
                    com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = this.L;
                    GLES20.glViewport(0, 0, cVar.f312559d, cVar.f312560e);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16640);
                    GLES20.glDepthMask(false);
                    GLES20.glDisable(2929);
                    this.C.drawTexture(i3, i16, fArr, fArr2);
                    if (this.X) {
                        GLES20.glEnable(3042);
                        GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
                        this.D.a(GLSLRender.GL_TEXTURE_2D, this.E, this.G, this.H);
                        GLES20.glDisable(3042);
                    }
                    this.f197068m.d(j16);
                    this.f197068m.e();
                    this.f197068m.b();
                    this.f197066h.h(j16);
                } catch (Exception e16) {
                    QLog.e("VideoRecordController", 1, "onVideoFrameAvailable render encode surface fail.", e16);
                    l(4);
                }
            }
        }
    }

    public void u() {
        QLog.d("VideoRecordController", 2, "releaseGLResource");
        f fVar = this.f197068m;
        if (fVar != null) {
            fVar.c();
            this.f197068m = null;
        }
        TextureRender textureRender = this.C;
        if (textureRender != null) {
            textureRender.release();
            this.C = null;
        }
        u81.a aVar = this.D;
        if (aVar != null) {
            aVar.b();
            this.D = null;
        }
        int i3 = this.E;
        if (i3 > 0) {
            GLES20.glDeleteTextures(0, new int[]{i3}, 0);
            this.E = 0;
            this.G = null;
            this.H = null;
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.a
    public void e(long j3) {
    }
}
