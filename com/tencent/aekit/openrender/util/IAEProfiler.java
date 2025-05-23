package com.tencent.aekit.openrender.util;

/* loaded from: classes3.dex */
public interface IAEProfiler {
    public static final String TAG = "IAEProfiler";
    public static final String TAG_CAL_FPS = "IAEProfiler-calFps";
    public static final String TAG_CHAIN_FILTERS = "IAEProfiler-chainFilters";
    public static final String TAG_CONFIG_FILTERS = "IAEProfiler-configFilters";
    public static final String TAG_DETECT_FRAME = "IAEProfiler-detectFrame";
    public static final String TAG_DRAW_FRAME = "IAEProfiler-drawFrame";
    public static final String TAG_GL_WAIT_FACE_Time = "IAEProfiler-waitFaceTime";
    public static final String TAG_GL_WAIT_SEG_Time = "IAEProfiler-waitSegTime";
    public static final String TAG_INIT_FILTERS = "IAEProfiler-initFilters";

    long endByTag(String str);

    String print();

    void reset();

    void startByTag(String str);
}
