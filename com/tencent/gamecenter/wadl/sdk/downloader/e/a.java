package com.tencent.gamecenter.wadl.sdk.downloader.e;

import java.util.concurrent.FutureTask;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a<T> extends FutureTask<T> implements Comparable<a<T>> {

    /* renamed from: a, reason: collision with root package name */
    private Object f107383a;

    public a(Runnable runnable, T t16) {
        super(runnable, t16);
        this.f107383a = runnable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a<T> aVar) {
        if (this == aVar) {
            return 0;
        }
        if (aVar == null) {
            return -1;
        }
        Object obj = this.f107383a;
        if (obj != null && aVar.f107383a != null && obj.getClass().equals(aVar.f107383a.getClass())) {
            Object obj2 = this.f107383a;
            if (obj2 instanceof Comparable) {
                return ((Comparable) obj2).compareTo(aVar.f107383a);
            }
        }
        return 0;
    }
}
