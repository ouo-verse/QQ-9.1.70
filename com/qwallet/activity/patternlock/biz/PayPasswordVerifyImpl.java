package com.qwallet.activity.patternlock.biz;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.qwallet.activity.patternlock.PatternLockHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.api.TenpayInterface;
import com.tenpay.realname.RealNameSource;

/* loaded from: classes3.dex */
public class PayPasswordVerifyImpl implements b {

    /* renamed from: a, reason: collision with root package name */
    private Activity f41372a;

    /* renamed from: b, reason: collision with root package name */
    private QvipPayWalletPatternLockBizManager f41373b;

    /* loaded from: classes3.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public PayPasswordVerifyImpl(QvipPayWalletPatternLockBizManager qvipPayWalletPatternLockBizManager) {
        this.f41373b = qvipPayWalletPatternLockBizManager;
    }

    @Override // com.qwallet.activity.patternlock.biz.b
    public void a() {
        QvipPayWalletPatternLockBizManager qvipPayWalletPatternLockBizManager = this.f41373b;
        if (qvipPayWalletPatternLockBizManager != null) {
            qvipPayWalletPatternLockBizManager.a();
        }
    }

    @Override // com.qwallet.activity.patternlock.biz.b
    public void b(int i3) {
        if (i3 != 4) {
            if (g.c("qwallet_is_pws_enter_" + com.tencent.mobileqq.base.a.c(), true)) {
                this.f41373b.l(i3, 2);
                return;
            }
            final Bundle bundle = new Bundle();
            String string = this.f41372a.getString(R.string.f179753_8);
            if (i3 == 3) {
                string = this.f41372a.getString(R.string.f179773__);
                bundle.putString("sourceId", "5");
                bundle.putString(RealNameSource.EXTRA_KEY_SOURCE_NAME, RealNameSource.getSourceName("5"));
            } else {
                bundle.putString("sourceId", "4");
                bundle.putString(RealNameSource.EXTRA_KEY_SOURCE_NAME, RealNameSource.getSourceName("4"));
            }
            bundle.putString("userId", com.tencent.mobileqq.base.a.c());
            Activity activity = this.f41372a;
            PatternLockHelper.d(activity, 230, null, string, activity.getString(R.string.cancel), this.f41372a.getString(R.string.f179813_d), new DialogInterface.OnClickListener() { // from class: com.qwallet.activity.patternlock.biz.PayPasswordVerifyImpl.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i16) {
                    TenpayInterface.gotoView(PayPasswordVerifyImpl.this.f41372a, "idCardVerify", com.tencent.mobileqq.base.a.c(), com.tencent.mobileqq.base.a.b(), bundle, new ResultReceiver(null) { // from class: com.qwallet.activity.patternlock.biz.PayPasswordVerifyImpl.1.1
                        @Override // android.os.ResultReceiver
                        protected void onReceiveResult(int i17, Bundle bundle2) {
                            QLog.i("PatternLock_PayPasswordVerifyImpl", 2, "resultCode: " + i17);
                        }
                    });
                    dialogInterface.dismiss();
                }
            }, new a());
            return;
        }
        this.f41373b.l(i3, 2);
    }

    @Override // com.qwallet.activity.patternlock.biz.b
    public void c(Activity activity) {
        this.f41372a = activity;
    }
}
