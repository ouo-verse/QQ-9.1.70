package com.tencent.kuikly.core.render.android.context;

import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import d01.v;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/d;", "Ldalvik/system/DexClassLoader;", "", "name", "", "resolve", "Ljava/lang/Class;", "loadClass", "", "a", "Ljava/util/List;", "hostClassNameList", "dexPath", "optimizedDirectory", "Ljava/lang/ClassLoader;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V", "c", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class d extends DexClassLoader {

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, d> f117527b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<String> hostClassNameList;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/d$a;", "", "", "c", "", "dexPath", "Ljava/io/File;", "b", "Ljava/lang/ClassLoader;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/kuikly/core/render/android/context/d;", "a", "d", "", "dexClassLoaders", "Ljava/util/Map;", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.context.d$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
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
                file.mkdir();
            }
            return file;
        }

        private final void c() {
            if (d.f117527b == null) {
                d.f117527b = new ConcurrentHashMap();
            }
        }

        @NotNull
        public final d a(@NotNull String dexPath, @NotNull ClassLoader parent) {
            d dVar;
            Intrinsics.checkNotNullParameter(dexPath, "dexPath");
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (v.f392616a.a()) {
                c();
                Map map = d.f117527b;
                if (map != null) {
                    dVar = (d) map.get(dexPath);
                } else {
                    dVar = null;
                }
                if (dVar == null) {
                    d d16 = d(dexPath, parent);
                    Map map2 = d.f117527b;
                    if (map2 != null) {
                        return d16;
                    }
                    return d16;
                }
                return dVar;
            }
            return d(dexPath, parent);
        }

        @NotNull
        public final d d(@NotNull String dexPath, @NotNull ClassLoader parent) {
            Intrinsics.checkNotNullParameter(dexPath, "dexPath");
            Intrinsics.checkNotNullParameter(parent, "parent");
            String absolutePath = b(dexPath).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "createDexOptimizedDirectory(dexPath).absolutePath");
            return new d(dexPath, absolutePath, parent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull String dexPath, @NotNull String optimizedDirectory, @NotNull ClassLoader parent) {
        super(dexPath, optimizedDirectory, null, parent);
        Intrinsics.checkNotNullParameter(dexPath, "dexPath");
        Intrinsics.checkNotNullParameter(optimizedDirectory, "optimizedDirectory");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.tencent.kuikly.core.IKuiklyCoreEntry");
        arrayList.add("com.tencent.kuikly.core.IKuiklyCoreEntry$Delegate");
        Unit unit = Unit.INSTANCE;
        this.hostClassNameList = arrayList;
    }

    @Override // java.lang.ClassLoader
    @NotNull
    protected Class<?> loadClass(@NotNull String name, boolean resolve) {
        Class<?> loadClass;
        Intrinsics.checkNotNullParameter(name, "name");
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
        Intrinsics.checkNotNullExpressionValue(loadClass2, "loadClass");
        return loadClass2;
    }
}
