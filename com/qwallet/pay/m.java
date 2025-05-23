package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import com.tenpay.api.TenpayInterface;

/* compiled from: P */
/* loaded from: classes3.dex */
public class m extends a {
    public m(Context context, Intent intent) {
        super(context, intent);
    }

    @Override // com.qwallet.pay.a
    public void g(Context context) {
        super.g(context);
        TenpayInterface.preConnect(this.f41629a, this.f41632d.getString("uin"));
        e(null);
    }

    @Override // com.qwallet.pay.a
    protected boolean j() {
        return false;
    }
}
