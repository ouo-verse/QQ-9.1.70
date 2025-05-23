package com.tencent.mobileqq.location.window;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dq;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class FloatMapDialogUtil {
    static IPatchRedirector $redirector_;

    public static void a(QBaseActivity qBaseActivity) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.location.window.FloatMapDialogUtil.2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.location.window.FloatMapDialogUtil$2$a */
            /* loaded from: classes15.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        QBaseActivity.this.finish();
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QBaseActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (((IFloatMapService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).getBadNetOnFloatWindowDialogShown()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FloatMapDialogUtil", 2, "showBadNetDialog: invoked. \u5f53\u524d\u5982\u679c\u5c55\u793a\u60ac\u6d6e\u7a97\uff0c\u5c31\u4e0d\u663e\u793a\u8fd9\u4e2a\u5f39\u7a97\u4e86");
                    }
                } else {
                    QBaseActivity qBaseActivity2 = QBaseActivity.this;
                    FloatMapDialogUtil.c(QBaseActivity.this, dq.a(qBaseActivity2, 230, null, qBaseActivity2.getResources().getString(R.string.vro), R.string.f171151ok, R.string.cancel, null, new a()));
                }
            }
        }, 7000L);
    }

    public static void b(QBaseActivity qBaseActivity) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.location.window.FloatMapDialogUtil.1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.location.window.FloatMapDialogUtil$1$a */
            /* loaded from: classes15.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                        return;
                    }
                    IFloatMapService iFloatMapService = (IFloatMapService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "");
                    iFloatMapService.quitFloat(3);
                    iFloatMapService.setBadNetOnFloatWindowDialogShown(false);
                }
            }

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QBaseActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QBaseActivity qBaseActivity2 = QBaseActivity.this;
                FloatMapDialogUtil.c(QBaseActivity.this, dq.a(qBaseActivity2, 230, null, qBaseActivity2.getResources().getString(R.string.vro), R.string.f171151ok, R.string.cancel, null, new a()));
            }
        }, 1000L);
    }

    public static void c(Activity activity, QQCustomDialog qQCustomDialog) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    qQCustomDialog.show();
                }
            } catch (Exception e16) {
                QLog.e("FloatMapDialogUtil", 1, "showSafely: failed. ", e16);
            }
        }
    }
}
