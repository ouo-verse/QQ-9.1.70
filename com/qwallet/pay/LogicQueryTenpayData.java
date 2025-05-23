package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.qwallet.data.TenPayInfo;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.api.TenpayInterface;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LogicQueryTenpayData extends a {
    public LogicQueryTenpayData(Context context, Intent intent) {
        super(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final TenPayInfo tenPayInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.qwallet.pay.LogicQueryTenpayData.2
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                Bundle bundle = LogicQueryTenpayData.this.f41632d;
                int i16 = -1;
                if (bundle != null) {
                    i16 = bundle.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
                }
                Intent intent = new Intent();
                intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, i16);
                TenPayInfo tenPayInfo2 = tenPayInfo;
                if (tenPayInfo2 != null) {
                    List<TenPayInfo.BankCardInfo> list = tenPayInfo2.f41530c;
                    if (list != null) {
                        i3 = list.size();
                    } else {
                        i3 = 0;
                    }
                    int i17 = 0;
                    while (true) {
                        if (i17 >= i3) {
                            break;
                        }
                        TenPayInfo.BankCardInfo bankCardInfo = list.get(i17);
                        if (bankCardInfo.isCreditPay == 1 && bankCardInfo.webankInfo != null) {
                            intent.putExtra("retCode", 0);
                            intent.putExtra("card_status", bankCardInfo.webankInfo.f41542a);
                            intent.putExtra("available_amount", bankCardInfo.webankInfo.f41543b);
                            intent.putExtra("overdue_amount", bankCardInfo.webankInfo.f41544c);
                            break;
                        }
                        i17++;
                    }
                }
                LogicQueryTenpayData.this.e(intent.getExtras());
            }
        });
    }

    @Override // com.qwallet.pay.a, com.qwallet.pay.b
    public boolean b() {
        return true;
    }

    @Override // com.qwallet.pay.a
    public void g(Context context) {
        super.g(context);
        ResultReceiver resultReceiver = new ResultReceiver(new Handler()) { // from class: com.qwallet.pay.LogicQueryTenpayData.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                String str;
                super.onReceiveResult(i3, bundle);
                if (i3 != 99999 && i3 != 99998) {
                    TenPayInfo tenPayInfo = null;
                    if (bundle != null) {
                        str = bundle.getString("retmsg");
                    } else {
                        str = null;
                    }
                    if (i3 == 0 && str != null) {
                        try {
                            tenPayInfo = TenPayInfo.d(new JSONObject(str));
                        } catch (Exception e16) {
                            QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", e16);
                        }
                    }
                    LogicQueryTenpayData.this.p(tenPayInfo);
                }
            }
        };
        TenpayInterface.requestData(this.f41629a, "qwallet", QWalletUtils.h(), new HashMap(), resultReceiver);
    }
}
