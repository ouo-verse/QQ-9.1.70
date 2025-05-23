package com.tencent.minibox.common.exception;

import com.huawei.hms.framework.common.ContainerUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/minibox/common/exception/d;", "", "", "key", "value", "a", "b", "Ljava/lang/StringBuilder;", "Ljava/lang/StringBuilder;", "urlStrBuilder", "<init>", "()V", "MiniBoxCommon_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final StringBuilder urlStrBuilder = new StringBuilder("https://h.trace.qq.com/kv?");

    @NotNull
    public final d a(@NotNull String key, @Nullable String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        StringBuilder sb5 = this.urlStrBuilder;
        sb5.append(key);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (value == null) {
            value = "";
        }
        sb5.append(value);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        return this;
    }

    @NotNull
    public final String b() {
        String sb5 = this.urlStrBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb5, "urlStrBuilder.toString()");
        return sb5;
    }
}
