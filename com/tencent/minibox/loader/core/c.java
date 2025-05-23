package com.tencent.minibox.loader.core;

import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.vivo.push.PushClientConstants;
import dalvik.system.DexClassLoader;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0016\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0014R\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/minibox/loader/core/c;", "Ldalvik/system/DexClassLoader;", "", PushClientConstants.TAG_CLASS_NAME, "", "resolve", "Ljava/lang/Class;", "loadClass", "name", "findClass", "Ljava/lang/ClassLoader;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ClassLoader;", "mGrandParent", "", "b", "Ljava/util/List;", "hostWhitelist", "dexPath", "optimizedDirectory", "librarySearchPath", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/util/List;)V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class c extends DexClassLoader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ClassLoader mGrandParent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<String> hostWhitelist;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull String dexPath, @NotNull String optimizedDirectory, @NotNull String librarySearchPath, @NotNull ClassLoader parent, @NotNull List<String> hostWhitelist) {
        super(dexPath, optimizedDirectory, librarySearchPath, parent);
        Intrinsics.checkParameterIsNotNull(dexPath, "dexPath");
        Intrinsics.checkParameterIsNotNull(optimizedDirectory, "optimizedDirectory");
        Intrinsics.checkParameterIsNotNull(librarySearchPath, "librarySearchPath");
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        Intrinsics.checkParameterIsNotNull(hostWhitelist, "hostWhitelist");
        this.hostWhitelist = hostWhitelist;
        this.mGrandParent = parent.getParent();
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    @NotNull
    protected Class<?> findClass(@Nullable String name) {
        Class<?> findClass = super.findClass(name);
        Intrinsics.checkExpressionValueIsNotNull(findClass, "super.findClass(name)");
        return findClass;
    }

    @Override // java.lang.ClassLoader
    @NotNull
    protected Class<?> loadClass(@Nullable String className, boolean resolve) {
        boolean z16;
        boolean startsWith$default;
        ClassNotFoundException e16 = null;
        if (className != null) {
            Iterator<String> it = this.hostWhitelist.iterator();
            while (it.hasNext()) {
                z16 = false;
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(className, it.next(), false, 2, null);
                if (startsWith$default) {
                    break;
                }
            }
        }
        z16 = true;
        if (z16) {
            Class<?> clazz = findLoadedClass(className);
            if (clazz == null) {
                try {
                    clazz = findClass(className);
                } catch (ClassNotFoundException e17) {
                    e16 = e17;
                }
                if (clazz == null) {
                    try {
                        clazz = this.mGrandParent.loadClass(className);
                    } catch (ClassNotFoundException e18) {
                        e18.addSuppressed(e16);
                        throw e18;
                    }
                }
            }
            Intrinsics.checkExpressionValueIsNotNull(clazz, "clazz");
            return clazz;
        }
        Class<?> loadClass = super.loadClass(className, resolve);
        Intrinsics.checkExpressionValueIsNotNull(loadClass, "super.loadClass(className, resolve)");
        return loadClass;
    }
}
