package com.tencent.mobileqq.guild.util;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class WeakObjectRunnable<T> implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<T> f235420d;

    protected abstract void a(@NonNull T t16);

    @Override // java.lang.Runnable
    public final void run() {
        T t16 = this.f235420d.get();
        if (t16 != null) {
            a(t16);
        }
    }
}
