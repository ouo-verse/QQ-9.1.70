package com.tencent.qqmini.minigame.dynamic.context;

import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqmini/minigame/dynamic/context/DynamicDexClassLoader;", "Ldalvik/system/DexClassLoader;", "", "name", "", "resolve", "Ljava/lang/Class;", "loadClass", "", "hostClassNameList", "Ljava/util/List;", "dexPath", "optimizedDirectory", "nativeLibraryDir", "Ljava/lang/ClassLoader;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V", "Companion", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class DynamicDexClassLoader extends DexClassLoader {
    private static final String TAG = "DynamicCore_DexClassLoader";
    private final List<String> hostClassNameList;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ConcurrentHashMap<String, DynamicDexClassLoader> classLoaderMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqmini/minigame/dynamic/context/DynamicDexClassLoader$a;", "", "", "dexPath", "Ljava/io/File;", "b", "pluginName", "Ljava/lang/ClassLoader;", HippyNestedScrollComponent.PRIORITY_PARENT, "nativeLibraryDir", "Lcom/tencent/qqmini/minigame/dynamic/context/DynamicDexClassLoader;", "a", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "classLoaderMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qqmini.minigame.dynamic.context.DynamicDexClassLoader$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        private final File b(String dexPath) {
            File parentFile = new File(dexPath).getParentFile();
            if (parentFile == null) {
                parentFile = new File(dexPath);
            }
            File file = new File(parentFile.getAbsolutePath() + "/odex");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        @NotNull
        public final DynamicDexClassLoader a(@NotNull String dexPath, @NotNull String pluginName, @NotNull ClassLoader parent, @NotNull String nativeLibraryDir) {
            Intrinsics.checkParameterIsNotNull(dexPath, "dexPath");
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(parent, "parent");
            Intrinsics.checkParameterIsNotNull(nativeLibraryDir, "nativeLibraryDir");
            DynamicDexClassLoader dynamicDexClassLoader = (DynamicDexClassLoader) DynamicDexClassLoader.classLoaderMap.get(pluginName);
            if (dynamicDexClassLoader == null) {
                QMLog.i(DynamicDexClassLoader.TAG, "create classLoader:" + dexPath);
                String absolutePath = b(dexPath).getAbsolutePath();
                Intrinsics.checkExpressionValueIsNotNull(absolutePath, "createDexOptimizedDirectory(dexPath).absolutePath");
                DynamicDexClassLoader dynamicDexClassLoader2 = new DynamicDexClassLoader(dexPath, absolutePath, nativeLibraryDir, parent);
                DynamicDexClassLoader.classLoaderMap.put(pluginName, dynamicDexClassLoader2);
                return dynamicDexClassLoader2;
            }
            return dynamicDexClassLoader;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicDexClassLoader(@NotNull String dexPath, @NotNull String optimizedDirectory, @NotNull String nativeLibraryDir, @NotNull ClassLoader parent) {
        super(dexPath, optimizedDirectory, nativeLibraryDir, parent);
        List<String> mutableListOf;
        Intrinsics.checkParameterIsNotNull(dexPath, "dexPath");
        Intrinsics.checkParameterIsNotNull(optimizedDirectory, "optimizedDirectory");
        Intrinsics.checkParameterIsNotNull(nativeLibraryDir, "nativeLibraryDir");
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("com.tencent.qqmini.minigame.dynamic.IDynamicEntry", "com.tencent.qqmini.minigame.dynamic.IDynamicEntry$Delegate");
        this.hostClassNameList = mutableListOf;
    }

    @Override // java.lang.ClassLoader
    @NotNull
    protected Class<?> loadClass(@NotNull String name, boolean resolve) {
        Class<?> loadClass;
        Intrinsics.checkParameterIsNotNull(name, "name");
        Class<?> loadClass2 = findLoadedClass(name);
        if (loadClass2 == null) {
            if (this.hostClassNameList.contains(name)) {
                loadClass = getParent().loadClass(name);
            } else {
                try {
                    loadClass = findClass(name);
                } catch (Throwable unused) {
                    loadClass = getParent().loadClass(name);
                }
            }
            loadClass2 = loadClass;
        }
        if (resolve) {
            resolveClass(loadClass2);
        }
        Intrinsics.checkExpressionValueIsNotNull(loadClass2, "loadClass");
        return loadClass2;
    }
}
