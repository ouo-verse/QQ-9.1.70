package com.tencent.qqlive.tvkplayer.logo.manager;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKLogoCommonDefine;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKLogoMgr {
    boolean draw();

    boolean isLogoEnabled();

    void reset();

    void resetStartTime();

    void setDynamicLogoOpen(boolean z16);

    void setStaticLogoOpen(boolean z16);

    void setVideoSize(int i3, int i16);

    void setXYAxis(int i3);

    void updateLogoInfo(@NonNull TVKLogoCommonDefine.TVKOriginalLogoInfo tVKOriginalLogoInfo);

    void updatePlayerPositionMs(long j3);
}
