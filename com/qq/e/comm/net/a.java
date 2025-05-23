package com.qq.e.comm.net;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a<T> extends FutureTask<T> implements Comparable<a<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final int f38295a;

    public a(Callable<T> callable, int i3) {
        super(callable);
        this.f38295a = i3;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        a aVar = (a) obj;
        if (aVar == null) {
            return 1;
        }
        return this.f38295a - aVar.f38295a;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
