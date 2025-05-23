package com.tencent.mobileqq.shortvideo.mediacodec;

import android.content.Context;
import com.tencent.av.mediacodec.DeviceCheck;
import com.tencent.avcore.jni.codec.AndroidCodec;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShortVideoCodec extends AndroidCodec {
    public static String TAG = "ShortVideoCodec";
    public static int mMediaCodecFeature = -1;

    public static int checkSupportMediaCodecFeature(Context context) {
        int i3 = mMediaCodecFeature;
        if (i3 >= 0) {
            return i3;
        }
        mMediaCodecFeature = 0;
        if (context == null) {
            return 0;
        }
        AndroidCodec.invoke21Apis();
        if (!AndroidCodec.fInvokeAPILevel21) {
            mMediaCodecFeature = 0;
            return 0;
        }
        if (DeviceCheck.g()) {
            mMediaCodecFeature = 1;
        }
        if (DeviceCheck.i()) {
            mMediaCodecFeature += 2;
        }
        return mMediaCodecFeature;
    }
}
