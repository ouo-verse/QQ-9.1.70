package com.tencent.qqlive.tvkplayer.tools.utils;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKObjectHolder<T> {
    private volatile T mObject;

    public TVKObjectHolder(T t16) {
        this.mObject = t16;
    }

    public T getObject() {
        return this.mObject;
    }

    @NonNull
    public String toString() {
        return "" + this.mObject;
    }

    public void updateObject(T t16) {
        this.mObject = t16;
    }
}
