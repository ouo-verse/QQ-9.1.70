package com.tencent.qqlive.tvkplayer.logo.impl;

import com.tencent.qqlive.tvkplayer.logo.impl.TVKLogoCommonDefine;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKLogoImpl {
    boolean draw();

    int getCurrentLogoType();

    void release();

    void resetStartTime();

    void setVideoSize(int i3, int i16);

    void setXYaxis(int i3);

    void updateLogoInfo(TVKLogoCommonDefine.TVKOriginalLogoInfo tVKOriginalLogoInfo);

    void updatePlayerPositionMs(long j3);
}
