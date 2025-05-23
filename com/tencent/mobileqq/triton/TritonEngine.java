package com.tencent.mobileqq.triton;

import android.view.Surface;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.ScreenRecordCallback;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u000fH&J \u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010 \u001a\u00020\u000fH&J\b\u0010!\u001a\u00020\u000fH&J\b\u0010\"\u001a\u00020\u000fH&J\b\u0010#\u001a\u00020\u000fH&J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020%H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/triton/TritonEngine;", "", "data", "Lcom/tencent/mobileqq/triton/engine/EngineData;", "getData", "()Lcom/tencent/mobileqq/triton/engine/EngineData;", "state", "Lcom/tencent/mobileqq/triton/engine/EngineState;", "getState", "()Lcom/tencent/mobileqq/triton/engine/EngineState;", "statisticsManager", "Lcom/tencent/mobileqq/triton/statistic/StatisticsManager;", "getStatisticsManager", "()Lcom/tencent/mobileqq/triton/statistic/StatisticsManager;", "destroy", "", "isScreenRecordReady", "", "observeLifeCycle", "lifeCycle", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "onInputSurfaceReady", "surface", "Landroid/view/Surface;", "onScreenRecordRelease", "prepareScreenRecord", "recordAudio", "outputPath", "Ljava/io/File;", "callback", "Lcom/tencent/mobileqq/triton/engine/ScreenRecordCallback;", "removeLifeCycleObserver", "start", "startScreenRecord", "stop", "stopScreenRecord", "takeScreenShot", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface TritonEngine {
    void destroy();

    @NotNull
    EngineData getData();

    @NotNull
    EngineState getState();

    @NotNull
    StatisticsManager getStatisticsManager();

    boolean isScreenRecordReady();

    void observeLifeCycle(@NotNull LifeCycle lifeCycle);

    void onInputSurfaceReady(@NotNull Surface surface);

    void onScreenRecordRelease();

    void prepareScreenRecord(boolean recordAudio, @NotNull File outputPath, @NotNull ScreenRecordCallback callback);

    void removeLifeCycleObserver(@NotNull LifeCycle lifeCycle);

    void start();

    void startScreenRecord();

    void stop();

    void stopScreenRecord();

    void takeScreenShot(@NotNull ScreenShotCallback callback);
}
