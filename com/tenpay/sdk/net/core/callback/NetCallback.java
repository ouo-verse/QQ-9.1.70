package com.tenpay.sdk.net.core.callback;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tenpay.sdk.net.core.result.NetResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/sdk/net/core/callback/NetCallback;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tenpay/sdk/net/core/result/NetResult;", "", "onNetFailed", "", "url", "", "result", "(Ljava/lang/String;Lcom/tenpay/sdk/net/core/result/NetResult;)V", "onNetSucceed", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface NetCallback<R extends NetResult> {
    void onNetFailed(@NotNull String url, @NotNull R result);

    void onNetSucceed(@NotNull String url, @NotNull R result);
}
