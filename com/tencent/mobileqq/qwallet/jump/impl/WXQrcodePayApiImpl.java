package com.tencent.mobileqq.qwallet.jump.impl;

import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXQRCodePay;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.jump.IWXQrcodePayApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u0018\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jump/impl/WXQrcodePayApiImpl;", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "Lcom/tencent/mobileqq/qwallet/jump/IWXQrcodePayApi;", "", "msgResId", "", UIJsPlugin.EVENT_SHOW_TOAST, "", "actionName", "r2", "report", "qrcodeUrl", WadlProxyConsts.CHANNEL, "token", "launchQrcodePay", "Landroid/content/Intent;", "intent", "handleWXEntryIntent", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "resp", "onResp", "Lcom/tencent/mm/opensdk/modelbase/BaseReq;", "baseReq", "onReq", "wxAppId", "Ljava/lang/String;", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "wxApi", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "<init>", "()V", "Companion", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class WXQrcodePayApiImpl implements IWXAPIEventHandler, IWXQrcodePayApi {

    @NotNull
    private static final String APP_ID_DEBUG = "wx76a769350165bcff";

    @NotNull
    private static final String APP_ID_RELEASE = "wxf0a80d0ac2e82aa7";

    @NotNull
    private static final String REPORT_ACTION_BACK_FROM_WX = "qq.scan.backtrack";

    @NotNull
    private static final String REPORT_ACTION_LAUNCH_WX = "qq.scan.pullwechat";

    @NotNull
    private static final String TAG = "WXQrcodePayApi";

    @NotNull
    private final IWXAPI wxApi;

    @NotNull
    private final String wxAppId = "wxf0a80d0ac2e82aa7";

    public WXQrcodePayApiImpl() {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(MobileQQ.sMobileQQ, "wxf0a80d0ac2e82aa7", true);
        createWXAPI.registerApp("wxf0a80d0ac2e82aa7");
        Intrinsics.checkNotNullExpressionValue(createWXAPI, "createWXAPI(MobileQQ.sMo\u2026egisterApp(wxAppId)\n    }");
        this.wxApi = createWXAPI;
    }

    private final void report(String actionName, String r26) {
        com.tencent.mobileqq.qwallet.c.e(actionName, r26, "", "", AppSetting.f99551k);
    }

    private final void showToast(final int msgResId) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.jump.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                WXQrcodePayApiImpl.showToast$lambda$3(msgResId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$3(int i3) {
        QQToast.makeText(MobileQQ.sMobileQQ, 0, i3, 0).show();
    }

    @Override // com.tencent.mobileqq.qwallet.jump.IWXQrcodePayApi
    public void handleWXEntryIntent(@Nullable Intent intent) {
        this.wxApi.handleIntent(intent, this);
    }

    @Override // com.tencent.mobileqq.qwallet.jump.IWXQrcodePayApi
    public void launchQrcodePay(@NotNull String qrcodeUrl, int channel, @NotNull String token) {
        Intrinsics.checkNotNullParameter(qrcodeUrl, "qrcodeUrl");
        Intrinsics.checkNotNullParameter(token, "token");
        if (!this.wxApi.isWXAppInstalled()) {
            QLog.i(TAG, 1, "wx is not install");
            showToast(R.string.f242187tw);
            return;
        }
        if (this.wxApi.getWXAppSupportAPI() < 671092224) {
            QLog.i(TAG, 1, "wx version = " + this.wxApi.getWXAppSupportAPI() + " is old");
            showToast(R.string.f242197tx);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WadlProxyConsts.CHANNEL, channel);
        jSONObject.put("token", token);
        WXQRCodePay.Req req = new WXQRCodePay.Req();
        req.codeContent = qrcodeUrl;
        req.extraMsg = jSONObject.toString();
        this.wxApi.sendReq(req);
        QLog.i(TAG, 1, "launchQrcodePay: wxApi send wxQrcodePay");
        report(REPORT_ACTION_LAUNCH_WX, String.valueOf(channel));
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(@NotNull BaseReq baseReq) {
        Intrinsics.checkNotNullParameter(baseReq, "baseReq");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onReq: ");
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(@Nullable BaseResp resp) {
        if (resp instanceof WXQRCodePay.Resp) {
            WXQRCodePay.Resp resp2 = (WXQRCodePay.Resp) resp;
            QLog.i(TAG, 1, "onResp: errCode = " + resp2.errCode);
            if (resp2.errCode == 0) {
                report(REPORT_ACTION_BACK_FROM_WX, "");
            }
        }
    }
}
