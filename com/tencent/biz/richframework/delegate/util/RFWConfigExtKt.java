package com.tencent.biz.richframework.delegate.util;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a8\u0006\u0004"}, d2 = {"isInnerVerOrRemoteCfgEnabled", "", "key", "", "richframeworkdelegate_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWConfigExtKt {
    public static final boolean isInnerVerOrRemoteCfgEnabled(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (RFWApplication.isPublicVersion() && !RFWConfig.getConfigValue(key, false)) {
            return false;
        }
        return true;
    }
}
