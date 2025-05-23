package com.tencent.oskplayer.contrib;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ImageHashError extends Error {
    public static final int ERROR_DECODE_FLOW = -2147483638;
    public static final int ERROR_LARGE_DISTANCE = -2147483628;
    public static final int ERROR_LOW_FPS = -2147483618;
    public static final int ERROR_UNKNOWN = Integer.MIN_VALUE;
    public static final int NOERR = 0;
    public int errCode;

    public ImageHashError(int i3, String str) {
        super(str);
        this.errCode = i3;
    }

    public ImageHashError(int i3, Throwable th5) {
        super(th5);
        this.errCode = i3;
    }
}
