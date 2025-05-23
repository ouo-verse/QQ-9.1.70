package org.jbox2d.pooling.arrays;

import java.util.HashMap;
import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Vec2Array {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final HashMap<Integer, Vec2[]> map = new HashMap<>();

    public Vec2[] get(int i3) {
        if (!this.map.containsKey(Integer.valueOf(i3))) {
            this.map.put(Integer.valueOf(i3), getInitializedArray(i3));
        }
        return this.map.get(Integer.valueOf(i3));
    }

    protected Vec2[] getInitializedArray(int i3) {
        Vec2[] vec2Arr = new Vec2[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            vec2Arr[i16] = new Vec2();
        }
        return vec2Arr;
    }
}
