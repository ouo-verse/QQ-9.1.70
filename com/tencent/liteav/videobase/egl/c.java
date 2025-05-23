package com.tencent.liteav.videobase.egl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final EGLCore f119333a;

    c(EGLCore eGLCore) {
        this.f119333a = eGLCore;
    }

    public static Runnable a(EGLCore eGLCore) {
        return new c(eGLCore);
    }

    @Override // java.lang.Runnable
    public final void run() {
        EGLCore.lambda$destroyAsync$0(this.f119333a);
    }
}
