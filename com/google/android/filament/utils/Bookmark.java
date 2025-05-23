package com.google.android.filament.utils;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Bookmark {

    /* renamed from: a, reason: collision with root package name */
    private long f33066a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bookmark(long j3) {
        this.f33066a = j3;
    }

    private static native void nDestroyBookmark(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a() {
        return this.f33066a;
    }

    protected void finalize() throws Throwable {
        nDestroyBookmark(this.f33066a);
        super.finalize();
    }
}
