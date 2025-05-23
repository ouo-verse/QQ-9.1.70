package com.tenpay.sdk.net.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tenpay/sdk/net/utils/PayNetMockUtil;", "", "()V", "TAG", "", "tryMockCgiData", "Lorg/json/JSONObject;", "url", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayNetMockUtil {

    @NotNull
    public static final PayNetMockUtil INSTANCE = new PayNetMockUtil();

    @NotNull
    private static final String TAG = "QWalletHttp-PayNetMockUtil";

    PayNetMockUtil() {
    }

    @Nullable
    public final JSONObject tryMockCgiData(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return null;
    }
}
