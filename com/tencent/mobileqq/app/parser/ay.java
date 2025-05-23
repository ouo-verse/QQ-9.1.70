package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ark.Constants;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ay extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements ArkAppMgr.IGetAppPathByNameCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQProgressDialog f196457a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f196458b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f196459c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f196460d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f196461e;

        a(QQProgressDialog qQProgressDialog, String str, String str2, String str3, String str4) {
            this.f196457a = qQProgressDialog;
            this.f196458b = str;
            this.f196459c = str2;
            this.f196460d = str3;
            this.f196461e = str4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ay.this, qQProgressDialog, str, str2, str3, str4);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
        @Override // com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onGetAppPathByName(int i3, String str, ArkAppMgr.AppPathInfo appPathInfo) {
            String str2;
            boolean z16;
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, appPathInfo);
                return;
            }
            QQProgressDialog qQProgressDialog = this.f196457a;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.f196457a.dismiss();
            }
            if (appPathInfo != null && i3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("LightAppOpenAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen get path succeed, appPath: ", appPathInfo.path);
                }
                String str4 = this.f196458b;
                String str5 = null;
                if (TextUtils.isEmpty(str4)) {
                    String applicationLauncher = ArkAppCacheMgr.getApplicationLauncher(appPathInfo.path);
                    if (!TextUtils.isEmpty(applicationLauncher) && (applicationLauncher.startsWith("http://") || applicationLauncher.startsWith("https://"))) {
                        str5 = applicationLauncher;
                        str2 = str4;
                        z16 = false;
                        str3 = this.f196459c;
                        if (TextUtils.isEmpty(str3)) {
                            str3 = "{}";
                        }
                        String str6 = str3;
                        if (!z16) {
                            com.tencent.mobileqq.ark.g.b(null, this.f196460d, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
                            Context context = ay.this.f307437b;
                            if (context != null) {
                                ArkFullScreenAppActivity.W2(context, this.f196460d, str2, this.f196461e, Constants.DEFAULT_MIN_APP_VERSION, str6, com.tencent.mobileqq.ark.f.c(), null, 1);
                                return;
                            }
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
                        intent.putExtra("param_force_internal_browser", true);
                        intent.putExtra("url", str5);
                        intent.putExtra("injectrecommend", false);
                        intent.putExtra("browserType", 3);
                        if (!TextUtils.isEmpty(this.f196460d)) {
                            intent.putExtra(AppConstants.Key.H5_ARK_APP_NAME, this.f196460d);
                            String appPathFromLocal = ArkAppMgr.getInstance().getAppPathFromLocal(this.f196460d, this.f196461e);
                            if (!TextUtils.isEmpty(appPathFromLocal)) {
                                intent.putExtra(AppConstants.Key.H5_ARK_APP_PATH, appPathFromLocal);
                                String applicationDesc = ArkAppCacheMgr.getApplicationDesc(this.f196460d);
                                if (!TextUtils.isEmpty(applicationDesc)) {
                                    intent.putExtra(AppConstants.Key.H5_ARK_APP_DESCRIPTION, applicationDesc);
                                }
                            }
                        }
                        d91.b arkAIKeyWordConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkAIKeyWordConfig();
                        if (arkAIKeyWordConfig != null) {
                            String b16 = arkAIKeyWordConfig.b();
                            if (!TextUtils.isEmpty(b16)) {
                                intent.putExtra(AppConstants.Key.H5_ARK_CHECK_CONFIG, b16);
                            }
                        }
                        intent.addFlags(603979776);
                        Context context2 = ay.this.f307437b;
                        if (context2 != null) {
                            context2.startActivity(intent);
                            return;
                        }
                        return;
                    }
                    str2 = applicationLauncher;
                } else {
                    str2 = str4;
                }
                z16 = true;
                str3 = this.f196459c;
                if (TextUtils.isEmpty(str3)) {
                }
                String str62 = str3;
                if (!z16) {
                }
            } else {
                QQToast.makeText(ay.this.f307437b, R.string.f170433qp, 0).show();
                if (QLog.isColorLevel()) {
                    QLog.d("LightAppOpenAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen appPath is null ");
                }
            }
        }
    }

    public ay(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        String str;
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f307437b, 0, R.layout.f167664dn, 17);
        qQProgressDialog.setMessage(this.f307437b.getString(R.string.f170468s3));
        qQProgressDialog.getWindow().setDimAmount(0.0f);
        qQProgressDialog.show();
        qQProgressDialog.setCanceledOnTouchOutside(true);
        String str2 = this.f307441f.get("app");
        if (TextUtils.isEmpty(str2) && QLog.isColorLevel()) {
            QLog.e("LightAppOpenAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen jumpAction. appName=null");
        }
        String str3 = this.f307441f.get(PublicAccountMessageUtilImpl.META_NAME);
        String str4 = this.f307441f.get("view");
        if (this.f307441f.containsKey(QQCustomArkDialogUtil.BIZ_SRC)) {
            str = this.f307441f.get(QQCustomArkDialogUtil.BIZ_SRC);
        } else {
            str = "";
        }
        String str5 = str;
        ArkAppMgr.getInstance().getAppPathByName(str2, Constants.DEFAULT_MIN_APP_VERSION, str5, new a(qQProgressDialog, str4, str3, str2, str5));
        return true;
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
            QLog.e("LightAppOpenAction", 1, "doAction error: " + e16.getMessage());
            i("LightAppOpenAction");
            return false;
        }
    }
}
