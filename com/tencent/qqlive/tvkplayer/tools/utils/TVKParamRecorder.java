package com.tencent.qqlive.tvkplayer.tools.utils;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes23.dex */
public class TVKParamRecorder<T> {
    private final AtomicBoolean isRecorded = new AtomicBoolean(false);
    private T mValue;

    public TVKParamRecorder(T t16) {
        this.mValue = t16;
    }

    public void finalize(T t16) {
        if (this.isRecorded.compareAndSet(false, true)) {
            this.mValue = t16;
        }
    }

    public T get() {
        return this.mValue;
    }
}
