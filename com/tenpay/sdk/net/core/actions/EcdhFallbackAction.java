package com.tenpay.sdk.net.core.actions;

import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.core.encrypt.PayEcdhConfig;
import com.tenpay.sdk.net.core.exception.EcdhException;
import com.tenpay.sdk.net.core.request.RetryAbility;
import com.tenpay.sdk.net.core.result.NetResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tenpay/sdk/net/core/actions/EcdhFallbackAction;", "Lcom/tenpay/sdk/net/core/actions/IKeyLinkAction;", "()V", "onInterceptCallback", "", "url", "", "result", "Lcom/tenpay/sdk/net/core/result/NetResult;", "callback", "Lkotlin/Function0;", "", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class EcdhFallbackAction implements IKeyLinkAction {

    @NotNull
    public static final String TAG = "QWalletHttp-EcdhFallbackAction";

    @Override // com.tenpay.sdk.net.core.actions.IKeyLinkAction
    public boolean onInterceptCallback(@NotNull String url, @NotNull NetResult result, @NotNull Function0<Unit> callback) {
        RetryAbility retryAbility;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(result.getThrowable() instanceof EcdhException)) {
            return false;
        }
        Object request = result.getRequest();
        if (request instanceof RetryAbility) {
            retryAbility = (RetryAbility) request;
        } else {
            retryAbility = null;
        }
        if (retryAbility == null) {
            return false;
        }
        PayEcdhConfig.INSTANCE.disableEcdh(url);
        QLog.i(TAG, 1, "intercepted, retry des encrypt " + url);
        retryAbility.forbidEcdhAes();
        RetryAbility.DefaultImpls.retry$default(retryAbility, null, 1, null);
        return true;
    }
}
