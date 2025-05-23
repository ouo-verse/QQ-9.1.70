package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dy extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public dy(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        String e16;
        try {
            Intent intent = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class);
            if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().e())) {
                e16 = "https://docs.qq.com/desktop/m/index.html?_from=1";
            } else {
                e16 = TencentDocConvertConfigProcessor.a().e();
            }
            this.f307437b.startActivity(intent.putExtra("url", e16));
            return true;
        } catch (Exception e17) {
            e17.printStackTrace();
            return true;
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            return F();
        } catch (Exception e16) {
            QLog.e("TeamWorkListAction", 1, "doAction error: " + e16.getMessage());
            i("TeamWorkListAction");
            return false;
        }
    }
}
