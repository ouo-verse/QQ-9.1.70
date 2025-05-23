package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.avcore.jni.codec.HWColorFormat;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Id3Util {
    public static int synchsafe(int i3) {
        int i16 = 0;
        int i17 = 127;
        while ((Integer.MAX_VALUE ^ i17) > 0) {
            i16 = (((~i17) & i3) << 1) | (i3 & i17);
            i17 = ((i17 + 1) << 8) - 1;
            i3 = i16;
        }
        return i16;
    }

    public static int unsynchsafe(int i3) {
        int i16 = 0;
        for (int i17 = HWColorFormat.COLOR_FormatVendorStartUnused; i17 > 0; i17 >>= 8) {
            i16 = (i16 >> 1) | (i3 & i17);
        }
        return i16;
    }
}
