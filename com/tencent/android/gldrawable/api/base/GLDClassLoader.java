package com.tencent.android.gldrawable.api.base;

import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.vivo.push.PushClientConstants;
import dalvik.system.DexClassLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/android/gldrawable/api/base/GLDClassLoader;", "Ldalvik/system/DexClassLoader;", "dexPath", "", "optimizedDirectory", "libraryPath", HippyNestedScrollComponent.PRIORITY_PARENT, "Ljava/lang/ClassLoader;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V", "loadClass", "Ljava/lang/Class;", PushClientConstants.TAG_CLASS_NAME, "resolve", "", "Companion", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class GLDClassLoader extends DexClassLoader {
    private static final String HOST_CLASS_START = "com.tencent.android.gldrawable.api.";
    private static final String KTX_CLASS_START = "kotlinx.";
    private static final String MY_CLASS_START = "com.tencent.android.gldrawable.";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GLDClassLoader(@NotNull String dexPath, @NotNull String optimizedDirectory, @Nullable String str, @NotNull ClassLoader parent) {
        super(dexPath, optimizedDirectory, str, parent);
        Intrinsics.checkNotNullParameter(dexPath, "dexPath");
        Intrinsics.checkNotNullParameter(optimizedDirectory, "optimizedDirectory");
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    @Override // java.lang.ClassLoader
    @NotNull
    protected Class<?> loadClass(@NotNull String className, boolean resolve) throws ClassNotFoundException {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        Intrinsics.checkNotNullParameter(className, "className");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(className, MY_CLASS_START, false, 2, null);
        if (!startsWith$default) {
            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(className, KTX_CLASS_START, false, 2, null);
            if (!startsWith$default3) {
                Class<?> loadClass = super.loadClass(className, resolve);
                Intrinsics.checkNotNullExpressionValue(loadClass, "super.loadClass(className, resolve)");
                return loadClass;
            }
        }
        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(className, HOST_CLASS_START, false, 2, null);
        if (startsWith$default2) {
            Class<?> loadClass2 = super.loadClass(className, resolve);
            Intrinsics.checkNotNullExpressionValue(loadClass2, "super.loadClass(className, resolve)");
            return loadClass2;
        }
        try {
            Class<?> findClass = findClass(className);
            Intrinsics.checkNotNullExpressionValue(findClass, "findClass(className)");
            return findClass;
        } catch (ClassNotFoundException unused) {
            Class<?> loadClass3 = super.loadClass(className, resolve);
            Intrinsics.checkNotNullExpressionValue(loadClass3, "super.loadClass(className, resolve)");
            return loadClass3;
        }
    }
}
