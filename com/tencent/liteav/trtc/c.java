package com.tencent.liteav.trtc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final TrtcCloudJni f119199a;

    c(TrtcCloudJni trtcCloudJni) {
        this.f119199a = trtcCloudJni;
    }

    public static Runnable a(TrtcCloudJni trtcCloudJni) {
        return new c(trtcCloudJni);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119199a.hideFloatingWindow();
    }
}
