package com.tribe.async.reactive;

/* loaded from: classes27.dex */
public abstract class DataPusher<T> implements AsyncFunction<Observer<T>> {
    public abstract void cancel();
}
