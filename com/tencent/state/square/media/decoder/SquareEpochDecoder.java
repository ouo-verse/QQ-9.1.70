package com.tencent.state.square.media.decoder;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.media.IMediaDecoder;
import com.tencent.state.square.media.IMediaExtractor;
import com.tencent.state.square.media.ISquareDecoder;
import com.tencent.state.square.media.ISquareRender;
import com.tencent.state.square.media.MediaSource;
import com.tencent.state.square.media.StopFrom;
import com.tencent.state.square.media.VideoInfo;
import com.tencent.state.square.media.extractor.SystemMediaExtractor;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001GB!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\"\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020 H\u0002J\b\u0010+\u001a\u00020 H\u0002J\u0012\u0010,\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010\u0012\u001a\u00020'H\u0016J\b\u00100\u001a\u00020'H\u0016J\b\u00101\u001a\u00020 H\u0016J\b\u00102\u001a\u00020'H\u0002J\b\u00103\u001a\u00020 H\u0016J\b\u00104\u001a\u00020 H\u0016J\b\u00105\u001a\u00020 H\u0016J\u0010\u00106\u001a\u00020 2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020'H\u0016J\u0010\u0010>\u001a\u00020 2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020AH\u0002J\u0012\u0010B\u001a\u00020 2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\b\u0010E\u001a\u00020 H\u0016J\b\u0010F\u001a\u00020 H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006H"}, d2 = {"Lcom/tencent/state/square/media/decoder/SquareEpochDecoder;", "Lcom/tencent/state/square/media/ISquareDecoder;", "Landroid/os/Handler$Callback;", "Lcom/tencent/state/square/media/IMediaDecoder$Controller;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "Lcom/tencent/state/square/media/ISquareRender;", "extractor", "Lcom/tencent/state/square/media/IMediaExtractor;", "decoder", "Lcom/tencent/state/square/media/decoder/BaseMediaDecoder;", "(Lcom/tencent/state/square/media/ISquareRender;Lcom/tencent/state/square/media/IMediaExtractor;Lcom/tencent/state/square/media/decoder/BaseMediaDecoder;)V", "decodeHandler", "Landroid/os/Handler;", "decodeThread", "Landroid/os/HandlerThread;", "isDestroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDestroying", "isExecuting", "isPaused", "isResetting", "logPrefix", "", "pauseLock", "Ljava/lang/Object;", "value", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "getUniqueId", "()Ljava/lang/String;", "setUniqueId", "(Ljava/lang/String;)V", "checkPauseState", "", "createDecodeThread", "doResume", "doStop", "from", "Lcom/tencent/state/square/media/StopFrom;", "handleMessage", "", "msg", "Landroid/os/Message;", "handleMessageOfDestroy", "handleMessageOfReset", "handleMessageOfStart", "source", "Lcom/tencent/state/square/media/MediaSource;", "handleMessageOfStop", "isInvalid", "pause", "prepareDecodeThread", "release", "reset", "resume", "setListener", "listener", "Lcom/tencent/state/square/media/ISquareDecoder$Listener;", "setLoopCount", "loopCount", "", "setLoopDecode", "isLoopDecode", "start", "startDecode", "info", "Lcom/tencent/state/square/media/VideoInfo;", "startExecute", "surface", "Landroid/view/Surface;", "stop", "stopWhenComplete", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareEpochDecoder implements ISquareDecoder, Handler.Callback, IMediaDecoder.Controller {
    private static final int MESSAGE_DESTROY = 4;
    private static final int MESSAGE_RESET = 3;
    private static final int MESSAGE_START = 1;
    private static final int MESSAGE_STOP = 2;
    private static final String TAG = "Square_SquareDecoder";
    private Handler decodeHandler;
    private HandlerThread decodeThread;
    private BaseMediaDecoder decoder;
    private final IMediaExtractor extractor;
    private final AtomicBoolean isDestroyed;
    private final AtomicBoolean isDestroying;
    private final AtomicBoolean isExecuting;
    private final AtomicBoolean isPaused;
    private final AtomicBoolean isResetting;
    private String logPrefix;
    private Object pauseLock;
    private final ISquareRender render;
    private String uniqueId;

    public SquareEpochDecoder(ISquareRender render, IMediaExtractor extractor, BaseMediaDecoder decoder) {
        Intrinsics.checkNotNullParameter(render, "render");
        Intrinsics.checkNotNullParameter(extractor, "extractor");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        this.render = render;
        this.extractor = extractor;
        this.decoder = decoder;
        this.uniqueId = "";
        this.logPrefix = "";
        this.isPaused = new AtomicBoolean(false);
        this.pauseLock = new Object();
        this.isExecuting = new AtomicBoolean(false);
        this.isResetting = new AtomicBoolean(false);
        this.isDestroyed = new AtomicBoolean(true);
        this.isDestroying = new AtomicBoolean(false);
    }

    private final HandlerThread createDecodeThread() {
        try {
            return new HandlerThread("Decode-" + hashCode());
        } catch (OutOfMemoryError e16) {
            SquareBaseKt.getSquareLog().e(TAG, "createDecodeThread failed due to OOM: " + e16.getMessage(), e16);
            return null;
        }
    }

    private final void doResume() {
        if (this.isPaused.compareAndSet(true, false)) {
            synchronized (this.pauseLock) {
                this.pauseLock.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void doStop(StopFrom from) {
        Message obtainMessage;
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " doStop: from=" + from);
        this.isExecuting.set(false);
        Handler handler = this.decodeHandler;
        if (handler == null || (obtainMessage = handler.obtainMessage(2, from)) == null) {
            return;
        }
        obtainMessage.sendToTarget();
    }

    private final void handleMessageOfDestroy() {
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " handleMessageOfDestroy: isDestroyed=" + this.isDestroyed.get());
        if (this.isDestroyed.get()) {
            this.isDestroying.set(false);
            return;
        }
        this.decoder.release();
        this.extractor.release();
        Handler handler = this.decodeHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        HandlerThread handlerThread = this.decodeThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.decodeThread = null;
        this.decodeHandler = null;
        this.isExecuting.set(false);
        this.isDestroyed.set(true);
        this.isDestroying.set(false);
    }

    private final void handleMessageOfReset() {
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " handleMessageOfReset: isDestroyed=" + this.isDestroyed.get());
        if (this.isDestroyed.get()) {
            this.isResetting.set(false);
            return;
        }
        this.decoder.reset();
        this.extractor.release();
        this.isExecuting.set(false);
        this.isResetting.set(false);
    }

    private final void handleMessageOfStart(MediaSource source) {
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " handleMessageOfStart: " + source);
        if (source != null) {
            this.isDestroyed.set(false);
            this.decoder.stop(StopFrom.StartCheck);
            this.extractor.release();
            VideoInfo selectVideoTrack = this.extractor.selectVideoTrack(source);
            SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " selectVideoTrack: " + selectVideoTrack);
            if (selectVideoTrack == null) {
                ISquareDecoder.Listener listener = this.decoder.getListener();
                if (listener != null) {
                    ISquareDecoder.Listener.DefaultImpls.onDecodeError$default(listener, 10001, this.logPrefix + " handleMessageOfStart: " + source, false, 4, null);
                    return;
                }
                return;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            this.render.onBeforeDecode(selectVideoTrack.getWidth(), selectVideoTrack.getHeight(), new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.media.decoder.SquareEpochDecoder$handleMessageOfStart$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    Ref.BooleanRef.this.element = z16;
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            if (booleanRef.element) {
                startDecode(selectVideoTrack);
                return;
            }
            SquareBaseKt.getSquareLog().w(TAG, this.logPrefix + " onStartDecode: render is not prepared");
        }
    }

    private final void handleMessageOfStop(StopFrom from) {
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " handleMessageOfStop");
        this.decoder.stop(from);
    }

    private final boolean prepareDecodeThread() {
        if (this.decodeThread == null) {
            synchronized (this) {
                if (this.decodeThread == null) {
                    HandlerThread createDecodeThread = createDecodeThread();
                    if (createDecodeThread != null) {
                        createDecodeThread.start();
                        this.decodeHandler = new Handler(createDecodeThread.getLooper(), this);
                        Unit unit = Unit.INSTANCE;
                    } else {
                        createDecodeThread = null;
                    }
                    this.decodeThread = createDecodeThread;
                    return this.decodeHandler != null;
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return true;
    }

    private final boolean startDecode(VideoInfo info) {
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " startDecode");
        try {
            Surface outputSurface = this.render.getOutputSurface();
            if (!this.decoder.initialize(info, this)) {
                SquareBaseKt.getSquareLog().w(TAG, this.logPrefix + " decoder initialize failed");
                return false;
            }
            try {
                this.decoder.start(info, outputSurface);
                if (isInvalid()) {
                    SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " onStartDecode but isDestroying");
                    return false;
                }
                startExecute(outputSurface);
                return true;
            } catch (MediaCodec.CodecException e16) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, this.logPrefix + " onStartDecode CodecException: " + e16.getDiagnosticInfo() + ", " + e16.getMessage(), null, 4, null);
                this.decoder.error(8, e16);
                return false;
            } catch (Throwable th5) {
                SquareBaseKt.getSquareLog().e(TAG, this.logPrefix + " onStartDecode error: " + th5 + ", " + th5.getMessage(), th5);
                this.decoder.error(8, th5);
                return false;
            }
        } catch (Throwable th6) {
            this.decoder.error(7, th6);
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, this.logPrefix + " get OutputSurface error", null, 4, null);
            return false;
        }
    }

    private final void startExecute(Surface surface) {
        SquareLogger squareLog;
        StringBuilder sb5;
        boolean z16 = true;
        this.isExecuting.set(true);
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " isExecuting set true");
        try {
            BaseMediaDecoder baseMediaDecoder = this.decoder;
            if (surface == null) {
                z16 = false;
            }
            baseMediaDecoder.execute(z16);
        } catch (Throwable th5) {
            try {
                SquareBaseKt.getSquareLog().e(TAG, this.logPrefix + " onDecoderExecuting error: " + th5 + ", " + th5.getMessage(), th5);
                this.decoder.error(6, th5);
                if (!this.isExecuting.get()) {
                    return;
                }
                this.isExecuting.set(false);
                squareLog = SquareBaseKt.getSquareLog();
                sb5 = new StringBuilder();
            } catch (Throwable th6) {
                if (this.isExecuting.get()) {
                    this.isExecuting.set(false);
                    SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " isExecuting set false, finally");
                }
                throw th6;
            }
        }
        if (this.isExecuting.get()) {
            this.isExecuting.set(false);
            squareLog = SquareBaseKt.getSquareLog();
            sb5 = new StringBuilder();
            sb5.append(this.logPrefix);
            sb5.append(" isExecuting set false, finally");
            squareLog.i(TAG, sb5.toString());
        }
    }

    @Override // com.tencent.state.square.media.IMediaDecoder.Controller
    public void checkPauseState() {
        if (this.isPaused.get()) {
            try {
                synchronized (this.pauseLock) {
                    LockMethodProxy.wait(this.pauseLock);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Throwable th5) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, this.logPrefix + " in pause state, wait error: " + th5.getMessage(), null, 4, null);
            }
        }
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == 1) {
            Object obj = msg2.obj;
            if (!(obj instanceof MediaSource)) {
                obj = null;
            }
            handleMessageOfStart((MediaSource) obj);
        } else if (i3 == 2) {
            Object obj2 = msg2.obj;
            if (obj2 != null) {
                handleMessageOfStop((StopFrom) obj2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.state.square.media.StopFrom");
            }
        } else if (i3 == 3) {
            handleMessageOfReset();
        } else if (i3 == 4) {
            handleMessageOfDestroy();
        }
        return true;
    }

    @Override // com.tencent.state.square.media.IMediaDecoder.Controller
    public boolean isExecuting() {
        return this.isExecuting.get();
    }

    @Override // com.tencent.state.square.media.ISquareDecoder
    public boolean isInvalid() {
        return this.isResetting.get() || this.isDestroying.get();
    }

    @Override // com.tencent.state.square.media.ISquareDecoder
    public void pause() {
        if (isInvalid()) {
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " pause");
        this.isPaused.set(true);
    }

    @Override // com.tencent.state.square.media.ISquareDecoder
    public void release() {
        Message obtainMessage;
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " release");
        if (this.isDestroyed.get() || !this.isDestroying.compareAndSet(false, true)) {
            return;
        }
        Handler handler = this.decodeHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        Handler handler2 = this.decodeHandler;
        if (handler2 != null) {
            handler2.removeMessages(3);
        }
        this.isExecuting.set(false);
        doResume();
        Handler handler3 = this.decodeHandler;
        if (handler3 != null && (obtainMessage = handler3.obtainMessage(4)) != null) {
            obtainMessage.sendToTarget();
        }
        this.decoder.setListener(null);
    }

    @Override // com.tencent.state.square.media.ISquareDecoder
    public void reset() {
        Message obtainMessage;
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " reset");
        if (this.isDestroyed.get() || !this.isResetting.compareAndSet(false, true)) {
            return;
        }
        Handler handler = this.decodeHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.isExecuting.set(false);
        doResume();
        Handler handler2 = this.decodeHandler;
        if (handler2 != null && (obtainMessage = handler2.obtainMessage(3)) != null) {
            obtainMessage.sendToTarget();
        }
        this.decoder.setListener(null);
    }

    @Override // com.tencent.state.square.media.ISquareDecoder
    public void resume() {
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " resume");
        doResume();
    }

    @Override // com.tencent.state.square.media.ISquareDecoder
    public void setListener(ISquareDecoder.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.decoder.setListener(listener);
    }

    @Override // com.tencent.state.square.media.ISquareDecoder
    public void setLoopCount(int loopCount) {
        this.decoder.setLoopCount(loopCount);
    }

    @Override // com.tencent.state.square.media.ISquareDecoder
    public void setLoopDecode(boolean isLoopDecode) {
        this.decoder.setLoopDecode(isLoopDecode);
    }

    public final void setUniqueId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.uniqueId = value;
        String str = '[' + hashCode() + "](" + value + ')';
        this.logPrefix = str;
        this.decoder.setLogPrefix(str);
    }

    @Override // com.tencent.state.square.media.ISquareDecoder
    public void start(MediaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " start: " + source);
        if (!prepareDecodeThread()) {
            ISquareDecoder.Listener listener = this.decoder.getListener();
            if (listener != null) {
                ISquareDecoder.Listener.DefaultImpls.onDecodeError$default(listener, 10, null, false, 6, null);
                return;
            }
            return;
        }
        Handler handler = this.decodeHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.isDestroyed.set(false);
        this.isExecuting.set(false);
        doResume();
        Handler handler2 = this.decodeHandler;
        if (handler2 != null) {
            boolean sendMessage = handler2.sendMessage(handler2.obtainMessage(1, source));
            SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " send start message: isSent=" + sendMessage);
            if (sendMessage) {
                return;
            }
            ISquareDecoder.Listener listener2 = this.decoder.getListener();
            if (listener2 != null) {
                ISquareDecoder.Listener.DefaultImpls.onDecodeError$default(listener2, 1, null, true, 2, null);
            }
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.logPrefix);
            sb5.append(" send start message failed: thread status(isInterrupted=");
            HandlerThread handlerThread = this.decodeThread;
            sb5.append(handlerThread != null ? Boolean.valueOf(handlerThread.isInterrupted()) : null);
            sb5.append(", isAlive=");
            HandlerThread handlerThread2 = this.decodeThread;
            sb5.append(handlerThread2 != null ? Boolean.valueOf(handlerThread2.isAlive()) : null);
            sb5.append(')');
            SquareLogger.DefaultImpls.e$default(squareLog, TAG, sb5.toString(), null, 4, null);
        }
    }

    @Override // com.tencent.state.square.media.ISquareDecoder
    public void stop() {
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + " stop");
        Handler handler = this.decodeHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        doResume();
        doStop(StopFrom.UserStop);
    }

    @Override // com.tencent.state.square.media.IMediaDecoder.Controller
    public void stopWhenComplete() {
        doStop(StopFrom.VideoComplete);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SquareEpochDecoder(ISquareRender iSquareRender, IMediaExtractor iMediaExtractor, BaseMediaDecoder baseMediaDecoder, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(iSquareRender, iMediaExtractor, (i3 & 4) != 0 ? new MediaCodecDecoder(iMediaExtractor, iSquareRender) : baseMediaDecoder);
        iMediaExtractor = (i3 & 2) != 0 ? new SystemMediaExtractor() : iMediaExtractor;
    }
}
