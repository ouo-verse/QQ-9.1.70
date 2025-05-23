package com.tencent.qqlive.module.videoreport.dtreport.audio.util;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AudioUtil {
    public static int floatByteCount() {
        return 4;
    }

    public static int getBytesPerSample(int i3) {
        if (i3 != 3) {
            if (i3 == 4) {
                return 4;
            }
            return 2;
        }
        return 1;
    }

    public static int shortByteSize() {
        return 2;
    }
}
