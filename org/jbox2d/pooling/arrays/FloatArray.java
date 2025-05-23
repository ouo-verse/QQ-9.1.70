package org.jbox2d.pooling.arrays;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FloatArray {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final HashMap<Integer, float[]> map = new HashMap<>();

    public float[] get(int i3) {
        if (!this.map.containsKey(Integer.valueOf(i3))) {
            this.map.put(Integer.valueOf(i3), getInitializedArray(i3));
        }
        return this.map.get(Integer.valueOf(i3));
    }

    protected float[] getInitializedArray(int i3) {
        return new float[i3];
    }
}
