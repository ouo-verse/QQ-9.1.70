package com.google.android.apps.internal.games.memoryadvice;

/* compiled from: P */
/* loaded from: classes2.dex */
class TryAllocTester {
    static {
        System.loadLibrary("try-alloc-lib");
    }

    TryAllocTester() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean tryAlloc(int i3);
}
