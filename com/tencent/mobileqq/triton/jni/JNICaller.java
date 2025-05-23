package com.tencent.mobileqq.triton.jni;

import android.content.res.AssetManager;
import android.view.Surface;
import com.tencent.mobileqq.triton.api.TTChannel;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.internal.game.EngineScriptPackageBridge;
import com.tencent.mobileqq.triton.internal.game.GameDataFileSystemBridge;
import com.tencent.mobileqq.triton.internal.game.GameScriptPackageBridge;
import com.tencent.mobileqq.triton.internal.script.InspectorBridge;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.utils.CanvasRecorder;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class JNICaller {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static final class RenderContext {
        public static void nInitRenderContext(com.tencent.mobileqq.triton.render.RenderContext renderContext, long j3, Surface surface, int i3, int i16, float f16) {
            try {
                renderContext.nInitRenderContext(j3, surface, i3, i16, f16);
            } catch (UnsatisfiedLinkError unused) {
                renderContext.nInitRenderContext(j3, surface, i3, i16, f16);
            }
        }

        public static void nOnPause(com.tencent.mobileqq.triton.render.RenderContext renderContext, long j3) {
            try {
                renderContext.nOnPause(j3);
            } catch (UnsatisfiedLinkError unused) {
                renderContext.nOnPause(j3);
            }
        }

        public static void nOnResume(com.tencent.mobileqq.triton.render.RenderContext renderContext, long j3) {
            try {
                renderContext.nOnResume(j3);
            } catch (UnsatisfiedLinkError unused) {
                renderContext.nOnResume(j3);
            }
        }

        public static void nSurfaceChanged(com.tencent.mobileqq.triton.render.RenderContext renderContext, long j3, Surface surface) {
            try {
                renderContext.nSurfaceChanged(j3, surface);
            } catch (UnsatisfiedLinkError unused) {
                renderContext.nSurfaceChanged(j3, surface);
            }
        }

        public static void nSurfaceDestroyed(com.tencent.mobileqq.triton.render.RenderContext renderContext, long j3) {
            try {
                renderContext.nSurfaceDestroyed(j3);
            } catch (UnsatisfiedLinkError unused) {
                renderContext.nSurfaceDestroyed(j3);
            }
        }

        public static boolean nUpdateRenderContext(com.tencent.mobileqq.triton.render.RenderContext renderContext, long j3) {
            try {
                return renderContext.nUpdateRenderContext(j3);
            } catch (UnsatisfiedLinkError unused) {
                return renderContext.nUpdateRenderContext(j3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static final class TTEngine {
        public static int getProcessedMessageCount(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3) {
            try {
                return tTEngine.getProcessedMessageCount(j3);
            } catch (UnsatisfiedLinkError unused) {
                return tTEngine.getProcessedMessageCount(j3);
            }
        }

        public static void interruptLoop(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3) {
            try {
                tTEngine.interruptLoop(j3);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.interruptLoop(j3);
            }
        }

        public static long nativeCanvasPresent(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3) {
            try {
                return tTEngine.nativeCanvasPresent(j3);
            } catch (UnsatisfiedLinkError unused) {
                return tTEngine.nativeCanvasPresent(j3);
            }
        }

        public static void nativeCreateTTApp(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3, com.tencent.mobileqq.triton.render.RenderContext renderContext, CanvasRecorder canvasRecorder, TTChannel tTChannel, FontBitmapManager fontBitmapManager, InspectorBridge inspectorBridge, EngineScriptPackageBridge engineScriptPackageBridge, ScriptSystem scriptSystem) {
            try {
                tTEngine.nativeCreateTTApp(j3, renderContext, canvasRecorder, tTChannel, fontBitmapManager, inspectorBridge, engineScriptPackageBridge, scriptSystem);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.nativeCreateTTApp(j3, renderContext, canvasRecorder, tTChannel, fontBitmapManager, inspectorBridge, engineScriptPackageBridge, scriptSystem);
            }
        }

        public static void nativeDiposeTTApp(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3) {
            try {
                tTEngine.nativeDiposeTTApp(j3);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.nativeDiposeTTApp(j3);
            }
        }

        public static long nativeEnvInit(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, boolean z16) {
            try {
                return tTEngine.nativeEnvInit(z16);
            } catch (UnsatisfiedLinkError unused) {
                return tTEngine.nativeEnvInit(z16);
            }
        }

        public static void nativeFinalize(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3) {
            try {
                tTEngine.nativeFinalize(j3);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.nativeFinalize(j3);
            }
        }

        public static void nativeFontManagerInit(AssetManager assetManager, String str) {
            try {
                com.tencent.mobileqq.triton.engine.TTEngine.nativeFontManagerInit(assetManager, str);
            } catch (UnsatisfiedLinkError unused) {
                com.tencent.mobileqq.triton.engine.TTEngine.nativeFontManagerInit(assetManager, str);
            }
        }

        public static long nativeGetCurrentFrameDrawCallCount(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3) {
            try {
                return tTEngine.nativeGetCurrentFrameDrawCallCount(j3);
            } catch (UnsatisfiedLinkError unused) {
                return tTEngine.nativeGetCurrentFrameDrawCallCount(j3);
            }
        }

        public static String nativeGetTTVersion() {
            try {
                return com.tencent.mobileqq.triton.engine.TTEngine.nativeGetTTVersion();
            } catch (UnsatisfiedLinkError unused) {
                return com.tencent.mobileqq.triton.engine.TTEngine.nativeGetTTVersion();
            }
        }

        public static void nativeInitGameInfo(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3, GameScriptPackageBridge gameScriptPackageBridge, GameDataFileSystemBridge gameDataFileSystemBridge) {
            try {
                tTEngine.nativeInitGameInfo(j3, gameScriptPackageBridge, gameDataFileSystemBridge);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.nativeInitGameInfo(j3, gameScriptPackageBridge, gameDataFileSystemBridge);
            }
        }

        public static void nativeOnTouchEvent(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3, long j16) {
            try {
                tTEngine.nativeOnTouchEvent(j3, j16);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.nativeOnTouchEvent(j3, j16);
            }
        }

        public static void nativeOnVSync(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3, long j16) {
            try {
                tTEngine.nativeOnVSync(j3, j16);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.nativeOnVSync(j3, j16);
            }
        }

        public static void nativeSaveScriptCodeCache(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3) {
            try {
                tTEngine.nativeSaveScriptCodeCache(j3);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.nativeSaveScriptCodeCache(j3);
            }
        }

        public static void nativeSetJankTraceLevel(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3, int i3) {
            try {
                tTEngine.nativeSetJankTraceLevel(j3, i3);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.nativeSetJankTraceLevel(j3, i3);
            }
        }

        public static void nativeSetPremultiplyAlpha(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3, boolean z16) {
            try {
                tTEngine.nativeSetPremultiplyAlpha(j3, z16);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.nativeSetPremultiplyAlpha(j3, z16);
            }
        }

        public static void nativeSetWebAudioEnable(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3, boolean z16) {
            try {
                tTEngine.nativeSetWebAudioEnable(j3, z16);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.nativeSetWebAudioEnable(j3, z16);
            }
        }

        public static void nativeSetWebglTwoEnable(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3, boolean z16) {
            try {
                tTEngine.nativeSetWebglTwoEnable(j3, z16);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.nativeSetWebglTwoEnable(j3, z16);
            }
        }

        public static boolean nativeStartDrawCall(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3) {
            try {
                return tTEngine.nativeStartDrawCall(j3);
            } catch (UnsatisfiedLinkError unused) {
                return tTEngine.nativeStartDrawCall(j3);
            }
        }

        public static void postRunnableDelayedWithPriority(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3, Runnable runnable, long j16, int i3) {
            try {
                tTEngine.postRunnableDelayedWithPriority(j3, runnable, j16, i3);
            } catch (UnsatisfiedLinkError unused) {
                tTEngine.postRunnableDelayedWithPriority(j3, runnable, j16, i3);
            }
        }

        public static boolean runLoop(com.tencent.mobileqq.triton.engine.TTEngine tTEngine, long j3, boolean z16) {
            try {
                return tTEngine.runLoop(j3, z16);
            } catch (UnsatisfiedLinkError unused) {
                return tTEngine.runLoop(j3, z16);
            }
        }
    }
}
