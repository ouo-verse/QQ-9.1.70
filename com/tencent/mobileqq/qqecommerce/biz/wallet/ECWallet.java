package com.tencent.mobileqq.qqecommerce.biz.wallet;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback;
import com.tencent.ecommerce.biz.wallet.IWallet;
import com.tencent.ecommerce.biz.wallet.WalletRequestListener;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import org.json.JSONObject;
import yg0.ECPsKey;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/wallet/ECWallet;", "Lcom/tencent/ecommerce/biz/wallet/IWallet;", "Lcom/tencent/ecommerce/biz/wallet/WalletRequestListener;", "listener", "", "skey", "", "b", "Landroid/content/Context;", "context", "requestVerify", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECWallet implements IWallet {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/wallet/ECWallet$b", "Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;", "", "msg", "", "onFailed", "", "Lyg0/b;", "pSKeys", "onSuccess", "onTimeout", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IECPSKeyCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WalletRequestListener f263428a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ECWallet f263429b;

        b(WalletRequestListener walletRequestListener, ECWallet eCWallet) {
            this.f263428a = walletRequestListener;
            this.f263429b = eCWallet;
        }

        @Override // com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback
        public void onFailed(String msg2) {
            this.f263428a.onFail(-1, null);
        }

        @Override // com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback
        public void onSuccess(List<ECPsKey> pSKeys) {
            Intrinsics.checkNotNullParameter(pSKeys, "pSKeys");
            if (pSKeys.isEmpty()) {
                QLog.e("ECWallet", 1, "pSKey is empty");
                this.f263428a.onFail(-1, null);
            } else {
                String value = pSKeys.get(0).getValue();
                if (value == null) {
                    value = "";
                }
                this.f263429b.b(this.f263428a, value);
            }
        }

        @Override // com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback
        public void onTimeout(String msg2) {
            this.f263428a.onFail(-1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final WalletRequestListener listener, String skey) {
        AppRuntime runtime;
        JSONObject jSONObject = new JSONObject();
        try {
            runtime = BaseApplicationImpl.getApplication().getRuntime();
        } catch (Exception e16) {
            QLog.e("ECWallet", 2, "requestVerify json  error: " + e16.getMessage());
        }
        if (runtime == null) {
            listener.onFail(-1, null);
            return;
        }
        jSONObject.put("userId", runtime.getAccount());
        jSONObject.put(HippyHeaderListViewController.VIEW_TAG, "idCardVerify");
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
        bundle.putString("callbackSn", "0");
        final Handler handler = new Handler(Looper.getMainLooper());
        PayBridgeActivity.tenpay(Foreground.getTopActivity(), 5, bundle, new ResultReceiver(handler) { // from class: com.tencent.mobileqq.qqecommerce.biz.wallet.ECWallet$requestVerify$resultReceiver$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                QLog.d("ECWallet", 2, "onReceiveResult resultCode = " + resultCode + " resultData = " + resultData);
                if (resultCode != 0) {
                    WalletRequestListener.this.onFail(-1, null);
                    return;
                }
                String string = resultData.getString("result");
                try {
                    QLog.d("ECWallet", 2, "onReceiveResult json data: " + string);
                    JSONObject jSONObject2 = new JSONObject(string);
                    int optInt = jSONObject2.optInt(QzoneIPCModule.RESULT_CODE, -1);
                    String retmsg = jSONObject2.optString("retmsg");
                    if (optInt == 0) {
                        WalletRequestListener.this.onSucc(0, null);
                    } else {
                        HashMap hashMap = new HashMap();
                        Intrinsics.checkNotNullExpressionValue(retmsg, "retmsg");
                        hashMap.put("errorMsg", retmsg);
                        WalletRequestListener.this.onFail(-1, hashMap);
                    }
                } catch (Exception e17) {
                    QLog.e("ECWallet", 2, "onReceiveResult error: " + e17.getMessage());
                    WalletRequestListener.this.onFail(-1, null);
                }
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.wallet.IWallet
    public void requestVerify(Context context, WalletRequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getPsKeysAsync(new String[]{"kandian.qq.com"}, new b(listener, this));
    }
}
