package iq;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b5\u00106J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00068"}, d2 = {"Liq/b;", "Landroid/os/Handler;", "", "pcmData", "", "length", "", "isEnd", "", "b", "frameLen", "c", "a", "Landroid/os/Message;", "msg", "handleMessage", "d", "Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/g;", "iMediaMuxerWrapper", "e", "Landroid/media/MediaCodec;", "Landroid/media/MediaCodec;", "mMediaCodec", "", "Ljava/nio/ByteBuffer;", "[Ljava/nio/ByteBuffer;", "encodeInputBuffers", "encodeOutputBuffers", "Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/g;", "muxerWrapper", "Landroid/media/MediaCodec$BufferInfo;", "Landroid/media/MediaCodec$BufferInfo;", "mBufferInfo", "Liq/f;", "f", "Liq/f;", "timeUtils", "g", "Z", "isStop", "()Z", "setStop", "(Z)V", "", h.F, "J", "getFrameCount", "()J", "setFrameCount", "(J)V", "frameCount", "Landroid/os/Looper;", "looper", "<init>", "(Landroid/os/Looper;)V", "i", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends Handler {

    /* renamed from: j, reason: collision with root package name */
    private static int f408174j = 16384;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile MediaCodec mMediaCodec;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ByteBuffer[] encodeInputBuffers;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ByteBuffer[] encodeOutputBuffers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.videocodec.mediacodec.recorder.g muxerWrapper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MediaCodec.BufferInfo mBufferInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final f timeUtils;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isStop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long frameCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Looper looper) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.encodeInputBuffers = new ByteBuffer[0];
        this.encodeOutputBuffers = new ByteBuffer[0];
        this.mBufferInfo = new MediaCodec.BufferInfo();
        this.timeUtils = new f();
    }

    private final void b(byte[] pcmData, int length, boolean isEnd) {
        MediaCodec mediaCodec = this.mMediaCodec;
        Intrinsics.checkNotNull(mediaCodec);
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        Intrinsics.checkNotNullExpressionValue(inputBuffers, "mMediaCodec!!.inputBuffers");
        this.encodeInputBuffers = inputBuffers;
        MediaCodec mediaCodec2 = this.mMediaCodec;
        Intrinsics.checkNotNull(mediaCodec2);
        ByteBuffer[] outputBuffers = mediaCodec2.getOutputBuffers();
        Intrinsics.checkNotNullExpressionValue(outputBuffers, "mMediaCodec!!.outputBuffers");
        this.encodeOutputBuffers = outputBuffers;
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaCodec mediaCodec3 = this.mMediaCodec;
        Intrinsics.checkNotNull(mediaCodec3);
        int dequeueInputBuffer = mediaCodec3.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer < 0) {
            return;
        }
        ByteBuffer byteBuffer = this.encodeInputBuffers[dequeueInputBuffer];
        byteBuffer.clear();
        long a16 = this.timeUtils.a();
        ms.a.a("HwAudioCaptureEncoder", "encodePCM length = " + length + ", time = " + a16);
        if (length > 0) {
            byteBuffer.limit(length);
            byteBuffer.put(pcmData);
        }
        if (!isEnd && length >= 0) {
            MediaCodec mediaCodec4 = this.mMediaCodec;
            Intrinsics.checkNotNull(mediaCodec4);
            mediaCodec4.queueInputBuffer(dequeueInputBuffer, 0, length, a16, 0);
        } else {
            MediaCodec mediaCodec5 = this.mMediaCodec;
            Intrinsics.checkNotNull(mediaCodec5);
            mediaCodec5.queueInputBuffer(dequeueInputBuffer, 0, length, a16, 4);
        }
    }

    private final void c(int frameLen) {
        MediaFormat createAudioFormat;
        int coerceAtLeast;
        ms.a.f("HwAudioCaptureEncoder", "create mediaEncode frameLen = " + frameLen);
        try {
            createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 44100, 1);
            Intrinsics.checkNotNullExpressionValue(createAudioFormat, "createAudioFormat(MediaF\u2026TYPE_AUDIO_AAC, 44100, 1)");
            createAudioFormat.setInteger("bitrate", 64000);
            createAudioFormat.setInteger("channel-count", 1);
            createAudioFormat.setInteger("channel-mask", 16);
            createAudioFormat.setInteger("aac-profile", 2);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(frameLen, f408174j);
            ms.a.f("HwAudioCaptureEncoder", "create mediaEncode length = " + coerceAtLeast);
            createAudioFormat.setInteger("max-input-size", coerceAtLeast);
            this.mMediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (IOException e16) {
            ms.a.d("HwAudioCaptureEncoder", "initAACMediaEncode failed", e16);
        }
        if (this.mMediaCodec == null) {
            ms.a.c("HwAudioCaptureEncoder", "create mediaEncode failed");
            return;
        }
        MediaCodec mediaCodec = this.mMediaCodec;
        Intrinsics.checkNotNull(mediaCodec);
        mediaCodec.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        MediaCodec mediaCodec2 = this.mMediaCodec;
        Intrinsics.checkNotNull(mediaCodec2);
        mediaCodec2.start();
        MediaCodec mediaCodec3 = this.mMediaCodec;
        Intrinsics.checkNotNull(mediaCodec3);
        ByteBuffer[] inputBuffers = mediaCodec3.getInputBuffers();
        Intrinsics.checkNotNullExpressionValue(inputBuffers, "mMediaCodec!!.inputBuffers");
        this.encodeInputBuffers = inputBuffers;
        MediaCodec mediaCodec4 = this.mMediaCodec;
        Intrinsics.checkNotNull(mediaCodec4);
        ByteBuffer[] outputBuffers = mediaCodec4.getOutputBuffers();
        Intrinsics.checkNotNullExpressionValue(outputBuffers, "mMediaCodec!!.outputBuffers");
        this.encodeOutputBuffers = outputBuffers;
    }

    public final void d() {
        try {
            ms.a.a("HwAudioCaptureEncoder", "dstAudioFormatFromPCM release");
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                mediaCodec.stop();
                mediaCodec.release();
                this.mMediaCodec = null;
            }
            com.tencent.mobileqq.videocodec.mediacodec.recorder.g gVar = this.muxerWrapper;
            if (gVar != null) {
                gVar.release();
            }
        } catch (Exception unused) {
        }
    }

    public final void e(com.tencent.mobileqq.videocodec.mediacodec.recorder.g iMediaMuxerWrapper) {
        Intrinsics.checkNotNullParameter(iMediaMuxerWrapper, "iMediaMuxerWrapper");
        this.muxerWrapper = iMediaMuxerWrapper;
        this.isStop = false;
        this.frameCount = 0L;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.handleMessage(msg2);
        switch (msg2.what) {
            case 1000:
                this.isStop = false;
                c(msg2.arg1);
                Object obj = msg2.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.videocodec.mediacodec.recorder.IMediaMuxerWrapper");
                e((com.tencent.mobileqq.videocodec.mediacodec.recorder.g) obj);
                return;
            case 1001:
                Object obj2 = msg2.obj;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
                Object[] objArr = (Object[]) obj2;
                try {
                    Object obj3 = objArr[0];
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.ByteArray");
                    Object obj4 = objArr[1];
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) obj4).intValue();
                    Object obj5 = objArr[2];
                    Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                    b((byte[]) obj3, intValue, ((Boolean) obj5).booleanValue());
                    a();
                    return;
                } catch (Exception e16) {
                    ms.a.d("HwAudioCaptureEncoder", "dstAudioFormatFromPCM encounter error", e16);
                    e16.printStackTrace();
                    return;
                }
            case 1002:
                if (this.isStop) {
                    ms.a.c("HwAudioCaptureEncoder", "dstAudioFormatFromPCM already STOP");
                }
                this.isStop = true;
                d();
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b2, code lost:
    
        r1 = r10.encodeOutputBuffers[r2];
        r3 = r10.mBufferInfo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00bc, code lost:
    
        if ((r3.flags & 2) == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00be, code lost:
    
        r3.size = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c2, code lost:
    
        if (r3.size == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c4, code lost:
    
        r1.position(r3.offset);
        r3 = r10.mBufferInfo;
        r1.limit(r3.offset + r3.size);
        r3 = r10.mBufferInfo;
        ms.a.a("HwAudioCaptureEncoder", "dstAudioFormatFromPCM writeSampleData size = " + r3.size + ",  ts = " + r3.presentationTimeUs);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0103, code lost:
    
        if (r10.mBufferInfo.presentationTimeUs <= r10.timeUtils.getPrevOutputPTSUs()) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0105, code lost:
    
        r10.timeUtils.c(r10.mBufferInfo.presentationTimeUs);
        r3 = r10.muxerWrapper;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0110, code lost:
    
        if (r3 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0112, code lost:
    
        r3.writeSampleData(1, r1, r10.mBufferInfo);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0118, code lost:
    
        ms.a.c("HwAudioCaptureEncoder", "dstAudioFormatFromPCM writeSampleData timestamp is error");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x011e, code lost:
    
        r1 = r10.mMediaCodec;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0120, code lost:
    
        if (r1 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0122, code lost:
    
        r1.releaseOutputBuffer(r2, false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a() {
        do {
            int i3 = 0;
            while (true) {
                MediaCodec mediaCodec = this.mMediaCodec;
                Intrinsics.checkNotNull(mediaCodec);
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.mBufferInfo, 10000L);
                ms.a.a("HwAudioCaptureEncoder", "dstAudioFormatFromPCM outputIndex = " + dequeueOutputBuffer);
                if (dequeueOutputBuffer != -1) {
                    if (dequeueOutputBuffer != -3) {
                        if (dequeueOutputBuffer != -2) {
                            if (dequeueOutputBuffer >= 0) {
                                break;
                            }
                            ms.a.f("HwAudioCaptureEncoder", "dstAudioFormatFromPCM outputIndex = " + dequeueOutputBuffer + " < 0");
                        } else {
                            ms.a.f("HwAudioCaptureEncoder", "dstAudioFormatFromPCM INFO_OUTPUT_FORMAT_CHANGED");
                            MediaCodec mediaCodec2 = this.mMediaCodec;
                            Intrinsics.checkNotNull(mediaCodec2);
                            MediaFormat outputFormat = mediaCodec2.getOutputFormat();
                            Intrinsics.checkNotNullExpressionValue(outputFormat, "mMediaCodec!!.outputFormat");
                            com.tencent.mobileqq.videocodec.mediacodec.recorder.g gVar = this.muxerWrapper;
                            if (gVar != null) {
                                gVar.b(1, outputFormat);
                            }
                        }
                    } else {
                        ms.a.a("HwAudioCaptureEncoder", "dstAudioFormatFromPCM INFO_OUTPUT_BUFFERS_CHANGED");
                        MediaCodec mediaCodec3 = this.mMediaCodec;
                        Intrinsics.checkNotNull(mediaCodec3);
                        ByteBuffer[] outputBuffers = mediaCodec3.getOutputBuffers();
                        Intrinsics.checkNotNullExpressionValue(outputBuffers, "mMediaCodec!!.outputBuffers");
                        this.encodeOutputBuffers = outputBuffers;
                    }
                } else {
                    ms.a.a("HwAudioCaptureEncoder", "dstAudioFormatFromPCM INFO_TRY_AGAIN_LATER");
                    if (!this.isStop) {
                        ms.a.a("HwAudioCaptureEncoder", "dstAudioFormatFromPCM no output available yet");
                        return;
                    }
                    i3++;
                    if (i3 > 10) {
                        ms.a.c("HwAudioCaptureEncoder", "dstAudioFormatFromPCM endTryTimes = " + i3);
                        return;
                    }
                }
            }
        } while ((this.mBufferInfo.flags & 4) == 0);
        ms.a.f("HwAudioCaptureEncoder", "dstAudioFormatFromPCM BUFFER_FLAG_END_OF_STREAM");
    }
}
