package com.tencent.liteav.audio2;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final e f118863a;

    f(e eVar) {
        this.f118863a = eVar;
    }

    public static Runnable a(e eVar) {
        return new f(eVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a(this.f118863a);
    }
}
