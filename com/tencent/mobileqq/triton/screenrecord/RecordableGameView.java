package com.tencent.mobileqq.triton.screenrecord;

import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.ScreenRecordCallback;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.view.GameView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u00012\u00020\u0002:\u000212B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\"\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u001bH\u0016J-\u0010&\u001a\u00020\u001b2#\u0010'\u001a\u001f\u0012\u0013\u0012\u00110)\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0010\u0018\u00010(H\u0016J\u0012\u0010-\u001a\u00020\u001b2\b\u0010\u0011\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u001bH\u0016J\b\u00100\u001a\u00020\u001bH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/triton/screenrecord/RecordableGameView;", "Lcom/tencent/mobileqq/triton/view/GameView;", "Lcom/tencent/mobileqq/triton/screenrecord/Recordable;", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "gameView", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;Lcom/tencent/mobileqq/triton/view/GameView;)V", "displayDensity", "", "getDisplayDensity", "()F", "height", "", "getHeight", "()I", "paused", "", "surfaceCallback", "Lcom/tencent/mobileqq/triton/screenrecord/RecordableGameView$SurfaceCallbackProxy;", "width", "getWidth", "computeDimension", "", "originalWidth", "originalHeight", "isRecordReady", "onInputSurfaceReady", "", "surface", "Landroid/view/Surface;", "onSwapBuffer", "prepareRecording", "recordAudio", "outputPath", "Ljava/io/File;", "callback", "Lcom/tencent/mobileqq/triton/engine/ScreenRecordCallback;", "releaseRecording", "setGameOnTouchListener", "listener", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "event", "setSurfaceCallback", "Lcom/tencent/mobileqq/triton/view/GameView$SurfaceCallback;", "startRecording", "stopRecording", "Companion", "SurfaceCallbackProxy", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class RecordableGameView implements GameView, Recordable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "RecordableGameView";
    private static final int VIDEO_HEIGHT = 1280;
    private static final int VIDEO_WIDTH = 720;
    private final EngineContext engineContext;
    private final GameView gameView;
    private boolean paused;
    private SurfaceCallbackProxy surfaceCallback;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/triton/screenrecord/RecordableGameView$Companion;", "", "()V", "TAG", "", "VIDEO_HEIGHT", "", "VIDEO_WIDTH", "wrap", "Lcom/tencent/mobileqq/triton/view/GameView;", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "gameView", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final GameView wrap(@NotNull EngineContext engineContext, @NotNull GameView gameView) {
            Intrinsics.checkParameterIsNotNull(engineContext, "engineContext");
            Intrinsics.checkParameterIsNotNull(gameView, "gameView");
            return new RecordableGameView(engineContext, gameView);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016J(\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\"\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/triton/screenrecord/RecordableGameView$SurfaceCallbackProxy;", "Lcom/tencent/mobileqq/triton/view/GameView$SurfaceCallback;", "Lcom/tencent/mobileqq/triton/screenrecord/Recordable;", "surfaceCallback", "(Lcom/tencent/mobileqq/triton/screenrecord/RecordableGameView;Lcom/tencent/mobileqq/triton/view/GameView$SurfaceCallback;)V", "glRender", "Lcom/tencent/mobileqq/triton/screenrecord/RecordableGLRender;", "getGlRender", "()Lcom/tencent/mobileqq/triton/screenrecord/RecordableGLRender;", "setGlRender", "(Lcom/tencent/mobileqq/triton/screenrecord/RecordableGLRender;)V", "originalSurface", "Landroid/view/Surface;", "surfaceFormat", "", "getSurfaceFormat", "()I", "setSurfaceFormat", "(I)V", "isRecordReady", "", "onInputSurfaceReady", "", "surface", "onSurfaceChanged", "format", "width", "height", "onSurfaceCreated", "onSurfaceDestroyed", "prepareRecording", "recordAudio", "outputPath", "Ljava/io/File;", "callback", "Lcom/tencent/mobileqq/triton/engine/ScreenRecordCallback;", "releaseRecording", "startRecording", "stopRecording", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public final class SurfaceCallbackProxy implements GameView.SurfaceCallback, Recordable {

        @Nullable
        private RecordableGLRender glRender;
        private Surface originalSurface;
        private final GameView.SurfaceCallback surfaceCallback;
        private int surfaceFormat;
        final /* synthetic */ RecordableGameView this$0;

        public SurfaceCallbackProxy(@NotNull RecordableGameView recordableGameView, GameView.SurfaceCallback surfaceCallback) {
            Intrinsics.checkParameterIsNotNull(surfaceCallback, "surfaceCallback");
            this.this$0 = recordableGameView;
            this.surfaceCallback = surfaceCallback;
        }

        @Nullable
        public final RecordableGLRender getGlRender() {
            return this.glRender;
        }

        public final int getSurfaceFormat() {
            return this.surfaceFormat;
        }

        @Override // com.tencent.mobileqq.triton.screenrecord.Recordable
        public boolean isRecordReady() {
            RecordableGLRender recordableGLRender = this.glRender;
            if (recordableGLRender != null && recordableGLRender.isReady()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.triton.screenrecord.Recordable
        public void onInputSurfaceReady(@NotNull Surface surface) {
            Intrinsics.checkParameterIsNotNull(surface, "surface");
            if (this.originalSurface == null) {
                Logger.i$default(RecordableGameView.TAG, "startRecording, originalSurface=null", null, 4, null);
                return;
            }
            if (this.this$0.paused) {
                Logger.w$default(RecordableGameView.TAG, "startRecording, paused=true, unnormal state!", null, 4, null);
            }
            this.surfaceCallback.onSurfaceDestroyed();
            this.surfaceCallback.onSurfaceCreated(surface);
            this.surfaceCallback.onSurfaceChanged(surface, this.surfaceFormat, this.this$0.get_width(), this.this$0.get_height());
            RecordableGLRender recordableGLRender = this.glRender;
            if (recordableGLRender != null) {
                recordableGLRender.onRenderSurfaceChanged();
            }
        }

        @Override // com.tencent.mobileqq.triton.view.GameView.SurfaceCallback
        public void onSurfaceChanged(@NotNull Surface surface, int format, int width, int height) {
            Surface inputSurface;
            Intrinsics.checkParameterIsNotNull(surface, "surface");
            this.surfaceFormat = format;
            GameView.SurfaceCallback surfaceCallback = this.surfaceCallback;
            RecordableGLRender recordableGLRender = this.glRender;
            if (recordableGLRender != null && (inputSurface = recordableGLRender.getInputSurface()) != null) {
                surface = inputSurface;
            }
            surfaceCallback.onSurfaceChanged(surface, format, width, height);
            RecordableGLRender recordableGLRender2 = this.glRender;
            if (recordableGLRender2 != null) {
                recordableGLRender2.onRenderSurfaceChanged();
            }
        }

        @Override // com.tencent.mobileqq.triton.view.GameView.SurfaceCallback
        public void onSurfaceCreated(@NotNull Surface surface) {
            Surface inputSurface;
            Intrinsics.checkParameterIsNotNull(surface, "surface");
            Logger.d$default(RecordableGameView.TAG, "onSurfaceCreated, surface=" + surface, null, 4, null);
            this.originalSurface = surface;
            if (this.glRender != null) {
                if (this.this$0.paused) {
                    Logger.w$default(RecordableGameView.TAG, "onSurfaceCreated, paused=true, unnormal state!", null, 4, null);
                }
                GameView.SurfaceCallback surfaceCallback = this.surfaceCallback;
                RecordableGLRender recordableGLRender = this.glRender;
                if (recordableGLRender != null && (inputSurface = recordableGLRender.getInputSurface()) != null) {
                    surface = inputSurface;
                }
                surfaceCallback.onSurfaceCreated(surface);
                RecordableGLRender recordableGLRender2 = this.glRender;
                if (recordableGLRender2 != null) {
                    recordableGLRender2.onRenderSurfaceChanged();
                    return;
                }
                return;
            }
            this.surfaceCallback.onSurfaceCreated(surface);
        }

        @Override // com.tencent.mobileqq.triton.view.GameView.SurfaceCallback
        public void onSurfaceDestroyed() {
            this.originalSurface = null;
            if (this.glRender != null) {
                if (this.this$0.paused) {
                    Logger.w$default(RecordableGameView.TAG, "onSurfaceDestroyed, paused=true, unnormal state!", null, 4, null);
                }
                this.surfaceCallback.onSurfaceDestroyed();
                RecordableGLRender recordableGLRender = this.glRender;
                if (recordableGLRender != null) {
                    recordableGLRender.stopRendering();
                    return;
                }
                return;
            }
            this.surfaceCallback.onSurfaceDestroyed();
        }

        @Override // com.tencent.mobileqq.triton.screenrecord.Recordable
        public void prepareRecording(boolean recordAudio, @NotNull File outputPath, @Nullable ScreenRecordCallback callback) {
            Intrinsics.checkParameterIsNotNull(outputPath, "outputPath");
            if (this.originalSurface == null) {
                Logger.i$default(RecordableGameView.TAG, "prepareRecording, originalSurface=null", null, 4, null);
                return;
            }
            if (this.this$0.paused) {
                Logger.w$default(RecordableGameView.TAG, "prepareRecording, paused=true, unnormal state!", null, 4, null);
            }
            if (this.glRender == null) {
                this.glRender = new RecordableGLRender(callback, this.this$0.engineContext.getTtEngine().getRenderContext());
                RecordableGameView recordableGameView = this.this$0;
                int[] computeDimension = recordableGameView.computeDimension(recordableGameView.get_width(), this.this$0.get_height());
                RecordableGLRender recordableGLRender = this.glRender;
                if (recordableGLRender == null) {
                    Intrinsics.throwNpe();
                }
                recordableGLRender.prepare(recordAudio, computeDimension[0], computeDimension[1], outputPath);
            }
        }

        @Override // com.tencent.mobileqq.triton.screenrecord.Recordable
        public void releaseRecording() {
            if (this.glRender != null) {
                Surface surface = this.originalSurface;
                if (surface != null) {
                    GameView.SurfaceCallback surfaceCallback = this.surfaceCallback;
                    if (surface == null) {
                        Intrinsics.throwNpe();
                    }
                    surfaceCallback.onSurfaceCreated(surface);
                    GameView.SurfaceCallback surfaceCallback2 = this.surfaceCallback;
                    Surface surface2 = this.originalSurface;
                    if (surface2 == null) {
                        Intrinsics.throwNpe();
                    }
                    surfaceCallback2.onSurfaceChanged(surface2, this.surfaceFormat, this.this$0.get_width(), this.this$0.get_height());
                }
                this.glRender = null;
            }
        }

        public final void setGlRender(@Nullable RecordableGLRender recordableGLRender) {
            this.glRender = recordableGLRender;
        }

        public final void setSurfaceFormat(int i3) {
            this.surfaceFormat = i3;
        }

        @Override // com.tencent.mobileqq.triton.screenrecord.Recordable
        public void startRecording() {
            Surface surface = null;
            if (this.originalSurface == null) {
                Logger.i$default(RecordableGameView.TAG, "startRecording, originalSurface=null", null, 4, null);
                return;
            }
            if (this.this$0.paused) {
                Logger.w$default(RecordableGameView.TAG, "startRecording, paused=true, unnormal state!", null, 4, null);
            }
            RecordableGLRender recordableGLRender = this.glRender;
            if (recordableGLRender != null) {
                surface = recordableGLRender.getInputSurface();
            }
            if (surface != null) {
                RecordableGLRender recordableGLRender2 = this.glRender;
                if (recordableGLRender2 != null) {
                    Surface surface2 = this.originalSurface;
                    if (surface2 == null) {
                        Intrinsics.throwNpe();
                    }
                    recordableGLRender2.startRendering(surface2);
                    return;
                }
                return;
            }
            RecordableGLRender recordableGLRender3 = this.glRender;
            if (recordableGLRender3 != null) {
                recordableGLRender3.release(false);
            }
        }

        @Override // com.tencent.mobileqq.triton.screenrecord.Recordable
        public void stopRecording() {
            if (this.glRender != null) {
                if (this.originalSurface != null) {
                    this.surfaceCallback.onSurfaceDestroyed();
                }
                RecordableGLRender recordableGLRender = this.glRender;
                if (recordableGLRender != null) {
                    recordableGLRender.release(true);
                }
            }
        }
    }

    public RecordableGameView(@NotNull EngineContext engineContext, @NotNull GameView gameView) {
        Intrinsics.checkParameterIsNotNull(engineContext, "engineContext");
        Intrinsics.checkParameterIsNotNull(gameView, "gameView");
        this.engineContext = engineContext;
        this.gameView = gameView;
        engineContext.getLifeCycleOwner().observeLifeCycle(new LifeCycle() { // from class: com.tencent.mobileqq.triton.screenrecord.RecordableGameView.1
            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onDestroy() {
                LifeCycle.DefaultImpls.onDestroy(this);
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onFirstFrame() {
                LifeCycle.DefaultImpls.onFirstFrame(this);
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onGameLaunched(@NotNull TritonEngine engine) {
                Intrinsics.checkParameterIsNotNull(engine, "engine");
                LifeCycle.DefaultImpls.onGameLaunched(this, engine);
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onStart() {
                RecordableGameView.this.paused = false;
                Logger.i$default(RecordableGameView.TAG, "onStart", null, 4, null);
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onStop() {
                RecordableGameView.this.paused = true;
                Logger.i$default(RecordableGameView.TAG, DKHippyEvent.EVENT_STOP, null, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] computeDimension(int originalWidth, int originalHeight) {
        if (originalWidth < originalHeight) {
            return new int[]{720, 1280};
        }
        return new int[]{1280, 720};
    }

    @Override // com.tencent.mobileqq.triton.view.GameView
    public float getDisplayDensity() {
        return this.gameView.getDisplayDensity();
    }

    @Override // com.tencent.mobileqq.triton.view.GameView
    /* renamed from: getHeight */
    public int get_height() {
        return this.gameView.get_height();
    }

    @Override // com.tencent.mobileqq.triton.view.GameView
    /* renamed from: getWidth */
    public int get_width() {
        return this.gameView.get_width();
    }

    @Override // com.tencent.mobileqq.triton.screenrecord.Recordable
    public boolean isRecordReady() {
        SurfaceCallbackProxy surfaceCallbackProxy = this.surfaceCallback;
        if (surfaceCallbackProxy != null) {
            return surfaceCallbackProxy.isRecordReady();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.triton.screenrecord.Recordable
    public void onInputSurfaceReady(@NotNull Surface surface) {
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        Logger.i$default(TAG, "onInputSurfaceReady, surfaceCallback=" + this.surfaceCallback + ", paused=" + this.paused + ", surface=" + surface, null, 4, null);
        SurfaceCallbackProxy surfaceCallbackProxy = this.surfaceCallback;
        if (surfaceCallbackProxy != null && !this.paused && surfaceCallbackProxy != null) {
            surfaceCallbackProxy.onInputSurfaceReady(surface);
        }
    }

    @Override // com.tencent.mobileqq.triton.view.GameView
    public void onSwapBuffer() {
        this.gameView.onSwapBuffer();
    }

    @Override // com.tencent.mobileqq.triton.screenrecord.Recordable
    public void prepareRecording(boolean recordAudio, @NotNull File outputPath, @Nullable ScreenRecordCallback callback) {
        Intrinsics.checkParameterIsNotNull(outputPath, "outputPath");
        Logger.i$default(TAG, "prepareRecording, surfaceCallback=" + this.surfaceCallback + ", paused=" + this.paused, null, 4, null);
        SurfaceCallbackProxy surfaceCallbackProxy = this.surfaceCallback;
        if (surfaceCallbackProxy != null && !this.paused && surfaceCallbackProxy != null) {
            surfaceCallbackProxy.prepareRecording(recordAudio, outputPath, callback);
        }
    }

    @Override // com.tencent.mobileqq.triton.screenrecord.Recordable
    public void releaseRecording() {
        Logger.i$default(TAG, "stopRecording, surfaceCallback=" + this.surfaceCallback + ", paused=" + this.paused, null, 4, null);
        SurfaceCallbackProxy surfaceCallbackProxy = this.surfaceCallback;
        if (surfaceCallbackProxy != null) {
            surfaceCallbackProxy.releaseRecording();
        }
    }

    @Override // com.tencent.mobileqq.triton.view.GameView
    public void setGameOnTouchListener(@Nullable Function1<? super MotionEvent, Boolean> listener) {
        this.gameView.setGameOnTouchListener(listener);
    }

    @Override // com.tencent.mobileqq.triton.view.GameView
    public void setSurfaceCallback(@Nullable GameView.SurfaceCallback surfaceCallback) {
        if (surfaceCallback == null) {
            stopRecording();
            this.surfaceCallback = null;
            this.gameView.setSurfaceCallback(null);
        } else {
            SurfaceCallbackProxy surfaceCallbackProxy = new SurfaceCallbackProxy(this, surfaceCallback);
            this.surfaceCallback = surfaceCallbackProxy;
            this.gameView.setSurfaceCallback(surfaceCallbackProxy);
        }
    }

    @Override // com.tencent.mobileqq.triton.screenrecord.Recordable
    public void startRecording() {
        Logger.i$default(TAG, "startRecording, surfaceCallback=" + this.surfaceCallback + ", paused=" + this.paused, null, 4, null);
        SurfaceCallbackProxy surfaceCallbackProxy = this.surfaceCallback;
        if (surfaceCallbackProxy != null && !this.paused && surfaceCallbackProxy != null) {
            surfaceCallbackProxy.startRecording();
        }
    }

    @Override // com.tencent.mobileqq.triton.screenrecord.Recordable
    public void stopRecording() {
        Logger.i$default(TAG, "stopRecording, surfaceCallback=" + this.surfaceCallback + ", paused=" + this.paused, null, 4, null);
        SurfaceCallbackProxy surfaceCallbackProxy = this.surfaceCallback;
        if (surfaceCallbackProxy != null) {
            surfaceCallbackProxy.stopRecording();
        }
    }
}
