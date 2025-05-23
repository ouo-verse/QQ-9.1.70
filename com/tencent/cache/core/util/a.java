package com.tencent.cache.core.util;

import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a {
    public static final boolean a(@NotNull Object target) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (((target instanceof Collection) || (target instanceof Map)) && com.tencent.cache.core.manager.api.c.f98725d.d().y()) {
            return true;
        }
        return false;
    }
}
