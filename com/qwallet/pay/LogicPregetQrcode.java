package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tenpay.api.TenpayInterface;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class LogicPregetQrcode extends a {
    public LogicPregetQrcode(Context context, Intent intent) {
        super(context, intent);
    }

    @Override // com.qwallet.pay.a
    public void g(Context context) {
        super.g(context);
        ResultReceiver resultReceiver = new ResultReceiver(new Handler()) { // from class: com.qwallet.pay.LogicPregetQrcode.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                if (i3 != 0) {
                    return;
                }
                com.tencent.mobileqq.qwallet.c.e("fukuanma.yula", "", "", "", "");
            }
        };
        HashMap hashMap = new HashMap();
        for (String str : this.f41632d.keySet()) {
            if (!str.equals(QWalletPayBridge.Key.PAY_INVOKER_ID)) {
                hashMap.put(str, this.f41632d.getString(str));
            }
        }
        TenpayInterface.pregetQrcode(this.f41629a, hashMap, resultReceiver);
        e(null);
    }

    @Override // com.qwallet.pay.a
    protected boolean j() {
        return false;
    }
}
