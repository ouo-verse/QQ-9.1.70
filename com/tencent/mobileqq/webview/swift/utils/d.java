package com.tencent.mobileqq.webview.swift.utils;

import android.content.Context;
import android.content.DialogInterface;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f314744a;

    /* renamed from: b, reason: collision with root package name */
    public static String f314745b;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f314746d;

        a(SslErrorHandler sslErrorHandler) {
            this.f314746d = sslErrorHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sslErrorHandler);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                d.b(dialogInterface, this.f314746d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f314747d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f314748e;

        b(SslErrorHandler sslErrorHandler, String str) {
            this.f314747d = sslErrorHandler;
            this.f314748e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sslErrorHandler, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                d.c(this.f314747d, dialogInterface, this.f314748e);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49399);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f314745b = "";
        }
    }

    public static QQCustomDialog a(String str, String str2, SslErrorHandler sslErrorHandler, Context context, String str3, boolean z16) {
        b bVar;
        a aVar = new a(sslErrorHandler);
        if (!z16) {
            bVar = null;
        } else {
            bVar = new b(sslErrorHandler, str3);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, str, str2, R.string.f170647xd, R.string.zgo, bVar, aVar);
        createCustomDialog.getBtnight().setTextColor(SupportMenu.CATEGORY_MASK);
        createCustomDialog.setMessageTextSize(17.0f);
        return createCustomDialog;
    }

    protected static void b(DialogInterface dialogInterface, SslErrorHandler sslErrorHandler) {
        sslErrorHandler.cancel();
        dialogInterface.dismiss();
        f314744a = false;
        if (QLog.isColorLevel()) {
            QLog.d("SslErrorDialogUtil", 2, "click cancel");
        }
    }

    protected static void c(SslErrorHandler sslErrorHandler, DialogInterface dialogInterface, String str) {
        sslErrorHandler.proceed();
        dialogInterface.dismiss();
        f314745b = str;
        if (QLog.isColorLevel()) {
            QLog.d("SslErrorDialogUtil", 2, "click confirm url = ", str);
        }
    }

    public static void d(SslErrorHandler sslErrorHandler, QQCustomDialog qQCustomDialog) {
        f314744a = true;
        if (qQCustomDialog != null && !qQCustomDialog.isShowing()) {
            if (QLog.isColorLevel()) {
                QLog.d("SslErrorDialogUtil", 2, "dialog has show");
            }
            qQCustomDialog.show();
            return;
        }
        sslErrorHandler.cancel();
    }
}
