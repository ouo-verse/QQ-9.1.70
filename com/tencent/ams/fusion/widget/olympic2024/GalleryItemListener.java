package com.tencent.ams.fusion.widget.olympic2024;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface GalleryItemListener {
    public static final int VIDEO_ITEM_SRC_NOT_READY = -100;

    void afterItemSwitch(int i3, boolean z16);

    void beforeItemSwitch(int i3, boolean z16);

    void onEndAnimationFinish();

    void onEndAnimationStart();

    void onItemSwitch(int i3);

    void onVideoItemComplete(int i3);

    void onVideoItemError(int i3, int i16);

    void onVideoItemPause(int i3);

    void onVideoItemPlayUpdate(int i3, long j3);

    void onVideoItemResume(int i3);

    void onVideoItemStart(int i3, long j3);
}
