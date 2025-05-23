package com.tencent.filament.zplan;

import android.content.res.AssetManager;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004J\u0011\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0082 J\t\u0010\r\u001a\u00020\u0006H\u0082 J\u0011\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0082 J\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0082 J!\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0082 J\u001e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/FilamentDirectReadManager;", "", "()V", "TAG", "", "initAssetManager", "", "assetManager", "Landroid/content/res/AssetManager;", "initConfigCachePath", "configRootPath", "initUERootPath", "nInitAssetManager", "nRemoveAllPakGltfCache", "nSetConfigCachePath", "nSetConfigUERootPath", "nUpdatePakPathWithPakInfo", "pakPath", "gltfName", "pakUrl", "updatePakPathWithPakInfo", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentDirectReadManager {

    @NotNull
    public static final FilamentDirectReadManager INSTANCE;
    private static final String TAG = "FilamentDirectReadManager";

    static {
        FilamentDirectReadManager filamentDirectReadManager = new FilamentDirectReadManager();
        INSTANCE = filamentDirectReadManager;
        filamentDirectReadManager.nSetConfigUERootPath("main.obb.png");
    }

    FilamentDirectReadManager() {
    }

    private final native void nInitAssetManager(AssetManager assetManager);

    private final native void nRemoveAllPakGltfCache();

    private final native void nSetConfigCachePath(String configRootPath);

    private final native void nSetConfigUERootPath(String configRootPath);

    private final native void nUpdatePakPathWithPakInfo(String pakPath, String gltfName, String pakUrl);

    public final void initAssetManager(@NotNull AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        nInitAssetManager(assetManager);
    }

    public final void initConfigCachePath(@NotNull String configRootPath) {
        Intrinsics.checkNotNullParameter(configRootPath, "configRootPath");
        nSetConfigCachePath(configRootPath);
    }

    public final void initUERootPath(@NotNull String configRootPath) {
        Intrinsics.checkNotNullParameter(configRootPath, "configRootPath");
        nSetConfigUERootPath(configRootPath);
    }

    public final void updatePakPathWithPakInfo(@NotNull String pakPath, @NotNull String gltfName, @NotNull String pakUrl) {
        Intrinsics.checkNotNullParameter(pakPath, "pakPath");
        Intrinsics.checkNotNullParameter(gltfName, "gltfName");
        Intrinsics.checkNotNullParameter(pakUrl, "pakUrl");
        nUpdatePakPathWithPakInfo(pakPath, gltfName, pakUrl);
    }
}
