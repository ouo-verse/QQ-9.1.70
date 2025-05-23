package com.tencent.bugly.common.heapdump;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HeapDumpConfig {
    public static final int HPROF_STRIP_BYTES = 2;
    public static final int HPROF_STRIP_CHAR = 4;
    public static final int HPROF_STRIP_ENABLE = 1;
    public static final int HPROF_STRIP_IMAGE_HEAP = 32;
    public static final int HPROF_STRIP_OTHER_PRIMITIVE = 8;
    public static final int HPROF_STRIP_ZYGOTE_HEAP = 16;
    private final String dumpScene;
    private final boolean enableStrip;
    private IHeapDumpExceptionListener exceptionListener;
    private final int stripConfig;

    public HeapDumpConfig(boolean z16, int i3, String str) {
        this.enableStrip = z16;
        this.stripConfig = i3;
        this.dumpScene = str;
    }

    public String getDumpScene() {
        return this.dumpScene;
    }

    public IHeapDumpExceptionListener getExceptionListener() {
        return this.exceptionListener;
    }

    public int getStripConfig() {
        return this.stripConfig;
    }

    public boolean isEnableStrip() {
        return this.enableStrip;
    }

    public void setExceptionListener(IHeapDumpExceptionListener iHeapDumpExceptionListener) {
        this.exceptionListener = iHeapDumpExceptionListener;
    }

    public HeapDumpConfig(boolean z16, int i3) {
        this(z16, i3, "");
    }

    public HeapDumpConfig(boolean z16) {
        this(z16, 0);
    }
}
