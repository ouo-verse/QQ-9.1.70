package com.tenpay.sdk.net.core.actions;

import com.tenpay.sdk.net.core.result.NetResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/sdk/net/core/actions/IKeyLinkAction;", "", "onInterceptCallback", "", "url", "", "result", "Lcom/tenpay/sdk/net/core/result/NetResult;", "callback", "Lkotlin/Function0;", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface IKeyLinkAction {
    boolean onInterceptCallback(@NotNull String url, @NotNull NetResult result, @NotNull Function0<Unit> callback);
}
