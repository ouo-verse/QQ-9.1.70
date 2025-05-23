package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface HandlerWrapper {
    Looper getLooper();

    Message obtainMessage(int i3);

    Message obtainMessage(int i3, int i16, int i17);

    Message obtainMessage(int i3, int i16, int i17, Object obj);

    Message obtainMessage(int i3, Object obj);

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j3);

    void removeCallbacksAndMessages(Object obj);

    void removeMessages(int i3);

    boolean sendEmptyMessage(int i3);

    boolean sendEmptyMessageAtTime(int i3, long j3);
}
