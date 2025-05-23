package com.tencent.rdelivery.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"", "extraStr", "a", "rdelivery_nonCommercialRelease"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class d {
    @Nullable
    public static final String a(@NotNull String getFinalTag, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(getFinalTag, "$this$getFinalTag");
        if (str != null) {
            return Intrinsics.stringPlus(getFinalTag, util.base64_pad_url + str);
        }
        return getFinalTag;
    }
}
