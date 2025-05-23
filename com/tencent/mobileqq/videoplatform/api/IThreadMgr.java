package com.tencent.mobileqq.videoplatform.api;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IThreadMgr {
    void postOnSubThread(Runnable runnable);

    void postOnSubThreadDelayed(Runnable runnable, long j3);

    void postOnUIThread(Runnable runnable);

    void postOnUIThreadDelayed(Runnable runnable, long j3);

    void quitSubThread();

    void removeCallbackOnSubHandler(Runnable runnable);

    void removeCallbackOnUIHandler(Runnable runnable);
}
