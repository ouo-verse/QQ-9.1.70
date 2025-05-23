package com.tracking.sdk;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TrackerManager {
    public static final int ASMS = 1;
    public static final int CMT = 0;
    public static final int TYPE_GRAY = 3;
    public static final int TYPE_I420 = 4;
    public static final int TYPE_NV21 = 0;
    public static final int TYPE_RGB = 1;
    public static final int TYPE_RGBA = 2;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class ObjTrackHolder {
        public static TrackerManager instance = new TrackerManager();

        ObjTrackHolder() {
        }
    }

    public static TrackerManager newInstance() {
        return ObjTrackHolder.instance;
    }

    public native boolean openTrack(byte[] bArr, int i3, int i16, float f16, float f17, float f18, float f19, int i17, int i18, float f26);

    public native float[] processTrackFrame(byte[] bArr, int i3, int i16, int i17);

    public native void release();

    TrackerManager() {
        init();
    }

    public void init() {
    }
}
