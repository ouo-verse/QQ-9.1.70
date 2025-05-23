package com.tencent.ams.fusion.widget.olympic2024;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface OlympicGalleryListener {
    void onEndCardAnimFinish();

    void onEndCardAnimStart();

    void onItemSwitch(int i3);

    void onVideoItemComplete(int i3);

    void onVideoItemError(int i3, int i16);

    void onVideoItemPause(int i3);

    void onVideoItemPlayUpdate(int i3, long j3);

    void onVideoItemResume(int i3);

    void onVideoItemStart(int i3, long j3);
}
