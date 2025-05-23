package com.google.android.filament.gltfio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.filament.Engine;
import com.google.android.filament.EntityManager;
import java.nio.Buffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AssetLoader {
    private Engine mEngine;
    private MaterialProvider mMaterialCache;
    private long mNativeObject;

    public AssetLoader(@NonNull Engine engine, @NonNull MaterialProvider materialProvider, @NonNull EntityManager entityManager) {
        long nCreateAssetLoader = nCreateAssetLoader(engine.getNativeObject(), materialProvider, entityManager.getNativeObject());
        this.mNativeObject = nCreateAssetLoader;
        if (nCreateAssetLoader != 0) {
            this.mEngine = engine;
            this.mMaterialCache = materialProvider;
            return;
        }
        throw new IllegalStateException("Unable to parse glTF asset.");
    }

    private static native long nCreateAssetFromBinary(long j3, Buffer buffer, int i3);

    private static native long nCreateAssetFromJson(long j3, Buffer buffer, int i3);

    private static native long nCreateAssetLoader(long j3, Object obj, long j16);

    private static native long nCreateInstance(long j3, long j16);

    private static native long nCreateInstancedAsset(long j3, Buffer buffer, int i3, long[] jArr);

    private static native void nDestroyAsset(long j3, long j16);

    private static native void nDestroyAssetLoader(long j3);

    private static native void nEnableDiagnostics(long j3, boolean z16);

    @Nullable
    public FilamentAsset createAssetFromBinary(@NonNull Buffer buffer) {
        long nCreateAssetFromBinary = nCreateAssetFromBinary(this.mNativeObject, buffer, buffer.remaining());
        if (nCreateAssetFromBinary != 0) {
            return new FilamentAsset(this.mEngine, nCreateAssetFromBinary);
        }
        return null;
    }

    @Nullable
    public FilamentAsset createAssetFromJson(@NonNull Buffer buffer) {
        long nCreateAssetFromJson = nCreateAssetFromJson(this.mNativeObject, buffer, buffer.remaining());
        if (nCreateAssetFromJson != 0) {
            return new FilamentAsset(this.mEngine, nCreateAssetFromJson);
        }
        return null;
    }

    @Nullable
    public FilamentInstance createInstance(@NonNull FilamentAsset filamentAsset) {
        long nCreateInstance = nCreateInstance(this.mNativeObject, filamentAsset.getNativeObject());
        if (nCreateInstance == 0) {
            return null;
        }
        return new FilamentInstance(filamentAsset, nCreateInstance);
    }

    @Nullable
    public FilamentAsset createInstancedAsset(@NonNull Buffer buffer, @NonNull FilamentInstance[] filamentInstanceArr) {
        int length = filamentInstanceArr.length;
        long[] jArr = new long[length];
        long nCreateInstancedAsset = nCreateInstancedAsset(this.mNativeObject, buffer, buffer.remaining(), jArr);
        if (nCreateInstancedAsset == 0) {
            return null;
        }
        FilamentAsset filamentAsset = new FilamentAsset(this.mEngine, nCreateInstancedAsset);
        for (int i3 = 0; i3 < length; i3++) {
            filamentInstanceArr[i3] = new FilamentInstance(filamentAsset, jArr[i3]);
        }
        return filamentAsset;
    }

    public void destroy() {
        nDestroyAssetLoader(this.mNativeObject);
        this.mNativeObject = 0L;
    }

    public void destroyAsset(@NonNull FilamentAsset filamentAsset) {
        nDestroyAsset(this.mNativeObject, filamentAsset.getNativeObject());
        filamentAsset.clearNativeObject();
    }

    public void enableDiagnostics(boolean z16) {
        nEnableDiagnostics(this.mNativeObject, z16);
    }
}
