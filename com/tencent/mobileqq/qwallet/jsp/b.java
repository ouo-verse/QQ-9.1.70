package com.tencent.mobileqq.qwallet.jsp;

import android.net.Uri;
import com.qwallet.protocol.Wallet.pb.GetEncryptedAccountPB$GetEnAccountReq;
import com.qwallet.protocol.Wallet.pb.GetEncryptedAccountPB$GetEnAccountRsp;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletServletApi;
import com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import pl2.n;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002J=\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/b;", "Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "f", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "args", "jsCallback", "", "a", "(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lorg/json/JSONObject;[Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b extends QWalletJsPlugin.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/jsp/b$b", "Lpl2/o;", "Lcom/qwallet/protocol/Wallet/pb/GetEncryptedAccountPB$GetEnAccountRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.jsp.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8473b implements o<GetEncryptedAccountPB$GetEnAccountRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebViewPlugin f278534a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f278535b;

        C8473b(WebViewPlugin webViewPlugin, String str) {
            this.f278534a = webViewPlugin;
            this.f278535b = str;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull GetEncryptedAccountPB$GetEnAccountRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret_code", 0);
            jSONObject.put("en_acc_id", rsp.en_acc_id.get());
            jSONObject.put("pass_sdk_flag", rsp.pass_sdk_flag.get());
            jSONObject.put("sign", rsp.sign.get());
            this.f278534a.callJs(this.f278535b, jSONObject.toString());
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret_code", errCode);
            jSONObject.put("ret_msg", errMsg);
            this.f278534a.callJs(this.f278535b, jSONObject.toString());
        }
    }

    private final String f(WebViewPlugin webViewPlugin) {
        String str;
        boolean z16;
        CustomWebView e16;
        WebViewPlugin.b bVar = webViewPlugin.mRuntime;
        if (bVar != null && (e16 = bVar.e()) != null) {
            str = e16.getUrl();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        return Uri.parse(str).getHost();
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.c
    public void a(@NotNull WebViewPlugin plugin, @Nullable JSONObject jsonData, @NotNull String[] args, @Nullable String jsCallback) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(args, "args");
        if (jsonData == null) {
            return;
        }
        String optString = jsonData.optString("appid");
        String optString2 = jsonData.optString("open_id");
        String optString3 = jsonData.optString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN);
        String optString4 = jsonData.optString("bz_info");
        String optString5 = jsonData.optString("sign");
        String f16 = f(plugin);
        if (f16 == null) {
            f16 = "";
        }
        GetEncryptedAccountPB$GetEnAccountReq getEncryptedAccountPB$GetEnAccountReq = new GetEncryptedAccountPB$GetEnAccountReq();
        getEncryptedAccountPB$GetEnAccountReq.domain.set(f16);
        getEncryptedAccountPB$GetEnAccountReq.appid.set(optString);
        getEncryptedAccountPB$GetEnAccountReq.open_id.set(optString2);
        getEncryptedAccountPB$GetEnAccountReq.access_token.set(optString3);
        getEncryptedAccountPB$GetEnAccountReq.bz_info.set(optString4);
        getEncryptedAccountPB$GetEnAccountReq.sign.set(optString5);
        C8473b c8473b = new C8473b(plugin, jsCallback);
        n nVar = n.f426457a;
        IQWalletServletApi iQWalletServletApi = (IQWalletServletApi) QRoute.api(IQWalletServletApi.class);
        Object newInstance = GetEncryptedAccountPB$GetEnAccountRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        iQWalletServletApi.sendGatewayRequest("trpc.weloan.account.Account", "GetEnAccount", getEncryptedAccountPB$GetEnAccountReq, (MessageMicro) newInstance, true, false, true, c8473b);
    }
}
