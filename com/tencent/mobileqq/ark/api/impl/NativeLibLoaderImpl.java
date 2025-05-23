package com.tencent.mobileqq.ark.api.impl;

import android.content.Context;
import com.tencent.mobileqq.ark.api.INativeLibLoader;
import com.tencent.mobileqq.ark.core.f;
import com.tencent.mobileqq.ark.util.NativeLibLoader;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NativeLibLoaderImpl implements INativeLibLoader {
    @Override // com.tencent.mobileqq.ark.api.INativeLibLoader
    public void extractArkLibrary() {
        NativeLibLoader.d(BaseApplication.getContext(), "ark", false);
    }

    @Override // com.tencent.mobileqq.ark.api.INativeLibLoader
    public void extractPNGLibrary() {
        NativeLibLoader.c(BaseApplication.getContext(), "png-arm64-v8a");
    }

    @Override // com.tencent.mobileqq.ark.api.INativeLibLoader
    public void extractWordSegmentLibrary() {
        NativeLibLoader.d(BaseApplication.getContext(), "WordSegment", false);
    }

    @Override // com.tencent.mobileqq.ark.api.INativeLibLoader
    public boolean isArkLibraryLoaded() {
        return f.f199344b;
    }

    @Override // com.tencent.mobileqq.ark.api.INativeLibLoader
    public void loadArkLibrary() {
        f.l();
    }

    @Override // com.tencent.mobileqq.ark.api.INativeLibLoader
    public boolean loadPNGLibrary(Context context) {
        return NativeLibLoader.a(context, NativeLibLoader.g());
    }
}
