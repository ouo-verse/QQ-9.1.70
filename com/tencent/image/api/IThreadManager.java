package com.tencent.image.api;

import android.os.HandlerThread;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IThreadManager {
    void executeOnFileThreadExcutor(Runnable runnable, IThreadListener iThreadListener, boolean z16);

    void executeOnNetThreadExcutor(Runnable runnable, IThreadListener iThreadListener, boolean z16);

    HandlerThread getFileThread();

    HandlerThread getSubThread();
}
