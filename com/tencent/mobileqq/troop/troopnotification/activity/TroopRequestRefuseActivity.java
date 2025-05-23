package com.tencent.mobileqq.troop.troopnotification.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.inputview.QUIMultiLineInputView;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.widget.navbar.a;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.notification.ITroopNotificationInnerService;
import com.tencent.qqnt.notification.f;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopRequestRefuseActivity extends QIphoneTitleBarActivity implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected CheckBox f300639a0;

    /* renamed from: b0, reason: collision with root package name */
    protected QUIMultiLineInputView f300640b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f300641c0;

    /* renamed from: d0, reason: collision with root package name */
    private f f300642d0;

    public TroopRequestRefuseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f300639a0 = null;
        this.f300640b0 = null;
        this.f300641c0 = "";
    }

    private String G2() {
        QUIMultiLineInputView qUIMultiLineInputView = this.f300640b0;
        if (qUIMultiLineInputView != null && qUIMultiLineInputView.d() != null) {
            return this.f300640b0.d().toString();
        }
        return "";
    }

    public static void J2(Activity activity, int i3, f fVar) {
        Intent intent = new Intent(activity, (Class<?>) TroopRequestRefuseActivity.class);
        intent.putExtra("key_category", fVar.c());
        intent.putExtra("key_seq", fVar.j().seq);
        activity.startActivityForResult(intent, i3);
    }

    private void initTitleBar() {
        View findViewById = findViewById(R.id.rlCommenTitle);
        if (findViewById instanceof NavBarCommon) {
            NavBarCommon navBarCommon = (NavBarCommon) findViewById;
            navBarCommon.setTitle(getString(R.string.ew6));
            navBarCommon.setLeftButton(R.string.cancel);
            navBarCommon.setRightButton(R.string.hen);
            navBarCommon.setOnItemSelectListener(this);
        }
    }

    protected String H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("share_troop_request_refuse", 0);
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(g.d(this.mRuntime.getCurrentAccountUin()), "");
    }

    protected void I2(String str) {
        SharedPreferences.Editor edit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("share_troop_request_refuse", 0);
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.putString(g.d(this.mRuntime.getCurrentAccountUin()), str);
            edit.commit();
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
        super.setContentView(R.layout.c27);
        initTitleBar();
        this.f300640b0 = (QUIMultiLineInputView) findViewById(R.id.f165113bz3);
        this.f300639a0 = (CheckBox) findViewById(R.id.awv);
        String H2 = H2();
        if (!TextUtils.isEmpty(H2)) {
            this.f300640b0.setContentText(H2);
            this.f300640b0.setTextSelection(H2.length());
        }
        long longExtra = getIntent().getLongExtra("key_seq", 0L);
        int intExtra = getIntent().getIntExtra("key_category", 0);
        if (longExtra == 0) {
            QLog.e("IphoneTitleBarActivity", 1, "doOnCreate: error seq, seq=0, category=" + intExtra);
        } else {
            ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
            if (iTroopNotificationInnerService != null) {
                this.f300642d0 = iTroopNotificationInnerService.getNotificationMsgFromCache(intExtra, longExtra);
            }
        }
        f fVar = this.f300642d0;
        if (fVar != null) {
            this.f300641c0 = String.valueOf(fVar.j().getGroup().groupCode);
        }
        ReportController.o(this.mRuntime, "P_CliOper", "Grp_sysmsg", "", "Grp_ask", "exp_reject", 0, 0, this.f300641c0, "", "", "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        String G2 = G2();
        if (!TextUtils.isEmpty(G2)) {
            I2(G2);
        }
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.widget.navbar.a
    public void onItemSelect(View view, int i3) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, i3);
            return;
        }
        if (i3 == 2) {
            if (!NetworkUtil.isNetSupport(this)) {
                QQToast.makeText(this, getString(R.string.f235087ap), 0).show(getTitleBarHeight());
                return;
            }
            String G2 = G2();
            boolean isChecked = this.f300639a0.isChecked();
            Intent intent = new Intent();
            intent.putExtra("key_refuse_reason", G2);
            intent.putExtra("key_set_black_list", isChecked);
            setResult(-1, intent);
            finish();
            AppRuntime appRuntime = this.mRuntime;
            String str3 = this.f300641c0;
            if (TextUtils.isEmpty(G2)) {
                str = "0";
            } else {
                str = "1";
            }
            if (isChecked) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            ReportController.o(appRuntime, "P_CliOper", "Grp_sysmsg", "", "Grp_ask", "Clk_send_reject", 0, 0, str3, str, str2, "");
            return;
        }
        if (i3 == 8) {
            finish();
        }
    }
}
