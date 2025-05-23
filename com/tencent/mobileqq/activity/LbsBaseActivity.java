package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LbsBaseActivity extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_ = null;
    protected static final int REQUEST_GPS = 10;
    private Dialog cleDialog;
    private Dialog entDialog;
    private Dialog gpsDialog;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LbsBaseActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (LbsBaseActivity.this.gpsDialog != null && LbsBaseActivity.this.gpsDialog.isShowing()) {
                    LbsBaseActivity lbsBaseActivity = LbsBaseActivity.this;
                    lbsBaseActivity.dialogDismiss(lbsBaseActivity.gpsDialog);
                }
                LbsBaseActivity.this.onDisableClick();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LbsBaseActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                LbsBaseActivity.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 10);
                LbsBaseActivity.this.onEnableClick();
                if (LbsBaseActivity.this.gpsDialog != null && LbsBaseActivity.this.gpsDialog.isShowing()) {
                    LbsBaseActivity lbsBaseActivity = LbsBaseActivity.this;
                    lbsBaseActivity.dialogDismiss(lbsBaseActivity.gpsDialog);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f176367d;

        c(Runnable runnable) {
            this.f176367d = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LbsBaseActivity.this, (Object) runnable);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                this.f176367d.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f176369d;

        d(Runnable runnable) {
            this.f176369d = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LbsBaseActivity.this, (Object) runnable);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else if (LbsBaseActivity.this.isLbsEnabled()) {
                LbsBaseActivity.this.checkGPSAndTelecom(this.f176369d);
            } else {
                LbsBaseActivity.this.onLBSForbidden();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LbsBaseActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (LbsBaseActivity.this.entDialog != null && LbsBaseActivity.this.entDialog.isShowing()) {
                LbsBaseActivity lbsBaseActivity = LbsBaseActivity.this;
                lbsBaseActivity.dialogDismiss(lbsBaseActivity.entDialog);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LbsBaseActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setObtainLocAllowed(LbsBaseActivity.this.getAppInterface().getAccount(), true);
                if (LbsBaseActivity.this.entDialog != null && LbsBaseActivity.this.entDialog.isShowing()) {
                    LbsBaseActivity lbsBaseActivity = LbsBaseActivity.this;
                    lbsBaseActivity.dialogDismiss(lbsBaseActivity.entDialog);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public LbsBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void checkGPS(Runnable runnable) {
        if (!checkGPS()) {
            showGpsDialog(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkGPSAndTelecom(Runnable runnable) {
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLbsEnabled() {
        return ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).isObtainLocAllowed(getAppInterface().getAccount());
    }

    private void showEnableLbsDialog(Runnable runnable) {
        d dVar = new d(runnable);
        Dialog a16 = com.tencent.mobileqq.util.t.a(this, R.string.ay7, getContentTipsForEnableLbs(), R.string.auh, R.string.aue, new e(), new f());
        this.entDialog = a16;
        a16.setOnDismissListener(dVar);
        this.entDialog.show();
    }

    private void showGpsDialog(Runnable runnable) {
        if (this.gpsDialog == null) {
            Dialog a16 = com.tencent.mobileqq.util.t.a(this, android.R.string.dialog_alert_title, R.string.blp, R.string.h0_, R.string.aue, new a(), new b());
            this.gpsDialog = a16;
            a16.setOnDismissListener(new c(runnable));
        }
        notifyShowLbsEnableDlg();
        this.gpsDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkAndEnableLbs(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
        } else if (isLbsEnabled()) {
            checkGPSAndTelecom(runnable);
        } else {
            showEnableLbsDialog(runnable);
        }
    }

    protected void checkLbs(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable);
        } else if (isLbsEnabled()) {
            checkGPSAndTelecom(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkLbsOnlySystemSwitch(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
        } else {
            checkGPSAndTelecom(runnable);
        }
    }

    public void dialogDismiss(Dialog dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) dialog);
            return;
        }
        try {
            dialog.dismiss();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            sy3.a.a(dialog);
            throw th5;
        }
        sy3.a.a(dialog);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Dialog dialog = this.gpsDialog;
        if (dialog != null && dialog.isShowing()) {
            dialogDismiss(this.gpsDialog);
        }
        Dialog dialog2 = this.entDialog;
        if (dialog2 != null && dialog2.isShowing()) {
            dialogDismiss(this.entDialog);
        }
        Dialog dialog3 = this.cleDialog;
        if (dialog3 != null && dialog3.isShowing()) {
            this.cleDialog.dismiss();
        }
        super.doOnDestroy();
    }

    protected int getContentTipsForEnableLbs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return R.string.f170891ay2;
    }

    protected void notifyShowLbsEnableDlg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    protected void onDisableClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    protected void onEnableClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    protected void onLBSForbidden() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            finish();
        }
    }

    protected void showToast(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (isResume()) {
            QQToast.makeText(this, i3, getResources().getString(i16), 0).show(getTitleBarHeight());
        }
    }

    private boolean checkGPS() {
        boolean z16;
        try {
            z16 = ((LocationManager) getAppInterface().getApp().getSystemService("location")).isProviderEnabled("gps");
        } catch (Throwable unused) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(Global.TRACKING_LOCATION, 2, "GPS Open " + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) str);
        } else if (isResume()) {
            QQToast.makeText(this, i3, str, 0).show(getTitleBarHeight());
        }
    }
}
