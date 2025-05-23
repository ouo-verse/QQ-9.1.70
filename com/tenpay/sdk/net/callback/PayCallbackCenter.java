package com.tenpay.sdk.net.callback;

import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.core.actions.BeaconReportAction;
import com.tenpay.sdk.net.core.actions.CertUpgradeAction;
import com.tenpay.sdk.net.core.actions.CftSKeyUpdateAction;
import com.tenpay.sdk.net.core.actions.ConfirmRequestAction;
import com.tenpay.sdk.net.core.actions.DomainSettingAction;
import com.tenpay.sdk.net.core.actions.EcdhFallbackAction;
import com.tenpay.sdk.net.core.actions.IByPassAction;
import com.tenpay.sdk.net.core.actions.IKeyLinkAction;
import com.tenpay.sdk.net.core.actions.LogicErrorAction;
import com.tenpay.sdk.net.core.actions.RefreshPaymentOutAction;
import com.tenpay.sdk.net.core.actions.RsaSettingAction;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.request.CallbackDelegateAbility;
import com.tenpay.sdk.net.core.result.NetResult;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J&\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J \u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tenpay/sdk/net/callback/PayCallbackCenter;", "Lcom/tenpay/sdk/net/core/callback/NetCallback;", "Lcom/tenpay/sdk/net/core/result/NetResult;", "()V", "TAG", "", "bypassActionList", "", "Lcom/tenpay/sdk/net/core/actions/IByPassAction;", "keyLinkActionList", "Lcom/tenpay/sdk/net/core/actions/IKeyLinkAction;", "dispatchRequestCallback", "", "success", "", "url", "result", "intercept", "interceptCallback", "Lkotlin/Function0;", "onNetFailed", "onNetSucceed", "onReceiveCallback", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayCallbackCenter implements NetCallback<NetResult> {

    @NotNull
    public static final PayCallbackCenter INSTANCE = new PayCallbackCenter();

    @NotNull
    public static final String TAG = "QWalletHttp-PayCallbackCenter";

    @NotNull
    private static final List<IByPassAction<NetResult>> bypassActionList;

    @NotNull
    private static final List<IKeyLinkAction> keyLinkActionList;

    static {
        List<IByPassAction<NetResult>> listOf;
        List<IKeyLinkAction> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IByPassAction[]{new CftSKeyUpdateAction(), new RsaSettingAction(), new DomainSettingAction(), new BeaconReportAction(), new CertUpgradeAction(), new RefreshPaymentOutAction()});
        bypassActionList = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new IKeyLinkAction[]{new ConfirmRequestAction(), new EcdhFallbackAction(), new LogicErrorAction()});
        keyLinkActionList = listOf2;
    }

    PayCallbackCenter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchRequestCallback(boolean success, String url, NetResult result) {
        CallbackDelegateAbility callbackDelegateAbility;
        NetCallback delegate;
        Object request = result.getRequest();
        Unit unit = null;
        if (request instanceof CallbackDelegateAbility) {
            callbackDelegateAbility = (CallbackDelegateAbility) request;
        } else {
            callbackDelegateAbility = null;
        }
        if (callbackDelegateAbility != null && (delegate = callbackDelegateAbility.getDelegate()) != null) {
            if (success) {
                delegate.onNetSucceed(url, result);
            } else {
                delegate.onNetFailed(url, result);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(TAG, 1, "callback error, invalid request:" + result.getRequest());
        }
    }

    private final boolean intercept(String url, NetResult result, Function0<Unit> interceptCallback) {
        Iterator<T> it = bypassActionList.iterator();
        while (it.hasNext()) {
            try {
                ((IByPassAction) it.next()).onBeforeCallback(url, result);
            } catch (RuntimeException e16) {
                QLog.e(TAG, 1, "intercept bypassAction error. ", e16);
            }
        }
        Iterator<T> it5 = keyLinkActionList.iterator();
        while (it5.hasNext()) {
            try {
            } catch (RuntimeException e17) {
                QLog.e(TAG, 1, "intercept keyLink error. ", e17);
            }
            if (((IKeyLinkAction) it5.next()).onInterceptCallback(url, result, interceptCallback)) {
                return true;
            }
        }
        return false;
    }

    private final void onReceiveCallback(final boolean success, final String url, final NetResult result) {
        if (intercept(url, result, new Function0<Unit>() { // from class: com.tenpay.sdk.net.callback.PayCallbackCenter$onReceiveCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PayCallbackCenter.INSTANCE.dispatchRequestCallback(success, url, result);
            }
        })) {
            return;
        }
        dispatchRequestCallback(success, url, result);
    }

    @Override // com.tenpay.sdk.net.core.callback.NetCallback
    public void onNetFailed(@NotNull String url, @NotNull NetResult result) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        onReceiveCallback(false, url, result);
    }

    @Override // com.tenpay.sdk.net.core.callback.NetCallback
    public void onNetSucceed(@NotNull String url, @NotNull NetResult result) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        onReceiveCallback(true, url, result);
    }
}
