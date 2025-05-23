package com.tencent.mobileqq.guild.util;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes14.dex */
public class cn<T> extends MutableLiveData<T> {

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f235528d = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Observer<T> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Observer f235529d;

        a(Observer observer) {
            this.f235529d = observer;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable T t16) {
            if (cn.this.f235528d.compareAndSet(true, false)) {
                this.f235529d.onChanged(t16);
            }
        }
    }

    @MainThread
    public void d() {
        setValue(null);
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        super.observe(lifecycleOwner, new a(observer));
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    @MainThread
    public void setValue(@Nullable T t16) {
        this.f235528d.set(true);
        super.setValue(t16);
    }
}
