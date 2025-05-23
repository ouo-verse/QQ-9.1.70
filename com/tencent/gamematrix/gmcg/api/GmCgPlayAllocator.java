package com.tencent.gamematrix.gmcg.api;

/* loaded from: classes6.dex */
public interface GmCgPlayAllocator {
    void cancelQueue();

    void pauseQueue();

    void restartAllocate(int i3, String str);

    void resumeQueue();

    void setAuthRefreshListener(GmCgAuthRefreshListener gmCgAuthRefreshListener);

    void setPlayAllocatorListener(GmCgPlayAllocatorListener gmCgPlayAllocatorListener);

    void setPlayDetectorListener(GmCgPlayDetectorListener gmCgPlayDetectorListener);

    void startAllocate();

    void stopAllocate(boolean z16);
}
