package com.tencent.mobileqq.ar.ARRecord;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private VideoEncoderCore f197052d;

    /* renamed from: e, reason: collision with root package name */
    private a f197053e;

    /* renamed from: f, reason: collision with root package name */
    private HandlerThread f197054f;

    /* renamed from: h, reason: collision with root package name */
    private Handler f197055h;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a();

        void b();

        void g(int i3);

        void onEncodeStart();
    }

    private void c(byte[] bArr, long j3) {
        VideoEncoderCore videoEncoderCore = this.f197052d;
        if (videoEncoderCore != null) {
            try {
                videoEncoderCore.h(bArr, j3);
            } catch (Exception e16) {
                QLog.e("VideoEncoder", 1, "handleAudioFrameAvailable encode audio fail.", e16);
                a aVar = this.f197053e;
                if (aVar != null) {
                    aVar.g(3);
                }
            }
        }
    }

    private void d() {
        QLog.d("VideoEncoder", 2, "handleStopRecording");
        VideoEncoderCore videoEncoderCore = this.f197052d;
        if (videoEncoderCore != null) {
            try {
                videoEncoderCore.n();
            } catch (Exception e16) {
                QLog.e("VideoEncoder", 1, "handleStopRecording stop encoder fail.", e16);
                a aVar = this.f197053e;
                if (aVar != null) {
                    aVar.g(2);
                }
            }
            this.f197052d = null;
        }
        HandlerThread handlerThread = this.f197054f;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f197054f = null;
        }
        Handler handler = this.f197055h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f197055h = null;
        }
        a aVar2 = this.f197053e;
        if (aVar2 != null) {
            aVar2.b();
            this.f197053e = null;
        }
    }

    private void e(long j3) {
        VideoEncoderCore videoEncoderCore = this.f197052d;
        if (videoEncoderCore != null) {
            try {
                videoEncoderCore.o(j3);
            } catch (Exception e16) {
                QLog.e("VideoEncoder", 1, "handleVideoFrameAvailable encode video fail.", e16);
                a aVar = this.f197053e;
                if (aVar != null) {
                    aVar.g(4);
                }
            }
        }
    }

    public void a(byte[] bArr, long j3) {
        if (this.f197055h != null) {
            QLog.d("VideoEncoder", 2, String.format("audioFrameAvailable timestampNanos=%s", Long.valueOf(j3)));
            this.f197055h.obtainMessage(3, new Object[]{bArr, Long.valueOf(j3)}).sendToTarget();
        }
    }

    public Surface b() {
        VideoEncoderCore videoEncoderCore = this.f197052d;
        if (videoEncoderCore != null) {
            return videoEncoderCore.i();
        }
        return null;
    }

    public void f(com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar, a aVar) {
        QLog.d("VideoEncoder", 2, "startRecording");
        this.f197053e = aVar;
        if (this.f197054f == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("EncodeThread");
            this.f197054f = baseHandlerThread;
            baseHandlerThread.start();
            this.f197055h = new Handler(this.f197054f.getLooper(), this);
        }
        if (this.f197055h != null) {
            try {
                VideoEncoderCore videoEncoderCore = new VideoEncoderCore();
                this.f197052d = videoEncoderCore;
                videoEncoderCore.m(cVar, aVar);
            } catch (Exception e16) {
                QLog.e("VideoEncoder", 1, "startRecording start encoder fail.", e16);
                a aVar2 = this.f197053e;
                if (aVar2 != null) {
                    aVar2.g(1);
                }
            }
            a aVar3 = this.f197053e;
            if (aVar3 != null) {
                aVar3.onEncodeStart();
            }
        }
    }

    public void g() {
        QLog.d("VideoEncoder", 2, "stopRecording");
        Handler handler = this.f197055h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f197055h.sendEmptyMessage(2);
        }
    }

    public void h(long j3) {
        if (this.f197055h != null) {
            QLog.d("VideoEncoder", 2, String.format("videoFrameAvailable timestampNanos=%s", Long.valueOf(j3)));
            this.f197055h.removeMessages(4);
            this.f197055h.obtainMessage(4, Long.valueOf(j3)).sendToTarget();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    e(((Long) message.obj).longValue());
                }
            } else {
                Object[] objArr = (Object[]) message.obj;
                c((byte[]) objArr[0], ((Long) objArr[1]).longValue());
            }
        } else {
            d();
        }
        return true;
    }
}
