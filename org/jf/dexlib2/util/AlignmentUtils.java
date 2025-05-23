package org.jf.dexlib2.util;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class AlignmentUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static int alignOffset(int i3, int i16) {
        int i17 = i16 - 1;
        return (i3 + i17) & (~i17);
    }

    public static boolean isAligned(int i3, int i16) {
        if (i3 % i16 == 0) {
            return true;
        }
        return false;
    }
}
