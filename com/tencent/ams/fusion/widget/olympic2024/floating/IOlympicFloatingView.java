package com.tencent.ams.fusion.widget.olympic2024.floating;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IOlympicFloatingView {
    void foldIcon();

    void setBottomMargin(int i3);

    void setFloatingIconDisable(boolean z16);

    void setFloatingVideoClickArea(int i3, int i16, int i17, int i18);

    void setFloatingVideoClickDelay(int i3);

    void setIconPath(String str, String str2);

    void setListener(OlympicFloatingViewListener olympicFloatingViewListener);

    void setSecondViewBottomMargin(int i3);

    void setThirdViewBottomMargin(int i3);

    void setTotalDuration(long j3);

    void setVideoDuration(long j3);

    void setVideoPath(String str);

    void skipVideo();
}
