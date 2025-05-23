package org.jf.util;

import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BitSetUtils {
    public static BitSet bitSetOfIndexes(int... iArr) {
        BitSet bitSet = new BitSet();
        for (int i3 : iArr) {
            bitSet.set(i3);
        }
        return bitSet;
    }
}
