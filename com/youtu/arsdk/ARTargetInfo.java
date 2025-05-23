package com.youtu.arsdk;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ARTargetInfo {
    public static final int STATE_LOST = 2;
    public static final int STATE_RECOGNIZED = 0;
    public static final int STATE_TRACKED = 1;
    public String markerDesc;
    public int markerIndex = -1;
    public int state = -1;
    public float[] pose = new float[16];

    public static ARTargetInfo[] allocateInitialized(int i3) {
        ARTargetInfo[] aRTargetInfoArr = new ARTargetInfo[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            aRTargetInfoArr[i16] = new ARTargetInfo();
        }
        return aRTargetInfoArr;
    }
}
