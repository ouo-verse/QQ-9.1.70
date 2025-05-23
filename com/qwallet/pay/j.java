package com.qwallet.pay;

import android.content.Context;
import android.content.Intent;
import com.qwallet.activity.QvipPaySVipActivity;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class j extends r {
    public j(Context context, Intent intent) {
        super(context, intent);
    }

    @Override // com.qwallet.pay.a, com.qwallet.pay.b
    public boolean b() {
        return true;
    }

    @Override // com.qwallet.pay.r, com.qwallet.pay.a
    public void g(Context context) {
        super.g(context);
        Intent intent = new Intent();
        intent.putExtras(this.f41632d);
        try {
            com.tencent.mobileqq.base.c.g(this.f41629a, intent, QvipPaySVipActivity.class, 1);
        } catch (Throwable th5) {
            QLog.e("Q.qwallet.BasePayPluginLogic", 1, "", th5);
        }
    }

    @Override // com.qwallet.pay.a, com.qwallet.pay.b
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1) {
            if (i16 == -1 && intent != null) {
                e(intent.getExtras());
            } else {
                f(i16);
            }
        }
    }
}
