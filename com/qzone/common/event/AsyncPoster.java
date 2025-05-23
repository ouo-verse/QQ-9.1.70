package com.qzone.common.event;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes39.dex */
public class AsyncPoster implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final d f45845d = new d();

    /* renamed from: e, reason: collision with root package name */
    private final EventCenter f45846e;

    /* renamed from: f, reason: collision with root package name */
    private IThreadPool f45847f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncPoster(EventCenter eventCenter, IThreadPool iThreadPool) {
        this.f45846e = eventCenter;
        this.f45847f = iThreadPool;
    }

    public void a(b bVar, Object obj) {
        this.f45845d.a(c.a(bVar, obj));
        this.f45847f.submit(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        c b16 = this.f45845d.b();
        if (b16 != null) {
            this.f45846e.invokeObserver(b16);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
