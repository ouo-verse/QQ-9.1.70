package com.tencent.ecommerce.base.router.api;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&J(\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/base/router/api/IECScheme;", "", "handleCommonPage", "", "target", "data", "", "", "handleOtherScheme", "url", "handleWebScheme", "userData", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECScheme {
    int handleCommonPage(int target, @NotNull Map<String, String> data);

    int handleOtherScheme(@Nullable String url);

    int handleWebScheme(@Nullable String url, @Nullable Map<String, String> userData);
}
