package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes2.dex */
final class SystemHandlerWrapper implements HandlerWrapper {
    private final Handler handler;

    public SystemHandlerWrapper(Handler handler) {
        this.handler = handler;
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public Looper getLooper() {
        return this.handler.getLooper();
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public Message obtainMessage(int i3) {
        return this.handler.obtainMessage(i3);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean post(Runnable runnable) {
        return this.handler.post(runnable);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean postDelayed(Runnable runnable, long j3) {
        return this.handler.postDelayed(runnable, j3);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public void removeCallbacksAndMessages(Object obj) {
        this.handler.removeCallbacksAndMessages(obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public void removeMessages(int i3) {
        this.handler.removeMessages(i3);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessage(int i3) {
        return this.handler.sendEmptyMessage(i3);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessageAtTime(int i3, long j3) {
        return this.handler.sendEmptyMessageAtTime(i3, j3);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public Message obtainMessage(int i3, Object obj) {
        return this.handler.obtainMessage(i3, obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public Message obtainMessage(int i3, int i16, int i17) {
        return this.handler.obtainMessage(i3, i16, i17);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public Message obtainMessage(int i3, int i16, int i17, Object obj) {
        return this.handler.obtainMessage(i3, i16, i17, obj);
    }
}
