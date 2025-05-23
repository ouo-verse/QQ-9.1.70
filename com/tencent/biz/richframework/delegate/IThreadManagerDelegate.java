package com.tencent.biz.richframework.delegate;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IThreadManagerDelegate {
    void execute(Runnable runnable, int i3);

    Looper getAliveLooper();

    int getDBType();

    int getFileType();

    int getNetWorkType();

    int getNormalType();
}
