package com.tencent.richframework.delegate;

import com.tencent.mobileqq.rfw.common.api.a;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/richframework/delegate/RFWCommonConfigImpl;", "Lcom/tencent/mobileqq/rfw/common/api/a;", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getConfig", "", "", "updateConfig", "<init>", "()V", "qq-rfw-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RFWCommonConfigImpl implements a {
    @Override // com.tencent.mobileqq.rfw.common.api.a
    @NotNull
    public String getConfig(@NotNull String key, @NotNull String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String h16 = k.a().h(key, defaultValue);
        Intrinsics.checkNotNullExpressionValue(h16, "g().getString(key, defaultValue)");
        return h16;
    }

    @Override // com.tencent.mobileqq.rfw.common.api.a
    public void updateConfig(@NotNull String key, @NotNull Object defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (defaultValue instanceof Integer) {
            k.a().m(key, ((Number) defaultValue).intValue());
            return;
        }
        if (defaultValue instanceof Boolean) {
            k.a().j(key, ((Boolean) defaultValue).booleanValue());
            return;
        }
        if (defaultValue instanceof Float) {
            k.a().l(key, ((Number) defaultValue).floatValue());
            return;
        }
        if (defaultValue instanceof Long) {
            k.a().n(key, ((Number) defaultValue).longValue());
        } else if (defaultValue instanceof String) {
            k.a().p(key, (String) defaultValue);
        } else if (defaultValue instanceof byte[]) {
            k.a().k(key, (byte[]) defaultValue);
        }
    }
}
