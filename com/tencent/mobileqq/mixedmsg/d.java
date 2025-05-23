package com.tencent.mobileqq.mixedmsg;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.mixedmsg.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqalbum.IPicToJpg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.util.UiThreadUtil;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a implements MixedMsgManager.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Context> f247209a;

        /* renamed from: b, reason: collision with root package name */
        private ProgressDialog f247210b;

        protected a(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            } else {
                this.f247209a = new WeakReference<>(context);
            }
        }

        private void e() {
            ProgressDialog progressDialog = this.f247210b;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f247210b.cancel();
            }
        }

        private void g(Context context) {
            try {
                if (this.f247210b != null) {
                    e();
                } else {
                    ReportProgressDialog reportProgressDialog = new ReportProgressDialog(context, R.style.qZoneInputDialog);
                    this.f247210b = reportProgressDialog;
                    reportProgressDialog.setCancelable(true);
                    this.f247210b.show();
                    this.f247210b.setContentView(R.layout.f168383uh);
                    ((TextView) this.f247210b.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(R.string.cuv);
                }
                if (!this.f247210b.isShowing()) {
                    this.f247210b.show();
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.i("CommonSendActionCallback", 1, "showProgressDialog error!", th5);
                }
            }
        }

        @Override // com.tencent.mobileqq.mixedmsg.MixedMsgManager.e
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (UiThreadUtil.isOnUiThread()) {
                d();
            } else {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mixedmsg.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.a.this.d();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.mixedmsg.MixedMsgManager.e
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (UiThreadUtil.isOnUiThread()) {
                c();
            } else {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mixedmsg.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.a.this.c();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                f();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            Context context = this.f247209a.get();
            if (context == null) {
                return;
            }
            g(context);
        }

        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                e();
            }
        }
    }

    public static String a(String str) {
        if (FileUtils.isNeedTransPic(str)) {
            com.tencent.mobileqq.qqalbum.a aVar = new com.tencent.mobileqq.qqalbum.a();
            aVar.f262095a = str;
            String filePath = AbsDownloader.getFilePath(str);
            aVar.f262096b = filePath;
            if (FileUtils.fileExistsAndNotEmpty(filePath) || ((IPicToJpg) QRoute.api(IPicToJpg.class)).picToJpg(aVar)) {
                return aVar.f262096b;
            }
            return str;
        }
        return str;
    }

    public static a b(Context context) {
        return new a(context);
    }
}
