package com.tencent.state.square;

import android.app.Application;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.square.cache.DiskLruCache;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010 \u001a\u00020!J\u0012\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\u001fH\u0002J\u000e\u0010$\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/square/SquareBase;", "", "()V", "MAX_CACHE_COUNT", "", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "avatarCacheDir", "Ljava/io/File;", "getAvatarCacheDir", "()Ljava/io/File;", "setAvatarCacheDir", "(Ljava/io/File;)V", "avatarDefaultDir", "getAvatarDefaultDir", "setAvatarDefaultDir", "avatarDiskCache", "Lcom/tencent/state/square/cache/DiskLruCache;", "getAvatarDiskCache", "()Lcom/tencent/state/square/cache/DiskLruCache;", "avatarDiskCache$delegate", "Lkotlin/Lazy;", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/SquareConfig;", "getConfig", "()Lcom/tencent/state/square/SquareConfig;", "setConfig", "(Lcom/tencent/state/square/SquareConfig;)V", "isInitialized", "", "cleanup", "", "getAvatarRootDir", "isDefault", "initialize", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class SquareBase {

    @NotNull
    public static final SquareBase INSTANCE;
    private static final int MAX_CACHE_COUNT = 200;

    @NotNull
    private static File avatarCacheDir;

    @NotNull
    private static File avatarDefaultDir;

    /* renamed from: avatarDiskCache$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy avatarDiskCache;

    @NotNull
    private static SquareConfig config;
    private static boolean isInitialized;

    static {
        Lazy lazy;
        SquareBase squareBase = new SquareBase();
        INSTANCE = squareBase;
        config = new SquareConfig(false, new File("", "square"), false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, 2097149, null);
        avatarDefaultDir = squareBase.getAvatarRootDir(true);
        avatarCacheDir = squareBase.getAvatarRootDir(false);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DiskLruCache>() { // from class: com.tencent.state.square.SquareBase$avatarDiskCache$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DiskLruCache invoke() {
                File avatarRootDir;
                File avatarRootDir2;
                SquareBase squareBase2 = SquareBase.INSTANCE;
                avatarRootDir = squareBase2.getAvatarRootDir(false);
                avatarRootDir2 = squareBase2.getAvatarRootDir(true);
                return new DiskLruCache(avatarRootDir, 200, avatarRootDir2);
            }
        });
        avatarDiskCache = lazy;
    }

    SquareBase() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getAvatarRootDir(boolean isDefault) {
        String str;
        File rootCacheDir = config.getRootCacheDir();
        if (isDefault) {
            str = "avatar_defaults";
        } else {
            str = "avatar_caches";
        }
        return new File(rootCacheDir, str);
    }

    static /* synthetic */ File getAvatarRootDir$default(SquareBase squareBase, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return squareBase.getAvatarRootDir(z16);
    }

    public final void cleanup() {
        isInitialized = false;
    }

    @Nullable
    public final Application getApp() {
        return config.getCommonUtils().getApplication();
    }

    @NotNull
    public final File getAvatarCacheDir() {
        return avatarCacheDir;
    }

    @NotNull
    public final File getAvatarDefaultDir() {
        return avatarDefaultDir;
    }

    @NotNull
    public final DiskLruCache getAvatarDiskCache() {
        return (DiskLruCache) avatarDiskCache.getValue();
    }

    @NotNull
    public final SquareConfig getConfig() {
        return config;
    }

    public final void initialize(@NotNull SquareConfig config2) {
        Intrinsics.checkNotNullParameter(config2, "config");
        if (isInitialized) {
            return;
        }
        config = config2;
        isInitialized = true;
        avatarDefaultDir = getAvatarRootDir(true);
        avatarCacheDir = getAvatarRootDir(false);
        getAvatarDiskCache().build();
    }

    public final void setAvatarCacheDir(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<set-?>");
        avatarCacheDir = file;
    }

    public final void setAvatarDefaultDir(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<set-?>");
        avatarDefaultDir = file;
    }

    public final void setConfig(@NotNull SquareConfig squareConfig) {
        Intrinsics.checkNotNullParameter(squareConfig, "<set-?>");
        config = squareConfig;
    }
}
