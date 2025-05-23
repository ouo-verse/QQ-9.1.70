package com.tencent.rmonitor.base.plugin.listener;

/* loaded from: classes25.dex */
public interface IMemoryPeakListener extends IBaseListener {
    void onJavaHeapUpdate(long j3);

    void onPssUpdate(long j3);

    void onVssUpdate(long j3);
}
