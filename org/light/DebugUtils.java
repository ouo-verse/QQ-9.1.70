package org.light;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DebugUtils {
    private static final String TAG = "DebugUtils";

    private static native void nativeSetImageDebugInfo(boolean z16, String str, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27);

    public static void setImageDebugInfo(boolean z16, String str, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27) {
        nativeSetImageDebugInfo(z16, str, z17, z18, z19, z26, z27);
    }
}
