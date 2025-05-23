package com.tencent.rmonitor.base.plugin.listener;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/rmonitor/base/plugin/listener/IMemoryCeilingListener;", "Lcom/tencent/rmonitor/base/plugin/listener/IMemoryDumpListener;", "onLowMemory", "", "memory", "", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public interface IMemoryCeilingListener extends IMemoryDumpListener {
    boolean onLowMemory(long memory);
}
