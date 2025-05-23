package com.tenpay.sdk.activity;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.helper.WechatPayHelper;
import com.tenpay.sdk.paynet.Net;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tenpay/sdk/activity/ChoosePayChannelFragment$startWeChatPay$1", "Lcom/tenpay/sdk/paynet/Net$NetAdapter;", "onBlError", "", BrowserPlugin.KEY_REQUEST_URL, "", "data", "Lorg/json/JSONObject;", "onSuccess", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ChoosePayChannelFragment$startWeChatPay$1 extends Net.NetAdapter {
    final /* synthetic */ ChoosePayChannelFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChoosePayChannelFragment$startWeChatPay$1(ChoosePayChannelFragment choosePayChannelFragment) {
        this.this$0 = choosePayChannelFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBlError$lambda$0(ChoosePayChannelFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
        String str;
        if (this.this$0.getContext() == null) {
            QLog.w("ChoosePayChannelFragment", 1, "onBlError: context is nulL, early return");
            return;
        }
        Context context = this.this$0.getContext();
        if (data != null) {
            str = data.optString("retmsg");
        } else {
            str = null;
        }
        if (str == null) {
            str = WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN;
        }
        final ChoosePayChannelFragment choosePayChannelFragment = this.this$0;
        QUIProxy.showConfirm(context, str, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.ab
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChoosePayChannelFragment$startWeChatPay$1.onBlError$lambda$0(ChoosePayChannelFragment.this, dialogInterface, i3);
            }
        });
    }

    @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        WechatPayHelper wechatPayHelper;
        this.this$0.registerWxPayCallback();
        wechatPayHelper = this.this$0.wechatPayHelper;
        wechatPayHelper.pay(data, null);
        this.this$0.onPayChannelChosen(1);
    }
}
