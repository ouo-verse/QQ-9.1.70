package com.tencent.mobileqq.activity.troop.config;

import android.content.DialogInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
class TroopBaseRequestsProcessor$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f186605d;
    final /* synthetic */ f this$0;

    /* loaded from: classes10.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopBaseRequestsProcessor$1.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null && !baseActivity.isFinishing()) {
            DialogUtil.createCustomDialog(BaseActivity.sTopActivity, 230, (String) null, this.f186605d + " \u7fa4\u534f\u8bae\u62c9\u53d6\u8d85\u6807\uff01\uff01\u53ef\u80fd\u5b58\u5728\u5faa\u73af\u62c9\u53d6\u3002\u8bf7\u9a6c\u4e0a\u8054\u7cfb\u7fa4\u7684\u76f8\u5173\u5f00\u53d1\u4eba\u5458\u3002", (String) null, "\u6211\u77e5\u9053\u4e86", new a(), (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("TroopBaseRequestsProcessor", 2, "Failed to show warning dialog. CMD exceeded the limit: " + this.f186605d);
        }
    }
}
