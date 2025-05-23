package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CustomizedSensorEvent {
    public int accuracy;
    public CustomizedSensor sensor;
    public long timestamp;
    public final float[] values;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomizedSensorEvent(int i3) {
        this.values = new float[i3];
    }
}
