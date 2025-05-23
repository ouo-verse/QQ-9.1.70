package com.tencent.state.square.media.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.media.IMediaDecoder;
import com.tencent.state.square.media.IMediaExtractor;
import com.tencent.state.square.media.ISquareDecoder;
import com.tencent.state.square.media.ISquarePlayerKt;
import com.tencent.state.square.media.ISquareRender;
import com.tencent.state.square.media.MediaCodecState;
import com.tencent.state.square.media.StopFrom;
import com.tencent.state.square.media.VideoInfo;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\u000f\u0010#\u001a\u0004\u0018\u00010\u0012H\u0002\u00a2\u0006\u0002\u0010$J\u001a\u0010%\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tencent/state/square/media/decoder/MediaCodecDecoder;", "Lcom/tencent/state/square/media/decoder/BaseMediaDecoder;", "extractor", "Lcom/tencent/state/square/media/IMediaExtractor;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "Lcom/tencent/state/square/media/ISquareRender;", "(Lcom/tencent/state/square/media/IMediaExtractor;Lcom/tencent/state/square/media/ISquareRender;)V", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "codecState", "Lcom/tencent/state/square/media/MediaCodecState;", "controller", "Lcom/tencent/state/square/media/IMediaDecoder$Controller;", "decoder", "Landroid/media/MediaCodec;", "loop", "", "changeCodecState", "", "state", "createDecoder", "mime", "", "error", "code", "e", "", "execute", "isRenderDirectly", "", "initialize", "info", "Lcom/tencent/state/square/media/VideoInfo;", "release", "reset", "resetDecoder", "()Lkotlin/Unit;", "start", "surface", "Landroid/view/Surface;", "stop", "from", "Lcom/tencent/state/square/media/StopFrom;", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MediaCodecDecoder extends BaseMediaDecoder {
    private static final long DEQUEUE_INPUT_TIMEOUT = 10000;
    private static final long DEQUEUE_OUTPUT_TIMEOUT = 10000;
    private static final String TAG = "Square_MediaCodecDecoder";
    private MediaCodec.BufferInfo bufferInfo;
    private MediaCodecState codecState;
    private IMediaDecoder.Controller controller;
    private MediaCodec decoder;
    private final IMediaExtractor extractor;
    private int loop;
    private final ISquareRender render;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaCodecState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MediaCodecState.Released.ordinal()] = 1;
            iArr[MediaCodecState.Uninitialized.ordinal()] = 2;
            iArr[MediaCodecState.Executing.ordinal()] = 3;
            iArr[MediaCodecState.Error.ordinal()] = 4;
            iArr[MediaCodecState.Configured.ordinal()] = 5;
        }
    }

    public MediaCodecDecoder(IMediaExtractor extractor, ISquareRender render) {
        Intrinsics.checkNotNullParameter(extractor, "extractor");
        Intrinsics.checkNotNullParameter(render, "render");
        this.extractor = extractor;
        this.render = render;
        this.codecState = MediaCodecState.Released;
        this.bufferInfo = new MediaCodec.BufferInfo();
        this.loop = 1;
    }

    private final void changeCodecState(MediaCodecState state) {
        SquareBaseKt.getSquareLog().i(TAG, getLogPrefix() + " changeCodecState: from " + this.codecState + " to " + state);
        this.codecState = state;
    }

    private final MediaCodec createDecoder(String mime) {
        try {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mime);
            Intrinsics.checkNotNullExpressionValue(createDecoderByType, "MediaCodec.createDecoderByType(mime)");
            DecoderCounter.INSTANCE.onDecoderCreate(createDecoderByType);
            return createDecoderByType;
        } catch (Throwable th5) {
            ISquareDecoder.Listener listener = getListener();
            if (listener != null) {
                listener.onDecodeError(2, getLogPrefix() + TokenParser.SP + th5.getMessage(), true);
            }
            SquareBaseKt.getSquareLog().e(TAG, getLogPrefix() + " MediaCodec.createDecoderByType failed: " + th5.getMessage(), th5);
            return null;
        }
    }

    private final Unit resetDecoder() {
        MediaCodec mediaCodec = this.decoder;
        if (mediaCodec == null) {
            return null;
        }
        try {
            mediaCodec.reset();
        } catch (Throwable th5) {
            ISquareDecoder.Listener listener = getListener();
            if (listener != null) {
                listener.onDecodeError(4, String.valueOf(th5.getMessage()), true);
            }
            SquareBaseKt.getSquareLog().e(TAG, getLogPrefix() + " reset decoder failed, current=" + this.codecState, th5);
        }
        changeCodecState(MediaCodecState.Uninitialized);
        return Unit.INSTANCE;
    }

    @Override // com.tencent.state.square.media.IMediaDecoder
    public void error(int code, Throwable e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        changeCodecState(MediaCodecState.Error);
        ISquareDecoder.Listener listener = getListener();
        if (listener != null) {
            ISquareDecoder.Listener.DefaultImpls.onDecodeError$default(listener, code, String.valueOf(e16.getMessage()), false, 4, null);
        }
        SquareBaseKt.getSquareLog().e(TAG, getLogPrefix() + " error: " + code + ", t:", e16);
    }

    @Override // com.tencent.state.square.media.decoder.BaseMediaDecoder, com.tencent.state.square.media.IMediaDecoder
    public boolean initialize(VideoInfo info, IMediaDecoder.Controller controller) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(controller, "controller");
        super.initialize(info, controller);
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.codecState.ordinal()];
        if (i3 == 1) {
            this.decoder = createDecoder(info.getMime());
        } else if (i3 == 2) {
            MediaCodec mediaCodec = this.decoder;
            if (mediaCodec == null) {
                mediaCodec = createDecoder(info.getMime());
            }
            this.decoder = mediaCodec;
        } else if (i3 == 3 || i3 == 4 || i3 == 5) {
            resetDecoder();
        }
        this.loop = getLoopCount();
        this.controller = controller;
        return this.decoder != null;
    }

    @Override // com.tencent.state.square.media.IMediaDecoder
    public void release() {
        MediaCodec mediaCodec = this.decoder;
        if (mediaCodec != null) {
            mediaCodec.release();
            changeCodecState(MediaCodecState.Released);
            ISquareDecoder.Listener listener = getListener();
            if (listener != null) {
                listener.onDecodeReleased();
            }
            DecoderCounter.INSTANCE.onDecoderRelease(mediaCodec);
            this.decoder = null;
        }
    }

    @Override // com.tencent.state.square.media.IMediaDecoder
    public void reset() {
        resetDecoder();
    }

    @Override // com.tencent.state.square.media.IMediaDecoder
    public void start(VideoInfo info, Surface surface) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (surface != null && !surface.isValid()) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "invalid surface", null, 4, null);
            return;
        }
        MediaCodec mediaCodec = this.decoder;
        if (mediaCodec != null) {
            Object format = info.getFormat();
            if (format != null) {
                mediaCodec.configure((MediaFormat) format, surface, (MediaCrypto) null, 0);
                changeCodecState(MediaCodecState.Configured);
                mediaCodec.start();
                changeCodecState(MediaCodecState.Executing);
                ISquareDecoder.Listener listener = getListener();
                if (listener != null) {
                    listener.onDecodeStart();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.media.MediaFormat");
        }
    }

    @Override // com.tencent.state.square.media.IMediaDecoder
    public void stop(StopFrom from) {
        Intrinsics.checkNotNullParameter(from, "from");
        MediaCodec mediaCodec = this.decoder;
        if (mediaCodec != null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, getLogPrefix() + " stopDecoder from:" + from, null, 4, null);
            if (this.codecState != MediaCodecState.Executing) {
                SquareBaseKt.getSquareLog().w(TAG, getLogPrefix() + " stop decoder but current is not executing, is " + this.codecState);
                return;
            }
            try {
                mediaCodec.stop();
                mediaCodec.reset();
            } catch (Throwable unused) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, getLogPrefix() + " stop decoder failed, current=" + this.codecState + ", from=" + from, null, 4, null);
            }
            changeCodecState(MediaCodecState.Uninitialized);
            ISquareDecoder.Listener listener = getListener();
            if (listener != null) {
                listener.onDecodeStop(from);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01b6  */
    @Override // com.tencent.state.square.media.IMediaDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(boolean isRenderDirectly) {
        long j3;
        long j16;
        ISquareDecoder.Listener listener;
        MediaCodec mediaCodec = this.decoder;
        if (mediaCodec == null) {
            return;
        }
        boolean z16 = true;
        int i3 = 0;
        boolean z17 = true;
        boolean z18 = true;
        boolean z19 = false;
        while (true) {
            IMediaDecoder.Controller controller = this.controller;
            if (controller == null || controller.isExecuting() != z16) {
                return;
            }
            long j17 = 1000;
            long nanoTime = System.nanoTime() / j17;
            IMediaDecoder.Controller controller2 = this.controller;
            if (controller2 != null) {
                controller2.checkPauseState();
            }
            long nanoTime2 = (System.nanoTime() / j17) - nanoTime;
            if (z19) {
                j3 = 10000;
                j16 = nanoTime2;
            } else {
                int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer inputBuffer = mediaCodec.getInputBuffer(dequeueInputBuffer);
                    if (inputBuffer == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(inputBuffer, "codec.getInputBuffer(inputBufferId) ?: break");
                    int readSampleData = this.extractor.readSampleData(inputBuffer, i3);
                    if (readSampleData > 0) {
                        j3 = 10000;
                        j16 = nanoTime2;
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.extractor.getSampleTime(), 0);
                        this.extractor.advance();
                    } else {
                        j3 = 10000;
                        j16 = nanoTime2;
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        z19 = true;
                    }
                } else {
                    j3 = 10000;
                    j16 = nanoTime2;
                    SquareBaseKt.getSquareLog().d(TAG, getLogPrefix() + " input buffer is not available: " + dequeueInputBuffer);
                }
            }
            int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.bufferInfo, j3);
            if (dequeueOutputBuffer == -1) {
                if (SquareBase.INSTANCE.getConfig().isDebug()) {
                    SquareBaseKt.getSquareLog().d(TAG, getLogPrefix() + " no output from decoder available");
                }
            } else if (dequeueOutputBuffer == -3) {
                SquareBaseKt.getSquareLog().d(TAG, getLogPrefix() + " decoder output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                SquareBaseKt.getSquareLog().d(TAG, getLogPrefix() + " decoder output format changed: " + mediaCodec.getOutputFormat());
                ISquareRender iSquareRender = this.render;
                VideoInfo videoInfo = new VideoInfo();
                MediaFormat outputFormat = mediaCodec.getOutputFormat();
                Intrinsics.checkNotNullExpressionValue(outputFormat, "codec.outputFormat");
                ISquarePlayerKt.fill(videoInfo, outputFormat);
                Unit unit = Unit.INSTANCE;
                iSquareRender.onOutFormatChanged(videoInfo);
            } else if (dequeueOutputBuffer >= 0) {
                boolean z26 = (this.bufferInfo.flags & 4) != 0;
                if (!z26) {
                    getSpeeder().preRender(j16, this.bufferInfo.presentationTimeUs);
                }
                if (z17) {
                    ISquareDecoder.Listener listener2 = getListener();
                    if (listener2 != null) {
                        listener2.onDecodeFirstFrame();
                    }
                    z17 = false;
                }
                this.render.onFrameRender(this.bufferInfo, z18);
                if (z18) {
                    ISquareDecoder.Listener listener3 = getListener();
                    if (listener3 != null) {
                        listener3.onDecodeLoopStart();
                    }
                    z18 = false;
                }
                if (!isRenderDirectly) {
                    this.render.onFrameRender(this.bufferInfo, mediaCodec.getOutputImage(dequeueOutputBuffer));
                }
                mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, isRenderDirectly);
                if (z26) {
                    int i16 = this.loop;
                    if (i16 != -1) {
                        this.loop = i16 - 1;
                        if (i16 <= 0 && !getIsLoopDecode()) {
                            IMediaDecoder.Controller controller3 = this.controller;
                            if (controller3 != null) {
                                controller3.stopWhenComplete();
                            }
                            listener = getListener();
                            if (listener != null) {
                                listener.onDecodeLoop();
                            }
                            z18 = true;
                        }
                    }
                    this.extractor.seekTo(0L);
                    mediaCodec.flush();
                    getSpeeder().reset();
                    z19 = false;
                    listener = getListener();
                    if (listener != null) {
                    }
                    z18 = true;
                }
            } else {
                throw new RuntimeException(getLogPrefix() + " unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            }
            z16 = true;
            i3 = 0;
        }
    }
}
