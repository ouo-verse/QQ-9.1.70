package com.tencent.bugly.common.heapdump;

import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IHeapDumper {
    public static final int DUMP_ERROR_DUMP_HPROF_FAILED = 107;
    public static final int DUMP_ERROR_DUMP_HPROF_SMALL = 108;
    public static final int DUMP_ERROR_NO_VALID_DUMPER = 109;
    public static final int DUMP_ERROR_SO_NOT_LOADED = 101;
    public static final int DUMP_ERROR_SPACE_NOT_ENOUGH = 103;
    public static final int DUMP_ERROR_SUB_PROCESS_DUMP_FAILED = 105;
    public static final int DUMP_ERROR_SUB_PROCESS_DUMP_TIMEOUT = 106;
    public static final int DUMP_ERROR_SYMBOL_NOT_RESOLVED = 102;
    public static final int DUMP_ERROR_VERSION_NOT_PERMIT = 104;
    public static final int DUMP_SUCCESS = 0;

    int dump(String str, @NotNull HeapDumpConfig heapDumpConfig);

    boolean isValid();
}
