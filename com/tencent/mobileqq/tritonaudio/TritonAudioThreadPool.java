package com.tencent.mobileqq.tritonaudio;

import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/TritonAudioThreadPool;", "", "()V", "audioExecutorService", "Ljava/util/concurrent/ExecutorService;", "audioExecutorService$annotations", "getAudioExecutorService", "()Ljava/util/concurrent/ExecutorService;", "audioThreadPool", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "audioThreadPool$annotations", "getAudioThreadPool", "()Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "innerAudioThreadPool", "innerAudioThreadPool$annotations", "getInnerAudioThreadPool", "TritonAudio_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class TritonAudioThreadPool {
    public static final TritonAudioThreadPool INSTANCE = new TritonAudioThreadPool();

    @NotNull
    private static final ExecutorService audioExecutorService;

    @NotNull
    private static final ScheduledThreadPoolExecutor audioThreadPool;

    @NotNull
    private static final ScheduledThreadPoolExecutor innerAudioThreadPool;

    static {
        BaseScheduledThreadPoolExecutor baseScheduledThreadPoolExecutor = new BaseScheduledThreadPoolExecutor(2, new TF("TritonAudio", -19));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        baseScheduledThreadPoolExecutor.setKeepAliveTime(10L, timeUnit);
        baseScheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        audioThreadPool = baseScheduledThreadPoolExecutor;
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        Intrinsics.checkExpressionValueIsNotNull(newSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
        audioExecutorService = newSingleThreadExecutor;
        BaseScheduledThreadPoolExecutor baseScheduledThreadPoolExecutor2 = new BaseScheduledThreadPoolExecutor(10, new TF("TritonInnerAudio", -19));
        baseScheduledThreadPoolExecutor2.setKeepAliveTime(30L, timeUnit);
        baseScheduledThreadPoolExecutor2.allowCoreThreadTimeOut(true);
        innerAudioThreadPool = baseScheduledThreadPoolExecutor2;
    }

    TritonAudioThreadPool() {
    }

    @NotNull
    public static final ExecutorService getAudioExecutorService() {
        return audioExecutorService;
    }

    @NotNull
    public static final ScheduledThreadPoolExecutor getAudioThreadPool() {
        return audioThreadPool;
    }

    @NotNull
    public static final ScheduledThreadPoolExecutor getInnerAudioThreadPool() {
        return innerAudioThreadPool;
    }

    @JvmStatic
    public static /* synthetic */ void audioExecutorService$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void audioThreadPool$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void innerAudioThreadPool$annotations() {
    }
}
