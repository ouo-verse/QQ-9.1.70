package com.tencent.mobileqq.qqexpand.bean.common;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes16.dex */
public class GenericSerializable<T> implements Serializable {
    private T serializable;

    public T get() {
        return this.serializable;
    }

    public void set(T t16) {
        this.serializable = t16;
    }
}
