package com.tencent.ttpic.util;

import android.util.Pair;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AudioFabbyUtil {
    public static double getRangeValue(int i3, float f16, List<Pair<Float, Double>> list, double d16) {
        if (list.size() <= 0) {
            return d16;
        }
        Iterator<Pair<Float, Double>> it = list.iterator();
        Pair<Float, Double> pair = null;
        Pair<Float, Double> pair2 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Pair<Float, Double> next = it.next();
            if (((Float) next.first).floatValue() <= f16) {
                pair2 = next;
            } else {
                pair = next;
                break;
            }
        }
        if (pair2 == null && pair == null) {
            return 1.0d;
        }
        if (pair2 == null) {
            pair2 = pair;
        } else if (pair == null) {
            pair = pair2;
        }
        if (((Float) pair2.first).equals(pair.first)) {
            return ((Double) pair2.second).doubleValue();
        }
        return getValue(i3, ((Double) pair2.second).doubleValue(), ((Float) pair2.first).floatValue(), ((Double) pair.second).doubleValue(), ((Float) pair.first).floatValue(), f16);
    }

    private static double getValue(int i3, double d16, double d17, double d18, double d19, double d26) {
        double sin;
        double d27 = (d26 - d17) / (d19 - d17);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    sin = (d18 - d16) * d27;
                } else {
                    return (((-(d18 - d16)) / 2.0d) * (Math.cos(d27 * 3.141592653589793d) - 1.0d)) + d16;
                }
            } else {
                sin = (d18 - d16) * Math.sin(d27 * 1.5707963267948966d);
            }
            return sin + d16;
        }
        return d18 + ((-(d18 - d16)) * Math.cos(d27 * 1.5707963267948966d));
    }
}
