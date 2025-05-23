package com.tencent.liteav.videoproducer.capture.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final a f119635a;

    /* renamed from: b, reason: collision with root package name */
    private final int f119636b;

    b(a aVar, int i3) {
        this.f119635a = aVar;
        this.f119636b = i3;
    }

    public static Runnable a(a aVar, int i3) {
        return new b(aVar, i3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f119635a, this.f119636b);
    }
}
