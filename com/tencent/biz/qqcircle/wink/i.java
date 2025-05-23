package com.tencent.biz.qqcircle.wink;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"", "paramKey", "paramValue", "a", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class i {
    @NotNull
    public static final String a(@NotNull String str, @NotNull String paramKey, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(paramKey, "paramKey");
        return QQWinkSchemaParamsModifier.f93925a.b(str, paramKey, str2);
    }
}
