package com.tencent.now.app.common.widget.apng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class ArgumentsRunnable<T> implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<T> f337968d = null;

    private final synchronized List<T> e() {
        ArrayList<T> arrayList;
        arrayList = this.f337968d;
        this.f337968d = null;
        return arrayList;
    }

    public final synchronized void a(T... tArr) {
        boolean z16;
        if (this.f337968d == null) {
            this.f337968d = new ArrayList<>();
            z16 = false;
        } else {
            z16 = true;
        }
        Collections.addAll(this.f337968d, tArr);
        if (!z16) {
            g();
        }
    }

    protected abstract void f(List<T> list);

    protected abstract void g();

    @Override // java.lang.Runnable
    public final void run() {
        f(e());
    }
}
