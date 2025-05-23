package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.ServerConfigManager;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SpaceLowNoticeActiviy extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private QQCustomDialog f177130a0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpaceLowNoticeActiviy.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QQAppInterface qQAppInterface = SpaceLowNoticeActiviy.this.app;
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007547", "0X8007547", 0, 0, qQAppInterface.getCurrentAccountUin(), "", "", "");
            SpaceLowNoticeActiviy.this.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpaceLowNoticeActiviy.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QQSettingCleanActivity.K2(SpaceLowNoticeActiviy.this);
            QQAppInterface qQAppInterface = SpaceLowNoticeActiviy.this.app;
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007546", "0X8007546", 0, 0, qQAppInterface.getCurrentAccountUin(), "", "", "");
            SpaceLowNoticeActiviy.this.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpaceLowNoticeActiviy.this);
            }
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, dialogInterface, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 4) {
                SpaceLowNoticeActiviy.this.finish();
            }
            return false;
        }
    }

    public SpaceLowNoticeActiviy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f177130a0 = null;
        }
    }

    public static long F2(QQAppInterface qQAppInterface, String str, long j3) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            try {
                long parseLong = Long.parseLong(qQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.common, str));
                if (parseLong > 0) {
                    return parseLong;
                }
            } catch (Throwable unused) {
            }
        }
        return j3;
    }

    public static boolean G2(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication());
        long j16 = defaultSharedPreferences.getLong("lastCheckTime", 0L);
        if (j16 > 0 && currentTimeMillis - j16 <= j3) {
            return false;
        }
        defaultSharedPreferences.edit().putLong("lastCheckTime", currentTimeMillis).commit();
        return true;
    }

    public static void H2(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, SpaceLowNoticeActiviy.class);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        super.setContentView(R.layout.notification_activity_transparent);
        QQCustomDialog qQCustomDialog = this.f177130a0;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f177130a0.dismiss();
        }
        this.f177130a0 = null;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        this.f177130a0 = createCustomDialog;
        createCustomDialog.setContentView(R.layout.custom_dialog);
        this.f177130a0.setTitle(getString(R.string.f171495fi2)).setMessage(getString(R.string.f171496fi3)).setPositiveButton(R.string.fs7, new b()).setNegativeButton(R.string.cancel, new a());
        this.f177130a0.setOnKeyListener(new c());
        this.f177130a0.show();
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.f177130a0;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f177130a0.dismiss();
        }
        this.f177130a0 = null;
        super.finish();
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
