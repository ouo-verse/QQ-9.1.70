package com.tencent.mobileqq.guild.base;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.mvvm.a;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class b<T extends com.tencent.mobileqq.mvvm.a> extends com.tencent.mobileqq.mvvm.c<T> {
    public cn<cf1.b> mToastEvent;

    public b(T t16) {
        super(t16);
        this.mToastEvent = new cn<>();
    }

    public cn<cf1.b> getToastLiveEvent() {
        return this.mToastEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> void updateValue(MutableLiveData<T> mutableLiveData, T t16) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            mutableLiveData.setValue(t16);
        } else {
            mutableLiveData.postValue(t16);
        }
    }
}
