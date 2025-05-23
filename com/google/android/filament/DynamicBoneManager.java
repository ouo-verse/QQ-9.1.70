package com.google.android.filament;

import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DynamicBoneManager {
    private long mNativeObject;
    private long startTime;

    public DynamicBoneManager(Engine engine, @Entity int i3) {
        this.mNativeObject = nCreateManager(engine.getNativeObject(), i3);
    }

    private static native void nAddDynamicBone(long j3, int i3, List<Map<String, String>> list, List<Map<String, String>> list2, boolean z16, float[] fArr);

    private static native void nClear(long j3);

    private static native long nCreateManager(long j3, int i3);

    private static native void nUpdate(long j3, double d16);

    private static native void nUpdateHeadData(long j3, float[] fArr, int i3, float[] fArr2);

    public void add(@Entity int i3, List<Map<String, String>> list, List<Map<String, String>> list2, boolean z16, float[] fArr) {
        nAddDynamicBone(this.mNativeObject, i3, list, list2, z16, fArr);
    }

    public void clear() {
        nClear(this.mNativeObject);
    }

    public long getNativeObject() {
        return this.mNativeObject;
    }

    public void update() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.startTime <= 0) {
            this.startTime = currentTimeMillis;
        }
        nUpdate(this.mNativeObject, (currentTimeMillis - this.startTime) / 1000.0d);
    }

    public void updateHeadData(float[] fArr, int i3, float[] fArr2) {
        nUpdateHeadData(this.mNativeObject, fArr, i3, fArr2);
    }
}
