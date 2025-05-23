package com.tencent.component.callback;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface ITimedCallback<T> {
    void fail(int i3, String str);

    void success(T t16);

    void timeOut();
}
