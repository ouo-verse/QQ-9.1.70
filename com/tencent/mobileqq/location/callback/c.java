package com.tencent.mobileqq.location.callback;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingLocationWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static long f241241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements gh2.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        boolean f241242a;

        /* renamed from: b, reason: collision with root package name */
        Dialog f241243b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f241244c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LocationRoom.b f241245d;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.location.callback.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class DialogInterfaceOnDismissListenerC7970a implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnDismissListenerC7970a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                } else {
                    a.this.f241242a = false;
                }
            }
        }

        a(QQAppInterface qQAppInterface, LocationRoom.b bVar) {
            this.f241244c = qQAppInterface;
            this.f241245d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, qQAppInterface, bVar);
            } else {
                this.f241242a = false;
            }
        }

        @Override // gh2.d
        public boolean onCloseClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            IFloatMapService a16 = com.tencent.mobileqq.location.e.a(this.f241244c);
            QQAppInterface qQAppInterface = this.f241244c;
            if (!qQAppInterface.isBackgroundPause && !qQAppInterface.isBackgroundStop) {
                if (!this.f241242a) {
                    Dialog createFloatExitConfirmDialog = a16.createFloatExitConfirmDialog(this.f241245d.b(), this.f241245d.c());
                    this.f241243b = createFloatExitConfirmDialog;
                    this.f241242a = true;
                    if (createFloatExitConfirmDialog != null) {
                        createFloatExitConfirmDialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC7970a());
                    }
                }
            } else {
                a16.showFloatTypeDialog(this.f241245d);
            }
            ReportController.o(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
            return true;
        }

        @Override // gh2.d
        public boolean onEnterClick(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("FloatMapCallback", 2, "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(i3), " centerY: ", Integer.valueOf(i16));
            }
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null) {
                com.tencent.mobileqq.location.e.b(this.f241244c).launchShareUi(qBaseActivity, this.f241245d.b(), this.f241245d.c(), 4);
            }
            c.f();
            Dialog dialog = this.f241243b;
            if (dialog != null) {
                try {
                    dialog.dismiss();
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f241248d;

        b(QBaseActivity qBaseActivity) {
            this.f241248d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                com.tencent.mobileqq.qqfloatingwindow.b.b();
                ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(this.f241248d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72773);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f241241a = 0L;
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean c(QBaseActivity qBaseActivity, LocationRoom.b bVar, View view) {
        e();
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        FloatingScreenParams build = new FloatingScreenParams.FloatingBuilder().setShapeType(3).setCanMove(true).setCanZoom(false).setFloatingCenter(300, -680).build();
        IQQFloatingWindow iQQFloatingWindow = (IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class);
        BaseApplication context = BaseApplication.getContext();
        String str = FloatingLocationWrapper.CLASS_NAME;
        int enterLocationFloatingScreen = iQQFloatingWindow.enterLocationFloatingScreen(context, view, build, str);
        if (QLog.isColorLevel()) {
            QLog.d("FloatMapCallback", 2, "createFloatWindow: invoked. ", " result: ", Integer.valueOf(enterLocationFloatingScreen));
        }
        if (enterLocationFloatingScreen == 1) {
            d(qBaseActivity);
            return false;
        }
        iQQFloatingWindow.setWindowClickListener(str, new a(qQAppInterface, bVar));
        return true;
    }

    public static void d(QBaseActivity qBaseActivity) {
        if (qBaseActivity == null) {
            return;
        }
        com.tencent.mobileqq.qqfloatingwindow.b.c();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, "\u4f4d\u7f6e\u5171\u4eab\u5c06\u6536\u8d77\u4e3a\u5c0f\u7a97\u8fdb\u884c\u5c55\u793a\uff0c\u8bf7\u5f00\u542fQQ\u60ac\u6d6e\u7a97\u6743\u9650\u4ee5\u6b63\u5e38\u4f7f\u7528\u529f\u80fd\u3002", qBaseActivity.getString(R.string.cancel), qBaseActivity.getString(R.string.f171151ok), new b(qBaseActivity), (DialogInterface.OnClickListener) null);
        createCustomDialog.setCancelable(false);
        try {
            createCustomDialog.show();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void e() {
        f241241a = System.currentTimeMillis();
    }

    public static void f() {
        long currentTimeMillis = (System.currentTimeMillis() - f241241a) / 1000;
        if (QLog.isColorLevel()) {
            QLog.d("FloatMapCallback", 2, "reportFloatWindowLastExposeDuration: invoked. ", " second: ", Long.valueOf(currentTimeMillis));
        }
        ReportController.o(null, "CliOper", "", "", "0X800A976", "0X800A976", 0, 0, String.valueOf(currentTimeMillis), "0", "0", "");
    }

    @Override // com.tencent.mobileqq.location.callback.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(FloatingLocationWrapper.CLASS_NAME);
        }
    }

    @Override // com.tencent.mobileqq.location.callback.d
    public boolean b(QBaseActivity qBaseActivity, LocationRoom.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) bVar)).booleanValue();
        }
        return c(qBaseActivity, bVar, com.tencent.mobileqq.location.e.a(MobileQQ.sMobileQQ.waitAppRuntime(null)).getFloatMapView());
    }

    @Override // com.tencent.mobileqq.location.callback.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setWindowClickListener(FloatingLocationWrapper.CLASS_NAME, null);
        }
    }
}
