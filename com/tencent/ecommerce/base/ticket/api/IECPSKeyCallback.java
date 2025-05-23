package com.tencent.ecommerce.base.ticket.api;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yg0.b;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;", "", "", "Lyg0/b;", "pSKeys", "", "onSuccess", "", "msg", "onFailed", "onTimeout", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECPSKeyCallback {
    void onFailed(@Nullable String msg2);

    void onSuccess(@NotNull List<b> pSKeys);

    void onTimeout(@Nullable String msg2);
}
