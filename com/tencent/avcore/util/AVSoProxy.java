package com.tencent.avcore.util;

import android.content.Context;

/* loaded from: classes3.dex */
public interface AVSoProxy {
    String getAVAILibDir();

    String getAVMediaEngineSoDir();

    String getAVTraeSoDir();

    String getAndroidCodecInfo();

    Context getContext();

    String getHardwareDetectSoDir();

    String getHevcDecSoDir();

    String getHevcEncSoDir();

    int getScreenShareDecLevel();

    int getScreenShareEncLevel();

    String getVideoSRSoDir();

    void updateHevcCodecSoDir();
}
