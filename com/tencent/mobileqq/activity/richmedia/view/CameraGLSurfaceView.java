package com.tencent.mobileqq.activity.richmedia.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CameraGLSurfaceView extends GLSurfaceView implements GLSurfaceView.Renderer, Handler.Callback {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private PreviewContext I;
    private AtomicInteger J;
    private AtomicInteger K;
    private boolean L;
    private String M;
    private int N;
    public com.tencent.mobileqq.activity.richmedia.view.a P;
    public boolean Q;
    private boolean R;
    private HandlerThread S;
    private Handler T;

    /* renamed from: d, reason: collision with root package name */
    private boolean f186023d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f186024e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f186025f;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f186026h;

    /* renamed from: i, reason: collision with root package name */
    private int f186027i;

    /* renamed from: m, reason: collision with root package name */
    private int f186028m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView$3, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f186029d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f186030e;
        final /* synthetic */ CameraGLSurfaceView this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.M = this.f186029d;
            this.this$0.L = true;
            this.this$0.N = this.f186030e;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
    }

    public CameraGLSurfaceView(Context context) {
        super(context);
        this.H = 270;
        this.I = null;
        this.J = new AtomicInteger(0);
        this.K = new AtomicInteger(0);
        this.L = false;
        this.M = null;
        this.N = 90;
        j();
    }

    public static native ByteBuffer allocate(int i3, int i16);

    public static void e(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("CameraGLSurfaceView", 2, str);
        }
    }

    private int f() {
        if (this.K.getAndAdd(0) != 0) {
            e("beginRenderFileCacheData: lost frame");
            return -1;
        }
        ByteBuffer byteBuffer = this.P.f186103m;
        if (byteBuffer != null) {
            byteBuffer.position(0);
            this.P.f186104n.position(0);
            this.P.f186105o.position(0);
            return 0;
        }
        e("handleMessage:beginRenderFileCacheData:panelY=" + this.P.f186103m);
        return -2;
    }

    private Bitmap g(int i3, int i16, int i17, int i18, GL10 gl10) throws OutOfMemoryError {
        int i19 = i17 * i18;
        int[] iArr = new int[i19];
        int[] iArr2 = new int[i19];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        try {
            gl10.glReadPixels(i3, i16, i17, i18, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
            for (int i26 = 0; i26 < i18; i26++) {
                int i27 = i26 * i17;
                int i28 = ((i18 - i26) - 1) * i17;
                for (int i29 = 0; i29 < i17; i29++) {
                    int i36 = iArr[i27 + i29];
                    iArr2[i28 + i29] = (i36 & (-16711936)) | ((i36 << 16) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((i36 >> 16) & 255);
                }
            }
            return Bitmap.createBitmap(iArr2, i17, i18, Bitmap.Config.ARGB_8888);
        } catch (GLException unused) {
            return null;
        }
    }

    public static native int getBitmap(Bitmap bitmap, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i3);

    private void i() {
        this.K.set(1);
        com.tencent.mobileqq.activity.richmedia.view.a aVar = this.P;
        this.f186025f = aVar.h(this.f186025f, this.f186027i, this.f186028m, aVar.f186103m, aVar.f186104n, aVar.f186105o);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            e("glDrawFrame:err=" + glGetError);
        }
        this.K.set(0);
    }

    public static native void initTotalBufferSize(int i3, int i16, int i17);

    private void j() {
        setEGLContextClientVersion(2);
        super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        super.setRenderer(this);
        super.setRenderMode(0);
        super.getHolder().setFormat(1);
        this.f186023d = true;
        this.f186024e = false;
        this.f186026h = false;
        this.R = false;
        this.S = null;
        this.T = null;
        this.P = new com.tencent.mobileqq.activity.richmedia.view.a();
    }

    private void k() {
        this.P.f186093c = 0;
        this.f186024e = false;
    }

    private void l() {
        if (this.S != null) {
            PreviewContext previewContext = this.I;
            if (previewContext != null) {
                previewContext.mMsghandler = null;
            }
            this.T.removeCallbacksAndMessages(null);
            this.S.quit();
            this.S = null;
            this.T = null;
        }
    }

    public static native int processVideoFrame(byte[] bArr, int i3, int i16, int i17, int i18, boolean z16, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, boolean z17);

    public static native int writeVideoFrame(int i3, int i16, AVIOStruct aVIOStruct);

    public void h() {
        if (this.S == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("glProcess");
            this.S = baseHandlerThread;
            baseHandlerThread.start();
            Handler handler = new Handler(this.S.getLooper(), this);
            this.T = handler;
            PreviewContext previewContext = this.I;
            if (previewContext != null) {
                previewContext.mMsghandler = handler;
            }
            this.K.set(0);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        byte[] bArr;
        int i3;
        PreviewContext previewContext;
        int i16 = message.what;
        if (i16 == -16716526) {
            int i17 = this.J.get();
            if (i17 != 0) {
                e("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + i17);
                return true;
            }
            Object obj = message.obj;
            if (obj != null) {
                int i18 = message.arg1;
                if (i18 == 0) {
                    bArr = (byte[]) obj;
                } else if (i18 == 1) {
                    bArr = ((PreviewContext.a) obj).f288178a;
                } else {
                    bArr = null;
                }
                int d16 = this.P.d(this.G, this.f186027i, this.f186028m, this.C, this.D, this.H, bArr);
                if (message.arg2 == 1 && (previewContext = this.I) != null) {
                    previewContext.addUserBufferRecycle(bArr);
                }
                if (d16 == 0) {
                    requestRender();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    e("handleMessage:requestRender  renderTime=" + elapsedRealtime);
                    PreviewContext previewContext2 = this.I;
                    if (previewContext2 != null && previewContext2.notifyFirstFrame) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView.2
                            @Override // java.lang.Runnable
                            public void run() {
                                CameraGLSurfaceView.this.I.sendFirstFrameMsg();
                            }
                        });
                    }
                    if (message.arg1 == 1) {
                        try {
                            AVIOStruct aVIOStruct = ((PreviewContext.a) message.obj).f288179b;
                            if (elapsedRealtime != 0) {
                                e("handleMessage:writeVideoFrame  renderTime=" + elapsedRealtime + " oldtime=" + aVIOStruct.vFrameTime + " diff=" + (elapsedRealtime - aVIOStruct.vFrameTime));
                                aVIOStruct.vFrameTime = elapsedRealtime;
                            }
                            i3 = writeVideoFrame(this.f186027i, this.f186028m, aVIOStruct);
                        } catch (UnsatisfiedLinkError unused) {
                            i3 = -15;
                        }
                        e("handleMessage:writeVideoFrame  error=" + i3);
                    }
                } else {
                    e("handleMessage:byteBufferProcessFrame  error=" + d16);
                    return true;
                }
            }
        } else if (i16 == -16716525) {
            int i19 = this.J.get();
            if (i19 != 1) {
                e("handleMessage:[RenderModeCheck-Preview] mode=" + i19);
                return true;
            }
            if (f() == 0) {
                requestRender();
            }
        }
        return true;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(16384);
        if (this.f186026h && this.f186023d && this.f186024e) {
            i();
            if (this.L && this.M != null) {
                g(0, 0, getWidth(), getHeight(), gl10);
                this.L = false;
                this.M = null;
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (this.R) {
            super.onPause();
            this.R = false;
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        h();
        this.R = true;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        GLES20.glViewport(0, 0, i3, i16);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        if (this.Q) {
            this.P.f186099i = true;
        }
        if (!this.P.b(getContext())) {
            this.f186023d = false;
        }
        this.f186024e = true;
        this.f186025f = false;
    }

    public void setCaptureListener(a aVar) {
        queueEvent(new Runnable(aVar) { // from class: com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                CameraGLSurfaceView.this.getClass();
            }
        });
    }

    public void setPreviewSize(int i3, int i16, com.tencent.mobileqq.activity.richmedia.state.b bVar) {
        this.C = i3;
        this.D = i16;
        int i17 = bVar.f185924c;
        this.f186027i = i17;
        int i18 = bVar.f185925d;
        this.f186028m = i18;
        int i19 = bVar.f185926e;
        this.E = i19;
        int i26 = bVar.f185927f;
        this.F = i26;
        if (i17 % 2 != 0) {
            this.f186027i = i17 - 1;
        }
        if (i18 % 2 != 0) {
            this.f186028m = i18 - 1;
        }
        if (i19 % 2 != 0) {
            this.E = i19 - 1;
        }
        if (i26 % 2 != 0) {
            this.F = i26 - 1;
        }
        this.G = CameraControl.u().D();
        int F = CameraControl.u().F();
        if (F <= 0) {
            this.H = 270;
        } else {
            this.H = F;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CameraGLSurfaceView", 2, "setPreviewSize:mVideoClipDegree=" + this.H);
        }
        com.tencent.mobileqq.activity.richmedia.view.a.f186090v = false;
        try {
            initTotalBufferSize(this.C, this.D, this.G);
            com.tencent.mobileqq.activity.richmedia.view.a.f186090v = true;
        } catch (UnsatisfiedLinkError unused) {
            com.tencent.mobileqq.activity.richmedia.view.a.f186090v = false;
        }
        this.P.c(this.f186027i, this.f186028m);
        this.P.f186106p = false;
        this.f186026h = true;
    }

    public void setVideoContext(PreviewContext previewContext) {
        this.I = previewContext;
        if (previewContext != null) {
            previewContext.mMsghandler = this.T;
            previewContext.mPTVRealBeauty = true;
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
        k();
        l();
    }

    public CameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = 270;
        this.I = null;
        this.J = new AtomicInteger(0);
        this.K = new AtomicInteger(0);
        this.L = false;
        this.M = null;
        this.N = 90;
        j();
    }
}
