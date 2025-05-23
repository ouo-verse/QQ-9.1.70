package com.tencent.qqmini.minigame.manager;

import android.content.Context;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0007R8\u0010\u000e\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010\f0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\rR\u001b\u0010\u0012\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqmini/minigame/manager/EnginePackageUtil;", "", "Ljava/io/File;", "enginePackageDir", "", "e", "f", "Lju3/a;", "a", "", "", "kotlin.jvm.PlatformType", "", "Ljava/util/List;", "JSLIB_FILES", "b", "Lkotlin/Lazy;", "()Ljava/lang/String;", "sAssetJsLibPath", "c", "()Ljava/io/File;", "sEnginePackageCacheDir", "d", "sEnginePackageRootDir", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class EnginePackageUtil {

    /* renamed from: e, reason: collision with root package name */
    public static final EnginePackageUtil f346509e = new EnginePackageUtil();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final List<String> JSLIB_FILES = BaseLibManager.miniGameBaseLibFiles;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sAssetJsLibPath = LazyKt.lazy(new Function0<String>() { // from class: com.tencent.qqmini.minigame.manager.EnginePackageUtil$sAssetJsLibPath$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            return "assets://mini";
        }
    });

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sEnginePackageCacheDir = LazyKt.lazy(new Function0<File>() { // from class: com.tencent.qqmini.minigame.manager.EnginePackageUtil$sEnginePackageCacheDir$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final File invoke() {
            AppLoaderFactory g16 = AppLoaderFactory.g();
            Intrinsics.checkExpressionValueIsNotNull(g16, "AppLoaderFactory.g()");
            Context context = g16.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "AppLoaderFactory.g().context");
            return new File(context.getCacheDir(), "minigame");
        }
    });

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sEnginePackageRootDir = LazyKt.lazy(new Function0<File>() { // from class: com.tencent.qqmini.minigame.manager.EnginePackageUtil$sEnginePackageRootDir$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final File invoke() {
            AppLoaderFactory g16 = AppLoaderFactory.g();
            Intrinsics.checkExpressionValueIsNotNull(g16, "AppLoaderFactory.g()");
            Context context = g16.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "AppLoaderFactory.g().context");
            return new File(context.getFilesDir(), "mini/.baseLib/minigame");
        }
    });

    EnginePackageUtil() {
    }

    @Nullable
    public final ju3.a a() {
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        if (wnsConfigProxy != null) {
            return ju3.a.INSTANCE.a(wnsConfigProxy.getMiniGameEnginePackageConfig());
        }
        return null;
    }

    @NotNull
    public final String b() {
        return (String) sAssetJsLibPath.getValue();
    }

    @NotNull
    public final File c() {
        return (File) sEnginePackageCacheDir.getValue();
    }

    @NotNull
    public final File d() {
        return (File) sEnginePackageRootDir.getValue();
    }

    public final boolean e(@NotNull File enginePackageDir) {
        Intrinsics.checkParameterIsNotNull(enginePackageDir, "enginePackageDir");
        Iterator<String> it = JSLIB_FILES.iterator();
        while (it.hasNext()) {
            if (!new File(enginePackageDir, it.next()).exists()) {
                return false;
            }
        }
        return true;
    }

    public final boolean f(@NotNull File enginePackageDir) {
        Intrinsics.checkParameterIsNotNull(enginePackageDir, "enginePackageDir");
        return new File(enginePackageDir, "libtriton.so").exists();
    }
}
