package com.tencent.mobileqq.triton.statistic;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H&J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$H&J\u0012\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'H&J\u0012\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010*H&J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020,H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0018\u0010\n\u001a\u00020\u000bX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0012\u0010\u001a\u001a\u00020\u001bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/triton/statistic/StatisticsManager;", "", "accumulatedDrawCalls", "", "getAccumulatedDrawCalls", "()J", "accumulatedFrames", "getAccumulatedFrames", "currentDrawCalls", "getCurrentDrawCalls", "jankTraceLevel", "Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "getJankTraceLevel", "()Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "setJankTraceLevel", "(Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;)V", "lastBlackScreenTimeMillis", "getLastBlackScreenTimeMillis", "lastClickInfo", "", "getLastClickInfo", "()Ljava/lang/String;", "lastClicks", "getLastClicks", "lastTouchTimestamp", "getLastTouchTimestamp", "targetFPS", "", "getTargetFPS", "()F", "getTraceInfo", "", "callback", "Lcom/tencent/mobileqq/triton/statistic/GetTraceInfoCallback;", "setErrorCallback", "errorCallback", "Lcom/tencent/mobileqq/triton/statistic/ErrorCallback;", "setFpsUpdateListener", "fpsUpdateListener", "Lcom/tencent/mobileqq/triton/statistic/FpsUpdateListener;", "setFrameCallback", "frameCallback", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "setSubpackageLoadStatisticsCallback", "Lcom/tencent/mobileqq/triton/statistic/SubpackageLoadStatisticsCallback;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface StatisticsManager {
    long getAccumulatedDrawCalls();

    long getAccumulatedFrames();

    long getCurrentDrawCalls();

    @NotNull
    JankTraceLevel getJankTraceLevel();

    long getLastBlackScreenTimeMillis();

    @NotNull
    String getLastClickInfo();

    @NotNull
    String getLastClicks();

    long getLastTouchTimestamp();

    float getTargetFPS();

    void getTraceInfo(@NotNull GetTraceInfoCallback callback);

    void setErrorCallback(@Nullable ErrorCallback errorCallback);

    void setFpsUpdateListener(@Nullable FpsUpdateListener fpsUpdateListener);

    void setFrameCallback(@Nullable FrameCallback frameCallback);

    void setJankTraceLevel(@NotNull JankTraceLevel jankTraceLevel);

    void setSubpackageLoadStatisticsCallback(@NotNull SubpackageLoadStatisticsCallback callback);
}
