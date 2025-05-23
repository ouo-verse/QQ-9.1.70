package com.tencent.oskplayer.proxy;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ContentFormat {
    public static final int VIDEO_HLS = 1;
    public static final int VIDEO_LIVE = 4;
    public static final int VIDEO_MP4 = 8;

    public static boolean isHLSLive(String str) {
        if ((VideoManager.getInstance().probeContentFlag(str) & 5) != 0) {
            return true;
        }
        return false;
    }
}
