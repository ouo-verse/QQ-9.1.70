package com.qq.e.comm.plugin.i.core;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected com.qq.e.comm.plugin.i.b f39469a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.qq.e.comm.plugin.i.b bVar) {
        this.f39469a = bVar;
    }

    protected abstract void a();

    protected abstract boolean a(com.qq.e.comm.plugin.i.b bVar);

    @Override // java.lang.Runnable
    public void run() {
        if (a(this.f39469a)) {
            a();
        }
    }
}
