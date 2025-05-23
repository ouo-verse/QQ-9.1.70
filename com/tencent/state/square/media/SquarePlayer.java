package com.tencent.state.square.media;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.MediaCodec;
import android.view.Surface;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.media.ISquareDecoder;
import com.tencent.state.square.media.ISquarePlayer;
import com.tencent.state.square.media.ISquareRender;
import com.tencent.state.square.media.decoder.SquareEpochDecoder;
import com.tencent.state.square.media.render.SquareAbsRender;
import com.tencent.state.square.media.render.SquareRender;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002XYB\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0019H\u0002J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0001J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010!\u001a\u00020\"H\u0016J\t\u0010#\u001a\u00020\"H\u0096\u0001J-\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00140)H\u0096\u0001J \u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\"H\u0016J\b\u0010.\u001a\u00020\u0014H\u0016J\b\u0010/\u001a\u00020\u0014H\u0016J\b\u00100\u001a\u00020\u0014H\u0016J\b\u00101\u001a\u00020\u0014H\u0016J\b\u00102\u001a\u00020\u0014H\u0016J\u0010\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u000205H\u0016J\u001b\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0096\u0001J)\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<H\u0096\u0001J\u0019\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u0010?\u001a\u00020\"H\u0096\u0001J\u0011\u00106\u001a\u00020\u00142\u0006\u0010@\u001a\u00020<H\u0096\u0001J\u0011\u0010A\u001a\u00020\u00142\u0006\u00107\u001a\u00020BH\u0096\u0001J\u0018\u0010C\u001a\u00020\u00142\u0006\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0011H\u0016J\b\u0010D\u001a\u00020\u0014H\u0016J \u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020&H\u0016J\u0012\u0010J\u001a\u00020\u00142\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0019\u0010K\u001a\u00020\u00142\u0006\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020&H\u0096\u0001J\b\u0010L\u001a\u00020\u0014H\u0016J\b\u0010M\u001a\u00020\u0014H\u0016J\b\u0010N\u001a\u00020\u0014H\u0016J\b\u0010O\u001a\u00020\u0014H\u0016J\u0010\u0010P\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020\"H\u0016J\u0010\u0010S\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0011\u0010T\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0004H\u0096\u0001J\b\u0010U\u001a\u00020\u0014H\u0016J\u0010\u0010U\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u001bH\u0016J\b\u0010W\u001a\u00020\u0014H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006Z"}, d2 = {"Lcom/tencent/state/square/media/SquarePlayer;", "Lcom/tencent/state/square/media/ISquarePlayer;", "Lcom/tencent/state/square/media/ISquareRender;", "Lcom/tencent/state/square/media/ISquareDecoder$Listener;", "Lcom/tencent/state/square/media/ISquareRender$Listener;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "Lcom/tencent/state/square/media/render/SquareAbsRender;", "decoder", "Lcom/tencent/state/square/media/decoder/SquareEpochDecoder;", "(Lcom/tencent/state/square/media/render/SquareAbsRender;Lcom/tencent/state/square/media/decoder/SquareEpochDecoder;)V", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/media/PlayConfig;", "getDecoder", "()Lcom/tencent/state/square/media/decoder/SquareEpochDecoder;", "listener", "Lcom/tencent/state/square/media/ISquarePlayer$Listener;", "logPrefix", "", "pendingTask", "Lkotlin/Function0;", "", "playerReporter", "Lcom/tencent/state/square/media/SquarePlayer$PlayerReporter;", "state", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/state/square/media/PlayerState;", "videoSource", "Lcom/tencent/state/square/media/MediaSource;", "changePlayState", "getOutputSurface", "Landroid/view/Surface;", "getState", "getVideoSource", "isDestroying", "", "isSurfaceReady", "onBeforeDecode", "videoWidth", "", "videoHeight", "callback", "Lkotlin/Function1;", "onDecodeError", "code", "message", "onlyReport", "onDecodeFirstFrame", "onDecodeLoop", "onDecodeLoopStart", "onDecodeReleased", "onDecodeStart", "onDecodeStop", "from", "Lcom/tencent/state/square/media/StopFrom;", "onFrameRender", "info", "Landroid/media/MediaCodec$BufferInfo;", "image", "Landroid/media/Image;", "yBuffer", "Ljava/nio/ByteBuffer;", "uvBuffer", "alphaBuffer", "isStart", "rgba", "onOutFormatChanged", "Lcom/tencent/state/square/media/VideoInfo;", "onRenderError", "onRenderFirstFrame", "onSurfaceAvailable", "surface", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceDestroyed", "onSurfaceSizeChanged", "pause", "release", "reset", "resume", "setListener", "setLoopPlay", "isLoopPlay", "setPlayConfig", "setRenderListener", "start", "source", "stop", "Companion", "PlayerReporter", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquarePlayer implements ISquarePlayer, ISquareRender, ISquareDecoder.Listener, ISquareRender.Listener {
    private static final String TAG = "SquarePlayer";
    private PlayConfig config;
    private final SquareEpochDecoder decoder;
    private ISquarePlayer.Listener listener;
    private String logPrefix;
    private Function0<Unit> pendingTask;
    private final PlayerReporter playerReporter;
    private final SquareAbsRender render;
    private AtomicReference<PlayerState> state;
    private MediaSource videoSource;

    public SquarePlayer() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final void changePlayState(PlayerState state) {
        this.state.set(state);
        if (state == PlayerState.Starting) {
            this.playerReporter.onStart(this.videoSource);
        }
    }

    public final SquareEpochDecoder getDecoder() {
        return this.decoder;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public Surface getOutputSurface() {
        return this.render.getOutputSurface();
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public PlayerState getState() {
        PlayerState playerState = this.state.get();
        Intrinsics.checkNotNullExpressionValue(playerState, "state.get()");
        return playerState;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public MediaSource getVideoSource() {
        return this.videoSource;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer, com.tencent.state.square.media.ISquareRender
    public boolean isDestroying() {
        return this.decoder.isInvalid() || this.render.isDestroying();
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public boolean isSurfaceReady() {
        return this.render.isSurfaceReady();
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onBeforeDecode(int videoWidth, int videoHeight, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.render.onBeforeDecode(videoWidth, videoHeight, callback);
    }

    @Override // com.tencent.state.square.media.ISquareDecoder.Listener
    public void onDecodeError(final int code, final String message, boolean onlyReport) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!onlyReport) {
            changePlayState(PlayerState.Stopped);
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.media.SquarePlayer$onDecodeError$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ISquarePlayer.Listener listener;
                    listener = SquarePlayer.this.listener;
                    if (listener != null) {
                        listener.onVideoError(code, message);
                    }
                }
            });
        }
        this.playerReporter.onDecodeError(code, message);
    }

    @Override // com.tencent.state.square.media.ISquareDecoder.Listener
    public void onDecodeFirstFrame() {
        this.playerReporter.onDecodeFirstFrame();
    }

    @Override // com.tencent.state.square.media.ISquareDecoder.Listener
    public void onDecodeLoop() {
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.media.SquarePlayer$onDecodeLoop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ISquarePlayer.Listener listener;
                listener = SquarePlayer.this.listener;
                if (listener != null) {
                    listener.onVideoLoop();
                }
            }
        });
    }

    @Override // com.tencent.state.square.media.ISquareDecoder.Listener
    public void onDecodeLoopStart() {
        changePlayState(PlayerState.Executing);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.media.SquarePlayer$onDecodeLoopStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ISquarePlayer.Listener listener;
                listener = SquarePlayer.this.listener;
                if (listener != null) {
                    listener.onVideoLoopStart();
                }
            }
        });
    }

    @Override // com.tencent.state.square.media.ISquareDecoder.Listener
    public void onDecodeReleased() {
        changePlayState(PlayerState.Destroyed);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.media.SquarePlayer$onDecodeReleased$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ISquarePlayer.Listener listener;
                listener = SquarePlayer.this.listener;
                if (listener != null) {
                    listener.onVideoDestroy();
                }
            }
        });
    }

    @Override // com.tencent.state.square.media.ISquareDecoder.Listener
    public void onDecodeStart() {
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.media.SquarePlayer$onDecodeStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ISquarePlayer.Listener listener;
                listener = SquarePlayer.this.listener;
                if (listener != null) {
                    listener.onVideoStart();
                }
            }
        });
    }

    @Override // com.tencent.state.square.media.ISquareDecoder.Listener
    public void onDecodeStop(final StopFrom from) {
        Intrinsics.checkNotNullParameter(from, "from");
        changePlayState(PlayerState.Stopped);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.media.SquarePlayer$onDecodeStop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ISquarePlayer.Listener listener;
                listener = SquarePlayer.this.listener;
                if (listener != null) {
                    listener.onVideoStop(from);
                }
            }
        });
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onFrameRender(MediaCodec.BufferInfo info, Image image) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.render.onFrameRender(info, image);
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onOutFormatChanged(VideoInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.render.onOutFormatChanged(info);
    }

    @Override // com.tencent.state.square.media.ISquareRender.Listener
    public void onRenderError(int code, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.playerReporter.onRenderError(code, message);
    }

    @Override // com.tencent.state.square.media.ISquareRender.Listener
    public void onRenderFirstFrame() {
        this.playerReporter.onRenderFirstFrame();
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.media.SquarePlayer$onRenderFirstFrame$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ISquarePlayer.Listener listener;
                listener = SquarePlayer.this.listener;
                if (listener != null) {
                    listener.onVideoFirstFrame();
                }
            }
        });
        this.playerReporter.doReport();
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onSurfaceAvailable(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.render.onSurfaceAvailable(surface, width, height);
        Function0<Unit> function0 = this.pendingTask;
        if (function0 != null) {
            function0.invoke();
        }
        this.pendingTask = null;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onSurfaceDestroyed(SurfaceTexture surface) {
        this.render.onSurfaceDestroyed(surface);
        if (SquareBase.INSTANCE.getConfig().getRecorder().canCodecReUse()) {
            this.decoder.reset();
        } else {
            this.decoder.release();
        }
        this.listener = null;
        this.videoSource = null;
        this.pendingTask = null;
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onSurfaceSizeChanged(int width, int height) {
        this.render.onSurfaceSizeChanged(width, height);
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void pause() {
        this.decoder.pause();
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void release() {
        this.decoder.release();
        this.listener = null;
        this.videoSource = null;
        this.pendingTask = null;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void reset() {
        if (SquareBase.INSTANCE.getConfig().getRecorder().canCodecReUse()) {
            this.decoder.reset();
        } else {
            this.decoder.release();
        }
        this.listener = null;
        this.videoSource = null;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void resume() {
        this.decoder.resume();
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void setListener(ISquarePlayer.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void setLoopPlay(boolean isLoopPlay) {
        this.decoder.setLoopDecode(isLoopPlay);
        PlayConfig playConfig = this.config;
        if (playConfig != null) {
            playConfig.setLoop(isLoopPlay);
        }
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void setPlayConfig(PlayConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.decoder.setLoopCount(config.getLoopCount());
        this.decoder.setUniqueId(config.getUniqueId());
        this.render.setUniqueId(config.getUniqueId());
        this.logPrefix = '(' + config.getUniqueId() + ")(" + this.decoder.hashCode() + ')';
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void setRenderListener(ISquareRender.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.render.setRenderListener(listener);
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void start(final MediaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        changePlayState(PlayerState.Starting);
        this.videoSource = source;
        this.decoder.setListener(this);
        this.render.setRenderListener(this);
        if (isSurfaceReady()) {
            this.decoder.start(source);
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, this.logPrefix + ", setPendingTask: " + source);
        this.pendingTask = new Function0<Unit>() { // from class: com.tencent.state.square.media.SquarePlayer$start$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SquarePlayer.this.getDecoder().start(source);
            }
        };
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void stop() {
        this.decoder.stop();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\b\u0010\u0017\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/media/SquarePlayer$PlayerReporter;", "", "()V", "decodeFirstFrameTime", "", "errorCode", "", "needReportSuccess", "", "renderErrorCode", "renderFirstFrameTime", "startTime", "videoSource", "Lcom/tencent/state/square/media/MediaSource;", "doReport", "", "onDecodeError", "message", "", "onDecodeFirstFrame", "onRenderError", "onRenderFirstFrame", "onStart", "reset", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class PlayerReporter {
        private static final String TAG = "SquarePlayer-PlayerReporter";
        private static final int TIME = 1000000;
        private long decodeFirstFrameTime;
        private int errorCode;
        private boolean needReportSuccess = SquareBase.INSTANCE.getConfig().getCommonUtils().getNeedReportPlaySuccess();
        private int renderErrorCode;
        private long renderFirstFrameTime;
        private long startTime;
        private MediaSource videoSource;

        public final void doReport() {
            Map<String, Object> mutableMapOf;
            long j3 = this.startTime;
            boolean z16 = j3 == 0 || this.renderFirstFrameTime == 0 || this.decodeFirstFrameTime == 0;
            int i3 = this.errorCode;
            boolean z17 = i3 != 0 || (i3 == 0 && this.needReportSuccess);
            if (!z16 && z17) {
                long j16 = this.decodeFirstFrameTime - j3;
                long j17 = this.renderFirstFrameTime - j3;
                Pair[] pairArr = new Pair[5];
                pairArr[0] = TuplesKt.to("error_code", String.valueOf(i3));
                pairArr[1] = TuplesKt.to(SquarePlayerReportConst.PARAM_DECODE_FIRST_FRAME_COST_TIME, String.valueOf(j16));
                pairArr[2] = TuplesKt.to(SquarePlayerReportConst.PARAM_RENDER_FIRST_FRAME_COST_TIME, String.valueOf(j17));
                pairArr[3] = TuplesKt.to(SquarePlayerReportConst.PARAM_SUB_ERROR_CODE, String.valueOf(this.renderErrorCode));
                MediaSource mediaSource = this.videoSource;
                pairArr[4] = TuplesKt.to("url", String.valueOf(mediaSource != null ? mediaSource.getRemoteUrl() : null));
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                SquareBase.INSTANCE.getConfig().getReporter().reportEvent(SquarePlayerReportConst.EVENT_SQUARE_PLAY_MP4, mutableMapOf);
                reset();
                return;
            }
            reset();
        }

        public final void onDecodeError(int errorCode, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.errorCode = errorCode;
            SquareBaseKt.getSquareLog().w(TAG, "onDecodeError errorCode:" + errorCode + ", message:" + message);
        }

        public final void onDecodeFirstFrame() {
            this.decodeFirstFrameTime = System.nanoTime() / 1000000;
        }

        public final void onRenderError(int errorCode, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.renderErrorCode = errorCode;
            SquareBaseKt.getSquareLog().w(TAG, "onRenderError errorCode:" + errorCode + ", message:" + message);
        }

        public final void onRenderFirstFrame() {
            this.renderFirstFrameTime = System.nanoTime() / 1000000;
        }

        public final void onStart(MediaSource videoSource) {
            reset();
            this.startTime = System.nanoTime() / 1000000;
            this.videoSource = videoSource;
        }

        private final void reset() {
            this.startTime = 0L;
            this.renderFirstFrameTime = 0L;
            this.decodeFirstFrameTime = 0L;
            this.videoSource = null;
            this.errorCode = 0;
        }
    }

    public SquarePlayer(SquareAbsRender render, SquareEpochDecoder decoder) {
        Intrinsics.checkNotNullParameter(render, "render");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        this.render = render;
        this.decoder = decoder;
        this.logPrefix = "";
        this.state = new AtomicReference<>(PlayerState.Idle);
        this.playerReporter = new PlayerReporter();
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onFrameRender(MediaCodec.BufferInfo info, ByteBuffer yBuffer, ByteBuffer uvBuffer, ByteBuffer alphaBuffer) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(yBuffer, "yBuffer");
        Intrinsics.checkNotNullParameter(uvBuffer, "uvBuffer");
        Intrinsics.checkNotNullParameter(alphaBuffer, "alphaBuffer");
        this.render.onFrameRender(info, yBuffer, uvBuffer, alphaBuffer);
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onFrameRender(MediaCodec.BufferInfo info, boolean isStart) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.render.onFrameRender(info, isStart);
    }

    @Override // com.tencent.state.square.media.ISquareRender
    public void onFrameRender(ByteBuffer rgba) {
        Intrinsics.checkNotNullParameter(rgba, "rgba");
        this.render.onFrameRender(rgba);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SquarePlayer(SquareAbsRender squareAbsRender, SquareEpochDecoder squareEpochDecoder, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(squareAbsRender, (i3 & 2) != 0 ? new SquareEpochDecoder(squareAbsRender, null, null, 6, null) : squareEpochDecoder);
        squareAbsRender = (i3 & 1) != 0 ? new SquareRender() : squareAbsRender;
    }

    @Override // com.tencent.state.square.media.ISquarePlayer
    public void start() {
        if (this.pendingTask != null) {
            return;
        }
        changePlayState(PlayerState.Starting);
        MediaSource mediaSource = this.videoSource;
        if (mediaSource != null) {
            this.decoder.start(mediaSource);
        }
    }
}
