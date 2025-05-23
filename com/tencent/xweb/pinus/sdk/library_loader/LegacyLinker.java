package com.tencent.xweb.pinus.sdk.library_loader;

import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.pinus.sdk.library_loader.Linker;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LegacyLinker extends Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "LegacyLinker";

    private static native boolean nativeAddZipArchivePath(String str);

    private static native int nativeCreateMemoryFile(String str);

    private static native boolean nativeCreateSharedRelro(String str, long j3, Linker.LibInfo libInfo);

    private static native boolean nativeLoadLibrary(String str, long j3, Linker.LibInfo libInfo);

    private static native boolean nativeLoadLibraryByFd(String str, long j3, int i3, boolean z16);

    private static native boolean nativeUseSharedRelro(String str, Linker.LibInfo libInfo);

    private static void useSharedRelrosLocked(Linker.LibInfo libInfo) {
        String str = libInfo.mLibFilePath;
        if (!nativeUseSharedRelro(str, libInfo)) {
            x0.f(TAG, String.format("Could not use shared RELRO section for %s", str));
        } else {
            x0.d(TAG, String.format("Using shared RELRO section for %s", str));
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.library_loader.Linker
    public int createMemroyFile(String str) {
        ensureInitializedLocked();
        return nativeCreateMemoryFile(str);
    }

    @Override // com.tencent.xweb.pinus.sdk.library_loader.Linker
    public void loadLibraryByFdImplLocked(String str, boolean z16, int i3, boolean z17) {
        long j3;
        ensureInitializedLocked();
        if (z16) {
            j3 = this.mBaseLoadAddress;
        } else {
            j3 = 0;
        }
        if (nativeLoadLibraryByFd(str, j3, i3, z17)) {
            this.mState = 3;
            return;
        }
        String str2 = "Unable to load library: " + str;
        x0.c(TAG, str2);
        throw new UnsatisfiedLinkError(str2);
    }

    @Override // com.tencent.xweb.pinus.sdk.library_loader.Linker
    public void loadLibraryImplLocked(String str, boolean z16) {
        long j3;
        ensureInitializedLocked();
        boolean z17 = this.mInBrowserProcess;
        if (z16) {
            j3 = this.mBaseLoadAddress;
        } else {
            j3 = 0;
        }
        Linker.LibInfo libInfo = new Linker.LibInfo();
        if (nativeLoadLibrary(str, j3, libInfo)) {
            libInfo.mLibFilePath = str;
            if (z17) {
                if (!nativeCreateSharedRelro(str, this.mBaseLoadAddress, libInfo)) {
                    x0.f(TAG, String.format("Could not create shared RELRO for %s at %x", str, Long.valueOf(this.mBaseLoadAddress)));
                    libInfo.mRelroFd = -1;
                } else {
                    x0.d(TAG, String.format("Created shared RELRO for %s at %x: %s", str, Long.valueOf(this.mBaseLoadAddress), libInfo));
                }
                this.mLibInfo = libInfo;
                useSharedRelrosLocked(libInfo);
                this.mState = 2;
                return;
            }
            if (this.mWaitForSharedRelros) {
                waitForSharedRelrosLocked();
                useSharedRelrosLocked(this.mLibInfo);
                this.mLibInfo.close();
                this.mLibInfo = null;
                this.mState = 3;
                return;
            }
            this.mState = 3;
            return;
        }
        String str2 = "Unable to load library: " + str;
        x0.c(TAG, str2);
        throw new UnsatisfiedLinkError(str2);
    }

    @Override // com.tencent.xweb.pinus.sdk.library_loader.Linker
    public void setApkFilePath(String str) {
        synchronized (Linker.sLock) {
            ensureInitializedLocked();
            nativeAddZipArchivePath(str);
        }
    }
}
