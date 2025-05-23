package com.tencent.liteav.videobase.common;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final a f119287a = new a();

    a() {
    }

    public static Runnable a() {
        return f119287a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HDRCapability.checkIsHDR10Supported();
    }
}
