package com.tencent.rmonitor.looper;

import android.os.Looper;
import com.tencent.bugly.common.looper.ILooperDispatchListener;
import com.tencent.bugly.common.looper.LooperDispatchWatcher;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/rmonitor/looper/b;", "Lcom/tencent/rmonitor/looper/LagObserver;", "Lcom/tencent/bugly/common/looper/ILooperDispatchListener;", "Ljava/lang/Thread;", "e", "", "k", "l", "", h.f248218g, "", "msg", "", "startTime", "onDispatchStart", "endTime", "duration", "onDispatchEnd", "Landroid/os/Looper;", "i", "Landroid/os/Looper;", "monitoredLooper", "Lcom/tencent/rmonitor/looper/provider/b;", "lagParam", "<init>", "(Landroid/os/Looper;Lcom/tencent/rmonitor/looper/provider/b;)V", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b extends LagObserver implements ILooperDispatchListener {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Looper monitoredLooper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Looper monitoredLooper, @NotNull com.tencent.rmonitor.looper.provider.b lagParam) {
        super(lagParam);
        Intrinsics.checkParameterIsNotNull(monitoredLooper, "monitoredLooper");
        Intrinsics.checkParameterIsNotNull(lagParam, "lagParam");
        this.monitoredLooper = monitoredLooper;
    }

    @Override // com.tencent.rmonitor.looper.LagObserver
    @Nullable
    public Thread e() {
        return this.monitoredLooper.getThread();
    }

    @Override // com.tencent.bugly.common.looper.ILooperDispatchListener
    public boolean isOpen() {
        return true;
    }

    @Override // com.tencent.rmonitor.looper.LagObserver
    public void k() {
        super.k();
        LooperDispatchWatcher.INSTANCE.register(this.monitoredLooper, this);
        Logger.f365497g.i("RMonitor_lag", "start Looper Observer of " + f());
    }

    @Override // com.tencent.rmonitor.looper.LagObserver
    public void l() {
        LooperDispatchWatcher.INSTANCE.unregister(this.monitoredLooper, this);
        super.l();
        Logger.f365497g.i("RMonitor_lag", "stop Looper Observer of " + f());
    }

    @Override // com.tencent.bugly.common.looper.ILooperDispatchListener
    public void onDispatchEnd(@NotNull String msg2, long endTime, long duration) {
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        d(endTime, duration);
    }

    @Override // com.tencent.bugly.common.looper.ILooperDispatchListener
    public void onDispatchStart(@NotNull String msg2, long startTime) {
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        c(startTime);
    }
}
