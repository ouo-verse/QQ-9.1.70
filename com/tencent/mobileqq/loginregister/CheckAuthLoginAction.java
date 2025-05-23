package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.appcenter.OpenWriteCodeQQBrowserActivity;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CheckAuthLoginAction extends f {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f242792d;

        a(QBaseActivity qBaseActivity) {
            this.f242792d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CheckAuthLoginAction.this, (Object) qBaseActivity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ReportController.r(this.f242792d.getAppRuntime(), "dc00898", "", "", "0X8006797", "0X8006797", 0, 0, "", "", "", "");
            try {
                dialogInterface.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public CheckAuthLoginAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(QBaseActivity qBaseActivity) {
        Intent intent = qBaseActivity.getIntent();
        String stringExtra = intent.getStringExtra("StrTitle");
        String stringExtra2 = intent.getStringExtra("StrUpgradeDesc");
        String stringExtra3 = intent.getStringExtra("StrButton");
        String stringExtra4 = intent.getStringExtra("StrClientUrl");
        String stringExtra5 = intent.getStringExtra("StrH5Url");
        String stringExtra6 = intent.getStringExtra("StrCode");
        QQCustomDialog message = DialogUtil.createCustomDialog(qBaseActivity, 230).setTitle(stringExtra).setMessage(stringExtra2);
        message.setPositiveButton(stringExtra3, new DialogInterface.OnClickListener(qBaseActivity, stringExtra4, stringExtra5, stringExtra6) { // from class: com.tencent.mobileqq.loginregister.CheckAuthLoginAction.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QBaseActivity f242786d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f242787e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f242788f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f242789h;

            {
                this.f242786d = qBaseActivity;
                this.f242787e = stringExtra4;
                this.f242788f = stringExtra5;
                this.f242789h = stringExtra6;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, CheckAuthLoginAction.this, qBaseActivity, stringExtra4, stringExtra5, stringExtra6);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    ReportController.r(this.f242786d.getAppRuntime(), "dc00898", "", "", "0X8006796", "0X8006796", 0, 0, "", "", "", "");
                    ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.loginregister.CheckAuthLoginAction.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            boolean z16 = false;
                            if (com.tencent.mobileqq.cooperation.a.b(BaseApplication.getContext(), SDKConst.SELF_PACKAGENAME) > 0) {
                                Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                                intent2.setData(Uri.parse(AnonymousClass1.this.f242787e));
                                try {
                                    AnonymousClass1.this.f242786d.startActivity(intent2);
                                    z16 = true;
                                    ReportController.r(AnonymousClass1.this.f242786d.getAppRuntime(), "dc00898", "", "", "0X8006798", "0X8006798", 0, 0, "", "", "", "");
                                } catch (Exception unused) {
                                }
                            }
                            if (!z16) {
                                ReportController.r(AnonymousClass1.this.f242786d.getAppRuntime(), "dc00898", "", "", "0X8006799", "0X8006799", 0, 0, "", "", "", "");
                                Intent intent3 = new Intent(AnonymousClass1.this.f242786d, (Class<?>) OpenWriteCodeQQBrowserActivity.class);
                                intent3.putExtra("url", AnonymousClass1.this.f242788f);
                                DownloadApi.n(new com.tencent.mobileqq.upgrade.a(AnonymousClass1.this.f242789h, null));
                                AnonymousClass1.this.f242786d.startActivity(intent3);
                            }
                        }
                    }, null, false);
                }
            }
        });
        message.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), new a(qBaseActivity));
        message.show();
        ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8006795", "0X8006795", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.loginregister.f, com.tencent.mobileqq.loginregister.s
    public void j(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        if (bundle == null) {
            QLog.e("CheckAuthLoginAction", 1, "onLoginActivityCreate, bundle is null");
        } else if (bundle.getBoolean("reason_for_checkAuth", false) && (activity instanceof QBaseActivity)) {
            a((QBaseActivity) activity);
        }
    }
}
