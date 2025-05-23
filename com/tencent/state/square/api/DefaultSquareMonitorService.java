package com.tencent.state.square.api;

import android.os.Process;
import com.tencent.state.square.util.CpuUtil;
import com.tencent.state.square.util.MemoryUtil;
import com.tencent.state.square.util.SquareFPSCalculator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/api/DefaultSquareMonitorService;", "Lcom/tencent/state/square/api/ISquareMonitorService;", "()V", "fpsListener", "Lcom/tencent/state/square/util/SquareFPSCalculator$SquareFPSListener;", "fpsMonitorObserverSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/state/square/api/ISquareFPSMonitorObserver;", "addFPSMonitorObserver", "", "observer", "destroy", "getAppHeapAllocatedMemory", "", "getCpuUsage", "getPhoneLeftMemory", "getPssMemory", "getTotalPhoneMemory", "init", "kbToMb", "", "kb", "removeFPSMonitorObserver", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultSquareMonitorService implements ISquareMonitorService {
    private final CopyOnWriteArraySet<ISquareFPSMonitorObserver> fpsMonitorObserverSet = new CopyOnWriteArraySet<>();
    private final SquareFPSCalculator.SquareFPSListener fpsListener = new SquareFPSCalculator.SquareFPSListener() { // from class: com.tencent.state.square.api.DefaultSquareMonitorService$fpsListener$1
        @Override // com.tencent.state.square.util.SquareFPSCalculator.SquareFPSListener
        public final void onInfo(long j3, double d16) {
            CopyOnWriteArraySet copyOnWriteArraySet;
            copyOnWriteArraySet = DefaultSquareMonitorService.this.fpsMonitorObserverSet;
            Iterator it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                ((ISquareFPSMonitorObserver) it.next()).onInfo(j3, d16);
            }
        }
    };

    private final long kbToMb(long kb5) {
        long j3 = 1024;
        return (kb5 / j3) / j3;
    }

    @Override // com.tencent.state.square.api.ISquareMonitorService
    public void addFPSMonitorObserver(@NotNull ISquareFPSMonitorObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.fpsMonitorObserverSet.contains(observer)) {
            this.fpsMonitorObserverSet.add(observer);
        }
    }

    @Override // com.tencent.state.square.api.ISquareMonitorService
    public void destroy() {
        this.fpsMonitorObserverSet.clear();
        SquareFPSCalculator.getInstance().removeListener(this.fpsListener);
    }

    @Override // com.tencent.state.square.api.ISquareMonitorService
    public float getAppHeapAllocatedMemory() {
        return (float) kbToMb(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
    }

    @Override // com.tencent.state.square.api.ISquareMonitorService
    public float getCpuUsage() {
        return CpuUtil.INSTANCE.getCpuUsage(Process.myPid()) * 100.0f;
    }

    @Override // com.tencent.state.square.api.ISquareMonitorService
    public float getPhoneLeftMemory() {
        MemoryUtil memoryUtil = MemoryUtil.INSTANCE;
        return (float) (memoryUtil.getTotalMem() - memoryUtil.getFreeMem());
    }

    @Override // com.tencent.state.square.api.ISquareMonitorService
    public float getPssMemory() {
        return MemoryUtil.getRoughPssMemoryInfoInner(Process.myPid()).getTotalPss() / 1024.0f;
    }

    @Override // com.tencent.state.square.api.ISquareMonitorService
    public float getTotalPhoneMemory() {
        return (float) MemoryUtil.INSTANCE.getTotalMem();
    }

    @Override // com.tencent.state.square.api.ISquareMonitorService
    public void init() {
        SquareFPSCalculator.getInstance().setInterval(2000);
        SquareFPSCalculator.getInstance().addListener(this.fpsListener);
    }

    @Override // com.tencent.state.square.api.ISquareMonitorService
    public void removeFPSMonitorObserver(@NotNull ISquareFPSMonitorObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.fpsMonitorObserverSet.contains(observer)) {
            this.fpsMonitorObserverSet.remove(observer);
        }
    }
}
