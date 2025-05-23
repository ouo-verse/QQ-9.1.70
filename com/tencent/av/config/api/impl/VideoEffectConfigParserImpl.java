package com.tencent.av.config.api.impl;

import android.os.Build;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.av.config.api.IVideoEffectConfigParser;
import com.tencent.avcore.util.ArrayUtils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes3.dex */
public class VideoEffectConfigParserImpl implements IVideoEffectConfigParser {
    private static final String KEY_ROOT = "sharp/video_effect/";
    private static final String KEY_TEST = "sharp/video_effect/test/";
    private static final String KEY_TEST_DISABLE_SDK = "sharp/video_effect/test/disable_sdk";
    private static final String KEY_TEST_FLAG = "sharp/video_effect/test/flag";
    private static final String KEY_TEST_MINSDK = "sharp/video_effect/test/min_sdk";
    private static final String STR_DISABLE_SDK = "disable_sdk";
    private static final String STR_FLAG = "flag";
    private static final String STR_MIN_SDK = "min_sdk";
    static final String TAG = "VideoEffectConfigParser";

    @Override // com.tencent.av.config.api.IVideoEffectConfigParser
    public int getVideoEffectTestFlag(IConfigParser iConfigParser) {
        int[] intValues;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getVideoEffectTestFlag sdk: " + Build.VERSION.SDK_INT);
        }
        try {
            int[] intValues2 = iConfigParser.getIntValues(KEY_TEST_FLAG);
            if (intValues2 != null && (intValues2[0] & 1) == 1 && (intValues = iConfigParser.getIntValues(KEY_TEST_MINSDK)) != null && (i3 = Build.VERSION.SDK_INT) >= intValues[0]) {
                if (ArrayUtils.contains(iConfigParser.getIntValues(KEY_TEST_DISABLE_SDK), i3)) {
                    return 0;
                }
                return 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }
}
