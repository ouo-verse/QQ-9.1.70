package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.adapter.image.decoder.AvifLibraryLoader;
import com.tencent.hippy.qq.api.IHippyAvifLibraryLoader;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyAvifLibraryLoaderImpl implements IHippyAvifLibraryLoader {
    @Override // com.tencent.hippy.qq.api.IHippyAvifLibraryLoader
    public boolean isLibReady() {
        return AvifLibraryLoader.isLibReady();
    }

    @Override // com.tencent.hippy.qq.api.IHippyAvifLibraryLoader
    public void loadLibrary() {
        AvifLibraryLoader.loadLibrary();
    }
}
