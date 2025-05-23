package com.tencent.mobileqq.triton.internal.script;

import android.os.Handler;
import android.os.Looper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/script/CodeCacheSaver;", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "scriptSystem", "Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "(Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;)V", "gameLaunched", "", "mHandler", "Landroid/os/Handler;", "mTaskRunnable", "Ljava/lang/Runnable;", "cancelAutoSaving", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFirstFrame", "onGameLaunched", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/TritonEngine;", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class CodeCacheSaver implements LifeCycle {
    private static final long DELAY_SAVING_CACHE_AFTER_PRELOAD = 10000;
    private static final String TAG = "CodeCacheSaver";
    private boolean gameLaunched;
    private final Handler mHandler;
    private final Runnable mTaskRunnable;
    private final ScriptSystem scriptSystem;

    public CodeCacheSaver(@NotNull ScriptSystem scriptSystem) {
        Intrinsics.checkParameterIsNotNull(scriptSystem, "scriptSystem");
        this.scriptSystem = scriptSystem;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mTaskRunnable = new Runnable() { // from class: com.tencent.mobileqq.triton.internal.script.CodeCacheSaver$mTaskRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                ScriptSystem scriptSystem2;
                scriptSystem2 = CodeCacheSaver.this.scriptSystem;
                scriptSystem2.saveCodeCache();
            }
        };
    }

    public final void cancelAutoSaving() {
        this.mHandler.removeCallbacks(this.mTaskRunnable);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onDestroy() {
        LifeCycle.DefaultImpls.onDestroy(this);
        cancelAutoSaving();
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onFirstFrame() {
        Logger.d$default(TAG, "onFirstFrame", null, 4, null);
        this.mHandler.postDelayed(this.mTaskRunnable, 10000L);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onGameLaunched(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        this.gameLaunched = true;
        Logger.d$default(TAG, "onGameLaunched", null, 4, null);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStart() {
        LifeCycle.DefaultImpls.onStart(this);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStop() {
        LifeCycle.DefaultImpls.onStop(this);
    }
}
