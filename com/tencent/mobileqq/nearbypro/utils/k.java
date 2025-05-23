package com.tencent.mobileqq.nearbypro.utils;

import java.util.Objects;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k<T> extends e12.a<T> {
    public k(T t16) {
        super(t16);
    }

    @Override // e12.a, androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(T t16) {
        if (Objects.equals(t16, getValue())) {
            return;
        }
        super.postValue(t16);
    }

    @Override // e12.a, androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T t16) {
        if (Objects.equals(t16, getValue())) {
            return;
        }
        super.setValue(t16);
    }
}
