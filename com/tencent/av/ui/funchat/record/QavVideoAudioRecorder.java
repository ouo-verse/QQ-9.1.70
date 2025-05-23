package com.tencent.av.ui.funchat.record;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.util.VersionUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes3.dex */
public class QavVideoAudioRecorder {

    /* renamed from: a, reason: collision with root package name */
    private f f75833a;

    /* renamed from: b, reason: collision with root package name */
    private a f75834b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f75835c;

    /* renamed from: d, reason: collision with root package name */
    protected g f75836d;

    /* renamed from: e, reason: collision with root package name */
    private String f75837e;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.c f75839g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.d f75840h;

    /* renamed from: i, reason: collision with root package name */
    private long f75841i;

    /* renamed from: j, reason: collision with root package name */
    private long f75842j;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f75838f = false;

    /* renamed from: k, reason: collision with root package name */
    private ByteArrayOutputStream f75843k = null;

    /* renamed from: l, reason: collision with root package name */
    private int f75844l = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f75845m = 0;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<QavVideoAudioRecorder> f75848a;

        public a(Looper looper, QavVideoAudioRecorder qavVideoAudioRecorder) {
            super(looper);
            this.f75848a = new WeakReference<>(qavVideoAudioRecorder);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            QavVideoAudioRecorder qavVideoAudioRecorder = this.f75848a.get();
            if (qavVideoAudioRecorder == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("QavVideoAudioRecorder", 2, "RecodeHandler.handleMessage: encoder is null");
                    return;
                }
                return;
            }
            if (i3 != 0) {
                if (i3 == 1) {
                    qavVideoAudioRecorder.i();
                    try {
                        if (QavVideoAudioRecorder.this.f75843k != null) {
                            QavVideoAudioRecorder.this.f75843k.flush();
                            QavVideoAudioRecorder.this.f75843k.close();
                            QavVideoAudioRecorder.this.f75843k = null;
                            return;
                        }
                        return;
                    } catch (IOException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("QavVideoAudioRecorder", 2, "AudioBuf.close() ", e16);
                            return;
                        }
                        return;
                    }
                }
                if (i3 != 2) {
                    if (i3 == 3) {
                        Object obj = message.obj;
                        if (obj != null) {
                            Object[] objArr = (Object[]) obj;
                            qavVideoAudioRecorder.g((byte[]) objArr[0], ((Long) objArr[1]).longValue());
                            return;
                        }
                        throw new RuntimeException("MSG_AUDIO_FRAME_AVAILABLE bundle == null");
                    }
                    throw new RuntimeException("Unhandled msg what=" + i3);
                }
                Object obj2 = message.obj;
                if (obj2 != null) {
                    Object[] objArr2 = (Object[]) obj2;
                    if (objArr2 != null && objArr2.length == 5) {
                        qavVideoAudioRecorder.j(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (float[]) objArr2[2], (float[]) objArr2[3], ((Long) objArr2[4]).longValue());
                        return;
                    }
                    throw new IllegalArgumentException("args == null || args.length != 5");
                }
                throw new RuntimeException("MSG_VIDEO_FRAME_AVAILABLE bundle == null");
            }
            if (QavVideoAudioRecorder.this.f75843k == null) {
                QavVideoAudioRecorder.this.f75843k = new ByteArrayOutputStream(32768);
            }
            Object obj3 = message.obj;
            if (obj3 != null) {
                qavVideoAudioRecorder.h((com.tencent.mobileqq.videocodec.mediacodec.encoder.c) obj3);
                return;
            }
            throw new RuntimeException("MSG_START_RECORDING bundle == null");
        }
    }

    public QavVideoAudioRecorder() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("recode_thread");
        this.f75835c = baseHandlerThread;
        baseHandlerThread.start();
        this.f75835c.setPriority(10);
        this.f75834b = new a(this.f75835c.getLooper(), this);
        this.f75833a = new f(this);
        this.f75840h = new com.tencent.mobileqq.videocodec.mediacodec.encoder.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar) {
        if (QLog.isColorLevel()) {
            QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording EGLContext = " + cVar.b());
        }
        if (this.f75838f) {
            i();
        }
        this.f75838f = true;
        this.f75841i = -1L;
        this.f75842j = -1L;
        this.f75844l = 0;
        this.f75843k.reset();
        this.f75839g = cVar;
        this.f75837e = cVar.f312558c;
        try {
            this.f75833a.g(cVar);
            this.f75840h.b(cVar, this.f75833a.c());
            g gVar = this.f75836d;
            if (gVar != null) {
                gVar.onEncodeStart();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + cVar);
            }
            g gVar2 = this.f75836d;
            if (gVar2 != null) {
                gVar2.onEncodeError(1, th5);
            }
            this.f75838f = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (QLog.isColorLevel()) {
            QLog.w("QavVideoAudioRecorder", 1, "handleStopRecording, mPts[" + this.f75845m + "]");
        }
        if (this.f75838f) {
            try {
                g(this.f75843k.toByteArray(), this.f75845m);
                this.f75843k.reset();
                this.f75833a.h();
                this.f75840h.d();
                this.f75838f = false;
                g gVar = this.f75836d;
                if (gVar != null) {
                    gVar.onEncodeFinish(this.f75837e);
                    this.f75836d = null;
                    return;
                }
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QavVideoAudioRecorder", 2, "handleStopRecording: exception. config = " + this.f75839g);
                }
                g gVar2 = this.f75836d;
                if (gVar2 != null) {
                    gVar2.onEncodeError(4, e16);
                }
                f fVar = this.f75833a;
                if (fVar != null) {
                    fVar.f();
                }
                com.tencent.mobileqq.videocodec.mediacodec.encoder.d dVar = this.f75840h;
                if (dVar != null) {
                    dVar.d();
                }
                this.f75838f = false;
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("QavVideoAudioRecorder", 2, "handleStopRecording: is not recording.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i3, int i16, float[] fArr, float[] fArr2, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable timestampNanos = " + j3 + " ; textureId = " + i16);
        }
        if (this.f75838f && this.f75833a != null) {
            if (this.f75841i < 0) {
                this.f75841i = j3;
            }
            QavRecordReporter.c();
            if (this.f75833a.f75892d && !this.f75833a.f75894f && this.f75833a.b()) {
                if (QLog.isColorLevel()) {
                    QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable video track ready but muxer not start");
                }
                g gVar = this.f75836d;
                if (gVar != null) {
                    gVar.c();
                    return;
                }
                return;
            }
            try {
                this.f75833a.i();
                com.tencent.mobileqq.videocodec.mediacodec.encoder.d dVar = this.f75840h;
                if (dVar != null) {
                    dVar.a(i3, i16, fArr, fArr2, j3 - this.f75841i);
                }
                g gVar2 = this.f75836d;
                if (gVar2 != null) {
                    gVar2.b();
                    return;
                }
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QavVideoAudioRecorder", 2, "videoFrameAvailable: exception. config = " + this.f75839g);
                }
                g gVar3 = this.f75836d;
                if (gVar3 != null) {
                    gVar3.onEncodeError(2, e16);
                }
                this.f75833a.f();
                com.tencent.mobileqq.videocodec.mediacodec.encoder.d dVar2 = this.f75840h;
                if (dVar2 != null) {
                    dVar2.d();
                }
                this.f75838f = false;
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable mIsRecording = " + this.f75838f);
        }
    }

    public void f(byte[] bArr, long j3) {
        if (this.f75838f) {
            if (this.f75833a.f75893e && !this.f75833a.f75894f) {
                if (QLog.isColorLevel()) {
                    QLog.d("QavVideoAudioRecorder", 2, "audioFrameAvailable audio track ready but muxer not start");
                    return;
                }
                return;
            }
            if (!this.f75833a.f75894f) {
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = new Object[]{bArr, Long.valueOf(j3)};
                this.f75834b.sendMessage(obtain);
                return;
            }
            try {
                this.f75843k.write(bArr);
            } catch (IOException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QavVideoAudioRecorder", 2, "audioFrameAvailable ", e16);
                }
            }
            int i3 = this.f75844l;
            if (i3 == 0) {
                this.f75845m = j3;
            }
            int i16 = i3 + 1;
            this.f75844l = i16;
            if (i16 >= 5) {
                this.f75844l = 0;
                Message obtain2 = Message.obtain();
                obtain2.what = 3;
                obtain2.obj = new Object[]{this.f75843k.toByteArray(), Long.valueOf(this.f75845m)};
                this.f75834b.sendMessage(obtain2);
                this.f75843k.reset();
            }
        }
    }

    public void g(byte[] bArr, long j3) {
        try {
            if (this.f75842j < 0) {
                this.f75842j = j3;
                QLog.w("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable, begin, mStartAudioPts[" + this.f75842j + "]");
            }
            this.f75833a.a(bArr, j3 - this.f75842j);
        } catch (Exception e16) {
            g gVar = this.f75836d;
            if (gVar != null) {
                gVar.onEncodeError(3, e16);
            }
            QLog.e("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable", e16);
        }
    }

    public void k() {
        a aVar = this.f75834b;
        final HandlerThread handlerThread = this.f75835c;
        final com.tencent.mobileqq.videocodec.mediacodec.encoder.d dVar = this.f75840h;
        this.f75833a = null;
        if (handlerThread != null) {
            aVar.post(new Runnable() { // from class: com.tencent.av.ui.funchat.record.QavVideoAudioRecorder.1
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.videocodec.mediacodec.encoder.d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.d();
                    }
                    try {
                        if (VersionUtils.isJellyBeanMA2()) {
                            handlerThread.getLooper().quitSafely();
                            QLog.i("QavVideoAudioRecorder", 1, "onDestroy quitSafely");
                        } else {
                            handlerThread.getLooper().quit();
                            QLog.i("QavVideoAudioRecorder", 1, "onDestroy quit");
                        }
                    } catch (Exception e16) {
                        QLog.e("QavVideoAudioRecorder", 1, "onDestroy Exception", e16);
                    }
                }
            });
        }
    }

    public void l(com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar, g gVar) {
        if (QLog.isColorLevel()) {
            QLog.w("QavVideoAudioRecorder", 2, "startRecording EGLContext = " + cVar.b() + ", config=" + cVar);
        }
        this.f75836d = gVar;
        Message obtain = Message.obtain();
        obtain.obj = cVar;
        obtain.what = 0;
        this.f75834b.sendMessage(obtain);
    }

    public void m() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.f75834b.sendMessage(obtain);
    }

    public void n(int i3, int i16, float[] fArr, float[] fArr2, long j3) {
        this.f75834b.removeMessages(2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = new Object[]{Integer.valueOf(i3), Integer.valueOf(i16), fArr, fArr2, Long.valueOf(j3)};
        this.f75834b.sendMessage(obtain);
    }
}
