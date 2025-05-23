package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.qwallet.utils.QWalletUtils;
import com.tenpay.api.TenpayInterface;
import cooperation.qwallet.plugin.ipc.CorpReq;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LogicTenWatch extends a {
    public LogicTenWatch(Context context, Intent intent) {
        super(context, intent);
    }

    @Override // com.qwallet.pay.a
    public void g(Context context) {
        super.g(context);
        TenpayInterface.requestData(this.f41629a, "watchPayCode", this.f41632d.getString("uin"), (HashMap) this.f41632d.getSerializable("map"), new ResultReceiver(new Handler()) { // from class: com.qwallet.pay.LogicTenWatch.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                if (i3 != 99998 && i3 != 99999) {
                    CorpReq corpReq = new CorpReq();
                    CorpReq.corpReqType = 4;
                    corpReq.data = bundle;
                    QWalletUtils.u(corpReq);
                    LogicTenWatch logicTenWatch = LogicTenWatch.this;
                    logicTenWatch.f41637i.x2(logicTenWatch.f41629a);
                }
            }
        });
    }

    @Override // com.qwallet.pay.a
    protected boolean j() {
        return false;
    }
}
