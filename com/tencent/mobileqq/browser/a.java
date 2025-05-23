package com.tencent.mobileqq.browser;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListAdapter;
import com.tencent.biz.qrcode.util.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.p;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.pm.PackageUtil;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final d f200531d;

    /* renamed from: e, reason: collision with root package name */
    private final Activity f200532e;

    /* renamed from: f, reason: collision with root package name */
    private final String f200533f;

    /* renamed from: h, reason: collision with root package name */
    private final e f200534h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.browser.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class DialogInterfaceOnClickListenerC7438a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.browser.b f200535d;

        DialogInterfaceOnClickListenerC7438a(com.tencent.mobileqq.browser.b bVar) {
            this.f200535d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) bVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                c.a(BaseApplication.context, this.f200535d.b(), a.this.f200533f);
                bv.a("0X800ADEF");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    a(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) str);
            return;
        }
        this.f200532e = activity;
        e eVar = new e(activity);
        this.f200534h = eVar;
        eVar.m(c.c(activity, com.tencent.mobileqq.config.business.e.b()));
        this.f200533f = str;
        this.f200531d = d.c(activity, -1, -1);
        b();
    }

    private void b() {
        Button d16 = this.f200531d.d();
        if (d16 != null) {
            d16.setOnClickListener(this);
        }
        Button f16 = this.f200531d.f();
        if (f16 != null) {
            f16.setOnClickListener(this);
        }
    }

    private static int d(com.tencent.mobileqq.browser.b bVar) {
        if (bVar.f()) {
            return 2;
        }
        return 1;
    }

    public static String e(String str) {
        String str2 = (String) p.b(BaseApplication.context, str, AppConstants.Preferences.KEY_SELECTED_BROWSER_NAME, "");
        if (QLog.isColorLevel()) {
            QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, "[sp] getSpSelectedBrowserPackage: invoked. ", " pkg: ", str2);
        }
        return str2;
    }

    public static void f(Activity activity, String str, String str2) {
        String e16 = e(str2);
        if (!TextUtils.isEmpty(e16) && !PackageUtil.isPackageInstalled(BaseApplication.context, e16)) {
            j(c.b(), "");
            e16 = "";
        }
        if (TextUtils.isEmpty(e16)) {
            new a(activity, str).l();
        } else {
            c.d(activity, str, e16);
        }
    }

    private void g() {
        h();
        com.tencent.mobileqq.browser.b n3 = this.f200534h.n();
        if (n3 != null) {
            j(c.b(), n3.d());
            bv.d("0X800ADED", d(n3), "", n3.c());
        }
    }

    private void h() {
        c();
        com.tencent.mobileqq.browser.b n3 = this.f200534h.n();
        if (n3 == null) {
            return;
        }
        if (n3.f()) {
            c.d(this.f200532e, this.f200533f, n3.d());
        } else if (PackageUtil.isPackageInstalled(BaseApplication.context, n3.d())) {
            c.d(this.f200532e, this.f200533f, n3.d());
        } else {
            k(n3);
        }
        QLog.d("[BrowserOpt] BrowserDialogViewModel", 1, "[action] onAnyButtonClicked: invoked. ", " browser: ", n3);
    }

    private void i() {
        h();
        com.tencent.mobileqq.browser.b n3 = this.f200534h.n();
        if (n3 != null) {
            bv.d("0X800ADEC", d(n3), "", n3.c());
        }
    }

    private static void j(String str, String str2) {
        p.g(BaseApplication.context, str, true, AppConstants.Preferences.KEY_SELECTED_BROWSER_NAME, str2);
        if (QLog.isColorLevel()) {
            QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, "[sp] saveSpSelectedBrowserPackage: invoked. ", " pkg: ", str2);
        }
    }

    private void k(com.tencent.mobileqq.browser.b bVar) {
        Resources resources = BaseApplication.context.getResources();
        DialogUtil.createCustomDialog(this.f200532e, 230, null, String.format(resources.getString(R.string.zga), bVar.c()), new DialogInterfaceOnClickListenerC7438a(bVar), new b()).show();
        if (QLog.isColorLevel()) {
            QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, "[dialog] showDownloadBrowserConfirmDialog: invoked. ", " browser: ", bVar);
        }
        bv.a("0X800ADEE");
    }

    private void l() {
        if (this.f200534h.getCount() <= 0) {
            h.T(1, R.string.d6f);
            if (QLog.isColorLevel()) {
                QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, "[error] showPopupWindow: invoked. [\u6ca1\u6709\u4efb\u4f55\u6d4f\u89c8\u5668\u65f6\uff0c\u5bf9\u9f50\u65e7\u7684\u9519\u8beftoast]");
                return;
            }
            return;
        }
        XListView e16 = this.f200531d.e();
        if (e16 != null) {
            e16.setAdapter((ListAdapter) this.f200534h);
        }
        Window window = this.f200532e.getWindow();
        if (window != null) {
            window.setDimAmount(0.5f);
            this.f200531d.showAtLocation(window.getDecorView(), 80, 0, 0);
        }
        bv.a("0X800ADEA");
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f200531d.isShowing()) {
            try {
                this.f200531d.dismiss();
            } catch (Exception e16) {
                QLog.e("[BrowserOpt] BrowserDialogViewModel", 1, "dismissPopupWindow: failed. ", e16);
            }
        }
        e eVar = this.f200534h;
        if (eVar != null) {
            eVar.l();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (view.getId() == R.id.smv) {
            g();
        } else if (view.getId() == R.id.zwo) {
            i();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
