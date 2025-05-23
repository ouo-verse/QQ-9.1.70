package com.tenpay.sdk.net.http;

import android.content.Context;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.encrypt.PayEcdhConfig;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.http.request.CgiBizData;
import com.tenpay.sdk.net.http.result.HttpResult;
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

@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016J<\u0010\u0018\u001a\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tenpay/sdk/net/http/PayCgiServiceProxy;", "Lcom/tenpay/sdk/paynet/NetSenderDelegate;", "()V", "baseUrl", "", "comeFrom", "context", "Landroid/content/Context;", "encrypt", "", "httpNetCallback", "com/tenpay/sdk/net/http/PayCgiServiceProxy$httpNetCallback$1", "Lcom/tenpay/sdk/net/http/PayCgiServiceProxy$httpNetCallback$1;", "netListener", "Lcom/tenpay/sdk/paynet/Net$NetListener;", "rawData", "", "tokenId", "uin", "isEncrypt", Const.BUNDLE_KEY_REQUEST, "", "iNetListener", "tokenID", "with", "ctx", "url", "data", "id", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayCgiServiceProxy implements NetSenderDelegate {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String baseUrl;

    @Nullable
    private Context context;

    @Nullable
    private Net.NetListener netListener;

    @Nullable
    private Map<String, String> rawData;

    @Nullable
    private String uin;

    @Nullable
    private String tokenId = "";

    @Nullable
    private String comeFrom = "0";
    private boolean encrypt = true;

    @NotNull
    private final PayCgiServiceProxy$httpNetCallback$1 httpNetCallback = new NetCallback<HttpResult>() { // from class: com.tenpay.sdk.net.http.PayCgiServiceProxy$httpNetCallback$1
        private final boolean isFragmentFinish() {
            Object obj;
            obj = PayCgiServiceProxy.this.netListener;
            if ((obj instanceof QWalletBaseFragment) && ((QWalletBaseFragment) obj).isFinishing()) {
                return true;
            }
            return false;
        }

        @Override // com.tenpay.sdk.net.core.callback.NetCallback
        public void onNetFailed(@NotNull String url, @NotNull HttpResult result) {
            Net.NetListener netListener;
            String str;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(result, "result");
            if (isFragmentFinish()) {
                QLog.w(PayCgiService.TAG, 1, "onHttpFailed but fragment finish, " + result);
                return;
            }
            QLog.e(PayCgiService.TAG, 1, "onHttpFailed, " + result);
            netListener = PayCgiServiceProxy.this.netListener;
            if (netListener != null) {
                str = PayCgiServiceProxy.this.baseUrl;
                netListener.onError(str, (JSONObject) result.getBizResponse());
            }
        }

        @Override // com.tenpay.sdk.net.core.callback.NetCallback
        public void onNetSucceed(@NotNull String url, @NotNull HttpResult result) {
            Net.NetListener netListener;
            String str;
            Net.NetListener netListener2;
            String str2;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(result, "result");
            if (isFragmentFinish()) {
                QLog.w(PayCgiService.TAG, 1, "onHttpSucceed but fragment finish, " + result);
                return;
            }
            if (result.getIsBizSucceed()) {
                netListener2 = PayCgiServiceProxy.this.netListener;
                if (netListener2 != null) {
                    str2 = PayCgiServiceProxy.this.baseUrl;
                    netListener2.onSuccess(str2, (JSONObject) result.getBizResponse());
                    return;
                }
                return;
            }
            netListener = PayCgiServiceProxy.this.netListener;
            if (netListener != null) {
                str = PayCgiServiceProxy.this.baseUrl;
                netListener.onBlError(str, (JSONObject) result.getBizResponse());
            }
        }
    };

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/tenpay/sdk/net/http/PayCgiServiceProxy$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tenpay/sdk/net/http/PayCgiServiceProxy;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final PayCgiServiceProxy create() {
            return new PayCgiServiceProxy();
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final PayCgiServiceProxy create() {
        return INSTANCE.create();
    }

    @Override // com.tenpay.sdk.paynet.NetSenderDelegate
    @NotNull
    public NetSenderDelegate comeFrom(@Nullable String comeFrom) {
        this.comeFrom = comeFrom;
        return this;
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
        String str2 = this.uin;
        boolean z16 = this.encrypt;
        Map map = this.rawData;
        if (map == null) {
            map = new LinkedHashMap();
        }
        Map map2 = map;
        String str3 = this.tokenId;
        String str4 = this.comeFrom;
        PayEcdhConfig payEcdhConfig = PayEcdhConfig.INSTANCE;
        String str5 = this.baseUrl;
        if (str5 == null) {
            str5 = "";
        }
        CgiBizData cgiBizData = new CgiBizData(str2, z16, payEcdhConfig.isEnable(str5), null, map2, str3, str4, 8, null);
        ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, PayHttpClient.TAG, "send request from " + iNetListener, null, 4, null);
        Context context = this.context;
        String str6 = this.baseUrl;
        if (str6 == null) {
            str = "";
        } else {
            str = str6;
        }
        PayCgiService.sendRequest$default(context, str, this.rawData, cgiBizData, null, this.httpNetCallback, 16, null);
    }

    @Override // com.tenpay.sdk.paynet.NetSenderDelegate
    @NotNull
    public NetSenderDelegate tokenID(@Nullable String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    @NotNull
    public final NetSenderDelegate with(@Nullable Context ctx, @Nullable String url, @Nullable Map<String, String> data, @Nullable String id5) {
        this.context = ctx;
        this.baseUrl = url;
        this.rawData = data;
        this.uin = id5;
        return this;
    }
}
