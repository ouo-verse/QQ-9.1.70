package com.tencent.minibox.loader.core;

import android.content.Context;
import com.tencent.minibox.common.log.LogUtils;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/minibox/loader/core/e;", "", "Landroid/content/Context;", "context", "", "b", "", PushClientConstants.TAG_CLASS_NAME, "Ljava/lang/Class;", "a", "Ljava/lang/ClassLoader;", "Ljava/lang/ClassLoader;", "mClassLoader", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static volatile ClassLoader mClassLoader;

    /* renamed from: b, reason: collision with root package name */
    public static final e f151663b = new e();

    e() {
    }

    @NotNull
    public final Class<?> a(@NotNull String className) {
        Intrinsics.checkParameterIsNotNull(className, "className");
        if (mClassLoader != null) {
            ClassLoader classLoader = mClassLoader;
            if (classLoader == null) {
                Intrinsics.throwNpe();
            }
            Class<?> loadClass = classLoader.loadClass(className);
            Intrinsics.checkExpressionValueIsNotNull(loadClass, "mClassLoader!!.loadClass(className)");
            return loadClass;
        }
        LogUtils.e("PluginDexLoader", "findClass: classLoader is null!");
        throw new IllegalStateException("ClassLoader is not ready");
    }

    public final void b(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (mClassLoader != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        mClassLoader = b.b(context);
        LogUtils.i("PluginDexLoader", "init succeed, cost = " + (System.currentTimeMillis() - currentTimeMillis));
    }
}
