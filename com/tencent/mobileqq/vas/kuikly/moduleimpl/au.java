package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"", "value", "", "a", "vas-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class au {
    public static final float a(@Nullable Object obj) {
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof Double) {
            return (float) ((Number) obj).doubleValue();
        }
        if (obj instanceof String) {
            return Float.parseFloat((String) obj);
        }
        if (obj instanceof Float) {
            return ((Number) obj).floatValue();
        }
        return 0.0f;
    }
}
