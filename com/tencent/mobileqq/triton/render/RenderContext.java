package com.tencent.mobileqq.triton.render;

import android.view.Surface;
import androidx.annotation.AnyThread;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.annotation.JNIModule;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.render.monitor.FPSMonitor;
import com.tencent.mobileqq.triton.internal.render.monitor.FirstScreenMonitor;
import com.tencent.mobileqq.triton.internal.render.monitor.ScreenShootMonitor;
import com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.jni.JNICaller;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.statistic.FpsUpdateListener;
import com.tencent.mobileqq.triton.utils.TritonKeep;
import com.tencent.mobileqq.triton.view.GameView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@TritonKeep
@JNIModule
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 A2\u00020\u0001:\u0003ABCB\u0085\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\u0002\u0010\u0017J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020 J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0002J\u0006\u0010,\u001a\u00020\u0004J\u0016\u0010-\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020\u000eJ3\u00101\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u001cH\u0086 J\u0011\u00105\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0086 J\u0011\u00106\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0086 J\u001b\u00107\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0086 J\u0011\u00108\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0086 J\u0011\u00109\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0086 J\u0006\u0010:\u001a\u00020\u0004J\b\u0010;\u001a\u00020\u0004H\u0003J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u000eH\u0003J\b\u0010>\u001a\u00020\u0004H\u0003J\u0018\u0010?\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0019H\u0007J\u0010\u0010@\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010/R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/triton/render/RenderContext;", "", "onInitEnd", "Lkotlin/Function0;", "", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "nativeTTAppHandle", "", "fpsUpdateListener", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/statistic/FpsUpdateListener;", "lastBlackTimeHolder", "firstFameCallbackHolder", "", "accumulatedDrawCallHolder", "screenShotCallbackValueHolder", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "worker", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", "touchProviderBridge", "Lcom/tencent/mobileqq/triton/internal/touch/TouchProviderBridge;", "(Lkotlin/jvm/functions/Function0;Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;JLcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/tencent/mobileqq/triton/internal/touch/TouchProviderBridge;)V", "canvasHeightHolder", "", "canvasWidthHolder", "displayDensity", "", "renderSurfaceInit", "surfaceInitializerListeners", "", "Lcom/tencent/mobileqq/triton/render/RenderContext$RenderSurfaceInitializerListener;", "swapListeners", "Lcom/tencent/mobileqq/triton/render/RenderContext$SwapListener;", "touchEventManager", "getTouchEventManager", "()Lcom/tencent/mobileqq/triton/internal/touch/TouchProviderBridge;", "addSurfaceInitializerListener", "listener", "attachGameView", "gameView", "Lcom/tencent/mobileqq/triton/view/GameView;", "attachSurface", "destroyRenderContext", "initRenderContext", "surface", "Landroid/view/Surface;", "isSurfaceReady", "nInitRenderContext", "width", "height", "scale", "nOnPause", "nOnResume", "nSurfaceChanged", "nSurfaceDestroyed", "nUpdateRenderContext", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onRenderContextInit", "onRenderSurfaceReadyChanged", "isInit", "onSwapBuffer", "setFixedSize", "surfaceChanged", "Companion", "RenderSurfaceInitializerListener", "SwapListener", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class RenderContext {
    private static final String TAG = "RenderContext";
    private final ValueHolder<Integer> canvasHeightHolder;
    private final ValueHolder<Integer> canvasWidthHolder;
    private float displayDensity;
    private final LifeCycleOwner lifeCycleOwner;
    private final long nativeTTAppHandle;
    private final Function0<Unit> onInitEnd;
    private boolean renderSurfaceInit;
    private final List<RenderSurfaceInitializerListener> surfaceInitializerListeners;
    private final List<SwapListener> swapListeners;

    @NotNull
    private final TouchProviderBridge touchEventManager;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/triton/render/RenderContext$RenderSurfaceInitializerListener;", "", "onInitializer", "", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public interface RenderSurfaceInitializerListener {
        void onInitializer();
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/triton/render/RenderContext$SwapListener;", "", "onSwap", "", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public interface SwapListener {
        void onSwap();
    }

    public RenderContext(@NotNull Function0<Unit> onInitEnd, @NotNull LifeCycleOwner lifeCycleOwner, long j3, @NotNull ValueHolder<FpsUpdateListener> fpsUpdateListener, @NotNull ValueHolder<Long> lastBlackTimeHolder, @NotNull ValueHolder<Boolean> firstFameCallbackHolder, @NotNull ValueHolder<Long> accumulatedDrawCallHolder, @NotNull ValueHolder<ScreenShotCallback> screenShotCallbackValueHolder, @NotNull Executor worker, @NotNull Executor mainThreadExecutor, @NotNull TouchProviderBridge touchProviderBridge) {
        List listOf;
        Intrinsics.checkParameterIsNotNull(onInitEnd, "onInitEnd");
        Intrinsics.checkParameterIsNotNull(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.checkParameterIsNotNull(fpsUpdateListener, "fpsUpdateListener");
        Intrinsics.checkParameterIsNotNull(lastBlackTimeHolder, "lastBlackTimeHolder");
        Intrinsics.checkParameterIsNotNull(firstFameCallbackHolder, "firstFameCallbackHolder");
        Intrinsics.checkParameterIsNotNull(accumulatedDrawCallHolder, "accumulatedDrawCallHolder");
        Intrinsics.checkParameterIsNotNull(screenShotCallbackValueHolder, "screenShotCallbackValueHolder");
        Intrinsics.checkParameterIsNotNull(worker, "worker");
        Intrinsics.checkParameterIsNotNull(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkParameterIsNotNull(touchProviderBridge, "touchProviderBridge");
        this.onInitEnd = onInitEnd;
        this.lifeCycleOwner = lifeCycleOwner;
        this.nativeTTAppHandle = j3;
        this.surfaceInitializerListeners = new ArrayList();
        ValueHolder.Companion companion = ValueHolder.INSTANCE;
        ValueHolder<Integer> just = companion.just(0);
        this.canvasWidthHolder = just;
        ValueHolder<Integer> just2 = companion.just(0);
        this.canvasHeightHolder = just2;
        this.touchEventManager = touchProviderBridge;
        Logger.e$default(TAG, "initialize:" + this, null, 4, null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new SwapListener[]{new FPSMonitor(fpsUpdateListener), new FirstScreenMonitor(firstFameCallbackHolder, accumulatedDrawCallHolder), new ScreenShootMonitor(screenShotCallbackValueHolder, just, just2, mainThreadExecutor, worker)});
        this.swapListeners = new CopyOnWriteArrayList(listOf);
    }

    private final void attachSurface(final GameView gameView) {
        gameView.setSurfaceCallback(new GameView.SurfaceCallback() { // from class: com.tencent.mobileqq.triton.render.RenderContext$attachSurface$1
            @Override // com.tencent.mobileqq.triton.view.GameView.SurfaceCallback
            public void onSurfaceChanged(@NotNull Surface surface, int format, int width, int height) {
                Intrinsics.checkParameterIsNotNull(surface, "surface");
                RenderContext.this.surfaceChanged(surface);
            }

            @Override // com.tencent.mobileqq.triton.view.GameView.SurfaceCallback
            public void onSurfaceCreated(@NotNull Surface surface) {
                Intrinsics.checkParameterIsNotNull(surface, "surface");
                RenderContext.this.initRenderContext(gameView, surface);
            }

            @Override // com.tencent.mobileqq.triton.view.GameView.SurfaceCallback
            public void onSurfaceDestroyed() {
                RenderContext.this.destroyRenderContext();
            }
        });
        this.swapListeners.add(new SwapListener() { // from class: com.tencent.mobileqq.triton.render.RenderContext$attachSurface$2
            @Override // com.tencent.mobileqq.triton.render.RenderContext.SwapListener
            public void onSwap() {
                GameView.this.onSwapBuffer();
            }
        });
    }

    @TritonKeep
    private final void onRenderContextInit() {
        this.onInitEnd.invoke();
    }

    @TritonKeep
    private final void onRenderSurfaceReadyChanged(boolean isInit) {
        Logger.i$default(TAG, "onRenderSurfaceReadyChanged isInit=" + isInit, null, 4, null);
        synchronized (this.surfaceInitializerListeners) {
            this.renderSurfaceInit = isInit;
            if (isInit) {
                Iterator<T> it = this.surfaceInitializerListeners.iterator();
                while (it.hasNext()) {
                    ((RenderSurfaceInitializerListener) it.next()).onInitializer();
                }
                this.surfaceInitializerListeners.clear();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @TritonKeep
    private final void onSwapBuffer() {
        Iterator<SwapListener> it = this.swapListeners.iterator();
        while (it.hasNext()) {
            it.next().onSwap();
        }
    }

    public final void addSurfaceInitializerListener(@NotNull RenderSurfaceInitializerListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        synchronized (this.surfaceInitializerListeners) {
            if (this.renderSurfaceInit) {
                listener.onInitializer();
            } else {
                this.surfaceInitializerListeners.add(listener);
            }
        }
    }

    @AnyThread
    public final void attachGameView(@NotNull final GameView gameView) {
        Intrinsics.checkParameterIsNotNull(gameView, "gameView");
        float displayDensity = gameView.getDisplayDensity();
        this.displayDensity = displayDensity;
        this.touchEventManager.attachView(gameView, displayDensity);
        attachSurface(gameView);
        this.lifeCycleOwner.observeLifeCycle(new LifeCycle() { // from class: com.tencent.mobileqq.triton.render.RenderContext$attachGameView$1
            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onDestroy() {
                GameView.this.setGameOnTouchListener(null);
                GameView.this.setSurfaceCallback(null);
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
                LifeCycle.DefaultImpls.onStart(this);
            }

            @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
            public void onStop() {
                LifeCycle.DefaultImpls.onStop(this);
            }
        });
    }

    public final void destroyRenderContext() {
        JNICaller.RenderContext.nSurfaceDestroyed(this, this.nativeTTAppHandle);
    }

    @NotNull
    public final TouchProviderBridge getTouchEventManager() {
        return this.touchEventManager;
    }

    public final void initRenderContext(@NotNull GameView gameView, @NotNull Surface surface) {
        Intrinsics.checkParameterIsNotNull(gameView, "gameView");
        Intrinsics.checkParameterIsNotNull(surface, "surface");
        long j3 = this.nativeTTAppHandle;
        int i3 = (int) (gameView.get_width() / this.displayDensity);
        float f16 = gameView.get_height();
        float f17 = this.displayDensity;
        JNICaller.RenderContext.nInitRenderContext(this, j3, surface, i3, (int) (f16 / f17), f17);
    }

    public final boolean isSurfaceReady() {
        boolean z16;
        synchronized (this.surfaceInitializerListeners) {
            z16 = this.renderSurfaceInit;
        }
        return z16;
    }

    public final native void nInitRenderContext(long nativeTTAppHandle, @Nullable Surface surface, int width, int height, float scale);

    public final native void nOnPause(long nativeTTAppHandle);

    public final native void nOnResume(long nativeTTAppHandle);

    public final native void nSurfaceChanged(long nativeTTAppHandle, @Nullable Surface surface);

    public final native void nSurfaceDestroyed(long nativeTTAppHandle);

    public final native boolean nUpdateRenderContext(long nativeTTAppHandle);

    public final void onDestroy() {
        this.swapListeners.clear();
        synchronized (this.surfaceInitializerListeners) {
            this.surfaceInitializerListeners.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @TritonKeep
    public final void setFixedSize(int width, int height) {
        this.canvasWidthHolder.setValue(Integer.valueOf(width));
        this.canvasHeightHolder.setValue(Integer.valueOf(height));
        Logger.i$default(TAG, "setFixedSize mCanvasWidth=" + width + ", mCanvasHeight=" + height, null, 4, null);
    }

    public final void surfaceChanged(@Nullable Surface surface) {
        JNICaller.RenderContext.nSurfaceChanged(this, this.nativeTTAppHandle, surface);
    }
}
