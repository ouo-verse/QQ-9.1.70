package com.google.android.exoplayer2.util;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class LibraryLoader {
    private boolean isAvailable;
    private boolean loadAttempted;
    private String[] nativeLibraries;

    public LibraryLoader(String... strArr) {
        this.nativeLibraries = strArr;
    }

    public synchronized boolean isAvailable() {
        if (this.loadAttempted) {
            return this.isAvailable;
        }
        this.loadAttempted = true;
        try {
            for (String str : this.nativeLibraries) {
                System.loadLibrary(str);
            }
            this.isAvailable = true;
        } catch (UnsatisfiedLinkError e16) {
            Log.w(LibraryLoader.class.getSimpleName(), "loadLibrary failed with exception " + e16.toString());
        }
        return this.isAvailable;
    }

    public synchronized void setLibraries(String... strArr) {
        boolean z16;
        if (!this.loadAttempted) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16, "Cannot set libraries after loading");
        this.nativeLibraries = strArr;
    }
}
