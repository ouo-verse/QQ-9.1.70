package com.tencent.ecommerce.base.ticket.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a2\u0006\u0002\u0010\tJ#\u0010\n\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;", "", "getPsKeysAsync", "", "domains", "", "", "callback", "Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;", "([Ljava/lang/String;Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;)V", "getPsKeysAsyncNoCache", "getServerTimeMillis", "", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECTicketManager {
    void getPsKeysAsync(@NotNull String[] domains, @NotNull IECPSKeyCallback callback);

    void getPsKeysAsyncNoCache(@NotNull String[] domains, @NotNull IECPSKeyCallback callback);

    long getServerTimeMillis();
}
