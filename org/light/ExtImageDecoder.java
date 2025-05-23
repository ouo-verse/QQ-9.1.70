package org.light;

import android.graphics.Bitmap;
import org.light.extDecoder.ExtDecoderApng;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class ExtImageDecoder {
    protected static final int ExtImageType_APNG = 2;
    protected static final int ExtImageType_GIF = 1;
    protected static final int ExtImageType_UNKNOWN = 0;
    private static final String TAG = "ExtImageDecoder";
    protected String path;
    protected int type;

    public ExtImageDecoder(int i3, String str) {
        this.type = i3;
        this.path = str;
    }

    public static ExtImageDecoder Create(int i3, String str) {
        LightLogUtil.e(TAG, "Create:" + i3 + "," + str);
        if (i3 != 2) {
            return null;
        }
        return new ExtDecoderApng(i3, str);
    }

    public abstract Bitmap decodeFrame(long j3);

    public abstract long[] getAllFrameDelay();

    public abstract void onRelease();
}
