package com.tencent.qqnt.emotion.pic.libra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public abstract class ArgumentsRunnable<T> implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<T> f356315d = null;

    private synchronized List<T> e() {
        ArrayList<T> arrayList;
        arrayList = this.f356315d;
        this.f356315d = null;
        return arrayList;
    }

    public final synchronized void a(T... tArr) {
        boolean z16;
        if (this.f356315d == null) {
            this.f356315d = new ArrayList<>();
            z16 = false;
        } else {
            z16 = true;
        }
        Collections.addAll(this.f356315d, tArr);
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
