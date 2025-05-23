package com.tenpay.sdk.paynet;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.sdk.helper.PayHelper;
import com.tenpay.view.WalletProgressDialog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Net {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class NetAdapter implements NetListener {
        protected ResultReceiver callback;

        public NetAdapter() {
            this(null);
        }

        @Override // com.tenpay.sdk.paynet.Net.NetListener
        public void onError(String str, JSONObject jSONObject) {
            String optString;
            if (this.callback == null) {
                QwLog.i("error, callback is null...");
                return;
            }
            if (jSONObject == null) {
                optString = ErrorCode.ERR_STR_DATA_EMPTY;
            } else {
                optString = jSONObject.optString("retmsg");
            }
            this.callback.send(-102, PayHelper.createResultForError(optString));
        }

        public NetAdapter(ResultReceiver resultReceiver) {
            this.callback = resultReceiver;
            if (resultReceiver == null) {
                this.callback = new ResultReceiver(new Handler()) { // from class: com.tenpay.sdk.paynet.Net.NetAdapter.1
                    @Override // android.os.ResultReceiver
                    protected void onReceiveResult(int i3, Bundle bundle) {
                        QwLog.i("error, no callback set...");
                    }
                };
            }
        }

        @Override // com.tenpay.sdk.paynet.Net.NetListener
        public void onBlError(String str, JSONObject jSONObject) {
        }

        @Override // com.tenpay.sdk.paynet.Net.NetListener
        public void onSuccess(String str, JSONObject jSONObject) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class NetDlgAdapter extends NetAdapter {
        private WalletProgressDialog loadingDlg;

        public NetDlgAdapter(Context context, boolean z16, ResultReceiver resultReceiver) {
            super(resultReceiver);
            this.loadingDlg = null;
            if (z16) {
                WalletProgressDialog walletProgressDialog = new WalletProgressDialog(context);
                this.loadingDlg = walletProgressDialog;
                walletProgressDialog.setCancelable(true);
                try {
                    this.loadingDlg.show();
                } catch (Throwable th5) {
                    QLog.e("CFT-sdk", 1, th5, new Object[0]);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void dismissLoading() {
            WalletProgressDialog walletProgressDialog = this.loadingDlg;
            if (walletProgressDialog != null && walletProgressDialog.isShowing()) {
                this.loadingDlg.dismiss();
            }
        }

        @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
        public void onBlError(String str, JSONObject jSONObject) {
            dismissLoading();
            super.onBlError(str, jSONObject);
        }

        @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
        public void onError(String str, JSONObject jSONObject) {
            dismissLoading();
            super.onError(str, jSONObject);
        }

        @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
        public void onSuccess(String str, JSONObject jSONObject) {
            dismissLoading();
            super.onSuccess(str, jSONObject);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface NetListener {
        void onBlError(String str, JSONObject jSONObject);

        void onError(String str, JSONObject jSONObject);

        void onSuccess(String str, JSONObject jSONObject);
    }
}
