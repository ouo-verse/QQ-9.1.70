package com.tenpay.sdk.net.core.request;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.result.NetResult;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tenpay/sdk/net/core/request/CallbackDelegateAbility;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tenpay/sdk/net/core/result/NetResult;", "", "getDelegate", "Lcom/tenpay/sdk/net/core/callback/NetCallback;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface CallbackDelegateAbility<R extends NetResult> {
    @Nullable
    NetCallback<R> getDelegate();
}
