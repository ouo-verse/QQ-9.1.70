package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qwallet.pay.b;
import com.tenpay.api.TenpayInterface;
import mqq.app.MobileQQ;

/* loaded from: classes3.dex */
public class LogicPayData extends a {

    /* renamed from: k, reason: collision with root package name */
    TenviewResultReceiver f41617k;

    /* loaded from: classes3.dex */
    public static class TenviewResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        LogicPayData f41618d;

        /* renamed from: e, reason: collision with root package name */
        b.a f41619e;

        public TenviewResultReceiver(LogicPayData logicPayData, b.a aVar) {
            super(null);
            this.f41618d = logicPayData;
            this.f41619e = aVar;
        }

        public void a() {
            this.f41618d = null;
            this.f41619e = null;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            LogicPayData logicPayData = this.f41618d;
            if (logicPayData != null && i3 != 99998 && i3 != 99999) {
                logicPayData.o(i3, bundle, this.f41619e);
            }
        }
    }

    public LogicPayData(Context context, Intent intent) {
        super(context, intent);
    }

    @Override // com.qwallet.pay.a
    public void g(Context context) {
        super.g(context);
        String string = this.f41632d.getString("_qwallet_payparams_tag");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.f41617k = new TenviewResultReceiver(this, this.f41637i);
        Bundle bundle = this.f41632d.getBundle("_qwallet_payparams_data");
        String currentAccountUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
        if (!"graphb".equals(string) && !"redgiftDetail".equals(string) && !"grapH5CommonHb".equals(string) && !"redgiftH5CommonDetail".equals(string)) {
            TenpayInterface.gotoView(this.f41629a, string, currentAccountUin, com.tencent.mobileqq.base.a.b(), bundle, this.f41617k);
        } else {
            TenpayInterface.gotoView(this.f41629a, string, currentAccountUin, com.tencent.mobileqq.base.a.b(), bundle, this.f41617k, this.f41631c);
        }
    }

    @Override // com.qwallet.pay.a
    protected boolean j() {
        return false;
    }

    public void o(int i3, Bundle bundle, b.a aVar) {
        if (this.f41636h != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.f41636h.send(i3, bundle);
        }
        aVar.x2(this.f41629a);
    }

    @Override // com.qwallet.pay.a, com.qwallet.pay.b
    public void onDestroy() {
        super.onDestroy();
        TenviewResultReceiver tenviewResultReceiver = this.f41617k;
        if (tenviewResultReceiver != null) {
            tenviewResultReceiver.a();
        }
    }
}
