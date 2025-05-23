package com.qzone.common.event;

/* compiled from: P */
/* loaded from: classes39.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private c f45872a;

    /* renamed from: b, reason: collision with root package name */
    private c f45873b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(c cVar) {
        try {
            if (cVar != null) {
                c cVar2 = this.f45873b;
                if (cVar2 != null) {
                    cVar2.f45871c = cVar;
                    this.f45873b = cVar;
                } else if (this.f45872a == null) {
                    this.f45873b = cVar;
                    this.f45872a = cVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th5) {
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized c b() {
        c cVar;
        cVar = this.f45872a;
        if (cVar != null) {
            c cVar2 = cVar.f45871c;
            this.f45872a = cVar2;
            if (cVar2 == null) {
                this.f45873b = null;
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized c c(int i3) throws InterruptedException {
        if (this.f45872a == null) {
            wait(i3);
        }
        return b();
    }
}
