package com.tencent.rdelivery.monitor;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/rdelivery/monitor/AppStateMonitor;", "Landroidx/lifecycle/LifecycleObserver;", "", "onAppBackground", "onAppForeground", "Lcom/tencent/rdelivery/monitor/AppStateMonitor$a;", "listener", "a", "", "d", "Ljava/util/List;", "listeners", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class AppStateMonitor implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<a> listeners = new CopyOnWriteArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/rdelivery/monitor/AppStateMonitor$a;", "", "", "onEnterBackground", "onEnterForeground", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public interface a {
        void onEnterBackground();

        void onEnterForeground();
    }

    public AppStateMonitor() {
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
        Intrinsics.checkExpressionValueIsNotNull(lifecycleOwner, "ProcessLifecycleOwner.get()");
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private final void onAppBackground() {
        Iterator<a> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onEnterBackground();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private final void onAppForeground() {
        Iterator<a> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onEnterForeground();
        }
    }

    public final void a(@NotNull a listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.listeners.add(listener);
    }
}
