package com.tencent.state.square.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/api/ISquareMonitorService;", "", "addFPSMonitorObserver", "", "observer", "Lcom/tencent/state/square/api/ISquareFPSMonitorObserver;", "destroy", "getAppHeapAllocatedMemory", "", "getCpuUsage", "getPhoneLeftMemory", "getPssMemory", "getTotalPhoneMemory", "init", "removeFPSMonitorObserver", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareMonitorService {
    void addFPSMonitorObserver(@NotNull ISquareFPSMonitorObserver observer);

    void destroy();

    float getAppHeapAllocatedMemory();

    float getCpuUsage();

    float getPhoneLeftMemory();

    float getPssMemory();

    float getTotalPhoneMemory();

    void init();

    void removeFPSMonitorObserver(@NotNull ISquareFPSMonitorObserver observer);
}
