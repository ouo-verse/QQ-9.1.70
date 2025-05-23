package iq;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Liq/g;", "", "", "b", "Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/g;", "iMediaMuxerWrapper", "", "length", "d", "", "pcmData", "", "isEnd", "c", "e", "a", "Landroid/os/HandlerThread;", "Landroid/os/HandlerThread;", "mAudioEncodeThread", "Landroid/os/Handler;", "Landroid/os/Handler;", "mAudioEncodeHandler", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private HandlerThread mAudioEncodeThread;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Handler mAudioEncodeHandler;

    public final void a() {
        ms.a.f("HwAudioCaptureEncoder", "destroy");
        Handler handler = this.mAudioEncodeHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        e();
        HandlerThread handlerThread = this.mAudioEncodeThread;
        if (handlerThread != null) {
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.mAudioEncodeThread = null;
        }
    }

    public final void b() {
        ms.a.f("HwAudioCaptureEncoder", "initThread");
        HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("HwAudioCaptureEncoder", 0);
        this.mAudioEncodeThread = newFreeHandlerThread;
        if (newFreeHandlerThread != null) {
            newFreeHandlerThread.start();
        }
        HandlerThread handlerThread = this.mAudioEncodeThread;
        Intrinsics.checkNotNull(handlerThread);
        Looper looper = handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "mAudioEncodeThread!!.looper");
        this.mAudioEncodeHandler = new b(looper);
    }

    public final void c(byte[] pcmData, int length, boolean isEnd) {
        Message obtainMessage;
        Intrinsics.checkNotNullParameter(pcmData, "pcmData");
        if (this.mAudioEncodeHandler != null) {
            Object[] objArr = {pcmData, Integer.valueOf(length), Boolean.valueOf(isEnd)};
            Handler handler = this.mAudioEncodeHandler;
            if (handler == null || (obtainMessage = handler.obtainMessage(1001, objArr)) == null) {
                return;
            }
            obtainMessage.sendToTarget();
        }
    }

    public final void d(com.tencent.mobileqq.videocodec.mediacodec.recorder.g iMediaMuxerWrapper, int length) {
        Intrinsics.checkNotNullParameter(iMediaMuxerWrapper, "iMediaMuxerWrapper");
        Handler handler = this.mAudioEncodeHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.mAudioEncodeHandler;
        Message obtainMessage = handler2 != null ? handler2.obtainMessage(1000) : null;
        if (obtainMessage != null) {
            obtainMessage.obj = iMediaMuxerWrapper;
        }
        if (obtainMessage != null) {
            obtainMessage.arg1 = length;
        }
        if (obtainMessage != null) {
            obtainMessage.sendToTarget();
        }
    }

    public final void e() {
        Message obtainMessage;
        ms.a.f("HwAudioCaptureEncoder", "stopRecord");
        Handler handler = this.mAudioEncodeHandler;
        if (handler == null || (obtainMessage = handler.obtainMessage(1002)) == null) {
            return;
        }
        obtainMessage.sendToTarget();
    }
}
