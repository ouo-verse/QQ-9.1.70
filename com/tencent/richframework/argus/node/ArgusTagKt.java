package com.tencent.richframework.argus.node;

import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\u001a\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000\"'\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000\u0012\u0004\u0012\u00020\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Ljava/lang/Class;", "clz", "Lcom/tencent/richframework/argus/node/ArgusTag;", "getAnnotationTag", "", "annotationCache", "Ljava/util/Map;", "getAnnotationCache", "()Ljava/util/Map;", "lifecycle_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ArgusTagKt {

    @NotNull
    private static final Map<Class<?>, ArgusTag> annotationCache;

    static {
        Map<Class<?>, ArgusTag> concurrentHashMap;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 != 24 && i3 != 25) {
            concurrentHashMap = new HashMap<>();
        } else {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        annotationCache = concurrentHashMap;
    }

    @Nullable
    public static final ArgusTag getAnnotationTag(@NotNull Class<?> clz) {
        Intrinsics.checkNotNullParameter(clz, "clz");
        Map<Class<?>, ArgusTag> map = annotationCache;
        ArgusTag argusTag = map.get(clz);
        if (argusTag == null && Intrinsics.areEqual(clz.getClassLoader(), ArgusTag.class.getClassLoader())) {
            argusTag = (ArgusTag) clz.getAnnotation(ArgusTag.class);
            if (argusTag != null) {
                map.put(clz, argusTag);
            } else {
                argusTag = null;
            }
        }
        if (argusTag == null && clz.getSuperclass() != null) {
            Class<? super Object> superclass = clz.getSuperclass();
            Intrinsics.checkNotNullExpressionValue(superclass, "clz.superclass");
            if (Intrinsics.areEqual(superclass.getClassLoader(), ArgusTag.class.getClassLoader())) {
                Class<? super Object> superclass2 = clz.getSuperclass();
                Intrinsics.checkNotNullExpressionValue(superclass2, "clz.superclass");
                return getAnnotationTag(superclass2);
            }
        }
        return argusTag;
    }
}
