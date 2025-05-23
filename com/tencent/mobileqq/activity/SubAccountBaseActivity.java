package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SubAccountBaseActivity extends QIphoneTitleBarActivity implements DialogInterface.OnClickListener {
    static IPatchRedirector $redirector_;
    protected String fromWhere;
    private QQCustomDialog mDialog;
    private QQProgressDialog mJuhua;

    public SubAccountBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void dimissDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.mDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            try {
                this.mDialog.dismiss();
            } catch (Exception unused) {
            }
            this.mDialog = null;
        }
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.fromWhere = getIntent().getStringExtra("fromWhere");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnDestroy();
        ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISubAccountControlService.class, "");
        if (iSubAccountControlService != null) {
            iSubAccountControlService.destoryHintDialog(this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        hideJuhua();
        dimissDialog();
        super.finish();
    }

    public void hideJuhua() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.mJuhua;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.mJuhua.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public boolean isNetConn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return NetworkUtil.isNetSupport(BaseApplication.getContext());
    }

    public boolean isNetConnToast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        boolean isNetConn = isNetConn();
        if (!isNetConn) {
            showQQToast(getString(R.string.b3j));
        }
        return isNetConn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onAccountChanged();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) dialogInterface, i3);
        } else {
            if (i3 != 0) {
                if (i3 == 1) {
                    dialogInterface.dismiss();
                    return;
                }
                return;
            }
            onDialogCancel();
        }
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    protected void onDialogCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    public void showJuhua(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        if (this.mJuhua == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
            this.mJuhua = qQProgressDialog;
            qQProgressDialog.setBackAndSearchFilter(true);
        }
        if (i3 > 0) {
            this.mJuhua.setMessage(i3);
        } else {
            this.mJuhua.setMessage(R.string.cpr);
        }
        QQProgressDialog qQProgressDialog2 = this.mJuhua;
        if (qQProgressDialog2 != null && !qQProgressDialog2.isShowing() && !isFinishing()) {
            this.mJuhua.show();
        }
    }

    public void showQQCustomDialog(String str, String str2, DialogInterface.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, onClickListener);
            return;
        }
        if (onClickListener == null) {
            onClickListener = this;
        }
        dimissDialog();
        QQCustomDialog message = DialogUtil.createCustomDialog(this, 230).setTitle(str).setMessage(str2);
        this.mDialog = message;
        message.setPositiveButton(R.string.a8j, onClickListener);
        this.mDialog.setNegativeButton(R.string.cancel, onClickListener);
        this.mDialog.setCancelable(false);
        this.mDialog.show();
    }

    public void showQQCustomDialogOneBtn(String str, String str2, DialogInterface.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, onClickListener);
            return;
        }
        if (onClickListener == null) {
            onClickListener = this;
        }
        dimissDialog();
        QQCustomDialog message = DialogUtil.createCustomDialog(this, 230).setTitle(str).setMessage(str2);
        this.mDialog = message;
        message.setPositiveButton(R.string.a8j, onClickListener);
        this.mDialog.setCancelable(false);
        this.mDialog.show();
    }

    public void showQQToast(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            QQToast.makeText(this, str, 0).show(getTitleBarHeight());
        }
    }

    public void showQQToastSuccess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            QQToast.makeText(this, 2, str, 0).show(getTitleBarHeight());
        }
    }
}
