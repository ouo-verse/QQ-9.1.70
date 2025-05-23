package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AudioResample {
    static {
        boolean isVideoSoLibLoaded = ShortVideoUtils.isVideoSoLibLoaded();
        QLog.i("SegmentClipUtils", 2, "LoadExtractedShortVideoSo:loaded=" + isVideoSoLibLoaded);
        if (!isVideoSoLibLoaded) {
            VideoEnvironment.loadAVCodecSo();
            boolean isVideoSoLibLoaded2 = ShortVideoUtils.isVideoSoLibLoaded();
            if (QLog.isColorLevel()) {
                QLog.i("SegmentClipUtils", 2, "LoadExtractedShortVideoSo:loaded=" + isVideoSoLibLoaded2);
            }
        }
    }

    public static native int nativeResample(int i3, int i16, byte[] bArr, int i17, byte[] bArr2, int i18, int i19);

    public static native int parseMp4Info(String str);
}
