package com.tencent.biz.richframework.monitor.window;

import android.os.Build;
import android.os.Handler;
import android.view.Window;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J*\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bR#\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/richframework/monitor/window/RFWWindowPerformanceMonitor;", "", "Landroid/view/Window;", "window", "", "key", "Lcom/tencent/biz/richframework/monitor/window/FrameMetricsAvailableListener;", "removeWindowFrameMetricsAvailableListener", "", "setWindowFrameMetricsAvailableListener", "startMonitor", "Landroidx/core/util/Consumer;", "Lcom/tencent/biz/richframework/monitor/window/WindowPerformanceData;", "consumer", "stopMonitor", "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "handler$delegate", "Lkotlin/Lazy;", "getHandler", "()Landroid/os/Handler;", "handler", "<init>", "()V", "monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWWindowPerformanceMonitor {

    @NotNull
    public static final RFWWindowPerformanceMonitor INSTANCE = new RFWWindowPerformanceMonitor();

    /* renamed from: handler$delegate, reason: from kotlin metadata */
    private static final Lazy handler;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.biz.richframework.monitor.window.RFWWindowPerformanceMonitor$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(rFWThreadManager, "RFWThreadManager.getInstance()");
                return rFWThreadManager.getSerialThreadHandler();
            }
        });
        handler = lazy;
    }

    RFWWindowPerformanceMonitor() {
    }

    private final Handler getHandler() {
        return (Handler) handler.getValue();
    }

    private final FrameMetricsAvailableListener removeWindowFrameMetricsAvailableListener(Window window, String key) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        Object tag = window.getDecorView().getTag(R.id.f74023v5);
        if (!(tag instanceof WindowFrameMetricsAvailableListenerDelegate)) {
            tag = null;
        }
        WindowFrameMetricsAvailableListenerDelegate windowFrameMetricsAvailableListenerDelegate = (WindowFrameMetricsAvailableListenerDelegate) tag;
        if (windowFrameMetricsAvailableListenerDelegate == null) {
            return null;
        }
        FrameMetricsAvailableListener removeWindowFrameMetricsListener = windowFrameMetricsAvailableListenerDelegate.removeWindowFrameMetricsListener(key);
        if (windowFrameMetricsAvailableListenerDelegate.getListenersSize() == 0) {
            try {
                window.getDecorView().setTag(R.id.f74023v5, null);
                window.removeOnFrameMetricsAvailableListener(windowFrameMetricsAvailableListenerDelegate);
            } catch (Exception unused) {
                RFWLog.d("RFWWindowPerformanceMonitor", RFWLog.USR, "removeWindowFrameMetricsAvailableListener exception");
            }
        }
        return removeWindowFrameMetricsListener;
    }

    private final void setWindowFrameMetricsAvailableListener(Window window, String key) {
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        Object tag = window.getDecorView().getTag(R.id.f74023v5);
        if (!(tag instanceof WindowFrameMetricsAvailableListenerDelegate)) {
            tag = null;
        }
        WindowFrameMetricsAvailableListenerDelegate windowFrameMetricsAvailableListenerDelegate = (WindowFrameMetricsAvailableListenerDelegate) tag;
        if (windowFrameMetricsAvailableListenerDelegate == null) {
            windowFrameMetricsAvailableListenerDelegate = new WindowFrameMetricsAvailableListenerDelegate();
            window.getDecorView().setTag(R.id.f74023v5, windowFrameMetricsAvailableListenerDelegate);
            window.addOnFrameMetricsAvailableListener(windowFrameMetricsAvailableListenerDelegate, getHandler());
        }
        windowFrameMetricsAvailableListenerDelegate.addWindowFrameMetricsListener(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void stopMonitor$default(RFWWindowPerformanceMonitor rFWWindowPerformanceMonitor, Window window, String str, Consumer consumer, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            consumer = null;
        }
        rFWWindowPerformanceMonitor.stopMonitor(window, str, consumer);
    }

    public final void startMonitor(@NotNull Window window, @NotNull String key) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(key, "key");
        setWindowFrameMetricsAvailableListener(window, key);
    }

    public final void stopMonitor(@NotNull Window window, @NotNull String key, @Nullable final Consumer<WindowPerformanceData> consumer) {
        final FrameMetricsAvailableListener removeWindowFrameMetricsAvailableListener;
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 24 && (removeWindowFrameMetricsAvailableListener = removeWindowFrameMetricsAvailableListener(window, key)) != null && consumer != null) {
            getHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.monitor.window.RFWWindowPerformanceMonitor$stopMonitor$1
                @Override // java.lang.Runnable
                public final void run() {
                    Consumer.this.accept(removeWindowFrameMetricsAvailableListener.getWindowPerformanceData());
                }
            });
        }
    }
}
