package com.google.android.filament.gltfio;

import androidx.annotation.NonNull;
import com.google.android.filament.Engine;
import java.nio.Buffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ResourceLoader {
    private final long mNativeKtx2Provider;
    private final long mNativeObject;
    private final long mNativeStbProvider;

    public ResourceLoader(@NonNull Engine engine) {
        long nativeObject = engine.getNativeObject();
        long nCreateResourceLoader = nCreateResourceLoader(nativeObject, false, false, false);
        this.mNativeObject = nCreateResourceLoader;
        long nCreateStbProvider = nCreateStbProvider(nativeObject);
        this.mNativeStbProvider = nCreateStbProvider;
        long nCreateKtx2Provider = nCreateKtx2Provider(nativeObject);
        this.mNativeKtx2Provider = nCreateKtx2Provider;
        nAddTextureProvider(nCreateResourceLoader, "image/jpeg", nCreateStbProvider);
        nAddTextureProvider(nCreateResourceLoader, "image/png", nCreateStbProvider);
        nAddTextureProvider(nCreateResourceLoader, "image/ktx2", nCreateKtx2Provider);
    }

    private static native void nAddResourceData(long j3, String str, Buffer buffer, int i3);

    private static native void nAddTextureProvider(long j3, String str, long j16);

    private static native boolean nAsyncBeginLoad(long j3, long j16);

    private static native void nAsyncCancelLoad(long j3);

    private static native float nAsyncGetLoadProgress(long j3);

    private static native void nAsyncUpdateLoad(long j3);

    private static native long nCreateKtx2Provider(long j3);

    private static native long nCreateResourceLoader(long j3, boolean z16, boolean z17, boolean z18);

    private static native long nCreateStbProvider(long j3);

    private static native void nDestroyResourceLoader(long j3);

    private static native void nDestroyTextureProvider(long j3);

    private static native void nEvictResourceData(long j3);

    private static native boolean nHasResourceData(long j3, String str);

    private static native void nLoadResources(long j3, long j16);

    @NonNull
    public ResourceLoader addResourceData(@NonNull String str, @NonNull Buffer buffer) {
        nAddResourceData(this.mNativeObject, str, buffer, buffer.remaining());
        return this;
    }

    public boolean asyncBeginLoad(@NonNull FilamentAsset filamentAsset) {
        return nAsyncBeginLoad(this.mNativeObject, filamentAsset.getNativeObject());
    }

    public void asyncCancelLoad() {
        nAsyncCancelLoad(this.mNativeObject);
    }

    public float asyncGetLoadProgress() {
        return nAsyncGetLoadProgress(this.mNativeObject);
    }

    public void asyncUpdateLoad() {
        nAsyncUpdateLoad(this.mNativeObject);
    }

    public void destroy() {
        nDestroyResourceLoader(this.mNativeObject);
        nDestroyTextureProvider(this.mNativeStbProvider);
        nDestroyTextureProvider(this.mNativeKtx2Provider);
    }

    public void evictResourceData() {
        nEvictResourceData(this.mNativeObject);
    }

    public boolean hasResourceData(@NonNull String str) {
        return nHasResourceData(this.mNativeObject, str);
    }

    @NonNull
    public ResourceLoader loadResources(@NonNull FilamentAsset filamentAsset) {
        nLoadResources(this.mNativeObject, filamentAsset.getNativeObject());
        return this;
    }

    public ResourceLoader(@NonNull Engine engine, boolean z16, boolean z17, boolean z18) {
        long nativeObject = engine.getNativeObject();
        long nCreateResourceLoader = nCreateResourceLoader(nativeObject, z16, z17, z18);
        this.mNativeObject = nCreateResourceLoader;
        long nCreateStbProvider = nCreateStbProvider(nativeObject);
        this.mNativeStbProvider = nCreateStbProvider;
        long nCreateKtx2Provider = nCreateKtx2Provider(nativeObject);
        this.mNativeKtx2Provider = nCreateKtx2Provider;
        nAddTextureProvider(nCreateResourceLoader, "image/jpeg", nCreateStbProvider);
        nAddTextureProvider(nCreateResourceLoader, "image/png", nCreateStbProvider);
        nAddTextureProvider(nCreateResourceLoader, "image/ktx2", nCreateKtx2Provider);
    }
}
