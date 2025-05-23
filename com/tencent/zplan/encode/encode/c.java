package com.tencent.zplan.encode.encode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.encode.utils.MediaCodecEncodeType;
import cooperation.qzone.QzoneIPCModule;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000 ;2\u00020\u0001:\u0001=B+\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010D\u001a\u00020\u0002\u0012\b\u0010I\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010M\u001a\u00020\u0018\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\tH\u0002J\u0010\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020\tH\u0002J\b\u0010+\u001a\u00020\tH\u0016J\b\u0010,\u001a\u00020\tH\u0016J \u00102\u001a\u00020 2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u0004H&J\u0006\u00103\u001a\u00020\tJ\u001a\u00104\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH&J\b\u00105\u001a\u00020\tH\u0016J\"\u0010:\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u0001062\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0004H\u0016J\u0014\u0010;\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000106H\u0016J\b\u0010<\u001a\u00020\tH\u0016R\u001a\u0010\u001d\u001a\u00020\u001c8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010D\u001a\u00020\u00028\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010I\u001a\u0004\u0018\u00010E8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010F\u001a\u0004\bG\u0010HR\u001a\u0010M\u001a\u00020\u00188\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010J\u001a\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010OR\u0016\u0010R\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010QR\u0016\u0010T\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010SR\u0016\u0010U\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010SR\u0016\u0010V\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010SR\u0016\u0010W\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010SR\u0016\u0010X\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010SR\u0016\u0010Z\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010YR\u0016\u0010[\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010YR\u0016\u0010\\\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010Y\u00a8\u0006_"}, d2 = {"Lcom/tencent/zplan/encode/encode/c;", "", "Lcom/tencent/zplan/encode/utils/a;", "configInfo", "", "c", "b", "Lcom/tencent/zplan/encode/encode/EncodeState;", "newState", "", "e", "E", "Lcom/tencent/zplan/encode/encode/f;", "info", "", BdhLogUtil.LogTag.Tag_Conn, "t", "B", "frameInfo", ReportConstant.COSTREPORT_PREFIX, "isInput", "errOcur", "f", "errCode", "", "errMsg", HippyTKDListViewAdapter.X, "d", "Landroid/media/MediaCodec;", "mediaCodec", "inputEnd", h.F, "Lcom/tencent/zplan/encode/encode/a;", "p", "w", "j", "l", QzoneIPCModule.RESULT_CODE, "k", "", "duration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "D", "i", "Ljava/nio/ByteBuffer;", "outputBuffer", "Landroid/media/MediaCodec$BufferInfo;", "outputBufferInfo", "outputBufferIndex", DomainData.DOMAIN_NAME, "v", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "data", "dataSize", "frameIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "o", "y", "a", "Landroid/media/MediaCodec;", "r", "()Landroid/media/MediaCodec;", "Lcom/tencent/zplan/encode/utils/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/zplan/encode/utils/a;", "encodeConfigInfo", "Lcom/tencent/zplan/encode/b;", "Lcom/tencent/zplan/encode/b;", "getListener", "()Lcom/tencent/zplan/encode/b;", "listener", "Ljava/lang/String;", "getTempPath", "()Ljava/lang/String;", "tempPath", "Lpx4/a;", "Lpx4/a;", "frameManager", "Lcom/tencent/zplan/encode/encode/EncodeState;", "state", "Z", "cancelFlag", "interruptFlag", "inputEndFlag", "alreadyNotifyFormatChange", "handledFinalInputFrame", "I", "handleInputContinueErrCount", "handleOutputContinueErrCount", "queueDataContinueErrCount", "<init>", "(Landroid/media/MediaCodec;Lcom/tencent/zplan/encode/utils/a;Lcom/tencent/zplan/encode/b;Ljava/lang/String;)V", "hardware_encode_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes38.dex */
public abstract class c {

    /* renamed from: p, reason: collision with root package name */
    private static final a f385351p = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MediaCodec mediaCodec;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.zplan.encode.utils.a encodeConfigInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.zplan.encode.b listener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String tempPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final px4.a frameManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private EncodeState state;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean cancelFlag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean interruptFlag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean inputEndFlag;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean alreadyNotifyFormatChange;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean handledFinalInputFrame;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int handleInputContinueErrCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int handleOutputContinueErrCount;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int queueDataContinueErrCount;

    public c(MediaCodec mediaCodec, com.tencent.zplan.encode.utils.a encodeConfigInfo, com.tencent.zplan.encode.b bVar, String tempPath) {
        Intrinsics.checkParameterIsNotNull(mediaCodec, "mediaCodec");
        Intrinsics.checkParameterIsNotNull(encodeConfigInfo, "encodeConfigInfo");
        Intrinsics.checkParameterIsNotNull(tempPath, "tempPath");
        this.mediaCodec = mediaCodec;
        this.encodeConfigInfo = encodeConfigInfo;
        this.listener = bVar;
        this.tempPath = tempPath;
        this.state = EncodeState.NONE;
        px4.a aVar = new px4.a(c(encodeConfigInfo), b(encodeConfigInfo), tempPath);
        this.frameManager = aVar;
        if (com.tencent.zplan.encode.d.f()) {
            com.tencent.zplan.encode.d.a("SR_MP4_Encoder", 1, encodeConfigInfo.f385463a + ", frameManager, " + aVar);
        }
        g();
        e(EncodeState.INIT);
    }

    private final f B() {
        try {
            return this.frameManager.g();
        } catch (Throwable th5) {
            com.tencent.zplan.encode.d.c("SR_MP4_Encoder", 1, "safelyPollElement, err, ", th5);
            return null;
        }
    }

    private final void E() {
        if (this.state != EncodeState.START) {
            return;
        }
        e(EncodeState.IDLE);
        px4.b.a(new Runnable() { // from class: com.tencent.zplan.encode.encode.b
            @Override // java.lang.Runnable
            public final void run() {
                c.F(c.this);
            }
        }, "Mp4MediaEncoder", 5).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(c this$0) {
        Intrinsics.checkParameterIsNotNull(this$0, "this$0");
        this$0.i();
        while (!this$0.t()) {
            if (this$0.cancelFlag) {
                this$0.j();
                return;
            }
            if (this$0.interruptFlag) {
                this$0.l();
                return;
            }
            f B = this$0.B();
            if (this$0.C(B)) {
                this$0.e(EncodeState.IDLE);
                this$0.m(10L);
                com.tencent.zplan.encode.d.a("SR_MP4_Encoder", 1, "wait next input frame");
            } else {
                this$0.e(EncodeState.RUNNING);
                this$0.s(B);
            }
        }
    }

    private final int b(com.tencent.zplan.encode.utils.a configInfo) {
        int i3 = 1;
        if (configInfo.f385476n == 1 && configInfo.f385477o == MediaCodecEncodeType.BUFFER) {
            i3 = 2;
        }
        if (configInfo.f385463a) {
            return configInfo.f385466d * i3 * configInfo.f385467e * 4;
        }
        return configInfo.f385473k * 2 * configInfo.f385474l;
    }

    private final int c(com.tencent.zplan.encode.utils.a configInfo) {
        if (configInfo.f385463a) {
            int i3 = configInfo.f385475m / ((configInfo.f385466d * configInfo.f385467e) * 4);
            if (i3 <= 0) {
                return 2;
            }
            return i3;
        }
        int i16 = 376832 / ((configInfo.f385473k * 2) * configInfo.f385474l);
        if (i16 <= 0) {
            return 50;
        }
        return i16;
    }

    private final boolean d() {
        return (this.cancelFlag || this.interruptFlag) ? false : true;
    }

    private final void e(EncodeState newState) {
        if (this.state == newState) {
            return;
        }
        if (com.tencent.zplan.encode.d.f()) {
            com.tencent.zplan.encode.d.a("SR_MP4_Encoder", 1, this.encodeConfigInfo.f385463a + ", changeState, old:" + this.state.name() + ", new:" + newState.name());
        }
        this.state = newState;
    }

    private final void g() {
        try {
            this.frameManager.a();
        } catch (Throwable th5) {
            com.tencent.zplan.encode.d.c("SR_MP4_Encoder", 1, "clearQueue err, ", th5);
        }
    }

    private final boolean h(MediaCodec mediaCodec, boolean inputEnd) {
        a p16;
        do {
            if (!d() || (p16 = p(mediaCodec)) == f385351p) {
                return false;
            }
            if (p16 == null) {
                return true;
            }
            if (p16.f385348c == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            MediaCodec.BufferInfo bufferInfo = p16.f385348c;
            if ((bufferInfo.flags & 2) != 0) {
                bufferInfo.size = 0;
            }
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Encoder", 1, "queueOutput, isVideo:" + this.encodeConfigInfo.f385463a + ", pts:" + p16.f385348c.presentationTimeUs + ", size:" + p16.f385348c.size + ", isConfig:" + (p16.f385348c.flags & 2) + ", isEnd:" + (p16.f385348c.flags & 4));
            }
            try {
                MediaCodec.BufferInfo bufferInfo2 = p16.f385348c;
                if (bufferInfo2.size != 0) {
                    p16.f385346a.position(bufferInfo2.offset);
                    ByteBuffer byteBuffer = p16.f385346a;
                    MediaCodec.BufferInfo bufferInfo3 = p16.f385348c;
                    byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                    com.tencent.zplan.encode.b bVar = this.listener;
                    if (bVar != null) {
                        bVar.a(p16.f385346a, p16.f385348c);
                    }
                }
            } catch (Throwable th5) {
                com.tencent.zplan.encode.d.c("SR_MP4_Encoder", 1, "dataOutputFromCodec fill data err, ", th5);
            }
            try {
                mediaCodec.releaseOutputBuffer(p16.f385347b, false);
            } catch (Throwable th6) {
                com.tencent.zplan.encode.d.c("SR_MP4_Encoder", 1, "dataOutputFromCodec releaseOutputBuffer err, ", th6);
            }
            com.tencent.zplan.encode.d.a("cuilamTest-time", 4, Intrinsics.stringPlus("[\u5408\u6210\u4e00\u5e27] ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            com.tencent.zplan.encode.d.a("SR_MP4_Encoder", 4, Intrinsics.stringPlus("dataOutputFromCodec flags:", Integer.valueOf(p16.f385348c.flags)));
        } while ((p16.f385348c.flags & 4) == 0);
        k(inputEnd ? 0 : -1001);
        return true;
    }

    private final void j() {
        e(EncodeState.CANCEL);
        com.tencent.zplan.encode.b bVar = this.listener;
        if (bVar != null) {
            bVar.d();
        }
        A();
    }

    private final void l() {
        e(EncodeState.INTERRUPT);
        A();
    }

    private final void m(long duration) {
        try {
            LockMethodProxy.sleep(duration);
        } catch (InterruptedException e16) {
            com.tencent.zplan.encode.d.c("SR_MP4_Encoder", 1, "sleep error: ", e16);
        }
    }

    private final a p(MediaCodec mediaCodec) {
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        try {
            int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 5000L);
            if (dequeueOutputBuffer == -2) {
                w(mediaCodec);
                return null;
            }
            if (dequeueOutputBuffer == -3) {
                if (!com.tencent.zplan.encode.d.f()) {
                    return null;
                }
                com.tencent.zplan.encode.d.a("SR_MP4_Encoder", 1, this.encodeConfigInfo.f385463a + ", INFO_OUTPUT_BUFFERS_CHANGED");
                return null;
            }
            if (dequeueOutputBuffer < 0) {
                return null;
            }
            com.tencent.zplan.encode.d.a("SR_MP4_Encoder", 4, Intrinsics.stringPlus("getAvailableOutputByteBuffer outputBufferIndex:", Integer.valueOf(dequeueOutputBuffer)));
            ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(dequeueOutputBuffer);
            if (outputBuffer != null) {
                return n(outputBuffer, bufferInfo, dequeueOutputBuffer);
            }
            return null;
        } catch (Throwable th5) {
            com.tencent.zplan.encode.d.c("SR_MP4_Encoder", 1, "getAvailableOutputByteBuffer error, ", th5);
            return f385351p;
        }
    }

    private final void s(f frameInfo) {
        MediaCodec mediaCodec = this.mediaCodec;
        try {
            if (!this.handledFinalInputFrame) {
                boolean u16 = u(mediaCodec, frameInfo);
                if (frameInfo == null) {
                    com.tencent.zplan.encode.d.a("SR_MP4_Encoder", 1, "handleFrameData frameInfo is null");
                    this.handledFinalInputFrame = true;
                }
                f(true, !u16);
            }
        } catch (Throwable th5) {
            com.tencent.zplan.encode.d.c("SR_MP4_Encoder", 1, "inputDataIntoCodec error:", th5);
        }
        if (this.state == EncodeState.ERROR) {
            return;
        }
        try {
            f(false, !h(mediaCodec, frameInfo == null));
        } catch (Throwable th6) {
            com.tencent.zplan.encode.d.c("SR_MP4_Encoder", 1, "dataOutputFromCodec error:", th6);
        }
    }

    private final boolean t() {
        return this.state.ordinal() >= EncodeState.CANCEL.ordinal();
    }

    private final void w(MediaCodec mediaCodec) {
        if (com.tencent.zplan.encode.d.f()) {
            com.tencent.zplan.encode.d.a("SR_MP4_Encoder", 1, "notifyFormatChange, isVideo:" + this.encodeConfigInfo.f385463a + ", alreadyNotify:" + this.alreadyNotifyFormatChange);
        }
        if (this.alreadyNotifyFormatChange) {
            return;
        }
        MediaFormat outputFormat = mediaCodec.getOutputFormat();
        Intrinsics.checkExpressionValueIsNotNull(outputFormat, "mediaCodec.outputFormat");
        com.tencent.zplan.encode.b bVar = this.listener;
        if (bVar != null) {
            bVar.e(outputFormat, this.encodeConfigInfo.f385463a);
            this.alreadyNotifyFormatChange = true;
        }
    }

    private final void x(int errCode, String errMsg) {
        e(EncodeState.ERROR);
        com.tencent.zplan.encode.b bVar = this.listener;
        if (bVar != null) {
            bVar.c(errCode, errMsg);
        }
        A();
    }

    public void A() {
        g();
        MediaCodec mediaCodec = this.mediaCodec;
        try {
            mediaCodec.stop();
            mediaCodec.release();
        } catch (Throwable th5) {
            com.tencent.zplan.encode.d.c("SR_MP4_Encoder", 1, Intrinsics.stringPlus("release error, ", Boolean.valueOf(this.encodeConfigInfo.f385463a)), th5);
        }
    }

    public void D() {
        if (this.state != EncodeState.INIT) {
            return;
        }
        try {
            this.mediaCodec.start();
            e(EncodeState.START);
            com.tencent.zplan.encode.b bVar = this.listener;
            if (bVar != null) {
                bVar.onEncodeStart();
            }
            E();
        } catch (Throwable th5) {
            com.tencent.zplan.encode.d.c("SR_MP4_Encoder", 1, this.encodeConfigInfo.f385463a + ", start error:", th5);
            x(-1000, Intrinsics.stringPlus("start error: ", th5.getMessage()));
        }
    }

    public abstract a n(ByteBuffer outputBuffer, MediaCodec.BufferInfo outputBufferInfo, int outputBufferIndex);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: q, reason: from getter */
    public final com.tencent.zplan.encode.utils.a getEncodeConfigInfo() {
        return this.encodeConfigInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: r, reason: from getter */
    public final MediaCodec getMediaCodec() {
        return this.mediaCodec;
    }

    public abstract boolean u(MediaCodec mediaCodec, f frameInfo);

    public void z(byte[] data, int dataSize, int frameIndex) {
        float f16;
        Object valueOf;
        if (com.tencent.zplan.encode.d.f()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("queueData, isVideo:");
            sb5.append(this.encodeConfigInfo.f385463a);
            sb5.append(", dataSize:");
            sb5.append(dataSize);
            sb5.append(", data.size:");
            if (data == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(data.length);
            }
            sb5.append(valueOf);
            sb5.append(", frameIndex:");
            sb5.append(frameIndex);
            sb5.append(", frameManager:");
            sb5.append(this.frameManager);
            sb5.append(", cancel:");
            sb5.append(this.cancelFlag);
            sb5.append(", end:");
            sb5.append(this.inputEndFlag);
            sb5.append(", state:");
            sb5.append(this.state.name());
            com.tencent.zplan.encode.d.a("SR_MP4_Encoder", 1, sb5.toString());
        }
        if (this.state.ordinal() <= EncodeState.START.ordinal() || this.state.ordinal() >= EncodeState.CANCEL.ordinal() || this.inputEndFlag || !d()) {
            return;
        }
        if (this.frameManager.f(data, dataSize, frameIndex)) {
            int i3 = this.queueDataContinueErrCount + 1;
            this.queueDataContinueErrCount = i3;
            if (i3 >= 10) {
                v();
                x(-1004, "continue queue err");
            }
            com.tencent.zplan.encode.d.b("SR_MP4_Encoder", 1, this.encodeConfigInfo.f385463a + ", queueData, error data, ignore");
            return;
        }
        this.queueDataContinueErrCount = 0;
        if (!this.encodeConfigInfo.f385463a) {
            f16 = frameIndex * (1000000.0f / r0.f385472j) * (dataSize / (r0.f385474l * 2));
        } else {
            f16 = frameIndex * (1000000.0f / r0.f385470h);
        }
        this.frameManager.h(o(data), dataSize, frameIndex, f16);
    }

    private final void k(int resultCode) {
        com.tencent.zplan.encode.d.a("SR_MP4_Encoder", 4, "doComplete resultCode");
        e(EncodeState.FINISH);
        com.tencent.zplan.encode.b bVar = this.listener;
        if (bVar != null) {
            bVar.b(resultCode);
        }
        A();
    }

    public final void v() {
        this.interruptFlag = true;
    }

    public void y() {
        this.inputEndFlag = true;
    }

    private final boolean C(f info) {
        return info == null && !this.inputEndFlag;
    }

    private final void f(boolean isInput, boolean errOcur) {
        if (isInput) {
            this.handleInputContinueErrCount = errOcur ? this.handleInputContinueErrCount + 1 : 0;
        } else {
            this.handleOutputContinueErrCount = errOcur ? this.handleOutputContinueErrCount + 1 : 0;
        }
        if (isInput && this.handleInputContinueErrCount >= 10) {
            x(-1002, "continue err");
        } else {
            if (isInput || this.handleOutputContinueErrCount < 10) {
                return;
            }
            x(-1003, "continue err");
        }
    }

    public void i() {
    }

    public byte[] o(byte[] data) {
        return data;
    }
}
