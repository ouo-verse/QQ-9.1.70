package com.tenpay.sdk.net.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/tenpay/sdk/net/utils/PayNetUtil;", "", "()V", "getMenShenGtk", "", "skey", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayNetUtil {

    @NotNull
    public static final PayNetUtil INSTANCE = new PayNetUtil();

    PayNetUtil() {
    }

    @Nullable
    public final String getMenShenGtk(@Nullable String skey) {
        if (skey == null) {
            return null;
        }
        int length = skey.length();
        int i3 = 5381;
        for (int i16 = 0; i16 < length; i16++) {
            i3 += (i3 << 5) + skey.charAt(i16);
        }
        return String.valueOf(Integer.MAX_VALUE & i3);
    }
}
