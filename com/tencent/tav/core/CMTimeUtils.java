package com.tencent.tav.core;

import com.tencent.tav.coremedia.CMTime;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CMTimeUtils {
    public static long CMTimeConvertToUs(CMTime cMTime) {
        return cMTime.getTimeSeconds() * 1000.0f * 1000.0f;
    }
}
