package com.tencent.mobileqq.flock.ktx;

import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"", "", "a", "qq-flock-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g {
    public static final boolean a(@Nullable String str) {
        boolean startsWith$default;
        if (str == null) {
            return false;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null);
        if (!startsWith$default) {
            return false;
        }
        return true;
    }
}
