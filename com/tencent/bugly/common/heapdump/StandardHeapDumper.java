package com.tencent.bugly.common.heapdump;

import com.tencent.bugly.common.heapdump.StripHeapDumper;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StandardHeapDumper extends StripHeapDumper {
    private static final String TAG = "RMonitor_Heap_StandardHeapDumper";

    @Override // com.tencent.bugly.common.heapdump.IHeapDumper
    public int dump(String str, @NotNull HeapDumpConfig heapDumpConfig) {
        Logger logger = Logger.f365497g;
        logger.i(TAG, "standard dumper dump start.");
        StripHeapDumper.HeapDumpResult heapDumpResult = new StripHeapDumper.HeapDumpResult(false, null);
        doDump(str, heapDumpConfig, heapDumpResult);
        logger.i(TAG, "standard dumper dump result: " + heapDumpResult);
        if (heapDumpResult.isSuccess) {
            return 0;
        }
        notifyDumpException(heapDumpConfig, heapDumpResult.exception);
        return 107;
    }

    @Override // com.tencent.bugly.common.heapdump.IHeapDumper
    public boolean isValid() {
        return true;
    }
}
