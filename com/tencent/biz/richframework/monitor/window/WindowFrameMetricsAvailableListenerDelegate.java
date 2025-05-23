package com.tencent.biz.richframework.monitor.window;

import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RequiresApi(24)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u000bJ \u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0017J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/richframework/monitor/window/WindowFrameMetricsAvailableListenerDelegate;", "Landroid/view/Window$OnFrameMetricsAvailableListener;", "()V", "windowFrameListener", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/biz/richframework/monitor/window/FrameMetricsAvailableListener;", "addWindowFrameMetricsListener", "", "key", "getListenersSize", "", "onFrameMetricsAvailable", "window", "Landroid/view/Window;", "fm", "Landroid/view/FrameMetrics;", "dropCountSinceLastInvocation", "removeWindowFrameMetricsListener", "monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class WindowFrameMetricsAvailableListenerDelegate implements Window.OnFrameMetricsAvailableListener {
    private ConcurrentHashMap<String, FrameMetricsAvailableListener> windowFrameListener = new ConcurrentHashMap<>();

    public final void addWindowFrameMetricsListener(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrentHashMap<String, FrameMetricsAvailableListener> concurrentHashMap = this.windowFrameListener;
        FrameMetricsAvailableListener frameMetricsAvailableListener = new FrameMetricsAvailableListener();
        frameMetricsAvailableListener.setAddTime(System.nanoTime());
        Unit unit = Unit.INSTANCE;
        concurrentHashMap.putIfAbsent(key, frameMetricsAvailableListener);
    }

    public final int getListenersSize() {
        return this.windowFrameListener.size();
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    @WorkerThread
    public void onFrameMetricsAvailable(@NotNull Window window, @NotNull FrameMetrics fm5, int dropCountSinceLastInvocation) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        FrameMetrics frameMetrics = new FrameMetrics(fm5);
        for (FrameMetricsAvailableListener frameMetricsAvailableListener : this.windowFrameListener.values()) {
            Intrinsics.checkNotNullExpressionValue(frameMetricsAvailableListener, "iterator.next()");
            frameMetricsAvailableListener.onFrameMetricsAvailable(window, frameMetrics, dropCountSinceLastInvocation);
        }
    }

    @Nullable
    public final FrameMetricsAvailableListener removeWindowFrameMetricsListener(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.windowFrameListener.remove(key);
    }
}
