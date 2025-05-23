package org.jf.util;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class NibbleUtils {
    public static int extractHighSignedNibble(int i3) {
        return (i3 << 24) >> 28;
    }

    public static int extractHighUnsignedNibble(int i3) {
        return (i3 & 240) >>> 4;
    }

    public static int extractLowSignedNibble(int i3) {
        return (i3 << 28) >> 28;
    }

    public static int extractLowUnsignedNibble(int i3) {
        return i3 & 15;
    }
}
