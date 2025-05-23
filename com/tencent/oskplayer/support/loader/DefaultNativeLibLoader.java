package com.tencent.oskplayer.support.loader;

import com.tencent.oskplayer.support.loader.NativeLibLoader;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DefaultNativeLibLoader implements NativeLibLoader {
    @Override // com.tencent.oskplayer.support.loader.NativeLibLoader
    public NativeLibLoader.State isLibReadyToLoad(String str) {
        return NativeLibLoader.State.TRUE;
    }

    @Override // com.tencent.oskplayer.support.loader.NativeLibLoader
    public void loadLibrary(String str) throws UnsatisfiedLinkError, SecurityException {
        System.loadLibrary(str);
    }
}
