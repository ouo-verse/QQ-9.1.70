package com.tenpay.sdk.net.sso;

import android.content.Context;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.encrypt.PayEcdhConfig;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.paynet.Net;
import com.tenpay.sdk.paynet.NetSenderDelegate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n*\u0001\n\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0018\u001a\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016JD\u0010\u001a\u001a\u00020\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tenpay/sdk/net/sso/PaySsoServiceProxy;", "Lcom/tenpay/sdk/paynet/NetSenderDelegate;", "()V", "baseUrl", "", "context", "Landroid/content/Context;", "encrypt", "", "httpNetCallback", "com/tenpay/sdk/net/sso/PaySsoServiceProxy$httpNetCallback$1", "Lcom/tenpay/sdk/net/sso/PaySsoServiceProxy$httpNetCallback$1;", "netListener", "Lcom/tenpay/sdk/paynet/Net$NetListener;", "paySsoCmd", "Lcom/tenpay/sdk/net/sso/PaySsoCmd;", "rawData", "", "uin", "comeFrom", "isEncrypt", Const.BUNDLE_KEY_REQUEST, "", "iNetListener", "tokenID", "tokenId", "with", "ctx", "url", "data", "id", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaySsoServiceProxy implements NetSenderDelegate {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String baseUrl;

    @Nullable
    private Context context;
    private boolean encrypt = true;

    @NotNull
    private final PaySsoServiceProxy$httpNetCallback$1 httpNetCallback = new NetCallback<PaySsoResult>() { // from class: com.tenpay.sdk.net.sso.PaySsoServiceProxy$httpNetCallback$1
        private final boolean isFragmentFinish() {
            Object obj;
            obj = PaySsoServiceProxy.this.netListener;
            if ((obj instanceof QWalletBaseFragment) && ((QWalletBaseFragment) obj).isFinishing()) {
                return true;
            }
            return false;
        }

        @Override // com.tenpay.sdk.net.core.callback.NetCallback
        public void onNetFailed(@NotNull String url, @NotNull PaySsoResult result) {
            Net.NetListener netListener;
            String str;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(result, "result");
            if (isFragmentFinish()) {
                QLog.w(PaySsoClient.TAG, 1, "onHttpFailed but fragment finish, " + result);
                return;
            }
            QLog.e(PaySsoClient.TAG, 1, "onHttpFailed, " + result);
            netListener = PaySsoServiceProxy.this.netListener;
            if (netListener != null) {
                str = PaySsoServiceProxy.this.baseUrl;
                netListener.onError(str, (JSONObject) result.getBizResponse());
            }
        }

        @Override // com.tenpay.sdk.net.core.callback.NetCallback
        public void onNetSucceed(@NotNull String url, @NotNull PaySsoResult result) {
            Net.NetListener netListener;
            String str;
            Net.NetListener netListener2;
            String str2;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(result, "result");
            if (isFragmentFinish()) {
                QLog.w(PaySsoClient.TAG, 1, "onHttpSucceed but fragment finish, " + result);
                return;
            }
            if (result.getIsBizSucceed()) {
                netListener2 = PaySsoServiceProxy.this.netListener;
                if (netListener2 != null) {
                    str2 = PaySsoServiceProxy.this.baseUrl;
                    netListener2.onSuccess(str2, (JSONObject) result.getBizResponse());
                    return;
                }
                return;
            }
            netListener = PaySsoServiceProxy.this.netListener;
            if (netListener != null) {
                str = PaySsoServiceProxy.this.baseUrl;
                netListener.onBlError(str, (JSONObject) result.getBizResponse());
            }
        }
    };

    @Nullable
    private Net.NetListener netListener;
    private PaySsoCmd paySsoCmd;

    @Nullable
    private Map<String, String> rawData;

    @Nullable
    private String uin;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/tenpay/sdk/net/sso/PaySsoServiceProxy$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tenpay/sdk/net/sso/PaySsoServiceProxy;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final PaySsoServiceProxy create() {
            return new PaySsoServiceProxy();
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final PaySsoServiceProxy create() {
        return INSTANCE.create();
    }

    @Override // com.tenpay.sdk.paynet.NetSenderDelegate
    @NotNull
    public NetSenderDelegate encrypt(boolean isEncrypt) {
        this.encrypt = isEncrypt;
        return this;
    }

    @Override // com.tenpay.sdk.paynet.NetSenderDelegate
    public void request(@Nullable Net.NetListener iNetListener) {
        String str;
        this.netListener = iNetListener;
        ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, PaySsoClient.TAG, "send sso request from " + iNetListener, null, 4, null);
        Context context = this.context;
        String str2 = this.baseUrl;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        String str3 = this.uin;
        boolean z16 = this.encrypt;
        PayEcdhConfig payEcdhConfig = PayEcdhConfig.INSTANCE;
        if (str2 == null) {
            str2 = "";
        }
        boolean isEnable = payEcdhConfig.isEnable(str2);
        Map map = this.rawData;
        if (map == null) {
            map = new LinkedHashMap();
        }
        Map map2 = map;
        PaySsoCmd paySsoCmd = this.paySsoCmd;
        if (paySsoCmd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paySsoCmd");
            paySsoCmd = null;
        }
        PaySsoService.sendRequest$default(context, str, str3, z16, isEnable, map2, paySsoCmd, null, this.httpNetCallback, 128, null);
    }

    @NotNull
    public final NetSenderDelegate with(@Nullable Context ctx, @Nullable String url, @Nullable Map<String, String> data, @Nullable String id5, @NotNull PaySsoCmd paySsoCmd) {
        Intrinsics.checkNotNullParameter(paySsoCmd, "paySsoCmd");
        this.context = ctx;
        this.baseUrl = url;
        this.rawData = data;
        this.uin = id5;
        this.paySsoCmd = paySsoCmd;
        return this;
    }

    @Override // com.tenpay.sdk.paynet.NetSenderDelegate
    @NotNull
    public NetSenderDelegate comeFrom(@Nullable String comeFrom) {
        return this;
    }

    @Override // com.tenpay.sdk.paynet.NetSenderDelegate
    @NotNull
    public NetSenderDelegate tokenID(@Nullable String tokenId) {
        return this;
    }
}
