package com.samsung.android.sdk.camera.util;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SsdkVersionCheck {
    public static int compareVersion(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        for (int i3 = 0; i3 < min; i3++) {
            int compareTo = new Integer(split[i3]).compareTo(Integer.valueOf(Integer.parseInt(split2[i3])));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.compare(split.length, split2.length);
    }
}
